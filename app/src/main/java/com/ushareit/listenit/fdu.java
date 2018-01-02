package com.ushareit.listenit;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

public class fdu extends BaseAdapter {
    private List<gla> f12494a = new ArrayList();
    private boolean f12495b;
    private fdw f12496c;
    private int f12497d = 0;
    private gal f12498e;

    public /* synthetic */ Object getItem(int i) {
        return m18923b(i);
    }

    public fdu(gal com_ushareit_listenit_gal) {
        this.f12498e = com_ushareit_listenit_gal;
    }

    public List<? extends gla> m18924b() {
        return this.f12494a;
    }

    public void m18919a(int i) {
        this.f12497d = i;
    }

    public void m18921a(List<? extends gla> list) {
        if (list != null) {
            this.f12494a.clear();
            this.f12494a.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void m18925b(List<? extends gla> list) {
        this.f12494a.removeAll(list);
        notifyDataSetChanged();
    }

    public int m18926c() {
        int i = 0;
        for (gla f : this.f12494a) {
            int i2;
            if (f.m20780f()) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }

    public List<? extends gla> m18927d() {
        List<? extends gla> arrayList = new ArrayList();
        for (gla com_ushareit_listenit_gla : this.f12494a) {
            if (com_ushareit_listenit_gla.m20780f()) {
                arrayList.add(com_ushareit_listenit_gla);
            }
        }
        return arrayList;
    }

    public void m18928e() {
        for (gla a : this.f12494a) {
            a.m20775a(false);
        }
        notifyDataSetChanged();
    }

    public void m18929f() {
        for (gla a : this.f12494a) {
            a.m20775a(true);
        }
        notifyDataSetChanged();
    }

    public void m18922a(boolean z) {
        this.f12495b = z;
        notifyDataSetChanged();
    }

    public void m18920a(fdw com_ushareit_listenit_fdw) {
        this.f12496c = com_ushareit_listenit_fdw;
    }

    public int getCount() {
        return this.f12494a.size();
    }

    public gla m18923b(int i) {
        return (gla) this.f12494a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        hbg c;
        View a;
        if (view == null) {
            c = this.f12498e.mo2567c();
            c.m20864a(this.f12496c);
            a = c.mo2576a(viewGroup);
            a.setTag(c);
        } else {
            c = (hbg) view.getTag();
            a = view;
        }
        if (i < this.f12494a.size()) {
            gla com_ushareit_listenit_gla = (gla) this.f12494a.get(i);
            c.mo2577a(com_ushareit_listenit_gla, this.f12495b, i + 1, this.f12497d);
            a.setOnClickListener(new fdv(this, com_ushareit_listenit_gla, c, i, a));
        }
        return a;
    }
}
