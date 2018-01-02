package com.songbirdnest.mediaplayer.service;

import com.songbirdnest.mediaplayer.PlayableItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PlayerState {
    public static final int RANDOM_OFF = 2;
    public static final int RANDOM_ON = 1;
    public static final int REPEAT_ALL = 2;
    public static final int REPEAT_NONE = 1;
    public static final int REPEAT_ONE = 3;
    private int mListPosition = -1;
    private List<PlayableItem> mPlayableList;
    private Random mRandom = new Random();
    private int mRepeatState = 1;
    private boolean mShuffleEnabled;
    private List<PlayableItem> mShuffledPlayableList;

    public int getListPosition() {
        return this.mListPosition;
    }

    public void setListPosition(int mListPosition) {
        this.mListPosition = mListPosition;
    }

    public void incrementListPosition() {
        this.mListPosition++;
    }

    public void decrementListPosition() {
        this.mListPosition--;
    }

    public PlayableItem getActiveItem() {
        if (this.mListPosition == -1 || getActiveList() == null) {
            return new PlayableItem("<UNKNOWN>", null, -1, -1);
        }
        return (PlayableItem) getActiveList().get(this.mListPosition);
    }

    public List<PlayableItem> getActiveList() {
        if (this.mShuffleEnabled) {
            return this.mShuffledPlayableList;
        }
        return this.mPlayableList;
    }

    public List<PlayableItem> getShuffledPlayableList() {
        return this.mShuffledPlayableList;
    }

    public void setShuffledPlayableList(List<PlayableItem> pShuffledPlayableList) {
        this.mShuffledPlayableList = pShuffledPlayableList;
    }

    public List<PlayableItem> getPlayableList() {
        return this.mPlayableList;
    }

    public void setPlayableList(List<PlayableItem> pPlayableList) {
        this.mPlayableList = pPlayableList;
        this.mShuffledPlayableList = null;
        this.mListPosition = 0;
    }

    public boolean isShuffleEnabled() {
        return this.mShuffleEnabled;
    }

    public void fullShuffle() {
        if (this.mShuffledPlayableList != null) {
            Collections.shuffle(this.mShuffledPlayableList, this.mRandom);
        }
    }

    public void setShuffleEnabled(boolean pShuffleEnabled) {
        this.mShuffleEnabled = pShuffleEnabled;
        if (this.mShuffleEnabled && this.mPlayableList != null) {
            this.mShuffledPlayableList = new ArrayList(this.mPlayableList);
            PlayableItem aTopItem = (PlayableItem) this.mShuffledPlayableList.get(this.mListPosition);
            Collections.shuffle(this.mShuffledPlayableList, this.mRandom);
            this.mShuffledPlayableList.remove(aTopItem);
            this.mShuffledPlayableList.add(0, aTopItem);
        } else if (!this.mShuffleEnabled && this.mShuffledPlayableList != null) {
            this.mListPosition = this.mPlayableList.indexOf((PlayableItem) this.mShuffledPlayableList.get(this.mListPosition));
        }
    }

    public int getRepeatState() {
        return this.mRepeatState;
    }

    public void setRepeatState(int pRepeatState) {
        this.mRepeatState = pRepeatState;
    }
}
