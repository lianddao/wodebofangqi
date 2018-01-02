package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Map;

class wu<K extends xb, V> {
    private final wv<K, V> f17491a = new wv();
    private final Map<K, wv<K, V>> f17492b = new HashMap();

    wu() {
    }

    public void m27156a(K k, V v) {
        wv wvVar = (wv) this.f17492b.get(k);
        if (wvVar == null) {
            wvVar = new wv(k);
            m27151b(wvVar);
            this.f17492b.put(k, wvVar);
        } else {
            k.mo3126a();
        }
        wvVar.m27159a((Object) v);
    }

    public V m27155a(K k) {
        wv wvVar = (wv) this.f17492b.get(k);
        if (wvVar == null) {
            wvVar = new wv(k);
            this.f17492b.put(k, wvVar);
        } else {
            k.mo3126a();
        }
        m27150a(wvVar);
        return wvVar.m27158a();
    }

    public V m27154a() {
        for (wv wvVar = this.f17491a.f17494b; !wvVar.equals(this.f17491a); wvVar = wvVar.f17494b) {
            V a = wvVar.m27158a();
            if (a != null) {
                return a;
            }
            m27153d(wvVar);
            this.f17492b.remove(wvVar.f17495c);
            ((xb) wvVar.f17495c).mo3126a();
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("GroupedLinkedMap( ");
        Object obj = null;
        for (wv wvVar = this.f17491a.f17493a; !wvVar.equals(this.f17491a); wvVar = wvVar.f17493a) {
            obj = 1;
            stringBuilder.append('{').append(wvVar.f17495c).append(':').append(wvVar.m27160b()).append("}, ");
        }
        if (obj != null) {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }
        return stringBuilder.append(" )").toString();
    }

    private void m27150a(wv<K, V> wvVar) {
        m27153d(wvVar);
        wvVar.f17494b = this.f17491a;
        wvVar.f17493a = this.f17491a.f17493a;
        m27152c(wvVar);
    }

    private void m27151b(wv<K, V> wvVar) {
        m27153d(wvVar);
        wvVar.f17494b = this.f17491a.f17494b;
        wvVar.f17493a = this.f17491a;
        m27152c(wvVar);
    }

    private static <K, V> void m27152c(wv<K, V> wvVar) {
        wvVar.f17493a.f17494b = wvVar;
        wvVar.f17494b.f17493a = wvVar;
    }

    private static <K, V> void m27153d(wv<K, V> wvVar) {
        wvVar.f17494b.f17493a = wvVar.f17493a;
        wvVar.f17493a.f17494b = wvVar.f17494b;
    }
}
