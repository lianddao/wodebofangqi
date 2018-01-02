package com.ushareit.listenit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public final class dag {
    private final Field f9456a;

    public dag(Field field) {
        dbw.m13748a((Object) field);
        this.f9456a = field;
    }

    public <T extends Annotation> T m13632a(Class<T> cls) {
        return this.f9456a.getAnnotation(cls);
    }
}
