require recipes-kernel/linux/linux-qoriq.inc

LINUX_VERSION = "5.10.52"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46 \
                    file://LICENSES/preferred/GPL-2.0;md5=e6a75371ba4d16749254a51215d13f97"
SRC_URI = "git://source.codeaurora.org/external/qoriq/qoriq-components/linux;nobranch=1"
SRCREV = "a11753a89ec610768301d4070e10b8bd60fde8cd"
