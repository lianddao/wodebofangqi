package com.ushareit.listenit;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import java.io.IOException;

final class bfq<T> implements Callback, boc, boe, bqr {
    private int f6075A;
    private bfr<T> f6076B;
    private bfr<T> f6077C;
    private bfr<T> f6078D;
    private bgd f6079E;
    private final bfx[] f6080a;
    private final bfy[] f6081b;
    private final bqo<T> f6082c;
    private final bfv f6083d;
    private final bta f6084e;
    private final Handler f6085f;
    private final HandlerThread f6086g;
    private final Handler f6087h;
    private final bgf f6088i;
    private final bge f6089j;
    private bfs f6090k;
    private bfx f6091l;
    private bsm f6092m;
    private bod f6093n;
    private bfx[] f6094o;
    private boolean f6095p;
    private boolean f6096q;
    private boolean f6097r;
    private boolean f6098s;
    private int f6099t = 1;
    private int f6100u;
    private int f6101v;
    private long f6102w;
    private long f6103x;
    private boolean f6104y;
    private boolean f6105z;

    public /* synthetic */ void mo909a(bog com_ushareit_listenit_bog) {
        m8114b((bob) com_ushareit_listenit_bog);
    }

    public bfq(bfx[] com_ushareit_listenit_bfxArr, bqo<T> com_ushareit_listenit_bqo_T, bfv com_ushareit_listenit_bfv, boolean z, Handler handler, bfs com_ushareit_listenit_bfs) {
        this.f6080a = com_ushareit_listenit_bfxArr;
        this.f6082c = com_ushareit_listenit_bqo_T;
        this.f6083d = com_ushareit_listenit_bfv;
        this.f6096q = z;
        this.f6087h = handler;
        this.f6090k = com_ushareit_listenit_bfs;
        this.f6081b = new bfy[com_ushareit_listenit_bfxArr.length];
        for (int i = 0; i < com_ushareit_listenit_bfxArr.length; i++) {
            com_ushareit_listenit_bfxArr[i].mo865a(i);
            this.f6081b[i] = com_ushareit_listenit_bfxArr[i].mo870b();
        }
        this.f6084e = new bta();
        this.f6094o = new bfx[0];
        this.f6088i = new bgf();
        this.f6089j = new bge();
        com_ushareit_listenit_bqo_T.m9507a((bqr) this);
        this.f6086g = new bsv("ExoPlayerImplInternal:Handler", -16);
        this.f6086g.start();
        this.f6085f = new Handler(this.f6086g.getLooper(), this);
    }

    public void m8109a(bod com_ushareit_listenit_bod, boolean z) {
        int i;
        Handler handler = this.f6085f;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        handler.obtainMessage(0, i, 0, com_ushareit_listenit_bod).sendToTarget();
    }

    public void m8111a(boolean z) {
        int i;
        Handler handler = this.f6085f;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        handler.obtainMessage(1, i, 0).sendToTarget();
    }

    public void m8106a(int i, long j) {
        this.f6085f.obtainMessage(3, i, 0, Long.valueOf(j)).sendToTarget();
    }

    public void m8105a() {
        this.f6085f.sendEmptyMessage(4);
    }

    public void m8112a(bfm... com_ushareit_listenit_bfmArr) {
        if (this.f6095p) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        this.f6100u++;
        this.f6085f.obtainMessage(10, com_ushareit_listenit_bfmArr).sendToTarget();
    }

