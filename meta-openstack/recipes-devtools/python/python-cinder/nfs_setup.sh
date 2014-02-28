#! /bin/bash

# Default setup
if [ "$1" == "1" ]; then
    mkdir /etc/cinder/nfs_volumes
    echo "/etc/cinder/nfs_volumes *(rw,nohide,insecure,no_subtree_check,async,no_root_squash)" >> /etc/exports
fi
