package com.miui.player.util.cursors;

import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.DatabaseUtils;
import android.text.TextUtils;
import com.miui.player.meta.MetaManager;

public class ColumnAppendedCursor extends CursorWrapper {
    private final ValueProvider mAppendedValue;
    private final String[] mColumns;

    interface ValueProvider {
        Object get(int i);
    }

    static class ArrayValueProvider implements ValueProvider {
        private final Object[] mValue;

        public ArrayValueProvider(Object[] value) {
            this.mValue = value;
        }

        public Object get(int row) {
            return this.mValue[row];
        }
    }

    static class SingleValueProvider implements ValueProvider {
        private final Object mValue;

        public SingleValueProvider(Object value) {
            this.mValue = value;
        }

        public Object get(int row) {
            return this.mValue;
        }
    }

    public ColumnAppendedCursor(Cursor cursor, String appendedColumn, Object appendedValue) {
        super(cursor);
        String[] oldColumns = cursor.getColumnNames();
        this.mColumns = new String[(oldColumns.length + 1)];
        System.arraycopy(oldColumns, 0, this.mColumns, 0, oldColumns.length);
        this.mColumns[this.mColumns.length - 1] = appendedColumn;
        if (appendedValue instanceof Object[]) {
            this.mAppendedValue = new ArrayValueProvider((Object[]) appendedValue);
        } else {
            this.mAppendedValue = new SingleValueProvider(appendedValue);
        }
    }

    public int getColumnCount() {
        return this.mColumns.length;
    }

    public int getColumnIndex(String columnName) {
        if (TextUtils.equals(columnName, this.mColumns[this.mColumns.length - 1])) {
            return this.mColumns.length - 1;
        }
        return super.getColumnIndex(columnName);
    }

    public int getColumnIndexOrThrow(String columnName) throws IllegalArgumentException {
        if (TextUtils.equals(columnName, this.mColumns[this.mColumns.length - 1])) {
            return this.mColumns.length - 1;
        }
        return super.getColumnIndexOrThrow(columnName);
    }

    public String getColumnName(int columnIndex) {
        if (columnIndex == this.mColumns.length - 1) {
            return this.mColumns[columnIndex];
        }
        return super.getColumnName(columnIndex);
    }

    public String[] getColumnNames() {
        return this.mColumns;
    }

    public double getDouble(int columnIndex) {
        if (columnIndex != this.mColumns.length - 1) {
            return super.getDouble(columnIndex);
        }
        Object value = this.mAppendedValue.get(getPosition());
        return value != null ? ((Number) value).doubleValue() : 0.0d;
    }

    public float getFloat(int columnIndex) {
        if (columnIndex != this.mColumns.length - 1) {
            return super.getFloat(columnIndex);
        }
        Object value = this.mAppendedValue.get(getPosition());
        return value != null ? ((Number) value).floatValue() : 0.0f;
    }

    public int getInt(int columnIndex) {
        if (columnIndex != this.mColumns.length - 1) {
            return super.getInt(columnIndex);
        }
        Object value = this.mAppendedValue.get(getPosition());
        return value != null ? ((Number) value).intValue() : 0;
    }

    public long getLong(int columnIndex) {
        if (columnIndex != this.mColumns.length - 1) {
            return super.getLong(columnIndex);
        }
        Object value = this.mAppendedValue.get(getPosition());
        return value != null ? ((Number) value).longValue() : 0;
    }

    public short getShort(int columnIndex) {
        if (columnIndex != this.mColumns.length - 1) {
            return super.getShort(columnIndex);
        }
        Object value = this.mAppendedValue.get(getPosition());
        return value != null ? ((Number) value).shortValue() : (short) 0;
    }

    public String getString(int columnIndex) {
        if (columnIndex != this.mColumns.length - 1) {
            return super.getString(columnIndex);
        }
        Object value = this.mAppendedValue.get(getPosition());
        return value != null ? value.toString() : MetaManager.UNKNOWN_STRING;
    }

    public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        if (columnIndex == this.mColumns.length - 1) {
            String result = getString(columnIndex);
            if (result != null) {
                char[] data = buffer.data;
                if (data == null || data.length < result.length()) {
                    buffer.data = result.toCharArray();
                } else {
                    result.getChars(0, result.length(), data, 0);
                }
                buffer.sizeCopied = result.length();
                return;
            }
            buffer.sizeCopied = 0;
            return;
        }
        super.copyStringToBuffer(columnIndex, buffer);
    }

    public byte[] getBlob(int columnIndex) {
        if (columnIndex == this.mColumns.length - 1) {
            return (byte[]) this.mAppendedValue.get(getPosition());
        }
        return super.getBlob(columnIndex);
    }

    public int getType(int columnIndex) {
        if (columnIndex == this.mColumns.length - 1) {
            return DatabaseUtils.getTypeOfObject(this.mAppendedValue.get(getPosition()));
        }
        return super.getType(columnIndex);
    }

    public boolean isNull(int columnIndex) {
        if (columnIndex == this.mColumns.length - 1) {
            return this.mAppendedValue.get(getPosition()) == null;
        } else {
            return super.isNull(columnIndex);
        }
    }
}
