package com.ushareit.listenit;

import android.view.View;

public class fjx {
    public static boolean m19569a(View view) {
        try {
            Object tag = view.getTag(C0349R.id.tag_click_time);
            long longValue = tag == null ? 0 : ((Long) tag).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue < 500) {
                return true;
            }
            view.setTag(C0349R.id.tag_click_time, Long.valueOf(currentTimeMillis));
            return false;
        } catch (Exception e) {
        }
    }

    public static boolean m19570b(View view) {
        try {
            Object tag = view.getTag(C0349R.id.tag_click_time);
            long longValue = tag == null ? 0 : ((Long) tag).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            view.setTag(C0349R.id.tag_click_time, Long.valueOf(currentTimeMillis));
            if (currentTimeMillis - longValue < 500) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
}
