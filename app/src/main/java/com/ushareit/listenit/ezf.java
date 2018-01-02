package com.ushareit.listenit;

import android.util.Pair;
import java.io.Serializable;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnRouteParams;

public class ezf extends ezb {
    private HttpClient f12234c = null;

    public ezf(int i, int i2) {
        super(i, i2);
        this.f12234c = ezm.m18635a(i, i2);
    }

    public ezp mo2340b(String str) {
        return new ezg(this, str);
    }

    public ezq mo2339a(ezp com_ushareit_listenit_ezp) {
        exu.m18433a(com_ushareit_listenit_ezp instanceof ezg);
        ezg com_ushareit_listenit_ezg = (ezg) com_ushareit_listenit_ezp;
        HttpUriRequest b = com_ushareit_listenit_ezg.m18607b();
        exw.m18449b("ApacheHttpClient", "Ready to download " + b.getURI());
        for (Pair pair : com_ushareit_listenit_ezp.m18594c()) {
            b.setHeader((String) pair.first, (String) pair.second);
        }
        b.getParams().setParameter("http.route.default-proxy", ConnRouteParams.NO_HOST);
        Pair pair2 = com_ushareit_listenit_ezg.m18595d();
        if (((Long) pair2.first).longValue() >= 0) {
            b.setHeader("Range", "bytes=" + pair2.first + "-" + (((Long) pair2.second).longValue() >= 0 ? (Serializable) pair2.second : ""));
        }
        return new ezh(this, this.f12234c.execute(b));
    }
}
