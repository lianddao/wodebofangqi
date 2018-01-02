package com.ushareit.listenit;

import android.database.DataSetObserver;
import android.support.v4.view.ViewPager;

public class kz extends DataSetObserver {
    final /* synthetic */ ViewPager f15622a;

    private kz(ViewPager viewPager) {
        this.f15622a = viewPager;
    }

    public void onChanged() {
        this.f15622a.m51b();
    }

    public void onInvalidated() {
        this.f15622a.m51b();
    }
}
