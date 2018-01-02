package com.ushareit.listenit;

import android.support.v4.widget.SlidingPaneLayout;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class pq extends pp {
    private Method f16285a;
    private Field f16286b;

    public pq() {
        try {
            this.f16285a = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
        } catch (Throwable e) {
            Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e);
        }
        try {
            this.f16286b = View.class.getDeclaredField("mRecreateDisplayList");
            this.f16286b.setAccessible(true);
        } catch (Throwable e2) {
            Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
        }
    }

    public void mo2999a(SlidingPaneLayout slidingPaneLayout, View view) {
        if (this.f16285a == null || this.f16286b == null) {
            view.invalidate();
            return;
        }
        try {
            this.f16286b.setBoolean(view, true);
            this.f16285a.invoke(view, (Object[]) null);
        } catch (Throwable e) {
            Log.e("SlidingPaneLayout", "Error refreshing display list state", e);
        }
        super.mo2999a(slidingPaneLayout, view);
    }
}
