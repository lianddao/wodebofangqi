package com.ushareit.listenit;

public final class ezx {
    public long f12273a = 0;
    public long f12274b = 0;
    public long f12275c = 0;
    public long f12276d = 0;
    public long f12277e = 0;
    public long f12278f = 0;
    public long f12279g = 0;
    public long f12280h = 0;
    public long f12281i = 0;
    public long f12282j = 0;
    public long f12283k = 0;
    public long f12284l = 0;
    public long f12285m = 0;
    public double f12286n = 0.0d;
    public double f12287o = 0.0d;
    public double f12288p = 0.0d;
    public long f12289q = 0;
    public long f12290r = 0;
    public double f12291s = 0.0d;
    private eyc f12292t = null;
    private eyc f12293u = null;
    private eyc f12294v = null;

    public void m18652a() {
        this.f12292t = new eyc().m18467a();
    }

    public void m18655b() {
        this.f12274b = this.f12292t.m18468b();
    }

    public void m18658c() {
        this.f12281i = this.f12292t.m18468b();
    }

    public void m18660d() {
        this.f12294v = new eyc().m18467a();
        this.f12293u = new eyc().m18467a();
    }

    public void m18654a(long j) {
        if (this.f12290r == 0 && this.f12294v.m18469c() > 3000000000L) {
            this.f12289q = this.f12294v.m18469c();
            this.f12290r = j;
        }
    }

    public void m18653a(int i) {
        this.f12275c += this.f12293u.m18468b();
    }

    public void m18656b(int i) {
        if (((long) i) > this.f12279g) {
            this.f12279g = (long) i;
        }
    }

    public void m18661e() {
        this.f12276d += this.f12292t.m18468b();
    }

    public void m18662f() {
        this.f12277e += this.f12292t.m18468b();
    }

    public void m18657b(long j) {
        this.f12284l++;
        long j2 = this.f12283k;
        this.f12283k += this.f12292t.m18468b();
        j2 = this.f12283k - j2;
        if (j > 0 && j2 > 0) {
            double d = ((double) (((float) j) / 1024.0f)) / (((double) j2) / 1.0E9d);
            if (d != 0.0d) {
                if (this.f12287o == 0.0d || d < this.f12287o) {
                    this.f12287o = d;
                }
                if (d > this.f12288p) {
                    this.f12288p = d;
                }
            }
        }
    }

    public void m18663g() {
        this.f12282j = this.f12292t.m18468b();
    }

    public void m18659c(long j) {
        try {
            this.f12273a = this.f12292t.m18469c();
            this.f12280h = (this.f12281i + this.f12283k) + this.f12282j;
            this.f12285m = (this.f12276d + this.f12277e) + this.f12283k;
            this.f12278f = (((this.f12273a - this.f12280h) - this.f12274b) - this.f12276d) - this.f12277e;
            if (this.f12290r == 0) {
                this.f12289q = this.f12294v.m18469c();
                this.f12290r = j;
            }
            if (this.f12289q > 0) {
                this.f12291s = ((double) (((float) this.f12290r) / 1024.0f)) / (((double) this.f12289q) / 1.0E9d);
            }
            if (this.f12273a == 0) {
                this.f12273a = 1;
            }
            this.f12286n = ((double) (((float) j) / 1024.0f)) / (((double) this.f12273a) / 1.0E9d);
            if (exw.m18447a() && j > 65536) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("=================================\n");
                stringBuffer.append(String.format("Size = %.2f KB, Time = %.2f S, Speed = %.2f KB/s", new Object[]{Float.valueOf(((float) j) / 1024.0f), Double.valueOf(((double) this.f12273a) / 1.0E9d), Double.valueOf(this.f12286n)}));
                stringBuffer.append("\n");
                stringBuffer.append(String.format("ReadTime = %.2f S vs CoreTime = %.2f S [ Wait = %.2f S, Write = %.2f S, Progress = %.2f S ]", new Object[]{Double.valueOf(((double) this.f12275c) / 1.0E9d), Double.valueOf(((double) this.f12285m) / 1.0E9d), Double.valueOf(((double) this.f12276d) / 1.0E9d), Double.valueOf(((double) this.f12277e) / 1.0E9d), Double.valueOf(((double) this.f12283k) / 1.0E9d)}));
                stringBuffer.append("\n");
                stringBuffer.append(String.format("InitPhase = %.2f S, InitSpeed = %.2f KB/s, MinInstSpeed = %.2f KB/s, MaxInstSpeed = %.2f KB/s", new Object[]{Double.valueOf(((double) this.f12289q) / 1.0E9d), Double.valueOf(this.f12291s), Double.valueOf(this.f12287o), Double.valueOf(this.f12288p)}));
                stringBuffer.append("\n");
                stringBuffer.append(String.format("ProgressCount = %d, QueueMaxLength = %d", new Object[]{Long.valueOf(this.f12284l), Long.valueOf(this.f12279g)}));
                stringBuffer.append("\n");
                stringBuffer.append(String.format("Request = %.2f S, Wait = %.2f S, Write = %.2f S, Progress = %.2f S, Other = %.2f S", new Object[]{Double.valueOf(((double) this.f12274b) / 1.0E9d), Double.valueOf(((double) this.f12276d) / 1.0E9d), Double.valueOf(((double) this.f12277e) / 1.0E9d), Double.valueOf(((double) this.f12283k) / 1.0E9d), Double.valueOf(((double) this.f12278f) / 1.0E9d)}));
                stringBuffer.append("\n");
                stringBuffer.append(String.format("UITime = %.2f S: Started = %.2f S, Progress = %.2f S, Finished = %.2f S", new Object[]{Double.valueOf(((double) this.f12280h) / 1.0E9d), Double.valueOf(((double) this.f12281i) / 1.0E9d), Double.valueOf(((double) this.f12283k) / 1.0E9d), Double.valueOf(((double) this.f12282j) / 1.0E9d)}));
                exw.m18443a("TimeStats", stringBuffer.toString());
            }
        } catch (Exception e) {
        }
    }
}
