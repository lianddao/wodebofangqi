package com.ushareit.listenit;

public enum ano {
    UNKNOWN(0),
    WEBVIEW_BANNER_LEGACY(4),
    WEBVIEW_BANNER_50(5),
    WEBVIEW_BANNER_90(6),
    WEBVIEW_BANNER_250(7),
    WEBVIEW_INTERSTITIAL_UNKNOWN(100),
    WEBVIEW_INTERSTITIAL_HORIZONTAL(101),
    WEBVIEW_INTERSTITIAL_VERTICAL(102),
    WEBVIEW_INTERSTITIAL_TABLET(103),
    NATIVE_UNKNOWN(200),
    REWARDED_VIDEO(400),
    NATIVE_250(201),
    INSTREAM_VIDEO(300);
    
    private final int f4974n;

    private ano(int i) {
        this.f4974n = i;
    }

    public int m6394a() {
        return this.f4974n;
    }
}
