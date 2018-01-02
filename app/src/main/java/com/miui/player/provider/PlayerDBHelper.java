package com.miui.player.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import com.miui.player.C0329R;
import com.miui.player.provider.PlayerStore.MiuiEqualizer;
import com.miui.player.provider.PlayerStore.MiuiPlaylists;
import com.miui.player.provider.PlayerStore.MiuiPlaylists.Columns;
import com.xiaomi.music.util.MusicLog;
import com.xiaomi.music.util.StreamHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class PlayerDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "com_miui_player.db";
    private static final int DATABASE_VERSION = 14;
    private static final String TAG = PlayerDBHelper.class.getCanonicalName();
    final Context mContext;
    final boolean mInternal;

    public PlayerDBHelper(Context context, String name, boolean internal) {
        super(context, name, null, 14);
        this.mContext = context;
        this.mInternal = internal;
    }

    public void onCreate(SQLiteDatabase db) {
        updateDatabase(this.mContext, db, this.mInternal, 0, 14);
    }

    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        updateDatabase(this.mContext, db, this.mInternal, oldV, newV);
    }

    private static void updateDatabase(Context context, SQLiteDatabase db, boolean internal, int fromVersion, int toVersion) {
        Log.i(TAG, "Database update: from " + fromVersion + " to " + toVersion);
        if (toVersion != 14) {
            Log.e(TAG, "Illegal update request. Got " + toVersion + ", expected " + 14);
            throw new IllegalArgumentException();
        } else if (fromVersion > toVersion) {
            Log.e(TAG, "Illegal update request: can't downgrade from " + fromVersion + " to " + toVersion + ". Did you forget to wipe data?");
            throw new IllegalArgumentException();
        } else {
            if (fromVersion < 1) {
                Log.i(TAG, "Upgrading media database from version " + fromVersion + " to " + toVersion + ", which will destroy all old data");
                db.execSQL("DROP TABLE IF EXISTS playlists");
                db.execSQL("DROP TABLE IF EXISTS playlists_audio_map");
                db.execSQL("CREATE TABLE IF NOT EXISTS playlists ( _id  INTEGER PRIMARY KEY,name TEXT, folder_path TEXT, date_added INTEGER, list_type INTEGER, date_modified INTEGER);");
                db.execSQL("CREATE TABLE IF NOT EXISTS playlists_audio_map (_id INTEGER PRIMARY KEY, audio_id INTEGER NOT NULL, playlist_id INTEGER NOT NULL, play_order INTEGER NOT NULL, date_added INTEGER, _data TEXT NOT NULL, title TEXT NOT NULL, online_id TEXT, provider_id TEXT, album TEXT, artist TEXT, duration INTEGER );");
                db.execSQL("CREATE TRIGGER IF NOT EXISTS audio_playlist_cleanup DELETE ON playlists BEGIN  DELETE FROM playlists_audio_map WHERE playlist_id = old._id;  END ");
                createNowplayinglist(db);
                db.execSQL("DROP TABLE IF EXISTS equalizer");
                db.execSQL("CREATE TABLE IF NOT EXISTS equalizer (_id INTEGER PRIMARY KEY, name TEXT NOT NULL, _data TEXT NOT NULL, data_added INTEGER NOT NULL );");
                insertEqualizerConfig(context, db);
            }
            if (fromVersion < 3) {
                Log.i(TAG, "update db from 2 to 3");
                db.execSQL("DROP TABLE IF EXISTS statistics");
                db.execSQL("CREATE TABLE IF NOT EXISTS statistics (_id INTEGER PRIMARY KEY, audio_id INTEGER, _data TEXT, played_count INTEGER, data_added INTEGER NOT NULL, data_last_modified INTEGER NOT NULL);");
            }
            if (fromVersion < 4) {
                Log.i(TAG, "update db from 3 to 4");
                db.execSQL("DELETE FROM playlists_audio_map WHERE audio_id>=536870911");
            }
            if (fromVersion < 6) {
                Log.i(TAG, "update db from 4 to 6");
                db.execSQL("DROP TABLE IF EXISTS online_audio_detail");
                db.execSQL("CREATE TABLE IF NOT EXISTS online_audio_detail (_id INTEGER PRIMARY KEY, time_last_modified INTEGER NOT NULL,online_id TEXT NOT NULL, album_id TEXT, artist_id TEXT, album_url TEXT, lyric_url TEXT ); ");
            }
            if (fromVersion < 8) {
                Log.i(TAG, "update db from 6 to 8");
                db.execSQL("DROP TABLE IF EXISTS online_downloading");
                db.execSQL("CREATE TABLE IF NOT EXISTS online_downloading (_id INTEGER PRIMARY KEY, download_id INTEGER NOT NULL, online_id TEXT NOT NULL, bitrate INTEGER, link TEXT, description TEXT, time_last_modified INTEGER NOT NULL);");
            }
            if (fromVersion < 9) {
                Log.i(TAG, "update db from 8 to 9");
                db.execSQL("DROP TABLE IF EXISTS statistics");
                db.execSQL("CREATE TABLE IF NOT EXISTS statistics (_id INTEGER PRIMARY KEY, audio_id INTEGER NOT NULL, _data TEXT, played_count INTEGER NOT NULL DEFAULT 0, id3_corrected INTEGER NOT NULL DEFAULT 0, data_added INTEGER NOT NULL DEFAULT 0,  data_last_modified INTEGER NOT NULL DEFAULT 0 );");
            }
            if (fromVersion < 10) {
                Log.i(TAG, "update db from 9 to 10");
                db.execSQL("ALTER TABLE playlists ADD cloud_id STRING DEFAULT NULL");
                db.execSQL("ALTER TABLE playlists ADD sync_state STRING DEFAULT 'insert'");
                db.execSQL("ALTER TABLE playlists_audio_map ADD sync_state STRING DEFAULT 'insert'");
            }
            if (fromVersion < 11) {
                Log.i(TAG, "update db from 10 to 11");
                HMSwitcher.saveAllTracks(context, db);
                db.execSQL("delete from playlists_audio_map");
            }
            if (fromVersion < 12) {
                Log.i(TAG, "update db from 11 to 12");
                changePlaylistType(db, "nowplaying", -2);
                changePlaylistType(db, MiuiPlaylists.NAME_HISTORY, -3);
                changePlaylistType(db, "$miui$", 1);
                changePlaylistType(db, "$my_ktv$", 1);
            }
            if (fromVersion < 13) {
                Log.i(TAG, "update db from 12 to 13");
                db.execSQL("ALTER TABLE playlists_audio_map ADD mi_online_id STRING DEFAULT NULL");
                db.execSQL("UPDATE playlists_audio_map SET mi_online_id='1$'||online_id WHERE provider_id='baidu'");
                db.execSQL("UPDATE playlists_audio_map SET provider_id='1'  WHERE provider_id='baidu'");
                db.execSQL("ALTER TABLE playlists ADD mi_online_list_id STRING DEFAULT NULL");
                db.execSQL("ALTER TABLE playlists ADD mi_sync_playlist_id STRING DEFAULT NULL");
                db.execSQL("ALTER TABLE playlists ADD mi_sync_playlist_state INTEGER DEFAULT 0");
                db.execSQL("ALTER TABLE playlists ADD mi_sync_playlist_tag INTEGER DEFAULT 0");
                db.execSQL("ALTER TABLE playlists_audio_map ADD mi_sync_track_id STRING DEFAULT NULL");
                db.execSQL("ALTER TABLE playlists_audio_map ADD mi_sync_track_state INTEGER DEFAULT 0");
                db.execSQL("ALTER TABLE playlists_audio_map ADD mi_sync_track_tag INTEGER DEFAULT 0");
            }
            if (fromVersion < 14) {
                Log.i(TAG, "update db from 13 to 14");
                db.execSQL("DELETE FROM online_audio_detail");
                db.execSQL("ALTER TABLE online_audio_detail ADD mi_online_id STRING DEFAULT NULL");
                db.execSQL("ALTER TABLE online_audio_detail ADD provider_id TEXT");
            }
            if (fromVersion != toVersion) {
                MusicLog.m395d(TAG, "recreate view, from=" + fromVersion + ", to=" + toVersion);
                recreateViews(db);
            }
        }
    }

    private static void changePlaylistType(SQLiteDatabase db, String name, int newType) {
        ContentValues values = new ContentValues();
        values.put("list_type", Integer.valueOf(newType));
        db.update("playlists", values, "name=?", new String[]{name});
    }

    private static void createNowplayinglist(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put("_id", Integer.valueOf(0));
        cv.put("name", "nowplaying");
        cv.put("list_type", Integer.valueOf(-2));
        long time = System.currentTimeMillis();
        cv.put("date_added", Long.valueOf(time));
        cv.put(Columns.DATE_MODIFIED, Long.valueOf(time));
        db.insert("playlists", "date_added", cv);
    }

    private static void recreateViews(SQLiteDatabase db) {
        db.execSQL("DROP VIEW IF EXISTS audio_playlist_view");
        db.execSQL("DROP VIEW IF EXISTS nowplaying_audio_view");
        db.execSQL("DROP TRIGGER IF EXISTS nowplayinglist_delete");
        db.execSQL("CREATE VIEW IF NOT EXISTS audio_playlist_view AS SELECT playlists_audio_map._id, playlists_audio_map.sync_state, audio_id , title , album , artist , _data , playlists_audio_map.date_added , duration , provider_id , online_id, playlist_id, cloud_id AS playlist_cloud_id, mi_online_id, mi_sync_track_id, mi_sync_track_tag, mi_sync_track_state, mi_sync_playlist_id, mi_sync_playlist_tag, mi_sync_playlist_state, list_type , name AS playlist_name FROM playlists, playlists_audio_map WHERE playlists._id = playlists_audio_map.playlist_id");
        db.execSQL("CREATE VIEW IF NOT EXISTS nowplaying_audio_view AS SELECT audio_id AS _id , audio_id , title , album , artist , _data , date_added , duration , mi_online_id , online_id , provider_id , play_order FROM playlists_audio_map WHERE playlist_id = 0 ;");
        db.execSQL("CREATE TRIGGER IF NOT EXISTS nowplayinglist_delete INSTEAD OF DELETE ON nowplaying_audio_view BEGIN  DELETE FROM playlists_audio_map WHERE audio_id = old._id;  END ");
    }

    private static void insertEqualizerConfig(Context context, SQLiteDatabase db) {
        IOException e1;
        Throwable th;
        SQLiteStatement insertStatement = db.compileStatement("INSERT INTO equalizer VALUES (?, ?, ?, ?)");
        insertStatement.bindLong(1, 0);
        insertStatement.bindString(2, MiuiEqualizer.NAME_CUSTOM);
        insertStatement.bindString(3, MiuiEqualizer.DATA_DEFAULT_STR);
        insertStatement.bindLong(4, System.currentTimeMillis());
        insertStatement.executeInsert();
        InputStream is = null;
        InputStreamReader fis = null;
        BufferedReader reader = null;
        try {
            is = context.getAssets().open("eq_config");
            InputStreamReader fis2 = new InputStreamReader(is);
            try {
                BufferedReader reader2 = new BufferedReader(fis2);
                try {
                    String[] names = context.getResources().getStringArray(C0329R.array.equalizer_presents);
                    int i = 0;
                    int id = 1;
                    while (true) {
                        int id2;
                        try {
                            String s = reader2.readLine();
                            if (s != null) {
                                int comment = s.indexOf(35);
                                if (comment >= 0) {
                                    s = s.substring(0, comment);
                                }
                                if (s.length() != 0) {
                                    id2 = id + 1;
                                    insertStatement.bindLong(1, (long) id);
                                    int i2 = i + 1;
                                    insertStatement.bindString(2, names[i]);
                                    insertStatement.bindString(3, s);
                                    insertStatement.bindLong(4, System.currentTimeMillis());
                                    insertStatement.executeInsert();
                                    i = i2;
                                    id = id2;
                                }
                            } else {
                                StreamHelper.closeSafe(reader2);
                                StreamHelper.closeSafe(fis2);
                                StreamHelper.closeSafe(is);
                                reader = reader2;
                                fis = fis2;
                                id2 = id;
                                return;
                            }
                        } catch (IOException e) {
                            e1 = e;
                            reader = reader2;
                            fis = fis2;
                            id2 = id;
                        } catch (Throwable th2) {
                            th = th2;
                            reader = reader2;
                            fis = fis2;
                            id2 = id;
                        }
                    }
                } catch (IOException e2) {
                    e1 = e2;
                    reader = reader2;
                    fis = fis2;
                } catch (Throwable th3) {
                    th = th3;
                    reader = reader2;
                    fis = fis2;
                }
            } catch (IOException e3) {
                e1 = e3;
                fis = fis2;
                try {
                    e1.printStackTrace();
                    StreamHelper.closeSafe(reader);
                    StreamHelper.closeSafe(fis);
                    StreamHelper.closeSafe(is);
                } catch (Throwable th4) {
                    th = th4;
                    StreamHelper.closeSafe(reader);
                    StreamHelper.closeSafe(fis);
                    StreamHelper.closeSafe(is);
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                fis = fis2;
                StreamHelper.closeSafe(reader);
                StreamHelper.closeSafe(fis);
                StreamHelper.closeSafe(is);
                throw th;
            }
        } catch (IOException e4) {
            e1 = e4;
            e1.printStackTrace();
            StreamHelper.closeSafe(reader);
            StreamHelper.closeSafe(fis);
            StreamHelper.closeSafe(is);
        }
    }
}
