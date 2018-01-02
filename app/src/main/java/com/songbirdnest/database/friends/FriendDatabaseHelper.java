package com.songbirdnest.database.friends;

import android.content.ContentValues;
import android.content.Context;
import com.songbirdnest.database.BaseDatabaseHelper;
import com.songbirdnest.facebook.util.FacebookUtils;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.soundboard.data.Friend;
import com.songbirdnest.util.Logger;
import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.TreeMap;

public class FriendDatabaseHelper extends BaseDatabaseHelper {
    protected static String DATABASE = "friends.db";
    private static final int MAX_IMAGE_FILES = 500;
    public static final String PHOTOS_CACHE = "photos/cache";
    protected static FriendDatabaseHelper singleton = null;
    protected static final int version = 3;
    private FriendTable friendTable;
    private PhotoTable photoTable;
    protected boolean removeStarted = false;

    public static FriendDatabaseHelper getFriendDatabaseHelper(Context context) {
        if (singleton == null) {
            singleton = new FriendDatabaseHelper(context);
        }
        return singleton;
    }

    private FriendDatabaseHelper(Context context) {
        super(context, DATABASE, PhotoTable.TABLE_NAME, 3);
    }

    protected void createLocalDB() {
        this.localDatabase = new FriendDatabase(this.sqLiteDatabase);
        this.photoTable = (PhotoTable) this.localDatabase.getTable(PhotoTable.TABLE_NAME);
        this.friendTable = (FriendTable) this.localDatabase.getTable("friends");
    }

    public synchronized Photo addPhoto(Photo photo) {
        open();
        return (Photo) this.localDatabase.insertTableEntry(this.photoTable, photo);
    }

    public synchronized void deletePhoto(Photo photo) {
        open();
        this.photoTable.deleteEntry(this.localDatabase, photo);
    }

    public synchronized void deletePhotoWhere(String whereClause, String[] whereArgs) {
        open();
        this.photoTable.deleteEntryWhere(this.localDatabase, whereClause, whereArgs);
    }

    public synchronized Photo updatePhoto(Photo photo) {
        open();
        return this.photoTable.updatePhoto(this.localDatabase, photo);
    }

    public int updatePhotoWhere(ContentValues cv, String whereClause, String[] whereArgs) {
        open();
        return this.photoTable.updateEntryWhere(this.localDatabase, cv, whereClause, whereArgs);
    }

    public synchronized Photo getPhoto(String facebookId) {
        Photo photo;
        open();
        if (this.photoTable == null) {
            Logger.error((Object) this, "getPhoto. Table is null");
            photo = null;
        } else {
            photo = this.photoTable.getEntry(this.localDatabase, (Object) facebookId);
        }
        return photo;
    }

    public synchronized List<Photo> getPhotos() {
        open();
        return this.photoTable.getPhotos(this.localDatabase);
    }

    public Photo addNewFacebookPhoto(String facebookId, File cacheFile, String facebookURL) {
        Photo photo = new Photo();
        photo.setFacebookId(facebookId);
        photo.setFacebookURL(facebookURL);
        photo.setLastAccessed(System.currentTimeMillis());
        photo.setLocalPath(cacheFile.getAbsolutePath());
        addPhoto(photo);
        return photo;
    }

    public Photo addNewFacebookPhoto(String facebookId) {
        File cacheFile = FacebookUtils.getFacebookCacheFile(this.context, facebookId);
        if (cacheFile == null) {
            return null;
        }
        return addNewFacebookPhoto(facebookId, cacheFile, this.context.getString(C0116R.string.facebook_photo_url, new Object[]{facebookId}));
    }

    public Photo updateFacebookPhotoFile(String facebookId) {
        Photo photo = getPhoto(facebookId);
        if (photo == null) {
            Logger.error((Object) this, "Could not find photo for id " + facebookId);
            return null;
        }
        File cacheFile = FacebookUtils.getFacebookCacheFile(this.context, facebookId);
        if (cacheFile == null) {
            return photo;
        }
        photo.setFacebookURL(this.context.getString(C0116R.string.facebook_photo_url, new Object[]{facebookId}));
        photo.setLastAccessed(System.currentTimeMillis());
        photo.setLocalPath(cacheFile.getAbsolutePath());
        updatePhoto(photo);
        return photo;
    }

    public synchronized List<Friend> getFriends() {
        open();
        return this.friendTable.getFriends(this.localDatabase);
    }

    public synchronized void deleteFriends() {
        open();
        this.friendTable.deleteAllEntries(this.localDatabase);
    }

    public synchronized List<Friend> addFriends(List<Friend> friends) {
        open();
        return this.friendTable.insertFriends(this.localDatabase, friends);
    }

    public void checkImageCapacity() {
        File cacheDir_ = new File(this.context.getFilesDir(), "photos/cache");
        if (cacheDir_.exists() && cacheDir_.listFiles() != null && !this.removeStarted) {
            this.removeStarted = true;
            removeOldImages();
        }
    }

    private void removeOldImages() {
        File cacheDir_ = new File(this.context.getFilesDir(), "photos/cache");
        if (cacheDir_.exists()) {
            Photo photo;
            int numFilesToDelete = Math.max(cacheDir_.listFiles().length - 500, 0);
            int deletedFileCount = 0;
            TreeMap<Long, Photo> lastAccessedList = new TreeMap();
            for (Photo photo2 : getPhotos()) {
                lastAccessedList.put(Long.valueOf(photo2.getLastAccessed()), photo2);
            }
            Calendar todayCal = Calendar.getInstance();
            todayCal.clear(10);
            todayCal.clear(12);
            todayCal.clear(13);
            todayCal.clear(14);
            Calendar photoCal = Calendar.getInstance();
            boolean firstTime = true;
            while (true) {
                if (firstTime || numFilesToDelete - deletedFileCount > 0) {
                    firstTime = false;
                    for (Long next : lastAccessedList.keySet()) {
                        photo2 = (Photo) lastAccessedList.get(next);
                        String localPath = photo2.getLocalPath();
                        if (!(localPath == null || localPath.length() == 0)) {
                            photoCal.setTimeInMillis(next.longValue());
                            photoCal.clear(10);
                            photoCal.clear(12);
                            photoCal.clear(13);
                            photoCal.clear(14);
                            if (!photoCal.equals(todayCal)) {
                                File photoFile = new File(localPath);
                                if (photoFile.exists()) {
                                    boolean deleted = photoFile.delete();
                                    if (numFilesToDelete > 0) {
                                        deletedFileCount++;
                                    }
                                }
                                photo2.setLocalPath(null);
                                updatePhoto(photo2);
                            }
                        }
                    }
                    if (deletedFileCount != numFilesToDelete) {
                        numFilesToDelete = Math.max(cacheDir_.listFiles().length - 500, 0);
                    }
                } else {
                    this.removeStarted = false;
                    return;
                }
            }
        }
    }
}
