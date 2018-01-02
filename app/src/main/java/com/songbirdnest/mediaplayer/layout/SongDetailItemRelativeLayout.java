package com.songbirdnest.mediaplayer.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.widgets.PlayIcon;

public class SongDetailItemRelativeLayout extends RelativeLayout {
    public SongDetailItemRelativeLayout(Context context) {
        super(context);
    }

    public SongDetailItemRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public String getAlbumName() {
        return (String) ((TextView) findViewById(C0116R.id.song_detail_album_name)).getText();
    }

    public String getSongName() {
        return (String) ((TextView) findViewById(C0116R.id.song_detail_song_name)).getText();
    }

    public PlayIcon getPlayIcon() {
        return (PlayIcon) findViewById(C0116R.id.song_detail_play_button);
    }

    public String toString() {
        return "SongDetailItemRelativeLayout: " + getSongName();
    }

    public boolean isPlaying() {
        PlayIcon playIcon = getPlayIcon();
        if (playIcon != null) {
            return playIcon.isPlaying();
        }
        throw new NullPointerException("PlayIcon not found");
    }
}
