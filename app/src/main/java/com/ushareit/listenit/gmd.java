package com.ushareit.listenit;

import com.ushareit.listenit.nearby.view.MyHomePageActivity;
import java.util.List;

public class gmd implements gmb<List<fnl>> {
    final /* synthetic */ MyHomePageActivity f14400a;

    public gmd(MyHomePageActivity myHomePageActivity) {
        this.f14400a = myHomePageActivity;
    }

    public void m22437a(List<fnl> list) {
        this.f14400a.f15990t.setVisibility(8);
        if (list != null && list.size() > 0) {
            this.f14400a.f15988r.m18937a((List) list);
            this.f14400a.f15991y = System.currentTimeMillis();
        }
    }
}
