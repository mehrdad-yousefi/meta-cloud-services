inherit setuptools
require python-debtcollector.inc

# Only for Python2 depends on funcsigs
RDEPENDS_${PN} += " \
        python-funcsigs \
        "
