package com.ushareit.listenit;

class rb {
    public sv f16385a;
    public sv f16386b;
    public int f16387c;
    public int f16388d;
    public int f16389e;
    public int f16390f;

    private rb(sv svVar, sv svVar2) {
        this.f16385a = svVar;
        this.f16386b = svVar2;
    }

    private rb(sv svVar, sv svVar2, int i, int i2, int i3, int i4) {
        this(svVar, svVar2);
        this.f16387c = i;
        this.f16388d = i2;
        this.f16389e = i3;
        this.f16390f = i4;
    }

    public String toString() {
        return "ChangeInfo{oldHolder=" + this.f16385a + ", newHolder=" + this.f16386b + ", fromX=" + this.f16387c + ", fromY=" + this.f16388d + ", toX=" + this.f16389e + ", toY=" + this.f16390f + '}';
    }
}
