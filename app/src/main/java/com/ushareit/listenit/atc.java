package com.ushareit.listenit;

import android.graphics.Bitmap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class atc {
    static final int f5400a = Runtime.getRuntime().availableProcessors();
    static final ExecutorService f5401b = Executors.newFixedThreadPool(f5400a);
    private static volatile boolean f5402c = true;
    private final Bitmap f5403d;
    private Bitmap f5404e;
    private final aud f5405f = new aur();

    public atc(Bitmap bitmap) {
        this.f5403d = bitmap;
    }

    public Bitmap m7116a() {
        return this.f5404e;
    }

    public Bitmap m7117a(int i) {
        this.f5404e = this.f5405f.mo803a(this.f5403d, (float) i);
        return this.f5404e;
    }
}
