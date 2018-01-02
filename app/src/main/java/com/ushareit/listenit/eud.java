package com.ushareit.listenit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Pair;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.umeng.analytics.pro.C0321x;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class eud extends SQLiteOpenHelper {
    private static eud f11880a;
    private SQLiteDatabase f11881b;

    public static synchronized eud m17974a(Context context) {
        eud com_ushareit_listenit_eud;
        synchronized (eud.class) {
            if (f11880a == null) {
                f11880a = new eud(context);
            }
            com_ushareit_listenit_eud = f11880a;
        }
        return com_ushareit_listenit_eud;
    }

    public static synchronized eud m17973a() {
        eud com_ushareit_listenit_eud;
        synchronized (eud.class) {
            com_ushareit_listenit_eud = f11880a;
        }
        return com_ushareit_listenit_eud;
    }

    public static synchronized void m17978b() {
        synchronized (eud.class) {
            f11880a.close();
        }
    }

    protected eud(Context context) {
        this(context, "beyla.db", null, 3);
        this.f11881b = null;
    }

    protected eud(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS headers (_id INTEGER PRIMARY KEY,sdk_ver INTEGER ,time_zone INTEGER,commit_id TEXT,pid TEXT,app_token TEXT,app_id TEXT,device_id TEXT,release_channel TEXT,app_ver_name TEXT,app_ver_code INTEGER,os_name TEXT,os_ver TEXT,language TEXT,country TEXT,manufacturer TEXT,device_model TEXT,resolution TEXT,net_type INTEGER,account TEXT,app_device_id TEXT,mac_address TEXT,android_id TEXT,imei TEXT,cid_sn TEXT,build_num TEXT,mobile_data_type INTEGER,promotion_channel TEXT,carrier TEXT );");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (_id INTEGER PRIMARY KEY,commit_id TEXT,sn LONG,type INTEGER,name TEXT,time INTEGER,label TEXT,value INTEGER,name1 TEXT,value1 TEXT,name2 TEXT,value2 TEXT,name3 TEXT,value3 TEXT,name4 TEXT,value4 TEXT,name5 TEXT,value5 TEXT,name6 TEXT,value6 TEXT,name7 TEXT,value7 TEXT,name8 TEXT,value8 TEXT );");
        } catch (Throwable e) {
            exw.m18446a("BeylaDB", e);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i <= 1) {
            try {
                euf.m17986a(sQLiteDatabase);
            } catch (Exception e) {
                try {
                    exw.m18449b("BeylaDB", "Database upgrade failed, message:" + e.getMessage());
                    sQLiteDatabase.execSQL("drop table if exists headers");
                    sQLiteDatabase.execSQL("drop table if exists events");
                    onCreate(sQLiteDatabase);
                    return;
                } catch (Throwable e2) {
                    exw.m18446a("BeylaDB", e2);
                    return;
                }
            }
        }
        if (i <= 2) {
            euf.m17987b(sQLiteDatabase);
        }
    }

    public synchronized boolean m17982a(etq com_ushareit_listenit_etq) {
        boolean z = false;
        synchronized (this) {
            ContentValues b = m17976b(com_ushareit_listenit_etq);
            try {
                this.f11881b = getWritableDatabase();
                if (this.f11881b.insert("headers", null, b) != -1) {
                    z = true;
                }
            } catch (Throwable e) {
                exw.m18444a("BeylaDB", "add client entity failed!", e);
            }
        }
        return z;
    }

    public synchronized List<etq> m17979a(int i) {
        Cursor query;
        List<etq> list;
        Throwable e;
        List<etq> arrayList = new ArrayList();
        try {
            this.f11881b = getWritableDatabase();
            query = this.f11881b.query("headers", eue.f11882a, null, null, null, null, null, String.valueOf(i));
            try {
                if (query.moveToNext()) {
                    do {
                        arrayList.add(m17972a(query));
                    } while (query.moveToNext());
                    fbb.m18756a(query);
                    list = arrayList;
                } else {
                    fbb.m18756a(query);
                    list = arrayList;
                }
            } catch (SQLiteException e2) {
                e = e2;
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            try {
                exw.m18444a("BeylaDB", "get last session entity failed!", e);
                fbb.m18756a(query);
                list = arrayList;
                return list;
            } catch (Throwable th) {
                e = th;
                fbb.m18756a(query);
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            query = null;
            fbb.m18756a(query);
            throw e;
        }
        return list;
    }

    public synchronized boolean m17983a(List<String> list) {
        boolean z;
        try {
            this.f11881b = getWritableDatabase();
            this.f11881b.beginTransaction();
            String str = "";
            for (int i = 0; i < list.size(); i++) {
                str = str.concat((TextUtils.isEmpty(str) ? "" : "OR ") + "commit_id" + " = ?");
            }
            String[] strArr = (String[]) list.toArray(new String[list.size()]);
            this.f11881b.delete("headers", str, strArr);
            this.f11881b.delete("events", str, strArr);
            try {
                this.f11881b.setTransactionSuccessful();
                z = true;
            } catch (Throwable e) {
                exw.m18444a("BeylaDB", "remove commit item failed!", e);
                z = false;
                return z;
            } finally {
                this.f11881b.endTransaction();
            }
        } catch (Throwable e2) {
            exw.m18446a("BeylaDB", e2);
            z = false;
        }
        return z;
    }

    public synchronized boolean m17981a(eto com_ushareit_listenit_eto) {
        boolean z = false;
        synchronized (this) {
            if (com_ushareit_listenit_eto != null) {
                try {
                    this.f11881b = getWritableDatabase();
                    if (this.f11881b.insert("events", null, m17975b(com_ushareit_listenit_eto)) != -1) {
                        z = true;
                    }
                } catch (Throwable e) {
                    exw.m18444a("BeylaDB", "add event failed!", e);
                }
            }
        }
        return z;
    }

    public synchronized List<eto> m17980a(String str) {
        List<eto> arrayList;
        Cursor query;
        Throwable e;
        arrayList = new ArrayList();
        String str2 = "commit_id = ?";
        String[] strArr = new String[]{str};
        try {
            this.f11881b = getWritableDatabase();
            query = this.f11881b.query("events", null, str2, strArr, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    arrayList.add(m17977b(query));
                } catch (SQLiteException e2) {
                    e = e2;
                }
            }
            fbb.m18756a(query);
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            try {
                exw.m18444a("BeylaDB", "get events failed!", e);
                fbb.m18756a(query);
                return arrayList;
            } catch (Throwable th) {
                e = th;
                fbb.m18756a(query);
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            query = null;
            fbb.m18756a(query);
            throw e;
        }
        return arrayList;
    }

    public synchronized int m17984c() {
        Cursor cursor = null;
        int i = 0;
        synchronized (this) {
            try {
                this.f11881b = getWritableDatabase();
                cursor = this.f11881b.rawQuery("select count (*) from events", null);
                if (cursor.moveToFirst()) {
                    i = cursor.getInt(0);
                    fbb.m18756a(cursor);
                } else {
                    fbb.m18756a(cursor);
                }
            } catch (Throwable e) {
                exw.m18444a("BeylaDB", "get events count error", e);
                fbb.m18756a(cursor);
            } catch (Throwable th) {
                fbb.m18756a(cursor);
            }
        }
        return i;
    }

    public synchronized long m17985d() {
        Throwable e;
        Throwable th;
        long j = 0;
        Cursor cursor = null;
        synchronized (this) {
            try {
                String format = String.format(Locale.US, "SELECT MAX(%s) FROM %s", new Object[]{"sn", "events"});
                this.f11881b = getWritableDatabase();
                Cursor rawQuery = this.f11881b.rawQuery(format, null);
                try {
                    if (rawQuery.moveToFirst()) {
                        long j2 = rawQuery.getLong(0);
                        exw.m18443a("BeylaDB", "query max seq number:" + j2);
                        fbb.m18756a(rawQuery);
                        j = j2;
                    } else {
                        fbb.m18756a(rawQuery);
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    cursor = rawQuery;
                    try {
                        exw.m18444a("BeylaDB", "get events count error", e);
                        fbb.m18756a(cursor);
                        return j;
                    } catch (Throwable th2) {
                        th = th2;
                        fbb.m18756a(cursor);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = rawQuery;
                    fbb.m18756a(cursor);
                    throw th;
                }
            } catch (SQLiteException e3) {
                e = e3;
                exw.m18444a("BeylaDB", "get events count error", e);
                fbb.m18756a(cursor);
                return j;
            }
        }
        return j;
    }

    private ContentValues m17976b(etq com_ushareit_listenit_etq) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sdk_ver", Integer.valueOf(com_ushareit_listenit_etq.m17919a()));
        contentValues.put("time_zone", Integer.valueOf(com_ushareit_listenit_etq.m17921b()));
        contentValues.put("commit_id", com_ushareit_listenit_etq.m17922c());
        contentValues.put("pid", com_ushareit_listenit_etq.m17923d());
        contentValues.put("app_token", com_ushareit_listenit_etq.m17924e());
        contentValues.put("app_id", com_ushareit_listenit_etq.m17925f());
        if (!TextUtils.isEmpty(com_ushareit_listenit_etq.m17926g())) {
            contentValues.put(C0321x.f3860u, com_ushareit_listenit_etq.m17926g());
        }
        if (!TextUtils.isEmpty(com_ushareit_listenit_etq.m17927h())) {
            contentValues.put("release_channel", com_ushareit_listenit_etq.m17927h());
        }
        if (!TextUtils.isEmpty(com_ushareit_listenit_etq.m17929j())) {
            contentValues.put("app_ver_name", com_ushareit_listenit_etq.m17929j());
        }
        contentValues.put("app_ver_code", Integer.valueOf(com_ushareit_listenit_etq.m17928i()));
        if (!TextUtils.isEmpty(com_ushareit_listenit_etq.m17930k())) {
            contentValues.put("os_name", com_ushareit_listenit_etq.m17930k());
        }
        if (!TextUtils.isEmpty(com_ushareit_listenit_etq.m17931l())) {
            contentValues.put("os_ver", com_ushareit_listenit_etq.m17931l());
        }
        if (!TextUtils.isEmpty(com_ushareit_listenit_etq.m17932m())) {
            contentValues.put(C0321x.f3819F, com_ushareit_listenit_etq.m17932m());
        }
        if (!TextUtils.isEmpty(com_ushareit_listenit_etq.m17933n())) {
            contentValues.put(C0321x.f3820G, com_ushareit_listenit_etq.m17933n());
        }
        if (!TextUtils.isEmpty(com_ushareit_listenit_etq.m17934o())) {
            contentValues.put("manufacturer", com_ushareit_listenit_etq.m17934o());
        }
        if (!TextUtils.isEmpty(com_ushareit_listenit_etq.m17935p())) {
            contentValues.put(C0321x.f3861v, com_ushareit_listenit_etq.m17935p());
        }
        if (!TextUtils.isEmpty(com_ushareit_listenit_etq.m17936q())) {
            contentValues.put("account", com_ushareit_listenit_etq.m17936q());
        }
        if (!TextUtils.isEmpty(com_ushareit_listenit_etq.m17937r())) {
            contentValues.put("app_device_id", com_ushareit_listenit_etq.m17937r());
        }
        return contentValues;
    }

    private etq m17972a(Cursor cursor) {
        return new etq(cursor.getInt(cursor.getColumnIndex("sdk_ver")), cursor.getInt(cursor.getColumnIndex("time_zone")), cursor.getString(cursor.getColumnIndex("commit_id")), cursor.getString(cursor.getColumnIndex("pid")), cursor.getString(cursor.getColumnIndex("app_token")), cursor.getString(cursor.getColumnIndex("app_id")), cursor.getString(cursor.getColumnIndex(C0321x.f3860u)), cursor.getString(cursor.getColumnIndex("release_channel")), cursor.getInt(cursor.getColumnIndex("app_ver_code")), cursor.getString(cursor.getColumnIndex("app_ver_name")), cursor.getString(cursor.getColumnIndex("os_name")), cursor.getString(cursor.getColumnIndex("os_ver")), cursor.getString(cursor.getColumnIndex(C0321x.f3819F)), cursor.getString(cursor.getColumnIndex(C0321x.f3820G)), cursor.getString(cursor.getColumnIndex("manufacturer")), cursor.getString(cursor.getColumnIndex(C0321x.f3861v)), cursor.getString(cursor.getColumnIndex("account")), cursor.getString(cursor.getColumnIndex("app_device_id")));
    }

    private ContentValues m17975b(eto com_ushareit_listenit_eto) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("commit_id", com_ushareit_listenit_eto.m17907a());
        contentValues.put("sn", Long.valueOf(com_ushareit_listenit_eto.m17909b()));
        contentValues.put(VastExtensionXmlManager.TYPE, Integer.valueOf(com_ushareit_listenit_eto.m17910c().m17918a()));
        contentValues.put("name", com_ushareit_listenit_eto.m17912e());
        contentValues.put("time", Long.valueOf(com_ushareit_listenit_eto.m17911d()));
        if (!TextUtils.isEmpty(com_ushareit_listenit_eto.m17913f())) {
            contentValues.put("label", com_ushareit_listenit_eto.m17913f());
        }
        contentValues.put("value", Long.valueOf(com_ushareit_listenit_eto.m17914g()));
        List<Pair> h = com_ushareit_listenit_eto.m17915h();
        if (h == null || h.isEmpty()) {
            return contentValues;
        }
        int i = 1;
        for (Pair pair : h) {
            contentValues.put("name" + i, (String) pair.first);
            contentValues.put("value" + i, (String) pair.second);
            int i2 = i + 1;
            if (i >= 8) {
                break;
            }
            i = i2;
        }
        return contentValues;
    }

    private eto m17977b(Cursor cursor) {
        long j = cursor.getLong(cursor.getColumnIndex("time"));
        String string = cursor.getString(cursor.getColumnIndex("commit_id"));
        long j2 = cursor.getLong(cursor.getColumnIndex("sn"));
        int i = cursor.getInt(cursor.getColumnIndex(VastExtensionXmlManager.TYPE));
        String string2 = cursor.getString(cursor.getColumnIndex("name"));
        String string3 = cursor.getString(cursor.getColumnIndex("label"));
        long j3 = cursor.getLong(cursor.getColumnIndex("value"));
        List arrayList = new ArrayList();
        for (int i2 = 1; i2 <= 8; i2++) {
            CharSequence string4 = cursor.getString(cursor.getColumnIndex("name" + i2));
            String string5 = cursor.getString(cursor.getColumnIndex("value" + i2));
            if (!TextUtils.isEmpty(string4)) {
                arrayList.add(new Pair(string4, string5));
            }
        }
        return new eto(string, j2, etp.m17917a(i), j, string2, string3, j3, arrayList);
    }
}
