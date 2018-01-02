package com.ushareit.listenit;

import android.os.Handler;
import com.facebook.GraphRequest;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class ajp extends OutputStream implements ajs {
    private final Map<GraphRequest, ajt> f4501a = new HashMap();
    private final Handler f4502b;
    private GraphRequest f4503c;
    private ajt f4504d;
    private int f4505e;

    public ajp(Handler handler) {
        this.f4502b = handler;
    }

    public void mo639a(GraphRequest graphRequest) {
        this.f4503c = graphRequest;
        this.f4504d = graphRequest != null ? (ajt) this.f4501a.get(graphRequest) : null;
    }

    public int m5800a() {
        return this.f4505e;
    }

    public Map<GraphRequest, ajt> m5803b() {
        return this.f4501a;
    }

    void m5801a(long j) {
        if (this.f4504d == null) {
            this.f4504d = new ajt(this.f4502b, this.f4503c);
            this.f4501a.put(this.f4503c, this.f4504d);
        }
        this.f4504d.m5812b(j);
        this.f4505e = (int) (((long) this.f4505e) + j);
    }

    public void write(byte[] bArr) {
        m5801a((long) bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        m5801a((long) i2);
    }

    public void write(int i) {
        m5801a(1);
    }
}
