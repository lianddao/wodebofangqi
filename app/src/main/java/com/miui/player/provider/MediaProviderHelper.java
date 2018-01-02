package com.miui.player.provider;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Audio.Artists;
import android.provider.MediaStore.Audio.Artists.Albums;
import android.provider.MediaStore.Audio.Media;
import com.baidu.music.log.LogHelper;
import com.miui.player.provider.PlayerStore.OnlineAudioDetail.Columns;
import com.miui.player.util.SqlUtils;
import com.miui.player.util.Utils;
import miui.os.Environment;

public class MediaProviderHelper {
    public static final int NORMAL = 0;
    public static final int UNMOUNTED = 1;
    public static final int UNPREPARED = 2;

    public static int getTrackCount(Context context, long artistId) {
        String AND = " AND ";
        String[] cols = new String[]{"count(*)"};
        StringBuilder where = new StringBuilder();
        where.append("title");
        where.append(" != '' ");
        if (artistId >= 0) {
            where.append(" AND ");
            where.append(Columns.ARTIST_ID);
            where.append(LogHelper.SEPARATE_DOT);
            where.append(artistId);
        }
        Cursor cursor = SqlUtils.query(context, Media.EXTERNAL_CONTENT_URI, cols, SqlUtils.wrapWithBlacklist(context, where.toString()), null, "album_key");
        int count = 0;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                count = cursor.getInt(0);
            }
            cursor.close();
        }
        return count;
    }

    public static int getTrackCountByAlbumId(Context context, long albumId) {
        String AND = " AND ";
        String[] cols = new String[]{"count(*)"};
        StringBuilder where = new StringBuilder();
        where.append("title");
        where.append(" != '' ");
        if (albumId >= 0) {
            where.append(" AND ");
            where.append("album_id");
            where.append(LogHelper.SEPARATE_DOT);
            where.append(albumId);
        }
        Cursor cursor = SqlUtils.query(context, Media.EXTERNAL_CONTENT_URI, cols, SqlUtils.wrapWithBlacklist(context, where.toString()), null, "album_key");
        int count = 0;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                count = cursor.getInt(0);
            }
            cursor.close();
        }
        return count;
    }

    public static int getAlbumCount(Context context, long artistId) {
        String[] cols = new String[]{"_id"};
        Uri uri = artistId > 0 ? Albums.getContentUri("external", artistId) : Audio.Albums.EXTERNAL_CONTENT_URI;
        String inClause = null;
        Cursor c = queryValidAlbumIdCursor(context);
        if (c != null) {
            String albumSet = SqlUtils.concatIdsAsSet(c, 0);
            if (artistId >= 0) {
                inClause = " audio.album_id  IN " + albumSet;
            } else {
                inClause = "_id IN " + albumSet;
            }
            c.close();
        }
        c = SqlUtils.query(context, uri, cols, inClause, null, "album_key");
        if (c == null) {
            return 0;
        }
        int count = c.getCount();
        c.close();
        return count;
    }

    public static int getArtistCount(Context context) {
        Cursor cursor = queryValidArtistIdCursor(context);
        int count = 0;
        if (cursor != null) {
            String artistSet = SqlUtils.concatIdsAsSet(cursor, 0);
            cursor.close();
            String[] cols = new String[]{"count(*)"};
            StringBuilder where = new StringBuilder();
            where.append("artist != ''");
            where.append(" AND ");
            where.append("_id");
            where.append(" IN ");
            where.append(artistSet);
            Cursor c = SqlUtils.query(context, Artists.EXTERNAL_CONTENT_URI, cols, where.toString(), null, "artist_key");
            if (c != null) {
                if (c.moveToFirst()) {
                    count = c.getInt(0);
                }
                c.close();
            }
        }
        return count;
    }

    public static long[] queryValidArtistIdArr(Context context) {
        Cursor cursor = queryValidArtistIdCursor(context);
        try {
            long[] valueArrFromCursor = getValueArrFromCursor(cursor, 0);
            return valueArrFromCursor;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static Cursor queryValidAlbumIdCursor(Context context) {
        return SqlUtils.query(context, Media.EXTERNAL_CONTENT_URI, new String[]{"distinct album_id"}, SqlUtils.wrapWithBlacklist(context), null, "album_id");
    }

    public static long[] queryValidAlbumIdArr(Context context) {
        Cursor cursor = queryValidAlbumIdCursor(context);
        try {
            long[] valueArrFromCursor = getValueArrFromCursor(cursor, 0);
            return valueArrFromCursor;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static long[] queryValidTrackIdArr(Context context) {
        Context context2 = context;
        Cursor cursor = SqlUtils.query(context2, Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, SqlUtils.wrapWithBlacklist(context), null, "_id");
        try {
            long[] valueArrFromCursor = getValueArrFromCursor(cursor, 0);
            return valueArrFromCursor;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static Cursor queryValidArtistIdCursor(Context context) {
        return SqlUtils.query(context, Media.EXTERNAL_CONTENT_URI, new String[]{"distinct artist_id"}, SqlUtils.wrapWithBlacklist(context), null, Columns.ARTIST_ID);
    }

    private static long[] getValueArrFromCursor(Cursor c, int colIdx) {
        long[] ret = Utils.LONG_EMPTY_ARRAY;
        if (c != null) {
            ret = new long[c.getCount()];
            int i = 0;
            c.moveToFirst();
            while (!c.isAfterLast()) {
                ret[i] = c.getLong(colIdx);
                c.moveToNext();
                i++;
            }
        }
        return ret;
    }

    public static long[] queryTrackListForArtists(Context context, long[] artistIds) {
        if (artistIds == null || artistIds.length == 0) {
            return Utils.LONG_EMPTY_ARRAY;
        }
        String where;
        String[] ccols = new String[]{"_id"};
        if (artistIds.length == 1) {
            where = "artist_id=" + artistIds[0];
        } else {
            where = "artist_id IN " + SqlUtils.concatAsSet(artistIds);
        }
        Context context2 = context;
        Cursor cursor = SqlUtils.query(context2, Media.EXTERNAL_CONTENT_URI, ccols, SqlUtils.wrapWithBlacklist(context, where), null, String.format("%s,%s,%s", new Object[]{"artist_key", "album_key", "track"}));
        if (cursor == null) {
            return Utils.LONG_EMPTY_ARRAY;
        }
        try {
            long[] idsForCursor = SqlUtils.getIdsForCursor(cursor, PlayerProviderUtils.guessAudioIdColumnIndex(cursor));
            return idsForCursor;
        } finally {
            cursor.close();
        }
    }

    public static long[] queryTrackListForAlbums(Context context, long[] albumIds) {
        if (albumIds == null || albumIds.length == 0) {
            return Utils.LONG_EMPTY_ARRAY;
        }
        String where;
        String[] ccols = new String[]{"_id"};
        if (albumIds.length == 1) {
            where = String.format("%s = %d", new Object[]{"album_id", Long.valueOf(albumIds[0])});
        } else {
            where = "album_id IN " + SqlUtils.concatAsSet(albumIds);
        }
        Cursor cursor = SqlUtils.query(context, Media.EXTERNAL_CONTENT_URI, ccols, SqlUtils.wrapWithBlacklist(context, where), null, "track");
        if (cursor == null) {
            return Utils.LONG_EMPTY_ARRAY;
        }
        try {
            long[] idsForCursor = SqlUtils.getIdsForCursor(cursor, PlayerProviderUtils.guessAudioIdColumnIndex(cursor));
            return idsForCursor;
        } finally {
            cursor.close();
        }
    }

    public static int getStatus(Context context) {
        if (!Environment.isExternalStorageMounted()) {
            return 1;
        }
        boolean prepared;
        Cursor cursor = SqlUtils.query(context, Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, null, null, null, 1);
        if (cursor == null || !cursor.moveToFirst()) {
            prepared = false;
        } else {
            prepared = true;
        }
        if (cursor != null) {
            cursor.close();
        }
        return prepared ? 0 : 2;
    }
}
