package com.ushareit.listenit.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.epm;
import com.ushareit.listenit.eqy;
import com.ushareit.listenit.erj;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.ffh;
import com.ushareit.listenit.fii;
import com.ushareit.listenit.fjw;
import com.ushareit.listenit.fre;
import com.ushareit.listenit.glg;
import com.ushareit.listenit.gox;
import com.ushareit.listenit.gum;
import com.ushareit.listenit.gun;
import com.ushareit.listenit.gup;
import com.ushareit.listenit.gvj;
import com.ushareit.listenit.gxm;
import com.ushareit.listenit.gxs;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.gyp;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.hbj;
import com.ushareit.listenit.hbv;
import com.ushareit.listenit.hcj;
import com.ushareit.listenit.hck;
import com.ushareit.listenit.hcl;
import com.ushareit.listenit.hcm;
import com.ushareit.listenit.hcn;
import com.ushareit.listenit.hco;
import com.ushareit.listenit.hcp;
import com.ushareit.listenit.hcq;
import com.ushareit.listenit.hcr;
import com.ushareit.listenit.hcs;
import com.ushareit.listenit.hct;
import com.ushareit.listenit.hcu;
import com.ushareit.listenit.hcv;
import com.ushareit.listenit.hcw;
import com.ushareit.listenit.hcx;
import com.ushareit.listenit.hcy;
import com.ushareit.listenit.hcz;
import com.ushareit.listenit.hda;
import com.ushareit.listenit.hdc;
import com.ushareit.listenit.hdd;
import com.ushareit.listenit.hde;
import com.ushareit.listenit.hdf;
import com.ushareit.listenit.hdg;
import com.ushareit.listenit.hdh;
import com.ushareit.listenit.hdi;
import com.ushareit.listenit.hdk;
import com.ushareit.listenit.hdl;
import com.ushareit.listenit.hdm;
import com.ushareit.listenit.hdn;
import com.ushareit.listenit.hdo;
import com.ushareit.listenit.hhe;
import com.ushareit.listenit.hic;
import com.ushareit.listenit.lyrics.LyricView;
import com.ushareit.listenit.popupview.NormalPlayerMenu;

public class NormalPlayerView extends FrameLayout implements hbj {
    private View f17291A;
    private ImageView f17292B;
    private LISTENitViewFlipper f17293C;
    private gum f17294D;
    private hdo f17295E;
    private boolean f17296F = false;
    private boolean f17297G = true;
    private boolean f17298H = false;
    private long f17299I = -1;
    private int f17300J;
    private int f17301K;
    private int f17302L;
    private Runnable f17303M = new hcj(this);
    private gxs f17304N = new hdk(this);
    private OnSeekBarChangeListener f17305O = new hdl(this);
    private OnClickListener f17306P = new hdm(this);
    private OnClickListener f17307Q = new hdn(this);
    private OnClickListener f17308R = new hck(this);
    private OnClickListener f17309S = new hcl(this);
    private OnClickListener f17310T = new hcm(this);
    private OnClickListener f17311U = new hcn(this);
    private OnClickListener f17312V = new hco(this);
    private OnClickListener f17313W = new hcp(this);
    private View f17314a;
    private gun aa = new hcq(this);
    private gup ab = new hcr(this);
    private OnClickListener ac = new hcs(this);
    private OnClickListener ad = new hct(this);
    private fjw ae = new hcv(this);
    private gox af = new hcx(this);
    private OnClickListener ag = new hcy(this);
    private OnClickListener ah = new hcz(this);
    private Bitmap ai;
    private long aj = -1;
    private hbv ak = new hda(this);
    private OnClickListener al = new hdc(this);
    private ImageView f17315b;
    private ffh f17316c;
    private View f17317d;
    private ImageView f17318e;
    private View f17319f;
    private View f17320g;
    private ImageView f17321h;
    private ImageView f17322i;
    private ImageView f17323j;
    private TextView f17324k;
    private TextView f17325l;
    private ImageView f17326m;
    private ImageView f17327n;
    private TextView f17328o;
    private SeekBar f17329p;
    private TextView f17330q;
    private ImageView f17331r;
    private ImageView f17332s;
    private ImageView f17333t;
    private ImageView f17334u;
    private ImageView f17335v;
    private ImageView f17336w;
    private LyricView f17337x;
    private View f17338y;
    private View f17339z;

