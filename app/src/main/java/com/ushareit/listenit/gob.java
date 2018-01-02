package com.ushareit.listenit;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.ushareit.listenit.popupview.ActivePlaylistPopupView;
import java.util.ArrayList;
import java.util.List;

public class gob extends BaseAdapter {
    final /* synthetic */ ActivePlaylistPopupView f14490a;
    private List<glg> f14491b = new ArrayList();
    private int f14492c = 0;

    public gob(ActivePlaylistPopupView activePlaylistPopupView) {
        this.f14490a = activePlaylistPopupView;
    }

    public /* synthetic */ Object getItem(int i) {
        return m22553a(i);
    }

    public void m22557a(List<glg> list) {
        if (list != null && list.size() != 0) {
            this.f14491b.clear();
            this.f14491b.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void m22555a(int i, int i2) {
        glg com_ushareit_listenit_glg = (glg) this.f14491b.get(i);
        this.f14491b.remove(com_ushareit_listenit_glg);
        this.f14491b.add(i2, com_ushareit_listenit_glg);
        notifyDataSetChanged();
    }

    public void m22556a(glg com_ushareit_listenit_glg) {
        if (this.f14491b.contains(com_ushareit_listenit_glg)) {
            this.f14491b.remove(com_ushareit_listenit_glg);
            notifyDataSetChanged();
        }
    }

    public void m22554a() {
        this.f14491b.clear();
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.f14491b.size();
    }

    public glg m22553a(int i) {
        return (glg) this.f14491b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        god com_ushareit_listenit_god;
        if (view == null) {
            view = View.inflate(viewGroup.getContext(), C0349R.layout.now_playlist_item, null);
            god com_ushareit_listenit_god2 = new god(this, view);
            view.setTag(com_ushareit_listenit_god2);
            com_ushareit_listenit_god = com_ushareit_listenit_god2;
        } else {
            com_ushareit_listenit_god = (god) view.getTag();
        }
        glg com_ushareit_listenit_glg = (glg) this.f14491b.get(i);
        com_ushareit_listenit_god.f14495a.setText(com_ushareit_listenit_glg.f14338f);
        com_ushareit_listenit_god.f14496b.setText(com_ushareit_listenit_glg.f14339g);
        com_ushareit_listenit_god.f14499e.setOnClickListener(new goc(this, com_ushareit_listenit_glg));
        if (com_ushareit_listenit_glg.f14348p != 0) {
            com_ushareit_listenit_god.f14495a.setTextColor(C0349R.color.common_text_color_gray, C0349R.color.common_text_color_gray_night);
            com_ushareit_listenit_god.f14496b.setTextColor(C0349R.color.common_text_color_gray, C0349R.color.common_text_color_gray_night);
            com_ushareit_listenit_god.f14498d.setVisibility(8);
        } else if (com_ushareit_listenit_glg.f14334b == gyp.m23298l()) {
            int color;
            int color2;
            com_ushareit_listenit_god.f14498d.setVisibility(0);
            switch (gzd.m23364e()) {
                case 1:
                    color = this.f14490a.getResources().getColor(C0349R.color.common_text_color_orange_night_1);
                    color2 = this.f14490a.getResources().getColor(C0349R.color.common_text_color_orange);
                    break;
                case 2:
                    color2 = gzd.m23358b();
                    color = color2;
                    break;
                default:
                    color2 = this.f14490a.getResources().getColor(C0349R.color.common_text_color_orange);
                    color = color2;
                    break;
            }
            com_ushareit_listenit_god.f14495a.setTextColor(color);
            com_ushareit_listenit_god.f14496b.setTextColor(color2);
            com_ushareit_listenit_god.f14498d.setVisibility(0);
            AnimationDrawable animationDrawable = (AnimationDrawable) com_ushareit_listenit_god.f14498d.getDrawable();
            if (gyp.m23302p()) {
                animationDrawable.start();
            } else {
                animationDrawable.stop();
            }
        } else {
            com_ushareit_listenit_god.f14495a.setTextColor(C0349R.color.common_text_black_bg, C0349R.color.common_text_black_bg_night);
            com_ushareit_listenit_god.f14496b.setTextColor(C0349R.color.common_text_color_gray, C0349R.color.common_text_black_bg_night);
            com_ushareit_listenit_god.f14498d.setVisibility(8);
        }
        return view;
    }
}
