package com.ushareit.listenit;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ushareit.listenit.theme.entry.CustomThemeCheckView;
import java.util.ArrayList;
import java.util.List;

public class gll extends BaseAdapter {
    private List<gkz> f14364a = new ArrayList();

    public /* synthetic */ Object getItem(int i) {
        return m22365a(i);
    }

    public List<gkz> m22366a() {
        return this.f14364a;
    }

    public void m22367a(List<gkz> list) {
        if (list != null) {
            this.f14364a.clear();
            this.f14364a.addAll(list);
            notifyDataSetChanged();
        }
    }

    public int getCount() {
        return this.f14364a.size();
    }

    public gkz m22365a(int i) {
        return (gkz) this.f14364a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        glm com_ushareit_listenit_glm;
        gkz com_ushareit_listenit_gkz = (gkz) this.f14364a.get(i);
        if (view == null) {
            view = View.inflate(viewGroup.getContext(), C0349R.layout.popup_view_audio_folder_item, null);
            glm com_ushareit_listenit_glm2 = new glm(this);
            com_ushareit_listenit_glm2.f14365a = (TextView) view.findViewById(C0349R.id.title);
            com_ushareit_listenit_glm2.f14366b = (TextView) view.findViewById(C0349R.id.sub_title);
            com_ushareit_listenit_glm2.f14367c = (TextView) view.findViewById(C0349R.id.song_count);
            com_ushareit_listenit_glm2.f14368d = (CustomThemeCheckView) view.findViewById(C0349R.id.select);
            view.setTag(com_ushareit_listenit_glm2);
            com_ushareit_listenit_glm = com_ushareit_listenit_glm2;
        } else {
            com_ushareit_listenit_glm = (glm) view.getTag();
        }
        com_ushareit_listenit_glm.f14365a.setText(com_ushareit_listenit_gkz.f14278b);
        com_ushareit_listenit_glm.f14366b.setText(com_ushareit_listenit_gkz.f14279c);
        com_ushareit_listenit_glm.f14367c.setText(String.valueOf(com_ushareit_listenit_gkz.f14280d));
        com_ushareit_listenit_glm.f14368d.setChecked(com_ushareit_listenit_gkz.m20780f());
        return view;
    }
}
