package com.ushareit.listenit;

import android.view.View;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.widget.dragsortlistview.DragSortListView;

public class hes extends hez {
    final /* synthetic */ DragSortListView f15309a;
    private int f15310d;
    private int f15311e;
    private float f15312f;
    private float f15313g;

    public hes(DragSortListView dragSortListView, float f, int i) {
        this.f15309a = dragSortListView;
        super(dragSortListView, f, i);
    }

    public void mo2759a() {
        this.f15310d = this.f15309a.f17455i;
        this.f15311e = this.f15309a.f17459m;
        this.f15309a.f17468v = 2;
        this.f15312f = (float) (this.f15309a.f17448b.y - m23645e());
        this.f15313g = (float) (this.f15309a.f17448b.x - this.f15309a.getPaddingLeft());
    }

    private int m23645e() {
        int i = (this.f15309a.f17469w + this.f15309a.getDividerHeight()) / 2;
        View childAt = this.f15309a.getChildAt(this.f15310d - this.f15309a.getFirstVisiblePosition());
        if (childAt == null) {
            m23644d();
            return -1;
        } else if (this.f15310d == this.f15311e) {
            return childAt.getTop();
        } else {
            if (this.f15310d < this.f15311e) {
                return childAt.getTop() - i;
            }
            return (childAt.getBottom() + i) - this.f15309a.f17470x;
        }
    }

    public void mo2760a(float f, float f2) {
        int e = m23645e();
        float paddingLeft = (float) (this.f15309a.f17448b.x - this.f15309a.getPaddingLeft());
        float f3 = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - f2;
        if (f3 < Math.abs(((float) (this.f15309a.f17448b.y - e)) / this.f15312f) || f3 < Math.abs(paddingLeft / this.f15313g)) {
            this.f15309a.f17448b.y = e + ((int) (this.f15312f * f3));
            this.f15309a.f17448b.x = this.f15309a.getPaddingLeft() + ((int) (this.f15313g * f3));
            this.f15309a.m27042b(true);
        }
    }

    public void mo2761b() {
        this.f15309a.m27058f();
    }
}
