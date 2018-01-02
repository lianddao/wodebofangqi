package com.miui.player.provider;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.miui.player.provider.PlayerStore.MiuiPlaylists.Members;
import com.miui.player.provider.PlayerStore.MiuiPlaylistsAudioMap;
import com.miui.player.util.SqlUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PlaylistCacheHelper {
    private static final String TAG = PlaylistCacheHelper.class.getCanonicalName();
    private final String mActionChanged;
    private final int mListType;
    private HashSet<Long> mLocalTracks = null;
    private HashSet<String> mOnlineTracks = null;
    private long mPlaylistId = -1;
    private final String mPlaylistName;

    public static PlaylistCacheHelper newInstance(Context context, String playlistName, int listType, String actionChanged) {
        return new PlaylistCacheHelper(context, playlistName, listType, actionChanged);
    }

    private PlaylistCacheHelper(Context context, String playlistName, int listType, String actionChanged) {
        this.mPlaylistName = playlistName;
        this.mListType = listType;
        this.mActionChanged = actionChanged;
        initialize(context);
    }

    private void initialize(Context context) {
        if (this.mPlaylistId < 0) {
            Uri uri = PlaylistHelper.createPlaylist(context, null, this.mPlaylistName, this.mListType);
            if (uri == null) {
                Log.e(TAG, "create playlist failed");
                return;
            }
            long id = ContentUris.parseId(uri);
            HashSet<Long> localSet = new HashSet();
            HashSet<String> onlineSet = new HashSet();
            String where = "mi_sync_track_state!=?";
            Context context2 = context;
            Cursor cursor = SqlUtils.query(context2, Members.getMembersUri(id), new String[]{"audio_id", "mi_online_id"}, "mi_sync_track_state!=?", new String[]{String.valueOf(1)}, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    long audioId = cursor.getLong(0);
                    if (PlayerProvider.isOnlineAudio(audioId)) {
                        onlineSet.add(cursor.getString(1));
                    } else {
                        try {
                            localSet.add(Long.valueOf(audioId));
                        } finally {
                            cursor.close();
                        }
                    }
                }
            }
            synchronized (PlaylistCacheHelper.class) {
                this.mPlaylistId = id;
                this.mLocalTracks = localSet;
                this.mOnlineTracks = onlineSet;
            }
        }
    }

    public int size(Context context) {
        initialize(context);
        Set<Long> localTracks = this.mLocalTracks;
        Set<String> onlineTracks = this.mOnlineTracks;
        if (localTracks == null || onlineTracks == null) {
            return 0;
        }
        return localTracks.size() + onlineTracks.size();
    }

    public void refreshSize(Context context) {
        Uri uri = PlaylistHelper.createPlaylist(context, null, this.mPlaylistName, this.mListType);
        if (uri == null) {
            Log.e(TAG, "create playlist failed");
            return;
        }
        long id = ContentUris.parseId(uri);
        HashSet<Long> localSet = new HashSet();
        HashSet<String> onlineSet = new HashSet();
        String where = "mi_sync_track_state!=?";
        Context context2 = context;
        Cursor cursor = SqlUtils.query(context2, Members.getMembersUri(id), new String[]{"audio_id", "mi_online_id"}, "mi_sync_track_state!=?", new String[]{String.valueOf(1)}, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    long audioId = cursor.getLong(0);
                    if (PlayerProvider.isOnlineAudio(audioId)) {
                        onlineSet.add(cursor.getString(1));
                    } else {
                        localSet.add(Long.valueOf(audioId));
                    }
                } finally {
                    cursor.close();
                }
            }
        }
        synchronized (PlaylistCacheHelper.class) {
            this.mPlaylistId = id;
            this.mLocalTracks = localSet;
            this.mOnlineTracks = onlineSet;
        }
    }

    public boolean equals(Context context, long playlistId) {
        initialize(context);
        return this.mPlaylistId == playlistId;
    }

    public int add(Context context, long[] ids) {
        initialize(context);
        int addNum = 0;
        Set<Long> localTracks = this.mLocalTracks;
        if (localTracks != null) {
            for (long id : ids) {
                if (!PlayerProvider.isOnlineAudio(id) && localTracks.add(Long.valueOf(id))) {
                    addNum++;
                }
            }
        }
        if (addNum != 0) {
            onCacheChange(context);
        }
        return addNum;
    }

    public int add(Context context, String[] onlineIds) {
        initialize(context);
        Set<String> onlineTracks = this.mOnlineTracks;
        int addNum = 0;
        if (onlineTracks != null) {
            for (String id : onlineIds) {
                if (onlineTracks.add(id)) {
                    addNum++;
                }
            }
        }
        if (addNum != 0) {
            onCacheChange(context);
        }
        return addNum;
    }

    public void add(Context context, String onlineId) {
        add(context, new String[]{onlineId});
    }

    public boolean contains(Context context, long id, String onlineId) {
        initialize(context);
        if (id >= 0 && !PlayerProvider.isOnlineAudio(id)) {
            return localContains(context, id);
        }
        if (TextUtils.isEmpty(onlineId)) {
            return onlineContains(context, PlayerProviderUtils.getOnlineId(context, id, null));
        }
        return onlineContains(context, onlineId);
    }

    public boolean localContains(Context context, long localId) {
        initialize(context);
        return this.mLocalTracks != null && this.mLocalTracks.contains(Long.valueOf(localId));
    }

    public boolean onlineContains(Context context, String onlineId) {
        initialize(context);
        return this.mOnlineTracks != null && this.mOnlineTracks.contains(onlineId);
    }

    public long getPlaylistId(Context context) {
        return this.mPlaylistId;
    }

    public int recoverCache(Context context, long[] validTrackIds) {
        Set<Long> localSet = this.mLocalTracks;
        if (localSet == null) {
            return 0;
        }
        int oldSize = localSet.size();
        Iterator<Long> it = localSet.iterator();
        while (it.hasNext()) {
            if (Arrays.binarySearch(validTrackIds, ((Long) it.next()).longValue()) < 0) {
                it.remove();
            }
        }
        int change = oldSize - localSet.size();
        if (change == 0) {
            return change;
        }
        onCacheChange(context);
        return change;
    }

    public int onlineRemove(Context context, Collection<String> onlineIds) {
        Set<String> onlineSet = this.mOnlineTracks;
        if (onlineSet == null || onlineIds == null) {
            return 0;
        }
        int oldSize = onlineSet.size();
        onlineSet.removeAll(onlineIds);
        int change = oldSize - onlineSet.size();
        if (change == 0) {
            return change;
        }
        onCacheChange(context);
        return change;
    }

    public int remove(Context context, long[] audioIds) {
        Set<Long> localSet = this.mLocalTracks;
        Set onlineSet = this.mOnlineTracks;
        List<Long> onlineList = new ArrayList();
        if (localSet == null || onlineSet == null) {
            return 0;
        }
        int oldSize = size(context);
        for (long id : audioIds) {
            if (PlayerProvider.isOnlineAudio(id)) {
                onlineList.add(Long.valueOf(id));
            } else {
                localSet.remove(Long.valueOf(id));
            }
        }
        if (onlineList.size() > 0) {
            Cursor cursor = SqlUtils.query(context, MiuiPlaylistsAudioMap.EXTERNAL_URI, new String[]{"mi_online_id"}, "audio_id IN " + SqlUtils.concatNumberAsSet(onlineList), null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        onlineSet.remove(cursor.getString(0));
                    } finally {
                        cursor.close();
                    }
                }
            }
        }
        int change = oldSize - size(context);
        if (change == 0) {
            return change;
        }
        onCacheChange(context);
        return change;
    }

    private void onCacheChange(Context context) {
        context.sendBroadcast(new Intent(this.mActionChanged));
    }
}
