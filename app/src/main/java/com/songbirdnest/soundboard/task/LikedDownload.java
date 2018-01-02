package com.songbirdnest.soundboard.task;

import com.songbirdnest.soundboard.SoundboardListener;
import com.songbirdnest.soundboard.SoundboardRunnable;
import com.songbirdnest.soundboard.SoundboardServer;
import com.songbirdnest.soundboard.data.Collection;
import com.songbirdnest.stream.AbstractStreamHandler;
import com.songbirdnest.stream.StreamException;
import com.songbirdnest.stream.StreamProcessor;
import com.songbirdnest.stream.StreamUtils;
import com.songbirdnest.util.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LikedDownload extends SoundboardRunnable<List<Collection>> {
    static final String ACTION = "liked";
    static final String PATH = "users";
    static final String SUBPATH = "friends";
    protected String url;

    static class LikeStreamHandler extends AbstractStreamHandler<List<Collection>> {
        LikeStreamHandler() {
        }

        public List<Collection> processInputStream(InputStream stream, long contentLength) throws StreamException {
            try {
                JSONArray jsonArray = new JSONArray(readInputStream(stream));
                int length = jsonArray.length();
                TreeSet<Collection> sortedSet = new TreeSet();
                for (int i = 0; i < length; i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    Collection collection = new Collection();
                    collection.parseJSON(jsonObject);
                    sortedSet.add(collection);
                }
                return new ArrayList(sortedSet);
            } catch (IOException e) {
                Logger.error(this, "Problems getting Collections from server", e);
                return null;
            } catch (JSONException e2) {
                Logger.error(this, "Problems getting Collections from server", e2);
                return null;
            }
        }
    }

    public LikedDownload(SoundboardServer pServer, SoundboardListener<List<Collection>> pListener, String pSoundboardID, String pFacebookId) {
        super(pServer, pListener);
        if (pSoundboardID == null) {
            pSoundboardID = this.server.getCurrentSoundBoardId();
        }
        ArrayList<String> params = new ArrayList();
        params.add(pSoundboardID);
        params.add("friends");
        params.add(pFacebookId);
        params.add(ACTION);
        this.url = StreamUtils.buildURLString(this.server.getServer(), "users", params);
    }

    public void run() {
        StreamProcessor<List<Collection>> processor = new StreamProcessor(this.url, new LikeStreamHandler());
        try {
            processor.setReadTimeout(40000);
            setupHeader(processor);
            List<Collection> collections = (List) processor.processInputStream();
            if (this.listener == null) {
                return;
            }
            if (collections == null || collections.size() == 0) {
                this.listener.onFailure("Problems getting Liked from server", null);
            } else {
                this.listener.onSuccess(collections);
            }
        } catch (StreamException e) {
            Logger.error(this, "Problems getting Likes from server", e);
            this.listener.onFailure("Problems getting Likes from server", e);
        }
    }
}
