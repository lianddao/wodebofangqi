package com.ushareit.listenit;

import android.util.Pair;

class fmh extends faw {
    final /* synthetic */ glg f12985a;
    final /* synthetic */ fmc f12986b;

    fmh(fmc com_ushareit_listenit_fmc, String str, glg com_ushareit_listenit_glg) {
        this.f12986b = com_ushareit_listenit_fmc;
        this.f12985a = com_ushareit_listenit_glg;
        super(str);
    }

    public void mo2286a() {
        int f = fkb.m19610a().m19648f();
        Pair a = eyw.m18568a(eys.m18562a());
        boolean booleanValue = ((Boolean) a.first).booleanValue();
        boolean booleanValue2 = ((Boolean) a.second).booleanValue();
        if ((booleanValue || booleanValue2) && (!booleanValue || booleanValue2 || f == 2)) {
            eyh a2 = eyh.m18491a(this.f12985a.f14342j);
            if (a2.mo2328c() && this.f12985a.f14352t <= 0) {
                if (this.f12985a.f14344l >= 104857600) {
                    if (this.f12986b.m19817i() > 0 && !this.f12986b.f12973d.containsKey(this.f12985a)) {
                        this.f12986b.f12973d.put(this.f12985a, String.format(eys.m18562a().getString(C0349R.string.sync_song_size_limit), new Object[]{Integer.valueOf((this.f12985a.f14344l / 1024) / 1024), Integer.valueOf(100)}));
                        return;
                    }
                    return;
                } else if (gnf.m22474a(this.f12985a)) {
                    if (gnf.m22478a(this.f12985a.m22362h(), a2, this.f12986b.f12977h)) {
                        exw.m18443a("SongFileUploader", "upload song success: name=" + this.f12985a.f14338f + ", md5=" + this.f12985a.m22362h());
                        frf.m20673d(this.f12985a);
                        return;
                    } else if (this.f12986b.m19817i() > 0 && !this.f12986b.f12973d.containsKey(this.f12985a)) {
                        this.f12986b.f12973d.put(this.f12985a, eys.m18562a().getString(C0349R.string.sync_upload_failure));
                        return;
                    } else {
                        return;
                    }
                } else if (this.f12986b.m19817i() > 0 && !this.f12986b.f12973d.containsKey(this.f12985a)) {
                    this.f12986b.f12973d.put(this.f12985a, eys.m18562a().getString(C0349R.string.sync_upload_failure));
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        faq.m18735a(new fmi(this));
    }
}
