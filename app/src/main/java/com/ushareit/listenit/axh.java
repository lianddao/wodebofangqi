package com.ushareit.listenit;

import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.ads.internal.view.C0052n;
import com.facebook.ads.internal.view.p003d.p004b.C0036e;

public class axh implements OnClickListener {
    final /* synthetic */ C0052n f5616a;
    final /* synthetic */ C0036e f5617b;

    public axh(C0036e c0036e, C0052n c0052n) {
        this.f5617b = c0036e;
        this.f5616a = c0052n;
    }

    public void onClick(View view) {
        try {
            this.f5616a.getEventBus().m6616a(new avq(Uri.parse(this.f5617b.f693c)));
            atz.m7168a(this.f5617b.f692b, Uri.parse(this.f5617b.f693c), this.f5617b.f695e);
        } catch (Throwable e) {
            Log.e("LearnMorePlugin", "Error while opening " + this.f5617b.f693c, e);
        }
    }
}
