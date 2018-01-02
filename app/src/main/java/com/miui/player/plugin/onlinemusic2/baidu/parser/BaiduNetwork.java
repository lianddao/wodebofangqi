package com.miui.player.plugin.onlinemusic2.baidu.parser;

import android.util.Log;
import com.baidu.music.log.LogHelper;
import com.miui.player.meta.MetaManager;
import com.miui.player.plugin.base.PlugInSharedValues;
import com.miui.player.plugin.onlinemusic2.baidu.BaiduConstants;
import com.xiaomi.music.util.NetworkUtil;
import com.xiaomi.music.util.StreamHelper;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

public class BaiduNetwork {
    static final String TAG = BaiduNetwork.class.getName();

    public static <T> T request(String r10, Map<String, String> r11, com.miui.player.plugin.base.Parser<T, JSONObject> r12, com.miui.player.plugin.base.RequestListener<T> r13) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x001b in list [B:17:0x0060]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        if (r11 != 0) goto L_0x0006;
    L_0x0002:
        r11 = com.google.android.collect.Maps.newHashMap();
    L_0x0006:
        r3 = com.miui.player.plugin.base.Parsers.createParserForString(r12);
        r8 = java.util.Collections.unmodifiableMap(r11);
        r1 = com.xiaomi.music.util.NetworkUtil.concatAsUrl(r10, r8);
        if (r13 == 0) goto L_0x001c;
    L_0x0014:
        r8 = r13.onPrepared(r1, r3);
        if (r8 != 0) goto L_0x001c;
    L_0x001a:
        r4 = 0;
    L_0x001b:
        return r4;
    L_0x001c:
        r6 = 0;
        r4 = 0;
        r7 = 0;
        r8 = "session_key";	 Catch:{ all -> 0x0066 }
        r9 = getSessionKey();	 Catch:{ all -> 0x0066 }
        r11.put(r8, r9);	 Catch:{ all -> 0x0066 }
        r8 = "timestamp";	 Catch:{ all -> 0x0066 }
        r9 = "yyyy-MM-dd hh:mm:ss";	 Catch:{ all -> 0x0066 }
        r9 = com.miui.player.util.DateTimeHelper.getCurrentString(r9);	 Catch:{ all -> 0x0066 }
        r11.put(r8, r9);	 Catch:{ all -> 0x0066 }
        r8 = "all_resource";	 Catch:{ all -> 0x0066 }
        r9 = "1";	 Catch:{ all -> 0x0066 }
        r11.put(r8, r9);	 Catch:{ all -> 0x0066 }
        r8 = getSessionSecret();	 Catch:{ all -> 0x0066 }
        r5 = getSignature(r11, r8);	 Catch:{ all -> 0x0066 }
        if (r5 == 0) goto L_0x005e;	 Catch:{ all -> 0x0066 }
    L_0x0044:
        r8 = "sign";	 Catch:{ all -> 0x0066 }
        r11.put(r8, r5);	 Catch:{ all -> 0x0066 }
        r8 = com.xiaomi.music.util.NetworkUtil.concatAsUrl(r10, r11);	 Catch:{ all -> 0x0066 }
        r2 = doRequest(r8, r3);	 Catch:{ all -> 0x0066 }
        if (r2 == 0) goto L_0x005e;	 Catch:{ all -> 0x0066 }
    L_0x0053:
        r8 = r2.first;	 Catch:{ all -> 0x0066 }
        r0 = r8;	 Catch:{ all -> 0x0066 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0066 }
        r6 = r0;	 Catch:{ all -> 0x0066 }
        r4 = r2.second;	 Catch:{ all -> 0x0066 }
        if (r4 == 0) goto L_0x0064;
    L_0x005d:
        r7 = 1;
    L_0x005e:
        if (r13 == 0) goto L_0x001b;
    L_0x0060:
        r13.onFinished(r1, r6, r7);
        goto L_0x001b;
    L_0x0064:
        r7 = 0;
        goto L_0x005e;
    L_0x0066:
        r8 = move-exception;
        if (r13 == 0) goto L_0x006c;
    L_0x0069:
        r13.onFinished(r1, r6, r7);
    L_0x006c:
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.player.plugin.onlinemusic2.baidu.parser.BaiduNetwork.request(java.lang.String, java.util.Map, com.miui.player.plugin.base.Parser, com.miui.player.plugin.base.RequestListener):T");
    }

    public static InputStream requestRaw(String url) {
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
        } catch (AssertionError e4) {
            Log.e(TAG, MetaManager.UNKNOWN_STRING, e4);
            return null;
        }
    }

    public static boolean touch(String url) {
        boolean ret = false;
        InputStream is = requestRaw(url);
        if (is != null) {
            try {
                is.close();
                ret = true;
            } catch (IOException e) {
                Log.e(TAG, MetaManager.UNKNOWN_STRING, e);
            }
        }
        Log.d(TAG, "touch: ret=" + ret + " url=" + url);
        return ret;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> android.util.Pair<String, T> doRequest(String r5, com.miui.player.plugin.base.Parser<T, String> r6) {
        /*
        r1 = requestRaw(r5);
        if (r1 == 0) goto L_0x0019;
    L_0x0006:
        r2 = com.miui.player.plugin.base.Parsers.parse(r1, r6);	 Catch:{ NumberFormatException -> 0x000e }
        r1.close();	 Catch:{ IOException -> 0x0032 }
    L_0x000d:
        return r2;
    L_0x000e:
        r0 = move-exception;
        r2 = TAG;	 Catch:{ all -> 0x001b }
        r3 = "";
        android.util.Log.e(r2, r3, r0);	 Catch:{ all -> 0x001b }
        r1.close();	 Catch:{ IOException -> 0x0029 }
    L_0x0019:
        r2 = 0;
        goto L_0x000d;
    L_0x001b:
        r2 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x0020 }
    L_0x001f:
        throw r2;
    L_0x0020:
        r0 = move-exception;
        r3 = TAG;
        r4 = "";
        android.util.Log.e(r3, r4, r0);
        goto L_0x001f;
    L_0x0029:
        r0 = move-exception;
        r2 = TAG;
        r3 = "";
        android.util.Log.e(r2, r3, r0);
        goto L_0x0019;
    L_0x0032:
        r0 = move-exception;
        r3 = TAG;
        r4 = "";
        android.util.Log.e(r3, r4, r0);
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.player.plugin.onlinemusic2.baidu.parser.BaiduNetwork.doRequest(java.lang.String, com.miui.player.plugin.base.Parser):android.util.Pair<java.lang.String, T>");
    }

    private static String getSessionKey() {
        return getCachedValue(BaiduConstants.KEY_BAIDU_SESSION_KEY);
    }

    private static String getSessionSecret() {
        return getCachedValue(BaiduConstants.KEY_BAIDU_SESSION_SECRET);
    }

    private static String getCachedValue(String key) {
        String value = (String) PlugInSharedValues.get(key);
        if (value == null) {
            initialize();
            value = (String) PlugInSharedValues.get(key);
        }
        return value != null ? value : MetaManager.UNKNOWN_STRING;
    }

    private static boolean initialize() {
        IOException e;
        String str;
        String str2;
        InputStream is = null;
        try {
            is = NetworkUtil.doHttpGet(BaiduConstants.ACCESS_TOKEN_URL);
            if (is != null) {
                JSONObject json = StreamHelper.toJSONObject(is);
                if (json != null) {
                    String token = json.optString("access_token");
                    String session = json.optString(BaiduConstants.KEY_SESSION_KEY);
                    String secret = json.optString(BaiduConstants.KEY_SESSION_SECRET);
                    if (!(token == null || session == null || secret == null)) {
                        synchronized (PlugInSharedValues.class) {
                            PlugInSharedValues.put(BaiduConstants.KEY_BAIDU_ACCESS_TOKEN, token);
                            PlugInSharedValues.put(BaiduConstants.KEY_BAIDU_SESSION_KEY, session);
                            PlugInSharedValues.put(BaiduConstants.KEY_BAIDU_SESSION_SECRET, secret);
                        }
                        if (is == null) {
                            return true;
                        }
                        try {
                            is.close();
                            return true;
                        } catch (IOException e2) {
                            Log.e(TAG, MetaManager.UNKNOWN_STRING, e2);
                            return true;
                        }
                    }
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e3) {
                    e2 = e3;
                    str = TAG;
                    str2 = MetaManager.UNKNOWN_STRING;
                    Log.e(str, str2, e2);
                    return false;
                }
            }
        } catch (IOException e22) {
            try {
                Log.e(TAG, MetaManager.UNKNOWN_STRING, e22);
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e4) {
                        e22 = e4;
                        str = TAG;
                        str2 = MetaManager.UNKNOWN_STRING;
                        Log.e(str, str2, e22);
                        return false;
                    }
                }
            } catch (Throwable th) {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e222) {
                        Log.e(TAG, MetaManager.UNKNOWN_STRING, e222);
                    }
                }
            }
        } catch (JSONException e5) {
            Log.e(TAG, MetaManager.UNKNOWN_STRING, e5);
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e6) {
                    e222 = e6;
                    str = TAG;
                    str2 = MetaManager.UNKNOWN_STRING;
                    Log.e(str, str2, e222);
                    return false;
                }
            }
        } catch (URISyntaxException e7) {
            Log.e(TAG, MetaManager.UNKNOWN_STRING, e7);
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e8) {
                    e222 = e8;
                    str = TAG;
                    str2 = MetaManager.UNKNOWN_STRING;
                    Log.e(str, str2, e222);
                    return false;
                }
            }
        }
        return false;
    }

    private static String getSignature(Map<String, String> params, String secret) {
        Set<Entry<String, String>> entrys = new TreeMap(params).entrySet();
        StringBuilder basestring = new StringBuilder();
        for (Entry<String, String> param : entrys) {
            basestring.append((String) param.getKey()).append(LogHelper.SEPARATE_DOT).append((String) param.getValue());
        }
        basestring.append(secret);
        byte[] bytes = null;
        try {
            bytes = MessageDigest.getInstance("MD5").digest(basestring.toString().getBytes("UTF-8"));
        } catch (GeneralSecurityException e) {
        } catch (UnsupportedEncodingException e2) {
        }
        if (bytes == null) {
            return null;
        }
        StringBuilder sign = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 255);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex);
        }
        return sign.toString();
    }
}
