package com.ushareit.listenit;

import android.os.Handler;
import com.facebook.GraphRequest;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.Map;

public class ajq extends FilterOutputStream implements ajs {
    private final Map<GraphRequest, ajt> f4506a;
    private final aje f4507b;
    private final long f4508c = ail.m5716g();
    private long f4509d;
    private long f4510e;
    private long f4511f;
    private ajt f4512g;

    public ajq(OutputStream outputStream, aje com_ushareit_listenit_aje, Map<GraphRequest, ajt> map, long j) {
        super(outputStream);
        this.f4507b = com_ushareit_listenit_aje;
        this.f4506a = map;
        this.f4511f = j;
    }

    private void m5806a(long j) {
        if (this.f4512g != null) {
            this.f4512g.m5811a(j);
        }
        this.f4509d += j;
        if (this.f4509d >= this.f4510e + this.f4508c || this.f4509d >= this.f4511f) {
            m5805a();
        }
    }

    private void m5805a() {
        if (this.f4509d > this.f4510e) {
            for (ajf com_ushareit_listenit_ajf : this.f4507b.m5763e()) {
                if (com_ushareit_listenit_ajf instanceof ajg) {
                    Handler c = this.f4507b.m5761c();
                    ajg com_ushareit_listenit_ajg = (ajg) com_ushareit_listenit_ajf;
                    if (c == null) {
                        com_ushareit_listenit_ajg.m5769a(this.f4507b, this.f4509d, this.f4511f);
                    } else {
                        c.post(new ajr(this, com_ushareit_listenit_ajg));
                    }
                }
            }
            this.f4510e = this.f4509d;
        }
    }

    public void mo639a(GraphRequest graphRequest) {
        this.f4512g = graphRequest != null ? (ajt) this.f4506a.get(graphRequest) : null;
    }

    public void write(byte[] bArr) {
        this.out.write(bArr);
        m5806a((long) bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.out.write(bArr, i, i2);
        m5806a((long) i2);
    }

    public void write(int i) {
        this.out.write(i);
        m5806a(1);
    }

    public void close() {
        super.close();
        for (ajt a : this.f4506a.values()) {
            a.m5810a();
        }
        m5805a();
    }
}
