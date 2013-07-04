DESCRIPTION = "Compresses linked and inline JavaScript or CSS into single cached files."
HOMEPAGE = "http://django-compressor.readthedocs.org/en/latest/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=005b23b510258ab60c075b1623eafd14"

PR = "r0"
SRCNAME = "django_compressor"

SRC_URI = "https://pypi.python.org/packages/source/d/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "da8ee3c5908d648ded03dfe996499b15"
SRC_URI[sha256sum] = "66ff1a845a6c1b16c4cf552ee3d746033979e46cd9bd5d999d4b5dae93327a52"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools 

RDEPENDS_${PN} += "python-django-appconf  \
	"
