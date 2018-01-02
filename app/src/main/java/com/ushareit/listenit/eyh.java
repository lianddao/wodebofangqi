package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import java.io.File;

public abstract class eyh {
    public abstract int mo2320a(byte[] bArr);

    public abstract int mo2321a(byte[] bArr, int i, int i2);

    public abstract void mo2322a(eyi com_ushareit_listenit_eyi);

    public abstract void mo2323a(eyi com_ushareit_listenit_eyi, long j);

    public abstract boolean mo2324a();

    public abstract boolean mo2325a(eyh com_ushareit_listenit_eyh);

    public abstract void mo2326b(byte[] bArr, int i, int i2);

    public abstract boolean mo2327b();

    public abstract boolean mo2328c();

    public abstract eyh mo2329d();

    public abstract String mo2330e();

    public abstract String mo2331f();

    public abstract long mo2332g();

    public abstract boolean mo2333h();

    public abstract boolean mo2334i();

    public abstract boolean mo2335j();

    public abstract File mo2336k();

    public abstract void mo2337l();

    public static eyh m18490a(File file) {
        return new eym(file);
    }

    public static eyh m18489a(fl flVar) {
        return new eyl(flVar);
    }

    public static eyh m18491a(String str) {
        Context a = eys.m18562a();
        Uri parse = Uri.parse(str);
        return m18492a(a, parse) ? new eyl(parse, false) : new eym(str);
    }

    public static eyh m18488a(eyh com_ushareit_listenit_eyh, String str) {
        if (com_ushareit_listenit_eyh instanceof eym) {
            return new eym((eym) com_ushareit_listenit_eyh, str);
        }
        if (com_ushareit_listenit_eyh instanceof eyl) {
            return new eyl((eyl) com_ushareit_listenit_eyh, str);
        }
        return null;
    }

    private static boolean m18492a(Context context, Uri uri) {
        try {
            return fl.m19697c(context, uri);
        } catch (NoClassDefFoundError e) {
            ext.m18428a(context);
            return false;
        }
    }
}
