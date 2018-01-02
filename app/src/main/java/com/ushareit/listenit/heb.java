package com.ushareit.listenit;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class heb {
    private static Toast f15245a;

    public static Toast m23596a(int i, int i2) {
        return m23597a(eys.m18562a().getString(i), i2);
    }

    public static Toast m23597a(CharSequence charSequence, int i) {
        View inflate;
        if (f15245a == null) {
            inflate = LayoutInflater.from(eys.m18562a()).inflate(C0349R.layout.toast_layout, null);
            ((TextView) inflate.findViewById(C0349R.id.toast_text)).setText(charSequence);
            f15245a = new Toast(eys.m18562a());
            f15245a.setGravity(80, 0, eys.m18562a().getResources().getDimensionPixelOffset(C0349R.dimen.common_dimens_100dp));
            f15245a.setDuration(i);
            f15245a.setView(inflate);
        } else {
            inflate = LayoutInflater.from(eys.m18562a()).inflate(C0349R.layout.toast_layout, null);
            ((TextView) inflate.findViewById(C0349R.id.toast_text)).setText(charSequence);
            f15245a.setDuration(i);
            f15245a.setView(inflate);
        }
        return f15245a;
    }
}
