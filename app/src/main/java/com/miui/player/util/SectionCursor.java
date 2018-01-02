package com.miui.player.util;

import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.DatabaseUtils;
import android.database.StaleDataException;
import com.miui.player.plugin.onlinemusic2.baidu.BaiduConstants;
import com.miui.player.ui.base.ApplicationHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SectionCursor extends AbstractCursor {
    private String mCloseStack = null;
    private boolean mClosed = false;
    private final String[] mColumns;
    private final int mCount;
    private final Object[][] mRawData;
    private final SectionInfo mSectionInfo;

    public interface ElementConverter {
        boolean parse(Cursor cursor, Object[] objArr);
    }

    public interface SortKeyGetter {
        String get(Object obj);
    }

    public static class ArraySortKey implements SortKeyGetter {
        private final int mSortKeyIndex;

        public ArraySortKey(int sortKeyIdx) {
            this.mSortKeyIndex = sortKeyIdx;
        }

        public String get(Object src) {
            return (String) ((Object[]) src)[this.mSortKeyIndex];
        }
    }

    public interface CursorConverter {
        ConvertResult toArray(Cursor cursor);
    }

    private static class CommonCursorConverter implements CursorConverter {
        private final ElementConverter mElementConverter;
        private final int mSortIndex;

        public CommonCursorConverter(ElementConverter converter, int sortIndex) {
            this.mElementConverter = converter;
            this.mSortIndex = sortIndex;
        }

        public ConvertResult toArray(Cursor cursor) {
            String[] columns = new String[(cursor.getColumnCount() + 1)];
            int columnCount = columns.length;
            System.arraycopy(cursor.getColumnNames(), 0, columns, 0, columnCount - 1);
            columns[columnCount - 1] = "sort_key";
            Object[][] records = new Object[cursor.getCount()][];
            IDeviceCompat wrapper = ApplicationHelper.instance().getDeviceCompat();
            int row = 0;
            while (cursor.moveToNext()) {
                Object[] rec = new Object[columnCount];
                if (this.mElementConverter.parse(cursor, rec)) {
                    rec[columnCount - 1] = wrapper.getSortKey((String) rec[this.mSortIndex]);
                    int row2 = row + 1;
                    records[row] = rec;
                    row = row2;
                }
            }
            return new ConvertResult(records, columns, columns.length - 1);
        }
    }

    public static class ConvertResult {
        public final String[] mColumns;
        public final Object[][] mRecords;
        public final int mSortIndex;

        public ConvertResult(Object[][] records, String[] columns, int sortIndex) {
            this.mRecords = records;
            this.mColumns = columns;
            this.mSortIndex = sortIndex;
        }
    }

    private class RecordComparator implements Comparator<Object[]> {
        private final SortKeyGetter mSortKeyGetter;

        public RecordComparator(SortKeyGetter sortkeyGetter) {
            this.mSortKeyGetter = sortkeyGetter;
        }

        public int compare(Object[] first, Object[] second) {
            return this.mSortKeyGetter.get(first).compareTo(this.mSortKeyGetter.get(second));
        }
    }

    public static class SectionInfo {
        public final Integer[] mCounts;
        public final String[] mTitles;

        public SectionInfo(String[] titles, Integer[] counts) {
            this.mTitles = titles;
            this.mCounts = counts;
        }
    }

    private SectionCursor(Object[][] rawData, int count, String[] columns, SectionInfo sectionInfo) {
        if (rawData == null) {
            throw new IllegalArgumentException("raw data can not be null");
        }
        this.mRawData = rawData;
        this.mCount = count;
        this.mSectionInfo = sectionInfo;
        this.mColumns = columns;
    }

    private SectionCursor(ConvertResult result, int headerCount) {
        Object[][] records = result.mRecords;
        if (records == null) {
            throw new IllegalArgumentException("raw data can not be null");
        }
        SortKeyGetter keyGetter = new ArraySortKey(result.mSortIndex);
        Arrays.sort(records, headerCount, records.length, new RecordComparator(keyGetter));
        this.mSectionInfo = collectSectionInfo(records, keyGetter, headerCount);
        this.mRawData = result.mRecords;
        this.mCount = this.mRawData.length;
        this.mColumns = result.mColumns;
    }

    public void close() {
        this.mCloseStack = ThreadManager.currentCallStack("Close Cursor Stack: ");
        this.mClosed = true;
        super.close();
    }

    public int getColumnCount() {
        return this.mColumns.length;
    }

    public String[] getColumnNames() {
        return this.mColumns;
    }

    public int getCount() {
        return this.mCount;
    }

    private Object get(int columnIndex) {
        if (this.mClosed) {
            throw new StaleDataException("section cursor is closed! call stack is \n\r" + this.mCloseStack);
        } else if (columnIndex < 0 || columnIndex >= this.mColumns.length) {
            throw new CursorIndexOutOfBoundsException("Requested column: " + columnIndex + ", # of columns: " + columnIndex);
        } else if (this.mPos < 0) {
            throw new CursorIndexOutOfBoundsException("Before first row.");
        } else if (this.mPos < this.mCount) {
            return this.mRawData[this.mPos][columnIndex];
        } else {
            throw new CursorIndexOutOfBoundsException("After last row.");
        }
    }

    public byte[] getBlob(int columnIndex) {
        return (byte[]) get(columnIndex);
    }

    public double getDouble(int columnIndex) {
        Object value = get(columnIndex);
        if (value == null) {
            return 0.0d;
        }
        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        }
        return Double.parseDouble(value.toString());
    }

    public float getFloat(int columnIndex) {
        Object value = get(columnIndex);
        if (value == null) {
            return 0.0f;
        }
        if (value instanceof Number) {
            return ((Number) value).floatValue();
        }
        return Float.parseFloat(value.toString());
    }

    public int getInt(int columnIndex) {
        Object value = get(columnIndex);
        if (value == null) {
            return 0;
        }
        if (value instanceof Number) {
            return ((Number) value).intValue();
        }
        return Integer.parseInt(value.toString());
    }

    public long getLong(int columnIndex) {
        Object value = get(columnIndex);
        if (value == null) {
            return 0;
        }
        if (value instanceof Number) {
            return ((Number) value).longValue();
        }
        return Long.parseLong(value.toString());
    }

    public short getShort(int columnIndex) {
        Object value = get(columnIndex);
        if (value == null) {
            return (short) 0;
        }
        if (value instanceof Number) {
            return ((Number) value).shortValue();
        }
        return Short.parseShort(value.toString());
    }

    public String getString(int columnIndex) {
        Object value = get(columnIndex);
        return value != null ? value.toString() : null;
    }

    public boolean isNull(int columnIndex) {
        return get(columnIndex) == null;
    }

    public int getType(int columnIndex) {
        return DatabaseUtils.getTypeOfObject(get(columnIndex));
    }

    public boolean requery() {
        throw new UnsupportedOperationException();
    }

    public SectionInfo getSectionInfo() {
        return this.mSectionInfo;
    }

    public static SectionCursor wrap(Cursor cursor, CursorConverter converter, int headerCount) {
        if (cursor != null) {
            return new SectionCursor(converter.toArray(cursor), headerCount);
        }
        return null;
    }

    public static SectionCursor wrap(Object[][] rawData, int count, String[] columns, SectionInfo sectionInfo) {
        if (rawData == null || sectionInfo == null) {
            return null;
        }
        return new SectionCursor(rawData, count, columns, sectionInfo);
    }

    public static CursorConverter createCursorConverter(ElementConverter ec, int sortIndex) {
        return new CommonCursorConverter(ec, sortIndex);
    }

    public static SectionInfo collectSectionInfo(Object[] records, SortKeyGetter keyGetter, int headerCount) {
        ArrayList<Integer> countArr = new ArrayList();
        ArrayList<String> titleArr = new ArrayList();
        int count = headerCount;
        int index = headerCount;
        if (index < records.length) {
            while (index < records.length) {
                String sort = keyGetter.get(records[index]);
                if (sort != null && !sort.isEmpty() && Character.isLetter(Character.toUpperCase(sort.charAt(0)))) {
                    break;
                }
                count++;
                index++;
            }
        } else {
            count = records.length;
        }
        titleArr.add(String.valueOf(BaiduConstants.DEFAULT_FIRST_CHAR));
        countArr.add(Integer.valueOf(count));
        if (index >= 0 && index < records.length) {
            char current = Character.toUpperCase(keyGetter.get(records[index]).charAt(0));
            count = 1;
            while (true) {
                index++;
                if (index >= records.length) {
                    break;
                }
                char c = Character.toUpperCase(keyGetter.get(records[index]).charAt(0));
                if (c == current || c < 'A' || c > 'Z') {
                    count++;
                } else {
                    titleArr.add(String.valueOf(current));
                    countArr.add(Integer.valueOf(count));
                    current = c;
                    count = 1;
                }
            }
            titleArr.add(String.valueOf(current));
            countArr.add(Integer.valueOf(count));
        }
        int size = countArr.size();
        String[] titles = new String[size];
        titleArr.toArray(titles);
        Integer[] counts = new Integer[size];
        countArr.toArray(counts);
        return new SectionInfo(titles, counts);
    }
}
