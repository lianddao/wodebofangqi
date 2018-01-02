package com.ushareit.listenit;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

public class frg {
    public static synchronized fse m20686a(long j) {
        fse com_ushareit_listenit_fse;
        synchronized (frg.class) {
            String[] strArr = new String[]{String.valueOf(j)};
            Cursor rawQuery = fra.m20531a().m20533b().rawQuery(" select _id , title , artist , album , artwork , streamurl , size , duration , play_count , like_it , last_play_timestamp from stream_songs where _id=? ", strArr);
            if (gyn.m23200a(rawQuery)) {
                com_ushareit_listenit_fse = new fse(rawQuery);
                rawQuery.close();
            } else {
                com_ushareit_listenit_fse = null;
            }
        }
        return com_ushareit_listenit_fse;
    }

    public static synchronized void m20688a(glg com_ushareit_listenit_glg) {
        synchronized (frg.class) {
            m20690a(com_ushareit_listenit_glg, !m20695b(com_ushareit_listenit_glg));
        }
    }

    public static synchronized void m20690a(glg com_ushareit_listenit_glg, boolean z) {
        synchronized (frg.class) {
            try {
                fra.m20531a().m20533b().beginTransaction();
                long currentTimeMillis = z ? System.currentTimeMillis() : 0;
                ContentValues contentValues = new ContentValues();
                contentValues.put("like_it", Long.valueOf(currentTimeMillis));
                contentValues.put("valid", Integer.valueOf(1));
                com_ushareit_listenit_glg.f14351s = currentTimeMillis;
                fra.m20531a().m20533b().update("stream_songs", contentValues, "_id=?", new String[]{String.valueOf(com_ushareit_listenit_glg.f14334b)});
                fiz.m19507d();
                fra.m20531a().m20533b().setTransactionSuccessful();
                fra.m20531a().m20533b().endTransaction();
            } catch (Exception e) {
                fra.m20531a().m20533b().setTransactionSuccessful();
                fra.m20531a().m20533b().endTransaction();
            } catch (Throwable th) {
                fra.m20531a().m20533b().setTransactionSuccessful();
                fra.m20531a().m20533b().endTransaction();
            }
        }
    }

