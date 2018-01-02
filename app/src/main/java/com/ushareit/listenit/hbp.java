package com.ushareit.listenit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.mopub.volley.DefaultRetryPolicy;

public class hbp {
    private float f15137a;
    private float f15138b;
    private float f15139c;
    private float f15140d;
    private float f15141e;
    private float f15142f;
    private int f15143g = 0;
    private int f15144h;
    private int f15145i;
    private int f15146j = -1;
    private boolean f15147k = false;
    private ListView f15148l = null;
    private SectionIndexer f15149m = null;
    private String[] f15150n = null;
    private RectF f15151o;
    private int f15152p;
    private int f15153q;
    private int f15154r;
    private boolean f15155s = true;
    private Handler f15156t = new hbq(this);

    public hbp(Context context, ListView listView) {
        this.f15140d = context.getResources().getDisplayMetrics().density;
        this.f15141e = context.getResources().getDisplayMetrics().scaledDensity;
        this.f15148l = listView;
        m23535a(this.f15148l.getAdapter());
        this.f15137a = 16.0f * this.f15140d;
        this.f15138b = 2.0f * this.f15140d;
        this.f15139c = 5.0f * this.f15140d;
        if (((ListenItApp) context.getApplicationContext()).m4934b() == 1) {
            this.f15152p = context.getResources().getColor(C0349R.color.common_dialog_background_color_night);
            this.f15153q = context.getResources().getColor(C0349R.color.common_text_color_black_night);
            this.f15154r = this.f15153q;
            return;
        }
        this.f15152p = 1610612736;
        this.f15153q = -1;
        this.f15154r = CtaButton.BACKGROUND_COLOR;
    }

    public void m23534a(Canvas canvas) {
        int i = 0;
        if (this.f15143g != 0 && this.f15150n != null && this.f15150n.length > 0) {
            Paint paint;
            float measureText;
            if (this.f15146j >= 0) {
                paint = new Paint();
                paint.setColor(this.f15152p);
                paint.setAntiAlias(true);
                paint.setShadowLayer(3.0f, 0.0f, 0.0f, Color.argb(64, 0, 0, 0));
                Paint paint2 = new Paint();
                paint2.setColor(this.f15153q);
                paint2.setAntiAlias(true);
                paint2.setTextSize(50.0f * this.f15141e);
                measureText = paint2.measureText(this.f15150n[this.f15146j]);
                float descent = ((this.f15139c * 2.0f) + paint2.descent()) - paint2.ascent();
                RectF rectF = new RectF((((float) this.f15144h) - descent) / 2.0f, (((float) this.f15145i) - descent) / 2.0f, ((((float) this.f15144h) - descent) / 2.0f) + descent, ((((float) this.f15145i) - descent) / 2.0f) + descent);
                canvas.drawRoundRect(rectF, 5.0f * this.f15140d, 5.0f * this.f15140d, paint);
                canvas.drawText(this.f15150n[this.f15146j], (((descent - measureText) / 2.0f) + rectF.left) - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, ((rectF.top + this.f15139c) - paint2.ascent()) + DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, paint2);
            }
            paint = new Paint();
            paint.setColor(this.f15154r);
            paint.setAlpha((int) (125.0f * this.f15142f));
            paint.setAntiAlias(true);
            paint.setTextSize(12.0f * this.f15141e);
            float height = (this.f15151o.height() - (this.f15138b * 2.0f)) / ((float) this.f15150n.length);
            measureText = (height - (paint.descent() - paint.ascent())) / 2.0f;
            while (i < this.f15150n.length) {
                canvas.drawText(this.f15150n[i], ((this.f15137a - paint.measureText(this.f15150n[i])) / 2.0f) + this.f15151o.left, (((this.f15151o.top + this.f15138b) + (((float) i) * height)) + measureText) - paint.ascent(), paint);
                i++;
            }
        }
    }

    public boolean m23538a(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.f15143g != 0 && m23537a(motionEvent.getX(), motionEvent.getY())) {
                    m23527a(2);
                    this.f15147k = true;
                    this.f15146j = m23525a(motionEvent.getY());
                    this.f15148l.setSelection(this.f15149m.getPositionForSection(this.f15146j));
                    return true;
                }
            case 1:
                if (this.f15147k) {
                    this.f15147k = false;
                    this.f15146j = -1;
                }
                if (this.f15143g == 2) {
                    m23527a(3);
                    break;
                }
                break;
            case 2:
                if (this.f15147k) {
                    if (!m23537a(motionEvent.getX(), motionEvent.getY())) {
                        return true;
                    }
                    this.f15146j = m23525a(motionEvent.getY());
                    this.f15148l.setSelection(this.f15149m.getPositionForSection(this.f15146j));
                    return true;
                }
                break;
        }
        return false;
    }

    public void m23533a(int i, int i2, int i3, int i4) {
        this.f15144h = i;
        this.f15145i = i2;
        this.f15151o = new RectF(((float) i) - this.f15137a, this.f15138b, ((float) i) - this.f15138b, ((float) i2) - this.f15138b);
    }

    public boolean m23536a() {
        return this.f15143g != 0;
    }

    public void m23539b() {
        if (this.f15143g == 0) {
            m23527a(1);
        } else if (this.f15143g == 3) {
            m23527a(3);
        }
    }

    public void m23540c() {
        if (this.f15143g == 2) {
            m23527a(3);
        }
    }

    public void m23541d() {
        this.f15155s = false;
    }

    public void m23542e() {
        this.f15155s = true;
    }

    public boolean m23543f() {
        return this.f15155s;
    }

    public void m23535a(Adapter adapter) {
        if (adapter instanceof SectionIndexer) {
            this.f15149m = (SectionIndexer) adapter;
            this.f15150n = (String[]) this.f15149m.getSections();
        }
    }

    private void m23527a(int i) {
        if (i >= 0 && i <= 3) {
            this.f15143g = i;
            switch (this.f15143g) {
                case 0:
                    this.f15156t.removeMessages(0);
                    return;
                case 1:
                    this.f15142f = 0.0f;
                    m23528a(0);
                    return;
                case 2:
                    this.f15156t.removeMessages(0);
                    return;
                case 3:
                    this.f15142f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
                    m23528a(1000);
                    return;
                default:
                    return;
            }
        }
    }

    public boolean m23537a(float f, float f2) {
        return f >= this.f15151o.left && f2 >= this.f15151o.top && f2 <= this.f15151o.top + this.f15151o.height();
    }

    private int m23525a(float f) {
        if (this.f15150n == null || this.f15150n.length == 0 || f < this.f15151o.top + this.f15138b) {
            return 0;
        }
        if (f >= (this.f15151o.top + this.f15151o.height()) - this.f15138b) {
            return this.f15150n.length - 1;
        }
        return (int) (((f - this.f15151o.top) - this.f15138b) / ((this.f15151o.height() - (2.0f * this.f15138b)) / ((float) this.f15150n.length)));
    }

    private void m23528a(long j) {
        this.f15156t.removeMessages(0);
        this.f15156t.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + j);
    }

    public void m23544g() {
        this.f15156t.removeMessages(0);
    }
}
