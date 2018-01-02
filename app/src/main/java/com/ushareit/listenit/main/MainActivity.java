package com.ushareit.listenit.main;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ListenItApp;
import com.ushareit.listenit.ak;
import com.ushareit.listenit.esr;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.eys;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fdi;
import com.ushareit.listenit.fez;
import com.ushareit.listenit.fhy;
import com.ushareit.listenit.fid;
import com.ushareit.listenit.fii;
import com.ushareit.listenit.fir;
import com.ushareit.listenit.fji;
import com.ushareit.listenit.fjt;
import com.ushareit.listenit.fqk;
import com.ushareit.listenit.fragments.PlayerFragment;
import com.ushareit.listenit.fragments.ScanFragment;
import com.ushareit.listenit.ftl;
import com.ushareit.listenit.fxp;
import com.ushareit.listenit.fyi;
import com.ushareit.listenit.fzd;
import com.ushareit.listenit.gbe;
import com.ushareit.listenit.gef;
import com.ushareit.listenit.gil;
import com.ushareit.listenit.gim;
import com.ushareit.listenit.gin;
import com.ushareit.listenit.gio;
import com.ushareit.listenit.gip;
import com.ushareit.listenit.giq;
import com.ushareit.listenit.gir;
import com.ushareit.listenit.gis;
import com.ushareit.listenit.git;
import com.ushareit.listenit.giu;
import com.ushareit.listenit.gro;
import com.ushareit.listenit.grr;
import com.ushareit.listenit.grz;
import com.ushareit.listenit.gvj;
import com.ushareit.listenit.gvk;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.gyp;
import com.ushareit.listenit.heb;
import com.ushareit.listenit.hhx;
import com.ushareit.listenit.hjb;
import com.ushareit.listenit.kx;
import com.ushareit.listenit.popupview.BasePopupView;
import com.ushareit.listenit.popupview.NearbyGuidePopupView;
import com.ushareit.listenit.widget.CustomViewPager;
import com.ushareit.listenit.widget.NearbyGuideMaskView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends fjt {
    private static long f15896s = 0;
    private long f15897A = 0;
    private boolean f15898B = false;
    private NearbyGuideMaskView f15899C;
    private FrameLayout f15900D;
    private fez f15901E;
    private fzd f15902F = new gir(this);
    private Runnable f15903G = new gis(this);
    private kx f15904H = new git(this);
    private BroadcastReceiver f15905I = new giu(this);
    @SuppressLint({"HandlerLeak"})
    private Handler f15906J = new gim(this);
    private PlayerFragment f15907n;
    private CustomViewPager f15908o;
    private List<fji> f15909p = new ArrayList();
    private fdi f15910q;
    private FrameLayout f15911r;
    private fxp f15912t;
    private ScanFragment f15913y;
    private ftl f15914z;

    protected void onCreate(Bundle bundle) {
        exw.m18443a("UI.MainActivity", "onCreate");
        super.onCreate(bundle);
        setContentView(C0349R.layout.main_activity);
        m24819s();
        this.f15908o.setOffscreenPageLimit(5);
        this.f15912t = new fxp();
        this.f15909p.add(this.f15912t);
        this.f15910q = new fdi(m709f(), this.f15909p);
        this.f15908o.setAdapter(this.f15910q);
        this.f15908o.setOnPageChangeListener(this.f15904H);
        if (!gvj.m23044y(this)) {
            gef.m21805a().m21830b();
            m24809b(true);
            m24822v();
        } else if (m24805a(getIntent())) {
            m24809b(false);
        } else {
            m24809b(false);
            mo539h();
        }
        m24823w();
        m24824x();
        m24804a(getIntent(), true);
        ((ListenItApp) getApplicationContext()).m4933a(true);
        gbe.m21585a().m21587a(this);
        m24833j().m19069b();
    }

    private void m24819s() {
        this.f15907n = (PlayerFragment) m709f().mo795a((int) C0349R.id.miniplay_fragment);
        this.f15908o = (CustomViewPager) findViewById(C0349R.id.custom_view_pager);
        this.f15911r = (FrameLayout) findViewById(C0349R.id.main_view);
        this.f15900D = (FrameLayout) findViewById(C0349R.id.init_fragment_container);
    }

    public void mo539h() {
        this.f15913y = new ScanFragment(true);
        this.f15913y.m20572a(this.f15902F);
        gyn.m23195a((ak) this, (int) C0349R.id.init_fragment_container, this.f15913y);
    }

    public fez m24833j() {
        if (this.f15901E == null) {
            this.f15901E = new fez(this, this.f15909p);
        }
        return this.f15901E;
    }

    public void m24828a(String str, String str2, Bitmap bitmap, Drawable drawable, Rect rect) {
        if (gyn.m23256m()) {
            if (this.f15914z == null) {
                this.f15914z = new ftl(str, str2, bitmap, drawable);
                this.f15914z.m20939a(rect);
                gyn.m23195a((ak) this, (int) C0349R.id.init_fragment_container, this.f15914z);
                this.f15900D.bringToFront();
            } else {
                this.f15914z.m20940a(str, str2, bitmap, drawable);
                this.f15914z.m20939a(rect);
                gyn.m23225c((ak) this, this.f15914z);
                this.f15900D.bringToFront();
            }
            if (gyp.m23302p()) {
                gyp.m23289d();
            }
            m24820t();
            return;
        }
        heb.m23597a(getString(C0349R.string.toast_no_network), 1).show();
    }

    public void m24835p() {
        if (this.f15914z != null) {
            gyn.m23232d((ak) this, this.f15914z);
            m24821u();
        }
    }

    private void m24820t() {
        if (this.f15912t != null) {
            this.f15912t.m21284X();
        }
    }

    private void m24821u() {
        if (this.f15912t != null) {
            this.f15912t.m21283W();
        }
    }

    private void m24809b(boolean z) {
        grr.m22621a().m22643a(new gro(gvk.m23052c()));
        grr.m22621a().m22642a(eys.m18562a(), z);
    }

    private void m24822v() {
        if (fqk.m20382h() && !gvj.m23017o()) {
            BasePopupView nearbyGuidePopupView = new NearbyGuidePopupView(this, this.f15912t);
            if (nearbyGuidePopupView.m25606a()) {
                gyn.m23197a((ak) this, new fyi(nearbyGuidePopupView));
            }
        }
        if (!gvj.m23017o()) {
            return;
        }
        if (fhy.m19213a()) {
            fir.m19411m();
        } else {
            fir.m19412n();
        }
    }

    public View m24826a(Rect rect) {
        this.f15899C = new NearbyGuideMaskView(this);
        this.f15899C.setHoleRect(rect);
        this.f15911r.addView(this.f15899C);
        this.f15899C.setOnClickListener(new gil(this));
        return this.f15899C;
    }

    public void removeViewFromRootView(View view) {
        this.f15911r.removeView(view);
    }

    private void m24823w() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.f15905I, intentFilter);
    }

    private void m24824x() {
        hhx.m23867a(new gin(this, "UI.SyncData"));
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        fii.m19286a((Context) this);
        gvj.m22895a((Context) this, System.currentTimeMillis());
        m24804a(intent, false);
    }

    private boolean m24805a(Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return false;
        }
        return intent.getAction().equals("android.intent.action.VIEW");
    }

    private void m24804a(Intent intent, boolean z) {
        m24808b(intent);
        exw.m18443a("UI.MainActivity", "action=" + intent.getAction());
        Uri data = intent.getData();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action) || z || !(action.equals("com.ushareit.listenit.action.NOTIFICATION") || action.equals("com.ushareit.listenit.action.WIDGET"))) {
            if (data != null) {
                exw.m18443a("UI.MainActivity", "action=" + intent.getAction() + ", data=" + intent.getData() + ", scheme=" + data.getScheme() + ", path" + data.getPath());
            }
            if (action != null && data != null && data.getScheme() != null) {
                if ((data.getScheme().equals("file") || data.getScheme().equals("content")) && !fbb.m18763c(data.getPath())) {
                    hhx.m23869a(new gio(this, data.getScheme().equals("file") ? data.getPath() : grz.m22656a().m22662a((Context) this, intent.getData())), 0, 100);
                }
            }
        }
    }

    public void mo541k() {
        this.f15906J.sendEmptyMessageDelayed(4096, 1000);
    }

    protected void onStart() {
        super.onStart();
        if (this.f15914z != null && m4859m()) {
            this.f15914z.m20937U();
        }
    }

    protected void onResume() {
        super.onResume();
        this.f15901E.m19071d();
    }

    protected void onDestroy() {
        exw.m18443a("UI.MainActivity", "onDestroy()");
        unregisterReceiver(this.f15905I);
        hjb.m23923a();
        esr.m17804a();
        m24825y();
        grr.m22621a().m22645b();
        ((ListenItApp) getApplicationContext()).m4933a(false);
        gbe.m21585a().m21588b();
        super.onDestroy();
    }

    private void m24825y() {
        this.f15908o.setOnPageChangeListener(null);
        this.f15908o.removeAllViews();
        this.f15908o.removeAllViewsInLayout();
        this.f15909p.clear();
    }

    public boolean mo540i() {
        if (this.f15913y != null && this.f15913y.mo2549b()) {
            return true;
        }
        if (this.f15907n != null && this.f15907n.mo2549b()) {
            if (this.f15909p.size() > 0 && this.f15912t == this.f15909p.get(this.f15909p.size() - 1)) {
                this.f15912t.mo201x();
            }
            return true;
        } else if (this.f15914z != null && this.f15914z.mo2549b()) {
            return true;
        } else {
            if (this.f15909p.size() > 1) {
                if (((fji) this.f15909p.get(this.f15909p.size() - 1)).mo2549b()) {
                    return true;
                }
                this.f15908o.setCurrentItem(this.f15909p.size() - 2);
                return true;
            } else if (this.f15912t != null && this.f15912t.mo2549b()) {
                if (this.f15899C != null) {
                    removeViewFromRootView(this.f15899C);
                }
                return true;
            } else if (m4860n() != null && m4860n().mo2425a() && !m4860n().mo2437b()) {
                moveTaskToBack(false);
                return false;
            } else if (this.f15897A != 0 && System.currentTimeMillis() - this.f15897A <= 3000) {
                return false;
            } else {
                this.f15897A = System.currentTimeMillis();
                heb.m23597a(getString(C0349R.string.main_quit_tips), 0).show();
                return true;
            }
        }
    }

    public PlayerFragment m24836q() {
        return this.f15907n;
    }

    public void m24827a(fji com_ushareit_listenit_fji) {
        if (System.currentTimeMillis() - f15896s >= 500) {
            f15896s = System.currentTimeMillis();
            if (this.f15909p.size() > 0) {
                ((fji) this.f15909p.get(this.f15909p.size() - 1)).mo202y();
            }
            this.f15909p.add(com_ushareit_listenit_fji);
            this.f15910q.m18882a(this.f15909p);
            exw.m18449b("UI.MainActivity", "add fragmentsize=" + this.f15909p.size() + ", fragment=" + com_ushareit_listenit_fji.getClass().getSimpleName());
            this.f15908o.postDelayed(new gip(this, com_ushareit_listenit_fji), 200);
        }
    }

    public void m24829b(fji com_ushareit_listenit_fji) {
        if (System.currentTimeMillis() - f15896s >= 500) {
            f15896s = System.currentTimeMillis();
            if (this.f15909p.size() > 0) {
                ((fji) this.f15909p.get(this.f15909p.size() - 1)).mo202y();
            }
            this.f15909p.add(com_ushareit_listenit_fji);
            this.f15910q.m18882a(this.f15909p);
            exw.m18449b("UI.MainActivity", "add fragmentsize=" + this.f15909p.size() + ", fragment=" + com_ushareit_listenit_fji.getClass().getSimpleName());
            if (com_ushareit_listenit_fji.m19527a()) {
                gyn.m23214b((ak) this.f15908o.getContext());
            }
            gyn.m23190a(this.f15908o);
            this.f15908o.setCurrentItem(this.f15909p.size() - 1);
        }
    }

    public void m24830c(fji com_ushareit_listenit_fji) {
        if (com_ushareit_listenit_fji != null && this.f15909p.size() != 1 && this.f15909p.contains(com_ushareit_listenit_fji)) {
            this.f15908o.post(new giq(this));
        }
    }

    public View m24837r() {
        return this.f15908o;
    }

    private void m24808b(Intent intent) {
        String action = intent.getAction();
        if (action != null && action.equalsIgnoreCase("android.intent.action.VIEW")) {
            fid.m19230a(this, fid.m19229a("fm_thirdparty"));
        }
    }
}
