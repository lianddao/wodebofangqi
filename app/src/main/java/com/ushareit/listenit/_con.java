package com.ushareit.listenit;

import com.mopub.common.Constants;
import java.net.URI;

public class con {
    private final String f8563a;
    private final String f8564b;
    private final boolean f8565c;

    public con(String str, String str2, boolean z) {
        this.f8563a = str;
        this.f8564b = str2;
        this.f8565c = z;
    }

    public static URI m12036a(String str, boolean z, String str2, String str3) {
        String str4 = z ? "wss" : "ws";
        String valueOf = String.valueOf(fno.KEY_VERSION);
        String valueOf2 = String.valueOf("5");
        str4 = new StringBuilder(((((String.valueOf(str4).length() + 13) + String.valueOf(str).length()) + String.valueOf(str2).length()) + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length()).append(str4).append("://").append(str).append("/.ws?ns=").append(str2).append("&").append(valueOf).append("=").append(valueOf2).toString();
        if (str3 != null) {
            str4 = String.valueOf(str4);
            valueOf = String.valueOf("&ls=");
            str4 = new StringBuilder(((String.valueOf(str4).length() + 0) + String.valueOf(valueOf).length()) + String.valueOf(str3).length()).append(str4).append(valueOf).append(str3).toString();
        }
        return URI.create(str4);
    }

    public String m12037a() {
        return this.f8563a;
    }

    public String m12038b() {
        return this.f8564b;
    }

    public boolean m12039c() {
        return this.f8565c;
    }

    public String toString() {
        String str = this.f8565c ? "s" : "";
        String str2 = this.f8563a;
        return new StringBuilder((String.valueOf(str).length() + 7) + String.valueOf(str2).length()).append(Constants.HTTP).append(str).append("://").append(str2).toString();
    }
}
