package com.songbirdnest.soundboard;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.android.Facebook.ServiceListener;
import com.facebook.android.FacebookError;
import com.songbirdnest.database.cookies.CookieDatabaseHelper;
import com.songbirdnest.facebook.FacebookAPI;
import com.songbirdnest.facebook.FacebookUser;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.PrefKeys;
import com.songbirdnest.mediaplayer.SongbirdApplication;
import com.songbirdnest.mediaplayer.SongbirdApplication.BUILD_TYPE;
import com.songbirdnest.soundboard.data.AppDetails;
import com.songbirdnest.soundboard.data.ArtistInfo;
import com.songbirdnest.soundboard.data.Collection;
import com.songbirdnest.soundboard.data.Friend;
import com.songbirdnest.soundboard.data.UserFeed;
import com.songbirdnest.soundboard.task.BulkFollowArtists;
import com.songbirdnest.soundboard.task.Collections;
import com.songbirdnest.soundboard.task.FollowArtist;
import com.songbirdnest.soundboard.task.Friends;
import com.songbirdnest.soundboard.task.LikeFeedItem;
import com.songbirdnest.soundboard.task.LikedDownload;
import com.songbirdnest.soundboard.task.RegisterDevice;
import com.songbirdnest.soundboard.task.RetrieveAppDetails;
import com.songbirdnest.soundboard.task.RetrieveArtistFeed;
import com.songbirdnest.soundboard.task.RetrieveArtistId;
import com.songbirdnest.soundboard.task.RetrieveArtistInfo;
import com.songbirdnest.soundboard.task.RetrieveUserFeed;
import com.songbirdnest.soundboard.task.SoundBoardId;
import com.songbirdnest.soundboard.task.UnFollowArtist;
import com.songbirdnest.soundboard.task.UnRegisterDevice;
import com.songbirdnest.soundboard.task.UnlikeFeedItem;
import com.songbirdnest.soundboard.task.UpdateSoundboardUser;
import com.songbirdnest.stream.StreamException;
import com.songbirdnest.util.Logger;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.client.CookieStore;

public class SoundboardServer {
    public static final String SOUND_BOARD_VERSION = "v1";
    private static int TWENTY_FOUR_HOURS = 86400000;
    protected static final String URL_SERVER = "soundboard.urlserver";
    protected static final String mConfiguredServer = "soundboard.server";
    private static final SoundboardServer soundBoardServer = new SoundboardServer();
    private CookieStore cookieStore;
    private boolean initialized = false;
    private Context mContext = null;
    private final ExecutorService mExecutor = Executors.newSingleThreadExecutor();
    protected long mLastFeedAction = 0;
    private final ReentrantLock mLock = new ReentrantLock();
    protected String mSoundboardServer = "";
    protected String mURLServer = "";
    private boolean retrievingAppDetails = false;
    private boolean retrievingSoundboardId = false;
    private boolean showDebugMsgs = false;
    private SoundBoardPrefs soundBoardPrefs;

    class C04581 implements SoundboardListener<AppDetails> {
        C04581() {
        }

        public void onSuccess(AppDetails appDetails) {
            SoundboardServer.this.retrievingAppDetails = false;
            if (appDetails != null) {
                String app_id = appDetails.appId;
                if (app_id == null || app_id.length() <= 0) {
                    Logger.error((Object) this, "No app ID received from server");
                } else {
                    if (!(SoundboardServer.this.soundBoardPrefs.getSoundBoardAppKey() == null || app_id.equalsIgnoreCase(SoundboardServer.this.soundBoardPrefs.getSoundBoardAppKey()))) {
                        SoundboardServer.this.clearPreferences();
                    }
                    SoundboardServer.this.saveAppId(app_id);
                }
                String permissions = appDetails.permissions;
                if (permissions == null || permissions.length() <= 0) {
                    Logger.error((Object) this, "No permissions received from server");
                } else {
                    SoundboardServer.this.savePermissions(permissions);
                }
                SoundboardServer.this.retrieveCookieStore();
            }
        }

