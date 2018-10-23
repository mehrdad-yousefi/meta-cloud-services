SRC_URI = "https://bits.gluster.org/pub/gluster/glusterfs/src/${BPN}-${PV}.tar.gz"

SRC_URI[md5sum] = "46d56837b8b5c785f2f1e5317d5f6da8"
SRC_URI[sha256sum] = "c7e0502631c9bc9da05795b666b74ef40a30a0344f5a2e205e65bd2faefe1442"

require glusterfs.inc
