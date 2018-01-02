package com.ushareit.listenit;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ushareit.listenit.theme.entry.CustomThemeImageView;

public class gzl extends hbg {
    public CustomThemeImageView f14965a;
    public TextView f14966b;
    public TextView f14967c;
    public ImageView f14968d;
    public ImageView f14969e;
    public ImageView f14970f;
    public Context f14971g;
    private int f14972i;

    public View mo2576a(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), C0349R.layout.list_item_ablumart, null);
        this.f14969e = (ImageView) inflate.findViewById(C0349R.id.select);
        this.f14965a = (CustomThemeImageView) inflate.findViewById(C0349R.id.icon);
        this.f14970f = (ImageView) inflate.findViewById(C0349R.id.playing);
        this.f14966b = (TextView) inflate.findViewById(C0349R.id.title);
        this.f14967c = (TextView) inflate.findViewById(C0349R.id.sub_title);
        this.f14968d = (ImageView) inflate.findViewById(C0349R.id.more);
        this.f14965a.setVisibility(0);
        this.f14968d.setVisibility(0);
        this.f14971g = viewGroup.getContext();
        this.f14972i = (int) this.f14971g.getResources().getDimension(C0349R.dimen.common_dimens_54dp);
        return inflate;
    }

    public void mo2577a(gla com_ushareit_listenit_gla, boolean z, int i, int i2) {
        gkv com_ushareit_listenit_gkv = (gkv) com_ushareit_listenit_gla;
        this.f14966b.setText(com_ushareit_listenit_gkv.f14244c);
        this.f14967c.setText(this.f14971g.getString(C0349R.string.main_fragment_song_count, new Object[]{Integer.valueOf(com_ushareit_listenit_gkv.f14246e)}));
        this.f14968d.setOnClickListener(new gzm(this, com_ushareit_listenit_gla));
        if (z) {
            int i3;
            this.f14970f.setVisibility(8);
            this.f14969e.setVisibility(0);
            ImageView imageView = this.f14969e;
            if (com_ushareit_listenit_gla.m20780f()) {
                i3 = C0349R.drawable.common_item_selected;
            } else {
                i3 = C0349R.drawable.common_item_unselected;
            }
            imageView.setImageResource(i3);
        } else {
            this.f14969e.setVisibility(8);
            if (m23385a(com_ushareit_listenit_gkv)) {
                this.f14970f.setVisibility(0);
                AnimationDrawable animationDrawable = (AnimationDrawable) this.f14970f.getDrawable();
                if (gyp.m23302p()) {
                    animationDrawable.start();
                } else {
                    animationDrawable.stop();
                }
            } else {
                this.f14970f.setVisibility(8);
            }
        }
        fzi.m21401a(this.f14971g, com_ushareit_listenit_gkv, this.f14965a, tv.NORMAL, this.f14972i);
    }

    private boolean m23385a(gkv com_ushareit_listenit_gkv) {
        glg o = gyp.m23301o();
        return (o == null || o.f14339g == null || !o.f14339g.equals(com_ushareit_listenit_gkv.f14243b) || o.f14340h == null || !o.f14340h.equals(com_ushareit_listenit_gkv.f14244c)) ? false : true;
    }
}
