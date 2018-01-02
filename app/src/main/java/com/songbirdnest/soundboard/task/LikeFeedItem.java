package com.songbirdnest.soundboard.task;

import android.util.Log;
import com.songbirdnest.soundboard.SoundboardListener;
import com.songbirdnest.soundboard.SoundboardRunnable;
import com.songbirdnest.soundboard.SoundboardServer;
import com.songbirdnest.stream.AbstractStreamHandler;
import com.songbirdnest.stream.StreamException;
import com.songbirdnest.stream.StreamProcessor;
import com.songbirdnest.stream.StreamType;
import com.songbirdnest.stream.StreamUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class LikeFeedItem extends SoundboardRunnable<String> {
    public static final String SOUNDBOARD_ACTION = "likes";
    public static final String SOUNDBOARD_PATH = "users";
    protected String url;

    static class LikeFeedHandler extends AbstractStreamHandler<String> {
        LikeFeedHandler() {
        }

        public StreamType getType() {
            return StreamType.PUT_TYPE;
        }

        public String processInputStream(InputStream stream, long contentLength) throws StreamException {
            try {
                return readInputStream(stream);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public LikeFeedItem(SoundboardServer server, String pItemID, String pUserID, SoundboardListener<String> listener) {
        super(server, listener);
        List<String> params = new ArrayList();
        params.add(pUserID);
        params.add(SOUNDBOARD_ACTION);
        params.add(pItemID);
        this.url = StreamUtils.buildURLString(server.getServer(), "users", params);
    }

    public void run() {
        StreamProcessor<String> processor = new StreamProcessor(this.url, new LikeFeedHandler());
        try {
            setupHeader(processor);
            String result = (String) processor.processInputStream();
            if (this.listener != null) {
                this.listener.onSuccess(result);
            }
        } catch (StreamException ex) {
            Log.e(getClass().getSimpleName(), "Problems liking feed item", ex);
            this.listener.onFailure("Problems liking feed item", ex);
        }
    }
}
