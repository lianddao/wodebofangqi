package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.InputStream;

public class abf implements aeb<yv, Bitmap> {
    private final abe f4029a;
    private final ux<File, Bitmap> f4030b;
    private final uy<Bitmap> f4031c;
    private final yw f4032d;

    public abf(aeb<InputStream, Bitmap> com_ushareit_listenit_aeb_java_io_InputStream__android_graphics_Bitmap, aeb<ParcelFileDescriptor, Bitmap> com_ushareit_listenit_aeb_android_os_ParcelFileDescriptor__android_graphics_Bitmap) {
        this.f4031c = com_ushareit_listenit_aeb_java_io_InputStream__android_graphics_Bitmap.mo564d();
        this.f4032d = new yw(com_ushareit_listenit_aeb_java_io_InputStream__android_graphics_Bitmap.mo563c(), com_ushareit_listenit_aeb_android_os_ParcelFileDescriptor__android_graphics_Bitmap.mo563c());
        this.f4030b = com_ushareit_listenit_aeb_java_io_InputStream__android_graphics_Bitmap.mo561a();
        this.f4029a = new abe(com_ushareit_listenit_aeb_java_io_InputStream__android_graphics_Bitmap.mo562b(), com_ushareit_listenit_aeb_android_os_ParcelFileDescriptor__android_graphics_Bitmap.mo562b());
    }

    public ux<File, Bitmap> mo561a() {
        return this.f4030b;
    }

    public ux<yv, Bitmap> mo562b() {
        return this.f4029a;
    }

    public uu<yv> mo563c() {
        return this.f4032d;
    }

    public uy<Bitmap> mo564d() {
        return this.f4031c;
    }
}
