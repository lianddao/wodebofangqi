package com.ushareit.listenit;

public final class bgw extends Exception {
    public final int f6254a;

    public bgw(int i, int i2, int i3, int i4) {
        super("AudioTrack init failed: " + i + ", Config(" + i2 + ", " + i3 + ", " + i4 + ")");
        this.f6254a = i;
    }
}
