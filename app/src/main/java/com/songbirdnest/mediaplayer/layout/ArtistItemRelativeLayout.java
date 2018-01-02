package com.songbirdnest.mediaplayer.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.widgets.PlayIcon;

public class ArtistItemRelativeLayout extends RelativeLayout {
    public ArtistItemRelativeLayout(Context context) {
        super(context);
    }

    public ArtistItemRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public String getName() {
        return (String) ((TextView) findViewById(C0116R.id.artist_item_artist_name)).getText();
    }

    public PlayIcon getPlayButton() {
        return (PlayIcon) findViewById(C0116R.id.artist_item_play_icon);
    }

    public ImageView getRightArrorw() {
        return (ImageView) findViewById(C0116R.id.artist_item_right_arrow);
    }

    public String toString() {
        return "ArtistItemRelativeLayout: " + getName();
    }
}
