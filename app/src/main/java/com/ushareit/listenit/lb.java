package com.ushareit.listenit;

import android.support.v4.view.ViewPager.LayoutParams;
import android.view.View;
import java.util.Comparator;

public class lb implements Comparator<View> {
    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m24405a((View) obj, (View) obj2);
    }

    public int m24405a(View view, View view2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
        if (layoutParams.f70a != layoutParams2.f70a) {
            return layoutParams.f70a ? 1 : -1;
        } else {
            return layoutParams.f74e - layoutParams2.f74e;
        }
    }
}
