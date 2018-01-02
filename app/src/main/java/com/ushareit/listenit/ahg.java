package com.ushareit.listenit;

import java.io.File;

public class ahg extends ahd {
    private final long f4361a;

    public ahg(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.f4361a = j;
    }

    protected boolean mo630a(File file, long j, int i) {
        return j <= this.f4361a;
    }
}
