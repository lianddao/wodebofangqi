package com.ushareit.listenit;

import android.app.Activity;
import android.view.View;

public class hak {
    private hal f15052a;
    private hal f15053b = new hal(this, this.f15054c);
    private View f15054c;
    private Activity f15055d;

    public hak(View view, Activity activity) {
        this.f15052a = new hal(this, view.findViewById(C0349R.id.sub_item_1));
        this.f15054c = view.findViewById(C0349R.id.sub_item_2);
        this.f15055d = activity;
    }

    public void m23458a(fni com_ushareit_listenit_fni) {
        this.f15052a.m23463a(com_ushareit_listenit_fni);
    }

    public void m23460b(fni com_ushareit_listenit_fni) {
        this.f15053b.m23463a(com_ushareit_listenit_fni);
    }

    public void m23457a() {
        this.f15054c.setVisibility(0);
    }

    public void m23459b() {
        this.f15054c.setVisibility(4);
    }
}
