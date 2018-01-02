package com.ushareit.listenit;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

public class cfn<T extends IInterface> extends cha<T> {
    private final cdv<T> f8219d;

    public cfn(Context context, Looper looper, int i, ceb com_ushareit_listenit_ceb, cec com_ushareit_listenit_cec, cgs com_ushareit_listenit_cgs, cdv<T> com_ushareit_listenit_cdv_T) {
        super(context, looper, i, com_ushareit_listenit_cgs, com_ushareit_listenit_ceb, com_ushareit_listenit_cec);
        this.f8219d = com_ushareit_listenit_cdv_T;
    }

    protected String mo1243a() {
        return this.f8219d.m10915a();
    }

    protected void mo1303a(int i, T t) {
        this.f8219d.m10916a(i, t);
    }

    protected T mo1244b(IBinder iBinder) {
        return this.f8219d.m10914a(iBinder);
    }

    protected String mo1245b() {
        return this.f8219d.m10917b();
    }

    public cdv<T> mo1281f() {
        return this.f8219d;
    }
}
