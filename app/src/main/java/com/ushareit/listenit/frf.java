package com.ushareit.listenit;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class frf {
    public static synchronized SQLiteDatabase m20632a() {
        SQLiteDatabase b;
        synchronized (frf.class) {
            b = fra.m20531a().m20533b();
        }
        return b;
    }

    public static synchronized int m20655b() {
        int i = 0;
        synchronized (frf.class) {
            String[] strArr = new String[]{String.valueOf(0)};
            Cursor rawQuery = m20632a().rawQuery("select _id from audio_library where song_state=? group by _size, title, artist", strArr);
            if (gyn.m23200a(rawQuery)) {
                i = rawQuery.getCount();
                rawQuery.close();
            }
        }
        return i;
    }

    public static synchronized int m20665c() {
        int i = 0;
        synchronized (frf.class) {
            String[] strArr = new String[]{String.valueOf(0), String.valueOf(0)};
            Cursor rawQuery = m20632a().rawQuery("select _id from audio_library where song_state=? and song_source=?", strArr);
            if (gyn.m23200a(rawQuery)) {
                i = rawQuery.getCount();
                rawQuery.close();
            }
        }
        return i;
    }

    public static synchronized int m20670d() {
        int i = 0;
        synchronized (frf.class) {
            String[] strArr = new String[]{String.valueOf(0), String.valueOf(0)};
            Cursor rawQuery = m20632a().rawQuery("select _id from audio_library where song_state=? and song_source=?  group by _size, title, artist", strArr);
            if (gyn.m23200a(rawQuery)) {
                i = rawQuery.getCount();
                rawQuery.close();
            }
        }
        return i;
    }

    public static glf m20633a(String str) {
        String str2 = "select * from audio_library where _data=?";
        Cursor rawQuery = fra.m20531a().m20533b().rawQuery(str2, new String[]{str});
        exw.m18443a("SongDatabase", "getSongDetails: sql=" + str2 + ", result=" + (rawQuery == null ? -1 : rawQuery.getCount()));
        if (!gyn.m23200a(rawQuery)) {
            return null;
        }
        glf com_ushareit_listenit_glf = new glf(rawQuery);
        rawQuery.close();
        return com_ushareit_listenit_glf;
    }

    public static synchronized glg m20634a(long j) {
        glg com_ushareit_listenit_glg;
        synchronized (frf.class) {
            String[] strArr = new String[]{String.valueOf(j)};
            Cursor rawQuery = fra.m20531a().m20533b().rawQuery(" select _id , song_key , song_state , duration , title , artist , album , _data , folder_path , album_art_path , _size , song_genre , song_bitrate , song_mimetype , song_source , song_md5 , sync_time , changed_flag , like_it , song_backup , is_support , play_count , temp_play_count , track , last_play_timestamp , albumart_modified_timestamp from audio_library where _id=? ", strArr);
            exw.m18443a("SongDatabase", "getSongItem");
            if (gyn.m23200a(rawQuery)) {
                com_ushareit_listenit_glg = new glg(rawQuery);
                rawQuery.close();
            } else {
                com_ushareit_listenit_glg = null;
            }
        }
        return com_ushareit_listenit_glg;
    }

    public static synchronized Long m20657b(String str) {
        Long valueOf;
        synchronized (frf.class) {
            String[] strArr = new String[]{str};
            Cursor rawQuery = fra.m20531a().m20533b().rawQuery("select _id from audio_library where song_md5=? and song_state=0", strArr);
            long j = -1;
            if (gyn.m23200a(rawQuery)) {
                int columnIndex = rawQuery.getColumnIndex("_id");
                if (columnIndex != -1) {
                    j = rawQuery.getLong(columnIndex);
                }
                rawQuery.close();
                valueOf = Long.valueOf(j);
            } else {
                valueOf = Long.valueOf(-1);
            }
        }
        return valueOf;
    }

    public static List<Long> m20636a(String str, String[] strArr, String str2) {
        Cursor rawQuery = m20632a().rawQuery(str, strArr);
        List<Long> arrayList = new ArrayList();
        if (!gyn.m23200a(rawQuery)) {
            return arrayList;
        }
        for (int i = 0; i < rawQuery.getCount(); i++) {
            rawQuery.moveToPosition(i);
            int columnIndex = rawQuery.getColumnIndex(str2);
            if (columnIndex != -1) {
                arrayList.add(Long.valueOf(rawQuery.getLong(columnIndex)));
            }
        }
        rawQuery.close();
        return arrayList;
    }

    public static synchronized boolean m20669c(String str) {
        boolean z = false;
        synchronized (frf.class) {
            String[] strArr = new String[]{str};
            Cursor rawQuery = m20632a().rawQuery("select _id from audio_library where _data=?", strArr);
            if (gyn.m23200a(rawQuery)) {
                if (rawQuery.getCount() > 0) {
                    z = true;
                }
                rawQuery.close();
            }
        }
        return z;
    }

    public static synchronized boolean m20653a(int i, String str, String str2) {
        boolean z = false;
        synchronized (frf.class) {
            String[] strArr = new String[]{String.valueOf(i), str, str2};
            Cursor rawQuery = m20632a().rawQuery("select _id from audio_library where _size=? and title=? and artist=?", strArr);
            if (gyn.m23200a(rawQuery)) {
                if (rawQuery.getCount() > 0) {
                    z = true;
                }
                rawQuery.close();
            }
        }
        return z;
    }

    public static synchronized boolean m20654a(SQLiteDatabase sQLiteDatabase, int i, String str, String str2) {
        boolean z = false;
        synchronized (frf.class) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select _id from audio_library where _size=? and title=? and artist=? and song_state=0", new String[]{String.valueOf(i), str, str2});
            if (gyn.m23200a(rawQuery)) {
                if (rawQuery.getCount() > 0) {
                    z = true;
                }
                rawQuery.close();
            }
        }
        return z;
    }

    public static synchronized int m20656b(int i, String str, String str2) {
        int i2 = 0;
        synchronized (frf.class) {
            String[] strArr = new String[]{String.valueOf(i), str, str2, String.valueOf(0), String.valueOf(0)};
            Cursor rawQuery = m20632a().rawQuery("select _id from audio_library where _size=? and title=? and artist=? and song_state=? and song_source=?", strArr);
            if (gyn.m23200a(rawQuery)) {
                i2 = rawQuery.getCount();
                rawQuery.close();
            }
        }
        return i2;
    }

    public static void m20642a(glf com_ushareit_listenit_glf) {
        if (m20669c(com_ushareit_listenit_glf.f14309d)) {
            m20672d(com_ushareit_listenit_glf);
        } else {
            m20659b(com_ushareit_listenit_glf);
        }
    }

    public static synchronized void m20659b(glf com_ushareit_listenit_glf) {
        int i = 1;
        synchronized (frf.class) {
            long c = gvj.m22916c();
            m20637a(c, com_ushareit_listenit_glf.f14310e, com_ushareit_listenit_glf.f14315j, com_ushareit_listenit_glf.f14318m);
            try {
                if (!gse.m22670a().m22674b(com_ushareit_listenit_glf.f14324s)) {
                    i = 0;
                }
                String str = "";
                m20632a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", Long.valueOf(c));
                contentValues.put("song_key", Long.valueOf(c));
                contentValues.put("song_state", Integer.valueOf(i));
                contentValues.put("_data", com_ushareit_listenit_glf.f14309d);
                contentValues.put("_size", Integer.valueOf(gyn.m23241g(com_ushareit_listenit_glf.f14309d)));
                contentValues.put("duration", Integer.valueOf(com_ushareit_listenit_glf.f14311f));
                contentValues.put("year", Integer.valueOf(com_ushareit_listenit_glf.f14312g));
                contentValues.put("date_modified", Long.valueOf(com_ushareit_listenit_glf.f14313h));
                contentValues.put("last_add_timestamp", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("title", com_ushareit_listenit_glf.f14315j);
                contentValues.put("artist_id", Integer.valueOf(com_ushareit_listenit_glf.f14317l));
                contentValues.put("artist", com_ushareit_listenit_glf.f14316k);
                contentValues.put("album_id", Integer.valueOf(com_ushareit_listenit_glf.f14319n));
                contentValues.put("album", com_ushareit_listenit_glf.f14318m);
                contentValues.put("album_artist", com_ushareit_listenit_glf.f14320o);
                contentValues.put("album_art_path", com_ushareit_listenit_glf.f14321p);
                contentValues.put(fnl.PLAY_COUNT, Integer.valueOf(com_ushareit_listenit_glf.f14322q));
                contentValues.put("temp_play_count", Integer.valueOf(com_ushareit_listenit_glf.f14323r));
                contentValues.put("folder_name", com_ushareit_listenit_glf.f14325t);
                contentValues.put("folder_path", com_ushareit_listenit_glf.f14324s);
                contentValues.put("last_play_timestamp", Long.valueOf(com_ushareit_listenit_glf.f14326u));
                contentValues.put("song_md5", fbb.m18763c(com_ushareit_listenit_glf.f14328w) ? "0" : com_ushareit_listenit_glf.f14328w);
                contentValues.put("song_genre", str);
                contentValues.put("song_bitrate", Integer.valueOf(0));
                contentValues.put("song_mimetype", gyn.m23235e(com_ushareit_listenit_glf.f14309d));
                contentValues.put("song_source", Integer.valueOf(com_ushareit_listenit_glf.f14299A));
                contentValues.put("like_it", Long.valueOf(com_ushareit_listenit_glf.f14327v));
                contentValues.put("sync_time", Long.valueOf(com_ushareit_listenit_glf.f14300B));
                contentValues.put("changed_flag", Integer.valueOf(0));
                contentValues.put("song_backup", Integer.valueOf(0));
                contentValues.put("track", Integer.valueOf(com_ushareit_listenit_glf.f14304F));
                contentValues.put("albumart_modified_timestamp", Long.valueOf(com_ushareit_listenit_glf.f14305G));
                m20632a().insert("audio_library", null, contentValues);
                fle.m19717b().m19733c(true);
                exw.m18457e("SongDatabase", "insertLibrarySong: " + com_ushareit_listenit_glf.f14309d + ", id=" + c);
            } catch (Exception e) {
            } finally {
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            }
        }
    }

    private static synchronized void m20637a(long j, int i, String str, String str2) {
        synchronized (frf.class) {
            if (m20653a(i, str, str2)) {
                List<glg> a = fqs.m20450a(i, str, str2);
                List arrayList = new ArrayList();
                int i2 = 0;
                for (glg com_ushareit_listenit_glg : a) {
                    int i3;
                    if (com_ushareit_listenit_glg.f14336d == 2 || com_ushareit_listenit_glg.f14348p == 1 || !gyn.m23201a(com_ushareit_listenit_glg)) {
                        arrayList.add(com_ushareit_listenit_glg);
                        com_ushareit_listenit_glg.f14336d = 2;
                        i3 = i2;
                    } else if (com_ushareit_listenit_glg.f14336d == 1) {
                        i3 = i2 + 1;
                    } else {
                        i3 = i2;
                    }
                    i2 = i3;
                }
                if (arrayList.size() > 0) {
                    m20650a(arrayList);
                }
                if ((arrayList.size() == a.size() || arrayList.size() + i2 == a.size()) && !gvj.m22857B(eys.m18562a())) {
                    gyo.m23264a().m23266a(eys.m18562a(), Long.valueOf(j));
                }
            } else if (!gvj.m22857B(eys.m18562a())) {
                gyo.m23264a().m23266a(eys.m18562a(), Long.valueOf(j));
            }
        }
    }

    public static synchronized void m20666c(glf com_ushareit_listenit_glf) {
        synchronized (frf.class) {
            long c = gvj.m22916c();
            try {
                m20632a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", Long.valueOf(c));
                contentValues.put("song_key", Long.valueOf(c));
                contentValues.put("song_state", Integer.valueOf(2));
                contentValues.put("_data", com_ushareit_listenit_glf.f14309d);
                contentValues.put("_size", Integer.valueOf(com_ushareit_listenit_glf.f14310e));
                contentValues.put("duration", Integer.valueOf(com_ushareit_listenit_glf.f14311f));
                contentValues.put("year", Integer.valueOf(com_ushareit_listenit_glf.f14312g));
                contentValues.put("date_modified", Long.valueOf(com_ushareit_listenit_glf.f14313h));
                contentValues.put("last_add_timestamp", Long.valueOf(com_ushareit_listenit_glf.f14314i));
                contentValues.put("title", com_ushareit_listenit_glf.f14315j);
                contentValues.put("artist_id", Integer.valueOf(com_ushareit_listenit_glf.f14317l));
                contentValues.put("artist", com_ushareit_listenit_glf.f14316k);
                contentValues.put("album_id", Integer.valueOf(com_ushareit_listenit_glf.f14319n));
                contentValues.put("album", com_ushareit_listenit_glf.f14318m);
                contentValues.put("album_artist", com_ushareit_listenit_glf.f14320o);
                contentValues.put("album_art_path", com_ushareit_listenit_glf.f14321p);
                contentValues.put(fnl.PLAY_COUNT, Integer.valueOf(com_ushareit_listenit_glf.f14322q));
                contentValues.put("temp_play_count", Integer.valueOf(com_ushareit_listenit_glf.f14323r));
                contentValues.put("folder_name", com_ushareit_listenit_glf.f14325t);
                contentValues.put("folder_path", com_ushareit_listenit_glf.f14324s);
                contentValues.put("last_play_timestamp", Long.valueOf(com_ushareit_listenit_glf.f14326u));
                contentValues.put("song_md5", com_ushareit_listenit_glf.f14328w);
                contentValues.put("song_genre", com_ushareit_listenit_glf.f14330y);
                contentValues.put("song_bitrate", Integer.valueOf(com_ushareit_listenit_glf.f14329x));
                contentValues.put("song_mimetype", com_ushareit_listenit_glf.f14331z);
                contentValues.put("song_source", Integer.valueOf(com_ushareit_listenit_glf.f14299A));
                contentValues.put("like_it", Long.valueOf(com_ushareit_listenit_glf.f14327v));
                contentValues.put("sync_time", Long.valueOf(com_ushareit_listenit_glf.f14300B));
                contentValues.put("changed_flag", Integer.valueOf(1));
                contentValues.put("song_backup", Long.valueOf(com_ushareit_listenit_glf.f14302D));
                contentValues.put("albumart_modified_timestamp", Long.valueOf(com_ushareit_listenit_glf.f14305G));
                m20632a().insert("audio_library", null, contentValues);
                fle.m19717b().m19733c(true);
                exw.m18443a("SongDatabase", "insertLibrarySong: " + com_ushareit_listenit_glf.f14309d);
            } catch (Exception e) {
            } finally {
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            }
        }
    }

    public static synchronized long m20630a(fnn com_ushareit_listenit_fnn) {
        long c;
        int i = 1;
        synchronized (frf.class) {
            try {
                c = gvj.m22916c();
                String a = gyn.m23184a(com_ushareit_listenit_fnn);
                String b = gyn.m23209b(a);
                String valueOf = String.valueOf(gyn.m23234e());
                long currentTimeMillis = System.currentTimeMillis();
                if (!gse.m22670a().m22674b(b)) {
                    i = com_ushareit_listenit_fnn.getSta();
                }
                m20632a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", Long.valueOf(c));
                contentValues.put("song_key", Long.valueOf(c));
                contentValues.put("song_state", Integer.valueOf(i));
                contentValues.put("_data", a);
                contentValues.put("_size", Integer.valueOf(com_ushareit_listenit_fnn.getSz()));
                contentValues.put("duration", Integer.valueOf(com_ushareit_listenit_fnn.getDu()));
                contentValues.put("year", Integer.valueOf(0));
                contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
                contentValues.put("last_add_timestamp", Long.valueOf(currentTimeMillis));
                contentValues.put("title", com_ushareit_listenit_fnn.getNa());
                contentValues.put("artist_id", Integer.valueOf(0));
                contentValues.put("artist", com_ushareit_listenit_fnn.getAr());
                contentValues.put("album_id", Integer.valueOf(0));
                contentValues.put("album", com_ushareit_listenit_fnn.getAl());
                contentValues.put("album_artist", com_ushareit_listenit_fnn.getAl());
                contentValues.put("album_art_path", valueOf);
                contentValues.put(fnl.PLAY_COUNT, Integer.valueOf(0));
                contentValues.put("temp_play_count", Integer.valueOf(0));
                contentValues.put("folder_name", gyn.m23220c(a));
                contentValues.put("folder_path", b);
                contentValues.put("last_play_timestamp", Integer.valueOf(0));
                contentValues.put("song_md5", com_ushareit_listenit_fnn.getId());
                contentValues.put("song_bitrate", Integer.valueOf(com_ushareit_listenit_fnn.getBr()));
                contentValues.put("song_genre", com_ushareit_listenit_fnn.getGe());
                contentValues.put("song_mimetype", com_ushareit_listenit_fnn.getMt());
                contentValues.put("sync_time", Long.valueOf(com_ushareit_listenit_fnn.getSt()));
                contentValues.put("changed_flag", Integer.valueOf(0));
                contentValues.put("song_source", Integer.valueOf(1));
                contentValues.put("song_backup", Long.valueOf(com_ushareit_listenit_fnn.getBk()));
                contentValues.put("like_it", Long.valueOf(com_ushareit_listenit_fnn.getFv()));
                contentValues.put("albumart_modified_timestamp", Integer.valueOf(0));
                m20632a().insert("audio_library", null, contentValues);
                if (!gvj.m22857B(eys.m18562a()) && i == 0) {
                    gyo.m23264a().m23266a(eys.m18562a(), Long.valueOf(c));
                }
                exw.m18457e("SongDatabase", "insertLibrarySong: cloudsong= " + com_ushareit_listenit_fnn.getNa());
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            } catch (Exception e) {
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
                c = -1;
            } catch (Throwable th) {
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            }
        }
        return c;
    }

    public static synchronized long m20631a(fri com_ushareit_listenit_fri) {
        long a;
        synchronized (frf.class) {
            a = m20630a(new fnn(com_ushareit_listenit_fri));
            fle.m19717b().m19733c(true);
            gvj.m22995l();
        }
        return a;
    }

    public static void m20643a(glg com_ushareit_listenit_glg) {
        exw.m18443a("SongDatabase", "updateLibrarySongMoreInfo: songPath=" + com_ushareit_listenit_glg.f14342j);
        try {
            String a = gyk.m23153a(com_ushareit_listenit_glg.f14342j);
            String a2 = grz.m22656a().m22663a(eys.m18562a(), com_ushareit_listenit_glg.f14342j);
            int k = gyn.m23251k(com_ushareit_listenit_glg.f14342j);
            int g = gyn.m23241g(com_ushareit_listenit_glg.f14342j);
            String e = gyn.m23235e(com_ushareit_listenit_glg.f14342j);
            ContentValues contentValues = new ContentValues();
            contentValues.put("song_md5", a);
            contentValues.put("song_genre", a2);
            contentValues.put("song_bitrate", Integer.valueOf(k));
            contentValues.put("song_mimetype", e);
            contentValues.put("_size", Integer.valueOf(g));
            m20632a().update("audio_library", contentValues, "_id=?", new String[]{String.valueOf(com_ushareit_listenit_glg.f14334b)});
            com_ushareit_listenit_glg.m22357a(a);
            com_ushareit_listenit_glg.f14345m = a2;
            com_ushareit_listenit_glg.f14346n = k;
            com_ushareit_listenit_glg.f14347o = e;
            com_ushareit_listenit_glg.f14344l = g;
        } catch (Exception e2) {
            exw.m18443a("SongDatabase", "updateLibrarySongMoreInfo error");
        }
    }

    public static void m20647a(glg com_ushareit_listenit_glg, String str, boolean z) {
        exw.m18443a("SongDatabase", "updateLibrarySongMoreInfo: songName=" + com_ushareit_listenit_glg.f14338f + ", songmd5=" + str);
        try {
            String a = grz.m22656a().m22663a(eys.m18562a(), com_ushareit_listenit_glg.f14342j);
            int k = gyn.m23251k(com_ushareit_listenit_glg.f14342j);
            String e = gyn.m23235e(com_ushareit_listenit_glg.f14342j);
            int g = gyn.m23241g(com_ushareit_listenit_glg.f14342j);
            ContentValues contentValues = new ContentValues();
            contentValues.put("song_md5", str);
            contentValues.put("song_genre", a);
            contentValues.put("song_bitrate", Integer.valueOf(k));
            contentValues.put("song_mimetype", e);
            contentValues.put("_size", Integer.valueOf(g));
            if (z) {
                contentValues.put("song_state", Integer.valueOf(2));
                com_ushareit_listenit_glg.f14336d = 2;
            }
            m20632a().update("audio_library", contentValues, "_id=?", new String[]{String.valueOf(com_ushareit_listenit_glg.f14334b)});
            com_ushareit_listenit_glg.m22357a(str);
            com_ushareit_listenit_glg.f14345m = a;
            com_ushareit_listenit_glg.f14346n = k;
            com_ushareit_listenit_glg.f14347o = e;
            com_ushareit_listenit_glg.f14344l = g;
        } catch (Exception e2) {
            exw.m18443a("SongDatabase", "updateLibrarySongMoreInfo error");
        }
    }

    private static synchronized void m20672d(glf com_ushareit_listenit_glf) {
        synchronized (frf.class) {
            glg a = fqs.m20448a(com_ushareit_listenit_glf.f14309d);
            if (!(a == null || a.f14336d == 2)) {
                ContentValues contentValues = new ContentValues();
                if (a.f14348p == 1) {
                    contentValues.put("title", a.f14338f);
                    contentValues.put("artist", a.f14339g);
                    contentValues.put("album", a.f14340h);
                    contentValues.put("song_source", Integer.valueOf(0));
                    contentValues.put("changed_flag", Integer.valueOf(1));
                    a.f14348p = 0;
                    a.f14350r = 1;
                }
                if (com_ushareit_listenit_glf.f14304F != a.f14356x) {
                    contentValues.put("track", Integer.valueOf(com_ushareit_listenit_glf.f14304F));
                }
                if (contentValues.size() != 0) {
                    try {
                        m20632a().beginTransaction();
                        if (m20632a().update("audio_library", contentValues, "_data=?", new String[]{com_ushareit_listenit_glf.f14309d}) > 0) {
                            fle.m19717b().m19733c(true);
                        }
                        exw.m18443a("SongDatabase", "updateLibrarySong: values=" + contentValues);
                        m20632a().setTransactionSuccessful();
                    } catch (Throwable e) {
                        exw.m18457e("SongDatabase", "updateLibrarySong: " + exw.m18438a(e));
                    } finally {
                        m20632a().endTransaction();
                    }
                }
            }
        }
    }

    public static synchronized void m20651a(List<glg> list, fnn com_ushareit_listenit_fnn) {
        synchronized (frf.class) {
            exw.m18443a("SongDatabase", "updateLibrarySong");
            try {
                m20632a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("title", com_ushareit_listenit_fnn.getNa());
                contentValues.put("artist", com_ushareit_listenit_fnn.getAr());
                contentValues.put("album", com_ushareit_listenit_fnn.getAl());
                contentValues.put("song_genre", com_ushareit_listenit_fnn.getGe());
                contentValues.put("song_bitrate", Integer.valueOf(com_ushareit_listenit_fnn.getBr()));
                contentValues.put("song_state", Integer.valueOf(com_ushareit_listenit_fnn.getSta()));
                contentValues.put("_size", Integer.valueOf(com_ushareit_listenit_fnn.getSz()));
                contentValues.put("duration", Integer.valueOf(com_ushareit_listenit_fnn.getDu()));
                contentValues.put("sync_time", Long.valueOf(com_ushareit_listenit_fnn.getSt()));
                contentValues.put("song_backup", Long.valueOf(com_ushareit_listenit_fnn.getBk()));
                contentValues.put("like_it", Long.valueOf(com_ushareit_listenit_fnn.getFv()));
                contentValues.put("changed_flag", Integer.valueOf(0));
                for (glg com_ushareit_listenit_glg : list) {
                    com_ushareit_listenit_glg.f14338f = com_ushareit_listenit_fnn.getNa();
                    com_ushareit_listenit_glg.f14339g = com_ushareit_listenit_fnn.getAr();
                    com_ushareit_listenit_glg.f14340h = com_ushareit_listenit_fnn.getAl();
                    com_ushareit_listenit_glg.f14345m = com_ushareit_listenit_fnn.getGe();
                    com_ushareit_listenit_glg.f14346n = com_ushareit_listenit_fnn.getBr();
                    com_ushareit_listenit_glg.f14336d = com_ushareit_listenit_fnn.getSta();
                    com_ushareit_listenit_glg.f14344l = com_ushareit_listenit_fnn.getSz();
                    com_ushareit_listenit_glg.f14337e = com_ushareit_listenit_fnn.getDu();
                    com_ushareit_listenit_glg.f14349q = com_ushareit_listenit_fnn.getSt();
                    com_ushareit_listenit_glg.f14352t = com_ushareit_listenit_fnn.getBk();
                    com_ushareit_listenit_glg.f14351s = com_ushareit_listenit_fnn.getFv();
                    com_ushareit_listenit_glg.f14350r = 0;
                }
                m20632a().update("audio_library", contentValues, "song_md5=?", new String[]{String.valueOf(com_ushareit_listenit_fnn.getId())});
                m20632a().setTransactionSuccessful();
            } catch (Exception e) {
            } finally {
                m20632a().endTransaction();
            }
        }
    }

    public static synchronized void m20652a(boolean z) {
        int i = 0;
        synchronized (frf.class) {
            try {
                m20632a().beginTransaction();
                if (!z) {
                    i = 2;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("song_state", Integer.valueOf(i));
                contentValues.put("changed_flag", Integer.valueOf(1));
                String[] strArr = new String[]{"0", String.valueOf(60000), String.valueOf(i)};
                if (m20632a().update("audio_library", contentValues, "duration>? and duration<=? and song_state!=?", strArr) > 0) {
                    fqs.m20456a(i);
                    fle.m19717b().m19733c(true);
                }
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            } catch (Exception e) {
                exw.m18457e("SongDatabase", "showShortAudios error");
                m20632a().endTransaction();
            } catch (Throwable th) {
                m20632a().endTransaction();
            }
        }
    }

    public static synchronized void m20660b(glg com_ushareit_listenit_glg) {
        synchronized (frf.class) {
            exw.m18457e("SongDatabase", "instantiateCloudSongs");
            try {
                m20632a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("_data", com_ushareit_listenit_glg.f14342j);
                contentValues.put("folder_path", com_ushareit_listenit_glg.f14341i);
                contentValues.put("song_source", Integer.valueOf(0));
                com_ushareit_listenit_glg.f14348p = 0;
                String[] strArr = new String[]{com_ushareit_listenit_glg.m22362h(), String.valueOf(1)};
                m20632a().update("audio_library", contentValues, "song_md5=? and song_source=?", strArr);
                m20632a().setTransactionSuccessful();
            } catch (Exception e) {
                exw.m18457e("SongDatabase", "updateLibrarySong error");
            } finally {
                m20632a().endTransaction();
            }
        }
    }

    public static synchronized void m20650a(List<glg> list) {
        synchronized (frf.class) {
            try {
                m20632a().beginTransaction();
                for (glg com_ushareit_listenit_glg : list) {
                    m20632a().delete("audio_library", "_id=?", new String[]{String.valueOf(com_ushareit_listenit_glg.f14334b)});
                }
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            } catch (Exception e) {
                exw.m18443a("SongDatabase", "deleteLibrarySongs error");
                m20632a().endTransaction();
            } catch (Throwable th) {
                m20632a().endTransaction();
            }
        }
        return;
    }

    public static synchronized void m20667c(glg com_ushareit_listenit_glg) {
        synchronized (frf.class) {
            try {
                m20632a().beginTransaction();
                m20632a().delete("audio_library", "_id=?", new String[]{String.valueOf(com_ushareit_listenit_glg.f14334b)});
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            } catch (Exception e) {
                exw.m18443a("SongDatabase", "deleteLibrarySong error");
                m20632a().endTransaction();
            } catch (Throwable th) {
                m20632a().endTransaction();
            }
        }
    }

    public static synchronized int m20674e() {
        int i = 0;
        synchronized (frf.class) {
            String[] strArr = new String[]{String.valueOf(0), "0"};
            Cursor rawQuery = m20632a().rawQuery("select _id from audio_library where song_state=? and song_backup>?  group by _size, title, artist", strArr);
            if (gyn.m23200a(rawQuery)) {
                i = rawQuery.getCount();
                rawQuery.close();
            }
        }
        return i;
    }

    public static synchronized void m20673d(glg com_ushareit_listenit_glg) {
        synchronized (frf.class) {
            exw.m18443a("SongDatabase", "begin: updateLibrarySongState");
            try {
                long currentTimeMillis = System.currentTimeMillis();
                m20632a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("song_backup", Long.valueOf(currentTimeMillis));
                contentValues.put("changed_flag", Integer.valueOf(1));
                com_ushareit_listenit_glg.f14350r = 1;
                com_ushareit_listenit_glg.f14352t = currentTimeMillis;
                String[] strArr = new String[]{String.valueOf(com_ushareit_listenit_glg.f14344l), com_ushareit_listenit_glg.f14338f, com_ushareit_listenit_glg.f14339g};
                if (m20632a().update("audio_library", contentValues, "_size=? and title=? and artist=?", strArr) > 0) {
                    fle.m19717b().m19733c(true);
                }
            } catch (Exception e) {
            } finally {
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            }
        }
    }

    public static synchronized void m20644a(glg com_ushareit_listenit_glg, int i) {
        synchronized (frf.class) {
            exw.m18443a("SongDatabase", "begin: updateLibrarySongState");
            try {
                m20632a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("song_state", Integer.valueOf(i));
                contentValues.put("changed_flag", Integer.valueOf(1));
                com_ushareit_listenit_glg.f14350r = 1;
                com_ushareit_listenit_glg.f14336d = i;
                if (m20632a().update("audio_library", contentValues, "_id=?", new String[]{String.valueOf(com_ushareit_listenit_glg.f14334b)}) > 0) {
                    fle.m19717b().m19733c(true);
                }
            } catch (Exception e) {
            } finally {
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            }
        }
    }

    public static synchronized void m20661b(glg com_ushareit_listenit_glg, int i) {
        synchronized (frf.class) {
            exw.m18443a("SongDatabase", "begin: updateLibrarySongState");
            try {
                m20632a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("song_source", Integer.valueOf(i));
                com_ushareit_listenit_glg.f14348p = 1;
                m20632a().update("audio_library", contentValues, "_id=?", new String[]{String.valueOf(com_ushareit_listenit_glg.f14334b)});
            } catch (Exception e) {
            } finally {
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            }
        }
    }

    public static synchronized void m20645a(glg com_ushareit_listenit_glg, long j) {
        synchronized (frf.class) {
            exw.m18443a("SongDatabase", "begin: updateLibrarySongState");
            try {
                m20632a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("sync_time", Long.valueOf(j));
                com_ushareit_listenit_glg.f14349q = j;
                m20632a().update("audio_library", contentValues, "_id=?", new String[]{String.valueOf(com_ushareit_listenit_glg.f14334b)});
            } catch (Exception e) {
            } finally {
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            }
        }
    }

    public static synchronized void m20668c(glg com_ushareit_listenit_glg, int i) {
        synchronized (frf.class) {
            exw.m18443a("SongDatabase", "begin: updateLibrarySongState");
            try {
                m20632a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("changed_flag", Integer.valueOf(i));
                com_ushareit_listenit_glg.f14350r = i;
                m20632a().update("audio_library", contentValues, "_id=?", new String[]{String.valueOf(com_ushareit_listenit_glg.f14334b)});
            } catch (Exception e) {
            } finally {
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            }
        }
    }

    public static synchronized void m20649a(String str, String str2) {
        synchronized (frf.class) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                m20632a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("album_art_path", str2);
                contentValues.put("albumart_modified_timestamp", Long.valueOf(currentTimeMillis));
                m20632a().update("audio_library", contentValues, "album=?", new String[]{str});
                for (glg com_ushareit_listenit_glg : m20677f(str)) {
                    com_ushareit_listenit_glg.f14343k = str2;
                    com_ushareit_listenit_glg.f14357y = currentTimeMillis;
                }
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            } catch (Throwable e) {
                exw.m18450b("SongDatabase", "updateLibrarySongAlbumArtPath has a error.", e);
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            } catch (Throwable th) {
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            }
        }
        return;
    }

    public static synchronized void m20646a(glg com_ushareit_listenit_glg, String str) {
        synchronized (frf.class) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                m20632a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("album_art_path", str);
                contentValues.put("albumart_modified_timestamp", Long.valueOf(currentTimeMillis));
                m20632a().update("audio_library", contentValues, "_id=?", new String[]{String.valueOf(com_ushareit_listenit_glg.f14334b)});
                com_ushareit_listenit_glg.f14343k = str;
                com_ushareit_listenit_glg.f14357y = currentTimeMillis;
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            } catch (Throwable e) {
                exw.m18450b("SongDatabase", "updateLibrarySongAlbumArtPath has a error.", e);
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            } catch (Throwable th) {
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            }
        }
    }

    private static synchronized List<glg> m20677f(String str) {
        List<glg> a;
        synchronized (frf.class) {
            a = fqs.m20454a(m20636a(m20635a(" select ", "_id", " from ", "audio_library", " where ", "album", "=?"), new String[]{str}, "_id"));
        }
        return a;
    }

    public static synchronized void m20675e(glg com_ushareit_listenit_glg) {
        synchronized (frf.class) {
            exw.m18443a("SongDatabase", "updateLibrarySong");
            try {
                m20632a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                if (!fbb.m18763c(com_ushareit_listenit_glg.f14338f)) {
                    contentValues.put("title", com_ushareit_listenit_glg.f14338f);
                }
                if (!fbb.m18763c(com_ushareit_listenit_glg.f14339g)) {
                    contentValues.put("artist", com_ushareit_listenit_glg.f14339g);
                }
                if (!fbb.m18763c(com_ushareit_listenit_glg.f14340h)) {
                    contentValues.put("album", com_ushareit_listenit_glg.f14340h);
                }
                if (contentValues.size() > 0) {
                    contentValues.put("changed_flag", Integer.valueOf(1));
                    com_ushareit_listenit_glg.f14350r = 1;
                    if (m20632a().update("audio_library", contentValues, "_data=?", new String[]{com_ushareit_listenit_glg.f14342j}) > 0) {
                        fle.m19717b().m19733c(true);
                    }
                }
            } catch (Exception e) {
            } finally {
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            }
        }
    }

    public static synchronized long m20671d(String str) {
        long j;
        synchronized (frf.class) {
            String[] strArr = new String[]{str};
            Cursor rawQuery = m20632a().rawQuery("select _id from audio_library where _data=?", strArr);
            if (gyn.m23200a(rawQuery)) {
                j = rawQuery.getLong(rawQuery.getColumnIndex("_id"));
                rawQuery.close();
            } else {
                j = 0;
            }
        }
        return j;
    }

    public static synchronized void m20638a(long j, long j2) {
        synchronized (frf.class) {
            exw.m18443a("SongDatabase", "updateLibrarySongLastModified");
            try {
                m20632a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("last_add_timestamp", Long.valueOf(j2));
                m20632a().update("audio_library", contentValues, "_id=?", new String[]{String.valueOf(j)});
            } catch (Exception e) {
            } finally {
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            }
        }
    }

    public static synchronized void m20679f(glg com_ushareit_listenit_glg) {
        synchronized (frf.class) {
            exw.m18443a("SongDatabase", "resetLastPlayTimestamp");
            try {
                m20632a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("last_play_timestamp", Integer.valueOf(0));
                m20632a().update("audio_library", contentValues, "_id=?", new String[]{String.valueOf(com_ushareit_listenit_glg.f14334b)});
                com_ushareit_listenit_glg.f14358z = 0;
            } catch (Exception e) {
            } finally {
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            }
        }
    }

    public static synchronized void m20663b(List<glg> list) {
        synchronized (frf.class) {
            try {
                m20632a().beginTransaction();
                for (glg g : list) {
                    m20681g(g);
                }
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            } catch (Exception e) {
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            } catch (Throwable th) {
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            }
        }
        return;
    }

    public static synchronized void m20681g(glg com_ushareit_listenit_glg) {
        synchronized (frf.class) {
            try {
                boolean e = gef.m21805a().m21835e();
                ContentValues contentValues = new ContentValues();
                contentValues.put("song_state", Integer.valueOf(2));
                contentValues.put("song_source", Integer.valueOf(1));
                com_ushareit_listenit_glg.f14336d = 2;
                com_ushareit_listenit_glg.f14348p = 1;
                if (e) {
                    contentValues.put("changed_flag", Integer.valueOf(1));
                    com_ushareit_listenit_glg.f14350r = 1;
                } else {
                    contentValues.put("sync_time", Integer.valueOf(0));
                    com_ushareit_listenit_glg.f14349q = 0;
                }
                int update = m20632a().update("audio_library", contentValues, "_id=?", new String[]{String.valueOf(com_ushareit_listenit_glg.f14334b)});
                if (update > 0) {
                    fle.m19717b().m19733c(true);
                    if (e) {
                        if (!flw.m19819a().m19842c() && (flw.m19819a().m19813f(com_ushareit_listenit_glg) || flw.m19819a().m19812e(com_ushareit_listenit_glg) || flw.m19819a().m19814g(com_ushareit_listenit_glg))) {
                            flw.m19819a().m19840c(com_ushareit_listenit_glg);
                            flw.m19819a().m19844d(com_ushareit_listenit_glg);
                        } else if (!fmc.m19867a().m19897c() && (fmc.m19867a().m19813f(com_ushareit_listenit_glg) || fmc.m19867a().m19812e(com_ushareit_listenit_glg) || fmc.m19867a().m19814g(com_ushareit_listenit_glg))) {
                            fmc.m19867a().m19888a(com_ushareit_listenit_glg);
                            fmc.m19867a().m19893b(com_ushareit_listenit_glg);
                        }
                    }
                }
                List<String> a = frd.m20599a(com_ushareit_listenit_glg.f14334b);
                for (String d : a) {
                    frd.m20620d(d);
                }
                m20632a().delete("playlist_song", "song_id=?", new String[]{String.valueOf(com_ushareit_listenit_glg.f14334b)});
                exw.m18443a("SongDatabase", "removeLibrarySong: valuse=" + contentValues.toString() + "ret=" + update + ", playlist.size=" + a.size());
            } catch (Exception e2) {
            }
        }
    }

    public static synchronized boolean m20676e(String str) {
        boolean z = false;
        synchronized (frf.class) {
            String[] strArr = new String[]{str, String.valueOf(2)};
            Cursor rawQuery = m20632a().rawQuery("select _id from audio_library where _data=? and song_state=?", strArr);
            if (gyn.m23200a(rawQuery)) {
                if (rawQuery.getCount() > 0) {
                    z = true;
                }
                rawQuery.close();
            }
        }
        return z;
    }

    public static synchronized boolean m20664b(long j) {
        boolean z = false;
        synchronized (frf.class) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" select ").append("like_it").append(" from ").append("audio_library");
            stringBuilder.append(" where ").append("_id").append("=?");
            Cursor rawQuery = m20632a().rawQuery(stringBuilder.toString(), new String[]{String.valueOf(j)});
            if (gyn.m23200a(rawQuery)) {
                int columnIndex = rawQuery.getColumnIndex("like_it");
                if (columnIndex != -1 && rawQuery.getLong(columnIndex) > 0) {
                    z = true;
                }
                exw.m18443a("SongDatabase", "isLikeIt: likeIt=" + z + ", songID=" + j);
                rawQuery.close();
            }
        }
        return z;
    }

    public static synchronized void m20648a(glg com_ushareit_listenit_glg, boolean z) {
        synchronized (frf.class) {
            long currentTimeMillis;
            if (z) {
                try {
                    currentTimeMillis = System.currentTimeMillis();
                } catch (Exception e) {
                }
            } else {
                currentTimeMillis = 0;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("like_it", Long.valueOf(currentTimeMillis));
            contentValues.put("changed_flag", Integer.valueOf(1));
            com_ushareit_listenit_glg.f14351s = currentTimeMillis;
            com_ushareit_listenit_glg.f14350r = 1;
            if (m20632a().update("audio_library", contentValues, "_id=?", new String[]{String.valueOf(com_ushareit_listenit_glg.f14334b)}) > 0) {
                fle.m19717b().m19733c(true);
            }
            exw.m18457e("SongDatabase", "updateLikeIt: valuse=" + contentValues.toString() + ", songId=" + com_ushareit_listenit_glg.f14334b + ", name=" + com_ushareit_listenit_glg.f14338f);
            fiz.m19507d();
        }
    }

    public static synchronized void m20662b(glg com_ushareit_listenit_glg, long j) {
        synchronized (frf.class) {
            try {
                String[] strArr = new String[]{String.valueOf(com_ushareit_listenit_glg.f14334b)};
                Cursor rawQuery = m20632a().rawQuery("select play_count, temp_play_count, last_play_timestamp from audio_library where _id=?", strArr);
                if (gyn.m23200a(rawQuery)) {
                    int i = rawQuery.getInt(rawQuery.getColumnIndex(fnl.PLAY_COUNT));
                    int i2 = rawQuery.getInt(rawQuery.getColumnIndex("temp_play_count"));
                    long j2 = rawQuery.getLong(rawQuery.getColumnIndex("last_play_timestamp"));
                    rawQuery.close();
                    if (j >= j2) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("last_play_timestamp", Long.valueOf(j));
                        contentValues.put(fnl.PLAY_COUNT, Integer.valueOf(i + 1));
                        contentValues.put("temp_play_count", Integer.valueOf(i2 + 1));
                        m20632a().update("audio_library", contentValues, "_id=?", strArr);
                        com_ushareit_listenit_glg.f14354v = i + 1;
                        com_ushareit_listenit_glg.f14355w = i2 + 1;
                        com_ushareit_listenit_glg.f14358z = j;
                        exw.m18443a("SongDatabase", "updatePlayTimestamp: valuse=" + contentValues.toString());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void m20678f() {
        synchronized (frf.class) {
            exw.m18443a("recommend", "resetAllSongsPlayCount()");
            try {
                m20632a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("temp_play_count", Integer.valueOf(0));
                m20632a().update("audio_library", contentValues, null, null);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                m20632a().setTransactionSuccessful();
                m20632a().endTransaction();
            }
        }
    }

    public static synchronized int m20680g() {
        int i = 0;
        synchronized (frf.class) {
            Cursor rawQuery = m20632a().rawQuery(m20635a(" select ", "_id", " from ", "audio_library", " where ", "song_state", "=?", " and ", "last_add_timestamp", ">?", " group by _size, title, artist"), new String[]{String.valueOf(0), String.valueOf(0)});
            if (gyn.m23200a(rawQuery)) {
                i = rawQuery.getCount();
                rawQuery.close();
            }
        }
        return i;
    }

    private static String m20635a(String... strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : strArr) {
            stringBuilder.append(append);
        }
        return stringBuilder.toString();
    }

    public static synchronized int m20682h() {
        int i = 0;
        synchronized (frf.class) {
            String str = "result";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" select count() as ").append(str).append(" from ").append("audio_library");
            stringBuilder.append(" where ").append("last_play_timestamp").append(">?");
            stringBuilder.append(" and ").append("song_state").append("=?");
            Cursor rawQuery = m20632a().rawQuery(stringBuilder.toString(), new String[]{String.valueOf(0), String.valueOf(0)});
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

    public static synchronized int m20683i() {
        int i = 0;
        synchronized (frf.class) {
            String str = "result";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" select count() as ").append(str).append(" from ").append("audio_library");
            stringBuilder.append(" where ").append("like_it").append(">?");
            stringBuilder.append(" and ").append("song_state").append("=?");
            Cursor rawQuery = m20632a().rawQuery(stringBuilder.toString(), new String[]{String.valueOf(0), String.valueOf(0)});
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

    public static int m20684j() {
        int i = 0;
        String str = "result";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" select count() as ").append(str).append(" from ").append("audio_library");
        stringBuilder.append(" where ").append("song_source").append("=?");
        stringBuilder.append(" and ").append("song_state").append("=?");
        stringBuilder.append(" and ").append("song_backup").append(">?");
        Cursor rawQuery = m20632a().rawQuery(stringBuilder.toString(), new String[]{String.valueOf(1), String.valueOf(0), "0"});
        if (gyn.m23200a(rawQuery)) {
            int columnIndex = rawQuery.getColumnIndex(str);
            if (columnIndex != -1) {
                i = rawQuery.getInt(columnIndex);
            }
            rawQuery.close();
        }
        return i;
    }

    public static int m20685k() {
        String[] strArr = new String[]{String.valueOf(0), String.valueOf(0), String.valueOf(0)};
        Cursor rawQuery = m20632a().rawQuery("select _id from audio_library where song_state=? and song_source=? and song_backup=?  group by _size, title, artist", strArr);
        if (!gyn.m23200a(rawQuery)) {
            return 0;
        }
        int count = rawQuery.getCount();
        rawQuery.close();
        return count;
    }

    public static void m20639a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            m20658b(sQLiteDatabase);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
        }
    }

    public static void m20658b(SQLiteDatabase sQLiteDatabase) {
        for (frh a : frc.m20583a(sQLiteDatabase)) {
            m20641a(a, sQLiteDatabase);
        }
    }

    private static void m20641a(frh com_ushareit_listenit_frh, SQLiteDatabase sQLiteDatabase) {
        m20640a(sQLiteDatabase, new fnn(com_ushareit_listenit_frh));
        fle.m19717b().m19733c(true);
    }

    public static synchronized void m20640a(SQLiteDatabase sQLiteDatabase, fnn com_ushareit_listenit_fnn) {
        int i = 1;
        synchronized (frf.class) {
            long c = gvj.m22916c();
            String a = gyn.m23184a(com_ushareit_listenit_fnn);
            String b = gyn.m23209b(a);
            String valueOf = String.valueOf(gyn.m23234e());
            long currentTimeMillis = System.currentTimeMillis();
            if (!gse.m22670a().m22674b(b)) {
                i = com_ushareit_listenit_fnn.getSta();
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("_id", Long.valueOf(c));
            contentValues.put("song_key", Long.valueOf(c));
            contentValues.put("song_state", Integer.valueOf(i));
            contentValues.put("_data", a);
            contentValues.put("_size", Integer.valueOf(com_ushareit_listenit_fnn.getSz()));
            contentValues.put("duration", Integer.valueOf(com_ushareit_listenit_fnn.getDu()));
            contentValues.put("year", Integer.valueOf(0));
            contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
            contentValues.put("last_add_timestamp", Long.valueOf(currentTimeMillis));
            contentValues.put("title", com_ushareit_listenit_fnn.getNa());
            contentValues.put("artist_id", Integer.valueOf(0));
            contentValues.put("artist", com_ushareit_listenit_fnn.getAr());
            contentValues.put("album_id", Integer.valueOf(0));
            contentValues.put("album", com_ushareit_listenit_fnn.getAl());
            contentValues.put("album_artist", com_ushareit_listenit_fnn.getAl());
            contentValues.put("album_art_path", valueOf);
            contentValues.put(fnl.PLAY_COUNT, Integer.valueOf(0));
            contentValues.put("temp_play_count", Integer.valueOf(0));
            contentValues.put("folder_name", gyn.m23220c(a));
            contentValues.put("folder_path", b);
            contentValues.put("last_play_timestamp", Integer.valueOf(0));
            contentValues.put("song_md5", com_ushareit_listenit_fnn.getId());
            contentValues.put("song_bitrate", Integer.valueOf(com_ushareit_listenit_fnn.getBr()));
            contentValues.put("song_genre", com_ushareit_listenit_fnn.getGe());
            contentValues.put("song_mimetype", com_ushareit_listenit_fnn.getMt());
            contentValues.put("sync_time", Long.valueOf(com_ushareit_listenit_fnn.getSt()));
            contentValues.put("changed_flag", Integer.valueOf(0));
            contentValues.put("song_source", Integer.valueOf(1));
            contentValues.put("song_backup", Long.valueOf(com_ushareit_listenit_fnn.getBk()));
            contentValues.put("like_it", Long.valueOf(com_ushareit_listenit_fnn.getFv()));
            contentValues.put("albumart_modified_timestamp", Integer.valueOf(0));
            sQLiteDatabase.insert("audio_library", null, contentValues);
            if (!gvj.m22857B(eys.m18562a()) && i == 0) {
                gyo.m23264a().m23266a(eys.m18562a(), Long.valueOf(c));
            }
        }
    }
}
