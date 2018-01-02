package com.ushareit.listenit;

import com.mopub.mraid.MraidBridge;
import com.mopub.mraid.MraidController;
import com.mopub.mraid.MraidNativeCommandHandler;

public class eld implements Runnable {
    final /* synthetic */ MraidController f11198a;

    public eld(MraidController mraidController) {
        this.f11198a = mraidController;
    }

    public void run() {
        MraidBridge b = this.f11198a.f2589q;
        boolean b2 = this.f11198a.f2594v.m3131b(this.f11198a.f2575c);
        boolean a = this.f11198a.f2594v.m3129a(this.f11198a.f2575c);
        this.f11198a.f2594v;
        boolean c = MraidNativeCommandHandler.m3125c(this.f11198a.f2575c);
        this.f11198a.f2594v;
        b.m3070a(b2, a, c, MraidNativeCommandHandler.isStorePictureSupported(this.f11198a.f2575c), this.f11198a.m3089h());
        this.f11198a.f2589q.m3067a(this.f11198a.f2582j);
        this.f11198a.f2589q.m3066a(this.f11198a.f2576d);
        this.f11198a.f2589q.m3069a(this.f11198a.f2589q.m3073c());
        this.f11198a.f2589q.m3071b();
    }
}
