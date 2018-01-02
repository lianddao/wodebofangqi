package com.miui.player.plugin.onlinesync.baidu;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.music.model.Songlist;
import com.baidu.music.model.SonglistList;
import com.baidu.music.onlinedata.CloundManager;
import com.baidu.music.onlinedata.CloundManager.CloundInterface.onAddSongToSonglistListener;
import com.baidu.music.onlinedata.CloundManager.CloundInterface.onAddSonglistListener;
import com.baidu.music.onlinedata.CloundManager.CloundInterface.onDelSongInSonglistListener;
import com.baidu.music.onlinedata.CloundManager.CloundInterface.onDelSonglistListener;
import com.baidu.music.onlinedata.CloundManager.CloundInterface.onGetSonglistDetailListener;
import com.baidu.music.onlinedata.CloundManager.CloundInterface.onGetSonglistListsListener;
import com.baidu.music.onlinedata.CloundManager.CloundInterface.onUpdateSonglistListener;
import com.baidu.music.onlinedata.OnlineManagerEngine;
import com.miui.player.ui.base.MusicApplication;
import com.miui.player.util.ThreadManager.BlockingRequest;

public class BaiduSdkInterface {
    private static final String TAG = "BaiduSdkInterface";
    private static final Handler sHandler = new Handler(Looper.getMainLooper());

    public static class PlaylistDetailResult {
        public final int mResultCode;
        public final Songlist mSonglist;

        PlaylistDetailResult(Songlist songlist, int resultCode) {
            this.mSonglist = songlist;
            this.mResultCode = resultCode;
        }
    }

    public static class PlaylistListResult {
        public final SonglistList mLists;

        PlaylistListResult(SonglistList lists) {
            this.mLists = lists;
        }
    }

    public static class PlaylistResult {
        public final String mPlaylistCloudId;
        public final int mResultCode;

        PlaylistResult(String playlistCloudId, int resultCode) {
            this.mPlaylistCloudId = playlistCloudId;
            this.mResultCode = resultCode;
        }
    }

    public static class TracksResult {
        public final String mOnlineAudioIds;
        public final String mPlaylistCloudId;
        public final int mResultCode;

        TracksResult(String playlistCloudId, String onlineAudioIds, int resultCode) {
            this.mPlaylistCloudId = playlistCloudId;
            this.mOnlineAudioIds = onlineAudioIds;
            this.mResultCode = resultCode;
        }
    }

    private static CloundManager getCloundManager() {
        Context context = MusicApplication.getApplication();
        return OnlineManagerEngine.getInstance(context).getCloundManager(context);
    }

    public static PlaylistResult addPlaylist(final String playlistName) {
        return (PlaylistResult) new BlockingRequest<PlaylistResult>(sHandler) {

            class C03781 implements onAddSonglistListener {
                C03781() {
                }

                public void onAddSonglist(String cloudId, int resultCode) {
                    C03791.this.setResult(new PlaylistResult(cloudId, resultCode));
                }
            }

            public void run() {
                Context context = MusicApplication.getApplication();
                CloundManager manager = BaiduSdkInterface.getCloundManager();
                if (manager != null) {
                    manager.addSonglist(context, playlistName, new C03781());
                }
            }
        }.getResult();
    }

    public static PlaylistResult delPlaylist(final String playlistCloudId) {
        return (PlaylistResult) new BlockingRequest<PlaylistResult>(sHandler) {

            class C03801 implements onDelSonglistListener {
                C03801() {
                }

                public void onDelSonglist(String cloudId, int resultCode) {
                    C03812.this.setResult(new PlaylistResult(cloudId, resultCode));
                }
            }

            public void run() {
                Context context = MusicApplication.getApplication();
                CloundManager manager = BaiduSdkInterface.getCloundManager();
                if (manager != null) {
                    manager.delSonglist(context, playlistCloudId, new C03801());
                }
            }
        }.getResult();
    }

    public static PlaylistResult updatePlaylist(final String playlistCloudId, final String playlistName) {
        return (PlaylistResult) new BlockingRequest<PlaylistResult>(sHandler) {

            class C03821 implements onUpdateSonglistListener {
                C03821() {
                }

                public void onUpdateSonglistName(String cloudId, int resultCode) {
                    C03833.this.setResult(new PlaylistResult(cloudId, resultCode));
                }
            }

            public void run() {
                Context context = MusicApplication.getApplication();
                CloundManager manager = BaiduSdkInterface.getCloundManager();
                if (manager != null) {
                    manager.updateSonglist(context, playlistCloudId, playlistName, new C03821());
                }
            }
        }.getResult();
    }

    public static TracksResult addTracksToPlaylist(final String playlistCloudId, final String ids) {
        return (TracksResult) new BlockingRequest<TracksResult>(sHandler) {

            class C03841 implements onAddSongToSonglistListener {
                C03841() {
                }

                public void onAddSongToSonglist(String playlistCloudId, String onlineAudioIds, int resultCode) {
                    C03854.this.setResult(new TracksResult(playlistCloudId, onlineAudioIds, resultCode));
                }
            }

            public void run() {
                Context context = MusicApplication.getApplication();
                CloundManager manager = BaiduSdkInterface.getCloundManager();
                if (manager != null) {
                    manager.addSongToSonglist(context, playlistCloudId, ids, new C03841());
                }
            }
        }.getResult();
    }

    public static TracksResult delTracksInPlaylist(final String playlistCloudId, final String ids) {
        return (TracksResult) new BlockingRequest<TracksResult>(sHandler) {

            class C03861 implements onDelSongInSonglistListener {
                C03861() {
                }

                public void onDelSongInSonglist(String playlistCloudId, String onlineAudioIds, int resultCode) {
                    C03875.this.setResult(new TracksResult(playlistCloudId, onlineAudioIds, resultCode));
                }
            }

            public void run() {
                Context context = MusicApplication.getApplication();
                CloundManager manager = BaiduSdkInterface.getCloundManager();
                if (manager != null) {
                    manager.delSongInSonglist(context, playlistCloudId, ids, new C03861());
                }
            }
        }.getResult();
    }

    public static PlaylistDetailResult getPlaylistDetail(final String playlistCloudId, final int pageNo, final int pageSize) {
        return (PlaylistDetailResult) new BlockingRequest<PlaylistDetailResult>(sHandler) {

            class C03881 implements onGetSonglistDetailListener {
                C03881() {
                }

                public void onGetSonglistDetail(Songlist songlist, int resultCode) {
                    C03896.this.setResult(new PlaylistDetailResult(songlist, resultCode));
                }
            }

            public void run() {
                Context context = MusicApplication.getApplication();
                CloundManager manager = BaiduSdkInterface.getCloundManager();
                if (manager != null) {
                    manager.getSonglistDetail(context, playlistCloudId, pageNo, pageSize, false, new C03881());
                }
            }
        }.getResult();
    }

    public static PlaylistListResult getPlaylistList(final int pageNo, final int pageSize) {
        return (PlaylistListResult) new BlockingRequest<PlaylistListResult>(sHandler) {

            class C03901 implements onGetSonglistListsListener {
                C03901() {
                }

                public void onGetSonglistLists(SonglistList lists) {
                    C03917.this.setResult(new PlaylistListResult(lists));
                }
            }

            public void run() {
                Context context = MusicApplication.getApplication();
                CloundManager manager = BaiduSdkInterface.getCloundManager();
                if (manager != null) {
                    manager.getSonglistLists(context, pageNo, pageSize, false, new C03901());
                }
            }
        }.getResult();
    }
}
