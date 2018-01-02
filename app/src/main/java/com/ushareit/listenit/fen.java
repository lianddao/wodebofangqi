package com.ushareit.listenit;

public abstract class fen {
    private long f12545a = 0;
    private long f12546b = 0;
    private int f12547c = 0;
    private String f12548d;
    private boolean f12549e;

    public abstract void mo2360b(ffl com_ushareit_listenit_ffl, esi com_ushareit_listenit_esi);

    public abstract void mo2361g();

    public fen(long j) {
        boolean z = false;
        if (j > 0) {
            z = true;
        }
        this.f12549e = z;
        this.f12546b = j;
        this.f12548d = "" + hashCode();
    }

    public final synchronized void m18992a(ffl com_ushareit_listenit_ffl, esi com_ushareit_listenit_esi) {
        if (this.f12547c == 0) {
            com_ushareit_listenit_ffl.a = com_ushareit_listenit_esi.m17765a();
            com_ushareit_listenit_ffl.c = com_ushareit_listenit_esi.m17768b();
            if (!this.f12549e || this.f12545a <= 0) {
                this.f12547c = 2;
                mo2360b(com_ushareit_listenit_ffl, com_ushareit_listenit_esi);
            } else if (System.currentTimeMillis() - this.f12545a < this.f12546b) {
                this.f12547c = 2;
                m18990i();
                mo2360b(com_ushareit_listenit_ffl, com_ushareit_listenit_esi);
            }
        }
    }

    public final synchronized void m18991a() {
        if (this.f12547c == 0) {
            this.f12547c = 1;
            if (this.f12549e && this.f12545a > 0) {
                m18990i();
            }
            mo2361g();
        }
    }

    public boolean m18994b() {
        return this.f12549e && this.f12545a > 0 && System.currentTimeMillis() - this.f12545a > this.f12546b;
    }

    public boolean m18995c() {
        return this.f12549e;
    }

    public long m18996d() {
        return this.f12546b;
    }

    public void m18997e() {
        this.f12545a = System.currentTimeMillis();
        hhx.m23869a(new feo(this, this.f12548d), 0, (int) this.f12546b);
    }

    private synchronized void m18989h() {
        if (this.f12547c != 2) {
            mo2361g();
        }
    }

    private void m18990i() {
        hhx.m23870a(this.f12548d);
    }

    public boolean mo2362f() {
        return true;
    }
}
