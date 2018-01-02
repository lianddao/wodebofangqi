package com.ushareit.listenit;

import android.content.Context;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.List;

public class fle {
    private static fle f12901a;
    private flg f12902b;
    private fnp f12903c;
    private fno f12904d;
    private fnq f12905e;
    private fnh f12906f;
    private Context f12907g = eys.m18562a();
    private List<flh> f12908h = new ArrayList();

    public void m19724a(flh com_ushareit_listenit_flh) {
        if (!this.f12908h.contains(com_ushareit_listenit_flh)) {
            this.f12908h.add(com_ushareit_listenit_flh);
        }
    }

    public void m19729b(flh com_ushareit_listenit_flh) {
        if (this.f12908h.contains(com_ushareit_listenit_flh)) {
            this.f12908h.remove(com_ushareit_listenit_flh);
        }
    }

    public boolean m19727a() {
        return this.f12902b.m19760b() > 0;
    }

    private void m19719w() {
        hhx.m23867a(new flf(this));
    }

    private fle() {
        m19715A();
        m19745k();
        m19722z();
        m19720x();
        m19721y();
    }

    public static fle m19717b() {
        if (f12901a == null) {
            f12901a = new fle();
        }
        return f12901a;
    }

    private void m19720x() {
        if (this.f12906f == null) {
            this.f12906f = new fnh();
        }
        long N = gvj.m22875N(this.f12907g);
        long O = gvj.m22876O(this.f12907g);
        long P = gvj.m22877P(this.f12907g);
        this.f12906f.setUi(N);
        this.f12906f.setPl(O);
        this.f12906f.setLs(P);
    }

    public void m19731c() {
        m19723a(0);
        m19738e(0);
        m19728b(0);
        m19732c(0);
    }

    public long m19734d() {
        return this.f12906f.getUi();
    }

    public void m19723a(long j) {
        this.f12906f.setUi(j);
        gvj.m22957g(this.f12907g, j);
    }

    public long m19737e() {
        return this.f12906f.getPl();
    }

    public void m19728b(long j) {
        exw.m18443a("LocalSyncManager", "setPlaylistSyncTime: syncTime=" + j);
        this.f12906f.setPl(j);
        gvj.m22965h(this.f12907g, j);
    }

    public long m19740f() {
        return this.f12906f.getLs();
    }

    public void m19732c(long j) {
        exw.m18443a("LocalSyncManager", "setLibrarySongsSyncTime: syncTime=" + j);
        this.f12906f.setLs(j);
        gvj.m22973i(this.f12907g, j);
    }

    private void m19721y() {
        if (this.f12905e == null) {
            this.f12905e = new fnq();
        }
        long L = gvj.m22873L(this.f12907g);
        long M = gvj.m22874M(this.f12907g);
        this.f12905e.setNa(L);
        this.f12905e.setAv(M);
    }

    public fnq m19741g() {
        return this.f12905e;
    }

    public long m19742h() {
        return this.f12905e.getNa();
    }

    public void m19735d(long j) {
        exw.m18443a("LocalSyncManager", "setUserNameSyncTime: syncTime=" + j);
        this.f12905e.setNa(j);
        gvj.m22941e(this.f12907g, j);
    }

    public long m19743i() {
        return this.f12905e.getAv();
    }

    public void m19738e(long j) {
        exw.m18443a("LocalSyncManager", "setUserAvatorSyncTime: syncTime=" + j);
        this.f12905e.setAv(j);
        gvj.m22949f(this.f12907g, j);
    }

    private void m19722z() {
        if (this.f12904d == null) {
            this.f12904d = new fno();
        }
        String a = fah.m18702a(this.f12907g);
        String valueOf = String.valueOf(VERSION.SDK_INT);
        fbc b = fbb.m18760b(this.f12907g);
        this.f12904d.setId(m19718b(a));
        this.f12904d.setTy(b.toString());
        this.f12904d.setVe(valueOf);
    }

