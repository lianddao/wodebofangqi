package com.ushareit.listenit;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.ads.internal.view.p000a.C0019a;

public class avd implements OnClickListener {
    final /* synthetic */ C0019a f5562a;

    public avd(C0019a c0019a) {
        this.f5562a = c0019a;
    }

    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.f5562a.f642i) && !"about:blank".equals(this.f5562a.f642i)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f5562a.f642i));
            intent.addFlags(268435456);
            this.f5562a.getContext().startActivity(intent);
        }
    }
}
