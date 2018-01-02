package com.ushareit.listenit;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.mopub.volley.DefaultRetryPolicy;

public class px extends Animation {
    final /* synthetic */ SwipeRefreshLayout f16294a;

    public px(SwipeRefreshLayout swipeRefreshLayout) {
        this.f16294a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        int i;
        if (this.f16294a.f253M) {
            i = (int) this.f16294a.f249I;
        } else {
            i = (int) (this.f16294a.f249I - ((float) Math.abs(this.f16294a.f258b)));
        }
        this.f16294a.setTargetOffsetTopAndBottom((((int) (((float) (i - this.f16294a.f257a)) * f)) + this.f16294a.f257a) - this.f16294a.f280z.getTop(), false);
        this.f16294a.f243C.m25372a(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - f);
    }
}
