inherit setuptools
require python-cliff.inc

# RDEPENDS only fot python2
RDEPENDS_${PN} += " \
            python-unicodecsv \
"
