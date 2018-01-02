package com.ushareit.listenit.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.ushareit.listenit.theme.entry.CustomThemeButton;
import java.util.Locale;

public class DrawableCenterButton extends CustomThemeButton {
    boolean f17207a = false;

    public DrawableCenterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26822a();
    }

    private void m26822a() {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) {
                z = false;
            }
            this.f17207a = z;
        }
    }

    protected void onDraw(Canvas canvas) {
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables != null) {
            Drawable drawable;
            if (this.f17207a) {
                drawable = compoundDrawables[2];
                if (drawable != null) {
                    canvas.translate(-((((float) getWidth()) - ((((float) drawable.getIntrinsicWidth()) + getPaint().measureText(getText().toString())) + ((float) getCompoundDrawablePadding()))) / 2.0f), 0.0f);
                }
            } else {
                drawable = compoundDrawables[0];
                if (drawable != null) {
                    canvas.translate((((float) getWidth()) - ((((float) drawable.getIntrinsicWidth()) + getPaint().measureText(getText().toString())) + ((float) getCompoundDrawablePadding()))) / 2.0f, 0.0f);
                }
            }
        }
        super.onDraw(canvas);
    }
}
