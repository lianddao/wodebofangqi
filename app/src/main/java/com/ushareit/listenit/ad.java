package com.ushareit.listenit;

import android.content.Intent;
import android.content.IntentSender;

abstract class ad extends ac {
    boolean f431a;

    ad() {
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        if (!(this.f431a || i == -1)) {
            m689b(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    void mo63a() {
        super.onBackPressed();
    }

    static void m689b(int i) {
        if ((-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }
}
