package com.songbirdnest.soundboard.task;

import com.songbirdnest.database.cookies.CookieTable;
import com.songbirdnest.soundboard.SoundboardListener;
import com.songbirdnest.soundboard.SoundboardRunnable;
import com.songbirdnest.soundboard.SoundboardServer;
import com.songbirdnest.soundboard.data.Friend;
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

public class Friends extends SoundboardRunnable<List<Friend>> {
    public static final String NULL_STRING = "null";
    public static final String SOUNDBOARD_ACTION = "friends";
    public static final String SOUNDBOARD_PATH = "users";
    public static final String TAG = "Friends";
    protected String soundBoardId;
    protected String url;

    class FriendsStreamHandler extends AbstractStreamHandler<List<Friend>> {
        FriendsStreamHandler() {
        }

        public List<Friend> processInputStream(InputStream stream, long contentLength) throws StreamException {
            try {
                JSONArray jsonArray = new JSONArray(readInputStream(stream));
                int length = jsonArray.length();
                List<Friend> arrayList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    if (jsonObject.has("id")) {
                        Friend user = new Friend();
                        String id = jsonObject.getString("id");
                        if (!(id == null || id.length() <= 0 || "null".equalsIgnoreCase(id))) {
                            user.setSoundBoardId(id);
                        }
                        user.setFacebookId(jsonObject.optString("facebook_id", null));
                        user.setFullName(jsonObject.optString(CookieTable.NAME, null));
                        arrayList.add(user);
                    }
                }
                return arrayList;
            } catch (IOException e) {
                Logger.error(this, "Problems getting Friends from server", e);
                return null;
            } catch (JSONException e2) {
                Logger.error(this, "Problems getting Friends from server", e2);
                return null;
            }
        }
    }

    public Friends(SoundboardServer server, SoundboardListener<List<Friend>> listener, String soundBoardId) {
        super(server, listener);
        if (soundBoardId == null) {
            soundBoardId = server.getCurrentSoundBoardId();
        }
        this.soundBoardId = soundBoardId;
        List<String> params = new ArrayList();
        params.add(soundBoardId);
        params.add("friends");
        this.url = StreamUtils.buildURLString(server.getServer(), "users", params);
    }

    public void run() {
        if (this.soundBoardId == null) {
            this.soundBoardId = this.server.getCurrentSoundBoardId();
            if (this.soundBoardId != null) {
                List<String> params = new ArrayList();
                params.add(this.soundBoardId);
                params.add("friends");
                this.url = StreamUtils.buildURLString(this.server.getServer(), "users", params);
            } else if (this.listener != null) {
                this.listener.onFailure("No current soundboard user", null);
                return;
            } else {
                return;
            }
        }
        StreamProcessor<List<Friend>> processor = new StreamProcessor(this.url, new FriendsStreamHandler());
        try {
            setupHeader(processor);
            List<Friend> friends = (List) processor.processInputStream();
            if (friends == null) {
                Logger.error((Object) this, "Problems finding Friends");
            }
            if (this.listener == null) {
                return;
            }
            if (friends == null) {
                this.listener.onFailure("Problems getting Friends from server", null);
            } else {
                this.listener.onSuccess(friends);
            }
        } catch (StreamException e) {
            Logger.error(this, "Problems getting Friends from server", e);
            this.listener.onFailure("Problems getting Friends from server", e);
        }
    }
}
