package com.songbirdnest.database.friends;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.songbirdnest.database.AbstractTable;
import com.songbirdnest.database.Column;
import com.songbirdnest.database.Column.COLUMN_TYPE;
import com.songbirdnest.database.Database;
import com.songbirdnest.soundboard.data.Friend;
import com.songbirdnest.util.Logger;
import java.util.ArrayList;
import java.util.List;

public class FriendTable extends AbstractTable {
    public static final String FACEBOOK_ID = "facebook_id";
    private static final int FACEBOOK_ID_COLUMN = 1;
    public static final String FACEBOOK_NAME = "facebook_name";
    private static final int FACEBOOK_NAME_COLUMN = 2;
    private static final int ID_COLUMN = 0;
    public static final String SOUNDBOARD_ID = "soundboard_id";
    private static final int SOUNDBOARD_ID_COLUMN = 3;
    public static final String TABLE_NAME = "friends";
    private static final int version = 1;

    public FriendTable() {
        super("friends");
        addColumn(new Column("_id", COLUMN_TYPE.INTEGER, true));
        addColumn(new Column("facebook_id", COLUMN_TYPE.TEXT));
        addColumn(new Column(FACEBOOK_NAME, COLUMN_TYPE.TEXT));
        addColumn(new Column(SOUNDBOARD_ID, COLUMN_TYPE.TEXT));
    }

    public List<Friend> insertFriends(Database database, List<Friend> friends) {
        ContentValues cv = new ContentValues();
        for (Friend friend : friends) {
            cv.put("facebook_id", friend.getFacebookId());
            cv.put(FACEBOOK_NAME, friend.getFullName());
            cv.put(SOUNDBOARD_ID, friend.getSoundBoardId());
            try {
                long id = database.getDatabase().insert("friends", "facebook_id", cv);
            } catch (SQLiteException e) {
                Logger.error((Object) this, e.getMessage());
            }
        }
        return friends;
    }

    public void deleteEntry(Database database, Object data) {
        try {
            database.getDatabase().delete("friends", "facebook_id=?", new String[]{String.valueOf(((Friend) data).getFacebookId())});
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
    }

    public void deleteEntryWhere(Database database, String whereClause, String[] whereArgs) {
        try {
            database.getDatabase().delete("friends", whereClause, whereArgs);
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
    }

    public void deleteAllEntries(Database database) {
        try {
            database.getDatabase().delete("friends", null, null);
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
    }

    public Friend getEntry(Database database, Object data) {
        try {
            Cursor result = database.getDatabase().query("friends", getProjection(), "facebook_id=?", new String[]{(String) data}, null, null, null);
            if (result.moveToFirst()) {
                Friend friend = fillFriend(result);
                result.close();
                return friend;
            }
            result.close();
            return null;
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
            return null;
        }
    }

    public Friend updateEntry(Database database, Object data) {
        Friend friend = (Friend) data;
        ContentValues cv = new ContentValues();
        cv.put("facebook_id", friend.getFacebookId());
        cv.put(FACEBOOK_NAME, friend.getFullName());
        cv.put(SOUNDBOARD_ID, friend.getSoundBoardId());
        try {
            database.getDatabase().update("friends", cv, "facebook_id=?", new String[]{String.valueOf(friend.getFacebookId())});
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
        return friend;
    }

    public int updateEntryWhere(Database database, ContentValues cv, String whereClause, String[] whereArgs) {
        try {
            return database.getDatabase().update("friends", cv, whereClause, whereArgs);
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
            return 0;
        }
    }

    public String getIdField() {
        return "_id";
    }

    public List<Friend> getFriends(Database database) {
        List<Friend> photos = new ArrayList();
        try {
            Cursor result = database.getDatabase().query("friends", getProjection(), null, null, null, null, null);
            if (result.moveToFirst()) {
                while (!result.isAfterLast()) {
                    photos.add(fillFriend(result));
                    result.moveToNext();
                }
                result.close();
            } else {
                result.close();
            }
        } catch (SQLiteException e) {
            Logger.error((Object) this, e.getMessage());
        }
        return photos;
    }

    public static Friend fillFriend(Cursor result) {
        Friend friend = new Friend();
        friend.setFacebookId(result.getString(1));
        friend.setFullName(result.getString(2));
        friend.setSoundBoardId(result.getString(3));
        return friend;
    }
}
