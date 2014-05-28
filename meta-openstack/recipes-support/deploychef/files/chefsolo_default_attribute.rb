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
#
#These are the default values that chef-solo uses
#to convert our template files into the respective
#configuration and script files we want it to bake. 
#Note though that Some of which are overwritten in the recipe file(s)

default["CHEFROOT_DIR"]   ="%DEPLOYCHEF_ROOT_DIR%/"
default["TEMPLATE_DIR"] ="#{node[:CHEFROOT_DIR]}cookbooks/openstack/templates/default/*"
default["ETC_DIR"]= "%SYSCONFDIR%/"
default["POSTINSTS_DIR"]   ="#{node[:ETC_DIR]}%POSTINSTS_DIR%/"
default["NOVA_CONF_DIR"]="#{node[:ETC_DIR]}nova/"
default["SWIFT_CONF_DIR"]="#{node[:ETC_DIR]}swift/"
default["CEILOMETER_CONF_DIR"]="#{node[:ETC_DIR]}ceilometer/"
default["NEUTRON_CONF_DIR"]= "#{node[:ETC_DIR]}neutron/"
default["NEUTRON_CORE_PLUGIN"]= "neutron.plugins.openvswitch.ovs_neutron_plugin.OVSNeutronPluginV2"
default["OPENVSWITCH_CONF_DIR"]= "#{node[:NEUTRON_CONF_DIR]}plugins/openvswitch/"
default["LINUXBRIDGE_CONF_DIR"]= "#{node[:NEUTRON_CONF_DIR]}plugins/linuxbridge/"
default["KEYSTONE_CONF_DIR"]= "#{node[:ETC_DIR]}keystone/"
default["CINDER_CONF_DIR"]= "#{node[:ETC_DIR]}cinder/"
default["GLANCE_CONF_DIR"]= "#{node[:ETC_DIR]}glance/"
default["CEPH_CONF_DIR"]= "#{node[:ETC_DIR]}ceph/"
default["DB_DATADIR"]= "#{node[:ETC_DIR]}postgresql/"
default["HEAT_CONF_DIR"]= "#{node[:ETC_DIR]}heat/"

default["INITD_DIR"]= "#{node[:ETC_DIR]}init.d/"
default["CONTROLLER_DAEMON"]= "#{node[:INITD_DIR]}nova-api"
default["COMPUTE_DAEMON"]= "#{node[:INITD_DIR]}nova-compute"
default["NODE_TYPE"]="compute"
default["NODE_TYPES"]="compute controller allinone"
default["POSTINSTS_SCRIPT"] =   "run-postinsts"
default["PREINSTS_SCRIPT"] =   "service-shutdown"
default["AUTH_PROTOCOL"] =   "http"
default["PRIVATE_IP"]    = "127.0.0.1"

default["CONTROLLER_IP"]    = "%CONTROLLER_IP%"
default["CONTROLLER_HOST"]  =   "%CONTROLLER_HOST%"
default["COMPUTE_IP"]   =   "%COMPUTE_IP%"
default["COMPUTE_HOST"] =   "%COMPUTE_HOST%"
default["ADMIN_PASSWORD"]   =   "%ADMIN_PASSWORD%"
default["SERVICE_PASSWORD"] =   "%SERVICE_PASSWORD%"
default["SERVICE_TENANT_NAME"]  ="%SERVICE_TENANT_NAME%"
default["SERVICE_USER"]  ="%SERVICE_USER%"
default["SERVICE_TOKEN"]  ="%SERVICE_TOKEN%"
default["DEMO_USER"]  ="%DEMO_USER%"
default["DEMO_PASSWORD"]  ="%DEMO_PASSWORD%"
default["OS_TENANT_NAME"]   ="%OS_TENANT_NAME%"
default["OS_USERNAME"]  ="%OS_USERNAME%"
default["OS_PASSWORD"]  ="%OS_PASSWORD%"
default["DB_USER"]  ="%DB_USER%"
default["DB_PASSWORD"]  ="%DB_PASSWORD%"
default["PUBLIC_IP"]  ="#{node[:CONTROLLER_IP]}"
default["HOST_NAME"]="#{node[:CONTROLLER_HOSTS]}"
default["PUBLIC_DOMAIN"] ="#{node[:CONTROLLER_IP]}/24"


