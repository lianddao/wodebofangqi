package com.ushareit.listenit;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class ckw implements Callable<SharedPreferences> {
    final /* synthetic */ Context f8398a;

    ckw(Context context) {
        this.f8398a = context;
    }

    public SharedPreferences m11523a() {
        return this.f8398a.getSharedPreferences("google_sdk_flags", 1);
    }

    public /* synthetic */ Object call() {
        return m11523a();
    }
}
