package com.xiaomi.music.online.model;

public class ResourceSearchResult {
    public final String mAlbumId;
    public final String mAlbumUrl;
    public final String mArtistId;
    public final String mAvatarUrl;
    public final String mLyricUrl;
    public final int mSearchType;

    public static class Builder {
        private String mAlbumId;
        private String mAlbumUrl;
        private String mArtistId;
        private String mAvatarUrl;
        private String mLyricUrl;
        private final int mSearchType;

        public Builder(int type) {
            this.mSearchType = type;
        }

        public ResourceSearchResult build() {
            return new ResourceSearchResult(this.mSearchType, this.mAlbumId, this.mAlbumUrl, this.mArtistId, this.mAvatarUrl, this.mLyricUrl);
        }

        public Builder setAlbumId(String albumId) {
            this.mAlbumId = albumId;
            return this;
        }

        public Builder setAlbumUrl(String albumUrl) {
            this.mAlbumUrl = albumUrl;
            return this;
        }

        public Builder setAvatarUrl(String avatarUrl) {
            this.mAvatarUrl = avatarUrl;
            return this;
        }

        public Builder setArtistId(String artistId) {
            this.mArtistId = artistId;
            return this;
        }

        public Builder setLyricUrl(String lyricUrl) {
            this.mLyricUrl = lyricUrl;
            return this;
        }
    }

    private ResourceSearchResult(int searchType, String albumId, String albumUrl, String artistId, String avatarUrl, String lrcUrl) {
        this.mSearchType = searchType;
        this.mAlbumId = albumId;
        this.mAlbumUrl = albumUrl;
        this.mArtistId = artistId;
        this.mAvatarUrl = avatarUrl;
        this.mLyricUrl = lrcUrl;
    }
}
