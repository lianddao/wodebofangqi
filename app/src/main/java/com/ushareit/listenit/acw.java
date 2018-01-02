package com.ushareit.listenit;

import java.io.InputStream;

public class acw implements ux<InputStream, acq> {
    private final ux<yv, acq> f4142a;

    public acw(ux<yv, acq> uxVar) {
        this.f4142a = uxVar;
    }

    public wk<acq> m5247a(InputStream inputStream, int i, int i2) {
        return this.f4142a.mo565a(new yv(inputStream, null), i, i2);
    }

    public String mo566a() {
        return this.f4142a.mo566a();
    }
}
