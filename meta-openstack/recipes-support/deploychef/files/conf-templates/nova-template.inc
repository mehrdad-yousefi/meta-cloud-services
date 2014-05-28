#Nova chefsolo template generation functions
openrc_chefsolo_template() {
    file_name=$1
    if [ -e $file_name ]; then
        sed "s/^export OS_TENANT_NAME=.*$/export OS_TENANT_NAME=<%=node[:OS_TENANT_NAME]%> /" -i $file_name
        sed "s/^export OS_USERNAME=.*$/export OS_USERNAME=<%=node[:OS_USERNAME]%> /" -i $file_name
        sed "s/^export OS_PASSWORD=.*$/export OS_PASSWORD=<%=node[:OS_PASSWORD]%> /" -i $file_name
        sed "s/^export SERVICE_TOKEN=.*$/export SERVICE_TOKEN=<%=node[:SERVICE_TOKEN]%> /" -i $file_name
        sed "s/$CONTROLLER_HOST/<%=node[:CONTROLLER_HOST]%>/g" -i $file_name
        mv $file_name $file_name$SUFFIX
    fi
}

nova-conf_chefsolo_template() {
    file_name=$1
    if [ -e $file_name ]; then
        sed "s/$CONTROLLER_IP/<%=node[:CONTROLLER_IP]%>/g" -i $file_name
        sed "s/$CONTROLLER_HOST/<%=node[:CONTROLLER_HOST]%>/g" -i $file_name
        sed "s/$COMPUTE_IP/<%=node[:COMPUTE_IP]%>/g" -i $file_name
        sed "s/$DB_USER:/<%=node[:DB_USER]%>:/g" -i $file_name
        sed "s/$DB_PASSWORD@/<%=node[:DB_PASSWORD]%>@/g" -i $file_name
        mv $file_name $file_name$SUFFIX
    fi
}

api-paste_chefsolo_template() {
    file_name=$1
    if [ -e $file_name ]; then
        sed "s/auth_host =.*$/auth_host = <%=node[:CONTROLLER_IP]%> /" -i $file_name
        sed "s/^admin_tenant_name =.*$/admin_tenant_name = <%=node[:SERVICE_TENANT_NAME]%> /" -i $file_name
        sed "s/^admin_user =.*$/admin_user = <%=node[:SERVICE_USER]%> /" -i $file_name
        sed "s/^admin_password =.*$/admin_password = <%=node[:SERVICE_PASSWORD]%> /" -i $file_name
        sed "s/$CONTROLLER_HOST/<%=node[:CONTROLLER_HOST]%>/g" -i $file_name
        mv $file_name $file_name$SUFFIX
    fi
}

deploy-conf_chefsolo_template() {
    file_name=$1
    if [ -e $file_name ]; then
        sed "s/$CONTROLLER_IP/<%=node[:CONTROLLER_IP]%>/g" -i $file_name
        sed "s/$CONTROLLER_HOST/<%=node[:CONTROLLER_HOST]%>/g" -i $file_name
        sed "s/$COMPUTE_IP/<%=node[:COMPUTE_IP]%>/g" -i $file_name
        sed "s/$COMPUTE_HOST/<%=node[:COMPUTE_HOST]%>/g" -i $file_name
        mv $file_name $file_name$SUFFIX
    fi
}
