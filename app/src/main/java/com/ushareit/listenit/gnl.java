package com.ushareit.listenit;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;

class gnl {
    private boolean f14458a;
    private String f14459b;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    gnl(java.net.HttpURLConnection r7) {
        /*
        r6 = this;
        r4 = 1;
        r6.<init>();
        r0 = r7.getResponseCode();
        r1 = "ResponseOfString";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "response status code:";
        r2 = r2.append(r3);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.ushareit.listenit.exw.m18454c(r1, r2);
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 != r1) goto L_0x0038;
    L_0x0024:
        r6.f14458a = r4;
        r0 = 0;
        r0 = r7.getInputStream();	 Catch:{ IOException -> 0x0055, all -> 0x005d }
        if (r0 == 0) goto L_0x0034;
    L_0x002d:
        r1 = 1;
        r1 = com.ushareit.listenit.fbb.m18753a(r0, r1);	 Catch:{ IOException -> 0x0055 }
        r6.f14459b = r1;	 Catch:{ IOException -> 0x0055 }
    L_0x0034:
        com.ushareit.listenit.fbb.m18757a(r0);
    L_0x0037:
        return;
    L_0x0038:
        r0 = "ResponseOfString";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "status code is not 200,status message is:";
        r1 = r1.append(r2);
        r2 = r7.getResponseMessage();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.ushareit.listenit.exw.m18457e(r0, r1);
        goto L_0x0037;
    L_0x0055:
        r1 = move-exception;
        r6.m22506a(r7);	 Catch:{ all -> 0x0065 }
        com.ushareit.listenit.fbb.m18757a(r0);
        goto L_0x0037;
    L_0x005d:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
    L_0x0061:
        com.ushareit.listenit.fbb.m18757a(r1);
        throw r0;
    L_0x0065:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x0061;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.gnl.<init>(java.net.HttpURLConnection):void");
    }

    private void m22506a(HttpURLConnection httpURLConnection) {
        try {
            InputStream errorStream = httpURLConnection.getErrorStream();
            if (errorStream != null) {
                char[] cArr = new char[1024];
                StringBuilder stringBuilder = new StringBuilder();
                Reader inputStreamReader = new InputStreamReader(errorStream, "UTF-8");
                while (true) {
                    int read = inputStreamReader.read(cArr, 0, cArr.length);
                    if (read < 0) {
                        exw.m18454c("ResponseOfString", "response error message:" + stringBuilder.toString());
                        return;
                    }
                    stringBuilder.append(cArr, 0, read);
                }
            }
        } catch (Throwable e) {
            exw.m18450b("ResponseOfString", "The process of showing detail error info has an error", e);
        }
    }

    public String m22507a() {
        return this.f14459b;
    }

    public boolean m22508b() {
        return this.f14458a;
    }

    public String toString() {
        return "ResponseOfString{isSuccess=" + this.f14458a + ", content='" + this.f14459b + '\'' + '}';
    }
}
