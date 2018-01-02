package com.xiaomi.music.statistics.impl;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.android.collect.Maps;
import com.xiaomi.music.cloud.AccountUtils;
import com.xiaomi.music.statistics.MusicTrackEvent;
import com.xiaomi.music.statistics.StatEngine;
import com.xiaomi.music.util.MusicLog;
import com.xiaomi.music.util.ScheduleExecutor;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

public class StatEngineImpl implements StatEngine {
    static final String PREF_LAST_UPLOAD_ACCOUNT = "StatEngineImpl_last_upload_account";
    static final String PREF_PLAY_DUR = "StatEngineImpl_play_duration";
    public static final String PREF_UPLOAD_PLAY_DUR = "StatEngineImpl_upload_play_duration";
    static final String TAG = "StatEngineImpl";
    private final String mDevice;
    private final String mSubPlatform;

    public StatEngineImpl(Context context, JSONObject config) throws JSONException {
        this.mDevice = config.getString("device");
        this.mSubPlatform = config.getString("subplatform");
    }

    public long uploadPlayDuration(Context context, long durationInSec) {
        MusicLog.m395d(TAG, "uploadPlayDuration, durationInSec=" + durationInSec);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        String lastAccountName = sp.getString(PREF_LAST_UPLOAD_ACCOUNT, null);
        final long lastDuration = sp.getLong(PREF_PLAY_DUR, 0);
        Account account = AccountUtils.getAccount(context);
        final String accountName = account != null ? account.name : null;
        boolean accumulate = TextUtils.equals(accountName, lastAccountName);
        long dur = 0;
        if (!(accumulate || lastAccountName == null)) {
            doUploadPlayDuration(lastAccountName, lastDuration);
        }
        if (accountName != null) {
            Callable<Boolean> call = new Callable<Boolean>() {
                public Boolean call() throws Exception {
                    return Boolean.valueOf(StatEngineImpl.this.doUploadPlayDuration(accountName, lastDuration));
                }
            };
            if (accumulate) {
                if (ScheduleExecutor.executeOnceInPeriod(context, PREF_UPLOAD_PLAY_DUR, ScheduleExecutor.PERIOD_A_DAY, call)) {
                    dur = durationInSec;
                    persistPlayDuration(context, accountName, dur);
                }
            }
            dur = accumulate ? durationInSec + lastDuration : durationInSec;
            persistPlayDuration(context, accountName, dur);
        }
        return dur;
    }

