package com.ushareit.listenit;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

public abstract class cha<T extends IInterface> extends cfs<T> implements cdt, che {
    private final cgs f8070d;
    private final Set<Scope> f8071e;
    private final Account f8072f;

    protected cha(Context context, Looper looper, int i, cgs com_ushareit_listenit_cgs, ceb com_ushareit_listenit_ceb, cec com_ushareit_listenit_cec) {
        this(context, looper, chf.m11221a(context), cdd.m10887a(), i, com_ushareit_listenit_cgs, (ceb) cfi.m11080a((Object) com_ushareit_listenit_ceb), (cec) cfi.m11080a((Object) com_ushareit_listenit_cec));
    }

    protected cha(Context context, Looper looper, chf com_ushareit_listenit_chf, cdd com_ushareit_listenit_cdd, int i, cgs com_ushareit_listenit_cgs, ceb com_ushareit_listenit_ceb, cec com_ushareit_listenit_cec) {
        super(context, looper, com_ushareit_listenit_chf, com_ushareit_listenit_cdd, i, m10651a(com_ushareit_listenit_ceb), m10652a(com_ushareit_listenit_cec), com_ushareit_listenit_cgs.m11187h());
        this.f8070d = com_ushareit_listenit_cgs;
        this.f8072f = com_ushareit_listenit_cgs.m11181b();
        this.f8071e = m10653b(com_ushareit_listenit_cgs.m11184e());
    }

    private static cfu m10651a(ceb com_ushareit_listenit_ceb) {
        return com_ushareit_listenit_ceb == null ? null : new chb(com_ushareit_listenit_ceb);
    }

    private static cfv m10652a(cec com_ushareit_listenit_cec) {
        return com_ushareit_listenit_cec == null ? null : new chc(com_ushareit_listenit_cec);
    }

    private Set<Scope> m10653b(Set<Scope> set) {
        Set<Scope> a = m10654a((Set) set);
        for (Scope contains : a) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return a;
    }

    protected Set<Scope> m10654a(Set<Scope> set) {
        return set;
    }

    public final Account mo1240q() {
        return this.f8072f;
    }

    protected final Set<Scope> mo1241w() {
        return this.f8071e;
    }

    protected final cgs mo1242x() {
        return this.f8070d;
    }
}