        public void onFailure(String message, StreamException exception) {
            SoundboardServer.this.retrievingAppDetails = false;
            Logger.error((Object) this, "retrieveAppDetails:onFailure");
        }
    }

    class C04603 implements SoundboardListener<String> {
        C04603() {
        }

        public void onSuccess(String id) {
            SoundboardServer.this.retrievingSoundboardId = false;
            if (id != null && id.length() > 0) {
                SoundboardServer.this.saveSoundboardId(id);
            }
        }

        public void onFailure(String message, StreamException exception) {
            Logger.error(this, "createSoundboardUser: onFailure", exception);
            SoundboardServer.this.retrievingSoundboardId = false;
        }
    }

    class C04614 implements SoundboardListener<String> {
        C04614() {
        }

        public void onSuccess(String id) {
            if (id != null && id.length() > 0) {
                SoundboardServer.this.saveSoundboardId(id);
            }
        }

        public void onFailure(String message, StreamException exception) {
            Logger.error(this, "updateSoundboardUser: Problems updating Soundboard User: " + message, exception);
        }
    }

    class C04625 implements ServiceListener {
        C04625() {
        }

        public void onComplete(Bundle values) {
            SoundboardServer.this.soundBoardPrefs.setAccessToken(FacebookAPI.get().getAccess());
            SoundboardServer.this.updateSoundboardUser();
        }

        public void onFacebookError(FacebookError e) {
            Logger.error(this, "reauthorizeSoundboard:onFacebookError", e);
        }

        public void onError(Error e) {
            Logger.error(this, "reauthorizeSoundboard:onError", e);
        }
    }

    public static SoundboardServer get() {
        return soundBoardServer;
    }

