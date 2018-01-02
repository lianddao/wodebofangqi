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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FriendLikes extends SoundboardRunnable<List<Collection>> {
    public static final String NULL_STRING = "null";
    public static final String SOUNDBOARD_ACTION = "friends";
    public static final String SOUNDBOARD_PATH = "users";
    public static final String TAG = "Friends";
    protected String friendId;
    protected String soundBoardId;
    protected String url;

    class FriendsStreamHandler extends AbstractStreamHandler<List<Collection>> {
        FriendsStreamHandler() {
        }

        public List<Collection> processInputStream(InputStream stream, long contentLength) throws StreamException {
            try {
                JSONArray jsonArray = new JSONArray(readInputStream(stream));
                int length = jsonArray.length();
                List<Collection> arrayList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    Collection collection = new Collection();
                    collection.parseJSON(jsonObject);
                    arrayList.add(collection);
                }
                return arrayList;
            } catch (IOException e) {
                Logger.error(this, "Problems getting Friends Likes from server", e);
                return null;
            } catch (JSONException e2) {
                Logger.error(this, "Problems getting Friends Likes from server", e2);
                return null;
            }
        }
    }

    public FriendLikes(SoundboardServer server, SoundboardListener<List<Collection>> listener, String soundBoardId, String friendId) {
        super(server, listener);
        if (soundBoardId == null) {
            soundBoardId = server.getCurrentSoundBoardId();
        }
        this.soundBoardId = soundBoardId;
        this.friendId = friendId;
        List<String> params = new ArrayList();
        params.add(soundBoardId);
        params.add("friends");
        params.add(friendId);
        this.url = StreamUtils.buildURLString(server.getServer(), "users", params);
    }

    public void run() {
        Logger.debug(this, "Processing " + this.url);
        StreamProcessor<List<Collection>> processor = new StreamProcessor(this.url, new FriendsStreamHandler());
        try {
            setupHeader(processor);
            List<Collection> collections = (List) processor.processInputStream();
            if (this.listener == null) {
                return;
            }
            if (collections == null || collections.size() == 0) {
                this.listener.onFailure("Problems getting Friends Likes from server", null);
            } else {
                this.listener.onSuccess(collections);
            }
        } catch (StreamException e) {
            Logger.error(this, "Problems getting Friends Likes from server", e);
            this.listener.onFailure("Problems getting Friends Likes from server", e);
        }
    }
}
