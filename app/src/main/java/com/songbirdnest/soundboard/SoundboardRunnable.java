package com.songbirdnest.soundboard;

import android.os.Build;
import android.os.Build.VERSION;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.stream.StreamProcessor;
import java.util.Locale;
import org.cmc.music.myid3.id3v2.MyID3v2Constants;

public abstract class SoundboardRunnable<Result> implements Runnable {
    public static final String ACCEPT = "Accept";
    public static final String ENCODING = "Accept-Encoding";
    public static final String ENC_TYPE = "gzip";
    public static final String acceptString = "application/vnd.songbirdnest-com.";
    public static final String acceptType = "+json";
    protected SoundboardListener<Result> listener;
    protected SoundboardServer server;

    public abstract void run();

    protected SoundboardRunnable(SoundboardServer server, SoundboardListener<Result> listener) {
        this.listener = listener;
        this.server = server;
    }

    protected void setupHeader(StreamProcessor<Result> processor) {
        processor.addRequestHeader(ACCEPT, "application/vnd.songbirdnest-com.v1+json");
        processor.addRequestHeader(ENCODING, ENC_TYPE);
        StringBuilder builder = new StringBuilder();
        builder.append("Songbird/").append(this.server.getContext().getString(C0116R.string.core_version));
        builder.append(" (Android ").append(VERSION.RELEASE).append(";");
        builder.append(Locale.getDefault().toString()).append(";");
        builder.append(Build.PRODUCT).append(";");
        switch (VERSION.SDK_INT) {
            case 5:
                builder.append("Eclair 2.0)");
                break;
            case 6:
                builder.append("Eclair 2.0.1)");
                break;
            case 7:
                builder.append("Eclair 2.1)");
                break;
            case 8:
                builder.append("Froyo)");
                break;
            case MyID3v2Constants.PICTURE_TYPE_CONDUCTOR /*9*/:
                builder.append("Gingerbread 2.3)");
                break;
            case 10:
                builder.append("Gingerbread 2.3.3)");
                break;
            case MyID3v2Constants.PICTURE_TYPE_COMPOSER /*11*/:
                builder.append("Honeycomb 3.0)");
                break;
            case MyID3v2Constants.PICTURE_TYPE_LYRICIST_TEXT_WRITER /*12*/:
                builder.append("Honeycomb 3.1)");
                break;
            case MyID3v2Constants.PICTURE_TYPE_RECORDING_LOCATION /*13*/:
                builder.append("Honeycomb 3.2)");
                break;
            case MyID3v2Constants.PICTURE_TYPE_DURING_RECORDING /*14*/:
                builder.append("ICS 4.0)");
                break;
            case MyID3v2Constants.PICTURE_TYPE_DURING_PERFORMANCE /*15*/:
                builder.append("ICS 4.0.03)");
                break;
        }
        processor.addRequestHeader("User-Agent", builder.toString());
        processor.setCookieStore(this.server.getCookieStore());
    }
}
