package com.ushareit.listenit;

import com.mopub.common.Constants;
import java.io.IOException;
import java.util.Map;

public class ewy {
    public static ezt m18132a(String str, Map<String, String> map, int i) {
        IOException iOException = new IOException();
        int i2 = 0;
        while (i2 < i) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                ezt a = ezm.m18630a(str, (Map) map, (int) Constants.TEN_SECONDS_MILLIS, (int) Constants.TEN_SECONDS_MILLIS);
                eww.m18328a(eys.m18562a(), "success", str, System.currentTimeMillis() - currentTimeMillis, null);
                return a;
            } catch (IOException e) {
                iOException = e;
                i2++;
                exw.m18457e("CLOUD.Connector", "doRetryPost(): URL: " + str + ", Retry count:" + i2 + " and exception:" + iOException.toString());
                eww.m18328a(eys.m18562a(), "failed", str, System.currentTimeMillis() - currentTimeMillis, iOException.toString());
            }
        }
        throw iOException;
    }

    public static ezt m18133a(String str, byte[] bArr, int i) {
        IOException iOException = new IOException();
        int i2 = 0;
        while (i2 < i) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                ezt a = ezm.m18632a(str, bArr, (int) Constants.TEN_SECONDS_MILLIS, (int) Constants.TEN_SECONDS_MILLIS);
                eww.m18328a(eys.m18562a(), "success", str, System.currentTimeMillis() - currentTimeMillis, null);
                return a;
            } catch (IOException e) {
                iOException = e;
                i2++;
                exw.m18457e("CLOUD.Connector", "doRetryPostJSON(): URL: " + str + ", Retry count:" + i2 + " and exception:" + iOException.toString());
                eww.m18328a(eys.m18562a(), "failed", str, System.currentTimeMillis() - currentTimeMillis, iOException.toString());
            }
        }
        throw iOException;
    }
}
