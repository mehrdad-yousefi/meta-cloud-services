#Glance related configuration functions
glance_chefsolo_template() {
    file_name=$1
    if [ -e $file_name ]; then
        sed "s/$DB_USER:/<%=node[:DB_USER]%>:/g" -i $file_name
        sed "s/$DB_PASSWORD@/<%=node[:DB_PASSWORD]%>@/g" -i $file_name
        sed "s/^swift_store_user =.*$/swift_store_user = <%=node[:SERVICE_TENANT_NAME]%>:glance/" -i $file_name
        sed "s/^swift_store_key =.*$/swift_store_key = <%=node[:SERVICE_PASSWORD]%> /" -i $file_name

        sed "s/^admin_tenant_name =.*$/admin_tenant_name = <%=node[:SERVICE_TENANT_NAME]%> /" -i $file_name
        sed "s/^admin_user =.*$/admin_user = <%=node[:SERVICE_USER]%> /" -i $file_name
        sed "s/^admin_password =.*$/admin_password = <%=node[:SERVICE_PASSWORD]%> /" -i $file_name
        sed "s/$CONTROLLER_HOST/<%=node[:CONTROLLER_HOST]%>/g" -i $file_name
        mv $file_name $file_name$SUFFIX
    fi
}
