package com.miui.player.provider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.provider.MediaStore.Audio.Media;
import android.text.TextUtils;
import com.google.android.collect.Lists;
import com.miui.player.cloud.MusicSyncAdapter;
import com.miui.player.meta.Audio;
import com.miui.player.provider.PlayerStore.MiuiPlaylists;
import com.miui.player.provider.PlayerStore.MiuiPlaylists.Columns;
import com.miui.player.provider.PlayerStore.MiuiPlaylists.Members;
import com.miui.player.provider.PlayerStore.MiuiPlaylistsAudioMap;
import com.miui.player.service.HistoryManager;
import com.miui.player.ui.UIHelper;
import com.miui.player.util.CollectionHelper;
import com.miui.player.util.CollectionHelper.Predication;
import com.miui.player.util.SqlUtils;
import com.miui.player.util.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PlaylistHelper {
    private static final Object LOCK_CACHE = new Object();
    public static final List<Integer> ONLINE_PLAYLIST_TYPES = Lists.newArrayList();
    public static final String PLAYLIST_FAVORITE = "favorite";
    public static final String PLAYLIST_NOWPLAYING = "nowplaying";
    public static final String PLAYLIST_RECENTLY_ADDED = "recentlyAdded";
    public static final String PLAYLIST_RECENTLY_PLAYED = "recentlyPlayed";
    public static final String PLAYLSIT_FREQUENTLY_PLAYED = "frequentlyPlayed";
    public static final int SYSTEM_PLAYLIST_COUNT = 4;
    private static final String TAG = PlaylistHelper.class.getCanonicalName();
    private static Map<Long, Integer> sOnlinePlaylistCache;

    private static class StringPredication implements Predication<Audio> {
        private final Collection<String> mRefCollection;

        public StringPredication(Collection<String> ref) {
            this.mRefCollection = ref;
        }

        public boolean predicate(Audio v) {
            return !this.mRefCollection.contains(v.getId());
        }
    }

    static {
        ONLINE_PLAYLIST_TYPES.add(Integer.valueOf(103));
        ONLINE_PLAYLIST_TYPES.add(Integer.valueOf(102));
        ONLINE_PLAYLIST_TYPES.add(Integer.valueOf(101));
    }

    public static Uri createPlaylist(Context context, String onlineId, String name, int type) {
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        Uri uri;
        synchronized (MiuiPlaylists.EXTERNAL_URI) {
            int id = queryPlaylistId(context, name, type);
            if (id >= 0) {
                uri = ContentUris.withAppendedId(MiuiPlaylists.EXTERNAL_URI, (long) id);
            } else {
                ContentValues values = new ContentValues(1);
                values.put("name", name);
                if (!TextUtils.isEmpty(onlineId)) {
                    values.put(Columns.MI_ONLINE_LIST_ID, onlineId);
                }
                values.put("list_type", Integer.valueOf(type));
                uri = SqlUtils.insert(context, MiuiPlaylists.EXTERNAL_URI, values);
                if (isOnlinePlaylist(type)) {
                    addToOnlinePlaylistCache(context, (long) queryPlaylistId(context, name, type), type);
                }
            }
        }
        MusicSyncAdapter.requestSync(context);
        return uri;
    }

    public static String queryPlaylistName(Context context, long plid) {
        String name = null;
        String[] cols = new String[]{"name"};
        Cursor cursor = SqlUtils.query(context, ContentUris.withAppendedId(MiuiPlaylists.EXTERNAL_URI, plid), cols, null, null, null);
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    name = cursor.getString(0);
                }
                cursor.close();
            } catch (Throwable th) {
                cursor.close();
            }
        }
        return name;
    }

    public static int queryPlaylistId(Context context, String name, int type) {
        return queryPlaylistId(context, name, new long[]{(long) type});
    }

    private static int queryPlaylistId(Context context, String name, long[] types) {
        Context context2 = context;
        Cursor c = SqlUtils.query(context2, MiuiPlaylists.EXTERNAL_URI, new String[]{"_id"}, String.format("%s = ? AND %s in %s AND %s != ?", new Object[]{"name", "list_type", SqlUtils.concatAsSet(types), "mi_sync_playlist_state"}), new String[]{name, String.valueOf(1)}, "name");
        int id = -1;
        if (c != null) {
            try {
                if (c.moveToNext()) {
                    id = c.getInt(0);
                }
                c.close();
            } catch (Throwable th) {
                c.close();
            }
        }
        return id;
    }

    private static long[] getOnlineAddAudioList(long[] addAudioIdList, Uri uri, Context context) {
        String onlineIdCol = "mi_online_id";
        String audioIdCol = "audio_id";
        String where = "mi_sync_track_state!=?";
        String[] args = new String[]{String.valueOf(1)};
        Cursor cursor = context.getContentResolver().query(uri, new String[]{"mi_online_id"}, "mi_online_id IS NOT NULL AND " + where, args, "mi_online_id");
        String[] existOnlineIdlist = null;
        if (cursor != null) {
            existOnlineIdlist = SqlUtils.getStringsForCursor(cursor, cursor.getColumnIndexOrThrow("mi_online_id"));
            cursor.close();
        }
        if (existOnlineIdlist == null || existOnlineIdlist.length == 0) {
            return addAudioIdList;
        }
        cursor = context.getContentResolver().query(MiuiPlaylistsAudioMap.EXTERNAL_URI, new String[]{"mi_online_id", "audio_id"}, "audio_id IN " + SqlUtils.concatAsSet(addAudioIdList) + " AND " + where, args, "audio_id");
        long[] existAudioIdlist = null;
        int size = 0;
        if (cursor != null) {
            int onlineIdIndex = cursor.getColumnIndex("mi_online_id");
            int audioIdIndex = cursor.getColumnIndex("audio_id");
            existAudioIdlist = new long[cursor.getCount()];
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String id = cursor.getString(onlineIdIndex);
                if (id != null && Arrays.binarySearch(existOnlineIdlist, id) >= 0) {
                    int size2 = size + 1;
                    existAudioIdlist[size] = cursor.getLong(audioIdIndex);
                    size = size2;
                }
                cursor.moveToNext();
            }
            cursor.close();
        }
        return (existAudioIdlist == null || existAudioIdlist.length == 0) ? addAudioIdList : SqlUtils.differenceSet(Arrays.copyOf(existAudioIdlist, size), addAudioIdList);
    }

    private static long[] getLocalAddAudioList(long[] addAudioIdList, Uri uri, Context context) {
        String[] cols = new String[]{"audio_id"};
        long[] existAudioIdList = null;
        Cursor cursor = SqlUtils.query(context, uri, cols, "mi_sync_track_state!=?", new String[]{String.valueOf(1)}, "audio_id");
        if (cursor != null) {
            try {
                existAudioIdList = SqlUtils.getIdsForCursor(cursor, cursor.getColumnIndex(cols[0]));
            } finally {
                cursor.close();
            }
        }
        return (existAudioIdList == null || existAudioIdList.length == 0) ? addAudioIdList : SqlUtils.differenceSet(existAudioIdList, addAudioIdList);
    }

    public static int addToPlaylist(Context context, long[] ids, long playlistId, boolean notify) {
        return addToPlaylist(context, ids, playlistId, true, notify);
    }

    public static int addToPlaylist(Context context, long[] ids, long playlistId, boolean filterDuplicate, boolean notify) {
        int added = addToPlaylistInternal(context, ids, playlistId, filterDuplicate);
        if (notify) {
            UIHelper.notifyAddToPlaylist(context, playlistId, added);
        }
        return added;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int addToPlaylistInternal(Context r15, long[] r16, long r17, boolean r19) {
        /*
        if (r16 == 0) goto L_0x0007;
    L_0x0002:
        r0 = r16;
        r13 = r0.length;
        if (r13 != 0) goto L_0x0009;
    L_0x0007:
        r13 = 0;
    L_0x0008:
        return r13;
    L_0x0009:
        r14 = com.miui.player.provider.PlayerStore.MiuiPlaylistsAudioMap.EXTERNAL_URI;
        monitor-enter(r14);
        r11 = com.miui.player.provider.PlayerStore.MiuiPlaylists.Members.getMembersUri(r17);	 Catch:{ all -> 0x0021 }
        r5 = com.miui.player.util.SqlUtils.getRecordCount(r15, r11);	 Catch:{ all -> 0x0021 }
        if (r19 == 0) goto L_0x002f;
    L_0x0016:
        r0 = r16;
        r16 = getLocalAddAudioList(r0, r11, r15);	 Catch:{ all -> 0x0021 }
        if (r16 != 0) goto L_0x0024;
    L_0x001e:
        r13 = 0;
        monitor-exit(r14);	 Catch:{ all -> 0x0021 }
        goto L_0x0008;
    L_0x0021:
        r13 = move-exception;
        monitor-exit(r14);	 Catch:{ all -> 0x0021 }
        throw r13;
    L_0x0024:
        r0 = r16;
        r16 = getOnlineAddAudioList(r0, r11, r15);	 Catch:{ all -> 0x0021 }
        if (r16 != 0) goto L_0x002f;
    L_0x002c:
        r13 = 0;
        monitor-exit(r14);	 Catch:{ all -> 0x0021 }
        goto L_0x0008;
    L_0x002f:
        r0 = r16;
        r12 = com.miui.player.provider.PlayerProviderUtils.createMemberInfoById(r15, r0, r5);	 Catch:{ all -> 0x0021 }
        if (r12 != 0) goto L_0x003a;
    L_0x0037:
        r13 = 0;
        monitor-exit(r14);	 Catch:{ all -> 0x0021 }
        goto L_0x0008;
    L_0x003a:
        r13 = com.miui.player.util.SqlUtils.bulkInsert(r15, r11, r12);	 Catch:{ all -> 0x0021 }
        if (r13 <= 0) goto L_0x0043;
    L_0x0040:
        com.miui.player.cloud.MusicSyncAdapter.requestSync(r15);	 Catch:{ all -> 0x0021 }
    L_0x0043:
        monitor-exit(r14);	 Catch:{ all -> 0x0021 }
        r0 = r17;
        r13 = com.miui.player.provider.FavoriteCache.isFavoritePlaylistId(r15, r0);
        if (r13 == 0) goto L_0x008d;
    L_0x004c:
        r13 = com.miui.player.provider.FavoriteCache.add(r15, r16);
        r0 = r16;
        r14 = r0.length;
        if (r13 >= r14) goto L_0x006e;
    L_0x0055:
        r3 = r12;
        r8 = r3.length;
        r7 = 0;
    L_0x0058:
        if (r7 >= r8) goto L_0x006e;
    L_0x005a:
        r6 = r3[r7];
        r13 = "mi_online_id";
        r9 = r6.getAsString(r13);
        r13 = android.text.TextUtils.isEmpty(r9);
        if (r13 != 0) goto L_0x006b;
    L_0x0068:
        com.miui.player.provider.FavoriteCache.add(r15, r9);
    L_0x006b:
        r7 = r7 + 1;
        goto L_0x0058;
    L_0x006e:
        r3 = r12;
        r8 = r3.length;
        r7 = 0;
    L_0x0071:
        if (r7 >= r8) goto L_0x00b7;
    L_0x0073:
        r6 = r3[r7];
        r13 = "title";
        r10 = r6.getAsString(r13);
        r13 = "artist";
        r4 = r6.getAsString(r13);
        r13 = "album";
        r2 = r6.getAsString(r13);
        com.miui.player.network.StatHelper.uploadFavoriteTrack(r10, r4, r2);
        r7 = r7 + 1;
        goto L_0x0071;
    L_0x008d:
        r0 = r17;
        r13 = com.miui.player.provider.KtvPlaylistCache.isKtvPlaylistId(r15, r0);
        if (r13 == 0) goto L_0x00b7;
    L_0x0095:
        r13 = com.miui.player.provider.KtvPlaylistCache.add(r15, r16);
        r0 = r16;
        r14 = r0.length;
        if (r13 >= r14) goto L_0x00b7;
    L_0x009e:
        r3 = r12;
        r8 = r3.length;
        r7 = 0;
    L_0x00a1:
        if (r7 >= r8) goto L_0x00b7;
    L_0x00a3:
        r6 = r3[r7];
        r13 = "mi_online_id";
        r9 = r6.getAsString(r13);
        r13 = android.text.TextUtils.isEmpty(r9);
        if (r13 != 0) goto L_0x00b4;
    L_0x00b1:
        com.miui.player.provider.KtvPlaylistCache.add(r15, r9);
    L_0x00b4:
        r7 = r7 + 1;
        goto L_0x00a1;
    L_0x00b7:
        r13 = r12.length;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.player.provider.PlaylistHelper.addToPlaylistInternal(android.content.Context, long[], long, boolean):int");
    }

    public static void addToPlaylistAsync(Context context, long[] trackIds, long playlistId, boolean filterDuplicate, Runnable callback) {
        final Context context2 = context;
        final long[] jArr = trackIds;
        final long j = playlistId;
        final boolean z = filterDuplicate;
        final Runnable runnable = callback;
        new AsyncTask<Void, Void, Integer>() {
            protected Integer doInBackground(Void... params) {
                return Integer.valueOf(PlaylistHelper.addToPlaylist(context2, jArr, j, z, false));
            }

            protected void onPostExecute(Integer result) {
                UIHelper.notifyAddToPlaylist(context2, j, result.intValue());
                if (runnable != null) {
                    runnable.run();
                }
            }
        }.execute(new Void[0]);
    }

    public static List<String> getExistOnlineIdList(Context context, Uri uri) {
        String[] cols = new String[]{"mi_online_id"};
        String[] args = new String[]{String.valueOf(1)};
        Cursor cursor = context.getContentResolver().query(uri, cols, "mi_sync_track_state !=?", args, "mi_online_id");
        if (cursor == null) {
            return null;
        }
        String lastId = null;
        List<String> existOnlineIdList = new ArrayList();
        while (cursor.moveToNext()) {
            String onlineId = cursor.getString(0);
            if (!(onlineId == null || onlineId.equals(lastId))) {
                existOnlineIdList.add(onlineId);
                lastId = onlineId;
            }
        }
        cursor.close();
        return existOnlineIdList;
    }

    public static List<Audio> getDifferenceAudioList(Collection<Audio> audioList, Collection<String> exist) {
        List<Audio> to = new ArrayList();
        CollectionHelper.difference(audioList, to, new StringPredication(exist));
        return to;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void addOnlineToPlaylist(Context r22, List<Audio> r23, String r24, long r25, boolean r27, boolean r28) {
        /*
        r20 = com.miui.player.util.CollectionHelper.isEmpty(r23);
        if (r20 == 0) goto L_0x000e;
    L_0x0006:
        r20 = TAG;
        r21 = "ListSelection null";
        com.xiaomi.music.util.MusicLog.m395d(r20, r21);
    L_0x000d:
        return;
    L_0x000e:
        r21 = com.miui.player.provider.PlayerStore.MiuiPlaylistsAudioMap.EXTERNAL_URI;
        monitor-enter(r21);
        r18 = com.miui.player.provider.PlayerStore.MiuiPlaylists.Members.getMembersUri(r25);	 Catch:{ all -> 0x0042 }
        r0 = r22;
        r1 = r18;
        r7 = com.miui.player.util.SqlUtils.getRecordCount(r0, r1);	 Catch:{ all -> 0x0042 }
        r0 = r22;
        r1 = r18;
        r9 = getExistOnlineIdList(r0, r1);	 Catch:{ all -> 0x0042 }
        r0 = r23;
        r23 = getDifferenceAudioList(r0, r9);	 Catch:{ all -> 0x0042 }
        if (r27 == 0) goto L_0x003a;
    L_0x002d:
        r20 = r23.size();	 Catch:{ all -> 0x0042 }
        r0 = r22;
        r1 = r25;
        r3 = r20;
        com.miui.player.ui.UIHelper.notifyAddToPlaylist(r0, r1, r3);	 Catch:{ all -> 0x0042 }
    L_0x003a:
        r20 = r23.isEmpty();	 Catch:{ all -> 0x0042 }
        if (r20 == 0) goto L_0x0045;
    L_0x0040:
        monitor-exit(r21);	 Catch:{ all -> 0x0042 }
        goto L_0x000d;
    L_0x0042:
        r20 = move-exception;
        monitor-exit(r21);	 Catch:{ all -> 0x0042 }
        throw r20;
    L_0x0045:
        r0 = r22;
        r1 = r23;
        r2 = r24;
        r16 = com.miui.player.provider.PlayerProviderUtils.createMemberInfoByProviderId(r0, r1, r2, r7);	 Catch:{ all -> 0x0042 }
        r20 = r16.size();	 Catch:{ all -> 0x0042 }
        r0 = r20;
        r0 = new android.content.ContentValues[r0];	 Catch:{ all -> 0x0042 }
        r19 = r0;
        r0 = r16;
        r1 = r19;
        r0.toArray(r1);	 Catch:{ all -> 0x0042 }
        r0 = r22;
        r1 = r18;
        r2 = r19;
        r20 = com.miui.player.util.SqlUtils.bulkInsert(r0, r1, r2);	 Catch:{ all -> 0x0042 }
        if (r20 <= 0) goto L_0x006f;
    L_0x006c:
        com.miui.player.cloud.MusicSyncAdapter.requestSync(r22);	 Catch:{ all -> 0x0042 }
    L_0x006f:
        r0 = r22;
        r1 = r25;
        r20 = com.miui.player.provider.FavoriteCache.isFavoritePlaylistId(r0, r1);	 Catch:{ all -> 0x0042 }
        if (r20 == 0) goto L_0x00cc;
    L_0x0079:
        r20 = r23.size();	 Catch:{ all -> 0x0042 }
        r0 = r20;
        r15 = new java.lang.String[r0];	 Catch:{ all -> 0x0042 }
        r10 = 0;
        r12 = r23.iterator();	 Catch:{ all -> 0x0042 }
        r11 = r10;
    L_0x0087:
        r20 = r12.hasNext();	 Catch:{ all -> 0x0042 }
        if (r20 == 0) goto L_0x009d;
    L_0x008d:
        r13 = r12.next();	 Catch:{ all -> 0x0042 }
        r13 = (com.miui.player.meta.Audio) r13;	 Catch:{ all -> 0x0042 }
        r10 = r11 + 1;
        r20 = r13.getId();	 Catch:{ all -> 0x0042 }
        r15[r11] = r20;	 Catch:{ all -> 0x0042 }
        r11 = r10;
        goto L_0x0087;
    L_0x009d:
        r0 = r22;
        com.miui.player.provider.FavoriteCache.add(r0, r15);	 Catch:{ all -> 0x0042 }
        if (r28 == 0) goto L_0x00ff;
    L_0x00a4:
        r5 = r19;
        r14 = r5.length;	 Catch:{ all -> 0x0042 }
        r12 = 0;
    L_0x00a8:
        if (r12 >= r14) goto L_0x00ff;
    L_0x00aa:
        r8 = r5[r12];	 Catch:{ all -> 0x0042 }
        r20 = "title";
        r0 = r20;
        r17 = r8.getAsString(r0);	 Catch:{ all -> 0x0042 }
        r20 = "artist";
        r0 = r20;
        r6 = r8.getAsString(r0);	 Catch:{ all -> 0x0042 }
        r20 = "album";
        r0 = r20;
        r4 = r8.getAsString(r0);	 Catch:{ all -> 0x0042 }
        r0 = r17;
        com.miui.player.network.StatHelper.uploadFavoriteTrack(r0, r6, r4);	 Catch:{ all -> 0x0042 }
        r12 = r12 + 1;
        goto L_0x00a8;
    L_0x00cc:
        r0 = r22;
        r1 = r25;
        r20 = com.miui.player.provider.KtvPlaylistCache.isKtvPlaylistId(r0, r1);	 Catch:{ all -> 0x0042 }
        if (r20 == 0) goto L_0x00ff;
    L_0x00d6:
        r20 = r23.size();	 Catch:{ all -> 0x0042 }
        r0 = r20;
        r15 = new java.lang.String[r0];	 Catch:{ all -> 0x0042 }
        r10 = 0;
        r12 = r23.iterator();	 Catch:{ all -> 0x0042 }
        r11 = r10;
    L_0x00e4:
        r20 = r12.hasNext();	 Catch:{ all -> 0x0042 }
        if (r20 == 0) goto L_0x00fa;
    L_0x00ea:
        r13 = r12.next();	 Catch:{ all -> 0x0042 }
        r13 = (com.miui.player.meta.Audio) r13;	 Catch:{ all -> 0x0042 }
        r10 = r11 + 1;
        r20 = r13.getId();	 Catch:{ all -> 0x0042 }
        r15[r11] = r20;	 Catch:{ all -> 0x0042 }
        r11 = r10;
        goto L_0x00e4;
    L_0x00fa:
        r0 = r22;
        com.miui.player.provider.KtvPlaylistCache.add(r0, r15);	 Catch:{ all -> 0x0042 }
    L_0x00ff:
        monitor-exit(r21);	 Catch:{ all -> 0x0042 }
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.player.provider.PlaylistHelper.addOnlineToPlaylist(android.content.Context, java.util.List, java.lang.String, long, boolean, boolean):void");
    }

    public static void addOnlineToPlaylist(Context context, List<Audio> audioList, String provider, long playlistId) {
        addOnlineToPlaylist(context, audioList, provider, playlistId, true, true);
    }

    public static int removeMembers(Context context, long[] audioIds, long playlistId) {
        return removeMembers(context, audioIds, playlistId, true);
    }

    public static int removeMembers(Context context, long[] audioIds, long playlistId, boolean notify) {
        int removed;
        synchronized (MiuiPlaylistsAudioMap.EXTERNAL_URI) {
            if (FavoriteCache.isFavoritePlaylistId(context, playlistId)) {
                FavoriteCache.remove(context, audioIds);
            } else if (KtvPlaylistCache.isKtvPlaylistId(context, playlistId)) {
                KtvPlaylistCache.remove(context, audioIds);
            }
            removed = PlayerProviderUtils.removeMembersFromDB(context, playlistId, audioIds);
            if (notify) {
                UIHelper.notifyRemoveFromPlaylist(context, playlistId, removed);
            }
            if (removed > 0) {
                MusicSyncAdapter.requestSync(context);
            }
        }
        return removed;
    }

    public static int removeOnlineMembers(Context context, Collection<String> onlineIds, String provider, long playlistId) {
        return removeOnlineMembers(context, onlineIds, provider, playlistId, true);
    }

    public static int removeOnlineMembers(Context context, Collection<String> onlineIds, String provider, long playlistId, boolean notify) {
        int removed;
        synchronized (MiuiPlaylistsAudioMap.EXTERNAL_URI) {
            if (FavoriteCache.isFavoritePlaylistId(context, playlistId)) {
                FavoriteCache.onlineRemove(context, onlineIds);
            } else if (KtvPlaylistCache.isKtvPlaylistId(context, playlistId)) {
                KtvPlaylistCache.onlineRemove(context, onlineIds);
            }
            removed = PlayerProviderUtils.removeOnlineMembersFromDB(context, playlistId, onlineIds, provider);
            if (notify) {
                UIHelper.notifyRemoveFromPlaylist(context, playlistId, removed);
            }
            if (removed > 0) {
                MusicSyncAdapter.requestSync(context);
            }
        }
        return removed;
    }

    public static long[] getLocalTrackListForPlaylist(Context context, long plid) {
        return getTrackListForPlaylist(context, plid, "audio_id<536870911" + " AND mi_sync_track_state!=1");
    }

    public static long[] getTrackListForPlaylist(Context context, long plid, String where) {
        String[] ccols = new String[]{"audio_id"};
        Cursor cursor = SqlUtils.query(context, Members.getMembersUri(plid), ccols, where, null, Members.DEFAULT_SORT_ORDER);
        if (cursor == null) {
            return Utils.LONG_EMPTY_ARRAY;
        }
        try {
            long[] idsForCursor = SqlUtils.getIdsForCursor(cursor, cursor.getColumnIndex(ccols[0]));
            return idsForCursor;
        } finally {
            cursor.close();
        }
    }

    public static int getPlaylistCount(Context context) {
        String AND = " AND ";
        String[] cols = new String[]{"count(*)"};
        StringBuilder where = new StringBuilder();
        where.append("name");
        where.append(" != ''");
        where.append(" AND ");
        where.append("list_type");
        where.append(" == ");
        where.append(0);
        int count = 4;
        Cursor cursor = SqlUtils.query(context, MiuiPlaylists.EXTERNAL_URI, cols, where.toString(), null, "name");
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                count = 4 + cursor.getInt(0);
            }
            cursor.close();
        }
        return count;
    }

    public static Set<String> queryAllPlaylistNameSet(Context context) {
        Context context2 = context;
        Cursor cursor = SqlUtils.query(context2, MiuiPlaylists.EXTERNAL_URI, new String[]{"name"}, "mi_sync_playlist_state != ?", new String[]{String.valueOf(1)}, null);
        if (cursor == null) {
            return new HashSet(0);
        }
        try {
            Set<String> hashSet = new HashSet(cursor.getCount());
            while (cursor.moveToNext()) {
                hashSet.add(cursor.getString(0));
            }
            return hashSet;
        } finally {
            cursor.close();
        }
    }

    public static void deletePlaylist(Context context, long plid) {
        deletePlaylist(context, new long[]{plid});
    }

    public static void deletePlaylist(Context context, long[] plidlist) {
        synchronized (MiuiPlaylists.EXTERNAL_URI) {
            Uri uri = MiuiPlaylists.EXTERNAL_URI;
            String where = "_id IN " + SqlUtils.concatAsSet(plidlist);
            ContentValues values = new ContentValues(1);
            values.put("mi_sync_playlist_state", Integer.valueOf(1));
            context.getContentResolver().update(uri, values, where, null);
        }
        for (long playlistId : plidlist) {
            removeFromOnlinePlaylistCache(context, playlistId);
        }
        MusicSyncAdapter.requestSync(context);
    }

    public static String recentlyAddedWhere(Context context) {
        return "date_added>" + ((System.currentTimeMillis() / 1000) - (((long) PreferenceManager.getDefaultSharedPreferences(context).getInt("numweeks", 2)) * 604800));
    }

    public static int getRecentlyAddedTrackCount(Context context) {
        int count = 0;
        String[] cols = new String[]{"count(*)"};
        Cursor cursor = SqlUtils.query(context, Media.EXTERNAL_CONTENT_URI, cols, SqlUtils.wrapWithBlacklist(context, recentlyAddedWhere(context)), null, null);
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    count = cursor.getInt(0);
                }
                cursor.close();
            } catch (Throwable th) {
                cursor.close();
            }
        }
        return count;
    }

    public static int getRecentlyPlayedTrackCount(Context context) {
        int c = 0;
        long[] last = HistoryManager.loadLatest(context);
        if (last != null) {
            for (long id : last) {
                if (!PlayerProvider.isOnlineAudio(id)) {
                    c++;
                }
            }
        }
        return c;
    }

    public static long queryAudioIdForMember(Context context, long memberId, long plid) {
        long audioId = -1;
        Cursor c = SqlUtils.query(context, Members.getMembersUri(plid), new String[]{"audio_id"}, ("_id = " + memberId) + " AND mi_sync_track_state!=1", null, null);
        if (c != null) {
            if (c.moveToFirst()) {
                audioId = (long) c.getInt(0);
            }
            c.close();
        }
        return audioId;
    }

    public static long queryMemberIdByAudio(Context context, long audioId, long plid) {
        long memberId = -1;
        Cursor c = SqlUtils.query(context, Members.getMembersUri(plid), new String[]{"_id"}, ("audio_id = " + audioId) + " AND mi_sync_track_state!=1", null, null);
        if (c != null) {
            if (c.moveToFirst()) {
                memberId = (long) c.getInt(0);
            }
            c.close();
        }
        return memberId;
    }

    private static void initOnlinePlaylistCache(Context context) {
        synchronized (LOCK_CACHE) {
            if (sOnlinePlaylistCache == null) {
                sOnlinePlaylistCache = new ConcurrentHashMap();
                Cursor cursor = SqlUtils.query(context, MiuiPlaylists.EXTERNAL_URI, new String[]{"_id", "list_type"}, "list_type IN " + SqlUtils.concatNumberAsSet(ONLINE_PLAYLIST_TYPES) + " AND " + "mi_sync_playlist_state" + "!=?", new String[]{String.valueOf(1)}, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            sOnlinePlaylistCache.put(Long.valueOf(cursor.getLong(0)), Integer.valueOf(cursor.getInt(1)));
                        } catch (Throwable th) {
                            cursor.close();
                        }
                    }
                    cursor.close();
                }
            }
        }
    }

    private static void addToOnlinePlaylistCache(Context context, long playlistId, int type) {
        initOnlinePlaylistCache(context);
        sOnlinePlaylistCache.put(Long.valueOf(playlistId), Integer.valueOf(type));
    }

    private static void removeFromOnlinePlaylistCache(Context context, long playlistId) {
        initOnlinePlaylistCache(context);
        sOnlinePlaylistCache.remove(Long.valueOf(playlistId));
    }

    public static int getOnlinePlaylistType(Context context, long playlistId) {
        initOnlinePlaylistCache(context);
        Integer type = (Integer) sOnlinePlaylistCache.get(Long.valueOf(playlistId));
        return type != null ? type.intValue() : -1;
    }

    public static boolean isOnlinePlaylist(int type) {
        return ONLINE_PLAYLIST_TYPES.indexOf(Integer.valueOf(type)) >= 0;
    }
}