    public String getServer() {
        if (!this.mSoundboardServer.equals("")) {
            return this.mSoundboardServer;
        }
        int aTarget = C0116R.string.soundboard_server;
        SharedPreferences mPref = this.mContext.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0);
        if (((SongbirdApplication) this.mContext.getApplicationContext()).getBuildType().equals(SongbirdApplication.QA_BUILD)) {
            aTarget = C0116R.string.soundboard_stagging;
        }
        this.mSoundboardServer = mPref.getString(mConfiguredServer, this.mContext.getResources().getString(aTarget));
        return this.mSoundboardServer;
    }

    public String getURLServer() {
        if (!this.mURLServer.equals("")) {
            return this.mURLServer;
        }
        int aTarget = C0116R.string.soundboard_link;
        SharedPreferences mPref = this.mContext.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0);
        if (((SongbirdApplication) this.mContext.getApplicationContext()).getBuildType().equals(SongbirdApplication.QA_BUILD)) {
            aTarget = C0116R.string.soundboard_link_staging;
        }
        this.mURLServer = mPref.getString(URL_SERVER, this.mContext.getResources().getString(aTarget));
        return this.mURLServer;
    }

    private SoundboardServer() {
    }

    public void init(Context aContext) {
        if (this.initialized) {
            Logger.error((Object) this, "Already Initialized");
            return;
        }
        this.initialized = true;
        if (this.mContext == null) {
            this.mContext = aContext.getApplicationContext();
        }
        SongbirdApplication app = this.mContext;
        if (app.getAppBuildType() == BUILD_TYPE.QA) {
            this.showDebugMsgs = true;
        }
        this.soundBoardPrefs = app.getSoundBoardPrefs();
        if (this.soundBoardPrefs.getSoundBoardAppKey() == null && FacebookAPI.get().getAccess() != null) {
            FacebookAPI.get().logout();
            FacebookAPI.get().clearFacebookData();
        }
        forceAppDetails(null);
        retrieveCookieStore();
    }

    public Context getContext() {
        return this.mContext;
    }

    public CookieStore getCookieStore() {
        return this.cookieStore;
    }

    public void setCookieStore(CookieStore cookieStore) {
        this.cookieStore = cookieStore;
    }

    protected void retrieveCookieStore() {
        CookieDatabaseHelper cookieDatabaseHelper = CookieDatabaseHelper.getInstance(this.mContext);
        this.cookieStore = cookieDatabaseHelper.getCookieStore();
        cookieDatabaseHelper.close();
    }

    protected void deleteCookieStore() {
        CookieDatabaseHelper cookieDatabaseHelper = CookieDatabaseHelper.getInstance(this.mContext);
        cookieDatabaseHelper.deleteAllCookies();
        cookieDatabaseHelper.close();
        if (this.cookieStore != null) {
            this.cookieStore.clear();
        }
    }

    private boolean isAppDetailsValid() {
        return this.soundBoardPrefs.isAppDetailsValid();
    }

    private RetrieveAppDetails getAppDetails() {
        if (this.retrievingAppDetails) {
            return null;
        }
        this.retrievingAppDetails = true;
        return new RetrieveAppDetails(this, new C04581());
    }

    public void setUser(String aID, String aName, String email) {
        boolean soundboardUserNeedsUpdate = false;
        String facebookToken = FacebookAPI.get().getAccess();
        String currentToken = this.soundBoardPrefs.getAccessToken();
        if (currentToken == null) {
            soundboardUserNeedsUpdate = true;
        }
        if (facebookToken == null || !(currentToken == null || facebookToken.equals(currentToken))) {
            soundboardUserNeedsUpdate = true;
        }
        this.soundBoardPrefs.setUserId(aID);
        this.soundBoardPrefs.setUserName(aName);
        this.soundBoardPrefs.setUserEmail(email);
        this.soundBoardPrefs.setAccessToken(FacebookAPI.get().getAccess());
        this.soundBoardPrefs.setExpiration(FacebookAPI.get().getAccessExpires());
        this.soundBoardPrefs.writePrefs();
        if (this.soundBoardPrefs.getCurrentUserSoundBoardId() == null) {
            createSoundboardUser();
        } else if (soundboardUserNeedsUpdate) {
            createSoundboardUser();
        }
    }

    public void setUser(String aID, String aName, String email, final SoundboardListener<String> listener) {
        boolean soundboardUserNeedsUpdate = false;
        String facebookToken = FacebookAPI.get().getAccess();
        String currentToken = this.soundBoardPrefs.getFacebookUser().getAccessToken();
        if (currentToken == null) {
            soundboardUserNeedsUpdate = true;
        }
        if (facebookToken == null || !(currentToken == null || facebookToken.equals(currentToken))) {
            soundboardUserNeedsUpdate = true;
        }
        this.soundBoardPrefs.setUserId(aID);
        this.soundBoardPrefs.setUserName(aName);
        this.soundBoardPrefs.setUserEmail(email);
        this.soundBoardPrefs.setAccessToken(FacebookAPI.get().getAccess());
        this.soundBoardPrefs.setExpiration(FacebookAPI.get().getAccessExpires());
        this.soundBoardPrefs.writePrefs();
        if (this.soundBoardPrefs.getCurrentUserSoundBoardId() == null || soundboardUserNeedsUpdate) {
            executeTask(new CreateSoundboardUser(this, new SoundboardListener<String>() {
                public void onSuccess(String id) {
                    if (id != null && id.length() > 0) {
                        SoundboardServer.this.saveSoundboardId(id);
                    }
                    if (listener != null) {
                        listener.onSuccess(id);
                    }
                }

                public void onFailure(String message, StreamException exception) {
                    Logger.error(this, "setUser: onFailure", exception);
                    if (listener != null) {
                        listener.onFailure(message, exception);
                    }
                }
            }, this.soundBoardPrefs.getFacebookUser()));
        }
    }

    private void createSoundboardUser() {
        if (!this.retrievingSoundboardId) {
            this.retrievingSoundboardId = true;
            createNewUser(new C04603(), this.soundBoardPrefs.getFacebookUser());
        }
    }

    private void updateSoundboardUser() {
        updateUser(new C04614(), this.soundBoardPrefs.getFacebookUser());
    }

    public void reauthorizeSoundboard() {
        FacebookAPI.get().updateAccessToken(new C04625());
    }

    public String getCurrentSoundBoardId() {
        return this.soundBoardPrefs.getCurrentUserSoundBoardId();
    }

    private void saveAppId(String app_id) {
        this.soundBoardPrefs.setSoundBoardAppKey(app_id);
        this.soundBoardPrefs.writePrefs();
        FacebookAPI.get().setApplicationKey(app_id);
    }

    private void saveSoundboardId(String id) {
        this.soundBoardPrefs.setCurrentUserSoundBoardId(id);
        this.soundBoardPrefs.writePrefs();
    }

    private void savePermissions(String permissions) {
        String soundBoardPermissions = permissions;
        Set<String> permissionSet = new TreeSet();
        for (String currentFacebookPermission : FacebookAPI.getsPermissions()) {
            permissionSet.add(currentFacebookPermission);
        }
        if (soundBoardPermissions != null && soundBoardPermissions.length() > 0) {
            for (String sbPermission : soundBoardPermissions.split(",")) {
                permissionSet.add(sbPermission);
            }
        }
        String[] soundBoardPermissionsArray = (String[]) permissionSet.toArray(new String[permissionSet.size()]);
        StringBuilder builder = new StringBuilder();
        for (String item : permissionSet) {
            builder.append(item).append(",");
        }
        builder.setLength(builder.length() - 1);
        soundBoardPermissions = builder.toString();
        if (soundBoardPermissions == null || soundBoardPermissions.length() <= 0) {
            Logger.error((Object) this, "Soundboard Permissions are missing");
        } else {
            FacebookAPI.setPermissions(soundBoardPermissions);
        }
        this.soundBoardPrefs.setSoundBoardPermissions(soundBoardPermissions);
        this.soundBoardPrefs.setSoundBoardPermissionsArray(soundBoardPermissionsArray);
        this.soundBoardPrefs.writePrefs();
    }

    public void clearSessionData() {
        clearPreferences();
        deleteCookieStore();
    }

    private void clearPreferences() {
        this.soundBoardPrefs.setSoundBoardAppKey(null);
        this.soundBoardPrefs.setCurrentUserSoundBoardId(null);
        this.soundBoardPrefs.setSoundBoardPermissions(null);
        this.soundBoardPrefs.setSoundBoardPermissionsArray(null);
        this.soundBoardPrefs.writePrefs();
    }

    public void shutdown() {
        if (!this.mExecutor.isShutdown() && this.mExecutor.isTerminated()) {
            try {
                this.mLock.unlock();
            } catch (IllegalMonitorStateException e) {
            }
            this.mExecutor.shutdown();
        }
    }

    public void retrieveSoundboardId(SoundboardListener<String> listener, String facebookId) {
        executeTask(new SoundBoardId(this, listener, facebookId));
    }

    public void createNewUser(SoundboardListener<String> listener, FacebookUser facebookUser) {
        executeTask(new CreateSoundboardUser(this, listener, facebookUser));
    }

    public void updateUser(SoundboardListener<String> listener, FacebookUser facebookUser) {
        executeTask(new UpdateSoundboardUser(this, listener, facebookUser));
    }

    public void getFriends(SoundboardListener<List<Friend>> listener, String soundBoardId) {
        if (this.soundBoardPrefs.getCurrentUserSoundBoardId() == null && this.soundBoardPrefs.getFacebookUser() != null && this.soundBoardPrefs.getUserId() != null) {
            createSoundboardUser();
        } else if (this.soundBoardPrefs.getFacebookUser() == null) {
            Logger.error((Object) this, "getFriends: Facebook User not set");
            return;
        }
        executeTask(new Friends(this, listener, soundBoardId));
    }

    public void getCollections(SoundboardListener<List<Collection>> listener, String soundBoardId) {
        executeTask(new Collections(this, listener, soundBoardId));
    }

    public void getArtistFeed(SoundboardListener<UserFeed> listener, String pArtistID) {
        executeTask(new RetrieveArtistFeed(this, listener, pArtistID));
    }

    public void forceAppDetails(Runnable pRunnable) {
        executeTask(pRunnable);
    }

    public void getArtistInfo(SoundboardListener<ArtistInfo> listener, String pArtistID) {
        executeTask(new RetrieveArtistInfo(this, listener, pArtistID));
    }

    public void searchArtists(SoundboardListener<ArtistInfo> listener, String pArtistName) {
        if (pArtistName.equals("<unknown>")) {
            listener.onSuccess(null);
        }
        executeTask(new RetrieveArtistId(this, listener, pArtistName));
    }

    public void getLiked(SoundboardListener<List<Collection>> pListener, String pFacebookId) {
        executeTask(new LikedDownload(this, pListener, getCurrentSoundBoardId(), pFacebookId));
    }

    public void getUserFeed(SoundboardListener<UserFeed> pListener, String pSoundboardID, int pOffset, int pLimit) {
        if (pSoundboardID == null && this.soundBoardPrefs.getCurrentUserSoundBoardId() == null && this.soundBoardPrefs.getFacebookUser() != null && this.soundBoardPrefs.getUserId() != null) {
            createSoundboardUser();
        } else if (this.soundBoardPrefs.getFacebookUser() == null) {
            Logger.error((Object) this, "getFriends: Facebook User not set");
            return;
        }
        executeTask(new RetrieveUserFeed(this, pListener, pSoundboardID, pOffset, pLimit));
    }

    public void getUserFeed(SoundboardListener<UserFeed> pListener, String pSoundboardID, int pOffset) {
        getUserFeed(pListener, pSoundboardID, pOffset, 50);
    }

    public void followArtist(String artistId, SoundboardListener<String> pListener) {
        this.mLastFeedAction = System.currentTimeMillis();
        executeTask(new FollowArtist(this, getCurrentSoundBoardId(), artistId, pListener));
    }

    public void unFollowArtist(String artistId, SoundboardListener<String> pListener) {
        this.mLastFeedAction = System.currentTimeMillis();
        executeTask(new UnFollowArtist(this, getCurrentSoundBoardId(), artistId, pListener));
    }

    public long lastFeedAction() {
        return this.mLastFeedAction;
    }

    public void bulkFollowArtist(List<String> artistIds, SoundboardListener<List<String>> pListener) {
        executeTask(new BulkFollowArtists(this, getCurrentSoundBoardId(), artistIds, pListener));
    }

    public void likeFeedItem(String pFeedID, SoundboardListener<String> pListener) {
        this.mLastFeedAction = System.currentTimeMillis();
        executeTask(new LikeFeedItem(this, pFeedID, getCurrentSoundBoardId(), pListener));
    }

    public void unlikeFeedItem(String pFeedID, SoundboardListener<String> pListener) {
        this.mLastFeedAction = System.currentTimeMillis();
        executeTask(new UnlikeFeedItem(this, pFeedID, getCurrentSoundBoardId(), pListener));
    }

    public void registerDevice(String regId, SoundboardListener<String> pListener) {
        executeTask(new RegisterDevice(this, getCurrentSoundBoardId(), regId, pListener));
    }

    public void unRegisterDevice(String regId, SoundboardListener<String> pListener) {
        executeTask(new UnRegisterDevice(this, getCurrentSoundBoardId(), regId, pListener));
    }

    private boolean executeTask(Runnable aRunnable) {
        if (this.showDebugMsgs && aRunnable != null) {
            Logger.debug(this, "calling " + aRunnable.getClass().getSimpleName());
        }
        this.mLock.lock();
        try {
            if (this.mExecutor.isShutdown() || this.mExecutor.isTerminated()) {
                this.mLock.unlock();
                return false;
            }
            try {
                if (!isAppDetailsValid()) {
                    RetrieveAppDetails appDetails = getAppDetails();
                    if (appDetails != null) {
                        if (this.showDebugMsgs) {
                            Logger.debug(this, "Calling AppDetails ");
                        }
                        this.mExecutor.execute(appDetails);
                    }
                }
                if (aRunnable != null) {
                    this.mExecutor.execute(aRunnable);
                }
                this.mLock.unlock();
                return true;
            } catch (Exception e) {
                this.mLock.unlock();
                return false;
            }
        } catch (Throwable th) {
            this.mLock.unlock();
        }
    }
}
