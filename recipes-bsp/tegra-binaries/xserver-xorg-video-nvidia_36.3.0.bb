L4T_DEB_COPYRIGHT_MD5 = "d3617777039321a257aef01439341b02"
DEPENDS = "tegra-libraries-core tegra-libraries-glxcore"

L4T_DEB_TRANSLATED_BPN = "nvidia-l4t-3d-core"

require tegra-debian-libraries-common.inc

MAINSUM = "a202ea5f467836eed8466faa7541dec3521c4d1668ca097cea3eee0dfc52cab6"

do_install() {
    install -d ${D}${libdir}/xorg/modules/drivers
    install -m 0644 ${S}/usr/lib/xorg/modules/drivers/nvidia_drv.so ${D}${libdir}/xorg/modules/drivers/
    install -d ${D}${libdir}/xorg/modules/extensions
    install -m 0644 ${S}/usr/lib/xorg/modules/extensions/libglxserver_nvidia.so ${D}${libdir}/xorg/modules/extensions/
}

PACKAGES = "${PN}"
FILES:${PN} = "${libdir}"
RDEPENDS:${PN} += "tegra-configs-xorg"
RPROVIDES:${PN} += "xserver-xorg-extension-glx"
RCONFLICTS:${PN} = "xserver-xorg-extension-glx"

INSANE_SKIP:${PN} = "dev-so textrel ldflags xorg-driver-abi"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