    public static synchronized boolean m20695b(glg com_ushareit_listenit_glg) {
        boolean z = false;
        synchronized (frg.class) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" select ").append("like_it").append(" from ").append("stream_songs");
            stringBuilder.append(" where ").append("_id").append("=?");
            Cursor rawQuery = fra.m20531a().m20533b().rawQuery(stringBuilder.toString(), new String[]{String.valueOf(com_ushareit_listenit_glg.f14334b)});
            if (gyn.m23200a(rawQuery)) {
                int columnIndex = rawQuery.getColumnIndex("like_it");
                if (columnIndex != -1 && rawQuery.getLong(columnIndex) > 0) {
                    z = true;
                }
                exw.m18443a("StreamMediaDatabase", "isLikeIt: likeIt=" + z + ", songID=" + com_ushareit_listenit_glg.f14334b);
                rawQuery.close();
            }
        }
        return z;
    }

    public static synchronized boolean m20692a(String str) {
        boolean z = false;
        synchronized (frg.class) {
            String[] strArr = new String[]{str};
            Cursor rawQuery = fra.m20531a().m20533b().rawQuery("select _id from stream_songs where streamurl=?", strArr);
            if (gyn.m23200a(rawQuery)) {
                if (rawQuery.getCount() > 0) {
                    z = true;
                }
                rawQuery.close();
            }
        }
        return z;
    }

    public static synchronized long m20693b(String str) {
        long j;
        synchronized (frg.class) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" select ").append("_id").append(" from ").append("stream_songs");
            stringBuilder.append(" where ").append("streamurl").append("=?");
            Cursor rawQuery = fra.m20531a().m20533b().rawQuery(stringBuilder.toString(), new String[]{str});
            if (gyn.m23200a(rawQuery)) {
                j = rawQuery.getLong(0);
                rawQuery.close();
            } else {
                j = -1;
            }
        }
        return j;
    }

    public static synchronized void m20697c(glg com_ushareit_listenit_glg) {
        synchronized (frg.class) {
            try {
                fra.m20531a().m20533b().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", Long.valueOf(com_ushareit_listenit_glg.f14334b));
                contentValues.put("title", com_ushareit_listenit_glg.f14338f);
                contentValues.put("artist", com_ushareit_listenit_glg.f14339g);
                contentValues.put("album", com_ushareit_listenit_glg.f14340h);
                contentValues.put("artwork", com_ushareit_listenit_glg.f14343k);
                contentValues.put("streamurl", gyn.m23262r(com_ushareit_listenit_glg.f14342j));
                contentValues.put("size", Integer.valueOf(com_ushareit_listenit_glg.f14344l));
                contentValues.put("duration", Integer.valueOf(com_ushareit_listenit_glg.f14337e));
                contentValues.put("last_play_timestamp", Integer.valueOf(0));
                contentValues.put(fnl.PLAY_COUNT, Integer.valueOf(com_ushareit_listenit_glg.f14354v));
                contentValues.put("like_it", Integer.valueOf(0));
                contentValues.put("valid", Integer.valueOf(0));
                fra.m20531a().m20533b().insert("stream_songs", null, contentValues);
                fra.m20531a().m20533b().setTransactionSuccessful();
                fra.m20531a().m20533b().endTransaction();
            } catch (Exception e) {
                exw.m18457e("StreamMediaDatabase", "insertStreamSong, error=" + e);
                fra.m20531a().m20533b().setTransactionSuccessful();
                fra.m20531a().m20533b().endTransaction();
            } catch (Throwable th) {
                fra.m20531a().m20533b().setTransactionSuccessful();
                fra.m20531a().m20533b().endTransaction();
            }
        }
    }

    public static List<Long> m20687a() {
        List<Long> arrayList = new ArrayList();
        String[] strArr = new String[]{String.valueOf(0)};
        Cursor rawQuery = fra.m20531a().m20533b().rawQuery("select _id from stream_songs where valid=?", strArr);
        if (!gyn.m23200a(rawQuery)) {
            return arrayList;
        }
        for (int i = 0; i < rawQuery.getCount(); i++) {
            rawQuery.moveToPosition(i);
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        return arrayList;
    }

    public static synchronized void m20691a(List<Long> list) {
        synchronized (frg.class) {
            try {
                fra.m20531a().m20533b().beginTransaction();
                for (Long valueOf : list) {
                    fra.m20531a().m20533b().delete("stream_songs", "_id=?", new String[]{String.valueOf(valueOf)});
                    exw.m18457e("StreamMediaDatabase", "removeInvalidSong id=" + valueOf);
                }
                fra.m20531a().m20533b().setTransactionSuccessful();
                fra.m20531a().m20533b().endTransaction();
            } catch (Exception e) {
                exw.m18457e("StreamMediaDatabase", "removeInvalidSongs error");
                fra.m20531a().m20533b().endTransaction();
            } catch (Throwable th) {
                fra.m20531a().m20533b().endTransaction();
            }
        }
        return;
    }

    public static synchronized void m20689a(glg com_ushareit_listenit_glg, long j) {
        synchronized (frg.class) {
            try {
                String[] strArr = new String[]{String.valueOf(com_ushareit_listenit_glg.f14334b)};
                Cursor rawQuery = fra.m20531a().m20533b().rawQuery("select play_count, last_play_timestamp from stream_songs where _id=?", strArr);
                if (gyn.m23200a(rawQuery)) {
                    int i = rawQuery.getInt(rawQuery.getColumnIndex(fnl.PLAY_COUNT));
                    long j2 = rawQuery.getLong(rawQuery.getColumnIndex("last_play_timestamp"));
                    rawQuery.close();
                    if (j >= j2) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("last_play_timestamp", Long.valueOf(j));
                        contentValues.put(fnl.PLAY_COUNT, Integer.valueOf(i + 1));
                        contentValues.put("valid", Integer.valueOf(1));
                        fra.m20531a().m20533b().update("stream_songs", contentValues, "_id=?", strArr);
                        com_ushareit_listenit_glg.f14354v = i + 1;
                        com_ushareit_listenit_glg.f14358z = j;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void m20699d(glg com_ushareit_listenit_glg) {
        synchronized (frg.class) {
            try {
                fra.m20531a().m20533b().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("last_play_timestamp", Integer.valueOf(0));
                fra.m20531a().m20533b().update("stream_songs", contentValues, "_id=?", new String[]{String.valueOf(com_ushareit_listenit_glg.f14334b)});
                com_ushareit_listenit_glg.f14358z = 0;
                fra.m20531a().m20533b().setTransactionSuccessful();
                fra.m20531a().m20533b().endTransaction();
            } catch (Exception e) {
                fra.m20531a().m20533b().setTransactionSuccessful();
                fra.m20531a().m20533b().endTransaction();
            } catch (Throwable th) {
                fra.m20531a().m20533b().setTransactionSuccessful();
                fra.m20531a().m20533b().endTransaction();
            }
        }
    }

    public static synchronized void m20701e(glg com_ushareit_listenit_glg) {
        synchronized (frg.class) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("valid", Integer.valueOf(1));
                fra.m20531a().m20533b().update("stream_songs", contentValues, "_id=?", new String[]{String.valueOf(com_ushareit_listenit_glg.f14334b)});
            } catch (Exception e) {
            }
        }
    }

    public static synchronized List<Long> m20694b() {
        List arrayList;
        synchronized (frg.class) {
            arrayList = new ArrayList();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" select ").append("_id").append(" from ").append("stream_songs");
            stringBuilder.append(" where ").append("like_it").append(">?");
            Cursor rawQuery = fra.m20531a().m20533b().rawQuery(stringBuilder.toString(), new String[]{String.valueOf(0)});
            if (gyn.m23200a(rawQuery)) {
                for (int i = 0; i < rawQuery.getCount(); i++) {
                    rawQuery.moveToPosition(i);
                    arrayList.add(Long.valueOf(rawQuery.getLong(0)));
                }
                rawQuery.close();
            }
        }
        return arrayList;
    }

    public static synchronized List<Long> m20696c() {
        List arrayList;
        synchronized (frg.class) {
            arrayList = new ArrayList();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" select ").append("_id").append(" from ").append("stream_songs");
            stringBuilder.append(" where ").append("last_play_timestamp").append(">?");
            stringBuilder.append(" order by ").append("last_play_timestamp").append(" desc ");
            Cursor rawQuery = fra.m20531a().m20533b().rawQuery(stringBuilder.toString(), new String[]{String.valueOf(0)});
            if (gyn.m23200a(rawQuery)) {
                for (int i = 0; i < rawQuery.getCount(); i++) {
                    rawQuery.moveToPosition(i);
                    arrayList.add(Long.valueOf(rawQuery.getLong(0)));
                }
                rawQuery.close();
            }
        }
        return arrayList;
    }

    public static synchronized int m20698d() {
        int i = 0;
        synchronized (frg.class) {
            String str = "result";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" select count() as ").append(str).append(" from ").append("stream_songs");
            stringBuilder.append(" where ").append("last_play_timestamp").append(">?");
            Cursor rawQuery = fra.m20531a().m20533b().rawQuery(stringBuilder.toString(), new String[]{String.valueOf(0)});
            if (gyn.m23200a(rawQuery)) {
                int columnIndex = rawQuery.getColumnIndex(str);
                if (columnIndex != -1) {
                    i = rawQuery.getInt(columnIndex);
                }
                rawQuery.close();
            }
        }
        return i;
    }

    public static synchronized int m20700e() {
        int i = 0;
        synchronized (frg.class) {
            String str = "result";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" select count() as ").append(str).append(" from ").append("stream_songs");
            stringBuilder.append(" where ").append("like_it").append(">?");
            Cursor rawQuery = fra.m20531a().m20533b().rawQuery(stringBuilder.toString(), new String[]{String.valueOf(0)});
            if (gyn.m23200a(rawQuery)) {
                int columnIndex = rawQuery.getColumnIndex(str);
                if (columnIndex != -1) {
                    i = rawQuery.getInt(columnIndex);
                }
                rawQuery.close();
            }
        }
        return i;
    }
}
