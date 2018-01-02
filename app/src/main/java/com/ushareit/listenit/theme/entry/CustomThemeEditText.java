package com.ushareit.listenit.theme.entry;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ListenItApp;
import com.ushareit.listenit.erj;
import com.ushareit.listenit.ery;
import com.ushareit.listenit.gxi;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.hhe;
import com.ushareit.listenit.hhf;
import com.ushareit.listenit.hhg;
import java.lang.reflect.Field;

public class CustomThemeEditText extends EditText implements hhg {
    private ColorStateList f16633a;
    private ColorStateList f16634b;
    private Drawable f16635c;
    private Drawable f16636d;
    private float f16637e;
    private float f16638f;
    private ColorStateList f16639g;
    private ColorStateList f16640h;
    private ColorStateList f16641i;
    private ColorStateList f16642j;
    private boolean f16643k;
    private gxi f16644l;

    public CustomThemeEditText(Context context) {
        super(context);
        this.f16644l = new gxi(this);
    }

    public CustomThemeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16644l = new gxi(this);
        this.f16633a = getTextColors();
        this.f16635c = getBackground();
        this.f16637e = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        this.f16641i = getHintTextColors();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0349R.styleable.CustomThemeEditText, 0, 0);
        this.f16634b = obtainStyledAttributes.getColorStateList(0);
        this.f16642j = obtainStyledAttributes.getColorStateList(1);
        this.f16636d = obtainStyledAttributes.getDrawable(2);
        this.f16638f = obtainStyledAttributes.getFraction(3, 100, 1, 100.0f) / 100.0f;
        this.f16640h = obtainStyledAttributes.getColorStateList(4);
        this.f16639g = obtainStyledAttributes.getColorStateList(5);
        this.f16643k = obtainStyledAttributes.getBoolean(6, false);
        obtainStyledAttributes.recycle();
    }

    public void setTheme(Context context) {
        switch (((ListenItApp) context.getApplicationContext()).m4934b()) {
            case 1:
                if (this.f16634b != null) {
                    setTextColor(this.f16634b);
                }
                if (this.f16636d != null) {
                    setBackgroundDrawable(this.f16636d);
                }
                if (VERSION.SDK_INT >= 12 && this.f16640h != null) {
                    m26310a(this.f16640h);
                }
                if (this.f16642j != null) {
                    setHintTextColor(this.f16642j);
                }
                if (this.f16638f != this.f16637e) {
                    erj.m17570a(this, this.f16638f);
                    return;
                } else if (!isShown() && ery.f11646a) {
                    clearAnimation();
                    return;
                } else {
                    return;
                }
            case 2:
                if (!(this.f16633a == null || this.f16634b == null)) {
                    setTextColor(this.f16633a);
                }
                if (!(this.f16635c == null || this.f16636d == null)) {
                    setBackgroundDrawable(this.f16635c);
                }
                if (VERSION.SDK_INT >= 12 && this.f16640h != null) {
                    if (this.f16643k) {
                        this.f16639g = ColorStateList.valueOf(gzd.m23358b());
                    }
                    m26310a(this.f16639g);
                }
                if (!(this.f16641i == null || this.f16642j == null)) {
                    setHintTextColor(this.f16641i);
                }
                if (erj.m17569a(this) != this.f16637e) {
                    erj.m17570a(this, this.f16637e);
                    return;
                } else if (!isShown() && ery.f11646a) {
                    clearAnimation();
                    return;
                } else {
                    return;
                }
            default:
                if (!(this.f16633a == null || this.f16634b == null)) {
                    setTextColor(this.f16633a);
                }
                if (!(this.f16635c == null || this.f16636d == null)) {
                    setBackgroundDrawable(this.f16635c);
                }
                if (VERSION.SDK_INT >= 12 && this.f16640h != null) {
                    if (this.f16643k) {
                        this.f16639g = ColorStateList.valueOf(gzd.m23358b());
                    }
                    m26310a(this.f16639g);
                }
                if (!(this.f16641i == null || this.f16642j == null)) {
                    setHintTextColor(this.f16641i);
                }
                if (erj.m17569a(this) != this.f16637e) {
                    erj.m17570a(this, this.f16637e);
                    return;
                } else if (!isShown() && ery.f11646a) {
                    clearAnimation();
                    return;
                } else {
                    return;
                }
        }
    }

    public void m26310a(ColorStateList colorStateList) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i = declaredField.getInt(this);
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(this);
            Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
            declaredField3.setAccessible(true);
            if (i > 0) {
                Drawable drawable = getContext().getResources().getDrawable(i);
                if (drawable != null) {
                    drawable = hhe.m23348a(drawable, colorStateList.getDefaultColor());
                    declaredField3.set(obj, new Drawable[]{drawable, drawable});
                }
            }
        } catch (Exception e) {
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hhf.m23856a(this.f16644l);
    }

    protected void onDetachedFromWindow() {
        hhf.m23857b(this.f16644l);
        super.onDetachedFromWindow();
    }
}
