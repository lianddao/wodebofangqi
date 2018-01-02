package com.xiaomi.music.online.model;

import com.miui.player.meta.MetaManager;
import java.io.Serializable;

public class ResourceSearchInfo implements Serializable {
    public static final int SEARCH_ALUBM = 1;
    public static final int SEARCH_AVATAR = 0;
    public static final int SEARCH_LYRIC = 2;
    private static final long serialVersionUID = 1;
    public final String mAlbumId;
    public final String mAlbumName;
    public final String mArtistId;
    public final String mArtistName;
    public final String mCpId;
    public final String mCpSongId;
    public final int mSearchType;
    public final String mSongId;
    public final String mTrackName;
    public final String mTrackPath;

    public static class Builder {
        private String mAlbumId;
        private String mAlbumName;
        private String mArtistId;
        private String mArtistName;
        private String mCpId;
        private String mCpSongId;
        private String mSongId;
        private String mTrackName;
        private String mTrackPath;
        private final int mType;

        public Builder(int type) {
            this.mType = type;
        }

        public ResourceSearchInfo build() {
            return new ResourceSearchInfo(this.mType, this.mSongId, this.mCpId, this.mCpSongId, this.mTrackName, this.mAlbumId, this.mAlbumName, this.mArtistId, this.mArtistName, this.mTrackPath);
        }

        public Builder setSongId(String songId) {
            this.mSongId = songId;
            return this;
        }

        public Builder setTrackName(String trackName) {
            this.mTrackName = trackName;
            return this;
        }

        public Builder setAlbumId(String albumId) {
            this.mAlbumId = albumId;
            return this;
        }

        public Builder setAlbumName(String albumName) {
            this.mAlbumName = albumName;
            return this;
        }

        public Builder setArtistId(String artistId) {
            this.mArtistId = artistId;
            return this;
        }

        public Builder setArtistName(String artistName) {
            this.mArtistName = artistName;
            return this;
        }

        public Builder setTrackPath(String path) {
            this.mTrackPath = path;
            return this;
        }

        public Builder setCpId(String cpId) {
            this.mCpId = cpId;
            return this;
        }

        public Builder setCpSongId(String cpSongId) {
            this.mCpSongId = cpSongId;
            return this;
        }
    }

    private ResourceSearchInfo(int type, String songId, String cpId, String cpSongId, String trackName, String albumId, String albumName, String artistId, String artistName, String path) {
        this.mSearchType = type;
        if (songId == null) {
            songId = MetaManager.UNKNOWN_STRING;
        }
        this.mSongId = songId;
        if (cpId == null) {
            cpId = MetaManager.UNKNOWN_STRING;
        }
        this.mCpId = cpId;
        if (cpSongId == null) {
            cpSongId = MetaManager.UNKNOWN_STRING;
        }
        this.mCpSongId = cpSongId;
        if (trackName == null) {
            trackName = MetaManager.UNKNOWN_STRING;
        }
        this.mTrackName = trackName;
        if (path == null) {
            path = MetaManager.UNKNOWN_STRING;
        }
        this.mTrackPath = path;
        if (albumId == null) {
            albumId = MetaManager.UNKNOWN_STRING;
        }
        this.mAlbumId = albumId;
        if (albumName == null) {
            albumName = MetaManager.UNKNOWN_STRING;
        }
        this.mAlbumName = albumName;
        if (artistId == null) {
            artistId = MetaManager.UNKNOWN_STRING;
        }
        this.mArtistId = artistId;
        if (artistName == null) {
            artistName = MetaManager.UNKNOWN_STRING;
        }
        this.mArtistName = artistName;
    }

    public ResourceSearchInfo generate(int newType) {
        return new Builder(newType).setSongId(this.mSongId).setCpId(this.mCpId).setCpSongId(this.mCpSongId).setAlbumId(this.mAlbumId).setAlbumName(this.mAlbumName).setArtistId(this.mArtistId).setArtistName(this.mArtistName).setTrackPath(this.mTrackPath).setTrackName(this.mTrackName).build();
    }
}
