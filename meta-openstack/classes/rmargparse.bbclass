do_install:append() {
    sed -i '/argparse/d' ${D}${libdir}/python3/site-packages/*/requires.txt
}
