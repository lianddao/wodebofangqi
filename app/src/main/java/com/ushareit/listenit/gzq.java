package com.ushareit.listenit;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ushareit.listenit.theme.entry.CustomThemeImageView;

public class gzq extends hbg {
    public CustomThemeImageView f14986a;
    public TextView f14987b;
    public TextView f14988c;
    public ImageView f14989d;
    public ImageView f14990e;
    public ImageView f14991f;
    public Context f14992g;
    private int f14993i;

    public View mo2576a(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), C0349R.layout.list_item_playlist, null);
        this.f14990e = (ImageView) inflate.findViewById(C0349R.id.select);
        this.f14986a = (CustomThemeImageView) inflate.findViewById(C0349R.id.icon);
        this.f14991f = (ImageView) inflate.findViewById(C0349R.id.playing);
        this.f14987b = (TextView) inflate.findViewById(C0349R.id.title);
        this.f14988c = (TextView) inflate.findViewById(C0349R.id.sub_title);
        this.f14989d = (ImageView) inflate.findViewById(C0349R.id.more);
        this.f14986a.setVisibility(0);
        this.f14989d.setVisibility(0);
        this.f14992g = viewGroup.getContext();
        this.f14993i = (int) this.f14992g.getResources().getDimension(C0349R.dimen.common_dimens_45dp);
        return inflate;
    }

    public void mo2577a(gla com_ushareit_listenit_gla, boolean z, int i, int i2) {
        gkw com_ushareit_listenit_gkw = (gkw) com_ushareit_listenit_gla;
        this.f14987b.setText(com_ushareit_listenit_gkw.f14249b);
        this.f14988c.setText(this.f14992g.getString(C0349R.string.main_fragment_song_count, new Object[]{Integer.valueOf(com_ushareit_listenit_gkw.f14252e)}));
        this.f14989d.setOnClickListener(new gzr(this, com_ushareit_listenit_gla));
        if (z) {
            this.f14990e.setVisibility(0);
            this.f14990e.setImageResource(com_ushareit_listenit_gla.m20780f() ? C0349R.drawable.common_item_selected : C0349R.drawable.common_item_unselected);
            this.f14991f.setVisibility(8);
        } else {
            this.f14990e.setVisibility(8);
            if (m23400a(com_ushareit_listenit_gkw)) {
                this.f14991f.setVisibility(0);
                AnimationDrawable animationDrawable = (AnimationDrawable) this.f14991f.getDrawable();
                if (gyp.m23302p()) {
                    animationDrawable.start();
                } else {
                    animationDrawable.stop();
                }
            } else {
                this.f14991f.setVisibility(8);
            }
        }
        fzi.m21401a(this.f14992g, com_ushareit_listenit_gkw, this.f14986a, tv.NORMAL, this.f14993i);
    }

    private boolean m23400a(gkw com_ushareit_listenit_gkw) {
        glg o = gyp.m23301o();
        return o != null && o.f14339g.equals(com_ushareit_listenit_gkw.f14249b);
    }
}
