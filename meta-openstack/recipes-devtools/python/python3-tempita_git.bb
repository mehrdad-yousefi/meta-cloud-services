DESCRIPTION = "A very small text templating language"
HOMEPAGE = "https://github.com/nsoranzo/tempita"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://setup.py;beginline=36;endline=36;md5=3cbf117e7a23a9d13aabecd89569c69e"

SRCREV = "a30af77422444985d43e249e035963a0e131ea05"
PV = "0.5.2+git${SRCPV}"

SRC_URI = "\
	git://github.com/nsoranzo/tempita.git;branch=main;protocol=https \
	"

S = "${WORKDIR}/git"

inherit setuptools3
