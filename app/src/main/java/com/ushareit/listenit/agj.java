package com.ushareit.listenit;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

class agj extends ProxySelector {
    private static final List<Proxy> f4338a = Arrays.asList(new Proxy[]{Proxy.NO_PROXY});
    private final ProxySelector f4339b;
    private final String f4340c;
    private final int f4341d;

    agj(ProxySelector proxySelector, String str, int i) {
        this.f4339b = (ProxySelector) ago.m5589a((Object) proxySelector);
        this.f4340c = (String) ago.m5589a((Object) str);
        this.f4341d = i;
    }

    static void m5580a(String str, int i) {
        ProxySelector.setDefault(new agj(ProxySelector.getDefault(), str, i));
    }

    public List<Proxy> select(URI uri) {
        Object obj = (this.f4340c.equals(uri.getHost()) && this.f4341d == uri.getPort()) ? 1 : null;
        return obj != null ? f4338a : this.f4339b.select(uri);
    }

    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f4339b.connectFailed(uri, socketAddress, iOException);
    }
}
