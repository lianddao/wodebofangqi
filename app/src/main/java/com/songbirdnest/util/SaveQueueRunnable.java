package com.songbirdnest.util;

import android.content.Context;
import com.songbirdnest.mediaplayer.PlayableItem;
import com.songbirdnest.mediaplayer.service.PlayQueueDatabase;
import java.util.List;

public class SaveQueueRunnable implements Runnable {
    private Context mContext;
    private PlayableItem mCurrentItem;
    private List<PlayableItem> mPlayableList;
    private int mPlayableListPosition;
    private int mPlaybackPosition;
    private List<PlayableItem> mShuffledPlayableList;

    public void init(Context aContext, List<PlayableItem> aPlayableList, List<PlayableItem> aShuffledList, PlayableItem aCurrentItem, int aPlayableListPosition, int aPlaybackPosition) {
        this.mContext = aContext;
        this.mPlayableList = aPlayableList;
        this.mShuffledPlayableList = aShuffledList;
        this.mCurrentItem = aCurrentItem;
        this.mPlayableListPosition = aPlayableListPosition;
        this.mPlaybackPosition = aPlaybackPosition;
    }

    public void run() {
        PlayQueueDatabase pqd = new PlayQueueDatabase(this.mContext);
        pqd.saveQueueFromPlayableList(this.mPlayableList, this.mShuffledPlayableList, this.mCurrentItem, this.mPlayableListPosition, this.mPlaybackPosition);
        pqd.close();
    }
}
