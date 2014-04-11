INC := "${@int(PRINC) + 1}"

do_install_append() {
    sed -i -e 's/#ServerName.*$/ServerName 127.0.0.1:80/' ${D}${sysconfdir}/apache2/httpd.conf
}
