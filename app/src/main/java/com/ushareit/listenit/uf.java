package com.ushareit.listenit;

import java.io.File;
import java.io.IOException;

public final class uf {
    final /* synthetic */ ud f16873a;
    private final ug f16874b;
    private final boolean[] f16875c;
    private boolean f16876d;

    private uf(ud udVar, ug ugVar) {
        this.f16873a = udVar;
        this.f16874b = ugVar;
        this.f16875c = ugVar.f16882f ? null : new boolean[udVar.f16865h];
    }

    public File m26524a(int i) {
        File b;
        synchronized (this.f16873a) {
            if (this.f16874b.f16883g != this) {
                throw new IllegalStateException();
            }
            if (!this.f16874b.f16882f) {
                this.f16875c[i] = true;
            }
            b = this.f16874b.m26541b(i);
            if (!this.f16873a.f16859b.exists()) {
                this.f16873a.f16859b.mkdirs();
            }
        }
        return b;
    }

    public void m26525a() {
        this.f16873a.m26502a(this, true);
        this.f16876d = true;
    }

    public void m26526b() {
        this.f16873a.m26502a(this, false);
    }

    public void m26527c() {
        if (!this.f16876d) {
            try {
                m26526b();
            } catch (IOException e) {
            }
        }
    }
}
