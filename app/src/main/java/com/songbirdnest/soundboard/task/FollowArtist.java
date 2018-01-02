package com.songbirdnest.soundboard.task;

import com.songbirdnest.soundboard.SoundboardListener;
import com.songbirdnest.soundboard.SoundboardRunnable;
import com.songbirdnest.soundboard.SoundboardServer;
import com.songbirdnest.stream.AbstractStreamHandler;
import com.songbirdnest.stream.StreamException;
import com.songbirdnest.stream.StreamProcessor;
import com.songbirdnest.stream.StreamType;
import com.songbirdnest.stream.StreamUtils;
import com.songbirdnest.util.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class FollowArtist extends SoundboardRunnable<String> {
    public static final String SOUNDBOARD_ACTION = "artists";
    public static final String SOUNDBOARD_PATH = "users";
    protected String soundBoardId;
    protected String url;

    class CollectionStreamHandler extends AbstractStreamHandler<String> {
        CollectionStreamHandler() {
        }

        public StreamType getType() {
            return StreamType.PUT_TYPE;
        }

        public String processInputStream(InputStream stream, long contentLength) throws StreamException {
            try {
                String jsonString = readInputStream(stream);
                JSONObject jSONObject = new JSONObject(jsonString);
                return jsonString;
            } catch (IOException e) {
                Logger.error(this, "Problems following artist", e);
            } catch (JSONException e2) {
                Logger.error(this, "Problems following artist", e2);
            }
            return null;
        }
    }

    public FollowArtist(SoundboardServer server, String soundBoardId, String artistId, SoundboardListener<String> listener) {
        super(server, listener);
        this.soundBoardId = soundBoardId;
        List<String> params = new ArrayList();
        params.add(soundBoardId);
        params.add("artists");
        params.add(artistId);
        this.url = StreamUtils.buildURLString(server.getServer(), "users", params);
    }

    public void run() {
        Logger.debug(this, "Processing " + this.url);
        if (this.soundBoardId != null) {
            StreamProcessor<String> processor = new StreamProcessor(this.url, new CollectionStreamHandler());
            try {
                setupHeader(processor);
                String result = (String) processor.processInputStream();
                if (this.listener != null) {
                    this.listener.onSuccess(result);
                }
            } catch (StreamException e) {
                Logger.error(this, "Problems following artist", e);
                this.listener.onFailure("Problems following artist", e);
            }
        } else if (this.listener != null) {
            this.listener.onFailure("Soundboard id is null", null);
        }
    }
}
