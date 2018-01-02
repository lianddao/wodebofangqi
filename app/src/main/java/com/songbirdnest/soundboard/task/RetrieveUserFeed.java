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
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class RetrieveUserFeed extends SoundboardRunnable<UserFeed> {
    public static final String SOUNDBOARD_ACTION = "stream";
    public static final String SOUNDBOARD_PATH = "users";
    static final String TAG = RetrieveUserFeed.class.getSimpleName();
    protected String mSoundboardID;
    protected String mUrl;

    static class UserFeedHandler extends AbstractStreamHandler<UserFeed> {
        UserFeedHandler() {
        }

        public UserFeed processInputStream(InputStream stream, long contentLength) throws StreamException {
            try {
                return new UserFeed(new JSONArray(readInputStream(stream)));
            } catch (JSONException ex) {
                Log.e(RetrieveUserFeed.TAG, "JSON Parse Error", ex);
            } catch (IOException e) {
                Log.e(RetrieveUserFeed.TAG, "IO Exception", e);
            }
            return null;
        }
    }

    public RetrieveUserFeed(SoundboardServer server, SoundboardListener<UserFeed> listener, String pSoundboardID, int pOffset, int pLimit) {
        super(server, listener);
        this.mSoundboardID = pSoundboardID;
        ArrayList<String> aParams = new ArrayList();
        aParams.add("%1$s");
        aParams.add("stream");
        this.mUrl = StreamUtils.buildURLString(server.getServer(), "users", aParams);
        this.mUrl += String.format("?offset=%1$d&limit=%2$d", new Object[]{Integer.valueOf(pOffset), Integer.valueOf(pLimit)});
    }

    public void run() {
        try {
            if (this.mSoundboardID == null) {
                this.mSoundboardID = this.server.getCurrentSoundBoardId();
            }
            this.mUrl = String.format(this.mUrl, new Object[]{this.mSoundboardID});
            Log.i("Tracker", "URL: " + this.mUrl);
            StreamProcessor<UserFeed> processor = new StreamProcessor(this.mUrl, new UserFeedHandler());
            setupHeader(processor);
            this.listener.onSuccess((UserFeed) processor.processInputStream());
        } catch (StreamException ex) {
            this.listener.onFailure("Failed getting User Feed", ex);
        }
    }
}
