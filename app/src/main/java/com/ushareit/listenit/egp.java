package com.ushareit.listenit;

import com.umeng.analytics.pro.dm;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

class egp extends ByteArrayOutputStream {
    final /* synthetic */ ego f11049a;

    egp(ego com_ushareit_listenit_ego, int i) {
        this.f11049a = com_ushareit_listenit_ego;
        super(i);
    }

    public String toString() {
        int i = (this.count <= 0 || this.buf[this.count - 1] != dm.f3661k) ? this.count : this.count - 1;
        try {
            return new String(this.buf, 0, i, this.f11049a.f11045b.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
