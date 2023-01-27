DESCRIPTION = "A very small text templating language"
HOMEPAGE = "https://github.com/nsoranzo/tempita"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=06e8c765d2d2ec21c46aeaff361cb044"

SRCREV = "f6015ac7c6e698e52d2b4909517eef0d6fde3889"
PV = "0.5.4dev+git${SRCPV}"

SRC_URI = "\
	git://github.com/mehrdad-yousefi/tempita.git;branch=main;protocol=https \
	"

S = "${WORKDIR}/git"

inherit setuptools3
