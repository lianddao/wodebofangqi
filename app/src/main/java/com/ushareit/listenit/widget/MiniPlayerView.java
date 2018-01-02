package com.ushareit.listenit.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fez;
import com.ushareit.listenit.fzi;
import com.ushareit.listenit.glg;
import com.ushareit.listenit.gum;
import com.ushareit.listenit.gvj;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.hbj;
import com.ushareit.listenit.hbv;
import com.ushareit.listenit.hce;
import com.ushareit.listenit.hcf;
import com.ushareit.listenit.hcg;
import com.ushareit.listenit.hci;
import com.ushareit.listenit.tv;

public class MiniPlayerView extends FrameLayout implements hbj {
    private static String f17270a = "MiniPlayerView";
    private ProgressBar f17271b;
    private TextView f17272c;
    private ImageView f17273d;
    private View f17274e;
    private gum f17275f;
    private int f17276g;
    private LISTENitViewFlipper f17277h;
    private long f17278i = -1;
    private ImageView f17279j;
    private boolean f17280k = false;
    private boolean f17281l = false;
    private OnClickListener f17282m = new hcf(this);
    private OnClickListener f17283n = new hcg(this);
    private hbv f17284o = new hci(this);

    public MiniPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26888a(context);
    }

    public MiniPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26888a(context);
    }

    public MiniPlayerView(Context context) {
        super(context);
        m26888a(context);
    }

    public void m26888a(Context context) {
        View inflate = View.inflate(context, C0349R.layout.player_minimal_view, this);
        this.f17273d = (ImageView) inflate.findViewById(C0349R.id.play);
        this.f17274e = inflate.findViewById(C0349R.id.playlist);
        this.f17272c = (TextView) inflate.findViewById(C0349R.id.welcome);
        this.f17271b = (ProgressBar) inflate.findViewById(C0349R.id.progress_bar);
        this.f17277h = (LISTENitViewFlipper) inflate.findViewById(C0349R.id.view_flipper);
        this.f17279j = (ImageView) inflate.findViewById(C0349R.id.circle);
        this.f17273d.setOnClickListener(this.f17282m);
        this.f17274e.setOnClickListener(this.f17283n);
        this.f17277h.setOnPlayerDiscListener(this.f17284o);
        this.f17277h.setScrollDuration(250);
        this.f17276g = (int) context.getResources().getDimension(C0349R.dimen.common_dimens_55dp);
        fez.m19056a(context).m19067a(inflate);
        this.f17280k = true;
        if (this.f17281l) {
            fez.m19056a(context).m19069b();
        }
    }

    public void m26893b(gum com_ushareit_listenit_gum) {
        this.f17275f = com_ushareit_listenit_gum;
        if (!gvj.m22985j(getContext())) {
            m26883g();
        } else if (com_ushareit_listenit_gum.mo2425a()) {
            m26884h();
            m26882f();
            this.f17278i = com_ushareit_listenit_gum.mo2464u();
        } else if (com_ushareit_listenit_gum.mo2462s() > 0) {
            m26874a(this.f17277h.getCurrentView(), com_ushareit_listenit_gum.mo2465v(), false);
            m26879c(false);
            this.f17278i = com_ushareit_listenit_gum.mo2464u();
        }
        this.f17281l = true;
        if (this.f17280k) {
            fez.m19056a(getContext()).m19069b();
        }
    }

    public void mo3119a(gum com_ushareit_listenit_gum) {
        if (com_ushareit_listenit_gum == null) {
            return;
        }
        if (com_ushareit_listenit_gum.mo2462s() == 0) {
            m26883g();
            m26879c(false);
            return;
        }
        m26874a(this.f17277h.getCurrentView(), com_ushareit_listenit_gum.mo2465v(), false);
        m26879c(com_ushareit_listenit_gum.mo2425a());
        this.f17278i = com_ushareit_listenit_gum.mo2464u();
    }

    public void mo2503a(boolean z) {
        if (this.f17275f != null) {
            if (this.f17272c.isShown()) {
                m26884h();
            }
            if (!z) {
                if (this.f17275f.mo2464u() != this.f17278i) {
                    this.f17277h.m26850a(true);
                } else {
                    m26879c(true);
                }
                this.f17278i = this.f17275f.mo2464u();
            } else if (this.f17278i != this.f17275f.mo2464u()) {
                this.f17277h.m26850a(true);
            } else {
                m26879c(true);
            }
        }
    }

    public void f_() {
        m26879c(false);
    }

    public void mo2504b() {
        m26879c(false);
    }

    public void mo2505c() {
        m26879c(false);
    }

    public void mo2482a() {
        m26879c(false);
        m26883g();
    }

    public void m26887a(int i, int i2) {
        if (i >= 0 && i2 > 0) {
            this.f17271b.setProgress((int) (((((float) i) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) i2)) * ((float) this.f17271b.getMax())));
        }
    }

    public void m26894b(boolean z) {
        if (z) {
            m26880d();
        } else {
            m26881e();
        }
    }

    private void m26880d() {
        this.f17279j.setImageResource(C0349R.drawable.miniplayer_semicircle_normal);
        this.f17279j.setVisibility(0);
        Animation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(1000);
        this.f17279j.startAnimation(rotateAnimation);
    }

    private void m26881e() {
        this.f17279j.setImageResource(C0349R.drawable.miniplayer_play_circle_bg);
        this.f17279j.clearAnimation();
    }

    public void m26886a(int i) {
        if (this.f17271b != null) {
            this.f17271b.setSecondaryProgress((this.f17271b.getMax() * i) / 100);
        }
    }

    public void m26890a(String str) {
        if (this.f17275f != null && !fbb.m18763c(str) && this.f17275f.mo2465v() != null && this.f17275f.mo2465v().f14340h.equals(str)) {
            m26874a(this.f17277h.getCurrentView(), this.f17275f.mo2465v(), true);
        }
    }

    public void setOnMiniPlayerClickListener(OnClickListener onClickListener) {
        this.f17277h.setOnClickListener(onClickListener);
    }

    private void m26882f() {
        this.f17273d.setImageResource(C0349R.drawable.miniplayer_pause_bg);
        postDelayed(new hce(this), 400);
    }

    private void m26874a(View view, glg com_ushareit_listenit_glg, boolean z) {
        view.setVisibility(0);
        Long l = (Long) view.getTag();
        if (l == null || l.longValue() != com_ushareit_listenit_glg.f14334b || z) {
            view.setTag(Long.valueOf(com_ushareit_listenit_glg.f14334b));
            ImageView imageView = (ImageView) view.findViewById(C0349R.id.ablumart);
            TextView textView = (TextView) view.findViewById(C0349R.id.song_name);
            TextView textView2 = (TextView) view.findViewById(C0349R.id.artist_name);
            textView.setText(com_ushareit_listenit_glg.f14338f);
            textView2.setText(com_ushareit_listenit_glg.f14339g);
            if (gzd.m23364e() == 1) {
                textView.setTextColor(getResources().getColor(C0349R.color.common_text_color_black_night));
                textView2.setTextColor(getResources().getColor(C0349R.color.common_text_color_gray_night));
            } else {
                textView.setTextColor(getResources().getColor(C0349R.color.common_text_color_black));
                textView2.setTextColor(getResources().getColor(C0349R.color.common_text_color_black));
            }
            fzi.m21401a(getContext(), com_ushareit_listenit_glg, imageView, tv.HIGH, this.f17276g);
        }
    }

    private void m26883g() {
        this.f17277h.setVisibility(4);
        this.f17272c.setVisibility(0);
        this.f17271b.setProgress(0);
        this.f17271b.setSecondaryProgress(0);
        gvj.m22912b(getContext(), false);
    }

    private void m26884h() {
        this.f17277h.setVisibility(0);
        this.f17272c.setVisibility(8);
        if (!gvj.m22985j(getContext())) {
            gvj.m22912b(getContext(), true);
        }
    }

    private void m26879c(boolean z) {
        if (this.f17275f != null) {
            this.f17273d.setImageResource(z ? C0349R.drawable.miniplayer_pause_bg : C0349R.drawable.miniplayer_play_bg);
            if (this.f17275f.mo2462s() != 0) {
                TextView textView = (TextView) this.f17277h.getCurrentView().findViewById(C0349R.id.artist_name);
                if (gvj.m22977i(getContext())) {
                    textView.setText(this.f17275f.mo2465v().f14339g);
                    if (gzd.m23364e() == 1) {
                        textView.setTextColor(getResources().getColor(C0349R.color.common_text_color_gray_night));
                        return;
                    } else {
                        textView.setTextColor(getResources().getColor(C0349R.color.common_text_color_black));
                        return;
                    }
                }
                textView.setText(getResources().getString(C0349R.string.miniplayer_drag_hint));
                switch (gzd.m23364e()) {
                    case 1:
                        textView.setTextColor(getResources().getColor(C0349R.color.miniplayer_common_orange));
                        return;
                    case 2:
                        textView.setTextColor(gzd.m23358b());
                        return;
                    default:
                        textView.setTextColor(getResources().getColor(C0349R.color.common_text_color_orange));
                        return;
                }
            }
        }
    }
}
