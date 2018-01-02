package com.songbirdnest.mediaplayer.widgets;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.mediaplayer.Songbird;
import com.songbirdnest.mediaplayer.activities.ContentBrowser;

public class Header extends LinearLayout {
    private MarqueeTextView mHeaderTextView;
    private MarqueeTextView mHeaderTextViewSecondary;
    private Button mHomeButton;

    public Header(Context context) {
        super(context);
        init(context);
    }

    public Header(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void setText(String headerText) {
        if (this.mHeaderTextViewSecondary != null) {
            this.mHeaderTextViewSecondary.setVisibility(4);
        }
        if (this.mHeaderTextView != null) {
            this.mHeaderTextView.setText(headerText);
        }
    }

    public void setTextWithAnimation(String aHeaderText, boolean aViewsRelated, boolean aViewPoppingFromStack) {
        if (aViewsRelated) {
            setTextWithSlideAnimation(aHeaderText, aViewPoppingFromStack);
        } else {
            setTextWithFadeAnimation(aHeaderText);
        }
    }

    public void setTextWithSlideAnimation(String aHeaderText, boolean aViewPoppingFromStack) {
        setText(aHeaderText);
    }

    public void setTextWithFadeAnimation(String aHeaderText) {
        setText(aHeaderText);
    }

    private void init(Context context) {
        View header = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0116R.layout.header, this);
        this.mHeaderTextView = (MarqueeTextView) header.findViewById(C0116R.id.header_header_text);
        this.mHeaderTextViewSecondary = (MarqueeTextView) header.findViewById(C0116R.id.header_header_text_secondary);
        this.mHomeButton = (Button) header.findViewById(C0116R.id.top_menu_songbird_logo_transp);
        this.mHomeButton.setOnClickListener(createOnClickListener(Constants.TOP_MENU_HOME));
    }

    public OnClickListener createOnClickListener(final String aViewKey) {
        return new OnClickListener() {
            public void onClick(View v) {
                Header.this.fireIntent(aViewKey);
            }
        };
    }

    private void fireIntent(String aViewKey) {
        if (aViewKey.equals(Constants.TOP_MENU_HOME)) {
            Intent i = new Intent(getContext(), Songbird.class);
            i.addFlags(67108864);
            getContext().startActivity(i);
            ((Activity) getContext()).overridePendingTransition(C0116R.anim.slide_left, C0116R.anim.slide_right);
            return;
        }
        i = new Intent(getContext(), ContentBrowser.class);
        i.putExtra(Constants.CONTENT_AREA_VIEW_KEY, aViewKey);
        getContext().startActivity(i);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
