package com.ushareit.listenit;

import android.content.Context;
import java.io.File;

public final class agd {
    private File f4317a;
    private agz f4318b = new ahf();
    private agx f4319c = new ahg(536870912);
    private ahj f4320d;

    public agd(Context context) {
        this.f4320d = ahk.m5642a(context);
        this.f4317a = agw.m5601a(context);
    }

    public agd m5558a(long j) {
        this.f4319c = new ahg(j);
        return this;
    }

    public agb m5557a() {
        return new agb(m5556b());
    }

    private afy m5556b() {
        return new afy(this.f4317a, this.f4318b, this.f4319c, this.f4320d);
    }
}
