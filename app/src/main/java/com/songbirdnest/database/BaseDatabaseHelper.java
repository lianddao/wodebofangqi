package com.songbirdnest.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.songbirdnest.util.Logger;
import java.util.List;

public class BaseDatabaseHelper extends SQLiteOpenHelper {
    protected Context context;
    protected Database localDatabase;
    protected String mainTableName;
    protected SQLiteDatabase sqLiteDatabase;
    protected STATE state = STATE.NEW;
    protected int version = 1;

    protected enum STATE {
        NEW,
        CREATED,
        CLOSED,
        OPENING,
        OPEN
    }

    protected BaseDatabaseHelper(Context context, String databaseName, String mainTableName, int version) {
        super(context, databaseName, null, version);
        this.context = context;
        this.mainTableName = mainTableName;
        this.version = version;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(SQLiteDatabase r5) {
        /*
        r4 = this;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "SELECT name FROM sqlite_master WHERE type='table' AND name='";
        r2 = r2.append(r3);
        r3 = r4.mainTableName;
        r2 = r2.append(r3);
        r3 = "'";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r3 = 0;
        r0 = r5.rawQuery(r2, r3);
        r4.sqLiteDatabase = r5;
        r4.createLocalDB();
        r2 = r0.getCount();	 Catch:{ SQLiteException -> 0x0038 }
        if (r2 != 0) goto L_0x0034;
    L_0x002b:
        r2 = r4.localDatabase;	 Catch:{ SQLiteException -> 0x0038 }
        r2.createDatabase();	 Catch:{ SQLiteException -> 0x0038 }
        r2 = com.songbirdnest.database.BaseDatabaseHelper.STATE.CREATED;	 Catch:{ SQLiteException -> 0x0038 }
        r4.state = r2;	 Catch:{ SQLiteException -> 0x0038 }
    L_0x0034:
        r0.close();
    L_0x0037:
        return;
    L_0x0038:
        r1 = move-exception;
        r2 = r1.getMessage();	 Catch:{ all -> 0x0044 }
        com.songbirdnest.util.Logger.error(r4, r2);	 Catch:{ all -> 0x0044 }
        r0.close();
        goto L_0x0037;
    L_0x0044:
        r2 = move-exception;
        r0.close();
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.songbirdnest.database.BaseDatabaseHelper.onCreate(android.database.sqlite.SQLiteDatabase):void");
    }

    protected boolean isOpen() {
        return this.state == STATE.OPEN;
    }

    public synchronized void open() {
        if (!(this.state == STATE.OPEN || this.state == STATE.OPENING)) {
            try {
                STATE oldState = this.state;
                this.state = STATE.OPENING;
                this.sqLiteDatabase = getWritableDatabase();
                this.state = oldState;
                if (this.state == STATE.NEW) {
                    onCreate(this.sqLiteDatabase);
                } else {
                    createLocalDB();
                }
                this.state = STATE.OPEN;
            } catch (SQLiteException e) {
                Logger.error(this, "Problems opening database " + this.mainTableName, e);
            } catch (IllegalStateException e2) {
                Logger.error(this, "Problems opening database " + this.mainTableName, e2);
            }
        }
    }

    protected void createLocalDB() {
        this.localDatabase = new Database(this.sqLiteDatabase);
    }

    public synchronized void close() {
        if (this.state != STATE.CLOSED) {
            if (!(this.state == STATE.CLOSED || this.state == STATE.OPENING || this.sqLiteDatabase == null)) {
                super.close();
            }
            this.state = STATE.CLOSED;
            this.sqLiteDatabase = null;
            this.localDatabase = null;
        }
    }

    public int getVersion() {
        return this.version;
    }

    public void dropDatabase() {
        open();
        this.localDatabase.dropDatabase();
        onCreate(this.sqLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.sqLiteDatabase = db;
        createLocalDB();
        if (oldVersion != newVersion) {
            dropDatabase();
        }
    }

    public synchronized void execSQL(String sql) {
        try {
            open();
            this.sqLiteDatabase.execSQL(sql);
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
    }

    public synchronized Cursor rawQuery(String sql, String[] selectionArgs) {
        Cursor rawQuery;
        try {
            open();
            rawQuery = this.sqLiteDatabase.rawQuery(sql, selectionArgs);
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
            rawQuery = null;
        }
        return rawQuery;
    }

    public synchronized Object insertEntry(TableEntry table, Object data) {
        open();
        return table.getTable().insertEntry(this.localDatabase, data);
    }

    public synchronized long insertEntry(TableEntry table, List<String> data) {
        open();
        return table.getTable().insertEntry(this.localDatabase, (List) data);
    }

    public synchronized void deleteEntry(TableEntry table, Object data) {
        open();
        table.getTable().deleteEntry(this.localDatabase, data);
    }

    public synchronized void deleteEntryWhere(TableEntry table, String whereClause, String[] whereArgs) {
        open();
        table.getTable().deleteEntryWhere(this.localDatabase, whereClause, whereArgs);
    }

    public synchronized void deleteAllEntries(TableEntry table) {
        open();
        table.getTable().deleteAllEntries(this.localDatabase);
    }

    public synchronized Object getEntry(TableEntry table, Object data) {
        open();
        return table.getTable().getEntry(this.localDatabase, data);
    }

    public synchronized Cursor getEntry(TableEntry table, long id) {
        open();
        return table.getTable().getEntry(this.localDatabase, id);
    }

    public synchronized Cursor getEntry(TableEntry table, String columnName, String columnValue) {
        open();
        return table.getTable().getEntry(this.localDatabase, columnName, columnValue);
    }

    public synchronized Object updateEntry(TableEntry table, Object data, Object key) {
        open();
        return table.getTable().updateEntry(this.localDatabase, data, key);
    }

    public synchronized int updateEntry(TableEntry table, List<String> data, Object key) {
        open();
        return table.getTable().updateEntry(this.localDatabase, (List) data, key);
    }

    public synchronized int updateEntryWhere(TableEntry table, ContentValues cv, String whereClause, String[] whereArgs) {
        open();
        return table.getTable().updateEntryWhere(this.localDatabase, cv, whereClause, whereArgs);
    }

    public synchronized Cursor getAllEntries(TableEntry table) {
        open();
        return table.getTable().getAllEntries(this.localDatabase);
    }
}
