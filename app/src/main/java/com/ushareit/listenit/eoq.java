package com.ushareit.listenit;

import com.mopub.common.logging.MoPubLog;
import com.mopub.network.ScribeRequestManager;
import com.mopub.volley.VolleyError;

public class eoq implements Runnable {
    final /* synthetic */ VolleyError f11397a;
    final /* synthetic */ ScribeRequestManager f11398b;

    public eoq(ScribeRequestManager scribeRequestManager, VolleyError volleyError) {
        this.f11398b = scribeRequestManager;
        this.f11397a = volleyError;
    }

    public void run() {
        try {
            this.f11398b.c.backoff(this.f11397a);
            this.f11398b.m3341b();
        } catch (VolleyError e) {
            MoPubLog.m2753d("Failed to Scribe events: " + this.f11397a);
            this.f11398b.m3342c();
        }
    }
}
