HOMEPAGE = "http://saltstack.com/"
SECTION = "admin"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ac9a49d86925151327b277d6a3999a07"
DEPENDS = "\
           python3-msgpack \
           python3-pyyaml \
           python3-jinja2 \
           python3-markupsafe \
           python3-dateutil \
           python3-pycryptodome \
           python3-pytest-salt \
           python3-pyzmq \
           python3-requests \
"

PACKAGECONFIG ??= "zeromq"
PACKAGECONFIG[zeromq] = ",,python3-pyzmq python3-pycryptodome,"
PACKAGECONFIG[tcp] = ",,python3-pycryptodome"

SRC_URI = "https://files.pythonhosted.org/packages/source/s/${BPN}/${BPN}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "4174a6dd2c7eee808086ca06bdd928c9"
SRC_URI[sha256sum] = "e9ebb4d92fae8dabf21b8749dc126e4a4048bf8f613f5b1b851fe4b8226b5abc"


SYSTEMD_AUTO_ENABLE:${PN}-master = "disable"
SYSTEMD_AUTO_ENABLE:${PN}-minion = "disable"
SYSTEMD_AUTO_ENABLE:${PN}-api = "disable"

S = "${WORKDIR}/${PN}-${PV}"

inherit setuptools3 systemd

# Avoid a QA Warning triggered by the test package including a file
# with a .a extension
INSANE_SKIP:${PN}-tests += "staticdev"

RDEPENDS:${PN} += "${PN}-api \
                   ${PN}-common \
                   ${PN}-master \
                   ${PN}-minion \
                   ${PN}-bash-completion \
"

# Note ${PN}-tests must be before ${PN}-common in the PACKAGES variable
# in order for ${PN}-tests to own the correct FILES.
PACKAGES += "\
           ${PN}-api \
           ${PN}-common \
           ${PN}-master \
           ${PN}-minion \
           ${PN}-cloud \
           ${PN}-syndic \
           ${PN}-ssh \
           ${PN}-bash-completion \
           ${PN}-zsh-completion \
"

do_install:append() {
        install -Dm644 ${S}/pkg/salt-common.logrotate ${D}${sysconfdir}/logrotate.d/${PN}
        install -Dm644 ${S}/pkg/salt.bash ${D}${datadir}/bash-completion/completions/${PN}
        install -Dm644 ${S}/pkg/zsh_completion.zsh ${D}${datadir}/zsh/site-functions/_${PN}

        # default config
        install -Dm644 ${S}/conf/minion ${D}${sysconfdir}/${PN}/minion
        install -Dm644 ${S}/conf/minion ${D}${sysconfdir}/${PN}/master

        # systemd services
        for _svc in salt-master.service salt-syndic.service salt-minion.service salt-api.service; do
            install -Dm644 ${S}/pkg/$_svc "${D}${systemd_system_unitdir}/$_svc"
        done
}

ALLOW_EMPTY:${PN} = "1"
FILES:${PN} = ""
FILES:${PN} += "${systemd_system_unitdir} ${systemd_system_unitdir}/* /etc/salt/master.d /etc/salt/master.d/preseed_key.py"

DESCRIPTION_COMMON = "salt is a powerful remote execution manager that can be used to administer servers in a\
 fast and efficient way. It allows commands to be executed across large groups of servers. This means systems\
 can be easily managed, but data can also be easily gathered. Quick introspection into running systems becomes\
 a reality. Remote execution is usually used to set up a certain state on a remote system. Salt addresses this\
 problem as well, the salt state system uses salt state files to define the state a server needs to be in. \
Between the remote execution system, and state management Salt addresses the backbone of cloud and data center\
 management."

SUMMARY:${PN}-minion = "client package for salt, the distributed remote execution system"
DESCRIPTION:${PN}-minion = "${DESCRIPTION_COMMON} This particular package provides the worker agent for salt."
RDEPENDS:${PN}-minion = "${PN}-common (= ${EXTENDPKGV}) python3-msgpack python3-pycryptodomex (>= 3.9.7)"
RDEPENDS:${PN}-minion += "${@bb.utils.contains('PACKAGECONFIG', 'zeromq', 'python3-pycryptodome python3-pyzmq (>= 13.1.0)', '',d)}"
RDEPENDS:${PN}-minion += "${@bb.utils.contains('PACKAGECONFIG', 'tcp', 'python3-pycryptodome', '',d)}"
RRECOMMENDS:${PN}-minion:append_x64 = "dmidecode"
RSUGGESTS:${PN}-minion = "python3-augeas"
CONFFILES:${PN}-minion = "${sysconfdir}/${PN}/minion"
FILES:${PN}-minion = "${bindir}/${PN}-minion ${sysconfdir}/${PN}/minion.d/ ${CONFFILES_${PN}-minion} ${bindir}/${PN}-proxy ${systemd_system_unitdir}/salt-minion.service"

