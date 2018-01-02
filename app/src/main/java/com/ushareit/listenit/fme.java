package com.ushareit.listenit;

class fme extends fjz {
    final /* synthetic */ fmd f12980a;

    fme(fmd com_ushareit_listenit_fmd) {
        this.f12980a = com_ushareit_listenit_fmd;
    }

    public void mo2390a(boolean z, long j) {
        int k = frf.m20685k();
        int g = this.f12980a.f12979b.m19902g();
        exw.m18443a("SongFileUploader", "startUploadSongs: needUpload=" + k + ", failureSize=" + g);
        if (k > g) {
            this.f12980a.f12979b.m19886a(this.f12980a.f12978a);
            return;
        }
        this.f12980a.f12979b.f12976g = true;
        if (this.f12980a.f12978a != null) {
            this.f12980a.f12978a.m19586b(System.currentTimeMillis());
        }
    }
}
