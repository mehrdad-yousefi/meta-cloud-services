#!/bin/bash
#Ceph related chefsolo template functions
ceph-conf_chefsolo_template() {
    file_name=$1
    if [ -e $file_name ]; then
        sed "s/mon initial members =.*$/mon initial members = <%=node[:HOST_NAME]%> /" -i $file_name
        sed "s/mon host =.*$/mon host = <%=node[:PUBLIC_IP]%>/" -i $file_name

        sed "s:public network =.*/:public network = <%=node[\:CONTROLLER_IP]%>/:" -i $file_name
        sed "s/mon.$CONTROLLER_HOST/mon.<%=node[:HOST_NAME]%>/" -i $file_name
        sed "s/host =.*$/host = <%=node[:HOST_NAME]%>/" -i $file_name
        sed "s#mon addr =.*:#mon addr = <%=node[:PUBLIC_IP]%>:#" -i $file_name
        sed "s#public addr =.*:#public addr = <%=node[:PUBLIC_IP]%>:#" -i $file_name
        sed "s#cluster addr =.*:#cluster addr = <%=node[:PRIVATE_IP]%>:#" -i $file_name
        mv $file_name $file_name$SUFFIX
    fi
}

ceph-setup_chefsolo_template() {
    file_name=$1
    if [ -e $file_name ]; then
        sed "s/^HOST_NAME.*$/HOST_NAME= <%=node[:HOST_NAME]%> /" -i $file_name
        sed "s/^PUBLIC_IP.*$/PUBLIC_IP= <%=node[:PUBLIC_IP]%>/" -i $file_name
        mv $file_name $file_name$SUFFIX
    fi
}
