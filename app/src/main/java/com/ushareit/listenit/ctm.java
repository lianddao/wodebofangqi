package com.ushareit.listenit;

public class ctm {
    public static final ctm f8954a = new ctm(ctn.User, null, false);
    public static final ctm f8955b = new ctm(ctn.Server, null, false);
    static final /* synthetic */ boolean f8956c = (!ctm.class.desiredAssertionStatus());
    private final ctn f8957d;
    private final cvd f8958e;
    private final boolean f8959f;

    public ctm(ctn com_ushareit_listenit_ctn, cvd com_ushareit_listenit_cvd, boolean z) {
        this.f8957d = com_ushareit_listenit_ctn;
        this.f8958e = com_ushareit_listenit_cvd;
        this.f8959f = z;
        if (!f8956c && z && !m12620b()) {
            throw new AssertionError();
        }
    }

    public static ctm m12618a(cvd com_ushareit_listenit_cvd) {
        return new ctm(ctn.Server, com_ushareit_listenit_cvd, true);
    }

    public boolean m12619a() {
        return this.f8957d == ctn.User;
    }

    public boolean m12620b() {
        return this.f8957d == ctn.Server;
    }

    public boolean m12621c() {
        return this.f8959f;
    }

    public cvd m12622d() {
        return this.f8958e;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f8957d);
        String valueOf2 = String.valueOf(this.f8958e);
        return new StringBuilder((String.valueOf(valueOf).length() + 52) + String.valueOf(valueOf2).length()).append("OperationSource{source=").append(valueOf).append(", queryParams=").append(valueOf2).append(", tagged=").append(this.f8959f).append("}").toString();
    }
}
