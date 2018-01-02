package com.ushareit.listenit.lockscreen.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.ushareit.listenit.gdh;
import com.ushareit.listenit.gdi;
import java.util.ArrayList;
import java.util.List;

public class PowerDotLayout extends SurfaceView implements Callback {
    private boolean f15707a = true;
    private List<gdh> f15708b = new ArrayList();
    private Paint f15709c = null;
    private Runnable f15710d = new gdi(this);

    public PowerDotLayout(Context context) {
        super(context);
        m24561c();
    }

    public PowerDotLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24561c();
    }

    private void m24561c() {
        setWillNotDraw(false);
        getHolder().addCallback(this);
        setZOrderOnTop(true);
        getHolder().setFormat(-3);
        this.f15709c = new Paint(1);
        this.f15709c.setColor(Color.parseColor("#0042ff6e"));
        this.f15709c.setAlpha(25);
        this.f15709c.setAntiAlias(false);
        this.f15709c.setDither(false);
        this.f15709c.setStyle(Style.FILL);
    }

    public void m24562a() {
        this.f15707a = true;
        setVisibility(0);
    }

    public void m24563b() {
        this.f15708b.clear();
        this.f15707a = false;
        setVisibility(8);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < this.f15708b.size(); i++) {
            ((gdh) this.f15708b.get(i)).m21755a(canvas);
        }
        getHandler().postDelayed(this.f15710d, 16);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}
