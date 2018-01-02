package com.ushareit.listenit;

import java.lang.reflect.Array;

public class dgd<M extends dgc<M>, T> {
    protected final int f9762a;
    protected final Class<T> f9763b;
    public final int f9764c;
    protected final boolean f9765d;

    int m14219a(Object obj) {
        return this.f9765d ? m14221b(obj) : m14223c(obj);
    }

    void m14220a(Object obj, dga com_ushareit_listenit_dga) {
        if (this.f9765d) {
            m14224c(obj, com_ushareit_listenit_dga);
        } else {
            m14222b(obj, com_ushareit_listenit_dga);
        }
    }

    protected int m14221b(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += m14223c(Array.get(obj, i2));
            }
        }
        return i;
    }

    protected void m14222b(Object obj, dga com_ushareit_listenit_dga) {
        try {
            com_ushareit_listenit_dga.m14215e(this.f9764c);
            switch (this.f9762a) {
                case 10:
                    dgi com_ushareit_listenit_dgi = (dgi) obj;
                    int b = dgl.m14264b(this.f9764c);
                    com_ushareit_listenit_dga.m14201a(com_ushareit_listenit_dgi);
                    com_ushareit_listenit_dga.m14211c(b, 4);
                    return;
                case 11:
                    com_ushareit_listenit_dga.m14207b((dgi) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.f9762a);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    protected int m14223c(Object obj) {
        int b = dgl.m14264b(this.f9764c);
        switch (this.f9762a) {
            case 10:
                return dga.m14168b(b, (dgi) obj);
            case 11:
                return dga.m14175c(b, (dgi) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.f9762a);
        }
    }

    protected void m14224c(Object obj, dga com_ushareit_listenit_dga) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                m14222b(obj2, com_ushareit_listenit_dga);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dgd)) {
            return false;
        }
        dgd com_ushareit_listenit_dgd = (dgd) obj;
        return this.f9762a == com_ushareit_listenit_dgd.f9762a && this.f9763b == com_ushareit_listenit_dgd.f9763b && this.f9764c == com_ushareit_listenit_dgd.f9764c && this.f9765d == com_ushareit_listenit_dgd.f9765d;
    }

    public int hashCode() {
        return (this.f9765d ? 1 : 0) + ((((((this.f9762a + 1147) * 31) + this.f9763b.hashCode()) * 31) + this.f9764c) * 31);
    }
}
