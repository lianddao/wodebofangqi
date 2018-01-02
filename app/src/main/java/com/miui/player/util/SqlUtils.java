package com.miui.player.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.PushConstants;
import com.miui.player.meta.MetaManager;
import com.miui.player.util.cursors.Cursors;
import com.miui.player.util.cursors.Cursors.CursorVisitor;
import com.xiaomi.music.cloud.impl.CloudJsonTag;
import com.xiaomi.music.util.MusicLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

public class SqlUtils {
    static final String EMPTY_SET = "()";
    public static final String EQUAL_FORMAT = "%s=\"%s\"";
    private static final char ESCAPE_SQL_CHAR = '\\';
    public static final String ESCAPE_SQL_CLAUSE = " ESCAPE '\\'";
    private static final char[] INVALID_SQL_CHAR = new char[]{'%', '?', '_'};
    public static final String LIKE_FORMAT = "%s LIKE \"%%%s%%\"";
    public static final String NOT_LIKE_FORMAT = "%s NOT LIKE \"%%%s%%/%%\"";
    static final String TAG = SqlUtils.class.getName();

    public interface ItemOperator<T> {
        String getId(T t);
    }

    static class C05321 implements ItemOperator<String> {
        C05321() {
        }

        public String getId(String item) {
            return String.format("'%s'", new Object[]{item});
        }
    }

    private static class RawLongArrayCollector implements CursorVisitor {
        private final long[] mContainer;
        private final int mDataIdx;

        public RawLongArrayCollector(int idx, int count) {
            this.mDataIdx = idx;
            this.mContainer = new long[count];
        }

        public boolean visit(Cursor cursor) {
            this.mContainer[cursor.getPosition()] = cursor.getLong(this.mDataIdx);
            return true;
        }

        public long[] result() {
            return this.mContainer;
        }
    }

    private static class RawStringArrayCollector implements CursorVisitor {
        private final String[] mContainer;
        private final int mDataIdx;

        public RawStringArrayCollector(int idx, int count) {
            this.mDataIdx = idx;
            this.mContainer = new String[count];
        }

        public boolean visit(Cursor cursor) {
            this.mContainer[cursor.getPosition()] = cursor.getString(this.mDataIdx);
            return true;
        }

        public String[] result() {
            return this.mContainer;
        }
    }

    public static class SQLArguments {
        public final String[] mArgs;
        public final String mSelection;

        public SQLArguments(String selection, String[] args) {
            this.mSelection = selection;
            this.mArgs = args;
        }
    }

    public static class SimpleItem<T> implements ItemOperator<T> {
        public String getId(T item) {
            return String.valueOf(item);
        }
    }

    public static void escapeSql(StringBuilder dst, String src) {
        if (!TextUtils.isEmpty(src)) {
            int i = 0;
            while (i < src.length()) {
                int j = indexOfInvalid(src, i);
                dst.append(src, i, j);
                if (j < src.length()) {
                    dst.append(ESCAPE_SQL_CHAR);
                    dst.append(src.charAt(j));
                }
                i = j + 1;
            }
        }
    }

    public static int indexOfInvalid(String str, int start) {
        int index = str.length();
        for (char ic : INVALID_SQL_CHAR) {
            int i = str.indexOf(ic, start);
            if (i >= 0 && i < index) {
                index = i;
                if (index == start) {
                    break;
                }
            }
        }
        return index;
    }

    public static String concatAsSet(long[] idList) {
        if (idList == null || idList.length == 0) {
            return EMPTY_SET;
        }
        StringBuilder idSet = new StringBuilder("(");
        for (int i = 0; i < idList.length - 1; i++) {
            idSet.append(idList[i]);
            idSet.append(",");
        }
        idSet.append(idList[idList.length - 1]);
        idSet.append(")");
        return idSet.toString();
    }

    public static String concatAsString(String[] idList) {
        return concatAsString(Arrays.asList(idList), new SimpleItem());
    }

    public static <T> String concatAsString(Collection<T> idList, ItemOperator<T> operator) {
        if (idList == null || idList.isEmpty()) {
            return null;
        }
        StringBuilder idString = new StringBuilder(MetaManager.UNKNOWN_STRING);
        Iterator<T> iter = idList.iterator();
        int last = idList.size() - 1;
        for (int i = 0; i < last; i++) {
            T item = iter.next();
            if (item != null) {
                idString.append(operator.getId(item));
                idString.append(",");
            }
        }
        T lastItem = iter.next();
        if (lastItem != null) {
            idString.append(operator.getId(lastItem));
        }
        return idString.toString();
    }

