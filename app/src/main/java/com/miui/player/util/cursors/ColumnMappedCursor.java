package com.miui.player.util.cursors;

import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.text.TextUtils;

public class ColumnMappedCursor extends CursorWrapper {
    private final int[] mColumnMap;
    private final String[] mColumns;

    public ColumnMappedCursor(Cursor cursor, String[] columns, int[] columnMap) {
        super(cursor);
        if (columns.length != columnMap.length) {
            throw new IllegalArgumentException(String.format("bad length: columns.length=%d, columnMap.length=%d", new Object[]{Integer.valueOf(columns.length), Integer.valueOf(columnMap.length)}));
        }
        this.mColumns = columns;
        this.mColumnMap = columnMap;
    }

    public short getShort(int columnIndex) {
        int mappedIndex = this.mColumnMap[columnIndex];
        if (mappedIndex >= 0) {
            return super.getShort(mappedIndex);
        }
        return (short) 0;
    }

    public int getInt(int columnIndex) {
        int mappedIndex = this.mColumnMap[columnIndex];
        if (mappedIndex >= 0) {
            return super.getInt(mappedIndex);
        }
        return 0;
    }

    public long getLong(int columnIndex) {
        int mappedIndex = this.mColumnMap[columnIndex];
        if (mappedIndex >= 0) {
            return super.getLong(mappedIndex);
        }
        return 0;
    }

    public float getFloat(int columnIndex) {
        int mappedIndex = this.mColumnMap[columnIndex];
        if (mappedIndex >= 0) {
            return super.getFloat(mappedIndex);
        }
        return 0.0f;
    }

    public double getDouble(int columnIndex) {
        int mappedIndex = this.mColumnMap[columnIndex];
        if (mappedIndex >= 0) {
            return super.getDouble(mappedIndex);
        }
        return 0.0d;
    }

    public String getString(int columnIndex) {
        int mappedIndex = this.mColumnMap[columnIndex];
        if (mappedIndex >= 0) {
            return super.getString(mappedIndex);
        }
        return null;
    }

    public byte[] getBlob(int columnIndex) {
        int mappedIndex = this.mColumnMap[columnIndex];
        if (mappedIndex >= 0) {
            return super.getBlob(mappedIndex);
        }
        return null;
    }

    public int getType(int columnIndex) {
        int mappedIndex = this.mColumnMap[columnIndex];
        if (mappedIndex >= 0) {
            return super.getType(mappedIndex);
        }
        return 0;
    }

    public int getColumnIndex(String column) {
        int index = 0;
        for (String c : this.mColumns) {
            if (TextUtils.equals(c, column)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        int mappedIndex = this.mColumnMap[columnIndex];
        if (mappedIndex >= 0) {
            super.copyStringToBuffer(mappedIndex, buffer);
        }
    }

    public int getColumnIndexOrThrow(String column) throws IllegalArgumentException {
        int index = getColumnIndex(column);
        if (index >= 0) {
            return index;
        }
        throw new IllegalArgumentException("fail to find column: " + column);
    }

    public int getColumnCount() {
        return this.mColumns.length;
    }

    public String getColumnName(int columnIndex) {
        return this.mColumns[columnIndex];
    }

    public String[] getColumnNames() {
        return this.mColumns;
    }
}
