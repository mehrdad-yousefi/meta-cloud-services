DESCRIPTION = "A small Python module for determining appropriate platform-specific dirs, e.g. a user data dir."
HOMEPAGE = "http://github.com/ActiveState/appdirs"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=31625363c45eb0c67c630a2f73e438e4"

PV = "1.4.0"
SRCREV = "57f2bc44a8bca99bac6c57496c8b3fdea26f94d5"

SRCNAME = "appdirs"
SRC_URI = "git://github.com/ActiveState/${SRCNAME}.git"

S = "${WORKDIR}/git"

inherit distutils

DEPENDS += " \
        python-pip \
        "

RDEPENDS_${PN} += " \
        python-pip \
        "

do_install_append() {
    # Using these "longest" paths will ensure needed shorter paths will be created
    install -d ${D}/${libdir}/python2.7/site-packages/${SRCNAME}/test
    install -d ${D}/${libdir}/python2.7/site-packages/${SRCNAME}.egg-info
    
    install -m 644 ${S}/${SRCNAME}.py ${D}/${libdir}/python2.7/site-packages/${SRCNAME}/__init__.py
    install -m 644 ${S}/${SRCNAME}.pyc ${D}/${libdir}/python2.7/site-packages/${SRCNAME}/__init__.pyc
    install -m 644 ${S}/test/* ${D}/${libdir}/python2.7/site-packages/${SRCNAME}/test/
    install -m 644 ${S}/${SRCNAME}.egg-info/* ${D}/${libdir}/python2.7/site-packages/${SRCNAME}.egg-info/
}
