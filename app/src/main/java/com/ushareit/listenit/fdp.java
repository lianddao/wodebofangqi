package com.ushareit.listenit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

public class fdp extends BaseAdapter {
    private fdr f12487a;
    private LayoutInflater f12488b;
    private List<gky> f12489c = new ArrayList();
    private Context f12490d;

    public /* synthetic */ Object getItem(int i) {
        return m18908a(i);
    }

    public void m18909a(fdr com_ushareit_listenit_fdr) {
        this.f12487a = com_ushareit_listenit_fdr;
    }

    public fdp(Context context) {
        this.f12490d = context;
        this.f12488b = LayoutInflater.from(context);
    }

    public void m18910a(List<gky> list) {
        this.f12489c.clear();
        this.f12489c.addAll(list);
    }

    public int getCount() {
        return this.f12489c.size();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public gky m18908a(int i) {
        return (gky) this.f12489c.get(i);
    }

    public void m18911b(int i) {
        gky com_ushareit_listenit_gky = (gky) this.f12489c.get(i);
        for (gky a : this.f12489c) {
            a.m22269a(false);
        }
        com_ushareit_listenit_gky.m22269a(true);
        notifyDataSetChanged();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        fds com_ushareit_listenit_fds;
        gky com_ushareit_listenit_gky = (gky) this.f12489c.get(i);
        if (view == null) {
            view = this.f12488b.inflate(C0349R.layout.equalizer_item_view, viewGroup, false);
            com_ushareit_listenit_fds = new fds(view);
            view.setTag(com_ushareit_listenit_fds);
        } else {
            com_ushareit_listenit_fds = (fds) view.getTag();
        }
        com_ushareit_listenit_fds.m18915a(com_ushareit_listenit_gky.m22273c());
        if (com_ushareit_listenit_gky.m22270a()) {
            com_ushareit_listenit_fds.m18913a(this.f12490d.getResources().getColor(C0349R.color.common_text_color_white));
            com_ushareit_listenit_fds.m18914a(this.f12490d.getResources().getDrawable(C0349R.drawable.equalizer_item_selected_bg));
        } else {
            com_ushareit_listenit_fds.m18913a(this.f12490d.getResources().getColor(C0349R.color.common_text_orange_bg));
            com_ushareit_listenit_fds.m18914a(this.f12490d.getResources().getDrawable(C0349R.drawable.equalizer_presets_item_bg));
        }
        if (this.f12487a != null) {
            view.setOnClickListener(new fdq(this, i));
        }
        return view;
    }
}
