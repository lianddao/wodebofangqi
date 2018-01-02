package com.ushareit.listenit;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class flw extends gze {
    private static flw f12956a = new flw();
    private List<fmb> f12957b = new ArrayList();
    private gxu<glg, String> f12958c = new gxu();
    private List<gnh> f12959d = new ArrayList();
    private fjz f12960e;
    private boolean f12961f = true;
    private gnh f12962g = new fma(this);

    private flw() {
    }

    public static flw m19819a() {
        return f12956a;
    }

    public void m19833a(gnh com_ushareit_listenit_gnh) {
        if (!this.f12959d.contains(com_ushareit_listenit_gnh)) {
            this.f12959d.add(com_ushareit_listenit_gnh);
        }
    }

    public void m19838b(gnh com_ushareit_listenit_gnh) {
        if (this.f12959d.contains(com_ushareit_listenit_gnh)) {
            this.f12959d.remove(com_ushareit_listenit_gnh);
        }
    }

    public ExecutorService mo2399b() {
        return Executors.newSingleThreadExecutor();
    }

    public void mo2398a(Object obj) {
        exw.m18443a("SongFileDownloader", "start download name=" + ((glg) obj).f14338f);
        for (fmb a : this.f12957b) {
            a.mo2391a();
        }
    }

    public void mo2400b(Object obj) {
        for (fmb b : this.f12957b) {
            b.mo2392b();
        }
    }

    public void mo2401c(Object obj) {
        glg com_ushareit_listenit_glg = (glg) obj;
        File file = new File(com_ushareit_listenit_glg.f14342j);
        boolean z = file.exists() && file.length() == ((long) com_ushareit_listenit_glg.f14344l);
        if (z) {
            fiw.m19472e(eys.m18562a());
        } else if (this.f12958c.containsKey(com_ushareit_listenit_glg)) {
            fiw.m19458a(eys.m18562a(), (String) this.f12958c.get(com_ushareit_listenit_glg));
        }
        exw.m18443a("SongFileDownloader", "download complete: name=" + com_ushareit_listenit_glg.f14338f + ", path=" + com_ushareit_listenit_glg.f14342j + ", size=" + com_ushareit_listenit_glg.f14344l + ", filelen=" + file.length());
        if (z) {
            frf.m20660b(com_ushareit_listenit_glg);
        }
        for (fmb c : this.f12957b) {
            c.mo2393c();
        }
        if (m19816h() && this.f12960e != null) {
            this.f12961f = true;
            if (z) {
                this.f12960e.m19587c();
            } else {
                this.f12960e.m19588d();
            }
        }
    }

    public void mo2403d(Object obj) {
    }

    public void m19830a(fmb com_ushareit_listenit_fmb) {
        if (com_ushareit_listenit_fmb != null && !this.f12957b.contains(com_ushareit_listenit_fmb)) {
            this.f12957b.add(com_ushareit_listenit_fmb);
        }
    }

    public void m19836b(fmb com_ushareit_listenit_fmb) {
        if (com_ushareit_listenit_fmb != null && this.f12957b.contains(com_ushareit_listenit_fmb)) {
            this.f12957b.remove(com_ushareit_listenit_fmb);
        }
    }

    public synchronized void m19829a(fjz com_ushareit_listenit_fjz) {
        this.f12961f = false;
        this.f12960e = com_ushareit_listenit_fjz;
        if (m19817i() == 0) {
            this.f12958c.clear();
        }
        faq.m18735a(new flx(this));
    }

    public synchronized void m19832a(glg com_ushareit_listenit_glg, boolean z) {
        if (this.f12958c.containsKey(com_ushareit_listenit_glg)) {
            this.f12958c.remove(com_ushareit_listenit_glg);
        }
        m19806a(com_ushareit_listenit_glg, new fly(this, "downloadsong", z, com_ushareit_listenit_glg));
    }

    public synchronized void m19831a(glg com_ushareit_listenit_glg) {
        m19832a(com_ushareit_listenit_glg, false);
        for (fmb d : this.f12957b) {
            d.mo2394d();
        }
    }

    public synchronized void m19837b(glg com_ushareit_listenit_glg) {
        exw.m18443a("SongFileDownloader", "pauseTask : name=" + com_ushareit_listenit_glg.f14338f);
        this.f12958c.put(com_ushareit_listenit_glg, eys.m18562a().getString(C0349R.string.sync_download_pause));
        super.m19818i(com_ushareit_listenit_glg);
    }

    public synchronized void m19840c(glg com_ushareit_listenit_glg) {
        exw.m18443a("SongFileDownloader", "cancelTask : name=" + com_ushareit_listenit_glg.f14338f);
        this.f12958c.put(com_ushareit_listenit_glg, eys.m18562a().getString(C0349R.string.sync_download_cancel));
        super.m19815h(com_ushareit_listenit_glg);
    }

    public boolean m19842c() {
        return this.f12961f;
    }

    public synchronized void mo2402d() {
        this.f12961f = true;
        super.mo2402d();
        if (this.f12960e != null) {
            this.f12960e.m19587c();
        }
    }

    private List<glg> m19828k() {
        List<glg> arrayList = new ArrayList();
        for (glg com_ushareit_listenit_glg : fqs.m20451a(eys.m18562a())) {
            if (!arrayList.contains(com_ushareit_listenit_glg) && m19826e(com_ushareit_listenit_glg)) {
                arrayList.add(com_ushareit_listenit_glg);
            }
        }
        exw.m18457e("SongFileDownloader", "getAllCloudSongs, songitem.size=" + arrayList.size());
        return arrayList;
    }

    private boolean m19826e(glg com_ushareit_listenit_glg) {
        if (com_ushareit_listenit_glg.f14348p != 1 || com_ushareit_listenit_glg.f14336d != 0 || com_ushareit_listenit_glg.f14352t <= 0 || m19812e(com_ushareit_listenit_glg) || m19813f(com_ushareit_listenit_glg) || m19814g(com_ushareit_listenit_glg)) {
            return false;
        }
        return true;
    }

    public void m19844d(glg com_ushareit_listenit_glg) {
        if (this.f12958c.containsKey(com_ushareit_listenit_glg)) {
            this.f12958c.containsKey(com_ushareit_listenit_glg);
        }
    }

    public Map<glg, String> m19846e() {
        return this.f12958c;
    }

    public void m19847f() {
        this.f12958c.clear();
    }

    public int m19848g() {
        return this.f12958c.size();
    }
}
