package com.ushareit.listenit;

public abstract class aqe {
    protected String f5171a = "";
    protected aqc f5172b;
    protected String f5173c;
    protected byte[] f5174d;

    public aqe(String str, aqi com_ushareit_listenit_aqi) {
        if (str != null) {
            this.f5171a = str;
        }
        if (com_ushareit_listenit_aqi != null) {
            this.f5171a += "?" + com_ushareit_listenit_aqi.m6784a();
        }
    }

    public String m6768a() {
        return this.f5171a;
    }

    public aqc m6769b() {
        return this.f5172b;
    }

    public String m6770c() {
        return this.f5173c;
    }

    public byte[] m6771d() {
        return this.f5174d;
    }
}
