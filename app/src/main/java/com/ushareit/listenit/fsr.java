package com.ushareit.listenit;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ushareit.listenit.widget.CustomCheckView;

public class fsr extends hbg {
    public TextView f13408a;
    public TextView f13409b;
    public ImageView f13410c;
    public ImageView f13411d;
    public CustomCheckView f13412e;
    public TextView f13413f;

    public View mo2576a(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), C0349R.layout.list_item_song, null);
        this.f13413f = (TextView) inflate.findViewById(C0349R.id.count);
        this.f13412e = (CustomCheckView) inflate.findViewById(C0349R.id.select);
        this.f13408a = (TextView) inflate.findViewById(C0349R.id.title);
        this.f13409b = (TextView) inflate.findViewById(C0349R.id.sub_title);
        this.f13410c = (ImageView) inflate.findViewById(C0349R.id.more);
        this.f13411d = (ImageView) inflate.findViewById(C0349R.id.play_anim);
        this.f13411d.setImageResource(C0349R.drawable.play_animation_orange);
        inflate.findViewById(C0349R.id.download_state).setVisibility(8);
        return inflate;
    }

    public void mo2577a(gla com_ushareit_listenit_gla, boolean z, int i, int i2) {
        glg com_ushareit_listenit_glg = (glg) com_ushareit_listenit_gla;
        this.f13408a.setText(com_ushareit_listenit_glg.f14338f);
        this.f13409b.setText(com_ushareit_listenit_glg.f14339g);
        if (z) {
            this.f13413f.setVisibility(8);
            this.f13412e.setVisibility(0);
            this.f13412e.setChecked(com_ushareit_listenit_gla.m20780f());
            this.f13411d.setVisibility(8);
            this.f13410c.setVisibility(8);
            return;
        }
        this.f13412e.setVisibility(8);
        if (com_ushareit_listenit_glg.f14334b == gyp.m23298l()) {
            this.f13413f.setVisibility(8);
            this.f13411d.setVisibility(0);
            m20867a();
        } else {
            this.f13413f.setText(String.valueOf(i));
            this.f13413f.setVisibility(0);
            this.f13411d.setVisibility(8);
        }
        this.f13410c.setOnClickListener(new fss(this, com_ushareit_listenit_gla));
        this.f13410c.setClickable(true);
        this.f13410c.setImageResource(C0349R.drawable.common_list_item_more_bg);
    }

    private void m20867a() {
        AnimationDrawable animationDrawable;
        if (gyp.m23302p()) {
            if (this.f13411d.getTag() == null || !((Boolean) this.f13411d.getTag()).booleanValue()) {
                this.f13411d.setImageResource(C0349R.drawable.play_animation_orange);
                animationDrawable = (AnimationDrawable) this.f13411d.getDrawable();
                this.f13411d.setTag(Boolean.valueOf(true));
                animationDrawable.start();
            }
        } else if (this.f13411d.getTag() == null || ((Boolean) this.f13411d.getTag()).booleanValue()) {
            this.f13411d.setImageResource(C0349R.drawable.play_animation_orange);
            animationDrawable = (AnimationDrawable) this.f13411d.getDrawable();
            this.f13411d.setTag(Boolean.valueOf(false));
            animationDrawable.stop();
        }
    }
}
