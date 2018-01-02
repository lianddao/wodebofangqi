package com.ushareit.listenit;

public class cua {
    public final long f8980a;
    public final cvg f8981b;
    public final long f8982c;
    public final boolean f8983d;
    public final boolean f8984e;

    public cua(long j, cvg com_ushareit_listenit_cvg, long j2, boolean z, boolean z2) {
        this.f8980a = j;
        if (!com_ushareit_listenit_cvg.m13006e() || com_ushareit_listenit_cvg.m13005d()) {
            this.f8981b = com_ushareit_listenit_cvg;
            this.f8982c = j2;
            this.f8983d = z;
            this.f8984e = z2;
            return;
        }
        throw new IllegalArgumentException("Can't create TrackedQuery for a non-default query that loads all data");
    }

    public cua m12698a() {
        return new cua(this.f8980a, this.f8981b, this.f8982c, true, this.f8984e);
    }

    public cua m12699a(long j) {
        return new cua(this.f8980a, this.f8981b, j, this.f8983d, this.f8984e);
    }

    public cua m12700a(boolean z) {
        return new cua(this.f8980a, this.f8981b, this.f8982c, this.f8983d, z);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        cua com_ushareit_listenit_cua = (cua) obj;
        return this.f8980a == com_ushareit_listenit_cua.f8980a && this.f8981b.equals(com_ushareit_listenit_cua.f8981b) && this.f8982c == com_ushareit_listenit_cua.f8982c && this.f8983d == com_ushareit_listenit_cua.f8983d && this.f8984e == com_ushareit_listenit_cua.f8984e;
    }

    public int hashCode() {
        return (((((((Long.valueOf(this.f8980a).hashCode() * 31) + this.f8981b.hashCode()) * 31) + Long.valueOf(this.f8982c).hashCode()) * 31) + Boolean.valueOf(this.f8983d).hashCode()) * 31) + Boolean.valueOf(this.f8984e).hashCode();
    }

    public String toString() {
        long j = this.f8980a;
        String valueOf = String.valueOf(this.f8981b);
        long j2 = this.f8982c;
        boolean z = this.f8983d;
        return new StringBuilder(String.valueOf(valueOf).length() + 109).append("TrackedQuery{id=").append(j).append(", querySpec=").append(valueOf).append(", lastUse=").append(j2).append(", complete=").append(z).append(", active=").append(this.f8984e).append("}").toString();
    }
}
