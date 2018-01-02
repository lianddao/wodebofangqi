package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.umeng.analytics.pro.C0321x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class dwo extends duy {
    private static final Map<String, String> f10480a = new fq(17);
    private static final Map<String, String> f10481b = new fq(1);
    private static final Map<String, String> f10482c = new fq(1);
    private final dwr f10483d = new dwr(this, mo2090q(), m16079B());
    private final dwf f10484e = new dwf(mo2089p());

    static {
        f10480a.put(C0321x.f3843d, "ALTER TABLE apps ADD COLUMN app_version TEXT;");
        f10480a.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
        f10480a.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
        f10480a.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
        f10480a.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
        f10480a.put("last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;");
        f10480a.put("day", "ALTER TABLE apps ADD COLUMN day INTEGER;");
        f10480a.put("daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;");
        f10480a.put("daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;");
        f10480a.put("daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;");
        f10480a.put("remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;");
        f10480a.put("config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;");
        f10480a.put("failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;");
        f10480a.put("app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;");
        f10480a.put("firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;");
        f10480a.put("daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;");
        f10480a.put("daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;");
        f10481b.put("realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;");
        f10482c.put("has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;");
    }

    dwo(dyf com_ushareit_listenit_dyf) {
        super(com_ushareit_listenit_dyf);
    }

    private boolean m16070N() {
        return mo2090q().getDatabasePath(m16079B()).exists();
    }

    @TargetApi(11)
    static int m16071a(Cursor cursor, int i) {
        if (VERSION.SDK_INT >= 11) {
            return cursor.getType(i);
        }
        CursorWindow window = ((SQLiteCursor) cursor).getWindow();
        int position = cursor.getPosition();
        return window.isNull(position, i) ? 0 : window.isLong(position, i) ? 1 : window.isFloat(position, i) ? 2 : window.isString(position, i) ? 3 : window.isBlob(position, i) ? 4 : -1;
    }

    private long m16072a(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = m16078A().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            mo2096w().m16242f().m16265a("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private long m16073a(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            cursor = m16078A().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            mo2096w().m16242f().m16265a("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private void m16075a(String str, drf com_ushareit_listenit_drf) {
        Object obj = null;
        m15696c();
        mo2083j();
        cfi.m11082a(str);
        cfi.m11080a((Object) com_ushareit_listenit_drf);
        cfi.m11080a(com_ushareit_listenit_drf.f10181c);
        cfi.m11080a(com_ushareit_listenit_drf.f10180b);
        if (com_ushareit_listenit_drf.f10179a == null) {
            mo2096w().m16262z().m16263a("Audience with no ID");
            return;
        }
        int intValue = com_ushareit_listenit_drf.f10179a.intValue();
        for (drg com_ushareit_listenit_drg : com_ushareit_listenit_drf.f10181c) {
            if (com_ushareit_listenit_drg.f10183a == null) {
                mo2096w().m16262z().m16265a("Event filter with no ID. Audience definition ignored. appId, audienceId", str, com_ushareit_listenit_drf.f10179a);
                return;
            }
        }
        for (drj com_ushareit_listenit_drj : com_ushareit_listenit_drf.f10180b) {
            if (com_ushareit_listenit_drj.f10199a == null) {
                mo2096w().m16262z().m16265a("Property filter with no ID. Audience definition ignored. appId, audienceId", str, com_ushareit_listenit_drf.f10179a);
                return;
            }
        }
        Object obj2 = 1;
        for (drg a : com_ushareit_listenit_drf.f10181c) {
            if (!m16076a(str, intValue, a)) {
                obj2 = null;
                break;
            }
        }
        if (obj2 != null) {
            for (drj a2 : com_ushareit_listenit_drf.f10180b) {
                if (!m16077a(str, intValue, a2)) {
                    break;
                }
            }
        }
        obj = obj2;
        if (obj == null) {
            m16111b(str, intValue);
        }
    }

    private boolean m16076a(String str, int i, drg com_ushareit_listenit_drg) {
        m15696c();
        mo2083j();
        cfi.m11082a(str);
        cfi.m11080a((Object) com_ushareit_listenit_drg);
        if (TextUtils.isEmpty(com_ushareit_listenit_drg.f10184b)) {
            mo2096w().m16262z().m16265a("Event filter had no event name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(com_ushareit_listenit_drg.f10183a));
            return false;
        }
        try {
            byte[] bArr = new byte[com_ushareit_listenit_drg.m13475g()];
            dga a = dga.m14159a(bArr);
            com_ushareit_listenit_drg.mo1666a(a);
            a.m14204b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", com_ushareit_listenit_drg.f10183a);
            contentValues.put("event_name", com_ushareit_listenit_drg.f10184b);
            contentValues.put("data", bArr);
            try {
                if (m16078A().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                    mo2096w().m16242f().m16263a("Failed to insert event filter (got -1)");
                }
                return true;
            } catch (SQLiteException e) {
                mo2096w().m16242f().m16264a("Error storing event filter", e);
                return false;
            }
        } catch (IOException e2) {
            mo2096w().m16242f().m16264a("Configuration loss. Failed to serialize event filter", e2);
            return false;
        }
    }

    private boolean m16077a(String str, int i, drj com_ushareit_listenit_drj) {
        m15696c();
        mo2083j();
        cfi.m11082a(str);
        cfi.m11080a((Object) com_ushareit_listenit_drj);
        if (TextUtils.isEmpty(com_ushareit_listenit_drj.f10200b)) {
            mo2096w().m16262z().m16265a("Property filter had no property name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(com_ushareit_listenit_drj.f10199a));
            return false;
        }
        try {
            byte[] bArr = new byte[com_ushareit_listenit_drj.m13475g()];
            dga a = dga.m14159a(bArr);
            com_ushareit_listenit_drj.mo1666a(a);
            a.m14204b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", com_ushareit_listenit_drj.f10199a);
            contentValues.put("property_name", com_ushareit_listenit_drj.f10200b);
            contentValues.put("data", bArr);
            try {
                if (m16078A().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                mo2096w().m16242f().m16263a("Failed to insert property filter (got -1)");
                return false;
            } catch (SQLiteException e) {
                mo2096w().m16242f().m16264a("Error storing property filter", e);
                return false;
            }
        } catch (IOException e2) {
            mo2096w().m16242f().m16264a("Configuration loss. Failed to serialize property filter", e2);
            return false;
        }
    }

    SQLiteDatabase m16078A() {
        mo2083j();
        try {
            return this.f10483d.getWritableDatabase();
        } catch (SQLiteException e) {
            mo2096w().m16262z().m16264a("Error opening database", e);
            throw e;
        }
    }

    String m16079B() {
        if (!mo2098y().m16015N()) {
            return mo2098y().m16012K();
        }
        if (mo2098y().m16016O()) {
            return mo2098y().m16012K();
        }
        mo2096w().m16231A().m16263a("Using secondary database");
        return mo2098y().m16013L();
    }

    public String m16080C() {
        Cursor rawQuery;
        Object e;
        Throwable th;
        String str = null;
        try {
            rawQuery = m16078A().rawQuery("select app_id from queue where app_id not in (select app_id from apps where measurement_enabled=0) order by has_realtime desc, rowid asc limit 1;", null);
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo2096w().m16242f().m16264a("Database error getting next bundle app id", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = null;
            mo2096w().m16242f().m16264a("Database error getting next bundle app id", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            rawQuery = null;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    public boolean m16081D() {
        return m16072a("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    void m16082E() {
        mo2083j();
        m15696c();
        if (m16070N()) {
            long a = mo2097x().f10597f.m16328a();
            long b = mo2089p().mo1371b();
            if (Math.abs(b - a) > mo2098y().m16021T()) {
                mo2097x().f10597f.m16329a(b);
                m16083F();
            }
        }
    }

    void m16083F() {
        mo2083j();
        m15696c();
        if (m16070N()) {
            int delete = m16078A().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(mo2089p().mo1370a()), String.valueOf(mo2098y().m16020S())});
            if (delete > 0) {
                mo2096w().m16235E().m16264a("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    public long m16084G() {
        return m16073a("select max(bundle_end_timestamp) from queue", null, 0);
    }

    public long m16085H() {
        return m16073a("select max(timestamp) from raw_events", null, 0);
    }

    public boolean m16086I() {
        return m16072a("select count(1) > 0 from raw_events", null) != 0;
    }

    public boolean m16087J() {
        return m16072a("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public long m16088a(dru com_ushareit_listenit_dru) {
        mo2083j();
        m15696c();
        cfi.m11080a((Object) com_ushareit_listenit_dru);
        cfi.m11082a(com_ushareit_listenit_dru.f10259p);
        try {
            byte[] bArr = new byte[com_ushareit_listenit_dru.m13475g()];
            dga a = dga.m14159a(bArr);
            com_ushareit_listenit_dru.mo1666a(a);
            a.m14204b();
            long d = mo2092s().m15966d(bArr);
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", com_ushareit_listenit_dru.f10259p);
            contentValues.put("metadata_fingerprint", Long.valueOf(d));
            contentValues.put("metadata", bArr);
            try {
                m16078A().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return d;
            } catch (SQLiteException e) {
                mo2096w().m16242f().m16264a("Error storing raw event metadata", e);
                throw e;
            }
        } catch (IOException e2) {
            mo2096w().m16242f().m16264a("Data loss. Failed to serialize event metadata", e2);
            throw e2;
        }
    }

    public dwp m16089a(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Object e;
        Throwable th;
        cfi.m11082a(str);
        mo2083j();
        m15696c();
        String[] strArr = new String[]{str};
        dwp com_ushareit_listenit_dwp = new dwp();
        Cursor query;
        try {
            SQLiteDatabase A = m16078A();
            query = A.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    if (query.getLong(0) == j) {
                        com_ushareit_listenit_dwp.f10486b = query.getLong(1);
                        com_ushareit_listenit_dwp.f10485a = query.getLong(2);
                        com_ushareit_listenit_dwp.f10487c = query.getLong(3);
                        com_ushareit_listenit_dwp.f10488d = query.getLong(4);
                        com_ushareit_listenit_dwp.f10489e = query.getLong(5);
                    }
                    if (z) {
                        com_ushareit_listenit_dwp.f10486b++;
                    }
                    if (z2) {
                        com_ushareit_listenit_dwp.f10485a++;
                    }
                    if (z3) {
                        com_ushareit_listenit_dwp.f10487c++;
                    }
                    if (z4) {
                        com_ushareit_listenit_dwp.f10488d++;
                    }
                    if (z5) {
                        com_ushareit_listenit_dwp.f10489e++;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(com_ushareit_listenit_dwp.f10485a));
                    contentValues.put("daily_events_count", Long.valueOf(com_ushareit_listenit_dwp.f10486b));
                    contentValues.put("daily_conversions_count", Long.valueOf(com_ushareit_listenit_dwp.f10487c));
                    contentValues.put("daily_error_events_count", Long.valueOf(com_ushareit_listenit_dwp.f10488d));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(com_ushareit_listenit_dwp.f10489e));
                    A.update("apps", contentValues, "app_id=?", strArr);
                    if (query != null) {
                        query.close();
                    }
                    return com_ushareit_listenit_dwp;
                }
                mo2096w().m16262z().m16264a("Not updating daily counts, app is not known", str);
                if (query != null) {
                    query.close();
                }
                return com_ushareit_listenit_dwp;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo2096w().m16242f().m16264a("Error updating daily counts", e);
                    if (query != null) {
                        query.close();
                    }
                    return com_ushareit_listenit_dwp;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            mo2096w().m16242f().m16264a("Error updating daily counts", e);
            if (query != null) {
                query.close();
            }
            return com_ushareit_listenit_dwp;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public dww m16090a(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        cfi.m11082a(str);
        cfi.m11082a(str2);
        mo2083j();
        m15696c();
        try {
            Cursor query = m16078A().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    dww com_ushareit_listenit_dww = new dww(str, str2, query.getLong(0), query.getLong(1), query.getLong(2));
                    if (query.moveToNext()) {
                        mo2096w().m16242f().m16263a("Got multiple records for event aggregates, expected one");
                    }
                    if (query == null) {
                        return com_ushareit_listenit_dww;
                    }
                    query.close();
                    return com_ushareit_listenit_dww;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    mo2096w().m16242f().m16266a("Error querying events", str, str2, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            mo2096w().m16242f().m16266a("Error querying events", str, str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public List<dwj> m16091a(String str) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        cfi.m11082a(str);
        mo2083j();
        m15696c();
        List<dwj> arrayList = new ArrayList();
        try {
            Cursor query = m16078A().query("user_attributes", new String[]{"name", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(mo2098y().m16007F()));
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(0);
                        long j = query.getLong(1);
                        Object b = m16109b(query, 2);
                        if (b == null) {
                            mo2096w().m16242f().m16263a("Read invalid user property value, ignoring it");
                        } else {
                            arrayList.add(new dwj(str, string, j, b));
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = query;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            try {
                mo2096w().m16242f().m16265a("Error querying user properties", str, e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public List<Pair<dru, Long>> m16092a(String str, int i, int i2) {
        Object e;
        Cursor cursor;
        Throwable th;
        boolean z = true;
        mo2083j();
        m15696c();
        cfi.m11089b(i > 0);
        if (i2 <= 0) {
            z = false;
        }
        cfi.m11089b(z);
        cfi.m11082a(str);
        Cursor query;
        List<Pair<dru, Long>> emptyList;
        try {
            query = m16078A().query("queue", new String[]{"rowid", "data"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            try {
                if (query.moveToFirst()) {
                    List<Pair<dru, Long>> arrayList = new ArrayList();
                    int i3 = 0;
                    while (true) {
                        long j = query.getLong(0);
                        int length;
                        try {
                            byte[] b = mo2092s().m15962b(query.getBlob(1));
                            if (!arrayList.isEmpty() && b.length + i3 > i2) {
                                break;
                            }
                            dfz a = dfz.m14123a(b);
                            dru com_ushareit_listenit_dru = new dru();
                            try {
                                dru com_ushareit_listenit_dru2 = (dru) com_ushareit_listenit_dru.mo1670b(a);
                                length = b.length + i3;
                                arrayList.add(Pair.create(com_ushareit_listenit_dru, Long.valueOf(j)));
                            } catch (IOException e2) {
                                mo2096w().m16242f().m16265a("Failed to merge queued bundle", str, e2);
                                length = i3;
                            }
                            if (!query.moveToNext() || length > i2) {
                                break;
                            }
                            i3 = length;
                        } catch (IOException e22) {
                            mo2096w().m16242f().m16265a("Failed to unzip queued bundle", str, e22);
                            length = i3;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                emptyList = Collections.emptyList();
                if (query == null) {
                    return emptyList;
                }
                query.close();
                return emptyList;
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            try {
                mo2096w().m16242f().m16265a("Error querying bundles", str, e);
                emptyList = Collections.emptyList();
                if (cursor == null) {
                    return emptyList;
                }
                cursor.close();
                return emptyList;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public void m16093a(long j) {
        mo2083j();
        m15696c();
        if (m16078A().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) != 1) {
            mo2096w().m16242f().m16263a("Deleted fewer rows from queue than expected");
        }
    }

    void m16094a(ContentValues contentValues, String str, Object obj) {
        cfi.m11082a(str);
        cfi.m11080a(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    public void m16095a(dru com_ushareit_listenit_dru, boolean z) {
        mo2083j();
        m15696c();
        cfi.m11080a((Object) com_ushareit_listenit_dru);
        cfi.m11082a(com_ushareit_listenit_dru.f10259p);
        cfi.m11080a(com_ushareit_listenit_dru.f10250f);
        m16082E();
        long a = mo2089p().mo1370a();
        if (com_ushareit_listenit_dru.f10250f.longValue() < a - mo2098y().m16020S() || com_ushareit_listenit_dru.f10250f.longValue() > mo2098y().m16020S() + a) {
            mo2096w().m16262z().m16265a("Storing bundle outside of the max uploading time span. now, timestamp", Long.valueOf(a), com_ushareit_listenit_dru.f10250f);
        }
        try {
            byte[] bArr = new byte[com_ushareit_listenit_dru.m13475g()];
            dga a2 = dga.m14159a(bArr);
            com_ushareit_listenit_dru.mo1666a(a2);
            a2.m14204b();
            bArr = mo2092s().m15958a(bArr);
            mo2096w().m16235E().m16264a("Saving bundle, size", Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", com_ushareit_listenit_dru.f10259p);
            contentValues.put("bundle_end_timestamp", com_ushareit_listenit_dru.f10250f);
            contentValues.put("data", bArr);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            try {
                if (m16078A().insert("queue", null, contentValues) == -1) {
                    mo2096w().m16242f().m16263a("Failed to insert bundle (got -1)");
                }
            } catch (SQLiteException e) {
                mo2096w().m16242f().m16264a("Error storing bundle", e);
            }
        } catch (IOException e2) {
            mo2096w().m16242f().m16264a("Data loss. Failed to serialize bundle", e2);
        }
    }

    public void m16096a(dux com_ushareit_listenit_dux) {
        cfi.m11080a((Object) com_ushareit_listenit_dux);
        mo2083j();
        m15696c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_ushareit_listenit_dux.m15635b());
        contentValues.put("app_instance_id", com_ushareit_listenit_dux.m15638c());
        contentValues.put("gmp_app_id", com_ushareit_listenit_dux.m15641d());
        contentValues.put("resettable_device_id_hash", com_ushareit_listenit_dux.m15644e());
        contentValues.put("last_bundle_index", Long.valueOf(com_ushareit_listenit_dux.m15666o()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(com_ushareit_listenit_dux.m15650g()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(com_ushareit_listenit_dux.m15652h()));
        contentValues.put(C0321x.f3843d, com_ushareit_listenit_dux.m15654i());
        contentValues.put("app_store", com_ushareit_listenit_dux.m15658k());
        contentValues.put("gmp_version", Long.valueOf(com_ushareit_listenit_dux.m15660l()));
        contentValues.put("dev_cert_hash", Long.valueOf(com_ushareit_listenit_dux.m15662m()));
        contentValues.put("measurement_enabled", Boolean.valueOf(com_ushareit_listenit_dux.m15665n()));
        contentValues.put("day", Long.valueOf(com_ushareit_listenit_dux.m15670s()));
        contentValues.put("daily_public_events_count", Long.valueOf(com_ushareit_listenit_dux.m15671t()));
        contentValues.put("daily_events_count", Long.valueOf(com_ushareit_listenit_dux.m15672u()));
        contentValues.put("daily_conversions_count", Long.valueOf(com_ushareit_listenit_dux.m15673v()));
        contentValues.put("config_fetched_time", Long.valueOf(com_ushareit_listenit_dux.m15667p()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(com_ushareit_listenit_dux.m15668q()));
        contentValues.put("app_version_int", Long.valueOf(com_ushareit_listenit_dux.m15656j()));
        contentValues.put("firebase_instance_id", com_ushareit_listenit_dux.m15647f());
        contentValues.put("daily_error_events_count", Long.valueOf(com_ushareit_listenit_dux.m15675x()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(com_ushareit_listenit_dux.m15674w()));
        try {
            if (m16078A().insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                mo2096w().m16242f().m16263a("Failed to insert/update app (got -1)");
            }
        } catch (SQLiteException e) {
            mo2096w().m16242f().m16264a("Error storing app", e);
        }
    }

    public void m16097a(dwv com_ushareit_listenit_dwv, long j, boolean z) {
        int i = 0;
        mo2083j();
        m15696c();
        cfi.m11080a((Object) com_ushareit_listenit_dwv);
        cfi.m11082a(com_ushareit_listenit_dwv.f10495a);
        drr com_ushareit_listenit_drr = new drr();
        com_ushareit_listenit_drr.f10228d = Long.valueOf(com_ushareit_listenit_dwv.f10499e);
        com_ushareit_listenit_drr.f10225a = new drs[com_ushareit_listenit_dwv.f10500f.m2442a()];
        Iterator it = com_ushareit_listenit_dwv.f10500f.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            drs com_ushareit_listenit_drs = new drs();
            int i3 = i2 + 1;
            com_ushareit_listenit_drr.f10225a[i2] = com_ushareit_listenit_drs;
            com_ushareit_listenit_drs.f10231a = str;
            mo2092s().m15948a(com_ushareit_listenit_drs, com_ushareit_listenit_dwv.f10500f.m2443a(str));
            i2 = i3;
        }
        try {
            byte[] bArr = new byte[com_ushareit_listenit_drr.m13475g()];
            dga a = dga.m14159a(bArr);
            com_ushareit_listenit_drr.mo1666a(a);
            a.m14204b();
            mo2096w().m16235E().m16265a("Saving event, name, data size", com_ushareit_listenit_dwv.f10496b, Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", com_ushareit_listenit_dwv.f10495a);
            contentValues.put("name", com_ushareit_listenit_dwv.f10496b);
            contentValues.put("timestamp", Long.valueOf(com_ushareit_listenit_dwv.f10498d));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            str = "realtime";
            if (z) {
                i = 1;
            }
            contentValues.put(str, Integer.valueOf(i));
            try {
                if (m16078A().insert("raw_events", null, contentValues) == -1) {
                    mo2096w().m16242f().m16263a("Failed to insert raw event (got -1)");
                }
            } catch (SQLiteException e) {
                mo2096w().m16242f().m16264a("Error storing raw event", e);
            }
        } catch (IOException e2) {
            mo2096w().m16242f().m16264a("Data loss. Failed to serialize event params/data", e2);
        }
    }

    public void m16098a(dww com_ushareit_listenit_dww) {
        cfi.m11080a((Object) com_ushareit_listenit_dww);
        mo2083j();
        m15696c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_ushareit_listenit_dww.f10501a);
        contentValues.put("name", com_ushareit_listenit_dww.f10502b);
        contentValues.put("lifetime_count", Long.valueOf(com_ushareit_listenit_dww.f10503c));
        contentValues.put("current_bundle_count", Long.valueOf(com_ushareit_listenit_dww.f10504d));
        contentValues.put("last_fire_timestamp", Long.valueOf(com_ushareit_listenit_dww.f10505e));
        try {
            if (m16078A().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                mo2096w().m16242f().m16263a("Failed to insert/update event aggregates (got -1)");
            }
        } catch (SQLiteException e) {
            mo2096w().m16242f().m16264a("Error storing event aggregates", e);
        }
    }

    public void m16099a(String str, int i) {
        cfi.m11082a(str);
        mo2083j();
        m15696c();
        try {
            m16078A().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(i)});
        } catch (SQLiteException e) {
            mo2096w().m16242f().m16265a("Error pruning currencies", str, e);
        }
    }

    void m16100a(String str, int i, drv com_ushareit_listenit_drv) {
        m15696c();
        mo2083j();
        cfi.m11082a(str);
        cfi.m11080a((Object) com_ushareit_listenit_drv);
        try {
            byte[] bArr = new byte[com_ushareit_listenit_drv.m13475g()];
            dga a = dga.m14159a(bArr);
            com_ushareit_listenit_drv.mo1666a(a);
            a.m14204b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("current_results", bArr);
            try {
                if (m16078A().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                    mo2096w().m16242f().m16263a("Failed to insert filter results (got -1)");
                }
            } catch (SQLiteException e) {
                mo2096w().m16242f().m16264a("Error storing filter results", e);
            }
        } catch (IOException e2) {
            mo2096w().m16242f().m16264a("Configuration loss. Failed to serialize filter results", e2);
        }
    }

    protected void m16101a(String str, long j) {
        cfi.m11082a(str);
        mo2083j();
        m15696c();
        if (j <= 0) {
            mo2096w().m16242f().m16263a("Nonpositive first open count received, ignoring");
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("first_open_count", Long.valueOf(j));
        try {
            if (m16078A().insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                mo2096w().m16242f().m16263a("Failed to insert/replace first open count (got -1)");
            }
        } catch (SQLiteException e) {
            mo2096w().m16242f().m16264a("Error inserting/replacing first open count", e);
        }
    }

    public void m16102a(String str, long j, dwq com_ushareit_listenit_dwq) {
        Object string;
        Cursor cursor;
        Object e;
        Throwable th;
        Cursor cursor2 = null;
        cfi.m11080a((Object) com_ushareit_listenit_dwq);
        mo2083j();
        m15696c();
        try {
            String str2;
            SQLiteDatabase A = m16078A();
            String string2;
            if (TextUtils.isEmpty(str)) {
                cursor2 = A.rawQuery("select app_id, metadata_fingerprint from raw_events where app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;", new String[]{String.valueOf(j)});
                if (cursor2.moveToFirst()) {
                    string = cursor2.getString(0);
                    string2 = cursor2.getString(1);
                    cursor2.close();
                    str2 = string2;
                    cursor = cursor2;
                } else if (cursor2 != null) {
                    cursor2.close();
                    return;
                } else {
                    return;
                }
            }
            cursor2 = A.rawQuery("select metadata_fingerprint from raw_events where app_id = ? order by rowid limit 1;", new String[]{str});
            if (cursor2.moveToFirst()) {
                string2 = cursor2.getString(0);
                cursor2.close();
                str2 = string2;
                cursor = cursor2;
            } else if (cursor2 != null) {
                cursor2.close();
                return;
            } else {
                return;
            }
            try {
                cursor = A.query("raw_events_metadata", new String[]{"metadata"}, "app_id=? and metadata_fingerprint=?", new String[]{string, str2}, null, null, "rowid", "2");
                if (cursor.moveToFirst()) {
                    dfz a = dfz.m14123a(cursor.getBlob(0));
                    dru com_ushareit_listenit_dru = new dru();
                    try {
                        dru com_ushareit_listenit_dru2 = (dru) com_ushareit_listenit_dru.mo1670b(a);
                        if (cursor.moveToNext()) {
                            mo2096w().m16262z().m16263a("Get multiple raw event metadata records, expected one");
                        }
                        cursor.close();
                        com_ushareit_listenit_dwq.mo2108a(com_ushareit_listenit_dru);
                        cursor2 = A.query("raw_events", new String[]{"rowid", "name", "timestamp", "data"}, "app_id=? and metadata_fingerprint=?", new String[]{string, str2}, null, null, "rowid", null);
                        if (cursor2.moveToFirst()) {
                            do {
                                long j2 = cursor2.getLong(0);
                                dfz a2 = dfz.m14123a(cursor2.getBlob(3));
                                drr com_ushareit_listenit_drr = new drr();
                                try {
                                    drr com_ushareit_listenit_drr2 = (drr) com_ushareit_listenit_drr.mo1670b(a2);
                                    com_ushareit_listenit_drr.f10226b = cursor2.getString(1);
                                    com_ushareit_listenit_drr.f10227c = Long.valueOf(cursor2.getLong(2));
                                    if (!com_ushareit_listenit_dwq.mo2109a(j2, com_ushareit_listenit_drr)) {
                                        if (cursor2 != null) {
                                            cursor2.close();
                                            return;
                                        }
                                        return;
                                    }
                                } catch (IOException e2) {
                                    try {
                                        mo2096w().m16242f().m16265a("Data loss. Failed to merge raw event", string, e2);
                                    } catch (SQLiteException e3) {
                                        e = e3;
                                    }
                                }
                            } while (cursor2.moveToNext());
                            if (cursor2 != null) {
                                cursor2.close();
                                return;
                            }
                            return;
                        }
                        mo2096w().m16262z().m16263a("Raw event data disappeared while in transaction");
                        if (cursor2 != null) {
                            cursor2.close();
                            return;
                        }
                        return;
                    } catch (IOException e22) {
                        mo2096w().m16242f().m16265a("Data loss. Failed to merge raw event metadata", string, e22);
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    }
                }
                mo2096w().m16242f().m16263a("Raw event metadata record is missing");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursor2 = cursor;
                try {
                    mo2096w().m16242f().m16264a("Data loss. Error selecting raw event", e);
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursor2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e32) {
            e = e32;
        } catch (Throwable th4) {
            th = th4;
            cursor = cursor2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void m16103a(String str, byte[] bArr) {
        cfi.m11082a(str);
        mo2083j();
        m15696c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) m16078A().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                mo2096w().m16242f().m16263a("Failed to update remote config (got 0)");
            }
        } catch (SQLiteException e) {
            mo2096w().m16242f().m16264a("Error storing remote config", e);
        }
    }

    void m16104a(String str, drf[] com_ushareit_listenit_drfArr) {
        int i = 0;
        m15696c();
        mo2083j();
        cfi.m11082a(str);
        cfi.m11080a((Object) com_ushareit_listenit_drfArr);
        SQLiteDatabase A = m16078A();
        A.beginTransaction();
        try {
            m16119e(str);
            for (drf a : com_ushareit_listenit_drfArr) {
                m16075a(str, a);
            }
            List arrayList = new ArrayList();
            int length = com_ushareit_listenit_drfArr.length;
            while (i < length) {
                arrayList.add(com_ushareit_listenit_drfArr[i].f10179a);
                i++;
            }
            m16107a(str, arrayList);
            A.setTransactionSuccessful();
        } finally {
            A.endTransaction();
        }
    }

    public void m16105a(List<Long> list) {
        cfi.m11080a((Object) list);
        mo2083j();
        m15696c();
        StringBuilder stringBuilder = new StringBuilder("rowid in (");
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(((Long) list.get(i)).longValue());
        }
        stringBuilder.append(")");
        int delete = m16078A().delete("raw_events", stringBuilder.toString(), null);
        if (delete != list.size()) {
            mo2096w().m16242f().m16265a("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
        }
    }

    public boolean m16106a(dwj com_ushareit_listenit_dwj) {
        cfi.m11080a((Object) com_ushareit_listenit_dwj);
        mo2083j();
        m15696c();
        if (m16114c(com_ushareit_listenit_dwj.f10474a, com_ushareit_listenit_dwj.f10475b) == null) {
            if (dwk.m15932a(com_ushareit_listenit_dwj.f10475b)) {
                if (m16072a("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{com_ushareit_listenit_dwj.f10474a}) >= ((long) mo2098y().m16006E())) {
                    return false;
                }
            }
            if (m16072a("select count(1) from user_attributes where app_id=?", new String[]{com_ushareit_listenit_dwj.f10474a}) >= ((long) mo2098y().m16007F())) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_ushareit_listenit_dwj.f10474a);
        contentValues.put("name", com_ushareit_listenit_dwj.f10475b);
        contentValues.put("set_timestamp", Long.valueOf(com_ushareit_listenit_dwj.f10476c));
        m16094a(contentValues, "value", com_ushareit_listenit_dwj.f10477d);
        try {
            if (m16078A().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                mo2096w().m16242f().m16263a("Failed to insert/update user property (got -1)");
            }
        } catch (SQLiteException e) {
            mo2096w().m16242f().m16264a("Error storing user property", e);
        }
        return true;
    }

    boolean m16107a(String str, List<Integer> list) {
        cfi.m11082a(str);
        m15696c();
        mo2083j();
        SQLiteDatabase A = m16078A();
        try {
            if (m16072a("select count(1) from audience_filter_values where app_id=?", new String[]{str}) <= ((long) mo2098y().m16042f(str))) {
                return false;
            }
            Iterable arrayList = new ArrayList();
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    Integer num = (Integer) list.get(i);
                    if (num == null || !(num instanceof Integer)) {
                        return false;
                    }
                    arrayList.add(Integer.toString(num.intValue()));
                }
            }
            String valueOf = String.valueOf(TextUtils.join(",", arrayList));
            valueOf = new StringBuilder(String.valueOf(valueOf).length() + 2).append("(").append(valueOf).append(")").toString();
            return A.delete("audience_filter_values", new StringBuilder(String.valueOf(valueOf).length() + 140).append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ").append(valueOf).append(" order by rowid desc limit -1 offset ?)").toString(), new String[]{str, Integer.toString(r5)}) > 0;
        } catch (SQLiteException e) {
            mo2096w().m16242f().m16264a("Database error querying filters", e);
            return false;
        }
    }

    public dux m16108b(String str) {
        Cursor query;
        Object e;
        Throwable th;
        cfi.m11082a(str);
        mo2083j();
        m15696c();
        try {
            query = m16078A().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", C0321x.f3843d, "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    dux com_ushareit_listenit_dux = new dux(this.n, str);
                    com_ushareit_listenit_dux.m15633a(query.getString(0));
                    com_ushareit_listenit_dux.m15637b(query.getString(1));
                    com_ushareit_listenit_dux.m15640c(query.getString(2));
                    com_ushareit_listenit_dux.m15648f(query.getLong(3));
                    com_ushareit_listenit_dux.m15632a(query.getLong(4));
                    com_ushareit_listenit_dux.m15636b(query.getLong(5));
                    com_ushareit_listenit_dux.m15646e(query.getString(6));
                    com_ushareit_listenit_dux.m15649f(query.getString(7));
                    com_ushareit_listenit_dux.m15642d(query.getLong(8));
                    com_ushareit_listenit_dux.m15645e(query.getLong(9));
                    com_ushareit_listenit_dux.m15634a((query.isNull(10) ? 1 : query.getInt(10)) != 0);
                    com_ushareit_listenit_dux.m15655i(query.getLong(11));
                    com_ushareit_listenit_dux.m15657j(query.getLong(12));
                    com_ushareit_listenit_dux.m15659k(query.getLong(13));
                    com_ushareit_listenit_dux.m15661l(query.getLong(14));
                    com_ushareit_listenit_dux.m15651g(query.getLong(15));
                    com_ushareit_listenit_dux.m15653h(query.getLong(16));
                    com_ushareit_listenit_dux.m15639c(query.isNull(17) ? -2147483648L : (long) query.getInt(17));
                    com_ushareit_listenit_dux.m15643d(query.getString(18));
                    com_ushareit_listenit_dux.m15664n(query.getLong(19));
                    com_ushareit_listenit_dux.m15663m(query.getLong(20));
                    com_ushareit_listenit_dux.m15631a();
                    if (query.moveToNext()) {
                        mo2096w().m16242f().m16263a("Got multiple records for app, expected one");
                    }
                    if (query == null) {
                        return com_ushareit_listenit_dux;
                    }
                    query.close();
                    return com_ushareit_listenit_dux;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo2096w().m16242f().m16265a("Error querying app", str, e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            mo2096w().m16242f().m16265a("Error querying app", str, e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    Object m16109b(Cursor cursor, int i) {
        int a = m16071a(cursor, i);
        switch (a) {
            case 0:
                mo2096w().m16242f().m16263a("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Double.valueOf(cursor.getDouble(i));
            case 3:
                return cursor.getString(i);
            case 4:
                mo2096w().m16242f().m16263a("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                mo2096w().m16242f().m16264a("Loaded invalid unknown value type, ignoring it", Integer.valueOf(a));
                return null;
        }
    }

    public String m16110b(long j) {
        Cursor rawQuery;
        Object e;
        Throwable th;
        String str = null;
        mo2083j();
        m15696c();
        try {
            rawQuery = m16078A().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j)});
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else {
                    mo2096w().m16235E().m16263a("No expired configs for apps with pending events");
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo2096w().m16242f().m16264a("Error selecting expired configs", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = str;
            mo2096w().m16242f().m16264a("Error selecting expired configs", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            rawQuery = str;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    void m16111b(String str, int i) {
        m15696c();
        mo2083j();
        cfi.m11082a(str);
        SQLiteDatabase A = m16078A();
        A.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
        A.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
    }

    public void m16112b(String str, String str2) {
        cfi.m11082a(str);
        cfi.m11082a(str2);
        mo2083j();
        m15696c();
        try {
            mo2096w().m16235E().m16264a("Deleted user attribute rows:", Integer.valueOf(m16078A().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            mo2096w().m16242f().m16266a("Error deleting user attribute", str, str2, e);
        }
    }

    public long m16113c(String str) {
        cfi.m11082a(str);
        mo2083j();
        m15696c();
        try {
            SQLiteDatabase A = m16078A();
            String valueOf = String.valueOf(mo2098y().m16049j(str));
            return (long) A.delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, valueOf});
        } catch (SQLiteException e) {
            mo2096w().m16242f().m16264a("Error deleting over the limit events", e);
            return 0;
        }
    }

    public dwj m16114c(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        cfi.m11082a(str);
        cfi.m11082a(str2);
        mo2083j();
        m15696c();
        try {
            Cursor query = m16078A().query("user_attributes", new String[]{"set_timestamp", "value"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    dwj com_ushareit_listenit_dwj = new dwj(str, str2, query.getLong(0), m16109b(query, 1));
                    if (query.moveToNext()) {
                        mo2096w().m16242f().m16263a("Got multiple records for user property, expected one");
                    }
                    if (query == null) {
                        return com_ushareit_listenit_dwj;
                    }
                    query.close();
                    return com_ushareit_listenit_dwj;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    mo2096w().m16242f().m16266a("Error querying user property", str, str2, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            mo2096w().m16242f().m16266a("Error querying user property", str, str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    Map<Integer, List<drg>> m16115d(String str, String str2) {
        Cursor query;
        Object e;
        Throwable th;
        m15696c();
        mo2083j();
        cfi.m11082a(str);
        cfi.m11082a(str2);
        Map<Integer, List<drg>> fqVar = new fq();
        try {
            query = m16078A().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
            if (query.moveToFirst()) {
                do {
                    try {
                        dfz a = dfz.m14123a(query.getBlob(1));
                        drg com_ushareit_listenit_drg = new drg();
                        try {
                            drg com_ushareit_listenit_drg2 = (drg) com_ushareit_listenit_drg.mo1670b(a);
                            int i = query.getInt(0);
                            List list = (List) fqVar.get(Integer.valueOf(i));
                            if (list == null) {
                                list = new ArrayList();
                                fqVar.put(Integer.valueOf(i), list);
                            }
                            list.add(com_ushareit_listenit_drg);
                        } catch (IOException e2) {
                            mo2096w().m16242f().m16265a("Failed to merge filter", str, e2);
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return fqVar;
            }
            Map<Integer, List<drg>> emptyMap = Collections.emptyMap();
            if (query == null) {
                return emptyMap;
            }
            query.close();
            return emptyMap;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                mo2096w().m16242f().m16264a("Database error querying filters", e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public byte[] m16116d(String str) {
        Object e;
        Throwable th;
        cfi.m11082a(str);
        mo2083j();
        m15696c();
        Cursor query;
        try {
            query = m16078A().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    byte[] blob = query.getBlob(0);
                    if (query.moveToNext()) {
                        mo2096w().m16242f().m16263a("Got multiple records for app config, expected one");
                    }
                    if (query == null) {
                        return blob;
                    }
                    query.close();
                    return blob;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo2096w().m16242f().m16265a("Error querying remote config", str, e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            mo2096w().m16242f().m16265a("Error querying remote config", str, e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    Map<Integer, List<drj>> m16117e(String str, String str2) {
        Object e;
        Throwable th;
        m15696c();
        mo2083j();
        cfi.m11082a(str);
        cfi.m11082a(str2);
        Map<Integer, List<drj>> fqVar = new fq();
        Cursor query;
        try {
            query = m16078A().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
            if (query.moveToFirst()) {
                do {
                    try {
                        dfz a = dfz.m14123a(query.getBlob(1));
                        drj com_ushareit_listenit_drj = new drj();
                        try {
                            drj com_ushareit_listenit_drj2 = (drj) com_ushareit_listenit_drj.mo1670b(a);
                            int i = query.getInt(0);
                            List list = (List) fqVar.get(Integer.valueOf(i));
                            if (list == null) {
                                list = new ArrayList();
                                fqVar.put(Integer.valueOf(i), list);
                            }
                            list.add(com_ushareit_listenit_drj);
                        } catch (IOException e2) {
                            mo2096w().m16242f().m16265a("Failed to merge filter", str, e2);
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return fqVar;
            }
            Map<Integer, List<drj>> emptyMap = Collections.emptyMap();
            if (query == null) {
                return emptyMap;
            }
            query.close();
            return emptyMap;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                mo2096w().m16242f().m16264a("Database error querying filters", e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    protected void mo2080e() {
    }

    void m16119e(String str) {
        m15696c();
        mo2083j();
        cfi.m11082a(str);
        SQLiteDatabase A = m16078A();
        A.delete("property_filters", "app_id=?", new String[]{str});
        A.delete("event_filters", "app_id=?", new String[]{str});
    }

    Map<Integer, drv> m16120f(String str) {
        Object e;
        Cursor cursor;
        Throwable th;
        m15696c();
        mo2083j();
        cfi.m11082a(str);
        Cursor query;
        try {
            query = m16078A().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    Map<Integer, drv> fqVar = new fq();
                    do {
                        int i = query.getInt(0);
                        dfz a = dfz.m14123a(query.getBlob(1));
                        drv com_ushareit_listenit_drv = new drv();
                        try {
                            drv com_ushareit_listenit_drv2 = (drv) com_ushareit_listenit_drv.mo1670b(a);
                            fqVar.put(Integer.valueOf(i), com_ushareit_listenit_drv);
                        } catch (IOException e2) {
                            mo2096w().m16242f().m16266a("Failed to merge filter results. appId, audienceId, error", str, Integer.valueOf(i), e2);
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return fqVar;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            try {
                mo2096w().m16242f().m16264a("Database error querying filter results", e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public void m16121f() {
        m15696c();
        m16078A().beginTransaction();
    }

    public void m16122g() {
        m15696c();
        m16078A().setTransactionSuccessful();
    }

    void m16123g(String str) {
        m15696c();
        mo2083j();
        cfi.m11082a(str);
        try {
            SQLiteDatabase A = m16078A();
            String[] strArr = new String[]{str};
            int delete = A.delete("audience_filter_values", "app_id=?", strArr) + (((((((A.delete("events", "app_id=?", strArr) + 0) + A.delete("user_attributes", "app_id=?", strArr)) + A.delete("apps", "app_id=?", strArr)) + A.delete("raw_events", "app_id=?", strArr)) + A.delete("raw_events_metadata", "app_id=?", strArr)) + A.delete("event_filters", "app_id=?", strArr)) + A.delete("property_filters", "app_id=?", strArr));
            if (delete > 0) {
                mo2096w().m16235E().m16265a("Deleted application data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            mo2096w().m16242f().m16265a("Error deleting application data. appId, error", str, e);
        }
    }

    public long m16124h(String str) {
        cfi.m11082a(str);
        mo2083j();
        m15696c();
        SQLiteDatabase A = m16078A();
        A.beginTransaction();
        try {
            long a = m16073a("select first_open_count from app2 where app_id=?", new String[]{str}, 0);
            m16101a(str, 1 + a);
            A.setTransactionSuccessful();
            return a;
        } finally {
            A.endTransaction();
        }
    }

    public void m16125i(String str) {
        try {
            m16078A().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{str, str});
        } catch (SQLiteException e) {
            mo2096w().m16242f().m16264a("Failed to remove unused event metadata", e);
        }
    }

    public long m16126j(String str) {
        cfi.m11082a(str);
        return m16073a("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    public void m16127z() {
        m15696c();
        m16078A().endTransaction();
    }
}
