DESCRIPTION = "Physical quantities module"
HOMEPAGE = "https://pypi.python.org/pypi/Pint"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bccf824202692270a1e0829a62e3f47b"

PYPI_PACKAGE = "Pint"

# Archived version so we have to overwrite what the pypi class will derive
PYPI_SRC_URI = "https://pypi.python.org/packages/source/P/${PYPI_PACKAGE}/${PYPI_PACKAGE}-${PV}.zip"

SRC_URI[md5sum] = "88aa0918019071546b10c5fbdc91ae5e"
SRC_URI[sha256sum] = "b1ab3b589ca4d78689233a007abd5a7eec4ea65302cabaed06932d20f2a9e748"

inherit setuptools pypi

RDEPENDS_${PN} += "gmp"

FILES_${PN} += "${datadir}/*"
