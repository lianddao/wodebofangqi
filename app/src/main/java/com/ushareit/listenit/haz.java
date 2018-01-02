package com.ushareit.listenit;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ushareit.listenit.theme.entry.CustomThemeImageView;

public class haz extends hbg {
    public CustomThemeImageView f15102a;
    public TextView f15103b;
    public TextView f15104c;
    public ImageView f15105d;
    public ImageView f15106e;
    public ImageView f15107f;
    public Context f15108g;
    private int f15109i;
    private View f15110j;

    public View mo2576a(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), C0349R.layout.list_item_playlist, null);
        this.f15106e = (ImageView) inflate.findViewById(C0349R.id.select);
        this.f15102a = (CustomThemeImageView) inflate.findViewById(C0349R.id.icon);
        this.f15107f = (ImageView) inflate.findViewById(C0349R.id.playing);
        this.f15103b = (TextView) inflate.findViewById(C0349R.id.title);
        this.f15104c = (TextView) inflate.findViewById(C0349R.id.sub_title);
        this.f15105d = (ImageView) inflate.findViewById(C0349R.id.more);
        this.f15110j = inflate.findViewById(C0349R.id.playlist_private);
        this.f15108g = viewGroup.getContext();
        this.f15102a.setVisibility(0);
        this.f15105d.setVisibility(0);
        this.f15108g = viewGroup.getContext();
        this.f15109i = (int) this.f15108g.getResources().getDimension(C0349R.dimen.common_dimens_45dp);
        return inflate;
    }

    public void mo2577a(gla com_ushareit_listenit_gla, boolean z, int i, int i2) {
        glc com_ushareit_listenit_glc = (glc) com_ushareit_listenit_gla;
        this.f15103b.setText(com_ushareit_listenit_glc.f14285e);
        this.f15104c.setText(this.f15108g.getString(C0349R.string.main_fragment_song_count, new Object[]{Integer.valueOf(com_ushareit_listenit_glc.f14289i)}));
        this.f15105d.setOnClickListener(new hba(this, com_ushareit_listenit_gla));
        if (z) {
            this.f15106e.setVisibility(0);
            this.f15106e.setImageResource(com_ushareit_listenit_gla.m20780f() ? C0349R.drawable.common_item_selected : C0349R.drawable.common_item_unselected);
            this.f15107f.setVisibility(8);
        } else {
            this.f15106e.setVisibility(8);
            if (!m23506a(com_ushareit_listenit_glc.f14285e)) {
                this.f15107f.setVisibility(8);
            } else if (com_ushareit_listenit_glc.f14289i == 0) {
                gyp.m23304r();
                this.f15107f.setVisibility(8);
            } else {
                this.f15107f.setVisibility(0);
                AnimationDrawable animationDrawable = (AnimationDrawable) this.f15107f.getDrawable();
                if (gyp.m23285b() && gyp.m23302p()) {
                    animationDrawable.start();
                } else {
                    animationDrawable.stop();
                }
            }
        }
        fzi.m21401a(this.f15108g, com_ushareit_listenit_gla, this.f15102a, tv.NORMAL, this.f15109i);
        if (com_ushareit_listenit_glc.f14290j == 1) {
            this.f15110j.setVisibility(0);
        } else {
            this.f15110j.setVisibility(4);
        }
    }

    private boolean m23506a(String str) {
        exw.m18443a("PlayListViewHolder", "isPlayPlaylist=" + gyp.m23305s() + ", name=" + gyp.m23303q());
        if (gyp.m23305s()) {
            String q = gyp.m23303q();
            if (!fbb.m18763c(q)) {
                return q.equals(str);
            }
        }
        return false;
    }
}
