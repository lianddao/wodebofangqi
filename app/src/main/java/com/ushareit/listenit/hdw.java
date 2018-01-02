package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.widget.SearchWidget;

public class hdw implements OnClickListener {
    final /* synthetic */ SearchWidget f15241a;

    public hdw(SearchWidget searchWidget) {
        this.f15241a = searchWidget;
    }

    public void onClick(View view) {
        this.f15241a.m26997c();
        if (this.f15241a.f17369f != null) {
            this.f15241a.f17369f.mo2502a(true);
        }
    }
}
