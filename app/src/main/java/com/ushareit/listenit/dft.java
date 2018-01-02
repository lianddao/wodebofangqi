package com.ushareit.listenit;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class dft<T> {
    final Class<? super T> f9732a;
    final Type f9733b;
    final int f9734c;

    protected dft() {
        this.f9733b = m14118a(getClass());
        this.f9732a = dbx.m13767e(this.f9733b);
        this.f9734c = this.f9733b.hashCode();
    }

    dft(Type type) {
        this.f9733b = dbx.m13766d((Type) dbw.m13748a((Object) type));
        this.f9732a = dbx.m13767e(this.f9733b);
        this.f9734c = this.f9733b.hashCode();
    }

    public static dft<?> m14117a(Type type) {
        return new dft(type);
    }

    static Type m14118a(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            return dbx.m13766d(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public static <T> dft<T> m14119b(Class<T> cls) {
        return new dft(cls);
    }

    public final Class<? super T> m14120a() {
        return this.f9732a;
    }

    public final Type m14121b() {
        return this.f9733b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof dft) && dbx.m13760a(this.f9733b, ((dft) obj).f9733b);
    }

    public final int hashCode() {
        return this.f9734c;
    }

    public final String toString() {
        return dbx.m13768f(this.f9733b);
    }
}
