package com.ushareit.listenit;

class dor implements Runnable {
    final /* synthetic */ dod f10100a;
    final /* synthetic */ String f10101b;
    final /* synthetic */ doq f10102c;

    dor(doq com_ushareit_listenit_doq, dod com_ushareit_listenit_dod, String str) {
        this.f10102c = com_ushareit_listenit_doq;
        this.f10100a = com_ushareit_listenit_dod;
        this.f10101b = str;
    }

    public void run() {
        if (this.f10102c.f10098c >= 1) {
            this.f10100a.mo1948a(this.f10102c.f10099d != null ? this.f10102c.f10099d.getBundle(this.f10101b) : null);
        }
        if (this.f10102c.f10098c >= 2) {
            this.f10100a.mo1949b();
        }
        if (this.f10102c.f10098c >= 3) {
            this.f10100a.mo1671a();
        }
        if (this.f10102c.f10098c >= 4) {
            this.f10100a.m13528f();
        }
    }
}
