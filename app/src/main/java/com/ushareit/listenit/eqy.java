package com.ushareit.listenit;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.mopub.volley.DefaultRetryPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class eqy extends epk {
    private static ThreadLocal<ere> f11485h = new ThreadLocal();
    private static final ThreadLocal<ArrayList<eqy>> f11486i = new eqz();
    private static final ThreadLocal<ArrayList<eqy>> f11487j = new era();
    private static final ThreadLocal<ArrayList<eqy>> f11488k = new erb();
    private static final ThreadLocal<ArrayList<eqy>> f11489l = new erc();
    private static final ThreadLocal<ArrayList<eqy>> f11490m = new erd();
    private static final Interpolator f11491n = new AccelerateDecelerateInterpolator();
    private static final eqx f11492o = new epx();
    private static final eqx f11493p = new epv();
    private static long f11494z = 10;
    private int f11495A = 0;
    private int f11496B = 1;
    private Interpolator f11497C = f11491n;
    private ArrayList<erf> f11498D = null;
    long f11499b;
    long f11500c = -1;
    int f11501d = 0;
    boolean f11502e = false;
    eqt[] f11503f;
    HashMap<String, eqt> f11504g;
    private boolean f11505q = false;
    private int f11506r = 0;
    private float f11507s = 0.0f;
    private boolean f11508t = false;
    private long f11509u;
    private boolean f11510v = false;
    private boolean f11511w = false;
    private long f11512x = 300;
    private long f11513y = 0;

    public /* synthetic */ epk mo2233a(long j) {
        return mo2252c(j);
    }

    public /* synthetic */ Object clone() {
        return mo2255i();
    }

    public /* synthetic */ epk mo2239f() {
        return mo2255i();
    }

    public static eqy m17367b(int... iArr) {
        eqy com_ushareit_listenit_eqy = new eqy();
        com_ushareit_listenit_eqy.mo2250a(iArr);
        return com_ushareit_listenit_eqy;
    }

    public static eqy m17366b(float... fArr) {
        eqy com_ushareit_listenit_eqy = new eqy();
        com_ushareit_listenit_eqy.mo2249a(fArr);
        return com_ushareit_listenit_eqy;
    }

    public void mo2250a(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            if (this.f11503f == null || this.f11503f.length == 0) {
                m17387a(eqt.m17483a("", iArr));
            } else {
                this.f11503f[0].mo2268a(iArr);
            }
            this.f11502e = false;
        }
    }

    public void mo2249a(float... fArr) {
        if (fArr != null && fArr.length != 0) {
            if (this.f11503f == null || this.f11503f.length == 0) {
                m17387a(eqt.m17482a("", fArr));
            } else {
                this.f11503f[0].mo2264a(fArr);
            }
            this.f11502e = false;
        }
    }

    public void m17387a(eqt... com_ushareit_listenit_eqtArr) {
        this.f11503f = com_ushareit_listenit_eqtArr;
        this.f11504g = new HashMap(r2);
        for (eqt com_ushareit_listenit_eqt : com_ushareit_listenit_eqtArr) {
            this.f11504g.put(com_ushareit_listenit_eqt.m17498c(), com_ushareit_listenit_eqt);
        }
        this.f11502e = false;
    }

    void mo2253g() {
        if (!this.f11502e) {
            for (eqt b : this.f11503f) {
                b.m17496b();
            }
            this.f11502e = true;
        }
    }

    public eqy mo2252c(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.f11512x = j;
        return this;
    }

    public void m17391d(long j) {
        mo2253g();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f11501d != 1) {
            this.f11500c = j;
            this.f11501d = 2;
        }
        this.f11499b = currentAnimationTimeMillis - j;
        m17395f(currentAnimationTimeMillis);
    }

    public long m17398j() {
        if (!this.f11502e || this.f11501d == 0) {
            return 0;
        }
        return AnimationUtils.currentAnimationTimeMillis() - this.f11499b;
    }

    public void m17393e(long j) {
        this.f11513y = j;
    }

    public Object m17399k() {
        if (this.f11503f == null || this.f11503f.length <= 0) {
            return null;
        }
        return this.f11503f[0].mo2267d();
    }

    public void m17384a(erf com_ushareit_listenit_erf) {
        if (this.f11498D == null) {
            this.f11498D = new ArrayList();
        }
        this.f11498D.add(com_ushareit_listenit_erf);
    }

    public void m17383a(Interpolator interpolator) {
        if (interpolator != null) {
            this.f11497C = interpolator;
        } else {
            this.f11497C = new LinearInterpolator();
        }
    }

    private void m17363a(boolean z) {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        this.f11505q = z;
        this.f11506r = 0;
        this.f11501d = 0;
        this.f11511w = true;
        this.f11508t = false;
        ((ArrayList) f11487j.get()).add(this);
        if (this.f11513y == 0) {
            m17391d(m17398j());
            this.f11501d = 0;
            this.f11510v = true;
            if (this.a != null) {
                ArrayList arrayList = (ArrayList) this.a.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((epl) arrayList.get(i)).mo2229a(this);
                }
            }
        }
        ere com_ushareit_listenit_ere = (ere) f11485h.get();
        if (com_ushareit_listenit_ere == null) {
            com_ushareit_listenit_ere = new ere();
            f11485h.set(com_ushareit_listenit_ere);
        }
        com_ushareit_listenit_ere.sendEmptyMessage(0);
    }

    public void mo2234a() {
        m17363a(false);
    }

    public void mo2235b() {
        if (this.f11501d != 0 || ((ArrayList) f11487j.get()).contains(this) || ((ArrayList) f11488k.get()).contains(this)) {
            if (this.f11510v && this.a != null) {
                Iterator it = ((ArrayList) this.a.clone()).iterator();
                while (it.hasNext()) {
                    ((epl) it.next()).mo2231c(this);
                }
            }
            mo2254h();
        }
    }

    public boolean mo2236c() {
        return this.f11501d == 1 || this.f11510v;
    }

    public boolean mo2238d() {
        return this.f11511w;
    }

    private void mo2254h() {
        ((ArrayList) f11486i.get()).remove(this);
        ((ArrayList) f11487j.get()).remove(this);
        ((ArrayList) f11488k.get()).remove(this);
        this.f11501d = 0;
        if (this.f11510v && this.a != null) {
            ArrayList arrayList = (ArrayList) this.a.clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((epl) arrayList.get(i)).mo2230b(this);
            }
        }
        this.f11510v = false;
        this.f11511w = false;
    }

    private void m17379t() {
        mo2253g();
        ((ArrayList) f11486i.get()).add(this);
        if (this.f11513y > 0 && this.a != null) {
            ArrayList arrayList = (ArrayList) this.a.clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((epl) arrayList.get(i)).mo2229a(this);
            }
        }
    }

    private boolean mo2251b(long j) {
        if (this.f11508t) {
            long j2 = j - this.f11509u;
            if (j2 > this.f11513y) {
                this.f11499b = j - (j2 - this.f11513y);
                this.f11501d = 1;
                return true;
            }
        }
        this.f11508t = true;
        this.f11509u = j;
        return false;
    }

    boolean m17395f(long j) {
        boolean z = false;
        if (this.f11501d == 0) {
            this.f11501d = 1;
            if (this.f11500c < 0) {
                this.f11499b = j;
            } else {
                this.f11499b = j - this.f11500c;
                this.f11500c = -1;
            }
        }
        switch (this.f11501d) {
            case 1:
            case 2:
                float f;
                float f2 = this.f11512x > 0 ? ((float) (j - this.f11499b)) / ((float) this.f11512x) : DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
                if (f2 < DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
                    f = f2;
                } else if (this.f11506r < this.f11495A || this.f11495A == -1) {
                    if (this.a != null) {
                        int size = this.a.size();
                        for (int i = 0; i < size; i++) {
                            ((epl) this.a.get(i)).mo2232d(this);
                        }
                    }
                    if (this.f11496B == 2) {
                        this.f11505q = !this.f11505q;
                    }
                    this.f11506r += (int) f2;
                    f = f2 % DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
                    this.f11499b += this.f11512x;
                } else {
                    f = Math.min(f2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                    z = true;
                }
                if (this.f11505q) {
                    f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - f;
                }
                mo2248a(f);
                break;
        }
        return z;
    }

    public float m17400l() {
        return this.f11507s;
    }

    void mo2248a(float f) {
        int i;
        float interpolation = this.f11497C.getInterpolation(f);
        this.f11507s = interpolation;
        for (eqt a : this.f11503f) {
            a.mo2262a(interpolation);
        }
        if (this.f11498D != null) {
            int size = this.f11498D.size();
            for (i = 0; i < size; i++) {
                ((erf) this.f11498D.get(i)).mo2279a(this);
            }
        }
    }

    public eqy mo2255i() {
        int i = 0;
        eqy com_ushareit_listenit_eqy = (eqy) super.mo2239f();
        if (this.f11498D != null) {
            ArrayList arrayList = this.f11498D;
            com_ushareit_listenit_eqy.f11498D = new ArrayList();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                com_ushareit_listenit_eqy.f11498D.add(arrayList.get(i2));
            }
        }
        com_ushareit_listenit_eqy.f11500c = -1;
        com_ushareit_listenit_eqy.f11505q = false;
        com_ushareit_listenit_eqy.f11506r = 0;
        com_ushareit_listenit_eqy.f11502e = false;
        com_ushareit_listenit_eqy.f11501d = 0;
        com_ushareit_listenit_eqy.f11508t = false;
        eqt[] com_ushareit_listenit_eqtArr = this.f11503f;
        if (com_ushareit_listenit_eqtArr != null) {
            int length = com_ushareit_listenit_eqtArr.length;
            com_ushareit_listenit_eqy.f11503f = new eqt[length];
            com_ushareit_listenit_eqy.f11504g = new HashMap(length);
            while (i < length) {
                eqt a = com_ushareit_listenit_eqtArr[i].mo2261a();
                com_ushareit_listenit_eqy.f11503f[i] = a;
                com_ushareit_listenit_eqy.f11504g.put(a.m17498c(), a);
                i++;
            }
        }
        return com_ushareit_listenit_eqy;
    }

    public static void m17372m() {
        ((ArrayList) f11486i.get()).clear();
        ((ArrayList) f11487j.get()).clear();
        ((ArrayList) f11488k.get()).clear();
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.f11503f != null) {
            for (eqt com_ushareit_listenit_eqt : this.f11503f) {
                str = str + "\n    " + com_ushareit_listenit_eqt.toString();
            }
        }
        return str;
    }
}
