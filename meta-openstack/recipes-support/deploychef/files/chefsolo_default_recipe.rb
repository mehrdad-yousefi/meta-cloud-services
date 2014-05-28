# default.rb
#
# Copyright (c) 2014 Wind River Systems, Inc.
#
# Permission is hereby granted, free of charge, to any person obtaining a copy
# of this software and associated documentation files (the "Software"), to deal
# in the Software without restriction, including without limitation the rights
# to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
# copies of the Software, and to permit persons to whom the Software is
# furnished to do so, subject to the following conditions:
#
# The above copyright notice and this permission notice shall be included in
# all copies or substantial portions of the Software.
#
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
# OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
# THE SOFTWARE.
#
# This is our main recipe that chef-solo bakes to configure our openstack deployment
domain = node['hostname']
domain += " " + node['platform']
domain += " " + node['platform_version']
domain += " " + node['ipaddress']
log domain  do
        level:info
end

#This function enables us to over-ride the hostname and ipaddress
#attributes based on the type of node installation
#we are running on.
def update_node_info()
    if  File.executable?(node[:CONTROLLER_DAEMON]) and \
        File.executable?(node[:COMPUTE_DAEMON])
        #All in one installation
        if node[:ipaddress].length
            node.default["CONTROLLER_IP"]=node.default["COMPUTE_IP"]=node[:ipaddress]
        end
        if node[:hostname].length
            node.default["CONTROLLER_HOST"]=node.default["COMPUTE_HOST"]=node[:hostname]
        end
        node.default["NODE_TYPE"] ="allinone"
    elsif File.executable?(node[:CONTROLLER_DAEMON])
        if node[:ipaddress].length
            node.default["CONTROLLER_IP"]=node[:ipaddress]
        end
        if node[:hostname].length
            node.default["CONTROLLER_HOST"]=node[:hostname]
        end
        node.default["NODE_TYPE"] ="controller"
    else
        if node[:ipaddress].length
            node.default["COMPUTE_IP"]=node[:ipaddress]
        end
        if node[:hostname].length
            node.default["COMPUTE_HOST"]=node[:hostname]
        end
        node.default["NODE_TYPE"] ="compute"
    end

    node.default["PUBLIC_IP"]="#{node[:CONTROLLER_IP]}"
    node.default["HOST_NAME"]="#{node[:CONTROLLER_HOST]}"
    node.default["PUBLIC_DOMAIN"]="#{node[:CONTROLLER_IP]}/24"
end
#This fucntion loops through all the files in the templates
#directory and create configuration or scripts files from the
#templates using the sets of defined attributes
def create_files_from_templates()
    #Make it easier to move from development environment to target
    output_dir = node[:POSTINSTS_DIR]
    template_dir = node[:TEMPLATE_DIR]
    #See if output directory exist if not create one
    if not File.directory?(output_dir)
        execute "Create #{output_dir} directory" do
            command "mkdir -p #{output_dir}"
        end
    end
    #Get the list of all template files
    files = Dir.glob(template_dir)
    #To ensure that the files are executed in increasing order
    files = files.sort
    for file in files  do
        #Exclude references to current and parent directory in search
        next if File.directory?(file) or file == '.' or file == '..'
        script_file = output_dir + File.basename(file)
        script_file.gsub!(".erb","")
        if File.file?(script_file)
            execute "Delete file #{script_file} if present" do
                command "rm -rf #{script_file}"
            end
        end
        template script_file do
            source File.basename(file)
            mode  0755
            owner node[:user]
            group node[:user]
        end
    end
end
#This function moves the generated configuration files for
#the respective modules to the specified module configuration directory
#Overwriting the current configuration file in the process
def replace_config_files(files, configDir, makeNoneExec=true)
    #!files.strip
    #!configDir.strip
    if files and configDir
        if not File.directory?(configDir)
            execute "Create #{configDir}" do
                command "mkdir -p #{configDir}"
            end
        end
        if files.strip.include?(" ")
            file_names = files.split
            file_names.each do |  fileName |
                fileName=fileName.strip
                if File.file?("#{node[:POSTINSTS_DIR]}#{fileName}")
                    execute "Move #{fileName} to #{configDir} " do
                        command "mv #{node[:POSTINSTS_DIR]}#{fileName} #{configDir}#{fileName}"
                    end
                    if makeNoneExec
                        execute "Remove execution mode on #{fileName}" do
                            command "chmod 0644 #{configDir}#{fileName}"
                        end
                    end
                end
            end
        else
        #There is only one file in the list
            files=files.strip
            if File.file?("#{node[:POSTINSTS_DIR]}#{files}")
                execute "Move #{files} to #{configDir} " do
                    command "mv #{node[:POSTINSTS_DIR]}#{files} #{configDir}#{files}"
                end
                if makeNoneExec
                    execute "Remove execution mode on #{files}" do
                        command "chmod 0644 #{configDir}#{files}"
                    end
                end
            end
        end
    end