    public static <T> String concatAsSet(Collection<T> idList, ItemOperator<T> operator) {
        if (idList == null || idList.isEmpty()) {
            return EMPTY_SET;
        }
        StringBuilder builder = new StringBuilder("(");
        builder.append(concatAsString(idList, operator));
        builder.append(")");
        return builder.toString();
    }

    public static String concatStringAsSet(Collection<String> idList) {
        return concatAsSet(idList, new C05321());
    }

    public static <T extends Number> String concatNumberAsSet(Collection<T> idList) {
        return concatAsSet(idList, new SimpleItem());
    }

    public static String concatIdsAsSet(Cursor cursor, int column) {
        if (cursor == null || cursor.getCount() == 0) {
            return EMPTY_SET;
        }
        StringBuilder idSet = new StringBuilder("(");
        cursor.moveToFirst();
        while (!cursor.isLast()) {
            idSet.append(cursor.getLong(column));
            idSet.append(",");
            cursor.moveToNext();
        }
        idSet.append(cursor.getLong(column));
        idSet.append(")");
        return idSet.toString();
    }

    public static SQLArguments concatStringFilter(String column, Collection<String> values, String connector) {
        if (TextUtils.isEmpty(column) || TextUtils.isEmpty(connector) || CollectionHelper.isEmpty(values)) {
            return null;
        }
        int count = 0;
        for (String str : values) {
            if (!TextUtils.isEmpty(str)) {
                count++;
            }
        }
        if (count == 0) {
            return null;
        }
        String selection;
        int i = 0;
        String[] args = new String[count];
        StringBuilder sb = new StringBuilder();
        for (String str2 : values) {
            if (!TextUtils.isEmpty(str2)) {
                int i2 = i + 1;
                args[i] = str2;
                sb.append("(");
                sb.append(column);
                sb.append("=?");
                sb.append(")");
                sb.append(connector);
                i = i2;
            }
        }
        int len = sb.length();
        int connectorLen = connector.length();
        if (len > connectorLen) {
            sb.delete(len - connectorLen, len);
        }
        if (count > 1) {
            selection = String.format("(%s)", new Object[]{sb});
        } else {
            selection = sb.toString();
        }
        return new SQLArguments(selection, args);
    }

    public static long[] differenceSet(long[] first, long[] second) {
        long[] temp = new long[second.length];
        long[] arr$ = second;
        int len$ = arr$.length;
        int i$ = 0;
        int i = 0;
        while (i$ < len$) {
            int i2;
            long v = arr$[i$];
            if (Arrays.binarySearch(first, v) < 0) {
                i2 = i + 1;
                temp[i] = v;
            } else {
                i2 = i;
            }
            i$++;
            i = i2;
        }
        long[] ret = temp;
        if (i < second.length) {
            return Arrays.copyOf(temp, i);
        }
        return ret;
    }

    public static String wrapWithBlacklist(Context context) {
        return wrapWithBlacklist(context, null, true);
    }

    public static String wrapWithBlacklist(Context context, String rawWhereClause) {
        return wrapWithBlacklist(context, rawWhereClause, true);
    }

    public static String wrapWithBlacklist(Context context, String rawWhereClause, boolean isFolderFilter) {
        ArrayList<CharSequence> list = new ArrayList();
        list.add(rawWhereClause);
        list.add("title!=''");
        if (PreferenceCache.getPrefAsBoolean(context, PreferenceCache.PREF_FILTER_BY_SIZE)) {
            list.add("_size>" + PreferenceCache.getPrefAsInteger(context, PreferenceCache.PREF_FILTER_BY_SIZE_PROGRESS).intValue());
        }
        if (PreferenceCache.getPrefAsBoolean(context, PreferenceCache.PREF_FILTER_BY_DURATION)) {
            int duration = PreferenceCache.getPrefAsInteger(context, PreferenceCache.PREF_FILTER_BY_DURATION_PROGRESS).intValue();
            list.add(String.format("(%s=0) OR (%s>%d)", new Object[]{"duration", "duration", Integer.valueOf(duration * 1000)}));
        }
        if (isFolderFilter) {
            list.add(FolderProvider.instance(context).getUnselectedFoldersAsSet(context));
        }
        return buildSqlWithAND(list);
    }

