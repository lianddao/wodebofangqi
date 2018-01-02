package com.ushareit.listenit.lockscreen;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.provider.Settings.System;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.eqy;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fff;
import com.ushareit.listenit.fjw;
import com.ushareit.listenit.fre;
import com.ushareit.listenit.fzi;
import com.ushareit.listenit.gcc;
import com.ushareit.listenit.gci;
import com.ushareit.listenit.gcj;
import com.ushareit.listenit.gck;
import com.ushareit.listenit.gcl;
import com.ushareit.listenit.gcm;
import com.ushareit.listenit.gcn;
import com.ushareit.listenit.gco;
import com.ushareit.listenit.gcp;
import com.ushareit.listenit.gcq;
import com.ushareit.listenit.gcr;
import com.ushareit.listenit.gcs;
import com.ushareit.listenit.gct;
import com.ushareit.listenit.gcu;
import com.ushareit.listenit.gcv;
import com.ushareit.listenit.gcw;
import com.ushareit.listenit.gcx;
import com.ushareit.listenit.glg;
import com.ushareit.listenit.gum;
import com.ushareit.listenit.guo;
import com.ushareit.listenit.gxs;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.gys;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.hgt;
import com.ushareit.listenit.hhe;
import com.ushareit.listenit.hu;
import com.ushareit.listenit.qb;
import com.ushareit.listenit.tv;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MusicLockScreenView extends FrameLayout {
    private boolean f15642A;
    private int f15643B;
    private int f15644C;
    private long f15645D;
    private final Handler f15646E;
    private Runnable f15647F;
    private gxs f15648G;
    private boolean f15649H;
    private OnClickListener f15650I;
    private OnClickListener f15651J;
    private fjw f15652K;
    private OnClickListener f15653L;
    private OnClickListener f15654M;
    private guo f15655N;
    private hgt f15656O;
    private final BroadcastReceiver f15657P;
    private OnClickListener f15658Q;
    private RelativeLayout f15659a;
    private RelativeLayout f15660b;
    private TextView f15661c;
    private TextView f15662d;
    private TextView f15663e;
    private ImageView f15664f;
    private ImageView f15665g;
    private ImageView f15666h;
    private ImageView f15667i;
    private ImageView f15668j;
    private ImageView f15669k;
    private ImageView f15670l;
    private ImageView f15671m;
    private ImageView f15672n;
    private ImageView f15673o;
    private ImageView f15674p;
    private ImageView f15675q;
    private fff f15676r;
    private gcc f15677s;
    private qb f15678t;
    private Calendar f15679u;
    private AnimationDrawable f15680v;
    private gum f15681w;
    private boolean f15682x;
    private boolean f15683y;
    private boolean f15684z;

    public MusicLockScreenView(Context context) {
        this(context, null);
    }

    public MusicLockScreenView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MusicLockScreenView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15682x = true;
        this.f15684z = false;
        this.f15642A = true;
        this.f15643B = 0;
        this.f15645D = -1;
        this.f15646E = new Handler();
        this.f15647F = new gcp(this);
        this.f15648G = new gct(this);
        this.f15649H = true;
        this.f15650I = new gcu(this);
        this.f15651J = new gcv(this);
        this.f15652K = new gcw(this);
        this.f15653L = new gcj(this);
        this.f15654M = new gck(this);
        this.f15655N = new gcl(this);
        this.f15656O = new gcm(this);
        this.f15657P = new gcn(this);
        this.f15658Q = new gco(this);
        m24500b();
    }

    private void m24500b() {
        View inflate = View.inflate(getContext(), C0349R.layout.lock_screen_player, null);
        this.f15678t = qb.m25667a((ViewGroup) this, (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, new gcx());
        this.f15644C = fbb.m18762c(getContext());
        this.f15679u = Calendar.getInstance();
        this.f15681w = gys.m23310a();
        m24496a(inflate);
        setViewListener();
        m24503c();
        m24508e();
        addView(inflate);
        post(this.f15647F);
        gyn.m23191a(this.f15664f);
        gyn.m23191a(this.f15665g);
    }

    private void m24496a(View view) {
        this.f15659a = (RelativeLayout) view.findViewById(C0349R.id.lock_screen_root);
        this.f15675q = (ImageView) view.findViewById(C0349R.id.prev_bg);
        this.f15666h = (ImageView) view.findViewById(C0349R.id.lock_bg);
        this.f15661c = (TextView) view.findViewById(C0349R.id.lock_time);
        this.f15662d = (TextView) view.findViewById(C0349R.id.lock_music_name);
        this.f15663e = (TextView) view.findViewById(C0349R.id.lock_music_artist);
        this.f15664f = (ImageView) view.findViewById(C0349R.id.curr_albumart);
        this.f15665g = (ImageView) view.findViewById(C0349R.id.next_albumart);
        this.f15669k = (ImageView) view.findViewById(C0349R.id.lock_arrow);
        this.f15667i = (ImageView) view.findViewById(C0349R.id.play_mode);
        this.f15668j = (ImageView) view.findViewById(C0349R.id.favorite);
        this.f15670l = (ImageView) view.findViewById(C0349R.id.lock_play);
        this.f15671m = (ImageView) view.findViewById(C0349R.id.play_prev);
        this.f15672n = (ImageView) view.findViewById(C0349R.id.play_next);
        this.f15660b = (RelativeLayout) view.findViewById(C0349R.id.lock_album_picture);
        this.f15674p = (ImageView) view.findViewById(C0349R.id.add_to_playlist);
        this.f15673o = (ImageView) view.findViewById(C0349R.id.circle);
        this.f15676r = new fff(this.f15659a);
    }

    private void setViewListener() {
        this.f15667i.setOnClickListener(this.f15650I);
        this.f15668j.setOnClickListener(this.f15651J);
        this.f15670l.setOnClickListener(this.f15652K);
        this.f15672n.setOnClickListener(this.f15653L);
        this.f15671m.setOnClickListener(this.f15654M);
        this.f15674p.setOnClickListener(this.f15658Q);
    }

    private void m24503c() {
        post(new gci(this));
    }

    private void m24506d() {
        if (this.f15680v != null) {
            this.f15680v.stop();
        }
    }

    private void m24508e() {
        if (this.f15681w != null) {
            if (this.f15681w.mo2425a()) {
                this.f15670l.setImageResource(C0349R.drawable.player_pause_bg);
            } else {
                this.f15670l.setImageResource(C0349R.drawable.player_play_bg);
            }
            if (this.f15645D != this.f15681w.mo2464u()) {
                this.f15645D = this.f15681w.mo2464u();
                glg v = this.f15681w.mo2465v();
                if (v != null) {
                    this.f15662d.setText(v.f14338f);
                    this.f15663e.setText(v.f14339g);
                    this.f15668j.setImageResource(fre.m20627a(this.f15681w.mo2465v()) ? C0349R.drawable.player_like_it : C0349R.drawable.player_unlike_it);
                    this.f15667i.setImageDrawable(m24493a(this.f15681w.mo2453j()));
                    m24501b(this.f15681w);
                }
            }
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.f15683y) {
            this.f15683y = true;
            if (this.f15682x) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.TIME_TICK");
                intentFilter.addAction("android.intent.action.TIME_SET");
                intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
                getContext().registerReceiver(this.f15657P, intentFilter, null, this.f15646E);
            }
            m24510f();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f15676r != null) {
            this.f15676r.m19090e();
        }
        if (this.f15683y) {
            this.f15683y = false;
            m24506d();
            if (this.f15682x) {
                getContext().unregisterReceiver(this.f15657P);
                if (this.f15681w != null) {
                    this.f15681w.mo2430b(this.f15655N);
                    this.f15681w.mo2433b(this.f15656O);
                }
            }
        }
    }

    public void m24532a() {
        this.f15684z = true;
    }

    public void setOnDragFinishListener(gcc com_ushareit_listenit_gcc) {
        this.f15677s = com_ushareit_listenit_gcc;
    }

    public void m24533a(gum com_ushareit_listenit_gum) {
        this.f15681w = com_ushareit_listenit_gum;
        this.f15681w.mo2416a(this.f15655N);
        this.f15681w.mo2419a(this.f15656O);
        m24508e();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int a = hu.m24051a(motionEvent);
        if (a != 3 && a != 1) {
            return this.f15678t.m25690a(motionEvent);
        }
        this.f15678t.m25705e();
        return false;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.f15678t.m25694b(motionEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public void computeScroll() {
        if (this.f15678t.m25692a(true)) {
            invalidate();
        } else if (this.f15643B == 2 && this.f15677s != null) {
            this.f15677s.mo2643a();
        }
    }

    private void m24510f() {
        if (this.f15682x) {
            this.f15679u.setTimeInMillis(System.currentTimeMillis());
        }
        String string = System.getString(getContext().getContentResolver(), "time_12_24");
        String str = "HH:mm";
        if (string != null && string.equals("12")) {
            str = "hh:mm";
        }
        CharSequence format = new SimpleDateFormat(str, Locale.getDefault()).format(this.f15679u.getTime());
        if (VERSION.SDK_INT > 17) {
            this.f15661c.setTypeface(Typeface.create("sans-serif-thin", 0));
        }
        this.f15661c.setText(format);
    }

    private synchronized void m24501b(gum com_ushareit_listenit_gum) {
        m24512g();
        fzi.m21402a(getContext(), com_ushareit_listenit_gum.mo2465v(), this.f15665g, tv.HIGH, this.f15665g.getWidth() != 0 ? this.f15665g.getWidth() : 480, new gcq(this));
    }

    private void m24512g() {
        Drawable drawable = this.f15665g.getDrawable();
        fzi.m21405a(this.f15665g, C0349R.drawable.default_albumart_gray);
        if (this.f15684z) {
            this.f15664f.setImageDrawable(drawable);
            m24514h();
            return;
        }
        this.f15684z = true;
    }

    private void m24514h() {
        this.f15664f.setVisibility(0);
        this.f15665g.setVisibility(0);
        int i = this.f15642A ? 1 : -1;
        eqy b = eqy.m17366b(0.0f, (float) fbb.m18762c(getContext()));
        b.m17384a(new gcr(this, i, r2));
        b.m17274a(new gcs(this));
        b.m17383a(new AccelerateDecelerateInterpolator());
        b.mo2252c(300);
        b.mo2234a();
    }

    private void m24516i() {
        if (this.f15649H) {
            this.f15649H = false;
            return;
        }
        this.f15666h.setVisibility(0);
        Animation alphaAnimation = new AlphaAnimation(0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        alphaAnimation.setDuration(400);
        alphaAnimation.setFillAfter(true);
        this.f15666h.startAnimation(alphaAnimation);
    }

    private Drawable m24493a(boolean z) {
        Drawable drawable = getResources().getDrawable(z ? C0349R.drawable.player_shuffle_enable_white_bg : C0349R.drawable.player_shuffle_disable_white_bg1);
        if (gzd.m23364e() == 2 && z) {
            return hhe.m23348a(drawable, gzd.m23358b());
        }
        return drawable;
    }

    private int m24498b(boolean z) {
        return z ? C0349R.string.common_shuffle_enable_play : C0349R.string.common_shuffle_disable_play;
    }

    private void m24517j() {
        this.f15673o.setImageResource(C0349R.drawable.playpage_ic_semicircle_normal);
        this.f15673o.setVisibility(0);
        Animation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(1000);
        this.f15673o.startAnimation(rotateAnimation);
    }

    private void m24520k() {
        this.f15673o.setImageResource(C0349R.drawable.player_play_circle_bg);
        this.f15673o.clearAnimation();
    }
}
