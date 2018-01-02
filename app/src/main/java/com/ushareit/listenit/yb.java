package com.ushareit.listenit;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class yb {
    private final afr<uv, String> f17556a = new afr(1000);

    yb() {
    }

    public String m27236a(uv uvVar) {
        String str;
        synchronized (this.f17556a) {
            str = (String) this.f17556a.m5483b((Object) uvVar);
        }
        if (str == null) {
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA-256");
                uvVar.mo583a(instance);
                str = afu.m5493a(instance.digest());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            }
            synchronized (this.f17556a) {
                this.f17556a.m5484b(uvVar, str);
            }
        }
        return str;
    }
}
