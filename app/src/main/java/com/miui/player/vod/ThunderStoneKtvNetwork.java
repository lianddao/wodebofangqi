package com.miui.player.vod;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.collect.Lists;
import com.google.android.collect.Maps;
import com.miui.player.C0329R;
import com.miui.player.meta.Audio;
import com.miui.player.meta.MetaManager;
import com.miui.player.provider.KtvPlaylistCache;
import com.miui.player.ui.UIHelper;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.ui.model.UserInfo;
import com.miui.player.util.Actions;
import com.miui.player.util.MD5;
import com.xiaomi.music.util.NetworkUtil;
import com.xiaomi.music.util.StreamHelper;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import miui.accounts.ExtraAccountManager;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

public class ThunderStoneKtvNetwork {
    private static final String APPS_SECRET = "8DE395D882214EF9A0245A6F63ADE638";
    private static final String APP_ID = "AEC881E353F342B194F1F0C9B5D1E2D0";
    private static final int BIND_TYPE = 2;
    private static final int CODE_FAIL = -1;
    private static final int CODE_PARAMETER_ERROR = 5;
    private static final int CODE_ROOM_UNAVAILABLE = 7;
    private static final int CODE_SERVER_ERROR = 2;
    private static final int CODE_SIGN_ERROR = 4;
    private static final int CODE_SUCCESS = 1;
    private static final int CODE_TIMEOUT = 3;
    private static final int CODE_UNBAND = 6;
    private static final int CODE_UNKNOWN_ERROR = 0;
    private static final Pattern DEFAULT_MIUI_KTV_PATTERN = Pattern.compile("http://www.miui.com/music/ktv");
    private static final Pattern DEFAULT_THUNDERERP_PATTERN = Pattern.compile("http://.+/qr/.+");
    public static final String JSON_TAG_ALIAS_NICK = "aliasNick";
    public static final String JSON_TAG_DATA = "data";
    public static final String JSON_TAG_LIST = "list";
    public static final String JSON_TAG_MILIAO_ICON = "miliaoIcon";
    public static final String JSON_TAG_MILIAO_NICK = "miliaoNick";
    public static final String JSON_TAG_USER_ID = "userId";
    private static final String KEY_APP_ID = "appid";
    private static final String KEY_BIND_TYPE = "bindtype";
    private static final String KEY_CHECK_CODE = "checkcode";
    private static final String KEY_CODE = "code";
    private static final String KEY_FAIL_DATA = "faildata";
    private static final String KEY_KTV_NAME = "ktvname";
    private static final String KEY_MUSIC_INFO = "musicinfo";
    private static final String KEY_MUSIC_KTV_PATTERN = "miui_ktv_pattern";
    private static final String KEY_MUSIC_NAME = "musicname";
    private static final String KEY_MUSIC_NO = "musicno";
    private static final String KEY_REQUEST_URL = "requesturl";
    private static final String KEY_ROOM_INFO = "roominfo";
    private static final String KEY_ROOM_NAME = "roomname";
    private static final String KEY_SIGN = "sign";
    private static final String KEY_SINGER_NAME = "singername";
    private static final String KEY_THUNDERERP_PATTERN = "thundererp_pattern";
    private static final String KEY_TIME = "time";
    private static final String KEY_USER_ID = "userid";
    private static final String KEY_USER_NAME = "username";
    private static final String KEY_USER_PIC = "userpic";
    private static final String MUSIC_KTV_QR_PATTERN_URL = "http://www.miui.com/music/ktv/qr/pattern";
    private static final String PATH_ROOM_BIND = "/room/bind";
    private static final String PATH_ROOM_UNBIND = "/room/unbind";
    private static final String PATH_SONG_VOD = "/song/vod";
    private static final String QUERY_SEPARATE = "?";
    public static final String TAG = "ThundererpKTVNetwork";
    public static final String URL_ACOUNT_API_BASE_SECURE = "https://api.account.xiaomi.com/pass";
    public static final String URL_USER_INFO_FORMAT = "https://api.account.xiaomi.com/pass/usersCard?ids=%s";
    private static final String USER_NAME = "小米音乐";
    private static String sCheckCode;
    private static boolean sIsBinded = false;
    private static String sKtvName;
    private static Pattern sMiuiKtvPattern;
    private static String sRequestUrl;
    private static String sRoomInfo;
    private static String sRoomName;
    private static ExecutorService sThreadPool = Executors.newScheduledThreadPool(1);
    private static Pattern sThundererpPattern;
    private static String sUserName;
    private static String sUserPic;

