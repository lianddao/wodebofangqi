package com.ushareit.listenit;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

class evq {
    private static final String f11985a = fbp.m18800a("%s = ? AND %s = ?", "cmd_id", "status");
    private static final String f11986b = ("select count(*) from " + "report");

    evq() {
    }

    public int m18199a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        int i = 0;
        exu.m18430a((Object) sQLiteDatabase);
        try {
            cursor = sQLiteDatabase.rawQuery(f11986b, null);
            if (cursor.moveToFirst()) {
                i = cursor.getInt(0);
            } else {
                fbb.m18756a(cursor);
            }
            return i;
        } finally {
            fbb.m18756a(cursor);
        }
    }

    public boolean m18200a(evp com_ushareit_listenit_evp, SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        exu.m18430a((Object) sQLiteDatabase);
        exu.m18430a((Object) com_ushareit_listenit_evp);
        Cursor query;
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query("report", new String[]{"cmd_id"}, f11985a, new String[]{com_ushareit_listenit_evp.f11981a, com_ushareit_listenit_evp.f11982b}, null, null, null);
            try {
                boolean z;
                if (query.getCount() == 0) {
                    sQLiteDatabase.insert("report", null, m18197a(com_ushareit_listenit_evp));
                    z = true;
                } else {
                    z = false;
                }
                fbb.m18756a(query);
                return z;
            } catch (Throwable th2) {
                th = th2;
                fbb.m18756a(query);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            fbb.m18756a(query);
            throw th;
        }
    }

    public void m18202b(evp com_ushareit_listenit_evp, SQLiteDatabase sQLiteDatabase) {
        exu.m18430a((Object) sQLiteDatabase);
        try {
            sQLiteDatabase.delete("report", f11985a, new String[]{com_ushareit_listenit_evp.f11981a, com_ushareit_listenit_evp.f11982b});
        } finally {
            fbb.m18756a(null);
        }
    }

    public List<evp> m18201b(SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        exu.m18430a((Object) sQLiteDatabase);
        Cursor query;
        try {
            List<evp> arrayList = new ArrayList();
            query = sQLiteDatabase.query("report", null, null, null, null, null, null);
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(m18198a(query));
                    } while (query.moveToNext());
                    fbb.m18756a(query);
                    return arrayList;
                }
                fbb.m18756a(query);
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            fbb.m18756a(query);
            throw th;
        }
    }

    private ContentValues m18197a(evp com_ushareit_listenit_evp) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("cmd_id", com_ushareit_listenit_evp.f11981a);
        contentValues.put("status", com_ushareit_listenit_evp.f11982b);
        contentValues.put("detail", com_ushareit_listenit_evp.f11983c);
        contentValues.put("duration", Long.valueOf(com_ushareit_listenit_evp.f11984d));
        return contentValues;
    }

    private evp m18198a(Cursor cursor) {
        evp com_ushareit_listenit_evp = new evp();
        com_ushareit_listenit_evp.f11981a = cursor.getString(cursor.getColumnIndex("cmd_id"));
        com_ushareit_listenit_evp.f11982b = cursor.getString(cursor.getColumnIndex("status"));
        com_ushareit_listenit_evp.f11983c = cursor.getString(cursor.getColumnIndex("detail"));
        com_ushareit_listenit_evp.f11984d = cursor.getLong(cursor.getColumnIndex("duration"));
        return com_ushareit_listenit_evp;
    }
}
