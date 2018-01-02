package com.ushareit.listenit;

import org.apache.http.client.methods.HttpGet;

class ezg extends ezp {
    final /* synthetic */ ezf f12235a;
    private HttpGet f12236b = null;

    public ezg(ezf com_ushareit_listenit_ezf, String str) {
        this.f12235a = com_ushareit_listenit_ezf;
        this.f12236b = new HttpGet(str);
    }

    HttpGet m18607b() {
        return this.f12236b;
    }

    public void mo2341a() {
        this.f12236b.abort();
    }
}
