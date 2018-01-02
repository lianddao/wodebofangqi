package com.songbirdnest.mediaplayer.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.widgets.PlayIcon;

public class AlbumSongItemRelativeLayout extends RelativeLayout {
    public AlbumSongItemRelativeLayout(Context context) {
        super(context);
    }

    public AlbumSongItemRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public String toString() {
        return "AlbumSongItemRelativeLayout: ";
    }

    public boolean isPlaying() {
        PlayIcon playIcon = (PlayIcon) findViewById(C0116R.id.album_song_item_play_icon);
        if (playIcon != null) {
            return playIcon.isPlaying();
        }
        throw new NullPointerException("PlayIcon not found");
    }
}
