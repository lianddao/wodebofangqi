package com.ushareit.listenit;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class cku implements Callable<String> {
    final /* synthetic */ SharedPreferences f8394a;
    final /* synthetic */ String f8395b;
    final /* synthetic */ String f8396c;

    cku(SharedPreferences sharedPreferences, String str, String str2) {
        this.f8394a = sharedPreferences;
        this.f8395b = str;
        this.f8396c = str2;
    }

    public String m11521a() {
        return this.f8394a.getString(this.f8395b, this.f8396c);
    }

    public /* synthetic */ Object call() {
        return m11521a();
    }
}
