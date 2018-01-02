package com.ushareit.listenit;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

class gsx extends BaseAdapter {
    private List<gla> f14682a = new ArrayList();
    private int f14683b = 0;
    private fdw f14684c;
    private gal f14685d;

    public /* synthetic */ Object getItem(int i) {
        return m22723a(i);
    }

    gsx(Context context, gal com_ushareit_listenit_gal) {
        this.f14685d = com_ushareit_listenit_gal;
    }

    void m22725a(fdw com_ushareit_listenit_fdw) {
        this.f14684c = com_ushareit_listenit_fdw;
    }

    void m22726a(List<? extends gla> list) {
        if (list != null) {
            this.f14682a.clear();
            this.f14682a.addAll(list);
        }
    }

    void m22729b(List<? extends gla> list) {
        if (list != null) {
            this.f14682a.addAll(list);
        }
    }

    void m22724a() {
        this.f14682a.clear();
    }

    public void m22727b() {
        this.f14682a.clear();
    }

    List<? extends gla> m22730c() {
        return this.f14682a;
    }

    public int getCount() {
        return this.f14682a.size();
    }

    public gla m22723a(int i) {
        return (gla) this.f14682a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        hbg com_ushareit_listenit_hbg;
        if (view != null) {
            com_ushareit_listenit_hbg = (hbg) view.getTag();
        } else {
            hbg c = this.f14685d.mo2567c();
            c.m20864a(this.f14684c);
            view = c.mo2576a(viewGroup);
            view.setTag(c);
            com_ushareit_listenit_hbg = c;
        }
        com_ushareit_listenit_hbg.mo2577a((gla) this.f14682a.get(i), false, i + 1, this.f14683b);
        view.setOnClickListener(new gsy(this, view, i));
        return view;
    }

    public void m22728b(int i) {
        this.f14683b = i;
    }
}
