package com.songbirdnest.database.cookies;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.songbirdnest.database.Database;
import com.songbirdnest.util.Logger;
import org.apache.http.client.CookieStore;

public class CookieDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE = "cookies.db";
    protected static CookieDatabaseHelper mHelper = null;
    private static final int version = 1;
    private Database cookieDatabase;
    private CookieTable cookieTable;
    protected boolean created = false;
    private SQLiteDatabase database;
    protected boolean opened = false;

    public CookieDatabaseHelper(Context context) {
        super(context, DATABASE, null, 1);
    }

    public static synchronized CookieDatabaseHelper getInstance(Context pContext) {
        CookieDatabaseHelper cookieDatabaseHelper;
        synchronized (CookieDatabaseHelper.class) {
            if (mHelper == null) {
                mHelper = new CookieDatabaseHelper(pContext);
            }
            cookieDatabaseHelper = mHelper;
        }
        return cookieDatabaseHelper;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(SQLiteDatabase r5) {
        /*
        r4 = this;
        r2 = 1;
        r4.created = r2;
        r2 = "SELECT name FROM sqlite_master WHERE type='table' AND name='cookies'";
        r3 = 0;
        r0 = r5.rawQuery(r2, r3);
        r4.database = r5;
        r4.createLocalDB();
        r2 = r0.getCount();	 Catch:{ SQLiteException -> 0x001e }
        if (r2 != 0) goto L_0x001a;
    L_0x0015:
        r2 = r4.cookieDatabase;	 Catch:{ SQLiteException -> 0x001e }
        r2.createDatabase();	 Catch:{ SQLiteException -> 0x001e }
    L_0x001a:
        r0.close();
    L_0x001d:
        return;
    L_0x001e:
        r1 = move-exception;
        r2 = r1.getMessage();	 Catch:{ all -> 0x002a }
        com.songbirdnest.util.Logger.error(r4, r2);	 Catch:{ all -> 0x002a }
        r0.close();
        goto L_0x001d;
    L_0x002a:
        r2 = move-exception;
        r0.close();
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.songbirdnest.database.cookies.CookieDatabaseHelper.onCreate(android.database.sqlite.SQLiteDatabase):void");
    }

    public synchronized void open() {
        if (this.opened) {
            Logger.error((Object) this, "DB Already opened");
        }
        this.opened = true;
        this.database = getWritableDatabase();
        if (this.created) {
            createLocalDB();
        } else {
            onCreate(this.database);
        }
    }

    private void createLocalDB() {
        this.cookieDatabase = new CookieDatabase(this.database);
        this.cookieTable = (CookieTable) this.cookieDatabase.getTable(CookieTable.TABLE_NAME);
    }

    public synchronized void close() {
        if (this.opened && this.database != null) {
            super.close();
        }
        this.opened = false;
    }

    public static int getVersion() {
        return 1;
    }

    public void dropDatabase() {
        this.cookieDatabase.dropDatabase();
        onCreate(this.database);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.database = db;
        this.cookieDatabase = new CookieDatabase(db);
        if (oldVersion != newVersion) {
            dropDatabase();
        }
    }

    public synchronized void deleteAllCookies() {
        if (!this.opened) {
            open();
        }
        this.cookieTable.deleteAllEntries(this.cookieDatabase);
    }

    public synchronized void addCookieStore(CookieStore cookieStore) {
        if (!this.opened) {
            open();
        }
        deleteAllCookies();
        this.cookieTable.addCookieStore(this.cookieDatabase, cookieStore);
    }

    public synchronized CookieStore getCookieStore() {
        if (!this.opened) {
            open();
        }
        return this.cookieTable.getCookieStore(this.cookieDatabase);
    }
}
