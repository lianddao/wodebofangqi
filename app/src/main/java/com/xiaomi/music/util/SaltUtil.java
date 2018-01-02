package com.xiaomi.music.util;

import com.baidu.music.log.LogHelper;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.NameValuePair;

public class SaltUtil {
    private static final String SALT = "8007236f-a2d6-4847-ac83-c49395ad6d65";

    static class C05491 implements Comparator<NameValuePair> {
        C05491() {
        }

        public int compare(NameValuePair p1, NameValuePair p2) {
            return p1.getName().compareTo(p2.getName());
        }
    }

    public static String getKeyFromParams(List<NameValuePair> nameValuePairs) {
        Collections.sort(nameValuePairs, new C05491());
        StringBuilder keyBuilder = new StringBuilder();
        boolean isFirst = true;
        for (NameValuePair nvp : nameValuePairs) {
            if (!isFirst) {
                keyBuilder.append("&");
            }
            keyBuilder.append(nvp.getName()).append(LogHelper.SEPARATE_DOT).append(nvp.getValue());
            isFirst = false;
        }
        keyBuilder.append("&").append(SALT);
        return getMd5Digest(new String(Base64.encodeBase64(getBytes(keyBuilder.toString()))));
    }

    private static byte[] getBytes(String s) {
        try {
            return s.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            return s.getBytes();
        }
    }

    private static String getMd5Digest(String pInput) {
        try {
            MessageDigest lDigest = MessageDigest.getInstance("MD5");
            lDigest.update(getBytes(pInput));
            BigInteger lHashInt = new BigInteger(1, lDigest.digest());
            return String.format("%1$032X", new Object[]{lHashInt});
        } catch (NoSuchAlgorithmException lException) {
            throw new RuntimeException(lException);
        }
    }
}
