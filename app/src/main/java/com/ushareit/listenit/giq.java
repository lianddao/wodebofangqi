package com.ushareit.listenit;

import com.ushareit.listenit.main.MainActivity;

public class giq implements Runnable {
    final /* synthetic */ MainActivity f14174a;

    public giq(MainActivity mainActivity) {
        this.f14174a = mainActivity;
    }

    public void run() {
        exw.m18449b("UI.MainActivity", "removeFragmentPager.... size=" + this.f14174a.f15909p.size());
        gyn.m23212b(this.f14174a.f15908o);
        this.f14174a.f15908o.setCurrentItem(this.f14174a.f15909p.size() - 2);
    }
}
