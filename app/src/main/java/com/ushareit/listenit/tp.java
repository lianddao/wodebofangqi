package com.ushareit.listenit;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

public class tp<ModelType> extends to<ModelType> {
    private final ze<ModelType, InputStream> f16803g;
    private final ze<ModelType, ParcelFileDescriptor> f16804h;
    private final ub f16805i;

    private static <A, Z, R> aee<A, yv, Z, R> m26446a(tt ttVar, ze<A, InputStream> zeVar, ze<A, ParcelFileDescriptor> zeVar2, Class<Z> cls, Class<R> cls2, adb<Z, R> com_ushareit_listenit_adb_Z__R) {
        if (zeVar == null && zeVar2 == null) {
            return null;
        }
        if (com_ushareit_listenit_adb_Z__R == null) {
            com_ushareit_listenit_adb_Z__R = ttVar.m26456a((Class) cls, (Class) cls2);
        }
        return new aee(new yt(zeVar, zeVar2), com_ushareit_listenit_adb_Z__R, ttVar.m26461b(yv.class, (Class) cls));
    }

    tp(Class<ModelType> cls, ze<ModelType, InputStream> zeVar, ze<ModelType, ParcelFileDescriptor> zeVar2, Context context, tt ttVar, adu com_ushareit_listenit_adu, adm com_ushareit_listenit_adm, ub ubVar) {
        super(context, cls, m26446a(ttVar, zeVar, zeVar2, acq.class, abo.class, null), ttVar, com_ushareit_listenit_adu, com_ushareit_listenit_adm);
        this.f16803g = zeVar;
        this.f16804h = zeVar2;
        this.f16805i = ubVar;
    }

    public tn<ModelType> m26447j() {
        return (tn) this.f16805i.m26495a(new tn(this, this.f16803g, this.f16804h, this.f16805i));
    }
}
