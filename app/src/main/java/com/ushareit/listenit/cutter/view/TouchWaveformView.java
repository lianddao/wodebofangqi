package com.ushareit.listenit.cutter.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fpm;
import com.ushareit.listenit.fpr;
import com.ushareit.listenit.fpw;
import com.ushareit.listenit.fpx;
import com.ushareit.listenit.fpy;
import com.ushareit.listenit.fpz;
import com.ushareit.listenit.fqa;
import com.ushareit.listenit.fqb;
import com.ushareit.listenit.fqc;
import com.ushareit.listenit.fqd;
import com.ushareit.listenit.fqj;
import com.ushareit.listenit.gyn;

public class TouchWaveformView extends RelativeLayout {
    private long f9077A;
    private boolean f9078B;
    private boolean f9079C;
    private boolean f9080D;
    private float f9081E;
    private OnClickListener f9082F = new fpz(this);
    private OnClickListener f9083G = new fqa(this);
    private fpr f9084H = new fqb(this);
    private fqj f9085I = new fqc(this);
    private WaveformView f9086a;
    private View f9087b;
    private View f9088c;
    private WavePlayerView f9089d;
    private TextView f9090e;
    private TextView f9091f;
    private MarkerView f9092g;
    private MarkerView f9093h;
    private fqd f9094i;
    private Handler f9095j = new Handler();
    private int f9096k;
    private int f9097l;
    private int f9098m;
    private int f9099n;
    private int f9100o;
    private int f9101p;
    private int f9102q;
    private int f9103r;
    private int f9104s;
    private int f9105t;
    private int f9106u;
    private int f9107v;
    private int f9108w;
    private int f9109x;
    private int f9110y;
    private int f9111z;

