package com.ushareit.listenit;

import android.content.SharedPreferences.Editor;

public final class dxu {
    final /* synthetic */ dxr f10615a;
    private final String f10616b;
    private final long f10617c;
    private boolean f10618d;
    private long f10619e;

    public dxu(dxr com_ushareit_listenit_dxr, String str, long j) {
        this.f10615a = com_ushareit_listenit_dxr;
        cfi.m11082a(str);
        this.f10616b = str;
        this.f10617c = j;
    }

    private void m16327b() {
        if (!this.f10618d) {
            this.f10618d = true;
            this.f10619e = this.f10615a.f10605o.getLong(this.f10616b, this.f10617c);
        }
    }

    public long m16328a() {
        m16327b();
        return this.f10619e;
    }

    public void m16329a(long j) {
        Editor edit = this.f10615a.f10605o.edit();
        edit.putLong(this.f10616b, j);
        edit.apply();
        this.f10619e = j;
    }
}
