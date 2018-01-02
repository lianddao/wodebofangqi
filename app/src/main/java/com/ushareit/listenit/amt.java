package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.ads.C0016g;

public class amt extends BroadcastReceiver {
    private String f4875a;
    private ams f4876b;
    private amr f4877c;

    public amt(String str, amr com_ushareit_listenit_amr, ams com_ushareit_listenit_ams) {
        this.f4877c = com_ushareit_listenit_amr;
        this.f4876b = com_ushareit_listenit_ams;
        this.f4875a = str;
    }

    public IntentFilter m6332a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(art.REWARDED_VIDEO_COMPLETE.m6914a(this.f4875a));
        intentFilter.addAction(art.REWARDED_VIDEO_ERROR.m6914a(this.f4875a));
        intentFilter.addAction(art.REWARDED_VIDEO_AD_CLICK.m6914a(this.f4875a));
        intentFilter.addAction(art.REWARDED_VIDEO_IMPRESSION.m6914a(this.f4875a));
        intentFilter.addAction(art.REWARDED_VIDEO_CLOSED.m6914a(this.f4875a));
        intentFilter.addAction(art.REWARD_SERVER_SUCCESS.m6914a(this.f4875a));
        intentFilter.addAction(art.REWARD_SERVER_FAILED.m6914a(this.f4875a));
        return intentFilter;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (art.REWARDED_VIDEO_COMPLETE.m6914a(this.f4875a).equals(action)) {
            this.f4876b.mo659d(this.f4877c);
        } else if (art.REWARDED_VIDEO_ERROR.m6914a(this.f4875a).equals(action)) {
            this.f4876b.mo656a(this.f4877c, C0016g.f613e);
        } else if (art.REWARDED_VIDEO_AD_CLICK.m6914a(this.f4875a).equals(action)) {
            this.f4876b.mo657b(this.f4877c);
        } else if (art.REWARDED_VIDEO_IMPRESSION.m6914a(this.f4875a).equals(action)) {
            this.f4876b.mo658c(this.f4877c);
        } else if (art.REWARDED_VIDEO_CLOSED.m6914a(this.f4875a).equals(action)) {
            this.f4876b.mo654a();
        } else if (art.REWARD_SERVER_FAILED.m6914a(this.f4875a).equals(action)) {
            this.f4876b.mo660e(this.f4877c);
        } else if (art.REWARD_SERVER_SUCCESS.m6914a(this.f4875a).equals(action)) {
            this.f4876b.mo661f(this.f4877c);
        }
    }
}
