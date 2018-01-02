package com.ushareit.listenit;

public enum hjq {
    ERROR(40, "ERROR"),
    WARN(30, "WARN"),
    INFO(20, "INFO"),
    DEBUG(10, "DEBUG"),
    TRACE(0, "TRACE");
    
    private int f15541f;
    private String f15542g;

    private hjq(int i, String str) {
        this.f15541f = i;
        this.f15542g = str;
    }

    public String toString() {
        return this.f15542g;
    }
}
