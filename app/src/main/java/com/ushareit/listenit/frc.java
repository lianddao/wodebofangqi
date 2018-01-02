package com.ushareit.listenit;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class frc {
    public static synchronized SQLiteDatabase m20582a() {
        SQLiteDatabase b;
        synchronized (frc.class) {
            b = fra.m20531a().m20533b();
        }
        return b;
    }

    public static void m20589a(List<fni> list) {
        try {
            m20582a().beginTransaction();
            m20582a().delete("nearby_user", null, null);
            m20582a().delete("nearby_user_playlist", null, null);
            m20582a().delete("nearby_user_song", null, null);
            for (fni com_ushareit_listenit_fni : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("user_id", com_ushareit_listenit_fni.getId());
                contentValues.put("user_name", com_ushareit_listenit_fni.getNm());
                contentValues.put("playlist_count", Integer.valueOf(com_ushareit_listenit_fni.getPlN()));
                contentValues.put(fnl.SONG_NUMBER, Integer.valueOf(com_ushareit_listenit_fni.getSgN()));
                contentValues.put("longitude", Long.valueOf(com_ushareit_listenit_fni.getLg()));
                contentValues.put("latitude", Long.valueOf(com_ushareit_listenit_fni.getLt()));
                contentValues.put("address", com_ushareit_listenit_fni.getAd());
                m20582a().insertOrThrow("nearby_user", "user_name", contentValues);
            }
            exw.m18457e("NearbyDatabase", "insertUsersAndClearDatabase, size=" + list.size());
        } catch (Throwable e) {
            exw.m18450b("NearbyDatabase", "insertUsersAndClearDatabase error", e);
        } finally {
            m20582a().setTransactionSuccessful();
            m20582a().endTransaction();
        }
    }

    public static void m20593b(List<fni> list) {
        try {
            m20582a().beginTransaction();
            for (fni com_ushareit_listenit_fni : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("user_id", com_ushareit_listenit_fni.getId());
                contentValues.put("user_name", com_ushareit_listenit_fni.getNm());
                contentValues.put("playlist_count", Integer.valueOf(com_ushareit_listenit_fni.getPlN()));
                contentValues.put(fnl.SONG_NUMBER, Integer.valueOf(com_ushareit_listenit_fni.getSgN()));
                contentValues.put("longitude", Long.valueOf(com_ushareit_listenit_fni.getLg()));
                contentValues.put("latitude", Long.valueOf(com_ushareit_listenit_fni.getLt()));
                contentValues.put("address", com_ushareit_listenit_fni.getAd());
                m20582a().insertOrThrow("nearby_user", "user_name", contentValues);
            }
            exw.m18457e("NearbyDatabase", "insertUsers, size=" + list.size());
        } catch (Throwable e) {
            exw.m18450b("NearbyDatabase", "insertUsers error=", e);
        } finally {
            m20582a().setTransactionSuccessful();
            m20582a().endTransaction();
        }
    }

    public static List<fni> m20590b() {
        List<fni> list = null;
        Cursor rawQuery = fra.m20531a().m20533b().rawQuery("SELECT * FROM nearby_user", null);
        if (gyn.m23200a(rawQuery)) {
            exw.m18457e("NearbyDatabase", "getAllNearbyUsers, size=" + rawQuery.getCount());
            list = new ArrayList();
            int i = 0;
            while (i < rawQuery.getCount()) {
                try {
                    rawQuery.moveToPosition(i);
                    list.add(new fni(rawQuery));
                    i++;
                } catch (Throwable e) {
                    exw.m18452b("NearbyDatabase", e);
                } finally {
                    rawQuery.close();
                }
            }
        }
        return list;
    }

    public static int m20594c() {
        Cursor rawQuery = fra.m20531a().m20533b().rawQuery("select user_id from nearby_user", null);
        if (!gyn.m23200a(rawQuery)) {
            return 0;
        }
        int count = rawQuery.getCount();
        rawQuery.close();
        exw.m18457e("NearbyDatabase", "getNearbyUserNumber, size=" + count);
        return count;
    }

    public static boolean m20595d() {
        boolean z = false;
        Cursor rawQuery = fra.m20531a().m20533b().rawQuery("select user_id from nearby_user", null);
        if (gyn.m23200a(rawQuery)) {
            if (rawQuery.getCount() > 0) {
                z = true;
            }
            rawQuery.close();
        }
        return z;
    }

    public static void m20586a(String str, int i) {
        try {
            m20582a().beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put(fnl.SONG_NUMBER, Integer.valueOf(i));
            m20582a().update("nearby_user", contentValues, "user_id=?", new String[]{str});
            exw.m18443a("NearbyDatabase", "updateUserSongCount: songCount=" + i);
            m20582a().setTransactionSuccessful();
        } catch (Throwable e) {
            Log.i("NearbyDatabase", "exception happen", e);
        } finally {
            m20582a().endTransaction();
        }
    }

    public static void m20592b(String str, int i) {
        try {
            m20582a().beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put("playlist_count", Integer.valueOf(i));
            m20582a().update("nearby_user", contentValues, "user_id=?", new String[]{str});
            exw.m18443a("NearbyDatabase", "updateUserPlaylistCount: playlistCount=" + i);
            m20582a().setTransactionSuccessful();
        } catch (Throwable e) {
            Log.i("NearbyDatabase", "exception happen", e);
        } finally {
            m20582a().endTransaction();
        }
    }

    public static void m20588a(String str, List<fnl> list) {
        try {
            m20582a().beginTransaction();
            ContentValues contentValues = new ContentValues();
            for (fnl com_ushareit_listenit_fnl : list) {
                contentValues.put("playlist_id", com_ushareit_listenit_fnl.getId());
                contentValues.put("user_id", str);
                contentValues.put("playlist_name", com_ushareit_listenit_fnl.getNa());
                contentValues.put(fnl.SONG_NUMBER, Integer.valueOf(com_ushareit_listenit_fnl.getSgN()));
                contentValues.put(fnl.PLAY_COUNT, Integer.valueOf(com_ushareit_listenit_fnl.getPc()));
                m20582a().insertOrThrow("nearby_user_playlist", "playlist_name", contentValues);
            }
            exw.m18443a("NearbyDatabase", "insertUserShareLists size=" + list.size());
        } catch (Throwable e) {
            exw.m18450b("NearbyDatabase", "insertUserShareLists error=", e);
        } finally {
            m20582a().setTransactionSuccessful();
            m20582a().endTransaction();
        }
    }

    public static List<fnl> m20584a(String str) {
        int i = 0;
        String[] strArr = new String[]{String.valueOf(str)};
        Cursor rawQuery = fra.m20531a().m20533b().rawQuery("SELECT * FROM nearby_user_playlist WHERE user_id=?", strArr);
        if (!gyn.m23200a(rawQuery)) {
            return null;
        }
        List<fnl> arrayList = new ArrayList();
        while (i < rawQuery.getCount()) {
            rawQuery.moveToPosition(i);
            arrayList.add(new fnl(rawQuery));
            i++;
        }
        rawQuery.close();
        exw.m18443a("NearbyDatabase", "getUserShareLists, size=" + arrayList.size());
        return arrayList;
    }

    public static void m20587a(String str, String str2, List<fri> list) {
        try {
            m20582a().beginTransaction();
            ContentValues contentValues = new ContentValues();
            for (fri com_ushareit_listenit_fri : list) {
                contentValues.put("uid", str);
                contentValues.put("playlist_id", str2);
                contentValues.put("id", com_ushareit_listenit_fri.f13280a);
                contentValues.put("name", com_ushareit_listenit_fri.f13281b);
                contentValues.put("artist", com_ushareit_listenit_fri.f13282c);
                contentValues.put("album", com_ushareit_listenit_fri.f13283d);
                contentValues.put("genre", com_ushareit_listenit_fri.f13284e);
                contentValues.put("duration", Integer.valueOf(com_ushareit_listenit_fri.f13286g));
                contentValues.put("bitrate", Integer.valueOf(com_ushareit_listenit_fri.f13285f));
                contentValues.put("size", Integer.valueOf(com_ushareit_listenit_fri.f13287h));
                contentValues.put("mimetype", com_ushareit_listenit_fri.f13288i);
                contentValues.put("is_collected", Integer.valueOf(com_ushareit_listenit_fri.f13289j));
                m20582a().insertOrThrow("nearby_user_song", "name", contentValues);
            }
            exw.m18457e("NearbyDatabase", "insertUserShareListSongs uid=" + str + ", playlistId=" + str2 + ", size=" + list.size());
        } catch (Throwable e) {
            exw.m18450b("NearbyDatabase", "insertUserShareListSongs error=", e);
        } finally {
            m20582a().setTransactionSuccessful();
            m20582a().endTransaction();
        }
    }

    public static List<fri> m20585a(String str, String str2) {
        int i = 0;
        String[] strArr = new String[]{str, str2};
        Cursor rawQuery = fra.m20531a().m20533b().rawQuery("SELECT * FROM nearby_user_song where uid=? and playlist_id=?", strArr);
        if (!gyn.m23200a(rawQuery)) {
            return null;
        }
        List<fri> arrayList = new ArrayList();
        while (i < rawQuery.getCount()) {
            rawQuery.moveToPosition(i);
            arrayList.add(new fri(rawQuery));
            i++;
        }
        rawQuery.close();
        return arrayList;
    }

    public static List<frh> m20583a(SQLiteDatabase sQLiteDatabase) {
        List<frh> b = m20591b(sQLiteDatabase);
        List<frh> arrayList = new ArrayList();
        for (frh com_ushareit_listenit_frh : b) {
            if (!frf.m20654a(sQLiteDatabase, com_ushareit_listenit_frh.f13277j, com_ushareit_listenit_frh.f13270c, com_ushareit_listenit_frh.f13271d)) {
                arrayList.add(com_ushareit_listenit_frh);
            }
        }
        return arrayList;
    }

    public static List<frh> m20591b(SQLiteDatabase sQLiteDatabase) {
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM nearby_collect", null);
        exw.m18443a("NearbyDatabase", "getAllCollectSongs()");
        List<frh> arrayList = new ArrayList();
        if (gyn.m23200a(rawQuery)) {
            while (true) {
                try {
                    arrayList.add(new frh(rawQuery));
                    if (!rawQuery.moveToNext()) {
                        break;
                    }
                } catch (Throwable e) {
                    exw.m18452b("NearbyDatabase", e);
                } finally {
                    rawQuery.close();
                }
            }
        }
        return arrayList;
    }
}
