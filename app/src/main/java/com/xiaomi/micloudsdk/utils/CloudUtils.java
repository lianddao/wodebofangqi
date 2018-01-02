package com.xiaomi.micloudsdk.utils;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.Log;
import com.miui.player.meta.MetaManager;
import com.miui.player.reporter.OnlinePlayStatus;
import com.xiaomi.micloudsdk.request.CloudRequestHelper;
import com.xiaomi.micloudsdk.request.Request;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import miui.net.exception.MiCloudServerException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CloudUtils {
    private static final String ACTION_COM_XIAOMI_ACTION_DATA_IN_TRANSFER = "com.xiaomi.action.DATA_IN_TRANSFER";
    public static final String CODE = "code";
    private static final int CODE_EXCEED_MAX_REDIRECT_COUNT = 10034;
    public static final int CODE_IS_INTERNATIONAL_ACCOUNT = 1;
    public static final int CODE_NOT_INTERNATIONAL_ACCOUNT = 0;
    private static final int CODE_REDIRECT = 308;
    public static final int CODE_UNKOWN_ERROR = 2;
    public static final String DATA = "data";
    private static final String EXTRA_MICLOUD_HOSTS = "extra_micloud_hosts";
    private static final int MAX_REDIRECT_COUNT = 15;
    private static final String PREF_MICLOUD_HOSTS = "pref_micloud_hosts";
    public static final String REDIRECT_URL = "redirectUrl";
    private static final int RESUME_SYNC_INTERVAL = 300000;
    private static final int RESUME_SYNC_INTERVAL_SECOND = 300;
    public static final String RETRY_AFTER = "retryAfter";
    private static final String RETRY_TIME = "retryTime";
    public static final int[] SERVER_RETRY_INTERVALS = new int[]{OnlinePlayStatus.STATUS_DOWNLOAD_END, 5000, 10000, 20000, 20000, 20000, 20000};
    public static final String URL_RELOCATION_BASE = (USE_PREVIEW ? "http://relocationapi.micloud.preview.n.xiaomi.net" : "http://relocationapi.micloud.xiaomi.net");
    private static final String URL_RELOCATION_QUERY = (URL_RELOCATION_BASE + "/mic/relocation/v3/user/%s/record");
    public static final boolean USE_PREVIEW = new File("/data/system/account_preview").exists();
    private static final String XIAOMI_ACCOUNT_TYPE = "com.xiaomi";
    public static final String X_XIAOMI_REDIRECT_COUNT = "X-XIAOMI-REDIRECT-COUNT";
    public static final String X_XIAOMI_SUPPORT_REDIRECT = "X-XIAOMI-SUPPORT-REDIRECT";
    public static Map<String, Object> sHostsCache = new ConcurrentHashMap();
    private static AtomicBoolean sIsUpdateMiCloudHosts = new AtomicBoolean(false);
    private static volatile boolean sNeedUpdateHosts = true;
    private static Object sUpdateMiCloudHostsLock = new Object();
    private static String sUserAgent;

    public static String getUserAgent() {
        if (sUserAgent == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(Build.MODEL);
            sb.append("; MIUI/");
            sb.append(VERSION.INCREMENTAL);
            try {
                if (((Boolean) Class.forName("miui.os.Build").getField("IS_ALPHA_BUILD").get(null)).booleanValue()) {
                    sb.append(' ');
                    sb.append("ALPHA");
                }
            } catch (ClassNotFoundException e) {
                Log.d(CloudRequestHelper.MICLOUD_TAG, "Not in MIUI in getUserAgent");
            } catch (NoSuchFieldException e2) {
                Log.d(CloudRequestHelper.MICLOUD_TAG, "Not in MIUI in getUserAgent");
            } catch (IllegalAccessException e3) {
                Log.d(CloudRequestHelper.MICLOUD_TAG, "Not in MIUI in getUserAgent");
            } catch (IllegalArgumentException e4) {
                Log.d(CloudRequestHelper.MICLOUD_TAG, "Not in MIUI in getUserAgent");
            }
            sUserAgent = sb.toString();
        }
        return sUserAgent;
    }

    public static boolean checkWifiAvailability(Context context) {
        return !((ConnectivityManager) context.getSystemService("connectivity")).isActiveNetworkMetered();
    }

    public static String checkRedirect(String response, int redirectCount) throws MiCloudServerException {
        if (redirectCount >= 15) {
            throw new MiCloudServerException(503, CODE_EXCEED_MAX_REDIRECT_COUNT, 300);
        }
        try {
            JSONObject responseJSON = new JSONObject(response);
            if (responseJSON.getInt("code") == CODE_REDIRECT) {
                if (responseJSON.getJSONObject("data").optBoolean("isPermanent")) {
                    sNeedUpdateHosts = true;
                }
                return responseJSON.getJSONObject("data").getString(REDIRECT_URL);
            } else if (responseJSON.getInt("code") == 503) {
                throw new MiCloudServerException(503, 503, responseJSON.getJSONObject("data").getInt("retryAfter"));
            } else {
                if (responseJSON.getInt("code") == CODE_EXCEED_MAX_REDIRECT_COUNT) {
                    throw new MiCloudServerException(503, CODE_EXCEED_MAX_REDIRECT_COUNT, responseJSON.getJSONObject("data").getInt("retryAfter"));
                }
                return null;
            }
        } catch (JSONException e) {
            Log.e(CloudRequestHelper.MICLOUD_TAG, "JSONException in checkRedirect():" + response, e);
        }
    }

    public static int handle5xx(Context context, MiCloudServerException e) {
        if (e.statusCode / 100 == 5) {
            int retryTime = 300000;
            if (e.statusCode == 503 && e.retryTime > 0) {
                retryTime = e.retryTime;
            }
            Log.w(CloudRequestHelper.MICLOUD_TAG, "Http 5xx error. retryTime: " + retryTime);
            return retryTime;
        }
        Log.e(CloudRequestHelper.MICLOUD_TAG, "Unrecognized server error " + e.statusCode);
        return 0;
    }

    public static void handleSendDataInTransferBroadCast(Context context, MiCloudServerException e) {
        if (e.code == 503 && e.retryTime > 0) {
            Intent intent = new Intent(ACTION_COM_XIAOMI_ACTION_DATA_IN_TRANSFER);
            intent.putExtra(RETRY_TIME, e.retryTime);
            context.sendBroadcast(intent);
        }
    }

    public static int isInternationalAccount(boolean needRefresh) {
        if (needRefresh) {
            sHostsCache.clear();
        }
        if (sHostsCache.isEmpty()) {
            sNeedUpdateHosts = true;
            try {
                updateMiCloudHosts();
                if (sHostsCache.isEmpty()) {
                    return 2;
                }
            } catch (MiCloudServerException e) {
                Log.e(CloudRequestHelper.MICLOUD_TAG, "MiCloudServerException in isInternationalAccount", e);
                return 2;
            }
        }
        Iterator<String> iterator = sHostsCache.keySet().iterator();
        if (!iterator.hasNext()) {
            return 2;
        }
        String key = (String) iterator.next();
        return key.equals(sHostsCache.get(key)) ? 0 : 1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void updateMiCloudHosts() throws miui.net.exception.MiCloudServerException {
        /*
        r16 = 0;
        r12 = sNeedUpdateHosts;
        if (r12 == 0) goto L_0x0068;
    L_0x0006:
        r12 = sIsUpdateMiCloudHosts;	 Catch:{ InterruptedException -> 0x006c }
        r13 = 1;
        r12 = r12.getAndSet(r13);	 Catch:{ InterruptedException -> 0x006c }
        if (r12 == 0) goto L_0x008d;
    L_0x000f:
        r13 = sUpdateMiCloudHostsLock;	 Catch:{ InterruptedException -> 0x006c }
        monitor-enter(r13);	 Catch:{ InterruptedException -> 0x006c }
        r12 = "Micloud";
        r14 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0069 }
        r14.<init>();	 Catch:{ all -> 0x0069 }
        r15 = "Waiting for an existing updateMiCloudHosts to finish ";
        r14 = r14.append(r15);	 Catch:{ all -> 0x0069 }
        r15 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0069 }
        r15 = r15.getName();	 Catch:{ all -> 0x0069 }
        r14 = r14.append(r15);	 Catch:{ all -> 0x0069 }
        r14 = r14.toString();	 Catch:{ all -> 0x0069 }
        android.util.Log.v(r12, r14);	 Catch:{ all -> 0x0069 }
        r12 = sUpdateMiCloudHostsLock;	 Catch:{ all -> 0x0069 }
        r12.wait();	 Catch:{ all -> 0x0069 }
        r12 = "Micloud";
        r14 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0069 }
        r14.<init>();	 Catch:{ all -> 0x0069 }
        r15 = "The existing updateMiCloudHosts finished ";
        r14 = r14.append(r15);	 Catch:{ all -> 0x0069 }
        r15 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0069 }
        r15 = r15.getName();	 Catch:{ all -> 0x0069 }
        r14 = r14.append(r15);	 Catch:{ all -> 0x0069 }
        r14 = r14.toString();	 Catch:{ all -> 0x0069 }
        android.util.Log.v(r12, r14);	 Catch:{ all -> 0x0069 }
        monitor-exit(r13);	 Catch:{ all -> 0x0069 }
    L_0x0058:
        r12 = sIsUpdateMiCloudHosts;
        r0 = r16;
        r12.set(r0);
        r13 = sUpdateMiCloudHostsLock;
        monitor-enter(r13);
        r12 = sUpdateMiCloudHostsLock;	 Catch:{ all -> 0x024f }
        r12.notifyAll();	 Catch:{ all -> 0x024f }
        monitor-exit(r13);	 Catch:{ all -> 0x024f }
    L_0x0068:
        return;
    L_0x0069:
        r12 = move-exception;
        monitor-exit(r13);	 Catch:{ all -> 0x0069 }
        throw r12;	 Catch:{ InterruptedException -> 0x006c }
    L_0x006c:
        r3 = move-exception;
        r12 = "Micloud";
        r13 = "InterruptedException in updateMiCloudHosts";
        android.util.Log.e(r12, r13, r3);	 Catch:{ all -> 0x007b }
        r12 = new miui.net.exception.MiCloudServerException;	 Catch:{ all -> 0x007b }
        r13 = 0;
        r12.<init>(r13);	 Catch:{ all -> 0x007b }
        throw r12;	 Catch:{ all -> 0x007b }
    L_0x007b:
        r12 = move-exception;
        r13 = sIsUpdateMiCloudHosts;
        r0 = r16;
        r13.set(r0);
        r13 = sUpdateMiCloudHostsLock;
        monitor-enter(r13);
        r14 = sUpdateMiCloudHostsLock;	 Catch:{ all -> 0x0252 }
        r14.notifyAll();	 Catch:{ all -> 0x0252 }
        monitor-exit(r13);	 Catch:{ all -> 0x0252 }
        throw r12;
    L_0x008d:
        r12 = "Micloud";
        r13 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x006c }
        r13.<init>();	 Catch:{ InterruptedException -> 0x006c }
        r14 = "updateMiCloudHosts ";
        r13 = r13.append(r14);	 Catch:{ InterruptedException -> 0x006c }
        r14 = java.lang.Thread.currentThread();	 Catch:{ InterruptedException -> 0x006c }
        r14 = r14.getName();	 Catch:{ InterruptedException -> 0x006c }
        r13 = r13.append(r14);	 Catch:{ InterruptedException -> 0x006c }
        r13 = r13.toString();	 Catch:{ InterruptedException -> 0x006c }
        android.util.Log.d(r12, r13);	 Catch:{ InterruptedException -> 0x006c }
        r6 = new java.util.HashMap;	 Catch:{ InterruptedException -> 0x006c }
        r6.<init>();	 Catch:{ InterruptedException -> 0x006c }
        r12 = "miui.os.Build";
        r2 = java.lang.Class.forName(r12);	 Catch:{ ClassNotFoundException -> 0x00e5, NoSuchFieldException -> 0x00f7, IllegalAccessException -> 0x0100, IllegalArgumentException -> 0x0109 }
        r12 = "REGION";
        r7 = r2.getField(r12);	 Catch:{ ClassNotFoundException -> 0x00e5, NoSuchFieldException -> 0x00f7, IllegalAccessException -> 0x0100, IllegalArgumentException -> 0x0109 }
        r12 = 0;
        r12 = r7.get(r12);	 Catch:{ ClassNotFoundException -> 0x00e5, NoSuchFieldException -> 0x00f7, IllegalAccessException -> 0x0100, IllegalArgumentException -> 0x0109 }
        r12 = (java.lang.String) r12;	 Catch:{ ClassNotFoundException -> 0x00e5, NoSuchFieldException -> 0x00f7, IllegalAccessException -> 0x0100, IllegalArgumentException -> 0x0109 }
        r0 = r12;
        r0 = (java.lang.String) r0;	 Catch:{ ClassNotFoundException -> 0x00e5, NoSuchFieldException -> 0x00f7, IllegalAccessException -> 0x0100, IllegalArgumentException -> 0x0109 }
        r11 = r0;
        com.xiaomi.micloudsdk.request.Request.setRegion(r11);	 Catch:{ ClassNotFoundException -> 0x00e5, NoSuchFieldException -> 0x00f7, IllegalAccessException -> 0x0100, IllegalArgumentException -> 0x0109 }
        r12 = "romCountry";
        r6.put(r12, r11);	 Catch:{ ClassNotFoundException -> 0x00e5, NoSuchFieldException -> 0x00f7, IllegalAccessException -> 0x0100, IllegalArgumentException -> 0x0109 }
    L_0x00d1:
        r9 = 0;
        r4 = 0;
        r5 = 0;
        r10 = r9;
    L_0x00d5:
        r12 = java.lang.Thread.currentThread();	 Catch:{ InterruptedException -> 0x006c }
        r12 = r12.isInterrupted();	 Catch:{ InterruptedException -> 0x006c }
        if (r12 == 0) goto L_0x0112;
    L_0x00df:
        r12 = new java.lang.InterruptedException;	 Catch:{ InterruptedException -> 0x006c }
        r12.<init>();	 Catch:{ InterruptedException -> 0x006c }
        throw r12;	 Catch:{ InterruptedException -> 0x006c }
    L_0x00e5:
        r3 = move-exception;
        r12 = "Micloud";
        r13 = "Not in MIUI in updateMiCloudHosts";
        android.util.Log.d(r12, r13);	 Catch:{ InterruptedException -> 0x006c }
        r12 = "romCountry";
        r13 = com.xiaomi.micloudsdk.request.Request.getRegion();	 Catch:{ InterruptedException -> 0x006c }
        r6.put(r12, r13);	 Catch:{ InterruptedException -> 0x006c }
        goto L_0x00d1;
    L_0x00f7:
        r3 = move-exception;
        r12 = "Micloud";
        r13 = "Not in MIUI in updateMiCloudHosts";
        android.util.Log.d(r12, r13);	 Catch:{ InterruptedException -> 0x006c }
        goto L_0x00d1;
    L_0x0100:
        r3 = move-exception;
        r12 = "Micloud";
        r13 = "Not in MIUI in updateMiCloudHosts";
        android.util.Log.d(r12, r13);	 Catch:{ InterruptedException -> 0x006c }
        goto L_0x00d1;
    L_0x0109:
        r3 = move-exception;
        r12 = "Micloud";
        r13 = "Not in MIUI in updateMiCloudHosts";
        android.util.Log.d(r12, r13);	 Catch:{ InterruptedException -> 0x006c }
        goto L_0x00d1;
    L_0x0112:
        r12 = com.xiaomi.micloudsdk.request.Request.getRequestEnv();	 Catch:{ JSONException -> 0x0260, UnsupportedEncodingException -> 0x01cb, IllegalBlockSizeException -> 0x01db, BadPaddingException -> 0x01eb, ClientProtocolException -> 0x01fb, IOException -> 0x020b }
        r1 = r12.getAccountName();	 Catch:{ JSONException -> 0x0260, UnsupportedEncodingException -> 0x01cb, IllegalBlockSizeException -> 0x01db, BadPaddingException -> 0x01eb, ClientProtocolException -> 0x01fb, IOException -> 0x020b }
        r12 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x0260, UnsupportedEncodingException -> 0x01cb, IllegalBlockSizeException -> 0x01db, BadPaddingException -> 0x01eb, ClientProtocolException -> 0x01fb, IOException -> 0x020b }
        if (r12 == 0) goto L_0x0135;
    L_0x0120:
        r12 = sIsUpdateMiCloudHosts;
        r0 = r16;
        r12.set(r0);
        r13 = sUpdateMiCloudHostsLock;
        monitor-enter(r13);
        r12 = sUpdateMiCloudHostsLock;	 Catch:{ all -> 0x0132 }
        r12.notifyAll();	 Catch:{ all -> 0x0132 }
        monitor-exit(r13);	 Catch:{ all -> 0x0132 }
        goto L_0x0068;
    L_0x0132:
        r12 = move-exception;
        monitor-exit(r13);	 Catch:{ all -> 0x0132 }
        throw r12;
    L_0x0135:
        r12 = URL_RELOCATION_QUERY;	 Catch:{ JSONException -> 0x0260, UnsupportedEncodingException -> 0x01cb, IllegalBlockSizeException -> 0x01db, BadPaddingException -> 0x01eb, ClientProtocolException -> 0x01fb, IOException -> 0x020b }
        r13 = 1;
        r13 = new java.lang.Object[r13];	 Catch:{ JSONException -> 0x0260, UnsupportedEncodingException -> 0x01cb, IllegalBlockSizeException -> 0x01db, BadPaddingException -> 0x01eb, ClientProtocolException -> 0x01fb, IOException -> 0x020b }
        r14 = 0;
        r13[r14] = r1;	 Catch:{ JSONException -> 0x0260, UnsupportedEncodingException -> 0x01cb, IllegalBlockSizeException -> 0x01db, BadPaddingException -> 0x01eb, ClientProtocolException -> 0x01fb, IOException -> 0x020b }
        r12 = java.lang.String.format(r12, r13);	 Catch:{ JSONException -> 0x0260, UnsupportedEncodingException -> 0x01cb, IllegalBlockSizeException -> 0x01db, BadPaddingException -> 0x01eb, ClientProtocolException -> 0x01fb, IOException -> 0x020b }
        r8 = com.xiaomi.micloudsdk.request.Request.securePost(r12, r6);	 Catch:{ JSONException -> 0x0260, UnsupportedEncodingException -> 0x01cb, IllegalBlockSizeException -> 0x01db, BadPaddingException -> 0x01eb, ClientProtocolException -> 0x01fb, IOException -> 0x020b }
        r12 = "Micloud";
        r13 = 3;
        r12 = android.util.Log.isLoggable(r12, r13);	 Catch:{ JSONException -> 0x0260, UnsupportedEncodingException -> 0x01cb, IllegalBlockSizeException -> 0x01db, BadPaddingException -> 0x01eb, ClientProtocolException -> 0x01fb, IOException -> 0x020b }
        if (r12 == 0) goto L_0x0166;
    L_0x014e:
        r12 = "Micloud";
        r13 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0260, UnsupportedEncodingException -> 0x01cb, IllegalBlockSizeException -> 0x01db, BadPaddingException -> 0x01eb, ClientProtocolException -> 0x01fb, IOException -> 0x020b }
        r13.<init>();	 Catch:{ JSONException -> 0x0260, UnsupportedEncodingException -> 0x01cb, IllegalBlockSizeException -> 0x01db, BadPaddingException -> 0x01eb, ClientProtocolException -> 0x01fb, IOException -> 0x020b }
        r14 = "updateMiCloudHosts response: ";
        r13 = r13.append(r14);	 Catch:{ JSONException -> 0x0260, UnsupportedEncodingException -> 0x01cb, IllegalBlockSizeException -> 0x01db, BadPaddingException -> 0x01eb, ClientProtocolException -> 0x01fb, IOException -> 0x020b }
        r13 = r13.append(r8);	 Catch:{ JSONException -> 0x0260, UnsupportedEncodingException -> 0x01cb, IllegalBlockSizeException -> 0x01db, BadPaddingException -> 0x01eb, ClientProtocolException -> 0x01fb, IOException -> 0x020b }
        r13 = r13.toString();	 Catch:{ JSONException -> 0x0260, UnsupportedEncodingException -> 0x01cb, IllegalBlockSizeException -> 0x01db, BadPaddingException -> 0x01eb, ClientProtocolException -> 0x01fb, IOException -> 0x020b }
        android.util.Log.d(r12, r13);	 Catch:{ JSONException -> 0x0260, UnsupportedEncodingException -> 0x01cb, IllegalBlockSizeException -> 0x01db, BadPaddingException -> 0x01eb, ClientProtocolException -> 0x01fb, IOException -> 0x020b }
    L_0x0166:
        r9 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0260, UnsupportedEncodingException -> 0x01cb, IllegalBlockSizeException -> 0x01db, BadPaddingException -> 0x01eb, ClientProtocolException -> 0x01fb, IOException -> 0x020b }
        r9.<init>(r8);	 Catch:{ JSONException -> 0x0260, UnsupportedEncodingException -> 0x01cb, IllegalBlockSizeException -> 0x01db, BadPaddingException -> 0x01eb, ClientProtocolException -> 0x01fb, IOException -> 0x020b }
        r12 = "code";
        r12 = r9.getInt(r12);	 Catch:{ JSONException -> 0x01bc, UnsupportedEncodingException -> 0x025d, IllegalBlockSizeException -> 0x025b, BadPaddingException -> 0x0259, ClientProtocolException -> 0x0257, IOException -> 0x0255 }
        if (r12 != 0) goto L_0x0214;
    L_0x0173:
        r12 = "data";
        r12 = r9.getJSONObject(r12);	 Catch:{ JSONException -> 0x01bc, UnsupportedEncodingException -> 0x025d, IllegalBlockSizeException -> 0x025b, BadPaddingException -> 0x0259, ClientProtocolException -> 0x0257, IOException -> 0x0255 }
        r13 = "hostList";
        r4 = r12.getJSONObject(r13);	 Catch:{ JSONException -> 0x01bc, UnsupportedEncodingException -> 0x025d, IllegalBlockSizeException -> 0x025b, BadPaddingException -> 0x0259, ClientProtocolException -> 0x0257, IOException -> 0x0255 }
        if (r4 == 0) goto L_0x0058;
    L_0x0181:
        r12 = "Micloud";
        r13 = 3;
        r12 = android.util.Log.isLoggable(r12, r13);	 Catch:{ JSONException -> 0x01bc, UnsupportedEncodingException -> 0x025d, IllegalBlockSizeException -> 0x025b, BadPaddingException -> 0x0259, ClientProtocolException -> 0x0257, IOException -> 0x0255 }
        if (r12 == 0) goto L_0x01aa;
    L_0x018a:
        r12 = "Micloud";
        r13 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x01bc, UnsupportedEncodingException -> 0x025d, IllegalBlockSizeException -> 0x025b, BadPaddingException -> 0x0259, ClientProtocolException -> 0x0257, IOException -> 0x0255 }
        r13.<init>();	 Catch:{ JSONException -> 0x01bc, UnsupportedEncodingException -> 0x025d, IllegalBlockSizeException -> 0x025b, BadPaddingException -> 0x0259, ClientProtocolException -> 0x0257, IOException -> 0x0255 }
        r14 = "getHostList set sNeedUpdateHosts to false ";
        r13 = r13.append(r14);	 Catch:{ JSONException -> 0x01bc, UnsupportedEncodingException -> 0x025d, IllegalBlockSizeException -> 0x025b, BadPaddingException -> 0x0259, ClientProtocolException -> 0x0257, IOException -> 0x0255 }
        r14 = java.lang.Thread.currentThread();	 Catch:{ JSONException -> 0x01bc, UnsupportedEncodingException -> 0x025d, IllegalBlockSizeException -> 0x025b, BadPaddingException -> 0x0259, ClientProtocolException -> 0x0257, IOException -> 0x0255 }
        r14 = r14.getName();	 Catch:{ JSONException -> 0x01bc, UnsupportedEncodingException -> 0x025d, IllegalBlockSizeException -> 0x025b, BadPaddingException -> 0x0259, ClientProtocolException -> 0x0257, IOException -> 0x0255 }
        r13 = r13.append(r14);	 Catch:{ JSONException -> 0x01bc, UnsupportedEncodingException -> 0x025d, IllegalBlockSizeException -> 0x025b, BadPaddingException -> 0x0259, ClientProtocolException -> 0x0257, IOException -> 0x0255 }
        r13 = r13.toString();	 Catch:{ JSONException -> 0x01bc, UnsupportedEncodingException -> 0x025d, IllegalBlockSizeException -> 0x025b, BadPaddingException -> 0x0259, ClientProtocolException -> 0x0257, IOException -> 0x0255 }
        android.util.Log.d(r12, r13);	 Catch:{ JSONException -> 0x01bc, UnsupportedEncodingException -> 0x025d, IllegalBlockSizeException -> 0x025b, BadPaddingException -> 0x0259, ClientProtocolException -> 0x0257, IOException -> 0x0255 }
    L_0x01aa:
        r12 = r4.toString();	 Catch:{ JSONException -> 0x01bc, UnsupportedEncodingException -> 0x025d, IllegalBlockSizeException -> 0x025b, BadPaddingException -> 0x0259, ClientProtocolException -> 0x0257, IOException -> 0x0255 }
        setHostList(r12);	 Catch:{ JSONException -> 0x01bc, UnsupportedEncodingException -> 0x025d, IllegalBlockSizeException -> 0x025b, BadPaddingException -> 0x0259, ClientProtocolException -> 0x0257, IOException -> 0x0255 }
        r12 = jsonToMap(r4);	 Catch:{ JSONException -> 0x01bc, UnsupportedEncodingException -> 0x025d, IllegalBlockSizeException -> 0x025b, BadPaddingException -> 0x0259, ClientProtocolException -> 0x0257, IOException -> 0x0255 }
        sHostsCache = r12;	 Catch:{ JSONException -> 0x01bc, UnsupportedEncodingException -> 0x025d, IllegalBlockSizeException -> 0x025b, BadPaddingException -> 0x0259, ClientProtocolException -> 0x0257, IOException -> 0x0255 }
        r12 = 0;
        sNeedUpdateHosts = r12;	 Catch:{ JSONException -> 0x01bc, UnsupportedEncodingException -> 0x025d, IllegalBlockSizeException -> 0x025b, BadPaddingException -> 0x0259, ClientProtocolException -> 0x0257, IOException -> 0x0255 }
        goto L_0x0058;
    L_0x01bc:
        r3 = move-exception;
    L_0x01bd:
        r12 = "Micloud";
        r13 = "JSONException in updateMiCloudHosts";
        android.util.Log.e(r12, r13, r3);	 Catch:{ InterruptedException -> 0x006c }
        r12 = new miui.net.exception.MiCloudServerException;	 Catch:{ InterruptedException -> 0x006c }
        r13 = 0;
        r12.<init>(r13);	 Catch:{ InterruptedException -> 0x006c }
        throw r12;	 Catch:{ InterruptedException -> 0x006c }
    L_0x01cb:
        r3 = move-exception;
        r9 = r10;
    L_0x01cd:
        r12 = "Micloud";
        r13 = "UnsupportedEncodingException in updateMiCloudHosts";
        android.util.Log.e(r12, r13, r3);	 Catch:{ InterruptedException -> 0x006c }
        r12 = new miui.net.exception.MiCloudServerException;	 Catch:{ InterruptedException -> 0x006c }
        r13 = 0;
        r12.<init>(r13);	 Catch:{ InterruptedException -> 0x006c }
        throw r12;	 Catch:{ InterruptedException -> 0x006c }
    L_0x01db:
        r3 = move-exception;
        r9 = r10;
    L_0x01dd:
        r12 = "Micloud";
        r13 = "IllegalBlockSizeException in updateMiCloudHosts";
        android.util.Log.e(r12, r13, r3);	 Catch:{ InterruptedException -> 0x006c }
        r12 = new miui.net.exception.MiCloudServerException;	 Catch:{ InterruptedException -> 0x006c }
        r13 = 0;
        r12.<init>(r13);	 Catch:{ InterruptedException -> 0x006c }
        throw r12;	 Catch:{ InterruptedException -> 0x006c }
    L_0x01eb:
        r3 = move-exception;
        r9 = r10;
    L_0x01ed:
        r12 = "Micloud";
        r13 = "BadPaddingException in updateMiCloudHosts";
        android.util.Log.e(r12, r13, r3);	 Catch:{ InterruptedException -> 0x006c }
        r12 = new miui.net.exception.MiCloudServerException;	 Catch:{ InterruptedException -> 0x006c }
        r13 = 0;
        r12.<init>(r13);	 Catch:{ InterruptedException -> 0x006c }
        throw r12;	 Catch:{ InterruptedException -> 0x006c }
    L_0x01fb:
        r3 = move-exception;
        r9 = r10;
    L_0x01fd:
        r12 = "Micloud";
        r13 = "ClientProtocolException in updateMiCloudHosts";
        android.util.Log.e(r12, r13, r3);	 Catch:{ InterruptedException -> 0x006c }
        r12 = new miui.net.exception.MiCloudServerException;	 Catch:{ InterruptedException -> 0x006c }
        r13 = 0;
        r12.<init>(r13);	 Catch:{ InterruptedException -> 0x006c }
        throw r12;	 Catch:{ InterruptedException -> 0x006c }
    L_0x020b:
        r3 = move-exception;
        r9 = r10;
    L_0x020d:
        r12 = "Micloud";
        r13 = "IOException in updateMiCloudHosts";
        android.util.Log.e(r12, r13, r3);	 Catch:{ InterruptedException -> 0x006c }
    L_0x0214:
        r12 = SERVER_RETRY_INTERVALS;	 Catch:{ InterruptedException -> 0x006c }
        r12 = r12.length;	 Catch:{ InterruptedException -> 0x006c }
        if (r5 >= r12) goto L_0x0248;
    L_0x0219:
        r12 = "Micloud";
        r13 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x006c }
        r13.<init>();	 Catch:{ InterruptedException -> 0x006c }
        r14 = "Wait ";
        r13 = r13.append(r14);	 Catch:{ InterruptedException -> 0x006c }
        r14 = SERVER_RETRY_INTERVALS;	 Catch:{ InterruptedException -> 0x006c }
        r14 = r14[r5];	 Catch:{ InterruptedException -> 0x006c }
        r13 = r13.append(r14);	 Catch:{ InterruptedException -> 0x006c }
        r14 = " ms for retry";
        r13 = r13.append(r14);	 Catch:{ InterruptedException -> 0x006c }
        r13 = r13.toString();	 Catch:{ InterruptedException -> 0x006c }
        android.util.Log.e(r12, r13);	 Catch:{ InterruptedException -> 0x006c }
        r12 = SERVER_RETRY_INTERVALS;	 Catch:{ InterruptedException -> 0x006c }
        r12 = r12[r5];	 Catch:{ InterruptedException -> 0x006c }
        r12 = (long) r12;	 Catch:{ InterruptedException -> 0x006c }
        java.lang.Thread.sleep(r12);	 Catch:{ InterruptedException -> 0x006c }
        r5 = r5 + 1;
        r10 = r9;
        goto L_0x00d5;
    L_0x0248:
        r12 = new miui.net.exception.MiCloudServerException;	 Catch:{ InterruptedException -> 0x006c }
        r13 = 0;
        r12.<init>(r13);	 Catch:{ InterruptedException -> 0x006c }
        throw r12;	 Catch:{ InterruptedException -> 0x006c }
    L_0x024f:
        r12 = move-exception;
        monitor-exit(r13);	 Catch:{ all -> 0x024f }
        throw r12;
    L_0x0252:
        r12 = move-exception;
        monitor-exit(r13);	 Catch:{ all -> 0x0252 }
        throw r12;
    L_0x0255:
        r3 = move-exception;
        goto L_0x020d;
    L_0x0257:
        r3 = move-exception;
        goto L_0x01fd;
    L_0x0259:
        r3 = move-exception;
        goto L_0x01ed;
    L_0x025b:
        r3 = move-exception;
        goto L_0x01dd;
    L_0x025d:
        r3 = move-exception;
        goto L_0x01cd;
    L_0x0260:
        r3 = move-exception;
        r9 = r10;
        goto L_0x01bd;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.micloudsdk.utils.CloudUtils.updateMiCloudHosts():void");
    }

    public static String updateRequestHost(String url) throws MiCloudServerException {
        updateMiCloudHosts();
        try {
            URL originalURL = new URL(url);
            String host = originalURL.getHost();
            String newHost = getHost(host);
            if (!(TextUtils.isEmpty(newHost) || host.equals(newHost))) {
                url = new URL(originalURL.getProtocol(), newHost, originalURL.getFile()).toString();
            }
        } catch (MalformedURLException e) {
            Log.e(CloudRequestHelper.MICLOUD_TAG, "MalformedURLException in updateHost", e);
        }
        return url;
    }

    private static String getHost(String hostKey) {
        JSONException e;
        if (Log.isLoggable(CloudRequestHelper.MICLOUD_TAG, 3)) {
            Log.d(CloudRequestHelper.MICLOUD_TAG, "Enter getHost key=" + hostKey);
        }
        String hostValueObj = sHostsCache.get(hostKey);
        String hostValue = null;
        if (hostValueObj != null && (hostValueObj instanceof String)) {
            hostValue = hostValueObj;
        }
        if (TextUtils.isEmpty(hostValue)) {
            String hosts = getHostList();
            if (!TextUtils.isEmpty(hosts)) {
                try {
                    JSONObject hostlist = new JSONObject(hosts);
                    try {
                        sHostsCache = jsonToMap(hostlist);
                        Object hostValueObj2 = sHostsCache.get(hostKey);
                        if (hostValueObj2 != null && (hostValueObj2 instanceof String)) {
                            hostValue = (String) hostValueObj2;
                        }
                        if (Log.isLoggable(CloudRequestHelper.MICLOUD_TAG, 3)) {
                            Log.d(CloudRequestHelper.MICLOUD_TAG, "find host in SystemSettings/sp return host = " + hostValue);
                        }
                        return hostValue;
                    } catch (JSONException e2) {
                        e = e2;
                        JSONObject jSONObject = hostlist;
                        Log.e(CloudRequestHelper.MICLOUD_TAG, "JSONException in getHost, return null", e);
                        return null;
                    }
                } catch (JSONException e3) {
                    e = e3;
                    Log.e(CloudRequestHelper.MICLOUD_TAG, "JSONException in getHost, return null", e);
                    return null;
                }
            } else if (!Log.isLoggable(CloudRequestHelper.MICLOUD_TAG, 3)) {
                return null;
            } else {
                Log.d(CloudRequestHelper.MICLOUD_TAG, "Hosts in SystemSettings/sp = null, return null");
                return null;
            }
        }
        if (Log.isLoggable(CloudRequestHelper.MICLOUD_TAG, 3)) {
            Log.d(CloudRequestHelper.MICLOUD_TAG, "Hit host cache directly return host = " + hostValue);
        }
        return hostValue;
    }

    private static String getHostList() {
        if (TextUtils.isEmpty(Request.getRegion())) {
            if (Log.isLoggable(CloudRequestHelper.MICLOUD_TAG, 3)) {
                Log.d(CloudRequestHelper.MICLOUD_TAG, "getRegion null, get from sp");
            }
            return PreferenceManager.getDefaultSharedPreferences(Request.getContext()).getString(PREF_MICLOUD_HOSTS, MetaManager.UNKNOWN_STRING);
        }
        if (Log.isLoggable(CloudRequestHelper.MICLOUD_TAG, 3)) {
            Log.d(CloudRequestHelper.MICLOUD_TAG, "getRegion not null, get from settings: " + Request.getRegion());
        }
        return System.getString(Request.getContext().getContentResolver(), EXTRA_MICLOUD_HOSTS);
    }

    private static void setHostList(String hosts) {
        if (TextUtils.isEmpty(Request.getRegion())) {
            if (Log.isLoggable(CloudRequestHelper.MICLOUD_TAG, 3)) {
                Log.d(CloudRequestHelper.MICLOUD_TAG, "getRegion null, set to sp");
            }
            PreferenceManager.getDefaultSharedPreferences(Request.getContext()).edit().putString(PREF_MICLOUD_HOSTS, hosts).commit();
            return;
        }
        if (Log.isLoggable(CloudRequestHelper.MICLOUD_TAG, 3)) {
            Log.d(CloudRequestHelper.MICLOUD_TAG, "getRegion not null, set to settings: " + Request.getRegion());
        }
        System.putString(Request.getContext().getContentResolver(), EXTRA_MICLOUD_HOSTS, hosts);
    }

    public static Account getXiaomiAccount() {
        Account[] accounts = AccountManager.get(Request.getContext()).getAccountsByType(XIAOMI_ACCOUNT_TYPE);
        if (accounts.length > 0) {
            return accounts[0];
        }
        return null;
    }

    private static Map<String, Object> jsonToMap(JSONObject jsonObj) {
        if (jsonObj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap();
        Iterator iter = jsonObj.keys();
        while (iter.hasNext()) {
            String key = (String) iter.next();
            map.put(key, convertObj(jsonObj.opt(key)));
        }
        return map;
    }

    private static Object convertObj(Object obj) {
        if (obj instanceof JSONObject) {
            return jsonToMap((JSONObject) obj);
        }
        if (!(obj instanceof JSONArray)) {
            return obj == JSONObject.NULL ? null : obj;
        } else {
            JSONArray array = (JSONArray) obj;
            int size = array.length();
            Object list = new ArrayList();
            for (int i = 0; i < size; i++) {
                list.add(convertObj(array.opt(i)));
            }
            return list;
        }
    }
}
