package com.miui.player.util;

import android.content.ContentResolver;
import android.content.Context;
import com.miui.player.provider.FavoriteCache;
import com.miui.player.provider.MediaProviderHelper;
import com.miui.player.provider.PlayerStore.MiuiPlaylistsAudioMap;
import com.miui.player.service.ServiceHelper;

public class PlaylistRecoverer {
    public static final String TAG = PlaylistRecoverer.class.getName();
    public static final int UPDATE_VERSION_START = 0;
    private static PlaylistRecoverer sInstance = null;
    private final FilterConditions mFilterConditions;
    private boolean mForceRecover = true;
    private int mUpdateVersion = 0;

    static class FilterConditions {
        public boolean mLastFilterDuration;
        public int mLastFilterDurationProgress;
        public boolean mLastFilterSize;
        public int mLastFilterSizeProgress;

        FilterConditions() {
        }

        public void update(Context context) {
            this.mLastFilterSizeProgress = getLastFilterSizeProgress(context);
            this.mLastFilterSize = getLastFilterSize(context);
            this.mLastFilterDurationProgress = getLastFilterDurationProgress(context);
            this.mLastFilterDuration = getLastFilterDuration(context);
        }

        public boolean isChanged(Context context) {
            return (this.mLastFilterSizeProgress == getLastFilterSizeProgress(context) && this.mLastFilterSize == getLastFilterSize(context) && this.mLastFilterDurationProgress == getLastFilterDurationProgress(context) && this.mLastFilterDuration == getLastFilterDuration(context)) ? false : true;
        }

        private static boolean getLastFilterSize(Context context) {
            return PreferenceCache.getPrefAsBoolean(context, PreferenceCache.PREF_FILTER_BY_SIZE);
        }

        private static boolean getLastFilterDuration(Context context) {
            return PreferenceCache.getPrefAsBoolean(context, PreferenceCache.PREF_FILTER_BY_DURATION);
        }

        private static int getLastFilterSizeProgress(Context context) {
            return PreferenceCache.getPrefAsInteger(context, PreferenceCache.PREF_FILTER_BY_SIZE_PROGRESS).intValue();
        }

        private static int getLastFilterDurationProgress(Context context) {
            return PreferenceCache.getPrefAsInteger(context, PreferenceCache.PREF_FILTER_BY_DURATION_PROGRESS).intValue();
        }
    }

    private PlaylistRecoverer(Context context, FilterConditions conditions) {
        this.mFilterConditions = conditions;
        doRecover(context);
    }

    private void markForceRecoverInternel() {
        this.mForceRecover = true;
    }

    private boolean needRecover(Context context) {
        return this.mForceRecover || this.mFilterConditions.isChanged(context);
    }

    private boolean doRecover(Context context) {
        if (!needRecover(context)) {
            return false;
        }
        long c = System.currentTimeMillis();
        ContentResolver res = context.getContentResolver();
        long[] trackIds = MediaProviderHelper.queryValidTrackIdArr(context);
        if (res.delete(MiuiPlaylistsAudioMap.EXTERNAL_URI, "audio_id<536870911 AND audio_id NOT IN " + SqlUtils.concatAsSet(trackIds), null) > 0) {
            FavoriteCache.recoverCache(context, trackIds);
        }
        ServiceHelper.recoverQueue(trackIds);
        this.mForceRecover = false;
        this.mFilterConditions.update(context);
        Utils.debugLog(TAG, "interval for recover miui db " + (System.currentTimeMillis() - c));
        return true;
    }

    public int recover(Context context) {
        if (doRecover(context)) {
            this.mUpdateVersion++;
        }
        return this.mUpdateVersion;
    }

    public static synchronized PlaylistRecoverer instance(Context context) {
        PlaylistRecoverer playlistRecoverer;
        synchronized (PlaylistRecoverer.class) {
            if (sInstance == null) {
                FilterConditions c = new FilterConditions();
                c.update(context);
                sInstance = new PlaylistRecoverer(context, c);
            }
            playlistRecoverer = sInstance;
        }
        return playlistRecoverer;
    }

    public static synchronized void markForceRecover() {
        synchronized (PlaylistRecoverer.class) {
            if (sInstance != null) {
                sInstance.markForceRecoverInternel();
            }
        }
    }

    public static synchronized int recoverIfNeeded(Context context) {
        int recover;
        synchronized (PlaylistRecoverer.class) {
            if (sInstance != null) {
                recover = sInstance.recover(context);
            } else {
                recover = 0;
            }
        }
        return recover;
    }
}
