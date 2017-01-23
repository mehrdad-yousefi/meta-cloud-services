DESCRIPTION = "Compresses linked and inline JavaScript or CSS into single cached files."
HOMEPAGE = "http://django-compressor.readthedocs.org/en/latest/"
SECTION = "devel/python"
LICENSE = "MIT & BSD-3-Clause & BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=021598d037fd39ab02e53249e1fe4b6f"

SRCNAME = "django_compressor"

SRC_URI = "https://pypi.io/packages/source/d/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "21ecfe4e8615eae64f7068a5599df9af"
SRC_URI[sha256sum] = "ae0051bc0c7a0660c93434e68d617553fccdd573293dfd15aa33f78d2b4954ef"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools 

RDEPENDS_${PN} += " \
        python-django-appconf  \
        python-rcssmin  \
        python-rjsmin  \
        "

CLEANBROKEN = "1"
