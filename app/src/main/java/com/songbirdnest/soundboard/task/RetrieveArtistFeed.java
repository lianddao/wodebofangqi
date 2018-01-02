package com.songbirdnest.soundboard.task;

import android.util.Log;
import com.songbirdnest.soundboard.SoundboardListener;
import com.songbirdnest.soundboard.SoundboardRunnable;
import com.songbirdnest.soundboard.SoundboardServer;
import com.songbirdnest.soundboard.data.UserFeed;
import com.songbirdnest.stream.AbstractStreamHandler;
import com.songbirdnest.stream.StreamException;
import com.songbirdnest.stream.StreamProcessor;
import com.songbirdnest.stream.StreamUtils;
import com.songbirdnest.util.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class RetrieveArtistFeed extends SoundboardRunnable<UserFeed> {
    public static final String SOUNDBOARD_ACTION = "stream";
    public static final String SOUNDBOARD_PATH = "artists";
    protected String mUrl;

    static class ArtistFeedHandler extends AbstractStreamHandler<UserFeed> {
        ArtistFeedHandler() {
        }

        public UserFeed processInputStream(InputStream stream, long contentLength) throws StreamException {
            try {
                return new UserFeed(new JSONArray(readInputStream(stream)));
            } catch (JSONException ex) {
                Logger.error(this, "JSON Parse Error", ex);
            } catch (IOException e) {
                Logger.error(this, "IO Exception", e);
            }
            return null;
        }
    }

    public RetrieveArtistFeed(SoundboardServer server, SoundboardListener<UserFeed> listener, String pArtistID) {
        super(server, listener);
        ArrayList<String> aParams = new ArrayList();
        aParams.add(pArtistID);
        aParams.add("stream");
        this.mUrl = StreamUtils.buildURLString(server.getServer(), "artists", aParams);
    }

    public void run() {
        try {
            StreamProcessor<UserFeed> processor = new StreamProcessor(this.mUrl, new ArtistFeedHandler());
            setupHeader(processor);
            this.listener.onSuccess((UserFeed) processor.processInputStream());
        } catch (StreamException e) {
            Log.e(getClass().getSimpleName(), "Problems reading Feed");
        }
    }
}
