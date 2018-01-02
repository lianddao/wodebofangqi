package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.os.Parcelable.Creator;

public final class fe {
    public static <T> Creator<T> m18939a(fg<T> fgVar) {
        if (VERSION.SDK_INT >= 13) {
            return fi.m19217a(fgVar);
        }
        return new ff(fgVar);
    }
}
