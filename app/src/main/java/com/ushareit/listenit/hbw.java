package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.ushareit.listenit.widget.LineEditView;

public class hbw implements OnFocusChangeListener {
    final /* synthetic */ LineEditView f15166a;

    public hbw(LineEditView lineEditView) {
        this.f15166a = lineEditView;
    }

    public void onFocusChange(View view, boolean z) {
        this.f15166a.f16661f = z;
        if (z) {
            this.f15166a.setLineHeightAndBackground(4, this.f15166a.f16659d);
        } else {
            this.f15166a.setLineHeightAndBackground(2, this.f15166a.f16657b);
        }
        if (this.f15166a.f16663h != null) {
            this.f15166a.f16663h.onFocusChange(view, z);
        }
    }
}
