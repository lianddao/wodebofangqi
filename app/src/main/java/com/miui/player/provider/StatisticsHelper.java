package com.miui.player.provider;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Audio.Media;
import com.miui.player.provider.PlayerStore.Statistics;
import com.miui.player.provider.PlayerStore.Statistics.Columns;
import com.miui.player.util.SqlUtils;
import com.miui.player.util.Utils;
import java.util.Arrays;

public class StatisticsHelper {
    private static final long MONTH = 2592000000L;
    private static final String TAG = StatisticsHelper.class.getName();

    public static boolean queryIsCorrectedID3(Context context, long audioId) {
        Cursor cursor = SqlUtils.query(context, Statistics.EXTERNAL_URI, new String[]{Columns.ID3_CORRECTED}, "audio_id=" + audioId, null, null);
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    boolean z = cursor.getInt(cursor.getColumnIndexOrThrow(Columns.ID3_CORRECTED)) == 1;
                    cursor.close();
                    return z;
                }
                cursor.close();
            } catch (Throwable th) {
                cursor.close();
            }
        }
        return false;
    }

    public static long[] queryFrequentlyPlayed(Context context) {
        long[] validIds = MediaProviderHelper.queryValidTrackIdArr(context);
        if (queryFrequentThreshold(context, validIds) < 0) {
            return Utils.LONG_EMPTY_ARRAY;
        }
        Context context2 = context;
        Cursor cursor = SqlUtils.query(context2, Statistics.EXTERNAL_URI, new String[]{"audio_id"}, "played_count>? AND data_last_modified>?", new String[]{String.valueOf(threshold), String.valueOf(System.currentTimeMillis() - MONTH)}, "played_count DESC");
        if (cursor == null) {
            return Utils.LONG_EMPTY_ARRAY;
        }
        long[] ids = new long[cursor.getCount()];
        int i = 0;
        while (cursor.moveToNext()) {
            long id = cursor.getLong(0);
            if (Arrays.binarySearch(validIds, id) >= 0) {
                int i2 = i + 1;
                ids[i] = id;
                i = i2;
            }
        }
        if (i < ids.length) {
            ids = Arrays.copyOf(ids, i);
        }
        cursor.close();
        return ids;
    }

    public static int queryFrequentlyPlayedCount(Context context) {
        long[] ids = queryFrequentlyPlayed(context);
        if (ids == null || ids.length == 0) {
            return 0;
        }
        String idSet = SqlUtils.concatAsSet(ids);
        Cursor cursor = SqlUtils.query(context, Media.EXTERNAL_CONTENT_URI, new String[]{"COUNT(*)"}, "_id IN " + idSet, null, null);
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    int i = cursor.getInt(0);
                    return i;
                }
                cursor.close();
            } finally {
                cursor.close();
            }
        }
        return 0;
    }

    private static int queryFrequentThreshold(Context context, long[] validSet) {
        String where = String.format("(%s>?) AND (%s>0)", new Object[]{Columns.DATE_LAST_MODIFIED, Columns.PLAYED_COUNT});
        Cursor cursor = SqlUtils.query(context, Statistics.EXTERNAL_URI, new String[]{"AVG(played_count)"}, applyValidSet(where, validSet), new String[]{String.valueOf(System.currentTimeMillis() - MONTH)}, null);
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    int i = cursor.getInt(0) - 1;
                    return i;
                }
                cursor.close();
            } finally {
                cursor.close();
            }
        }
        return -1;
    }

    private static String applyValidSet(String raw, long[] validSet) {
        if (validSet == null || validSet.length <= 0) {
            return raw;
        }
        return String.format("(%s) AND (%s IN %s)", new Object[]{raw, "audio_id", SqlUtils.concatAsSet(validSet)});
    }
}
