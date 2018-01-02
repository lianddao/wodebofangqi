package com.songbirdnest.mediaplayer.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeButtonLinearLayout extends LinearLayout {
    public HomeButtonLinearLayout(Context context) {
        super(context);
    }

    public HomeButtonLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public String getText() {
        return (String) ((TextView) ((LinearLayout) getChildAt(1)).getChildAt(0)).getText();
    }

    public String getCount() {
        TextView textView = (TextView) ((LinearLayout) getChildAt(1)).getChildAt(1);
        if (textView == null) {
            return "";
        }
        return (String) textView.getText();
    }

    public String toString() {
        return "HomeButtonLinearLayout:" + getText() + " " + getCount();
    }
}
