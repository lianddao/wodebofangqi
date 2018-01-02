package com.miui.player.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.miui.player.C0329R;
import com.miui.player.service.ShakeListener;
import org.mozilla.universalchardet.prober.SingleByteCharsetProber;
import org.mozilla.universalchardet.prober.contextanalysis.JapaneseContextAnalysis;

public class EqualizerView extends View {
    private static final int ALPHA_PARTITON = 5;
    public static final float CURVE_RESOLUTION = 1.15f;
    private static final int DEFAULT_CURVE_COLOR = 16756224;
    public static int MAX_FREQ = 20000;
    public static int MIN_FREQ = 20;
    public static int SAMPLING_RATE = 44100;
    public static int SCALE = 100;
    private static int sMaxEqualizerRank = Integer.MAX_VALUE;
    private static int sMinEqualizerRank = Integer.MAX_VALUE;
    private final int mCurveColor;
    private final Paint mCurvePaint;
    private final int mCurveShadowColor;
    private final float mCurveShadowRadius;
    private int mHeight;
    private final float[] mLevels = new float[5];
    private int mWidth;

    static class Biquad {
        private Complex a0;
        private Complex a1;
        private Complex a2;
        private Complex b0;
        private Complex b1;
        private Complex b2;

        Biquad() {
        }

        protected void setHighShelf(float centerFrequency, float samplingFrequency, float dbGain, float slope) {
            double w0 = (6.283185307179586d * ((double) centerFrequency)) / ((double) samplingFrequency);
            double A = Math.pow(10.0d, (double) (dbGain / 40.0f));
            double alpha = (Math.sin(w0) / 2.0d) * Math.sqrt((((1.0d / A) + A) * ((double) ((ShakeListener.ACCELATION_FACTOR_X / slope) - ShakeListener.ACCELATION_FACTOR_X))) + 2.0d);
            this.b0 = new Complex((float) ((((1.0d + A) + ((A - 1.0d) * Math.cos(w0))) + ((2.0d * Math.sqrt(A)) * alpha)) * A), 0.0f);
            this.b1 = new Complex((float) ((-2.0d * A) * ((A - 1.0d) + ((1.0d + A) * Math.cos(w0)))), 0.0f);
            this.b2 = new Complex((float) ((((1.0d + A) + ((A - 1.0d) * Math.cos(w0))) - ((2.0d * Math.sqrt(A)) * alpha)) * A), 0.0f);
            this.a0 = new Complex((float) (((1.0d + A) - ((A - 1.0d) * Math.cos(w0))) + ((2.0d * Math.sqrt(A)) * alpha)), 0.0f);
            this.a1 = new Complex((float) (2.0d * ((A - 1.0d) - ((1.0d + A) * Math.cos(w0)))), 0.0f);
            this.a2 = new Complex((float) (((1.0d + A) - ((A - 1.0d) * Math.cos(w0))) - ((2.0d * Math.sqrt(A)) * alpha)), 0.0f);
        }

        protected Complex evaluateTransfer(Complex z) {
            Complex zSquared = z.mul(z);
            return this.b0.add(this.b1.div(z)).add(this.b2.div(zSquared)).div(this.a0.add(this.a1.div(z)).add(this.a2.div(zSquared)));
        }
    }

    static class Complex {
        final float im;
        final float re;

        protected Complex(float re1, float im1) {
            this.re = re1;
            this.im = im1;
        }

        protected float rho() {
            return (float) Math.sqrt((double) ((this.re * this.re) + (this.im * this.im)));
        }

        protected float theta() {
            return (float) Math.atan2((double) this.im, (double) this.re);
        }

        protected Complex con() {
            return new Complex(this.re, -this.im);
        }

        protected Complex add(Complex other) {
            return new Complex(this.re + other.re, this.im + other.im);
        }

        protected Complex mul(Complex other) {
            return new Complex((this.re * other.re) - (this.im * other.im), (this.re * other.im) + (this.im * other.re));
        }

        protected Complex mul(float a) {
            return new Complex(this.re * a, this.im * a);
        }

        protected Complex div(Complex other) {
            return mul(other.con()).div((other.re * other.re) + (other.im * other.im));
        }

        protected Complex div(float a) {
            return new Complex(this.re / a, this.im / a);
        }
    }

