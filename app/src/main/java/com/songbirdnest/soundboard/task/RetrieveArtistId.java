package com.songbirdnest.soundboard.task;

import android.util.Log;
import com.songbirdnest.soundboard.SoundboardListener;
import com.songbirdnest.soundboard.SoundboardRunnable;
import com.songbirdnest.soundboard.SoundboardServer;
import com.songbirdnest.soundboard.data.ArtistInfo;
import com.songbirdnest.stream.AbstractStreamHandler;
import com.songbirdnest.stream.RequestParameter;
import com.songbirdnest.stream.StreamException;
import com.songbirdnest.stream.StreamProcessor;
import com.songbirdnest.stream.StreamUtils;
import com.songbirdnest.util.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import org.cmc.music.myid3.id3v2.MyID3v2Constants;
import org.json.JSONArray;
import org.json.JSONException;

public class RetrieveArtistId extends SoundboardRunnable<ArtistInfo> {
    public static final String SOUNDBOARD_PATH = "search";
    static final String TAG = "ArtistId";
    protected String mUrl;

    static class ArtistIdHandler extends AbstractStreamHandler<ArtistInfo> {
        ArtistIdHandler() {
        }

        public ArtistInfo processInputStream(InputStream stream, long contentLength) throws StreamException {
            try {
                JSONArray aArray = new JSONArray(readInputStream(stream));
                if (aArray.length() == 0) {
                    return null;
                }
                return new ArtistInfo(aArray.getJSONObject(0));
            } catch (JSONException e) {
                try {
                    Log.e(RetrieveArtistId.TAG, "JSON Parse Error", e);
                    return null;
                } catch (IOException ex) {
                    Log.e(getClass().getSimpleName(), "Problems getting Artist Info", ex);
                    return null;
                }
            }
        }
    }

    public RetrieveArtistId(SoundboardServer server, SoundboardListener<ArtistInfo> listener, String artistName) {
        String searchName;
        super(server, listener);
        try {
            searchName = URLDecoder.decode(artistName, MyID3v2Constants.CHAR_ENCODING_UTF_8);
        } catch (UnsupportedEncodingException e) {
            searchName = artistName;
            Logger.error((Object) this, "Problems decoding " + artistName);
        }
        ArrayList<RequestParameter> parameters = new ArrayList();
        parameters.add(new RequestParameter("q", searchName));
        this.mUrl = StreamUtils.buildURLRequestString(server.getServer(), SOUNDBOARD_PATH, parameters);
    }

    public void run() {
        try {
            StreamProcessor<ArtistInfo> processor = new StreamProcessor(this.mUrl, new ArtistIdHandler());
            setupHeader(processor);
            this.listener.onSuccess((ArtistInfo) processor.processInputStream());
        } catch (StreamException ex) {
            this.listener.onFailure("Failed getting Artist Info", ex);
        }
    }
}
