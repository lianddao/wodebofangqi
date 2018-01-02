package com.ushareit.listenit;

import android.app.Activity;
import android.content.Intent;

final class cgw extends cgv {
    final /* synthetic */ Intent f8273a;
    final /* synthetic */ Activity f8274b;
    final /* synthetic */ int f8275c;

    cgw(Intent intent, Activity activity, int i) {
        this.f8273a = intent;
        this.f8274b = activity;
        this.f8275c = i;
    }

    public void mo1316a() {
        if (this.f8273a != null) {
            this.f8274b.startActivityForResult(this.f8273a, this.f8275c);
        }
    }
}
