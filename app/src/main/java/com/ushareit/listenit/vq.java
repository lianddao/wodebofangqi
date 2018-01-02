package com.ushareit.listenit;

public enum vq {
    ALL(true, true),
    NONE(false, false),
    SOURCE(true, false),
    RESULT(false, true);
    
    private final boolean f17060e;
    private final boolean f17061f;

    private vq(boolean z, boolean z2) {
        this.f17060e = z;
        this.f17061f = z2;
    }

    public boolean m26729a() {
        return this.f17060e;
    }

    public boolean m26730b() {
        return this.f17061f;
    }
}
