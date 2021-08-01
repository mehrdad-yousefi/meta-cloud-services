DESCRIPTION = "The modular source code checker: pep8, pyflakes and co"
HOMEPAGE = "https://github.com/dreamhost/cliff"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=75b26781f1adf1aa310bda6098937878"

SRC_URI[md5sum] = "6ab0ad6630b6917fafabded7f80344b4"
SRC_URI[sha256sum] = "aadae8761ec651813c24be05c6f7b4680857ef6afaae4651a4eccaef97ce6c3b"

inherit setuptools3 pypi

RDEPENDS:${PN} += "python3-prettytable \
            python3-cmd2 \
            python3-pyparsing \
            python3-mccabe \
            python3-pep8 \
            python3-logging \
            python3-pyflakes"
