#Keystone related configuration functions
keystone-conf_chefsolo_template() {
    file_name=$1
    if [ -e $file_name ]; then
        #keystone.conf related
        sed "s/^admin_token =.*$/admin_token=<%=node[:SERVICE_TOKEN]%> /" -i $file_name
        sed "s/$DB_USER:/<%=node[:DB_USER]%>:/g" -i $file_name
        sed "s/$DB_PASSWORD@/<%=node[:DB_PASSWORD]%>@/g" -i $file_name
        mv $file_name $file_name$SUFFIX
    fi
}

keystone-identity_chefsolo_template() {
    file_name=$1
    if [ -e $file_name ]; then
        #Identifyy related substitutions
        sed "s/^export OS_SERVICE_TOKEN.*$/export OS_SERVICE_TOKEN=<%=node[:SERVICE_TOKEN]%>/" \
        -i $file_name
        sed "s/$ADMIN_PASSWORD/<%=node[:ADMIN_PASSWORD]%>/" -i $file_name
        sed "s/$SERVICE_TENANT_NAME/<%=node[:SERVICE_TENANT_NAME]%>/" -i $file_name
        sed "s/^KEYSTONE_HOST.*$/KEYSTONE_HOST=<%=node[:CONTROLLER_IP]%> /" -i $file_name
        mv $file_name $file_name$SUFFIX
    fi
}
