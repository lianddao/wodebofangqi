package com.ushareit.listenit;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.mopub.volley.DefaultRetryPolicy;

class fsv {
    public ImageView f13425a;
    public TextView f13426b;
    public View f13427c;
    public int f13428d;
    final /* synthetic */ fst f13429e;

    public fsv(fst com_ushareit_listenit_fst, View view, int i) {
        this.f13429e = com_ushareit_listenit_fst;
        this.f13428d = i;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.width = com_ushareit_listenit_fst.f13422r;
        if (i < 2) {
            layoutParams.weight = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        }
        View findViewById = view.findViewById(C0349R.id.artwork_area);
        findViewById.getLayoutParams().width = com_ushareit_listenit_fst.f13422r;
        findViewById.getLayoutParams().height = com_ushareit_listenit_fst.f13422r;
        this.f13425a = (ImageView) view.findViewById(C0349R.id.artwork);
        this.f13426b = (TextView) view.findViewById(C0349R.id.track_name);
        this.f13426b.setSingleLine(false);
        this.f13426b.setMaxLines(2);
        view.findViewById(C0349R.id.artist_name).setVisibility(8);
        view.findViewById(C0349R.id.play_button).setVisibility(8);
        this.f13427c = view.findViewById(C0349R.id.sub_card_mask);
    }

    public void m20877a(fsg com_ushareit_listenit_fsg, int i) {
        this.f13426b.setText(com_ushareit_listenit_fsg.f13356b);
        int i2 = i == 0 ? 0 : i == 1 ? 100 : 300;
        hhx.m23869a(new fsw(this, com_ushareit_listenit_fsg), 0, i2);
        this.f13427c.setOnClickListener(new fsx(this, com_ushareit_listenit_fsg));
    }
}
