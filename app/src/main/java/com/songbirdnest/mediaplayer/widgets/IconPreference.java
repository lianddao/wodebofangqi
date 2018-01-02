package com.songbirdnest.mediaplayer.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.songbirdnest.mediaplayer.C0116R;

public class IconPreference extends Preference {
    Drawable iconDrawable;
    Bitmap inIcon;

    public IconPreference(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IconPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setLayoutResource(C0116R.layout.preference_icon);
    }

    public IconPreference(Context context) {
        this(context, null);
    }

    public void setBitmap(Bitmap inImage) {
        this.inIcon = inImage;
    }

    public void setIconDrawable(Drawable iconDrawable) {
        this.iconDrawable = iconDrawable;
    }

    protected void onBindView(View view) {
        super.onBindView(view);
        ImageView mImage = (ImageView) view.findViewById(C0116R.id.icon);
        if (this.inIcon != null) {
            mImage.setImageBitmap(this.inIcon);
        }
        if (this.iconDrawable != null) {
            mImage.setBackgroundDrawable(this.iconDrawable);
        }
    }
}
