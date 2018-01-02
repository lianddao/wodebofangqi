package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.C0064v;
import com.facebook.ads.internal.view.p002c.C0029a;
import com.facebook.ads.internal.view.p003d.p004b.C0033a.C0031a;
import com.facebook.ads.internal.view.p003d.p004b.C0037f;
import com.facebook.ads.internal.view.p003d.p004b.C0041i;
import com.facebook.ads.internal.view.p003d.p004b.C0042j;
import com.facebook.ads.internal.view.p003d.p004b.C0043k;
import com.facebook.ads.internal.view.p003d.p004b.C0045o;
import com.mopub.mobileads.resource.DrawableConstants.CloseButton;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.mopub.mobileads.resource.DrawableConstants.RadialCountdown;
import com.umeng.analytics.pro.C0321x;
import org.json.JSONObject;

public class aly extends alq implements OnTouchListener, avo {
    static final /* synthetic */ boolean f4729h = (!aly.class.desiredAssertionStatus());
    final int f4730e = 64;
    final int f4731f = 64;
    final int f4732g = 16;
    private avp f4733i;
    private Activity f4734j;
    private C0064v f4735k = new alz(this);
    private final OnTouchListener f4736l = new ama(this);
    private alx f4737m = alx.UNSPECIFIED;
    private C0029a f4738n;
    private TextView f4739o;
    private TextView f4740p;
    private ImageView f4741q;
    private C0031a f4742r;
    private C0045o f4743s;
    private ViewGroup f4744t;
    private awx f4745u;
    private C0041i f4746v;
    private int f4747w = -1;
    private int f4748x = -10525069;
    private int f4749y = -12286980;
    private boolean f4750z = false;

