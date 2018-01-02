package com.ushareit.listenit;

import android.content.Context;

public class ts<ModelType, DataType, ResourceType> extends tq<ModelType, DataType, ResourceType, ResourceType> {
    private final ze<ModelType, DataType> f16807g;
    private final Class<DataType> f16808h;
    private final Class<ResourceType> f16809i;
    private final ub f16810j;

    private static <A, T, Z, R> aef<A, T, Z, R> m26448a(tt ttVar, ze<A, T> zeVar, Class<T> cls, Class<Z> cls2, adb<Z, R> com_ushareit_listenit_adb_Z__R) {
        return new aee(zeVar, com_ushareit_listenit_adb_Z__R, ttVar.m26461b((Class) cls, (Class) cls2));
    }

    ts(Context context, tt ttVar, Class<ModelType> cls, ze<ModelType, DataType> zeVar, Class<DataType> cls2, Class<ResourceType> cls3, adu com_ushareit_listenit_adu, adm com_ushareit_listenit_adm, ub ubVar) {
        super(context, cls, m26448a(ttVar, zeVar, cls2, cls3, add.m5264b()), cls3, ttVar, com_ushareit_listenit_adu, com_ushareit_listenit_adm);
        this.f16807g = zeVar;
        this.f16808h = cls2;
        this.f16809i = cls3;
        this.f16810j = ubVar;
    }
}
