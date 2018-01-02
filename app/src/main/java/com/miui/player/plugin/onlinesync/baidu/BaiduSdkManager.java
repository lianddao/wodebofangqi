package com.miui.player.plugin.onlinesync.baidu;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.baidu.music.SDKEngine;
import com.baidu.music.SDKInterface;
import com.baidu.music.model.Songlist;
import com.baidu.music.model.SonglistList;
import com.baidu.music.oauth.OAuthHelper;
import com.baidu.music.oauth.OAuthInterface.onAuthorizeFinishListener;
import com.baidu.music.oauth.OAuthManager;
import com.baidu.music.onlinedata.OnlineManagerEngine;
import com.miui.player.plugin.onlinesync.SyncObject.PlaylistRecord;
import com.miui.player.plugin.onlinesync.SyncObject.TracksOperation;
import com.miui.player.plugin.onlinesync.TokenManager;
import com.miui.player.plugin.onlinesync.baidu.BaiduSdkInterface.PlaylistDetailResult;
import com.miui.player.plugin.onlinesync.baidu.BaiduSdkInterface.PlaylistListResult;
import com.miui.player.plugin.onlinesync.baidu.BaiduSdkInterface.PlaylistResult;
import com.miui.player.plugin.onlinesync.baidu.BaiduSdkInterface.TracksResult;
import com.miui.player.provider.PlayerStore.BaiduSyncState;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.util.ThreadManager.BlockingRequest;
import com.xiaomi.music.util.MusicLog;
import com.xiaomi.music.util.NetworkUtil;
import java.util.HashMap;
import java.util.List;

public class BaiduSdkManager {
    private static final String CLIENT_ID = "MuVYUgPWGzqWBC1goWapvp5Z";
    private static final String CLIENT_SECRET = "2Ktr9G0D88Nkw1WVFnERyvtnAweGtGs3";
    private static final boolean DEBUG = true;
    public static final int NO_DATA = -800;
    public static final int OK = 50000;
    private static final int PAGE_SIZE = 50;
    private static final String SCOPE = "music_media_basic,music_media_premium,music_musicdata_basic,music_search_basic";
    private static final String TAG = "BaiduSdkManager";
    private static boolean isInitialized = false;

    static class C03942 implements SDKInterface {
        C03942() {
        }

        public void onAccountTokenInvalid() {
            Log.d(BaiduSdkManager.TAG, "onAccountTokenInvalid()");
        }

        public void onOrdinaryInvalid() {
            Log.d(BaiduSdkManager.TAG, "onOrdinaryInvalid()");
        }
    }

    public static int getCloudPlaylistSize(String playlistCloudId) {
        PlaylistDetailResult result = BaiduSdkInterface.getPlaylistDetail(playlistCloudId, 1, 1);
        if (result == null || result.mResultCode != 50000 || result.mSonglist == null) {
            return -1;
        }
        return result.mSonglist.getCount();
    }

    public static PlaylistResult uploadPlaylistRecord(PlaylistRecord record) {
        if (BaiduSyncState.INSERT.equals(record.mSyncState)) {
            return BaiduSdkInterface.addPlaylist(record.mPlaylistName);
        }
        if (BaiduSyncState.DELETE.equals(record.mSyncState)) {
            return BaiduSdkInterface.delPlaylist(record.mPlaylistCloudId);
        }
        if (BaiduSyncState.RENAME.equals(record.mSyncState)) {
            return BaiduSdkInterface.updatePlaylist(record.mPlaylistCloudId, record.mPlaylistName);
        }
        return null;
    }

    public static TracksResult uploadTracksOperation(TracksOperation operator) {
        if (BaiduSyncState.INSERT.equals(operator.mOperation)) {
            return BaiduSdkInterface.addTracksToPlaylist(operator.mPlaylistCloudId, operator.mTrackIds);
        }
        if (BaiduSyncState.DELETE.equals(operator.mOperation)) {
            return BaiduSdkInterface.delTracksInPlaylist(operator.mPlaylistCloudId, operator.mTrackIds);
        }
        return null;
    }

