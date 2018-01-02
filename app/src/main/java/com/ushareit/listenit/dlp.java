package com.ushareit.listenit;

public final class dlp<O extends cdk> {
    private final boolean f9888a = false;
    private final int f9889b;
    private final cdj<O> f9890c;
    private final O f9891d;

    private dlp(cdj<O> com_ushareit_listenit_cdj_O, O o) {
        this.f9890c = com_ushareit_listenit_cdj_O;
        this.f9891d = o;
        this.f9889b = cff.m11076a(this.f9890c, this.f9891d);
    }

    public static <O extends cdk> dlp<O> m14789a(cdj<O> com_ushareit_listenit_cdj_O, O o) {
        return new dlp(com_ushareit_listenit_cdj_O, o);
    }

    public String m14790a() {
        return this.f9890c.m10913f();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof dlp)) {
            return false;
        }
        dlp com_ushareit_listenit_dlp = (dlp) obj;
        return cff.m11078a(this.f9890c, com_ushareit_listenit_dlp.f9890c) && cff.m11078a(this.f9891d, com_ushareit_listenit_dlp.f9891d);
    }

    public int hashCode() {
        return this.f9889b;
    }
}
