package com.ushareit.listenit;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class frb {
    private static boolean m20581a(android.database.sqlite.SQLiteDatabase r7, java.util.List<java.lang.Long> r8, java.util.concurrent.atomic.AtomicLong r9) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = 0;
        r0 = 1;
        r1 = 0;
        r3 = "count";
        r3 = " select distinct ( _id ), count() as count from audio_library group by _id order by _id desc";	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        r4 = 0;	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        r2 = r7.rawQuery(r3, r4);	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        r3 = com.ushareit.listenit.gyn.m23200a(r2);	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        if (r3 != 0) goto L_0x0018;
    L_0x0012:
        if (r2 == 0) goto L_0x0017;
    L_0x0014:
        r2.close();
    L_0x0017:
        return r1;
    L_0x0018:
        r3 = 0;
        r2.moveToPosition(r3);	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        r3 = "_id";	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        r3 = r2.getColumnIndex(r3);	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        r4 = r2.getLong(r3);	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        r3 = "count";	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        r3 = r2.getColumnIndex(r3);	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        r3 = r2.getInt(r3);	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        if (r3 <= r0) goto L_0x0039;	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
    L_0x0032:
        r3 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        r8.add(r3);	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
    L_0x0039:
        r9.set(r4);	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        r3 = r0;	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
    L_0x003d:
        r4 = r2.getCount();	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        if (r3 >= r4) goto L_0x0066;	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
    L_0x0043:
        r2.moveToPosition(r3);	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        r4 = "_id";	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        r4 = r2.getColumnIndex(r4);	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        r4 = r2.getLong(r4);	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        r6 = "count";	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        r6 = r2.getColumnIndex(r6);	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        r6 = r2.getInt(r6);	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        if (r6 <= r0) goto L_0x0063;	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
    L_0x005c:
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        r8.add(r4);	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
    L_0x0063:
        r3 = r3 + 1;	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        goto L_0x003d;	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
    L_0x0066:
        r3 = r8.size();	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        if (r3 <= 0) goto L_0x0073;
    L_0x006c:
        if (r2 == 0) goto L_0x0071;
    L_0x006e:
        r2.close();
    L_0x0071:
        r1 = r0;
        goto L_0x0017;
    L_0x0073:
        r0 = r1;
        goto L_0x006c;
    L_0x0075:
        r0 = move-exception;
        r3 = "DBCompatibility";	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        r4 = "getAllSongId has an error.";	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        com.ushareit.listenit.exw.m18450b(r3, r4, r0);	 Catch:{ Exception -> 0x0075, all -> 0x0083 }
        if (r2 == 0) goto L_0x0017;
    L_0x007f:
        r2.close();
        goto L_0x0017;
    L_0x0083:
        r0 = move-exception;
        if (r2 == 0) goto L_0x0089;
    L_0x0086:
        r2.close();
    L_0x0089:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.frb.a(android.database.sqlite.SQLiteDatabase, java.util.List, java.util.concurrent.atomic.AtomicLong):boolean");
    }

    public static void m20580a(SQLiteDatabase sQLiteDatabase) {
        List<Long> arrayList = new ArrayList();
        AtomicLong atomicLong = new AtomicLong();
        if (m20581a(sQLiteDatabase, (List) arrayList, atomicLong)) {
            List arrayList2 = new ArrayList();
            for (Long longValue : arrayList) {
                arrayList2.addAll(m20579a(longValue.longValue(), sQLiteDatabase));
            }
            gvj.m22889a(m20578a(arrayList2, sQLiteDatabase, atomicLong.get()));
        }
    }

    private static List<String> m20579a(long j, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        List<String> arrayList = new ArrayList();
        try {
            cursor = sQLiteDatabase.rawQuery(" select _data from audio_library where _id=" + j, null);
            if (gyn.m23200a(cursor)) {
                for (int i = 1; i < cursor.getCount(); i++) {
                    cursor.moveToPosition(i);
                    arrayList.add(cursor.getString(cursor.getColumnIndex("_data")));
                }
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            exw.m18450b("DBCompatibility", "getRepeatSongPathsBySongId has an error.", e);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return arrayList;
    }

    private static long m20578a(List<String> list, SQLiteDatabase sQLiteDatabase, long j) {
        long j2;
        Throwable th;
        if (list == null || list.size() == 0) {
            return j;
        }
        try {
            sQLiteDatabase.beginTransaction();
            long j3 = j;
            for (String str : list) {
                try {
                    j3++;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("_id", Long.valueOf(j3));
                    contentValues.put("song_key", Long.valueOf(j3));
                    sQLiteDatabase.update("audio_library", contentValues, "_data=?", new String[]{str});
                } catch (Throwable e) {
                    Throwable th2 = e;
                    j2 = j3;
                    th = th2;
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            return j3;
        } catch (Throwable e2) {
            th = e2;
            j2 = j;
            try {
                exw.m18450b("DBCompatibility", "resetRepeatSongIds has an error.", th);
                return j2;
            } finally {
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
            }
        }
    }
}
