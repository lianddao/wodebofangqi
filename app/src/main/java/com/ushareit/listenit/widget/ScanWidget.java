package com.ushareit.listenit.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.hdv;

public class ScanWidget extends SurfaceView implements Callback {
    public long f17352a;
    public long f17353b = 0;
    public long f17354c;
    private int f17355d = -10;
    private Bitmap f17356e;
    private Bitmap f17357f;
    private boolean f17358g = true;
    private int f17359h;
    private int f17360i = 0;
    private int f17361j = 10;
    private hdv f17362k;
    private Paint f17363l;

    public ScanWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26981c();
    }

    public ScanWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26981c();
    }

    public ScanWidget(Context context) {
        super(context);
        m26981c();
    }

    private void m26981c() {
        setWillNotDraw(false);
        getHolder().addCallback(this);
        this.f17359h = getResources().getColor(C0349R.color.scan_background_color);
        this.f17356e = BitmapFactory.decodeResource(getResources(), C0349R.drawable.scan_animation);
        this.f17363l = new Paint(1);
        this.f17363l.setColor(-1);
    }

    public void m26987a() {
        if (!this.f17358g) {
            this.f17358g = true;
            invalidate();
        }
    }

    public void m26988b() {
        if (this.f17358g) {
            this.f17358g = false;
            invalidate();
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f17362k = new hdv(this, surfaceHolder);
        this.f17362k.m23594a(true);
        this.f17362k.start();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f17362k.m23594a(false);
    }
}
