package com.songbirdnest.database;

import android.database.AbstractCursor;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Bundle;

public class MergeCursor extends AbstractCursor {
    private Cursor mCursor;
    private Cursor[] mCursors;
    private DataSetObserver mObserver = new C00951();

    class C00951 extends DataSetObserver {
        C00951() {
        }

        public void onChanged() {
            MergeCursor.this.mPos = -1;
        }

        public void onInvalidated() {
            MergeCursor.this.mPos = -1;
        }
    }

    public MergeCursor(Cursor[] cursors) {
        if (cursors == null || cursors.length == 0) {
            throw new NullPointerException("MergeCursor: no cursors");
        }
        int i;
        int count = 0;
        for (Cursor cursor : cursors) {
            if (cursor != null) {
                count++;
            }
        }
        if (count == 0) {
            throw new NullPointerException("MergeCursor: NULL cursor ");
        }
        this.mCursors = cursors;
        this.mCursor = cursors[0];
        for (i = 0; i < this.mCursors.length; i++) {
            if (this.mCursors[i] != null) {
                this.mCursors[i].registerDataSetObserver(this.mObserver);
            }
        }
    }

    public int getCount() {
        int count = 0;
        int length = this.mCursors.length;
        int i = 0;
        while (i < length) {
            if (!(this.mCursors[i] == null || this.mCursors[i].isClosed())) {
                count += this.mCursors[i].getCount();
            }
            i++;
        }
        return count;
    }

    public boolean onMove(int oldPosition, int newPosition) {
        this.mCursor = null;
        int cursorStartPos = 0;
        int length = this.mCursors.length;
        for (int i = 0; i < length; i++) {
            if (this.mCursors[i] != null) {
                if (newPosition < this.mCursors[i].getCount() + cursorStartPos) {
                    this.mCursor = this.mCursors[i];
                    break;
                }
                cursorStartPos += this.mCursors[i].getCount();
            }
        }
        if (this.mCursor != null) {
            return this.mCursor.moveToPosition(newPosition - cursorStartPos);
        }
        return false;
    }

    public String getString(int column) {
        return this.mCursor.getString(column);
    }

    public short getShort(int column) {
        return this.mCursor.getShort(column);
    }

    public int getInt(int column) {
        return this.mCursor.getInt(column);
    }

    public long getLong(int column) {
        return this.mCursor.getLong(column);
    }

    public float getFloat(int column) {
        return this.mCursor.getFloat(column);
    }

    public double getDouble(int column) {
        return this.mCursor.getDouble(column);
    }

    public boolean isNull(int column) {
        return this.mCursor.isNull(column);
    }

    public byte[] getBlob(int column) {
        return this.mCursor.getBlob(column);
    }

    public String[] getColumnNames() {
        if (this.mCursor != null) {
            return this.mCursor.getColumnNames();
        }
        return new String[0];
    }

    public Bundle getExtras() {
        return this.mCursor.getExtras();
    }

    public void deactivate() {
        int length = this.mCursors.length;
        for (int i = 0; i < length; i++) {
            if (this.mCursors[i] != null) {
                this.mCursors[i].deactivate();
            }
        }
        super.deactivate();
    }

    public void close() {
        int length = this.mCursors.length;
        for (int i = 0; i < length; i++) {
            if (this.mCursors[i] != null) {
                this.mCursors[i].close();
            }
        }
        super.close();
    }

    public void registerContentObserver(ContentObserver observer) {
        int length = this.mCursors.length;
        for (int i = 0; i < length; i++) {
            if (this.mCursors[i] != null) {
                this.mCursors[i].registerContentObserver(observer);
            }
        }
    }

    public void unregisterContentObserver(ContentObserver observer) {
        int length = this.mCursors.length;
        for (int i = 0; i < length; i++) {
            if (this.mCursors[i] != null) {
                this.mCursors[i].unregisterContentObserver(observer);
            }
        }
    }

    public void registerDataSetObserver(DataSetObserver observer) {
        int length = this.mCursors.length;
        for (int i = 0; i < length; i++) {
            if (this.mCursors[i] != null) {
                this.mCursors[i].registerDataSetObserver(observer);
            }
        }
    }

    public void unregisterDataSetObserver(DataSetObserver observer) {
        int length = this.mCursors.length;
        for (int i = 0; i < length; i++) {
            if (this.mCursors[i] != null) {
                this.mCursors[i].unregisterDataSetObserver(observer);
            }
        }
    }

    public boolean requery() {
        int length = this.mCursors.length;
        int i = 0;
        while (i < length) {
            if (this.mCursors[i] != null && !this.mCursors[i].requery()) {
                return false;
            }
            i++;
        }
        return true;
    }
}
