package com.miui.player.provider;

import android.content.Context;
import com.miui.player.provider.PlayerStore.MiuiPlaylists;
import com.miui.player.util.Actions;
import java.util.Collection;
import java.util.HashSet;

public class KtvPlaylistCache {
    private static Object LOCK = new Object();
    private static PlaylistCacheHelper sCacheHelper;
    private static HashSet<Long> sLocalVodSuccess = new HashSet();
    private static HashSet<Long> sLocalVoding = new HashSet();
    private static HashSet<String> sOnlineVodSuccess = new HashSet();
    private static HashSet<String> sOnlineVoding = new HashSet();

    private static void initialize(Context context) {
        synchronized (MiuiPlaylists.EXTERNAL_URI) {
            synchronized (LOCK) {
                if (sCacheHelper == null) {
                    sCacheHelper = PlaylistCacheHelper.newInstance(context, "$my_ktv$", 1, Actions.ACTION_KTV_PLAYLIST_CHANGED);
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

    public static boolean isKtvPlaylistId(Context context, long playlistId) {
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

    public static long getPlaylistId(Context context) {
        initialize(context);
        return sCacheHelper.getPlaylistId(context);
    }

    public static int recoverCache(Context context, long[] validTrackIds) {
        return sCacheHelper.recoverCache(context, validTrackIds);
    }

    public static int onlineRemove(Context context, Collection<String> onlineIds) {
        return sCacheHelper.onlineRemove(context, onlineIds);
    }

    public static int remove(Context context, long[] audioIds) {
        return sCacheHelper.remove(context, audioIds);
    }

    public static void addToVoding(Context context, long id, String onlineId) {
        if (onlineId == null && PlayerProvider.isOnlineAudio(id)) {
            onlineId = PlayerProviderUtils.getOnlineId(context, id, null);
        }
        if (onlineId != null) {
            sOnlineVoding.add(onlineId);
        } else {
            sLocalVoding.add(Long.valueOf(id));
        }
    }

    public static void removeFromVoding(Context context, long id, String onlineId) {
        if (onlineId == null && PlayerProvider.isOnlineAudio(id)) {
            onlineId = PlayerProviderUtils.getOnlineId(context, id, null);
        }
        if (onlineId != null) {
            sOnlineVoding.remove(onlineId);
        } else {
            sLocalVoding.remove(Long.valueOf(id));
        }
    }

    public static boolean vodingContains(Context context, long id, String onlineId) {
        if (onlineId == null && PlayerProvider.isOnlineAudio(id)) {
            onlineId = PlayerProviderUtils.getOnlineId(context, id, null);
        }
        if (onlineId != null) {
            return vodingOnlineContains(onlineId);
        }
        return vodingLocalContains(id);
    }

    public static boolean vodingLocalContains(long localId) {
        return sLocalVoding.contains(Long.valueOf(localId));
    }

    public static boolean vodingOnlineContains(String onlineId) {
        return sOnlineVoding.contains(onlineId);
    }

    public static void addToVodSuccess(Context context, long id, String onlineId) {
        if (onlineId == null && PlayerProvider.isOnlineAudio(id)) {
            onlineId = PlayerProviderUtils.getOnlineId(context, id, null);
        }
        if (onlineId != null) {
            sOnlineVodSuccess.add(onlineId);
        } else {
            sLocalVodSuccess.add(Long.valueOf(id));
        }
    }

    public static void removeFromVodSuccess(Context context, long id, String onlineId) {
        if (onlineId == null && PlayerProvider.isOnlineAudio(id)) {
            onlineId = PlayerProviderUtils.getOnlineId(context, id, null);
        }
        if (onlineId != null) {
            sOnlineVodSuccess.remove(onlineId);
        } else {
            sLocalVodSuccess.remove(Long.valueOf(id));
        }
    }

    public static void removeAllFromVodSuccess() {
        sLocalVodSuccess.clear();
        sOnlineVodSuccess.clear();
    }

    public static boolean vodSuccessContains(Context context, long id, String onlineId) {
        if (onlineId == null && PlayerProvider.isOnlineAudio(id)) {
            onlineId = PlayerProviderUtils.getOnlineId(context, id, null);
        }
        if (onlineId != null) {
            return vodSuccessOnlineContains(onlineId);
        }
        return vodSuccessLocalContains(id);
    }

    public static boolean vodSuccessLocalContains(long localId) {
        return sLocalVodSuccess.contains(Long.valueOf(localId));
    }

    public static boolean vodSuccessOnlineContains(String onlineId) {
        return sOnlineVodSuccess.contains(onlineId);
    }
}
