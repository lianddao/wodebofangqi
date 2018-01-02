package com.ushareit.listenit.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ListenItApp;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fjw;
import com.ushareit.listenit.fqo;
import com.ushareit.listenit.gal;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.hbz;
import com.ushareit.listenit.hca;
import com.ushareit.listenit.hcb;
import com.ushareit.listenit.hcc;
import com.ushareit.listenit.hcd;

public class MainActionBar extends FrameLayout {
    private ImageView f17255a;
    private ImageView f17256b;
    private gal f17257c;
    private View f17258d;
    private View f17259e;
    private View f17260f;
    private hcd f17261g;
    private TextView f17262h;
    private TextView f17263i;
    private View f17264j;
    private View f17265k;
    private View f17266l;
    private fjw f17267m = new hca(this);
    private OnClickListener f17268n = new hcb(this);
    private OnClickListener f17269o = new hcc(this);

    public MainActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26858a(context);
    }

    public MainActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26858a(context);
    }

    public MainActionBar(Context context) {
        super(context);
        m26858a(context);
    }

    private void m26858a(Context context) {
        View inflate = View.inflate(context, C0349R.layout.main_action_bar, this);
        if (inflate != null) {
            View findViewById = inflate.findViewById(C0349R.id.actionbar_bg);
            View findViewById2 = inflate.findViewById(C0349R.id.actionbar_content);
            this.f17255a = (ImageView) inflate.findViewById(C0349R.id.home);
            this.f17256b = (ImageView) inflate.findViewById(C0349R.id.search);
            this.f17258d = inflate.findViewById(C0349R.id.action_bar_red_point);
            this.f17266l = inflate.findViewById(C0349R.id.app_logo);
            this.f17260f = inflate.findViewById(C0349R.id.all_songs);
            this.f17259e = inflate.findViewById(C0349R.id.discovery);
            this.f17262h = (TextView) inflate.findViewById(C0349R.id.all_songs_text);
            this.f17263i = (TextView) inflate.findViewById(C0349R.id.discovery_text);
            this.f17264j = inflate.findViewById(C0349R.id.all_songs_indicator);
            this.f17265k = inflate.findViewById(C0349R.id.discovery_indicator);
            if (gyn.m23217b()) {
                int e = fbb.m18766e(getContext());
                gyn.m23237e(findViewById2, e);
                gyn.m23224c(findViewById, e + ((int) (((double) getResources().getDimension(C0349R.dimen.common_dimens_50dp)) + 0.5d)));
            }
            if (fqo.m20421c()) {
                this.f17259e.setOnClickListener(this.f17268n);
                this.f17260f.setOnClickListener(this.f17269o);
                this.f17265k.setVisibility(8);
                return;
            }
            this.f17259e.setVisibility(8);
            this.f17260f.setVisibility(8);
            this.f17266l.setVisibility(0);
        }
    }

    public void m26868a(int i) {
        post(new hbz(this, i));
    }

    public void setSearchVisibility(int i) {
        if (i == 0) {
            this.f17256b.setVisibility(0);
            this.f17256b.setOnClickListener(this.f17267m);
            return;
        }
        this.f17256b.setVisibility(8);
        this.f17256b.setOnClickListener(null);
    }

    public void setListParams(gal com_ushareit_listenit_gal) {
        this.f17257c = com_ushareit_listenit_gal;
    }

    public int getActionBarHeight() {
        return getHeight();
    }

    public void setOnHomeClickListener(OnClickListener onClickListener) {
        this.f17255a.setOnClickListener(onClickListener);
    }

    public void setOnTabClickListener(hcd com_ushareit_listenit_hcd) {
        this.f17261g = com_ushareit_listenit_hcd;
    }

    public void m26867a() {
        this.f17258d.setVisibility(0);
        m26861c();
    }

    public void m26870b() {
        this.f17258d.setVisibility(8);
        this.f17258d.clearAnimation();
    }

    private void m26861c() {
        Animation scaleAnimation = new ScaleAnimation(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 1.2f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 1.2f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setRepeatCount(MoPubClientPositioning.NO_REPEAT);
        scaleAnimation.setRepeatMode(2);
        this.f17258d.startAnimation(scaleAnimation);
    }

    public void m26871b(int i) {
        m26869a(i, 0.0f);
    }

    public void m26869a(int i, float f) {
        int color;
        int color2;
        switch (((ListenItApp) getContext().getApplicationContext()).m4934b()) {
            case 1:
                color = getResources().getColor(C0349R.color.common_white_20_night);
                color2 = getResources().getColor(C0349R.color.common_white_60_night);
                break;
            default:
                color = getResources().getColor(C0349R.color.main_actionbar_unselected_color);
                color2 = getResources().getColor(C0349R.color.main_actionbar_selected_color);
                break;
        }
        int alpha = (int) (((float) (Color.alpha(color2) - Color.alpha(color))) * f);
        int argb = Color.argb(Color.alpha(color2) - alpha, 255, 255, 255);
        alpha = Color.argb(alpha + Color.alpha(color), 255, 255, 255);
        if (i == 0) {
            this.f17262h.setTextColor(argb);
            this.f17263i.setTextColor(alpha);
            if (((double) f) >= 0.5d) {
                this.f17264j.setVisibility(8);
                this.f17265k.setVisibility(0);
                return;
            }
            this.f17264j.setVisibility(0);
            this.f17265k.setVisibility(8);
            return;
        }
        this.f17262h.setTextColor(color);
        this.f17263i.setTextColor(color2);
    }
}
