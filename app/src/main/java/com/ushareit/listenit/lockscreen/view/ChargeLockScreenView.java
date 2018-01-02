package com.ushareit.listenit.lockscreen.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.few;
import com.ushareit.listenit.gcy;
import com.ushareit.listenit.gcz;
import com.ushareit.listenit.gda;
import com.ushareit.listenit.gdc;
import com.ushareit.listenit.gdd;
import com.ushareit.listenit.gde;
import com.ushareit.listenit.gdo;
import com.ushareit.listenit.gvj;

public class ChargeLockScreenView extends RelativeLayout {
    public FrameLayout f15685a;
    private View f15686b;
    private ScreenTimeView f15687c;
    private ScreenBatteryView f15688d;
    private VerticalDragLayout f15689e;
    private MiniBatteryView f15690f;
    private boolean f15691g = true;
    private few f15692h;
    private gcz f15693i = new gdd(this);
    private gdo f15694j = new gde(this);

    public ChargeLockScreenView(Context context) {
        super(context);
        m24535a(context);
    }

    public ChargeLockScreenView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24535a(context);
    }

    public ChargeLockScreenView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24535a(context);
    }

    private void m24535a(Context context) {
        LayoutInflater.from(context).inflate(C0349R.layout.screen_main_page, this);
        this.f15686b = findViewById(C0349R.id.root_view);
        this.f15687c = (ScreenTimeView) findViewById(C0349R.id.screenTimeView);
        this.f15690f = (MiniBatteryView) findViewById(C0349R.id.collapseBatteryView);
        this.f15689e = (VerticalDragLayout) findViewById(C0349R.id.vertical_drag_layout);
        this.f15688d = (ScreenBatteryView) findViewById(C0349R.id.screenBatteryView);
        this.f15685a = (FrameLayout) findViewById(C0349R.id.ad_container);
        gcy.m21713a().m21719a(this.f15693i);
        this.f15692h = new few(this);
        m24537b(context);
    }

    private void m24537b(Context context) {
        m24538c(context);
        m24543e();
        m24541d();
    }

    private void m24541d() {
        post(new gdc(this));
    }

    private void m24543e() {
        this.f15689e.m24614d(false);
        this.f15689e.m24613c(false);
        this.f15689e.m24611a(false);
        this.f15689e.m24609a(this.f15694j);
    }

    private void m24538c(Context context) {
        this.f15690f.m24554a();
        exw.m18454c("dzt_", "initBatteryUi.. isCharging =" + gda.m21728a(context));
        if (gvj.m22869H() && gda.m21728a(context)) {
            this.f15688d.m24572d();
            this.f15687c.m24584b(false);
            return;
        }
        this.f15687c.m24582a(false);
        this.f15688d.m24571c();
    }

    public void m24545a() {
        exw.m18449b("ScreenLockMainView", "collapseBatteryView");
        this.f15688d.m24566a(0.0f);
        this.f15688d.m24571c();
        this.f15690f.m24557b();
        this.f15689e.m24612b(this.f15691g);
    }

    public void m24546b() {
        exw.m18449b("ScreenLockMainView", "expandBatteryView");
        this.f15690f.m24554a();
        this.f15688d.m24572d();
        this.f15688d.m24566a((float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        this.f15689e.m24611a(this.f15691g);
    }

    public void m24547c() {
        gcy.m21713a().m21722b(this.f15693i);
        this.f15687c.m24585c();
        this.f15689e.m24610a();
        this.f15692h.m19046a();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m24547c();
    }
}
