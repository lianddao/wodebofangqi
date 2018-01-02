package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.widget.SearchWidget;

public class hdx implements OnClickListener {
    final /* synthetic */ SearchWidget f15242a;

    public hdx(SearchWidget searchWidget) {
        this.f15242a = searchWidget;
    }

    public void onClick(View view) {
        if ("".equals(this.f15242a.f17364a.getText().toString())) {
            this.f15242a.m26999d();
            this.f15242a.m27003b();
            if (this.f15242a.f17369f != null) {
                this.f15242a.f17369f.mo2502a(false);
                return;
            }
            return;
        }
        this.f15242a.f17364a.setText("");
    }
}
