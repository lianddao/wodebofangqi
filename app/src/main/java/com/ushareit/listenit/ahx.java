package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.AccessToken;

class ahx extends BroadcastReceiver {
    final /* synthetic */ ahv f4399a;

    private ahx(ahv com_ushareit_listenit_ahv) {
        this.f4399a = com_ushareit_listenit_ahv;
    }

    public void onReceive(Context context, Intent intent) {
        if ("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED".equals(intent.getAction())) {
            this.f4399a.mo821a((AccessToken) intent.getParcelableExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN"), (AccessToken) intent.getParcelableExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN"));
        }
    }
}
