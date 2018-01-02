package com.miui.player.provider;

import android.content.Context;
import com.miui.player.provider.PlayerStore.MiuiPlaylists;
import com.miui.player.util.Actions;
import java.util.Collection;

public class FavoriteCache {
    private static Object LOCK = new Object();
    private static PlaylistCacheHelper sCacheHelper;

    private static void initialize(Context context) {
        synchronized (MiuiPlaylists.EXTERNAL_URI) {
            synchronized (LOCK) {
                if (sCacheHelper == null) {
                    sCacheHelper = PlaylistCacheHelper.newInstance(context, "$miui$", 1, Actions.ACTION_FAVORITE_CHANGED);
                }
            }
        }
    }

    public static void reset() {
        synchronized (LOCK) {
            sCacheHelper = null;
        }
    }

    public static int size(Context context) {
        initialize(context);
        return sCacheHelper.size(context);
    }

    public static void refreshSize(Context context) {
        initialize(context);
        sCacheHelper.refreshSize(context);
    }

    public static boolean isFavoritePlaylistId(Context context, long playlistId) {
        initialize(context);
        return sCacheHelper.getPlaylistId(context) == playlistId;
    }

    public static int add(Context context, long[] ids) {
        initialize(context);
        return sCacheHelper.add(context, ids);
    }

    public static int add(Context context, String[] onlineIds) {
        initialize(context);
        return sCacheHelper.add(context, onlineIds);
    }

    public static void add(Context context, String onlineId) {
        add(context, new String[]{onlineId});
    }

    public static boolean contains(Context context, long id, String onlineId) {
        initialize(context);
        return sCacheHelper.contains(context, id, onlineId);
    }

    public static boolean localContains(Context context, long localId) {
        initialize(context);
        return sCacheHelper.localContains(context, localId);
    }

    public static boolean onlineContains(Context context, String onlineId) {
        initialize(context);
        return sCacheHelper.onlineContains(context, onlineId);
    }

    public static long getFavoritePlaylistId(Context context) {
        initialize(context);
        return sCacheHelper.getPlaylistId(context);
    }

    public static int recoverCache(Context context, long[] validTrackIds) {
        initialize(context);
        return sCacheHelper.recoverCache(context, validTrackIds);
    }

    public static int onlineRemove(Context context, Collection<String> onlineIds) {
        initialize(context);
        return sCacheHelper.onlineRemove(context, onlineIds);
    }

    public static int remove(Context context, long[] audioIds) {
        initialize(context);
        return sCacheHelper.remove(context, audioIds);
    }
}
