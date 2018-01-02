package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.mopub.mobileads.VastIconXmlManager;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class bmt extends bff {
    private static final byte[] f6259b = btc.m9778f("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private int f6260A;
    private boolean f6261B;
    private boolean f6262C;
    private int f6263D;
    private int f6264E;
    private boolean f6265F;
    private boolean f6266G;
    private boolean f6267H;
    private boolean f6268I;
    private boolean f6269J;
    protected bhe f6270a;
    private final bmv f6271c;
    private final bhm<bho> f6272d;
    private final boolean f6273e;
    private final bhf f6274f;
    private final bfu f6275g;
    private final List<Long> f6276h;
    private final BufferInfo f6277i;
    private Format f6278j;
    private MediaCodec f6279k;
    private bhl<bho> f6280l;
    private bhl<bho> f6281m;
    private boolean f6282n;
    private boolean f6283o;
    private boolean f6284p;
    private boolean f6285q;
    private boolean f6286r;
    private boolean f6287s;
    private boolean f6288t;
    private boolean f6289u;
    private boolean f6290v;
    private ByteBuffer[] f6291w;
    private ByteBuffer[] f6292x;
    private long f6293y;
    private int f6294z;

    protected abstract int mo940a(bmv com_ushareit_listenit_bmv, Format format);

    protected abstract void mo943a(MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto);

    protected abstract boolean mo945a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z);

    public bmt(int i, bmv com_ushareit_listenit_bmv, bhm<bho> com_ushareit_listenit_bhm_com_ushareit_listenit_bho, boolean z) {
        super(i);
        bsg.m9658b(btc.f7662a >= 16);
        this.f6271c = (bmv) bsg.m9654a((Object) com_ushareit_listenit_bmv);
        this.f6272d = com_ushareit_listenit_bhm_com_ushareit_listenit_bho;
        this.f6273e = z;
        this.f6274f = new bhf(0);
        this.f6275g = new bfu();
        this.f6276h = new ArrayList();
        this.f6277i = new BufferInfo();
        this.f6263D = 0;
        this.f6264E = 0;
    }

    public final int mo880l() {
        return 4;
    }

    public final int mo931a(Format format) {
        try {
            return mo940a(this.f6271c, format);
        } catch (Exception e) {
            throw bfi.m8024a(e, m8003p());
        }
    }

    protected bms mo941a(bmv com_ushareit_listenit_bmv, Format format, boolean z) {
        return com_ushareit_listenit_bmv.mo1016a(format.f1431e, z);
    }

    protected final void m8355w() {
        boolean a;
        MediaCrypto mediaCrypto;
        Throwable th;
        String str;
        long elapsedRealtime;
        long elapsedRealtime2;
        bhe com_ushareit_listenit_bhe;
        if (mo1104x()) {
            bms com_ushareit_listenit_bms;
            this.f6280l = this.f6281m;
            String str2 = this.f6278j.f1431e;
            if (this.f6280l != null) {
                int a2 = this.f6280l.m8426a();
                if (a2 == 0) {
                    throw bfi.m8024a(this.f6280l.m8429c(), m8003p());
                } else if (a2 == 3 || a2 == 4) {
                    MediaCrypto a3 = ((bho) this.f6280l.m8428b()).m8432a();
                    a = this.f6280l.m8427a(str2);
                    mediaCrypto = a3;
                } else {
                    return;
                }
            }
            a = false;
            mediaCrypto = null;
            try {
                bms a4 = mo941a(this.f6271c, this.f6278j, a);
                if (a4 == null && a) {
                    try {
                        a4 = mo941a(this.f6271c, this.f6278j, false);
                        if (a4 != null) {
                            Log.w("MediaCodecRenderer", "Drm session requires secure decoder for " + str2 + ", but no secure decoder available. Trying to proceed with " + a4.f7109a + ".");
                        }
                    } catch (Throwable e) {
                        Throwable th2 = e;
                        com_ushareit_listenit_bms = a4;
                        th = th2;
                        m8321a(new bmu(this.f6278j, th, a, -49998));
                        if (com_ushareit_listenit_bms == null) {
                            m8321a(new bmu(this.f6278j, null, a, -49999));
                        }
                        str = com_ushareit_listenit_bms.f7109a;
                        this.f6282n = com_ushareit_listenit_bms.f7110b;
                        this.f6283o = m8323a(str, this.f6278j);
                        this.f6284p = mo946a(str);
                        this.f6285q = m8325b(str);
                        this.f6286r = m8328c(str);
                        this.f6287s = m8330d(str);
                        this.f6288t = m8326b(str, this.f6278j);
                        elapsedRealtime = SystemClock.elapsedRealtime();
                        btb.m9756a("createCodec:" + str);
                        this.f6279k = MediaCodec.createByCodecName(str);
                        btb.m9755a();
                        btb.m9756a("configureCodec");
                        mo943a(this.f6279k, this.f6278j, mediaCrypto);
                        btb.m9755a();
                        btb.m9756a("startCodec");
                        this.f6279k.start();
                        btb.m9755a();
                        elapsedRealtime2 = SystemClock.elapsedRealtime();
                        mo944a(str, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                        this.f6291w = this.f6279k.getInputBuffers();
                        this.f6292x = this.f6279k.getOutputBuffers();
                        this.f6293y = mo872d() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                        this.f6294z = -1;
                        this.f6260A = -1;
                        com_ushareit_listenit_bhe = this.f6270a;
                        com_ushareit_listenit_bhe.f6313a++;
                    }
                }
                com_ushareit_listenit_bms = a4;
            } catch (bna e2) {
                th = e2;
                com_ushareit_listenit_bms = null;
                m8321a(new bmu(this.f6278j, th, a, -49998));
                if (com_ushareit_listenit_bms == null) {
                    m8321a(new bmu(this.f6278j, null, a, -49999));
                }
                str = com_ushareit_listenit_bms.f7109a;
                this.f6282n = com_ushareit_listenit_bms.f7110b;
                this.f6283o = m8323a(str, this.f6278j);
                this.f6284p = mo946a(str);
                this.f6285q = m8325b(str);
                this.f6286r = m8328c(str);
                this.f6287s = m8330d(str);
                this.f6288t = m8326b(str, this.f6278j);
                elapsedRealtime = SystemClock.elapsedRealtime();
                btb.m9756a("createCodec:" + str);
                this.f6279k = MediaCodec.createByCodecName(str);
                btb.m9755a();
                btb.m9756a("configureCodec");
                mo943a(this.f6279k, this.f6278j, mediaCrypto);
                btb.m9755a();
                btb.m9756a("startCodec");
                this.f6279k.start();
                btb.m9755a();
                elapsedRealtime2 = SystemClock.elapsedRealtime();
                mo944a(str, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                this.f6291w = this.f6279k.getInputBuffers();
                this.f6292x = this.f6279k.getOutputBuffers();
                if (mo872d() == 2) {
                }
                this.f6293y = mo872d() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                this.f6294z = -1;
                this.f6260A = -1;
                com_ushareit_listenit_bhe = this.f6270a;
                com_ushareit_listenit_bhe.f6313a++;
            }
            if (com_ushareit_listenit_bms == null) {
                m8321a(new bmu(this.f6278j, null, a, -49999));
            }
            str = com_ushareit_listenit_bms.f7109a;
            this.f6282n = com_ushareit_listenit_bms.f7110b;
            this.f6283o = m8323a(str, this.f6278j);
            this.f6284p = mo946a(str);
            this.f6285q = m8325b(str);
            this.f6286r = m8328c(str);
            this.f6287s = m8330d(str);
            this.f6288t = m8326b(str, this.f6278j);
            try {
                elapsedRealtime = SystemClock.elapsedRealtime();
                btb.m9756a("createCodec:" + str);
                this.f6279k = MediaCodec.createByCodecName(str);
                btb.m9755a();
                btb.m9756a("configureCodec");
                mo943a(this.f6279k, this.f6278j, mediaCrypto);
                btb.m9755a();
                btb.m9756a("startCodec");
                this.f6279k.start();
                btb.m9755a();
                elapsedRealtime2 = SystemClock.elapsedRealtime();
                mo944a(str, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                this.f6291w = this.f6279k.getInputBuffers();
                this.f6292x = this.f6279k.getOutputBuffers();
            } catch (Throwable e3) {
                m8321a(new bmu(this.f6278j, e3, a, str));
            }
            if (mo872d() == 2) {
            }
            this.f6293y = mo872d() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
            this.f6294z = -1;
            this.f6260A = -1;
            com_ushareit_listenit_bhe = this.f6270a;
            com_ushareit_listenit_bhe.f6313a++;
        }
    }

    private void m8321a(bmu com_ushareit_listenit_bmu) {
        throw bfi.m8024a(com_ushareit_listenit_bmu, m8003p());
    }

    protected boolean mo1104x() {
        return this.f6279k == null && this.f6278j != null;
    }

    protected void mo934a(boolean z) {
        this.f6270a = new bhe();
    }

    protected void mo933a(long j, boolean z) {
        this.f6267H = false;
        this.f6268I = false;
        if (this.f6279k != null) {
            m8358z();
        }
    }

    protected void mo937o() {
        this.f6278j = null;
        try {
            m8357y();
            try {
                if (this.f6280l != null) {
                    this.f6272d.m8431a(this.f6280l);
                }
                try {
                    if (!(this.f6281m == null || this.f6281m == this.f6280l)) {
                        this.f6272d.m8431a(this.f6281m);
                    }
                    this.f6280l = null;
                    this.f6281m = null;
                } catch (Throwable th) {
                    this.f6280l = null;
                    this.f6281m = null;
                }
            } catch (Throwable th2) {
                this.f6280l = null;
                this.f6281m = null;
            }
        } catch (Throwable th3) {
            this.f6280l = null;
            this.f6281m = null;
        }
    }

    protected void m8357y() {
        if (this.f6279k != null) {
            this.f6293y = -9223372036854775807L;
            this.f6294z = -1;
            this.f6260A = -1;
            this.f6269J = false;
            this.f6261B = false;
            this.f6276h.clear();
            this.f6291w = null;
            this.f6292x = null;
            this.f6262C = false;
            this.f6265F = false;
            this.f6282n = false;
            this.f6283o = false;
            this.f6284p = false;
            this.f6285q = false;
            this.f6286r = false;
            this.f6287s = false;
            this.f6288t = false;
            this.f6289u = false;
            this.f6290v = false;
            this.f6266G = false;
            this.f6263D = 0;
            this.f6264E = 0;
            bhe com_ushareit_listenit_bhe = this.f6270a;
            com_ushareit_listenit_bhe.f6314b++;
            try {
                this.f6279k.stop();
                try {
                    this.f6279k.release();
                    this.f6279k = null;
                    if (this.f6280l != null && this.f6281m != this.f6280l) {
                        try {
                            this.f6272d.m8431a(this.f6280l);
                        } finally {
                            this.f6280l = null;
                        }
                    }
                } catch (Throwable th) {
                    this.f6279k = null;
                    if (!(this.f6280l == null || this.f6281m == this.f6280l)) {
                        this.f6272d.m8431a(this.f6280l);
                    }
                } finally {
                    this.f6280l = null;
                }
            } catch (Throwable th2) {
                this.f6279k = null;
                if (!(this.f6280l == null || this.f6281m == this.f6280l)) {
                    try {
                        this.f6272d.m8431a(this.f6280l);
                    } finally {
                        this.f6280l = null;
                    }
                }
            } finally {
                this.f6280l = null;
            }
        }
    }

    protected void mo935m() {
    }

    protected void mo936n() {
    }

    public void mo932a(long j, long j2) {
        if (this.f6278j == null) {
            mo948t();
        }
        m8355w();
        if (this.f6279k != null) {
            btb.m9756a("drainAndFeed");
            do {
            } while (m8324b(j, j2));
            do {
            } while (mo950v());
            btb.m9755a();
        } else if (this.f6278j != null) {
            m7989b(j);
        }
        this.f6270a.m8395a();
    }

    private void mo948t() {
        if (m7979a(this.f6275g, null) == -5) {
            mo947b(this.f6275g.f6128a);
        }
    }

    protected void m8358z() {
        this.f6293y = -9223372036854775807L;
        this.f6294z = -1;
        this.f6260A = -1;
        this.f6269J = false;
        this.f6261B = false;
        this.f6276h.clear();
        this.f6289u = false;
        this.f6290v = false;
        if (this.f6284p || (this.f6287s && this.f6266G)) {
            m8357y();
            m8355w();
        } else if (this.f6264E != 0) {
            m8357y();
            m8355w();
        } else {
            this.f6279k.flush();
            this.f6265F = false;
        }
        if (this.f6262C && this.f6278j != null) {
            this.f6263D = 1;
        }
    }

    private boolean mo950v() {
        if (this.f6267H || this.f6264E == 2) {
            return false;
        }
        if (this.f6294z < 0) {
            this.f6294z = this.f6279k.dequeueInputBuffer(0);
            if (this.f6294z < 0) {
                return false;
            }
            this.f6274f.f6321b = this.f6291w[this.f6294z];
            this.f6274f.mo951a();
        }
        if (this.f6264E == 1) {
            if (!this.f6286r) {
                this.f6266G = true;
                this.f6279k.queueInputBuffer(this.f6294z, 0, 0, 0, 4);
                this.f6294z = -1;
            }
            this.f6264E = 2;
            return false;
        } else if (this.f6289u) {
            this.f6289u = false;
            this.f6274f.f6321b.put(f6259b);
            this.f6279k.queueInputBuffer(this.f6294z, 0, f6259b.length, 0, 0);
            this.f6294z = -1;
            this.f6265F = true;
            return true;
        } else {
            int i;
            int i2;
            if (this.f6269J) {
                i = -4;
                i2 = 0;
            } else {
                if (this.f6263D == 1) {
                    for (i = 0; i < this.f6278j.f1433g.size(); i++) {
                        this.f6274f.f6321b.put((byte[]) this.f6278j.f1433g.get(i));
                    }
                    this.f6263D = 2;
                }
                i2 = this.f6274f.f6321b.position();
                i = m7979a(this.f6275g, this.f6274f);
            }
            if (i == -3) {
                return false;
            }
            if (i == -5) {
                if (this.f6263D == 2) {
                    this.f6274f.mo951a();
                    this.f6263D = 1;
                }
                mo947b(this.f6275g.f6128a);
                return true;
            } else if (this.f6274f.m8384c()) {
                if (this.f6263D == 2) {
                    this.f6274f.mo951a();
                    this.f6263D = 1;
                }
                this.f6267H = true;
                if (this.f6265F) {
                    try {
                        if (this.f6286r) {
                            return false;
                        }
                        this.f6266G = true;
                        this.f6279k.queueInputBuffer(this.f6294z, 0, 0, 0, 4);
                        this.f6294z = -1;
                        return false;
                    } catch (Exception e) {
                        throw bfi.m8024a(e, m8003p());
                    }
                }
                m8319D();
                return false;
            } else {
                boolean d = this.f6274f.m8398d();
                this.f6269J = m8327b(d);
                if (this.f6269J) {
                    return false;
                }
                if (this.f6283o && !d) {
                    bso.m9686a(this.f6274f.f6321b);
                    if (this.f6274f.f6321b.position() == 0) {
                        return true;
                    }
                    this.f6283o = false;
                }
                try {
                    long j = this.f6274f.f6322c;
                    if (this.f6274f.b_()) {
                        this.f6276h.add(Long.valueOf(j));
                    }
                    this.f6274f.m8399e();
                    m8341a(this.f6274f);
                    if (d) {
                        this.f6279k.queueSecureInputBuffer(this.f6294z, 0, m8320a(this.f6274f, i2), j, 0);
                    } else {
                        this.f6279k.queueInputBuffer(this.f6294z, 0, this.f6274f.f6321b.limit(), j, 0);
                    }
                    this.f6294z = -1;
                    this.f6265F = true;
                    this.f6263D = 0;
                    bhe com_ushareit_listenit_bhe = this.f6270a;
                    com_ushareit_listenit_bhe.f6315c++;
                    return true;
                } catch (Exception e2) {
                    throw bfi.m8024a(e2, m8003p());
                }
            }
        }
    }

    private static CryptoInfo m8320a(bhf com_ushareit_listenit_bhf, int i) {
        CryptoInfo a = com_ushareit_listenit_bhf.f6320a.m8388a();
        if (i != 0) {
            if (a.numBytesOfClearData == null) {
                a.numBytesOfClearData = new int[1];
            }
            int[] iArr = a.numBytesOfClearData;
            iArr[0] = iArr[0] + i;
        }
        return a;
    }

    private boolean m8327b(boolean z) {
        if (this.f6280l == null) {
            return false;
        }
        int a = this.f6280l.m8426a();
        if (a == 0) {
            throw bfi.m8024a(this.f6280l.m8429c(), m8003p());
        } else if (a == 4) {
            return false;
        } else {
            if (z || !this.f6273e) {
                return true;
            }
            return false;
        }
    }

    protected void mo944a(String str, long j, long j2) {
    }

    protected void mo947b(Format format) {
        Format format2 = this.f6278j;
        this.f6278j = format;
        if (!btc.m9770a(this.f6278j.f1434h, format2 == null ? null : format2.f1434h)) {
            if (this.f6278j.f1434h == null) {
                this.f6281m = null;
            } else if (this.f6272d == null) {
                throw bfi.m8024a(new IllegalStateException("Media requires a DrmSessionManager"), m8003p());
            } else {
                this.f6281m = this.f6272d.m8430a(Looper.myLooper(), this.f6278j.f1434h);
                if (this.f6281m == this.f6280l) {
                    this.f6272d.m8431a(this.f6281m);
                }
            }
        }
        if (this.f6281m == this.f6280l && this.f6279k != null && mo1103a(this.f6279k, this.f6282n, format2, this.f6278j)) {
            boolean z;
            this.f6262C = true;
            this.f6263D = 1;
            if (this.f6285q && this.f6278j.f1435i == format2.f1435i && this.f6278j.f1436j == format2.f1436j) {
                z = true;
            } else {
                z = false;
            }
            this.f6289u = z;
        } else if (this.f6265F) {
            this.f6264E = 1;
        } else {
            m8357y();
            m8355w();
        }
    }

    protected void mo942a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    protected void mo949u() {
    }

    protected void m8341a(bhf com_ushareit_listenit_bhf) {
    }

    protected void m8347c(long j) {
    }

    protected boolean mo1103a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return false;
    }

    public boolean mo939s() {
        return this.f6268I;
    }

    public boolean mo938r() {
        return (this.f6278j == null || this.f6269J || (!m8004q() && this.f6260A < 0 && (this.f6293y == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.f6293y))) ? false : true;
    }

    protected long m8333A() {
        return 0;
    }

    private boolean m8324b(long j, long j2) {
        if (this.f6268I) {
            return false;
        }
        if (this.f6260A < 0) {
            this.f6260A = this.f6279k.dequeueOutputBuffer(this.f6277i, m8333A());
            if (this.f6260A >= 0) {
                if (this.f6290v) {
                    this.f6290v = false;
                    this.f6279k.releaseOutputBuffer(this.f6260A, false);
                    this.f6260A = -1;
                    return true;
                } else if ((this.f6277i.flags & 4) != 0) {
                    m8319D();
                    this.f6260A = -1;
                    return true;
                } else {
                    ByteBuffer byteBuffer = this.f6292x[this.f6260A];
                    if (byteBuffer != null) {
                        byteBuffer.position(this.f6277i.offset);
                        byteBuffer.limit(this.f6277i.offset + this.f6277i.size);
                    }
                    this.f6261B = m8329d(this.f6277i.presentationTimeUs);
                }
            } else if (this.f6260A == -2) {
                m8317B();
                return true;
            } else if (this.f6260A == -3) {
                m8318C();
                return true;
            } else if (!this.f6286r || (!this.f6267H && this.f6264E != 2)) {
                return false;
            } else {
                m8319D();
                return true;
            }
        }
        if (!mo945a(j, j2, this.f6279k, this.f6292x[this.f6260A], this.f6260A, this.f6277i.flags, this.f6277i.presentationTimeUs, this.f6261B)) {
            return false;
        }
        m8347c(this.f6277i.presentationTimeUs);
        this.f6260A = -1;
        return true;
    }

    private void m8317B() {
        MediaFormat outputFormat = this.f6279k.getOutputFormat();
        if (this.f6285q && outputFormat.getInteger(VastIconXmlManager.WIDTH) == 32 && outputFormat.getInteger(VastIconXmlManager.HEIGHT) == 32) {
            this.f6290v = true;
            return;
        }
        if (this.f6288t) {
            outputFormat.setInteger("channel-count", 1);
        }
        mo942a(this.f6279k, outputFormat);
    }

    private void m8318C() {
        this.f6292x = this.f6279k.getOutputBuffers();
    }

    private void m8319D() {
        if (this.f6264E == 2) {
            m8357y();
            m8355w();
            return;
        }
        this.f6268I = true;
        mo949u();
    }

    private boolean m8329d(long j) {
        int size = this.f6276h.size();
        for (int i = 0; i < size; i++) {
            if (((Long) this.f6276h.get(i)).longValue() == j) {
                this.f6276h.remove(i);
                return true;
            }
        }
        return false;
    }

    private static boolean mo946a(String str) {
        return btc.f7662a < 18 || ((btc.f7662a == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (btc.f7662a == 19 && btc.f7665d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str))));
    }

    private static boolean m8325b(String str) {
        return btc.f7662a < 24 && (("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) && ("flounder".equals(btc.f7663b) || "flounder_lte".equals(btc.f7663b) || "grouper".equals(btc.f7663b) || "tilapia".equals(btc.f7663b)));
    }

    private static boolean m8323a(String str, Format format) {
        return btc.f7662a < 21 && format.f1433g.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static boolean m8328c(String str) {
        return btc.f7662a <= 17 && ("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str));
    }

    private static boolean m8330d(String str) {
        return btc.f7662a <= 23 && "OMX.google.vorbis.decoder".equals(str);
    }

    private static boolean m8326b(String str, Format format) {
        if (btc.f7662a <= 18 && format.f1442p == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str)) {
            return true;
        }
        return false;
    }
}
