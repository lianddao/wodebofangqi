package com.ushareit.listenit;

import com.mopub.common.LocationService.ValidLocationProvider;

public /* synthetic */ class egu {
    public static final /* synthetic */ int[] f11053a = new int[ValidLocationProvider.values().length];

    static {
        try {
            f11053a[ValidLocationProvider.NETWORK.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f11053a[ValidLocationProvider.GPS.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
