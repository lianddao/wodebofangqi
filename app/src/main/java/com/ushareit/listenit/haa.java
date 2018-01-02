package com.ushareit.listenit;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class haa extends hbg {
    public ImageView f15021a;
    public TextView f15022b;
    public TextView f15023c;
    public ImageView f15024d;
    public ImageView f15025e;
    public ImageView f15026f;
    public Context f15027g;

    public View mo2576a(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), C0349R.layout.list_item_folder, null);
        this.f15025e = (ImageView) inflate.findViewById(C0349R.id.select);
        this.f15026f = (ImageView) inflate.findViewById(C0349R.id.playing);
        this.f15021a = (ImageView) inflate.findViewById(C0349R.id.icon);
        this.f15022b = (TextView) inflate.findViewById(C0349R.id.title);
        this.f15023c = (TextView) inflate.findViewById(C0349R.id.sub_title);
        this.f15024d = (ImageView) inflate.findViewById(C0349R.id.more);
        this.f15021a.setVisibility(0);
        this.f15024d.setVisibility(0);
        this.f15027g = viewGroup.getContext();
        return inflate;
    }

    public void mo2577a(gla com_ushareit_listenit_gla, boolean z, int i, int i2) {
        this.f15022b.setText(((gkz) com_ushareit_listenit_gla).f14278b);
        this.f15021a.setImageResource(C0349R.drawable.list_item_folder);
        this.f15023c.setText(this.f15027g.getString(C0349R.string.main_fragment_song_count, new Object[]{Integer.valueOf(r0.f14280d)}));
        this.f15024d.setOnClickListener(new hab(this, com_ushareit_listenit_gla));
        if (z) {
            this.f15026f.setVisibility(8);
            this.f15025e.setVisibility(0);
            this.f15025e.setImageResource(com_ushareit_listenit_gla.m20780f() ? C0349R.drawable.common_item_selected : C0349R.drawable.common_item_unselected);
            return;
        }
        this.f15025e.setVisibility(8);
    }
}
