package com.miui.player.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import com.miui.player.provider.PlayerStore;

public class FixedGridView extends GridView {
    private int mChildMaxHeight = 0;
    private boolean mIsFixed = true;

    public FixedGridView(Context context) {
        super(context);
    }

    public FixedGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FixedGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = heightMeasureSpec;
        if (this.mIsFixed) {
            expandSpec = MeasureSpec.makeMeasureSpec(PlayerStore.ONLINE_AUDIO_ID_BASE, Integer.MIN_VALUE);
        }
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

    protected void layoutChildren() {
        super.layoutChildren();
        if (this.mIsFixed) {
            updateGridViewHeight();
        }
    }

    public void setFixed(boolean isFixed) {
        this.mIsFixed = isFixed;
        requestLayout();
    }

    public void updateGridViewHeight() {
        int i;
        int tmpMaxHeight = 0;
        for (i = 0; i < getChildCount(); i++) {
            tmpMaxHeight = Math.max(tmpMaxHeight, getChildAt(i).getHeight());
        }
        if (tmpMaxHeight != this.mChildMaxHeight) {
            this.mChildMaxHeight = tmpMaxHeight;
            for (i = 0; i < getChildCount(); i++) {
                View v = getChildAt(i);
                LayoutParams layout = v.getLayoutParams();
                layout.height = this.mChildMaxHeight;
                v.setLayoutParams(layout);
            }
        }
    }

    public int getChildMaxHeight() {
        return this.mChildMaxHeight;
    }
}
