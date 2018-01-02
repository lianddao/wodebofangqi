package com.ushareit.listenit;

import android.content.SharedPreferences.Editor;
import android.util.Pair;

public final class dxv {
    final String f10620a;
    final /* synthetic */ dxr f10621b;
    private final String f10622c;
    private final String f10623d;
    private final long f10624e;

    private dxv(dxr com_ushareit_listenit_dxr, String str, long j) {
        this.f10621b = com_ushareit_listenit_dxr;
        cfi.m11082a(str);
        cfi.m11089b(j > 0);
        this.f10620a = String.valueOf(str).concat(":start");
        this.f10622c = String.valueOf(str).concat(":count");
        this.f10623d = String.valueOf(str).concat(":value");
        this.f10624e = j;
    }

    private void m16330b() {
        this.f10621b.mo2083j();
        long a = this.f10621b.mo2089p().mo1370a();
        Editor edit = this.f10621b.f10605o.edit();
        edit.remove(this.f10622c);
        edit.remove(this.f10623d);
        edit.putLong(this.f10620a, a);
        edit.apply();
    }

    private long m16331c() {
        this.f10621b.mo2083j();
        long d = m16332d();
        if (d != 0) {
            return Math.abs(d - this.f10621b.mo2089p().mo1370a());
        }
        m16330b();
        return 0;
    }

    private long m16332d() {
        return this.f10621b.m16306F().getLong(this.f10620a, 0);
    }

    public Pair<String, Long> m16333a() {
        this.f10621b.mo2083j();
        long c = m16331c();
        if (c < this.f10624e) {
            return null;
        }
        if (c > this.f10624e * 2) {
            m16330b();
            return null;
        }
        String string = this.f10621b.m16306F().getString(this.f10623d, null);
        c = this.f10621b.m16306F().getLong(this.f10622c, 0);
        m16330b();
        return (string == null || c <= 0) ? dxr.f10592a : new Pair(string, Long.valueOf(c));
    }

    public void m16334a(String str) {
        m16335a(str, 1);
    }

    public void m16335a(String str, long j) {
        this.f10621b.mo2083j();
        if (m16332d() == 0) {
            m16330b();
        }
        if (str == null) {
            str = "";
        }
        long j2 = this.f10621b.f10605o.getLong(this.f10622c, 0);
        if (j2 <= 0) {
            Editor edit = this.f10621b.f10605o.edit();
            edit.putString(this.f10623d, str);
            edit.putLong(this.f10622c, j);
            edit.apply();
            return;
        }
        Object obj = (this.f10621b.m16305E().nextLong() & Long.MAX_VALUE) < (Long.MAX_VALUE / (j2 + j)) * j ? 1 : null;
        Editor edit2 = this.f10621b.f10605o.edit();
        if (obj != null) {
            edit2.putString(this.f10623d, str);
        }
        edit2.putLong(this.f10622c, j2 + j);
        edit2.apply();
    }
}
