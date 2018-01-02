package com.ushareit.listenit;

public class cyz {
    private String f9388a;

    public cyz(String str) {
        this.f9388a = str;
    }

    public String m13445a() {
        return this.f9388a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof cyz)) {
            return false;
        }
        return cff.m11078a(this.f9388a, ((cyz) obj).f9388a);
    }

    public int hashCode() {
        return cff.m11076a(this.f9388a);
    }

    public String toString() {
        return cff.m11077a((Object) this).m11079a("token", this.f9388a).toString();
    }
}
