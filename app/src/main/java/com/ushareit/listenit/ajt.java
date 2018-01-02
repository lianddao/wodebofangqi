package com.ushareit.listenit;

import android.os.Handler;
import com.facebook.GraphRequest;

class ajt {
    private final GraphRequest f4515a;
    private final Handler f4516b;
    private final long f4517c = ail.m5716g();
    private long f4518d;
    private long f4519e;
    private long f4520f;

    ajt(Handler handler, GraphRequest graphRequest) {
        this.f4515a = graphRequest;
        this.f4516b = handler;
    }

    void m5811a(long j) {
        this.f4518d += j;
        if (this.f4518d >= this.f4519e + this.f4517c || this.f4518d >= this.f4520f) {
            m5810a();
        }
    }

    void m5812b(long j) {
        this.f4520f += j;
    }

    void m5810a() {
        if (this.f4518d > this.f4519e) {
            aix e = this.f4515a.m771e();
            if (this.f4520f > 0 && (e instanceof aja)) {
                long j = this.f4518d;
                long j2 = this.f4520f;
                aja com_ushareit_listenit_aja = (aja) e;
                if (this.f4516b == null) {
                    com_ushareit_listenit_aja.m5734a(j, j2);
                } else {
                    this.f4516b.post(new aju(this, com_ushareit_listenit_aja, j, j2));
                }
                this.f4519e = this.f4518d;
            }
        }
    }
}
