INC := "${@int(PRINC) + 1}"

RRECOMMENDS_${PN} += "kernel-module-xt-conntrack \
                      kernel-module-xt-redirect \
                      "
