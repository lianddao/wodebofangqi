package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class gyy extends gze {
    private static gyy f14942a;
    private List<gzb> f14943b = new ArrayList();
    private boolean f14944c = true;

    private gyy() {
    }

    public static gyy m23326a() {
        if (f14942a == null) {
            f14942a = new gyy();
        }
        return f14942a;
    }

    public ExecutorService mo2399b() {
        return Executors.newFixedThreadPool(5);
    }

    public void mo2398a(Object obj) {
    }

    public void mo2400b(Object obj) {
    }

    public void mo2401c(Object obj) {
        exw.m18443a("SongMoreInfoRetriever", "asyncExtractSongMoreInfo: onFinishTask=" + m19817i());
        if (m19816h()) {
            fxh.m21244X();
            m23328g();
        }
    }

    public void mo2403d(Object obj) {
    }

    public void m23330a(gzb com_ushareit_listenit_gzb) {
        if (!this.f14943b.contains(com_ushareit_listenit_gzb)) {
            this.f14943b.add(com_ushareit_listenit_gzb);
        }
    }

    public synchronized void m23334c() {
        this.f14944c = false;
        hhx.m23867a(new gyz(this));
    }

    public synchronized void m23329a(glg com_ushareit_listenit_glg) {
        if (!com_ushareit_listenit_glg.m22363i()) {
            m19806a(Long.valueOf(com_ushareit_listenit_glg.f14334b), new gza(this, "extractSongInfo", com_ushareit_listenit_glg));
        }
    }

    public boolean m23337e() {
        return this.f14944c;
    }

    public List<glg> m23338f() {
        List<glg> arrayList = new ArrayList();
        for (glg com_ushareit_listenit_glg : fqs.m20464c()) {
            if (!(arrayList.contains(com_ushareit_listenit_glg) || m19812e(com_ushareit_listenit_glg) || m19813f(com_ushareit_listenit_glg) || m19814g(com_ushareit_listenit_glg))) {
                arrayList.add(com_ushareit_listenit_glg);
            }
        }
        return arrayList;
    }

    private void m23328g() {
        exw.m18443a("SongMoreInfoRetriever", "onExtractFinished");
        this.f14944c = true;
        for (gzb a : this.f14943b) {
            a.mo2738a();
        }
    }
}
