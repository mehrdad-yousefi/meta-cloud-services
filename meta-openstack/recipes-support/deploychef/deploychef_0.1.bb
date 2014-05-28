#
# Copyright (C) 2014 Wind River Systems, Inc.
#
SUMMARY = "For the provisioning of OpenStack nodes"
DESCRIPTION = "There are a number of variables that are backed into Openstack \
at build time, for example the ip address of compute or controller node. \
This means that when a new compute or controller node boots up, it will \
have an ip address that differs from its currently assigned ip address \
This package facilitates the recreation or script and configuration files and their \
placement in the appropriate places on the files system on a compute/controller or \
all in one node at runtime"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PR = "r0"

require deploychef.inc

RDEPENDS_${PN} = "chef"
SRC_URI = "\
    file://deploychef.init  \
    file://attributes.json  \
    file://config.rb \
    file://run-postinsts \
    file://run-deploychef \
    file://service-shutdown \
    file://startup-list \
    file://shutdown-list \
    file://chefsolo_default_attribute.rb \
    file://chefsolo_default_recipe.rb \
    file://conf-templates/* \
    "
inherit update-rc.d identity hosts default_configs

S = "${WORKDIR}"
#Since this package does not need to be ran for each boot-up
#There is no need for an init scrpt so install it in /opt/${BPN}
DEPLOYCHEF_ROOT_DIR ?= "/opt/${BPN}"
#Provide a mechanism for these strings to be over-written if necessary
COOKBOOK_DIR = "${DEPLOYCHEF_ROOT_DIR}/cookbooks/"
ATTRIBUTE_DIR = "${DEPLOYCHEF_ROOT_DIR}/cookbooks/openstack/attributes/"
RECIPE_DIR = "${DEPLOYCHEF_ROOT_DIR}/cookbooks/openstack/recipes/"
TEMPLATES_CONF_DIR = "${DEPLOYCHEF_ROOT_DIR}/conf-templates/"

FILES_${PN} += " \
    ${DEPLOYCHEF_ROOT_DIR}/* \
    ${DEPLOYCHEF_ROOT_DIR}/conf-templates/* \
    ${DEPLOYCHEF_ROOT_DIR}/cookbooks/* \
    ${DEPLOYCHEF_ROOT_DIR}/cookbooks/openstack/recipes/* \
    ${DEPLOYCHEF_ROOT_DIR}/cookbooks/openstack/templates/* \
    ${DEPLOYCHEF_ROOT_DIR}/cookbooks/openstack/templates/default/* \
    ${DEPLOYCHEF_ROOT_DIR}/cookbooks/openstack/templates/default/excluded/* \
    ${DEPLOYCHEF_ROOT_DIR}/cookbooks/openstack/attributes/* \
    "
