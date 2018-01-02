package com.ushareit.listenit;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ushareit.listenit.theme.entry.CustomThemeImageView;

public class hbb extends hbg {
    public CustomThemeImageView f15113a;
    public TextView f15114b;
    public TextView f15115c;
    public ImageView f15116d;
    public ImageView f15117e;
    public ImageView f15118f;
    public Context f15119g;
    private int f15120i;

    public View mo2576a(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), C0349R.layout.list_item_playlist, null);
        this.f15117e = (ImageView) inflate.findViewById(C0349R.id.select);
        this.f15113a = (CustomThemeImageView) inflate.findViewById(C0349R.id.icon);
        this.f15118f = (ImageView) inflate.findViewById(C0349R.id.playing);
        this.f15114b = (TextView) inflate.findViewById(C0349R.id.title);
        this.f15115c = (TextView) inflate.findViewById(C0349R.id.sub_title);
        this.f15116d = (ImageView) inflate.findViewById(C0349R.id.more);
        this.f15119g = viewGroup.getContext();
        this.f15113a.setVisibility(0);
        this.f15116d.setVisibility(8);
        this.f15119g = viewGroup.getContext();
        this.f15120i = (int) this.f15119g.getResources().getDimension(C0349R.dimen.common_dimens_45dp);
        return inflate;
    }

    public void mo2577a(gla com_ushareit_listenit_gla, boolean z, int i, int i2) {
        this.f15114b.setText(((glc) com_ushareit_listenit_gla).f14285e);
        this.f15115c.setText(this.f15119g.getString(C0349R.string.main_fragment_song_count, new Object[]{Integer.valueOf(r0.f14289i)}));
        this.f15116d.setOnClickListener(new hbc(this, com_ushareit_listenit_gla));
        if (z) {
            this.f15117e.setVisibility(0);
            this.f15117e.setImageResource(com_ushareit_listenit_gla.m20780f() ? C0349R.drawable.common_item_selected : C0349R.drawable.common_item_unselected);
            this.f15118f.setVisibility(8);
        } else {
            this.f15117e.setVisibility(8);
        }
        fzi.m21401a(this.f15119g, com_ushareit_listenit_gla, this.f15113a, tv.NORMAL, this.f15120i);
    }
}
