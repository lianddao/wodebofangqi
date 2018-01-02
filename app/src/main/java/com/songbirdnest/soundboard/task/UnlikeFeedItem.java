package com.songbirdnest.soundboard.task;

import android.util.Log;
import com.songbirdnest.soundboard.SoundboardListener;
import com.songbirdnest.soundboard.SoundboardServer;
import com.songbirdnest.stream.StreamException;
import com.songbirdnest.stream.StreamProcessor;
import com.songbirdnest.stream.StreamType;

public class UnlikeFeedItem extends LikeFeedItem {

    static class UnlikeFeedHandler extends LikeFeedHandler {
        UnlikeFeedHandler() {
        }

        public StreamType getType() {
            return StreamType.DELETE_TYPE;
        }
    }

    public UnlikeFeedItem(SoundboardServer server, String pItemID, String pUserID, SoundboardListener<String> listener) {
        super(server, pItemID, pUserID, listener);
    }

    public void run() {
        StreamProcessor<String> processor = new StreamProcessor(this.url, new UnlikeFeedHandler());
        try {
            setupHeader(processor);
            String result = (String) processor.processInputStream();
            if (this.listener != null) {
                this.listener.onSuccess(result);
            }
        } catch (StreamException ex) {
            Log.e(getClass().getSimpleName(), "Problems unliking feed item", ex);
            this.listener.onFailure("Problem unliking feed item", ex);
        }
    }
}
