package com.ushareit.listenit;

import android.view.View;
import android.view.ViewGroup;
import com.ushareit.listenit.lockscreen.view.ChargeLockScreenViewGroup;

public class gdg extends ik {
    final /* synthetic */ ChargeLockScreenViewGroup f13947a;

    public gdg(ChargeLockScreenViewGroup chargeLockScreenViewGroup) {
        this.f13947a = chargeLockScreenViewGroup;
    }

    public boolean mo841a(View view, Object obj) {
        return view == obj;
    }

    public int mo2352b() {
        return this.f13947a.f15697c.size();
    }

    public void mo840a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) this.f13947a.f15697c.get(i));
    }

    public Object mo837a(ViewGroup viewGroup, int i) {
        viewGroup.addView((View) this.f13947a.f15697c.get(i));
        return this.f13947a.f15697c.get(i);
    }
}