    public TouchWaveformView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(context, C0349R.layout.touch_waveform_view, this);
        m12866e();
        m12869f();
        m12871g();
    }

    public void setMarkerMoveCallback(fqd com_ushareit_listenit_fqd) {
        this.f9094i = com_ushareit_listenit_fqd;
    }

    public void m12904a(fpm com_ushareit_listenit_fpm) {
        this.f9086a.setSoundFile(com_ushareit_listenit_fpm);
        this.f9086a.m12946g();
        this.f9092g.setVisibility(0);
        this.f9093h.setVisibility(0);
        this.f9096k = this.f9086a.m12945f();
        int c = fbb.m18762c(getContext());
        if (this.f9096k > c) {
            this.f9097l = c / 4;
            this.f9098m = (c * 3) / 4;
        } else {
            this.f9097l = this.f9086a.m12938b(10.0d);
            this.f9098m = this.f9086a.m12938b(15.0d);
            if (this.f9098m > this.f9096k) {
                this.f9098m = this.f9096k;
            }
        }
        m12901a();
        m12906b();
    }

    public void m12901a() {
        double a = this.f9086a.m12934a(this.f9097l);
        double a2 = this.f9086a.m12934a(this.f9098m);
        this.f9109x = this.f9086a.m12935a(a);
        this.f9110y = this.f9086a.m12935a(a2) - this.f9109x;
        this.f9111z = (int) ((a2 - a) + 0.5d);
    }

    public int getStartFrame() {
        return this.f9109x;
    }

    public int getStartPos() {
        return this.f9097l;
    }

    public int getEndPos() {
        return this.f9098m;
    }

    public int getTotalFrame() {
        return this.f9110y;
    }

    public int getDuration() {
        return this.f9111z;
    }

    public void setPlayback(int i) {
        this.f9086a.setPlayback(i);
    }

    public void setIsAfterScrollWaveform(boolean z) {
        this.f9078B = z;
    }

    public void setButtonsEnable(boolean z) {
        this.f9092g.setEnabled(z);
        this.f9093h.setEnabled(z);
        this.f9086a.setEnabled(z);
        this.f9087b.setEnabled(z);
        this.f9088c.setEnabled(z);
    }

    public int m12900a(int i) {
        return this.f9086a.m12941c(i);
    }

    public int m12905b(int i) {
        if (i < this.f9097l) {
            return this.f9086a.m12941c(this.f9097l);
        }
        if (i > this.f9098m) {
            return this.f9086a.m12941c(this.f9096k);
        }
        return this.f9086a.m12941c(this.f9098m);
    }

    public void m12903a(WavePlayerView wavePlayerView) {
        this.f9089d = wavePlayerView;
    }

    public synchronized void m12906b() {
        if (this.f9089d != null && this.f9089d.m12916a()) {
            int nowPosition = this.f9089d.getNowPosition();
            int b = this.f9086a.m12939b(nowPosition);
            this.f9086a.setPlayback(b);
            if (!this.f9078B) {
                setOffsetGoalNoUpdate(b - (this.f9100o / 2));
            }
            if (nowPosition >= this.f9089d.getPlayEndMillisecond()) {
                this.f9089d.m12917b();
            }
        }
        m12881j();
        m12850a(this.f9092g, this.f9097l, this.f9103r);
        m12849a(this.f9090e, this.f9097l);
        m12850a(this.f9093h, this.f9098m, (this.f9086a.getMeasuredHeight() - this.f9093h.getHeight()) - this.f9104s);
        m12849a(this.f9091f, this.f9098m);
    }

    public void m12907c() {
        this.f9092g.requestFocus();
        m12902a(this.f9092g);
    }

    public void m12908d() {
        this.f9093h.requestFocus();
        m12902a(this.f9093h);
    }

    public void m12902a(MarkerView markerView) {
        this.f9080D = false;
        if (markerView == this.f9092g) {
            setOffsetGoalStartNoUpdate();
        } else {
            setOffsetGoalEndNoUpdate();
        }
        this.f9095j.postDelayed(new fpw(this), 100);
    }

    private void m12866e() {
        this.f9086a = (WaveformView) findViewById(C0349R.id.waveform);
        this.f9086a.setListener(this.f9085I);
    }

    private void m12869f() {
        float f = fbb.m18767f(getContext());
        this.f9103r = (int) (60.0f * f);
        this.f9104s = (int) (f * 35.0f);
        this.f9092g = (MarkerView) findViewById(C0349R.id.start_marker);
        this.f9092g.setListener(this.f9084H);
        this.f9092g.setFocusable(true);
        this.f9092g.setFocusableInTouchMode(true);
        this.f9093h = (MarkerView) findViewById(C0349R.id.end_marker);
        this.f9093h.setListener(this.f9084H);
        this.f9093h.setFocusable(true);
        this.f9093h.setFocusableInTouchMode(true);
        this.f9090e = (TextView) findViewById(C0349R.id.start_time_text);
        this.f9091f = (TextView) findViewById(C0349R.id.end_time_text);
        post(new fpx(this));
    }

    private void m12871g() {
        this.f9087b = findViewById(C0349R.id.zoom_in);
        this.f9087b.setOnClickListener(this.f9082F);
        this.f9088c = findViewById(C0349R.id.zoom_out);
        this.f9088c.setOnClickListener(this.f9083G);
    }

    private void setOffsetGoalStartNoUpdate() {
        setOffsetGoalNoUpdate(this.f9097l - (this.f9100o / 2));
    }

    private void setOffsetGoalEndNoUpdate() {
        setOffsetGoalNoUpdate(this.f9098m - (this.f9100o / 2));
    }

    private void m12875h() {
        this.f9097l = this.f9086a.getStart();
        this.f9098m = this.f9086a.getEnd();
        this.f9096k = this.f9086a.m12945f();
        this.f9102q = this.f9086a.getOffset();
        this.f9101p = this.f9102q;
        m12878i();
        m12906b();
    }

    private void m12878i() {
        this.f9087b.setEnabled(this.f9086a.m12940b());
        this.f9088c.setEnabled(this.f9086a.m12943d());
    }

    private void setOffsetGoalNoUpdate(int i) {
        if (!this.f9079C) {
            this.f9101p = i;
            if (this.f9101p + (this.f9100o / 2) > this.f9096k) {
                this.f9101p = this.f9096k - (this.f9100o / 2);
            }
            if (this.f9101p < 0) {
                this.f9101p = 0;
            }
        }
    }

    private void m12850a(MarkerView markerView, int i, int i2) {
        int i3;
        int width = markerView.getWidth();
        int i4 = (i - this.f9102q) - (width / 2);
        if (i4 + width < 0) {
            if (markerView.isShown()) {
                markerView.setVisibility(4);
            }
            i3 = 0;
        } else if (markerView.isShown()) {
            i3 = i4;
        } else {
            this.f9095j.postDelayed(new fpy(this, markerView), 0);
            i3 = i4;
        }
        LayoutParams layoutParams = (LayoutParams) markerView.getLayoutParams();
        layoutParams.setMargins(i3, i2, -width, -markerView.getHeight());
        markerView.setLayoutParams(layoutParams);
    }

    private void m12849a(TextView textView, int i) {
        LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
        layoutParams.setMargins((i - this.f9102q) - (textView.getWidth() / 2), this.f9105t / 2, -textView.getWidth(), -textView.getHeight());
        textView.setLayoutParams(layoutParams);
        textView.setText(m12859c(i));
    }

    private String m12859c(int i) {
        if (this.f9086a == null || !this.f9086a.m12937a()) {
            return "";
        }
        return gyn.m23182a((long) this.f9086a.m12941c(i));
    }

    private void m12881j() {
        int i = 0;
        if (!this.f9079C) {
            int i2;
            if (this.f9099n != 0) {
                i2 = this.f9099n / 30;
                if (this.f9099n > 80) {
                    this.f9099n -= 80;
                } else if (this.f9099n < -80) {
                    this.f9099n += 80;
                } else {
                    this.f9099n = 0;
                }
                this.f9102q = i2 + this.f9102q;
                if (this.f9102q + (this.f9100o / 2) > this.f9096k) {
                    this.f9102q = this.f9096k - (this.f9100o / 2);
                    this.f9099n = 0;
                }
                if (this.f9102q < 0) {
                    this.f9102q = 0;
                    this.f9099n = 0;
                }
                this.f9101p = this.f9102q;
            } else {
                i2 = this.f9101p - this.f9102q;
                if (i2 > 5) {
                    i = i2 / 5;
                } else if (i2 > 0) {
                    i = 1;
                } else if (i2 < -5) {
                    i = i2 / 5;
                } else if (i2 < 0) {
                    i = -1;
                }
                this.f9102q = i + this.f9102q;
            }
        }
        this.f9086a.setParameters(this.f9097l, this.f9098m, this.f9102q);
        this.f9086a.invalidate();
    }

    private long getCurrentTime() {
        return System.nanoTime() / 1000000;
    }

    private int m12861d(int i) {
        if (i < 0) {
            return 0;
        }
        if (i > this.f9096k) {
            return this.f9096k;
        }
        return i;
    }
}
