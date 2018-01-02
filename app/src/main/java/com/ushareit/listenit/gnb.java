package com.ushareit.listenit;

import android.graphics.Bitmap;
import com.ushareit.listenit.nearby.widget.SongsMenuBlurView;

public class gnb extends hhw {
    final /* synthetic */ fnl f14438a;
    final /* synthetic */ SongsMenuBlurView f14439b;
    private Bitmap f14440c;

    public gnb(SongsMenuBlurView songsMenuBlurView, fnl com_ushareit_listenit_fnl) {
        this.f14439b = songsMenuBlurView;
        this.f14438a = com_ushareit_listenit_fnl;
    }

    public void execute() {
        this.f14440c = gyn.m23173a(m22467c(), this.f14439b.f16032b.getWidth(), this.f14439b.f16032b.getHeight());
    }

    public void callback() {
        if (this.f14440c != null) {
            gxm.m23097a(this.f14440c, "songmenuBlurTask", this.f14439b.f16035e);
            this.f14439b.f16032b.setImageBitmap(this.f14440c);
        }
    }

    private int m22467c() {
        return this.f14438a.getId().charAt(0) % 18;
    }
}
