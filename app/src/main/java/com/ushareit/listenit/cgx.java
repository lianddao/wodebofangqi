package com.ushareit.listenit;

import android.content.Intent;

final class cgx extends cgv {
    final /* synthetic */ Intent f8276a;
    final /* synthetic */ ah f8277b;
    final /* synthetic */ int f8278c;

    cgx(Intent intent, ah ahVar, int i) {
        this.f8276a = intent;
        this.f8277b = ahVar;
        this.f8278c = i;
    }

    public void mo1316a() {
        if (this.f8276a != null) {
            this.f8277b.startActivityForResult(this.f8276a, this.f8278c);
        }
    }
}
