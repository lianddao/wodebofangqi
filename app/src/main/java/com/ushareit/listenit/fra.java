package com.ushareit.listenit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class fra extends SQLiteOpenHelper {
    private static fra f13249a;

    public static synchronized fra m20531a() {
        fra com_ushareit_listenit_fra;
        synchronized (fra.class) {
            if (f13249a == null) {
                f13249a = new fra(eys.m18562a(), "musicplayer.db", null, 13);
            }
            com_ushareit_listenit_fra = f13249a;
        }
        return com_ushareit_listenit_fra;
    }

    private fra(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS audio_library( _id LONG, song_key INTEGER, song_state INTEGER, _data TEXT, _size INTEGER, duration INTEGER, year INTEGER, date_modified LONG, last_add_timestamp LONG, title TEXT, artist_id INTEGER, artist TEXT, album_id INTEGER, album TEXT, album_artist TEXT, album_art_path TEXT, play_count INTEGER, folder_path TEXT, folder_name TEXT, last_play_timestamp LONG, like_it LONG, song_genre TEXT, song_mimetype TEXT, song_source INTEGER, song_md5 TEXT, song_bitrate INTEGER, sync_time LONG, song_backup LONG, is_support INTEGER, changed_flag INTEGER, temp_play_count INTEGER,albumart_modified_timestamp LONG, track INTEGER )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS playlist ( playlist_id TEXT, playlist_key INTEGER, playlist_name TEXT, sync_time LONG, changed_flag INTEGER, visibility INTEGER, state INTEGER )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS playlist_song( row_id INTEGER, row_key INTEGER, playlist_id INTEGER, song_id LONG )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS audio_clips_library( _id LONG, title TEXT, _data TEXT, _size INTEGER, duration INTEGER, last_add_timestamp LONG, artist TEXT, album TEXT, album_art_path TEXT, folder_path TEXT, song_genre TEXT, song_bitrate INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS nearby_user( user_id TEXT, user_name TEXT, playlist_count INTEGER, song_count INTEGER,longitude REAL,latitude REAL,address TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS nearby_user_playlist( playlist_id TEXT, user_id TEXT, playlist_name TEXT, song_count INTEGER,play_count INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS nearby_user_song( id LONG, name TEXT, artist TEXT, album TEXT, genre TEXT, bitrate INTEGER, duration INTEGER, size INTEGER, mimetype TEXT, is_collected INTEGER,is_download INTEGER,uid TEXT,playlist_id TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS nearby_collect( song_md5 TEXT, song_id LONG, song_name TEXT, song_author TEXT, album TEXT, mimetype TEXT, genre TEXT, bitrate INTEGER, duration INTEGER, timestemp INTEGER, is_downloaded INTEGER, size INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS stream_songs( _id LONG, title TEXT, artist TEXT, album TEXT, artwork TEXT, streamurl TEXT, size INTEGER, duration INTEGER, play_count LONG, last_play_timestamp LONG, valid INTEGER, like_it LONG )");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onUpgrade(android.database.sqlite.SQLiteDatabase r1, int r2, int r3) {
        /*
        r0 = this;
        switch(r2) {
            case 1: goto L_0x0004;
            case 2: goto L_0x0007;
            case 3: goto L_0x000a;
            case 4: goto L_0x000d;
            case 5: goto L_0x0010;
            case 6: goto L_0x0013;
            case 7: goto L_0x0016;
            case 8: goto L_0x0019;
            case 9: goto L_0x001c;
            case 10: goto L_0x001f;
            case 11: goto L_0x0022;
            case 12: goto L_0x0025;
            default: goto L_0x0003;
        };
    L_0x0003:
        return;
    L_0x0004:
        r0.m20532a(r1);
    L_0x0007:
        r0.m20534b(r1);
    L_0x000a:
        r0.m20535c(r1);
    L_0x000d:
        r0.m20536d(r1);
    L_0x0010:
        r0.m20537e(r1);
    L_0x0013:
        r0.m20538f(r1);
    L_0x0016:
        r0.m20539g(r1);
    L_0x0019:
        r0.m20540h(r1);
    L_0x001c:
        r0.m20541i(r1);
    L_0x001f:
        r0.m20542j(r1);
    L_0x0022:
        r0.m20543k(r1);
    L_0x0025:
        r0.m20544l(r1);
        goto L_0x0003;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.fra.onUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }

    protected void m20532a(SQLiteDatabase sQLiteDatabase) {
        gxv.m23109a(sQLiteDatabase, "audio_library", "CREATE TABLE IF NOT EXISTS audio_library( _id LONG, song_key INTEGER, song_state INTEGER, _data TEXT, _size INTEGER, duration INTEGER, year INTEGER, date_modified LONG, last_add_timestamp LONG, title TEXT, artist_id INTEGER, artist TEXT, album_id INTEGER, album TEXT, album_artist TEXT, album_art_path TEXT, play_count INTEGER, folder_path TEXT, folder_name TEXT, last_play_timestamp LONG, like_it LONG, song_genre TEXT, song_mimetype TEXT, song_source INTEGER, song_md5 TEXT, song_bitrate INTEGER, sync_time LONG, song_backup LONG, is_support INTEGER, changed_flag INTEGER, temp_play_count INTEGER,albumart_modified_timestamp LONG, track INTEGER )");
        gxv.m23109a(sQLiteDatabase, "playlist", "CREATE TABLE IF NOT EXISTS playlist ( playlist_id TEXT, playlist_key INTEGER, playlist_name TEXT, sync_time LONG, changed_flag INTEGER, visibility INTEGER, state INTEGER )");
        gxv.m23110a(sQLiteDatabase, "audio_library", new String[]{"song_md5", "song_source", "sync_time", "changed_flag", "song_backup"}, new String[]{"0", String.valueOf(0), "0", "0", "0"});
        gxv.m23110a(sQLiteDatabase, "playlist", new String[]{"sync_time", "changed_flag", "state"}, new String[]{"0", "1", String.valueOf(0)});
        for (glc com_ushareit_listenit_glc : fqs.m20461b(sQLiteDatabase)) {
            frd.m20601a(sQLiteDatabase, com_ushareit_listenit_glc.f14283c);
        }
    }

    protected void m20534b(SQLiteDatabase sQLiteDatabase) {
        gxv.m23109a(sQLiteDatabase, "audio_library", "CREATE TABLE IF NOT EXISTS audio_library( _id LONG, song_key INTEGER, song_state INTEGER, _data TEXT, _size INTEGER, duration INTEGER, year INTEGER, date_modified LONG, last_add_timestamp LONG, title TEXT, artist_id INTEGER, artist TEXT, album_id INTEGER, album TEXT, album_artist TEXT, album_art_path TEXT, play_count INTEGER, folder_path TEXT, folder_name TEXT, last_play_timestamp LONG, like_it LONG, song_genre TEXT, song_mimetype TEXT, song_source INTEGER, song_md5 TEXT, song_bitrate INTEGER, sync_time LONG, song_backup LONG, is_support INTEGER, changed_flag INTEGER, temp_play_count INTEGER,albumart_modified_timestamp LONG, track INTEGER )");
        gxv.m23110a(sQLiteDatabase, "audio_library", new String[]{"is_support"}, new String[]{"0"});
    }

    protected void m20535c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS audio_clips_library( _id LONG, title TEXT, _data TEXT, _size INTEGER, duration INTEGER, last_add_timestamp LONG, artist TEXT, album TEXT, album_art_path TEXT, folder_path TEXT, song_genre TEXT, song_bitrate INTEGER)");
    }

    protected void m20536d(SQLiteDatabase sQLiteDatabase) {
        gxv.m23109a(sQLiteDatabase, "audio_library", "CREATE TABLE IF NOT EXISTS audio_library( _id LONG, song_key INTEGER, song_state INTEGER, _data TEXT, _size INTEGER, duration INTEGER, year INTEGER, date_modified LONG, last_add_timestamp LONG, title TEXT, artist_id INTEGER, artist TEXT, album_id INTEGER, album TEXT, album_artist TEXT, album_art_path TEXT, play_count INTEGER, folder_path TEXT, folder_name TEXT, last_play_timestamp LONG, like_it LONG, song_genre TEXT, song_mimetype TEXT, song_source INTEGER, song_md5 TEXT, song_bitrate INTEGER, sync_time LONG, song_backup LONG, is_support INTEGER, changed_flag INTEGER, temp_play_count INTEGER,albumart_modified_timestamp LONG, track INTEGER )");
        gxv.m23110a(sQLiteDatabase, "audio_library", new String[]{"temp_play_count"}, new String[]{"0"});
    }

    protected void m20537e(SQLiteDatabase sQLiteDatabase) {
        gxv.m23109a(sQLiteDatabase, "audio_library", "CREATE TABLE IF NOT EXISTS audio_library( _id LONG, song_key INTEGER, song_state INTEGER, _data TEXT, _size INTEGER, duration INTEGER, year INTEGER, date_modified LONG, last_add_timestamp LONG, title TEXT, artist_id INTEGER, artist TEXT, album_id INTEGER, album TEXT, album_artist TEXT, album_art_path TEXT, play_count INTEGER, folder_path TEXT, folder_name TEXT, last_play_timestamp LONG, like_it LONG, song_genre TEXT, song_mimetype TEXT, song_source INTEGER, song_md5 TEXT, song_bitrate INTEGER, sync_time LONG, song_backup LONG, is_support INTEGER, changed_flag INTEGER, temp_play_count INTEGER,albumart_modified_timestamp LONG, track INTEGER )");
        gxv.m23110a(sQLiteDatabase, "audio_library", new String[]{"track"}, new String[]{"0"});
    }

    protected void m20538f(SQLiteDatabase sQLiteDatabase) {
        gxv.m23109a(sQLiteDatabase, "playlist", "CREATE TABLE IF NOT EXISTS playlist ( playlist_id TEXT, playlist_key INTEGER, playlist_name TEXT, sync_time LONG, changed_flag INTEGER, visibility INTEGER, state INTEGER )");
        gxv.m23110a(sQLiteDatabase, "playlist", new String[]{"visibility"}, new String[]{"0"});
    }

    protected void m20539g(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS nearby_user( user_id TEXT, user_name TEXT, playlist_count INTEGER, song_count INTEGER,longitude REAL,latitude REAL,address TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS nearby_user_playlist( playlist_id TEXT, user_id TEXT, playlist_name TEXT, song_count INTEGER,play_count INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS nearby_user_song( id LONG, name TEXT, artist TEXT, album TEXT, genre TEXT, bitrate INTEGER, duration INTEGER, size INTEGER, mimetype TEXT, is_collected INTEGER,is_download INTEGER,uid TEXT,playlist_id TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS nearby_collect( song_md5 TEXT, song_id LONG, song_name TEXT, song_author TEXT, album TEXT, mimetype TEXT, genre TEXT, bitrate INTEGER, duration INTEGER, timestemp INTEGER, is_downloaded INTEGER, size INTEGER)");
    }

    protected void m20540h(SQLiteDatabase sQLiteDatabase) {
        gxv.m23109a(sQLiteDatabase, "nearby_user", "CREATE TABLE IF NOT EXISTS nearby_user( user_id TEXT, user_name TEXT, playlist_count INTEGER, song_count INTEGER,longitude REAL,latitude REAL,address TEXT)");
        gxv.m23110a(sQLiteDatabase, "nearby_user", new String[]{"address"}, new String[]{"''"});
    }

    protected void m20541i(SQLiteDatabase sQLiteDatabase) {
        frf.m20639a(sQLiteDatabase);
        gxv.m23108a(sQLiteDatabase, "nearby_collect");
    }

    protected void m20542j(SQLiteDatabase sQLiteDatabase) {
        frb.m20580a(sQLiteDatabase);
    }

    protected void m20543k(SQLiteDatabase sQLiteDatabase) {
        gxv.m23109a(sQLiteDatabase, "audio_library", "CREATE TABLE IF NOT EXISTS audio_library( _id LONG, song_key INTEGER, song_state INTEGER, _data TEXT, _size INTEGER, duration INTEGER, year INTEGER, date_modified LONG, last_add_timestamp LONG, title TEXT, artist_id INTEGER, artist TEXT, album_id INTEGER, album TEXT, album_artist TEXT, album_art_path TEXT, play_count INTEGER, folder_path TEXT, folder_name TEXT, last_play_timestamp LONG, like_it LONG, song_genre TEXT, song_mimetype TEXT, song_source INTEGER, song_md5 TEXT, song_bitrate INTEGER, sync_time LONG, song_backup LONG, is_support INTEGER, changed_flag INTEGER, temp_play_count INTEGER,albumart_modified_timestamp LONG, track INTEGER )");
        gxv.m23110a(sQLiteDatabase, "audio_library", new String[]{"albumart_modified_timestamp"}, new String[]{"0"});
    }

    protected void m20544l(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS stream_songs( _id LONG, title TEXT, artist TEXT, album TEXT, artwork TEXT, streamurl TEXT, size INTEGER, duration INTEGER, play_count LONG, last_play_timestamp LONG, valid INTEGER, like_it LONG )");
    }

    public synchronized SQLiteDatabase m20533b() {
        return getWritableDatabase();
    }
}
