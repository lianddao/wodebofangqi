package com.ushareit.listenit;

import com.facebook.internal.bl;
import com.facebook.internal.cb;
import com.facebook.login.C0119a;
import com.facebook.login.C0125g;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class azz {
    private C0119a f5757a = C0119a.FRIENDS;
    private List<String> f5758b = Collections.emptyList();
    private bl f5759c = null;
    private C0125g f5760d = C0125g.NATIVE_WITH_FALLBACK;

    public void m7473a(C0119a c0119a) {
        this.f5757a = c0119a;
    }

    public C0119a m7472a() {
        return this.f5757a;
    }

    public void m7475a(List<String> list) {
        if (bl.PUBLISH.equals(this.f5759c)) {
            throw new UnsupportedOperationException("Cannot call setReadPermissions after setPublishPermissions has been called.");
        }
        this.f5758b = list;
        this.f5759c = bl.READ;
    }

    public void m7477b(List<String> list) {
        if (bl.READ.equals(this.f5759c)) {
            throw new UnsupportedOperationException("Cannot call setPublishPermissions after setReadPermissions has been called.");
        } else if (cb.m1592a((Collection) list)) {
            throw new IllegalArgumentException("Permissions for publish actions cannot be null or empty.");
        } else {
            this.f5758b = list;
            this.f5759c = bl.PUBLISH;
        }
    }

    public List<String> m7476b() {
        return this.f5758b;
    }

    public void m7474a(C0125g c0125g) {
        this.f5760d = c0125g;
    }

    public C0125g m7478c() {
        return this.f5760d;
    }
}
