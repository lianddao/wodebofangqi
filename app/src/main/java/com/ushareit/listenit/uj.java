package com.ushareit.listenit;

import com.umeng.analytics.pro.dm;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

class uj extends ByteArrayOutputStream {
    final /* synthetic */ ui f16895a;

    uj(ui uiVar, int i) {
        this.f16895a = uiVar;
        super(i);
    }

    public String toString() {
        int i = (this.count <= 0 || this.buf[this.count - 1] != dm.f3661k) ? this.count : this.count - 1;
        try {
            return new String(this.buf, 0, i, this.f16895a.f16891b.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
