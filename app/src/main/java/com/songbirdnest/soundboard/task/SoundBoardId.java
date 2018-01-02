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

public class SoundBoardId extends SoundboardRunnable<String> {
    public static final String SOUNDBOARD_OAUTH_ACCOUNTS = "oauth_accounts";
    public static final String TAG = "SoundBoardId";
    protected String facebookId;
    protected String url;

    class FacebookIDStreamHandler extends AbstractStreamHandler<String> {
        FacebookIDStreamHandler() {
        }

        public StreamType getType() {
            return StreamType.PUT_TYPE;
        }

        public String processInputStream(InputStream stream, long contentLength) throws StreamException {
            try {
                JSONObject jsonObject = new JSONObject(readInputStream(stream));
                if (jsonObject.has("id")) {
                    return (String) jsonObject.get("id");
                }
            } catch (IOException e) {
                Logger.error(this, "Problems getting Soundboard ID from server", e);
            } catch (JSONException e2) {
                Logger.error(this, "Problems creating Soundboard user", e2);
            }
            return null;
        }
    }

    public SoundBoardId(SoundboardServer server, SoundboardListener<String> listener, String facebookId) {
        super(server, listener);
        this.facebookId = facebookId;
        List<String> params = new ArrayList();
        params.add(facebookId);
        this.url = StreamUtils.buildURLString(server.getServer(), "oauth_accounts", params);
    }

    public void run() {
        Logger.debug(this, "Processing " + this.url);
        StreamProcessor<String> processor = new StreamProcessor(this.url, new FacebookIDStreamHandler());
        try {
            setupHeader(processor);
            String id = (String) processor.processInputStream();
            if (this.listener == null) {
                return;
            }
            if (id == null || id.length() == 0) {
                this.listener.onFailure("Problems getting Soundboard ID from server", null);
            } else {
                this.listener.onSuccess(id);
            }
        } catch (StreamException e) {
            if (e.getResponseCode() == 401) {
                Logger.error((Object) this, "Error 401: User unauthorized");
            } else if (e.getResponseCode() == 404) {
                Logger.error((Object) this, "Error 404: User Not found");
            } else {
                Logger.error(this, "Problems getting Soundboard ID from server", e);
            }
            this.listener.onFailure("Problems getting Soundboard ID from server", e);
        }
    }
}
