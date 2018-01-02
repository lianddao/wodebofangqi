package com.ushareit.listenit;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.mopub.common.Constants;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class czv {
    public static Uri m13544a(eah com_ushareit_listenit_eah, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.toLowerCase().startsWith("gs://")) {
            String str2 = "gs://";
            String valueOf = String.valueOf(czr.m13538a(czr.m13540c(str.substring(5))));
            return Uri.parse(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        Uri parse = Uri.parse(str);
        Object toLowerCase = parse.getScheme().toLowerCase();
        if (m13546a(toLowerCase, Constants.HTTP) || m13546a(toLowerCase, Constants.HTTPS)) {
            try {
                int indexOf = parse.getAuthority().toLowerCase().indexOf(m13547b(com_ushareit_listenit_eah));
                valueOf = czr.m13539b(parse.getEncodedPath());
                if (indexOf == 0 && valueOf.startsWith("/")) {
                    int indexOf2 = valueOf.indexOf("/b/", 0);
                    indexOf = valueOf.indexOf("/", indexOf2 + 3);
                    int indexOf3 = valueOf.indexOf("/o/", 0);
                    if (indexOf2 == -1 || indexOf == -1) {
                        Log.w("StorageUtil", "Only URLs to firebasestorage.googleapis.com are supported.");
                        throw new IllegalArgumentException("Only URLs to firebasestorage.googleapis.com are supported.");
                    }
                    str2 = valueOf.substring(indexOf2 + 3, indexOf);
                    valueOf = indexOf3 != -1 ? valueOf.substring(indexOf3 + 3) : "";
                } else if (indexOf > 1) {
                    str2 = parse.getAuthority().substring(0, indexOf - 1);
                } else {
                    Log.w("StorageUtil", "Only URLs to firebasestorage.googleapis.com are supported.");
                    throw new IllegalArgumentException("Only URLs to firebasestorage.googleapis.com are supported.");
                }
                cfi.m11083a(str2, (Object) "No bucket specified");
                return new Builder().scheme("gs").authority(str2).encodedPath(valueOf).build();
            } catch (RemoteException e) {
                throw new UnsupportedEncodingException("Could not parse Url because the Storage network layer did not load");
            }
        }
        str2 = "StorageUtil";
        String str3 = "FirebaseStorage is unable to support the scheme:";
        valueOf = String.valueOf(toLowerCase);
        Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        throw new IllegalArgumentException("Uri scheme");
    }

    public static String m13545a(eah com_ushareit_listenit_eah) {
        Object a;
        String valueOf;
        try {
            a = ((ebk) dzt.m16572a(com_ushareit_listenit_eah.m16623b(false), 30000, TimeUnit.MILLISECONDS)).m16649a();
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            Log.w("StorageUtil", "no auth token for request");
            return null;
        } catch (ExecutionException e) {
            a = e;
            valueOf = String.valueOf(a);
            Log.e("StorageUtil", new StringBuilder(String.valueOf(valueOf).length() + 20).append("error getting token ").append(valueOf).toString());
            return null;
        } catch (InterruptedException e2) {
            a = e2;
            valueOf = String.valueOf(a);
            Log.e("StorageUtil", new StringBuilder(String.valueOf(valueOf).length() + 20).append("error getting token ").append(valueOf).toString());
            return null;
        } catch (TimeoutException e3) {
            a = e3;
            valueOf = String.valueOf(a);
            Log.e("StorageUtil", new StringBuilder(String.valueOf(valueOf).length() + 20).append("error getting token ").append(valueOf).toString());
            return null;
        }
    }

    public static boolean m13546a(Object obj, Object obj2) {
        return cff.m11078a(obj, obj2);
    }

    private static String m13547b(eah com_ushareit_listenit_eah) {
        return dac.m13605a(com_ushareit_listenit_eah).m13610a();
    }
}
