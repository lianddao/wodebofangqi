package com.ushareit.listenit;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ushareit.listenit.widget.CustomCheckBox;
import com.ushareit.listenit.widget.dragsortlistview.DragSortListView;
import java.util.ArrayList;
import java.util.List;

public class fdl extends BaseAdapter {
    private int f12473a;
    private List<gla> f12474b = new ArrayList();
    private fdn f12475c;
    private DragSortListView f12476d;
    private int f12477e = 0;
    private int f12478f;

    public /* synthetic */ Object getItem(int i) {
        return m18899b(i);
    }

    public fdl(int i, DragSortListView dragSortListView) {
        this.f12473a = i;
        this.f12476d = dragSortListView;
        this.f12478f = (int) dragSortListView.getContext().getResources().getDimension(C0349R.dimen.common_dimens_47dp);
    }

    public void m18895a(int i) {
        this.f12477e = i;
    }

    public void m18898a(List<? extends gla> list) {
        if (list != null && list.size() != 0) {
            this.f12474b.clear();
            this.f12474b.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void m18896a(int i, int i2) {
        int i3;
        if (i2 > i) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        while (i != i2) {
            int i4 = i + i3;
            gla com_ushareit_listenit_gla = (gla) this.f12474b.get(i);
            gla com_ushareit_listenit_gla2 = (gla) this.f12474b.get(i4);
            this.f12474b.set(i, com_ushareit_listenit_gla2);
            this.f12474b.set(i4, com_ushareit_listenit_gla);
            this.f12476d.setItemChecked(i, com_ushareit_listenit_gla2.m20780f());
            this.f12476d.setItemChecked(i4, com_ushareit_listenit_gla.m20780f());
            i = i4;
        }
        notifyDataSetChanged();
    }

    public void m18901b(List<? extends gla> list) {
        for (gla indexOf : list) {
            this.f12476d.setItemChecked(this.f12474b.indexOf(indexOf), false);
        }
        this.f12474b.removeAll(list);
        notifyDataSetChanged();
    }

    public int m18894a() {
        int i = 0;
        for (gla f : this.f12474b) {
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

    public List<? extends gla> m18900b() {
        List<? extends gla> arrayList = new ArrayList();
        for (gla com_ushareit_listenit_gla : this.f12474b) {
            if (com_ushareit_listenit_gla.m20780f()) {
                arrayList.add(com_ushareit_listenit_gla);
            }
        }
        return arrayList;
    }

    public void m18902c() {
        for (gla com_ushareit_listenit_gla : this.f12474b) {
            com_ushareit_listenit_gla.m20775a(false);
            this.f12476d.setItemChecked(this.f12474b.indexOf(com_ushareit_listenit_gla), false);
        }
        notifyDataSetChanged();
    }

    public void m18903d() {
        for (gla com_ushareit_listenit_gla : this.f12474b) {
            com_ushareit_listenit_gla.m20775a(true);
            this.f12476d.setItemChecked(this.f12474b.indexOf(com_ushareit_listenit_gla), true);
        }
        notifyDataSetChanged();
    }

    public void m18897a(fdn com_ushareit_listenit_fdn) {
        this.f12475c = com_ushareit_listenit_fdn;
    }

    public int getCount() {
        return this.f12474b.size();
    }

    public gla m18899b(int i) {
        return (gla) this.f12474b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        fdo com_ushareit_listenit_fdo;
        if (view == null) {
            view = View.inflate(viewGroup.getContext(), C0349R.layout.drag_sort_list_item, null);
            com_ushareit_listenit_fdo = new fdo();
            com_ushareit_listenit_fdo.f12481a = (ImageView) view.findViewById(C0349R.id.icon);
            com_ushareit_listenit_fdo.f12484d = (CustomCheckBox) view.findViewById(C0349R.id.checkbox);
            com_ushareit_listenit_fdo.f12482b = (TextView) view.findViewById(C0349R.id.title);
            com_ushareit_listenit_fdo.f12483c = (TextView) view.findViewById(C0349R.id.desc);
            gyn.m23213b(view.findViewById(C0349R.id.drag_content), fbb.m18762c(viewGroup.getContext()));
            view.setTag(com_ushareit_listenit_fdo);
        } else {
            com_ushareit_listenit_fdo = (fdo) view.getTag();
        }
        com_ushareit_listenit_fdo.f12484d.m26809a(((gla) this.f12474b.get(i)).m20780f());
        com_ushareit_listenit_fdo.f12484d.setOnCheckChangedListener(new fdm(this, i));
        gla com_ushareit_listenit_gla = (gla) this.f12474b.get(i);
        if (this.f12473a == 4) {
            glc com_ushareit_listenit_glc = (glc) com_ushareit_listenit_gla;
            com_ushareit_listenit_fdo.f12482b.setText(com_ushareit_listenit_glc.f14285e);
            com_ushareit_listenit_fdo.f12483c.setText(view.getResources().getString(C0349R.string.main_fragment_song_count, new Object[]{Integer.valueOf(com_ushareit_listenit_glc.f14289i)}));
            com_ushareit_listenit_fdo.f12481a.setVisibility(0);
            fzi.m21401a(viewGroup.getContext(), com_ushareit_listenit_glc, com_ushareit_listenit_fdo.f12481a, tv.NORMAL, this.f12478f);
        } else if (this.f12473a == 8) {
            glg com_ushareit_listenit_glg = (glg) com_ushareit_listenit_gla;
            com_ushareit_listenit_fdo.f12482b.setText(com_ushareit_listenit_glg.f14338f);
            com_ushareit_listenit_fdo.f12483c.setText(com_ushareit_listenit_glg.f14339g);
            com_ushareit_listenit_fdo.f12481a.setVisibility(8);
        }
        return view;
    }
}
