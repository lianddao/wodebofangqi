package com.ushareit.listenit;

import com.ushareit.listenit.main.MainActivity;

public class gip implements Runnable {
    final /* synthetic */ fji f14172a;
    final /* synthetic */ MainActivity f14173b;

    public gip(MainActivity mainActivity, fji com_ushareit_listenit_fji) {
        this.f14173b = mainActivity;
        this.f14172a = com_ushareit_listenit_fji;
    }

    public void run() {
        if (this.f14172a.m19527a()) {
            gyn.m23214b((ak) this.f14173b.f15908o.getContext());
        }
        gyn.m23190a(this.f14173b.f15908o);
        this.f14173b.f15908o.setCurrentItem(this.f14173b.f15909p.size() - 1);
    }
}
