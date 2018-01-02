package com.ushareit.listenit;

import android.graphics.Bitmap;
import java.io.File;
import java.io.InputStream;

public class acy implements aeb<yv, acq> {
    private final ux<File, acq> f4145a;
    private final ux<yv, acq> f4146b;
    private final uy<acq> f4147c;
    private final uu<yv> f4148d;

    public acy(aeb<yv, Bitmap> com_ushareit_listenit_aeb_com_ushareit_listenit_yv__android_graphics_Bitmap, aeb<InputStream, abx> com_ushareit_listenit_aeb_java_io_InputStream__com_ushareit_listenit_abx, ws wsVar) {
        ux com_ushareit_listenit_acs = new acs(com_ushareit_listenit_aeb_com_ushareit_listenit_yv__android_graphics_Bitmap.mo562b(), com_ushareit_listenit_aeb_java_io_InputStream__com_ushareit_listenit_abx.mo562b(), wsVar);
        this.f4145a = new abr(new acw(com_ushareit_listenit_acs));
        this.f4146b = com_ushareit_listenit_acs;
        this.f4147c = new acv(com_ushareit_listenit_aeb_com_ushareit_listenit_yv__android_graphics_Bitmap.mo564d(), com_ushareit_listenit_aeb_java_io_InputStream__com_ushareit_listenit_abx.mo564d());
        this.f4148d = com_ushareit_listenit_aeb_com_ushareit_listenit_yv__android_graphics_Bitmap.mo563c();
    }

    public ux<File, acq> mo561a() {
        return this.f4145a;
    }

    public ux<yv, acq> mo562b() {
        return this.f4146b;
    }

    public uu<yv> mo563c() {
        return this.f4148d;
    }

    public uy<acq> mo564d() {
        return this.f4147c;
    }
}
