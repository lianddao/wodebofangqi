package com.miui.player.util.cursors;

import android.database.AbstractCursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.DatabaseUtils;

public class ArrayCursor extends AbstractCursor {
    private final int mColumnCount;
    private final String[] mColumnNames;
    private final Object[][] mData;
    private final int mRowCount;

    public ArrayCursor(Object[][] data, int rowCount, String[] columnNames) {
        this.mData = data;
        this.mColumnNames = columnNames;
        this.mRowCount = rowCount;
        this.mColumnCount = columnNames.length;
    }

    public String[] getColumnNames() {
        return this.mColumnNames;
    }

    public int getCount() {
        return this.mRowCount;
    }

    public double getDouble(int column) {
        Object value = get(column);
        if (value == null) {
            return 0.0d;
        }
        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        }
        return Double.parseDouble(value.toString());
    }

    public float getFloat(int column) {
        Object value = get(column);
        if (value == null) {
            return 0.0f;
        }
        if (value instanceof Number) {
            return ((Number) value).floatValue();
        }
        return Float.parseFloat(value.toString());
    }

    public int getInt(int column) {
        Object value = get(column);
        if (value == null) {
            return 0;
        }
        if (value instanceof Number) {
            return ((Number) value).intValue();
        }
        return Integer.parseInt(value.toString());
    }

    public long getLong(int column) {
        Object value = get(column);
        if (value == null) {
            return 0;
        }
        if (value instanceof Number) {
            return ((Number) value).longValue();
        }
        return Long.parseLong(value.toString());
    }

    public short getShort(int column) {
        Object value = get(column);
        if (value == null) {
            return (short) 0;
        }
        if (value instanceof Number) {
            return ((Number) value).shortValue();
        }
        return Short.parseShort(value.toString());
    }

    public String getString(int column) {
        Object value = get(column);
        if (value == null) {
            return null;
        }
        return value.toString();
    }

    public boolean isNull(int column) {
        return get(column) == null;
    }

    public byte[] getBlob(int column) {
        return (byte[]) get(column);
    }

    public int getType(int column) {
        return DatabaseUtils.getTypeOfObject(get(column));
    }

    private Object get(int column) {
        if (column < 0 || column >= this.mColumnCount) {
            throw new CursorIndexOutOfBoundsException("Requested column: " + column + ", # of columns: " + this.mColumnCount);
        } else if (this.mPos < 0) {
            throw new CursorIndexOutOfBoundsException("Before first row.");
        } else if (this.mPos < this.mRowCount) {
            return this.mData[this.mPos][column];
        } else {
            throw new CursorIndexOutOfBoundsException("After last row.");
        }
    }
}
