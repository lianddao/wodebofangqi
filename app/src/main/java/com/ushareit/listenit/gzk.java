package com.ushareit.listenit;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.mopub.volley.DefaultRetryPolicy;

public class gzk extends Animation {
    private final float f14958a;
    private final float f14959b;
    private final float f14960c;
    private final float f14961d;
    private final float f14962e;
    private final boolean f14963f;
    private Camera f14964g;

    public gzk(float f, float f2, float f3, float f4, float f5, boolean z) {
        this.f14958a = f;
        this.f14959b = f2;
        this.f14960c = f3;
        this.f14961d = f4;
        this.f14962e = f5;
        this.f14963f = z;
    }

    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.f14964g = new Camera();
    }

    protected void applyTransformation(float f, Transformation transformation) {
        float f2 = this.f14958a;
        f2 += (this.f14959b - f2) * f;
        float f3 = this.f14960c;
        float f4 = this.f14961d;
        Camera camera = this.f14964g;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        if (this.f14962e != 0.0f) {
            if (this.f14963f) {
                camera.translate(0.0f, 0.0f, this.f14962e * f);
            } else {
                camera.translate(0.0f, 0.0f, this.f14962e * (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - f));
            }
        }
        camera.rotateY(f2);
        camera.getMatrix(matrix);
        if (VERSION.SDK_INT >= 12) {
            camera.setLocation(0.0f, 0.0f, -50.0f);
        }
        camera.restore();
        matrix.preTranslate(-f3, -f4);
        matrix.postTranslate(f3, f4);
    }
}
