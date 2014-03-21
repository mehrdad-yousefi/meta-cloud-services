FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PRINC := "${@int(PRINC) + 1}"

SRC_URI += " \
        file://readline-switch-to-new-style-readline-typedef.patch \
        "
