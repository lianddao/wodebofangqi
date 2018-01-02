package com.ushareit.listenit;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class ckq implements Callable<Integer> {
    final /* synthetic */ SharedPreferences f8388a;
    final /* synthetic */ String f8389b;
    final /* synthetic */ Integer f8390c;

    ckq(SharedPreferences sharedPreferences, String str, Integer num) {
        this.f8388a = sharedPreferences;
        this.f8389b = str;
        this.f8390c = num;
    }

    public Integer m11517a() {
        return Integer.valueOf(this.f8388a.getInt(this.f8389b, this.f8390c.intValue()));
    }

    public /* synthetic */ Object call() {
        return m11517a();
    }
}
