package com.xiaomi.music;

import android.content.Context;
import com.xiaomi.music.cloud.CloudEngine;
import com.xiaomi.music.cloud.impl.CloudEngineImpl;
import com.xiaomi.music.online.OnlineEngine;
import com.xiaomi.music.online.impl.OnlineEngineImpl;
import com.xiaomi.music.online.impl.OnlineJsonTag;
import com.xiaomi.music.statistics.StatEngine;
import com.xiaomi.music.statistics.impl.StatEngineImpl;
import com.xiaomi.music.util.MusicLog;
import com.xiaomi.music.util.StreamHelper;
import java.io.InputStream;
import org.json.JSONObject;

public class MusicEngine {
    private static final Object LOCK = new Object();
    static final String TAG = "MusicEngine";
    private static final String VERSION = "0.2";
    private static MusicEngine sIntance;
    private final CloudEngine mCloudEngine;
    private final OnlineEngine mOnlineEngine;
    private final StatEngine mStatEngine;

    private MusicEngine(Context context) {
        InputStream is = null;
        try {
            is = context.getAssets().open("xiaomi_music_sdk_config");
            JSONObject config = new JSONObject(StreamHelper.toString(is));
            this.mCloudEngine = new CloudEngineImpl(context, config.getJSONObject("cloud"));
            this.mOnlineEngine = new OnlineEngineImpl(context, config.getJSONObject(OnlineJsonTag.TAG_ONLINE));
            this.mStatEngine = new StatEngineImpl(context, config.getJSONObject("stat"));
            MusicLog.m399i(TAG, "Music Engine is initialized, version=" + getVersion());
            StreamHelper.closeSafe(is);
        } catch (Exception e) {
            MusicLog.m398e(TAG, "Init MusicEngine", e);
            throw new UnsupportedOperationException("Bad configuration: ");
        } catch (Throwable th) {
            StreamHelper.closeSafe(is);
        }
    }

    public static MusicEngine get(Context context) {
        synchronized (LOCK) {
            if (sIntance == null) {
                sIntance = new MusicEngine(context);
            }
        }
        return sIntance;
    }

    public String getVersion() {
        return VERSION;
    }

    public CloudEngine getCloudEngine() {
        return this.mCloudEngine;
    }

    public StatEngine getStatEngine() {
        return this.mStatEngine;
    }

    public OnlineEngine getOnlineEngine() {
        return this.mOnlineEngine;
    }
}
