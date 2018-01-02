package com.ushareit.listenit;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class dxj extends duy {
    public dxj(dyf com_ushareit_listenit_dyf) {
        super(com_ushareit_listenit_dyf);
    }

    private byte[] m16268a(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            return toByteArray;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    protected HttpURLConnection m16269a(URL url) {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout((int) mo2098y().m16009H());
            httpURLConnection.setReadTimeout((int) mo2098y().m16010I());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain HTTP connection");
    }

    protected void m16270a(String str) {
    }

    public void m16271a(String str, URL url, Map<String, String> map, dxl com_ushareit_listenit_dxl) {
        mo2083j();
        m15696c();
        cfi.m11080a((Object) url);
        cfi.m11080a((Object) com_ushareit_listenit_dxl);
        mo2095v().m16382b(new dxn(this, str, url, null, map, com_ushareit_listenit_dxl));
    }

    public void m16272a(String str, URL url, byte[] bArr, Map<String, String> map, dxl com_ushareit_listenit_dxl) {
        mo2083j();
        m15696c();
        cfi.m11080a((Object) url);
        cfi.m11080a((Object) bArr);
        cfi.m11080a((Object) com_ushareit_listenit_dxl);
        mo2095v().m16382b(new dxn(this, str, url, bArr, map, com_ushareit_listenit_dxl));
    }

    protected void mo2080e() {
    }

    public boolean m16274f() {
        NetworkInfo activeNetworkInfo;
        m15696c();
        try {
            activeNetworkInfo = ((ConnectivityManager) mo2090q().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    protected void m16275g() {
    }

    public /* bridge */ /* synthetic */ void mo2081h() {
        super.mo2081h();
    }

    public /* bridge */ /* synthetic */ void mo2082i() {
        super.mo2082i();
    }

    public /* bridge */ /* synthetic */ void mo2083j() {
        super.mo2083j();
    }

    public /* bridge */ /* synthetic */ dwm mo2084k() {
        return super.mo2084k();
    }

    public /* bridge */ /* synthetic */ dva mo2085l() {
        return super.mo2085l();
    }

    public /* bridge */ /* synthetic */ dxe mo2086m() {
        return super.mo2086m();
    }

    public /* bridge */ /* synthetic */ dwu mo2087n() {
        return super.mo2087n();
    }

    public /* bridge */ /* synthetic */ dvg mo2088o() {
        return super.mo2088o();
    }

    public /* bridge */ /* synthetic */ cio mo2089p() {
        return super.mo2089p();
    }

    public /* bridge */ /* synthetic */ Context mo2090q() {
        return super.mo2090q();
    }

    public /* bridge */ /* synthetic */ dwo mo2091r() {
        return super.mo2091r();
    }

    public /* bridge */ /* synthetic */ dwk mo2092s() {
        return super.mo2092s();
    }

    public /* bridge */ /* synthetic */ dxz mo2093t() {
        return super.mo2093t();
    }

    public /* bridge */ /* synthetic */ dvx mo2094u() {
        return super.mo2094u();
    }

    public /* bridge */ /* synthetic */ dya mo2095v() {
        return super.mo2095v();
    }

    public /* bridge */ /* synthetic */ dxg mo2096w() {
        return super.mo2096w();
    }

    public /* bridge */ /* synthetic */ dxr mo2097x() {
        return super.mo2097x();
    }

    public /* bridge */ /* synthetic */ dwn mo2098y() {
        return super.mo2098y();
    }
}
