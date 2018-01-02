package com.ushareit.listenit;

import android.view.View;

class lu {
    public static void m24675a(View view, long j) {
        view.animate().setDuration(j);
    }

    public static void m24674a(View view, float f) {
        view.animate().alpha(f);
    }

    public static void m24678b(View view, float f) {
        view.animate().translationX(f);
    }

    public static void m24679c(View view, float f) {
        view.animate().translationY(f);
    }

    public static void m24673a(View view) {
        view.animate().cancel();
    }

    public static void m24677b(View view) {
        view.animate().start();
    }

    public static void m24676a(View view, ly lyVar) {
        if (lyVar != null) {
            view.animate().setListener(new lv(lyVar, view));
        } else {
            view.animate().setListener(null);
        }
    }
}
