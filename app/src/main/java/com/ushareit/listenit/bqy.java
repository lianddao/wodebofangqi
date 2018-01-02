package com.ushareit.listenit;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import com.mopub.volley.DefaultRetryPolicy;

public final class bqy {
    private int f7447A;
    private int f7448B;
    private int f7449C;
    private StaticLayout f7450D;
    private int f7451E;
    private int f7452F;
    private int f7453G;
    private final RectF f7454a = new RectF();
    private final float f7455b;
    private final float f7456c;
    private final float f7457d;
    private final float f7458e;
    private final float f7459f;
    private final float f7460g;
    private final TextPaint f7461h;
    private final Paint f7462i;
    private CharSequence f7463j;
    private Alignment f7464k;
    private float f7465l;
    private int f7466m;
    private int f7467n;
    private float f7468o;
    private int f7469p;
    private float f7470q;
    private boolean f7471r;
    private int f7472s;
    private int f7473t;
    private int f7474u;
    private int f7475v;
    private int f7476w;
    private float f7477x;
    private float f7478y;
    private int f7479z;

    public bqy(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.f7460g = (float) obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f7459f = obtainStyledAttributes.getFloat(1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        obtainStyledAttributes.recycle();
        int round = Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * 2.0f) / 160.0f);
        this.f7455b = (float) round;
        this.f7456c = (float) round;
        this.f7457d = (float) round;
        this.f7458e = (float) round;
        this.f7461h = new TextPaint();
        this.f7461h.setAntiAlias(true);
        this.f7461h.setSubpixelText(true);
        this.f7462i = new Paint();
        this.f7462i.setAntiAlias(true);
        this.f7462i.setStyle(Style.FILL);
    }

    public void m9549a(bom com_ushareit_listenit_bom, boolean z, bol com_ushareit_listenit_bol, float f, float f2, Canvas canvas, int i, int i2, int i3, int i4) {
        CharSequence charSequence = com_ushareit_listenit_bom.f7233a;
        if (!TextUtils.isEmpty(charSequence)) {
            if (!z) {
                charSequence = charSequence.toString();
            }
            if (m9548a(this.f7463j, charSequence) && btc.m9770a(this.f7464k, com_ushareit_listenit_bom.f7234b) && this.f7465l == com_ushareit_listenit_bom.f7235c && this.f7466m == com_ushareit_listenit_bom.f7236d && btc.m9770a(Integer.valueOf(this.f7467n), Integer.valueOf(com_ushareit_listenit_bom.f7237e)) && this.f7468o == com_ushareit_listenit_bom.f7238f && btc.m9770a(Integer.valueOf(this.f7469p), Integer.valueOf(com_ushareit_listenit_bom.f7239g)) && this.f7470q == com_ushareit_listenit_bom.f7240h && this.f7471r == z && this.f7472s == com_ushareit_listenit_bol.f7227b && this.f7473t == com_ushareit_listenit_bol.f7228c && this.f7474u == com_ushareit_listenit_bol.f7229d && this.f7476w == com_ushareit_listenit_bol.f7230e && this.f7475v == com_ushareit_listenit_bol.f7231f && btc.m9770a(this.f7461h.getTypeface(), com_ushareit_listenit_bol.f7232g) && this.f7477x == f && this.f7478y == f2 && this.f7479z == i && this.f7447A == i2 && this.f7448B == i3 && this.f7449C == i4) {
                m9547a(canvas);
                return;
            }
            this.f7463j = charSequence;
            this.f7464k = com_ushareit_listenit_bom.f7234b;
            this.f7465l = com_ushareit_listenit_bom.f7235c;
            this.f7466m = com_ushareit_listenit_bom.f7236d;
            this.f7467n = com_ushareit_listenit_bom.f7237e;
            this.f7468o = com_ushareit_listenit_bom.f7238f;
            this.f7469p = com_ushareit_listenit_bom.f7239g;
            this.f7470q = com_ushareit_listenit_bom.f7240h;
            this.f7471r = z;
            this.f7472s = com_ushareit_listenit_bol.f7227b;
            this.f7473t = com_ushareit_listenit_bol.f7228c;
            this.f7474u = com_ushareit_listenit_bol.f7229d;
            this.f7476w = com_ushareit_listenit_bol.f7230e;
            this.f7475v = com_ushareit_listenit_bol.f7231f;
            this.f7461h.setTypeface(com_ushareit_listenit_bol.f7232g);
            this.f7477x = f;
            this.f7478y = f2;
            this.f7479z = i;
            this.f7447A = i2;
            this.f7448B = i3;
            this.f7449C = i4;
            int i5 = this.f7448B - this.f7479z;
            int i6 = this.f7449C - this.f7447A;
            this.f7461h.setTextSize(f);
            int i7 = (int) ((0.125f * f) + 0.5f);
            int i8 = i5 - (i7 * 2);
            if (this.f7470q != Float.MIN_VALUE) {
                i8 = (int) (((float) i8) * this.f7470q);
            }
            if (i8 <= 0) {
                Log.w("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
                return;
            }
            Alignment alignment = this.f7464k == null ? Alignment.ALIGN_CENTER : this.f7464k;
            this.f7450D = new StaticLayout(charSequence, this.f7461h, i8, alignment, this.f7459f, this.f7460g, true);
            int height = this.f7450D.getHeight();
            int lineCount = this.f7450D.getLineCount();
            int i9 = 0;
            int i10 = 0;
            while (i10 < lineCount) {
                int max = Math.max((int) Math.ceil((double) this.f7450D.getLineWidth(i10)), i9);
                i10++;
                i9 = max;
            }
            if (this.f7470q == Float.MIN_VALUE || i9 >= i8) {
                i8 = i9;
            }
            i8 += i7 * 2;
            if (this.f7468o != Float.MIN_VALUE) {
                i9 = Math.round(((float) i5) * this.f7468o) + this.f7479z;
                if (this.f7469p == 2) {
                    i9 -= i8;
                } else if (this.f7469p == 1) {
                    i9 = ((i9 * 2) - i8) / 2;
                }
                i10 = Math.max(i9, this.f7479z);
                i9 = Math.min(i10 + i8, this.f7448B);
                i5 = i10;
            } else {
                i10 = (i5 - i8) / 2;
                i9 = i10 + i8;
                i5 = i10;
            }
            if (this.f7465l != Float.MIN_VALUE) {
                if (this.f7466m == 0) {
                    i10 = Math.round(((float) i6) * this.f7465l) + this.f7447A;
                } else {
                    i10 = this.f7450D.getLineBottom(0) - this.f7450D.getLineTop(0);
                    if (this.f7465l >= 0.0f) {
                        i10 = Math.round(((float) i10) * this.f7465l) + this.f7447A;
                    } else {
                        i10 = Math.round(((float) i10) * this.f7465l) + this.f7449C;
                    }
                }
                if (this.f7467n == 2) {
                    i10 -= height;
                } else if (this.f7467n == 1) {
                    i10 = ((i10 * 2) - height) / 2;
                }
                if (i10 + height > this.f7449C) {
                    i10 = this.f7449C - height;
                } else if (i10 < this.f7447A) {
                    i10 = this.f7447A;
                }
                i6 = i10;
            } else {
                i6 = (this.f7449C - height) - ((int) (((float) i6) * f2));
            }
            this.f7450D = new StaticLayout(charSequence, this.f7461h, i9 - i5, alignment, this.f7459f, this.f7460g, true);
            this.f7451E = i5;
            this.f7452F = i6;
            this.f7453G = i7;
            m9547a(canvas);
        }
    }

    private void m9547a(Canvas canvas) {
        StaticLayout staticLayout = this.f7450D;
        if (staticLayout != null) {
            int lineCount;
            int i;
            int save = canvas.save();
            canvas.translate((float) this.f7451E, (float) this.f7452F);
            if (Color.alpha(this.f7474u) > 0) {
                this.f7462i.setColor(this.f7474u);
                canvas.drawRect((float) (-this.f7453G), 0.0f, (float) (staticLayout.getWidth() + this.f7453G), (float) staticLayout.getHeight(), this.f7462i);
            }
            if (Color.alpha(this.f7473t) > 0) {
                this.f7462i.setColor(this.f7473t);
                float lineTop = (float) staticLayout.getLineTop(0);
                lineCount = staticLayout.getLineCount();
                float f = lineTop;
                for (i = 0; i < lineCount; i++) {
                    this.f7454a.left = staticLayout.getLineLeft(i) - ((float) this.f7453G);
                    this.f7454a.right = staticLayout.getLineRight(i) + ((float) this.f7453G);
                    this.f7454a.top = f;
                    this.f7454a.bottom = (float) staticLayout.getLineBottom(i);
                    f = this.f7454a.bottom;
                    canvas.drawRoundRect(this.f7454a, this.f7455b, this.f7455b, this.f7462i);
                }
            }
            if (this.f7476w == 1) {
                this.f7461h.setStrokeJoin(Join.ROUND);
                this.f7461h.setStrokeWidth(this.f7456c);
                this.f7461h.setColor(this.f7475v);
                this.f7461h.setStyle(Style.FILL_AND_STROKE);
                staticLayout.draw(canvas);
            } else if (this.f7476w == 2) {
                this.f7461h.setShadowLayer(this.f7457d, this.f7458e, this.f7458e, this.f7475v);
            } else if (this.f7476w == 3 || this.f7476w == 4) {
                lineCount = this.f7476w == 3 ? 1 : 0;
                int i2 = lineCount != 0 ? -1 : this.f7475v;
                if (lineCount != 0) {
                    i = this.f7475v;
                } else {
                    i = -1;
                }
                float f2 = this.f7457d / 2.0f;
                this.f7461h.setColor(this.f7472s);
                this.f7461h.setStyle(Style.FILL);
                this.f7461h.setShadowLayer(this.f7457d, -f2, -f2, i2);
                staticLayout.draw(canvas);
                this.f7461h.setShadowLayer(this.f7457d, f2, f2, i);
            }
            this.f7461h.setColor(this.f7472s);
            this.f7461h.setStyle(Style.FILL);
            staticLayout.draw(canvas);
            this.f7461h.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas.restoreToCount(save);
        }
    }

    private static boolean m9548a(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }
}
