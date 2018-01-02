package com.songbirdnest.database.analytics;

import android.database.sqlite.SQLiteDatabase;
import com.songbirdnest.database.Database;
import com.songbirdnest.database.Table;

public class AnalyticsDB extends Database {
    private Table eventTable = new EventTable();
    private Table propertyTable;

    public AnalyticsDB(SQLiteDatabase database) {
        super(database);
        addTable(this.eventTable);
        this.propertyTable = new PropertyTable();
        addTable(this.propertyTable);
    }
}
