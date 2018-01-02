package com.ushareit.listenit;

import android.os.Bundle;
import com.facebook.share.model.ShareOpenGraphValueContainer;

public abstract class bcz<P extends ShareOpenGraphValueContainer, E extends bcz> {
    private Bundle f5914a = new Bundle();

    public E m7781a(String str, String str2) {
        this.f5914a.putString(str, str2);
        return this;
    }

    public E mo849a(P p) {
        if (p != null) {
            this.f5914a.putAll(p.m1971b());
        }
        return this;
    }
}