    private String m19718b(String str) {
        exw.m18443a("LocalSyncManager", "validateString: str=" + str);
        for (int i = 0; i < ".#$[]".length(); i++) {
            str = str.replace(".#$[]".charAt(i), '_');
        }
        exw.m18443a("LocalSyncManager", "validateString: result=" + str);
        return str;
    }

    public fno m19744j() {
        return this.f12904d;
    }

    public void m19745k() {
        if (this.f12903c == null) {
            this.f12903c = new fnp();
        }
        this.f12903c.setId(gvj.m22870I(this.f12907g));
        this.f12903c.setNa(gvj.m22871J(this.f12907g));
        this.f12903c.setAv(null);
    }

    public fnp m19746l() {
        return this.f12903c;
    }

    public String m19747m() {
        return this.f12903c.getId();
    }

    public String m19748n() {
        return this.f12903c.getNa();
    }

    public void m19725a(String str) {
        exw.m18443a("LocalSyncManager", "setUserName: userName=" + str);
        this.f12903c.setNa(str);
        gvj.m22966h(eys.m18562a(), str);
    }

    private void m19715A() {
        if (this.f12902b == null) {
            this.f12902b = new flg(this);
        }
        this.f12902b.m19758a(gvj.m22878Q(this.f12907g));
    }

    public void m19749o() {
        exw.m18443a("LocalSyncManager", "clearAllModifiedState");
        this.f12902b.m19757a();
        gvj.m22989k(this.f12907g, this.f12902b.m19760b());
        m19719w();
    }

    public void m19726a(boolean z) {
        if (z != this.f12902b.m19761b(2)) {
            exw.m18443a("LocalSyncManager", "updateUserInfoModifiedState");
            this.f12902b.m19759a(2, z);
            gvj.m22989k(this.f12907g, this.f12902b.m19760b());
            if (z) {
                m19719w();
            }
        }
    }

    public boolean m19750p() {
        return this.f12902b.m19761b(2);
    }

    public void m19730b(boolean z) {
        if (z != this.f12902b.m19761b(0)) {
            exw.m18443a("LocalSyncManager", "updatePlaylistModifiedState");
            this.f12902b.m19759a(0, z);
            gvj.m22989k(this.f12907g, this.f12902b.m19760b());
            if (z) {
                m19719w();
            }
        }
    }

    public boolean m19751q() {
        return this.f12902b.m19761b(0);
    }

    public void m19733c(boolean z) {
        if (z != this.f12902b.m19761b(1)) {
            exw.m18443a("LocalSyncManager", "updateLibrarySongsModifiedState");
            this.f12902b.m19759a(1, z);
            gvj.m22989k(this.f12907g, this.f12902b.m19760b());
            if (z) {
                m19719w();
            }
        }
    }

    public boolean m19752r() {
        return this.f12902b.m19761b(1);
    }

    public void m19736d(boolean z) {
        if (z != this.f12902b.m19761b(3)) {
            exw.m18443a("LocalSyncManager", "updateUserNameModifiedState: " + z);
            this.f12902b.m19759a(3, z);
            if (z) {
                this.f12902b.m19759a(2, true);
            }
            gvj.m22989k(this.f12907g, this.f12902b.m19760b());
        }
    }

    public boolean m19753s() {
        return this.f12902b.m19761b(3);
    }

    public void m19739e(boolean z) {
        if (z != this.f12902b.m19761b(4)) {
            exw.m18457e("LocalSyncManager", "updateUserAvatorModifiedState");
            this.f12902b.m19759a(4, z);
            if (z) {
                this.f12902b.m19759a(2, true);
            }
            gvj.m22989k(this.f12907g, this.f12902b.m19760b());
        }
    }

    public boolean m19754t() {
        return this.f12902b.m19761b(4);
    }

    public void m19755u() {
        if (!gyn.m23240f(gyn.m23238f()) && m19754t()) {
            m19739e(false);
        }
        if (!gvj.av(eys.m18562a()) && gyn.m23240f(gyn.m23238f())) {
            m19739e(true);
        }
    }

    public void m19756v() {
        if (!gvj.av(eys.m18562a())) {
            gvj.m23007m(eys.m18562a(), true);
        }
    }
}
