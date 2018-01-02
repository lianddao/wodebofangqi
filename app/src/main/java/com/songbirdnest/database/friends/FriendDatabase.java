package com.songbirdnest.database.friends;

import android.database.sqlite.SQLiteDatabase;
import com.songbirdnest.database.Database;
import com.songbirdnest.database.Table;

public class FriendDatabase extends Database {
    private Table photoTable = new PhotoTable();

    public FriendDatabase(SQLiteDatabase database) {
        super(database);
        addTable(this.photoTable);
        addTable(new FriendTable());
    }
}
