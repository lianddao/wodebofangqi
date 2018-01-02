package com.ushareit.listenit;

import com.mopub.mraid.MraidController;
import com.mopub.mraid.MraidNativeCommandHandler;

public class elc implements Runnable {
    final /* synthetic */ MraidController f11197a;

    public elc(MraidController mraidController) {
        this.f11197a = mraidController;
    }

    public void run() {
        this.f11197a.f2588p.m3070a(this.f11197a.f2594v.m3131b(this.f11197a.f2575c), this.f11197a.f2594v.m3129a(this.f11197a.f2575c), MraidNativeCommandHandler.m3125c(this.f11197a.f2575c), MraidNativeCommandHandler.isStorePictureSupported(this.f11197a.f2575c), this.f11197a.m3089h());
        this.f11197a.f2588p.m3066a(this.f11197a.f2576d);
        this.f11197a.f2588p.m3069a(this.f11197a.f2588p.m3073c());
        this.f11197a.f2588p.m3071b();
    }
}
