package com.songbirdnest.util;

import android.database.AbstractCursor;

public class ZeroCursor extends AbstractCursor {
    String[] aProjection;

    public ZeroCursor(String[] projection) {
        this.aProjection = projection;
    }

    public String[] getColumnNames() {
        return this.aProjection;
    }

    public int getCount() {
        return 0;
    }

    public double getDouble(int column) {
        return 0.0d;
    }

    public float getFloat(int column) {
        return 0.0f;
    }

    public int getInt(int column) {
        return 0;
    }

    public long getLong(int column) {
        return 0;
    }

    public short getShort(int column) {
        return (short) 0;
    }

    public String getString(int column) {
        return null;
    }

    public boolean isNull(int column) {
        return false;
    }
}
