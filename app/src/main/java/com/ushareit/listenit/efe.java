package com.ushareit.listenit;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public class efe {
    static final /* synthetic */ boolean f10945a = (!efe.class.desiredAssertionStatus());
    private static final Map<eah, efe> f10946b = new HashMap();
    private final eah f10947c;
    private long f10948d = 600000;
    private long f10949e = 600000;
    private long f10950f = 120000;

    private efe(eah com_ushareit_listenit_eah) {
        this.f10947c = com_ushareit_listenit_eah;
    }

    public static efe m16959a() {
        eah d = eah.m16613d();
        cfi.m11090b(d != null, "You must call FirebaseApp.initialize() first.");
        if (f10945a || d != null) {
            return m16960a(d);
        }
        throw new AssertionError();
    }

    public static efe m16960a(eah com_ushareit_listenit_eah) {
        efe com_ushareit_listenit_efe;
        cfi.m11090b(com_ushareit_listenit_eah != null, "Null is not a valid value for the FirebaseApp.");
        synchronized (f10946b) {
            com_ushareit_listenit_efe = (efe) f10946b.get(com_ushareit_listenit_eah);
            if (com_ushareit_listenit_efe == null) {
                com_ushareit_listenit_efe = new efe(com_ushareit_listenit_eah);
                f10946b.put(com_ushareit_listenit_eah, com_ushareit_listenit_efe);
            }
        }
        return com_ushareit_listenit_efe;
    }

    private efl m16961a(Uri uri) {
        cfi.m11081a((Object) uri, (Object) "uri must not be null");
        Object e = m16962e();
        boolean z = TextUtils.isEmpty(e) || uri.getAuthority().equalsIgnoreCase(e);
        cfi.m11090b(z, "The supplied bucketname is not available to this project.");
        return new efl(uri, this);
    }

    private String m16962e() {
        return this.f10947c.m16625c().m16636e();
    }

    public efl m16963a(String str) {
        cfi.m11090b(!TextUtils.isEmpty(str), "location must not be null or empty");
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.startsWith("gs://") || toLowerCase.startsWith("https://") || toLowerCase.startsWith("http://")) {
            try {
                Uri a = czv.m13544a(this.f10947c, str);
                if (a != null) {
                    return m16961a(a);
                }
                throw new IllegalArgumentException("The storage Uri could not be parsed.");
            } catch (Throwable e) {
                Throwable th = e;
                String str2 = "FirebaseStorage";
                String str3 = "Unable to parse location:";
                toLowerCase = String.valueOf(str);
                Log.e(str2, toLowerCase.length() != 0 ? str3.concat(toLowerCase) : new String(str3), th);
                throw new IllegalArgumentException("The storage Uri could not be parsed.");
            }
        }
        throw new IllegalArgumentException("The storage Uri could not be parsed.");
    }

    public long m16964b() {
        return this.f10949e;
    }

    public long m16965c() {
        return this.f10948d;
    }

    public eah m16966d() {
        return this.f10947c;
    }
}
