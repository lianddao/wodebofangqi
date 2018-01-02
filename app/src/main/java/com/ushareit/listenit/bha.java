package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import java.nio.ByteBuffer;

@TargetApi(16)
public class bha extends bmt implements bsm {
    private final bgj f6295b;
    private final bgq f6296c;
    private boolean f6297d;
    private MediaFormat f6298e;
    private int f6299f;
    private int f6300g = 0;
    private long f6301h;
    private boolean f6302i;
    private boolean f6303j;
    private long f6304k;

    public bha(bmv com_ushareit_listenit_bmv, bhm<bho> com_ushareit_listenit_bhm_com_ushareit_listenit_bho, boolean z, Handler handler, bgi com_ushareit_listenit_bgi, bgh com_ushareit_listenit_bgh, int i) {
        super(1, com_ushareit_listenit_bmv, com_ushareit_listenit_bhm_com_ushareit_listenit_bho, z);
        this.f6296c = new bgq(com_ushareit_listenit_bgh, i);
        this.f6295b = new bgj(handler, com_ushareit_listenit_bgi);
    }

    protected int mo940a(bmv com_ushareit_listenit_bmv, Format format) {
        boolean z = false;
        String str = format.f1431e;
        if (!bsn.m9677a(str)) {
            return 0;
        }
        if (mo946a(str) && com_ushareit_listenit_bmv.mo1015a() != null) {
            return 7;
        }
        bms a = com_ushareit_listenit_bmv.mo1016a(str, false);
        if (a == null) {
            return 1;
        }
        if (btc.f7662a < 21 || ((format.f1443q == -1 || a.m9089a(format.f1443q)) && (format.f1442p == -1 || a.m9093b(format.f1442p)))) {
            z = true;
        }
        return (z ? 3 : 2) | 4;
    }

    protected bms mo941a(bmv com_ushareit_listenit_bmv, Format format, boolean z) {
        if (mo946a(format.f1431e)) {
            bms a = com_ushareit_listenit_bmv.mo1015a();
            if (a != null) {
                this.f6297d = true;
                return a;
            }
        }
        this.f6297d = false;
        return super.mo941a(com_ushareit_listenit_bmv, format, z);
    }

    protected boolean mo946a(String str) {
        return this.f6296c.m8272a(str);
    }

    protected void mo943a(MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        if (this.f6297d) {
            this.f6298e = format.m2081b();
            this.f6298e.setString("mime", "audio/raw");
            mediaCodec.configure(this.f6298e, null, mediaCrypto, 0);
            this.f6298e.setString("mime", format.f1431e);
            return;
        }
        mediaCodec.configure(format.m2081b(), null, mediaCrypto, 0);
        this.f6298e = null;
    }

    public bsm mo871c() {
        return this;
    }

    protected void mo944a(String str, long j, long j2) {
        this.f6295b.m8244a(str, j, j2);
    }

    protected void mo947b(Format format) {
        super.mo947b(format);
        this.f6295b.m8242a(format);
        this.f6299f = "audio/raw".equals(format.f1431e) ? format.f1444r : 2;
    }

    protected void mo942a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i = this.f6298e != null ? 1 : 0;
        String string = i != 0 ? this.f6298e.getString("mime") : "audio/raw";
        if (i != 0) {
            mediaFormat = this.f6298e;
        }
        this.f6296c.m8270a(string, mediaFormat.getInteger("channel-count"), mediaFormat.getInteger("sample-rate"), this.f6299f, 0);
    }

    protected void m8370b(int i) {
    }

    protected void mo934a(boolean z) {
        super.mo934a(z);
        this.f6295b.m8243a(this.a);
    }

    protected void mo933a(long j, boolean z) {
        super.mo933a(j, z);
        this.f6296c.m8280i();
        this.f6301h = j;
        this.f6302i = true;
    }

    protected void mo935m() {
        super.mo935m();
        this.f6296c.m8275d();
    }

    protected void mo936n() {
        this.f6296c.m8279h();
        super.mo936n();
    }

    protected void mo937o() {
        this.f6300g = 0;
        try {
            this.f6296c.m8281j();
            try {
                super.mo937o();
            } finally {
                this.a.m8395a();
                this.f6295b.m8245b(this.a);
            }
        } catch (Throwable th) {
            super.mo937o();
        } finally {
            this.a.m8395a();
            this.f6295b.m8245b(this.a);
        }
    }

    public boolean mo939s() {
        return super.mo939s() && !this.f6296c.m8278g();
    }

    public boolean mo938r() {
        return this.f6296c.m8278g() || super.mo938r();
    }

    public long mo948t() {
        long a = this.f6296c.m8267a(mo939s());
        if (a != Long.MIN_VALUE) {
            if (!this.f6302i) {
                a = Math.max(this.f6301h, a);
            }
            this.f6301h = a;
            this.f6302i = false;
        }
        return this.f6301h;
    }

    protected boolean mo945a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        if (this.f6297d && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            r2 = this.a;
            r2.f6317e++;
            this.f6296c.m8276e();
            return true;
        } else {
            if (this.f6296c.m8271a()) {
                boolean z2 = this.f6303j;
                this.f6303j = this.f6296c.m8278g();
                if (z2 && !this.f6303j && mo872d() == 2) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - this.f6304k;
                    this.f6295b.m8241a(this.f6296c.m8273b(), bfg.m8005a(this.f6296c.m8274c()), elapsedRealtime);
                }
            } else {
                try {
                    if (this.f6300g == 0) {
                        this.f6300g = this.f6296c.m8265a(0);
                        this.f6295b.m8240a(this.f6300g);
                        m8370b(this.f6300g);
                    } else {
                        this.f6296c.m8265a(this.f6300g);
                    }
                    this.f6303j = false;
                    if (mo872d() == 2) {
                        this.f6296c.m8275d();
                    }
                } catch (Exception e) {
                    throw bfi.m8024a(e, m8003p());
                }
            }
            try {
                int a = this.f6296c.m8266a(byteBuffer, j3);
                this.f6304k = SystemClock.elapsedRealtime();
                if ((a & 1) != 0) {
                    mo950v();
                    this.f6302i = true;
                }
                if ((a & 2) == 0) {
                    return false;
                }
                mediaCodec.releaseOutputBuffer(i, false);
                r2 = this.a;
                r2.f6316d++;
                return true;
            } catch (Exception e2) {
                throw bfi.m8024a(e2, m8003p());
            }
        }
    }

    protected void mo949u() {
        this.f6296c.m8277f();
    }

    protected void mo950v() {
    }

    public void mo866a(int i, Object obj) {
        switch (i) {
            case 2:
                this.f6296c.m8268a(((Float) obj).floatValue());
                return;
            case 3:
                this.f6296c.m8269a((PlaybackParams) obj);
                return;
            default:
                super.mo866a(i, obj);
                return;
        }
    }
}
