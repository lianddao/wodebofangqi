package com.songbirdnest.mediaplayer.service;

import android.graphics.Bitmap;

public class PodcastEntry {
    String mAlbum;
    String mAlbumKey;
    Bitmap mBitmap;
    Bitmap mLargeBitmap;
    String mPath;

    public PodcastEntry(Bitmap pThumb, Bitmap pArt, String pKey, String pAlbum, String pPath) {
        this.mBitmap = pThumb;
        this.mLargeBitmap = pArt;
        this.mAlbumKey = pKey;
        this.mAlbum = pAlbum;
        this.mPath = pPath;
    }
}
