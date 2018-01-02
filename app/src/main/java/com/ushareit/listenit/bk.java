package com.ushareit.listenit;

import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

final class bk implements OnPreDrawListener {
    final /* synthetic */ View f6705a;
    final /* synthetic */ Transition f6706b;
    final /* synthetic */ View f6707c;
    final /* synthetic */ bo f6708d;
    final /* synthetic */ Map f6709e;
    final /* synthetic */ Map f6710f;
    final /* synthetic */ ArrayList f6711g;
    final /* synthetic */ Transition f6712h;

    bk(View view, Transition transition, View view2, bo boVar, Map map, Map map2, ArrayList arrayList, Transition transition2) {
        this.f6705a = view;
        this.f6706b = transition;
        this.f6707c = view2;
        this.f6708d = boVar;
        this.f6709e = map;
        this.f6710f = map2;
        this.f6711g = arrayList;
        this.f6712h = transition2;
    }

    public boolean onPreDraw() {
        this.f6705a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.f6706b != null) {
            this.f6706b.removeTarget(this.f6707c);
        }
        if (this.f6708d != null) {
            View a = this.f6708d.mo3115a();
            if (a != null) {
                if (!this.f6709e.isEmpty()) {
                    bi.m8539a(this.f6710f, a);
                    this.f6710f.keySet().retainAll(this.f6709e.values());
                    for (Entry entry : this.f6709e.entrySet()) {
                        View view = (View) this.f6710f.get((String) entry.getValue());
                        if (view != null) {
                            view.setTransitionName((String) entry.getKey());
                        }
                    }
                }
                if (this.f6706b != null) {
                    bi.m8547b(this.f6711g, a);
                    this.f6711g.removeAll(this.f6710f.values());
                    this.f6711g.add(this.f6707c);
                    bi.m8546b(this.f6706b, this.f6711g);
                }
            }
        }
        bi.m8545b(this.f6712h, this.f6706b, this.f6711g, true);
        return true;
    }
}
