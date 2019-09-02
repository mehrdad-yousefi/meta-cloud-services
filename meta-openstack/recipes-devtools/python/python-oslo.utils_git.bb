inherit setuptools
require python-oslo.utils.inc

# RDEPENDS only for python2
RDEPENDS_${PN} += " \
        ${PYTHON_PN}-monotonic \
        ${PYTHON_PN}-funcsigs \
        "

