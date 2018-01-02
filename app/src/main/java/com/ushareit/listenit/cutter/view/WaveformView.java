package com.ushareit.listenit.cutter.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.mopub.volley.DefaultRetryPolicy;
import com.umeng.analytics.pro.C0277j;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fpm;
import com.ushareit.listenit.fqh;
import com.ushareit.listenit.fqi;
import com.ushareit.listenit.fqj;
import com.ushareit.listenit.gzd;

public class WaveformView extends View {
    private ScaleGestureDetector f9122A;
    private boolean f9123B;
    private int f9124C;
    private int f9125D;
    private int f9126E;
    private int f9127F;
    private int f9128G;
    private int f9129H;
    private int f9130I;
    private Paint f9131a;
    private float f9132b = this.f9139i.measureText("00:00");
    private Paint f9133c;
    private Paint f9134d;
    private Paint f9135e;
    private Paint f9136f;
    private Paint f9137g;
    private Paint f9138h;
    private Paint f9139i;
    private fpm f9140j;
    private int[] f9141k;
    private double[][] f9142l;
    private double[] f9143m;
    private int[] f9144n;
    private int f9145o;
    private int f9146p;
    private int f9147q;
    private int f9148r;
    private int f9149s = 0;
    private int f9150t = 0;
    private int f9151u = 0;
    private int f9152v = -1;
    private float f9153w;
    private float f9154x;
    private fqj f9155y;
    private GestureDetector f9156z;

