package com.ushareit.listenit;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class vb implements vc<InputStream> {
    private final byte[] f17028a;
    private final String f17029b;

    public /* synthetic */ Object mo584a(tv tvVar) {
        return m26677b(tvVar);
    }

    public vb(byte[] bArr, String str) {
        this.f17028a = bArr;
        this.f17029b = str;
    }

    public InputStream m26677b(tv tvVar) {
        return new ByteArrayInputStream(this.f17028a);
    }

    public void mo585a() {
    }

    public String mo586b() {
        return this.f17029b;
    }

    public void mo587c() {
    }
}
