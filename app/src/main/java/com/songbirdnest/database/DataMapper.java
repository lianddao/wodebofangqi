package com.songbirdnest.database;

import android.content.ContentValues;
import android.database.Cursor;

public interface DataMapper<T> {
    void read(Cursor cursor, Column column, T t);

    void write(ContentValues contentValues, Column column, T t);
}
