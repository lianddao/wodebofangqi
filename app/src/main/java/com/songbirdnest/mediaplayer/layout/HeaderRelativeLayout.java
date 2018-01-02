package com.songbirdnest.mediaplayer.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.widgets.MarqueeTextView;

public class HeaderRelativeLayout extends RelativeLayout {
    public HeaderRelativeLayout(Context context) {
        super(context);
    }

    public HeaderRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public String getText() {
        return (String) ((MarqueeTextView) findViewById(C0116R.id.header_header_text)).getText();
    }

    public String toString() {
        return "HeaderRelativeLayout:" + getText();
    }
}
