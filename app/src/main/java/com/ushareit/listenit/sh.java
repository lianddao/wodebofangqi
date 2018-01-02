package com.ushareit.listenit;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;

public abstract class sh {
    private boolean f292a = false;
    private boolean f293b = false;
    qp f294q;
    public RecyclerView f295r;
    sq f296s;

    public abstract LayoutParams mo25a();

    public void m271b(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.f295r = null;
            this.f294q = null;
            return;
        }
        this.f295r = recyclerView;
        this.f294q = recyclerView.f350c;
    }

    public void m316m() {
        if (this.f295r != null) {
            this.f295r.requestLayout();
        }
    }

    public void mo31a(String str) {
        if (this.f295r != null) {
            this.f295r.m521a(str);
        }
    }

    public boolean mo35b() {
        return false;
    }

    public void m282c(RecyclerView recyclerView) {
        this.f293b = true;
        m293d(recyclerView);
    }

    public void m273b(RecyclerView recyclerView, sm smVar) {
        this.f293b = false;
        mo28a(recyclerView, smVar);
    }

    public boolean m318n() {
        return this.f293b;
    }

    public void m255a(Runnable runnable) {
        if (this.f295r != null) {
            ja.m24141a(this.f295r, runnable);
        }
    }

    public boolean m278b(Runnable runnable) {
        if (this.f295r != null) {
            return this.f295r.removeCallbacks(runnable);
        }
        return false;
    }

    public void m293d(RecyclerView recyclerView) {
    }

    @Deprecated
    public void m298e(RecyclerView recyclerView) {
    }

    public void mo28a(RecyclerView recyclerView, sm smVar) {
        m298e(recyclerView);
    }

    public boolean m319o() {
        return this.f295r != null && this.f295r.f358m;
    }

    public void mo38c(sm smVar, ss ssVar) {
        Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
    }

    public boolean mo57a(LayoutParams layoutParams) {
        return layoutParams != null;
    }

    public LayoutParams mo48a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public LayoutParams mo47a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public int mo24a(int i, sm smVar, ss ssVar) {
        return 0;
    }

    public int mo32b(int i, sm smVar, ss ssVar) {
        return 0;
    }

    public boolean mo41d() {
        return false;
    }

    public boolean mo43e() {
        return false;
    }

    public void mo40d(int i) {
    }

    public void mo29a(RecyclerView recyclerView, ss ssVar, int i) {
        Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
    }

    public void m254a(sq sqVar) {
        if (!(this.f296s == null || sqVar == this.f296s || !this.f296s.m7382h())) {
            this.f296s.m7380f();
        }
        this.f296s = sqVar;
        this.f296s.m7373a(this.f295r, this);
    }

    public boolean m320p() {
        return this.f296s != null && this.f296s.m7382h();
    }

    public int m321q() {
        return ja.m24162h(this.f295r);
    }

    public void m238a(View view) {
        m239a(view, -1);
    }

    public void m239a(View view, int i) {
        m216a(view, i, true);
    }

    public void m274b(View view) {
        m275b(view, -1);
    }

    public void m275b(View view, int i) {
        m216a(view, i, false);
    }

    private void m216a(View view, int i, boolean z) {
        sv b = RecyclerView.m459b(view);
        if (z || b.m3238l()) {
            this.f295r.f351d.m26346c(b);
        } else {
            this.f295r.f351d.m26348d(b);
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (b.m3232f() || b.m3230d()) {
            if (b.m3230d()) {
                b.m3231e();
            } else {
                b.m3233g();
            }
            this.f294q.m25795a(view, i, view.getLayoutParams(), false);
        } else if (view.getParent() == this.f295r) {
            int b2 = this.f294q.m25799b(view);
            if (i == -1) {
                i = this.f294q.m25798b();
            }
            if (b2 == -1) {
                throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f295r.indexOfChild(view));
            } else if (b2 != i) {
                this.f295r.f362q.m270b(b2, i);
            }
        } else {
            this.f294q.m25796a(view, i, false);
            layoutParams.f288c = true;
            if (this.f296s != null && this.f296s.m7382h()) {
                this.f296s.m7376b(view);
            }
        }
        if (layoutParams.f289d) {
            b.itemView.invalidate();
            layoutParams.f289d = false;
        }
    }

    public void m284c(View view) {
        this.f294q.m25794a(view);
    }

    public void m297e(int i) {
        if (m306g(i) != null) {
            this.f294q.m25793a(i);
        }
    }

    public int m322r() {
        return -1;
    }

    public int m288d(View view) {
        return ((LayoutParams) view.getLayoutParams()).m207e();
    }

    public View mo34b(int i) {
        int s = m323s();
        for (int i2 = 0; i2 < s; i2++) {
            View g = m306g(i2);
            sv b = RecyclerView.m459b(g);
            if (b != null && b.getLayoutPosition() == i && !b.m3229c() && (this.f295r.f353f.m26201a() || !b.m3238l())) {
                return g;
            }
        }
        return null;
    }

    public void m303f(int i) {
        m215a(i, m306g(i));
    }

    private void m215a(int i, View view) {
        this.f294q.m25804d(i);
    }

    public void m242a(View view, int i, LayoutParams layoutParams) {
        sv b = RecyclerView.m459b(view);
        if (b.m3238l()) {
            this.f295r.f351d.m26346c(b);
        } else {
            this.f295r.f351d.m26348d(b);
        }
        this.f294q.m25795a(view, i, layoutParams, b.m3238l());
    }

    public void m285c(View view, int i) {
        m242a(view, i, (LayoutParams) view.getLayoutParams());
    }

    public void m270b(int i, int i2) {
        View g = m306g(i);
        if (g == null) {
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i);
        }
        m303f(i);
        m285c(g, i2);
    }

    public void m245a(View view, sm smVar) {
        m284c(view);
        smVar.m26149a(view);
    }

    public void m230a(int i, sm smVar) {
        View g = m306g(i);
        m297e(i);
        smVar.m26149a(g);
    }

    public int m323s() {
        return this.f294q != null ? this.f294q.m25798b() : 0;
    }

    public View m306g(int i) {
        return this.f294q != null ? this.f294q.m25800b(i) : null;
    }

    public int m324t() {
        return this.f295r != null ? this.f295r.getWidth() : 0;
    }

    public int m325u() {
        return this.f295r != null ? this.f295r.getHeight() : 0;
    }

    public int m326v() {
        return this.f295r != null ? this.f295r.getPaddingLeft() : 0;
    }

    public int m327w() {
        return this.f295r != null ? this.f295r.getPaddingTop() : 0;
    }

    public int m328x() {
        return this.f295r != null ? this.f295r.getPaddingRight() : 0;
    }

    public int m329y() {
        return this.f295r != null ? this.f295r.getPaddingBottom() : 0;
    }

    public View m330z() {
        if (this.f295r == null) {
            return null;
        }
        View focusedChild = this.f295r.getFocusedChild();
        if (focusedChild == null || this.f294q.m25803c(focusedChild)) {
            return null;
        }
        return focusedChild;
    }

    public void mo60h(int i) {
        if (this.f295r != null) {
            this.f295r.m537e(i);
        }
    }

    public void mo61i(int i) {
        if (this.f295r != null) {
            this.f295r.m533d(i);
        }
    }

    public void m249a(sm smVar) {
        for (int s = m323s() - 1; s >= 0; s--) {
            m218a(smVar, s, m306g(s));
        }
    }

    private void m218a(sm smVar, int i, View view) {
        sv b = RecyclerView.m459b(view);
        if (!b.m3229c()) {
            if (!b.m3235i() || b.m3238l() || this.f295r.f361p.hasStableIds()) {
                m303f(i);
                smVar.m26163c(view);
                return;
            }
            m297e(i);
            smVar.m26159b(b);
        }
    }

    public void m276b(sm smVar) {
        int d = smVar.m26165d();
        for (int i = d - 1; i >= 0; i--) {
            View e = smVar.m26168e(i);
            sv b = RecyclerView.m459b(e);
            if (!b.m3229c()) {
                b.setIsRecyclable(false);
                if (b.m3239m()) {
                    this.f295r.removeDetachedView(e, false);
                }
                if (this.f295r.f352e != null) {
                    this.f295r.f352e.mo3028c(b);
                }
                b.setIsRecyclable(true);
                smVar.m26158b(e);
            }
        }
        smVar.m26169e();
        if (d > 0) {
            this.f295r.invalidate();
        }
    }

    public void m240a(View view, int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect f = this.f295r.m540f(view);
        view.measure(m214a(m324t(), ((f.left + f.right) + i) + (((m326v() + m328x()) + layoutParams.leftMargin) + layoutParams.rightMargin), layoutParams.width, mo41d()), m214a(m325u(), ((f.bottom + f.top) + i2) + (((m327w() + m329y()) + layoutParams.topMargin) + layoutParams.bottomMargin), layoutParams.height, mo43e()));
    }

    public static int m214a(int i, int i2, int i3, boolean z) {
        int i4 = 1073741824;
        int max = Math.max(0, i - i2);
        if (z) {
            if (i3 < 0) {
                i4 = 0;
                i3 = 0;
            }
        } else if (i3 < 0) {
            if (i3 == -1) {
                i3 = max;
            } else if (i3 == -2) {
                i4 = Integer.MIN_VALUE;
                i3 = max;
            } else {
                i4 = 0;
                i3 = 0;
            }
        }
        return MeasureSpec.makeMeasureSpec(i3, i4);
    }

    public int m295e(View view) {
        Rect rect = ((LayoutParams) view.getLayoutParams()).f287b;
        return rect.right + (view.getMeasuredWidth() + rect.left);
    }

    public int m301f(View view) {
        Rect rect = ((LayoutParams) view.getLayoutParams()).f287b;
        return rect.bottom + (view.getMeasuredHeight() + rect.top);
    }

    public void m241a(View view, int i, int i2, int i3, int i4) {
        Rect rect = ((LayoutParams) view.getLayoutParams()).f287b;
        view.layout(rect.left + i, rect.top + i2, i3 - rect.right, i4 - rect.bottom);
    }

    public int m304g(View view) {
        return view.getLeft() - m315m(view);
    }

    public int m307h(View view) {
        return view.getTop() - m313k(view);
    }

    public int m309i(View view) {
        return view.getRight() + m317n(view);
    }

    public int m311j(View view) {
        return view.getBottom() + m314l(view);
    }

    public void m243a(View view, Rect rect) {
        if (this.f295r == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(this.f295r.m540f(view));
        }
    }

    public int m313k(View view) {
        return ((LayoutParams) view.getLayoutParams()).f287b.top;
    }

    public int m314l(View view) {
        return ((LayoutParams) view.getLayoutParams()).f287b.bottom;
    }

    public int m315m(View view) {
        return ((LayoutParams) view.getLayoutParams()).f287b.left;
    }

    public int m317n(View view) {
        return ((LayoutParams) view.getLayoutParams()).f287b.right;
    }

    public View mo26a(View view, int i, sm smVar, ss ssVar) {
        return null;
    }

    public View m291d(View view, int i) {
        return null;
    }

    public boolean m259a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
        int v = m326v();
        int w = m327w();
        int t = m324t() - m328x();
        int u = m325u() - m329y();
        int left = view.getLeft() + rect.left;
        int top = view.getTop() + rect.top;
        int width = left + rect.width();
        int height = top + rect.height();
        int min = Math.min(0, left - v);
        int min2 = Math.min(0, top - w);
        int max = Math.max(0, width - t);
        u = Math.max(0, height - u);
        if (m321q() == 1) {
            if (max == 0) {
                max = Math.max(min, width - t);
            }
            min = max;
        } else {
            min = min != 0 ? min : Math.min(left - v, max);
        }
        max = min2 != 0 ? min2 : Math.min(top - w, u);
        if (min == 0 && max == 0) {
            return false;
        }
        if (z) {
            recyclerView.scrollBy(min, max);
        } else {
            recyclerView.m517a(min, max);
        }
        return true;
    }

    @Deprecated
    public boolean m260a(RecyclerView recyclerView, View view, View view2) {
        return m320p() || recyclerView.m549j();
    }

    public boolean m261a(RecyclerView recyclerView, ss ssVar, View view, View view2) {
        return m260a(recyclerView, view, view2);
    }

    public void m248a(rx rxVar, rx rxVar2) {
    }

    public boolean m262a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
        return false;
    }

    public void mo50a(RecyclerView recyclerView) {
    }

    public void mo51a(RecyclerView recyclerView, int i, int i2) {
    }

    public void mo59b(RecyclerView recyclerView, int i, int i2) {
    }

    public void m283c(RecyclerView recyclerView, int i, int i2) {
    }

    public void mo53a(RecyclerView recyclerView, int i, int i2, Object obj) {
        m283c(recyclerView, i, i2);
    }

    public void mo52a(RecyclerView recyclerView, int i, int i2, int i3) {
    }

    public int mo39d(ss ssVar) {
        return 0;
    }

    public int mo33b(ss ssVar) {
        return 0;
    }

    public int mo44f(ss ssVar) {
        return 0;
    }

    public int mo42e(ss ssVar) {
        return 0;
    }

    public int mo36c(ss ssVar) {
        return 0;
    }

    public int mo45g(ss ssVar) {
        return 0;
    }

    public void mo810a(sm smVar, ss ssVar, int i, int i2) {
        this.f295r.m486i(i, i2);
    }

    public void m281c(int i, int i2) {
        this.f295r.setMeasuredDimension(i, i2);
    }

    public Parcelable mo37c() {
        return null;
    }

    public void mo27a(Parcelable parcelable) {
    }

    public void m222A() {
        if (this.f296s != null) {
            this.f296s.m7380f();
        }
    }

    private void m221b(sq sqVar) {
        if (this.f296s == sqVar) {
            this.f296s = null;
        }
    }

    public void mo62j(int i) {
    }

    public void m286c(sm smVar) {
        for (int s = m323s() - 1; s >= 0; s--) {
            if (!RecyclerView.m459b(m306g(s)).m3229c()) {
                m230a(s, smVar);
            }
        }
    }

    void m247a(mh mhVar) {
        m253a(this.f295r.f348a, this.f295r.f353f, mhVar);
    }

    public void m253a(sm smVar, ss ssVar, mh mhVar) {
        if (ja.m24149b(this.f295r, -1) || ja.m24145a(this.f295r, -1)) {
            mhVar.m24884a(8192);
            mhVar.m24914i(true);
        }
        if (ja.m24149b(this.f295r, 1) || ja.m24145a(this.f295r, 1)) {
            mhVar.m24884a(4096);
            mhVar.m24914i(true);
        }
        mhVar.m24895b(mt.m25075a(mo46a(smVar, ssVar), mo58b(smVar, ssVar), m300e(smVar, ssVar), m289d(smVar, ssVar)));
    }

    public void mo30a(AccessibilityEvent accessibilityEvent) {
        m252a(this.f295r.f348a, this.f295r.f353f, accessibilityEvent);
    }

    public void m252a(sm smVar, ss ssVar, AccessibilityEvent accessibilityEvent) {
        boolean z = true;
        nn a = mb.m24868a(accessibilityEvent);
        if (this.f295r != null && a != null) {
            if (!(ja.m24149b(this.f295r, 1) || ja.m24149b(this.f295r, -1) || ja.m24145a(this.f295r, -1) || ja.m24145a(this.f295r, 1))) {
                z = false;
            }
            a.m25229a(z);
            if (this.f295r.f361p != null) {
                a.m25228a(this.f295r.f361p.getItemCount());
            }
        }
    }

    public void m244a(View view, mh mhVar) {
        sv b = RecyclerView.m459b(view);
        if (b != null && !b.m3238l() && !this.f294q.m25803c(b.itemView)) {
            mo54a(this.f295r.f348a, this.f295r.f353f, view, mhVar);
        }
    }

    public void mo54a(sm smVar, ss ssVar, View view, mh mhVar) {
        int d;
        int d2 = mo43e() ? m288d(view) : 0;
        if (mo41d()) {
            d = m288d(view);
        } else {
            d = 0;
        }
        mhVar.m24901c(mu.m25076a(d2, 1, d, 1, false, false));
    }

    public void m223B() {
        this.f292a = true;
    }

    public int m289d(sm smVar, ss ssVar) {
        return 0;
    }

    public int mo46a(sm smVar, ss ssVar) {
        if (this.f295r == null || this.f295r.f361p == null || !mo43e()) {
            return 1;
        }
        return this.f295r.f361p.getItemCount();
    }

    public int mo58b(sm smVar, ss ssVar) {
        if (this.f295r == null || this.f295r.f361p == null || !mo41d()) {
            return 1;
        }
        return this.f295r.f361p.getItemCount();
    }

    public boolean m300e(sm smVar, ss ssVar) {
        return false;
    }

    boolean m257a(int i, Bundle bundle) {
        return m264a(this.f295r.f348a, this.f295r.f353f, i, bundle);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m264a(com.ushareit.listenit.sm r7, com.ushareit.listenit.ss r8, int r9, android.os.Bundle r10) {
        /*
        r6 = this;
        r4 = -1;
        r2 = 1;
        r1 = 0;
        r0 = r6.f295r;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        switch(r9) {
            case 4096: goto L_0x004a;
            case 8192: goto L_0x0018;
            default: goto L_0x000b;
        };
    L_0x000b:
        r0 = r1;
        r3 = r1;
    L_0x000d:
        if (r3 != 0) goto L_0x0011;
    L_0x000f:
        if (r0 == 0) goto L_0x0007;
    L_0x0011:
        r1 = r6.f295r;
        r1.scrollBy(r0, r3);
        r1 = r2;
        goto L_0x0007;
    L_0x0018:
        r0 = r6.f295r;
        r0 = com.ushareit.listenit.ja.m24149b(r0, r4);
        if (r0 == 0) goto L_0x007f;
    L_0x0020:
        r0 = r6.m325u();
        r3 = r6.m327w();
        r0 = r0 - r3;
        r3 = r6.m329y();
        r0 = r0 - r3;
        r0 = -r0;
    L_0x002f:
        r3 = r6.f295r;
        r3 = com.ushareit.listenit.ja.m24145a(r3, r4);
        if (r3 == 0) goto L_0x007a;
    L_0x0037:
        r3 = r6.m324t();
        r4 = r6.m326v();
        r3 = r3 - r4;
        r4 = r6.m328x();
        r3 = r3 - r4;
        r3 = -r3;
        r5 = r3;
        r3 = r0;
        r0 = r5;
        goto L_0x000d;
    L_0x004a:
        r0 = r6.f295r;
        r0 = com.ushareit.listenit.ja.m24149b(r0, r2);
        if (r0 == 0) goto L_0x007d;
    L_0x0052:
        r0 = r6.m325u();
        r3 = r6.m327w();
        r0 = r0 - r3;
        r3 = r6.m329y();
        r0 = r0 - r3;
    L_0x0060:
        r3 = r6.f295r;
        r3 = com.ushareit.listenit.ja.m24145a(r3, r2);
        if (r3 == 0) goto L_0x007a;
    L_0x0068:
        r3 = r6.m324t();
        r4 = r6.m326v();
        r3 = r3 - r4;
        r4 = r6.m328x();
        r3 = r3 - r4;
        r5 = r3;
        r3 = r0;
        r0 = r5;
        goto L_0x000d;
    L_0x007a:
        r3 = r0;
        r0 = r1;
        goto L_0x000d;
    L_0x007d:
        r0 = r1;
        goto L_0x0060;
    L_0x007f:
        r0 = r1;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.sh.a(com.ushareit.listenit.sm, com.ushareit.listenit.ss, int, android.os.Bundle):boolean");
    }

    boolean m263a(View view, int i, Bundle bundle) {
        return m265a(this.f295r.f348a, this.f295r.f353f, view, i, bundle);
    }

    public boolean m265a(sm smVar, ss ssVar, View view, int i, Bundle bundle) {
        return false;
    }
}