    private void m6126a(int i) {
        View linearLayout;
        float f = this.c.getResources().getDisplayMetrics().density;
        LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (56.0f * f), (int) (56.0f * f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        int i2 = (int) (16.0f * f);
        this.f4746v.setPadding(i2, i2, i2, i2);
        this.f4746v.setLayoutParams(layoutParams);
        axg com_ushareit_listenit_axg = m6141h() ? axg.FADE_OUT_ON_PLAY : axg.VISIBLE;
        int id = this.a.getId();
        if (i == 1 && (m6131m() || m6132n())) {
            Drawable gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{0, -15658735});
            gradientDrawable.setCornerRadius(0.0f);
            LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(10);
            this.a.setLayoutParams(layoutParams2);
            m6127a(this.a);
            m6127a(this.f4746v);
            m6127a(this.f4742r);
            LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (((float) (((((this.f4738n != null ? 64 : 0) + 60) + 16) + 16) + 16)) * f));
            layoutParams3.addRule(12);
            View relativeLayout = new RelativeLayout(this.c);
            relativeLayout.setBackground(gradientDrawable);
            relativeLayout.setLayoutParams(layoutParams3);
            relativeLayout.setPadding(i2, 0, i2, (int) (((float) (((this.f4738n != null ? 64 : 0) + 16) + 16)) * f));
            this.f4744t = relativeLayout;
            if (!this.f4750z) {
                this.f4745u.m7275a(relativeLayout, com_ushareit_listenit_axg);
            }
            m6127a(relativeLayout);
            if (this.f4743s != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, (int) (6.0f * f));
                layoutParams.addRule(12);
                layoutParams.topMargin = (int) (-6.0f * f);
                this.f4743s.setLayoutParams(layoutParams);
                m6127a(this.f4743s);
            }
            if (this.f4738n != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, (int) (64.0f * f));
                layoutParams.bottomMargin = (int) (16.0f * f);
                layoutParams.leftMargin = (int) (16.0f * f);
                layoutParams.rightMargin = (int) (16.0f * f);
                layoutParams.addRule(14);
                layoutParams.addRule(12);
                this.f4738n.setLayoutParams(layoutParams);
                m6127a(this.f4738n);
            }
            if (this.f4741q != null) {
                layoutParams = new RelativeLayout.LayoutParams((int) (60.0f * f), (int) (60.0f * f));
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                this.f4741q.setLayoutParams(layoutParams);
                m6128a(relativeLayout, this.f4741q);
            }
            if (this.f4739o != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.bottomMargin = (int) (36.0f * f);
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                this.f4739o.setEllipsize(TruncateAt.END);
                this.f4739o.setGravity(8388611);
                this.f4739o.setLayoutParams(layoutParams);
                this.f4739o.setMaxLines(1);
                this.f4739o.setPadding((int) (72.0f * f), 0, 0, 0);
                this.f4739o.setTextColor(-1);
                this.f4739o.setTextSize(RadialCountdown.TEXT_SIZE_SP);
                m6128a(relativeLayout, this.f4739o);
            }
            if (this.f4740p != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                layoutParams.bottomMargin = (int) (4.0f * f);
                this.f4740p.setEllipsize(TruncateAt.END);
                this.f4740p.setGravity(8388611);
                this.f4740p.setLayoutParams(layoutParams);
                this.f4740p.setMaxLines(1);
                this.f4740p.setPadding((int) (72.0f * f), 0, 0, 0);
                this.f4740p.setTextColor(-1);
                m6128a(relativeLayout, this.f4740p);
            }
            ((ViewGroup) this.a.getParent()).setBackgroundColor(CtaButton.BACKGROUND_COLOR);
        } else if (i == 1) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(10);
            this.a.setLayoutParams(layoutParams);
            m6127a(this.a);
            m6127a(this.f4746v);
            m6127a(this.f4742r);
            linearLayout = new LinearLayout(this.c);
            this.f4744t = linearLayout;
            linearLayout.setGravity(112);
            linearLayout.setOrientation(1);
            r4 = new RelativeLayout.LayoutParams(-1, -1);
            r4.leftMargin = (int) (33.0f * f);
            r4.rightMargin = (int) (33.0f * f);
            r4.topMargin = (int) (CloseButton.STROKE_WIDTH * f);
            if (this.f4738n == null) {
                r4.bottomMargin = (int) (16.0f * f);
            } else {
                r4.bottomMargin = (int) (80.0f * f);
            }
            r4.addRule(3, id);
            linearLayout.setLayoutParams(r4);
            m6127a(linearLayout);
            if (this.f4738n != null) {
                r4 = new RelativeLayout.LayoutParams(-1, (int) (64.0f * f));
                r4.bottomMargin = (int) (16.0f * f);
                r4.leftMargin = (int) (33.0f * f);
                r4.rightMargin = (int) (33.0f * f);
                r4.addRule(14);
                r4.addRule(12);
                this.f4738n.setLayoutParams(r4);
                m6127a(this.f4738n);
            }
            if (this.f4739o != null) {
                r4 = new LinearLayout.LayoutParams(-2, -2);
                r4.weight = 2.0f;
                r4.gravity = 17;
                this.f4739o.setEllipsize(TruncateAt.END);
                this.f4739o.setGravity(17);
                this.f4739o.setLayoutParams(r4);
                this.f4739o.setMaxLines(2);
                this.f4739o.setPadding(0, 0, 0, 0);
                this.f4739o.setTextColor(this.f4748x);
                this.f4739o.setTextSize(24.0f);
                m6128a(linearLayout, this.f4739o);
            }
            if (this.f4741q != null) {
                r4 = new LinearLayout.LayoutParams((int) (64.0f * f), (int) (64.0f * f));
                r4.weight = 0.0f;
                r4.gravity = 17;
                this.f4741q.setLayoutParams(r4);
                m6128a(linearLayout, this.f4741q);
            }
            if (this.f4740p != null) {
                r4 = new LinearLayout.LayoutParams(-1, -2);
                r4.weight = 2.0f;
                r4.gravity = 16;
                this.f4740p.setEllipsize(TruncateAt.END);
                this.f4740p.setGravity(16);
                this.f4740p.setLayoutParams(r4);
                this.f4740p.setMaxLines(2);
                this.f4740p.setPadding(0, 0, 0, 0);
                this.f4740p.setTextColor(this.f4748x);
                m6128a(linearLayout, this.f4740p);
            }
            if (this.f4743s != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, (int) (6.0f * f));
                layoutParams.addRule(3, id);
                this.f4743s.setLayoutParams(layoutParams);
                m6127a(this.f4743s);
            }
            ((ViewGroup) this.a.getParent()).setBackgroundColor(this.f4747w);
        } else if (!m6133o() || m6132n()) {
            Drawable gradientDrawable2 = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{0, -15658735});
            gradientDrawable2.setCornerRadius(0.0f);
            this.a.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            m6127a(this.a);
            m6127a(this.f4746v);
            m6127a(this.f4742r);
            LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, (int) (124.0f * f));
            layoutParams4.addRule(12);
            View relativeLayout2 = new RelativeLayout(this.c);
            relativeLayout2.setBackground(gradientDrawable2);
            relativeLayout2.setLayoutParams(layoutParams4);
            relativeLayout2.setPadding(i2, 0, i2, i2);
            this.f4744t = relativeLayout2;
            if (!this.f4750z) {
                this.f4745u.m7275a(relativeLayout2, com_ushareit_listenit_axg);
            }
            m6127a(relativeLayout2);
            if (this.f4738n != null) {
                layoutParams = new RelativeLayout.LayoutParams((int) (110.0f * f), (int) (56.0f * f));
                layoutParams.rightMargin = (int) (16.0f * f);
                layoutParams.bottomMargin = (int) (16.0f * f);
                layoutParams.addRule(12);
                layoutParams.addRule(11);
                this.f4738n.setLayoutParams(layoutParams);
                m6127a(this.f4738n);
            }
            if (this.f4741q != null) {
                layoutParams = new RelativeLayout.LayoutParams((int) (64.0f * f), (int) (64.0f * f));
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                layoutParams.bottomMargin = (int) (CloseButton.STROKE_WIDTH * f);
                this.f4741q.setLayoutParams(layoutParams);
                m6128a(relativeLayout2, this.f4741q);
            }
            if (this.f4739o != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.bottomMargin = (int) (48.0f * f);
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                this.f4739o.setEllipsize(TruncateAt.END);
                this.f4739o.setGravity(8388611);
                this.f4739o.setLayoutParams(layoutParams);
                this.f4739o.setMaxLines(1);
                this.f4739o.setPadding((int) (80.0f * f), 0, this.f4738n != null ? (int) (126.0f * f) : 0, 0);
                this.f4739o.setTextColor(-1);
                this.f4739o.setTextSize(24.0f);
                m6128a(relativeLayout2, this.f4739o);
            }
            if (this.f4740p != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                this.f4740p.setEllipsize(TruncateAt.END);
                this.f4740p.setGravity(8388611);
                this.f4740p.setLayoutParams(layoutParams);
                this.f4740p.setMaxLines(2);
                this.f4740p.setTextColor(-1);
                this.f4740p.setPadding((int) (80.0f * f), 0, this.f4738n != null ? (int) (126.0f * f) : 0, 0);
                m6128a(relativeLayout2, this.f4740p);
            }
            if (this.f4743s != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, (int) (6.0f * f));
                layoutParams.addRule(12);
                this.f4743s.setLayoutParams(layoutParams);
                m6127a(this.f4743s);
            }
            ((ViewGroup) this.a.getParent()).setBackgroundColor(CtaButton.BACKGROUND_COLOR);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams.addRule(9);
            this.a.setLayoutParams(layoutParams);
            m6127a(this.a);
            m6127a(this.f4746v);
            m6127a(this.f4742r);
            linearLayout = new LinearLayout(this.c);
            this.f4744t = linearLayout;
            linearLayout.setGravity(112);
            linearLayout.setOrientation(1);
            r4 = new RelativeLayout.LayoutParams(-1, -1);
            r4.leftMargin = (int) (16.0f * f);
            r4.rightMargin = (int) (16.0f * f);
            r4.topMargin = (int) (CloseButton.STROKE_WIDTH * f);
            r4.bottomMargin = (int) (80.0f * f);
            r4.addRule(1, id);
            linearLayout.setLayoutParams(r4);
            m6127a(linearLayout);
            if (this.f4743s != null) {
                r4 = new RelativeLayout.LayoutParams(-1, (int) (6.0f * f));
                r4.addRule(5, id);
                r4.addRule(7, id);
                r4.addRule(3, id);
                r4.topMargin = (int) (-6.0f * f);
                this.f4743s.setLayoutParams(r4);
                m6127a(this.f4743s);
            }
            if (this.f4739o != null) {
                r4 = new LinearLayout.LayoutParams(-2, -2);
                r4.weight = 2.0f;
                r4.gravity = 17;
                this.f4739o.setEllipsize(TruncateAt.END);
                this.f4739o.setGravity(17);
                this.f4739o.setLayoutParams(r4);
                this.f4739o.setMaxLines(10);
                this.f4739o.setPadding(0, 0, 0, 0);
                this.f4739o.setTextColor(this.f4748x);
                this.f4739o.setTextSize(24.0f);
                m6128a(linearLayout, this.f4739o);
            }
            if (this.f4741q != null) {
                r4 = new LinearLayout.LayoutParams((int) (64.0f * f), (int) (64.0f * f));
                r4.weight = 0.0f;
                r4.gravity = 17;
                this.f4741q.setLayoutParams(r4);
                m6128a(linearLayout, this.f4741q);
            }
            if (this.f4740p != null) {
                r4 = new LinearLayout.LayoutParams(-1, -2);
                r4.weight = 2.0f;
                r4.gravity = 16;
                this.f4740p.setEllipsize(TruncateAt.END);
                this.f4740p.setGravity(17);
                this.f4740p.setLayoutParams(r4);
                this.f4740p.setMaxLines(10);
                this.f4740p.setPadding(0, 0, 0, 0);
                this.f4740p.setTextColor(this.f4748x);
                m6128a(linearLayout, this.f4740p);
            }
            if (this.f4738n != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, (int) (64.0f * f));
                layoutParams.bottomMargin = (int) (16.0f * f);
                layoutParams.leftMargin = (int) (16.0f * f);
                layoutParams.rightMargin = (int) (16.0f * f);
                layoutParams.addRule(14);
                layoutParams.addRule(12);
                layoutParams.addRule(1, id);
                this.f4738n.setLayoutParams(layoutParams);
                m6127a(this.f4738n);
            }
            ((ViewGroup) this.a.getParent()).setBackgroundColor(this.f4747w);
        }
        linearLayout = this.a.getRootView();
        if (linearLayout != null) {
            linearLayout.setOnTouchListener(this);
        }
    }

    private void m6127a(View view) {
        if (this.f4733i != null) {
            this.f4733i.mo156a(view);
        }
    }

    private void m6128a(ViewGroup viewGroup, View view) {
        if (viewGroup != null) {
            viewGroup.addView(view);
        }
    }

    private void m6130b(View view) {
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
    }

    private boolean m6131m() {
        return ((double) (this.a.getVideoHeight() > 0 ? ((float) this.a.getVideoWidth()) / ((float) this.a.getVideoHeight()) : -1.0f)) <= 0.9d;
    }

    private boolean m6132n() {
        if (this.a.getVideoHeight() <= 0) {
            return false;
        }
        Rect rect = new Rect();
        float f = this.c.getResources().getDisplayMetrics().density;
        this.f4734j.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        if (rect.width() > rect.height()) {
            return ((float) (rect.width() - ((rect.height() * this.a.getVideoWidth()) / this.a.getVideoHeight()))) - (f * 192.0f) < 0.0f;
        } else {
            return ((((float) (rect.height() - ((rect.width() * this.a.getVideoHeight()) / this.a.getVideoWidth()))) - (64.0f * f)) - (64.0f * f)) - (f * 40.0f) < 0.0f;
        }
    }

    private boolean m6133o() {
        float videoWidth = this.a.getVideoHeight() > 0 ? ((float) this.a.getVideoWidth()) / ((float) this.a.getVideoHeight()) : -1.0f;
        return ((double) videoWidth) > 0.9d && ((double) videoWidth) < 1.1d;
    }

    private void m6134p() {
        m6130b(this.a);
        m6130b(this.f4738n);
        m6130b(this.f4739o);
        m6130b(this.f4740p);
        m6130b(this.f4741q);
        m6130b(this.f4742r);
        m6130b(this.f4743s);
        m6130b(this.f4744t);
        m6130b(this.f4746v);
    }

    @TargetApi(17)
    public void mo712a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        this.f4734j = audienceNetworkActivity;
        if (f4729h || this.f4733i != null) {
            audienceNetworkActivity.m807a(this.f4735k);
            m6134p();
            m6126a(this.f4734j.getResources().getConfiguration().orientation);
            if (m6141h()) {
                mo707f();
                return;
            } else {
                m6085g();
                return;
            }
        }
        throw new AssertionError();
    }

    public void m6136a(Configuration configuration) {
        m6134p();
        m6126a(configuration.orientation);
    }

    public void mo713a(Bundle bundle) {
    }

    public void mo714a(avp com_ushareit_listenit_avp) {
        this.f4733i = com_ushareit_listenit_avp;
    }

    public void mo674b() {
        if (this.a != null) {
            this.a.m1113g();
        }
        alv.m6104a((avo) this);
    }

    @TargetApi(17)
    protected void mo715c() {
        axy c0037f;
        String optString = this.b.getJSONObject(C0321x.aI).optString("orientation");
        if (!optString.isEmpty()) {
            this.f4737m = alx.m6118a(Integer.parseInt(optString));
        }
        if (this.b.has("layout") && !this.b.isNull("layout")) {
            JSONObject jSONObject = this.b.getJSONObject("layout");
            this.f4747w = (int) jSONObject.optLong("bgColor", (long) this.f4747w);
            this.f4748x = (int) jSONObject.optLong("textColor", (long) this.f4748x);
            this.f4749y = (int) jSONObject.optLong("accentColor", (long) this.f4749y);
            this.f4750z = jSONObject.optBoolean("persistentAdDetails", this.f4750z);
        }
        JSONObject jSONObject2 = this.b.getJSONObject("text");
        this.a.setId(View.generateViewId());
        int e = m6083e();
        Context context = this.c;
        if (e < 0) {
            e = 0;
        }
        this.f4746v = new C0041i(context, e, this.f4749y);
        this.f4746v.setOnTouchListener(this.f4736l);
        this.a.m1105a(this.f4746v);
        if (this.b.has("cta") && !this.b.isNull("cta")) {
            JSONObject jSONObject3 = this.b.getJSONObject("cta");
            this.f4738n = new C0029a(this.c, jSONObject3.getString("url"), jSONObject3.getString("text"), this.f4749y, this.a);
        }
        if (this.b.has("icon") && !this.b.isNull("icon")) {
            jSONObject = this.b.getJSONObject("icon");
            this.f4741q = new ImageView(this.c);
            new aum(this.f4741q).m7211a(jSONObject.getString("url"));
        }
        if (this.b.has("image") && !this.b.isNull("image")) {
            jSONObject = this.b.getJSONObject("image");
            c0037f = new C0037f(this.c);
            this.a.m1105a(c0037f);
            c0037f.setImage(jSONObject.getString("url"));
        }
        CharSequence optString2 = jSONObject2.optString("title");
        if (!optString2.isEmpty()) {
            this.f4739o = new TextView(this.c);
            this.f4739o.setText(optString2);
            this.f4739o.setTypeface(Typeface.defaultFromStyle(1));
        }
        optString2 = jSONObject2.optString("subtitle");
        if (!optString2.isEmpty()) {
            this.f4740p = new TextView(this.c);
            this.f4740p.setText(optString2);
            this.f4740p.setTextSize(16.0f);
        }
        this.f4743s = new C0045o(this.c);
        this.a.m1105a(this.f4743s);
        this.f4742r = new C0031a(this.c, "AdChoices", "http://m.facebook.com/ads/ad_choices", new float[]{0.0f, 0.0f, CloseButton.STROKE_WIDTH, 0.0f}, this.b.getString("ct"));
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        this.f4742r.setLayoutParams(layoutParams);
        this.a.m1105a(new C0042j(this.c));
        c0037f = new C0043k(this.c);
        this.a.m1105a(c0037f);
        axg com_ushareit_listenit_axg = m6141h() ? axg.FADE_OUT_ON_PLAY : axg.VISIBLE;
        this.a.m1105a(new awx(c0037f, com_ushareit_listenit_axg));
        this.f4745u = new awx(new RelativeLayout(this.c), com_ushareit_listenit_axg);
        this.a.m1105a(this.f4745u);
    }

    protected boolean m6141h() {
        if (f4729h || this.b != null) {
            try {
                return this.b.getJSONObject("video").getBoolean("autoplay");
            } catch (Throwable e) {
                Log.w(String.valueOf(aly.class), "Invalid JSON", e);
                return true;
            }
        }
        throw new AssertionError();
    }

    public void mo716i() {
    }

    public void mo717j() {
    }

    public alx m6144k() {
        return this.f4737m;
    }

    public void m6145l() {
        if (this.f4734j != null) {
            this.f4734j.finish();
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.a != null) {
            this.a.getEventBus().m6616a(new awi(view, motionEvent));
        }
        return true;
    }
}
