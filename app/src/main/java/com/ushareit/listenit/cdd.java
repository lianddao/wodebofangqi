package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiActivity;

public class cdd extends cjb {
    public static final int f8147a = cjb.f8146b;
    private static final cdd f8148c = new cdd();

    cdd() {
    }

    public static cdd m10887a() {
        return f8148c;
    }

    public int mo1287a(Context context) {
        return super.mo1287a(context);
    }

    public Dialog m10889a(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        return m10891a((Context) activity, i, cgv.m11198a(activity, mo1290a((Context) activity, i, "d"), i2), onCancelListener);
    }

    public Dialog m10890a(Activity activity, OnCancelListener onCancelListener) {
        View progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        Builder builder = new Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(cgu.m11195c(activity, 18));
        builder.setTitle(cgu.m11191a((Context) activity, 18));
        builder.setPositiveButton("", null);
        Dialog create = builder.create();
        m10897a(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    @TargetApi(14)
    public Dialog m10891a(Context context, int i, cgv com_ushareit_listenit_cgv, OnCancelListener onCancelListener) {
        Builder builder = null;
        if (i == 0) {
            return null;
        }
        if (cir.m11399a(context) && i == 2) {
            i = 42;
        }
        if (ciu.m11408d()) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16843529, typedValue, true);
            if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
                builder = new Builder(context, 5);
            }
        }
        if (builder == null) {
            builder = new Builder(context);
        }
        builder.setMessage(cgu.m11195c(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        CharSequence e = cgu.m11197e(context, i);
        if (e != null) {
            builder.setPositiveButton(e, com_ushareit_listenit_cgv);
        }
        e = cgu.m11191a(context, i);
        if (e != null) {
            builder.setTitle(e);
        }
        return builder.create();
    }

    public PendingIntent mo1288a(Context context, int i, int i2) {
        return super.mo1288a(context, i, i2);
    }

    public PendingIntent mo1289a(Context context, int i, int i2, String str) {
        return super.mo1289a(context, i, i2, str);
    }

    public PendingIntent m10894a(Context context, ConnectionResult connectionResult) {
        if (connectionResult.m2234a()) {
            return connectionResult.m2237d();
        }
        int c = connectionResult.m2236c();
        if (cir.m11399a(context) && c == 2) {
            c = 42;
        }
        return mo1288a(context, c, 0);
    }

    public Intent mo1290a(Context context, int i, String str) {
        return super.mo1290a(context, i, str);
    }

    public dnu m10896a(Context context, dnv com_ushareit_listenit_dnv) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        BroadcastReceiver com_ushareit_listenit_dnu = new dnu(com_ushareit_listenit_dnv);
        context.registerReceiver(com_ushareit_listenit_dnu, intentFilter);
        com_ushareit_listenit_dnu.m15138a(context);
        if (m10883a(context, "com.google.android.gms")) {
            return com_ushareit_listenit_dnu;
        }
        com_ushareit_listenit_dnv.mo1955a();
        com_ushareit_listenit_dnu.m15137a();
        return null;
    }

    @TargetApi(11)
    public void m10897a(Activity activity, Dialog dialog, String str, OnCancelListener onCancelListener) {
        boolean z;
        try {
            z = activity instanceof ak;
        } catch (NoClassDefFoundError e) {
            z = false;
        }
        if (z) {
            cdh.m10905a(dialog, onCancelListener).mo1295a(((ak) activity).m709f(), str);
        } else if (ciu.m11404a()) {
            cdc.m10874a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        } else {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
    }

    public void m10898a(Context context, ConnectionResult connectionResult, int i) {
        PendingIntent a = m10894a(context, connectionResult);
        if (a != null) {
            GooglePlayServicesUtil.zza(connectionResult.m2236c(), context, GoogleApiActivity.m2242a(context, a, i));
        }
    }

    public final boolean mo1291a(int i) {
        return super.mo1291a(i);
    }

    public boolean m10900a(Activity activity, doe com_ushareit_listenit_doe, int i, int i2, OnCancelListener onCancelListener) {
        Dialog a = m10891a((Context) activity, i, cgv.m11200a(com_ushareit_listenit_doe, mo1290a((Context) activity, i, "d"), i2), onCancelListener);
        if (a == null) {
            return false;
        }
        m10897a(activity, a, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    public boolean mo1292a(Context context, int i) {
        return super.mo1292a(context, i);
    }

    public int mo1293b(Context context) {
        return super.mo1293b(context);
    }

    @Deprecated
    public Intent mo1294b(int i) {
        return super.mo1294b(i);
    }

    public boolean m10904b(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        Dialog a = m10889a(activity, i, i2, onCancelListener);
        if (a == null) {
            return false;
        }
        m10897a(activity, a, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }
}
