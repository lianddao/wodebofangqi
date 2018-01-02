package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.widget.LoadMoreListView;

public class hbx implements OnClickListener {
    final /* synthetic */ LoadMoreListView f15167a;

    public hbx(LoadMoreListView loadMoreListView) {
        this.f15167a = loadMoreListView;
    }

    public void onClick(View view) {
        this.f15167a.f17250a.setVisibility(0);
        this.f15167a.f17251b.setVisibility(8);
        if (this.f15167a.f17253d != null) {
            this.f15167a.f17253d.mo2382a();
        }
    }
}
