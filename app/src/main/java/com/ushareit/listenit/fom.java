package com.ushareit.listenit;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class fom {
    TextView f13104a;
    TextView f13105b;
    TextView f13106c;
    ImageView f13107d;
    ImageView f13108e;
    final /* synthetic */ fol f13109f;

    public fom(fol com_ushareit_listenit_fol, View view) {
        this.f13109f = com_ushareit_listenit_fol;
        this.f13104a = (TextView) view.findViewById(C0349R.id.song_name);
        this.f13105b = (TextView) view.findViewById(C0349R.id.artist_name);
        this.f13106c = (TextView) view.findViewById(C0349R.id.count);
        this.f13108e = (ImageView) view.findViewById(C0349R.id.more);
        this.f13107d = (ImageView) view.findViewById(C0349R.id.playing);
    }

    public void m20220a(gkx com_ushareit_listenit_gkx, int i) {
        this.f13104a.setText(com_ushareit_listenit_gkx.f14255b);
        this.f13105b.setText(gyn.m23182a((long) com_ushareit_listenit_gkx.f14258e) + " | " + (com_ushareit_listenit_gkx.f14257d / 1000) + "KB");
        if (this.f13109f.f13101a.f9017A == null || this.f13109f.f13101a.f9017A.mo2464u() != com_ushareit_listenit_gkx.f14254a) {
            this.f13106c.setVisibility(0);
            this.f13106c.setText(String.valueOf(i + 1));
            this.f13107d.setVisibility(8);
        } else {
            this.f13106c.setVisibility(8);
            this.f13107d.setVisibility(0);
            this.f13107d.setImageResource(C0349R.drawable.play_animation_orange);
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f13107d.getDrawable();
            if (this.f13109f.f13101a.f9017A.mo2425a()) {
                animationDrawable.start();
            } else {
                animationDrawable.stop();
            }
        }
        this.f13108e.setVisibility(0);
        this.f13108e.setOnClickListener(new fon(this, com_ushareit_listenit_gkx));
    }
}
