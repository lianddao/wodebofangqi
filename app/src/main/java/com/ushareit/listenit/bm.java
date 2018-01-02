package com.ushareit.listenit;

import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

final class bm implements OnPreDrawListener {
    final /* synthetic */ View f7003a;
    final /* synthetic */ Transition f7004b;
    final /* synthetic */ ArrayList f7005c;
    final /* synthetic */ Transition f7006d;
    final /* synthetic */ ArrayList f7007e;
    final /* synthetic */ Transition f7008f;
    final /* synthetic */ ArrayList f7009g;
    final /* synthetic */ Map f7010h;
    final /* synthetic */ ArrayList f7011i;
    final /* synthetic */ Transition f7012j;
    final /* synthetic */ View f7013k;

    bm(View view, Transition transition, ArrayList arrayList, Transition transition2, ArrayList arrayList2, Transition transition3, ArrayList arrayList3, Map map, ArrayList arrayList4, Transition transition4, View view2) {
        this.f7003a = view;
        this.f7004b = transition;
        this.f7005c = arrayList;
        this.f7006d = transition2;
        this.f7007e = arrayList2;
        this.f7008f = transition3;
        this.f7009g = arrayList3;
        this.f7010h = map;
        this.f7011i = arrayList4;
        this.f7012j = transition4;
        this.f7013k = view2;
    }

    public boolean onPreDraw() {
        this.f7003a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.f7004b != null) {
            bi.m8536a(this.f7004b, this.f7005c);
            bi.m8545b(this.f7004b, this.f7006d, this.f7007e, false);
            bi.m8545b(this.f7004b, this.f7008f, this.f7009g, false);
        }
        if (this.f7006d != null) {
            bi.m8536a(this.f7006d, this.f7007e);
            bi.m8545b(this.f7006d, this.f7004b, this.f7005c, false);
            bi.m8545b(this.f7006d, this.f7008f, this.f7009g, false);
        }
        if (this.f7008f != null) {
            bi.m8536a(this.f7008f, this.f7009g);
        }
        for (Entry entry : this.f7010h.entrySet()) {
            ((View) entry.getValue()).setTransitionName((String) entry.getKey());
        }
        int size = this.f7011i.size();
        for (int i = 0; i < size; i++) {
            this.f7012j.excludeTarget((View) this.f7011i.get(i), false);
        }
        this.f7012j.excludeTarget(this.f7013k, false);
        return true;
    }
}
