package com.ushareit.listenit;

public class csu {
    private final long f8907a;

    public csu(long j) {
        this.f8907a = j;
    }

    public long m12545a() {
        return this.f8907a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f8907a == ((csu) obj).f8907a;
    }

    public int hashCode() {
        return (int) (this.f8907a ^ (this.f8907a >>> 32));
    }

    public String toString() {
        return "Tag{tagNumber=" + this.f8907a + "}";
    }
}
