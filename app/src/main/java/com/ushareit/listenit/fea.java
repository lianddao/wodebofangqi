package com.ushareit.listenit;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

public class fea extends BaseAdapter {
    private Activity f12516a;
    private List<fni> f12517b = new ArrayList();

    public fea(Activity activity) {
        this.f12516a = activity;
    }

    public void m18942a(List<fni> list) {
        this.f12517b.addAll(list);
        notifyDataSetChanged();
    }

    private int m18940a(int i) {
        return (i + 1) / 2;
    }

    private int m18941b(int i) {
        return i * 2;
    }

    public int getCount() {
        return m18940a(this.f12517b.size());
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        hak com_ushareit_listenit_hak;
        if (view == null) {
            view = LayoutInflater.from(this.f12516a).inflate(C0349R.layout.nearby_user_list_item, viewGroup, false);
            hak com_ushareit_listenit_hak2 = new hak(view, this.f12516a);
            view.setTag(com_ushareit_listenit_hak2);
            com_ushareit_listenit_hak = com_ushareit_listenit_hak2;
        } else {
            com_ushareit_listenit_hak = (hak) view.getTag();
        }
        int b = m18941b(i);
        com_ushareit_listenit_hak.m23458a((fni) this.f12517b.get(b));
        int i2 = b + 1;
        if (i2 < this.f12517b.size()) {
            com_ushareit_listenit_hak.m23457a();
            com_ushareit_listenit_hak.m23460b((fni) this.f12517b.get(i2));
        } else {
            com_ushareit_listenit_hak.m23459b();
        }
        return view;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
