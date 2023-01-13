do_install:append() {
    sed -i '/argparse/d' ${D}${libdir}/python3.10/site-packages/*/requires.txt
}
