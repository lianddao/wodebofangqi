package com.ushareit.listenit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class fdc extends BaseExpandableListAdapter {
    private LayoutInflater f12454a;
    private List<fdf> f12455b = new ArrayList();

    public /* synthetic */ Object getChild(int i, int i2) {
        return m18876a(i, i2);
    }

    public /* synthetic */ Object getGroup(int i) {
        return m18877a(i);
    }

    public fdc(Context context) {
        this.f12454a = LayoutInflater.from(context);
    }

    public void m18878a(List<fdf> list) {
        this.f12455b = list;
    }

    public int getGroupCount() {
        return this.f12455b.size();
    }

    public int getChildrenCount(int i) {
        if (((fdf) this.f12455b.get(i)).f12458b) {
            return ((fdf) this.f12455b.get(i)).f12459c.size();
        }
        return 0;
    }

    public fdf m18877a(int i) {
        return (fdf) this.f12455b.get(i);
    }

    public fde m18876a(int i, int i2) {
        if (((fdf) this.f12455b.get(i)).f12458b) {
            return (fde) ((fdf) this.f12455b.get(i)).f12459c.get(i2);
        }
        return null;
    }

    public long getGroupId(int i) {
        return (long) i;
    }

    public long getChildId(int i, int i2) {
        return (long) i2;
    }

    public boolean hasStableIds() {
        return false;
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        fdh com_ushareit_listenit_fdh;
        if (view == null) {
            com_ushareit_listenit_fdh = new fdh();
            view = this.f12454a.inflate(C0349R.layout.about_expandable_group_list, null);
            com_ushareit_listenit_fdh.f12462a = (TextView) view.findViewById(C0349R.id.title);
            com_ushareit_listenit_fdh.f12463b = (ImageView) view.findViewById(C0349R.id.arrow);
            view.setTag(com_ushareit_listenit_fdh);
        } else {
            com_ushareit_listenit_fdh = (fdh) view.getTag();
        }
        fdf com_ushareit_listenit_fdf = (fdf) this.f12455b.get(i);
        com_ushareit_listenit_fdh.f12462a.setText(com_ushareit_listenit_fdf.f12457a);
        if (com_ushareit_listenit_fdf.f12458b && z) {
            com_ushareit_listenit_fdh.f12463b.setBackgroundResource(C0349R.drawable.common_down_arrow);
        } else {
            com_ushareit_listenit_fdh.f12463b.setBackgroundResource(C0349R.drawable.common_goto_arrow);
        }
        view.findViewById(C0349R.id.bottom_divider).setVisibility(i == getGroupCount() + -1 ? 8 : 0);
        return view;
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        if (m18877a(i).f12459c != null) {
            fde a = m18876a(i, i2);
            if (a != null) {
                fdg com_ushareit_listenit_fdg;
                if (view == null) {
                    view = this.f12454a.inflate(C0349R.layout.about_expandable_child_list, null);
                    fdg com_ushareit_listenit_fdg2 = new fdg();
                    com_ushareit_listenit_fdg2.f12460a = (TextView) view.findViewById(C0349R.id.child_title);
                    view.setTag(com_ushareit_listenit_fdg2);
                    com_ushareit_listenit_fdg = com_ushareit_listenit_fdg2;
                } else {
                    com_ushareit_listenit_fdg = (fdg) view.getTag();
                }
                com_ushareit_listenit_fdg.f12460a.setText(a.f12456a);
            }
        }
        return view;
    }

    public boolean isChildSelectable(int i, int i2) {
        return true;
    }
}
