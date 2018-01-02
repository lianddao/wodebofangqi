package com.ushareit.listenit;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.mopub.mobileads.VastIconXmlManager;
import com.mopub.volley.DefaultRetryPolicy;
import java.nio.ByteBuffer;

@TargetApi(16)
public class bth extends bmt {
    private final btj f7679b;
    private final btm f7680c;
    private final long f7681d;
    private final int f7682e;
    private final int f7683f;
    private final boolean f7684g = m9788B();
    private Format[] f7685h;
    private bti f7686i;
    private Surface f7687j;
    private boolean f7688k;
    private long f7689l = -9223372036854775807L;
    private long f7690m;
    private int f7691n;
    private int f7692o;
    private int f7693p;
    private float f7694q = -1.0f;
    private int f7695r = -1;
    private int f7696s = -1;
    private int f7697t;
    private float f7698u = -1.0f;
    private int f7699v = -1;
    private int f7700w = -1;
    private int f7701x;
    private float f7702y = -1.0f;

    public bth(Context context, bmv com_ushareit_listenit_bmv, int i, long j, bhm<bho> com_ushareit_listenit_bhm_com_ushareit_listenit_bho, boolean z, Handler handler, btl com_ushareit_listenit_btl, int i2) {
        super(2, com_ushareit_listenit_bmv, com_ushareit_listenit_bhm_com_ushareit_listenit_bho, z);
        this.f7682e = i;
        this.f7681d = j;
        this.f7683f = i2;
        this.f7679b = new btj(context);
        this.f7680c = new btm(handler, com_ushareit_listenit_btl);
    }

    protected int mo940a(bmv com_ushareit_listenit_bmv, Format format) {
        boolean z = false;
        String str = format.f1431e;
        if (!bsn.m9678b(str)) {
            return 0;
        }
        boolean z2;
        DrmInitData drmInitData = format.f1434h;
        if (drmInitData != null) {
            z2 = false;
            for (int i = 0; i < drmInitData.f1457a; i++) {
                z2 |= drmInitData.m2084a(i).f1454c;
            }
        } else {
            z2 = false;
        }
        bms a = com_ushareit_listenit_bmv.mo1016a(str, z2);
        if (a == null) {
            return 1;
        }
        boolean b = a.m9094b(format.f1429c);
        if (!b || format.f1435i <= 0 || format.f1436j <= 0) {
            z = b;
        } else if (btc.f7662a >= 21) {
            if (format.f1437k > 0.0f) {
                z = a.m9091a(format.f1435i, format.f1436j, (double) format.f1437k);
            } else {
                z = a.m9090a(format.f1435i, format.f1436j);
            }
        } else if (format.f1435i * format.f1436j <= bmx.m9108b()) {
            z = true;
        }
        return (a.f7110b ? 8 : 4) | (z ? 3 : 2);
    }

    protected void mo934a(boolean z) {
        super.mo934a(z);
        this.f7680c.m9836a(this.a);
        this.f7679b.m9822a();
    }

    protected void mo1070a(Format[] formatArr) {
        this.f7685h = formatArr;
        super.mo1070a(formatArr);
    }

    protected void mo933a(long j, boolean z) {
        super.mo933a(j, z);
        this.f7688k = false;
        this.f7692o = 0;
        long elapsedRealtime = (!z || this.f7681d <= 0) ? -9223372036854775807L : SystemClock.elapsedRealtime() + this.f7681d;
        this.f7689l = elapsedRealtime;
    }

