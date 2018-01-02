package com.ushareit.listenit.popupview;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fii;
import com.ushareit.listenit.gla;
import com.ushareit.listenit.gqx;
import com.ushareit.listenit.gqy;
import com.ushareit.listenit.gqz;
import com.ushareit.listenit.gum;
import com.ushareit.listenit.hbo;
import com.ushareit.listenit.theme.entry.CustomThemeTextView;
import com.ushareit.listenit.widget.EmotionRatingBar;

public class RatePopupView extends BasePopupView {
    private TextView f16257a;
    private CustomThemeTextView f16258b;
    private TextView f16259c;
    private EmotionRatingBar f16260d;
    private hbo f16261e = new gqx(this);
    private OnClickListener f16262f = new gqy(this);
    private OnClickListener f16263g = new gqz(this);

    public RatePopupView(Context context) {
        super(context);
        m25631a(context, this);
    }

    public void m25631a(Context context, ViewGroup viewGroup) {
        View inflate = View.inflate(context, C0349R.layout.popup_view_rate, viewGroup);
        this.f16257a = (TextView) inflate.findViewById(C0349R.id.desc);
        this.f16260d = (EmotionRatingBar) inflate.findViewById(C0349R.id.rating_bar);
        this.f16258b = (CustomThemeTextView) inflate.findViewById(C0349R.id.later);
        this.f16259c = (TextView) inflate.findViewById(C0349R.id.feedback);
        this.f16258b.setOnClickListener(this.f16262f);
        this.f16259c.setOnClickListener(this.f16263g);
        this.f16260d.setOnRatingBarChangeListener(this.f16261e);
        fii.m19297a(context, "rateus", "from_navigation");
    }

    public void mo2995a(gum com_ushareit_listenit_gum) {
        super.mo2995a(com_ushareit_listenit_gum);
    }

    public void mo2996b() {
        super.mo2996b();
    }

    public void mo2997c() {
        super.mo2997c();
    }

    public int getGravity() {
        return 17;
    }

    public void setItem(gla com_ushareit_listenit_gla) {
    }

    public void setTitle(String str) {
    }
}
