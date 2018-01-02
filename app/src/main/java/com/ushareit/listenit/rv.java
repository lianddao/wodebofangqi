package com.ushareit.listenit;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.umeng.analytics.pro.C0277j;

public class rv implements qr {
    final /* synthetic */ RecyclerView f16435a;

    public rv(RecyclerView recyclerView) {
        this.f16435a = recyclerView;
    }

    public int mo3043a() {
        return this.f16435a.getChildCount();
    }

    public void mo3046a(View view, int i) {
        this.f16435a.addView(view, i);
        this.f16435a.m488i(view);
    }

    public int mo3044a(View view) {
        return this.f16435a.indexOfChild(view);
    }

    public void mo3045a(int i) {
        View childAt = this.f16435a.getChildAt(i);
        if (childAt != null) {
            this.f16435a.m485h(childAt);
        }
        this.f16435a.removeViewAt(i);
    }

    public View mo3048b(int i) {
        return this.f16435a.getChildAt(i);
    }

    public void mo3050b() {
        int a = mo3043a();
        for (int i = 0; i < a; i++) {
            this.f16435a.m485h(mo3048b(i));
        }
        this.f16435a.removeAllViews();
    }

    public sv mo3049b(View view) {
        return RecyclerView.m459b(view);
    }

    public void mo3047a(View view, int i, LayoutParams layoutParams) {
        sv b = RecyclerView.m459b(view);
        if (b != null) {
            if (b.m3239m() || b.m3229c()) {
                b.m3234h();
            } else {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + b);
            }
        }
        this.f16435a.attachViewToParent(view, i, layoutParams);
    }

    public void mo3051c(int i) {
        View b = mo3048b(i);
        if (b != null) {
            sv b2 = RecyclerView.m459b(b);
            if (b2 != null) {
                if (!b2.m3239m() || b2.m3229c()) {
                    b2.m3228b((int) C0277j.f3694e);
                } else {
                    throw new IllegalArgumentException("called detach on an already detached child " + b2);
                }
            }
        }
        this.f16435a.detachViewFromParent(i);
    }

    public void mo3052c(View view) {
        sv b = RecyclerView.m459b(view);
        if (b != null) {
            b.m3216t();
        }
    }

    public void mo3053d(View view) {
        sv b = RecyclerView.m459b(view);
        if (b != null) {
            b.m3217u();
        }
    }
}
