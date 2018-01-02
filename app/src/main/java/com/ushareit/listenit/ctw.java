package com.ushareit.listenit;

public class ctw {
    private static final cum<Boolean> f8973b = new ctx();
    private static final cum<Boolean> f8974c = new cty();
    private static final cui<Boolean> f8975d = new cui(Boolean.valueOf(true));
    private static final cui<Boolean> f8976e = new cui(Boolean.valueOf(false));
    private final cui<Boolean> f8977a;

    public ctw() {
        this.f8977a = cui.m12736a();
    }

    private ctw(cui<Boolean> com_ushareit_listenit_cui_java_lang_Boolean) {
        this.f8977a = com_ushareit_listenit_cui_java_lang_Boolean;
    }

    public ctw m12684a(cwc com_ushareit_listenit_cwc) {
        cui a = this.f8977a.m12742a(com_ushareit_listenit_cwc);
        cui com_ushareit_listenit_cui = a == null ? new cui((Boolean) this.f8977a.m12746b()) : (a.m12746b() != null || this.f8977a.m12746b() == null) ? a : a.m12741a(cqq.m12332a(), (Boolean) this.f8977a.m12746b());
        return new ctw(com_ushareit_listenit_cui);
    }

    public <T> T m12685a(T t, cul<Void, T> com_ushareit_listenit_cul_java_lang_Void__T) {
        return this.f8977a.m12743a((Object) t, new ctz(this, com_ushareit_listenit_cul_java_lang_Void__T));
    }

    public boolean m12686a() {
        return this.f8977a.m12745a(f8974c);
    }

    public boolean m12687a(cqq com_ushareit_listenit_cqq) {
        Boolean bool = (Boolean) this.f8977a.m12747b(com_ushareit_listenit_cqq);
        return bool != null && bool.booleanValue();
    }

    public boolean m12688b(cqq com_ushareit_listenit_cqq) {
        Boolean bool = (Boolean) this.f8977a.m12747b(com_ushareit_listenit_cqq);
        return (bool == null || bool.booleanValue()) ? false : true;
    }

    public ctw m12689c(cqq com_ushareit_listenit_cqq) {
        if (this.f8977a.m12748b(com_ushareit_listenit_cqq, f8973b) == null) {
            return this.f8977a.m12748b(com_ushareit_listenit_cqq, f8974c) != null ? this : new ctw(this.f8977a.m12740a(com_ushareit_listenit_cqq, f8975d));
        } else {
            throw new IllegalArgumentException("Can't prune path that was kept previously!");
        }
    }

    public ctw m12690d(cqq com_ushareit_listenit_cqq) {
        return this.f8977a.m12748b(com_ushareit_listenit_cqq, f8973b) != null ? this : new ctw(this.f8977a.m12740a(com_ushareit_listenit_cqq, f8976e));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ctw)) {
            return false;
        }
        return this.f8977a.equals(((ctw) obj).f8977a);
    }

    public int hashCode() {
        return this.f8977a.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.f8977a.toString());
        return new StringBuilder(String.valueOf(valueOf).length() + 14).append("{PruneForest:").append(valueOf).append("}").toString();
    }
}
