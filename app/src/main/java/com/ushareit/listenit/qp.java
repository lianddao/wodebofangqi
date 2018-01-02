package com.ushareit.listenit;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class qp {
    final qr f16336a;
    final qq f16337b = new qq();
    final List<View> f16338c = new ArrayList();

    public qp(qr qrVar) {
        this.f16336a = qrVar;
    }

    private void m25789g(View view) {
        this.f16338c.add(view);
        this.f16336a.mo3052c(view);
    }

    private boolean m25790h(View view) {
        if (!this.f16338c.remove(view)) {
            return false;
        }
        this.f16336a.mo3053d(view);
        return true;
    }

    public void m25797a(View view, boolean z) {
        m25796a(view, -1, z);
    }

    void m25796a(View view, int i, boolean z) {
        int a;
        if (i < 0) {
            a = this.f16336a.mo3043a();
        } else {
            a = m25788e(i);
        }
        this.f16337b.m25811a(a, z);
        if (z) {
            m25789g(view);
        }
        this.f16336a.mo3046a(view, a);
    }

    private int m25788e(int i) {
        if (i < 0) {
            return -1;
        }
        int a = this.f16336a.mo3043a();
        int i2 = i;
        while (i2 < a) {
            int e = i - (i2 - this.f16337b.m25815e(i2));
            if (e == 0) {
                while (this.f16337b.m25813c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += e;
        }
        return -1;
    }

    void m25794a(View view) {
        int a = this.f16336a.mo3044a(view);
        if (a >= 0) {
            if (this.f16337b.m25814d(a)) {
                m25790h(view);
            }
            this.f16336a.mo3045a(a);
        }
    }

    void m25793a(int i) {
        int e = m25788e(i);
        View b = this.f16336a.mo3048b(e);
        if (b != null) {
            if (this.f16337b.m25814d(e)) {
                m25790h(b);
            }
            this.f16336a.mo3045a(e);
        }
    }

    public View m25800b(int i) {
        return this.f16336a.mo3048b(m25788e(i));
    }

    public void m25792a() {
        this.f16337b.m25809a();
        for (int size = this.f16338c.size() - 1; size >= 0; size--) {
            this.f16336a.mo3053d((View) this.f16338c.get(size));
            this.f16338c.remove(size);
        }
        this.f16336a.mo3050b();
    }

    View m25791a(int i, int i2) {
        int size = this.f16338c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) this.f16338c.get(i3);
            sv b = this.f16336a.mo3049b(view);
            if (b.getLayoutPosition() == i && !b.m3235i() && !b.m3238l() && (i2 == -1 || b.getItemViewType() == i2)) {
                return view;
            }
        }
        return null;
    }

    public void m25795a(View view, int i, LayoutParams layoutParams, boolean z) {
        int a;
        if (i < 0) {
            a = this.f16336a.mo3043a();
        } else {
            a = m25788e(i);
        }
        this.f16337b.m25811a(a, z);
        if (z) {
            m25789g(view);
        }
        this.f16336a.mo3047a(view, a, layoutParams);
    }

    public int m25798b() {
        return this.f16336a.mo3043a() - this.f16338c.size();
    }

    public int m25801c() {
        return this.f16336a.mo3043a();
    }

    public View m25802c(int i) {
        return this.f16336a.mo3048b(i);
    }

    void m25804d(int i) {
        int e = m25788e(i);
        this.f16337b.m25814d(e);
        this.f16336a.mo3051c(e);
    }

    int m25799b(View view) {
        int a = this.f16336a.mo3044a(view);
        if (a == -1 || this.f16337b.m25813c(a)) {
            return -1;
        }
        return a - this.f16337b.m25815e(a);
    }

    boolean m25803c(View view) {
        return this.f16338c.contains(view);
    }

    public void m25805d(View view) {
        int a = this.f16336a.mo3044a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.f16337b.m25810a(a);
        m25789g(view);
    }

    void m25806e(View view) {
        int a = this.f16336a.mo3044a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f16337b.m25813c(a)) {
            this.f16337b.m25812b(a);
            m25790h(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f16337b.toString() + ", hidden list:" + this.f16338c.size();
    }

    public boolean m25807f(View view) {
        int a = this.f16336a.mo3044a(view);
        if (a == -1) {
            return m25790h(view) ? true : true;
        } else {
            if (!this.f16337b.m25813c(a)) {
                return false;
            }
            this.f16337b.m25814d(a);
            if (m25790h(view)) {
                this.f16336a.mo3045a(a);
            } else {
                this.f16336a.mo3045a(a);
            }
            return true;
        }
    }
}
