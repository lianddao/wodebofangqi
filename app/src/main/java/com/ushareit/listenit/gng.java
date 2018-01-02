package com.ushareit.listenit;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;

public final class gng {
    public static gnl m22487a(String str) {
        return m22489a(str, null);
    }

    public static gnl m22489a(String str, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder(str);
        if (map != null && map.size() > 0) {
            if (!str.contains("?")) {
                stringBuilder.append("?");
            }
            for (Entry entry : map.entrySet()) {
                if (stringBuilder.toString().contains("=")) {
                    stringBuilder.append("&");
                }
                stringBuilder.append((String) entry.getKey()).append("=").append(m22493c((String) entry.getValue()));
            }
        }
        exw.m18449b("HttpUtils", "get url -> " + stringBuilder.toString());
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(stringBuilder.toString()).openConnection();
        try {
            httpURLConnection.setConnectTimeout(6000000);
            httpURLConnection.setReadTimeout(6000000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setInstanceFollowRedirects(true);
            gnl com_ushareit_listenit_gnl = new gnl(httpURLConnection);
            exw.m18449b("HttpUtils", "response" + com_ushareit_listenit_gnl.m22507a());
            return com_ushareit_listenit_gnl;
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public static gnl m22491b(String str) {
        return m22492b(str, null);
    }

    public static gnl m22492b(String str, Map<String, String> map) {
        Throwable th;
        Writer writer = null;
        exw.m18449b("HttpUtils", "post url -> " + str);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        try {
            httpURLConnection.setConnectTimeout(6000000);
            httpURLConnection.setReadTimeout(6000000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setInstanceFollowRedirects(true);
            if (map != null && map.size() > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                Writer outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
                try {
                    Object obj = 1;
                    for (Entry entry : map.entrySet()) {
                        Object obj2;
                        if (obj != null) {
                            obj2 = null;
                        } else {
                            outputStreamWriter.write("&");
                            stringBuilder.append("&");
                            obj2 = obj;
                        }
                        outputStreamWriter.append((CharSequence) entry.getKey()).append("=").append(m22493c((String) entry.getValue()));
                        stringBuilder.append((String) entry.getKey()).append("=").append(m22493c((String) entry.getValue()));
                        obj = obj2;
                    }
                    outputStreamWriter.flush();
                    exw.m18443a("HttpUtils", "post params: " + stringBuilder);
                    writer = outputStreamWriter;
                } catch (Throwable th2) {
                    th = th2;
                    writer = outputStreamWriter;
                    if (writer != null) {
                        try {
                            writer.close();
                        } catch (IOException e) {
                        }
                    }
                    httpURLConnection.disconnect();
                    throw th;
                }
            }
            gnl com_ushareit_listenit_gnl = new gnl(httpURLConnection);
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e2) {
                }
            }
            httpURLConnection.disconnect();
            exw.m18449b("HttpUtils", "response" + com_ushareit_listenit_gnl.m22507a());
            return com_ushareit_listenit_gnl;
        } catch (Throwable th3) {
            th = th3;
            if (writer != null) {
                writer.close();
            }
            httpURLConnection.disconnect();
            throw th;
        }
    }

    public static gnl m22488a(String str, eyh com_ushareit_listenit_eyh, gnh com_ushareit_listenit_gnh) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(com_ushareit_listenit_eyh.mo2331f(), com_ushareit_listenit_eyh);
        return m22490a(str, linkedHashMap, com_ushareit_listenit_gnh);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.ushareit.listenit.gnl m22490a(java.lang.String r16, java.util.Map<java.lang.String, java.lang.Object> r17, com.ushareit.listenit.gnh r18) {
        /*
        r2 = r17.size();
        if (r2 != 0) goto L_0x0008;
    L_0x0006:
        r2 = 0;
    L_0x0007:
        return r2;
    L_0x0008:
        r8 = new com.ushareit.listenit.gni;
        r8.<init>();
        r0 = r18;
        r8.m22495a(r0);
        r6 = 0;
        r2 = new java.net.URL;
        r0 = r16;
        r2.<init>(r0);
        r3 = 0;
        r4 = 0;
        r2 = r2.openConnection();	 Catch:{ Exception -> 0x025f, all -> 0x0257 }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ Exception -> 0x025f, all -> 0x0257 }
        r3 = 6000000; // 0x5b8d80 float:8.407791E-39 double:2.964394E-317;
        r2.setConnectTimeout(r3);	 Catch:{ Exception -> 0x0265, all -> 0x0257 }
        r3 = 6000000; // 0x5b8d80 float:8.407791E-39 double:2.964394E-317;
        r2.setReadTimeout(r3);	 Catch:{ Exception -> 0x0265, all -> 0x0257 }
        r3 = 1;
        r2.setDoOutput(r3);	 Catch:{ Exception -> 0x0265, all -> 0x0257 }
        r3 = 1;
        r2.setDoInput(r3);	 Catch:{ Exception -> 0x0265, all -> 0x0257 }
        r3 = 0;
        r2.setUseCaches(r3);	 Catch:{ Exception -> 0x0265, all -> 0x0257 }
        r3 = "POST";
        r2.setRequestMethod(r3);	 Catch:{ Exception -> 0x0265, all -> 0x0257 }
        r3 = m22484a(r17);	 Catch:{ Exception -> 0x0265, all -> 0x0257 }
        r2.setFixedLengthStreamingMode(r3);	 Catch:{ Exception -> 0x0265, all -> 0x0257 }
        r3 = "Charset";
        r5 = "UTF-8";
        r2.setRequestProperty(r3, r5);	 Catch:{ Exception -> 0x0265, all -> 0x0257 }
        r3 = "Content-Type";
        r5 = "multipart/form-data; boundary=JavaZnGpCtePMx0KrHw_G0Xl9Yefer8JZlRJSXe";
        r2.setRequestProperty(r3, r5);	 Catch:{ Exception -> 0x0265, all -> 0x0257 }
        r3 = 1;
        r2.setInstanceFollowRedirects(r3);	 Catch:{ Exception -> 0x0265, all -> 0x0257 }
        r5 = new java.io.DataOutputStream;	 Catch:{ Exception -> 0x0265, all -> 0x0257 }
        r3 = r2.getOutputStream();	 Catch:{ Exception -> 0x0265, all -> 0x0257 }
        r5.<init>(r3);	 Catch:{ Exception -> 0x0265, all -> 0x0257 }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r9.<init>();	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r3 = r17.entrySet();	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r10 = r3.iterator();	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
    L_0x006e:
        r3 = r10.hasNext();	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        if (r3 == 0) goto L_0x01c1;
    L_0x0074:
        r3 = r10.next();	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r3 = (java.util.Map.Entry) r3;	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r4 = r3.getKey();	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r4 = (java.lang.String) r4;	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r3 = r3.getValue();	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r7 = "--JavaZnGpCtePMx0KrHw_G0Xl9Yefer8JZlRJSXe\r\n";
        r5.writeBytes(r7);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r7 = r3 instanceof com.ushareit.listenit.eyh;	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        if (r7 == 0) goto L_0x0182;
    L_0x008d:
        r3 = (com.ushareit.listenit.eyh) r3;	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r7 = "Content-Disposition: form-data; name=\"%1$s\"; filename=\"%2$s\"\r\n";
        r11 = 2;
        r11 = new java.lang.Object[r11];	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r12 = 0;
        r11[r12] = r4;	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r12 = 1;
        r13 = r3.mo2331f();	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r11[r12] = r13;	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r7 = java.lang.String.format(r7, r11);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r5.writeBytes(r7);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r7 = "Content-Type: application/octet-stream\r\n";
        r5.writeBytes(r7);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r7 = "\r\n";
        r5.writeBytes(r7);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r7 = com.ushareit.listenit.eyi.Read;	 Catch:{ all -> 0x00d4 }
        r3.mo2322a(r7);	 Catch:{ all -> 0x00d4 }
        r12 = r3.mo2332g();	 Catch:{ all -> 0x00d4 }
        r11 = (int) r12;	 Catch:{ all -> 0x00d4 }
        r7 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r12 = new byte[r7];	 Catch:{ all -> 0x00d4 }
        r7 = 0;
    L_0x00be:
        r13 = r3.mo2328c();	 Catch:{ all -> 0x00d4 }
        if (r13 == 0) goto L_0x012b;
    L_0x00c4:
        r13 = r3.mo2320a(r12);	 Catch:{ all -> 0x00d4 }
        r14 = -1;
        if (r13 == r14) goto L_0x012b;
    L_0x00cb:
        r14 = 0;
        r5.write(r12, r14, r13);	 Catch:{ all -> 0x00d4 }
        r7 = r7 + r13;
        r8.m22494a(r7, r11);	 Catch:{ all -> 0x00d4 }
        goto L_0x00be;
    L_0x00d4:
        r4 = move-exception;
        r3.mo2337l();	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        throw r4;	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
    L_0x00d9:
        r3 = move-exception;
        r4 = r2;
        r2 = r3;
        r3 = r5;
    L_0x00dd:
        r5 = "HttpUtils";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x025b }
        r7.<init>();	 Catch:{ all -> 0x025b }
        r9 = "response exception:";
        r7 = r7.append(r9);	 Catch:{ all -> 0x025b }
        r2 = r2.getMessage();	 Catch:{ all -> 0x025b }
        r2 = r7.append(r2);	 Catch:{ all -> 0x025b }
        r2 = r2.toString();	 Catch:{ all -> 0x025b }
        com.ushareit.listenit.exw.m18454c(r5, r2);	 Catch:{ all -> 0x025b }
        if (r3 == 0) goto L_0x011a;
    L_0x00fb:
        r2 = "HttpUtils";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0220 }
        r5.<init>();	 Catch:{ Exception -> 0x0220 }
        r7 = "realStreamSize=:";
        r5 = r5.append(r7);	 Catch:{ Exception -> 0x0220 }
        r7 = r3.size();	 Catch:{ Exception -> 0x0220 }
        r5 = r5.append(r7);	 Catch:{ Exception -> 0x0220 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0220 }
        com.ushareit.listenit.exw.m18454c(r2, r5);	 Catch:{ Exception -> 0x0220 }
        r3.close();	 Catch:{ Exception -> 0x0220 }
    L_0x011a:
        r2 = r6;
    L_0x011b:
        if (r4 == 0) goto L_0x0120;
    L_0x011d:
        r4.disconnect();
    L_0x0120:
        r3 = 0;
        r8.removeCallbacksAndMessages(r3);
        r0 = r18;
        r8.m22497b(r0);
        goto L_0x0007;
    L_0x012b:
        r3.mo2337l();	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r7 = "Content-Disposition: form-data; name=\"%1$s\"; filename=\"%2$s\"\r\n";
        r11 = 2;
        r11 = new java.lang.Object[r11];	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r12 = 0;
        r11[r12] = r4;	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r4 = 1;
        r3 = r3.mo2331f();	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r11[r4] = r3;	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r3 = java.lang.String.format(r7, r11);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r9.append(r3);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r3 = "Content-Type: application/octet-stream\r\n";
        r9.append(r3);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r3 = "\r\n";
        r9.append(r3);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r3 = "[FILE]";
        r9.append(r3);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
    L_0x0153:
        r3 = "\r\n";
        r5.writeBytes(r3);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r3 = "\r\n";
        r9.append(r3);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        goto L_0x006e;
    L_0x015f:
        r2 = move-exception;
    L_0x0160:
        if (r5 == 0) goto L_0x0181;
    L_0x0162:
        r3 = "HttpUtils";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x023c }
        r4.<init>();	 Catch:{ Exception -> 0x023c }
        r6 = "realStreamSize=:";
        r4 = r4.append(r6);	 Catch:{ Exception -> 0x023c }
        r6 = r5.size();	 Catch:{ Exception -> 0x023c }
        r4 = r4.append(r6);	 Catch:{ Exception -> 0x023c }
        r4 = r4.toString();	 Catch:{ Exception -> 0x023c }
        com.ushareit.listenit.exw.m18454c(r3, r4);	 Catch:{ Exception -> 0x023c }
        r5.close();	 Catch:{ Exception -> 0x023c }
    L_0x0181:
        throw r2;
    L_0x0182:
        r7 = "Content-Disposition: form-data; name=\"%1$s\";\r\n";
        r11 = 1;
        r11 = new java.lang.Object[r11];	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r12 = 0;
        r11[r12] = r4;	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r7 = java.lang.String.format(r7, r11);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r5.writeBytes(r7);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r7 = "\r\n";
        r5.writeBytes(r7);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r3 = m22493c(r3);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r7 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        if (r7 != 0) goto L_0x01a7;
    L_0x01a4:
        r5.writeBytes(r3);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
    L_0x01a7:
        r3 = "Content-Disposition: form-data; name=\"%1$s\";\r\n";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r11 = 0;
        r7[r11] = r4;	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r3 = java.lang.String.format(r3, r7);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r9.append(r3);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r3 = "\r\n";
        r9.append(r3);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r3 = "[content]";
        r9.append(r3);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        goto L_0x0153;
    L_0x01c1:
        r3 = "--JavaZnGpCtePMx0KrHw_G0Xl9Yefer8JZlRJSXe--\r\n";
        r5.writeBytes(r3);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r5.flush();	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r3 = "--JavaZnGpCtePMx0KrHw_G0Xl9Yefer8JZlRJSXe--\r\n";
        r9.append(r3);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r3 = "HttpUtils";
        r4 = r9.toString();	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        com.ushareit.listenit.exw.m18449b(r3, r4);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r4 = new com.ushareit.listenit.gnl;	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        r4.<init>(r2);	 Catch:{ Exception -> 0x00d9, all -> 0x015f }
        if (r5 == 0) goto L_0x01fd;
    L_0x01de:
        r3 = "HttpUtils";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0202 }
        r6.<init>();	 Catch:{ Exception -> 0x0202 }
        r7 = "realStreamSize=:";
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0202 }
        r7 = r5.size();	 Catch:{ Exception -> 0x0202 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0202 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0202 }
        com.ushareit.listenit.exw.m18454c(r3, r6);	 Catch:{ Exception -> 0x0202 }
        r5.close();	 Catch:{ Exception -> 0x0202 }
    L_0x01fd:
        r15 = r2;
        r2 = r4;
        r4 = r15;
        goto L_0x011b;
    L_0x0202:
        r3 = move-exception;
        r5 = "HttpUtils";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "close error=";
        r6 = r6.append(r7);
        r3 = r6.append(r3);
        r3 = r3.toString();
        com.ushareit.listenit.exw.m18457e(r5, r3);
        r15 = r2;
        r2 = r4;
        r4 = r15;
        goto L_0x011b;
    L_0x0220:
        r2 = move-exception;
        r3 = "HttpUtils";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r7 = "close error=";
        r5 = r5.append(r7);
        r2 = r5.append(r2);
        r2 = r2.toString();
        com.ushareit.listenit.exw.m18457e(r3, r2);
        r2 = r6;
        goto L_0x011b;
    L_0x023c:
        r3 = move-exception;
        r4 = "HttpUtils";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "close error=";
        r5 = r5.append(r6);
        r3 = r5.append(r3);
        r3 = r3.toString();
        com.ushareit.listenit.exw.m18457e(r4, r3);
        goto L_0x0181;
    L_0x0257:
        r2 = move-exception;
        r5 = r4;
        goto L_0x0160;
    L_0x025b:
        r2 = move-exception;
        r5 = r3;
        goto L_0x0160;
    L_0x025f:
        r2 = move-exception;
        r15 = r4;
        r4 = r3;
        r3 = r15;
        goto L_0x00dd;
    L_0x0265:
        r3 = move-exception;
        r15 = r3;
        r3 = r4;
        r4 = r2;
        r2 = r15;
        goto L_0x00dd;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.gng.a(java.lang.String, java.util.Map, com.ushareit.listenit.gnh):com.ushareit.listenit.gnl");
    }

    public static gnk m22485a(String str, String str2) {
        exw.m18449b("HttpUtils", "download url -> " + str);
        URL url = new URL(str);
        eyh a = eyh.m18491a(str2);
        gnk c = a.mo2328c();
        if (!c != false) {
            a.mo2334i();
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        try {
            c = new gnk(httpsURLConnection, a);
            return c;
        } finally {
            httpsURLConnection.disconnect();
        }
    }

    public static gnk m22486a(String str, String str2, String str3, int i, gnh com_ushareit_listenit_gnh) {
        long j;
        exw.m18454c("HttpUtils", "download url -> " + str);
        URL url = new URL(str);
        gni com_ushareit_listenit_gni = new gni();
        com_ushareit_listenit_gni.m22498c(com_ushareit_listenit_gnh);
        eyh a = gnk.m22501a(str2, str3);
        long g = a.mo2332g();
        if (g >= ((long) i)) {
            exw.m18454c("HttpUtils", "startPos>endPos delete old and download new");
            a.mo2335j();
            a = gnk.m22501a(str2, str3);
            j = 0;
        } else {
            j = g;
        }
        exw.m18454c("HttpUtils", "range:" + j + "-" + i);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        try {
            httpURLConnection.setConnectTimeout(6000000);
            httpURLConnection.setReadTimeout(6000000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Range", "bytes=" + j + "-" + i);
            httpURLConnection.setInstanceFollowRedirects(true);
            gnk com_ushareit_listenit_gnk = new gnk(httpURLConnection, str2, a, i, com_ushareit_listenit_gni);
            return com_ushareit_listenit_gnk;
        } finally {
            httpURLConnection.disconnect();
            com_ushareit_listenit_gni.removeCallbacksAndMessages(null);
            com_ushareit_listenit_gni.m22499d(com_ushareit_listenit_gnh);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m22484a(java.util.Map<java.lang.String, java.lang.Object> r9) {
        /*
        r2 = 0;
        r4 = new java.io.DataOutputStream;
        r0 = new java.io.ByteArrayOutputStream;
        r0.<init>();
        r4.<init>(r0);
        r0 = r9.entrySet();	 Catch:{ Exception -> 0x00cd }
        r5 = r0.iterator();	 Catch:{ Exception -> 0x00cd }
        r3 = r2;
    L_0x0014:
        r0 = r5.hasNext();	 Catch:{ Exception -> 0x00cd }
        if (r0 == 0) goto L_0x008a;
    L_0x001a:
        r0 = r5.next();	 Catch:{ Exception -> 0x00cd }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ Exception -> 0x00cd }
        r1 = r0.getKey();	 Catch:{ Exception -> 0x00cd }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x00cd }
        r0 = r0.getValue();	 Catch:{ Exception -> 0x00cd }
        r6 = "--JavaZnGpCtePMx0KrHw_G0Xl9Yefer8JZlRJSXe\r\n";
        r4.writeBytes(r6);	 Catch:{ Exception -> 0x00cd }
        r6 = r0 instanceof com.ushareit.listenit.eyh;	 Catch:{ Exception -> 0x00cd }
        if (r6 == 0) goto L_0x0063;
    L_0x0033:
        r0 = (com.ushareit.listenit.eyh) r0;	 Catch:{ Exception -> 0x00cd }
        r6 = "Content-Disposition: form-data; name=\"%1$s\"; filename=\"%2$s\"\r\n";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x00cd }
        r8 = 0;
        r7[r8] = r1;	 Catch:{ Exception -> 0x00cd }
        r1 = 1;
        r8 = r0.mo2331f();	 Catch:{ Exception -> 0x00cd }
        r7[r1] = r8;	 Catch:{ Exception -> 0x00cd }
        r1 = java.lang.String.format(r6, r7);	 Catch:{ Exception -> 0x00cd }
        r4.writeBytes(r1);	 Catch:{ Exception -> 0x00cd }
        r1 = "Content-Type: application/octet-stream\r\n";
        r4.writeBytes(r1);	 Catch:{ Exception -> 0x00cd }
        r1 = "\r\n";
        r4.writeBytes(r1);	 Catch:{ Exception -> 0x00cd }
        r6 = (long) r3;	 Catch:{ Exception -> 0x00cd }
        r0 = r0.mo2332g();	 Catch:{ Exception -> 0x00cd }
        r0 = r0 + r6;
        r0 = (int) r0;	 Catch:{ Exception -> 0x00cd }
    L_0x005c:
        r1 = "\r\n";
        r4.writeBytes(r1);	 Catch:{ Exception -> 0x00cd }
        r3 = r0;
        goto L_0x0014;
    L_0x0063:
        r6 = "Content-Disposition: form-data; name=\"%1$s\";\r\n";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x00cd }
        r8 = 0;
        r7[r8] = r1;	 Catch:{ Exception -> 0x00cd }
        r1 = java.lang.String.format(r6, r7);	 Catch:{ Exception -> 0x00cd }
        r4.writeBytes(r1);	 Catch:{ Exception -> 0x00cd }
        r1 = "\r\n";
        r4.writeBytes(r1);	 Catch:{ Exception -> 0x00cd }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00cd }
        r0 = m22493c(r0);	 Catch:{ Exception -> 0x00cd }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x00cd }
        if (r1 != 0) goto L_0x0088;
    L_0x0085:
        r4.writeBytes(r0);	 Catch:{ Exception -> 0x00cd }
    L_0x0088:
        r0 = r3;
        goto L_0x005c;
    L_0x008a:
        r0 = "--JavaZnGpCtePMx0KrHw_G0Xl9Yefer8JZlRJSXe--\r\n";
        r4.writeBytes(r0);	 Catch:{ Exception -> 0x00cd }
        r4.flush();	 Catch:{ Exception -> 0x00cd }
        r0 = r4.size();	 Catch:{ Exception -> 0x00cd }
        r0 = r0 + r3;
        r4.close();	 Catch:{ Exception -> 0x00b3 }
    L_0x009a:
        r1 = "HttpUtils";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "getMultiPartStreamLength: ";
        r2 = r2.append(r3);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.ushareit.listenit.exw.m18454c(r1, r2);
        return r0;
    L_0x00b3:
        r1 = move-exception;
        r2 = "HttpUtils";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "close error=";
        r3 = r3.append(r4);
        r1 = r3.append(r1);
        r1 = r1.toString();
        com.ushareit.listenit.exw.m18457e(r2, r1);
        goto L_0x009a;
    L_0x00cd:
        r0 = move-exception;
        r1 = "HttpUtils";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010a }
        r3.<init>();	 Catch:{ all -> 0x010a }
        r5 = "getMultiPartStreamLength exception:";
        r3 = r3.append(r5);	 Catch:{ all -> 0x010a }
        r0 = r0.getMessage();	 Catch:{ all -> 0x010a }
        r0 = r3.append(r0);	 Catch:{ all -> 0x010a }
        r0 = r0.toString();	 Catch:{ all -> 0x010a }
        com.ushareit.listenit.exw.m18454c(r1, r0);	 Catch:{ all -> 0x010a }
        r4.close();	 Catch:{ Exception -> 0x00ef }
        r0 = r2;
        goto L_0x009a;
    L_0x00ef:
        r0 = move-exception;
        r1 = "HttpUtils";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "close error=";
        r3 = r3.append(r4);
        r0 = r3.append(r0);
        r0 = r0.toString();
        com.ushareit.listenit.exw.m18457e(r1, r0);
        r0 = r2;
        goto L_0x009a;
    L_0x010a:
        r0 = move-exception;
        r4.close();	 Catch:{ Exception -> 0x010f }
    L_0x010e:
        throw r0;
    L_0x010f:
        r1 = move-exception;
        r2 = "HttpUtils";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "close error=";
        r3 = r3.append(r4);
        r1 = r3.append(r1);
        r1 = r1.toString();
        com.ushareit.listenit.exw.m18457e(r2, r1);
        goto L_0x010e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.gng.a(java.util.Map):int");
    }

    private static String m22493c(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            exu.m18432a(e.getMessage());
            return null;
        }
    }
}
