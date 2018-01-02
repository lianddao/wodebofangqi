package com.ushareit.listenit;

import android.content.SharedPreferences.Editor;

public final class dxt {
    final /* synthetic */ dxr f10610a;
    private final String f10611b;
    private final boolean f10612c;
    private boolean f10613d;
    private boolean f10614e;

    public dxt(dxr com_ushareit_listenit_dxr, String str, boolean z) {
        this.f10610a = com_ushareit_listenit_dxr;
        cfi.m11082a(str);
        this.f10611b = str;
        this.f10612c = z;
    }

    private void m16324b() {
        if (!this.f10613d) {
            this.f10613d = true;
            this.f10614e = this.f10610a.f10605o.getBoolean(this.f10611b, this.f10612c);
        }
    }

    public void m16325a(boolean z) {
        Editor edit = this.f10610a.f10605o.edit();
        edit.putBoolean(this.f10611b, z);
        edit.apply();
        this.f10614e = z;
    }

    public boolean m16326a() {
        m16324b();
        return this.f10614e;
    }
}
