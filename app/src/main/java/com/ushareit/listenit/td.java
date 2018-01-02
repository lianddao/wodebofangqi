package com.ushareit.listenit;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.StaggeredGridLayoutManager;

public class td extends rl {
    final /* synthetic */ StaggeredGridLayoutManager f16577a;

    public td(StaggeredGridLayoutManager staggeredGridLayoutManager, Context context) {
        this.f16577a = staggeredGridLayoutManager;
        super(context);
    }

    public PointF mo817a(int i) {
        int a = this.f16577a.m615q(i);
        if (a == 0) {
            return null;
        }
        if (this.f16577a.f400i == 0) {
            return new PointF((float) a, 0.0f);
        }
        return new PointF(0.0f, (float) a);
    }
}
