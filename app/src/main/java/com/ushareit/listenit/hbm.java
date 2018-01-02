package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.widget.DefaultEqualizerView;

public class hbm implements OnClickListener {
    final /* synthetic */ DefaultEqualizerView f15136a;

    public hbm(DefaultEqualizerView defaultEqualizerView) {
        this.f15136a = defaultEqualizerView;
    }

    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        boolean z = intValue == this.f15136a.f17204b.size();
        if (!z) {
            this.f15136a.m26816b(intValue);
            this.f15136a.m26815b();
        }
        if (this.f15136a.f17205c != null) {
            this.f15136a.f17205c.mo2597a(intValue, z);
        }
    }
}
