package com.ushareit.listenit.lockscreen.view;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.gcy;
import com.ushareit.listenit.gda;
import com.ushareit.listenit.gyb;

public class MiniBatteryView extends FrameLayout {
    private ImageView f15702a;
    private TextView f15703b;
    private TextView f15704c;
    private TextView f15705d;
    private boolean f15706e = false;

    public MiniBatteryView(Context context) {
        super(context);
        m24553a(context);
    }

    public MiniBatteryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24553a(context);
    }

    public MiniBatteryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24553a(context);
    }

    private void m24553a(Context context) {
        LayoutInflater.from(context).inflate(C0349R.layout.screen_collapse_battery_view, this);
        this.f15702a = (ImageView) findViewById(C0349R.id.iv_battery_status);
        this.f15703b = (TextView) findViewById(C0349R.id.tv_charging_status);
        this.f15704c = (TextView) findViewById(C0349R.id.charging_describe);
        this.f15705d = (TextView) findViewById(C0349R.id.charging_left_time);
        try {
            this.f15702a.setImageResource(C0349R.drawable.screen_batrery_level);
        } catch (OutOfMemoryError e) {
            gyb.m23123a().m23134b();
            this.f15702a.setImageResource(C0349R.drawable.screen_battery_50);
        }
    }

    public void m24555a(int i, String str) {
        this.f15702a.setImageLevel(i);
        this.f15703b.setText(i + "%");
        this.f15704c.setText(gda.m21725a(i));
        if (TextUtils.isEmpty(str)) {
            this.f15705d.setText("");
        } else {
            this.f15705d.setText(str);
        }
    }

    public void m24556a(boolean z) {
        if (z) {
            this.f15704c.setVisibility(0);
            this.f15705d.setVisibility(0);
            return;
        }
        this.f15704c.setVisibility(4);
        this.f15705d.setVisibility(4);
    }

    public void m24554a() {
        setVisibility(8);
    }

    public void m24557b() {
        setVisibility(0);
        if (!this.f15706e) {
            gcy.m21713a().m21718a(getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")), getContext());
            this.f15706e = true;
        }
    }
}
