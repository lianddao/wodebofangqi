package com.ushareit.listenit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class fdx extends BaseAdapter {
    private List<fnl> f12506a = new ArrayList();
    private final Context f12507b;

    public /* synthetic */ Object getItem(int i) {
        return m18936a(i);
    }

    public fdx(Context context) {
        this.f12507b = context;
    }

    public int getCount() {
        return this.f12506a.size();
    }

    public fnl m18936a(int i) {
        return (fnl) this.f12506a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        fdz com_ushareit_listenit_fdz;
        if (view == null) {
            view = LayoutInflater.from(this.f12507b).inflate(C0349R.layout.list_item_playlist, null);
            ImageView imageView = (ImageView) view.findViewById(C0349R.id.icon);
            TextView textView = (TextView) view.findViewById(C0349R.id.title);
            TextView textView2 = (TextView) view.findViewById(C0349R.id.sub_title);
            view.findViewById(C0349R.id.more).setVisibility(8);
            fdz com_ushareit_listenit_fdz2 = new fdz(this);
            com_ushareit_listenit_fdz2.f12512a = imageView;
            com_ushareit_listenit_fdz2.f12513b = textView;
            com_ushareit_listenit_fdz2.f12514c = textView2;
            view.setTag(com_ushareit_listenit_fdz2);
            com_ushareit_listenit_fdz = com_ushareit_listenit_fdz2;
        } else {
            com_ushareit_listenit_fdz = (fdz) view.getTag();
        }
        fnl com_ushareit_listenit_fnl = (fnl) this.f12506a.get(i);
        com_ushareit_listenit_fdz.f12513b.setText(com_ushareit_listenit_fnl.getNa());
        com_ushareit_listenit_fdz.f12514c.setText(view.getContext().getString(C0349R.string.main_fragment_song_count, new Object[]{Integer.valueOf(com_ushareit_listenit_fnl.getSgN())}));
        m18935a(com_ushareit_listenit_fdz.f12512a, com_ushareit_listenit_fnl);
        return view;
    }

    private void m18935a(ImageView imageView, fnl com_ushareit_listenit_fnl) {
        hhx.m23867a(new fdy(this, imageView, com_ushareit_listenit_fnl));
    }

    public void m18937a(List<fnl> list) {
        this.f12506a.addAll(list);
        notifyDataSetChanged();
    }
}
