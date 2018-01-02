package com.ushareit.listenit;

import android.database.ContentObserver;
import android.os.Handler;

class asp extends ContentObserver {
    private final ath f5331a;

    public asp(Handler handler, ath com_ushareit_listenit_ath) {
        super(handler);
        this.f5331a = com_ushareit_listenit_ath;
    }

    public boolean deliverSelfNotifications() {
        return false;
    }

    public void onChange(boolean z) {
        this.f5331a.m7001e();
    }
}
