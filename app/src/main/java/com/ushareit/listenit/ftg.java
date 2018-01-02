package com.ushareit.listenit;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.mopub.volley.DefaultRetryPolicy;

class ftg {
    public ImageView f13461a;
    public TextView f13462b;
    public TextView f13463c;
    public View f13464d;
    public int f13465e;
    final /* synthetic */ ftc f13466f;

    public ftg(ftc com_ushareit_listenit_ftc, View view, int i) {
        this.f13466f = com_ushareit_listenit_ftc;
        this.f13465e = i;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.width = com_ushareit_listenit_ftc.f13453v;
        if (i == 0 || i == 2) {
            layoutParams.weight = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        }
        View findViewById = view.findViewById(C0349R.id.artwork_area);
        findViewById.getLayoutParams().width = com_ushareit_listenit_ftc.f13453v;
        findViewById.getLayoutParams().height = com_ushareit_listenit_ftc.f13454w;
        findViewById.invalidate();
        this.f13461a = (ImageView) view.findViewById(C0349R.id.artwork);
        this.f13463c = (TextView) view.findViewById(C0349R.id.mv_duration);
        this.f13462b = (TextView) view.findViewById(C0349R.id.track_name);
        this.f13464d = view.findViewById(C0349R.id.sub_card_mask);
    }

    public void m20901a(fsi com_ushareit_listenit_fsi) {
        this.f13463c.setText(gyn.m23182a(com_ushareit_listenit_fsi.f13367f));
        this.f13462b.setText(com_ushareit_listenit_fsi.f13363b);
        fzi.m21398a(this.f13466f.f13443k, this.f13461a, Uri.parse(com_ushareit_listenit_fsi.f13364c), this.f13466f.f13453v, this.f13466f.f13454w, (int) C0349R.drawable.default_mv_bg);
        this.f13464d.setOnClickListener(new fth(this, com_ushareit_listenit_fsi));
    }
}
