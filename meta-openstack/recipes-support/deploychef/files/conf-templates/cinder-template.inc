#Cinder related configuration functions
cinder-conf_chefsolo_template() {
    file_name=$1
    if [ -e $file_name ]; then
        sed "s/$DB_USER:/<%=node[:DB_USER]%>:/g" -i $file_name
        sed "s/$DB_PASSWORD@/<%=node[:DB_PASSWORD]%>@/g" -i $file_name
        sed "s/$CONTROLLER_HOST/<%=node[:CONTROLLER_HOST]%>/g" -i $file_name
        mv $file_name $file_name$SUFFIX
    fi
}

cinder-api_chefsolo_template() {
    file_name=$1
    if [ -e $file_name ]; then
        sed "s/^admin_tenant_name =.*$/admin_tenant_name = <%=node[:SERVICE_TENANT_NAME]%> /" -i $file_name
        sed "s/^admin_user =.*$/admin_user = <%=node[:SERVICE_USER]%> /" -i $file_name
        sed "s/^admin_password =.*$/admin_password = <%=node[:SERVICE_PASSWORD]%> /" -i $file_name
        mv $file_name $file_name$SUFFIX
    fi
}

