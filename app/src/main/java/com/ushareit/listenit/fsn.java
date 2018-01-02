package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.mopub.volley.DefaultRetryPolicy;

class fsn {
    public ImageView f13388a;
    public TextView f13389b;
    public TextView f13390c;
    public View f13391d;
    public int f13392e;
    final /* synthetic */ fsj f13393f;
    private OnClickListener f13394g = new fso(this);

    public fsn(fsj com_ushareit_listenit_fsj, View view, int i) {
        this.f13393f = com_ushareit_listenit_fsj;
        this.f13392e = i;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.width = com_ushareit_listenit_fsj.f13378r;
        if (i < 2) {
            layoutParams.weight = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        }
        View findViewById = view.findViewById(C0349R.id.artwork_area);
        findViewById.getLayoutParams().width = com_ushareit_listenit_fsj.f13378r;
        findViewById.getLayoutParams().height = com_ushareit_listenit_fsj.f13378r;
        this.f13388a = (ImageView) view.findViewById(C0349R.id.artwork);
        this.f13389b = (TextView) view.findViewById(C0349R.id.track_name);
        this.f13390c = (TextView) view.findViewById(C0349R.id.artist_name);
        this.f13391d = view.findViewById(C0349R.id.sub_card_mask);
    }

    public void m20810a(fse com_ushareit_listenit_fse, int i) {
        this.f13389b.setText(com_ushareit_listenit_fse.f13344b);
        this.f13390c.setText(com_ushareit_listenit_fse.f13345c);
        this.f13391d.setOnClickListener(this.f13394g);
        fzi.m21399a(this.f13393f.f13372k, new glg(com_ushareit_listenit_fse), this.f13388a, C0349R.drawable.default_albumart_gray, 0, this.f13388a.getWidth(), this.f13388a.getWidth());
    }
}
