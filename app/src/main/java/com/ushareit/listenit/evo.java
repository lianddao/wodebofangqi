package com.ushareit.listenit;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class evo {
    private static final String f11980a = fbp.m18800a("%s = ?", "cmd_id");

    evo() {
    }

    public boolean m18194a(String str, Map<String, String> map, SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        Cursor cursor;
        exu.m18430a((Object) sQLiteDatabase);
        exu.m18430a((Object) map);
        try {
            String[] strArr = new String[]{str};
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            Cursor query = sQLiteDatabase2.query("properties", new String[]{"cmd_id"}, f11980a, strArr, null, null, null);
            try {
                if (query.getCount() != 0) {
                    sQLiteDatabase.delete("properties", f11980a, strArr);
                }
                for (Entry key : map.entrySet()) {
                    String str2 = (String) key.getKey();
                    sQLiteDatabase.insert("properties", null, m18189a(str, str2, (String) map.get(str2)));
                }
                fbb.m18756a(query);
                return true;
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                fbb.m18756a(cursor);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            fbb.m18756a(cursor);
            throw th;
        }
    }

    public boolean m18193a(String str, String str2, String str3, SQLiteDatabase sQLiteDatabase) {
        Cursor query;
        Throwable th;
        exu.m18430a((Object) sQLiteDatabase);
        try {
            String[] strArr = new String[]{"cmd_id"};
            String a = fbp.m18800a("%s = ? AND %s = ?", "cmd_id", "prop_key");
            String[] strArr2 = new String[]{str, str2};
            query = sQLiteDatabase.query("properties", strArr, a, strArr2, null, null, null);
            try {
                boolean z;
                ContentValues a2 = m18189a(str, str2, str3);
                if (query.getCount() == 0) {
                    if (sQLiteDatabase.insert("properties", null, a2) >= 0) {
                        z = true;
                    }
                    z = false;
                } else {
                    sQLiteDatabase.update("properties", a2, a, strArr2);
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

    public void m18192a(String str, SQLiteDatabase sQLiteDatabase) {
        exu.m18430a((Object) sQLiteDatabase);
        try {
            sQLiteDatabase.delete("properties", f11980a, new String[]{str});
        } finally {
            fbb.m18756a(null);
        }
    }

    public Map<String, String> m18195b(String str, SQLiteDatabase sQLiteDatabase) {
        Cursor query;
        Throwable th;
        exu.m18430a((Object) sQLiteDatabase);
        try {
            Map<String, String> hashMap = new HashMap();
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query("properties", null, f11980a, new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    do {
                        Pair a = m18190a(query);
                        hashMap.put(a.first, a.second);
                    } while (query.moveToNext());
                    fbb.m18756a(query);
                    return hashMap;
                }
                fbb.m18756a(query);
                return hashMap;
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

    public List<String> m18191a(String str, String str2, SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        exu.m18430a((Object) sQLiteDatabase);
        Cursor query;
        try {
            List<String> arrayList = new ArrayList();
            String str3 = "properties";
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query(str3, null, "prop_key = ? AND prop_value = ?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(query.getString(query.getColumnIndex("cmd_id")));
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

    private ContentValues m18189a(String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("cmd_id", str);
        contentValues.put("prop_key", str2);
        contentValues.put("prop_value", str3);
        return contentValues;
    }

    private Pair<String, String> m18190a(Cursor cursor) {
        return new Pair(cursor.getString(cursor.getColumnIndex("prop_key")), cursor.getString(cursor.getColumnIndex("prop_value")));
    }
}
