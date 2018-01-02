package com.ushareit.listenit;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.View;

public class gdb {
    private static gdb f13940a;
    private Bitmap f13941b;
    private Bitmap f13942c;

    private gdb() {
    }

    public static gdb m21731a() {
        if (f13940a == null) {
            synchronized (gdb.class) {
                if (f13940a == null) {
                    f13940a = new gdb();
                }
            }
        }
        return f13940a;
    }

    private static Bitmap m21732b(Context context) {
        try {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) WallpaperManager.getInstance(context).getDrawable();
            if (bitmapDrawable == null) {
                return BitmapFactory.decodeResource(context.getResources(), C0349R.drawable.keyguard_bg);
            }
            return m21730a(context, bitmapDrawable.getBitmap());
        } catch (Throwable th) {
            exw.m18457e("WallpaperManagerHelper", th.toString());
            return null;
        }
    }

    private static Bitmap m21730a(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            return BitmapFactory.decodeResource(context.getResources(), C0349R.drawable.keyguard_bg);
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == 0 || height == 0) {
            return BitmapFactory.decodeResource(context.getResources(), C0349R.drawable.keyguard_bg);
        }
        int i;
        int i2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f = ((float) displayMetrics.widthPixels) / ((float) displayMetrics.heightPixels);
        if (((float) width) / ((float) height) > f) {
            i = height;
            i2 = (int) (f * ((float) height));
        } else {
            i = (int) (((float) width) / f);
            i2 = width;
        }
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return Bitmap.createBitmap(iArr, 0, width, i2, i, Config.RGB_565);
    }

    public void m21733a(Context context) {
        try {
            this.f13941b = m21732b(context);
            if (this.f13941b != null) {
                int width = this.f13941b.getWidth();
                int height = this.f13941b.getHeight();
                if (width > 0 && height > 0) {
                    this.f13941b = Bitmap.createScaledBitmap(this.f13941b, (int) (((float) width) * 0.66f), (int) (((float) height) * 0.66f), false);
                }
            }
        } catch (Exception e) {
        }
    }

    public void m21734a(View view) {
        if (this.f13941b == null) {
            m21733a(view.getContext());
        }
        if (this.f13941b != null) {
            view.setBackgroundDrawable(new BitmapDrawable(this.f13941b));
        }
    }

    public void m21735b() {
        this.f13941b = null;
        this.f13942c = null;
        f13940a = null;
    }
}
