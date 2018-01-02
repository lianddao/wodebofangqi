package com.ushareit.listenit;

import android.view.View;

class lw {
    public static void m24680a(View view, ly lyVar) {
        if (lyVar != null) {
            view.animate().setListener(new lx(lyVar, view));
        } else {
            view.animate().setListener(null);
        }
    }
}
