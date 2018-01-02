package com.xiaomi.music.online.model;

import java.io.Serializable;

public class Song implements Serializable {
    private static final long serialVersionUID = 1;
    public String mAlbumName;
    public String mArtistName;
    public String mComposeName;
    public String mCopyType;
    public String mCountry;
    public final String mCpId;
    public final String mCpSongId;
    public long mDuration;
    public final String mId;
    public String mLanguage;
    public String mLyricistName;
    public final String mName;

    public Song(String id, String cpId, String cpSongId, String name) {
        this.mId = id;
        this.mCpId = cpId;
        this.mCpSongId = cpSongId;
        this.mName = name;
    }
}
