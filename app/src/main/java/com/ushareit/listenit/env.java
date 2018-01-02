package com.ushareit.listenit;

import android.content.Context;
import android.os.Handler;
import com.mopub.common.Constants;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.nativeads.PositioningRequest;
import com.mopub.nativeads.PositioningSource;
import com.mopub.nativeads.PositioningSource.PositioningListener;
import com.mopub.network.Networking;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.Response.Listener;

public class env implements PositioningSource {
    private int f11334a = 300000;
    private final Context f11335b;
    private final Handler f11336c;
    private final Runnable f11337d;
    private final Listener<MoPubClientPositioning> f11338e;
    private final ErrorListener f11339f;
    private PositioningListener f11340g;
    private int f11341h;
    private String f11342i;
    private PositioningRequest f11343j;

    public env(Context context) {
        this.f11335b = context.getApplicationContext();
        this.f11336c = new Handler();
        this.f11337d = new enw(this);
        this.f11338e = new enx(this);
        this.f11339f = new eny(this);
    }

    public void loadPositions(String str, PositioningListener positioningListener) {
        if (this.f11343j != null) {
            this.f11343j.cancel();
            this.f11343j = null;
        }
        if (this.f11341h > 0) {
            this.f11336c.removeCallbacks(this.f11337d);
            this.f11341h = 0;
        }
        this.f11340g = positioningListener;
        this.f11342i = new ent(this.f11335b).withAdUnitId(str).generateUrlString(Constants.HOST);
        m17234a();
    }

    private void m17234a() {
        MoPubLog.m2753d("Loading positioning from: " + this.f11342i);
        this.f11343j = new PositioningRequest(this.f11342i, this.f11338e, this.f11339f);
        Networking.getRequestQueue(this.f11335b).add(this.f11343j);
    }

    private void m17235a(MoPubClientPositioning moPubClientPositioning) {
        if (this.f11340g != null) {
            this.f11340g.onLoad(moPubClientPositioning);
        }
        this.f11340g = null;
        this.f11341h = 0;
    }

    private void m17239b() {
        int pow = (int) (Math.pow(2.0d, (double) (this.f11341h + 1)) * 1000.0d);
        if (pow >= this.f11334a) {
            MoPubLog.m2753d("Error downloading positioning information");
            if (this.f11340g != null) {
                this.f11340g.onFailed();
            }
            this.f11340g = null;
            return;
        }
        this.f11341h++;
        this.f11336c.postDelayed(this.f11337d, (long) pow);
    }
}
