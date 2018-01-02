package com.ushareit.listenit;

import java.io.InputStream;

class fzq extends hhv {
    final /* synthetic */ InputStream f13779a;
    final /* synthetic */ int f13780b;
    final /* synthetic */ String f13781c;
    final /* synthetic */ boolean f13782d;
    final /* synthetic */ fzp f13783e;

    fzq(fzp com_ushareit_listenit_fzp, InputStream inputStream, int i, String str, boolean z) {
        this.f13783e = com_ushareit_listenit_fzp;
        this.f13779a = inputStream;
        this.f13780b = i;
        this.f13781c = str;
        this.f13782d = z;
    }

    public void e_() {
        try {
            String a = gyn.m23185a(this.f13779a, this.f13780b, this.f13781c);
            if (!this.f13782d) {
                frf.m20649a(this.f13781c, a);
                fig.m19279b(eys.m18562a());
            }
            fig.m19277a(eys.m18562a());
        } catch (Throwable e) {
            exw.m18457e(hhw.TAG, "saveNetAlbumArt, error=" + exw.m18438a(e));
        }
    }
}
