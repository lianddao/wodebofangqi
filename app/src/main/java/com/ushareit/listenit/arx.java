package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Map;

public class arx {
    private ary f5270a;
    private float f5271b;
    private Map<String, String> f5272c;

    public arx(ary com_ushareit_listenit_ary) {
        this(com_ushareit_listenit_ary, 0.0f);
    }

    public arx(ary com_ushareit_listenit_ary, float f) {
        this(com_ushareit_listenit_ary, f, null);
    }

    public arx(ary com_ushareit_listenit_ary, float f, Map<String, String> map) {
        this.f5270a = com_ushareit_listenit_ary;
        this.f5271b = f;
        if (map != null) {
            this.f5272c = map;
        } else {
            this.f5272c = new HashMap();
        }
    }

    public boolean m6938a() {
        return this.f5270a == ary.IS_VIEWABLE;
    }

    public int m6939b() {
        return this.f5270a.m6942a();
    }

    public float m6940c() {
        return this.f5271b;
    }

    public Map<String, String> m6941d() {
        return this.f5272c;
    }
}
