package com.ushareit.listenit;

import com.mopub.volley.CacheDispatcher;
import com.mopub.volley.Request;

public class eos implements Runnable {
    final /* synthetic */ Request f11401a;
    final /* synthetic */ CacheDispatcher f11402b;

    public eos(CacheDispatcher cacheDispatcher, Request request) {
        this.f11402b = cacheDispatcher;
        this.f11401a = request;
    }

    public void run() {
        try {
            this.f11402b.f2873c.put(this.f11401a);
        } catch (InterruptedException e) {
        }
    }
}
