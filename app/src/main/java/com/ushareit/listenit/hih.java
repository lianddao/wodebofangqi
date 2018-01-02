package com.ushareit.listenit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class hih extends BaseAdapter {
    private List<hip> f15483a = null;
    private LayoutInflater f15484b;

    public hih(Context context, List<hip> list) {
        this.f15484b = LayoutInflater.from(context);
        this.f15483a = list;
    }

    public int getCount() {
        return this.f15483a.size();
    }

    public Object getItem(int i) {
        return this.f15483a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        hii com_ushareit_listenit_hii;
        if (view == null) {
            com_ushareit_listenit_hii = new hii(this);
            view = this.f15484b.inflate(C0349R.layout.socialshare_dialog_fragment_grid_item, viewGroup, false);
            com_ushareit_listenit_hii.f15485a = (ImageView) view.findViewById(C0349R.id.icon);
            com_ushareit_listenit_hii.f15486b = (TextView) view.findViewById(C0349R.id.name);
            view.setTag(com_ushareit_listenit_hii);
        } else {
            com_ushareit_listenit_hii = (hii) view.getTag();
        }
        hip com_ushareit_listenit_hip = (hip) this.f15483a.get(i);
        com_ushareit_listenit_hii.f15485a.setImageResource(com_ushareit_listenit_hip.f15499d);
        com_ushareit_listenit_hii.f15486b.setText(com_ushareit_listenit_hip.f15498c);
        view.setOnClickListener(com_ushareit_listenit_hip.f15500e);
        return view;
    }
}
