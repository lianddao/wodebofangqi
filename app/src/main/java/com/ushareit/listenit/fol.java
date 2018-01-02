package com.ushareit.listenit;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import com.ushareit.listenit.cutter.AudioClipsActivity;
import java.util.ArrayList;
import java.util.List;

public class fol extends BaseAdapter implements SectionIndexer {
    final /* synthetic */ AudioClipsActivity f13101a;
    private String f13102b = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private List<gkx> f13103c = new ArrayList();

    public fol(AudioClipsActivity audioClipsActivity) {
        this.f13101a = audioClipsActivity;
    }

    public /* synthetic */ Object getItem(int i) {
        return m20218a(i);
    }

    public void m20219a(List<gkx> list) {
        if (list != null) {
            this.f13103c.clear();
            this.f13103c.addAll(list);
            notifyDataSetChanged();
        }
    }

    public int getCount() {
        return this.f13103c.size();
    }

    public gkx m20218a(int i) {
        return (gkx) this.f13103c.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        fom com_ushareit_listenit_fom;
        if (view == null) {
            view = View.inflate(viewGroup.getContext(), C0349R.layout.audio_cutter_list_item, null);
            fom com_ushareit_listenit_fom2 = new fom(this, view);
            view.setTag(com_ushareit_listenit_fom2);
            com_ushareit_listenit_fom = com_ushareit_listenit_fom2;
        } else {
            com_ushareit_listenit_fom = (fom) view.getTag();
        }
        com_ushareit_listenit_fom.m20220a((gkx) this.f13103c.get(i), i);
        return view;
    }

    public int m20217a() {
        return 1;
    }

    public int getPositionForSection(int i) {
        while (i >= 0) {
            char charAt = this.f13102b.charAt(i);
            for (int i2 = 0; i2 < getCount(); i2++) {
                Object c = m20218a(i2).mo2562c();
                if (!TextUtils.isEmpty(c) && m20216a(c.charAt(0)) == charAt) {
                    return i2 + m20217a();
                }
            }
            i--;
        }
        return m20217a();
    }

    private char m20216a(char c) {
        return ('a' > c || c > 'z') ? c : (char) (c - 32);
    }

    public int getSectionForPosition(int i) {
        return 0;
    }

    public Object[] getSections() {
        String[] strArr = new String[this.f13102b.length()];
        for (int i = 0; i < this.f13102b.length(); i++) {
            strArr[i] = String.valueOf(this.f13102b.charAt(i));
        }
        return strArr;
    }
}
