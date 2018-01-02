package com.miui.player.plugin.onlinesync;

import android.text.TextUtils;
import com.miui.player.provider.PlayerStore.BaiduSyncState;

public class SyncObject {

    public static class PlaylistRecord {
        public String mPlaylistCloudId;
        public int mPlaylistLocalId;
        public String mPlaylistName;
        public String mSyncState;

        public boolean canUpload() {
            int i;
            int i2 = 1;
            if (!BaiduSyncState.INSERT.equals(this.mSyncState) || TextUtils.isEmpty(this.mPlaylistName)) {
                i = 0;
            } else {
                i = 1;
            }
            boolean ret = false | i;
            if (!BaiduSyncState.DELETE.equals(this.mSyncState) || TextUtils.isEmpty(this.mPlaylistCloudId)) {
                i = 0;
            } else {
                i = 1;
            }
            ret |= i;
            if (!BaiduSyncState.RENAME.equals(this.mSyncState) || TextUtils.isEmpty(this.mPlaylistName) || TextUtils.isEmpty(this.mPlaylistCloudId)) {
                i2 = 0;
            }
            return ret | i2;
        }

        public boolean canUpdate() {
            return canUpload() && this.mPlaylistLocalId > 0;
        }

        public String toString() {
            return String.format("name=%s, cloud id=%s, local id=%d, state=%d", new Object[]{this.mPlaylistName, this.mPlaylistCloudId, Integer.valueOf(this.mPlaylistLocalId), this.mSyncState});
        }
    }

    public static class TrackInfo {
        public String mAlbumName;
        public String mArtistName;
        public long mDuration;
        public String mProvider;
        public String mTitle;
        public String mTrackOnlineId;
    }

    public static class TrackRecord extends TrackInfo {
        public String mPlaylistCloudId;
        public int mPlaylistLocalId;
        public String mPlaylistName;
        public String mSyncState;

        public boolean canUpload() {
            if ((!BaiduSyncState.INSERT.equals(this.mSyncState) && !BaiduSyncState.DELETE.equals(this.mSyncState)) || this.mPlaylistLocalId < 0 || TextUtils.isEmpty(this.mTrackOnlineId) || TextUtils.isEmpty(this.mPlaylistCloudId) || TextUtils.isEmpty(this.mPlaylistName)) {
                return false;
            }
            return true;
        }

        public String toString() {
            return String.format("online id=%s, title=%s, album=%s, artist=%s, provider=%s, state=%s, playlist local id=%d, playlist cloud id=%s, playlist name=%s", new Object[]{this.mTrackOnlineId, this.mTitle, this.mAlbumName, this.mArtistName, this.mProvider, this.mSyncState, Integer.valueOf(this.mPlaylistLocalId), this.mPlaylistCloudId, this.mPlaylistName});
        }
    }

    public static class TracksOperation {
        public String mOperation;
        public String mPlaylistCloudId;
        public int mPlaylistLocalId;
        public String mPlaylistName;
        public int mTrackCount;
        public String mTrackIds;

        public boolean isValid() {
            if ((BaiduSyncState.INSERT.equals(this.mOperation) || BaiduSyncState.DELETE.equals(this.mOperation)) && this.mPlaylistLocalId >= 0 && this.mTrackCount > 0 && !TextUtils.isEmpty(this.mPlaylistCloudId) && !TextUtils.isEmpty(this.mPlaylistName)) {
                return true;
            }
            return false;
        }
    }
}
