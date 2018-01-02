package com.songbirdnest.soundboard.task;

import com.songbirdnest.database.cookies.CookieTable;
import com.songbirdnest.mediaplayer.Utils;
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
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BulkFollowArtists extends SoundboardRunnable<List<String>> {
    public static final String SOUNDBOARD_ACTION = "artists";
    public static final String SOUNDBOARD_PATH = "users";
    protected List<String> artistIds;
    protected String soundBoardId;
    protected String url;

    class CollectionStreamHandler extends AbstractStreamHandler<List<String>> {
        CollectionStreamHandler() {
        }

        public StreamType getType() {
            return StreamType.POST_TYPE;
        }

        public List<String> processInputStream(InputStream stream, long contentLength) throws StreamException {
            try {
                JSONArray jsonResult = new JSONArray(readInputStream(stream));
                List<String> arrayList = new ArrayList();
                for (int i = 0; i < jsonResult.length(); i++) {
                    arrayList.add(jsonResult.get(i).toString());
                }
                return arrayList;
            } catch (IOException e) {
                Logger.error(this, "Problems following artists", e);
                return null;
            } catch (JSONException e2) {
                Logger.error(this, "Problems following artists", e2);
                return null;
            }
        }
    }

    public BulkFollowArtists(SoundboardServer server, String soundBoardId, List<String> artistIds, SoundboardListener<List<String>> listener) {
        super(server, listener);
        this.soundBoardId = soundBoardId;
        this.artistIds = artistIds;
        List<String> params = new ArrayList();
        params.add(soundBoardId);
        params.add("artists");
        this.url = StreamUtils.buildURLString(server.getServer(), "users", params);
    }

    public void run() {
        Logger.debug(this, "Processing " + this.url);
        if (this.soundBoardId != null) {
            StreamProcessor<List<String>> processor = new StreamProcessor(this.url, new CollectionStreamHandler());
            try {
                setupHeader(processor);
                JSONObject json = new JSONObject();
                JSONArray jsonArtists = new JSONArray();
                json.put("artists", jsonArtists);
                for (String artistId : this.artistIds) {
                    JSONObject artistObject = new JSONObject();
                    artistObject.put(CookieTable.NAME, Utils.encode(artistId));
                    jsonArtists.put(artistObject);
                }
                StringEntity stringEntity = new StringEntity(json.toString());
                stringEntity.setContentType(new BasicHeader("Content-Type", "application/json"));
                processor.addRequestHeader("Content-Type", "application/json");
                List<String> result = (List) processor.processInputStream(stringEntity);
                if (result == null) {
                    if (this.listener != null) {
                        this.listener.onFailure("Problems following artists", null);
                    }
                } else if (this.listener != null) {
                    this.listener.onSuccess(result);
                }
            } catch (StreamException e) {
                Logger.error(this, "Problems following artists", e);
                this.listener.onFailure("Problems following artists", e);
            } catch (Throwable e2) {
                Logger.error(this, "Problems following artists", e2);
                this.listener.onFailure("Problems following artists", new StreamException(e2));
            } catch (Throwable e22) {
                Logger.error(this, "Problems following artists", e22);
                this.listener.onFailure("Problems following artists", new StreamException(e22));
            }
        } else if (this.listener != null) {
            this.listener.onFailure("Soundboard id is null", null);
        }
    }
}
