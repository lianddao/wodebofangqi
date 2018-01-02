package com.ushareit.listenit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class anv extends SQLiteOpenHelper {
    private final ans f5001a;

    public anv(Context context, ans com_ushareit_listenit_ans) {
        super(context, "ads.db", null, 3);
        if (com_ushareit_listenit_ans == null) {
            throw new IllegalArgumentException("AdDatabaseHelper can not be null");
        }
        this.f5001a = com_ushareit_listenit_ans;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (any a : this.f5001a.m6423c()) {
            a.m6403a(sQLiteDatabase);
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (any com_ushareit_listenit_any : this.f5001a.m6423c()) {
            com_ushareit_listenit_any.m6404b(sQLiteDatabase);
            com_ushareit_listenit_any.m6403a(sQLiteDatabase);
        }
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        if (!sQLiteDatabase.isReadOnly()) {
            sQLiteDatabase.execSQL("PRAGMA foreign_keys = ON;");
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 2 && i2 == 3) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS crashes");
        }
    }
}
