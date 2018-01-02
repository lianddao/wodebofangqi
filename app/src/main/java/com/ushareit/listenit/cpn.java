package com.ushareit.listenit;

class cpn implements cpm, cxx {
    final /* synthetic */ cpi f8649a;
    private cxs f8650b;

    private cpn(cpi com_ushareit_listenit_cpi, cxs com_ushareit_listenit_cxs) {
        this.f8649a = com_ushareit_listenit_cpi;
        this.f8650b = com_ushareit_listenit_cxs;
        this.f8650b.m13324a((cxx) this);
    }

    private void m12205e() {
        this.f8650b.m13330e();
        try {
            this.f8650b.m13332g();
        } catch (Throwable e) {
            this.f8649a.f8646l.m13091a("Interrupted while shutting down websocket threads", e);
        }
    }

    public void mo1540a() {
        try {
            this.f8650b.m13329d();
        } catch (Throwable e) {
            if (this.f8649a.f8646l.m13094a()) {
                this.f8649a.f8646l.m13092a("Error connecting", e, new Object[0]);
            }
            m12205e();
        }
    }

    public void mo1541a(cxy com_ushareit_listenit_cxy) {
        this.f8649a.f8645k.execute(new cpr(this, com_ushareit_listenit_cxy));
    }

    public void mo1542a(cya com_ushareit_listenit_cya) {
        String a = com_ushareit_listenit_cya.m13341a();
        if (this.f8649a.f8646l.m13094a()) {
            cvy b = this.f8649a.f8646l;
            String str = "ws message: ";
            String valueOf = String.valueOf(a);
            b.m13093a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), new Object[0]);
        }
        this.f8649a.f8645k.execute(new cpp(this, a));
    }

    public void mo1543a(String str) {
        this.f8650b.m13326a(str);
    }

    public void mo1544b() {
        this.f8650b.m13330e();
    }

    public void mo1545c() {
        this.f8649a.f8645k.execute(new cpo(this));
    }

    public void mo1546d() {
        String str = "closed";
        this.f8649a.f8645k.execute(new cpq(this));
    }
}
