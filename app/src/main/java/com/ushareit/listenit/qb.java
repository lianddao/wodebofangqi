package com.ushareit.listenit;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.mopub.mobileads.resource.DrawableConstants.CloseButton;
import com.mopub.volley.DefaultRetryPolicy;
import java.util.Arrays;

public class qb {
    private static final Interpolator f16297v = new qc();
    private int f16298a;
    private int f16299b;
    private int f16300c = -1;
    private float[] f16301d;
    private float[] f16302e;
    private float[] f16303f;
    private float[] f16304g;
    private int[] f16305h;
    private int[] f16306i;
    private int[] f16307j;
    private int f16308k;
    private VelocityTracker f16309l;
    private float f16310m;
    private float f16311n;
    private int f16312o;
    private int f16313p;
    private pb f16314q;
    private final qe f16315r;
    private View f16316s;
    private boolean f16317t;
    private final ViewGroup f16318u;
    private final Runnable f16319w = new qd(this);

    public static qb m25668a(ViewGroup viewGroup, qe qeVar) {
        return new qb(viewGroup.getContext(), viewGroup, qeVar);
    }

    public static qb m25667a(ViewGroup viewGroup, float f, qe qeVar) {
        qb a = m25668a(viewGroup, qeVar);
        a.f16299b = (int) (((float) a.f16299b) * (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT / f));
        return a;
    }

    private qb(Context context, ViewGroup viewGroup, qe qeVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (qeVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f16318u = viewGroup;
            this.f16315r = qeVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f16312o = (int) ((context.getResources().getDisplayMetrics().density * CloseButton.TEXT_SIZE_SP) + 0.5f);
            this.f16299b = viewConfiguration.getScaledTouchSlop();
            this.f16310m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f16311n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f16314q = pb.m25418a(context, f16297v);
        }
    }

    public void m25686a(float f) {
        this.f16311n = f;
    }

    public int m25685a() {
        return this.f16298a;
    }

    public void m25687a(int i) {
        this.f16313p = i;
    }

    public int m25693b() {
        return this.f16312o;
    }

