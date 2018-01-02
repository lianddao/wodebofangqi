package com.ushareit.listenit;

import android.util.Pair;
import com.umeng.analytics.C0154a;
import java.util.ArrayList;
import java.util.List;

public class fkb {
    private static fkb f12826a;
    private List<fkp> f12827b = new ArrayList();
    private fmm f12828c = new fmm();
    private fmp f12829d = new fmp();
    private fli f12830e = new fli();
    private fkv f12831f = new fkv();
    private flr f12832g = new flr();
    private int f12833h = 1;
    private List<fko> f12834i = new ArrayList();
    private boolean f12835j = false;
    private long f12836k = 0;
    private fkq f12837l = fkq.FINISH;
    private fkq f12838m = fkq.FINISH;
    private fjz f12839n = new fkg(this);
    private fjz f12840o = new fkh(this);
    private fmb f12841p = new fkm(this);
    private fml f12842q = new fkn(this);

    private fkb() {
    }

    public static fkb m19610a() {
        if (f12826a == null) {
            f12826a = new fkb();
        }
        return f12826a;
    }

    public void m19639a(fko com_ushareit_listenit_fko) {
        if (!this.f12834i.contains(com_ushareit_listenit_fko)) {
            this.f12834i.add(com_ushareit_listenit_fko);
        }
    }

    public void m19643b(fko com_ushareit_listenit_fko) {
        if (this.f12834i.contains(com_ushareit_listenit_fko)) {
            this.f12834i.remove(com_ushareit_listenit_fko);
        }
    }

    public void m19640a(fkp com_ushareit_listenit_fkp) {
        if (com_ushareit_listenit_fkp != null && !this.f12827b.contains(com_ushareit_listenit_fkp)) {
            this.f12827b.add(com_ushareit_listenit_fkp);
        }
    }

    public void m19644b(fkp com_ushareit_listenit_fkp) {
        if (com_ushareit_listenit_fkp != null && this.f12827b.contains(com_ushareit_listenit_fkp)) {
            this.f12827b.remove(com_ushareit_listenit_fkp);
        }
    }

    public synchronized void m19641a(String str) {
        m19638a(1, false, str);
    }

    public synchronized void m19638a(int i, boolean z, String str) {
        Pair a = eyw.m18568a(eys.m18562a());
        boolean booleanValue = ((Boolean) a.first).booleanValue();
        boolean booleanValue2 = ((Boolean) a.second).booleanValue();
        boolean e = gef.m21805a().m21835e();
        fle.m19717b().m19745k();
        String m = fle.m19717b().m19747m();
        if (e && !fbb.m18763c(m) && (booleanValue || booleanValue2)) {
            this.f12833h = i;
            this.f12835j = z;
            if (z) {
                this.f12836k = System.currentTimeMillis();
                fiw.m19457a(eys.m18562a(), i);
            }
            if (this.f12838m != fkq.FINISH) {
                for (fko a2 : this.f12834i) {
                    a2.mo2396a(this.f12838m);
                }
            } else {
                if (!z) {
                    if (booleanValue && !booleanValue2) {
                        String T = gvj.m22881T(eys.m18562a());
                        String a3 = gyn.m23179a();
                        if (fbb.m18763c(T) || !a3.equals(T)) {
                            gvj.m23006m(eys.m18562a(), a3);
                        }
                    } else if (booleanValue2) {
                        if ((System.currentTimeMillis() - gvj.m22886Y(eys.m18562a())) / C0154a.f2954j >= ((long) fqk.m20377c())) {
                            gvj.m22990k(eys.m18562a(), System.currentTimeMillis());
                        }
                    }
                }
                exw.m18443a("CloudSyncManager", "startSync uid=" + fle.m19717b().m19747m() + ", scanFinish=" + grr.m22621a().m22648d() + ", extractFinish=" + gyy.m23326a().m23337e() + ", syncState=" + this.f12838m);
                m19614a(fkq.SYNCING_PLAYLIST);
                this.f12836k = System.currentTimeMillis();
                for (fko a22 : this.f12834i) {
                    a22.mo2396a(this.f12838m);
                }
                hhx.m23867a(new fkc(this, str));
            }
        }
    }

