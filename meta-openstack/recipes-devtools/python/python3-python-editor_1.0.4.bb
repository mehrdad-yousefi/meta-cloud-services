DESCRIPTION = "Programmatically open an editor, capture the result"
HOMEPAGE = "https://github.com/fmoo/python-editor"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d2794c0df5b907fdace235a619d80314"

inherit setuptools3 pypi

SRC_URI[sha256sum] = "51fda6bcc5ddbbb7063b2af7509e43bd84bfc32a4ff71349ec7847713882327b"

DEPENDS += " \
        ${PYTHON_PN}-pip \
        "

RDEPENDS:${PN} += " \
        "
