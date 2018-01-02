package com.ushareit.listenit.cutter.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.ushareit.listenit.fpr;

public class MarkerView extends ImageView {
    private int f9064a = 0;
    private fpr f9065b = null;

    public MarkerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFocusable(true);
    }

    public void setListener(fpr com_ushareit_listenit_fpr) {
        this.f9065b = com_ushareit_listenit_fpr;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                requestFocus();
                this.f9065b.mo2525a(this, motionEvent.getRawX());
                break;
            case 1:
                this.f9065b.mo2524a(this);
                break;
            case 2:
                this.f9065b.mo2529b(this, motionEvent.getRawX());
                break;
        }
        return true;
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (z && this.f9065b != null) {
            this.f9065b.mo2528b(this);
        }
        super.onFocusChanged(z, i, rect);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f9065b != null) {
            this.f9065b.mo2527b();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        this.f9064a++;
        int sqrt = (int) Math.sqrt((double) ((this.f9064a / 2) + 1));
        if (this.f9065b != null) {
            if (i == 21) {
                this.f9065b.mo2526a(this, sqrt);
                return true;
            } else if (i == 22) {
                this.f9065b.mo2530b(this, sqrt);
                return true;
            } else if (i == 23) {
                this.f9065b.mo2531c(this);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        this.f9064a = 0;
        if (this.f9065b != null) {
            this.f9065b.mo2523a();
        }
        return super.onKeyDown(i, keyEvent);
    }
}
