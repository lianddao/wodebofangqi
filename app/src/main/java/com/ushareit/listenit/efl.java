package com.ushareit.listenit;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;

public class efl {
    static final /* synthetic */ boolean f10976a = (!efl.class.desiredAssertionStatus());
    private final Uri f10977b;
    private final efe f10978c;

    efl(Uri uri, efe com_ushareit_listenit_efe) {
        boolean z = true;
        cfi.m11090b(uri != null, "storageUri cannot be null");
        if (com_ushareit_listenit_efe == null) {
            z = false;
        }
        cfi.m11090b(z, "FirebaseApp cannot be null");
        this.f10977b = uri;
        this.f10978c = com_ushareit_listenit_efe;
    }

    public efc m17007a(File file) {
        return m17011b(Uri.fromFile(file));
    }

    public efl m17008a() {
        String path = this.f10977b.getPath();
        if (path == null || path.equals("/")) {
            return null;
        }
        int lastIndexOf = path.lastIndexOf(47);
        return new efl(this.f10977b.buildUpon().path(lastIndexOf == -1 ? "/" : path.substring(0, lastIndexOf)).build(), this.f10978c);
    }

    public efl m17009a(String str) {
        cfi.m11090b(!TextUtils.isEmpty(str), "childName cannot be null or empty");
        String c = czr.m13540c(str);
        try {
            return new efl(this.f10977b.buildUpon().appendEncodedPath(czr.m13538a(c)).build(), this.f10978c);
        } catch (Throwable e) {
            Throwable th = e;
            String str2 = "StorageReference";
            String str3 = "Unable to create a valid default Uri. ";
            String valueOf = String.valueOf(c);
            Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), th);
            throw new IllegalArgumentException("childName");
        }
    }

    public efu m17010a(Uri uri) {
        cfi.m11090b(uri != null, "uri cannot be null");
        efu com_ushareit_listenit_efu = new efu(this, null, uri, null);
        com_ushareit_listenit_efu.m16938k();
        return com_ushareit_listenit_efu;
    }

    public efc m17011b(Uri uri) {
        efc com_ushareit_listenit_efc = new efc(this, uri);
        com_ushareit_listenit_efc.m16938k();
        return com_ushareit_listenit_efc;
    }

    public efe m17012b() {
        return this.f10978c;
    }

    eah m17013c() {
        return m17012b().m16966d();
    }

    dac m17014d() {
        return dac.m13605a(m17013c());
    }

    Uri m17015e() {
        return this.f10977b;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof efl) ? false : ((efl) obj).toString().equals(toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.f10977b.getAuthority());
        String valueOf2 = String.valueOf(this.f10977b.getPath());
        return new StringBuilder((String.valueOf(valueOf).length() + 5) + String.valueOf(valueOf2).length()).append("gs://").append(valueOf).append(valueOf2).toString();
    }
}
