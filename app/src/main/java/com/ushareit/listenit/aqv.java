package com.ushareit.listenit;

import java.io.File;

public class aqv extends aqs {
    private final long f5192a;

    public aqv(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.f5192a = j;
    }

    public /* bridge */ /* synthetic */ void mo783a(File file) {
        super.mo783a(file);
    }

    protected boolean mo785a(File file, long j, int i) {
        return j <= this.f5192a;
    }
}
