package com.ushareit.listenit;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class aow {
    private static final String f5109a = aow.class.getSimpleName();
    private static final String f5110b = asf.m6965b();
    private final aoz f5111c;
    private final ThreadPoolExecutor f5112d;
    private final ConnectivityManager f5113e;
    private final aps f5114f;
    private final Handler f5115g;
    private final long f5116h;
    private final long f5117i;
    private final Runnable f5118j = new aox(this);
    private volatile boolean f5119k;
    private int f5120l;
    private long f5121m;

    aow(Context context, aoz com_ushareit_listenit_aoz) {
        this.f5111c = com_ushareit_listenit_aoz;
        this.f5112d = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.f5113e = (ConnectivityManager) context.getSystemService("connectivity");
        this.f5114f = auv.m7232b(context);
        this.f5115g = new Handler(Looper.getMainLooper());
        this.f5116h = app.m6624f(context);
        this.f5117i = app.m6625g(context);
    }

    private void m6510a(long j) {
        this.f5115g.postDelayed(this.f5118j, j);
    }

    static /* synthetic */ int m6512b(aow com_ushareit_listenit_aow) {
        int i = com_ushareit_listenit_aow.f5120l + 1;
        com_ushareit_listenit_aow.f5120l = i;
        return i;
    }

    private void m6514c() {
        if (this.f5120l >= 5) {
            m6517e();
            m6519b();
            return;
        }
        if (this.f5120l == 1) {
            this.f5121m = 2000;
        } else {
            this.f5121m *= 2;
        }
        m6518a();
    }

    private void m6515d() {
        try {
            NetworkInfo activeNetworkInfo = this.f5113e.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                m6510a(this.f5117i);
                return;
            }
            JSONObject a = this.f5111c.mo740a();
            if (a == null) {
                m6517e();
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("attempt", String.valueOf(this.f5120l));
            a.put("data", jSONObject);
            aqi com_ushareit_listenit_aqi = new aqi();
            com_ushareit_listenit_aqi.m6786a("payload", a.toString());
            aqg b = this.f5114f.m6731b(f5110b, com_ushareit_listenit_aqi);
            Object e = b != null ? b.m6780e() : null;
            if (TextUtils.isEmpty(e)) {
                m6514c();
            } else if (b.m6776a() != 200) {
                m6514c();
            } else if (!this.f5111c.mo743a(new JSONArray(e))) {
                m6514c();
            } else if (this.f5111c.mo747c()) {
                m6514c();
            } else {
                m6517e();
            }
        } catch (Exception e2) {
            m6514c();
        }
    }

    private void m6517e() {
        this.f5120l = 0;
        this.f5121m = 0;
        if (this.f5112d.getQueue().size() == 0) {
            this.f5111c.mo744b();
        }
    }

    void m6518a() {
        this.f5119k = true;
        this.f5115g.removeCallbacks(this.f5118j);
        m6510a(this.f5116h);
    }

    void m6519b() {
        if (!this.f5119k) {
            this.f5119k = true;
            this.f5115g.removeCallbacks(this.f5118j);
            m6510a(this.f5117i);
        }
    }
}
