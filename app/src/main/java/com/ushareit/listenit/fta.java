package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mopub.mobileads.resource.DrawableConstants.CloseButton;
import com.ushareit.listenit.theme.entry.CustomThemeImageView;

public class fta extends hbg {
    public Context f13435a;
    public CustomThemeImageView f13436b;
    public TextView f13437c;
    public View f13438d;
    private int f13439e;

    public View mo2576a(ViewGroup viewGroup) {
        this.f13435a = viewGroup.getContext();
        this.f13439e = ((gyr.m23306a() - gyr.m23307a((float) CloseButton.TEXT_SIZE_SP)) * 8) / 17;
        View inflate = View.inflate(viewGroup.getContext(), C0349R.layout.grid_item_sreaming_playlist, null);
        this.f13438d = inflate.findViewById(C0349R.id.artwork_area);
        this.f13436b = (CustomThemeImageView) inflate.findViewById(C0349R.id.artwork);
        this.f13438d.getLayoutParams().width = this.f13439e;
        this.f13437c = (TextView) inflate.findViewById(C0349R.id.track_name);
        return inflate;
    }

    public void mo2577a(gla com_ushareit_listenit_gla, boolean z, int i, int i2) {
        fsg com_ushareit_listenit_fsg = (fsg) com_ushareit_listenit_gla;
        this.f13437c.setText(com_ushareit_listenit_fsg.f13356b);
        this.f13438d.setOnClickListener(new ftb(this, i, com_ushareit_listenit_fsg));
        fzi.m21396a(this.f13435a, Uri.parse(com_ushareit_listenit_fsg.f13358d), this.f13436b, tv.NORMAL, this.f13439e, this.f13435a.getResources().getDrawable(C0349R.drawable.default_albumart_gray));
    }
}
