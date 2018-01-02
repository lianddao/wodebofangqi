package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.mraid.MraidController;

@VisibleForTesting
public class elf extends BroadcastReceiver {
    final /* synthetic */ MraidController f11202a;
    private Context f11203b;
    private int f11204c = -1;

    public elf(MraidController mraidController) {
        this.f11202a = mraidController;
    }

    public void onReceive(Context context, Intent intent) {
        if (this.f11203b != null && "android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction())) {
            int l = this.f11202a.m3084f();
            if (l != this.f11204c) {
                this.f11204c = l;
                this.f11202a.m3097a(this.f11204c);
            }
        }
    }

    public void register(Context context) {
        Preconditions.checkNotNull(context);
        this.f11203b = context.getApplicationContext();
        if (this.f11203b != null) {
            this.f11203b.registerReceiver(this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        }
    }

    public void unregister() {
        if (this.f11203b != null) {
            this.f11203b.unregisterReceiver(this);
            this.f11203b = null;
        }
    }
}
