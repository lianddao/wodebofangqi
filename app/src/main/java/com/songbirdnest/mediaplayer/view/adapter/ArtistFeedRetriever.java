package com.songbirdnest.mediaplayer.view.adapter;

import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.soundboard.SoundboardServer;

public class ArtistFeedRetriever extends FeedRetriever {
    protected String artistId;

    public ArtistFeedRetriever(Runnable pUpdate, String pSoundboardID, String artistId) {
        super(pUpdate, pSoundboardID);
        this.artistId = artistId;
    }

    public void refreshList() {
        this.mFeedList.clear();
        SoundboardServer.get().getArtistFeed(new UserFeedReturn(this), this.artistId);
        this.mGetAttempt = true;
        this.mEmptyUpdate = false;
        this.mUpdate.run();
    }

    protected void requestAdditional() {
        if (!this.mGetAttempt) {
            SoundboardServer.get().getArtistFeed(new UserFeedReturn(this), this.artistId);
            if (this.mFeedList.size() != 0) {
                Analytics.get().track(Analytics.EVENT_WHATS_NEW_EXTEND);
            }
            this.mGetAttempt = true;
        }
    }
}
