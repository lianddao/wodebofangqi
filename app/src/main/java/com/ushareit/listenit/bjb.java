package com.ushareit.listenit;

final class bjb implements bjf {
    private final long f6534a;
    private final int f6535b;
    private final long f6536c;

    public bjb(long j, int i, long j2) {
        this.f6534a = j;
        this.f6535b = i;
        this.f6536c = j2 == -1 ? -9223372036854775807L : mo995a(j2);
    }

    public boolean mo957a() {
        return this.f6536c != -9223372036854775807L;
    }

    public long mo959b(long j) {
        return this.f6536c == -9223372036854775807L ? 0 : this.f6534a + ((((long) this.f6535b) * j) / 8000000);
    }

    public long mo995a(long j) {
        return ((Math.max(0, j - this.f6534a) * 1000000) * 8) / ((long) this.f6535b);
    }

    public long mo958b() {
        return this.f6536c;
    }
}
