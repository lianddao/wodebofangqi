package com.songbirdnest.facebook.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.songbirdnest.database.friends.FriendDatabaseHelper;
import com.songbirdnest.database.friends.Photo;
import com.songbirdnest.util.Logger;
import java.io.File;
import java.io.FileInputStream;

public abstract class FaceDownload implements Runnable {
    public static final String PHOTOS_CACHE = "photos/cache";
    protected Context mContext;
    int mTargetSize;
    String mTargetURL;

    public abstract void onPostExecute(Bitmap bitmap);

    public FaceDownload(Context context, String pTarget, int pTargetSize) {
        this.mContext = context;
        this.mTargetURL = pTarget;
        this.mTargetSize = pTargetSize;
    }

    public void run() {
        Bitmap aBitmap = null;
        FriendDatabaseHelper friendDatabaseHelper = FriendDatabaseHelper.getFriendDatabaseHelper(this.mContext);
        try {
            if (this.mTargetURL != null) {
                Photo photo = friendDatabaseHelper.getPhoto(this.mTargetURL);
                File photoPath = null;
                if (!(photo == null || photo.getLocalPath() == null)) {
                    photoPath = new File(photo.getLocalPath());
                    if (!photoPath.exists()) {
                        photoPath = null;
                    }
                }
                if (photoPath != null) {
                    aBitmap = BitmapFactory.decodeStream(new FileInputStream(photoPath));
                    photo.setLastAccessed(System.currentTimeMillis());
                    friendDatabaseHelper.updatePhoto(photo);
                } else {
                    aBitmap = FacebookUtils.downloadBitmap(this.mContext, this.mTargetURL, this.mTargetSize);
                    if (aBitmap != null) {
                        friendDatabaseHelper.addNewFacebookPhoto(this.mTargetURL);
                        FacebookUtils.saveFacebookFile(this.mContext, this.mTargetURL, aBitmap);
                    }
                }
                friendDatabaseHelper.close();
                if (aBitmap != null) {
                    onPostExecute(aBitmap);
                }
            }
        } catch (Exception e) {
            Logger.error(this, "Problems Downloading Facebook Image " + this.mTargetURL, e);
        } finally {
            friendDatabaseHelper.close();
        }
    }
}
