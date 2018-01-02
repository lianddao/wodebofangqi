package com.ushareit.listenit;

import android.content.Context;
import android.content.SharedPreferences;

public class ckv {
    private static SharedPreferences f8397a = null;

    public static SharedPreferences m11522a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f8397a == null) {
                f8397a = (SharedPreferences) drd.m15310a(new ckw(context));
            }
            sharedPreferences = f8397a;
        }
        return sharedPreferences;
    }
}
