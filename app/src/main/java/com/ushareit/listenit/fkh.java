package com.ushareit.listenit;

class fkh extends fjz {
    final /* synthetic */ fkb f12849a;

    fkh(fkb com_ushareit_listenit_fkb) {
        this.f12849a = com_ushareit_listenit_fkb;
    }

    public void mo2390a(boolean z, long j) {
        exw.m18457e("CloudSyncManager", "mPlaylistSyncCompleteListener: result=" + z);
        fiw.m19465b(eys.m18562a(), z);
        this.f12849a.f12832g.m19792d();
        if (z) {
            fxh.m21244X();
            if (gvj.m22880S(eys.m18562a())) {
                heb.m23596a(z ? C0349R.string.sync_playlist_success : C0349R.string.sync_playlist_failure, 0).show();
                gvj.m22951f(eys.m18562a(), false);
            }
            if (this.f12849a.f12838m != fkq.FINISH) {
                if (this.f12849a.f12833h == 0 || frf.m20685k() + frf.m20684j() == 0) {
                    this.f12849a.m19614a(fkq.FINISH);
                    for (fko a : this.f12849a.f12834i) {
                        a.mo2396a(this.f12849a.f12838m);
                    }
                    return;
                }
                this.f12849a.m19615a(this.f12849a.f12833h == 2);
                return;
            }
            return;
        }
        this.f12849a.m19614a(fkq.FINISH);
        for (fko a2 : this.f12849a.f12834i) {
            a2.mo2396a(this.f12849a.f12838m);
        }
    }
}
