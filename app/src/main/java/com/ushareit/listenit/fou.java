package com.ushareit.listenit;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import com.ushareit.listenit.cutter.AudioCutterActivity;
import java.util.ArrayList;
import java.util.List;

public class fou extends BaseAdapter implements SectionIndexer {
    final /* synthetic */ AudioCutterActivity f13119a;
    private String f13120b = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private List<glg> f13121c = new ArrayList();

    public fou(AudioCutterActivity audioCutterActivity) {
        this.f13119a = audioCutterActivity;
    }

    public /* synthetic */ Object getItem(int i) {
        return m20227a(i);
    }

    public void m20228a(List<glg> list) {
        if (list != null) {
            this.f13121c.clear();
            this.f13121c.addAll(list);
            notifyDataSetChanged();
        }
    }

    public int getCount() {
        return this.f13121c.size();
    }

    public glg m20227a(int i) {
        return (glg) this.f13121c.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        fov com_ushareit_listenit_fov;
        if (view == null) {
            view = View.inflate(viewGroup.getContext(), C0349R.layout.audio_cutter_list_item, null);
            fov com_ushareit_listenit_fov2 = new fov(this, view);
            view.setTag(com_ushareit_listenit_fov2);
            com_ushareit_listenit_fov = com_ushareit_listenit_fov2;
        } else {
            com_ushareit_listenit_fov = (fov) view.getTag();
        }
        com_ushareit_listenit_fov.m20229a((glg) this.f13121c.get(i), i);
        return view;
    }

    public int m20226a() {
        return 1;
    }

    public int getPositionForSection(int i) {
        while (i >= 0) {
            char charAt = this.f13120b.charAt(i);
            for (int i2 = 0; i2 < getCount(); i2++) {
                Object c = m20227a(i2).mo2562c();
                if (!TextUtils.isEmpty(c) && m20225a(c.charAt(0)) == charAt) {
                    return i2 + m20226a();
                }
            }
            i--;
        }
        return m20226a();
    }

    private char m20225a(char c) {
        return ('a' > c || c > 'z') ? c : (char) (c - 32);
    }

    public int getSectionForPosition(int i) {
        return 0;
    }

    public Object[] getSections() {
        String[] strArr = new String[this.f13120b.length()];
        for (int i = 0; i < this.f13120b.length(); i++) {
            strArr[i] = String.valueOf(this.f13120b.charAt(i));
        }
        return strArr;
    }
}
