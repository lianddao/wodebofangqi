package com.ushareit.listenit;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.internal.SignInButtonConfig;

public final class cfm extends ckk<cib> {
    private static final cfm f8218a = new cfm();

    private cfm() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View m11102a(Context context, int i, int i2) {
        return f8218a.m11103b(context, i, i2);
    }

    private View m11103b(Context context, int i, int i2) {
        try {
            SignInButtonConfig signInButtonConfig = new SignInButtonConfig(i, i2, null);
            return (View) ckj.m11513a(((cib) m10057b(context)).mo1369a(ckj.m11512a((Object) context), signInButtonConfig));
        } catch (Throwable e) {
            throw new ckl("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    public cib m11104a(IBinder iBinder) {
        return cic.m11354a(iBinder);
    }

    public /* synthetic */ Object mo1119b(IBinder iBinder) {
        return m11104a(iBinder);
    }
}
