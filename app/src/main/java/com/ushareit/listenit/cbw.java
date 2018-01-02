package com.ushareit.listenit;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

public final class cbw implements Comparator<Scope> {
    public int m10719a(Scope scope, Scope scope2) {
        return scope.m2248a().compareTo(scope2.m2248a());
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m10719a((Scope) obj, (Scope) obj2);
    }
}
