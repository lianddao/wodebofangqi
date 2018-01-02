package com.ushareit.listenit;

import android.os.SystemClock;
import com.mopub.volley.VolleyLog;
import java.util.ArrayList;
import java.util.List;

public class eox {
    public static final boolean ENABLED = VolleyLog.DEBUG;
    private final List<eoy> f11414a = new ArrayList();
    private boolean f11415b = false;

    public synchronized void add(String str, long j) {
        if (this.f11415b) {
            throw new IllegalStateException("Marker added to finished log");
        }
        this.f11414a.add(new eoy(str, j, SystemClock.elapsedRealtime()));
    }

    public synchronized void finish(String str) {
        this.f11415b = true;
        if (m17267a() > 0) {
            long j = ((eoy) this.f11414a.get(0)).time;
            VolleyLog.m3359d("(%-4d ms) %s", Long.valueOf(r2), str);
            long j2 = j;
            for (eoy com_ushareit_listenit_eoy : this.f11414a) {
                VolleyLog.m3359d("(+%-4d) [%2d] %s", Long.valueOf(com_ushareit_listenit_eoy.time - j2), Long.valueOf(com_ushareit_listenit_eoy.thread), com_ushareit_listenit_eoy.name);
                j2 = com_ushareit_listenit_eoy.time;
            }
        }
    }

    protected void finalize() {
        if (!this.f11415b) {
            finish("Request on the loose");
            VolleyLog.m3360e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    private long m17267a() {
        if (this.f11414a.size() == 0) {
            return 0;
        }
        return ((eoy) this.f11414a.get(this.f11414a.size() - 1)).time - ((eoy) this.f11414a.get(0)).time;
    }
}
