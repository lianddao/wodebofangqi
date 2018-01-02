package com.songbirdnest.soundboard.task;

import android.util.Log;
import com.songbirdnest.soundboard.SoundboardListener;
import com.songbirdnest.soundboard.SoundboardRunnable;
import com.songbirdnest.soundboard.SoundboardServer;
import com.songbirdnest.soundboard.data.ArtistInfo;
import com.songbirdnest.stream.AbstractStreamHandler;
import com.songbirdnest.stream.StreamException;
import com.songbirdnest.stream.StreamProcessor;
import com.songbirdnest.stream.StreamUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class RetrieveArtistInfo extends SoundboardRunnable<ArtistInfo> {
    public static final String ARTIST_INFO = "?fields=biography,tracks";
    public static final String SOUNDBOARD_PATH = "artists";
    static final String TAG = "ArtistInfo";
    protected String mUrl;

    static class ArtistInfoHandler extends AbstractStreamHandler<ArtistInfo> {
        ArtistInfoHandler() {
        }

        public ArtistInfo processInputStream(InputStream stream, long contentLength) throws StreamException {
            try {
                return new ArtistInfo(new JSONObject(readInputStream(stream)));
            } catch (JSONException e) {
                try {
                    Log.e(RetrieveArtistInfo.TAG, "JSON Parse Error", e);
                    return null;
                } catch (IOException ex) {
                    Log.e(getClass().getSimpleName(), "Problems getting Artist Info", ex);
                    return null;
                }
            }
        }
    }

    public RetrieveArtistInfo(SoundboardServer server, SoundboardListener<ArtistInfo> listener, String pArtistID) {
        super(server, listener);
        ArrayList<String> aParams = new ArrayList();
        aParams.add(pArtistID);
        this.mUrl = StreamUtils.buildURLString(server.getServer(), "artists", aParams);
        this.mUrl += ARTIST_INFO;
    }

    public void run() {
        try {
            StreamProcessor<ArtistInfo> processor = new StreamProcessor(this.mUrl, new ArtistInfoHandler());
            setupHeader(processor);
            this.listener.onSuccess((ArtistInfo) processor.processInputStream());
        } catch (StreamException ex) {
            this.listener.onFailure("Failed getting Artist Info", ex);
        }
    }
}
