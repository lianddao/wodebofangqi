package com.ushareit.listenit;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.DisplayMetrics;
import android.view.View;

class ayv extends rl {
    final /* synthetic */ ayu f5705a;

    public ayv(ayu com_ushareit_listenit_ayu, Context context) {
        this.f5705a = com_ushareit_listenit_ayu;
        super(context);
    }

    protected float mo816a(DisplayMetrics displayMetrics) {
        return this.f5705a.f5689f / ((float) displayMetrics.densityDpi);
    }

    public PointF mo817a(int i) {
        return this.f5705a.m382c(i);
    }

    public int mo818b(View view, int i) {
        sh e = m7379e();
        if (!e.mo41d()) {
            return 0;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return m7387a(e.m304g(view) - layoutParams.leftMargin, e.m309i(view) + layoutParams.rightMargin, e.m326v(), e.m324t() - e.m328x(), i) + this.f5705a.f5688e;
    }

    protected int mo819c() {
        return -1;
    }
}
