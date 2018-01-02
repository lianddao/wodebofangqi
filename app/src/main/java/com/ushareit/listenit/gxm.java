package com.ushareit.listenit;

import android.graphics.Bitmap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class gxm {
    private static final int f14865a = Runtime.getRuntime().availableProcessors();
    private static final ExecutorService f14866b = Executors.newFixedThreadPool(f14865a);

    public static void m23097a(Bitmap bitmap, String str, gxs com_ushareit_listenit_gxs) {
        m23095a(bitmap, str, 30, 0, com_ushareit_listenit_gxs);
    }

    public static void m23096a(Bitmap bitmap, String str, int i, gxs com_ushareit_listenit_gxs) {
        m23095a(bitmap, str, 30, i, com_ushareit_listenit_gxs);
    }

    public static void m23094a(Bitmap bitmap, String str, int i, int i2, int i3, gxs com_ushareit_listenit_gxs) {
        hhx.m23869a(new gxo(str, bitmap, i2, i3, com_ushareit_listenit_gxs), i, 0);
    }

    public static void m23095a(Bitmap bitmap, String str, int i, int i2, gxs com_ushareit_listenit_gxs) {
        hhx.m23869a(new gxp(str, bitmap, i, com_ushareit_listenit_gxs), i2, 0);
    }
}
