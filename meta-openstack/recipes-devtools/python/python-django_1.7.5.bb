DESCRIPTION = "A high-level Python Web framework"
HOMEPAGE = "http://www.djangoproject.com/"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f09eb47206614a4954c51db8a94840fa"

SRCNAME = "Django"

SRC_URI = "https://pypi.python.org/packages/source/D/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "e76c70a5dd7d56a511974b28ab38df20"
SRC_URI[sha256sum] = "1c391f9349c97df503dac3461599f24235e4d04393498e6060e74dd2721460bc"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

FILES_${PN} += "${datadir}/django/*"

