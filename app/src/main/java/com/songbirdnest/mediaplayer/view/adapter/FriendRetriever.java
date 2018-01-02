package com.songbirdnest.mediaplayer.view.adapter;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import com.songbirdnest.database.friends.FriendDatabaseHelper;
import com.songbirdnest.database.friends.Photo;
import com.songbirdnest.facebook.FacebookAPI;
import com.songbirdnest.facebook.util.FacebookUtils;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.soundboard.SoundboardListener;
import com.songbirdnest.soundboard.SoundboardServer;
import com.songbirdnest.soundboard.data.Friend;
import com.songbirdnest.stream.StreamException;
import com.songbirdnest.util.Logger;
import com.songbirdnest.util.media.BitmapDownloader;
import com.songbirdnest.util.media.BitmapLoadInfo;
import com.songbirdnest.util.media.ImagePostProcessor;
import com.songbirdnest.util.media.ImageReady;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FriendRetriever {
    public static final int NUM_THREADS = 4;
    private BitmapDownloadProcessor bitmapDownloadProcessor;
    private BitmapDownloader bitmapDownloader;
    protected FriendRetrieverCallback callback;
    private Friend currentUser;
    private boolean errorOccurred = false;
    protected List<Friend> friendList;
    private Map<String, Photo> friendPhotoMap = new HashMap();
    protected Activity mActivity;
    private ExecutorService mDownloadExecutator;
    protected int mTargetSize;
    private ExecutorService mUpdateDBExecutator;
    protected boolean started = false;

    class C04291 extends AsyncTask<Void, Void, Void> {
        C04291() {
        }

        protected Void doInBackground(Void... params) {
            new FriendsRunnable().run();
            return null;
        }
    }

    class BitmapDownloadProcessor implements ImagePostProcessor, ImageReady {
        BitmapDownloadProcessor() {
        }

        public Bitmap postProcess(Bitmap bitmap) {
            return bitmap;
        }

        public void ready(String id, Bitmap bitmap) {
            if (!FriendRetriever.this.started) {
                Logger.error((Object) this, "FriendRetriever:BitmapDownloadProcessor. Canceling because we are shutdown");
            } else if (bitmap != null) {
                FriendRetriever.this.callback.setFriendImage(id, bitmap);
                if (FriendRetriever.this.mUpdateDBExecutator != null) {
                    FriendRetriever.this.mUpdateDBExecutator.execute(new FriendDBUpdater(id));
                }
            }
        }

        public void error(String id, Exception e) {
            if (e != null) {
                FriendRetriever.this.callback.onError(id, e.getMessage());
            } else {
                FriendRetriever.this.callback.onError(id, null);
            }
        }
    }

    static class FriendComparator implements Comparator<Friend> {
        FriendComparator() {
        }

        public int compare(Friend lhs, Friend rhs) {
            return lhs.getFullName().compareTo(rhs.getFullName());
        }
    }

    class FriendDBUpdater implements Runnable {
        String id;

        FriendDBUpdater(String id) {
            this.id = id;
        }

        public void run() {
            if (FriendRetriever.this.started) {
                Photo photo = (Photo) FriendRetriever.this.friendPhotoMap.get(this.id);
                FriendDatabaseHelper friendDatabaseHelper = FriendDatabaseHelper.getFriendDatabaseHelper(FriendRetriever.this.mActivity);
                if (photo == null) {
                    FriendRetriever.this.friendPhotoMap.put(this.id, friendDatabaseHelper.addNewFacebookPhoto(this.id));
                } else if (photo.getLocalPath() == null) {
                    FriendRetriever.this.friendPhotoMap.put(this.id, friendDatabaseHelper.updateFacebookPhotoFile(this.id));
                }
                friendDatabaseHelper.close();
                return;
            }
            Logger.error((Object) this, "FriendRetriever:FriendDBUpdater. Canceling because we are shutdown");
        }
    }

    class FriendsRunnable implements Runnable {

        class C04321 implements SoundboardListener<List<Friend>> {

            class C04311 implements Runnable {

                class C04301 implements OnClickListener {
                    C04301() {
                    }

                    public void onClick(DialogInterface dialog, int which) {
                        FriendRetriever.this.mActivity.finish();
                    }
                }

                C04311() {
                }

                public void run() {
                    new Builder(FriendRetriever.this.mActivity).setMessage(C0116R.string.soundboard_version_error).setPositiveButton(FriendRetriever.this.mActivity.getString(C0116R.string.ok), new C04301()).show();
                }
            }

            C04321() {
            }

            public void onSuccess(List<Friend> friends) {
                Collections.sort(friends, new FriendComparator());
                if (FriendRetriever.this.currentUser != null) {
                    FriendRetriever.this.currentUser.setSoundBoardId(SoundboardServer.get().getCurrentSoundBoardId());
                    friends.add(0, FriendRetriever.this.currentUser);
                } else {
                    Logger.error((Object) this, "FriendRetriever: CurrentUser is null");
                }
                FriendRetriever.this.friendList = friends;
                FriendRetriever.this.buildFriendPhotoList();
                FriendRetriever.this.saveFriendsToDb();
                FriendRetriever.this.callback.setFriends(friends);
            }

            public void onFailure(String message, StreamException exception) {
                Logger.error((Object) this, "getFriends failed. Message: " + (exception != null ? exception.getResponseMessage() : " "));
                FriendRetriever.this.errorOccurred = true;
                if (exception != null && exception.getResponseCode() == 404) {
                    FacebookAPI.get().clearFacebookData();
                    SoundboardServer.get().clearSessionData();
                } else if (exception != null && exception.getResponseCode() == 401) {
                    FacebookAPI.get().clearFacebookData();
                    SoundboardServer.get().clearSessionData();
                } else if (exception != null && exception.getResponseCode() == 403) {
                    FriendRetriever.this.mActivity.runOnUiThread(new C04311());
                }
                if (FriendRetriever.this.callback != null) {
                    FriendRetriever.this.callback.onError(null, message);
                }
            }
        }

        FriendsRunnable() {
        }

        public void run() {
            if (!FriendRetriever.this.errorOccurred) {
                FriendRetriever.this.loadFriendsFromDb();
                SoundboardServer.get().getFriends(new C04321(), SoundboardServer.get().getCurrentSoundBoardId());
            }
        }
    }

    public FriendRetriever(Activity mActivity, int mTargetSize, FriendRetrieverCallback callback) {
        this.callback = callback;
        this.mTargetSize = mTargetSize;
        this.mActivity = mActivity;
        this.bitmapDownloadProcessor = new BitmapDownloadProcessor();
    }

    public boolean isStarted() {
        return this.started;
    }

    public void start() {
        this.errorOccurred = false;
        if (this.mDownloadExecutator == null) {
            this.mDownloadExecutator = Executors.newFixedThreadPool(4);
            this.mUpdateDBExecutator = Executors.newFixedThreadPool(4);
            this.bitmapDownloader = new BitmapDownloader(this.mDownloadExecutator);
        }
        this.started = true;
    }

    public void reset() {
        this.started = false;
    }

    public void stop() {
        if (this.mDownloadExecutator != null && !this.mDownloadExecutator.isTerminated()) {
            this.mDownloadExecutator.shutdownNow();
            this.mDownloadExecutator = null;
            this.mUpdateDBExecutator.shutdownNow();
            this.mUpdateDBExecutator = null;
        }
    }

    public Bitmap getFacebookFileImage(Friend friend) {
        File cacheFile = FacebookUtils.getFacebookCacheFile(this.mActivity, friend.getFacebookId());
        if (cacheFile != null && cacheFile.exists()) {
            try {
                return BitmapFactory.decodeStream(new FileInputStream(cacheFile));
            } catch (FileNotFoundException e) {
                Logger.error(this, "Problems getting Facebook Image " + friend.getFacebookId(), e);
            }
        }
        return null;
    }

    public boolean facebookImageFileExists(Friend friend) {
        File cacheFile = FacebookUtils.getFacebookCacheFile(this.mActivity, friend.getFacebookId());
        if (cacheFile != null) {
            return cacheFile.exists();
        }
        return false;
    }

    public boolean facebookImageFileExists(String facebookId) {
        for (Friend friend : this.friendList) {
            if (friend.getFacebookId().equalsIgnoreCase(facebookId)) {
                return facebookImageFileExists(friend);
            }
        }
        return false;
    }

    public void downloadFacebookImage(Friend friend) {
        if (this.started) {
            BitmapLoadInfo bitmapLoadInfo = new BitmapLoadInfo();
            bitmapLoadInfo.url = this.mActivity.getString(C0116R.string.facebook_photo_url, new Object[]{friend.getFacebookId()});
            bitmapLoadInfo.id = friend.getFacebookId();
            bitmapLoadInfo.imageReadyListener = this.bitmapDownloadProcessor;
            File cacheFile = FacebookUtils.getFacebookCacheFile(this.mActivity, friend.getFacebookId());
            if (cacheFile != null) {
                bitmapLoadInfo.filePath = cacheFile.getAbsolutePath();
            }
            this.bitmapDownloader.startDownload(bitmapLoadInfo);
        }
    }

    public void setCurrentUser(Friend pCurrentUser) {
        this.currentUser = pCurrentUser;
    }

    public void setErrorOccured(boolean pError) {
        this.errorOccurred = pError;
    }

    public void startFriendRequest() {
        new C04291().execute(new Void[]{(Void) null});
    }

    public void updateCallback(FriendRetrieverCallback pCallback) {
        this.callback = pCallback;
        if (this.friendList != null) {
            this.callback.setFriends(this.friendList);
        }
    }

    private void loadFriendsFromDb() {
        FriendDatabaseHelper friendDatabaseHelper = FriendDatabaseHelper.getFriendDatabaseHelper(this.mActivity);
        List<Friend> friends = friendDatabaseHelper.getFriends();
        friendDatabaseHelper.close();
        if (friends != null && friends.size() > 0) {
            this.friendList = friends;
            this.callback.setFriends(friends);
        }
    }

    private void saveFriendsToDb() {
        FriendDatabaseHelper friendDatabaseHelper = FriendDatabaseHelper.getFriendDatabaseHelper(this.mActivity);
        friendDatabaseHelper.deleteFriends();
        friendDatabaseHelper.addFriends(this.friendList);
        friendDatabaseHelper.close();
    }

    private void buildFriendPhotoList() {
        this.friendPhotoMap.clear();
        FriendDatabaseHelper friendDatabaseHelper = FriendDatabaseHelper.getFriendDatabaseHelper(this.mActivity);
        for (Friend friend : this.friendList) {
            this.friendPhotoMap.put(friend.getFacebookId(), friendDatabaseHelper.getPhoto(friend.getFacebookId()));
        }
        friendDatabaseHelper.close();
    }
}
