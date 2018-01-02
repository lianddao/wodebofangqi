package com.ushareit.listenit;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;

public final class btm {
    private final Handler f7723a;
    private final btl f7724b;

    public btm(Handler handler, btl com_ushareit_listenit_btl) {
        this.f7723a = com_ushareit_listenit_btl != null ? (Handler) bsg.m9654a((Object) handler) : null;
        this.f7724b = com_ushareit_listenit_btl;
    }

    public void m9836a(bhe com_ushareit_listenit_bhe) {
        if (this.f7724b != null) {
            this.f7723a.post(new btn(this, com_ushareit_listenit_bhe));
        }
    }

    public void m9837a(String str, long j, long j2) {
        if (this.f7724b != null) {
            this.f7723a.post(new bto(this, str, j, j2));
        }
    }

    public void m9835a(Format format) {
        if (this.f7724b != null) {
            this.f7723a.post(new btp(this, format));
        }
    }

    public void m9833a(int i, long j) {
        if (this.f7724b != null) {
            this.f7723a.post(new btq(this, i, j));
        }
    }

    public void m9832a(int i, int i2, int i3, float f) {
        if (this.f7724b != null) {
            this.f7723a.post(new btr(this, i, i2, i3, f));
        }
    }

    public void m9834a(Surface surface) {
        if (this.f7724b != null) {
            this.f7723a.post(new bts(this, surface));
        }
    }

    public void m9838b(bhe com_ushareit_listenit_bhe) {
        if (this.f7724b != null) {
            this.f7723a.post(new btt(this, com_ushareit_listenit_bhe));
        }
    }
}
