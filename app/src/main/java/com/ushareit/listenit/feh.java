package com.ushareit.listenit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.ushareit.listenit.theme.entry.CustomThemeTextView;
import java.util.ArrayList;
import java.util.List;

public class feh extends BaseAdapter {
    private List<fri> f12531a = new ArrayList();
    private fei f12532b;
    private final Context f12533c;

    public feh(Context context) {
        this.f12533c = context;
    }

    public int getCount() {
        return this.f12531a.size();
    }

    public Object getItem(int i) {
        return this.f12531a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        fek com_ushareit_listenit_fek;
        int i2;
        fri com_ushareit_listenit_fri = (fri) this.f12531a.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.f12533c).inflate(C0349R.layout.songs_menu_list_items, null);
            CustomThemeTextView customThemeTextView = (CustomThemeTextView) view.findViewById(C0349R.id.songs_index);
            CustomThemeTextView customThemeTextView2 = (CustomThemeTextView) view.findViewById(C0349R.id.songs_name);
            CustomThemeTextView customThemeTextView3 = (CustomThemeTextView) view.findViewById(C0349R.id.singer_name);
            ImageView imageView = (ImageView) view.findViewById(C0349R.id.collect_star);
            fek com_ushareit_listenit_fek2 = new fek(this);
            com_ushareit_listenit_fek2.f12537a = customThemeTextView;
            com_ushareit_listenit_fek2.f12538b = customThemeTextView2;
            com_ushareit_listenit_fek2.f12539c = customThemeTextView3;
            com_ushareit_listenit_fek2.f12540d = imageView;
            view.setTag(com_ushareit_listenit_fek2);
            com_ushareit_listenit_fek = com_ushareit_listenit_fek2;
        } else {
            com_ushareit_listenit_fek = (fek) view.getTag();
        }
        com_ushareit_listenit_fek.f12537a.setText(String.valueOf(i + 1));
        com_ushareit_listenit_fek.f12538b.setText(com_ushareit_listenit_fri.m20702a());
        com_ushareit_listenit_fek.f12539c.setText(com_ushareit_listenit_fri.m20704b());
        if (fhy.m19213a()) {
            if (com_ushareit_listenit_fri.m20705c()) {
                i2 = C0349R.drawable.collection_selected_b;
            } else {
                i2 = C0349R.drawable.collection_normal_b;
            }
        } else if (com_ushareit_listenit_fri.m20705c()) {
            i2 = C0349R.drawable.collection_selected;
        } else {
            i2 = C0349R.drawable.collection_normal;
        }
        com_ushareit_listenit_fek.f12540d.setImageResource(i2);
        view.setOnClickListener(new fej(this, com_ushareit_listenit_fri, com_ushareit_listenit_fek.f12540d));
        return view;
    }

    public boolean m18952a() {
        for (fri c : this.f12531a) {
            if (!c.m20705c()) {
                return false;
            }
        }
        return true;
    }

    public void m18951a(List<fri> list) {
        this.f12531a.clear();
        this.f12531a.addAll(list);
        notifyDataSetChanged();
    }

    public List<Long> m18953b() {
        List<Long> arrayList = new ArrayList();
        for (int i = 0; i < this.f12531a.size(); i++) {
            Long b;
            fri com_ushareit_listenit_fri = (fri) this.f12531a.get(i);
            if (com_ushareit_listenit_fri.m20705c()) {
                b = frf.m20657b(com_ushareit_listenit_fri.f13280a);
            } else {
                ((fri) this.f12531a.get(i)).m20703a(true);
                b = Long.valueOf(frf.m20631a(com_ushareit_listenit_fri));
            }
            if (b.longValue() != -1) {
                arrayList.add(b);
            }
        }
        notifyDataSetChanged();
        return arrayList;
    }

    public void m18950a(fei com_ushareit_listenit_fei) {
        this.f12532b = com_ushareit_listenit_fei;
    }
}