    public synchronized void m8115b(bfm... com_ushareit_listenit_bfmArr) {
        if (this.f6095p) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        } else {
            int i = this.f6100u;
            this.f6100u = i + 1;
            this.f6085f.obtainMessage(10, com_ushareit_listenit_bfmArr).sendToTarget();
            while (this.f6101v <= i) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public synchronized void m8113b() {
        if (!this.f6095p) {
            this.f6085f.sendEmptyMessage(5);
            while (!this.f6095p) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            this.f6086g.quit();
        }
    }

    public void mo907a(bgd com_ushareit_listenit_bgd, Object obj) {
        this.f6085f.obtainMessage(6, Pair.create(com_ushareit_listenit_bgd, obj)).sendToTarget();
    }

    public void mo908a(bob com_ushareit_listenit_bob) {
        this.f6085f.obtainMessage(7, com_ushareit_listenit_bob).sendToTarget();
    }

    public void m8114b(bob com_ushareit_listenit_bob) {
        this.f6085f.obtainMessage(8, com_ushareit_listenit_bob).sendToTarget();
    }

    public boolean handleMessage(Message message) {
        boolean z = false;
        try {
            switch (message.what) {
                case 0:
                    bod com_ushareit_listenit_bod = (bod) message.obj;
                    if (message.arg1 != 0) {
                        z = true;
                    }
                    m8085b(com_ushareit_listenit_bod, z);
                    return true;
                case 1:
                    if (message.arg1 != 0) {
                        z = true;
                    }
                    m8090c(z);
                    return true;
                case 2:
                    m8096f();
                    return true;
                case 3:
                    m8083b(message.arg1, ((Long) message.obj).longValue());
                    return true;
                case 4:
                    m8097g();
                    return true;
                case 5:
                    m8098h();
                    return true;
                case 6:
                    m8077a((Pair) message.obj);
                    return true;
                case 7:
                    m8089c((bob) message.obj);
                    return true;
                case 8:
                    m8093d((bob) message.obj);
                    return true;
                case 9:
                    m8100j();
                    return true;
                case 10:
                    m8091c((bfm[]) message.obj);
                    return true;
                default:
                    return false;
            }
        } catch (Throwable e) {
            Log.e("ExoPlayerImplInternal", "Renderer error.", e);
            this.f6087h.obtainMessage(6, e).sendToTarget();
            m8097g();
            return true;
        } catch (IOException e2) {
            Log.e("ExoPlayerImplInternal", "Source error.", e2);
            this.f6087h.obtainMessage(6, bfi.m8023a(e2)).sendToTarget();
            m8097g();
            return true;
        } catch (RuntimeException e3) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e3);
            this.f6087h.obtainMessage(6, bfi.m8025a(e3)).sendToTarget();
            m8097g();
            return true;
        }
    }

    private void m8074a(int i) {
        if (this.f6099t != i) {
            this.f6099t = i;
            this.f6087h.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private void m8086b(boolean z) {
        if (this.f6098s != z) {
            int i;
            this.f6098s = z;
            Handler handler = this.f6087h;
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            handler.obtainMessage(2, i, 0).sendToTarget();
        }
    }

    private void m8085b(bod com_ushareit_listenit_bod, boolean z) {
        m8099i();
        this.f6083d.mo881a();
        if (z) {
            this.f6090k = new bfs(0, -9223372036854775807L);
        }
        this.f6093n = com_ushareit_listenit_bod;
        com_ushareit_listenit_bod.mo1049a((boe) this);
        m8074a(2);
        this.f6085f.sendEmptyMessage(2);
    }

    private void m8090c(boolean z) {
        this.f6097r = false;
        this.f6096q = z;
        if (!z) {
            m8092d();
            m8095e();
        } else if (this.f6099t == 3) {
            m8088c();
            this.f6085f.sendEmptyMessage(2);
        } else if (this.f6099t == 2) {
            this.f6085f.sendEmptyMessage(2);
        }
    }

    private void m8088c() {
        int i = 0;
        this.f6097r = false;
        this.f6084e.m9751a();
        bfx[] com_ushareit_listenit_bfxArr = this.f6094o;
        int length = com_ushareit_listenit_bfxArr.length;
        while (i < length) {
            com_ushareit_listenit_bfxArr[i].mo873e();
            i++;
        }
    }

    private void m8092d() {
        this.f6084e.m9753b();
        for (bfx a : this.f6094o) {
            m8079a(a);
        }
    }

    private void m8095e() {
        if (this.f6076B != null) {
            long f = this.f6076B.f6106a.mo1037f();
            if (f != -9223372036854775807L) {
                m8075a(f);
            } else {
                if (this.f6091l == null || this.f6091l.mo939s()) {
                    this.f6103x = this.f6084e.mo948t();
                } else {
                    this.f6103x = this.f6092m.mo948t();
                    this.f6084e.m9752a(this.f6103x);
                }
                f = this.f6103x - this.f6076B.f6115j;
            }
            this.f6090k.f6126c = f;
            this.f6102w = SystemClock.elapsedRealtime() * 1000;
            if (this.f6094o.length == 0) {
                f = Long.MIN_VALUE;
            } else {
                f = this.f6076B.f6106a.mo1038g();
            }
            bfs com_ushareit_listenit_bfs = this.f6090k;
            if (f == Long.MIN_VALUE) {
                f = this.f6079E.m8212a(this.f6076B.f6110e, this.f6089j).m8219b();
            }
            com_ushareit_listenit_bfs.f6127d = f;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m8096f() {
        /*
        r15 = this;
        r4 = android.os.SystemClock.elapsedRealtime();
        r15.m8102l();
        r0 = r15.f6076B;
        if (r0 != 0) goto L_0x0014;
    L_0x000b:
        r15.m8101k();
        r0 = 10;
        r15.m8076a(r4, r0);
    L_0x0013:
        return;
    L_0x0014:
        r0 = "doSomeWork";
        com.ushareit.listenit.btb.m9756a(r0);
        r15.m8095e();
        r2 = 1;
        r1 = 1;
        r6 = r15.f6094o;
        r7 = r6.length;
        r0 = 0;
        r3 = r1;
        r14 = r0;
        r0 = r2;
        r2 = r14;
    L_0x0026:
        if (r2 >= r7) goto L_0x005b;
    L_0x0028:
        r8 = r6[r2];
        r10 = r15.f6103x;
        r12 = r15.f6102w;
        r8.mo932a(r10, r12);
        if (r0 == 0) goto L_0x0055;
    L_0x0033:
        r0 = r8.mo939s();
        if (r0 == 0) goto L_0x0055;
    L_0x0039:
        r0 = 1;
    L_0x003a:
        r1 = r8.mo938r();
        if (r1 != 0) goto L_0x0046;
    L_0x0040:
        r1 = r8.mo939s();
        if (r1 == 0) goto L_0x0057;
    L_0x0046:
        r1 = 1;
    L_0x0047:
        if (r1 != 0) goto L_0x004c;
    L_0x0049:
        r8.mo877i();
    L_0x004c:
        if (r3 == 0) goto L_0x0059;
    L_0x004e:
        if (r1 == 0) goto L_0x0059;
    L_0x0050:
        r1 = 1;
    L_0x0051:
        r2 = r2 + 1;
        r3 = r1;
        goto L_0x0026;
    L_0x0055:
        r0 = 0;
        goto L_0x003a;
    L_0x0057:
        r1 = 0;
        goto L_0x0047;
    L_0x0059:
        r1 = 0;
        goto L_0x0051;
    L_0x005b:
        if (r3 != 0) goto L_0x0060;
    L_0x005d:
        r15.m8101k();
    L_0x0060:
        r1 = r15.f6079E;
        r2 = r15.f6076B;
        r2 = r2.f6110e;
        r6 = r15.f6089j;
        r1 = r1.m8212a(r2, r6);
        r6 = r1.m8219b();
        if (r0 == 0) goto L_0x00a1;
    L_0x0072:
        r0 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1));
        if (r0 == 0) goto L_0x0083;
    L_0x007b:
        r0 = r15.f6090k;
        r0 = r0.f6126c;
        r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1));
        if (r0 > 0) goto L_0x00a1;
    L_0x0083:
        r0 = r15.f6105z;
        if (r0 == 0) goto L_0x00a1;
    L_0x0087:
        r0 = 4;
        r15.m8074a(r0);
        r15.m8092d();
    L_0x008e:
        r0 = r15.f6099t;
        r1 = 2;
        if (r0 != r1) goto L_0x00e3;
    L_0x0093:
        r1 = r15.f6094o;
        r2 = r1.length;
        r0 = 0;
    L_0x0097:
        if (r0 >= r2) goto L_0x00e3;
    L_0x0099:
        r3 = r1[r0];
        r3.mo877i();
        r0 = r0 + 1;
        goto L_0x0097;
    L_0x00a1:
        r0 = r15.f6099t;
        r1 = 2;
        if (r0 != r1) goto L_0x00c6;
    L_0x00a6:
        r0 = r15.f6094o;
        r0 = r0.length;
        if (r0 <= 0) goto L_0x00c1;
    L_0x00ab:
        if (r3 == 0) goto L_0x008e;
    L_0x00ad:
        r0 = r15.f6097r;
        r0 = r15.m8094d(r0);
        if (r0 == 0) goto L_0x008e;
    L_0x00b5:
        r0 = 3;
        r15.m8074a(r0);
        r0 = r15.f6096q;
        if (r0 == 0) goto L_0x008e;
    L_0x00bd:
        r15.m8088c();
        goto L_0x008e;
    L_0x00c1:
        r0 = r15.f6104y;
        if (r0 == 0) goto L_0x008e;
    L_0x00c5:
        goto L_0x00b5;
    L_0x00c6:
        r0 = r15.f6099t;
        r1 = 3;
        if (r0 != r1) goto L_0x008e;
    L_0x00cb:
        r0 = r15.f6094o;
        r0 = r0.length;
        if (r0 <= 0) goto L_0x00de;
    L_0x00d0:
        if (r3 != 0) goto L_0x008e;
    L_0x00d2:
        r0 = r15.f6096q;
        r15.f6097r = r0;
        r0 = 2;
        r15.m8074a(r0);
        r15.m8092d();
        goto L_0x008e;
    L_0x00de:
        r0 = r15.f6104y;
        if (r0 != 0) goto L_0x008e;
    L_0x00e2:
        goto L_0x00d2;
    L_0x00e3:
        r0 = r15.f6096q;
        if (r0 == 0) goto L_0x00ec;
    L_0x00e7:
        r0 = r15.f6099t;
        r1 = 3;
        if (r0 == r1) goto L_0x00f1;
    L_0x00ec:
        r0 = r15.f6099t;
        r1 = 2;
        if (r0 != r1) goto L_0x00fb;
    L_0x00f1:
        r0 = 10;
        r15.m8076a(r4, r0);
    L_0x00f6:
        com.ushareit.listenit.btb.m9755a();
        goto L_0x0013;
    L_0x00fb:
        r0 = r15.f6094o;
        r0 = r0.length;
        if (r0 == 0) goto L_0x0106;
    L_0x0100:
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r15.m8076a(r4, r0);
        goto L_0x00f6;
    L_0x0106:
        r0 = r15.f6085f;
        r1 = 2;
        r0.removeMessages(r1);
        goto L_0x00f6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.bfq.f():void");
    }

    private void m8076a(long j, long j2) {
        this.f6085f.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.f6085f.sendEmptyMessage(2);
        } else {
            this.f6085f.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private void m8083b(int i, long j) {
        if (j == -9223372036854775807L) {
            try {
                if (this.f6079E != null && i < this.f6079E.mo1055b()) {
                    Pair b = m8082b(i);
                    i = ((Integer) b.first).intValue();
                    j = ((Long) b.second).longValue();
                }
            } catch (Throwable th) {
                this.f6090k = new bfs(i, j);
                this.f6087h.obtainMessage(3, this.f6090k).sendToTarget();
            }
        }
        if (i == this.f6090k.f6124a && ((j == -9223372036854775807L && this.f6090k.f6126c == -9223372036854775807L) || j / 1000 == this.f6090k.f6126c / 1000)) {
            this.f6090k = new bfs(i, j);
            this.f6087h.obtainMessage(3, this.f6090k).sendToTarget();
            return;
        }
        this.f6090k = new bfs(i, m8087c(i, j));
        this.f6087h.obtainMessage(3, this.f6090k).sendToTarget();
    }

    private long m8087c(int i, long j) {
        if (this.f6093n != null) {
            bfr com_ushareit_listenit_bfr;
            m8092d();
            this.f6097r = false;
            m8074a(2);
            if (j == -9223372036854775807L || (this.f6077C != this.f6076B && (i == this.f6076B.f6110e || i == this.f6077C.f6110e))) {
                i = -1;
            }
            if (this.f6076B != null) {
                bfr com_ushareit_listenit_bfr2 = this.f6076B;
                com_ushareit_listenit_bfr = null;
                while (com_ushareit_listenit_bfr2 != null) {
                    if (com_ushareit_listenit_bfr2.f6110e == i && com_ushareit_listenit_bfr2.f6113h) {
                        com_ushareit_listenit_bfr = com_ushareit_listenit_bfr2;
                    } else {
                        com_ushareit_listenit_bfr2.m8124c();
                    }
                    com_ushareit_listenit_bfr2 = com_ushareit_listenit_bfr2.f6116k;
                }
            } else if (this.f6078D != null) {
                this.f6078D.m8124c();
                com_ushareit_listenit_bfr = null;
            } else {
                com_ushareit_listenit_bfr = null;
            }
            if (com_ushareit_listenit_bfr != this.f6076B) {
                for (bfx k : this.f6094o) {
                    k.mo879k();
                }
                this.f6094o = new bfx[0];
                this.f6092m = null;
                this.f6091l = null;
            }
            this.f6075A = 0;
            if (com_ushareit_listenit_bfr != null) {
                com_ushareit_listenit_bfr.f6116k = null;
                m8084b(com_ushareit_listenit_bfr);
                m8104n();
                this.f6077C = this.f6076B;
                this.f6078D = this.f6076B;
                if (this.f6076B.f6114i) {
                    j = this.f6076B.f6106a.mo1033b(j);
                }
                m8075a(j);
                m8103m();
            } else {
                this.f6076B = null;
                this.f6077C = null;
                this.f6078D = null;
                if (j != -9223372036854775807L) {
                    m8075a(j);
                }
            }
            m8095e();
            this.f6085f.sendEmptyMessage(2);
        } else if (j != -9223372036854775807L) {
            m8075a(j);
        }
        return j;
    }

    private void m8075a(long j) {
        this.f6103x = (this.f6076B == null ? 0 : this.f6076B.f6115j) + j;
        this.f6084e.m9752a(this.f6103x);
        for (bfx a : this.f6094o) {
            a.mo867a(this.f6103x);
        }
    }

    private void m8097g() {
        m8099i();
        this.f6083d.mo885b();
        m8074a(1);
    }

    private void m8098h() {
        m8099i();
        this.f6083d.mo886c();
        m8074a(1);
        synchronized (this) {
            this.f6095p = true;
            notifyAll();
        }
    }

    private void m8099i() {
        Throwable e;
        this.f6085f.removeMessages(2);
        this.f6097r = false;
        this.f6084e.m9753b();
        this.f6092m = null;
        this.f6091l = null;
        for (bfx com_ushareit_listenit_bfx : this.f6094o) {
            try {
                m8079a(com_ushareit_listenit_bfx);
                com_ushareit_listenit_bfx.mo879k();
            } catch (bfi e2) {
                e = e2;
            } catch (RuntimeException e3) {
                e = e3;
            }
        }
        this.f6094o = new bfx[0];
        m8078a(this.f6076B != null ? this.f6076B : this.f6078D);
        if (this.f6093n != null) {
            this.f6093n.mo1050b();
            this.f6093n = null;
        }
        this.f6104y = false;
        this.f6105z = false;
        this.f6076B = null;
        this.f6077C = null;
        this.f6078D = null;
        this.f6079E = null;
        this.f6075A = 0;
        m8086b(false);
        return;
        Log.e("ExoPlayerImplInternal", "Stop failed.", e);
    }

    private void m8091c(bfm[] com_ushareit_listenit_bfmArr) {
        try {
            for (bfm com_ushareit_listenit_bfm : com_ushareit_listenit_bfmArr) {
                com_ushareit_listenit_bfm.f6056a.mo866a(com_ushareit_listenit_bfm.f6057b, com_ushareit_listenit_bfm.f6058c);
            }
            if (this.f6093n != null) {
                this.f6085f.sendEmptyMessage(2);
            }
            synchronized (this) {
                this.f6101v++;
                notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.f6101v++;
                notifyAll();
            }
        }
    }

    private void m8079a(bfx com_ushareit_listenit_bfx) {
        if (com_ushareit_listenit_bfx.mo872d() == 2) {
            com_ushareit_listenit_bfx.mo878j();
        }
    }

    private void m8100j() {
        if (this.f6076B != null) {
            bfr com_ushareit_listenit_bfr = this.f6076B;
            boolean z = true;
            while (com_ushareit_listenit_bfr != null && com_ushareit_listenit_bfr.f6113h) {
                if (com_ushareit_listenit_bfr.m8123b()) {
                    if (z) {
                        boolean z2;
                        if (this.f6077C != this.f6076B) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        m8078a(this.f6076B.f6116k);
                        this.f6076B.f6116k = null;
                        this.f6077C = this.f6076B;
                        this.f6078D = this.f6076B;
                        this.f6075A = 0;
                        boolean[] zArr = new boolean[this.f6080a.length];
                        long a = this.f6076B.m8118a(this.f6090k.f6126c, this.f6083d, z2, zArr);
                        if (a != this.f6090k.f6126c) {
                            this.f6090k.f6126c = a;
                            m8075a(a);
                        }
                        boolean[] zArr2 = new boolean[this.f6080a.length];
                        int i = 0;
                        for (int i2 = 0; i2 < this.f6080a.length; i2++) {
                            bfx com_ushareit_listenit_bfx = this.f6080a[i2];
                            zArr2[i2] = com_ushareit_listenit_bfx.mo872d() != 0;
                            bof com_ushareit_listenit_bof = this.f6076B.f6108c[i2];
                            if (com_ushareit_listenit_bof != null) {
                                i++;
                            }
                            if (zArr2[i2]) {
                                if (com_ushareit_listenit_bof != com_ushareit_listenit_bfx.mo874f()) {
                                    if (com_ushareit_listenit_bfx == this.f6091l) {
                                        if (com_ushareit_listenit_bof == null) {
                                            this.f6084e.m9752a(this.f6092m.mo948t());
                                        }
                                        this.f6092m = null;
                                        this.f6091l = null;
                                    }
                                    m8079a(com_ushareit_listenit_bfx);
                                    com_ushareit_listenit_bfx.mo879k();
                                } else if (zArr[i2]) {
                                    com_ushareit_listenit_bfx.mo867a(this.f6090k.f6126c);
                                }
                            }
                        }
                        this.f6082c.m9505a(this.f6076B.f6122q);
                        m8081a(zArr2, i);
                    } else {
                        this.f6078D = com_ushareit_listenit_bfr;
                        bfr com_ushareit_listenit_bfr2 = this.f6078D.f6116k;
                        while (com_ushareit_listenit_bfr2 != null) {
                            com_ushareit_listenit_bfr2.m8124c();
                            com_ushareit_listenit_bfr2 = com_ushareit_listenit_bfr2.f6116k;
                            this.f6075A--;
                        }
                        this.f6078D.f6116k = null;
                        this.f6078D.m8117a(Math.max(0, this.f6103x - this.f6078D.f6115j), this.f6083d, false);
                    }
                    m8103m();
                    m8095e();
                    this.f6085f.sendEmptyMessage(2);
                    return;
                }
                if (com_ushareit_listenit_bfr == this.f6077C) {
                    z = false;
                }
                com_ushareit_listenit_bfr = com_ushareit_listenit_bfr.f6116k;
            }
        }
    }

    private boolean m8094d(boolean z) {
        if (this.f6078D == null) {
            return false;
        }
        long g;
        long j = this.f6103x - this.f6078D.f6115j;
        if (this.f6078D.f6113h) {
            g = this.f6078D.f6106a.mo1038g();
        } else {
            g = 0;
        }
        if (g == Long.MIN_VALUE) {
            if (this.f6078D.f6112g) {
                return true;
            }
            g = this.f6079E.m8212a(this.f6078D.f6110e, this.f6089j).m8219b();
        }
        return this.f6083d.mo884a(g - j, z);
    }

    private void m8101k() {
        if (this.f6078D != null && !this.f6078D.f6113h) {
            if (this.f6077C == null || this.f6077C.f6116k == this.f6078D) {
                bfx[] com_ushareit_listenit_bfxArr = this.f6094o;
                int length = com_ushareit_listenit_bfxArr.length;
                int i = 0;
                while (i < length) {
                    if (com_ushareit_listenit_bfxArr[i].mo875g()) {
                        i++;
                    } else {
                        return;
                    }
                }
                this.f6078D.f6106a.mo1034c();
            }
        }
    }

    private void m8077a(Pair<bgd, Object> pair) {
        int i;
        this.f6087h.obtainMessage(5, pair).sendToTarget();
        bgd com_ushareit_listenit_bgd = this.f6079E;
        this.f6079E = (bgd) pair.first;
        if (this.f6076B != null) {
            int a = this.f6079E.mo1052a(this.f6076B.f6107b);
            if (a == -1) {
                m8080a(this.f6079E, com_ushareit_listenit_bgd, this.f6076B.f6110e);
                return;
            }
            this.f6079E.mo1053a(a, this.f6089j, true);
            this.f6076B.m8121a(this.f6079E, this.f6079E.m8214a(this.f6089j.f6158c, this.f6088i), a);
            bfr com_ushareit_listenit_bfr = this.f6076B;
            this.f6075A = 0;
            int i2 = a;
            bfr com_ushareit_listenit_bfr2 = com_ushareit_listenit_bfr;
            i = 0;
            bfr com_ushareit_listenit_bfr3 = com_ushareit_listenit_bfr2;
            while (com_ushareit_listenit_bfr3.f6116k != null) {
                bfr com_ushareit_listenit_bfr4 = com_ushareit_listenit_bfr3.f6116k;
                i2++;
                this.f6079E.mo1053a(i2, this.f6089j, true);
                if (com_ushareit_listenit_bfr4.f6107b.equals(this.f6089j.f6157b)) {
                    this.f6075A++;
                    com_ushareit_listenit_bfr4.m8121a(this.f6079E, this.f6079E.m8214a(this.f6079E.m8212a(i2, this.f6089j).f6158c, this.f6088i), i2);
                    if (com_ushareit_listenit_bfr4 == this.f6077C) {
                        i = true;
                    }
                    com_ushareit_listenit_bfr3 = com_ushareit_listenit_bfr4;
                } else if (i == 0) {
                    i = this.f6076B.f6110e;
                    m8078a(this.f6076B);
                    this.f6076B = null;
                    this.f6077C = null;
                    this.f6078D = null;
                    long c = m8087c(i, this.f6090k.f6126c);
                    if (c != this.f6090k.f6126c) {
                        this.f6090k = new bfs(i, c);
                        this.f6087h.obtainMessage(4, this.f6090k).sendToTarget();
                        return;
                    }
                    return;
                } else {
                    this.f6078D = com_ushareit_listenit_bfr3;
                    this.f6078D.f6116k = null;
                    m8078a(com_ushareit_listenit_bfr4);
                }
            }
        } else if (this.f6078D != null) {
            i = this.f6079E.mo1052a(this.f6078D.f6107b);
            if (i == -1) {
                m8080a(this.f6079E, com_ushareit_listenit_bgd, this.f6078D.f6110e);
                return;
            }
            this.f6078D.m8121a(this.f6079E, this.f6079E.m8214a(this.f6079E.m8212a(i, this.f6089j).f6158c, this.f6088i), i);
        }
        if (com_ushareit_listenit_bgd != null) {
            i = this.f6076B != null ? this.f6076B.f6110e : this.f6078D != null ? this.f6078D.f6110e : -1;
            if (i != -1 && i != this.f6090k.f6124a) {
                this.f6090k = new bfs(i, this.f6090k.f6126c);
                m8095e();
                this.f6087h.obtainMessage(4, this.f6090k).sendToTarget();
            }
        }
    }

    private void m8080a(bgd com_ushareit_listenit_bgd, bgd com_ushareit_listenit_bgd2, int i) {
        int i2 = -1;
        while (i2 == -1 && i < com_ushareit_listenit_bgd2.mo1055b() - 1) {
            i++;
            i2 = com_ushareit_listenit_bgd.mo1052a(com_ushareit_listenit_bgd2.mo1053a(i, this.f6089j, true).f6157b);
        }
        if (i2 == -1) {
            m8097g();
            return;
        }
        m8078a(this.f6076B != null ? this.f6076B : this.f6078D);
        this.f6075A = 0;
        this.f6076B = null;
        this.f6077C = null;
        this.f6078D = null;
        Pair b = m8082b(i2);
        this.f6090k = new bfs(((Integer) b.first).intValue(), ((Long) b.second).longValue());
        this.f6087h.obtainMessage(4, this.f6090k).sendToTarget();
    }

    private Pair<Integer, Long> m8082b(int i) {
        this.f6079E.m8212a(i, this.f6089j);
        this.f6079E.m8214a(this.f6089j.f6158c, this.f6088i);
        int i2 = this.f6088i.f6166f;
        long d = this.f6088i.m8225d() + this.f6088i.m8221a();
        this.f6079E.m8212a(i2, this.f6089j);
        while (i2 < this.f6088i.f6167g && d > this.f6089j.m8217a()) {
            d -= this.f6089j.m8219b();
            int i3 = i2 + 1;
            this.f6079E.m8212a(i2, this.f6089j);
            i2 = i3;
        }
        return Pair.create(Integer.valueOf(i2), Long.valueOf(d));
    }

    private void m8102l() {
        int i = 0;
        if (this.f6079E == null) {
            this.f6093n.mo1047a();
            return;
        }
        int i2;
        if (this.f6078D == null || (this.f6078D.m8122a() && !this.f6078D.f6112g && this.f6075A < 100)) {
            i2 = this.f6078D == null ? this.f6090k.f6124a : this.f6078D.f6110e + 1;
            if (i2 >= this.f6079E.mo1055b()) {
                this.f6093n.mo1047a();
            } else {
                int i3 = this.f6079E.m8212a(i2, this.f6089j).f6158c;
                long j = this.f6078D == null ? this.f6090k.f6126c : i2 == this.f6079E.m8214a(i3, this.f6088i).f6166f ? -9223372036854775807L : 0;
                if (j == -9223372036854775807L) {
                    Pair b = m8082b(i2);
                    int intValue = ((Integer) b.first).intValue();
                    j = ((Long) b.second).longValue();
                    i2 = intValue;
                }
                Object obj = this.f6079E.mo1053a(i2, this.f6089j, true).f6157b;
                bob a = this.f6093n.mo1046a(i2, this.f6083d.mo887d(), j);
                a.mo1029a(this);
                bfr com_ushareit_listenit_bfr = new bfr(this.f6080a, this.f6081b, this.f6082c, this.f6093n, a, obj, j);
                this.f6079E.m8214a(i3, this.f6088i);
                com_ushareit_listenit_bfr.m8121a(this.f6079E, this.f6088i, i2);
                if (this.f6078D != null) {
                    this.f6078D.m8120a(com_ushareit_listenit_bfr);
                    com_ushareit_listenit_bfr.f6115j = this.f6078D.f6115j + this.f6079E.m8212a(this.f6078D.f6110e, this.f6089j).m8219b();
                }
                this.f6075A++;
                this.f6078D = com_ushareit_listenit_bfr;
                m8086b(true);
            }
        }
        if (this.f6078D == null || this.f6078D.m8122a()) {
            m8086b(false);
        } else if (this.f6078D != null && this.f6078D.f6117l) {
            m8103m();
        }
        if (this.f6076B != null) {
            while (this.f6076B != this.f6077C && this.f6076B.f6116k != null && this.f6103x >= this.f6076B.f6116k.f6115j) {
                this.f6076B.m8124c();
                m8084b(this.f6076B.f6116k);
                this.f6075A--;
                this.f6090k = new bfs(this.f6076B.f6110e, this.f6076B.f6111f);
                m8095e();
                this.f6087h.obtainMessage(4, this.f6090k).sendToTarget();
            }
            m8104n();
            if (this.f6077C.f6112g) {
                bfx[] com_ushareit_listenit_bfxArr = this.f6094o;
                intValue = com_ushareit_listenit_bfxArr.length;
                while (i < intValue) {
                    com_ushareit_listenit_bfxArr[i].mo876h();
                    i++;
                }
                return;
            }
            bfx[] com_ushareit_listenit_bfxArr2 = this.f6094o;
            int length = com_ushareit_listenit_bfxArr2.length;
            i2 = 0;
            while (i2 < length) {
                if (com_ushareit_listenit_bfxArr2[i2].mo875g()) {
                    i2++;
                } else {
                    return;
                }
            }
            if (this.f6077C.f6116k != null && this.f6077C.f6116k.f6113h) {
                bqn b2 = this.f6077C.f6122q;
                this.f6077C = this.f6077C.f6116k;
                bqn b3 = this.f6077C.f6122q;
                for (i2 = 0; i2 < this.f6080a.length; i2++) {
                    bfx com_ushareit_listenit_bfx = this.f6080a[i2];
                    bql a2 = b2.m9530a(i2);
                    bql a3 = b3.m9530a(i2);
                    if (a2 != null) {
                        if (a3 != null) {
                            Format[] formatArr = new Format[a3.mo1080b()];
                            for (intValue = 0; intValue < formatArr.length; intValue++) {
                                formatArr[intValue] = a3.mo1078a(intValue);
                            }
                            com_ushareit_listenit_bfx.mo868a(formatArr, this.f6077C.f6108c[i2], this.f6077C.f6115j);
                        } else {
                            com_ushareit_listenit_bfx.mo876h();
                        }
                    }
                }
            }
        }
    }

    private void m8089c(bob com_ushareit_listenit_bob) {
        if (this.f6078D != null && this.f6078D.f6106a == com_ushareit_listenit_bob) {
            this.f6078D.m8119a(this.f6078D.f6111f, this.f6083d);
            if (this.f6076B == null) {
                this.f6077C = this.f6078D;
                m8084b(this.f6077C);
                if (this.f6090k.f6125b == -9223372036854775807L) {
                    this.f6090k = new bfs(this.f6076B.f6110e, this.f6076B.f6111f);
                    m8075a(this.f6090k.f6125b);
                    m8095e();
                    this.f6087h.obtainMessage(4, this.f6090k).sendToTarget();
                }
                m8104n();
            }
            m8103m();
        }
    }

    private void m8093d(bob com_ushareit_listenit_bob) {
        if (this.f6078D != null && this.f6078D.f6106a == com_ushareit_listenit_bob) {
            m8103m();
        }
    }

    private void m8103m() {
        long e = this.f6078D.f6106a.mo1036e();
        if (e != Long.MIN_VALUE) {
            long j = this.f6103x - this.f6078D.f6115j;
            boolean a = this.f6083d.mo883a(e - j);
            m8086b(a);
            if (a) {
                this.f6078D.f6117l = false;
                this.f6078D.f6106a.mo1032a(j);
                return;
            }
            this.f6078D.f6117l = true;
            return;
        }
        m8086b(false);
    }

    private void m8078a(bfr<T> com_ushareit_listenit_bfr_T) {
        while (com_ushareit_listenit_bfr_T != null) {
            com_ushareit_listenit_bfr_T.m8124c();
            com_ushareit_listenit_bfr_T = com_ushareit_listenit_bfr_T.f6116k;
        }
    }

    private void m8084b(bfr<T> com_ushareit_listenit_bfr_T) {
        boolean[] zArr = new boolean[this.f6080a.length];
        int i = 0;
        for (int i2 = 0; i2 < this.f6080a.length; i2++) {
            boolean z;
            bfx com_ushareit_listenit_bfx = this.f6080a[i2];
            if (com_ushareit_listenit_bfx.mo872d() != 0) {
                z = true;
            } else {
                z = false;
            }
            zArr[i2] = z;
            if (com_ushareit_listenit_bfr_T.f6122q.m9530a(i2) != null) {
                i++;
            } else if (zArr[i2]) {
                if (com_ushareit_listenit_bfx == this.f6091l) {
                    this.f6084e.m9752a(this.f6092m.mo948t());
                    this.f6092m = null;
                    this.f6091l = null;
                }
                m8079a(com_ushareit_listenit_bfx);
                com_ushareit_listenit_bfx.mo879k();
            }
        }
        this.f6082c.m9505a(com_ushareit_listenit_bfr_T.f6122q);
        this.f6076B = com_ushareit_listenit_bfr_T;
        m8081a(zArr, i);
    }

    private void m8104n() {
        long b = this.f6079E.m8212a(this.f6076B.f6110e, this.f6089j).m8219b();
        boolean z = b == -9223372036854775807L || this.f6090k.f6126c < b || (this.f6076B.f6116k != null && this.f6076B.f6116k.f6113h);
        this.f6104y = z;
        this.f6105z = this.f6076B.f6112g;
    }

    private void m8081a(boolean[] zArr, int i) {
        this.f6094o = new bfx[i];
        int i2 = 0;
        for (int i3 = 0; i3 < this.f6080a.length; i3++) {
            bfx com_ushareit_listenit_bfx = this.f6080a[i3];
            bql a = this.f6076B.f6122q.m9530a(i3);
            if (a != null) {
                int i4 = i2 + 1;
                this.f6094o[i2] = com_ushareit_listenit_bfx;
                if (com_ushareit_listenit_bfx.mo872d() == 0) {
                    boolean z;
                    Object obj = (this.f6096q && this.f6099t == 3) ? 1 : null;
                    if (zArr[i3] || obj == null) {
                        z = false;
                    } else {
                        z = true;
                    }
                    Format[] formatArr = new Format[a.mo1080b()];
                    for (int i5 = 0; i5 < formatArr.length; i5++) {
                        formatArr[i5] = a.mo1078a(i5);
                    }
                    com_ushareit_listenit_bfx.mo869a(formatArr, this.f6076B.f6108c[i3], this.f6103x, z, this.f6076B.f6115j);
                    bsm c = com_ushareit_listenit_bfx.mo871c();
                    if (c != null) {
                        if (this.f6092m != null) {
                            throw bfi.m8025a(new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                        this.f6092m = c;
                        this.f6091l = com_ushareit_listenit_bfx;
                    }
                    if (obj != null) {
                        com_ushareit_listenit_bfx.mo873e();
                    }
                }
                i2 = i4;
            }
        }
    }
}
