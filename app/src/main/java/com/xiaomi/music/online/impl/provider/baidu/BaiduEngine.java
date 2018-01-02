package com.xiaomi.music.online.impl.provider.baidu;

import android.content.Context;
import android.os.Handler;
import com.baidu.music.SDKEngine;
import com.baidu.music.SDKInterface;
import com.baidu.music.oauth.OAuthInterface.onAuthorizeFinishListener;
import com.baidu.music.oauth.OAuthManager;
import com.baidu.music.onlinedata.OnlineManagerEngine;
import com.xiaomi.music.MusicEngine;
import com.xiaomi.music.online.impl.OnlineJsonTag;
import com.xiaomi.music.util.MusicLog;
import com.xiaomi.music.util.ThreadManager.BlockingRequest;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONObject;

class BaiduEngine {
    private static final long AUTHORITY_TIME_OUT = 432000;
    static final String TAG = "BaiduEngine";
    private static String sAppId;
    private static String sAppKey;
    private static OnlineManagerEngine sEngine;
    private static String sSecretKey;

    static class C05411 implements SDKInterface {
        C05411() {
        }

        public void onAccountTokenInvalid() {
            MusicLog.m404w(BaiduEngine.TAG, "onAccountTokenInvalid");
        }

        public void onOrdinaryInvalid() {
            MusicLog.m404w(BaiduEngine.TAG, "onOrdinaryInvalid");
        }
    }

    private BaiduEngine() {
    }

    private static synchronized void validate(Context context) {
        synchronized (BaiduEngine.class) {
            if (sEngine == null) {
                initConfig(context);
                SDKEngine.getInstance().init(context, sAppKey, sSecretKey, "music_media_basic,music_media_premium,music_musicdata_basic,music_search_basic", new C05411());
                sEngine = OnlineManagerEngine.getInstance(context);
            }
            refreshToken(context);
        }
    }

    private static void refreshToken(Context context) {
        final OAuthManager manager = OAuthManager.getInstance(context);
        if (manager.validate() < AUTHORITY_TIME_OUT) {
            new BlockingRequest<Integer>(new Handler(context.getMainLooper())) {

                class C05421 implements onAuthorizeFinishListener {
                    C05421() {
                    }

                    public void onAuthorizeFinish(int result) {
                        MusicLog.m402v(BaiduEngine.TAG, "authorize result=" + result);
                        C05432.this.setResult(Integer.valueOf(result));
                    }
                }

                public void run() {
                    manager.authorize(new C05421());
                }
            }.getResult();
        }
    }

    public static OnlineManagerEngine get(Context context) {
        validate(context);
        return sEngine;
    }

    private static void initConfig(Context context) {
        InputStream is = null;
        try {
            JSONObject onlineConfig = MusicEngine.get(context).getOnlineEngine().getConfig();
            sAppId = onlineConfig.getString("app_id");
            sAppKey = onlineConfig.getString(OnlineJsonTag.TAG_APP_KEY);
            sSecretKey = onlineConfig.getString(OnlineJsonTag.TAG_SECRET_KEY);
            MusicLog.m395d(TAG, "config success!");
            MusicLog.m395d(TAG, "appId=" + sAppId);
            MusicLog.m395d(TAG, "appKey=" + sAppKey);
            MusicLog.m395d(TAG, "secretKey=" + sSecretKey);
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
        } catch (Exception e2) {
            MusicLog.m395d(TAG, "config fail!");
            throw new UnsupportedOperationException("Bad configuration: ");
        } catch (Throwable th) {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e3) {
                }
            }
        }
    }
}
