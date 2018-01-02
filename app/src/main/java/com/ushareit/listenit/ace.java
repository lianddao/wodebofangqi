package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.os.Handler;

class ace extends afe<Bitmap> {
    private final Handler f4107a;
    private final int f4108b;
    private final long f4109c;
    private Bitmap f4110d;

    public ace(Handler handler, int i, long j) {
        this.f4107a = handler;
        this.f4108b = i;
        this.f4109c = j;
    }

    public Bitmap m5189a() {
        return this.f4110d;
    }

    public void m5190a(Bitmap bitmap, aeq<? super Bitmap> com_ushareit_listenit_aeq__super_android_graphics_Bitmap) {
        this.f4110d = bitmap;
        this.f4107a.sendMessageAtTime(this.f4107a.obtainMessage(1, this), this.f4109c);
    }
}