    private static String buildSqlWithAND(Collection<CharSequence> clauses) {
        StringBuilder sb = new StringBuilder();
        for (CharSequence clause : clauses) {
            if (!TextUtils.isEmpty(clause)) {
                if (!TextUtils.isEmpty(sb)) {
                    sb.append("AND");
                }
                sb.append("(");
                sb.append(clause);
                sb.append(")");
            }
        }
        return sb.length() > 0 ? sb.toString() : null;
    }

    public static long[] getIdsForCursor(Cursor cursor, int idx) {
        if (cursor == null) {
            return Utils.LONG_EMPTY_ARRAY;
        }
        int len = cursor.getCount();
        if (len == 0) {
            return Utils.LONG_EMPTY_ARRAY;
        }
        RawLongArrayCollector collector = new RawLongArrayCollector(idx, len);
        Cursors.traverse(cursor, collector);
        return collector.result();
    }

    public static String[] getStringsForCursor(Cursor cursor, int idx) {
        if (cursor == null) {
            return Utils.STRING_EMPTY_ARRAY;
        }
        int len = cursor.getCount();
        if (len == 0) {
            return Utils.STRING_EMPTY_ARRAY;
        }
        RawStringArrayCollector collector = new RawStringArrayCollector(idx, len);
        Cursors.traverse(cursor, collector);
        return collector.result();
    }

    public static int getRecordCount(Context context, Uri uri) {
        return getRecordCount(context, uri, null, null);
    }

    public static int getRecordCount(Context context, Uri uri, String where, String[] args) {
        Cursor cur = context.getContentResolver().query(uri, new String[]{"count(*)"}, where, args, null);
        cur.moveToFirst();
        int count = cur.getInt(0);
        cur.close();
        return count;
    }

    public static String pathLikeWhere(Collection<String> paths, String columnName) {
        if (paths == null || paths.isEmpty()) {
            return null;
        }
        String AND = " AND ";
        String OR = " OR ";
        StringBuilder set = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        Formatter format = new Formatter(tmp, Locale.getDefault());
        set.append("(");
        boolean empty = true;
        for (String str : paths) {
            if (!TextUtils.isEmpty(str)) {
                tmp.setLength(0);
                escapeSql(tmp, str);
                String escaped = tmp.toString();
                tmp.setLength(0);
                String like = format.format(LIKE_FORMAT, new Object[]{columnName, escaped}).toString();
                tmp.setLength(0);
                String notlike = format.format(NOT_LIKE_FORMAT, new Object[]{columnName, escaped}).toString();
                set.append("(");
                tmp.setLength(0);
                set.append(like);
                set.append(ESCAPE_SQL_CLAUSE);
                set.append(" AND ");
                set.append(notlike);
                set.append(ESCAPE_SQL_CLAUSE);
                set.append(")");
                set.append(" OR ");
                empty = false;
            }
        }
        if (!empty) {
            int len = set.length();
            set.delete(len - " OR ".length(), len);
        }
        set.append(")");
        return set.toString();
    }

    public static Cursor query(Context context, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, int limit) {
        try {
            ContentResolver resolver = context.getContentResolver();
            if (resolver == null) {
                return null;
            }
            if (limit > 0) {
                uri = uri.buildUpon().appendQueryParameter(CloudJsonTag.TAG_LIMIT, MetaManager.UNKNOWN_STRING + limit).build();
            }
            return resolver.query(uri, projection, selection, selectionArgs, sortOrder);
        } catch (UnsupportedOperationException e) {
            Log.e(TAG, argsDump(uri, projection, selection, selectionArgs, sortOrder, limit), e);
            return null;
        } catch (IllegalStateException e2) {
            Log.e(TAG, argsDump(uri, projection, selection, selectionArgs, sortOrder, limit), e2);
            return null;
        } catch (SQLiteException e3) {
            Log.e(TAG, argsDump(uri, projection, selection, selectionArgs, sortOrder, limit), e3);
            return null;
        }
    }

    public static Cursor query(Context context, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return query(context, uri, projection, selection, selectionArgs, sortOrder, 0);
    }

