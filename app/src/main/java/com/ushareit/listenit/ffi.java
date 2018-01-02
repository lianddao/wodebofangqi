package com.ushareit.listenit;

class ffi extends fen {
    final /* synthetic */ ffh f12602a;

    ffi(ffh com_ushareit_listenit_ffh, long j) {
        this.f12602a = com_ushareit_listenit_ffh;
        super(j);
    }

    public void mo2360b(ffl com_ushareit_listenit_ffl, esi com_ushareit_listenit_esi) {
        if (this.f12602a.f12599i) {
            exw.m18454c("1020", "onAdLoaded() current mNotShowAdOnCurrent:" + this.f12602a.f12600j);
            if (this.f12602a.f12600j) {
                this.f12602a.f12600j = false;
            } else {
                this.f12602a.f12593c.setVisibility(4);
                fet.m19019a(this.f12602a.f12593c, com_ushareit_listenit_esi, com_ushareit_listenit_ffl);
                gzi.m23381a(this.f12602a.f12593c, this.f12602a.f12592b);
                this.f12602a.sendEmptyMessageDelayed(4, (long) this.f12602a.f12597g);
            }
        } else {
            exw.m18454c("1020", "onAdLoaded() next mNotShowAdOnNext:" + this.f12602a.f12601k);
            if (this.f12602a.f12601k) {
                this.f12602a.f12601k = false;
            } else {
                this.f12602a.f12595e.setVisibility(4);
                fet.m19019a(this.f12602a.f12595e, com_ushareit_listenit_esi, com_ushareit_listenit_ffl);
                gzi.m23381a(this.f12602a.f12595e, this.f12602a.f12594d);
                this.f12602a.sendEmptyMessageDelayed(5, (long) this.f12602a.f12597g);
            }
        }
        fem.f12544b = 0;
    }

    public void mo2361g() {
    }

    public boolean mo2362f() {
        return this.f12602a.f12598h;
    }
}