    static class C05372 implements Runnable {
        C05372() {
        }

        public void run() {
            ThunderStoneKtvNetwork.doUnBind();
        }
    }

    public static class MusicInfo {
        final String mArtist;
        final long mAudioId;
        final String mMusicNo;
        final Audio mOnlineAudio;
        final String mTitle;

        public MusicInfo(String title, String artist, String musicNo, long audioId, Audio audio) {
            this.mTitle = title;
            this.mArtist = artist;
            this.mMusicNo = musicNo;
            this.mAudioId = audioId;
            this.mOnlineAudio = audio;
        }

        public String getOnlineId() {
            return this.mOnlineAudio != null ? this.mOnlineAudio.mOutline.mId : null;
        }

        public JSONObject toJSONObject() {
            JSONObject js = new JSONObject();
            try {
                js.put(ThunderStoneKtvNetwork.KEY_MUSIC_NAME, this.mTitle);
                js.put(ThunderStoneKtvNetwork.KEY_SINGER_NAME, this.mArtist);
                js.put(ThunderStoneKtvNetwork.KEY_MUSIC_NO, this.mMusicNo);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return js;
        }

        public boolean equals(String title, String artist, String musicNo) {
            return TextUtils.equals(title, this.mTitle) && TextUtils.equals(artist, this.mArtist) && (this.mMusicNo == null || TextUtils.equals(musicNo, this.mMusicNo));
        }
    }

    public static InputStream doHttpGet(String url) {
        try {
            return NetworkUtil.doHttpGet(url);
        } catch (ClientProtocolException e) {
            Log.e(TAG, MetaManager.UNKNOWN_STRING, e);
            return null;
        } catch (URISyntaxException e2) {
            Log.e(TAG, MetaManager.UNKNOWN_STRING, e2);
            return null;
        } catch (IOException e3) {
            Log.e(TAG, MetaManager.UNKNOWN_STRING, e3);
            return null;
        }
    }

    public static String doHttpPost(String url, JSONObject js) {
        try {
            return NetworkUtil.doHttpPost(url, js);
        } catch (IOException e) {
            Log.e(TAG, MetaManager.UNKNOWN_STRING, e);
            return null;
        }
    }

    public static boolean isBinded() {
        return sIsBinded;
    }

    public static void initialize(final String url) {
        if (NetworkUtil.isActive(MusicApplication.getApplication())) {
            UIHelper.toastSafe(C0329R.string.requesting, new Object[0]);
            sThreadPool.execute(new Runnable() {
                public void run() {
                    ThunderStoneKtvNetwork.initializeInternal(url);
                }
            });
            return;
        }
        UIHelper.toastSafe(C0329R.string.network_error, new Object[0]);
    }

    private static void initializeInternal(String url) {
        if (sMiuiKtvPattern == null || sThundererpPattern == null) {
            initPattern();
        }
        int code = 6;
        if (isMiuiKtvPattern(url)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(url));
            intent.setFlags(268435456);
            MusicApplication.getApplication().startActivity(intent);
            return;
        }
        if (isThundereroPattern(url)) {
            InputStream is = doHttpGet(url);
            if (is != null) {
                try {
                    JSONObject js = StreamHelper.toJSONObject(is);
                    code = js.optInt("code", 0);
                    switch (code) {
                        case 1:
                            sRequestUrl = js.optString(KEY_REQUEST_URL, null);
                            sRoomInfo = js.optString(KEY_ROOM_INFO, null);
                            code = doBind();
                            break;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                } catch (Throwable th) {
                    StreamHelper.closeSafe(is);
                }
                StreamHelper.closeSafe(is);
            }
        }
        checkState(code);
    }

    public static void disconnect() {
        exitKtvMode();
        if (NetworkUtil.isActive(MusicApplication.getApplication())) {
            sThreadPool.execute(new C05372());
        }
    }

