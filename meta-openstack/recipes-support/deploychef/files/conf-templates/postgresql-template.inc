#Postgresql chefsolo template generation functions
postgresql_chefsolo_template() {
    file_name=$1
    if [ -e $file_name ]; then
        sed "s/$CONTROLLER_IP/<%=node[:CONTROLLER_IP]%>/g" -i $file_name
        sed "s/$COMPUTE_IP/<%=node[:COMPUTE_IP]%>/g" -i $file_name
        sed "s/^DB_USER=.*$/DB_USER=<%=node[:DB_USER]%>/" -i $file_name
        sed "s/^DB_PASSWORD=.*$/DB_PASSWORD=<%=node[:DB_PASSWORD]%>/" -i $file_name
        mv $file_name $file_name$SUFFIX
    fi
}

