package com.ushareit.listenit;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public final class dcb {
    private final Map<Type, daw<?>> f9515a;

    public dcb(Map<Type, daw<?>> map) {
        this.f9515a = map;
    }

    private <T> dda<T> m13774a(Class<? super T> cls) {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new dck(this, declaredConstructor);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private <T> dda<T> m13775a(Type type, Class<? super T> cls) {
        return Collection.class.isAssignableFrom(cls) ? SortedSet.class.isAssignableFrom(cls) ? new dcl(this) : EnumSet.class.isAssignableFrom(cls) ? new dcm(this, type) : Set.class.isAssignableFrom(cls) ? new dcn(this) : Queue.class.isAssignableFrom(cls) ? new dcd(this) : new dce(this) : Map.class.isAssignableFrom(cls) ? SortedMap.class.isAssignableFrom(cls) ? new dcf(this) : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(dft.m14117a(((ParameterizedType) type).getActualTypeArguments()[0]).m14120a())) ? new dch(this) : new dcg(this) : null;
    }

    private <T> dda<T> m13776b(Type type, Class<? super T> cls) {
        return new dci(this, cls, type);
    }

    public <T> dda<T> m13777a(dft<T> com_ushareit_listenit_dft_T) {
        Type b = com_ushareit_listenit_dft_T.m14121b();
        Class a = com_ushareit_listenit_dft_T.m14120a();
        daw com_ushareit_listenit_daw = (daw) this.f9515a.get(b);
        if (com_ushareit_listenit_daw != null) {
            return new dcc(this, com_ushareit_listenit_daw, b);
        }
        com_ushareit_listenit_daw = (daw) this.f9515a.get(a);
        if (com_ushareit_listenit_daw != null) {
            return new dcj(this, com_ushareit_listenit_daw, b);
        }
        dda<T> a2 = m13774a(a);
        if (a2 != null) {
            return a2;
        }
        a2 = m13775a(b, a);
        return a2 == null ? m13776b(b, a) : a2;
    }

    public String toString() {
        return this.f9515a.toString();
    }
}
