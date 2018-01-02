package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class fmc extends gze {
    private static fmc f12970a = new fmc();
    private int f12971b = 0;
    private List<fml> f12972c = new ArrayList();
    private gxu<glg, String> f12973d = new gxu();
    private fjz f12974e;
    private List<gnh> f12975f = new ArrayList();
    private boolean f12976g = true;
    private gnh f12977h = new fmk(this);

    private fmc() {
    }

    public static fmc m19867a() {
        return f12970a;
    }

    public ExecutorService mo2399b() {
        return Executors.newSingleThreadExecutor();
    }

    public void m19887a(fml com_ushareit_listenit_fml) {
        if (com_ushareit_listenit_fml != null && !this.f12972c.contains(com_ushareit_listenit_fml)) {
            this.f12972c.add(com_ushareit_listenit_fml);
        }
    }

    public void m19892b(fml com_ushareit_listenit_fml) {
        if (com_ushareit_listenit_fml != null && this.f12972c.contains(com_ushareit_listenit_fml)) {
            this.f12972c.remove(com_ushareit_listenit_fml);
        }
    }

    public void m19889a(gnh com_ushareit_listenit_gnh) {
        if (!this.f12975f.contains(com_ushareit_listenit_gnh)) {
            this.f12975f.add(com_ushareit_listenit_gnh);
        }
    }

    public void m19894b(gnh com_ushareit_listenit_gnh) {
        if (this.f12975f.contains(com_ushareit_listenit_gnh)) {
            this.f12975f.remove(com_ushareit_listenit_gnh);
        }
    }

    public void mo2401c(Object obj) {
        glg com_ushareit_listenit_glg = (glg) obj;
        if (com_ushareit_listenit_glg.f14352t > 0) {
            fiw.m19474f(eys.m18562a());
        } else if (this.f12973d.containsKey(com_ushareit_listenit_glg)) {
            fiw.m19464b(eys.m18562a(), com_ushareit_listenit_glg.f14344l >= 104857600 ? "too big" : (String) this.f12973d.get(com_ushareit_listenit_glg));
        }
        for (fml a : this.f12972c) {
            a.mo2395a();
        }
        if (m19816h() && this.f12974e != null) {
            this.f12974e.m19586b(System.currentTimeMillis());
        }
    }

    public void mo2398a(Object obj) {
    }

    public void mo2400b(Object obj) {
    }

    public void mo2403d(Object obj) {
    }

    public synchronized void m19886a(fjz com_ushareit_listenit_fjz) {
        exw.m18443a("SongFileUploader", "startUploadSongs");
        m19876c(new fmd(this, com_ushareit_listenit_fjz));
    }

    private synchronized void m19873b(fjz com_ushareit_listenit_fjz) {
        this.f12976g = false;
        this.f12974e = com_ushareit_listenit_fjz;
        if (m19817i() == 0) {
            this.f12973d.clear();
        }
        faq.m18735a(new fmf(this));
    }

    private synchronized void m19876c(fjz com_ushareit_listenit_fjz) {
        this.f12976g = false;
        this.f12974e = com_ushareit_listenit_fjz;
        if (m19817i() == 0) {
            this.f12973d.clear();
        }
        faq.m18735a(new fmg(this));
    }

    private void m19878c(glg com_ushareit_listenit_glg) {
        m19806a(com_ushareit_listenit_glg, new fmh(this, "uploadsong", com_ushareit_listenit_glg));
    }

    private void m19880d(glg com_ushareit_listenit_glg) {
        m19806a(com_ushareit_listenit_glg, new fmj(this, "fastuploadsong", com_ushareit_listenit_glg));
    }

    private void m19882e(glg com_ushareit_listenit_glg) {
        String a = gyk.m23153a(com_ushareit_listenit_glg.f14342j);
        if (!com_ushareit_listenit_glg.m22362h().equals(a)) {
            frf.m20666c(frf.m20633a(com_ushareit_listenit_glg.f14342j));
            frf.m20647a(com_ushareit_listenit_glg, a, false);
            List<String> a2 = frd.m20599a(com_ushareit_listenit_glg.f14334b);
            exw.m18443a("SongFileUploader", "checkSongMd5: discover errorMd5, need reupload playlist.size=" + a2.size());
            for (String a3 : a2) {
                frd.m20620d(a3);
            }
        }
    }

    public boolean m19897c() {
        return this.f12976g;
    }

    public void m19888a(glg com_ushareit_listenit_glg) {
        this.f12973d.put(com_ushareit_listenit_glg, eys.m18562a().getString(C0349R.string.sync_upload_failure));
        super.m19815h(com_ushareit_listenit_glg);
    }

    public void mo2402d() {
        this.f12976g = true;
        super.mo2402d();
    }

    private List<glg> m19885k() {
        List<glg> arrayList = new ArrayList();
        for (glc com_ushareit_listenit_glc : fqs.m20480m()) {
            for (glg com_ushareit_listenit_glg : fqs.m20475i(com_ushareit_listenit_glc.f14283c)) {
                if (!(arrayList.contains(com_ushareit_listenit_glg) || !m19884f(com_ushareit_listenit_glg) || gyn.m23260p(com_ushareit_listenit_glg.f14342j))) {
                    arrayList.add(com_ushareit_listenit_glg);
                }
            }
        }
        for (glg com_ushareit_listenit_glg2 : fqs.m20451a(eys.m18562a())) {
            if (!arrayList.contains(com_ushareit_listenit_glg2) && m19884f(com_ushareit_listenit_glg2)) {
                arrayList.add(com_ushareit_listenit_glg2);
            }
        }
        return arrayList;
    }

    private boolean m19884f(glg com_ushareit_listenit_glg) {
        return com_ushareit_listenit_glg.f14348p == 0 && com_ushareit_listenit_glg.f14336d == 0 && com_ushareit_listenit_glg.f14352t == 0 && !m19812e(com_ushareit_listenit_glg) && !m19813f(com_ushareit_listenit_glg) && !m19814g(com_ushareit_listenit_glg);
    }

    public void m19893b(glg com_ushareit_listenit_glg) {
        if (this.f12973d.containsKey(com_ushareit_listenit_glg)) {
            this.f12973d.remove(com_ushareit_listenit_glg);
        }
    }

    public void m19900e() {
        this.f12973d.clear();
    }

    public Map<glg, String> m19901f() {
        return this.f12973d;
    }

    public int m19902g() {
        return this.f12973d.size();
    }
}
