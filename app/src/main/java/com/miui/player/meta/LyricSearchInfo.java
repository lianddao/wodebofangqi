package com.miui.player.meta;

import android.text.TextUtils;

public class LyricSearchInfo {
    public final String mAlbum;
    public final String mArtist;
    public final String mPath;
    public final String mTrack;

    public LyricSearchInfo(String tr, String ar, String al, String path) {
        this.mTrack = tr;
        this.mArtist = ar;
        this.mAlbum = al;
        this.mPath = path;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.mTrack);
    }
}
