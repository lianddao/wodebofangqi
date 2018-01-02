package com.ushareit.listenit;

public enum gdp {
    COLLAPSED(0),
    EXPANDED(1),
    SLIDING(2);
    
    private int f13965d;

    private gdp(int i) {
        this.f13965d = i;
    }

    public static gdp m21764a(int i) {
        switch (i) {
            case 0:
                return COLLAPSED;
            case 2:
                return SLIDING;
            default:
                return EXPANDED;
        }
    }

    public int m21765a() {
        return this.f13965d;
    }
}
