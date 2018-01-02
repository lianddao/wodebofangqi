package com.ushareit.listenit;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v4.widget.CircleImageView;

public class nx extends OvalShape {
    final /* synthetic */ CircleImageView f16045a;
    private RadialGradient f16046b;
    private Paint f16047c = new Paint();
    private int f16048d;

    public nx(CircleImageView circleImageView, int i, int i2) {
        this.f16045a = circleImageView;
        circleImageView.f129b = i;
        this.f16048d = i2;
        this.f16046b = new RadialGradient((float) (this.f16048d / 2), (float) (this.f16048d / 2), (float) circleImageView.f129b, new int[]{1023410176, 0}, null, TileMode.CLAMP);
        this.f16047c.setShader(this.f16046b);
    }

    public void draw(Canvas canvas, Paint paint) {
        int width = this.f16045a.getWidth();
        int height = this.f16045a.getHeight();
        canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) ((this.f16048d / 2) + this.f16045a.f129b), this.f16047c);
        canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (this.f16048d / 2), paint);
    }
}
