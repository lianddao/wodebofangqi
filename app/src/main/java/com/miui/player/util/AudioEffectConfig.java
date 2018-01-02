package com.miui.player.util;

import android.content.Context;
import com.miui.player.ui.base.ApplicationHelper;
import miui.os.Build;

public class AudioEffectConfig {
    public static boolean supportDolby(Context context) {
        return ApplicationHelper.instance().getDeviceCompat().supportDolby(context);
    }

    public static boolean isAndroidEqualizerEnabled() {
        if (Build.IS_MIONE) {
            return true;
        }
        if (Build.IS_XIAOMI || Build.IS_HONGMI) {
            return false;
        }
        return true;
    }
}
