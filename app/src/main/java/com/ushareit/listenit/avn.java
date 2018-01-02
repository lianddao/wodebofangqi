package com.ushareit.listenit;

import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.ads.internal.view.p002c.C0029a;
import java.util.HashMap;

public class avn implements OnClickListener {
    final /* synthetic */ C0029a f5571a;

    public avn(C0029a c0029a) {
        this.f5571a = c0029a;
    }

    public void onClick(View view) {
        try {
            Uri parse = Uri.parse(this.f5571a.f667a);
            this.f5571a.f668b.getEventBus().m6616a(new avq(parse));
            ako a = akp.m5928a(this.f5571a.getContext(), "", parse, new HashMap());
            if (a != null) {
                a.mo667b();
            }
        } catch (Throwable e) {
            Log.e(String.valueOf(C0029a.class), "Error while opening " + this.f5571a.f667a, e);
        } catch (Throwable e2) {
            Log.e(String.valueOf(C0029a.class), "Error executing action", e2);
        }
    }
}
