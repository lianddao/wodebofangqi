package com.ushareit.listenit;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class cko implements Callable<Boolean> {
    final /* synthetic */ SharedPreferences f8385a;
    final /* synthetic */ String f8386b;
    final /* synthetic */ Boolean f8387c;

    cko(SharedPreferences sharedPreferences, String str, Boolean bool) {
        this.f8385a = sharedPreferences;
        this.f8386b = str;
        this.f8387c = bool;
    }

    public Boolean m11515a() {
        return Boolean.valueOf(this.f8385a.getBoolean(this.f8386b, this.f8387c.booleanValue()));
    }

    public /* synthetic */ Object call() {
        return m11515a();
    }
}