    public static int update(Context context, Uri uri, ContentValues values, String where, String[] selectionArgs) {
        return context.getContentResolver().update(uri, values, where, selectionArgs);
    }

    public static Uri insert(Context context, Uri uri, ContentValues values) {
        Uri uri2 = null;
        try {
            ContentResolver resolver = context.getContentResolver();
            if (resolver != null) {
                uri2 = resolver.insert(uri, values);
            }
        } catch (UnsupportedOperationException e) {
            MusicLog.m397e(TAG, e.toString());
        } catch (IllegalStateException e2) {
            MusicLog.m397e(TAG, e2.toString());
        } catch (SQLiteException e3) {
            MusicLog.m397e(TAG, e3.toString());
        }
        return uri2;
    }

    public static int bulkInsert(Context context, Uri url, ContentValues[] values) {
        return context.getContentResolver().bulkInsert(url, values);
    }

    public static int delete(Context context, Uri url, String where, String[] selectionArgs) {
        return context.getContentResolver().delete(url, where, selectionArgs);
    }

    private static String argsDump(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, int limit) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("uri=").append(uri).append("; ");
        sb.append("projection=");
        if (projection == null) {
            sb.append("null");
        } else {
            sb.append("[");
            for (String p : projection) {
                sb.append(p).append(", ");
            }
            sb.append("]");
        }
        sb.append("; ");
        sb.append("selection=").append(selection).append("; ");
        sb.append("selectionArgs=");
        if (selectionArgs == null) {
            sb.append("null");
        } else {
            sb.append("[");
            for (String p2 : selectionArgs) {
                sb.append(p2).append(", ");
            }
            sb.append("]");
        }
        sb.append("; ");
        sb.append("sortOrder=").append(sortOrder).append("; ");
        sb.append("limit=").append(limit);
        sb.append("}");
        return sb.toString();
    }

    public static long[] sortElementsByCursor(Cursor cursor, Set<Long> s, String idColumn, String dataColumn) {
        if (cursor == null || s == null || s.isEmpty()) {
            return null;
        }
        int oldPos = cursor.getPosition();
        long[] ret = new long[s.size()];
        int i = 0;
        int idIdx = cursor.getColumnIndexOrThrow(idColumn);
        int dataIdx = cursor.getColumnIndexOrThrow(dataColumn);
        int i2;
        if (idIdx == dataIdx) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                long id = cursor.getLong(idIdx);
                if (s.contains(Long.valueOf(id))) {
                    i2 = i + 1;
                    ret[i] = id;
                    i = i2;
                }
                cursor.moveToNext();
            }
        } else {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                if (s.contains(Long.valueOf(cursor.getLong(idIdx)))) {
                    i2 = i + 1;
                    ret[i] = cursor.getLong(dataIdx);
                    i = i2;
                }
                cursor.moveToNext();
            }
        }
        cursor.moveToPosition(oldPos);
        return i != ret.length ? Arrays.copyOf(ret, i) : ret;
    }

    public static Uri translateToFileUri(Context context, Uri uri) {
        if (uri != null && PushConstants.EXTRA_CONTENT.equals(uri.getScheme()) && "media".equals(uri.getAuthority())) {
            Cursor c = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            if (c != null) {
                try {
                    if (c.moveToFirst()) {
                        uri = Uri.fromFile(new File(c.getString(0)));
                    }
                    c.close();
                } catch (Throwable th) {
                    c.close();
                }
            }
        }
        return uri;
    }

    public static boolean notFilteredBySize(Context context, int size) {
        if (PreferenceCache.getPrefAsBoolean(context, PreferenceCache.PREF_FILTER_BY_SIZE) && size <= PreferenceCache.getPrefAsInteger(context, PreferenceCache.PREF_FILTER_BY_SIZE_PROGRESS).intValue()) {
            return false;
        }
        return true;
    }

    public static boolean notFilteredByDuration(Context context, int duration) {
        if (PreferenceCache.getPrefAsBoolean(context, PreferenceCache.PREF_FILTER_BY_DURATION) && duration != 0 && duration <= PreferenceCache.getPrefAsInteger(context, PreferenceCache.PREF_FILTER_BY_DURATION_PROGRESS).intValue() * 1000) {
            return false;
        }
        return true;
    }
}
