package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.view.Gravity;

public class abx extends abo implements acf {
    private final Paint f4069a;
    private final Rect f4070b;
    private final aby f4071c;
    private final ul f4072d;
    private final acc f4073e;
    private boolean f4074f;
    private boolean f4075g;
    private boolean f4076h;
    private boolean f4077i;
    private int f4078j;
    private int f4079k;
    private boolean f4080l;

    public abx(Context context, um umVar, ws wsVar, uz<Bitmap> uzVar, int i, int i2, uo uoVar, byte[] bArr, Bitmap bitmap) {
        this(new aby(uoVar, bArr, context, uzVar, i, i2, umVar, wsVar, bitmap));
    }

    public abx(abx com_ushareit_listenit_abx, Bitmap bitmap, uz<Bitmap> uzVar) {
        this(new aby(com_ushareit_listenit_abx.f4071c.f4081a, com_ushareit_listenit_abx.f4071c.f4082b, com_ushareit_listenit_abx.f4071c.f4083c, uzVar, com_ushareit_listenit_abx.f4071c.f4085e, com_ushareit_listenit_abx.f4071c.f4086f, com_ushareit_listenit_abx.f4071c.f4087g, com_ushareit_listenit_abx.f4071c.f4088h, bitmap));
    }

    abx(aby com_ushareit_listenit_aby) {
        this.f4070b = new Rect();
        this.f4077i = true;
        this.f4079k = -1;
        if (com_ushareit_listenit_aby == null) {
            throw new NullPointerException("GifState must not be null");
        }
        this.f4071c = com_ushareit_listenit_aby;
        this.f4072d = new ul(com_ushareit_listenit_aby.f4087g);
        this.f4069a = new Paint();
        this.f4072d.m26557a(com_ushareit_listenit_aby.f4081a, com_ushareit_listenit_aby.f4082b);
        this.f4073e = new acc(com_ushareit_listenit_aby.f4083c, this, this.f4072d, com_ushareit_listenit_aby.f4085e, com_ushareit_listenit_aby.f4086f);
        this.f4073e.m5165a(com_ushareit_listenit_aby.f4084d);
    }

    public Bitmap m5147b() {
        return this.f4071c.f4089i;
    }

    public uz<Bitmap> m5149c() {
        return this.f4071c.f4084d;
    }

    public byte[] m5150d() {
        return this.f4071c.f4082b;
    }

    public int m5151e() {
        return this.f4072d.m26559c();
    }

    private void m5141g() {
        this.f4078j = 0;
    }

    public void start() {
        this.f4075g = true;
        m5141g();
        if (this.f4077i) {
            m5143i();
        }
    }

    public void stop() {
        this.f4075g = false;
        m5144j();
        if (VERSION.SDK_INT < 11) {
            m5142h();
        }
    }

    private void m5142h() {
        this.f4073e.m5167c();
        invalidateSelf();
    }

    private void m5143i() {
        if (this.f4072d.m26559c() == 1) {
            invalidateSelf();
        } else if (!this.f4074f) {
            this.f4074f = true;
            this.f4073e.m5163a();
            invalidateSelf();
        }
    }

    private void m5144j() {
        this.f4074f = false;
        this.f4073e.m5166b();
    }

    public boolean setVisible(boolean z, boolean z2) {
        this.f4077i = z;
        if (!z) {
            m5144j();
        } else if (this.f4075g) {
            m5143i();
        }
        return super.setVisible(z, z2);
    }

    public int getIntrinsicWidth() {
        return this.f4071c.f4089i.getWidth();
    }

    public int getIntrinsicHeight() {
        return this.f4071c.f4089i.getHeight();
    }

    public boolean isRunning() {
        return this.f4074f;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f4080l = true;
    }

    public void draw(Canvas canvas) {
        if (!this.f4076h) {
            if (this.f4080l) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.f4070b);
                this.f4080l = false;
            }
            Bitmap d = this.f4073e.m5168d();
            if (d == null) {
                d = this.f4071c.f4089i;
            }
            canvas.drawBitmap(d, null, this.f4070b, this.f4069a);
        }
    }

    public void setAlpha(int i) {
        this.f4069a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f4069a.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return -2;
    }

    @TargetApi(11)
    public void mo572b(int i) {
        if (VERSION.SDK_INT < 11 || getCallback() != null) {
            invalidateSelf();
            if (i == this.f4072d.m26559c() - 1) {
                this.f4078j++;
            }
            if (this.f4079k != -1 && this.f4078j >= this.f4079k) {
                stop();
                return;
            }
            return;
        }
        stop();
        m5142h();
    }

    public ConstantState getConstantState() {
        return this.f4071c;
    }

    public void m5152f() {
        this.f4076h = true;
        this.f4071c.f4088h.mo3131a(this.f4071c.f4089i);
        this.f4073e.m5167c();
        this.f4073e.m5166b();
    }

    public boolean mo568a() {
        return true;
    }

    public void mo567a(int i) {
        if (i <= 0 && i != -1 && i != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        } else if (i == 0) {
            this.f4079k = this.f4072d.m26561e();
        } else {
            this.f4079k = i;
        }
    }
}
