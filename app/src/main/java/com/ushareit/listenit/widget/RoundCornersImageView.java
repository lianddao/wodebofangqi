package com.ushareit.listenit.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.theme.entry.CustomThemeImageView;

public class RoundCornersImageView extends CustomThemeImageView {
    private float f17347a;
    private int f17348b;
    private int f17349c;

    public RoundCornersImageView(Context context) {
        super(context);
        m26972a(context, null);
    }

    public RoundCornersImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26972a(context, attributeSet);
    }

    public void setRadius(float f) {
        this.f17347a = f;
    }

    private void m26972a(Context context, AttributeSet attributeSet) {
        this.f17347a = context.obtainStyledAttributes(attributeSet, C0349R.styleable.RoundCornersImageView).getDimension(0, -1.0f);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f17348b = i;
        this.f17349c = i2;
    }

    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable)) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (bitmap != null) {
                m26973a(canvas, bitmap);
            }
        }
    }

    private void m26973a(Canvas canvas, Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setAntiAlias(true);
        Xfermode porterDuffXfermode = new PorterDuffXfermode(Mode.SRC_IN);
        canvas.saveLayer(0.0f, 0.0f, (float) this.f17348b, (float) this.f17349c, null, 31);
        canvas.drawRoundRect(new RectF(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, (float) (getWidth() - 1), (float) (getHeight() - 1)), this.f17347a + DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, this.f17347a + DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, paint);
        paint.setXfermode(porterDuffXfermode);
        float width = ((float) getWidth()) / ((float) bitmap.getWidth());
        float height = ((float) getHeight()) / ((float) bitmap.getHeight());
        Matrix matrix = new Matrix();
        matrix.postScale(width, height);
        canvas.drawBitmap(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true), 0.0f, 0.0f, paint);
        canvas.restore();
    }
}
