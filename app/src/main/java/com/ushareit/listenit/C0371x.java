package com.ushareit.listenit;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;

class C0371x implements OnPreDrawListener {
    final /* synthetic */ View f17508a;
    final /* synthetic */ Object f17509b;
    final /* synthetic */ ArrayList f17510c;
    final /* synthetic */ aa f17511d;
    final /* synthetic */ Object f17512e;
    final /* synthetic */ Object f17513f;
    final /* synthetic */ boolean f17514g;
    final /* synthetic */ ah f17515h;
    final /* synthetic */ ah f17516i;
    final /* synthetic */ C0369v f17517j;

    C0371x(C0369v c0369v, View view, Object obj, ArrayList arrayList, aa aaVar, Object obj2, Object obj3, boolean z, ah ahVar, ah ahVar2) {
        this.f17517j = c0369v;
        this.f17508a = view;
        this.f17509b = obj;
        this.f17510c = arrayList;
        this.f17511d = aaVar;
        this.f17512e = obj2;
        this.f17513f = obj3;
        this.f17514g = z;
        this.f17515h = ahVar;
        this.f17516i = ahVar2;
    }

    public boolean onPreDraw() {
        this.f17508a.getViewTreeObserver().removeOnPreDrawListener(this);
        bi.m8536a(this.f17509b, this.f17510c);
        this.f17510c.remove(this.f17511d.f3984d);
        bi.m8535a(this.f17512e, this.f17513f, this.f17509b, this.f17510c, false);
        this.f17510c.clear();
        fq a = this.f17517j.m26621a(this.f17511d, this.f17514g, this.f17515h);
        bi.m8532a(this.f17509b, this.f17511d.f3984d, (Map) a, this.f17510c);
        this.f17517j.m26635a(a, this.f17511d);
        this.f17517j.m26632a(this.f17511d, this.f17515h, this.f17516i, this.f17514g, a);
        bi.m8535a(this.f17512e, this.f17513f, this.f17509b, this.f17510c, true);
        return true;
    }
}
