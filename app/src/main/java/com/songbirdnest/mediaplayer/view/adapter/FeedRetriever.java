package com.songbirdnest.mediaplayer.view.adapter;

import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.mediaplayer.view.adapter.FeedAdapter.AccessDelegate;
import com.songbirdnest.mediaplayer.view.adapter.FeedAdapter.ItemDelegate;
import com.songbirdnest.mediaplayer.view.adapter.FeedAdapter.ViewType;
import com.songbirdnest.mediaplayer.view.adapter.UserFeedReturn.Delegate;
import com.songbirdnest.soundboard.SoundboardServer;
import com.songbirdnest.soundboard.data.UserFeedItem;
import java.util.ArrayList;
import java.util.List;

public class FeedRetriever implements AccessDelegate, Delegate, FollowDialogWrapper.Delegate {
    protected boolean mEmptyUpdate = false;
    protected List<ItemDelegate> mFeedList;
    protected boolean mGetAttempt = false;
    protected String mSoundboardID;
    protected Runnable mUpdate;

    static class UserFeedItemDelegate implements ItemDelegate {
        String mArtistID;
        String mDescription;
        protected String mID;
        boolean mIsLiked;
        boolean mIsPlayable = false;
        int[] mPhotoSize;
        String mPhotoURL;
        String mTitle;
        ViewType mType;
        String mURL;

        public UserFeedItemDelegate(boolean pLoading) {
            if (pLoading) {
                this.mType = ViewType.LoadingItem;
            } else {
                this.mType = ViewType.EmptyFeed;
            }
        }

        public UserFeedItemDelegate(UserFeedItem pItem) {
            this.mPhotoURL = pItem.getCoverImage().getSrc();
            this.mTitle = pItem.getArtistName();
            this.mArtistID = pItem.getArtistID();
            this.mDescription = pItem.getDescription();
            this.mPhotoSize = new int[]{pItem.getCoverImage().getWidth(), pItem.getCoverImage().getHeight()};
            this.mType = ViewType.FeedItem;
            if (pItem.getType().equals("video") || pItem.getType().equals("audio")) {
                this.mIsPlayable = true;
            }
            this.mIsLiked = pItem.getLiked();
            this.mURL = pItem.getUrl();
            this.mID = pItem.getID();
        }

        public String getPhotoURL() {
            return this.mPhotoURL;
        }

        public String getTitle() {
            return this.mTitle;
        }

        public String getDescription() {
            return this.mDescription;
        }

        public int[] getPhotoSize() {
            return this.mPhotoSize;
        }

        public ViewType getType() {
            return this.mType;
        }

        public String getArtistID() {
            return this.mArtistID;
        }

        public boolean isPlayable() {
            return this.mIsPlayable;
        }

        public String getLink() {
            return this.mURL;
        }

        public boolean isLiked() {
            return this.mIsLiked;
        }

        public String getFeedID() {
            return this.mID;
        }

        public void toggleLike() {
            this.mIsLiked = !this.mIsLiked;
        }
    }

    public FeedRetriever(Runnable pUpdate, String pSoundboardID) {
        this.mUpdate = pUpdate;
        this.mSoundboardID = pSoundboardID;
        this.mFeedList = new ArrayList();
    }

    public void refreshList() {
        this.mFeedList.clear();
        SoundboardServer.get().getUserFeed(new UserFeedReturn(this), this.mSoundboardID, this.mFeedList.size());
        this.mGetAttempt = true;
        this.mEmptyUpdate = false;
        this.mUpdate.run();
    }

    public int getFeedCount() {
        if (this.mFeedList.size() == 0) {
            requestAdditional();
        }
        if (!this.mGetAttempt || this.mEmptyUpdate) {
            return this.mFeedList.size();
        }
        return this.mFeedList.size() + 1;
    }

    protected void requestAdditional() {
        if (!this.mGetAttempt) {
            SoundboardServer.get().getUserFeed(new UserFeedReturn(this), this.mSoundboardID, this.mFeedList.size());
            if (this.mFeedList.size() != 0) {
                Analytics.get().track(Analytics.EVENT_WHATS_NEW_EXTEND);
            }
            this.mGetAttempt = true;
        }
    }

    public ItemDelegate getItem(int pPosition) {
        if (pPosition < this.mFeedList.size()) {
            if (pPosition >= this.mFeedList.size() - 10) {
                requestAdditional();
            }
            return (ItemDelegate) this.mFeedList.get(pPosition);
        } else if (this.mEmptyUpdate && this.mFeedList.size() == 0) {
            return new UserFeedItemDelegate(false);
        } else {
            return new UserFeedItemDelegate(true);
        }
    }

    public void addFeedItem(UserFeedItem pItem) {
        this.mFeedList.add(new UserFeedItemDelegate(pItem));
    }

    public void resetFlag() {
        this.mGetAttempt = false;
    }

    public void runUpdate() {
        this.mUpdate.run();
    }

    public void emptyUpdate() {
        this.mEmptyUpdate = true;
    }

    public void likeToggle(String pFeedID) {
        for (int i = 0; i < this.mFeedList.size(); i++) {
            UserFeedItemDelegate aDelegate = (UserFeedItemDelegate) this.mFeedList.get(i);
            if (pFeedID.equals(aDelegate.getFeedID())) {
                aDelegate.toggleLike();
                break;
            }
        }
        runUpdate();
    }
}
