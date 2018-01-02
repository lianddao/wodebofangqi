package com.ushareit.listenit;

public final class cdj<O extends cdk> {
    private final cdp<?, O> f8153a;
    private final cdw<?, O> f8154b = null;
    private final cdu<?> f8155c;
    private final cdx<?> f8156d;
    private final String f8157e;

    public <C extends cdt> cdj(String str, cdp<C, O> com_ushareit_listenit_cdp_C__O, cdu<C> com_ushareit_listenit_cdu_C) {
        cfi.m11081a((Object) com_ushareit_listenit_cdp_C__O, (Object) "Cannot construct an Api with a null ClientBuilder");
        cfi.m11081a((Object) com_ushareit_listenit_cdu_C, (Object) "Cannot construct an Api with a null ClientKey");
        this.f8157e = str;
        this.f8153a = com_ushareit_listenit_cdp_C__O;
        this.f8155c = com_ushareit_listenit_cdu_C;
        this.f8156d = null;
    }

    public cds<?, O> m10908a() {
        return m10912e() ? null : this.f8153a;
    }

    public cdp<?, O> m10909b() {
        cfi.m11086a(this.f8153a != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f8153a;
    }

    public cdw<?, O> m10910c() {
        cfi.m11086a(false, (Object) "This API was constructed with a ClientBuilder. Use getClientBuilder");
        return null;
    }

    public cdr<?> m10911d() {
        if (this.f8155c != null) {
            return this.f8155c;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    public boolean m10912e() {
        return false;
    }

    public String m10913f() {
        return this.f8157e;
    }
}
