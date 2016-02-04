SUMMARY = "Python client for Apache Kafka"
HOMEPAGE = "https://github.com/mumrah/kafka-python"
SECTION = "devel/python"
LICENSE = "Apache-2.0"

PV = "0.9.4+git${SRCPV}"
SRCREV = "4955582be1443b75c23f700268b7abbef0fde0ad"

SRCNAME = "kafka-python"

LIC_FILES_CHKSUM = "file://LICENSE;md5=22efebb1e053dcc946f4b9d17f3cbbea"
SRC_URI = "git://github.com/mumrah/${SRCNAME}.git"

S = "${WORKDIR}/git"

inherit setuptools

DEPENDS += " \
	python-pbr \
	"

RDEPENDS_${PN} += " \
        python-six \
	"

