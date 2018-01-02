package com.ushareit.listenit;

import android.annotation.SuppressLint;
import java.security.Key;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class fbg {
    @SuppressLint({"TrulyRandom"})
    public static byte[] m18780a(byte[] bArr, String str) {
        byte[] bArr2 = null;
        if (!(bArr == null || str == null)) {
            try {
                Key a = m18779a(str);
                Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                instance.init(1, a);
                bArr2 = instance.doFinal(bArr);
            } catch (Throwable e) {
                exw.m18444a("RSA", "can not support RSAEncrypt!", e);
            }
        }
        return bArr2;
    }

    private static RSAPublicKey m18779a(String str) {
        return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(fbe.m18772a(str)));
    }
}
