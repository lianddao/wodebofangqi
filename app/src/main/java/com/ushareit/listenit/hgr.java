package com.ushareit.listenit;

import android.os.Handler;
import android.os.Message;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

class hgr extends Handler {
    final /* synthetic */ hgk f15435a;

    private hgr(hgk com_ushareit_listenit_hgk) {
        this.f15435a = com_ushareit_listenit_hgk;
    }

    public void handleMessage(Message message) {
        String str = (String) message.obj;
        int i = message.arg1;
        int i2 = message.arg2;
        switch (message.what) {
            case 10:
                if (i2 == MoPubClientPositioning.NO_REPEAT || i2 == 0) {
                    sendMessageDelayed(obtainMessage(10), 500);
                    return;
                } else if (this.f15435a.f15417c + i >= i2) {
                    this.f15435a.f15425k.mo2783a();
                    return;
                } else {
                    for (hgq a : this.f15435a.f15422h) {
                        a.mo2623a(str, i, i2);
                    }
                    sendMessageDelayed(obtainMessage(10), 500);
                    this.f15435a.m23771b(str, 500);
                    return;
                }
            case 11:
                if (i2 == 0) {
                    i2 = MoPubClientPositioning.NO_REPEAT;
                }
                for (hgq a2 : this.f15435a.f15422h) {
                    a2.mo2623a(str, i2, i2);
                }
                return;
            case 12:
                if (i2 == 0) {
                    i2 = MoPubClientPositioning.NO_REPEAT;
                }
                for (hgq a22 : this.f15435a.f15422h) {
                    a22.mo2623a(str, i, i2);
                }
                return;
            default:
                return;
        }
    }
}
