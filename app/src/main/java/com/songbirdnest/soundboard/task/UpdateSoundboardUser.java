package com.songbirdnest.soundboard.task;

import com.mixpanel.android.mpmetrics.MPDbAdapter;
import com.songbirdnest.facebook.FacebookUser;
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
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.cmc.music.myid3.id3v2.MyID3v2Constants;
import org.json.JSONException;
import org.json.JSONObject;

public class UpdateSoundboardUser extends SoundboardRunnable<String> {
    public static final String SOUNDBOARD_OAUTH_ACCOUNTS = "oauth_accounts";
    public static final String SOUNDBOARD_REFRESH_PATH = "refresh_token";
    public static final String TAG = "CreateSoundboardUser";
    protected FacebookUser facebookUser;
    protected String url;

    class UpdateUserStreamHandler extends AbstractStreamHandler<String> {
        UpdateUserStreamHandler() {
        }

        public StreamType getType() {
            return StreamType.POST_TYPE;
        }

        public String processInputStream(InputStream stream, long contentLength) throws StreamException {
            try {
                JSONObject jsonObject = new JSONObject(readInputStream(stream));
                if (jsonObject.has("id")) {
                    return (String) jsonObject.get("id");
                }
            } catch (IOException e) {
                Logger.error(this, "Problems updating Soundboard user", e);
            } catch (JSONException e2) {
                Logger.error(this, "Problems updating Soundboard user", e2);
            }
            return null;
        }
    }

    public UpdateSoundboardUser(SoundboardServer server, SoundboardListener<String> listener, FacebookUser facebookUser) {
        super(server, listener);
        this.facebookUser = facebookUser;
        List<String> params = new ArrayList();
        params.add(facebookUser.getId());
        params.add(SOUNDBOARD_REFRESH_PATH);
        this.url = StreamUtils.buildURLString(server.getServer(), "oauth_accounts", params);
    }

    public void run() {
        Logger.debug(this, "Processing " + this.url);
        StreamProcessor<String> processor = new StreamProcessor(this.url, new UpdateUserStreamHandler());
        try {
            StringBuilder builder = new StringBuilder();
            try {
                builder.append("id=").append(this.facebookUser.getId()).append("&token=").append(this.facebookUser.getAccessToken()).append("&email=").append(this.facebookUser.getEmail()).append("&expires=0");
                Logger.debug(this, "Processing StringEntity " + builder.toString());
                List<BasicNameValuePair> pairs = new ArrayList();
                pairs.add(new BasicNameValuePair(MPDbAdapter.KEY_TOKEN, this.facebookUser.getAccessToken()));
                pairs.add(new BasicNameValuePair("email", this.facebookUser.getEmail()));
                pairs.add(new BasicNameValuePair("expires", String.valueOf(this.facebookUser.getExpiration())));
                UrlEncodedFormEntity stringEntity = new UrlEncodedFormEntity(pairs, MyID3v2Constants.CHAR_ENCODING_UTF_8);
                setupHeader(processor);
                String id = (String) processor.processInputStream(stringEntity);
                if (this.listener == null) {
                    return;
                }
                if (id == null || id.length() == 0) {
                    this.listener.onFailure("Problems updating Soundboard user", null);
                } else {
                    this.listener.onSuccess(id);
                }
            } catch (UnsupportedEncodingException e) {
                Logger.error(this, "Problems updating StringEntity " + builder.toString(), e);
                this.listener.onFailure("Problems updating StringEntity " + builder.toString(), null);
            }
        } catch (StreamException e2) {
            Logger.error(this, "Problems updating Soundboard user", e2);
            this.listener.onFailure("Problems updating Soundboard user", e2);
        }
    }
}
