package com.ushareit.listenit;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class cks implements Callable<Long> {
    final /* synthetic */ SharedPreferences f8391a;
    final /* synthetic */ String f8392b;
    final /* synthetic */ Long f8393c;

    cks(SharedPreferences sharedPreferences, String str, Long l) {
        this.f8391a = sharedPreferences;
        this.f8392b = str;
        this.f8393c = l;
    }

    public Long m11519a() {
        return Long.valueOf(this.f8391a.getLong(this.f8392b, this.f8393c.longValue()));
    }

    public /* synthetic */ Object call() {
        return m11519a();
    }
}