end

#Update hostname and ipaddress to be written to configuration files
update_node_info

#Generate scripts and cofiguration files
create_files_from_templates

#Move the configuration files to /etc/nova directory
#and make remove execution modifier from the files
novaConfigFiles="nova.conf  openrc api-paste.ini deploy.conf"
replace_config_files(novaConfigFiles,"#{node[:NOVA_CONF_DIR]}")
#Move the configuration files to /etc/swift directory
#and remove execution modifier from the files
swiftConfigFiles="test.conf dispersion.conf proxy-server.conf"
if node[:NODE_TYPE] == "compute"
    files = swiftConfigFiles.split
    files.each do | fileName |
        fileName=fileName.strip
        fileName ="#{node[:POSTINSTS_DIR]}#{fileName}"
        if File.file?(fileName)
            execute "Remove file #{fileName}" do
                command "rm #{node[:POSTINSTS_DIR]}#{fileName}"
            end
        end
    end
else
    replace_config_files(swiftConfigFiles,"#{node[:SWIFT_CONF_DIR]}")
end
#Move the configuration files to /etc/neutron directory
#and remove execution modifier from the files
configFiles="neutron.conf"
replace_config_files(configFiles,"#{node[:NEUTRON_CONF_DIR]}")
configFiles="linuxbridge_conf.ini"
replace_config_files(configFiles,"#{node[:LINUXBRIDGE_CONF_DIR]}")
configFiles="ovs_neutron_plugin.ini"
replace_config_files(configFiles,"#{node[:OPENVSWITCH_CONF_DIR]}")

configFiles="ceilometer.conf"
replace_config_files(configFiles,"#{node[:CEILOMETER_CONF_DIR]}")

configFiles="glance-api.conf glance-cache.conf glance-registry.conf"
if node[:NODE_TYPE] == "compute"
    files = configFiles.split
    files.each do | fileName |
        if File.file?("#{node[:POSTINSTS_DIR]}#{fileName}")
            execute "Remove file #{fileName}" do
                command "rm #{node[:POSTINSTS_DIR]}#{fileName}"
            end
        end
    end
else
    replace_config_files(configFiles,"#{node[:GLANCE_CONF_DIR]}")
end

#Move the postgresql init script and make them executable
configFiles="postgresql-init"
replace_config_files(configFiles, "#{node[:INITD_DIR]}", false)

configFiles="ceph.conf"
replace_config_files(configFiles, "#{node[:CEPH_CONF_DIR]}")

configFiles="ceph-setup"
if node[:NODE_TYPE] == "compute"
    if File.file?("#{node[:POSTINSTS_DIR]}#{configFiles}")
        execute "Remove file #{configFiles}" do
            command "rm #{node[:POSTINSTS_DIR]}#{configFiles}"
        end
    end
else
    replace_config_files(configFiles, "#{node[:INITD_DIR]}", false)
end

configFiles="keystone.conf identity.sh"
if node[:NODE_TYPE] == "compute"
    files = configFiles.split
    files.each do | fileName |
        if File.file?("#{node[:POSTINSTS_DIR]}#{fileName}")
            execute "Remove file #{fileName}" do
                command "rm #{node[:POSTINSTS_DIR]}#{fileName}"
            end
        end
    end
else
    replace_config_files(configFiles, "#{node[:KEYSTONE_CONF_DIR]}")
    #Openrc in keystone conf dir is same as that found in nova
    execute "Copy openrc to #{node[:KEYSTONE_CONF_DIR]}" do
        command "cp #{node[:NOVA_CONF_DIR]}openrc #{node[:KEYSTONE_CONF_DIR]}"
    end
end
#cinder configurations
configFiles="api-paste.ini.cinder cinder.conf"
replace_config_files(configFiles, "#{node[:CINDER_CONF_DIR]}")

fileName="#{node[:CINDER_CONF_DIR]}api-paste.ini.cinder"
if File.file?(fileName)
    execute "Rename api-paste.ini.cinder to api-paste.ini" do
        command "mv #{node[:CINDER_CONF_DIR]}api-paste.ini.cinder #{node[:CINDER_CONF_DIR]}api-paste.ini"
    end
end
#heat configuration
configFiles="heat.conf"
if node[:NODE_TYPE] == "compute"
    if File.file?("#{node[:POSTINSTS_DIR]}#{configFiles}")
        execute "Remove file #{configFiles}" do
            command "rm #{node[:POSTINSTS_DIR]}#{configFiles}"
        end
    end
else
    replace_config_files(configFiles, "#{node[:HEAT_CONF_DIR]}")
end
#Move the hosts file in place
configFiles="hosts"
replace_config_files(configFiles,"#{node[:ETC_DIR]}")

=begin
service  host[:hostname] do
    action :restart
endf
=end