SUMMARY:${PN}-common = "shared libraries that salt requires for all packages"
DESCRIPTION:${PN}-common ="${DESCRIPTION_COMMON} This particular package provides shared libraries that \
salt-master, salt-minion, and salt-syndic require to function."
RDEPENDS:${PN}-common = "python3-dateutil python3-jinja2 python3-pyyaml python3-requests (>= 1.0.0) python3-distro"
RRECOMMENDS:${PN}-common = "lsb-release"
RSUGGESTS:${PN}-common = "python3-mako python3-git"
RCONFLICTS:${PN}-common = "python3-mako (< 0.7.0)"
CONFFILES:${PN}-common="${sysconfdir}/logrotate.d/${PN}"
FILES:${PN}-common = "${bindir}/${PN}-call ${PYTHON_SITEPACKAGES_DIR}/* ${CONFFILES_${PN}-common}"

SUMMARY:${PN}-ssh = "remote manager to administer servers via salt"
DESCRIPTION:${PN}-ssh = "${DESCRIPTION_COMMON} This particular package provides the salt ssh controller. It \
is able to run salt modules and states on remote hosts via ssh. No minion or other salt specific software needs\
 to be installed on the remote host."
RDEPENDS:${PN}-ssh = "${PN}-common (= ${EXTENDPKGV}) python3-msgpack"
CONFFILES:${PN}-ssh="${sysconfdir}/${PN}/roster"
FILES:${PN}-ssh = "${bindir}/${PN}-ssh ${CONFFILES_${PN}-ssh}"

SUMMARY:${PN}-api = "generic, modular network access system"
DESCRIPTION:${PN}-api = "a modular interface on top of Salt that can provide a variety of entry points into a \
running Salt system. It can start and manage multiple interfaces allowing a REST API to coexist with XMLRPC or \
even a Websocket API. The Salt API system is used to expose the fundamental aspects of Salt control to external\
 sources. salt-api acts as the bridge between Salt itself and REST, Websockets, etc. Documentation is available\
 on Read the Docs: http://salt-api.readthedocs.org/"
RDEPENDS:${PN}-api = "${PN}-master"
RSUGGESTS:${PN}-api = "python3-cherrypy"
CONFFILES:${PN}-api = "${sysconfdir}/init.d/${PN}-api"
FILES:${PN}-api = "${bindir}/${PN}-api ${CONFFILES_${PN}-api} ${systemd_system_unitdir}/${PN}-api.service"


SUMMARY:${PN}-master = "remote manager to administer servers via salt"
DESCRIPTION:${PN}-master ="${DESCRIPTION_COMMON} This particular package provides the salt controller."
RDEPENDS:${PN}-master = "${PN}-common (= ${EXTENDPKGV}) python3-msgpack python3-pycryptodomex (>= 3.9.7)"
RDEPENDS:${PN}-master += "${@bb.utils.contains('PACKAGECONFIG', 'zeromq', 'python3-pycryptodome python3-pyzmq (>= 13.1.0)', '',d)}"
RDEPENDS:${PN}-master += "${@bb.utils.contains('PACKAGECONFIG', 'tcp', 'python3-pycryptodome', '',d)}"
CONFFILES:${PN}-master="${sysconfdir}/init.d/${PN}-master  ${sysconfdir}/${PN}/master"
RSUGGESTS:${PN}-master = "python3-git"
FILES:${PN}-master = "${bindir}/${PN} ${bindir}/${PN}-cp ${bindir}/${PN}-key ${bindir}/${PN}-master ${bindir}/${PN}-run ${bindir}/${PN}-unity ${bindir}/spm ${CONFFILES_${PN}-master} ${systemd_system_unitdir}/${PN}-master.service"


SUMMARY:${PN}-syndic = "master-of-masters for salt, the distributed remote execution system"
DESCRIPTION:${PN}-syndic = "${DESCRIPTION_COMMON} This particular package provides the master of masters for \
salt; it enables the management of multiple masters at a time."
RDEPENDS:${PN}-syndic = "${PN}-master (= ${EXTENDPKGV})"
CONFFILES:${PN}-syndic="${sysconfdir}/init.d/${PN}-syndic"
FILES:${PN}-syndic = "${bindir}/${PN}-syndic ${CONFFILES_${PN}-syndic} ${systemd_system_unitdir}/${PN}-syndic.service"

SUMMARY:${PN}-cloud = "public cloud VM management system"
DESCRIPTION:${PN}-cloud = "provision virtual machines on various public clouds via a cleanly controlled profile and mapping system."
RDEPENDS:${PN}-cloud = "${PN}-common (= ${EXTENDPKGV})"
RSUGGESTS:${PN}-cloud = "python3-netaddr python3-botocore"
CONFFILES:${PN}-cloud = "${sysconfdir}/${PN}/cloud"
FILES:${PN}-cloud = "${bindir}/${PN}-cloud ${sysconfdir}/${PN}/cloud.conf.d/ ${sysconfdir}/${PN}/cloud.profiles.d/ ${sysconfdir}/${PN}/cloud.providers.d/ ${CONFFILES_${PN}-cloud}"

SUMMARY:${PN}-tests = "salt stack test suite"
DESCRIPTION:${PN}-tests ="${DESCRIPTION_COMMON} This particular package provides the salt unit test suite."
RDEPENDS:${PN}-tests = "${PN}-common python3-pytest-salt python3-tests python3-image bash"
FILES:${PN}-tests = "${PYTHON_SITEPACKAGES_DIR}/salt-tests/tests/"

FILES:${PN}-bash-completion = "${datadir}/bash-completion"
FILES:${PN}-zsh-completion = "${datadir}/zsh/site-functions"
