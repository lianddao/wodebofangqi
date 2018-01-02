package com.ushareit.listenit;

import java.util.Map;

public class cvg {
    private final cqq f9198a;
    private final cvd f9199b;

    public cvg(cqq com_ushareit_listenit_cqq, cvd com_ushareit_listenit_cvd) {
        this.f9198a = com_ushareit_listenit_cqq;
        this.f9199b = com_ushareit_listenit_cvd;
    }

    public static cvg m13000a(cqq com_ushareit_listenit_cqq) {
        return new cvg(com_ushareit_listenit_cqq, cvd.f9184a);
    }

    public static cvg m13001a(cqq com_ushareit_listenit_cqq, Map<String, Object> map) {
        return new cvg(com_ushareit_listenit_cqq, cvd.m12977a((Map) map));
    }

    public cqq m13002a() {
        return this.f9198a;
    }

    public cvd m13003b() {
        return this.f9199b;
    }

    public cws m13004c() {
        return this.f9199b.m12992j();
    }

    public boolean m13005d() {
        return this.f9199b.m12996n();
    }

    public boolean m13006e() {
        return this.f9199b.m12995m();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        cvg com_ushareit_listenit_cvg = (cvg) obj;
        return !this.f9198a.equals(com_ushareit_listenit_cvg.f9198a) ? false : this.f9199b.equals(com_ushareit_listenit_cvg.f9199b);
    }

    public int hashCode() {
        return (this.f9198a.hashCode() * 31) + this.f9199b.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.f9198a);
        String valueOf2 = String.valueOf(this.f9199b);
        return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append(":").append(valueOf2).toString();
    }
}
