package com.ushareit.listenit;

import com.mopub.common.util.DeviceUtils.ForceOrientation;

public /* synthetic */ class ejv {
    public static final /* synthetic */ int[] f11156a = new int[ForceOrientation.values().length];

    static {
        try {
            f11156a[ForceOrientation.FORCE_PORTRAIT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f11156a[ForceOrientation.FORCE_LANDSCAPE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f11156a[ForceOrientation.DEVICE_ORIENTATION.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f11156a[ForceOrientation.UNDEFINED.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
