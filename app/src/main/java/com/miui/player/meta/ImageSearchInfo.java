package com.miui.player.meta;

import android.text.TextUtils;
import java.io.Serializable;

public class ImageSearchInfo implements Serializable {
    public static final int SEARCH_ALUBM = 1;
    public static final int SEARCH_AVATAR = 0;
    private static final long serialVersionUID = 1;
    public final String mAlbumArt;
    public final long mAlbumId;
    public final String mAlbumName;
    public final String mArtistName;
    public final int mSearchType;
    public final String mTrackName;

    private ImageSearchInfo(long albumId, String albumArt, String trackName, String albumName, String artistName, int searchType) {
        this.mAlbumId = albumId;
        this.mAlbumArt = albumArt;
        if (albumName == null) {
            albumName = MetaManager.UNKNOWN_STRING;
        }
        this.mAlbumName = albumName;
        if (trackName == null) {
            trackName = MetaManager.UNKNOWN_STRING;
        }
        this.mTrackName = trackName;
        if (artistName == null) {
            artistName = MetaManager.UNKNOWN_STRING;
        }
        this.mArtistName = artistName;
        this.mSearchType = searchType;
    }

    public ImageSearchInfo(long albumId, String albumArt, String albumName, String artistName) {
        this(albumId, albumArt, null, albumName, artistName, 1);
    }

    public ImageSearchInfo(String albumName, String artistName) {
        this(-1, null, null, albumName, artistName, 1);
    }

    public ImageSearchInfo(String artistName) {
        this(-1, null, null, null, artistName, 0);
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.mArtistName) && TextUtils.isEmpty(this.mTrackName) && TextUtils.isEmpty(this.mAlbumName)) ? false : true;
    }
}
