package com.ushareit.listenit;

import android.net.Uri;
import android.text.TextUtils;
import com.mopub.common.Constants;

public class caz {
    public static String m10592a(String str) {
        boolean z = false;
        cfi.m11090b(!TextUtils.isEmpty(str), "account type cannot be empty");
        String scheme = Uri.parse(str).getScheme();
        if (Constants.HTTP.equalsIgnoreCase(scheme) || Constants.HTTPS.equalsIgnoreCase(scheme)) {
            z = true;
        }
        cfi.m11090b(z, "Account type must be an http or https URI");
        return str;
    }
}
