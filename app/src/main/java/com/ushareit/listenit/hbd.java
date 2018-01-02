package com.ushareit.listenit;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ushareit.listenit.widget.CustomCheckView;

public class hbd extends hbg {
    public TextView f15123a;
    public TextView f15124b;
    public ImageView f15125c;
    public ImageView f15126d;
    public CustomCheckView f15127e;
    public TextView f15128f;
    private Context f15129g;
    private ImageView f15130i;
    private OnClickListener f15131j = new hbf(this);

    public View mo2576a(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), C0349R.layout.list_item_song, null);
        this.f15123a = (TextView) inflate.findViewById(C0349R.id.title);
        this.f15124b = (TextView) inflate.findViewById(C0349R.id.sub_title);
        this.f15125c = (ImageView) inflate.findViewById(C0349R.id.more);
        this.f15127e = (CustomCheckView) inflate.findViewById(C0349R.id.select);
        this.f15126d = (ImageView) inflate.findViewById(C0349R.id.play_anim);
        this.f15128f = (TextView) inflate.findViewById(C0349R.id.count);
        this.f15130i = (ImageView) inflate.findViewById(C0349R.id.download_state);
        this.f15129g = viewGroup.getContext();
        return inflate;
    }

    public void mo2577a(gla com_ushareit_listenit_gla, boolean z, int i, int i2) {
        boolean z2;
        glg com_ushareit_listenit_glg = (glg) com_ushareit_listenit_gla;
        this.f15123a.setText(com_ushareit_listenit_glg.f14338f);
        this.f15124b.setText(com_ushareit_listenit_glg.f14339g);
        this.f15128f.setText(String.valueOf(i));
        if (com_ushareit_listenit_glg.f14348p == 0) {
            this.f15125c.setOnClickListener(new hbe(this, com_ushareit_listenit_gla));
        } else {
            this.f15125c.setOnClickListener(null);
        }
        m23517a(gyo.m23264a().m23267a(Long.valueOf(com_ushareit_listenit_glg.f14334b)));
        if (com_ushareit_listenit_glg.f14352t > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        m23519b(z2);
        if (z) {
            this.f15128f.setVisibility(8);
            this.f15125c.setVisibility(8);
            this.f15126d.setVisibility(8);
            this.f15130i.setVisibility(8);
            this.f15127e.setVisibility(0);
            this.f15127e.setChecked(com_ushareit_listenit_gla.m20780f());
        } else {
            this.f15125c.setVisibility(0);
            this.f15127e.setVisibility(8);
            if (com_ushareit_listenit_glg.f14334b == gyp.m23298l()) {
                this.f15128f.setVisibility(8);
                this.f15130i.setVisibility(8);
                this.f15126d.setVisibility(0);
                AnimationDrawable animationDrawable;
                if (gyp.m23302p()) {
                    if (this.f15126d.getTag() == null || !((Boolean) this.f15126d.getTag()).booleanValue()) {
                        this.f15126d.setImageResource(C0349R.drawable.play_animation_orange);
                        animationDrawable = (AnimationDrawable) this.f15126d.getDrawable();
                        this.f15126d.setTag(Boolean.valueOf(true));
                        animationDrawable.start();
                    }
                } else if (this.f15126d.getTag() == null || ((Boolean) this.f15126d.getTag()).booleanValue()) {
                    this.f15126d.setImageResource(C0349R.drawable.play_animation_orange);
                    animationDrawable = (AnimationDrawable) this.f15126d.getDrawable();
                    this.f15126d.setTag(Boolean.valueOf(false));
                    animationDrawable.stop();
                }
                this.f15125c.setClickable(true);
                this.f15125c.setImageResource(C0349R.drawable.common_list_item_more_bg);
            } else if (com_ushareit_listenit_glg.f14348p == 0) {
                this.f15128f.setVisibility(0);
                this.f15130i.setVisibility(8);
                this.f15126d.setVisibility(8);
                this.f15125c.setClickable(true);
                this.f15125c.setImageResource(C0349R.drawable.common_list_item_more_bg);
            } else {
                Drawable a = m23515a(com_ushareit_listenit_glg);
                if (a != null) {
                    this.f15128f.setVisibility(8);
                    this.f15126d.setVisibility(8);
                    this.f15130i.setVisibility(0);
                    this.f15130i.setImageDrawable(a);
                } else {
                    this.f15128f.setVisibility(0);
                    this.f15126d.setVisibility(8);
                    this.f15130i.setVisibility(8);
                }
                this.f15125c.setClickable(false);
                this.f15125c.setImageResource(C0349R.drawable.common_list_item_more_normal);
            }
        }
        int i3 = gzd.m23364e() == 1 ? com_ushareit_listenit_glg.f14348p == 1 ? C0349R.color.common_text_color_gray_night : C0349R.color.common_text_color_black_night : com_ushareit_listenit_glg.f14348p == 1 ? C0349R.color.common_text_color_gray : C0349R.color.common_text_color_black;
        this.f15123a.setTextColor(this.f15129g.getResources().getColor(i3));
    }

    private Drawable m23515a(glg com_ushareit_listenit_glg) {
        if (flw.m19819a().m19813f(com_ushareit_listenit_glg)) {
            Drawable drawable = this.f15129g.getResources().getDrawable(C0349R.drawable.list_icon_download);
            if (gzd.m23364e() == 2) {
                return hhe.m23348a(drawable, gzd.m23362d());
            }
            return drawable;
        } else if (flw.m19819a().m19812e(com_ushareit_listenit_glg)) {
            return this.f15129g.getResources().getDrawable(C0349R.drawable.list_icon_waiting);
        } else {
            if (flw.m19819a().m19814g(com_ushareit_listenit_glg)) {
                return this.f15129g.getResources().getDrawable(C0349R.drawable.list_icon_paused);
            }
            return null;
        }
    }

    private void m23517a(boolean z) {
        if (z) {
            Drawable drawable = this.f15129g.getResources().getDrawable(C0349R.drawable.common_new_message);
            int b = gyn.m23204b(this.f15123a.getTextSize());
            int dimension = (int) this.f15129g.getResources().getDimension(C0349R.dimen.common_dimens_5dp);
            drawable.setBounds(0, 0, (drawable.getIntrinsicWidth() * b) / drawable.getIntrinsicHeight(), b);
            if (gzd.m23364e() == 2) {
                drawable = hhe.m23348a(drawable, gzd.m23358b());
            }
            this.f15123a.setCompoundDrawables(null, null, drawable, null);
            this.f15123a.setCompoundDrawablePadding(dimension);
            return;
        }
        this.f15123a.setCompoundDrawables(null, null, null, null);
    }

    private void m23519b(boolean z) {
        if (z) {
            Drawable drawable = this.f15129g.getResources().getDrawable(C0349R.drawable.list_icon_cloud);
            int b = (int) (((double) gyn.m23204b(this.f15124b.getTextSize())) * 0.7d);
            int dimension = (int) this.f15129g.getResources().getDimension(C0349R.dimen.common_dimens_5dp);
            drawable.setBounds(0, 0, (drawable.getIntrinsicWidth() * b) / drawable.getIntrinsicHeight(), b);
            if (gzd.m23364e() == 2) {
                drawable = hhe.m23348a(drawable, gzd.m23360c());
            }
            this.f15124b.setCompoundDrawables(drawable, null, null, null);
            this.f15124b.setCompoundDrawablePadding(dimension);
            return;
        }
        this.f15124b.setCompoundDrawables(null, null, null, null);
    }
}
