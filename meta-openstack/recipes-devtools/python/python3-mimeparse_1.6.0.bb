DESCRIPTION = "basic functions for parsing mime-type names and matching "
HOMEPAGE = "https://pypi.python.org/pypi/python-mimeparse/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=1f333cc431fd2aaf1a80b1b7212a6086"

PYPI_PACKAGE = "python-mimeparse"

SRC_URI[md5sum] = "a32ae1df93be1ddb581d1c0fa124bab4"
SRC_URI[sha256sum] = "76e4b03d700a641fd7761d3cd4fdbbdcd787eade1ebfac43f877016328334f78"

inherit pypi setuptools3

DISTUTILS_INSTALL_ARGS = "--root=${D} \
    --prefix=${prefix} \
    --install-lib=${PYTHON_SITEPACKAGES_DIR} \
    --install-data=${datadir}"

RDEPENDS:${PN} += " \
	python3-netserver \
"
