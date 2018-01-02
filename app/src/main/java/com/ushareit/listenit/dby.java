package com.ushareit.listenit;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

final class dby implements Serializable, GenericArrayType {
    private final Type f9508a;

    public dby(Type type) {
        this.f9508a = dbx.m13766d(type);
    }

    public boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && dbx.m13760a((Type) this, (GenericArrayType) obj);
    }

    public Type getGenericComponentType() {
        return this.f9508a;
    }

    public int hashCode() {
        return this.f9508a.hashCode();
    }

    public String toString() {
        return String.valueOf(dbx.m13768f(this.f9508a)).concat("[]");
    }
}
