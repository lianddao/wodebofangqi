package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

class wo implements xa {
    private final wq f17484a = new wq();
    private final wu<wp, Bitmap> f17485b = new wu();

    wo() {
    }

    public void mo3122a(Bitmap bitmap) {
        this.f17485b.m27156a(this.f17484a.m27138a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    public Bitmap mo3121a(int i, int i2, Config config) {
        return (Bitmap) this.f17485b.m27155a(this.f17484a.m27138a(i, i2, config));
    }

    public Bitmap mo3120a() {
        return (Bitmap) this.f17485b.m27154a();
    }

    public String mo3124b(Bitmap bitmap) {
        return m27124d(bitmap);
    }

    public String mo3123b(int i, int i2, Config config) {
        return m27123d(i, i2, config);
    }

    public int mo3125c(Bitmap bitmap) {
        return afu.m5492a(bitmap);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f17485b;
    }

    private static String m27124d(Bitmap bitmap) {
        return m27123d(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    private static String m27123d(int i, int i2, Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }
}
