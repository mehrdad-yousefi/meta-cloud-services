SRC_URI = "https://bits.gluster.org/pub/gluster/glusterfs/src/${BPN}-${PV}.tar.gz"

SRC_URI[md5sum] = "b52ec9101de3c01c7db17c00b3234d94"
SRC_URI[sha256sum] = "d4f8cf7551c4ac97480fa4f2da6077171b12d5501ee1ddc4cd8535e2336bde7e"

require glusterfs.inc
