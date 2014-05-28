#Swift chefso template generation functions
dispersion-conf_chefsolo_template() {
    file_name=$1
    if [ -e $file_name ]; then
        sed "s/$SERVICE_TENANT_NAME/<%=node[:SERVICE_TENANT_NAME]%>/" -i $file_name
        sed "s/$SERVICE_USER/<%=node[:SERVICE_USER]%>/" -i $file_name
        sed "s/$SERVICE_PASSWORD/<%=node[:SERVICE_PASSWORD]%>/" -i $file_name
        mv $file_name $file_name$SUFFIX
    fi
}

test-conf_chefsolo_template() {
    file_name=$1
    if [ -e $file_name ]; then
        sed "s/^account =.*$/account = <%=node[:ADMIN_TENANT_NAME]%>/" -i $file_name
        sed "s/^username =.*$/username = <%=node[:ADMIN_USER]%>/" -i $file_name
        sed "s/^password =.*$/password = <%=node[:ADMIN_PASSWORD]%>/g" -i $file_name

        sed "s/^account2 =.*$/account = <%=node[:SERVICE_TENANT_NAME]%>/" -i $file_name
        sed "s/^username2 =.*$/username = <%=node[:SERVICE_USER]%>/" -i $file_name
        sed "s/^password2 =.*$/password = <%=node[:SERVICE_PASSWORD]%>/g" -i $file_name

        sed "s/^username3 =.*$/username = <%=node[:DEMO_USER]%>/" -i $file_name
        sed "s/^password3 =.*$/password = <%=node[:DEMO_PASSWORD]%>/g" -i $file_name
        mv $file_name $file_name$SUFFIX
    fi
}

proxy-server_chefsolo_template() {
    file_name=$1
    if [ -e $file_name ]; then
        sed "s/^admin_tenant_name =.*$/admin_tenant_name = <%=node[:SERVICE_TENANT_NAME]%> /" -i $file_name
        sed "s/^admin_user =.*$/admin_user = <%=node[:SERVICE_USER]%> /" -i $file_name
        sed "s/^admin_password =.*$/admin_password = <%=node[:SERVICE_PASSWORD]%> /" -i $file_name
        mv $file_name $file_name$SUFFIX
    fi
}
