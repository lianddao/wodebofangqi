package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

public class ftj extends hbg {
    private ImageView f13470a;
    private TextView f13471b;
    private TextView f13472c;
    private Context f13473d;
    private View f13474e;
    private int f13475f;
    private int f13476g;

    public View mo2576a(ViewGroup viewGroup) {
        this.f13473d = viewGroup.getContext();
        View inflate = View.inflate(viewGroup.getContext(), C0349R.layout.list_item_video, null);
        this.f13474e = inflate.findViewById(C0349R.id.click_area);
        this.f13470a = (ImageView) inflate.findViewById(C0349R.id.thumbnail);
        this.f13471b = (TextView) inflate.findViewById(C0349R.id.video_name);
        this.f13472c = (TextView) inflate.findViewById(C0349R.id.duration);
        this.f13475f = gyr.m23306a();
        this.f13476g = (int) ((((float) this.f13475f) * 9.0f) / 16.0f);
        LayoutParams layoutParams = this.f13474e.getLayoutParams();
        layoutParams.width = this.f13475f;
        layoutParams.height = this.f13476g;
        this.f13474e.setLayoutParams(layoutParams);
        return inflate;
    }

    public void mo2577a(gla com_ushareit_listenit_gla, boolean z, int i, int i2) {
        fsi com_ushareit_listenit_fsi = (fsi) com_ushareit_listenit_gla;
        this.f13471b.setText(com_ushareit_listenit_fsi.f13363b);
        this.f13472c.setText(gyn.m23182a(com_ushareit_listenit_fsi.f13367f));
        if (i2 == 0) {
            fzi.m21398a(this.f13473d, this.f13470a, Uri.parse(com_ushareit_listenit_fsi.f13364c), this.f13475f, this.f13476g, 0);
            this.f13474e.setOnClickListener(new ftk(this, com_ushareit_listenit_fsi));
        }
    }
}
