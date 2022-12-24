DESCRIPTION = "OpenStack Block storage service"
HOMEPAGE = "https://launchpad.net/cinder"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRCNAME = "cinder"

SRC_URI = "git://github.com/openstack/${SRCNAME}.git;branch=stable/pike;protocol=https \
    file://cinder-init \
    file://cinder-init.service \
    file://cinder-api.service \
    file://cinder-backup.service \
    file://cinder-scheduler.service \
    file://cinder-volume.service \
    file://cinder.conf \
    file://cinder-volume \
    file://nfs_setup.sh \
    file://glusterfs_setup.sh \
    file://lvm_iscsi_setup.sh \
    file://add-cinder-volume-types.sh \
    "

SRCREV = "4fb3a702ba8c3de24c41a6f706597bfa81e60435"
PV = "11.1.0+git${SRCPV}"
S = "${WORKDIR}/git"

inherit setuptools3 systemd useradd identity default_configs hosts monitor

USER = "cinder"
GROUP = "cinder"

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM:${PN} = "--system ${GROUP}"
USERADD_PARAM:${PN} = "--system -m -d ${localstatedir}/lib/cinder -s /bin/false -g ${GROUP} ${USER}"

CINDER_BACKUP_BACKEND_DRIVER ?= "cinder.backup.drivers.swift"

KEYSTONE_HOST="${CONTROLLER_IP}"

CINDER_LVM_VOLUME_BACKING_FILE_SIZE ?= "2G"
CINDER_NFS_VOLUME_SERVERS_DEFAULT = "controller:/etc/cinder/nfs_volumes"
CINDER_NFS_VOLUME_SERVERS ?= "${CINDER_NFS_VOLUME_SERVERS_DEFAULT}"
CINDER_GLUSTERFS_VOLUME_SERVERS_DEFAULT = "controller:/glusterfs_volumes"
CINDER_GLUSTERFS_VOLUME_SERVERS ?= "${CINDER_GLUSTERFS_VOLUME_SERVERS_DEFAULT}"

