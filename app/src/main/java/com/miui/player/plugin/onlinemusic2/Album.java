package com.miui.player.plugin.onlinemusic2;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Album implements Serializable {
    private static final long serialVersionUID = 1;
    public AudioList mAudioList;
    public AlbumDetail mDetail;
    public final AlbumOutline mOutline;

    public static class AlbumOutline implements Serializable {
        private static final long serialVersionUID = 1;
        public String mArtistId;
        public List<String> mArtistIds;
        public String mArtistName;
        public List<String> mArtistNames;
        public int mAudioCount;
        public final String mId;
        public final String mTitle;
        public String mURLImage;
        public String mURLPictureBig;
        public String mURLPictureSmall;

        public static class AlbumDetail implements Serializable {
            private static final long serialVersionUID = 1;
            public AudioList mAudioList;
            public List<String> mGenre;
            public String mIntroduction;
            public String mLanguage;
            public String mProduceCompany;
            public String mPublishCompany;
            public Date mPublishTime;
            public AlbumStatistics mStatistics;
        }

        public AlbumOutline(String id, String title) {
            this.mId = id;
            this.mTitle = title;
        }

        public String getBestImageURL() {
            if (this.mURLImage != null) {
                return this.mURLImage;
            }
            if (this.mURLPictureBig != null) {
                return this.mURLPictureBig;
            }
            if (this.mURLPictureSmall != null) {
                return this.mURLPictureSmall;
            }
            return null;
        }
    }

    public static class AlbumStatistics implements Serializable {
        private static final long serialVersionUID = 1;
        public int mFavoriteNum;
        public int mHot;
        public boolean mIsHot;
        public boolean mIsNew;
        public boolean mIsRecommend;
        public int mListenNum;
        public int mNewHot;
        public int mRecommendNum;
        public int mTotalListenNum;
        public String mZhuoyueBuyURL;
        public int mZhuoyueFlag;
        public float mZhuoyuePrice;
    }

    public Album(AlbumOutline outline) {
        this.mOutline = outline;
    }
}
