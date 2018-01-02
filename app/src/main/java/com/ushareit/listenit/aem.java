package com.ushareit.listenit;

public class aem implements aei, aej {
    private aei f4236a;
    private aei f4237b;
    private aej f4238c;

    public aem() {
        this(null);
    }

    public aem(aej com_ushareit_listenit_aej) {
        this.f4238c = com_ushareit_listenit_aej;
    }

    public void m5397a(aei com_ushareit_listenit_aei, aei com_ushareit_listenit_aei2) {
        this.f4236a = com_ushareit_listenit_aei;
        this.f4237b = com_ushareit_listenit_aei2;
    }

    public boolean mo606a(aei com_ushareit_listenit_aei) {
        return m5393j() && (com_ushareit_listenit_aei.equals(this.f4236a) || !this.f4236a.mo604h());
    }

    private boolean m5393j() {
        return this.f4238c == null || this.f4238c.mo606a(this);
    }

    public boolean mo607b(aei com_ushareit_listenit_aei) {
        return m5394k() && com_ushareit_listenit_aei.equals(this.f4236a) && !mo609c();
    }

    private boolean m5394k() {
        return this.f4238c == null || this.f4238c.mo607b(this);
    }

    public boolean mo609c() {
        return m5395l() || mo604h();
    }

    public void mo608c(aei com_ushareit_listenit_aei) {
        if (!com_ushareit_listenit_aei.equals(this.f4237b)) {
            if (this.f4238c != null) {
                this.f4238c.mo608c(this);
            }
            if (!this.f4237b.mo603g()) {
                this.f4237b.mo600d();
            }
        }
    }

    private boolean m5395l() {
        return this.f4238c != null && this.f4238c.mo609c();
    }

    public void mo599b() {
        if (!this.f4237b.mo602f()) {
            this.f4237b.mo599b();
        }
        if (!this.f4236a.mo602f()) {
            this.f4236a.mo599b();
        }
    }

    public void mo601e() {
        this.f4236a.mo601e();
        this.f4237b.mo601e();
    }

    public void mo600d() {
        this.f4237b.mo600d();
        this.f4236a.mo600d();
    }

    public boolean mo602f() {
        return this.f4236a.mo602f();
    }

    public boolean mo603g() {
        return this.f4236a.mo603g() || this.f4237b.mo603g();
    }

    public boolean mo604h() {
        return this.f4236a.mo604h() || this.f4237b.mo604h();
    }

    public boolean mo605i() {
        return this.f4236a.mo605i();
    }

    public void mo595a() {
        this.f4236a.mo595a();
        this.f4237b.mo595a();
    }
}
