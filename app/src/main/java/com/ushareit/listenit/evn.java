package com.ushareit.listenit;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.ArrayList;
import java.util.List;

class evn {
    private static final String f11979a = fbp.m18800a("%s = ?", "_id");

    evn() {
    }

    public boolean m18184a(eva com_ushareit_listenit_eva, SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        exu.m18430a((Object) sQLiteDatabase);
        exu.m18430a((Object) com_ushareit_listenit_eva);
        Cursor query;
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query("commands", new String[]{"_id"}, f11979a, new String[]{com_ushareit_listenit_eva.m18099a()}, null, null, null);
            try {
                boolean z;
                if (query.getCount() == 0) {
                    if (sQLiteDatabase.insert("commands", null, m18179a(com_ushareit_listenit_eva)) >= 0) {
                        z = true;
                        fbb.m18756a(query);
                        return z;
                    }
                }
                z = false;
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

    public boolean m18186a(String str, evf com_ushareit_listenit_evf, SQLiteDatabase sQLiteDatabase) {
        Cursor query;
        Throwable th;
        exu.m18430a((Object) sQLiteDatabase);
        try {
            String[] strArr = new String[]{str};
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query("commands", new String[]{"_id"}, f11979a, strArr, null, null, null);
            try {
                boolean z;
                if (query.getCount() > 0) {
                    sQLiteDatabase.update("commands", m18180a(str, com_ushareit_listenit_evf), f11979a, strArr);
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

    public boolean m18185a(String str, int i, SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        exu.m18430a((Object) sQLiteDatabase);
        Cursor query;
        try {
            String[] strArr = new String[]{str};
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query("commands", new String[]{"_id"}, f11979a, strArr, null, null, null);
            try {
                boolean z;
                if (query.getCount() > 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("_id", str);
                    contentValues.put("retry_count", Integer.valueOf(i));
                    sQLiteDatabase.update("commands", contentValues, f11979a, strArr);
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

    public void m18183a(String str, SQLiteDatabase sQLiteDatabase) {
        exu.m18430a((Object) sQLiteDatabase);
        try {
            sQLiteDatabase.delete("commands", f11979a, new String[]{str});
        } finally {
            fbb.m18756a(null);
        }
    }

    public List<eva> m18182a(SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        exu.m18430a((Object) sQLiteDatabase);
        Cursor query;
        try {
            List<eva> arrayList = new ArrayList();
            query = sQLiteDatabase.query("commands", null, null, null, null, null, null);
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(m18181a(query));
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

    public List<eva> m18188b(SQLiteDatabase sQLiteDatabase) {
        Cursor query;
        Throwable th;
        exu.m18430a((Object) sQLiteDatabase);
        try {
            List<eva> arrayList = new ArrayList();
            String str = "commands";
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query(str, null, "status != ? AND status != ? AND status != ?", new String[]{evf.EXPIRED.toString(), evf.COMPLETED.toString(), evf.CANCELED.toString()}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(m18181a(query));
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

    public eva m18187b(String str, SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        Cursor cursor = null;
        exu.m18430a((Object) sQLiteDatabase);
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            Cursor query = sQLiteDatabase2.query("commands", null, f11979a, new String[]{str}, null, null, null);
            try {
                eva a;
                if (query.moveToFirst()) {
                    a = m18181a(query);
                } else {
                    a = null;
                }
                fbb.m18756a(query);
                return a;
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                fbb.m18756a(cursor);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fbb.m18756a(cursor);
            throw th;
        }
    }

    private ContentValues m18179a(eva com_ushareit_listenit_eva) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", com_ushareit_listenit_eva.m18099a());
        contentValues.put(VastExtensionXmlManager.TYPE, com_ushareit_listenit_eva.m18107b());
        contentValues.put("name", com_ushareit_listenit_eva.m18112c());
        contentValues.put("start_date", Long.valueOf(com_ushareit_listenit_eva.m18115d()));
        contentValues.put("end_date", Long.valueOf(com_ushareit_listenit_eva.m18118e()));
        contentValues.put("need_report", Integer.valueOf(1));
        contentValues.put("max_retry", Integer.valueOf(com_ushareit_listenit_eva.m18120f()));
        contentValues.put("status", com_ushareit_listenit_eva.m18125j().toString());
        contentValues.put("retry_count", Integer.valueOf(com_ushareit_listenit_eva.m18126k()));
        contentValues.put("arrived_time", Long.valueOf(com_ushareit_listenit_eva.m18131p()));
        contentValues.put("data1", "");
        contentValues.put("data2", "");
        contentValues.put("data3", "");
        contentValues.put("data4", "");
        return contentValues;
    }

    private ContentValues m18180a(String str, evf com_ushareit_listenit_evf) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", str);
        contentValues.put("status", com_ushareit_listenit_evf.toString());
        return contentValues;
    }

    private eva m18181a(Cursor cursor) {
        eva com_ushareit_listenit_eva = new eva();
        com_ushareit_listenit_eva.m18103a(cursor.getString(cursor.getColumnIndex("_id")));
        com_ushareit_listenit_eva.m18111b(cursor.getString(cursor.getColumnIndex(VastExtensionXmlManager.TYPE)));
        com_ushareit_listenit_eva.m18113c(cursor.getString(cursor.getColumnIndex("name")));
        com_ushareit_listenit_eva.m18101a(cursor.getLong(cursor.getColumnIndex("start_date")));
        com_ushareit_listenit_eva.m18110b(cursor.getLong(cursor.getColumnIndex("end_date")));
        com_ushareit_listenit_eva.m18100a(cursor.getInt(cursor.getColumnIndex("max_retry")));
        com_ushareit_listenit_eva.m18102a(evf.m18164a(cursor.getString(cursor.getColumnIndex("status"))));
        com_ushareit_listenit_eva.m18109b(cursor.getInt(cursor.getColumnIndex("retry_count")));
        com_ushareit_listenit_eva.m18116d(cursor.getLong(cursor.getColumnIndex("arrived_time")));
        return com_ushareit_listenit_eva;
    }
}
