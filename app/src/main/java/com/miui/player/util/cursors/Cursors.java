package com.miui.player.util.cursors;

import android.database.Cursor;
import android.database.MergeCursor;
import android.text.TextUtils;
import com.miui.player.util.cursors.SortBy.SortColumn;
import java.util.Arrays;
import java.util.Comparator;

public class Cursors {

    public interface CursorVisitor {
        boolean visit(Cursor cursor);
    }

    static class ComparablePair implements Comparable<ComparablePair> {
        public final Object mComparable;
        public final int mIndex;

        public ComparablePair(int index, Object comparable) {
            this.mIndex = index;
            this.mComparable = comparable;
        }

        public int compareTo(ComparablePair another) {
            return ((Comparable) this.mComparable).compareTo((Comparable) another.mComparable);
        }
    }

    public static boolean traverse(Cursor cursor, CursorVisitor visitor) {
        if (cursor == null) {
            return false;
        }
        int position = cursor.getPosition();
        cursor.moveToFirst();
        while (!cursor.isAfterLast() && visitor.visit(cursor)) {
            cursor.moveToNext();
        }
        cursor.moveToPosition(position);
        return true;
    }

    public static Cursor newArrayCursor(Object[][] data, String[] columns) {
        if (data == null) {
            return null;
        }
        return new ArrayCursor(data, data.length, columns);
    }

    public static Cursor newRowMappedCursor(Cursor cursor, int[] positionMap) {
        if (cursor == null) {
            return null;
        }
        return new RowMappedCursor(cursor, positionMap);
    }

    public static Cursor newRowMappedCursor(Cursor cursor, int idx, long[] refIds) {
        if (cursor == null || refIds == null) {
            return null;
        }
        long[] ids = new long[cursor.getCount()];
        int i = 0;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int i2 = i + 1;
            ids[i] = cursor.getLong(idx);
            cursor.moveToNext();
            i = i2;
        }
        int[] map = new int[refIds.length];
        Arrays.fill(map, -1);
        long[] arr$ = refIds;
        int len$ = arr$.length;
        int i$ = 0;
        int j = 0;
        while (i$ < len$) {
            int j2;
            int pos = Arrays.binarySearch(ids, arr$[i$]);
            if (pos >= 0) {
                j2 = j + 1;
                map[j] = pos;
            } else {
                j2 = j;
            }
            i$++;
            j = j2;
        }
        if (j < map.length) {
            map = Arrays.copyOf(map, j);
        }
        return new RowMappedCursor(cursor, map);
    }

    public static Cursor newSorttedCursor(Cursor cursor, SortColumn getter, boolean asc) {
        if (cursor == null) {
            return null;
        }
        int count = cursor.getCount();
        ComparablePair[] idxArray = new ComparablePair[count];
        int i = 0;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            idxArray[i] = new ComparablePair(i, getter.get(cursor));
            cursor.moveToNext();
            i++;
        }
        Arrays.sort(idxArray);
        int[] sorted = new int[count];
        int j;
        if (asc) {
            for (j = 0; j < count; j++) {
                sorted[j] = idxArray[j].mIndex;
            }
        } else {
            for (j = 0; j < count; j++) {
                sorted[(count - j) - 1] = idxArray[j].mIndex;
            }
        }
        return new RowMappedCursor(cursor, sorted);
    }

    public static Cursor newColumnAppendedCursor(Cursor cursor, String column, Object value) {
        if (cursor == null) {
            return null;
        }
        return new ColumnAppendedCursor(cursor, column, value);
    }

    public static Cursor newColumnMappedCursor(Cursor cursor, String[] columns) {
        return newColumnMappedCursor(cursor, columns, parseColumnMap(cursor.getColumnNames(), columns));
    }

    public static Cursor newColumnMappedCursor(Cursor cursor, String[] columns, int[] indexMap) {
        if (cursor == null) {
            return null;
        }
        return new ColumnMappedCursor(cursor, columns, indexMap);
    }

    public static Cursor replaceCursorColumns(Cursor cursor, String[] columns) {
        if (cursor == null) {
            return null;
        }
        int[] indexMap = new int[cursor.getColumnCount()];
        Arrays.fill(indexMap, -1);
        for (int i = 0; i < columns.length; i++) {
            indexMap[i] = i;
        }
        return new ColumnMappedCursor(cursor, columns, indexMap);
    }

    public static Cursor merge(Cursor[] cursors) {
        return new MergeCursor(cursors);
    }

    public static Cursor removeDuplicateRows(Cursor sortedCursor, SortColumn getter, Comparator<Object> comparator) {
        if (sortedCursor == null) {
            return null;
        }
        int[] indexMap = new int[sortedCursor.getCount()];
        Arrays.fill(indexMap, -1);
        if (!sortedCursor.moveToFirst()) {
            return sortedCursor;
        }
        Object last = getter.get(sortedCursor);
        int i = 0 + 1;
        indexMap[0] = 0;
        int i2 = i;
        while (sortedCursor.moveToNext()) {
            Object current = getter.get(sortedCursor);
            if (comparator.compare(last, current) != 0) {
                i = i2 + 1;
                indexMap[i2] = sortedCursor.getPosition();
                last = current;
                i2 = i;
            }
        }
        int lastUsable = -1;
        for (int j = indexMap.length - 1; j >= 0; j--) {
            if (indexMap[j] != -1) {
                lastUsable = j;
                break;
            }
        }
        if (lastUsable != -1) {
            System.arraycopy(indexMap, 0, new int[lastUsable], 0, lastUsable + 1);
        } else {
            int[] iArr = indexMap;
        }
        Cursor result = new RowMappedCursor(sortedCursor, indexMap);
        result.moveToFirst();
        return result;
    }

    private static int[] parseColumnMap(String[] src, String[] dst) {
        int[] indexMap = new int[dst.length];
        Arrays.fill(indexMap, -1);
        for (int i = 0; i < dst.length; i++) {
            for (int j = 0; j < src.length; j++) {
                if (TextUtils.equals(dst[i], src[j])) {
                    indexMap[i] = j;
                }
            }
            if (indexMap[i] == -1) {
                throw new IllegalArgumentException("column " + dst[i] + " is not found in src");
            }
        }
        return indexMap;
    }
}
