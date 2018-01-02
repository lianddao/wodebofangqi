package com.ushareit.listenit;

import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

class ezd extends ezp {
    final /* synthetic */ ezc f12231a;

    public ezd(ezc com_ushareit_listenit_ezc, String str) {
        this.f12231a = com_ushareit_listenit_ezc;
        try {
            com_ushareit_listenit_ezc.f12227c = (HttpURLConnection) new URL(str).openConnection(Proxy.NO_PROXY);
            com_ushareit_listenit_ezc.f12227c.setConnectTimeout(com_ushareit_listenit_ezc.a);
            com_ushareit_listenit_ezc.f12227c.setReadTimeout(com_ushareit_listenit_ezc.b);
        } catch (Exception e) {
        }
    }

    public void mo2341a() {
        this.f12231a.f12227c.disconnect();
    }
}
