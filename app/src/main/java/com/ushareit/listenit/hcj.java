package com.ushareit.listenit;

import android.view.View;
import android.view.ViewGroup;
import com.ushareit.listenit.widget.NormalPlayerView;

public class hcj implements Runnable {
    final /* synthetic */ NormalPlayerView f15180a;

    public hcj(NormalPlayerView normalPlayerView) {
        this.f15180a = normalPlayerView;
    }

    public void run() {
        View childAt = ((ViewGroup) this.f15180a.f17293C.getCurrentView()).getChildAt(0);
        View childAt2 = ((ViewGroup) this.f15180a.f17293C.getNextView()).getChildAt(0);
        if (childAt != null && childAt2 != null) {
            int dimension = (int) this.f15180a.getResources().getDimension(C0349R.dimen.common_dimens_36dp);
            int dimension2 = (int) this.f15180a.getResources().getDimension(C0349R.dimen.common_dimens_20dp);
            dimension = (this.f15180a.f17293C.getWidth() - dimension) - dimension;
            dimension2 = (this.f15180a.f17293C.getHeight() - dimension2) - dimension2;
            if (dimension < dimension2) {
                dimension2 = dimension;
            }
            gyn.m23192a(childAt, dimension2);
            gyn.m23192a(childAt2, dimension2);
            gyn.m23192a(((ViewGroup) this.f15180a.f17293C.getCurrentView()).getChildAt(1), dimension2);
            gyn.m23192a(((ViewGroup) this.f15180a.f17293C.getNextView()).getChildAt(1), dimension2);
        }
    }
}
