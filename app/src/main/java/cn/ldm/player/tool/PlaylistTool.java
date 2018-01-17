package cn.ldm.player.tool;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadata;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.BaseColumns;
import android.provider.MediaStore;
import android.widget.Toast;

import java.util.List;

import static cn.ldm.player.tool.ToolConfig.*;

import cn.ldm.player.R;
import cn.ldm.player.loader.PlaylistLoader;

/**
 * 播放列表工具类
 */
public class PlaylistTool {

    private static ContentValues[] mContentValuesCache = null;

    /**
     * 创建一个播放列表
     *
     * @param context
     * @param name    播放列表的名称
     * @return
     */
    public static long createPlaylist(final Context context, final String name) {
        if (name != null && name.length() > 0) {
            final ContentResolver resolver = context.getContentResolver();
            Cursor cursor = resolver.query(
                    MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI,
                    new String[]{MediaStore.Audio.PlaylistsColumns.NAME},
                    MediaStore.Audio.PlaylistsColumns.NAME + "='?'",
                    new String[]{name},
                    null);
            if (cursor.getCount() <= 0) {
                final ContentValues values = new ContentValues(1);
                values.put(MediaStore.Audio.PlaylistsColumns.NAME, name);
                final Uri uri = resolver.insert(MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI, values);
                return Long.parseLong(uri.getLastPathSegment());
            }
            if (cursor != null) {
                cursor.close();
                cursor = null;
            }
            return -1;
        }
        return -1;
    }

    /**
     * 清空播放列表
     *
     * @param context
     * @param playlistId
     */
    public static void clearPlaylist(final Context context, final int playlistId) {
        final Uri uri = MediaStore.Audio.Playlists.Members.getContentUri(VOLUME_EXTERNAL, playlistId);
        context.getContentResolver().delete(uri, null, null);
        return;
    }

    /**
     * 获取播放列表的id
     *
     * @param context
     * @param name
     * @return
     */
    public static final long getIdForPlaylist(final Context context, final String name) {
        Cursor cursor = context.getContentResolver().query(
                MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI,
                new String[]{BaseColumns._ID},
                MediaStore.Audio.PlaylistsColumns.NAME + "=?",
                new String[]{name},
                MediaStore.Audio.PlaylistsColumns.NAME);
        int id = -1;
        if (cursor != null) {
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                id = cursor.getInt(0);
            }
            cursor.close();
            cursor = null;
        }
        return id;
    }

    /**
     * 添加到播放列表
     *
     * @param context
     * @param ids        歌曲的id集合
     * @param playlistId 要添加到的播放列表的id
     */
    public static void addToPlaylist(final Context context, final long[] ids, final long playlistId) {
        final ContentResolver resolver = context.getContentResolver();
        final String[] projection = new String[]{"max(" + MediaStore.Audio.Playlists.Members.PLAY_ORDER + ")",};
        final Uri uri = MediaStore.Audio.Playlists.Members.getContentUri(VOLUME_EXTERNAL, playlistId);
        Cursor cursor = null;
        int base = 0;

        try {
            cursor = resolver.query(uri, projection, null, null, null);

            if (cursor != null && cursor.moveToFirst()) {
                base = cursor.getInt(0) + 1;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
                cursor = null;
            }
        }

        int numinserted = 0;
        for (int offSet = 0; offSet < ids.length; offSet += 1000) {
            makeInsertItems(ids, offSet, 1000, base);
            numinserted += resolver.bulkInsert(uri, mContentValuesCache);
        }
        playlistChanged();
    }

    public static void makeInsertItems(final long[] ids, final int offset, int len, final int base) {
        if (offset + len > ids.length) {
            len = ids.length - offset;
        }

        if (mContentValuesCache == null || mContentValuesCache.length != len) {
            mContentValuesCache = new ContentValues[len];
        }
        for (int i = 0; i < len; i++) {
            if (mContentValuesCache[i] == null) {
                mContentValuesCache[i] = new ContentValues();
            }
            mContentValuesCache[i].put(MediaStore.Audio.Playlists.Members.PLAY_ORDER, base + offset + i);
            mContentValuesCache[i].put(MediaStore.Audio.Playlists.Members.AUDIO_ID, ids[offset + i]);
        }
    }

    /**
     * 当其中一个播放列表发生变化时调用。
     */
    public static void playlistChanged() {
    }



}
