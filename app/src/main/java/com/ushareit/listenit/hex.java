package com.ushareit.listenit;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.widget.dragsortlistview.DragSortListView;

public class hex extends hez {
    final /* synthetic */ DragSortListView f15321a;
    private float f15322d;
    private float f15323e;
    private float f15324f;
    private int f15325g = -1;
    private int f15326h = -1;
    private int f15327i;
    private int f15328j;
    private int f15329k;

    public hex(DragSortListView dragSortListView, float f, int i) {
        this.f15321a = dragSortListView;
        super(dragSortListView, f, i);
    }

    public void mo2759a() {
        int i = -1;
        this.f15325g = -1;
        this.f15326h = -1;
        this.f15327i = this.f15321a.f17456j;
        this.f15328j = this.f15321a.f17457k;
        this.f15329k = this.f15321a.f17459m;
        this.f15321a.f17468v = 1;
        this.f15322d = (float) this.f15321a.f17448b.x;
        if (this.f15321a.al) {
            float width = ((float) this.f15321a.getWidth()) * 2.0f;
            if (this.f15321a.am == 0.0f) {
                DragSortListView dragSortListView = this.f15321a;
                if (this.f15322d >= 0.0f) {
                    i = 1;
                }
                dragSortListView.am = ((float) i) * width;
                return;
            }
            float f = width * 2.0f;
            if (this.f15321a.am < 0.0f && this.f15321a.am > (-f)) {
                this.f15321a.am = -f;
                return;
            } else if (this.f15321a.am > 0.0f && this.f15321a.am < f) {
                this.f15321a.am = f;
                return;
            } else {
                return;
            }
        }
        this.f15321a.m27073n();
    }

    public void mo2760a(float f, float f2) {
        float f3 = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - f2;
        int firstVisiblePosition = this.f15321a.getFirstVisiblePosition();
        View childAt = this.f15321a.getChildAt(this.f15327i - firstVisiblePosition);
        if (this.f15321a.al) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.b)) / 1000.0f;
            if (uptimeMillis != 0.0f) {
                float o = this.f15321a.am * uptimeMillis;
                int width = this.f15321a.getWidth();
                this.f15321a.am = ((((float) (this.f15321a.am > 0.0f ? 1 : -1)) * uptimeMillis) * ((float) width)) + this.f15321a.am;
                this.f15322d += o;
                this.f15321a.f17448b.x = (int) this.f15322d;
                if (this.f15322d < ((float) width) && this.f15322d > ((float) (-width))) {
                    this.b = SystemClock.uptimeMillis();
                    this.f15321a.m27042b(true);
                    return;
                }
            }
            return;
        }
        if (childAt != null) {
            if (this.f15325g == -1) {
                this.f15325g = this.f15321a.m27036b(this.f15327i, childAt, false);
                this.f15323e = (float) (childAt.getHeight() - this.f15325g);
            }
            int max = Math.max((int) (this.f15323e * f3), 1);
            LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.height = max + this.f15325g;
            childAt.setLayoutParams(layoutParams);
        }
        if (this.f15328j != this.f15327i) {
            View childAt2 = this.f15321a.getChildAt(this.f15328j - firstVisiblePosition);
            if (childAt2 != null) {
                if (this.f15326h == -1) {
                    this.f15326h = this.f15321a.m27036b(this.f15328j, childAt2, false);
                    this.f15324f = (float) (childAt2.getHeight() - this.f15326h);
                }
                int max2 = Math.max((int) (this.f15324f * f3), 1);
                LayoutParams layoutParams2 = childAt2.getLayoutParams();
                layoutParams2.height = max2 + this.f15326h;
                childAt2.setLayoutParams(layoutParams2);
            }
        }
    }

    public void mo2761b() {
        this.f15321a.m27060g();
    }
}
