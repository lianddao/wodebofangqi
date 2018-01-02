package com.ushareit.listenit.lockscreen.view;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.erj;
import com.ushareit.listenit.gcy;
import com.ushareit.listenit.gda;
import com.ushareit.listenit.gyb;

public class ScreenBatteryView extends FrameLayout {
    private ImageView f15711a;
    private TextView f15712b;
    private TextView f15713c;
    private TextView f15714d;
    private ImageView f15715e;
    private ImageView f15716f;
    private ImageView f15717g;
    private View f15718h;
    private PowerDotLayout f15719i;
    private boolean f15720j = false;

    public ScreenBatteryView(Context context) {
        super(context);
        m24564e();
    }

    public ScreenBatteryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24564e();
    }

    private void m24564e() {
        LayoutInflater.from(getContext()).inflate(C0349R.layout.screen_battery_view, this);
        this.f15719i = (PowerDotLayout) findViewById(C0349R.id.power_dot);
        this.f15718h = findViewById(C0349R.id.battery_expanded);
        this.f15711a = (ImageView) findViewById(C0349R.id.img_charging_status);
        try {
            this.f15711a.setImageResource(C0349R.drawable.screen_batrery_level);
        } catch (OutOfMemoryError e) {
            gyb.m23123a().m23134b();
            this.f15711a.setImageResource(C0349R.drawable.screen_battery_50);
        }
        this.f15712b = (TextView) findViewById(C0349R.id.tv_charging_status);
        this.f15713c = (TextView) findViewById(C0349R.id.charging_status_des);
        this.f15714d = (TextView) findViewById(C0349R.id.charging_time);
        this.f15715e = (ImageView) findViewById(C0349R.id.screen_arrow);
        m24568a(false);
        this.f15716f = (ImageView) findViewById(C0349R.id.screen_battery_big_bg);
        this.f15717g = (ImageView) findViewById(C0349R.id.screen_battery_small_bg);
    }

    public void m24568a(boolean z) {
        this.f15715e.setVisibility(z ? 0 : 4);
        invalidate();
    }

    public void m24567a(int i, String str) {
        this.f15711a.setImageLevel(i);
        this.f15712b.setText(i + "%");
        this.f15713c.setVisibility(0);
        this.f15714d.setVisibility(0);
        this.f15713c.setText(gda.m21725a(i));
        if (!TextUtils.isEmpty(str)) {
            this.f15714d.setText(str);
        }
    }

    public void m24565a() {
        this.f15713c.setVisibility(4);
        this.f15714d.setVisibility(4);
        this.f15719i.m24563b();
    }

    public void m24569b() {
        this.f15713c.setVisibility(0);
        this.f15714d.setVisibility(0);
        this.f15719i.m24562a();
    }

    public void m24570b(boolean z) {
        if (z) {
            m24569b();
        } else {
            m24565a();
        }
    }

    public void m24566a(float f) {
        if (((double) f) < 0.5d || f > DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            erj.m17570a(this.f15718h, 0.0f);
            erj.m17572c(this.f15718h, 0.0f);
            erj.m17573d(this.f15718h, 0.0f);
        } else {
            erj.m17570a(this.f15718h, (2.0f * f) - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            erj.m17572c(this.f15718h, (2.0f * f) - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            erj.m17573d(this.f15718h, (2.0f * f) - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        }
        if (((double) f) < 0.8d || f > DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            this.f15715e.setImageResource(C0349R.drawable.screen_arrow_down);
        } else {
            this.f15715e.setImageResource(C0349R.drawable.screen_arrow_up);
        }
        if (((double) f) < 0.8d || f > DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            erj.m17572c(this.f15716f, 0.0f);
            erj.m17573d(this.f15716f, 0.0f);
            erj.m17570a(this.f15716f, 0.0f);
        } else {
            erj.m17572c(this.f15716f, (5.0f * f) - 4.0f);
            erj.m17573d(this.f15716f, (5.0f * f) - 4.0f);
            erj.m17570a(this.f15716f, (5.0f * f) - 4.0f);
        }
        if (((double) f) < 0.9d || f > DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            erj.m17572c(this.f15717g, 0.0f);
            erj.m17573d(this.f15717g, 0.0f);
            erj.m17570a(this.f15717g, 0.0f);
            return;
        }
        erj.m17572c(this.f15717g, (10.0f * f) - 9.0f);
        erj.m17573d(this.f15717g, (10.0f * f) - 9.0f);
        erj.m17570a(this.f15717g, (10.0f * f) - 9.0f);
    }

    public void m24571c() {
        setVisibility(4);
    }

    public void m24572d() {
        setVisibility(0);
        if (!this.f15720j) {
            gcy.m21713a().m21718a(getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")), getContext());
            this.f15720j = true;
        }
    }
}
