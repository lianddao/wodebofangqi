package com.ushareit.listenit;

import java.io.InputStream;
import org.apache.http.HttpResponse;

class ezh extends ezq {
    final /* synthetic */ ezf f12237a;
    private final HttpResponse f12238c;

    ezh(ezf com_ushareit_listenit_ezf, HttpResponse httpResponse) {
        this.f12237a = com_ushareit_listenit_ezf;
        this.f12238c = httpResponse;
        this.b = ezm.m18634a(this.f12238c);
    }

    public long mo2342a() {
        return this.f12238c.getEntity().getContentLength();
    }

    public InputStream mo2343b() {
        return this.f12238c.getEntity().getContent();
    }

    public int mo2344c() {
        return this.f12238c.getStatusLine().getStatusCode();
    }
}