    public boolean mo938r() {
        if ((this.f7688k || super.mo1104x()) && super.mo938r()) {
            this.f7689l = -9223372036854775807L;
            return true;
        } else if (this.f7689l == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.f7689l) {
                return true;
            }
            this.f7689l = -9223372036854775807L;
            return false;
        }
    }

    protected void mo935m() {
        super.mo935m();
        this.f7691n = 0;
        this.f7690m = SystemClock.elapsedRealtime();
    }

    protected void mo936n() {
        this.f7689l = -9223372036854775807L;
        m9801v();
        super.mo936n();
    }

    protected void mo937o() {
        this.f7695r = -1;
        this.f7696s = -1;
        this.f7698u = -1.0f;
        this.f7694q = -1.0f;
        this.f7699v = -1;
        this.f7700w = -1;
        this.f7702y = -1.0f;
        this.f7679b.m9823b();
        try {
            super.mo937o();
        } finally {
            this.a.m8395a();
            this.f7680c.m9838b(this.a);
        }
    }

    public void mo866a(int i, Object obj) {
        if (i == 1) {
            m9793a((Surface) obj);
        } else {
            super.mo866a(i, obj);
        }
    }

    private void m9793a(Surface surface) {
        if (this.f7687j != surface) {
            this.f7688k = false;
            this.f7687j = surface;
            int d = mo872d();
            if (d == 1 || d == 2) {
                m8357y();
                m8355w();
            }
        }
    }

    protected boolean mo1104x() {
        return super.mo1104x() && this.f7687j != null && this.f7687j.isValid();
    }

    protected void mo943a(MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        this.f7686i = m9790a(format, this.f7685h);
        mediaCodec.configure(m9789a(format, this.f7686i, this.f7684g), this.f7687j, mediaCrypto, 0);
    }

    protected void mo944a(String str, long j, long j2) {
        this.f7680c.m9837a(str, j, j2);
    }

    protected void mo947b(Format format) {
        super.mo947b(format);
        this.f7680c.m9835a(format);
        this.f7694q = m9798d(format);
        this.f7693p = m9799e(format);
    }

    protected void mo942a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        Object obj = (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) ? 1 : null;
        if (obj != null) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger(VastIconXmlManager.WIDTH);
        }
        this.f7695r = integer;
        if (obj != null) {
            integer = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer = mediaFormat.getInteger(VastIconXmlManager.HEIGHT);
        }
        this.f7696s = integer;
        this.f7698u = this.f7694q;
        if (btc.f7662a < 21) {
            this.f7697t = this.f7693p;
        } else if (this.f7693p == 90 || this.f7693p == 270) {
            integer = this.f7695r;
            this.f7695r = this.f7696s;
            this.f7696s = integer;
            this.f7698u = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT / this.f7698u;
        }
        mediaCodec.setVideoScalingMode(this.f7682e);
    }

    protected boolean mo1103a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return m9794a(format, format2) && format2.f1435i <= this.f7686i.f7703a && format2.f1436j <= this.f7686i.f7704b && format2.f1432f <= this.f7686i.f7705c && (z || (format.f1435i == format2.f1435i && format.f1436j == format2.f1436j));
    }

    protected boolean mo945a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        if (z) {
            m9791a(mediaCodec, i);
            return true;
        } else if (!this.f7688k) {
            if (btc.f7662a >= 21) {
                m9792a(mediaCodec, i, System.nanoTime());
            } else {
                m9797c(mediaCodec, i);
            }
            return true;
        } else if (mo872d() != 2) {
            return false;
        } else {
            long elapsedRealtime = (j3 - j) - ((SystemClock.elapsedRealtime() * 1000) - j2);
            long nanoTime = System.nanoTime();
            elapsedRealtime = this.f7679b.m9821a(j3, (elapsedRealtime * 1000) + nanoTime);
            nanoTime = (elapsedRealtime - nanoTime) / 1000;
            if (nanoTime < -30000) {
                m9795b(mediaCodec, i);
                return true;
            }
            if (btc.f7662a >= 21) {
                if (nanoTime < 50000) {
                    m9792a(mediaCodec, i, elapsedRealtime);
                    return true;
                }
            } else if (nanoTime < 30000) {
                if (nanoTime > 11000) {
                    try {
                        Thread.sleep((nanoTime - 10000) / 1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                m9797c(mediaCodec, i);
                return true;
            }
            return false;
        }
    }

    private void m9791a(MediaCodec mediaCodec, int i) {
        btb.m9756a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        btb.m9755a();
        bhe com_ushareit_listenit_bhe = this.a;
        com_ushareit_listenit_bhe.f6317e++;
    }

    private void m9795b(MediaCodec mediaCodec, int i) {
        btb.m9756a("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        btb.m9755a();
        bhe com_ushareit_listenit_bhe = this.a;
        com_ushareit_listenit_bhe.f6318f++;
        this.f7691n++;
        this.f7692o++;
        this.a.f6319g = Math.max(this.f7692o, this.a.f6319g);
        if (this.f7691n == this.f7683f) {
            m9801v();
        }
    }

    private void m9797c(MediaCodec mediaCodec, int i) {
        m9800t();
        btb.m9756a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        btb.m9755a();
        bhe com_ushareit_listenit_bhe = this.a;
        com_ushareit_listenit_bhe.f6316d++;
        this.f7692o = 0;
        if (!this.f7688k) {
            this.f7688k = true;
            this.f7680c.m9834a(this.f7687j);
        }
    }

    @TargetApi(21)
    private void m9792a(MediaCodec mediaCodec, int i, long j) {
        m9800t();
        btb.m9756a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j);
        btb.m9755a();
        bhe com_ushareit_listenit_bhe = this.a;
        com_ushareit_listenit_bhe.f6316d++;
        this.f7692o = 0;
        if (!this.f7688k) {
            this.f7688k = true;
            this.f7680c.m9834a(this.f7687j);
        }
    }

    @SuppressLint({"InlinedApi"})
    private static MediaFormat m9789a(Format format, bti com_ushareit_listenit_bti, boolean z) {
        MediaFormat b = format.m2081b();
        b.setInteger("max-width", com_ushareit_listenit_bti.f7703a);
        b.setInteger("max-height", com_ushareit_listenit_bti.f7704b);
        if (com_ushareit_listenit_bti.f7705c != -1) {
            b.setInteger("max-input-size", com_ushareit_listenit_bti.f7705c);
        }
        if (z) {
            b.setInteger("auto-frc", 0);
        }
        return b;
    }

    private static bti m9790a(Format format, Format[] formatArr) {
        int i = format.f1435i;
        int i2 = format.f1436j;
        int c = m9796c(format);
        int i3 = c;
        c = i2;
        i2 = i;
        for (Format format2 : formatArr) {
            if (m9794a(format, format2)) {
                i2 = Math.max(i2, format2.f1435i);
                c = Math.max(c, format2.f1436j);
                i3 = Math.max(i3, m9796c(format2));
            }
        }
        return new bti(i2, c, i3);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m9796c(com.google.android.exoplayer2.Format r6) {
        /*
        r1 = 4;
        r0 = 2;
        r2 = -1;
        r3 = r6.f1432f;
        if (r3 == r2) goto L_0x000a;
    L_0x0007:
        r0 = r6.f1432f;
    L_0x0009:
        return r0;
    L_0x000a:
        r3 = r6.f1435i;
        if (r3 == r2) goto L_0x0012;
    L_0x000e:
        r3 = r6.f1436j;
        if (r3 != r2) goto L_0x0014;
    L_0x0012:
        r0 = r2;
        goto L_0x0009;
    L_0x0014:
        r3 = r6.f1431e;
        r4 = r3.hashCode();
        switch(r4) {
            case -1664118616: goto L_0x0023;
            case -1662541442: goto L_0x004b;
            case 1187890754: goto L_0x002d;
            case 1331836730: goto L_0x0037;
            case 1599127256: goto L_0x0041;
            case 1599127257: goto L_0x0055;
            default: goto L_0x001d;
        };
    L_0x001d:
        r3 = r2;
    L_0x001e:
        switch(r3) {
            case 0: goto L_0x005f;
            case 1: goto L_0x005f;
            case 2: goto L_0x006b;
            case 3: goto L_0x0089;
            case 4: goto L_0x008f;
            case 5: goto L_0x008f;
            default: goto L_0x0021;
        };
    L_0x0021:
        r0 = r2;
        goto L_0x0009;
    L_0x0023:
        r4 = "video/3gpp";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x001d;
    L_0x002b:
        r3 = 0;
        goto L_0x001e;
    L_0x002d:
        r4 = "video/mp4v-es";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x001d;
    L_0x0035:
        r3 = 1;
        goto L_0x001e;
    L_0x0037:
        r4 = "video/avc";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x001d;
    L_0x003f:
        r3 = r0;
        goto L_0x001e;
    L_0x0041:
        r4 = "video/x-vnd.on2.vp8";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x001d;
    L_0x0049:
        r3 = 3;
        goto L_0x001e;
    L_0x004b:
        r4 = "video/hevc";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x001d;
    L_0x0053:
        r3 = r1;
        goto L_0x001e;
    L_0x0055:
        r4 = "video/x-vnd.on2.vp9";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x001d;
    L_0x005d:
        r3 = 5;
        goto L_0x001e;
    L_0x005f:
        r1 = r6.f1435i;
        r2 = r6.f1436j;
        r1 = r1 * r2;
    L_0x0064:
        r1 = r1 * 3;
        r0 = r0 * 2;
        r0 = r1 / r0;
        goto L_0x0009;
    L_0x006b:
        r1 = "BRAVIA 4K 2015";
        r3 = com.ushareit.listenit.btc.f7665d;
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x0077;
    L_0x0075:
        r0 = r2;
        goto L_0x0009;
    L_0x0077:
        r1 = r6.f1435i;
        r1 = r1 + 15;
        r1 = r1 / 16;
        r2 = r6.f1436j;
        r2 = r2 + 15;
        r2 = r2 / 16;
        r1 = r1 * r2;
        r1 = r1 * 16;
        r1 = r1 * 16;
        goto L_0x0064;
    L_0x0089:
        r1 = r6.f1435i;
        r2 = r6.f1436j;
        r1 = r1 * r2;
        goto L_0x0064;
    L_0x008f:
        r0 = r6.f1435i;
        r2 = r6.f1436j;
        r0 = r0 * r2;
        r5 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x0064;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.bth.c(com.google.android.exoplayer2.Format):int");
    }

    private void m9800t() {
        if (this.f7699v != this.f7695r || this.f7700w != this.f7696s || this.f7701x != this.f7697t || this.f7702y != this.f7698u) {
            this.f7680c.m9832a(this.f7695r, this.f7696s, this.f7697t, this.f7698u);
            this.f7699v = this.f7695r;
            this.f7700w = this.f7696s;
            this.f7701x = this.f7697t;
            this.f7702y = this.f7698u;
        }
    }

    private void m9801v() {
        if (this.f7691n > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f7680c.m9833a(this.f7691n, elapsedRealtime - this.f7690m);
            this.f7691n = 0;
            this.f7690m = elapsedRealtime;
        }
    }

    private static boolean m9788B() {
        return btc.f7662a <= 22 && "foster".equals(btc.f7663b) && "NVIDIA".equals(btc.f7664c);
    }

    private static boolean m9794a(Format format, Format format2) {
        return format.f1431e.equals(format2.f1431e) && m9799e(format) == m9799e(format2);
    }

    private static float m9798d(Format format) {
        return format.f1439m == -1.0f ? DefaultRetryPolicy.DEFAULT_BACKOFF_MULT : format.f1439m;
    }

    private static int m9799e(Format format) {
        return format.f1438l == -1 ? 0 : format.f1438l;
    }
}
