package com.ushareit.listenit;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public class cqd {
    protected cvz f8694a;
    protected cqj f8695b;
    protected cpw f8696c;
    protected crt f8697d;
    protected String f8698e;
    protected String f8699f;
    protected cwa f8700g = cwa.INFO;
    protected boolean f8701h;
    protected long f8702i = 10485760;
    protected eah f8703j;
    private boolean f8704k = false;
    private boolean f8705l = false;
    private cqs f8706m;

    private static coj m12254a(cpw com_ushareit_listenit_cpw) {
        return new cqe(com_ushareit_listenit_cpw);
    }

    private String mo1550c(String str) {
        return "Firebase/" + "5" + "/" + ecl.m16740c() + "/" + str;
    }

    private cqs m12256p() {
        if (this.f8706m == null) {
            if (cye.m13360a()) {
                m12257q();
            } else if (cqk.m12303a()) {
                cqs com_ushareit_listenit_cqs = cqk.INSTANCE;
                com_ushareit_listenit_cqs.m12311b();
                this.f8706m = com_ushareit_listenit_cqs;
            } else {
                this.f8706m = cqo.INSTANCE;
            }
        }
        return this.f8706m;
    }

    private synchronized void m12257q() {
        this.f8706m = new cmz(this.f8703j);
    }

    private void m12258r() {
        m12261u();
        m12256p();
        m12264x();
        m12263w();
        m12262v();
        m12266z();
        m12265y();
    }

    private void m12259s() {
        this.f8695b.mo1450a();
        this.f8697d.mo1460c();
    }

    private ScheduledExecutorService m12260t() {
        crt l = m12281l();
        if (l instanceof cyj) {
            return ((cyj) l).m11798d();
        }
        throw new RuntimeException("Custom run loops are not supported!");
    }

    private void m12261u() {
        if (this.f8694a == null) {
            this.f8694a = m12256p().mo1456a(this, this.f8700g, null);
        }
    }

    private void m12262v() {
        if (this.f8697d == null) {
            this.f8697d = this.f8706m.mo1457b(this);
        }
    }

    private void m12263w() {
        if (this.f8695b == null) {
            this.f8695b = m12256p().mo1454a(this);
        }
    }

    private void m12264x() {
        if (this.f8699f == null) {
            this.f8699f = mo1550c(m12256p().mo1458c(this));
        }
    }

    private void m12265y() {
        if (this.f8696c == null) {
            this.f8696c = m12256p().mo1453a(m12260t());
        }
    }

    private void m12266z() {
        if (this.f8698e == null) {
            this.f8698e = "default";
        }
    }

    public cop m12267a(con com_ushareit_listenit_con, coq com_ushareit_listenit_coq) {
        return m12256p().mo1452a(this, m12277h(), com_ushareit_listenit_con, com_ushareit_listenit_coq);
    }

    public cvy m12268a(String str) {
        return new cvy(this.f8694a, str);
    }

    public boolean m12269a() {
        return this.f8704k;
    }

    ctu m12270b(String str) {
        if (!this.f8701h) {
            return new ctt();
        }
        ctu a = this.f8706m.mo1455a(this, str);
        if (a != null) {
            return a;
        }
        throw new IllegalArgumentException("You have enabled persistence, but persistence is not supported on this platform.");
    }

    synchronized void m12271b() {
        if (!this.f8704k) {
            this.f8704k = true;
            m12258r();
        }
    }

    public void m12272c() {
        if (this.f8705l) {
            m12259s();
            this.f8705l = false;
        }
    }

    protected void m12273d() {
        if (m12269a()) {
            throw new ecf("Modifications to DatabaseConfig objects must occur before they are in use");
        }
    }

    public List<String> m12274e() {
        return null;
    }

    public cwa m12275f() {
        return this.f8700g;
    }

    public cvz m12276g() {
        return this.f8694a;
    }

    public col m12277h() {
        return new col(m12276g(), m12254a(m12284o()), m12260t(), m12278i(), ecl.m16740c(), m12282m());
    }

    public boolean m12278i() {
        return this.f8701h;
    }

    public long m12279j() {
        return this.f8702i;
    }

    public cqj m12280k() {
        return this.f8695b;
    }

    public crt m12281l() {
        return this.f8697d;
    }

    public String m12282m() {
        return this.f8699f;
    }

    public String m12283n() {
        return this.f8698e;
    }

    public cpw m12284o() {
        return this.f8696c;
    }
}
