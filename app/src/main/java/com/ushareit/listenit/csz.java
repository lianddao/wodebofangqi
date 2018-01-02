package com.ushareit.listenit;

public class csz {
    private final long f8912a;
    private final cqq f8913b;
    private final cxa f8914c;
    private final cpz f8915d;
    private final boolean f8916e;

    public csz(long j, cqq com_ushareit_listenit_cqq, cpz com_ushareit_listenit_cpz) {
        this.f8912a = j;
        this.f8913b = com_ushareit_listenit_cqq;
        this.f8914c = null;
        this.f8915d = com_ushareit_listenit_cpz;
        this.f8916e = true;
    }

    public csz(long j, cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa, boolean z) {
        this.f8912a = j;
        this.f8913b = com_ushareit_listenit_cqq;
        this.f8914c = com_ushareit_listenit_cxa;
        this.f8915d = null;
        this.f8916e = z;
    }

    public long m12551a() {
        return this.f8912a;
    }

    public cqq m12552b() {
        return this.f8913b;
    }

    public cxa m12553c() {
        if (this.f8914c != null) {
            return this.f8914c;
        }
        throw new IllegalArgumentException("Can't access overwrite when write is a merge!");
    }

    public cpz m12554d() {
        if (this.f8915d != null) {
            return this.f8915d;
        }
        throw new IllegalArgumentException("Can't access merge when write is an overwrite!");
    }

    public boolean m12555e() {
        return this.f8914c != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        csz com_ushareit_listenit_csz = (csz) obj;
        if (this.f8912a != com_ushareit_listenit_csz.f8912a) {
            return false;
        }
        if (!this.f8913b.equals(com_ushareit_listenit_csz.f8913b)) {
            return false;
        }
        if (this.f8916e != com_ushareit_listenit_csz.f8916e) {
            return false;
        }
        if (!this.f8914c == null ? this.f8914c.equals(com_ushareit_listenit_csz.f8914c) : com_ushareit_listenit_csz.f8914c == null) {
            return false;
        }
        if (this.f8915d != null) {
            if (this.f8915d.equals(com_ushareit_listenit_csz.f8915d)) {
                return true;
            }
        } else if (com_ushareit_listenit_csz.f8915d == null) {
            return true;
        }
        return false;
    }

    public boolean m12556f() {
        return this.f8916e;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f8914c != null ? this.f8914c.hashCode() : 0) + (((((Long.valueOf(this.f8912a).hashCode() * 31) + Boolean.valueOf(this.f8916e).hashCode()) * 31) + this.f8913b.hashCode()) * 31)) * 31;
        if (this.f8915d != null) {
            i = this.f8915d.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        long j = this.f8912a;
        String valueOf = String.valueOf(this.f8913b);
        boolean z = this.f8916e;
        String valueOf2 = String.valueOf(this.f8914c);
        String valueOf3 = String.valueOf(this.f8915d);
        return new StringBuilder(((String.valueOf(valueOf).length() + 78) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append("UserWriteRecord{id=").append(j).append(" path=").append(valueOf).append(" visible=").append(z).append(" overwrite=").append(valueOf2).append(" merge=").append(valueOf3).append("}").toString();
    }
}
