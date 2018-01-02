package com.ushareit.listenit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import java.util.Random;

public class gdh {
    private Point f13948a;
    private Paint f13949b;
    private int f13950c = 0;
    private int f13951d = 0;
    private double f13952e = 0.0d;
    private Context f13953f;

    public static gdh m21751a(Context context, int i, Paint paint) {
        Random random = new Random(System.currentTimeMillis());
        int a = (i / 2) - gyn.m23167a(context, 5.0f);
        double nextInt = (double) (random.nextInt(91) + (random.nextInt(4) * 90));
        return new gdh(context, new Point((int) (Math.sin(nextInt) * ((double) a)), (int) (Math.cos(nextInt) * ((double) a))), paint, a, nextInt);
    }

    public gdh(Context context, Point point, Paint paint, int i, double d) {
        this.f13953f = context;
        this.f13948a = point;
        this.f13949b = paint;
        this.f13951d = i;
        this.f13950c = i;
        this.f13952e = d;
    }

    public void m21755a(Canvas canvas) {
        int width = canvas.getWidth();
        canvas.save();
        canvas.translate(((float) width) / 2.0f, ((float) width) / 2.0f);
        m21752a(width);
        float a = ((((float) gyn.m23167a(this.f13953f, 3.0f)) / ((float) this.f13951d)) * ((float) this.f13950c)) + ((float) gyn.m23167a(this.f13953f, 2.0f));
        this.f13949b.setAlpha((int) (((-230.0f / ((float) this.f13951d)) * ((float) this.f13950c)) + 255.0f));
        canvas.drawCircle((float) this.f13948a.x, (float) this.f13948a.y, a, this.f13949b);
        canvas.restore();
    }

    private void m21752a(int i) {
        if (this.f13950c < this.f13951d / 3) {
            this.f13950c -= m21753b(11);
        } else {
            this.f13950c -= m21753b(8);
        }
        this.f13948a.set((int) (Math.sin(this.f13952e) * ((double) this.f13950c)), (int) (Math.cos(this.f13952e) * ((double) this.f13950c)));
        if (this.f13950c <= 5) {
            m21754c(i);
        }
    }

    private int m21753b(int i) {
        return new Random(System.currentTimeMillis()).nextInt(2) + i;
    }

    private void m21754c(int i) {
        Random random = new Random(System.currentTimeMillis());
        int a = (i / 2) - gyn.m23167a(this.f13953f, 5.0f);
        this.f13952e = (double) (random.nextInt(91) + (random.nextInt(4) * 90));
        this.f13950c = a;
    }
}
