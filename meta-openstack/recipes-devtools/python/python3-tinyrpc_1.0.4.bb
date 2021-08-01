DESCRIPTION = "A small, modular, transport and protocol neutral \
RPC library that, among other things, supports JSON-RPC and zmq."
HOMEPAGE = "http://github.com/mbr/tinyrpc"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[md5sum] = "cd61e3cbc01ea940abc97d3a87abf4a7"
SRC_URI[sha256sum] = "4b41fab967fb1c978f573bf0d609a3b12cc3b6ed62bd3108f43f575563746396"

inherit setuptools3 pypi

RDEPENDS:${PN} += " \
        python3-six \
        python3-gevent \
        python3-requests \
        python3-websocket-client \
        python3-jsonext \
        python3-gevent-websocket \
        python3-werkzeug \
        python3-pyzmq \
        "
