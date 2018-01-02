package com.ushareit.listenit;

import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class cjd extends chr {
    private int f8364a;

    protected cjd(byte[] bArr) {
        boolean z = false;
        if (bArr.length != 25) {
            int length = bArr.length;
            String valueOf = String.valueOf(cit.m11403a(bArr, 0, bArr.length, false));
            Log.wtf("GoogleCertificates", new StringBuilder(String.valueOf(valueOf).length() + 51).append("Cert hash data has incorrect length (").append(length).append("):\n").append(valueOf).toString(), new Exception());
            bArr = Arrays.copyOfRange(bArr, 0, 25);
            if (bArr.length == 25) {
                z = true;
            }
            cfi.m11090b(z, "cert hash data has incorrect length. length=" + bArr.length);
        }
        this.f8364a = Arrays.hashCode(bArr);
    }

    protected static byte[] m11429a(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public ckg mo1373a() {
        return ckj.m11512a(mo1375c());
    }

    public int mo1374b() {
        return hashCode();
    }

    abstract byte[] mo1375c();

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof chq)) {
            return false;
        }
        try {
            chq com_ushareit_listenit_chq = (chq) obj;
            if (com_ushareit_listenit_chq.mo1374b() != hashCode()) {
                return false;
            }
            ckg a = com_ushareit_listenit_chq.mo1373a();
            if (a == null) {
                return false;
            }
            return Arrays.equals(mo1375c(), (byte[]) ckj.m11513a(a));
        } catch (RemoteException e) {
            Log.e("GoogleCertificates", "iCertData failed to retrive data from remote");
            return false;
        }
    }

    public int hashCode() {
        return this.f8364a;
    }
}