    public static HashMap<String, PlaylistRecord> downloadPlaylistListFromServer() {
        HashMap<String, PlaylistRecord> playlistMap = new HashMap();
        int pageNo = 0;
        List<Songlist> list;
        do {
            pageNo++;
            PlaylistListResult result = BaiduSdkInterface.getPlaylistList(pageNo, 50);
            if (result == null || result.mLists == null) {
                return null;
            }
            SonglistList lists = result.mLists;
            Log.d(TAG, "getPlaylistList(...) SonglistList.getCount()=" + lists.getCount());
            if (lists.isAvailable()) {
                list = lists.getSonglists();
                if (list == null) {
                    return playlistMap;
                }
                for (Songlist songlist : list) {
                    PlaylistRecord record = new PlaylistRecord();
                    record.mPlaylistCloudId = songlist.getSonglistId();
                    record.mPlaylistName = songlist.getTitle();
                    playlistMap.put(record.mPlaylistCloudId, record);
                }
            } else if (lists.getErrorCode() != -800) {
                return null;
            } else {
                return playlistMap;
            }
        } while (list.size() >= 50);
        return playlistMap;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static HashMap<String, com.miui.player.plugin.onlinesync.SyncObject.TrackRecord> downloadTracksFromServer(String r15) {
        /*
        r11 = 0;
        r10 = new java.util.HashMap;
        r10.<init>();
        r6 = 0;
        r7 = 0;
    L_0x0008:
        r6 = r6 + 1;
        r12 = 50;
        r7 = com.miui.player.plugin.onlinesync.baidu.BaiduSdkInterface.getPlaylistDetail(r15, r6, r12);
        if (r7 == 0) goto L_0x001d;
    L_0x0012:
        r12 = r7.mResultCode;
        r13 = 50000; // 0xc350 float:7.0065E-41 double:2.47033E-319;
        if (r12 != r13) goto L_0x001d;
    L_0x0019:
        r12 = r7.mSonglist;
        if (r12 != 0) goto L_0x001f;
    L_0x001d:
        r10 = r11;
    L_0x001e:
        return r10;
    L_0x001f:
        r8 = r7.mSonglist;
        r12 = "BaiduSdkManager";
        r13 = new java.lang.StringBuilder;
        r13.<init>();
        r14 = "getPlaylistDetail(...) Songlist.getCount()=";
        r13 = r13.append(r14);
        r14 = r8.getCount();
        r13 = r13.append(r14);
        r13 = r13.toString();
        android.util.Log.d(r12, r13);
        r12 = r8.isAvailable();
        if (r12 != 0) goto L_0x004d;
    L_0x0043:
        r12 = r8.getErrorCode();
        r13 = -800; // 0xfffffffffffffce0 float:NaN double:NaN;
        if (r12 == r13) goto L_0x001e;
    L_0x004b:
        r10 = r11;
        goto L_0x001e;
    L_0x004d:
        r5 = r8.getSongs();
        if (r5 == 0) goto L_0x001e;
    L_0x0053:
        r3 = r5.iterator();
    L_0x0057:
        r12 = r3.hasNext();
        if (r12 == 0) goto L_0x0008;
    L_0x005d:
        r4 = r3.next();
        r4 = (com.baidu.music.model.Music) r4;
        r9 = new com.miui.player.plugin.onlinesync.SyncObject$TrackRecord;
        r9.<init>();
        r12 = r4.mAlbumTitle;
        r9.mAlbumName = r12;
        r12 = r4.mArtist;
        r9.mArtistName = r12;
        r0 = 0;
        r12 = r4.mFileDuration;	 Catch:{ NumberFormatException -> 0x0093 }
        r12 = java.lang.Integer.valueOf(r12);	 Catch:{ NumberFormatException -> 0x0093 }
        r12 = r12.intValue();	 Catch:{ NumberFormatException -> 0x0093 }
        r0 = (long) r12;
    L_0x007d:
        r9.mDuration = r0;
        r12 = com.miui.player.provider.PlayerStore.ID_PROVIDER_BAIDU_STR;
        r9.mProvider = r12;
        r12 = r4.mTitle;
        r9.mTitle = r12;
        r12 = r4.mId;
        r9.mTrackOnlineId = r12;
        r9.mPlaylistCloudId = r15;
        r12 = r9.mTrackOnlineId;
        r10.put(r12, r9);
        goto L_0x0057;
    L_0x0093:
        r2 = move-exception;
        r12 = "BaiduSdkManager";
        r13 = "get track info error.";
        android.util.Log.e(r12, r13);
        r12 = "BaiduSdkManager";
        r13 = new java.lang.StringBuilder;
        r13.<init>();
        r14 = "album name:";
        r13 = r13.append(r14);
        r14 = r4.mAlbumTitle;
        r13 = r13.append(r14);
        r13 = r13.toString();
        android.util.Log.e(r12, r13);
        r12 = "BaiduSdkManager";
        r13 = new java.lang.StringBuilder;
        r13.<init>();
        r14 = "artist name:";
        r13 = r13.append(r14);
        r14 = r4.mArtist;
        r13 = r13.append(r14);
        r13 = r13.toString();
        android.util.Log.e(r12, r13);
        r12 = "BaiduSdkManager";
        r13 = new java.lang.StringBuilder;
        r13.<init>();
        r14 = "duration:";
        r13 = r13.append(r14);
        r14 = r4.mFileDuration;
        r13 = r13.append(r14);
        r13 = r13.toString();
        android.util.Log.e(r12, r13);
        r12 = "BaiduSdkManager";
        r13 = new java.lang.StringBuilder;
        r13.<init>();
        r14 = "title:";
        r13 = r13.append(r14);
        r14 = r4.mTitle;
        r13 = r13.append(r14);
        r13 = r13.toString();
        android.util.Log.e(r12, r13);
        r12 = "BaiduSdkManager";
        r13 = new java.lang.StringBuilder;
        r13.<init>();
        r14 = "track online id:";
        r13 = r13.append(r14);
        r14 = r4.mId;
        r13 = r13.append(r14);
        r13 = r13.toString();
        android.util.Log.e(r12, r13);
        r12 = "BaiduSdkManager";
        r13 = new java.lang.StringBuilder;
        r13.<init>();
        r14 = "playlist online id:";
        r13 = r13.append(r14);
        r13 = r13.append(r15);
        r13 = r13.toString();
        android.util.Log.e(r12, r13);
        goto L_0x007d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.player.plugin.onlinesync.baidu.BaiduSdkManager.downloadTracksFromServer(java.lang.String):java.util.HashMap<java.lang.String, com.miui.player.plugin.onlinesync.SyncObject$TrackRecord>");
    }

    public static synchronized boolean initSdkEnvironment() {
        boolean z = true;
        synchronized (BaiduSdkManager.class) {
            if (isInitialized) {
                Log.d(TAG, "sdk env is already ok.");
            } else if (NetworkUtil.isNetworkAllow()) {
                isInitialized = TokenManager.requestTokensFromServer();
                if (isInitialized) {
                    initSdkEngine();
                    initOAuthManager();
                    initOAuthHelper();
                } else {
                    Log.d(TAG, "sdk env is not ok.");
                    z = false;
                }
            } else {
                z = false;
            }
        }
        return z;
    }

    public static synchronized void clearSdkEnvironment() {
        synchronized (BaiduSdkManager.class) {
            isInitialized = false;
            TokenManager.clearTokens();
        }
    }

    public static synchronized boolean destorySdkEnvironment() {
        synchronized (BaiduSdkManager.class) {
            if (isInitialized) {
                isInitialized = false;
                OnlineManagerEngine managerEngine = OnlineManagerEngine.getInstance(MusicApplication.getApplication());
                if (managerEngine != null) {
                    managerEngine.releaseEngine();
                }
                SDKEngine sdkEngine = SDKEngine.getInstance();
                if (sdkEngine != null) {
                    sdkEngine.destory();
                }
            }
        }
        return true;
    }

    private static void initOAuthManager() {
        Context context = MusicApplication.getApplication();
        final OAuthManager manager = OAuthManager.getInstance(context);
        if (manager == null) {
            Log.e(TAG, "Error! initSdkEnvironment(): Cannot get instance of OAuthManager.");
        }
        new BlockingRequest<Integer>(new Handler(context.getMainLooper())) {

            class C03921 implements onAuthorizeFinishListener {
                C03921() {
                }

                public void onAuthorizeFinish(int result) {
                    MusicLog.m402v(BaiduSdkManager.TAG, "authorize result=" + result);
                    C03931.this.setResult(Integer.valueOf(result));
                }
            }

            public void run() {
                manager.authorize(new C03921());
            }
        }.getResult();
    }

    private static void initSdkEngine() {
        Context context = MusicApplication.getApplication();
        SDKEngine sdkEngine = SDKEngine.getInstance();
        if (sdkEngine == null) {
            Log.e(TAG, "Error! initSdkEnvironment(): Cannot get instance of SDKEngine.");
        }
        sdkEngine.init(context, "MuVYUgPWGzqWBC1goWapvp5Z", "2Ktr9G0D88Nkw1WVFnERyvtnAweGtGs3", "music_media_basic,music_media_premium,music_musicdata_basic,music_search_basic", new C03942());
    }

    private static void initOAuthHelper() {
        OAuthHelper.saveToken(MusicApplication.getApplication(), "MuVYUgPWGzqWBC1goWapvp5Z", "2Ktr9G0D88Nkw1WVFnERyvtnAweGtGs3", TokenManager.getAccessToken(), TokenManager.getRefreshToken(), "music_media_basic,music_media_premium,music_musicdata_basic,music_search_basic", TokenManager.getExpiresIn());
    }
}