do_install:append() {
    TEMPLATE_CONF_DIR=${S}${sysconfdir}/${SRCNAME}
    CINDER_CONF_DIR=${D}${sysconfdir}/${SRCNAME}
    
    #Instead of substituting api-paste.ini from the WORKDIR,
    #move it over to the image's directory and do the substitution there
    install -d ${CINDER_CONF_DIR}
    install -o ${USER} -m 664 ${WORKDIR}/cinder.conf ${CINDER_CONF_DIR}/
    install -o ${USER} -m 664 ${TEMPLATE_CONF_DIR}/api-paste.ini ${CINDER_CONF_DIR}/
    install -o ${USER} -m 664 ${S}/etc/cinder/policy.json ${CINDER_CONF_DIR}/

    install -d ${CINDER_CONF_DIR}/drivers
    install -m 600 ${WORKDIR}/nfs_setup.sh ${CINDER_CONF_DIR}/drivers/
    install -m 600 ${WORKDIR}/glusterfs_setup.sh ${CINDER_CONF_DIR}/drivers/
    install -m 600 ${WORKDIR}/lvm_iscsi_setup.sh ${CINDER_CONF_DIR}/drivers/
    install -m 700 ${WORKDIR}/add-cinder-volume-types.sh ${CINDER_CONF_DIR}/

    install -d ${D}${localstatedir}/log/${SRCNAME}

    # Setup the neutron initialization script
    INIT_FILE=${CINDER_CONF_DIR}/cinder-init
    install -g ${USER} -m 750 ${WORKDIR}/cinder-init ${INIT_FILE}
    sed -e "s:%DB_USER%:${DB_USER}:g" -i ${INIT_FILE}
    sed -e "s:%CINDER_USER%:${USER}:g" -i ${INIT_FILE}
    sed -e "s:%CINDER_GROUP%:${GROUP}:g" -i ${INIT_FILE}
    sed -e "s:%CONTROLLER_IP%:${CONTROLLER_IP}:g" -i ${INIT_FILE}
    sed -e "s:%ADMIN_USER%:${ADMIN_USER}:g" -i ${INIT_FILE}
    sed -e "s:%ADMIN_PASSWORD%:${ADMIN_PASSWORD}:g" -i ${INIT_FILE}
    sed -e "s:%ADMIN_ROLE%:${ADMIN_ROLE}:g" -i ${INIT_FILE}
    sed -e "s:%SYSCONFDIR%:${sysconfdir}:g" -i ${INIT_FILE}
    sed -e "s:%ROOT_HOME%:${ROOT_HOME}:g" -i ${INIT_FILE}

    # install systemd service files
    install -d ${D}${systemd_system_unitdir}/
    for j in cinder-init cinder-api cinder-backup cinder-volume cinder-scheduler; do
        SERVICE_FILE=${D}${systemd_system_unitdir}/$j.service
	install -m 644 ${WORKDIR}/$j.service ${SERVICE_FILE}
        sed -e "s:%USER%:${USER}:g" -i ${SERVICE_FILE}
	sed -e "s:%GROUP%:${GROUP}:g" -i ${SERVICE_FILE}
        sed -e "s:%LOCALSTATEDIR%:${localstatedir}:g" -i ${SERVICE_FILE}
        sed -e "s:%SYSCONFDIR%:${sysconfdir}:g" -i ${SERVICE_FILE}			
    done

    #
    # Per https://docs.openstack.org/cinder/pike/install/cinder-controller-install-ubuntu.html
    #
    CONF_FILE="${CINDER_CONF_DIR}/cinder.conf"
    sed -e "/^\[database\]/aconnection = postgresql+psycopg2://${DB_USER}:${DB_PASSWORD}@${CONTROLLER_IP}/cinder" \
           -i ${CONF_FILE}
    sed -e "/#transport_url =/atransport_url = rabbit://openstack:${ADMIN_PASSWORD}@${CONTROLLER_IP}" -i ${CONF_FILE}
    sed -e "/#auth_strategy =/aauth_strategy = keystone" -i ${CONF_FILE}

    str="auth_uri = http://${CONTROLLER_IP}:5000"
    str="$str\nauth_url = http://${CONTROLLER_IP}:35357"
    str="$str\nmemcached_servers = ${CONTROLLER_IP}:11211"
    str="$str\nauth_type = password"
    str="$str\nproject_domain_name = Default"
    str="$str\nuser_domain_name = Default"
    str="$str\nproject_name = service"
    str="$str\nusername = ${USER}"
    str="$str\npassword = ${ADMIN_PASSWORD}"
    sed -e "/^\[keystone_authtoken\].*/a$str" -i ${CONF_FILE}

    sed -e "/#my_ip =/amy_ip = ${MY_IP}" -i ${CONF_FILE}
    sed -e "/#lock_path =/alock_path = ${localstatedir}/lib/cinder/tmp" -i ${CONF_FILE}

    sed -e "/#enabled_backends =/aenabled_backends = nfsdriver" -i ${CONF_FILE}
    str="[nfsdriver]"
    str="$str\nvolume_group=nfs-group-1"
    str="$str\nvolume_driver=cinder.volume.drivers.nfs.NfsDriver"
    str="$str\nvolume_backend_name=Generic_NFS"
    sed -e "s/\(^\[backend\].*\)/$str\n\1/" -i ${CONF_FILE}

    # test setup
    cp -r tools ${CINDER_CONF_DIR}

    #Create cinder volume group backing file
    sed 's/%CINDER_LVM_VOLUME_BACKING_FILE_SIZE%/${CINDER_LVM_VOLUME_BACKING_FILE_SIZE}/g' -i ${D}/etc/cinder/drivers/lvm_iscsi_setup.sh
    mkdir -p ${D}/etc/tgt/conf.d/
    echo "include /etc/cinder/data/volumes/*" > ${D}/etc/tgt/conf.d/python-cinder.conf

    # Create Cinder nfs_share config file with default nfs server
    echo "${CINDER_NFS_VOLUME_SERVERS}" > ${D}/etc/cinder/nfs_shares
    sed 's/\s\+/\n/g' -i ${D}/etc/cinder/nfs_shares
    [ "x${CINDER_NFS_VOLUME_SERVERS}" = "x${CINDER_NFS_VOLUME_SERVERS_DEFAULT}" ] && is_default="1" || is_default="0"
    sed -e "s:%IS_DEFAULT%:${is_default}:g" -i ${D}/etc/cinder/drivers/nfs_setup.sh

    # Create Cinder glusterfs_share config file with default glusterfs server
    echo "${CINDER_GLUSTERFS_VOLUME_SERVERS}" > ${D}/etc/cinder/glusterfs_shares
    sed 's/\s\+/\n/g' -i ${D}/etc/cinder/glusterfs_shares
    [ "x${CINDER_GLUSTERFS_VOLUME_SERVERS}" = "x${CINDER_GLUSTERFS_VOLUME_SERVERS_DEFAULT}" ] && is_default="1" || is_default="0"
    sed -e "s:%IS_DEFAULT%:${is_default}:g" -i ${D}/etc/cinder/drivers/glusterfs_setup.sh
}

#pkg_postinst_${SRCNAME}-setup () {
#    if [ -z "$D" ]; then
#	 if [ ! -d /var/log/cinder ]; then
#	    mkdir /var/log/cinder
#	 fi
#
#	 sudo -u postgres createdb cinder
#	 cinder-manage db sync
#
#	 # Create Cinder nfs_share config file with default nfs server
#	 if [ ! -f /etc/cinder/nfs_shares ]; then
#	     /bin/bash /etc/cinder/drivers/nfs_setup.sh
#	 fi
#
#	 # Create Cinder glusterfs_share config file with default glusterfs server
#	 if [ ! -f /etc/cinder/glusterfs_shares ] && [ -f /usr/sbin/glusterfsd ]; then
#	     /bin/bash /etc/cinder/drivers/glusterfs_setup.sh
#	 fi
#    fi
#}

