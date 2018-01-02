package com.ushareit.listenit;

import android.os.Bundle;
import com.facebook.share.model.ShareMedia;

public abstract class bcu<M extends ShareMedia, B extends bcu> {
    private Bundle f5913a = new Bundle();

    @Deprecated
    public B m7775a(Bundle bundle) {
        this.f5913a.putAll(bundle);
        return this;
    }

    public B mo850a(M m) {
        return m == null ? this : m7775a(m.m1969a());
    }
}
