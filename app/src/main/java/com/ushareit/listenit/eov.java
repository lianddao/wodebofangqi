package com.ushareit.listenit;

import com.mopub.volley.Request;

public class eov implements Runnable {
    final /* synthetic */ String f11409a;
    final /* synthetic */ long f11410b;
    final /* synthetic */ Request f11411c;

    public eov(Request request, String str, long j) {
        this.f11411c = request;
        this.f11409a = str;
        this.f11410b = j;
    }

    public void run() {
        this.f11411c.f2716a.add(this.f11409a, this.f11410b);
        this.f11411c.f2716a.finish(toString());
    }
}
