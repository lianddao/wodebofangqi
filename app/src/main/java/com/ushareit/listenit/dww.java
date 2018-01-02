package com.ushareit.listenit;

class dww {
    final String f10501a;
    final String f10502b;
    final long f10503c;
    final long f10504d;
    final long f10505e;

    dww(String str, String str2, long j, long j2, long j3) {
        boolean z = true;
        cfi.m11082a(str);
        cfi.m11082a(str2);
        cfi.m11089b(j >= 0);
        if (j2 < 0) {
            z = false;
        }
        cfi.m11089b(z);
        this.f10501a = str;
        this.f10502b = str2;
        this.f10503c = j;
        this.f10504d = j2;
        this.f10505e = j3;
    }

    dww m16160a() {
        return new dww(this.f10501a, this.f10502b, this.f10503c + 1, this.f10504d + 1, this.f10505e);
    }

    dww m16161a(long j) {
        return new dww(this.f10501a, this.f10502b, this.f10503c, this.f10504d, j);
    }
}