    public WaveformView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFocusable(false);
        m12933l();
        m12924a(context);
        this.f9153w = fbb.m18767f(context);
        this.f9123B = false;
        this.f9124C = (int) (12.0f * this.f9153w);
        this.f9125D = (int) (25.0f * this.f9153w);
        this.f9126E = this.f9125D - ((int) (16.0f * this.f9153w));
        this.f9127F = this.f9125D - ((int) (5.0f * this.f9153w));
        this.f9128G = (int) (230.0f * this.f9153w);
    }

    public void setSoundFile(fpm com_ushareit_listenit_fpm) {
        this.f9140j = com_ushareit_listenit_fpm;
        this.f9147q = this.f9140j.mo2519f();
        this.f9148r = this.f9140j.mo2516c();
        m12929h();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f9140j != null) {
            if (this.f9144n == null) {
                m12932k();
            }
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int i = this.f9149s;
            int length = this.f9144n.length - i;
            int i2 = ((measuredHeight - this.f9125D) / 2) + this.f9125D;
            if (length > measuredWidth) {
                length = measuredWidth;
            }
            m12925a(canvas, measuredWidth);
            m12926a(canvas, i, length, measuredHeight, i2);
            while (length < measuredWidth) {
                canvas.drawLine((float) length, (float) this.f9125D, (float) length, (float) measuredHeight, this.f9136f);
                length++;
            }
            canvas.drawLine(((float) (this.f9150t - this.f9149s)) + 0.5f, (float) this.f9125D, ((float) (this.f9150t - this.f9149s)) + 0.5f, (float) measuredHeight, this.f9137g);
            canvas.drawLine(((float) (this.f9151u - this.f9149s)) + 0.5f, (float) this.f9125D, ((float) (this.f9151u - this.f9149s)) + 0.5f, (float) measuredHeight, this.f9137g);
            if (this.f9155y != null) {
                this.f9155y.mo2532a();
            }
        }
    }

    private void m12925a(Canvas canvas, int i) {
        Object obj;
        canvas.drawRect(0.0f, 0.0f, (float) i, (float) this.f9125D, this.f9131a);
        canvas.drawLine(0.0f, (float) (this.f9125D - 1), (float) i, (float) (this.f9125D - 1), this.f9133c);
        double a = m12934a(1);
        if (a > 0.02d) {
            obj = 1;
        } else {
            obj = null;
        }
        double d = ((double) this.f9149s) * a;
        int i2 = (int) d;
        int i3 = 0;
        while (i3 < i) {
            int i4 = i3 + 1;
            double d2 = d + a;
            int i5 = (int) d2;
            if (i5 != i2) {
                if (obj == null || i5 % 5 == 0) {
                    canvas.drawLine((float) i4, (float) this.f9126E, (float) i4, (float) this.f9125D, this.f9133c);
                }
                if (obj != null && d2 - ((double) i5) < a) {
                    canvas.drawLine((float) i4, (float) this.f9127F, (float) i4, (float) this.f9125D, this.f9133c);
                }
                i2 = i5;
            }
            i3 = i4;
            d = d2;
        }
        double a2 = m12918a(a, i2);
        d = ((double) this.f9149s) * a;
        i2 = (int) (d / a2);
        i3 = 0;
        double d3 = d;
        while (i3 < i) {
            int i6 = i3 + 1;
            d3 += a;
            int i7 = (int) d3;
            i3 = (int) (d3 / a2);
            if (i3 != i2) {
                String str = "" + (i7 / 60);
                String str2 = "" + (i7 % 60);
                if (i7 % 60 < 10) {
                    str2 = "0" + str2;
                }
                str2 = str + ":" + str2;
                canvas.drawText(str2, ((float) i6) - ((float) (0.5d * ((double) this.f9139i.measureText(str2)))), (float) this.f9124C, this.f9139i);
                i2 = i3;
            }
            i3 = i6;
        }
    }

    private void m12926a(Canvas canvas, int i, int i2, int i3, int i4) {
        int i5;
        for (int i6 = 0; i6 < i2; i6++) {
            Paint paint;
            int i7 = i6 + i;
            if (i7 < this.f9150t || i7 >= this.f9151u) {
                canvas.drawLine((float) i6, (float) this.f9125D, (float) i6, (float) i3, this.f9136f);
                paint = this.f9135e;
            } else {
                paint = this.f9134d;
            }
            i5 = this.f9144n[i7];
            m12936a(canvas, i6, i4 - i5, (i4 + 1) + i5, paint);
        }
        i5 = this.f9152v - i;
        canvas.drawLine((float) i5, (float) this.f9125D, (float) i5, (float) i3, this.f9138h);
    }

    private double m12918a(double d, int i) {
        if (i / 60 < 10) {
            this.f9132b = this.f9139i.measureText("0:00") + 6.0f;
        }
        double d2 = 1.0d;
        if (1.0d / d < ((double) this.f9132b)) {
            d2 = 5.0d;
        }
        if (d2 / d < ((double) this.f9132b)) {
            d2 = 10.0d;
        }
        if (d2 / d < ((double) this.f9132b)) {
            return 20.0d;
        }
        return d2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f9122A.onTouchEvent(motionEvent);
        if (!this.f9156z.onTouchEvent(motionEvent)) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.f9155y.mo2533a(motionEvent.getX());
                    break;
                case 1:
                    this.f9155y.mo2537c(motionEvent.getX());
                    break;
                case 2:
                    this.f9155y.mo2535b(motionEvent.getX());
                    break;
                default:
                    break;
            }
        }
        return true;
    }

    public boolean m12937a() {
        return this.f9123B;
    }

    public int getCurrentZoomLevel() {
        return this.f9145o;
    }

    public void setCurrentZoomLevel(int i) {
        while (this.f9145o > i) {
            m12942c();
        }
        while (this.f9145o < i) {
            m12944e();
        }
    }

    public boolean m12940b() {
        return this.f9145o > 0;
    }

    public void m12942c() {
        if (m12940b()) {
            this.f9145o--;
            this.f9150t *= 2;
            this.f9151u *= 2;
            this.f9144n = null;
            this.f9149s = ((this.f9149s + (getMeasuredWidth() / 2)) * 2) - (getMeasuredWidth() / 2);
            if (this.f9149s < 0) {
                this.f9149s = 0;
            }
            invalidate();
        }
    }

    public boolean m12943d() {
        return this.f9145o < this.f9146p + -1;
    }

    public void m12944e() {
        if (m12943d()) {
            this.f9145o++;
            this.f9150t /= 2;
            this.f9151u /= 2;
            this.f9149s = ((this.f9149s + (getMeasuredWidth() / 2)) / 2) - (getMeasuredWidth() / 2);
            if (this.f9149s < 0) {
                this.f9149s = 0;
            }
            this.f9144n = null;
            invalidate();
        }
    }

    public int m12945f() {
        return this.f9141k[this.f9145o];
    }

    public int m12935a(double d) {
        return (int) ((((1.0d * d) * ((double) this.f9147q)) / ((double) this.f9148r)) + 0.5d);
    }

    public int m12938b(double d) {
        return (int) ((((this.f9143m[this.f9145o] * d) * ((double) this.f9147q)) / ((double) this.f9148r)) + 0.5d);
    }

    public double m12934a(int i) {
        return (((double) i) * ((double) this.f9148r)) / (this.f9143m[this.f9145o] * ((double) this.f9147q));
    }

    public int m12939b(int i) {
        return (int) (((this.f9143m[this.f9145o] * ((((double) i) * 1.0d) * ((double) this.f9147q))) / (1000.0d * ((double) this.f9148r))) + 0.5d);
    }

    public int m12941c(int i) {
        return (int) (((((double) i) * (1000.0d * ((double) this.f9148r))) / (this.f9143m[this.f9145o] * ((double) this.f9147q))) + 0.5d);
    }

    public void setParameters(int i, int i2, int i3) {
        this.f9150t = i;
        this.f9151u = i2;
        this.f9149s = i3;
    }

    public int getStart() {
        return this.f9150t;
    }

    public int getEnd() {
        return this.f9151u;
    }

    public int getOffset() {
        return this.f9149s;
    }

    public void setPlayback(int i) {
        this.f9152v = i;
    }

    public void setListener(fqj com_ushareit_listenit_fqj) {
        this.f9155y = com_ushareit_listenit_fqj;
    }

    public void m12946g() {
        this.f9144n = null;
        this.f9139i.setTextSize((float) this.f9124C);
        invalidate();
    }

    protected void m12936a(Canvas canvas, int i, int i2, int i3, Paint paint) {
        int i4 = (this.f9149s + i) % 3;
        if (i4 == 0) {
            canvas.drawLine((float) i, (float) i2, (float) i, (float) i3, paint);
            this.f9129H = i2;
            this.f9130I = i3;
        }
        if (i4 == 1 && i != 0) {
            canvas.drawLine((float) i, (float) this.f9129H, (float) i, (float) this.f9130I, paint);
        }
    }

    private void m12929h() {
        int i;
        int i2;
        int b = this.f9140j.mo2515b();
        int[] d = this.f9140j.mo2517d();
        double[] dArr = new double[b];
        if (b == 1) {
            dArr[0] = (double) d[0];
        } else if (b == 2) {
            dArr[0] = (double) d[0];
            dArr[1] = (double) d[1];
        } else if (b > 2) {
            dArr[0] = (((double) d[0]) / 2.0d) + (((double) d[1]) / 2.0d);
            for (int i3 = 1; i3 < b - 1; i3++) {
                dArr[i3] = ((((double) d[i3 - 1]) / 3.0d) + (((double) d[i3]) / 3.0d)) + (((double) d[i3 + 1]) / 3.0d);
            }
            dArr[b - 1] = (((double) d[b - 2]) / 2.0d) + (((double) d[b - 1]) / 2.0d);
        }
        double d2 = 1.0d;
        for (i = 0; i < b; i++) {
            if (dArr[i] > d2) {
                d2 = dArr[i];
            }
        }
        if (d2 > 255.0d) {
            d2 = 255.0d / d2;
        } else {
            d2 = 1.0d;
        }
        int[] iArr = new int[C0277j.f3694e];
        double d3 = 0.0d;
        for (int i4 = 0; i4 < b; i4++) {
            i2 = (int) (dArr[i4] * d2);
            if (i2 < 0) {
                i2 = 0;
            }
            if (i2 > 255) {
                i2 = 255;
            }
            if (((double) i2) > d3) {
                d3 = (double) i2;
            }
            iArr[i2] = iArr[i2] + 1;
        }
        double d4 = 0.0d;
        i2 = 0;
        while (d4 < 255.0d && i2 < b / 20) {
            i2 += iArr[(int) d4];
            d4 += 1.0d;
        }
        double d5 = d3;
        i = 0;
        while (d5 > 2.0d && i < b / 100) {
            i += iArr[(int) d5];
            d5 -= 1.0d;
        }
        double[] dArr2 = new double[b];
        double d6 = d5 - d4;
        for (i2 = 0; i2 < b; i2++) {
            d3 = ((dArr[i2] * d2) - d4) / d6;
            if (d3 < 0.0d) {
                d3 = 0.0d;
            }
            if (d3 > 1.0d) {
                d3 = 1.0d;
            }
            dArr2[i2] = d3 * d3;
        }
        m12930i();
        m12923a(b, dArr2);
        m12928b(b, dArr2);
        m12931j();
        if (b > 5000) {
            this.f9145o = 3;
        } else if (b > 1000) {
            this.f9145o = 2;
        } else if (b > 300) {
            this.f9145o = 1;
        } else {
            this.f9145o = 0;
        }
        this.f9123B = true;
    }

    private void m12930i() {
        this.f9146p = 5;
        this.f9141k = new int[this.f9146p];
        this.f9143m = new double[this.f9146p];
        this.f9142l = new double[this.f9146p][];
    }

    private void m12923a(int i, double[] dArr) {
        int i2 = 1;
        this.f9141k[0] = i * 2;
        this.f9143m[0] = 2.0d;
        this.f9142l[0] = new double[this.f9141k[0]];
        if (i > 0) {
            this.f9142l[0][0] = dArr[0] * 0.5d;
            this.f9142l[0][1] = dArr[0];
        }
        while (i2 < i) {
            this.f9142l[0][i2 * 2] = (dArr[i2 - 1] + dArr[i2]) * 0.5d;
            this.f9142l[0][(i2 * 2) + 1] = dArr[i2];
            i2++;
        }
    }

    private void m12928b(int i, double[] dArr) {
        this.f9141k[1] = i;
        this.f9142l[1] = new double[this.f9141k[1]];
        this.f9143m[1] = 1.0d;
        for (int i2 = 0; i2 < this.f9141k[1]; i2++) {
            this.f9142l[1][i2] = dArr[i2];
        }
    }

    private void m12931j() {
        for (int i = 2; i < 5; i++) {
            this.f9141k[i] = this.f9141k[i - 1] / 2;
            this.f9142l[i] = new double[this.f9141k[i]];
            this.f9143m[i] = this.f9143m[i - 1] / 2.0d;
            for (int i2 = 0; i2 < this.f9141k[i]; i2++) {
                this.f9142l[i][i2] = 0.5d * (this.f9142l[i - 1][i2 * 2] + this.f9142l[i - 1][(i2 * 2) + 1]);
            }
        }
    }

    private void m12932k() {
        int i = (this.f9128G / 2) - 1;
        int i2 = this.f9141k[this.f9145o];
        this.f9144n = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            this.f9144n[i3] = (int) (this.f9142l[this.f9145o][i3] * ((double) i));
        }
    }

    private void m12924a(Context context) {
        this.f9156z = new GestureDetector(context, new fqh(this));
        this.f9122A = new ScaleGestureDetector(context, new fqi(this));
    }

    private float m12919a(ScaleGestureDetector scaleGestureDetector) {
        if (VERSION.SDK_INT >= 11) {
            return scaleGestureDetector.getCurrentSpanX();
        }
        return scaleGestureDetector.getCurrentSpan();
    }

    private void m12933l() {
        Resources resources = getResources();
        this.f9133c = new Paint();
        this.f9133c.setAntiAlias(false);
        this.f9133c.setColor(resources.getColor(C0349R.color.grid_line));
        this.f9133c.setStrokeWidth(2.0f);
        this.f9134d = new Paint();
        this.f9134d.setAntiAlias(false);
        this.f9134d.setColor(resources.getColor(C0349R.color.waveform_selected));
        this.f9135e = new Paint();
        this.f9135e.setAntiAlias(false);
        this.f9135e.setColor(resources.getColor(C0349R.color.waveform_unselected));
        this.f9136f = new Paint();
        this.f9136f.setAntiAlias(false);
        this.f9136f.setColor(resources.getColor(C0349R.color.waveform_unselected_bkgnd_overlay));
        this.f9137g = new Paint();
        this.f9137g.setAntiAlias(true);
        this.f9137g.setStrokeWidth(1.5f);
        this.f9137g.setPathEffect(new DashPathEffect(new float[]{3.0f, 2.0f}, 0.0f));
        this.f9137g.setColor(resources.getColor(C0349R.color.selection_border));
        this.f9138h = new Paint();
        this.f9138h.setAntiAlias(false);
        this.f9138h.setColor(gzd.m23358b());
        this.f9138h.setStrokeWidth(2.0f);
        this.f9139i = new Paint();
        this.f9139i.setTextSize((float) this.f9124C);
        this.f9139i.setAntiAlias(true);
        this.f9139i.setColor(resources.getColor(C0349R.color.timecode));
        this.f9139i.setShadowLayer(2.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, resources.getColor(C0349R.color.timecode_shadow));
        this.f9131a = new Paint();
        this.f9131a.setAntiAlias(false);
        this.f9131a.setColor(resources.getColor(C0349R.color.cutter_time_code_bg_color));
    }
}
