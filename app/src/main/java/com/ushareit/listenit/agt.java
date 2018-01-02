package com.ushareit.listenit;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.Closeable;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;

public class agt {
    private static final hjm f4348a = hjn.m23936a("ProxyCacheUtils");

    static String m5594a(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        Object fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        return TextUtils.isEmpty(fileExtensionFromUrl) ? null : singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    static void m5597a(byte[] bArr, long j, int i) {
        boolean z;
        boolean z2 = true;
        ago.m5590a((Object) bArr, "Buffer must be not null!");
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        ago.m5592a(z, "Data offset must be positive!");
        if (i < 0 || i > bArr.length) {
            z2 = false;
        }
        ago.m5592a(z2, "Length must be in range [0..buffer.length]");
    }

    static String m5598b(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Throwable e) {
            throw new RuntimeException("Error encoding url", e);
        }
    }

    static String m5599c(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (Throwable e) {
            throw new RuntimeException("Error decoding url", e);
        }
    }

    static void m5596a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                f4348a.mo2792a("Error closing resource", e);
            }
        }
    }

    public static String m5600d(String str) {
        try {
            return m5595a(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    private static String m5595a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuffer.toString();
    }
}
