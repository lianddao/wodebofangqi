package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.util.Locale;

class hal {
    final /* synthetic */ hak f15056a;
    private final ImageView f15057b;
    private final TextView f15058c;
    private final TextView f15059d;
    private final TextView f15060e;
    private final TextView f15061f;
    private final View f15062g;
    private OnTouchListener f15063h = new hao(this);

    hal(hak com_ushareit_listenit_hak, View view) {
        this.f15056a = com_ushareit_listenit_hak;
        this.f15062g = view;
        this.f15057b = (ImageView) view.findViewById(C0349R.id.user_head_photo);
        this.f15058c = (TextView) view.findViewById(C0349R.id.user_name);
        this.f15059d = (TextView) view.findViewById(C0349R.id.user_distance_and_address);
        this.f15060e = (TextView) view.findViewById(C0349R.id.user_playlist_count);
        this.f15061f = (TextView) view.findViewById(C0349R.id.user_song_count);
    }

    void m23463a(fni com_ushareit_listenit_fni) {
        this.f15062g.setOnClickListener(new ham(this, com_ushareit_listenit_fni));
        this.f15062g.setOnTouchListener(this.f15063h);
        Object com_ushareit_listenit_glh = new glh(com_ushareit_listenit_fni.getId());
        fzi.m21404a(this.f15056a.f15055d, com_ushareit_listenit_glh, com_ushareit_listenit_glh.m22364a(), this.f15057b, (int) C0349R.drawable.profile_photo_default, C0349R.drawable.profile_photo_default, tv.NORMAL, this.f15057b.getWidth() > 0 ? this.f15057b.getWidth() : 100, new han(this));
        this.f15058c.setText(com_ushareit_listenit_fni.getNm());
        if (fbb.m18763c(com_ushareit_listenit_fni.getAd())) {
            this.f15059d.setText(m23462a(com_ushareit_listenit_fni.getLg()));
        } else {
            this.f15059d.setText(m23462a(com_ushareit_listenit_fni.getLg()) + "  " + com_ushareit_listenit_fni.getAd());
        }
        this.f15060e.setText(String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(com_ushareit_listenit_fni.getPlN())}));
        this.f15061f.setText(String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(com_ushareit_listenit_fni.getSgN())}));
    }

    private String m23462a(long j) {
        double a = ((double) gln.m22368a(j)) / 1000.0d;
        return new DecimalFormat("0.00").format(a) + "km";
    }
}
