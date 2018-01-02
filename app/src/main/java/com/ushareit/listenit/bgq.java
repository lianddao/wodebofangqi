package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.ConditionVariable;
import android.util.Log;
import com.mopub.volley.DefaultRetryPolicy;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public final class bgq {
    public static boolean f6198a = false;
    public static boolean f6199b = false;
    private int f6200A;
    private int f6201B;
    private long f6202C;
    private long f6203D;
    private long f6204E;
    private float f6205F;
    private byte[] f6206G;
    private int f6207H;
    private ByteBuffer f6208I;
    private ByteBuffer f6209J;
    private boolean f6210K;
    private final bgh f6211c;
    private final int f6212d;
    private final ConditionVariable f6213e = new ConditionVariable(true);
    private final long[] f6214f;
    private final bgt f6215g;
    private AudioTrack f6216h;
    private AudioTrack f6217i;
    private int f6218j;
    private int f6219k;
    private int f6220l;
    private int f6221m;
    private boolean f6222n;
    private int f6223o;
    private int f6224p;
    private long f6225q;
    private int f6226r;
    private int f6227s;
    private long f6228t;
    private long f6229u;
    private boolean f6230v;
    private long f6231w;
    private Method f6232x;
    private long f6233y;
    private long f6234z;

    public bgq(bgh com_ushareit_listenit_bgh, int i) {
        this.f6211c = com_ushareit_listenit_bgh;
        this.f6212d = i;
        if (btc.f7662a >= 18) {
            try {
                this.f6232x = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException e) {
            }
        }
        if (btc.f7662a >= 23) {
            this.f6215g = new bgv();
        } else if (btc.f7662a >= 19) {
            this.f6215g = new bgu();
        } else {
            this.f6215g = new bgt();
        }
        this.f6214f = new long[10];
        this.f6205F = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        this.f6201B = 0;
    }

    public boolean m8272a(String str) {
        return this.f6211c != null && this.f6211c.m8238a(m8252b(str));
    }

    public boolean m8271a() {
        return this.f6217i != null;
    }

    public long m8267a(boolean z) {
        if (!m8258m()) {
            return Long.MIN_VALUE;
        }
        if (this.f6217i.getPlayState() == 3) {
            m8259n();
        }
        long nanoTime = System.nanoTime() / 1000;
        if (this.f6230v) {
            return m8253b(m8255c((long) (((float) (nanoTime - (this.f6215g.mo927e() / 1000))) * this.f6215g.mo930g())) + this.f6215g.mo928f()) + this.f6202C;
        }
        if (this.f6227s == 0) {
            nanoTime = this.f6215g.m8287c() + this.f6202C;
        } else {
            nanoTime = (nanoTime + this.f6228t) + this.f6202C;
        }
        if (z) {
            return nanoTime;
        }
        return nanoTime - this.f6204E;
    }

    public void m8270a(String str, int i, int i2, int i3, int i4) {
        int i5;
        switch (i) {
            case 1:
                i5 = 4;
                break;
            case 2:
                i5 = 12;
                break;
            case 3:
                i5 = 28;
                break;
            case 4:
                i5 = 204;
                break;
            case 5:
                i5 = 220;
                break;
            case 6:
                i5 = 252;
                break;
            case 7:
                i5 = 1276;
                break;
            case 8:
                i5 = bfg.f6043a;
                break;
            default:
                throw new IllegalArgumentException("Unsupported channel count: " + i);
        }
        boolean z = !"audio/raw".equals(str);
        if (z) {
            i3 = m8252b(str);
        } else if (!(i3 == 3 || i3 == 2 || i3 == Integer.MIN_VALUE || i3 == 1073741824)) {
            throw new IllegalArgumentException("Unsupported PCM encoding: " + i3);
        }
        if (!m8271a() || this.f6220l != i3 || this.f6218j != i2 || this.f6219k != i5) {
            long j;
            m8280i();
            this.f6220l = i3;
            this.f6222n = z;
            this.f6218j = i2;
            this.f6219k = i5;
            if (!z) {
                i3 = 2;
            }
            this.f6221m = i3;
            this.f6223o = i * 2;
            if (i4 != 0) {
                this.f6224p = i4;
            } else if (!z) {
                int minBufferSize = AudioTrack.getMinBufferSize(i2, i5, this.f6221m);
                bsg.m9658b(minBufferSize != -2);
                int i6 = minBufferSize * 4;
                i5 = ((int) m8255c(250000)) * this.f6223o;
                minBufferSize = (int) Math.max((long) minBufferSize, m8255c(750000) * ((long) this.f6223o));
                if (i6 >= i5) {
                    i5 = i6 > minBufferSize ? minBufferSize : i6;
                }
                this.f6224p = i5;
            } else if (this.f6221m == 5 || this.f6221m == 6) {
                this.f6224p = 20480;
            } else {
                this.f6224p = 49152;
            }
            if (z) {
                j = -9223372036854775807L;
            } else {
                j = m8253b(m8248a((long) this.f6224p));
            }
            this.f6225q = j;
        }
    }

    public int m8265a(int i) {
        this.f6213e.block();
        if (i == 0) {
            this.f6217i = new AudioTrack(this.f6212d, this.f6218j, this.f6219k, this.f6221m, this.f6224p, 1);
        } else {
            this.f6217i = new AudioTrack(this.f6212d, this.f6218j, this.f6219k, this.f6221m, this.f6224p, 1, i);
        }
        m8260o();
        int audioSessionId = this.f6217i.getAudioSessionId();
        if (f6198a && btc.f7662a < 21) {
            if (!(this.f6216h == null || audioSessionId == this.f6216h.getAudioSessionId())) {
                m8257l();
            }
            if (this.f6216h == null) {
                this.f6216h = new AudioTrack(this.f6212d, 4000, 4, 2, 2, 0, audioSessionId);
            }
        }
        this.f6215g.mo925a(this.f6217i, m8263r());
        m8256k();
        return audioSessionId;
    }

    public int m8273b() {
        return this.f6224p;
    }

    public long m8274c() {
        return this.f6225q;
    }

    public void m8275d() {
        if (m8271a()) {
            this.f6203D = System.nanoTime() / 1000;
            this.f6217i.play();
        }
    }

    public void m8276e() {
        if (this.f6201B == 1) {
            this.f6201B = 2;
        }
    }

    public int m8266a(ByteBuffer byteBuffer, long j) {
        boolean z;
        int remaining;
        int i = 1;
        int i2 = 0;
        int i3 = this.f6208I == null ? 1 : 0;
        if (i3 != 0 || this.f6208I == byteBuffer) {
            z = true;
        } else {
            z = false;
        }
        bsg.m9658b(z);
        this.f6208I = byteBuffer;
        if (m8263r()) {
            if (this.f6217i.getPlayState() == 2) {
                return 0;
            }
            if (this.f6217i.getPlayState() == 1 && this.f6215g.m8286b() != 0) {
                return 0;
            }
        }
        if (i3 == 0) {
            i = 0;
        } else if (this.f6208I.hasRemaining()) {
            this.f6210K = this.f6221m != this.f6220l;
            if (this.f6210K) {
                if (this.f6221m == 2) {
                    z = true;
                } else {
                    z = false;
                }
                bsg.m9658b(z);
                this.f6209J = m8250a(this.f6208I, this.f6220l, this.f6209J);
                byteBuffer = this.f6209J;
            }
            if (this.f6222n && this.f6200A == 0) {
                this.f6200A = m8246a(this.f6221m, byteBuffer);
            }
            if (this.f6201B == 0) {
                this.f6202C = Math.max(0, j);
                this.f6201B = 1;
                i = 0;
            } else {
                long b = this.f6202C + m8253b(m8261p());
                if (this.f6201B == 1 && Math.abs(b - j) > 200000) {
                    Log.e("AudioTrack", "Discontinuity detected [expected " + b + ", got " + j + "]");
                    this.f6201B = 2;
                }
                if (this.f6201B == 2) {
                    this.f6202C = (j - b) + this.f6202C;
                    this.f6201B = 1;
                } else {
                    i = 0;
                }
            }
            if (btc.f7662a < 21) {
                remaining = byteBuffer.remaining();
                if (this.f6206G == null || this.f6206G.length < remaining) {
                    this.f6206G = new byte[remaining];
                }
                int position = byteBuffer.position();
                byteBuffer.get(this.f6206G, 0, remaining);
                byteBuffer.position(position);
                this.f6207H = 0;
            }
        } else {
            this.f6208I = null;
            return 2;
        }
        if (this.f6210K) {
            byteBuffer = this.f6209J;
        }
        remaining = byteBuffer.remaining();
        if (btc.f7662a < 21) {
            position = this.f6224p - ((int) (this.f6233y - (this.f6215g.m8286b() * ((long) this.f6223o))));
            if (position > 0) {
                i2 = this.f6217i.write(this.f6206G, this.f6207H, Math.min(remaining, position));
                if (i2 >= 0) {
                    this.f6207H += i2;
                }
                byteBuffer.position(byteBuffer.position() + i2);
            }
        } else {
            i2 = m8247a(this.f6217i, byteBuffer, remaining);
        }
        if (i2 < 0) {
            throw new bgy(i2);
        }
        if (!this.f6222n) {
            this.f6233y += (long) i2;
        }
        if (i2 == remaining) {
            if (this.f6222n) {
                this.f6234z += (long) this.f6200A;
            }
            this.f6208I = null;
            i |= 2;
        }
        return i;
    }

    public void m8277f() {
        if (m8271a()) {
            this.f6215g.m8283a(m8261p());
        }
    }

    public boolean m8278g() {
        return m8271a() && (m8261p() > this.f6215g.m8286b() || m8264s());
    }

    public void m8269a(PlaybackParams playbackParams) {
        this.f6215g.mo929a(playbackParams);
    }

    public void m8268a(float f) {
        if (this.f6205F != f) {
            this.f6205F = f;
            m8256k();
        }
    }

    private void m8256k() {
        if (!m8271a()) {
            return;
        }
        if (btc.f7662a >= 21) {
            m8251a(this.f6217i, this.f6205F);
        } else {
            m8254b(this.f6217i, this.f6205F);
        }
    }

    public void m8279h() {
        if (m8271a()) {
            m8262q();
            this.f6215g.m8282a();
        }
    }

    public void m8280i() {
        if (m8271a()) {
            this.f6233y = 0;
            this.f6234z = 0;
            this.f6200A = 0;
            this.f6208I = null;
            this.f6201B = 0;
            this.f6204E = 0;
            m8262q();
            if (this.f6217i.getPlayState() == 3) {
                this.f6217i.pause();
            }
            AudioTrack audioTrack = this.f6217i;
            this.f6217i = null;
            this.f6215g.mo925a(null, false);
            this.f6213e.close();
            new bgr(this, audioTrack).start();
        }
    }

    public void m8281j() {
        m8280i();
        m8257l();
    }

    private void m8257l() {
        if (this.f6216h != null) {
            AudioTrack audioTrack = this.f6216h;
            this.f6216h = null;
            new bgs(this, audioTrack).start();
        }
    }

    private boolean m8258m() {
        return m8271a() && this.f6201B != 0;
    }

    private void m8259n() {
        long c = this.f6215g.m8287c();
        if (c != 0) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - this.f6229u >= 30000) {
                this.f6214f[this.f6226r] = c - nanoTime;
                this.f6226r = (this.f6226r + 1) % 10;
                if (this.f6227s < 10) {
                    this.f6227s++;
                }
                this.f6229u = nanoTime;
                this.f6228t = 0;
                for (int i = 0; i < this.f6227s; i++) {
                    this.f6228t += this.f6214f[i] / ((long) this.f6227s);
                }
            }
            if (!m8263r() && nanoTime - this.f6231w >= 500000) {
                this.f6230v = this.f6215g.mo926d();
                if (this.f6230v) {
                    long e = this.f6215g.mo927e() / 1000;
                    long f = this.f6215g.mo928f();
                    if (e < this.f6203D) {
                        this.f6230v = false;
                    } else if (Math.abs(e - nanoTime) > 5000000) {
                        r0 = "Spurious audio timestamp (system clock mismatch): " + f + ", " + e + ", " + nanoTime + ", " + c;
                        if (f6199b) {
                            throw new bgx(r0);
                        }
                        Log.w("AudioTrack", r0);
                        this.f6230v = false;
                    } else if (Math.abs(m8253b(f) - c) > 5000000) {
                        r0 = "Spurious audio timestamp (frame position mismatch): " + f + ", " + e + ", " + nanoTime + ", " + c;
                        if (f6199b) {
                            throw new bgx(r0);
                        }
                        Log.w("AudioTrack", r0);
                        this.f6230v = false;
                    }
                }
                if (!(this.f6232x == null || this.f6222n)) {
                    try {
                        this.f6204E = (((long) ((Integer) this.f6232x.invoke(this.f6217i, (Object[]) null)).intValue()) * 1000) - this.f6225q;
                        this.f6204E = Math.max(this.f6204E, 0);
                        if (this.f6204E > 5000000) {
                            Log.w("AudioTrack", "Ignoring impossibly large audio latency: " + this.f6204E);
                            this.f6204E = 0;
                        }
                    } catch (Exception e2) {
                        this.f6232x = null;
                    }
                }
                this.f6231w = nanoTime;
            }
        }
    }

    private void m8260o() {
        int state = this.f6217i.getState();
        if (state != 1) {
            try {
                this.f6217i.release();
            } catch (Exception e) {
            } finally {
                this.f6217i = null;
            }
            throw new bgw(state, this.f6218j, this.f6219k, this.f6224p);
        }
    }

    private long m8248a(long j) {
        return j / ((long) this.f6223o);
    }

    private long m8253b(long j) {
        return (1000000 * j) / ((long) this.f6218j);
    }

    private long m8255c(long j) {
        return (((long) this.f6218j) * j) / 1000000;
    }

    private long m8261p() {
        return this.f6222n ? this.f6234z : m8248a(this.f6233y);
    }

    private void m8262q() {
        this.f6228t = 0;
        this.f6227s = 0;
        this.f6226r = 0;
        this.f6229u = 0;
        this.f6230v = false;
        this.f6231w = 0;
    }

    private boolean m8263r() {
        return btc.f7662a < 23 && (this.f6221m == 5 || this.f6221m == 6);
    }

    private boolean m8264s() {
        return m8263r() && this.f6217i.getPlayState() == 2 && this.f6217i.getPlaybackHeadPosition() == 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.nio.ByteBuffer m8250a(java.nio.ByteBuffer r5, int r6, java.nio.ByteBuffer r7) {
        /*
        r4 = 0;
        r0 = r5.position();
        r2 = r5.limit();
        r1 = r2 - r0;
        switch(r6) {
            case -2147483648: goto L_0x0031;
            case 3: goto L_0x0014;
            case 1073741824: goto L_0x0036;
            default: goto L_0x000e;
        };
    L_0x000e:
        r0 = new java.lang.IllegalStateException;
        r0.<init>();
        throw r0;
    L_0x0014:
        r1 = r1 * 2;
    L_0x0016:
        if (r7 == 0) goto L_0x001e;
    L_0x0018:
        r3 = r7.capacity();
        if (r3 >= r1) goto L_0x0022;
    L_0x001e:
        r7 = java.nio.ByteBuffer.allocateDirect(r1);
    L_0x0022:
        r7.position(r4);
        r7.limit(r1);
        switch(r6) {
            case -2147483648: goto L_0x004d;
            case 3: goto L_0x0039;
            case 1073741824: goto L_0x0064;
            default: goto L_0x002b;
        };
    L_0x002b:
        r0 = new java.lang.IllegalStateException;
        r0.<init>();
        throw r0;
    L_0x0031:
        r1 = r1 / 3;
        r1 = r1 * 2;
        goto L_0x0016;
    L_0x0036:
        r1 = r1 / 2;
        goto L_0x0016;
    L_0x0039:
        if (r0 >= r2) goto L_0x007b;
    L_0x003b:
        r7.put(r4);
        r1 = r5.get(r0);
        r1 = r1 & 255;
        r1 = r1 + -128;
        r1 = (byte) r1;
        r7.put(r1);
        r0 = r0 + 1;
        goto L_0x0039;
    L_0x004d:
        if (r0 >= r2) goto L_0x007b;
    L_0x004f:
        r1 = r0 + 1;
        r1 = r5.get(r1);
        r7.put(r1);
        r1 = r0 + 2;
        r1 = r5.get(r1);
        r7.put(r1);
        r0 = r0 + 3;
        goto L_0x004d;
    L_0x0064:
        if (r0 >= r2) goto L_0x007b;
    L_0x0066:
        r1 = r0 + 2;
        r1 = r5.get(r1);
        r7.put(r1);
        r1 = r0 + 3;
        r1 = r5.get(r1);
        r7.put(r1);
        r0 = r0 + 4;
        goto L_0x0064;
    L_0x007b:
        r7.position(r4);
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.bgq.a(java.nio.ByteBuffer, int, java.nio.ByteBuffer):java.nio.ByteBuffer");
    }

    private static int m8252b(String str) {
        int i = -1;
        switch (str.hashCode()) {
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    i = 2;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    i = 0;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    i = 1;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    i = 3;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                return 5;
            case 1:
                return 6;
            case 2:
                return 7;
            case 3:
                return 8;
            default:
                return 0;
        }
    }

    private static int m8246a(int i, ByteBuffer byteBuffer) {
        if (i == 7 || i == 8) {
            return bgz.m8300a(byteBuffer);
        }
        if (i == 5) {
            return bgg.m8226a();
        }
        if (i == 6) {
            return bgg.m8228a(byteBuffer);
        }
        throw new IllegalStateException("Unexpected audio encoding: " + i);
    }

    @TargetApi(21)
    private static int m8247a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    @TargetApi(21)
    private static void m8251a(AudioTrack audioTrack, float f) {
        audioTrack.setVolume(f);
    }

    private static void m8254b(AudioTrack audioTrack, float f) {
        audioTrack.setStereoVolume(f, f);
    }
}
