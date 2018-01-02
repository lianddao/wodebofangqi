package com.ushareit.listenit;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ushareit.listenit.theme.entry.CustomThemeImageView;
import java.util.ArrayList;
import java.util.List;

public class fee extends BaseAdapter {
    private List<gxl> f12522a = new ArrayList();

    public /* synthetic */ Object getItem(int i) {
        return m18945a(i);
    }

    public void m18946a(List<gxl> list) {
        if (list != null) {
            this.f12522a.clear();
            this.f12522a.addAll(list);
            notifyDataSetChanged();
        }
    }

    public int getCount() {
        return this.f12522a.size();
    }

    public gxl m18945a(int i) {
        return (gxl) this.f12522a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        feg com_ushareit_listenit_feg;
        gxl com_ushareit_listenit_gxl = (gxl) this.f12522a.get(i);
        if (view == null) {
            view = View.inflate(viewGroup.getContext(), C0349R.layout.popup_view_share_item, null);
            feg com_ushareit_listenit_feg2 = new feg(this);
            com_ushareit_listenit_feg2.f12528a = (CustomThemeImageView) view.findViewById(C0349R.id.icon);
            com_ushareit_listenit_feg2.f12529b = (TextView) view.findViewById(C0349R.id.desc);
            view.setTag(com_ushareit_listenit_feg2);
            com_ushareit_listenit_feg = com_ushareit_listenit_feg2;
        } else {
            com_ushareit_listenit_feg = (feg) view.getTag();
        }
        com_ushareit_listenit_feg.m18947a(com_ushareit_listenit_gxl.f14860a);
        com_ushareit_listenit_feg.f12528a.setImageColorDrawable(C0349R.color.common_icon_default_color, C0349R.color.common_icon_default_color_night);
        hhx.m23867a(new fef(this, viewGroup, com_ushareit_listenit_gxl, com_ushareit_listenit_feg));
        return view;
    }
}
