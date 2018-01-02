package com.ushareit.listenit.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.theme.entry.CustomThemeImageView;

public class CircleImageView extends CustomThemeImageView {
    private static final ScaleType f17146a = ScaleType.CENTER_CROP;
    private static final Config f17147b = Config.ARGB_8888;
    private final RectF f17148c = new RectF();
    private final RectF f17149d = new RectF();
    private final Matrix f17150e = new Matrix();
    private final Paint f17151f = new Paint();
    private final Paint f17152g = new Paint();
    private final Paint f17153h = new Paint();
    private int f17154i = CtaButton.BACKGROUND_COLOR;
    private int f17155j = 0;
    private int f17156k = 0;
    private Bitmap f17157l;
    private BitmapShader f17158m;
    private int f17159n;
    private int f17160o;
    private float f17161p;
    private float f17162q;
    private ColorFilter f17163r;
    private boolean f17164s;
    private boolean f17165t;
    private boolean f17166u;
    private boolean f17167v;

    public CircleImageView(Context context) {
        super(context);
        m26793a();
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0349R.styleable.CircleImageView, 0, 0);
        this.f17155j = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f17154i = obtainStyledAttributes.getColor(1, CtaButton.BACKGROUND_COLOR);
        this.f17166u = obtainStyledAttributes.getBoolean(2, false);
        this.f17156k = obtainStyledAttributes.getColor(3, 0);
        obtainStyledAttributes.recycle();
        m26793a();
    }

    private void m26793a() {
        super.setScaleType(f17146a);
        this.f17164s = true;
        if (this.f17165t) {
            setup();
            this.f17165t = false;
        }
    }

    public ScaleType getScaleType() {
        return f17146a;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != f17146a) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.f17167v) {
            super.onDraw(canvas);
        } else if (this.f17157l != null) {
            if (this.f17156k != 0) {
                canvas.drawCircle(this.f17148c.centerX(), this.f17148c.centerY(), this.f17161p, this.f17153h);
            }
            canvas.drawCircle(this.f17148c.centerX(), this.f17148c.centerY(), this.f17161p, this.f17151f);
            if (this.f17155j > 0) {
                canvas.drawCircle(this.f17149d.centerX(), this.f17149d.centerY(), this.f17162q, this.f17152g);
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setup();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        setup();
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        setup();
    }

    public int getBorderColor() {
        return this.f17154i;
    }

    public void setBorderColor(int i) {
        if (i != this.f17154i) {
            this.f17154i = i;
            this.f17152g.setColor(this.f17154i);
            invalidate();
        }
    }

    @Deprecated
    public void setBorderColorResource(int i) {
        setBorderColor(getContext().getResources().getColor(i));
    }

    @Deprecated
    public int getFillColor() {
        return this.f17156k;
    }

    @Deprecated
    public void setFillColor(int i) {
        if (i != this.f17156k) {
            this.f17156k = i;
            this.f17153h.setColor(i);
            invalidate();
        }
    }

    @Deprecated
    public void setFillColorResource(int i) {
        setFillColor(getContext().getResources().getColor(i));
    }

    public int getBorderWidth() {
        return this.f17155j;
    }

    public void setBorderWidth(int i) {
        if (i != this.f17155j) {
            this.f17155j = i;
            setup();
        }
    }

    public void setBorderOverlay(boolean z) {
        if (z != this.f17166u) {
            this.f17166u = z;
            setup();
        }
    }

    public void setDisableCircularTransformation(boolean z) {
        if (this.f17167v != z) {
            this.f17167v = z;
            m26795c();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        m26795c();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m26795c();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        m26795c();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m26795c();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.f17163r) {
            this.f17163r = colorFilter;
            m26794b();
            invalidate();
        }
    }

    public ColorFilter getColorFilter() {
        return this.f17163r;
    }

    private void m26794b() {
        if (this.f17151f != null) {
            this.f17151f.setColorFilter(this.f17163r);
        }
    }

    private Bitmap m26792a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap;
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(2, 2, f17147b);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f17147b);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void m26795c() {
        if (this.f17167v) {
            this.f17157l = null;
        } else {
            this.f17157l = m26792a(getDrawable());
        }
        setup();
    }

    private void setup() {
        if (!this.f17164s) {
            this.f17165t = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            if (this.f17157l == null) {
                invalidate();
                return;
            }
            this.f17158m = new BitmapShader(this.f17157l, TileMode.CLAMP, TileMode.CLAMP);
            this.f17151f.setAntiAlias(true);
            this.f17151f.setShader(this.f17158m);
            this.f17152g.setStyle(Style.STROKE);
            this.f17152g.setAntiAlias(true);
            this.f17152g.setColor(this.f17154i);
            this.f17152g.setStrokeWidth((float) this.f17155j);
            this.f17153h.setStyle(Style.FILL);
            this.f17153h.setAntiAlias(true);
            this.f17153h.setColor(this.f17156k);
            this.f17160o = this.f17157l.getHeight();
            this.f17159n = this.f17157l.getWidth();
            this.f17149d.set(m26796d());
            this.f17162q = Math.min((this.f17149d.height() - ((float) this.f17155j)) / 2.0f, (this.f17149d.width() - ((float) this.f17155j)) / 2.0f);
            this.f17148c.set(this.f17149d);
            if (!this.f17166u && this.f17155j > 0) {
                this.f17148c.inset(((float) this.f17155j) - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, ((float) this.f17155j) - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            }
            this.f17161p = Math.min(this.f17148c.height() / 2.0f, this.f17148c.width() / 2.0f);
            m26794b();
            m26797e();
            invalidate();
        }
    }

    private RectF m26796d() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int min = Math.min(width, height);
        float paddingLeft = (((float) (width - min)) / 2.0f) + ((float) getPaddingLeft());
        float paddingTop = (((float) (height - min)) / 2.0f) + ((float) getPaddingTop());
        return new RectF(paddingLeft, paddingTop, ((float) min) + paddingLeft, ((float) min) + paddingTop);
    }

    private void m26797e() {
        float height;
        float width;
        float f = 0.0f;
        this.f17150e.set(null);
        if (((float) this.f17159n) * this.f17148c.height() > this.f17148c.width() * ((float) this.f17160o)) {
            height = this.f17148c.height() / ((float) this.f17160o);
            width = (this.f17148c.width() - (((float) this.f17159n) * height)) * 0.5f;
        } else {
            height = this.f17148c.width() / ((float) this.f17159n);
            width = 0.0f;
            f = (this.f17148c.height() - (((float) this.f17160o) * height)) * 0.5f;
        }
        this.f17150e.setScale(height, height);
        this.f17150e.postTranslate(((float) ((int) (width + 0.5f))) + this.f17148c.left, ((float) ((int) (f + 0.5f))) + this.f17148c.top);
        this.f17158m.setLocalMatrix(this.f17150e);
    }
}
