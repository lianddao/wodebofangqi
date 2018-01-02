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
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.json.JSONObject;

public class SetUTC extends SoundboardRunnable<String> {
    public static final String SOUNDBOARD_ACTION = "settings";
    public static final String SOUNDBOARD_PATH = "users";
    private boolean debugging = true;
    protected String soundBoardId;
    protected String url;
    protected String utcOffset;

    class RegisterDeviceStreamHandler extends AbstractStreamHandler<String> {
        RegisterDeviceStreamHandler() {
        }

        public StreamType getType() {
            return StreamType.POST_TYPE;
        }

        public String processInputStream(InputStream stream, long contentLength) throws StreamException {
            try {
                readInputStream(stream);
            } catch (IOException e) {
                Logger.error(this, "Problems registering device", e);
            }
            return null;
        }
    }

    public SetUTC(SoundboardServer server, String soundBoardId, String utcOffset, SoundboardListener<String> listener) {
        super(server, listener);
        this.soundBoardId = soundBoardId;
        this.utcOffset = utcOffset;
        List<String> params = new ArrayList();
        params.add(soundBoardId);
        params.add(SOUNDBOARD_ACTION);
        this.url = StreamUtils.buildURLString(server.getServer(), "users", params);
        if (this.debugging) {
            Logger.debug(this, "Setting UTC Timezone. Calling " + this.url);
        }
    }

    public void run() {
        if (this.soundBoardId != null) {
            StreamProcessor<String> processor = new StreamProcessor(this.url, new RegisterDeviceStreamHandler());
            try {
                setupHeader(processor);
                JSONObject json = new JSONObject();
                json.put("utc_offset", this.utcOffset);
                StringEntity stringEntity = new StringEntity(json.toString());
                stringEntity.setContentType(new BasicHeader("Content-Type", "application/json"));
                processor.addRequestHeader("Content-Type", "application/json");
                processor.processInputStream(stringEntity);
                if (this.listener != null) {
                    this.listener.onSuccess(null);
                }
            } catch (Throwable e) {
                Logger.error(this, "Problems registering device", e);
                this.listener.onFailure("Problems registering device", new StreamException(e));
            } catch (StreamException e2) {
                Logger.error(this, "Problems registering device", e2);
                this.listener.onFailure("Problems registering device", e2);
            } catch (Throwable e3) {
                Logger.error(this, "Problems following artists", e3);
                this.listener.onFailure("Problems following artists", new StreamException(e3));
            }
        } else if (this.listener != null) {
            this.listener.onFailure("Soundboard id is null", null);
        }
    }
}
