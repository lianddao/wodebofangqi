package com.xiaomi.music.online.model;

import android.text.TextUtils;
import java.io.Serializable;

public class SongGroup implements Serializable {
    private static final long serialVersionUID = 1;
    public int mCount;
    public String mDescription;
    public final String mId;
    public String mImageUrl;
    public String mIntro;
    public String mLargeImageUrl;
    public final String mName;
    public String mSubTitle;

    private SongGroup(String id, String name) {
        this.mId = id;
        this.mName = name;
    }

    public static SongGroup createSongGroup(String id, String name) {
        return new SongGroup(id, name);
    }

    public String getLargeImageUrl() {
        return TextUtils.isEmpty(this.mLargeImageUrl) ? this.mImageUrl : this.mLargeImageUrl;
    }
}
