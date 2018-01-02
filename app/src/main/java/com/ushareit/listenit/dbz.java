package com.ushareit.listenit;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

final class dbz implements Serializable, ParameterizedType {
    private final Type f9509a;
    private final Type f9510b;
    private final Type[] f9511c;

    public dbz(Type type, Type type2, Type... typeArr) {
        int i = 0;
        if (type2 instanceof Class) {
            Class cls = (Class) type2;
            int i2 = (Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null) ? 1 : 0;
            boolean z = (type == null && i2 == 0) ? false : true;
            dbw.m13749a(z);
        }
        this.f9509a = type == null ? null : dbx.m13766d(type);
        this.f9510b = dbx.m13766d(type2);
        this.f9511c = (Type[]) typeArr.clone();
        while (i < this.f9511c.length) {
            dbw.m13748a(this.f9511c[i]);
            dbx.m13771i(this.f9511c[i]);
            this.f9511c[i] = dbx.m13766d(this.f9511c[i]);
            i++;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && dbx.m13760a((Type) this, (ParameterizedType) obj);
    }

    public Type[] getActualTypeArguments() {
        return (Type[]) this.f9511c.clone();
    }

    public Type getOwnerType() {
        return this.f9509a;
    }

    public Type getRawType() {
        return this.f9510b;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f9511c) ^ this.f9510b.hashCode()) ^ dbx.m13761b(this.f9509a);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder((this.f9511c.length + 1) * 30);
        stringBuilder.append(dbx.m13768f(this.f9510b));
        if (this.f9511c.length == 0) {
            return stringBuilder.toString();
        }
        stringBuilder.append("<").append(dbx.m13768f(this.f9511c[0]));
        for (int i = 1; i < this.f9511c.length; i++) {
            stringBuilder.append(", ").append(dbx.m13768f(this.f9511c[i]));
        }
        return stringBuilder.append(">").toString();
    }
}