    private void m19627h() {
        flw.m19819a().m19847f();
        fmc.m19867a().m19900e();
    }

    private void m19619b(String str) {
        fiw.m19473e(eys.m18562a(), str);
        hhx.m23867a(new fkd(this));
    }

    private void m19629i() {
        boolean j = m19631j();
        while (!j && this.f12838m != fkq.FINISH) {
            exw.m18443a("CloudSyncManager", "waitForScanFinished, scanFinish=" + grr.m22621a().m22648d() + ", md5Finish=" + gyy.m23326a().m23337e());
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            j = m19631j();
        }
    }

    private boolean m19631j() {
        return grr.m22621a().m22648d() && gyy.m23326a().m23337e();
    }

    public void m19642b() {
        exw.m18443a("CloudSyncManager", "stopSync: syncState=" + this.f12838m);
        m19614a(fkq.FINISH);
        if (!fmc.m19867a().m19897c()) {
            fmc.m19867a().mo2402d();
        }
        if (!flw.m19819a().m19842c()) {
            flw.m19819a().mo2402d();
        }
        for (fko a : this.f12834i) {
            a.mo2396a(this.f12838m);
        }
    }

    public boolean m19645c() {
        return this.f12835j;
    }

    public long m19646d() {
        return this.f12836k;
    }

    public fkq m19647e() {
        return this.f12838m;
    }

    public int m19648f() {
        return this.f12833h;
    }

    private void m19614a(fkq com_ushareit_listenit_fkq) {
        this.f12837l = this.f12838m;
        this.f12838m = com_ushareit_listenit_fkq;
    }

    public boolean m19649g() {
        return this.f12838m == fkq.FINISH;
    }

    private void m19615a(boolean z) {
        Pair a = eyw.m18568a(eys.m18562a());
        boolean booleanValue = ((Boolean) a.first).booleanValue();
        boolean booleanValue2 = ((Boolean) a.second).booleanValue();
        boolean R = gvj.m22879R(eys.m18562a());
        exw.m18457e("CloudSyncManager", "startDownloadSongFiles: isforce=" + z + ", isM=" + booleanValue + ", iswifi=" + booleanValue2 + ", isauto=" + R);
        if ((z && (booleanValue || booleanValue2)) || ((this.f12835j && booleanValue2) || (R && booleanValue2))) {
            m19614a(fkq.DOWNLOADING_SONGS);
            flw.m19819a().m19830a(this.f12841p);
            flw.m19819a().m19829a(new fki(this));
            for (fko a2 : this.f12834i) {
                a2.mo2396a(this.f12838m);
            }
            return;
        }
        m19614a(fkq.FINISH);
        for (fko a22 : this.f12834i) {
            a22.mo2396a(this.f12838m);
        }
    }

    private void m19620b(boolean z) {
        Pair a = eyw.m18568a(eys.m18562a());
        boolean booleanValue = ((Boolean) a.first).booleanValue();
        boolean booleanValue2 = ((Boolean) a.second).booleanValue();
        boolean R = gvj.m22879R(eys.m18562a());
        exw.m18443a("CloudSyncManager", "startUploadSongFiles: isforce=" + z + ", isM=" + booleanValue + ", iswifi=" + booleanValue2 + ", isauto=" + R);
        if ((z && (booleanValue || booleanValue2)) || ((this.f12835j && booleanValue2) || (R && booleanValue2))) {
            m19614a(fkq.UPLOADING_SONGS);
            fmc.m19867a().m19887a(this.f12842q);
            fmc.m19867a().m19886a(new fkj(this));
            for (fko a2 : this.f12834i) {
                a2.mo2396a(this.f12838m);
            }
            return;
        }
        m19614a(fkq.FINISH);
        for (fko a22 : this.f12834i) {
            a22.mo2396a(this.f12838m);
        }
    }

    private void m19633k() {
        boolean a = fle.m19717b().m19727a();
        exw.m18443a("CloudSyncManager", "endSync:  isLocalModified=" + a);
        if (a) {
            this.f12831f.m19688a(new fkk(this));
            return;
        }
        m19614a(fkq.FINISH);
        for (fko a2 : this.f12834i) {
            a2.mo2396a(this.f12838m);
        }
    }
}
