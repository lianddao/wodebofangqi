package com.ushareit.listenit;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class apy implements aqj {
    private final aqk f5166a;

    public apy() {
        this(new apz());
    }

    public apy(aqk com_ushareit_listenit_aqk) {
        this.f5166a = com_ushareit_listenit_aqk;
    }

    public OutputStream mo764a(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getOutputStream();
    }

    public HttpURLConnection mo765a(String str) {
        return (HttpURLConnection) new URL(str).openConnection();
    }

    public void mo766a(OutputStream outputStream, byte[] bArr) {
        outputStream.write(bArr);
    }

    public void mo767a(HttpURLConnection httpURLConnection, aqc com_ushareit_listenit_aqc, String str) {
        httpURLConnection.setRequestMethod(com_ushareit_listenit_aqc.m6774c());
        httpURLConnection.setDoOutput(com_ushareit_listenit_aqc.m6773b());
        httpURLConnection.setDoInput(com_ushareit_listenit_aqc.m6772a());
        if (str != null) {
            httpURLConnection.setRequestProperty("Content-Type", str);
        }
        httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
    }

    public boolean mo768a(aqf com_ushareit_listenit_aqf) {
        aqg a = com_ushareit_listenit_aqf.m6775a();
        if (this.f5166a.mo775a()) {
            this.f5166a.mo773a("BasicRequestHandler.onError got");
            com_ushareit_listenit_aqf.printStackTrace();
        }
        return a != null && a.m6776a() > 0;
    }

    public byte[] mo769a(InputStream inputStream) {
        byte[] bArr = new byte[16384];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public InputStream mo770b(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getInputStream();
    }
}
