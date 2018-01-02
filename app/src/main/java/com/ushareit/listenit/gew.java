package com.ushareit.listenit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

public class gew extends ArrayAdapter<ggi> {
    public gew(Context context, ArrayList<ggi> arrayList) {
        super(context, 0, arrayList);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        gex com_ushareit_listenit_gex;
        ggi com_ushareit_listenit_ggi = (ggi) getItem(i);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(C0349R.layout.sync_log_list_item, viewGroup, false);
            com_ushareit_listenit_gex = new gex(this, view);
            view.setTag(com_ushareit_listenit_gex);
        } else {
            com_ushareit_listenit_gex = (gex) view.getTag();
        }
        if (com_ushareit_listenit_ggi != null) {
            com_ushareit_listenit_gex.f14011a.setText(com_ushareit_listenit_ggi.f14071a.mo2562c());
            com_ushareit_listenit_gex.f14012b.setText(com_ushareit_listenit_ggi.f14072b);
        }
        return view;
    }
}
