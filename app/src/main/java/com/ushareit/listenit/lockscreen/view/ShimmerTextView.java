package com.ushareit.listenit.lockscreen.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.widget.TextView;
import com.mopub.volley.DefaultRetryPolicy;

public class ShimmerTextView extends TextView {
    private LinearGradient f15730a;
    private Matrix f15731b;
    private Paint f15732c;
    private int f15733d = 0;
    private int f15734e = 0;
    private boolean f15735f = true;

    public ShimmerTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f15733d == 0) {
            this.f15733d = getMeasuredWidth();
            if (this.f15733d > 0) {
                this.f15732c = getPaint();
                this.f15730a = new LinearGradient((float) (-this.f15733d), 0.0f, 0.0f, 0.0f, new int[]{872415231, -1, 872415231}, new float[]{0.0f, 0.5f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT}, TileMode.CLAMP);
                this.f15732c.setShader(this.f15730a);
                this.f15731b = new Matrix();
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f15735f && this.f15731b != null) {
            this.f15734e += this.f15733d / 10;
            if (this.f15734e > this.f15733d * 2) {
                this.f15734e = -this.f15733d;
            }
            this.f15731b.setTranslate((float) this.f15734e, 0.0f);
            this.f15730a.setLocalMatrix(this.f15731b);
            postInvalidateDelayed(90);
        }
    }
}
