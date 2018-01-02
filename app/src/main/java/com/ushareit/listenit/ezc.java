package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.util.Pair;
import java.io.Serializable;
import java.net.HttpURLConnection;

public class ezc extends ezb {
    private HttpURLConnection f12227c = null;

    public /* synthetic */ ezp mo2340b(String str) {
        return m18588a(str);
    }

    static {
        if (VERSION.SDK_INT < 9) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    public ezc(int i, int i2) {
        super(i, i2);
    }

    public ezd m18588a(String str) {
        return new ezd(this, str);
    }

    public ezq mo2339a(ezp com_ushareit_listenit_ezp) {
        exu.m18433a(com_ushareit_listenit_ezp instanceof ezd);
        exw.m18443a("AndroidHttpClient", "By android http client");
        exw.m18449b("AndroidHttpClient", "Ready to download " + this.f12227c.getURL());
        for (Pair pair : com_ushareit_listenit_ezp.m18594c()) {
            this.f12227c.addRequestProperty((String) pair.first, (String) pair.second);
        }
        Pair d = com_ushareit_listenit_ezp.m18595d();
        if (((Long) d.first).longValue() >= 0) {
            this.f12227c.addRequestProperty("Range", "bytes=" + d.first + "-" + (((Long) d.second).longValue() >= 0 ? (Serializable) d.second : ""));
        }
        return new eze(this);
    }
}
