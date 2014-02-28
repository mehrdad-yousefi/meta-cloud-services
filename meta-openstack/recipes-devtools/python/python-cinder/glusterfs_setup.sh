#! /bin/bash

# Default setup
if [ "$1" == "1" ]; then
    mkdir /etc/cinder/glusterfs_volumes
    /etc/init.d/glusterd start
    gluster volume create glusterfs_volumes controller:/etc/cinder/glusterfs_volumes force
    gluster volume start glusterfs_volumes force
    /etc/init.d/glusterd stop
fi
