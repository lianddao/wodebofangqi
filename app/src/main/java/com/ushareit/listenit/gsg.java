package com.ushareit.listenit;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Audio.Media;

public class gsg {
    private int f14638a;
    private Handler f14639b = new Handler(Looper.getMainLooper());
    private ContentObserver f14640c = new gsh(this, this.f14639b);
    private Runnable f14641d = new gsi(this);

    public void m22681a(Context context) {
        context.getContentResolver().registerContentObserver(Media.EXTERNAL_CONTENT_URI, true, this.f14640c);
        this.f14638a = grz.m22656a().m22665b(context);
    }

    public void m22682b(Context context) {
        try {
            context.getContentResolver().unregisterContentObserver(this.f14640c);
        } catch (Exception e) {
        }
    }
}
