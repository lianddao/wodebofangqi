package com.songbirdnest.billing.db;

import android.database.sqlite.SQLiteDatabase;
import com.songbirdnest.database.Database;

public class BillingDatabase extends Database {
    public BillingDatabase(SQLiteDatabase database) {
        super(database);
        addTable(new HistoryTable());
        addTable(new PurchasedTable());
    }
}
