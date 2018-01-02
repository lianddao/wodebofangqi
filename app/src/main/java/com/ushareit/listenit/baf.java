package com.ushareit.listenit;

import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.facebook.login.widget.ToolTipPopup;

public class baf implements OnScrollChangedListener {
    final /* synthetic */ ToolTipPopup f5773a;

    public baf(ToolTipPopup toolTipPopup) {
        this.f5773a = toolTipPopup;
    }

    public void onScrollChanged() {
        if (this.f5773a.f1346b.get() != null && this.f5773a.f1349e != null && this.f5773a.f1349e.isShowing()) {
            if (this.f5773a.f1349e.isAboveAnchor()) {
                this.f5773a.f1348d.m1933b();
            } else {
                this.f5773a.f1348d.m1932a();
            }
        }
    }
}
