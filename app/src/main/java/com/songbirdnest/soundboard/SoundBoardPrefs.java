package com.songbirdnest.soundboard;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.songbirdnest.facebook.FacebookAPI;
import com.songbirdnest.facebook.FacebookUser;
import com.songbirdnest.mediaplayer.PrefKeys;
import com.songbirdnest.util.Logger;

public class SoundBoardPrefs {
    private static int TWENTY_FOUR_HOURS = 86400000;
    protected String currentUserSoundBoardId;
    protected FacebookUser facebookUser = new FacebookUser();
    protected long lastAppDetailsAccess;
    private Context mContext = null;
    protected String soundBoardAppKey;
    protected String soundBoardPermissions;
    protected String[] soundBoardPermissionsArray;

    public SoundBoardPrefs(Context mContext) {
        this.mContext = mContext;
    }

    public void setUserId(String userId) {
        this.facebookUser.setId(userId);
    }

    public void setUserName(String userName) {
        this.facebookUser.setName(userName);
    }

    public void setUserEmail(String userEmail) {
        this.facebookUser.setEmail(userEmail);
    }

    public String getUserEmail() {
        return this.facebookUser.getEmail();
    }

    public String getUserId() {
        return this.facebookUser.getId();
    }

    public String getUserName() {
        return this.facebookUser.getName();
    }

    public String getCurrentUserSoundBoardId() {
        return this.currentUserSoundBoardId;
    }

    public void setCurrentUserSoundBoardId(String currentUserSoundBoardId) {
        this.currentUserSoundBoardId = currentUserSoundBoardId;
        this.facebookUser.setSoundBoardId(currentUserSoundBoardId);
    }

    public FacebookUser getFacebookUser() {
        return this.facebookUser;
    }

    public String getSoundBoardAppKey() {
        return this.soundBoardAppKey;
    }

    public void setSoundBoardAppKey(String soundBoardAppKey) {
        this.lastAppDetailsAccess = System.currentTimeMillis();
        this.soundBoardAppKey = soundBoardAppKey;
    }

    public void setSoundBoardPermissions(String soundBoardPermissions) {
        this.soundBoardPermissions = soundBoardPermissions;
    }

    public void setSoundBoardPermissionsArray(String[] soundBoardPermissionsArray) {
        this.soundBoardPermissionsArray = soundBoardPermissionsArray;
    }

    public void setAccessToken(String access) {
        this.facebookUser.setAccessToken(access);
    }

    public void setExpiration(long accessExpires) {
        this.facebookUser.setExpiration(accessExpires);
    }

    public long getExpiration() {
        return this.facebookUser.getExpiration();
    }

    public String getAccessToken() {
        return this.facebookUser.getAccessToken();
    }

    public boolean hasUserInfo() {
        return (getUserId() == null || getUserEmail() == null || getUserName() == null) ? false : true;
    }

    public boolean isAppDetailsValid() {
        if (this.soundBoardAppKey == null || this.soundBoardPermissions == null) {
            return false;
        }
        if (this.lastAppDetailsAccess > 0) {
            if (this.lastAppDetailsAccess + ((long) TWENTY_FOUR_HOURS) < System.currentTimeMillis()) {
                return false;
            }
        }
        return true;
    }

    public void readPrefs() {
        SharedPreferences prefs = this.mContext.getSharedPreferences(PrefKeys.SOUNDBOARD_PREF_FILENAME, 0);
        this.soundBoardAppKey = prefs.getString(PrefKeys.sSoundboardAppKey, null);
        this.lastAppDetailsAccess = prefs.getLong(PrefKeys.sLastAppDetailsAccess, -1);
        if (this.soundBoardAppKey != null) {
            this.currentUserSoundBoardId = prefs.getString(PrefKeys.sSoundboardId, null);
            this.soundBoardPermissions = prefs.getString(PrefKeys.sSoundboardPermissions, null);
            if (this.soundBoardPermissions != null && this.soundBoardPermissions.length() > 0) {
                this.soundBoardPermissionsArray = this.soundBoardPermissions.split(",");
                FacebookAPI.setPermissions(this.soundBoardPermissions);
            }
            this.facebookUser.setSoundBoardId(this.currentUserSoundBoardId);
        }
        this.facebookUser.setAccessToken(prefs.getString(PrefKeys.sAccessTokenKey, null));
        this.facebookUser.setName(prefs.getString(PrefKeys.sAccessUserFullName, null));
        this.facebookUser.setId(prefs.getString(PrefKeys.sAccessUserId, null));
        this.facebookUser.setEmail(prefs.getString(PrefKeys.sAccessUserEmail, null));
        this.facebookUser.setExpiration(prefs.getLong(PrefKeys.sAccessExpirationKey, -1));
    }

    public void writePrefs() {
        Editor prefsEditor = this.mContext.getSharedPreferences(PrefKeys.SOUNDBOARD_PREF_FILENAME, 0).edit();
        prefsEditor.putLong(PrefKeys.sLastAppDetailsAccess, this.lastAppDetailsAccess);
        prefsEditor.putString(PrefKeys.sSoundboardAppKey, this.soundBoardAppKey);
        prefsEditor.putString(PrefKeys.sSoundboardId, this.currentUserSoundBoardId);
        prefsEditor.putString(PrefKeys.sSoundboardPermissions, this.soundBoardPermissions);
        prefsEditor.putString(PrefKeys.sAccessUserId, this.facebookUser.getId());
        prefsEditor.putString(PrefKeys.sAccessUserFullName, this.facebookUser.getName());
        prefsEditor.putString(PrefKeys.sAccessUserEmail, this.facebookUser.getEmail());
        prefsEditor.putString(PrefKeys.sAccessTokenKey, this.facebookUser.getAccessToken());
        prefsEditor.putLong(PrefKeys.sAccessExpirationKey, this.facebookUser.getExpiration());
        if (!prefsEditor.commit()) {
            Logger.warn(this, "Failed to write Soundboard App Key to persistent storage!");
        }
    }

    public void clearData() {
        this.soundBoardPermissions = null;
        this.soundBoardAppKey = null;
        this.currentUserSoundBoardId = null;
        this.soundBoardPermissionsArray = null;
        this.facebookUser = new FacebookUser();
    }
}
