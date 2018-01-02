package com.songbirdnest.mediaplayer.view.adapter;

import android.util.Log;
import com.songbirdnest.soundboard.SoundboardListener;
import com.songbirdnest.soundboard.data.UserFeed;
import com.songbirdnest.soundboard.data.UserFeedItem;
import com.songbirdnest.stream.StreamException;

public class UserFeedReturn implements SoundboardListener<UserFeed> {
    Delegate mDelegate;

    public interface Delegate {
        void addFeedItem(UserFeedItem userFeedItem);

        void emptyUpdate();

        void resetFlag();

        void runUpdate();
    }

    public UserFeedReturn(Delegate pDelegate) {
        this.mDelegate = pDelegate;
    }

    public void onSuccess(UserFeed result) {
        for (int i = 0; i < result.getItemCount(); i++) {
            this.mDelegate.addFeedItem(result.getItem(i));
        }
        this.mDelegate.runUpdate();
        if (result.getItemCount() != 0) {
            this.mDelegate.resetFlag();
        } else {
            this.mDelegate.emptyUpdate();
        }
    }

    public void onFailure(String message, StreamException exception) {
        Log.e(getClass().getSimpleName(), "Problem getting User Feed", exception);
    }
}
