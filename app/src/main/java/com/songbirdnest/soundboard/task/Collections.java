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

public class Collections extends SoundboardRunnable<List<Collection>> {
    public static final String SOUNDBOARD_ACTION = "artists";
    public static final String SOUNDBOARD_PATH = "users";
    public static final String TAG = "Collections";
    protected String soundBoardId;
    protected String url;

    class CollectionStreamHandler extends AbstractStreamHandler<List<Collection>> {
        CollectionStreamHandler() {
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

    public Collections(SoundboardServer server, SoundboardListener<List<Collection>> listener, String soundBoardId) {
        super(server, listener);
        this.soundBoardId = soundBoardId;
        List<String> params = new ArrayList();
        params.add(soundBoardId);
        params.add("artists");
        this.url = StreamUtils.buildURLString(server.getServer(), "users", params);
    }

    public void run() {
        if (this.soundBoardId != null) {
            StreamProcessor<List<Collection>> processor = new StreamProcessor(this.url, new CollectionStreamHandler());
            try {
                setupHeader(processor);
                List<Collection> collections = (List) processor.processInputStream();
                if (this.listener == null) {
                    return;
                }
                if (collections == null || collections.size() == 0) {
                    this.listener.onFailure("Problems getting Collections from server", null);
                } else {
                    this.listener.onSuccess(collections);
                }
            } catch (StreamException e) {
                Logger.error(this, "Problems getting Collections from server", e);
                this.listener.onFailure("Problems getting Collections from server", e);
            }
        } else if (this.listener != null) {
            this.listener.onFailure("Soundboard id is null", null);
        }
    }
}
