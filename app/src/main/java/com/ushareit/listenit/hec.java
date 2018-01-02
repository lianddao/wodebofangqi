package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.widget.ViewPagerTabBar;

public class hec implements OnClickListener {
    final /* synthetic */ int f15246a;
    final /* synthetic */ ViewPagerTabBar f15247b;

    public hec(ViewPagerTabBar viewPagerTabBar, int i) {
        this.f15247b = viewPagerTabBar;
        this.f15246a = i;
    }

    public void onClick(View view) {
        if (this.f15247b.f17411f != null) {
            this.f15247b.f17411f.mo2629a(this.f15246a);
        }
    }
}
