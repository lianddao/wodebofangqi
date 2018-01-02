package com.ushareit.listenit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class fzw implements vc<InputStream> {
    private vc<InputStream> f13790a;
    private byte[] f13791b;
    private zh f13792c = new zh();

    public /* synthetic */ Object mo584a(tv tvVar) {
        return m21452b(tvVar);
    }

    public fzw(vc<InputStream> vcVar) {
        this.f13790a = vcVar;
    }

    public InputStream m21452b(tv tvVar) {
        if (this.f13791b != null) {
            return new ByteArrayInputStream(this.f13791b);
        }
        this.f13791b = m21449c(tvVar);
        return this.f13791b != null ? new ByteArrayInputStream(this.f13791b) : null;
    }

    private byte[] m21449c(tv tvVar) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (this.f13792c.m27283a((InputStream) this.f13790a.mo584a(tvVar), byteArrayOutputStream)) {
            return byteArrayOutputStream.toByteArray();
        }
        byteArrayOutputStream.close();
        return null;
    }

    public int m21455d() {
        return this.f13791b != null ? this.f13791b.length : 0;
    }

    public void mo585a() {
        this.f13790a.mo585a();
    }

    public String mo586b() {
        return this.f13790a.mo586b();
    }

    public void mo587c() {
        this.f13790a.mo587c();
    }
}
