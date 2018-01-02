package com.ushareit.listenit;

public final class fcx {
    public static void m18875a(String str, eyh com_ushareit_listenit_eyh) {
        if (!com_ushareit_listenit_eyh.mo2328c()) {
            ezs com_ushareit_listenit_ezs = null;
            int i = 0;
            while (i < 3) {
                try {
                    ezi com_ushareit_listenit_ezi = new ezi(str, com_ushareit_listenit_eyh, true);
                    com_ushareit_listenit_ezi.m18621a(null, null);
                    if (!com_ushareit_listenit_ezi.m18625a()) {
                        throw new ezs(2, "remote thumbnail download failed!");
                    }
                    return;
                } catch (ezs e) {
                    com_ushareit_listenit_ezs = e;
                    exw.m18457e("RemoteThumbnailLoader", "doDownloadThumbnail(): File: " + com_ushareit_listenit_eyh + ", Retry count:" + i + " and exception:" + com_ushareit_listenit_ezs.toString());
                    i++;
                }
            }
            if (com_ushareit_listenit_ezs != null) {
                throw new fci(com_ushareit_listenit_ezs.mo2345a(), com_ushareit_listenit_ezs.getMessage());
            }
        }
    }
}
