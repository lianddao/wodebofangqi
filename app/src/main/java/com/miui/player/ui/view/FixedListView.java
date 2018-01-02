package com.miui.player.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ListView;
import com.miui.player.provider.PlayerStore;

public class FixedListView extends ListView {
    public FixedListView(Context context) {
        super(context);
    }

    public FixedListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FixedListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(PlayerStore.ONLINE_AUDIO_ID_BASE, Integer.MIN_VALUE));
    }
}
