package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class fxo extends BroadcastReceiver {
    final /* synthetic */ fxh f13687a;

    fxo(fxh com_ushareit_listenit_fxh) {
        this.f13687a = com_ushareit_listenit_fxh;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && !fbb.m18763c(intent.getAction())) {
            String action = intent.getAction();
            if (action.equals("action_refresh_main_page")) {
                this.f13687a.mo2550c();
            } else if (action.equals("action_refresh_local_song")) {
                this.f13687a.m21254U();
            } else if (action.equals("action_refresh_playlist")) {
                this.f13687a.m21255V();
            } else if (action.equals("action_refresh_feature_card")) {
                this.f13687a.m21256W();
            }
        }
    }
}
