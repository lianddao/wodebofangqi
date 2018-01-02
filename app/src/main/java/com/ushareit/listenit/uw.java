package com.ushareit.listenit;

import java.util.Arrays;
import java.util.Collection;

public class uw<T> implements uz<T> {
    private final Collection<? extends uz<T>> f17001a;
    private String f17002b;

    @SafeVarargs
    public uw(uz<T>... uzVarArr) {
        if (uzVarArr.length < 1) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.f17001a = Arrays.asList(uzVarArr);
    }

    public wk<T> mo556a(wk<T> wkVar, int i, int i2) {
        wk<T> wkVar2 = wkVar;
        for (uz a : this.f17001a) {
            wk<T> a2 = a.mo556a(wkVar2, i, i2);
            if (!(wkVar2 == null || wkVar2.equals(wkVar) || wkVar2.equals(a2))) {
                wkVar2.mo555d();
            }
            wkVar2 = a2;
        }
        return wkVar2;
    }

    public String mo557a() {
        if (this.f17002b == null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (uz a : this.f17001a) {
                stringBuilder.append(a.mo557a());
            }
            this.f17002b = stringBuilder.toString();
        }
        return this.f17002b;
    }
}
