package com.miui.player.util.cursors;

import android.database.Cursor;
import android.database.CursorWrapper;

public class RowMappedCursor extends CursorWrapper {
    private final int[] mPositionMap;
    private int mRow = -1;

    public RowMappedCursor(Cursor cursor, int[] positionMap) {
        super(cursor);
        if (cursor == null) {
            throw new IllegalArgumentException("Bad src cursor == null");
        } else if (positionMap == null) {
            throw new IllegalArgumentException("Bad src posMap == null");
        } else {
            this.mPositionMap = positionMap;
        }
    }

    protected boolean onMove(int oldPosition, int newPosition) {
        this.mRow = newPosition;
        if (isAfterLast() || isBeforeFirst()) {
            return false;
        }
        if (super.moveToPosition(this.mPositionMap[newPosition])) {
            return true;
        }
        this.mRow = -1;
        return false;
    }

    public int getPosition() {
        return this.mRow;
    }

    public final boolean move(int offset) {
        return moveToPosition(getPosition() + offset);
    }

    public final boolean moveToPosition(int position) {
        int current = getPosition();
        if (current == position) {
            return true;
        }
        return onMove(current, position);
    }

    public final boolean moveToFirst() {
        return moveToPosition(0);
    }

    public final boolean moveToLast() {
        return moveToPosition(getCount());
    }

    public final boolean moveToNext() {
        return moveToPosition(getPosition() + 1);
    }

    public final boolean moveToPrevious() {
        return moveToPosition(getPosition() - 1);
    }

    public String[] getColumnNames() {
        return getWrappedCursor().getColumnNames();
    }

    public int getCount() {
        return this.mPositionMap.length;
    }

    public boolean isAfterLast() {
        return this.mRow >= getCount();
    }

    public boolean isBeforeFirst() {
        return this.mRow < 0;
    }

    public boolean isFirst() {
        return this.mRow == 0;
    }

    public boolean isLast() {
        return this.mRow == getCount() + -1;
    }
}
