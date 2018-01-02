package com.ushareit.listenit;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class fbd {
    public static byte[] m18771a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        if (!(bArr == null || bArr2 == null)) {
            try {
                Key secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                instance.init(1, secretKeySpec, new IvParameterSpec(bArr2));
                bArr3 = instance.doFinal(bArr);
            } catch (Exception e) {
                exw.m18457e("AES", "encrypt error: " + e.toString());
            }
        }
        return bArr3;
    }
}
