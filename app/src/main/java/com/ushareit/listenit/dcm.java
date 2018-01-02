package com.ushareit.listenit;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

class dcm implements dda<T> {
    final /* synthetic */ Type f9534a;
    final /* synthetic */ dcb f9535b;

    dcm(dcb com_ushareit_listenit_dcb, Type type) {
        this.f9535b = com_ushareit_listenit_dcb;
        this.f9534a = type;
    }

    public T mo1710a() {
        if (this.f9534a instanceof ParameterizedType) {
            Type type = ((ParameterizedType) this.f9534a).getActualTypeArguments()[0];
            if (type instanceof Class) {
                return EnumSet.noneOf((Class) type);
            }
            String str = "Invalid EnumSet type: ";
            String valueOf = String.valueOf(this.f9534a.toString());
            throw new dbb(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        str = "Invalid EnumSet type: ";
        valueOf = String.valueOf(this.f9534a.toString());
        throw new dbb(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }
}