#Read the module config files and make them into
#chef-solo templates
do_install() {
    if ${@base_contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        #This script will make templates out of postinst script before they
        #have a chance to run
        install -d ${D}${sysconfdir}/init.d
        install -m 0755 ${S}/${BPN}.init ${D}${sysconfdir}/init.d/${BPN}

        install -d ${D}/${DEPLOYCHEF_ROOT_DIR}
        #Copy the template configuration scripts to image directory
        cp -r ${S}/conf-templates ${D}/${DEPLOYCHEF_ROOT_DIR}
        install -m 0755 ${S}/generate-templates ${D}/${DEPLOYCHEF_ROOT_DIR}
        install -m 0644 ${S}/config.rb ${D}/${DEPLOYCHEF_ROOT_DIR}/config.rb
        install -m 0644 ${S}/attributes.json ${D}/${DEPLOYCHEF_ROOT_DIR}/attributes.json
        install -m 0644 ${S}/run-postinsts ${D}/${DEPLOYCHEF_ROOT_DIR}/run-postinsts
        install -m 0644 ${S}/shutdown-list ${D}/${DEPLOYCHEF_ROOT_DIR}/shutdown-list
        install -m 0755 ${S}/run-deploychef  ${D}/${DEPLOYCHEF_ROOT_DIR}/run-deploychef
        install -m 0644 ${S}/service-shutdown  ${D}/${DEPLOYCHEF_ROOT_DIR}/service-shutdown
        install -m 0644 ${S}/startup-list  ${D}/${DEPLOYCHEF_ROOT_DIR}/startup-list
        #Copy the respective services configuration script files and convert them to
        #chefsolo recipes
        install -d ${D}/${ATTRIBUTE_DIR}
        install -m 0644 ${S}/chefsolo_default_attribute.rb  ${D}/${ATTRIBUTE_DIR}/default.rb

        install -d ${D}/${RECIPE_DIR}
        install -m 0644 ${S}/chefsolo_default_recipe.rb  ${D}/${RECIPE_DIR}/default.rb
    fi
}

do_install_append() {
    sed -i s:%DEPLOYCHEF_ROOT_DIR%:${DEPLOYCHEF_ROOT_DIR}:g ${D}/${sysconfdir}/init.d/${BPN}
    #Replace all the place holders in the respective files
    sed -i s:%DEPLOYCHEF_ROOT_DIR%:${DEPLOYCHEF_ROOT_DIR}:g ${D}/${ATTRIBUTE_DIR}default.rb
    sed -i s:%SYSCONFDIR%:${sysconfdir}:g ${D}/${ATTRIBUTE_DIR}default.rb
    sed -i s:%SYSCONFDIR%:${sysconfdir}:g ${D}/${DEPLOYCHEF_ROOT_DIR}/generate-templates
    sed -i s:%DEPLOYCHEF_ROOT_DIR%:${DEPLOYCHEF_ROOT_DIR}:g ${D}/${DEPLOYCHEF_ROOT_DIR}/generate-templates
    #chef-solo requires location of script files to be absolute, provide absolute path
    sed -i s:%DEPLOYCHEF_ROOT_DIR%:${DEPLOYCHEF_ROOT_DIR}:g ${D}/${DEPLOYCHEF_ROOT_DIR}/service-shutdown
    sed -i s:%DEPLOYCHEF_ROOT_DIR%:${DEPLOYCHEF_ROOT_DIR}:g ${D}/${DEPLOYCHEF_ROOT_DIR}/run-postinsts
    sed -i s:%PACKAGE_NAME%:${BPN}:g ${D}/${DEPLOYCHEF_ROOT_DIR}/run-postinsts

    #Populate chefsolo attribute file and
    #Populate deploychef.inc file used in the generation of chefsolo templates
    for file in ${D}/${ATTRIBUTE_DIR}default.rb ${D}/${TEMPLATES_CONF_DIR}/constants.inc; do
        sed -i s:%CONTROLLER_IP%:${CONTROLLER_IP}:g $file
        sed -i s:%CONTROLLER_HOST%:${CONTROLLER_HOST}:g $file
        sed -i s:%COMPUTE_IP%:${COMPUTE_IP}:g $file
        sed -i s:%COMPUTE_HOST%:${COMPUTE_HOST}:g $file
        sed -i s:%ADMIN_PASSWORD%:${ADMIN_PASSWORD}:g $file
        sed -i s:%ADMIN_USER%:${ADMIN_USER}:g $file
        sed -i s:%SERVICE_PASSWORD%:${SERVICE_PASSWORD}:g $file
        sed -i s:%SERVICE_TENANT_NAME%:${SERVICE_TENANT_NAME}:g $file
        sed -i s:%SERVICE_USER%:${SERVICE_USER}:g $file
        sed -i s:%SERVICE_TOKEN%:${SERVICE_TOKEN}:g $file
        sed -i s:%DEMO_USER%:${DEMO_USER}:g $file
        sed -i s:%DEMO_PASSWORD%:${DEMO_PASSWORD}:g $file
        sed -i s:%OS_TENANT_NAME%:${OS_TENANT_NAME}:g $file
        sed -i s:%OS_USERNAME%:${OS_USERNAME}:g $file
        sed -i s:%OS_PASSWORD%:${OS_PASSWORD}:g $file
        sed -i s:%DB_NAME%:${DB_NAME}:g $file
        sed -i s:%DB_USER%:${DB_USER}:g $file
        sed -i s:%DB_PASSWORD%:${DB_PASSWORD}:g $file
    done

    #Replace the rpm-postinsts dir
    for file in "${D}/${ATTRIBUTE_DIR}default.rb \
        ${D}/${DEPLOYCHEF_ROOT_DIR}/run-deploychef \
        ${D}/${DEPLOYCHEF_ROOT_DIR}/generate-templates"; do
        sed -i s:%POSTINSTS_DIR%:${POSTINSTS_DIR}:g $file
    done
}

INITSCRIPT_PACKAGES = "${BPN}"
INITSCRIPT_NAME_${BPN} = "${BPN}"
INITSCRIPT_PARAMS = "start 96 S ."

