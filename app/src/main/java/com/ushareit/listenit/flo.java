package com.ushareit.listenit;

class flo implements ecy {
    final /* synthetic */ fjz f12931a;
    final /* synthetic */ fli f12932b;

    flo(fli com_ushareit_listenit_fli, fjz com_ushareit_listenit_fjz) {
        this.f12932b = com_ushareit_listenit_fli;
        this.f12931a = com_ushareit_listenit_fjz;
    }

    public void mo2135a(ecb com_ushareit_listenit_ecb) {
        if (com_ushareit_listenit_ecb.m16703b() != 0) {
            try {
                hhx.m23867a(new flp(this, new fnk(com_ushareit_listenit_ecb)));
            } catch (Exception e) {
                exw.m18457e("PlaylistSync", "downloadPlaylists: error");
                if (this.f12931a != null) {
                    this.f12931a.m19588d();
                }
            }
        } else if (this.f12931a != null) {
            this.f12931a.m19587c();
        }
    }

    public void mo2136a(ece com_ushareit_listenit_ece) {
        if (this.f12931a != null) {
            this.f12931a.m19588d();
        }
    }
}
