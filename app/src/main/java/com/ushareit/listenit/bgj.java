package com.ushareit.listenit;

import android.os.Handler;
import com.google.android.exoplayer2.Format;

public final class bgj {
    private final Handler f6180a;
    private final bgi f6181b;

    public bgj(Handler handler, bgi com_ushareit_listenit_bgi) {
        this.f6180a = com_ushareit_listenit_bgi != null ? (Handler) bsg.m9654a((Object) handler) : null;
        this.f6181b = com_ushareit_listenit_bgi;
    }

    public void m8243a(bhe com_ushareit_listenit_bhe) {
        if (this.f6181b != null) {
            this.f6180a.post(new bgk(this, com_ushareit_listenit_bhe));
        }
    }

    public void m8244a(String str, long j, long j2) {
        if (this.f6181b != null) {
            this.f6180a.post(new bgl(this, str, j, j2));
        }
    }

    public void m8242a(Format format) {
        if (this.f6181b != null) {
            this.f6180a.post(new bgm(this, format));
        }
    }

    public void m8241a(int i, long j, long j2) {
        if (this.f6181b != null) {
            this.f6180a.post(new bgn(this, i, j, j2));
        }
    }

    public void m8245b(bhe com_ushareit_listenit_bhe) {
        if (this.f6181b != null) {
            this.f6180a.post(new bgo(this, com_ushareit_listenit_bhe));
        }
    }

    public void m8240a(int i) {
        if (this.f6181b != null) {
            this.f6180a.post(new bgp(this, i));
        }
    }
}
