package com.songbirdnest.mediaplayer;

public final class PrefKeys {
    public static final String ARTIST_BIO_SHOW_FEED = "artist_bio.displayfeed";
    public static final String ARTIST_DETAILS_LAST_SUBVIEW = "artistDetailsView.lastSubView";
    public static final String BACK_TO_LIST_TOKEN = "mediaService.backToListToken";
    public static final String BACK_TO_LIST_VIEW = "mediaService.backToListView";
    public static final String DEFAULT_MEDIA_BUTTON_RECEIVER = "mediaService.defaultMediaButtonReceiver";
    public static final String ENABLE_FULL_SENSOR = "mediaPlayer.FullSensor";
    public static final String ENABLE_LOCKSCREEN_WIDGET = "mediaPlayer.enableLockScreenWidget";
    public static final String ENABLE_MUSIC_APP_INTENTS = "mediaService.enableMusicAppIntents";
    public static final String ENABLE_SCROBBLE_DROID_INTENTS = "mediaService.enableScrobbleDroidIntents";
    public static final String FEATURE_SET = "mediaPlayer.FeatureSet";
    public static final String LOCK_PORTRAIT = "mediaPlayer.portraitLock";
    public static final String PLAYLIST_CREATE_NEXT_PLAYLIST = "playlistCreationDialog.nextPlaylist";
    public static final String PLAYLIST_MOST_RECENTLY_EDITED_LIST = "playlist.mostRecentlyEdited";
    public static final String PREFS_BROADCAST = "com.songbirdnest.mediaplayer.PREF_BROADCAST";
    public static final String PREFS_BROADCAST_KEY = "key";
    public static final String PREFS_BROADCAST_VALUE = "value";
    public static final String PREFS_EXTERNAL = "externalPrefs";
    public static final String PREFS_FILENAME = "mediaServicePrefs";
    public static final String REPEAT_MODE = "mediaService.repeatMode";
    public static final String SHUFFLE_ENABLED = "mediaService.shuffle.enabled";
    public static final String SONGBIRD_ME_SHOW_FEED = "songbird.me.displayfeed";
    public static final String SOUNDBOARD_PREF_FILENAME = "soundboardPrefs";
    public static final String VIDEO_ID = "video.id";
    public static final String VIDEO_POSITION = "video.position";
    public static final String sAccessExpirationKey = "facebook.accessExpirationTime";
    public static final String sAccessTokenKey = "facebook.accessToken";
    public static final String sAccessUserEmail = "facebook.accessUserEmail";
    public static final String sAccessUserFullName = "facebook.accessUserFullName";
    public static final String sAccessUserId = "facebook.accessUserId";
    public static final String sAmazon_Billing_initialized = "amazon.billing.initialized";
    public static final String sCurrentEQ_status = "eq.status";
    public static final String sCurrentPresetIndex = "eq.presetIndex";
    public static final String sCurrentPresetSettings = "eq.settings";
    public static final String sCurrentPresetType = "eq.presetType";
    public static final String sFirstRun = "mediaPlayer.firstRun";
    public static final String sFriendsFirstRun = "friends.firstRun";
    public static final String sGoogle_Billing_initialized = "google.billing.initialized";
    public static final String sGoogle_Billing_supported = "google.billing.supported";
    public static final String sLastAppDetailsAccess = "soundboard.LastAppDetailsAccess";
    public static final String sMediaPlayerPrefs = "mediaPlayerPrefs";
    public static final String sNotificationRegId = "google.notification.reg.id";
    public static final String sSoundboardAppKey = "soundboard.appKey";
    public static final String sSoundboardId = "soundboard.id";
    public static final String sSoundboardPermissions = "soundboard.permissions";
    public static final String sVersion = "mediaPlayer.version";

    public enum FeatureSet {
        BASE64;
        
        int value;

        public static int getFeatures() {
            return BASE64.getMask();
        }

        public int getMask() {
            return this.value;
        }

        public boolean hasMask(int pMask) {
            if ((this.value & pMask) == this.value) {
                return true;
            }
            return false;
        }
    }
}
