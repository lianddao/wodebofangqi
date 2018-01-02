package com.xiaomi.music.util;

import android.util.Log;
import com.baidu.utils.FileUtil;
import com.miui.player.meta.MetaManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class URLHelper {
    private static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final String TAG = "URLHelper";
    private static Random random = new Random(System.currentTimeMillis());

    public static String getUrl(String urlString, List<String> params, boolean isQueryEmpty) {
        Log.d(TAG, "getUrl begin:" + urlString);
        String signature = MetaManager.UNKNOWN_STRING;
        String nonce = String.valueOf(random.nextLong());
        params.add(nonce);
        try {
            signature = URLEncoder.encode(genSignature(params, nonce), "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        if (isQueryEmpty) {
            urlString = urlString + "?sign=" + signature + "&nonce=" + nonce;
        } else {
            urlString = urlString + "&sign=" + signature + "&nonce=" + nonce;
        }
        Log.d(TAG, "getUrl end:" + urlString);
        return urlString;
    }

    private static String genSignature(List<String> params, String key) {
        StringBuffer strbuf = new StringBuffer();
        Collections.sort(params);
        for (String param : params) {
            strbuf.append(param);
        }
        return encodeBySHA1(strbuf.toString());
    }

    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 15]);
            buf.append(HEX_DIGITS[bytes[j] & 15]);
        }
        return buf.toString();
    }

    private static String encodeBySHA1(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(FileUtil.HASH_TYPE_SHA1);
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