    private static void exitKtvMode() {
        sIsBinded = false;
        KtvPlaylistCache.removeAllFromVodSuccess();
        Context context = MusicApplication.getApplication();
        Intent connectChangedIntent = new Intent(Actions.ACTION_KTV_CONNECT_CHANGED);
        connectChangedIntent.setPackage(context.getPackageName());
        context.sendBroadcast(connectChangedIntent);
    }

    public static void songVod(Context context, MusicInfo music) {
        if (NetworkUtil.isActive(MusicApplication.getApplication())) {
            List list = Lists.newArrayList();
            list.add(music);
            songVod(context, list);
            return;
        }
        UIHelper.toastSafe(C0329R.string.network_error, new Object[0]);
    }

    public static void songVod(final Context context, final List<MusicInfo> musicList) {
        if (NetworkUtil.isActive(MusicApplication.getApplication())) {
            sThreadPool.execute(new Runnable() {
                public void run() {
                    ThunderStoneKtvNetwork.doSongVod(context, musicList);
                }
            });
        } else {
            UIHelper.toastSafe(C0329R.string.network_error, new Object[0]);
        }
    }

    private static int doBind() {
        int code = -1;
        if (!(sRequestUrl == null || sRoomInfo == null)) {
            Map<String, String> nameValues = Maps.newHashMap();
            long currentTime = getCurrentTime();
            nameValues.put(KEY_APP_ID, APP_ID);
            doGetUserInfo();
            nameValues.put(KEY_USER_NAME, sUserName != null ? sUserName : USER_NAME);
            if (sUserPic != null) {
                nameValues.put(KEY_USER_PIC, sUserPic);
            }
            nameValues.put(KEY_BIND_TYPE, Integer.toString(2));
            nameValues.put(KEY_ROOM_INFO, sRoomInfo);
            nameValues.put(KEY_TIME, Long.toString(currentTime));
            nameValues.put("sign", MD5.MD5_32(APPS_SECRET + sRoomInfo + currentTime));
            InputStream is = doHttpGet(NetworkUtil.concatAsUrl(sRequestUrl + PATH_ROOM_BIND + QUERY_SEPARATE, Collections.unmodifiableMap(nameValues)));
            if (is != null) {
                try {
                    JSONObject js = StreamHelper.toJSONObject(is);
                    code = js.optInt("code", 0);
                    switch (code) {
                        case 1:
                            sCheckCode = js.optString(KEY_CHECK_CODE);
                            sKtvName = js.optString(KEY_KTV_NAME);
                            sRoomName = js.optString(KEY_ROOM_NAME);
                            sIsBinded = true;
                            Context context = MusicApplication.getApplication();
                            Intent connectChangedIntent = new Intent(Actions.ACTION_KTV_CONNECT_CHANGED);
                            connectChangedIntent.setPackage(context.getPackageName());
                            context.sendBroadcast(connectChangedIntent);
                            Intent intent = new Intent(Actions.ACTION_KTV_CONNECTED);
                            intent.setPackage(context.getPackageName());
                            intent.setFlags(268435456);
                            context.startActivity(intent);
                            break;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                } catch (Throwable th) {
                    StreamHelper.closeSafe(is);
                }
                StreamHelper.closeSafe(is);
            }
        }
        return code;
    }

    private static void doUnBind() {
        if (sRequestUrl != null && sRoomInfo != null && sCheckCode != null) {
            Map<String, String> nameValues = Maps.newHashMap();
            long currentTime = getCurrentTime();
            nameValues.put(KEY_APP_ID, APP_ID);
            nameValues.put(KEY_ROOM_INFO, sRoomInfo);
            nameValues.put(KEY_TIME, Long.toString(currentTime));
            nameValues.put("sign", MD5.MD5_32(APPS_SECRET + sCheckCode + sRoomInfo + currentTime));
            StreamHelper.closeSafe(doHttpGet(NetworkUtil.concatAsUrl(sRequestUrl + PATH_ROOM_UNBIND + QUERY_SEPARATE, Collections.unmodifiableMap(nameValues))));
            sRequestUrl = null;
            sRoomInfo = null;
            sCheckCode = null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void doSongVod(Context r37, List<MusicInfo> r38) {
        /*
        r16 = 6;
        r35 = 0;
        r3 = r38.size();
        r0 = new boolean[r3];
        r34 = r0;
        r3 = 0;
        r0 = r34;
        java.util.Arrays.fill(r0, r3);
        r3 = sRequestUrl;
        if (r3 == 0) goto L_0x0053;
    L_0x0016:
        r3 = sRoomInfo;
        if (r3 == 0) goto L_0x0053;
    L_0x001a:
        r3 = sCheckCode;
        if (r3 == 0) goto L_0x0053;
    L_0x001e:
        r29 = new org.json.JSONObject;
        r29.<init>();
        r25 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x004f }
        r25.<init>();	 Catch:{ JSONException -> 0x004f }
        r22 = r38.iterator();	 Catch:{ JSONException -> 0x004f }
    L_0x002c:
        r3 = r22.hasNext();	 Catch:{ JSONException -> 0x004f }
        if (r3 == 0) goto L_0x0095;
    L_0x0032:
        r27 = r22.next();	 Catch:{ JSONException -> 0x004f }
        r27 = (com.miui.player.vod.ThunderStoneKtvNetwork.MusicInfo) r27;	 Catch:{ JSONException -> 0x004f }
        r3 = r27.toJSONObject();	 Catch:{ JSONException -> 0x004f }
        r0 = r25;
        r0.put(r3);	 Catch:{ JSONException -> 0x004f }
        r0 = r27;
        r7 = r0.mAudioId;	 Catch:{ JSONException -> 0x004f }
        r3 = r27.getOnlineId();	 Catch:{ JSONException -> 0x004f }
        r0 = r37;
        com.miui.player.provider.KtvPlaylistCache.addToVoding(r0, r7, r3);	 Catch:{ JSONException -> 0x004f }
        goto L_0x002c;
    L_0x004f:
        r19 = move-exception;
        r19.printStackTrace();
    L_0x0053:
        r23 = new android.content.Intent;
        r3 = "com.miui.player.KTV_SONG_VOD_STATE_CHANGED";
        r0 = r23;
        r0.<init>(r3);
        r3 = r37.getPackageName();
        r0 = r23;
        r0.setPackage(r3);
        r0 = r37;
        r1 = r23;
        r0.sendBroadcast(r1);
        r3 = r38.size();
        r7 = 1;
        if (r3 != r7) goto L_0x0220;
    L_0x0073:
        r3 = 0;
        r3 = r34[r3];
        if (r3 == 0) goto L_0x021b;
    L_0x0078:
        r31 = 2131296556; // 0x7f09012c float:1.8211032E38 double:1.0530004094E-314;
    L_0x007b:
        r3 = 1;
        r7 = new java.lang.Object[r3];
        r8 = 0;
        r3 = 0;
        r0 = r38;
        r3 = r0.get(r3);
        r3 = (com.miui.player.vod.ThunderStoneKtvNetwork.MusicInfo) r3;
        r3 = r3.mTitle;
        r7[r8] = r3;
        r0 = r31;
        com.miui.player.ui.UIHelper.toastSafe(r0, r7);
    L_0x0091:
        checkState(r16);
        return;
    L_0x0095:
        r17 = getCurrentTime();	 Catch:{ JSONException -> 0x004f }
        r3 = "appid";
        r7 = "AEC881E353F342B194F1F0C9B5D1E2D0";
        r0 = r29;
        r0.put(r3, r7);	 Catch:{ JSONException -> 0x004f }
        r3 = "roominfo";
        r7 = sRoomInfo;	 Catch:{ JSONException -> 0x004f }
        r0 = r29;
        r0.put(r3, r7);	 Catch:{ JSONException -> 0x004f }
        r3 = "musicinfo";
        r0 = r29;
        r1 = r25;
        r0.put(r3, r1);	 Catch:{ JSONException -> 0x004f }
        r3 = "time";
        r7 = java.lang.Long.toString(r17);	 Catch:{ JSONException -> 0x004f }
        r0 = r29;
        r0.put(r3, r7);	 Catch:{ JSONException -> 0x004f }
        r3 = "sign";
        r7 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x004f }
        r7.<init>();	 Catch:{ JSONException -> 0x004f }
        r8 = "8DE395D882214EF9A0245A6F63ADE638";
        r7 = r7.append(r8);	 Catch:{ JSONException -> 0x004f }
        r8 = sCheckCode;	 Catch:{ JSONException -> 0x004f }
        r7 = r7.append(r8);	 Catch:{ JSONException -> 0x004f }
        r8 = sRoomInfo;	 Catch:{ JSONException -> 0x004f }
        r7 = r7.append(r8);	 Catch:{ JSONException -> 0x004f }
        r0 = r17;
        r7 = r7.append(r0);	 Catch:{ JSONException -> 0x004f }
        r7 = r7.toString();	 Catch:{ JSONException -> 0x004f }
        r7 = com.miui.player.util.MD5.MD5_32(r7);	 Catch:{ JSONException -> 0x004f }
        r0 = r29;
        r0.put(r3, r7);	 Catch:{ JSONException -> 0x004f }
        r3 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x004f }
        r3.<init>();	 Catch:{ JSONException -> 0x004f }
        r7 = sRequestUrl;	 Catch:{ JSONException -> 0x004f }
        r3 = r3.append(r7);	 Catch:{ JSONException -> 0x004f }
        r7 = "/song/vod";
        r3 = r3.append(r7);	 Catch:{ JSONException -> 0x004f }
        r3 = r3.toString();	 Catch:{ JSONException -> 0x004f }
        r0 = r29;
        r32 = doHttpPost(r3, r0);	 Catch:{ JSONException -> 0x004f }
        if (r32 == 0) goto L_0x011d;
    L_0x0108:
        r26 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x01cc }
        r0 = r26;
        r1 = r32;
        r0.<init>(r1);	 Catch:{ JSONException -> 0x01cc }
        r3 = "code";
        r7 = 0;
        r0 = r26;
        r16 = r0.optInt(r3, r7);	 Catch:{ JSONException -> 0x01cc }
        switch(r16) {
            case 1: goto L_0x016b;
            default: goto L_0x011d;
        };
    L_0x011d:
        r15 = com.google.android.collect.Lists.newArrayList();	 Catch:{ JSONException -> 0x004f }
        r30 = com.google.android.collect.Lists.newArrayList();	 Catch:{ JSONException -> 0x004f }
        r21 = 0;
    L_0x0127:
        r3 = r38.size();	 Catch:{ JSONException -> 0x004f }
        r0 = r21;
        if (r0 >= r3) goto L_0x01df;
    L_0x012f:
        r0 = r38;
        r1 = r21;
        r27 = r0.get(r1);	 Catch:{ JSONException -> 0x004f }
        r27 = (com.miui.player.vod.ThunderStoneKtvNetwork.MusicInfo) r27;	 Catch:{ JSONException -> 0x004f }
        r3 = r34[r21];	 Catch:{ JSONException -> 0x004f }
        if (r3 == 0) goto L_0x0168;
    L_0x013d:
        r35 = r35 + 1;
        r3 = r27.getOnlineId();	 Catch:{ JSONException -> 0x004f }
        if (r3 == 0) goto L_0x01d2;
    L_0x0145:
        r0 = r27;
        r3 = r0.mOnlineAudio;	 Catch:{ JSONException -> 0x004f }
        r0 = r30;
        r0.add(r3);	 Catch:{ JSONException -> 0x004f }
    L_0x014e:
        r0 = r27;
        r7 = r0.mAudioId;	 Catch:{ JSONException -> 0x004f }
        r3 = r27.getOnlineId();	 Catch:{ JSONException -> 0x004f }
        r0 = r37;
        com.miui.player.provider.KtvPlaylistCache.removeFromVoding(r0, r7, r3);	 Catch:{ JSONException -> 0x004f }
        r0 = r27;
        r7 = r0.mAudioId;	 Catch:{ JSONException -> 0x004f }
        r3 = r27.getOnlineId();	 Catch:{ JSONException -> 0x004f }
        r0 = r37;
        com.miui.player.provider.KtvPlaylistCache.addToVodSuccess(r0, r7, r3);	 Catch:{ JSONException -> 0x004f }
    L_0x0168:
        r21 = r21 + 1;
        goto L_0x0127;
    L_0x016b:
        r3 = 1;
        r0 = r34;
        java.util.Arrays.fill(r0, r3);	 Catch:{ JSONException -> 0x01cc }
        r3 = "faildata";
        r0 = r26;
        r25 = r0.getJSONArray(r3);	 Catch:{ JSONException -> 0x01cc }
        r21 = 0;
    L_0x017b:
        r3 = r25.length();	 Catch:{ JSONException -> 0x01cc }
        r0 = r21;
        if (r0 >= r3) goto L_0x011d;
    L_0x0183:
        r0 = r25;
        r1 = r21;
        r20 = r0.getJSONObject(r1);	 Catch:{ JSONException -> 0x01cc }
        r3 = "musicname";
        r0 = r20;
        r36 = r0.optString(r3);	 Catch:{ JSONException -> 0x01cc }
        r3 = "singername";
        r0 = r20;
        r14 = r0.optString(r3);	 Catch:{ JSONException -> 0x01cc }
        r3 = "musicno";
        r0 = r20;
        r28 = r0.optString(r3);	 Catch:{ JSONException -> 0x01cc }
        r24 = 0;
    L_0x01a5:
        r3 = r38.size();	 Catch:{ JSONException -> 0x01cc }
        r0 = r24;
        if (r0 >= r3) goto L_0x01c6;
    L_0x01ad:
        r0 = r38;
        r1 = r21;
        r27 = r0.get(r1);	 Catch:{ JSONException -> 0x01cc }
        r27 = (com.miui.player.vod.ThunderStoneKtvNetwork.MusicInfo) r27;	 Catch:{ JSONException -> 0x01cc }
        r0 = r27;
        r1 = r36;
        r2 = r28;
        r3 = r0.equals(r1, r14, r2);	 Catch:{ JSONException -> 0x01cc }
        if (r3 == 0) goto L_0x01c9;
    L_0x01c3:
        r3 = 0;
        r34[r24] = r3;	 Catch:{ JSONException -> 0x01cc }
    L_0x01c6:
        r21 = r21 + 1;
        goto L_0x017b;
    L_0x01c9:
        r24 = r24 + 1;
        goto L_0x01a5;
    L_0x01cc:
        r19 = move-exception;
        r19.printStackTrace();	 Catch:{ JSONException -> 0x004f }
        goto L_0x011d;
    L_0x01d2:
        r0 = r27;
        r7 = r0.mAudioId;	 Catch:{ JSONException -> 0x004f }
        r3 = java.lang.Long.valueOf(r7);	 Catch:{ JSONException -> 0x004f }
        r15.add(r3);	 Catch:{ JSONException -> 0x004f }
        goto L_0x014e;
    L_0x01df:
        r5 = com.miui.player.provider.KtvPlaylistCache.getPlaylistId(r37);	 Catch:{ JSONException -> 0x004f }
        r3 = r15.size();	 Catch:{ JSONException -> 0x004f }
        r4 = new long[r3];	 Catch:{ JSONException -> 0x004f }
        r21 = 0;
    L_0x01eb:
        r3 = r15.size();	 Catch:{ JSONException -> 0x004f }
        r0 = r21;
        if (r0 >= r3) goto L_0x0204;
    L_0x01f3:
        r0 = r21;
        r3 = r15.get(r0);	 Catch:{ JSONException -> 0x004f }
        r3 = (java.lang.Long) r3;	 Catch:{ JSONException -> 0x004f }
        r7 = r3.longValue();	 Catch:{ JSONException -> 0x004f }
        r4[r21] = r7;	 Catch:{ JSONException -> 0x004f }
        r21 = r21 + 1;
        goto L_0x01eb;
    L_0x0204:
        r7 = 1;
        r8 = 0;
        r3 = r37;
        com.miui.player.provider.PlaylistHelper.addToPlaylist(r3, r4, r5, r7, r8);	 Catch:{ JSONException -> 0x004f }
        r9 = com.miui.player.network.OnlineMusicProxy.getProviderName(r37);	 Catch:{ JSONException -> 0x004f }
        r12 = 0;
        r13 = 1;
        r7 = r37;
        r8 = r30;
        r10 = r5;
        com.miui.player.provider.PlaylistHelper.addOnlineToPlaylist(r7, r8, r9, r10, r12, r13);	 Catch:{ JSONException -> 0x004f }
        goto L_0x0053;
    L_0x021b:
        r31 = 2131296557; // 0x7f09012d float:1.8211034E38 double:1.05300041E-314;
        goto L_0x007b;
    L_0x0220:
        r3 = r37.getResources();
        r7 = 2131689478; // 0x7f0f0006 float:1.9007973E38 double:1.0531945387E-314;
        r8 = 1;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = java.lang.Integer.valueOf(r35);
        r8[r9] = r10;
        r0 = r35;
        r33 = r3.getQuantityString(r7, r0, r8);
        r3 = 2131296556; // 0x7f09012c float:1.8211032E38 double:1.0530004094E-314;
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r7[r8] = r33;
        com.miui.player.ui.UIHelper.toastSafe(r3, r7);
        goto L_0x0091;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.player.vod.ThunderStoneKtvNetwork.doSongVod(android.content.Context, java.util.List):void");
    }

    private static long getCurrentTime() {
        return System.currentTimeMillis() / 1000;
    }

    public static String getKtvName() {
        return sKtvName;
    }

    public static String getRoomName() {
        return sRoomName;
    }

    private static void checkState(int code) {
        switch (code) {
            case -1:
            case 0:
            case 3:
            case 4:
            case 5:
            case 7:
                UIHelper.toastSafe(C0329R.string.request_fail, new Object[0]);
                break;
            case 2:
                UIHelper.toastSafe(C0329R.string.server_error, new Object[0]);
                break;
            case 6:
                UIHelper.toastSafe(C0329R.string.ktv_unbind_message, new Object[0]);
                break;
        }
        if (code != 1) {
            exitKtvMode();
        }
    }

    public static boolean isKtvValid() {
        return MusicApplication.getApplication().getResources().getBoolean(C0329R.bool.enable_ktv_mode);
    }

    private static void doGetUserInfo() {
        if (ExtraAccountManager.getXiaomiAccount(MusicApplication.getApplication()) != null) {
            InputStream is = doHttpGet(String.format(URL_USER_INFO_FORMAT, new Object[]{xiaomiAccount.name}));
            if (is != null) {
                try {
                    JSONObject user = StreamHelper.toJSONObject(is).getJSONObject("data").getJSONArray("list").getJSONObject(0);
                    String id = user.getString(JSON_TAG_USER_ID);
                    if (!TextUtils.isEmpty(id)) {
                        UserInfo info = new UserInfo(id);
                        info.setAliasNick(user.optString(JSON_TAG_ALIAS_NICK, null));
                        info.setMiliaoNick(user.optString(JSON_TAG_MILIAO_NICK, null));
                        info.setMiliaoIconUrl(user.optString(JSON_TAG_MILIAO_ICON, null));
                        sUserName = info.getDisplayName();
                        sUserPic = info.getMiliaoIconUrl150();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                } catch (Throwable th) {
                    StreamHelper.closeSafe(is);
                }
                StreamHelper.closeSafe(is);
            }
        }
    }

    private static void initPattern() {
        Map<String, String> nameValues = Maps.newHashMap();
        nameValues.put(KEY_APP_ID, APP_ID);
        InputStream is = doHttpGet(NetworkUtil.concatAsUrl("http://www.miui.com/music/ktv/qr/pattern?", Collections.unmodifiableMap(nameValues)));
        if (is != null) {
            try {
                JSONObject js = StreamHelper.toJSONObject(is);
                String musicKtvPattern = js.optString(KEY_MUSIC_KTV_PATTERN, null);
                if (musicKtvPattern != null) {
                    sMiuiKtvPattern = Pattern.compile(musicKtvPattern);
                }
                String thundererpPattern = js.optString(KEY_THUNDERERP_PATTERN, null);
                if (thundererpPattern != null) {
                    sThundererpPattern = Pattern.compile(thundererpPattern);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                StreamHelper.closeSafe(is);
            }
            StreamHelper.closeSafe(is);
        }
    }

    private static boolean isMiuiKtvPattern(String url) {
        return urlMatchPattern(url, sMiuiKtvPattern, DEFAULT_MIUI_KTV_PATTERN);
    }

    private static boolean isThundereroPattern(String url) {
        return urlMatchPattern(url, sThundererpPattern, DEFAULT_THUNDERERP_PATTERN);
    }

    private static boolean urlMatchPattern(String url, Pattern serverPattern, Pattern localPattern) {
        return (serverPattern != null && serverPattern.matcher(url).find()) || localPattern.matcher(url).find();
    }
}
