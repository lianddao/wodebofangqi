package com.songbirdnest.mediaplayer.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.songbirdnest.util.ZeroCursor;
import java.io.ByteArrayOutputStream;

public class PodcastAlbumArtHelper {
    public static final String ART_TABLE = "arttable";
    private static final String CREATE_ART_TABLE = "create table arttable(albumkey text primary key ,thumbart blob not null, displayart blob not null,albumname text , songPath text,_id int not null)";
    private static final String DATABASE_NAME = "PodcastArt";
    private static final int DATABASE_VERSION = 1;
    public static final String KEY_ALBUM_ART = "thumbart";
    public static final String KEY_ALBUM_KEY = "albumkey";
    public static final String KEY_ALBUM_NAME = "albumname";
    public static final String KEY_ID = "_id";
    public static final String KEY_LARGE_ALBUM_ART = "displayart";
    public static final String KEY_SONG_DATA = "songPath";
    public static String[] projection = new String[]{KEY_ALBUM_ART, KEY_ALBUM_KEY, KEY_ALBUM_NAME, KEY_SONG_DATA, "_id"};
    SQLiteDatabase mDb;
    DatabaseHelper mDbHelper;

    private static class DatabaseHelper extends SQLiteOpenHelper {
        public DatabaseHelper(Context context) {
            super(context, PodcastAlbumArtHelper.DATABASE_NAME, null, 1);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(PodcastAlbumArtHelper.CREATE_ART_TABLE);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE ID EXISTS arttable");
            onCreate(db);
        }
    }

    public PodcastAlbumArtHelper(Context pContext) {
        this.mDbHelper = new DatabaseHelper(pContext);
    }

    public PodcastAlbumArtHelper open() throws SQLException {
        this.mDb = this.mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        this.mDb.close();
        this.mDbHelper.close();
    }

    public void createEntry(PodcastEntry pEntry) {
        ByteArrayOutputStream thumbArt = new ByteArrayOutputStream();
        pEntry.mBitmap.compress(CompressFormat.JPEG, 100, thumbArt);
        ByteArrayOutputStream largeArt = new ByteArrayOutputStream();
        pEntry.mLargeBitmap.compress(CompressFormat.JPEG, 100, largeArt);
        ContentValues cv = new ContentValues();
        cv.put(KEY_ALBUM_ART, thumbArt.toByteArray());
        cv.put(KEY_ALBUM_KEY, pEntry.mAlbumKey);
        cv.put(KEY_LARGE_ALBUM_ART, largeArt.toByteArray());
        cv.put(KEY_ALBUM_NAME, pEntry.mAlbum);
        cv.put(KEY_SONG_DATA, pEntry.mPath);
        cv.put("_id", Integer.valueOf(0));
        this.mDb.insert(ART_TABLE, null, cv);
    }

    public synchronized void removeEntry(String pAlbumKey) {
        this.mDb.delete(ART_TABLE, "albumkey = ?", new String[]{pAlbumKey});
    }

    public Cursor getCursor(String pSearch) {
        Cursor query = this.mDb.query(true, ART_TABLE, projection, "albumname LIKE ?", new String[]{"%" + pSearch + "%"}, null, null, "albumname ASC", null);
        if (query == null) {
            return new ZeroCursor(projection);
        }
        return query;
    }

    public Cursor getCursor() {
        Cursor query = this.mDb.query(true, ART_TABLE, projection, null, null, null, null, "albumname ASC", null);
        if (query == null) {
            return new ZeroCursor(projection);
        }
        return query;
    }

    public Bitmap getArtwork(String pAlbumKey) {
        Cursor aCursor = this.mDb.query(true, ART_TABLE, new String[]{KEY_LARGE_ALBUM_ART, KEY_ALBUM_KEY}, "albumkey= ?", new String[]{new String(pAlbumKey)}, null, null, null, null);
        if (aCursor.moveToFirst()) {
            byte[] blob = aCursor.getBlob(aCursor.getColumnIndex(KEY_LARGE_ALBUM_ART));
            Bitmap aBitmap = BitmapFactory.decodeByteArray(blob, 0, blob.length);
            aCursor.close();
            return aBitmap;
        }
        aCursor.close();
        return null;
    }
}
