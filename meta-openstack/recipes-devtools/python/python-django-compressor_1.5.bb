DESCRIPTION = "Compresses linked and inline JavaScript or CSS into single cached files."
HOMEPAGE = "http://django-compressor.readthedocs.org/en/latest/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9f8de96acfc347c41ce7c15f2e918ef6"

SRCNAME = "django_compressor"

SRC_URI = "https://pypi.python.org/packages/source/d/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "274dd82a45ddd13e111852dd101a5924"
SRC_URI[sha256sum] = "0189fd1dbf87d802f4e4e21ebc9220f29bbb7771b252a958ad6119f61453e22e"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools 

RDEPENDS_${PN} += "python-django-appconf  \
	"

CLEANBROKEN = "1"
