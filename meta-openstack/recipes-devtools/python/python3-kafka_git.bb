SUMMARY = "Python client for Apache Kafka"
HOMEPAGE = "https://github.com/mumrah/kafka-python"
SECTION = "devel/python"
LICENSE = "Apache-2.0"

PV = "2.0.1+git${SRCPV}"
SRCREV = "fcc9a30c62662cee7aa2c1f69c0d06a9741e2700"

SRCNAME = "kafka-python"

LIC_FILES_CHKSUM = "file://LICENSE;md5=22efebb1e053dcc946f4b9d17f3cbbea"
SRC_URI = "git://github.com/mumrah/${SRCNAME}.git"

S = "${WORKDIR}/git"

inherit setuptools3

DEPENDS += " \
	${PYTHON_PN}-pbr \
	"

RDEPENDS_${PN} += " \
        ${PYTHON_PN}-six \
        ${PYTHON_PN}-logging \
        ${PYTHON_PN}-compression \
	"

