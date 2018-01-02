package com.songbirdnest.database;

import android.database.Cursor;
import android.os.Bundle;

public class CursorWrapper extends android.database.CursorWrapper {
    private Bundle mExtras = null;

    public CursorWrapper(Cursor aCursor, Bundle aBundle) {
        super(aCursor);
        this.mExtras = aBundle;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }
}
