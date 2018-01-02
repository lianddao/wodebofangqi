package com.ushareit.listenit;

import android.os.SystemClock;
import android.view.View;
import com.ushareit.listenit.widget.dragsortlistview.DragSortListView;

public class hep implements Runnable {
    final /* synthetic */ DragSortListView f15284a;
    private boolean f15285b;
    private long f15286c;
    private long f15287d;
    private int f15288e;
    private float f15289f;
    private long f15290g;
    private int f15291h;
    private float f15292i;
    private boolean f15293j = false;

    public boolean m23632a() {
        return this.f15293j;
    }

    public int m23633b() {
        return this.f15293j ? this.f15291h : -1;
    }

    public hep(DragSortListView dragSortListView) {
        this.f15284a = dragSortListView;
    }

    public void m23630a(int i) {
        if (!this.f15293j) {
            this.f15285b = false;
            this.f15293j = true;
            this.f15290g = SystemClock.uptimeMillis();
            this.f15286c = this.f15290g;
            this.f15291h = i;
            this.f15284a.post(this);
        }
    }

    public void m23631a(boolean z) {
        if (z) {
            this.f15284a.removeCallbacks(this);
            this.f15293j = false;
            return;
        }
        this.f15285b = true;
    }

    public void run() {
        if (this.f15285b) {
            this.f15293j = false;
            return;
        }
        View childAt;
        int firstVisiblePosition = this.f15284a.getFirstVisiblePosition();
        int lastVisiblePosition = this.f15284a.getLastVisiblePosition();
        int count = this.f15284a.getCount();
        int paddingTop = this.f15284a.getPaddingTop();
        int height = (this.f15284a.getHeight() - paddingTop) - this.f15284a.getPaddingBottom();
        int min = Math.min(this.f15284a.f17437N, this.f15284a.f17450d + this.f15284a.f17471y);
        int max = Math.max(this.f15284a.f17437N, this.f15284a.f17450d - this.f15284a.f17471y);
        if (this.f15291h == 0) {
            childAt = this.f15284a.getChildAt(0);
            if (childAt == null) {
                this.f15293j = false;
                return;
            } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                this.f15293j = false;
                return;
            } else {
                this.f15292i = this.f15284a.f17435L.mo2758a((this.f15284a.f17431H - ((float) max)) / this.f15284a.f17432I, this.f15286c);
            }
        } else {
            View childAt2 = this.f15284a.getChildAt(lastVisiblePosition - firstVisiblePosition);
            if (childAt2 == null) {
                this.f15293j = false;
                return;
            } else if (lastVisiblePosition != count - 1 || childAt2.getBottom() > height + paddingTop) {
                this.f15292i = -this.f15284a.f17435L.mo2758a((((float) min) - this.f15284a.f17430G) / this.f15284a.f17433J, this.f15286c);
            } else {
                this.f15293j = false;
                return;
            }
        }
        this.f15287d = SystemClock.uptimeMillis();
        this.f15289f = (float) (this.f15287d - this.f15286c);
        this.f15288e = Math.round(this.f15292i * this.f15289f);
        if (this.f15288e >= 0) {
            this.f15288e = Math.min(height, this.f15288e);
            lastVisiblePosition = firstVisiblePosition;
        } else {
            this.f15288e = Math.max(-height, this.f15288e);
        }
        childAt = this.f15284a.getChildAt(lastVisiblePosition - firstVisiblePosition);
        firstVisiblePosition = childAt.getTop() + this.f15288e;
        if (lastVisiblePosition == 0 && firstVisiblePosition > paddingTop) {
            firstVisiblePosition = paddingTop;
        }
        this.f15284a.af = true;
        this.f15284a.setSelectionFromTop(lastVisiblePosition, firstVisiblePosition - paddingTop);
        this.f15284a.layoutChildren();
        this.f15284a.invalidate();
        this.f15284a.af = false;
        this.f15284a.m27053d(lastVisiblePosition, childAt, false);
        this.f15286c = this.f15287d;
        this.f15284a.post(this);
    }
}
