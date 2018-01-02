package com.ushareit.listenit;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class feb extends BaseAdapter {
    private List<String> f12518a = new ArrayList();

    public /* synthetic */ Object getItem(int i) {
        return m18944a(i);
    }

    public feb(List<String> list) {
        this.f12518a.addAll(list);
    }

    public int getCount() {
        return this.f12518a.size();
    }

    public String m18944a(int i) {
        return (String) this.f12518a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return m18943a(i, view, viewGroup, C0349R.layout.equalizer_reverb_spinner_item);
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return m18943a(i, view, viewGroup, C0349R.layout.equalizer_reverb_spinner_dropdown_item);
    }

    private View m18943a(int i, View view, ViewGroup viewGroup, int i2) {
        fed com_ushareit_listenit_fed;
        if (view == null) {
            com_ushareit_listenit_fed = new fed();
            view = View.inflate(viewGroup.getContext(), i2, null);
            com_ushareit_listenit_fed.f12519a = (TextView) view.findViewById(C0349R.id.name);
            com_ushareit_listenit_fed.f12520b = view.findViewById(C0349R.id.divider);
            view.setTag(com_ushareit_listenit_fed);
        } else {
            com_ushareit_listenit_fed = (fed) view.getTag();
        }
        com_ushareit_listenit_fed.f12519a.setText((CharSequence) this.f12518a.get(i));
        if (com_ushareit_listenit_fed.f12520b != null) {
            com_ushareit_listenit_fed.f12520b.setVisibility(i < this.f12518a.size() + -1 ? 0 : 8);
        }
        return view;
    }
}
