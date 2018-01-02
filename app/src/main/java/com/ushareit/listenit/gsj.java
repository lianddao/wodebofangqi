package com.ushareit.listenit;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class gsj extends BaseExpandableListAdapter {
    private List<gla> f14644a = new ArrayList();
    private ArrayList<Integer> f14645b = new ArrayList();
    private SparseIntArray f14646c = new SparseIntArray();
    private SparseIntArray f14647d = new SparseIntArray();
    private SparseIntArray f14648e = new SparseIntArray();
    private int f14649f = 0;
    private gsp f14650g;
    private fdw f14651h;
    private fdw f14652i;
    private fdw f14653j;
    private fdw f14654k;

    public gsj(Context context) {
        this.f14648e.put(0, C0349R.string.search_fragment_header_songs);
        this.f14648e.put(1, C0349R.string.search_fragment_header_artists);
        this.f14648e.put(2, C0349R.string.search_fragment_header_albums);
        this.f14648e.put(3, C0349R.string.search_fragment_header_folders);
    }

    public void m22697a(gsp com_ushareit_listenit_gsp) {
        this.f14650g = com_ushareit_listenit_gsp;
    }

    void m22696a(fdw com_ushareit_listenit_fdw) {
        this.f14651h = com_ushareit_listenit_fdw;
    }

    void m22700b(fdw com_ushareit_listenit_fdw) {
        this.f14652i = com_ushareit_listenit_fdw;
    }

    void m22702c(fdw com_ushareit_listenit_fdw) {
        this.f14653j = com_ushareit_listenit_fdw;
    }

    void m22703d(fdw com_ushareit_listenit_fdw) {
        this.f14654k = com_ushareit_listenit_fdw;
    }

    synchronized void m22695a(int i, List<gla> list) {
        if (list != null) {
            if (list.size() != 0) {
                this.f14645b.add(Integer.valueOf(i));
                this.f14646c.put(i, this.f14644a.size());
                this.f14647d.put(i, list.size());
                this.f14644a.addAll(list);
            }
        }
    }

    synchronized void m22694a() {
        this.f14645b.add(Integer.valueOf(10001));
        this.f14646c.put(10001, this.f14644a.size());
        this.f14647d.put(10001, 0);
    }

    public synchronized gla m22693a(int i) {
        return (gla) this.f14644a.get(i);
    }

    public synchronized void m22698b() {
        this.f14644a.clear();
        this.f14645b.clear();
        this.f14646c.clear();
        this.f14647d.clear();
    }

    public int getGroupCount() {
        return this.f14645b.size();
    }

    public int getChildrenCount(int i) {
        return this.f14647d.get(((Integer) this.f14645b.get(i)).intValue());
    }

    public synchronized int m22701c() {
        return this.f14644a.size();
    }

    public Object getGroup(int i) {
        return null;
    }

    public Object getChild(int i, int i2) {
        return this.f14644a.get(this.f14646c.get(((Integer) this.f14645b.get(i)).intValue()) + i2);
    }

    public long getGroupId(int i) {
        return (long) i;
    }

    public long getChildId(int i, int i2) {
        return (long) (this.f14646c.get(((Integer) this.f14645b.get(i)).intValue()) + i2);
    }

    public boolean hasStableIds() {
        return false;
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = View.inflate(viewGroup.getContext(), C0349R.layout.search_fragment_list_group_view, null);
        }
        int intValue = ((Integer) this.f14645b.get(i)).intValue();
        if (intValue == 10001) {
            view.findViewById(C0349R.id.search_result_group_name).setVisibility(8);
            View findViewById = view.findViewById(C0349R.id.online_search_view);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new gsk(this));
        } else {
            view.findViewById(C0349R.id.online_search_view).setVisibility(8);
            TextView textView = (TextView) view.findViewById(C0349R.id.search_result_group_name);
            textView.setText(viewGroup.getContext().getResources().getString(this.f14648e.get(intValue)));
            textView.setVisibility(0);
        }
        return view;
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        switch (((Integer) this.f14645b.get(i)).intValue()) {
            case 0:
                view = m22683a(view, i, i2, viewGroup);
                break;
            case 1:
                view = m22684a(view, i2, viewGroup);
                break;
            case 2:
                view = m22686b(view, i2, viewGroup);
                break;
            case 3:
                view = m22689c(view, i2, viewGroup);
                break;
        }
        ((hbg) view.getTag(C0349R.id.key_view_holder)).mo2577a((gla) getChild(i, i2), false, i2 + 1, this.f14649f);
        return view;
    }

    private View m22683a(View view, int i, int i2, ViewGroup viewGroup) {
        if (view == null || ((Integer) view.getTag(C0349R.id.key_child_type)).intValue() != 0) {
            hbd com_ushareit_listenit_hbd = new hbd();
            com_ushareit_listenit_hbd.m20864a(this.f14651h);
            view = com_ushareit_listenit_hbd.mo2576a(viewGroup);
            view.setTag(C0349R.id.key_child_type, Integer.valueOf(0));
            view.setTag(C0349R.id.key_view_holder, com_ushareit_listenit_hbd);
        }
        view.setOnClickListener(new gsl(this, view, i2));
        return view;
    }

    private View m22684a(View view, int i, ViewGroup viewGroup) {
        if (view == null || ((Integer) view.getTag(C0349R.id.key_child_type)).intValue() != 1) {
            gzq com_ushareit_listenit_gzq = new gzq();
            com_ushareit_listenit_gzq.m20864a(this.f14653j);
            view = com_ushareit_listenit_gzq.mo2576a(viewGroup);
            view.setTag(C0349R.id.key_child_type, Integer.valueOf(1));
            view.setTag(C0349R.id.key_view_holder, com_ushareit_listenit_gzq);
        }
        view.setOnClickListener(new gsm(this, view, i));
        return view;
    }

    private View m22686b(View view, int i, ViewGroup viewGroup) {
        if (view == null || ((Integer) view.getTag(C0349R.id.key_child_type)).intValue() != 2) {
            gzl com_ushareit_listenit_gzl = new gzl();
            com_ushareit_listenit_gzl.m20864a(this.f14652i);
            view = com_ushareit_listenit_gzl.mo2576a(viewGroup);
            view.setTag(C0349R.id.key_child_type, Integer.valueOf(2));
            view.setTag(C0349R.id.key_view_holder, com_ushareit_listenit_gzl);
        }
        view.setOnClickListener(new gsn(this, view, i));
        return view;
    }

    private View m22689c(View view, int i, ViewGroup viewGroup) {
        if (view == null || ((Integer) view.getTag(C0349R.id.key_child_type)).intValue() != 3) {
            haa com_ushareit_listenit_haa = new haa();
            com_ushareit_listenit_haa.m20864a(this.f14654k);
            view = com_ushareit_listenit_haa.mo2576a(viewGroup);
            view.setTag(C0349R.id.key_child_type, Integer.valueOf(3));
            view.setTag(C0349R.id.key_view_holder, com_ushareit_listenit_haa);
        }
        view.setOnClickListener(new gso(this, view, i));
        return view;
    }

    public void m22699b(int i) {
        this.f14649f = i;
    }

    public boolean isChildSelectable(int i, int i2) {
        return false;
    }
}
