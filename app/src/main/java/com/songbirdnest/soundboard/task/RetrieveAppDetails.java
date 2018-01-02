package com.songbirdnest.soundboard.task;

import com.songbirdnest.soundboard.SoundboardListener;
import com.songbirdnest.soundboard.SoundboardRunnable;
import com.songbirdnest.soundboard.SoundboardServer;
import com.songbirdnest.soundboard.data.AppDetails;
import com.songbirdnest.stream.AbstractStreamHandler;
import com.songbirdnest.stream.StreamException;
import com.songbirdnest.stream.StreamProcessor;
import com.songbirdnest.stream.StreamUtils;
import com.songbirdnest.util.Logger;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class RetrieveAppDetails extends SoundboardRunnable<AppDetails> {
    public static final String SOUNDBOARD_GET_ID = "appdetails";
    public static final String TAG = "RetrieveAppDetails";
    protected String url;

    class AppDetailsStreamHandler extends AbstractStreamHandler<AppDetails> {
        AppDetails aDetails = new AppDetails();

        AppDetailsStreamHandler() {
        }

        public AppDetails processInputStream(InputStream stream, long contentLength) throws StreamException {
            try {
                JSONObject jsonObject = new JSONObject(readInputStream(stream));
                if (jsonObject.has("app_id")) {
                    this.aDetails.appId = (String) jsonObject.get("app_id");
                }
                if (jsonObject.has("permissions")) {
                    this.aDetails.permissions = (String) jsonObject.get("permissions");
                }
            } catch (IOException e) {
                Logger.error(this, "Problems getting App Details from server", e);
            } catch (JSONException e2) {
                Logger.error(this, "Problems creating Soundboard user", e2);
            }
            return this.aDetails;
        }
    }

    public RetrieveAppDetails(SoundboardServer server, SoundboardListener<AppDetails> listener) {
        super(server, listener);
        this.url = StreamUtils.buildURLString(server.getServer(), SOUNDBOARD_GET_ID, null);
    }

    public void run() {
        StreamProcessor<AppDetails> processor = new StreamProcessor(this.url, new AppDetailsStreamHandler());
        try {
            setupHeader(processor);
            AppDetails bundle = (AppDetails) processor.processInputStream();
            if (this.listener != null) {
                this.listener.onSuccess(bundle);
            }
        } catch (StreamException e) {
            Logger.error(this, "Problems getting App Details from server", e);
            this.listener.onFailure("Problems getting App Details from server", e);
        }
    }
}
