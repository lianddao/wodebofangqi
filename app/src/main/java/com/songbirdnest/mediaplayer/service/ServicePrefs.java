package com.songbirdnest.mediaplayer.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import com.songbirdnest.analytics.Analytics;
import com.songbirdnest.mediaplayer.MediaButtonReceiver;
import com.songbirdnest.mediaplayer.MediaButtonReceiverProxy;
import com.songbirdnest.mediaplayer.PrefKeys;
import com.songbirdnest.mediaplayer.PrefKeys.FeatureSet;
import com.songbirdnest.mediaplayer.Utils;
import com.songbirdnest.util.Base64;

public class ServicePrefs {
    public static final String MUSIC_APP_METADATA_ACTION = "com.android.music.metachanged";
    public static final String MUSIC_APP_PLAYSTATE_CHANGED_ACTION = "com.songbirdnest.mediaplayer.playstatechanged";
    public static final String MUSIC_APP_QUEUE_CHANGED_ACTION = "com.android.music.queuechanged";
    public static final String SCROBBLEDROID_MUSIC_STATUS_ACTION = "net.jjc1138.android.scrobbler.action.MUSIC_STATUS";
    private boolean isServiceInitalized = false;
    Context mContext;
    private boolean mDefaultMediaButtonReceiver = true;
    private ComponentName mMediaButtonReceiverComponentName;
    int mMediaId = -1;
    MediaButtonReceiver mMediaRecevier = new MediaButtonReceiver();
    SongbirdMedia mMediaWrapper;
    PlayerMetaData mMetaData;
    private boolean mMusicAppIntentsEnabled = true;
    private BroadcastReceiver mPrefBroadcast = new C01911();
    private boolean mScrobbleEnabled = true;
    SharedPreferences prefs;

    class C01911 extends BroadcastReceiver {
        C01911() {
        }

        public void onReceive(Context context, Intent intent) {
            ServicePrefs.this.processChange(intent);
        }
    }

    public ServicePrefs(Context pContext, PlayerMetaData pMetaData, SongbirdMedia pMediaWrapper) {
        this.mContext = pContext;
        this.mMediaWrapper = pMediaWrapper;
        this.mMetaData = pMetaData;
        this.mMediaButtonReceiverComponentName = new ComponentName(pContext.getPackageName(), MediaButtonReceiverProxy.class.getName());
        pContext.registerReceiver(this.mPrefBroadcast, new IntentFilter(PrefKeys.PREFS_BROADCAST));
        this.prefs = pContext.getSharedPreferences(PrefKeys.PREFS_FILENAME, 0);
        if (!FeatureSet.BASE64.hasMask(this.prefs.getInt(PrefKeys.FEATURE_SET, 0))) {
            String aToken = this.prefs.getString(PrefKeys.BACK_TO_LIST_TOKEN, "");
            Editor aEdit = this.prefs.edit();
            aEdit.putString(PrefKeys.BACK_TO_LIST_TOKEN, Base64.encodeBytes(aToken.getBytes()));
            aEdit.putInt(PrefKeys.FEATURE_SET, FeatureSet.getFeatures());
            aEdit.commit();
        }
        reinitMedia();
        this.mDefaultMediaButtonReceiver = this.prefs.getBoolean(PrefKeys.DEFAULT_MEDIA_BUTTON_RECEIVER, true);
        if (this.mDefaultMediaButtonReceiver) {
            registerMediaButtonReceiver();
        } else {
            unregisterMediaButtonReceiver();
        }
        this.mScrobbleEnabled = this.prefs.getBoolean(PrefKeys.ENABLE_SCROBBLE_DROID_INTENTS, true);
        this.mDefaultMediaButtonReceiver = this.prefs.getBoolean(PrefKeys.DEFAULT_MEDIA_BUTTON_RECEIVER, true);
    }

