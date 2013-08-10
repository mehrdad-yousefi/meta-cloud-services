# conflicting file prevention
do_install_append() {
	rm -f ${D}${libdir}/python*/site-packages/site.py*
}