    public EqualizerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        if (attributeSet != null) {
            TypedArray a = context.obtainStyledAttributes(attributeSet, C0329R.styleable.EqualizerView);
            this.mCurveColor = a.getColor(0, DEFAULT_CURVE_COLOR);
            this.mCurveShadowColor = a.getColor(1, 0);
            this.mCurveShadowRadius = a.getFloat(2, 0.0f);
        } else {
            this.mCurveColor = DEFAULT_CURVE_COLOR;
            this.mCurveShadowColor = 0;
            this.mCurveShadowRadius = 0.0f;
        }
        this.mCurvePaint = new Paint();
        this.mCurvePaint.setColor(this.mCurveColor);
        this.mCurvePaint.setStyle(Style.FILL_AND_STROKE);
        this.mCurvePaint.setStrokeWidth(ShakeListener.ACCELATION_FACTOR_X);
        this.mCurvePaint.setAntiAlias(true);
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.mWidth = right - left;
        this.mHeight = bottom - top;
    }

    public void setBand(int i, int value) {
        this.mLevels[i] = ((float) value) / ((float) SCALE);
        postInvalidate();
    }

    public void setBands(int[] values) {
        for (int i = 0; i < this.mLevels.length; i++) {
            this.mLevels[i] = ((float) values[i]) / ((float) SCALE);
        }
        postInvalidate();
    }

    protected void onDraw(Canvas canvas) {
        Biquad[] biquads = new Biquad[]{new Biquad(), new Biquad(), new Biquad(), new Biquad()};
        float gain = (float) Math.pow(10.0d, (double) (this.mLevels[0] / 20.0f));
        biquads[0].setHighShelf(125.0f, (float) SAMPLING_RATE, this.mLevels[1] - this.mLevels[0], ShakeListener.ACCELATION_FACTOR_X);
        biquads[1].setHighShelf(500.0f, (float) SAMPLING_RATE, this.mLevels[2] - this.mLevels[1], ShakeListener.ACCELATION_FACTOR_X);
        biquads[2].setHighShelf(2000.0f, (float) SAMPLING_RATE, this.mLevels[3] - this.mLevels[2], ShakeListener.ACCELATION_FACTOR_X);
        biquads[3].setHighShelf(8000.0f, (float) SAMPLING_RATE, this.mLevels[4] - this.mLevels[3], ShakeListener.ACCELATION_FACTOR_X);
        float oldx = JapaneseContextAnalysis.DONT_KNOW;
        float olddB = 0.0f;
        for (float freq = ((float) MIN_FREQ) / 1.15f; freq < ((float) MAX_FREQ) * 1.15f; freq *= 1.15f) {
            float omega = ((freq / ((float) SAMPLING_RATE)) * 3.1415927f) * 2.0f;
            Complex complex = new Complex((float) Math.cos((double) omega), (float) Math.sin((double) omega));
            float newBb = projectY(lin2dB((((complex.mul(gain).rho() * biquads[0].evaluateTransfer(complex).rho()) * biquads[1].evaluateTransfer(complex).rho()) * biquads[2].evaluateTransfer(complex).rho()) * biquads[3].evaluateTransfer(complex).rho())) * ((float) this.mHeight);
            float newx = projectX(freq) * ((float) this.mWidth);
            if (oldx != JapaneseContextAnalysis.DONT_KNOW) {
                float edge = (float) (this.mWidth / 5);
                if (oldx < edge) {
                    setPanitAlpha(oldx / edge);
                } else {
                    float f = ((float) this.mWidth) - oldx;
                    if (edge > f) {
                        setPanitAlpha(f / edge);
                    } else {
                        this.mCurvePaint.setAlpha(255);
                        if (this.mCurveShadowColor != 0) {
                            this.mCurvePaint.setShadowLayer(this.mCurveShadowRadius, 0.0f, 0.0f, this.mCurveShadowColor);
                        }
                    }
                }
                canvas.drawLine(oldx, olddB, newx, newBb, this.mCurvePaint);
            }
            oldx = newx;
            olddB = newBb;
        }
    }

    private void setPanitAlpha(float percent) {
        if (percent < 0.01f) {
            percent = 0.01f;
        } else if (percent < SingleByteCharsetProber.NEGATIVE_SHORTCUT_THRESHOLD) {
            percent = SingleByteCharsetProber.NEGATIVE_SHORTCUT_THRESHOLD;
        }
        this.mCurvePaint.setAlpha((int) (255.0f * percent));
        if (this.mCurveShadowColor != 0) {
            this.mCurvePaint.setShadowLayer(this.mCurveShadowRadius * percent, 0.0f, 0.0f, this.mCurveShadowColor);
        }
    }

    private float projectX(float freq) {
        double pos = Math.log((double) freq);
        double minPos = Math.log((double) MIN_FREQ);
        return (float) ((pos - minPos) / (Math.log((double) MAX_FREQ) - minPos));
    }

    private float projectY(float dB) {
        return ShakeListener.ACCELATION_FACTOR_X - ((dB - ((float) getMinRank(this.mContext))) / ((float) (getMaxRank(this.mContext) - getMinRank(this.mContext))));
    }

    private float lin2dB(float rho) {
        return rho != 0.0f ? (float) ((Math.log((double) rho) / Math.log(10.0d)) * 20.0d) : -99.0f;
    }

    public static int getMaxRank(Context context) {
        if (sMinEqualizerRank == Integer.MAX_VALUE) {
            sMinEqualizerRank = context.getResources().getInteger(C0329R.integer.equalizer_rank_max);
        }
        return sMinEqualizerRank;
    }

    public static int getMinRank(Context context) {
        if (sMaxEqualizerRank == Integer.MAX_VALUE) {
            sMaxEqualizerRank = context.getResources().getInteger(C0329R.integer.equalizer_rank_min);
        }
        return sMaxEqualizerRank;
    }
}
