package com.ushareit.listenit.lockscreen.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.eqy;
import com.ushareit.listenit.gdj;
import com.ushareit.listenit.gdk;
import com.ushareit.listenit.gdl;
import com.ushareit.listenit.gyn;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ScreenTimeView extends FrameLayout {
    private TextView f15721a;
    private TextView f15722b;
    private TextView f15723c;
    private boolean f15724d;
    private int f15725e;
    private int f15726f;
    private int f15727g;
    private int f15728h;
    private BroadcastReceiver f15729i = new gdj(this);

    public ScreenTimeView(Context context) {
        super(context);
        m24573a(context);
    }

    public ScreenTimeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24573a(context);
    }

    public ScreenTimeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24573a(context);
    }

    private void m24573a(Context context) {
        LayoutInflater.from(context).inflate(C0349R.layout.screen_time_weather_view, this);
        this.f15721a = (TextView) findViewById(C0349R.id.screen_time);
        this.f15722b = (TextView) findViewById(C0349R.id.screen_date);
        this.f15723c = (TextView) findViewById(C0349R.id.screen_week);
        this.f15725e = getResources().getDimensionPixelSize(C0349R.dimen.common_dimens_60sp);
        this.f15726f = getResources().getDimensionPixelSize(C0349R.dimen.common_dimens_75sp);
        this.f15727g = getResources().getDimensionPixelOffset(C0349R.dimen.common_dimens_85dp);
        this.f15728h = getResources().getDimensionPixelOffset(C0349R.dimen.common_dimens_45dp);
        m24578d();
        m24581a();
    }

    private void m24578d() {
        this.f15721a.setText(getCurrentTime());
        this.f15722b.setText(getCurrentDate());
        this.f15723c.setText(getCurrentWeek());
    }

    public void m24581a() {
        try {
            getContext().registerReceiver(this.f15729i, new IntentFilter("android.intent.action.TIME_TICK"));
        } catch (Exception e) {
        }
    }

    public void m24583b() {
        try {
            getContext().unregisterReceiver(this.f15729i);
        } catch (Exception e) {
        }
    }

    private String getCurrentTime() {
        return new SimpleDateFormat("HH:mm", Locale.US).format(new Date(System.currentTimeMillis()));
    }

    private String getCurrentDate() {
        return new SimpleDateFormat("MM/dd", Locale.US).format(new Date(System.currentTimeMillis()));
    }

    private String getCurrentWeek() {
        int i = Calendar.getInstance().get(7);
        String str = "";
        if (i == 2) {
            return getResources().getString(C0349R.string.week_abbreviation_monday);
        }
        if (i == 3) {
            return getResources().getString(C0349R.string.week_abbreviation_tuesday);
        }
        if (i == 4) {
            return getResources().getString(C0349R.string.week_abbreviation_wednesday);
        }
        if (i == 5) {
            return getResources().getString(C0349R.string.week_abbreviation_thursday);
        }
        if (i == 6) {
            return getResources().getString(C0349R.string.week_abbreviation_friday);
        }
        if (i == 7) {
            return getResources().getString(C0349R.string.week_abbreviation_saturday);
        }
        if (i == 1) {
            return getResources().getString(C0349R.string.week_abbreviation_sunday);
        }
        return str;
    }

    public void m24582a(boolean z) {
        if (!this.f15724d) {
            if (z) {
                eqy c = eqy.m17366b(0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT).mo2252c(500);
                c.m17384a(new gdk(this));
                c.mo2234a();
            } else {
                this.f15721a.setTextSize(0, (float) this.f15726f);
                gyn.m23237e(this, this.f15728h);
            }
            this.f15724d = true;
        }
    }

    public void m24584b(boolean z) {
        if (this.f15724d) {
            if (z) {
                eqy c = eqy.m17366b(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.0f).mo2252c(500);
                c.m17384a(new gdl(this));
                c.mo2234a();
            } else {
                this.f15721a.setTextSize(0, (float) this.f15725e);
                gyn.m23237e(this, this.f15727g);
            }
            this.f15724d = false;
        }
    }

    public void m24585c() {
        eqy.m17372m();
        m24583b();
    }
}