    private void persistPlayDuration(Context context, String accountName, long dur) {
        MusicLog.m395d(TAG, "persistPlayDuration, account name=" + accountName + ", durationInSec=" + dur);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(PREF_LAST_UPLOAD_ACCOUNT, accountName).putLong(PREF_PLAY_DUR, dur).apply();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean doUploadPlayDuration(String r10, long r11) {
        /*
        r9 = this;
        r4 = 1;
        r5 = 0;
        r6 = "StatEngineImpl";
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "doUploadPlayDuration, account name=";
        r7 = r7.append(r8);
        r7 = r7.append(r10);
        r8 = ", durationInSec=";
        r7 = r7.append(r8);
        r7 = r7.append(r11);
        r7 = r7.toString();
        com.xiaomi.music.util.MusicLog.m395d(r6, r7);
        if (r10 != 0) goto L_0x0027;
    L_0x0026:
        return r5;
    L_0x0027:
        r6 = 0;
        r6 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1));
        if (r6 > 0) goto L_0x002f;
    L_0x002d:
        r5 = r4;
        goto L_0x0026;
    L_0x002f:
        r6 = "http://nslog.fm.duokanbox.com/vip/%s";
        r7 = new java.lang.Object[r4];
        r8 = r9.mDevice;
        r7[r5] = r8;
        r3 = java.lang.String.format(r6, r7);
        r1 = com.google.android.collect.Maps.newHashMap();
        r6 = "uid";
        r1.put(r6, r10);
        r6 = "subplatform";
        r7 = r9.mSubPlatform;
        r7 = java.lang.String.valueOf(r7);
        r1.put(r6, r7);
        r6 = "duration";
        r7 = java.lang.String.valueOf(r11);
        r1.put(r6, r7);
        r2 = 0;
        r6 = new java.lang.StringBuilder;	 Catch:{ ClientProtocolException -> 0x007d, URISyntaxException -> 0x0085, IOException -> 0x008d }
        r6.<init>();	 Catch:{ ClientProtocolException -> 0x007d, URISyntaxException -> 0x0085, IOException -> 0x008d }
        r6 = r6.append(r3);	 Catch:{ ClientProtocolException -> 0x007d, URISyntaxException -> 0x0085, IOException -> 0x008d }
        r7 = "?";
        r6 = r6.append(r7);	 Catch:{ ClientProtocolException -> 0x007d, URISyntaxException -> 0x0085, IOException -> 0x008d }
        r6 = r6.toString();	 Catch:{ ClientProtocolException -> 0x007d, URISyntaxException -> 0x0085, IOException -> 0x008d }
        r6 = com.xiaomi.music.util.NetworkUtil.concatAsUrl(r6, r1);	 Catch:{ ClientProtocolException -> 0x007d, URISyntaxException -> 0x0085, IOException -> 0x008d }
        r2 = com.xiaomi.music.util.NetworkUtil.doHttpGet(r6);	 Catch:{ ClientProtocolException -> 0x007d, URISyntaxException -> 0x0085, IOException -> 0x008d }
        if (r2 == 0) goto L_0x007b;
    L_0x0076:
        com.xiaomi.music.util.StreamHelper.closeSafe(r2);
        r5 = r4;
        goto L_0x0026;
    L_0x007b:
        r4 = r5;
        goto L_0x0076;
    L_0x007d:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0095 }
        com.xiaomi.music.util.StreamHelper.closeSafe(r2);
        goto L_0x0026;
    L_0x0085:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0095 }
        com.xiaomi.music.util.StreamHelper.closeSafe(r2);
        goto L_0x0026;
    L_0x008d:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0095 }
        com.xiaomi.music.util.StreamHelper.closeSafe(r2);
        goto L_0x0026;
    L_0x0095:
        r4 = move-exception;
        com.xiaomi.music.util.StreamHelper.closeSafe(r2);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.music.statistics.impl.StatEngineImpl.doUploadPlayDuration(java.lang.String, long):boolean");
    }

    public Map<String, String> getVersionParams(Context context) {
        Map<String, String> result = Maps.newHashMap();
        result.put("device", VersionParamHolder.getDevice());
        result.put(StatEngine.PARAM_SYSTEM_VERSION, VersionParamHolder.getSystemVersion());
        result.put(StatEngine.PARAM_LANGUAGE, VersionParamHolder.getLanguage());
        result.put(StatEngine.PARAM_APK_VERSION, VersionParamHolder.getApkVersion(context));
        result.put(StatEngine.PARAM_SDK_VERSION, VersionParamHolder.getSDKVersion(context));
        result.put(StatEngine.PARAM_ACCOUNT, VersionParamHolder.getAccountName(context));
        return result;
    }

    public String getVersionParamsAsStr(Context context) {
        JSONObject json = new JSONObject();
        for (Entry<String, String> p : getVersionParams(context).entrySet()) {
            String value = (String) p.getValue();
            if (!TextUtils.isEmpty(value)) {
                try {
                    json.put((String) p.getKey(), value);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return json.toString();
    }

    public MusicTrackEvent createTrackEvent(String id) {
        return new MusicTrackEvent(id);
    }

    public void applyTrackEvent(Context context, MusicTrackEvent event) {
        applyTrackEvents(context, Arrays.asList(new MusicTrackEvent[]{event}));
    }

    public void applyTrackEvents(Context context, List<MusicTrackEvent> events) {
        MusicTrackEvent.apply(context, events);
    }
}
