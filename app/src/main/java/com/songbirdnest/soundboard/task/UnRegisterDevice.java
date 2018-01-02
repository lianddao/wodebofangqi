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
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.cmc.music.myid3.id3v2.MyID3v2Constants;

public class UnRegisterDevice extends SoundboardRunnable<String> {
    public static final String SOUNDBOARD_ACTION = "devices";
    public static final String SOUNDBOARD_PATH = "users";
    protected String url;

    class RegisterDeviceStreamHandler extends AbstractStreamHandler<String> {
        RegisterDeviceStreamHandler() {
        }

        public StreamType getType() {
            return StreamType.DELETE_TYPE;
        }

        public String processInputStream(InputStream stream, long contentLength) throws StreamException {
            try {
                readInputStream(stream);
            } catch (IOException e) {
                Logger.error(this, "Problems unregistering device", e);
            }
            return null;
        }
    }

    public UnRegisterDevice(SoundboardServer server, String soundBoardId, String deviceId, SoundboardListener<String> listener) {
        super(server, listener);
        List<String> params = new ArrayList();
        params.add(soundBoardId);
        params.add("devices");
        params.add(deviceId);
        this.url = StreamUtils.buildURLString(server.getServer(), "users", params);
    }

    public void run() {
        StreamProcessor<String> processor = new StreamProcessor(this.url, new RegisterDeviceStreamHandler());
        try {
            List<BasicNameValuePair> pairs = new ArrayList();
            pairs.add(new BasicNameValuePair("type", "android"));
            UrlEncodedFormEntity stringEntity = new UrlEncodedFormEntity(pairs, MyID3v2Constants.CHAR_ENCODING_UTF_8);
            setupHeader(processor);
            processor.processInputStream(stringEntity);
            if (this.listener != null) {
                this.listener.onSuccess(null);
            }
        } catch (Throwable e) {
            Logger.error(this, "Problems unregistering device", e);
            this.listener.onFailure("Problems unregistering device", new StreamException(e));
        } catch (StreamException e2) {
            Logger.error(this, "Problems unregistering device", e2);
            this.listener.onFailure("Problems unregistering device", e2);
        }
    }
}
