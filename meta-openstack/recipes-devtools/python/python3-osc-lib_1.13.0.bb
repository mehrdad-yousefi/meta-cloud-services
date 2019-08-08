inherit setuptools3 pypi
require python-osc-lib.inc

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

