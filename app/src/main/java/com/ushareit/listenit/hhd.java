package com.ushareit.listenit;

import android.os.Handler;
import android.os.Message;

class hhd extends Handler {
    final /* synthetic */ hgy f15454a;
    private final int f15455b;
    private boolean f15456c;
    private int f15457d;
    private int f15458e;

    private hhd(hgy com_ushareit_listenit_hgy) {
        this.f15454a = com_ushareit_listenit_hgy;
        this.f15455b = 2;
        this.f15456c = false;
        this.f15457d = 0;
        this.f15458e = 0;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                m23851c();
                return;
            case 1:
                m23852d();
                return;
            case 2:
                int i = this.f15454a.mo2778i();
                if (i == this.f15457d) {
                    this.f15458e++;
                    if (this.f15458e >= 2 && !this.f15456c) {
                        m23851c();
                    }
                } else {
                    this.f15458e = 0;
                    this.f15457d = i;
                    if (this.f15456c) {
                        m23852d();
                    }
                }
                this.f15454a.m23832r();
                return;
            case 3:
                if (this.f15454a.f15447l != null) {
                    this.f15454a.f15447l.onBufferingUpdate(null, message.arg1);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void m23851c() {
        this.f15456c = true;
        this.f15454a.m23717b(true);
        if (this.f15454a.mo2770a()) {
            hgf.m23701d();
        }
    }

    private void m23852d() {
        this.f15456c = false;
        this.f15454a.m23717b(false);
    }

    public void m23853a() {
        if (this.f15456c) {
            this.f15454a.m23831q();
        }
        this.f15456c = false;
        this.f15457d = 0;
        this.f15458e = 0;
    }

    public boolean m23854b() {
        return this.f15456c;
    }
}
