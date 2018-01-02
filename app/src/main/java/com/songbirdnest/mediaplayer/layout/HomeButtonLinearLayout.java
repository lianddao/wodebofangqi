package com.songbirdnest.mediaplayer.layout;

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
        LinearLayout linearLayout = (LinearLayout) getChildAt(1);
        if (linearLayout == null) {
            return "undefined";
        }
        return (String) ((TextView) linearLayout.getChildAt(0)).getText();
    }

    public String getCount() {
        LinearLayout linearLayout = (LinearLayout) getChildAt(1);
        if (linearLayout == null) {
            return "undefined";
        }
        TextView textView = (TextView) linearLayout.getChildAt(1);
        if (textView == null) {
            return "";
        }
        return (String) textView.getText();
    }

    public String toString() {
        return "HomeButtonLinearLayout:" + getText() + " " + getCount();
    }
}
