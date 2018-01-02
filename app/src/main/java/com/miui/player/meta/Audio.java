package com.miui.player.meta;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Audio implements Serializable {
    private static final long serialVersionUID = 1;
    public List<AudioLink> mAudioLinks;
    public AudioDetail mDetail;
    public final AudioOutline mOutline;

    public static class AudioDetail implements Serializable {
        private static final long serialVersionUID = 1;
        public String mAlbumId;
        public int mAlbumNO;
        public String mAlbumName;
        public List<String> mAllArtistNames;
        public int mArea;
        public String mArtistId;
        public List<String> mArtistIds;
        public String mArtistName;
        public String mCompose;
        public String mCountry;
        public String mCpId;
        public String mCpSongId;
        public long mDurationInSec;
        public List<String> mGenre;
        public String mLanguage;
        public Date mPulishTime;
        public int mResourceType;
        public String mSongWriting;
        public AudioStatistics mStatistics;
        public String mURLLrc;
        public String mURLPictureBig;
        public String mURLPictureHuge;
        public String mURLPicturePremium;
        public String mURLPictureRadio;
        public String mURLPictureSmall;

        public synchronized String getAllArtistName() {
            if (this.mArtistName == null) {
                StringBuilder sb = new StringBuilder();
                if (this.mAllArtistNames != null) {
                    for (String name : this.mAllArtistNames) {
                        sb.append(name);
                    }
                    if (this.mAllArtistNames.size() > 1) {
                        sb.substring(0, sb.length() - 1);
                    }
                    this.mArtistName = sb.toString();
                }
            }
            return this.mArtistName;
        }

        public String getAlbumPictureUrl() {
            if (this.mURLPictureHuge != null) {
                return this.mURLPictureHuge;
            }
            if (this.mURLPicturePremium != null) {
                return this.mURLPicturePremium;
            }
            if (this.mURLPictureRadio != null) {
                return this.mURLPictureRadio;
            }
            if (this.mURLPictureBig != null) {
                return this.mURLPictureBig;
            }
            return null;
        }
    }

    public static class AudioLink implements Serializable {
        private static final long serialVersionUID = 1;
        public final int mBitrate;
        public long mDurationInSec;
        public String mExtension;
        public String mFileId;
        public String mShowLink;
        public long mSizeInByte;
        public final String mURL;
        public int mUnition;

        public AudioLink(String url, int bitrate) {
            this.mURL = url;
            this.mBitrate = bitrate;
        }
    }

    public static class AudioOutline implements Serializable {
        private static final long serialVersionUID = 1;
        public final String mId;
        public final String mTitle;

        public AudioOutline(String id, String title) {
            this.mId = id;
            this.mTitle = title;
        }
    }

    public static class AudioStatistics implements Serializable {
        private static final long serialVersionUID = 1;
        public int mDownloadNum;
        public int mFavoriteNum;
        public int mHot;
        public boolean mIsGenuine;
        public boolean mIsHot;
        public boolean mIsNew;
        public int mListenNum;
        public int mLyricNum;
        public int mRank;
        public int mRankChange;
        public int mRecommendNum;
        public int mTotalListenNum;
    }

    public Audio(String id, String title) {
        this.mOutline = new AudioOutline(id, title);
    }

    public Audio(AudioOutline outline) {
        this.mOutline = outline;
    }

    public String getTitle() {
        return this.mOutline.mTitle;
    }

    public String getId() {
        return this.mOutline.mId;
    }

    public String getArtistName() {
        return this.mDetail != null ? this.mDetail.mArtistName : null;
    }

    public String getAlbumName() {
        return this.mDetail != null ? this.mDetail.mAlbumName : null;
    }

    public long getDurationInSec() {
        return (this.mDetail != null ? Long.valueOf(this.mDetail.mDurationInSec) : null).longValue();
    }

    public String getCpId() {
        return this.mDetail != null ? this.mDetail.mCpId : null;
    }

    public String getCpSongId() {
        return this.mDetail != null ? this.mDetail.mCpSongId : null;
    }
}
