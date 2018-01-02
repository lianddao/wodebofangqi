package com.miui.player.util;

import miui.os.Build;

public class CachePolicy {
    private static final int sLocalAlbumCacheSize;
    private static final int sLocalAvatarCacheSize;
    private static final int sOnlineBMCacheSize;

    static {
        if (Build.IS_MI2A || Build.IS_MITHREE) {
            sLocalAlbumCacheSize = 20;
            sLocalAvatarCacheSize = 20;
            sOnlineBMCacheSize = 20;
            return;
        }
        sLocalAlbumCacheSize = 100;
        sLocalAvatarCacheSize = 100;
        sOnlineBMCacheSize = 100;
    }

    public static int getLocalAlbumCacheSize() {
        return sLocalAlbumCacheSize;
    }

    public static int getLocalAvatarCacheSize() {
        return sLocalAvatarCacheSize;
    }

    public static int getOnlineBMCacheSize() {
        return sOnlineBMCacheSize;
    }
}
