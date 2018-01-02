package com.ushareit.listenit.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ListenItApp;
import com.ushareit.listenit.gxi;
import com.ushareit.listenit.gzd;
import com.ushareit.listenit.hhf;
import com.ushareit.listenit.hhg;

public class AllSongsLogo extends View implements hhg {
    private Drawable f17143a = getResources().getDrawable(C0349R.drawable.all_songs_album_shape);
    private gxi f17144b = new gxi(this);

    public AllSongsLogo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public void setTheme(Context context) {
        switch (((ListenItApp) context.getApplicationContext()).m4934b()) {
            case 1:
                setBackgroundDrawable(this.f17143a);
                return;
            default:
                setBackgroundDrawable(gzd.m23356a(gzd.m23358b()));
                return;
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hhf.m23856a(this.f17144b);
    }

    protected void onDetachedFromWindow() {
        hhf.m23857b(this.f17144b);
        super.onDetachedFromWindow();
    }
}
