package com.ushareit.listenit;

public enum gwu {
    RADIO10(10),
    RADIO20(20),
    RADIO30(30),
    RADIO60(60),
    RADIO90(90),
    RADIO_CUSTOM(-1),
    RADIO_COLSE(-2);
    
    private int f14845h;

    private gwu(int i) {
        this.f14845h = i;
    }

    public int m23079a() {
        return this.f14845h;
    }
}
