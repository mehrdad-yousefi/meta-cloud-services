SUMMARY = "Shadow Password Module"
HOMEPAGE = "https://github.com/apalmblad/ruby-shadow"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=137882914e5269b7268f0fe8e28a3f89"

PV = "2.4.1"

SRC_URI = "git://github.com/apalmblad/ruby-shadow.git"
SRCREV = "4231a4838fd50022b112838f114ee0586e119605"
S = "${WORKDIR}/git"

inherit ruby

DEPENDS += " \
        ruby \
"

RDEPENDS_${PN} += " \
        ruby \
"

RUBY_INSTALL_GEMS = "ruby-shadow-${PV}.gem"
FILES_${PN}-dbg += "/usr/lib*/ruby/gems/*/gems/ruby-shadow-${PV}/.debug/shadow.so"
