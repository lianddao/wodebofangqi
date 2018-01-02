package com.ushareit.listenit;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public final class amv implements atd<Bundle> {
    private final View f4880a;
    private final List<amz> f4881b;
    private final Context f4882c;
    private amx f4883d;

    public amv(Context context, View view, List<amw> list) {
        this.f4882c = context;
        this.f4880a = view;
        this.f4881b = new ArrayList(list.size());
        for (amw com_ushareit_listenit_amz : list) {
            this.f4881b.add(new amz(com_ushareit_listenit_amz));
        }
        this.f4883d = new amx();
    }

    public amv(Context context, View view, List<amw> list, Bundle bundle) {
        this.f4882c = context;
        this.f4880a = view;
        this.f4881b = new ArrayList(list.size());
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("TESTS");
        for (int i = 0; i < list.size(); i++) {
            this.f4881b.add(new amz((amw) list.get(i), (Bundle) parcelableArrayList.get(i)));
        }
        this.f4883d = (amx) bundle.getSerializable("STATISTICS");
    }

    public void m6335a() {
        this.f4883d.m6339a();
    }

    public void m6336a(double d, double d2) {
        if (d2 >= 0.0d) {
            this.f4883d.m6342b(d, d2);
        }
        double a = ana.m6356a(this.f4880a, this.f4882c);
        this.f4883d.m6340a(d, a);
        for (amz a2 : this.f4881b) {
            a2.m6355a(d, a);
        }
    }

    public amx m6337b() {
        return this.f4883d;
    }

    public Bundle getSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("STATISTICS", this.f4883d);
        ArrayList arrayList = new ArrayList(this.f4881b.size());
        for (amz saveInstanceState : this.f4881b) {
            arrayList.add(saveInstanceState.getSaveInstanceState());
        }
        bundle.putParcelableArrayList("TESTS", arrayList);
        return bundle;
    }
}