    public NormalPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26952a(context);
    }

    public NormalPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26952a(context);
    }

    public NormalPlayerView(Context context) {
        super(context);
        m26952a(context);
    }

    public void m26952a(Context context) {
        View inflate = View.inflate(context, C0349R.layout.player_normal_view, this);
        this.f17317d = inflate.findViewById(C0349R.id.player_view);
        this.f17318e = (ImageView) inflate.findViewById(C0349R.id.player_bg);
        this.f17319f = inflate.findViewById(C0349R.id.player_content);
        this.f17320g = inflate.findViewById(C0349R.id.back);
        this.f17321h = (ImageView) inflate.findViewById(C0349R.id.more);
        this.f17322i = (ImageView) inflate.findViewById(C0349R.id.search);
        this.f17323j = (ImageView) inflate.findViewById(C0349R.id.equalizer);
        this.f17324k = (TextView) inflate.findViewById(C0349R.id.song_name);
        this.f17325l = (TextView) inflate.findViewById(C0349R.id.artist_name);
        this.f17326m = (ImageView) inflate.findViewById(C0349R.id.normal_favorite);
        this.f17327n = (ImageView) inflate.findViewById(C0349R.id.add_to_playlist);
        this.f17328o = (TextView) inflate.findViewById(C0349R.id.elapse);
        this.f17329p = (SeekBar) inflate.findViewById(C0349R.id.seekbar);
        this.f17330q = (TextView) inflate.findViewById(C0349R.id.duration);
        this.f17331r = (ImageView) inflate.findViewById(C0349R.id.play_mode);
        this.f17332s = (ImageView) inflate.findViewById(C0349R.id.shuffle_play);
        this.f17333t = (ImageView) inflate.findViewById(C0349R.id.normal_play_prev);
        this.f17334u = (ImageView) inflate.findViewById(C0349R.id.play);
        this.f17315b = (ImageView) inflate.findViewById(C0349R.id.play_circle);
        this.f17335v = (ImageView) inflate.findViewById(C0349R.id.normal_play_next);
        this.f17336w = (ImageView) inflate.findViewById(C0349R.id.playlist);
        this.f17291A = inflate.findViewById(C0349R.id.song_attach_file_area);
        this.f17337x = (LyricView) inflate.findViewById(C0349R.id.lyric_view);
        this.f17338y = inflate.findViewById(C0349R.id.lyric_guide);
        this.f17339z = inflate.findViewById(C0349R.id.album_and_button_area);
        this.f17314a = inflate.findViewById(C0349R.id.player_mask);
        this.f17292B = (ImageView) inflate.findViewById(C0349R.id.prev_bg);
        this.f17293C = (LISTENitViewFlipper) inflate.findViewById(C0349R.id.view_flipper);
        erj.m17570a(this.f17314a, 0.7f);
        this.f17321h.setVisibility(0);
        this.f17321h.setImageResource(C0349R.drawable.more_player_icon_click_bg);
        this.f17321h.setOnClickListener(this.ad);
        this.f17322i.setOnClickListener(this.ae);
        if (gyn.m23226c()) {
            this.f17323j.setVisibility(0);
            this.f17323j.setOnClickListener(this.ac);
            m26932h();
        } else {
            this.f17323j.setVisibility(8);
        }
        this.f17326m.setOnClickListener(this.f17306P);
        this.f17327n.setOnClickListener(this.f17307Q);
        this.f17329p.setOnSeekBarChangeListener(this.f17305O);
        this.f17334u.setOnClickListener(this.f17308R);
        this.f17335v.setOnClickListener(this.f17309S);
        this.f17333t.setOnClickListener(this.f17310T);
        this.f17336w.setOnClickListener(this.f17311U);
        this.f17331r.setOnClickListener(this.f17312V);
        this.f17332s.setOnClickListener(this.f17313W);
        this.f17291A.setOnClickListener(this.ag);
        this.f17337x.setLyricClickListener(this.ah);
        this.f17338y.setOnClickListener(this.al);
        this.f17293C.setOnPlayerDiscListener(this.ak);
        this.f17293C.setOnClickListener(this.ag);
        this.f17293C.post(this.f17303M);
        this.f17302L = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f17316c = new ffh(context, inflate);
        this.f17328o.setText(gyn.m23182a(0));
        if (gyn.m23217b()) {
            gyn.m23237e(this.f17319f, fbb.m18766e(getContext()));
        }
        gyn.m23224c(this.f17317d, fbb.m18764d(getContext()));
        this.f17338y.setVisibility(gvj.m22887Z(getContext()) ? 0 : 8);
    }

    public void setOnDragHideListener(hdo com_ushareit_listenit_hdo) {
        this.f17295E = com_ushareit_listenit_hdo;
    }

    public void m26958b(gum com_ushareit_listenit_gum) {
        this.f17294D = com_ushareit_listenit_gum;
        m26915c(com_ushareit_listenit_gum);
        if (com_ushareit_listenit_gum != null) {
            com_ushareit_listenit_gum.mo2417a(this.ab);
            com_ushareit_listenit_gum.mo2415a(this.aa);
        }
    }

    public void mo3119a(gum com_ushareit_listenit_gum) {
        boolean z = false;
        exw.m18454c("0926", "NormalPlayerView.onResume()");
        if (com_ushareit_listenit_gum != null) {
            com_ushareit_listenit_gum.mo2417a(this.ab);
            com_ushareit_listenit_gum.mo2415a(this.aa);
            m26932h();
            m26916c(com_ushareit_listenit_gum.mo2425a());
            m26915c(com_ushareit_listenit_gum);
            if (!this.f17297G) {
                this.f17337x.m24780a(false);
            }
            ffh com_ushareit_listenit_ffh = this.f17316c;
            if (this.f17293C.getDisplayedChild() != 0) {
                z = true;
            }
            com_ushareit_listenit_ffh.m19097b(z);
        }
    }

    protected void onDetachedFromWindow() {
        if (this.f17294D != null) {
            this.f17294D.mo2431b(this.ab);
            this.f17294D.mo2429b(this.aa);
        }
        super.onDetachedFromWindow();
    }

    public void mo2503a(boolean z) {
        boolean z2 = false;
        m26916c(true);
        if (!(this.f17297G || z)) {
            this.f17337x.m24780a(false);
        }
        if (!z) {
            if (this.f17299I > 0 && this.f17294D.mo2464u() != this.f17299I) {
                if (this.f17294D.mo2466w().f14334b == this.f17299I || this.f17294D.mo2467x().f14334b != this.f17299I) {
                    z2 = true;
                }
                this.f17293C.m26850a(z2);
            }
            this.f17299I = this.f17294D.mo2464u();
            if (this.f17299I == this.aj) {
                m26899a(this.ai);
            }
        }
    }

    private void m26899a(Bitmap bitmap) {
        if (bitmap != null) {
            gxm.m23096a(bitmap, "normalPlayViewBlurTask", 400, this.f17304N);
        }
    }

    public void f_() {
        m26916c(false);
    }

    public void mo2504b() {
        m26916c(false);
    }

    public void mo2505c() {
        m26916c(false);
    }

    public void mo2482a() {
    }

    public void m26951a(int i, int i2) {
        if (!this.f17298H && i >= 0 && i2 > 0) {
            this.f17328o.setText(gyn.m23182a((long) i));
            this.f17329p.setProgress((int) (((((float) i) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) i2)) * ((float) this.f17329p.getMax())));
            if (!this.f17297G) {
                this.f17337x.m24779a(i, false);
            }
        }
    }

    public void m26959b(boolean z) {
        if (z) {
            m26923e();
        } else {
            m26926f();
        }
    }

    private void m26923e() {
        this.f17315b.setImageResource(C0349R.drawable.playpage_ic_semicircle_normal);
        this.f17315b.setVisibility(0);
        Animation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(1000);
        this.f17315b.startAnimation(rotateAnimation);
    }

    private void m26926f() {
        this.f17315b.setImageResource(C0349R.drawable.player_play_circle_bg);
        this.f17315b.clearAnimation();
    }

    public void m26950a(int i) {
        if (this.f17329p != null) {
            this.f17329p.setSecondaryProgress((this.f17329p.getMax() * i) / 100);
        }
    }

    public void m26955a(String str) {
        if (this.f17294D != null && !fbb.m18763c(str) && this.f17294D.mo2465v() != null && this.f17294D.mo2465v().f14340h.equals(str)) {
            m26900a(this.f17294D, true);
        }
    }

    public void setOnBackClickListener(OnClickListener onClickListener) {
        this.f17320g.setOnClickListener(onClickListener);
    }

    public void m26961d() {
        this.f17316c.f12598h = true;
        this.f17339z.setVisibility(0);
        erj.m17570a(this.f17339z, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        erj.m17570a(this.f17314a, 0.7f);
        this.f17337x.setVisibility(4);
        this.f17297G = true;
        this.f17317d.setClickable(true);
        eqy b = eqy.m17366b((float) getHeight(), 0.0f);
        b.mo2252c(200);
        b.m17384a(new hcu(this, this));
        b.mo2234a();
        fii.m19308c();
    }

    public void m26953a(epm com_ushareit_listenit_epm) {
        this.f17316c.f12598h = false;
        this.f17317d.setClickable(false);
        eqy b = eqy.m17366b(0.0f, (float) getHeight());
        b.mo2252c(200);
        b.m17384a(new hdg(this, this));
        b.m17274a(new hdi(this, com_ushareit_listenit_epm));
        b.mo2234a();
    }

    private synchronized void m26915c(gum com_ushareit_listenit_gum) {
        m26900a(com_ushareit_listenit_gum, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m26900a(com.ushareit.listenit.gum r9, boolean r10) {
        /*
        r8 = this;
        monitor-enter(r8);
        if (r9 == 0) goto L_0x000f;
    L_0x0003:
        if (r10 != 0) goto L_0x0011;
    L_0x0005:
        r0 = r8.f17299I;	 Catch:{ all -> 0x0047 }
        r2 = r9.mo2464u();	 Catch:{ all -> 0x0047 }
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r8);
        return;
    L_0x0011:
        r0 = r9.mo2464u();	 Catch:{ all -> 0x0047 }
        r8.f17299I = r0;	 Catch:{ all -> 0x0047 }
        r1 = r9.mo2465v();	 Catch:{ all -> 0x0047 }
        r0 = r8.f17293C;	 Catch:{ all -> 0x0047 }
        r0 = r0.getCurrentView();	 Catch:{ all -> 0x0047 }
        r0 = (android.view.ViewGroup) r0;	 Catch:{ all -> 0x0047 }
        r2 = 0;
        r2 = r0.getChildAt(r2);	 Catch:{ all -> 0x0047 }
        r2 = (android.widget.ImageView) r2;	 Catch:{ all -> 0x0047 }
        r0 = r2.getWidth();	 Catch:{ all -> 0x0047 }
        if (r0 == 0) goto L_0x004a;
    L_0x0030:
        r4 = r2.getWidth();	 Catch:{ all -> 0x0047 }
    L_0x0034:
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0047 }
        r0 = r8.getContext();	 Catch:{ all -> 0x0047 }
        r3 = com.ushareit.listenit.tv.HIGH;	 Catch:{ all -> 0x0047 }
        r5 = new com.ushareit.listenit.hdj;	 Catch:{ all -> 0x0047 }
        r5.<init>(r8, r6, r2);	 Catch:{ all -> 0x0047 }
        com.ushareit.listenit.fzi.m21402a(r0, r1, r2, r3, r4, r5);	 Catch:{ all -> 0x0047 }
        goto L_0x000f;
    L_0x0047:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x004a:
        r4 = 480; // 0x1e0 float:6.73E-43 double:2.37E-321;
        goto L_0x0034;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.widget.NormalPlayerView.a(com.ushareit.listenit.gum, boolean):void");
    }

    private void m26928g() {
        this.f17318e.setVisibility(0);
        Animation alphaAnimation = new AlphaAnimation(0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        alphaAnimation.setDuration(400);
        alphaAnimation.setFillAfter(true);
        this.f17318e.startAnimation(alphaAnimation);
    }

    private void m26916c(boolean z) {
        glg o = gyp.m23301o();
        if (o != null) {
            this.f17330q.setText(gyn.m23182a((long) gyp.m23300n()));
            this.f17324k.setText(o.f14338f);
            this.f17325l.setText(o.f14339g);
            this.f17331r.setImageDrawable(m26908b(gyp.m23292f()));
            this.f17332s.setImageDrawable(m26921e(gyp.m23294h()));
            this.f17326m.setImageDrawable(m26918d(fre.m20627a(gyp.m23301o())));
        }
        if (z) {
            this.f17334u.setImageResource(C0349R.drawable.player_pause_bg);
        } else {
            this.f17334u.setImageResource(C0349R.drawable.player_play_bg);
        }
    }

    private void m26904a(Boolean bool) {
        if (this.f17294D != null) {
            glg v = bool == null ? this.f17294D.mo2465v() : bool.booleanValue() ? this.f17294D.mo2467x() : this.f17294D.mo2466w();
            if (v != null) {
                this.f17324k.setText(v.f14338f);
                this.f17325l.setText(v.f14339g);
            }
        }
    }

    private Drawable m26908b(int i) {
        int i2 = C0349R.drawable.player_mode_list_loop_enable_white_bg;
        switch (i) {
            case 1:
                i2 = C0349R.drawable.player_mode_list_loop_disable_white_bg;
                break;
            case 3:
                i2 = C0349R.drawable.player_mode_song_loop_white_bg;
                break;
        }
        Drawable drawable = getResources().getDrawable(i2);
        return (gzd.m23364e() != 2 || i == 1) ? drawable : hhe.m23351c(drawable, gzd.m23358b());
    }

    private void m26932h() {
        if (gyn.m23226c()) {
            boolean d = gvj.m22935d();
            Drawable drawable = getResources().getDrawable(d ? C0349R.drawable.equalizer_player_icon_open_bg : C0349R.drawable.equalizer_player_icon_close_bg);
            if (d && gzd.m23364e() == 2) {
                drawable = hhe.m23348a(drawable, gzd.m23358b());
            }
            this.f17323j.setImageDrawable(drawable);
        }
    }

    private Drawable m26918d(boolean z) {
        if (!z) {
            return getResources().getDrawable(C0349R.drawable.player_unlike_it);
        }
        Drawable drawable = getResources().getDrawable(C0349R.drawable.player_like_it);
        if (gzd.m23364e() == 2) {
            return hhe.m23348a(drawable, gzd.m23358b());
        }
        hhe.m23347a(drawable);
        return drawable;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f17317d.isClickable()) {
            return true;
        }
        if (!this.f17297G) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.f17300J = (int) motionEvent.getY();
                this.f17301K = (int) motionEvent.getX();
                break;
            case 1:
            case 3:
                int y = (int) (motionEvent.getY() - ((float) this.f17300J));
                int abs = Math.abs(y);
                int abs2 = (int) Math.abs(motionEvent.getX() - ((float) this.f17301K));
                if (y > 0 && abs > abs2 && abs > this.f17302L * 4 && this.f17295E != null) {
                    this.f17295E.mo2622a();
                    this.f17296F = true;
                    break;
                }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private Drawable m26921e(boolean z) {
        Drawable drawable = getResources().getDrawable(z ? C0349R.drawable.player_shuffle_enable_white_bg : C0349R.drawable.player_shuffle_disable_white_bg1);
        if (gzd.m23364e() == 2 && z) {
            return hhe.m23348a(drawable, gzd.m23358b());
        }
        return drawable;
    }

    private int m26912c(int i) {
        switch (i) {
            case 2:
                return C0349R.string.common_play_mode_list_repeat;
            case 3:
                return C0349R.string.common_play_mode_song_repeat;
            default:
                return C0349R.string.common_play_mode_list;
        }
    }

    private int m26924f(boolean z) {
        return z ? C0349R.string.common_shuffle_enable_play : C0349R.string.common_shuffle_disable_play;
    }

    private void setPopupMenu(View view) {
        View normalPlayerMenu = new NormalPlayerMenu(getContext());
        hic com_ushareit_listenit_hic = new hic(getContext(), normalPlayerMenu);
        normalPlayerMenu.setOnID3TagListener(this.af);
        normalPlayerMenu.setOnDismissListener(new hcw(this, com_ushareit_listenit_hic));
        com_ushareit_listenit_hic.m23887a(view);
    }

    private void m26934i() {
        if (this.f17297G) {
            m26936j();
        } else {
            m26938k();
        }
    }

    private void m26936j() {
        this.f17337x.m24780a(false);
        eqy b = eqy.m17366b(0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        b.m17383a(new DecelerateInterpolator());
        b.mo2252c(100);
        b.m17384a(new hdd(this));
        b.m17274a(new hde(this));
        b.mo2234a();
    }

    private void m26938k() {
        this.f17339z.setVisibility(0);
        this.f17337x.setVisibility(4);
        eqy b = eqy.m17366b(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.0f);
        b.mo2252c(100);
        b.m17383a(new DecelerateInterpolator());
        b.m17384a(new hdf(this));
        b.m17274a(new hdh(this));
        b.mo2234a();
    }
}
