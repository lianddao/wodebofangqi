package com.ushareit.listenit;

public class apq {
    private static final String[] f5150a = new String[]{"com.flurry.android.FlurryAgent", "com.flurry.android.ads.FlurryAdErrorType", "com.flurry.android.ads.FlurryAdNative", "com.flurry.android.ads.FlurryAdNativeAsset", "com.flurry.android.ads.FlurryAdNativeListener"};
    private static final String[] f5151b = new String[]{"com.inmobi.ads.InMobiNative", "com.inmobi.sdk.InMobiSdk"};
    private static final String[] f5152c = new String[]{"com.google.android.gms.ads.formats.NativeAdView"};

    public static boolean m6711a(alj com_ushareit_listenit_alj) {
        switch (apr.f5153a[com_ushareit_listenit_alj.ordinal()]) {
            case 1:
                return true;
            case 2:
                return m6713a(f5150a);
            case 3:
                return m6713a(f5151b);
            case 4:
                return m6713a(f5152c);
            default:
                return false;
        }
    }

    private static boolean m6712a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean m6713a(String[] strArr) {
        if (strArr == null) {
            return false;
        }
        for (String a : strArr) {
            if (!m6712a(a)) {
                return false;
            }
        }
        return true;
    }
}
