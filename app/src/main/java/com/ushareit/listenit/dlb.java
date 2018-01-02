package com.ushareit.listenit;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;

public final class dlb extends cha<dlf> {
    private final Bundle f9874d;

    public dlb(Context context, Looper looper, cgs com_ushareit_listenit_cgs, cdb com_ushareit_listenit_cdb, ceb com_ushareit_listenit_ceb, cec com_ushareit_listenit_cec) {
        super(context, looper, 16, com_ushareit_listenit_cgs, com_ushareit_listenit_ceb, com_ushareit_listenit_cec);
        this.f9874d = com_ushareit_listenit_cdb == null ? new Bundle() : com_ushareit_listenit_cdb.m10873a();
    }

    protected dlf m14747a(IBinder iBinder) {
        return dlg.m14761a(iBinder);
    }

    protected String mo1243a() {
        return "com.google.android.gms.auth.service.START";
    }

    protected /* synthetic */ IInterface mo1244b(IBinder iBinder) {
        return m14747a(iBinder);
    }

    protected String mo1245b() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    protected Bundle mo1246c() {
        return this.f9874d;
    }

    public boolean mo1936j() {
        cgs x = mo1242x();
        return (TextUtils.isEmpty(x.m11178a()) || x.m11179a(ccz.f8138b).isEmpty()) ? false : true;
    }
}
