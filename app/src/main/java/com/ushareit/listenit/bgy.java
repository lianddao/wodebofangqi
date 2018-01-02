package com.ushareit.listenit;

public final class bgy extends Exception {
    public final int f6255a;

    public bgy(int i) {
        super("AudioTrack write failed: " + i);
        this.f6255a = i;
    }
}
