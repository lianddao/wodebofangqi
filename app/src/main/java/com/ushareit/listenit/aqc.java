package com.ushareit.listenit;

public enum aqc {
    GET(true, false),
    POST(true, true);
    
    private boolean f5178c;
    private boolean f5179d;

    private aqc(boolean z, boolean z2) {
        this.f5178c = z;
        this.f5179d = z2;
    }

    public boolean m6772a() {
        return this.f5178c;
    }

    public boolean m6773b() {
        return this.f5179d;
    }

    public String m6774c() {
        return toString();
    }
}
