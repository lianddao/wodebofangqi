package com.songbirdnest.database.friends;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import com.songbirdnest.database.AbstractTable;
import com.songbirdnest.database.Column;
import com.songbirdnest.database.Column.COLUMN_TYPE;
import com.songbirdnest.database.Database;
import java.util.ArrayList;
import java.util.List;

public class PhotoTable extends AbstractTable {
    public static final String FACEBOOK_ID = "facebook_id";
    private static final int FACEBOOK_ID_COLUMN = 1;
    public static final String FACEBOOK_IMAGE = "facebook_image";
    public static final String FACEBOOK_URL = "facebook_url";
    private static final int FACEBOOK_URL_COLUMN = 2;
    public static final String ID = "_id";
    private static final int ID_COLUMN = 0;
    public static final String LAST_ACCESSED = "last_accessed";
    private static final int LAST_ACCESSED_COLUMN = 4;
    public static final String LOCAL_PATH = "local_path";
    private static final int LOCAL_PATH_COLUMN = 3;
    public static final String TABLE_NAME = "photos";
    public static final String TAG = "PhotoTable";
    private static final int version = 2;

    public PhotoTable() {
        super(TABLE_NAME);
        addColumn(new Column("_id", COLUMN_TYPE.INTEGER, true));
        addColumn(new Column("facebook_id", COLUMN_TYPE.TEXT));
        addColumn(new Column(FACEBOOK_URL, COLUMN_TYPE.TEXT));
        addColumn(new Column(LOCAL_PATH, COLUMN_TYPE.TEXT));
        addColumn(new Column(FACEBOOK_IMAGE, COLUMN_TYPE.BLOB));
        addColumn(new Column(LAST_ACCESSED, COLUMN_TYPE.INTEGER));
        setVersion(2);
    }

    public Object insertEntry(Database database, Object data) {
        Photo photo = (Photo) data;
        ContentValues cv = new ContentValues();
        cv.put("facebook_id", photo.getFacebookId());
        cv.put(FACEBOOK_URL, photo.getFacebookURL());
        cv.put(LOCAL_PATH, photo.getLocalPath());
        cv.put(LAST_ACCESSED, Long.valueOf(photo.getLastAccessed()));
        try {
            photo.setId(database.getDatabase().insert(TABLE_NAME, "facebook_id", cv));
        } catch (SQLiteException e) {
            Log.e(TAG, e.getMessage());
        }
        return photo;
    }

    public void deleteEntry(Database database, Object data) {
        try {
            database.getDatabase().delete(TABLE_NAME, "_id=?", new String[]{String.valueOf(((Photo) data).getId())});
        } catch (SQLiteException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void deleteEntryWhere(Database database, String whereClause, String[] whereArgs) {
        try {
            database.getDatabase().delete(TABLE_NAME, whereClause, whereArgs);
        } catch (SQLiteException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void deleteAllEntries(Database database) {
        try {
            database.getDatabase().delete(TABLE_NAME, null, null);
        } catch (SQLiteException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public Photo getEntry(Database database, Object data) {
        try {
            Cursor result = database.getDatabase().query(TABLE_NAME, getProjection(), "facebook_id=?", new String[]{(String) data}, null, null, null);
            if (result.moveToFirst()) {
                Photo photo = fillPhoto(result);
                result.close();
                return photo;
            }
            result.close();
            return null;
        } catch (SQLiteException e) {
            Log.e(TAG, e.getMessage());
            return null;
        }
    }

    public Photo updatePhoto(Database database, Object data) {
        Photo photo = (Photo) data;
        ContentValues cv = new ContentValues();
        cv.put("facebook_id", photo.getFacebookId());
        cv.put(FACEBOOK_URL, photo.getFacebookURL());
        cv.put(LOCAL_PATH, photo.getLocalPath());
        cv.put(LAST_ACCESSED, Long.valueOf(photo.getLastAccessed()));
        try {
            database.getDatabase().update(TABLE_NAME, cv, "_id=?", new String[]{String.valueOf(photo.getId())});
        } catch (SQLiteException e) {
            Log.e(TAG, e.getMessage());
        }
        return photo;
    }

    public int updateEntryWhere(Database database, ContentValues cv, String whereClause, String[] whereArgs) {
        try {
            return database.getDatabase().update(TABLE_NAME, cv, whereClause, whereArgs);
        } catch (SQLiteException e) {
            Log.e(TAG, e.getMessage());
            return 0;
        }
    }

    public String getIdField() {
        return "_id";
    }

    public List<Photo> getPhotos(Database database) {
        List<Photo> photos = new ArrayList();
        try {
            Cursor result = database.getDatabase().query(TABLE_NAME, getProjection(), null, null, null, null, null);
            if (result.moveToFirst()) {
                while (!result.isAfterLast()) {
                    photos.add(fillPhoto(result));
                    result.moveToNext();
                }
                result.close();
            } else {
                result.close();
            }
        } catch (SQLiteException e) {
            Log.e(TAG, e.getMessage());
        }
        return photos;
    }

    public static Photo fillPhoto(Cursor result) {
        Photo photo = new Photo();
        photo.setId(result.getLong(0));
        photo.setFacebookId(result.getString(1));
        photo.setFacebookURL(result.getString(2));
        photo.setLocalPath(result.getString(3));
        photo.setLastAccessed(result.getLong(4));
        return photo;
    }
}
