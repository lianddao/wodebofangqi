package com.ushareit.listenit;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;
import com.ushareit.listenit.equalizer.EqualizerActivity;

public class ful implements OnHierarchyChangeListener {
    final /* synthetic */ EqualizerActivity f13521a;

    public ful(EqualizerActivity equalizerActivity) {
        this.f13521a = equalizerActivity;
    }

    public void onChildViewAdded(View view, View view2) {
        view2.setEnabled(gvj.m22935d());
    }

    public void onChildViewRemoved(View view, View view2) {
    }
}
