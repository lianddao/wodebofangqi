package com.ushareit.listenit;

import android.support.v4.view.PagerTabStrip;
import android.view.View;
import android.view.View.OnClickListener;

public class im implements OnClickListener {
    final /* synthetic */ PagerTabStrip f15586a;

    public im(PagerTabStrip pagerTabStrip) {
        this.f15586a = pagerTabStrip;
    }

    public void onClick(View view) {
        this.f15586a.a.setCurrentItem(this.f15586a.a.getCurrentItem() + 1);
    }
}