    public void processChange(Intent pChangeRequest) {
        Bundle aExtra = pChangeRequest.getExtras();
        if (aExtra != null) {
            String aKey = aExtra.getString("key");
            if (pChangeRequest.getAction().equals(PrefKeys.PREFS_BROADCAST) && aKey != null) {
                if (aKey.equals(PrefKeys.ENABLE_SCROBBLE_DROID_INTENTS)) {
                    this.mScrobbleEnabled = aExtra.getBoolean("value");
                } else if (aKey.equals(PrefKeys.DEFAULT_MEDIA_BUTTON_RECEIVER)) {
                    this.mDefaultMediaButtonReceiver = aExtra.getBoolean("value");
                    if (!this.mMediaWrapper.mHeadsetConnected) {
                        return;
                    }
                    if (!this.mDefaultMediaButtonReceiver) {
                        unregisterMediaButtonReceiver();
                    } else if (this.mDefaultMediaButtonReceiver) {
                        registerMediaButtonReceiver();
                    }
                }
            }
        }
    }

    public void unregisterReceivers() {
        this.mContext.unregisterReceiver(this.mPrefBroadcast);
        unregisterMediaButtonReceiver();
    }

    public void fireNoPopulate(String pAction) {
        if (getCorrsponding(pAction)) {
            fireBroadcastIntent(pAction, false);
        }
    }

    public void firePopulate(String pAction) {
        if (getCorrsponding(pAction)) {
            fireBroadcastIntent(pAction, true);
        }
    }

    private void fireBroadcastIntent(String aAction, boolean aReportMetadata) {
        Intent i = new Intent(aAction);
        if (aReportMetadata) {
            i.putExtra("artist", this.mMetaData.getCurrentArtist());
            i.putExtra(Analytics.TRACK_KEY, this.mMetaData.getCurrentTitle());
            i.putExtra("album", this.mMetaData.getCurrentAlbum());
            i.putExtra("secs", Integer.valueOf(this.mMetaData.getCurrentDuration() / SongbirdMedia.PODCAST_BACKUP));
        }
        i.putExtra("playing", this.mMediaWrapper.mShouldBePlaying);
        this.mContext.sendStickyBroadcast(i);
    }

    public void mediaAttempt(Intent pIntent) {
        if (this.mDefaultMediaButtonReceiver) {
            Log.i("Tracke", "Media Button Attempt");
            this.mMediaRecevier.onReceive(this.mContext, pIntent);
        }
    }

    private boolean getCorrsponding(String pAction) {
        if (pAction.equals(MUSIC_APP_QUEUE_CHANGED_ACTION) || pAction.equals(MUSIC_APP_PLAYSTATE_CHANGED_ACTION) || pAction.equals(MUSIC_APP_METADATA_ACTION)) {
            return this.mMusicAppIntentsEnabled;
        }
        if (pAction.equals(SCROBBLEDROID_MUSIC_STATUS_ACTION)) {
            return this.mScrobbleEnabled;
        }
        return false;
    }

    public void registerMediaButtonReceiver() {
        if (VERSION.SDK_INT >= 8) {
            ((AudioManager) this.mContext.getSystemService("audio")).registerMediaButtonEventReceiver(this.mMediaButtonReceiverComponentName);
        }
    }

    public void unregisterMediaButtonReceiver() {
        if (VERSION.SDK_INT >= 8) {
            ((AudioManager) this.mContext.getSystemService("audio")).unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverComponentName);
        }
    }

    public boolean isServiceInitalized() {
        return this.isServiceInitalized;
    }

    public void setServiceInitalized(boolean isServiceInitalized) {
        this.isServiceInitalized = isServiceInitalized;
    }

    public void reinitMedia() {
        if (VERSION.SDK_INT >= 9) {
            Editor edit = this.prefs.edit();
            this.mMediaId = this.mMediaWrapper.mMediaPlayer.getAudioSessionId();
            edit.putInt("mediaid", this.mMediaId);
            Log.i("SongbirdMedia", "AudioSession id" + this.mMediaId);
            edit.commit();
            Intent intent = Utils.getPhilipsIntent(false, this.mMediaId, false);
            if (Utils.containsGingerPackage(intent, this.mContext.getPackageManager())) {
                intent.addFlags(268435456);
                this.mContext.startActivity(intent);
            }
        }
    }
}
