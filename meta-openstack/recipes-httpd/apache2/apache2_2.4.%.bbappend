do_install_append() {
    sed -i -e 's/#ServerName.*$/ServerName 127.0.0.1:80/' ${D}${sysconfdir}/apache2/httpd.conf
    # Keep our logs together, also matches ubuntu and debian
    sed -i -e 's@^\(.*\)/var/apache2/logs\(.*\)$@\1/var/log/apache2\2@g' ${D}${sysconfdir}/apache2/httpd.conf

    # default layout for htdocsdir in 2.4.7 is different, create the following for
    # backward compatibility reasons

    mkdir -p ${D}${datadir}/${BPN}/default-site
    ln -sf ../htdocs ${D}${datadir}/${BPN}/default-site/htdocs
}

FILES_${PN} += "${datadir}/${BPN}/default-site"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"
