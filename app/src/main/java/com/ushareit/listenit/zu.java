package com.ushareit.listenit;

import java.io.InputStream;

public class zu implements ze<yq, InputStream> {
    private final zb<yq, yq> f17617a;

    public zu() {
        this(null);
    }

    public zu(zb<yq, yq> zbVar) {
        this.f17617a = zbVar;
    }

    public vc<InputStream> m27295a(yq yqVar, int i, int i2) {
        if (this.f17617a != null) {
            yq yqVar2 = (yq) this.f17617a.m27275a(yqVar, 0, 0);
            if (yqVar2 == null) {
                this.f17617a.m27276a(yqVar, 0, 0, yqVar);
            } else {
                yqVar = yqVar2;
            }
        }
        return new vf(yqVar);
    }
}
