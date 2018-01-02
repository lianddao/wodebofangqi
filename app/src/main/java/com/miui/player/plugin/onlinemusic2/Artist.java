package com.miui.player.plugin.onlinemusic2;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Artist implements Serializable {
    private static final long serialVersionUID = 1;
    public AudioList mAudioList;
    public ArtistDetail mDetail;
    public final ArtistOutline mOutline;

    public static class ArtistDetail implements Serializable {
        private static final long serialVersionUID = 1;
        public int mAlbumCount;
        public String mAliasName;
        public int mAudioCount;
        public Date mBirth;
        public String mBloodType;
        public String mCompany;
        public String mConstellation;
        public String mIntroduction;
        public String mNickName;
        public List<String> mRelateArtistIds;
        public float mStature;
        public String mTranslateName;
        public float mWeight;
    }

    public static class ArtistOutline implements Serializable {
        private static final long serialVersionUID = 1;
        public int mAlbumCount;
        public int mArea;
        public int mAudioCount;
        public String mCountry;
        public final char mFirstChar;
        public int mGender;
        public final String mId;
        public final String mTitle;
        public String mURLAvatarBig;
        public String mURLAvatarMiddle;
        public String mURLAvatarMini;
        public String mURLAvatarSmall;

        public ArtistOutline(String id, String title, char firstChar) {
            this.mId = id;
            this.mTitle = title;
            this.mFirstChar = firstChar;
        }
    }

    public Artist(ArtistOutline outline) {
        this.mOutline = outline;
    }
}