PACKAGES += "${SRCNAME}-tests ${SRCNAME} ${SRCNAME}-setup ${SRCNAME}-api ${SRCNAME}-volume ${SRCNAME}-scheduler ${SRCNAME}-backup"
ALLOW_EMPTY:${SRCNAME}-setup = "1"
ALLOW_EMPTY:${SRCNAME}-backup = "1"
ALLOW_EMPTY:${SRCNAME}-scheduler = "1"
ALLOW_EMPTY:${SRCNAME}-volume = "1"
ALLOW_EMPTY:${SRCNAME}-api = "1"

RDEPENDS:${SRCNAME}-tests += " bash python3"

FILES:${PN} = "${libdir}/* /etc/tgt"

FILES:${SRCNAME}-tests = "${sysconfdir}/${SRCNAME}/tools"

FILES:${SRCNAME}-api = " \
    ${bindir}/cinder-api \
"

FILES:${SRCNAME}-volume = " \
    ${bindir}/cinder-volume \
"

FILES:${SRCNAME}-scheduler = " \
    ${bindir}/cinder-scheduler \
"

FILES:${SRCNAME}-backup = " \
    ${bindir}/cinder-backup \
"

FILES:${SRCNAME} = "${bindir}/* \
    ${sysconfdir}/${SRCNAME}/* \
    ${localstatedir}/* \
    ${sysconfdir}/${SRCNAME}/drivers/* \
    "

DEPENDS += " \
        python3-pip \
        python3-pbr \
        "

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python3-pbr-native \
        "

RDEPENDS:${PN} += " \
        lvm2 \
        python3-pbr \
        python3-babel \
        python3-decorator \
        python3-eventlet \
        python3-greenlet \
        python3-httplib2 \
        python3-iso8601 \
        python3-ipaddress \
        python3-keystoneauth1 \
        python3-keystonemiddleware \
        python3-lxml \
        python3-oauth2client \
        python3-oslo.config \
        python3-oslo.concurrency \
        python3-oslo.context \
        python3-oslo.db \
        python3-oslo.log \
        python3-oslo.messaging \
        python3-oslo.middleware \
        python3-oslo.policy \
        python3-oslo.privsep \
        python3-oslo.reports \
        python3-oslo.rootwrap \
        python3-oslo.serialization \
        python3-oslo.service \
        python3-oslo.utils \
        python3-oslo.versionedobjects \
        python3-osprofiler \
        python3-paramiko \
        python3-paste \
        python3-pastedeploy \
        python3-psutil \
        python-pyparsing \
        python3-barbicanclient \
        python-glanceclient \
        python3-keystoneclient \
        python-novaclient \
        python3-swiftclient \
        python3-pytz \
        python3-requests \
        python3-retrying \
        python3-routes \
        python3-taskflow \
        python3-rtslib-fb \
        python3-simplejson \
        python3-six \
        python3-sqlalchemy \
        python3-sqlalchemy-migrate \
        python3-stevedore \
        python3-suds-jurko \
        python3-webob \
        python3-oslo.i18n \
        python3-oslo.vmware \
        python3-os-brick \
        python3-os-win \
        python3-tooz \
        python-google-api-python-client \
        python3-castellan \
        python3-cryptography \
        "

RDEPENDS:${SRCNAME} = " \
    ${PN} \
    postgresql \
    postgresql-client \
    python-psycopg2 \
    tgt"

RDEPENDS:${SRCNAME}-api = "${SRCNAME}"
RDEPENDS:${SRCNAME}-volume = "${SRCNAME}"
RDEPENDS:${SRCNAME}-scheduler = "${SRCNAME}"
RDEPENDS:${SRCNAME}-setup = "postgresql sudo ${SRCNAME} bash"

SYSTEMD_PACKAGES = " \
    ${SRCNAME}-setup \
    ${SRCNAME}-api \
    ${SRCNAME}-volume \
    ${SRCNAME}-scheduler \
    ${SRCNAME}-backup \
"

SYSTEMD_SERVICE:${SRCNAME}-setup = "cinder-init.service"
SYSTEMD_SERVICE:${SRCNAME}-api = "cinder-api.service"
SYSTEMD_SERVICE:${SRCNAME}-volume = "cinder-volume.service"
SYSTEMD_SERVICE:${SRCNAME}-scheduler = "cinder-scheduler.service"
SYSTEMD_SERVICE:${SRCNAME}-backup = "cinder-backup.service"

# Disable until they are configured (via -setup)
SYSTEMD_AUTO_ENABLE:${SRCNAME}-api = "disable"
SYSTEMD_AUTO_ENABLE:${SRCNAME}-volume = "disable"
SYSTEMD_AUTO_ENABLE:${SRCNAME}-scheduler = "disable"
SYSTEMD_AUTO_ENABLE:${SRCNAME}-backup = "disable"

MONITOR_SERVICE_PACKAGES = "${SRCNAME}"
MONITOR_SERVICE_${SRCNAME} = "cinder"
