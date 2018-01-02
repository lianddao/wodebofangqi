package com.ushareit.listenit;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Looper;
import java.io.IOException;

public class ezy {
    public static String m18664a(Context context) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        ServiceConnection com_ushareit_listenit_faa = new faa();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, com_ushareit_listenit_faa, 1)) {
            try {
                String a = new fab(com_ushareit_listenit_faa.m18680a()).m18681a();
                return a;
            } finally {
                context.unbindService(com_ushareit_listenit_faa);
            }
        } else {
            throw new IOException("Google Play connection failed");
        }
    }
}
