package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.content.Intent;

final class cgy extends cgv {
    final /* synthetic */ Intent f8279a;
    final /* synthetic */ doe f8280b;
    final /* synthetic */ int f8281c;

    cgy(Intent intent, doe com_ushareit_listenit_doe, int i) {
        this.f8279a = intent;
        this.f8280b = com_ushareit_listenit_doe;
        this.f8281c = i;
    }

    @TargetApi(11)
    public void mo1316a() {
        if (this.f8279a != null) {
            this.f8280b.startActivityForResult(this.f8279a, this.f8281c);
        }
    }
}
