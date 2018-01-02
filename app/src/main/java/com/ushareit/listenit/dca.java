package com.ushareit.listenit;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

final class dca implements Serializable, WildcardType {
    private final Type f9513a;
    private final Type f9514b;

    public dca(Type[] typeArr, Type[] typeArr2) {
        boolean z = true;
        dbw.m13749a(typeArr2.length <= 1);
        dbw.m13749a(typeArr.length == 1);
        if (typeArr2.length == 1) {
            dbw.m13748a(typeArr2[0]);
            dbx.m13771i(typeArr2[0]);
            if (typeArr[0] != Object.class) {
                z = false;
            }
            dbw.m13749a(z);
            this.f9514b = dbx.m13766d(typeArr2[0]);
            this.f9513a = Object.class;
            return;
        }
        dbw.m13748a(typeArr[0]);
        dbx.m13771i(typeArr[0]);
        this.f9514b = null;
        this.f9513a = dbx.m13766d(typeArr[0]);
    }

    public boolean equals(Object obj) {
        return (obj instanceof WildcardType) && dbx.m13760a((Type) this, (WildcardType) obj);
    }

    public Type[] getLowerBounds() {
        if (this.f9514b == null) {
            return dbx.f9507a;
        }
        return new Type[]{this.f9514b};
    }

    public Type[] getUpperBounds() {
        return new Type[]{this.f9513a};
    }

    public int hashCode() {
        return (this.f9514b != null ? this.f9514b.hashCode() + 31 : 1) ^ (this.f9513a.hashCode() + 31);
    }

    public String toString() {
        String str;
        String valueOf;
        if (this.f9514b != null) {
            str = "? super ";
            valueOf = String.valueOf(dbx.m13768f(this.f9514b));
            return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        } else if (this.f9513a == Object.class) {
            return "?";
        } else {
            str = "? extends ";
            valueOf = String.valueOf(dbx.m13768f(this.f9513a));
            return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        }
    }
}
