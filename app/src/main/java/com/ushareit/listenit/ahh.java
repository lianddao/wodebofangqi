package com.ushareit.listenit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class ahh extends SQLiteOpenHelper implements ahj {
    private static final String[] f4362a = new String[]{"_id", "url", "length", "mime"};

    ahh(Context context) {
        super(context, "AndroidVideoCache.db", null, 1);
        ago.m5589a((Object) context);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        ago.m5589a((Object) sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    public agv mo631a(String str) {
        Throwable th;
        Cursor cursor = null;
        ago.m5589a((Object) str);
        try {
            agv a;
            Cursor query = getReadableDatabase().query("SourceInfo", f4362a, "url=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        a = m5634a(query);
                        if (query != null) {
                            query.close();
                        }
                        return a;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            a = null;
            if (query != null) {
                query.close();
            }
            return a;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void mo633a(String str, agv com_ushareit_listenit_agv) {
        ago.m5593a(str, com_ushareit_listenit_agv);
        int i = mo631a(str) != null ? 1 : 0;
        ContentValues a = m5633a(com_ushareit_listenit_agv);
        if (i != 0) {
            getWritableDatabase().update("SourceInfo", a, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, a);
        }
    }

    public void mo632a() {
        close();
    }

    private agv m5634a(Cursor cursor) {
        return new agv(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    private ContentValues m5633a(agv com_ushareit_listenit_agv) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", com_ushareit_listenit_agv.f4349a);
        contentValues.put("length", Long.valueOf(com_ushareit_listenit_agv.f4350b));
        contentValues.put("mime", com_ushareit_listenit_agv.f4351c);
        return contentValues;
    }
}
