package com.ushareit.listenit;

import android.support.v4.view.PagerTabStrip;
import android.view.View;
import android.view.View.OnClickListener;

public class il implements OnClickListener {
    final /* synthetic */ PagerTabStrip f15585a;

    public il(PagerTabStrip pagerTabStrip) {
        this.f15585a = pagerTabStrip;
    }

    public void onClick(View view) {
        this.f15585a.a.setCurrentItem(this.f15585a.a.getCurrentItem() - 1);
    }
}
