package com.ushareit.listenit;

final class blz {
    private final bii f6990a;
    private long f6991b;
    private boolean f6992c;
    private int f6993d;
    private long f6994e;
    private boolean f6995f;
    private boolean f6996g;
    private boolean f6997h;
    private boolean f6998i;
    private boolean f6999j;
    private long f7000k;
    private long f7001l;
    private boolean f7002m;

    public blz(bii com_ushareit_listenit_bii) {
        this.f6990a = com_ushareit_listenit_bii;
    }

    public void m8998a() {
        this.f6995f = false;
        this.f6996g = false;
        this.f6997h = false;
        this.f6998i = false;
        this.f6999j = false;
    }

    public void m9000a(long j, int i, int i2, long j2) {
        boolean z;
        boolean z2 = false;
        this.f6996g = false;
        this.f6997h = false;
        this.f6994e = j2;
        this.f6993d = 0;
        this.f6991b = j;
        if (i2 >= 32) {
            if (!this.f6999j && this.f6998i) {
                m8997a(i);
                this.f6998i = false;
            }
            if (i2 <= 34) {
                this.f6997h = !this.f6999j;
                this.f6999j = true;
            }
        }
        if (i2 < 16 || i2 > 21) {
            z = false;
        } else {
            z = true;
        }
        this.f6992c = z;
        if (this.f6992c || i2 <= 9) {
            z2 = true;
        }
        this.f6995f = z2;
    }

    public void m9001a(byte[] bArr, int i, int i2) {
        if (this.f6995f) {
            int i3 = (i + 2) - this.f6993d;
            if (i3 < i2) {
                this.f6996g = (bArr[i3] & 128) != 0;
                this.f6995f = false;
                return;
            }
            this.f6993d += i2 - i;
        }
    }

    public void m8999a(long j, int i) {
        if (this.f6999j && this.f6996g) {
            this.f7002m = this.f6992c;
            this.f6999j = false;
        } else if (this.f6997h || this.f6996g) {
            if (this.f6998i) {
                m8997a(((int) (j - this.f6991b)) + i);
            }
            this.f7000k = this.f6991b;
            this.f7001l = this.f6994e;
            this.f6998i = true;
            this.f7002m = this.f6992c;
        }
    }

    private void m8997a(int i) {
        this.f6990a.mo974a(this.f7001l, this.f7002m ? 1 : 0, (int) (this.f6991b - this.f7000k), i, null);
    }
}
