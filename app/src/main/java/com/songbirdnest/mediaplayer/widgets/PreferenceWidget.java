package com.songbirdnest.mediaplayer.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;

public class PreferenceWidget extends Preference {
    protected Drawable iconDrawable;
    protected int iconResourceId;
    private View parentView;

    public PreferenceWidget(Context context) {
        super(context);
    }

    public PreferenceWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PreferenceWidget(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setIconDrawable(int id, Drawable iconDrawable) {
        this.iconResourceId = id;
        this.iconDrawable = iconDrawable;
    }

    protected void onBindView(View view) {
        super.onBindView(view);
        this.parentView = view;
        if (this.parentView != null) {
            View iconView = this.parentView.findViewById(this.iconResourceId);
            if (iconView != null) {
                iconView.setBackgroundDrawable(this.iconDrawable);
            }
        }
    }

    public void refreshDrawable(Drawable iconDrawable) {
        this.iconDrawable = iconDrawable;
        if (this.parentView != null) {
            View iconView = this.parentView.findViewById(this.iconResourceId);
            if (iconView != null) {
                iconView.setBackgroundDrawable(iconDrawable);
            }
        }
    }
}
