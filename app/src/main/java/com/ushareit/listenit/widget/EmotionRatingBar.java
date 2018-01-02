package com.ushareit.listenit.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.hbo;
import java.util.Locale;

@SuppressLint({"NewApi"})
public class EmotionRatingBar extends View {
    boolean f17208a;
    float f17209b;
    private int f17210c;
    private int f17211d;
    private int[] f17212e;
    private int[] f17213f;
    private Bitmap[] f17214g;
    private Bitmap[] f17215h;
    private int f17216i;
    private int f17217j;
    private int f17218k;
    private int[] f17219l;
    private int[] f17220m;
    private hbo f17221n;
    private int f17222o;
    private ViewParent f17223p;

    public EmotionRatingBar(Context context) {
        this(context, null);
    }

    public EmotionRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmotionRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17210c = 0;
        this.f17211d = 0;
        this.f17208a = false;
        this.f17212e = new int[]{C0349R.drawable.rateus_star_selected_01, C0349R.drawable.rateus_star_selected_02, C0349R.drawable.rateus_star_selected_03, C0349R.drawable.rateus_star_selected_04, C0349R.drawable.rateus_star_selected_05};
        this.f17213f = new int[]{C0349R.drawable.rateus_star_normal_01, C0349R.drawable.rateus_star_normal_02, C0349R.drawable.rateus_star_normal_03, C0349R.drawable.rateus_star_normal_04, C0349R.drawable.rateus_star_normal_05};
        this.f17209b = 0.0f;
        m26823a();
    }

    @SuppressLint({"NewApi"})
    private void m26823a() {
        int i;
        boolean z = true;
        this.f17211d = this.f17210c;
        this.f17219l = new int[5];
        this.f17220m = new int[6];
        this.f17214g = new Bitmap[5];
        this.f17215h = new Bitmap[5];
        this.f17222o = ViewConfiguration.get(getContext()).getScaledTouchSlop() / 2;
        for (i = 0; i < 5; i++) {
            this.f17214g[i] = BitmapFactory.decodeResource(getResources(), this.f17212e[i]);
        }
        for (i = 0; i < 5; i++) {
            this.f17215h[i] = BitmapFactory.decodeResource(getResources(), this.f17213f[i]);
        }
        if (VERSION.SDK_INT >= 17) {
            if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) {
                z = false;
            }
            this.f17208a = z;
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        this.f17223p = getParent();
        int i6 = i / 5;
        if (i2 < i6) {
            i6 = i2;
        }
        this.f17216i = i6;
        this.f17218k = (i2 - this.f17216i) / 2;
        this.f17217j = (int) (((double) (i - (this.f17216i * 5))) / 5.0d);
        for (i6 = 0; i6 < 5; i6++) {
            this.f17219l[i6] = ((this.f17216i + this.f17217j) * i6) + (this.f17217j / 2);
        }
        this.f17220m[0] = (this.f17217j / 2) + (this.f17216i / 4);
        this.f17220m[1] = this.f17217j + this.f17216i;
        this.f17220m[2] = this.f17220m[1] * 2;
        this.f17220m[3] = this.f17220m[1] * 3;
        this.f17220m[4] = this.f17220m[1] * 4;
        this.f17220m[5] = i - this.f17220m[0];
        int width = this.f17214g[0].getWidth();
        int height = this.f17214g[0].getHeight();
        float f = ((float) i2) / ((float) width);
        float f2 = ((float) i2) / ((float) height);
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        for (i5 = 0; i5 < 5; i5++) {
            this.f17214g[i5] = Bitmap.createBitmap(this.f17214g[i5], 0, 0, width, height, matrix, true);
        }
        for (i5 = 0; i5 < 5; i5++) {
            this.f17215h[i5] = Bitmap.createBitmap(this.f17215h[i5], 0, 0, width, height, matrix, true);
        }
    }

    protected void onDraw(Canvas canvas) {
        int i;
        if (this.f17208a) {
            for (i = 4; i >= 0; i--) {
                if (4 - i < this.f17211d) {
                    canvas.drawBitmap(this.f17214g[this.f17211d - 1], (float) this.f17219l[i], (float) this.f17218k, null);
                } else {
                    canvas.drawBitmap(this.f17215h[4 - i], (float) this.f17219l[i], (float) this.f17218k, null);
                }
            }
        } else {
            for (i = 0; i < 5; i++) {
                if (i < this.f17211d) {
                    canvas.drawBitmap(this.f17214g[this.f17211d - 1], (float) this.f17219l[i], (float) this.f17218k, null);
                } else {
                    canvas.drawBitmap(this.f17215h[i], (float) this.f17219l[i], (float) this.f17218k, null);
                }
            }
        }
        super.onDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f17209b = motionEvent.getX();
                break;
            case 1:
                m26824a(motionEvent.getX());
                performClick();
                break;
            case 2:
                break;
            case 3:
                m26824a(motionEvent.getX());
                performClick();
                break;
        }
        float x = motionEvent.getX();
        if (Math.abs(x - this.f17209b) > ((float) this.f17222o)) {
            m26824a(x);
            m26825b();
        }
        this.f17209b = x;
        return true;
    }

    private void m26824a(float f) {
        int i = 0;
        if (!this.f17208a) {
            while (i < 5) {
                if (f < ((float) this.f17220m[i])) {
                    this.f17211d = i;
                    break;
                }
                i++;
            }
            if (f >= ((float) this.f17220m[4])) {
                this.f17211d = 5;
            }
        } else if (f > ((float) this.f17220m[5])) {
            this.f17211d = 0;
        } else if (f > ((float) this.f17220m[4])) {
            this.f17211d = 1;
        } else if (f > ((float) this.f17220m[3])) {
            this.f17211d = 2;
        } else if (f > ((float) this.f17220m[2])) {
            this.f17211d = 3;
        } else if (f > ((float) this.f17220m[1])) {
            this.f17211d = 4;
        } else {
            this.f17211d = 5;
        }
        invalidate();
    }

    public int getNumStars() {
        return 5;
    }

    private void m26825b() {
        if (this.f17223p != null) {
            this.f17223p.requestDisallowInterceptTouchEvent(true);
        }
    }

    public boolean performClick() {
        super.performClick();
        if (this.f17221n != null) {
            this.f17221n.mo2737a(this, getRating());
        }
        return true;
    }

    public int getRating() {
        return this.f17211d;
    }

    public void setRating(int i) {
        if (i < 0 || i > 5) {
            exw.m18457e("EmotionRationBar", "The value of rating can only range from 0 to 5");
            return;
        }
        this.f17211d = i;
        invalidate();
    }

    public int getDefaultRating() {
        return this.f17210c;
    }

    public void setDefaultRating(int i) {
        if (i < 0 || i > 5) {
            exw.m18457e("EmotionRationBar", "The value of rating can only range from 0 to 5");
            return;
        }
        this.f17210c = i;
        this.f17211d = this.f17210c;
    }

    public void setOnRatingBarChangeListener(hbo com_ushareit_listenit_hbo) {
        this.f17221n = com_ushareit_listenit_hbo;
    }

    public hbo getOnRatingBarChangeListener() {
        return this.f17221n;
    }
}
