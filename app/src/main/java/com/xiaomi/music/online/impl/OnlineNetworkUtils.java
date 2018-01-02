package com.xiaomi.music.online.impl;

import com.miui.player.meta.MetaManager;
import com.xiaomi.music.util.MusicLog;
import com.xiaomi.music.util.NetworkUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import org.apache.http.client.ClientProtocolException;

public class OnlineNetworkUtils {
    private static final String TAG = "OnlineNetworkUtils";

    public static InputStream requestRaw(String url) {
        try {
            return NetworkUtil.doHttpGet(url);
        } catch (ClientProtocolException e) {
            MusicLog.m398e(TAG, MetaManager.UNKNOWN_STRING, e);
            return null;
        } catch (URISyntaxException e2) {
            MusicLog.m398e(TAG, MetaManager.UNKNOWN_STRING, e2);
            return null;
        } catch (IOException e3) {
            MusicLog.m398e(TAG, MetaManager.UNKNOWN_STRING, e3);
            return null;
        } catch (AssertionError e4) {
            MusicLog.m398e(TAG, MetaManager.UNKNOWN_STRING, e4);
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> com.xiaomi.music.Result<T> request(android.content.Context r9, String r10, java.util.Map<String, String> r11, com.xiaomi.music.parser.Parser<T, org.json.JSONObject> r12) {
        /*
        r4 = com.google.android.collect.Lists.newArrayList();
        r6 = com.xiaomi.music.online.impl.OnlineConstants.LENGTH_URL_DUOKAN_HOST;
        r6 = r10.substring(r6);
        r4.add(r6);
        r6 = com.xiaomi.music.MusicEngine.get(r9);
        r6 = r6.getStatEngine();
        r2 = r6.getVersionParamsAsStr(r9);
        r6 = android.text.TextUtils.isEmpty(r2);
        if (r6 != 0) goto L_0x0042;
    L_0x001f:
        r6 = "OnlineNetworkUtils";
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "Stat info=";
        r7 = r7.append(r8);
        r7 = r7.append(r2);
        r7 = r7.toString();
        com.xiaomi.music.util.MusicLog.m395d(r6, r7);
        if (r11 != 0) goto L_0x003d;
    L_0x0039:
        r11 = com.google.android.collect.Maps.newHashMap();
    L_0x003d:
        r6 = "version_info";
        r11.put(r6, r2);
    L_0x0042:
        if (r11 == 0) goto L_0x0073;
    L_0x0044:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r6 = r6.append(r10);
        r7 = "?";
        r6 = r6.append(r7);
        r6 = r6.toString();
        r10 = com.xiaomi.music.util.NetworkUtil.concatAsUrl(r6, r11);
        r6 = r11.values();
        r1 = r6.iterator();
    L_0x0063:
        r6 = r1.hasNext();
        if (r6 == 0) goto L_0x0073;
    L_0x0069:
        r5 = r1.next();
        r5 = (java.lang.String) r5;
        r4.add(r5);
        goto L_0x0063;
    L_0x0073:
        if (r11 == 0) goto L_0x007b;
    L_0x0075:
        r6 = r11.isEmpty();
        if (r6 == 0) goto L_0x0092;
    L_0x007b:
        r6 = 1;
    L_0x007c:
        r10 = com.xiaomi.music.util.URLHelper.getUrl(r10, r4, r6);
        r3 = requestRaw(r10);
        if (r3 == 0) goto L_0x00a8;
    L_0x0086:
        r6 = com.xiaomi.music.util.StreamHelper.toJSONObject(r3);	 Catch:{ NumberFormatException -> 0x009d, JSONException -> 0x00b7, IOException -> 0x00cc }
        r6 = com.xiaomi.music.online.impl.OnlineParsers.parse(r6, r12);	 Catch:{ NumberFormatException -> 0x009d, JSONException -> 0x00b7, IOException -> 0x00cc }
        r3.close();	 Catch:{ IOException -> 0x0094 }
    L_0x0091:
        return r6;
    L_0x0092:
        r6 = 0;
        goto L_0x007c;
    L_0x0094:
        r0 = move-exception;
        r7 = "OnlineNetworkUtils";
        r8 = "";
        com.xiaomi.music.util.MusicLog.m398e(r7, r8, r0);
        goto L_0x0091;
    L_0x009d:
        r0 = move-exception;
        r6 = "OnlineNetworkUtils";
        r7 = "";
        com.xiaomi.music.util.MusicLog.m398e(r6, r7, r0);	 Catch:{ all -> 0x00e1 }
        r3.close();	 Catch:{ IOException -> 0x00ae }
    L_0x00a8:
        r6 = -1;
        r6 = com.xiaomi.music.Result.create(r6);
        goto L_0x0091;
    L_0x00ae:
        r0 = move-exception;
        r6 = "OnlineNetworkUtils";
        r7 = "";
        com.xiaomi.music.util.MusicLog.m398e(r6, r7, r0);
        goto L_0x00a8;
    L_0x00b7:
        r0 = move-exception;
        r6 = "OnlineNetworkUtils";
        r7 = "";
        com.xiaomi.music.util.MusicLog.m398e(r6, r7, r0);	 Catch:{ all -> 0x00e1 }
        r3.close();	 Catch:{ IOException -> 0x00c3 }
        goto L_0x00a8;
    L_0x00c3:
        r0 = move-exception;
        r6 = "OnlineNetworkUtils";
        r7 = "";
        com.xiaomi.music.util.MusicLog.m398e(r6, r7, r0);
        goto L_0x00a8;
    L_0x00cc:
        r0 = move-exception;
        r6 = "OnlineNetworkUtils";
        r7 = "";
        com.xiaomi.music.util.MusicLog.m398e(r6, r7, r0);	 Catch:{ all -> 0x00e1 }
        r3.close();	 Catch:{ IOException -> 0x00d8 }
        goto L_0x00a8;
    L_0x00d8:
        r0 = move-exception;
        r6 = "OnlineNetworkUtils";
        r7 = "";
        com.xiaomi.music.util.MusicLog.m398e(r6, r7, r0);
        goto L_0x00a8;
    L_0x00e1:
        r6 = move-exception;
        r3.close();	 Catch:{ IOException -> 0x00e6 }
    L_0x00e5:
        throw r6;
    L_0x00e6:
        r0 = move-exception;
        r7 = "OnlineNetworkUtils";
        r8 = "";
        com.xiaomi.music.util.MusicLog.m398e(r7, r8, r0);
        goto L_0x00e5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.music.online.impl.OnlineNetworkUtils.request(android.content.Context, java.lang.String, java.util.Map, com.xiaomi.music.parser.Parser):com.xiaomi.music.Result<T>");
    }
}
