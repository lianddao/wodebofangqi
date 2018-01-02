package com.songbirdnest.mediaplayer.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import com.songbirdnest.util.Logger;

public class VerticalLayout extends LinearLayout {
    static Paint border = new Paint();
    private int[] location;
    private final Rect mTempRect;

    static {
        border.setARGB(MotionEventCompat.ACTION_MASK, 0, 0, MotionEventCompat.ACTION_MASK);
        border.setStyle(Style.STROKE);
        border.setStrokeWidth(1.0f);
    }

    public VerticalLayout(Context context) {
        super(context);
        this.mTempRect = new Rect();
        this.location = new int[2];
        init();
    }

    public VerticalLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mTempRect = new Rect();
        this.location = new int[2];
        init();
    }

    private void init() {
        Logger.debug(this, "VerticalLayout:edgeSlop: " + ViewConfiguration.get(getContext()).getScaledEdgeSlop());
        Logger.debug(this, "VerticalLayout:displayMetrics: " + getContext().getResources().getDisplayMetrics());
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        Logger.debug(this, "VerticalLayout:before dispatchTouchEvent: " + ev);
        if (ev.getAction() == 0) {
            float xf = ev.getX();
            float yf = ev.getY();
            float scrolledXFloat = xf + ((float) getScrollX());
            float scrolledYFloat = yf + ((float) getScrollY());
            int scrolledXInt = (int) scrolledXFloat;
            int scrolledYInt = (int) scrolledYFloat;
            int count = getChildCount();
            Logger.debug(this, "VerticalLayout:Layout : " + getClass().getSimpleName() + " width " + getWidth() + " height " + getHeight());
            Logger.debug(this, "VerticalLayout:x: " + xf + " y: " + yf + " scrollx: " + scrolledXInt + " scrolly: " + scrolledYInt);
            Logger.debug(this, "VerticalLayout:rawX: " + ev.getRawX() + " rawY: " + ev.getRawY());
            for (int i = count - 1; i >= 0; i--) {
                View child = getChildAt(i);
                if (child.getVisibility() == 0 || child.getAnimation() != null) {
                    Logger.debug(this, "VerticalLayout:child : " + child.getClass().getSimpleName());
                    child.getHitRect(this.mTempRect);
                    Logger.debug(this, "VerticalLayout:child.getHitRect: " + this.mTempRect.toShortString());
                    child.getLocationInWindow(this.location);
                    Logger.debug(this, "VerticalLayout:child x: " + this.location[0] + " y: " + this.location[1] + " width " + child.getWidth() + " height " + child.getHeight());
                    if (this.mTempRect.contains(scrolledXInt, scrolledYInt)) {
                        Logger.debug(this, "VerticalLayout:child : " + child.getClass().getSimpleName() + " has been hit");
                        float xc = scrolledXFloat - ((float) child.getLeft());
                        float top = scrolledYFloat - ((float) child.getTop());
                        break;
                    }
                }
            }
        }
        boolean result = super.dispatchTouchEvent(ev);
        Logger.debug(this, "VerticalLayout:dispatchTouchEvent: " + (result ? "handled" : "not handled"));
        return result;
    }

    protected void dispatchDraw(Canvas canvas) {
        canvas.drawRect(1.0f, 1.0f, (float) (getWidth() - 1), (float) (getHeight() - 1), border);
        super.dispatchDraw(canvas);
    }
}
