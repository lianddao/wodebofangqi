package com.ushareit.listenit;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

public abstract class sg {
    public void m26108a(Canvas canvas, RecyclerView recyclerView, ss ssVar) {
        m26107a(canvas, recyclerView);
    }

    @Deprecated
    public void m26107a(Canvas canvas, RecyclerView recyclerView) {
    }

    public void m26112b(Canvas canvas, RecyclerView recyclerView, ss ssVar) {
        m26111b(canvas, recyclerView);
    }

    @Deprecated
    public void m26111b(Canvas canvas, RecyclerView recyclerView) {
    }

    @Deprecated
    public void m26109a(Rect rect, int i, RecyclerView recyclerView) {
        rect.set(0, 0, 0, 0);
    }

    public void m26110a(Rect rect, View view, RecyclerView recyclerView, ss ssVar) {
        m26109a(rect, ((LayoutParams) view.getLayoutParams()).m207e(), recyclerView);
    }
}
