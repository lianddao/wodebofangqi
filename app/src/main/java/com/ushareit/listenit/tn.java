package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

public class tn<ModelType> extends tm<ModelType, Bitmap> {
    private final ze<ModelType, InputStream> f16799g;
    private final ze<ModelType, ParcelFileDescriptor> f16800h;
    private final tt f16801i;
    private final ub f16802j;

    private static <A, R> aee<A, yv, Bitmap, R> m26411a(tt ttVar, ze<A, InputStream> zeVar, ze<A, ParcelFileDescriptor> zeVar2, Class<R> cls, adb<Bitmap, R> com_ushareit_listenit_adb_android_graphics_Bitmap__R) {
        if (zeVar == null && zeVar2 == null) {
            return null;
        }
        if (com_ushareit_listenit_adb_android_graphics_Bitmap__R == null) {
            com_ushareit_listenit_adb_android_graphics_Bitmap__R = ttVar.m26456a(Bitmap.class, (Class) cls);
        }
        return new aee(new yt(zeVar, zeVar2), com_ushareit_listenit_adb_android_graphics_Bitmap__R, ttVar.m26461b(yv.class, Bitmap.class));
    }

    tn(tq<ModelType, ?, ?, ?> tqVar, ze<ModelType, InputStream> zeVar, ze<ModelType, ParcelFileDescriptor> zeVar2, ub ubVar) {
        super(m26411a(tqVar.f16770c, zeVar, zeVar2, Bitmap.class, null), Bitmap.class, tqVar);
        this.f16799g = zeVar;
        this.f16800h = zeVar2;
        this.f16801i = tqVar.f16770c;
        this.f16802j = ubVar;
    }
}
