package com.ushareit.listenit;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class cdg extends Handler {
    private final Context f8152a;

    public cdg(Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f8152a = context.getApplicationContext();
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.f8152a);
                if (GooglePlayServicesUtil.isUserRecoverableError(isGooglePlayServicesAvailable)) {
                    GooglePlayServicesUtil.zza(isGooglePlayServicesAvailable, this.f8152a);
                    return;
                }
                return;
            default:
                Log.w("GooglePlayServicesUtil", "Don't know how to handle this message: " + message.what);
                return;
        }
    }
}
