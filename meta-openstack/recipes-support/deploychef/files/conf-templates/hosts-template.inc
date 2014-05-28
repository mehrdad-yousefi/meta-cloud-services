#Hosts related configuration function(s)
hosts_chefsolo_template() {
    file_name=$1
    if [ -e $file_name ]; then
        sed "s/$CONTROLLER_IP.*$/<%=node[:CONTROLLER_IP]%> <%=node[:CONTROLLER_HOST]%>/" -i $file_name
        sed "s/$COMPUTE_IP*$/<%=node[:COMPUTE_IP]%> <%=node[:COMPUTE_HOST]%>/" -i $file_name
        mv $file_name $file_name$SUFFIX
    fi
}

