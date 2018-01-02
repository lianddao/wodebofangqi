package com.ushareit.listenit;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.view.C0052n;
import com.facebook.ads.internal.view.p003d.p004b.C0042j;
import com.facebook.ads.internal.view.p003d.p004b.C0043k;
import com.facebook.ads.internal.view.p003d.p004b.C0046p;
import com.mopub.mobileads.resource.DrawableConstants.CloseButton;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.util.HashMap;
import java.util.Map;

public class azh implements avo {
    private aru f5714a;
    private C0052n f5715b;
    private asq f5716c;
    private atf f5717d;
    private avp f5718e;
    private apo<avr> f5719f;
    private apo<avt> f5720g;
    private apo<awb> f5721h;
    private apo<awi> f5722i;
    private String f5723j;
    private Context f5724k;
    private String f5725l;
    private RelativeLayout f5726m;
    private TextView f5727n;
    private TextView f5728o;
    private ImageView f5729p;
    private C0046p f5730q;

    public azh(Context context, avp com_ushareit_listenit_avp) {
        this.f5724k = context;
        this.f5718e = com_ushareit_listenit_avp;
        m7426h();
    }

    private void m7426h() {
        float f = this.f5724k.getResources().getDisplayMetrics().density;
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f5715b = new C0052n(this.f5724k);
        this.f5715b.m1114h();
        this.f5715b.setAutoplay(true);
        this.f5715b.setIsFullScreen(true);
        this.f5715b.setLayoutParams(layoutParams);
        this.f5715b.setBackgroundColor(CtaButton.BACKGROUND_COLOR);
        this.f5722i = new azi(this);
        this.f5719f = new azj(this);
        this.f5720g = new azk(this);
        this.f5721h = new azl(this);
        this.f5715b.getEventBus().m6617a(this.f5719f);
        this.f5715b.getEventBus().m6617a(this.f5720g);
        this.f5715b.getEventBus().m6617a(this.f5721h);
        this.f5715b.getEventBus().m6617a(this.f5722i);
        this.f5715b.m1105a(new C0042j(this.f5724k));
        this.f5730q = new C0046p(this.f5724k, (int) (6.0f * f));
        layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f5730q.setLayoutParams(layoutParams);
        this.f5715b.m1105a(this.f5730q);
        if (app.m6628j(this.f5724k)) {
            axy c0043k = new C0043k(this.f5724k);
            this.f5715b.m1105a(c0043k);
            this.f5715b.m1105a(new awx(c0043k, axg.INVSIBLE));
        }
        if (app.m6621c(this.f5724k)) {
            Drawable gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{0, -15658735});
            gradientDrawable.setCornerRadius(0.0f);
            LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            this.f5726m = new RelativeLayout(this.f5724k);
            if (VERSION.SDK_INT >= 16) {
                this.f5726m.setBackground(gradientDrawable);
            } else {
                this.f5726m.setBackgroundDrawable(gradientDrawable);
            }
            this.f5726m.setLayoutParams(layoutParams2);
            this.f5726m.setPadding((int) (16.0f * f), 0, (int) (16.0f * f), (int) (CloseButton.TEXT_SIZE_SP * f));
            this.f5727n = new TextView(this.f5724k);
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            layoutParams.addRule(4);
            this.f5727n.setEllipsize(TruncateAt.END);
            this.f5727n.setGravity(8388611);
            this.f5727n.setLayoutParams(layoutParams);
            this.f5727n.setMaxLines(1);
            this.f5727n.setPadding((int) (72.0f * f), 0, 0, (int) (30.0f * f));
            this.f5727n.setTextColor(-1);
            this.f5727n.setTextSize(CloseButton.TEXT_SIZE_SP);
            this.f5728o = new TextView(this.f5724k);
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            this.f5728o.setEllipsize(TruncateAt.END);
            this.f5728o.setGravity(8388611);
            this.f5728o.setLayoutParams(layoutParams);
            this.f5728o.setMaxLines(2);
            this.f5728o.setPadding((int) (72.0f * f), 0, 0, 0);
            this.f5728o.setTextColor(-1);
            this.f5729p = new ImageView(this.f5724k);
            layoutParams = new RelativeLayout.LayoutParams((int) (60.0f * f), (int) (f * 60.0f));
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            this.f5729p.setLayoutParams(layoutParams);
            this.f5726m.addView(this.f5729p);
            this.f5726m.addView(this.f5727n);
            this.f5726m.addView(this.f5728o);
            axy com_ushareit_listenit_awx = new awx(new RelativeLayout(this.f5724k), axg.INVSIBLE);
            com_ushareit_listenit_awx.m7275a(this.f5726m, axg.INVSIBLE);
            this.f5715b.m1105a(com_ushareit_listenit_awx);
        }
        this.f5714a = new aru(this.f5715b, 1, new azm(this));
        this.f5714a.m6934a(250);
        this.f5717d = new atf();
        this.f5718e.mo156a(this.f5715b);
        if (this.f5726m != null) {
            this.f5718e.mo156a(this.f5726m);
        }
        this.f5718e.mo156a(this.f5730q);
    }

    public Map<String, String> m7427a() {
        return this.f5717d.m7125e();
    }

    public void mo712a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        String stringExtra = intent.getStringExtra("videoURL");
        this.f5723j = intent.getStringExtra("clientToken");
        this.f5725l = intent.getStringExtra("contextSwitchBehavior");
        if (this.f5727n != null) {
            this.f5727n.setText(intent.getStringExtra("adTitle"));
        }
        if (this.f5728o != null) {
            this.f5728o.setText(intent.getStringExtra("adSubtitle"));
        }
        if (this.f5729p != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("adIconUrl"))) {
                new aum(this.f5729p).m7211a(r1);
            }
        }
        this.f5716c = new asq(this.f5724k, apb.m6565a(this.f5724k), this.f5715b, this.f5723j);
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f5715b.setVideoURI(stringExtra);
        }
        this.f5715b.mo151d();
    }

    public void mo713a(Bundle bundle) {
    }

    public void mo714a(avp com_ushareit_listenit_avp) {
    }

    public void mo674b() {
        m7435f();
        this.f5727n = null;
        this.f5728o = null;
        this.f5729p = null;
        this.f5726m = null;
        this.f5725l = null;
        this.f5719f = null;
        this.f5720g = null;
        this.f5721h = null;
        this.f5722i = null;
        this.f5714a = null;
        this.f5717d = null;
        this.f5716c = null;
        this.f5715b = null;
        this.f5718e = null;
        this.f5723j = null;
        this.f5724k = null;
        this.f5730q.m1041a();
        this.f5730q = null;
    }

    public void m7432c() {
        this.f5715b.m1103a(1);
        this.f5715b.mo151d();
    }

    public void m7433d() {
        this.f5715b.m1111e();
    }

    public boolean m7434e() {
        return this.f5715b.getState() == ayk.PAUSED;
    }

    public void m7435f() {
        if (this.f5715b != null) {
            this.f5715b.m1113g();
        }
        if (this.f5714a != null) {
            this.f5714a.m6936b();
        }
    }

    public void m7436g() {
        this.f5715b.m1103a(this.f5715b.getCurrentPosition());
        this.f5715b.mo151d();
    }

    public void mo716i() {
        m7433d();
    }

    public void mo717j() {
        if (!m7434e()) {
            return;
        }
        if (this.f5725l.equals("restart")) {
            m7432c();
        } else if (this.f5725l.equals("resume")) {
            m7436g();
        } else if (this.f5725l.equals("skip")) {
            this.f5718e.mo158a(art.REWARDED_VIDEO_COMPLETE_WITHOUT_REWARD.m6913a(), new avr());
            m7435f();
        } else if (this.f5725l.equals("endvideo")) {
            this.f5718e.mo157a(art.REWARDED_VIDEO_END_ACTIVITY.m6913a());
            Map hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.f5723j)) {
                this.f5714a.m6935a(hashMap);
                hashMap.put("touch", atz.m7161a(m7427a()));
                apb.m6565a(this.f5724k).mo749e(this.f5723j, hashMap);
            }
            m7435f();
        }
    }
}
