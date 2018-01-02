package com.songbirdnest.database.cookies;

import android.database.sqlite.SQLiteDatabase;
import com.songbirdnest.database.Database;
import com.songbirdnest.database.Table;

public class CookieDatabase extends Database {
    private Table cookieTable = new CookieTable();

    public CookieDatabase(SQLiteDatabase database) {
        super(database);
        addTable(this.cookieTable);
    }
}
