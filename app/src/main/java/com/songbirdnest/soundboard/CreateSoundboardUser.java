package com.songbirdnest.soundboard;

import com.mixpanel.android.mpmetrics.MPDbAdapter;
import com.songbirdnest.database.cookies.CookieDatabaseHelper;
import com.songbirdnest.facebook.FacebookUser;
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
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.cmc.music.myid3.id3v2.MyID3v2Constants;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateSoundboardUser extends SoundboardRunnable<String> {
    public static final String SOUNDBOARD_OAUTH_ACCOUNTS = "oauth_accounts";
    private boolean debugging = true;
    protected FacebookUser facebookUser;
    protected String url;

    class CreateUserStreamHandler extends AbstractStreamHandler<String> {
        CreateUserStreamHandler() {
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
                Logger.error(this, "Problems creating Soundboard user", e);
            } catch (JSONException e2) {
                Logger.error(this, "Problems creating Soundboard user", e2);
            }
            return null;
        }
    }

    public CreateSoundboardUser(SoundboardServer server, SoundboardListener<String> listener, FacebookUser facebookUser) {
        super(server, listener);
        this.facebookUser = facebookUser;
        List<String> params = new ArrayList();
        params.add(facebookUser.getId());
        this.url = StreamUtils.buildURLString(server.getServer(), "oauth_accounts", params);
        if (this.debugging) {
            Logger.debug(this, "CreateSoundboardUser. Calling " + this.url);
        }
    }

    public void run() {
        StreamProcessor<String> processor = new StreamProcessor(this.url, new CreateUserStreamHandler());
        try {
            List<BasicNameValuePair> pairs = new ArrayList();
            pairs.add(new BasicNameValuePair(MPDbAdapter.KEY_TOKEN, this.facebookUser.getAccessToken()));
            pairs.add(new BasicNameValuePair("email", this.facebookUser.getEmail()));
            pairs.add(new BasicNameValuePair("expires", String.valueOf(this.facebookUser.getExpiration())));
            UrlEncodedFormEntity stringEntity = new UrlEncodedFormEntity(pairs, MyID3v2Constants.CHAR_ENCODING_UTF_8);
            this.server.deleteCookieStore();
            setupHeader(processor);
            String id = (String) processor.processInputStream(stringEntity);
            CookieStore cookieStore = processor.getCookieStore();
            if (cookieStore != null) {
                this.server.setCookieStore(cookieStore);
                CookieDatabaseHelper cookieDatabaseHelper = CookieDatabaseHelper.getInstance(this.server.getContext());
                cookieDatabaseHelper.addCookieStore(cookieStore);
                cookieDatabaseHelper.close();
            }
            if (this.listener == null) {
                return;
            }
            if (id == null || id.length() == 0) {
                this.listener.onFailure("Problems creating Soundboard user", null);
            } else {
                this.listener.onSuccess(id);
            }
        } catch (Throwable e) {
            Logger.error(this, "Problems creating Soundboard user", e);
            this.listener.onFailure("Problems creating Soundboard user", new StreamException(e));
        } catch (StreamException e2) {
            Logger.error(this, "Problems creating Soundboard user", e2);
            this.listener.onFailure("Problems creating Soundboard user", e2);
        }
    }
}