    public void m25688a(View view, int i) {
        if (view.getParent() != this.f16318u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f16318u + ")");
        }
        this.f16316s = view;
        this.f16300c = i;
        this.f16315r.mo2970b(view, i);
        m25700c(1);
    }

    public View m25699c() {
        return this.f16316s;
    }

    public int m25702d() {
        return this.f16299b;
    }

    public void m25705e() {
        this.f16300c = -1;
        m25682g();
        if (this.f16309l != null) {
            this.f16309l.recycle();
            this.f16309l = null;
        }
    }

    public void m25706f() {
        m25705e();
        if (this.f16298a == 2) {
            int b = this.f16314q.m25425b();
            int c = this.f16314q.m25426c();
            this.f16314q.m25431h();
            int b2 = this.f16314q.m25425b();
            int c2 = this.f16314q.m25426c();
            this.f16315r.mo2653a(this.f16316s, b2, c2, b2 - b, c2 - c);
        }
        m25700c(0);
    }

    public boolean m25691a(View view, int i, int i2) {
        this.f16316s = view;
        this.f16300c = -1;
        boolean a = m25672a(i, i2, 0, 0);
        if (!(a || this.f16298a != 0 || this.f16316s == null)) {
            this.f16316s = null;
        }
        return a;
    }

    public boolean m25689a(int i, int i2) {
        if (this.f16317t) {
            return m25672a(i, i2, (int) iv.m24121a(this.f16309l, this.f16300c), (int) iv.m24122b(this.f16309l, this.f16300c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean m25672a(int i, int i2, int i3, int i4) {
        int left = this.f16316s.getLeft();
        int top = this.f16316s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f16314q.m25431h();
            m25700c(0);
            return false;
        }
        this.f16314q.m25420a(left, top, i5, i6, m25666a(this.f16316s, i5, i6, i3, i4));
        m25700c(2);
        return true;
    }

    private int m25666a(View view, int i, int i2, int i3, int i4) {
        int b = m25675b(i3, (int) this.f16311n, (int) this.f16310m);
        int b2 = m25675b(i4, (int) this.f16311n, (int) this.f16310m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) m25665a(i2, b2, this.f16315r.mo2654b(view)))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) m25665a(i, b, this.f16315r.mo2967a(view)))));
    }

    private int m25665a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f16318u.getWidth();
        int i4 = width / 2;
        float b = (m25674b(Math.min(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        if (i4 > 0) {
            width = Math.round(Math.abs(b / ((float) i4)) * 1000.0f) * 4;
        } else {
            width = (int) (((((float) Math.abs(i)) / ((float) i3)) + DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) * 256.0f);
        }
        return Math.min(width, 600);
    }

    private int m25675b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs <= i3) {
            return i;
        }
        if (i <= 0) {
            return -i3;
        }
        return i3;
    }

    private float m25664a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs <= f3) {
            return f;
        }
        if (f <= 0.0f) {
            return -f3;
        }
        return f3;
    }

    private float m25674b(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    public boolean m25692a(boolean z) {
        if (this.f16298a == 2) {
            int i;
            boolean g = this.f16314q.m25430g();
            int b = this.f16314q.m25425b();
            int c = this.f16314q.m25426c();
            int left = b - this.f16316s.getLeft();
            int top = c - this.f16316s.getTop();
            if (left != 0) {
                ja.m24158e(this.f16316s, left);
            }
            if (top != 0) {
                ja.m24155d(this.f16316s, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f16315r.mo2653a(this.f16316s, b, c, left, top);
            }
            if (g && b == this.f16314q.m25427d() && c == this.f16314q.m25428e()) {
                this.f16314q.m25431h();
                i = 0;
            } else {
                boolean z2 = g;
            }
            if (i == 0) {
                if (z) {
                    this.f16318u.post(this.f16319w);
                } else {
                    m25700c(0);
                }
            }
        }
        return this.f16298a == 2;
    }

    private void m25669a(float f, float f2) {
        this.f16317t = true;
        this.f16315r.mo2645a(this.f16316s, f, f2);
        this.f16317t = false;
        if (this.f16298a == 1) {
            m25700c(0);
        }
    }

    private void m25682g() {
        if (this.f16301d != null) {
            Arrays.fill(this.f16301d, 0.0f);
            Arrays.fill(this.f16302e, 0.0f);
            Arrays.fill(this.f16303f, 0.0f);
            Arrays.fill(this.f16304g, 0.0f);
            Arrays.fill(this.f16305h, 0);
            Arrays.fill(this.f16306i, 0);
            Arrays.fill(this.f16307j, 0);
            this.f16308k = 0;
        }
    }

    private void m25680e(int i) {
        if (this.f16301d != null) {
            this.f16301d[i] = 0.0f;
            this.f16302e[i] = 0.0f;
            this.f16303f[i] = 0.0f;
            this.f16304g[i] = 0.0f;
            this.f16305h[i] = 0;
            this.f16306i[i] = 0;
            this.f16307j[i] = 0;
            this.f16308k &= (1 << i) ^ -1;
        }
    }

    private void m25681f(int i) {
        if (this.f16301d == null || this.f16301d.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.f16301d != null) {
                System.arraycopy(this.f16301d, 0, obj, 0, this.f16301d.length);
                System.arraycopy(this.f16302e, 0, obj2, 0, this.f16302e.length);
                System.arraycopy(this.f16303f, 0, obj3, 0, this.f16303f.length);
                System.arraycopy(this.f16304g, 0, obj4, 0, this.f16304g.length);
                System.arraycopy(this.f16305h, 0, obj5, 0, this.f16305h.length);
                System.arraycopy(this.f16306i, 0, obj6, 0, this.f16306i.length);
                System.arraycopy(this.f16307j, 0, obj7, 0, this.f16307j.length);
            }
            this.f16301d = obj;
            this.f16302e = obj2;
            this.f16303f = obj3;
            this.f16304g = obj4;
            this.f16305h = obj5;
            this.f16306i = obj6;
            this.f16307j = obj7;
        }
    }

    private void m25670a(float f, float f2, int i) {
        m25681f(i);
        float[] fArr = this.f16301d;
        this.f16303f[i] = f;
        fArr[i] = f;
        fArr = this.f16302e;
        this.f16304g[i] = f2;
        fArr[i] = f2;
        this.f16305h[i] = m25679e((int) f, (int) f2);
        this.f16308k |= 1 << i;
    }

    private void m25678c(MotionEvent motionEvent) {
        int c = hu.m24056c(motionEvent);
        for (int i = 0; i < c; i++) {
            int b = hu.m24054b(motionEvent, i);
            float c2 = hu.m24055c(motionEvent, i);
            float d = hu.m24057d(motionEvent, i);
            this.f16303f[b] = c2;
            this.f16304g[b] = d;
        }
    }

    public boolean m25695b(int i) {
        return (this.f16308k & (1 << i)) != 0;
    }

    void m25700c(int i) {
        this.f16318u.removeCallbacks(this.f16319w);
        if (this.f16298a != i) {
            this.f16298a = i;
            this.f16315r.mo2652a(i);
            if (this.f16298a == 0) {
                this.f16316s = null;
            }
        }
    }

    boolean m25697b(View view, int i) {
        if (view == this.f16316s && this.f16300c == i) {
            return true;
        }
        if (view == null || !this.f16315r.mo2646a(view, i)) {
            return false;
        }
        this.f16300c = i;
        m25688a(view, i);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m25690a(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = com.ushareit.listenit.hu.m24051a(r14);
        r1 = com.ushareit.listenit.hu.m24053b(r14);
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r13.m25705e();
    L_0x000d:
        r2 = r13.f16309l;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = android.view.VelocityTracker.obtain();
        r13.f16309l = r2;
    L_0x0017:
        r2 = r13.f16309l;
        r2.addMovement(r14);
        switch(r0) {
            case 0: goto L_0x0026;
            case 1: goto L_0x0128;
            case 2: goto L_0x0092;
            case 3: goto L_0x0128;
            case 4: goto L_0x001f;
            case 5: goto L_0x005a;
            case 6: goto L_0x011f;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r13.f16298a;
        r1 = 1;
        if (r0 != r1) goto L_0x012d;
    L_0x0024:
        r0 = 1;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = 0;
        r2 = com.ushareit.listenit.hu.m24054b(r14, r2);
        r13.m25670a(r0, r1, r2);
        r0 = (int) r0;
        r1 = (int) r1;
        r0 = r13.m25703d(r0, r1);
        r1 = r13.f16316s;
        if (r0 != r1) goto L_0x0048;
    L_0x0040:
        r1 = r13.f16298a;
        r3 = 2;
        if (r1 != r3) goto L_0x0048;
    L_0x0045:
        r13.m25697b(r0, r2);
    L_0x0048:
        r0 = r13.f16305h;
        r0 = r0[r2];
        r1 = r13.f16313p;
        r1 = r1 & r0;
        if (r1 == 0) goto L_0x001f;
    L_0x0051:
        r1 = r13.f16315r;
        r3 = r13.f16313p;
        r0 = r0 & r3;
        r1.mo2968a(r0, r2);
        goto L_0x001f;
    L_0x005a:
        r0 = com.ushareit.listenit.hu.m24054b(r14, r1);
        r2 = com.ushareit.listenit.hu.m24055c(r14, r1);
        r1 = com.ushareit.listenit.hu.m24057d(r14, r1);
        r13.m25670a(r2, r1, r0);
        r3 = r13.f16298a;
        if (r3 != 0) goto L_0x007f;
    L_0x006d:
        r1 = r13.f16305h;
        r1 = r1[r0];
        r2 = r13.f16313p;
        r2 = r2 & r1;
        if (r2 == 0) goto L_0x001f;
    L_0x0076:
        r2 = r13.f16315r;
        r3 = r13.f16313p;
        r1 = r1 & r3;
        r2.mo2968a(r1, r0);
        goto L_0x001f;
    L_0x007f:
        r3 = r13.f16298a;
        r4 = 2;
        if (r3 != r4) goto L_0x001f;
    L_0x0084:
        r2 = (int) r2;
        r1 = (int) r1;
        r1 = r13.m25703d(r2, r1);
        r2 = r13.f16316s;
        if (r1 != r2) goto L_0x001f;
    L_0x008e:
        r13.m25697b(r1, r0);
        goto L_0x001f;
    L_0x0092:
        r0 = r13.f16301d;
        if (r0 == 0) goto L_0x001f;
    L_0x0096:
        r0 = r13.f16302e;
        if (r0 == 0) goto L_0x001f;
    L_0x009a:
        r2 = com.ushareit.listenit.hu.m24056c(r14);
        r0 = 0;
        r1 = r0;
    L_0x00a0:
        if (r1 >= r2) goto L_0x0107;
    L_0x00a2:
        r3 = com.ushareit.listenit.hu.m24054b(r14, r1);
        r0 = r13.m25683g(r3);
        if (r0 != 0) goto L_0x00b0;
    L_0x00ac:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00a0;
    L_0x00b0:
        r0 = com.ushareit.listenit.hu.m24055c(r14, r1);
        r4 = com.ushareit.listenit.hu.m24057d(r14, r1);
        r5 = r13.f16301d;
        r5 = r5[r3];
        r5 = r0 - r5;
        r6 = r13.f16302e;
        r6 = r6[r3];
        r6 = r4 - r6;
        r0 = (int) r0;
        r4 = (int) r4;
        r4 = r13.m25703d(r0, r4);
        if (r4 == 0) goto L_0x010c;
    L_0x00cc:
        r0 = r13.m25673a(r4, r5, r6);
        if (r0 == 0) goto L_0x010c;
    L_0x00d2:
        r0 = 1;
    L_0x00d3:
        if (r0 == 0) goto L_0x010e;
    L_0x00d5:
        r7 = r4.getLeft();
        r8 = (int) r5;
        r8 = r8 + r7;
        r9 = r13.f16315r;
        r10 = (int) r5;
        r8 = r9.mo2644a(r4, r8, r10);
        r9 = r4.getTop();
        r10 = (int) r6;
        r10 = r10 + r9;
        r11 = r13.f16315r;
        r12 = (int) r6;
        r10 = r11.mo2655b(r4, r10, r12);
        r11 = r13.f16315r;
        r11 = r11.mo2967a(r4);
        r12 = r13.f16315r;
        r12 = r12.mo2654b(r4);
        if (r11 == 0) goto L_0x0101;
    L_0x00fd:
        if (r11 <= 0) goto L_0x010e;
    L_0x00ff:
        if (r8 != r7) goto L_0x010e;
    L_0x0101:
        if (r12 == 0) goto L_0x0107;
    L_0x0103:
        if (r12 <= 0) goto L_0x010e;
    L_0x0105:
        if (r10 != r9) goto L_0x010e;
    L_0x0107:
        r13.m25678c(r14);
        goto L_0x001f;
    L_0x010c:
        r0 = 0;
        goto L_0x00d3;
    L_0x010e:
        r13.m25676b(r5, r6, r3);
        r5 = r13.f16298a;
        r6 = 1;
        if (r5 == r6) goto L_0x0107;
    L_0x0116:
        if (r0 == 0) goto L_0x00ac;
    L_0x0118:
        r0 = r13.m25697b(r4, r3);
        if (r0 == 0) goto L_0x00ac;
    L_0x011e:
        goto L_0x0107;
    L_0x011f:
        r0 = com.ushareit.listenit.hu.m24054b(r14, r1);
        r13.m25680e(r0);
        goto L_0x001f;
    L_0x0128:
        r13.m25705e();
        goto L_0x001f;
    L_0x012d:
        r0 = 0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.qb.a(android.view.MotionEvent):boolean");
    }

    public void m25694b(MotionEvent motionEvent) {
        int i = 0;
        int a = hu.m24051a(motionEvent);
        int b = hu.m24053b(motionEvent);
        if (a == 0) {
            m25705e();
        }
        if (this.f16309l == null) {
            this.f16309l = VelocityTracker.obtain();
        }
        this.f16309l.addMovement(motionEvent);
        float x;
        float y;
        View d;
        int i2;
        switch (a) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = hu.m24054b(motionEvent, 0);
                d = m25703d((int) x, (int) y);
                m25670a(x, y, i);
                m25697b(d, i);
                i2 = this.f16305h[i];
                if ((this.f16313p & i2) != 0) {
                    this.f16315r.mo2968a(i2 & this.f16313p, i);
                    return;
                }
                return;
            case 1:
                if (this.f16298a == 1) {
                    m25684h();
                }
                m25705e();
                return;
            case 2:
                if (this.f16298a != 1) {
                    i2 = hu.m24056c(motionEvent);
                    while (i < i2) {
                        a = hu.m24054b(motionEvent, i);
                        if (m25683g(a)) {
                            float c = hu.m24055c(motionEvent, i);
                            float d2 = hu.m24057d(motionEvent, i);
                            float f = c - this.f16301d[a];
                            float f2 = d2 - this.f16302e[a];
                            m25676b(f, f2, a);
                            if (this.f16298a != 1) {
                                d = m25703d((int) c, (int) d2);
                                if (m25673a(d, f, f2) && m25697b(d, a)) {
                                }
                            }
                            m25678c(motionEvent);
                            return;
                        }
                        i++;
                    }
                    m25678c(motionEvent);
                    return;
                } else if (m25683g(this.f16300c)) {
                    i = hu.m24052a(motionEvent, this.f16300c);
                    x = hu.m24055c(motionEvent, i);
                    i2 = (int) (x - this.f16303f[this.f16300c]);
                    i = (int) (hu.m24057d(motionEvent, i) - this.f16304g[this.f16300c]);
                    m25677b(this.f16316s.getLeft() + i2, this.f16316s.getTop() + i, i2, i);
                    m25678c(motionEvent);
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.f16298a == 1) {
                    m25669a(0.0f, 0.0f);
                }
                m25705e();
                return;
            case 5:
                i = hu.m24054b(motionEvent, b);
                x = hu.m24055c(motionEvent, b);
                y = hu.m24057d(motionEvent, b);
                m25670a(x, y, i);
                if (this.f16298a == 0) {
                    m25697b(m25703d((int) x, (int) y), i);
                    i2 = this.f16305h[i];
                    if ((this.f16313p & i2) != 0) {
                        this.f16315r.mo2968a(i2 & this.f16313p, i);
                        return;
                    }
                    return;
                } else if (m25701c((int) x, (int) y)) {
                    m25697b(this.f16316s, i);
                    return;
                } else {
                    return;
                }
            case 6:
                a = hu.m24054b(motionEvent, b);
                if (this.f16298a == 1 && a == this.f16300c) {
                    b = hu.m24056c(motionEvent);
                    while (i < b) {
                        int b2 = hu.m24054b(motionEvent, i);
                        if (b2 != this.f16300c) {
                            if (m25703d((int) hu.m24055c(motionEvent, i), (int) hu.m24057d(motionEvent, i)) == this.f16316s && m25697b(this.f16316s, b2)) {
                                i = this.f16300c;
                                if (i == -1) {
                                    m25684h();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        m25684h();
                    }
                }
                m25680e(a);
                return;
            default:
                return;
        }
    }

    private void m25676b(float f, float f2, int i) {
        int i2 = 1;
        if (!m25671a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m25671a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m25671a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m25671a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f16306i;
            iArr[i] = iArr[i] | i2;
            this.f16315r.mo2969b(i2, i);
        }
    }

    private boolean m25671a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f16305h[i] & i2) != i2 || (this.f16313p & i2) == 0 || (this.f16307j[i] & i2) == i2 || (this.f16306i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.f16299b) && abs2 <= ((float) this.f16299b)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f16315r.mo2971b(i2)) {
            int[] iArr = this.f16307j;
            iArr[i] = iArr[i] | i2;
            return false;
        } else if ((this.f16306i[i] & i2) != 0 || abs <= ((float) this.f16299b)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean m25673a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z;
        boolean z2;
        if (this.f16315r.mo2967a(view) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f16315r.mo2654b(view) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            if ((f * f) + (f2 * f2) <= ((float) (this.f16299b * this.f16299b))) {
                return false;
            }
            return true;
        } else if (z) {
            if (Math.abs(f) <= ((float) this.f16299b)) {
                return false;
            }
            return true;
        } else if (!z2) {
            return false;
        } else {
            if (Math.abs(f2) <= ((float) this.f16299b)) {
                return false;
            }
            return true;
        }
    }

    public boolean m25704d(int i) {
        int length = this.f16301d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (m25696b(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean m25696b(int i, int i2) {
        if (!m25695b(i2)) {
            return false;
        }
        boolean z;
        boolean z2 = (i & 1) == 1;
        if ((i & 2) == 2) {
            z = true;
        } else {
            z = false;
        }
        float f = this.f16303f[i2] - this.f16301d[i2];
        float f2 = this.f16304g[i2] - this.f16302e[i2];
        if (z2 && z) {
            if ((f * f) + (f2 * f2) <= ((float) (this.f16299b * this.f16299b))) {
                return false;
            }
            return true;
        } else if (z2) {
            if (Math.abs(f) <= ((float) this.f16299b)) {
                return false;
            }
            return true;
        } else if (!z) {
            return false;
        } else {
            if (Math.abs(f2) <= ((float) this.f16299b)) {
                return false;
            }
            return true;
        }
    }

    private void m25684h() {
        this.f16309l.computeCurrentVelocity(1000, this.f16310m);
        m25669a(m25664a(iv.m24121a(this.f16309l, this.f16300c), this.f16311n, this.f16310m), m25664a(iv.m24122b(this.f16309l, this.f16300c), this.f16311n, this.f16310m));
    }

    private void m25677b(int i, int i2, int i3, int i4) {
        int a;
        int b;
        int left = this.f16316s.getLeft();
        int top = this.f16316s.getTop();
        if (i3 != 0) {
            a = this.f16315r.mo2644a(this.f16316s, i, i3);
            ja.m24158e(this.f16316s, a - left);
        } else {
            a = i;
        }
        if (i4 != 0) {
            b = this.f16315r.mo2655b(this.f16316s, i2, i4);
            ja.m24155d(this.f16316s, b - top);
        } else {
            b = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.f16315r.mo2653a(this.f16316s, a, b, a - left, b - top);
        }
    }

    public boolean m25701c(int i, int i2) {
        return m25698b(this.f16316s, i, i2);
    }

    public boolean m25698b(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public View m25703d(int i, int i2) {
        for (int childCount = this.f16318u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f16318u.getChildAt(this.f16315r.m21709c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private int m25679e(int i, int i2) {
        int i3 = 0;
        if (i < this.f16318u.getLeft() + this.f16312o) {
            i3 = 1;
        }
        if (i2 < this.f16318u.getTop() + this.f16312o) {
            i3 |= 4;
        }
        if (i > this.f16318u.getRight() - this.f16312o) {
            i3 |= 2;
        }
        if (i2 > this.f16318u.getBottom() - this.f16312o) {
            return i3 | 8;
        }
        return i3;
    }

    private boolean m25683g(int i) {
        if (m25695b(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }
}
