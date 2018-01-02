package com.miui.player.service;

import android.content.Context;
import android.text.TextUtils;
import com.miui.player.meta.LyricParser;
import com.miui.player.meta.LyricParser.Lyric;
import com.miui.player.meta.LyricSearchInfo;
import com.miui.player.meta.MetaManager;
import com.miui.player.network.LyricDownloader;
import com.miui.player.network.LyricDownloader.LyricAsyncCallback;
import com.miui.player.plugin.onlinelyric.LyricContent;
import com.miui.player.plugin.onlinelyric.LyricItemInfo;
import com.miui.player.plugin.onlinelyric.LyricProvider;
import com.miui.player.util.CollectionHelper;
import com.miui.player.util.PreferenceCache;
import com.xiaomi.music.util.NetworkUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import miui.util.PlayerActions.Out.LyricStatus;

public class LyricManager implements LyricStatus {
    private Lyric mLyric;
    private int mLyricStatus = 0;

    interface LyricCommand {
        boolean execute(Context context, LyricAsyncCallback lyricAsyncCallback);
    }

    static class DirectlyDownload implements LyricCommand {
        private final String mOnlineId;

        public DirectlyDownload(String onlineId) {
            this.mOnlineId = onlineId;
        }

        public boolean execute(Context context, LyricAsyncCallback cbk) {
            LyricDownloader.downloadAsync(context, this.mOnlineId, cbk);
            return true;
        }
    }

    static class LyricDownloadProxy extends LyricAsyncCallback {
        private final LyricAsyncCallback mActual;
        private final Context mContext;
        private final LyricSearchInfo mSearchInfo;

        public LyricDownloadProxy(Context context, LyricAsyncCallback actual, LyricSearchInfo info) {
            this.mActual = actual;
            this.mSearchInfo = info;
            this.mContext = context;
        }

        public boolean isAutoChoose() {
            return this.mActual.isAutoChoose();
        }

        public void setLyricItemInfo(LyricProvider provider, List<LyricItemInfo> info) {
            super.setLyricItemInfo(provider, info);
            this.mActual.setLyricItemInfo(provider, info);
        }

        public void run() {
            if ((CollectionHelper.isEmpty(this.mInfoList) || this.mInfoList.get(0) == null) && this.mSearchInfo != null) {
                LyricManager.download(this.mContext, new SearchAndDownload(this.mSearchInfo), this.mActual);
            } else {
                this.mActual.run();
            }
        }
    }

    static class SearchAndDownload implements LyricCommand {
        private final LyricSearchInfo mSearchInfo;

        public SearchAndDownload(LyricSearchInfo searchInfo) {
            this.mSearchInfo = searchInfo;
        }

        public boolean execute(Context context, LyricAsyncCallback cbk) {
            if (this.mSearchInfo == null || !this.mSearchInfo.isValid()) {
                return false;
            }
            LyricDownloader.downloadAsync(context, this.mSearchInfo, cbk);
            return true;
        }
    }

    public void reset() {
        this.mLyricStatus = 0;
    }

    public boolean isSuccess() {
        return this.mLyricStatus == 3;
    }

    public ArrayList<CharSequence> getStringArr() {
        return this.mLyric != null ? this.mLyric.getStringArr() : null;
    }

    public int[] getTimeArr() {
        return this.mLyric != null ? this.mLyric.getTimeArr() : null;
    }

    public void recycleContent() {
        if (this.mLyric != null) {
            this.mLyric.recycleContent();
        }
    }

    public int status() {
        return this.mLyricStatus;
    }

    public boolean updateLyricStatus(MediaPlaybackService service, LyricAsyncCallback callback, boolean needLyric, String trackName, String albumName, String artistName, boolean reset) {
        if (!PreferenceCache.getPrefAsBoolean(service, PreferenceCache.PREF_DISPLAY_LYRIC)) {
            this.mLyricStatus = 1;
            this.mLyric = null;
            return false;
        } else if (!service.isPlaying() && !reset && this.mLyricStatus != 0) {
            return false;
        } else {
            if (TextUtils.isEmpty(trackName) && TextUtils.isEmpty(artistName)) {
                this.mLyric = null;
                this.mLyricStatus = 2;
                return false;
            }
            File lyricFile = MetaManager.getLyricFile(trackName, artistName, service.getAbsolutePath());
            if (lyricFile == null || !lyricFile.exists()) {
                this.mLyric = null;
            } else if (reset || this.mLyric == null || !this.mLyric.getFilePath().equals(lyricFile.getAbsolutePath()) || this.mLyric.getOpenTime() < lyricFile.lastModified()) {
                this.mLyric = LyricParser.parseLyric(lyricFile);
                lyricFile.setLastModified(System.currentTimeMillis());
                if (this.mLyric == null) {
                    lyricFile.delete();
                    this.mLyricStatus = 2;
                }
            }
            if (this.mLyric != null) {
                this.mLyricStatus = 3;
            } else if (this.mLyricStatus == 0) {
                if (service.isBuffering() && !reset) {
                    return false;
                }
                this.mLyricStatus = 1;
                if (service.needSearch()) {
                    Context context = service.getApplication();
                    String onlineId = service.getOnlineId();
                    LyricSearchInfo searchInfo = new LyricSearchInfo(trackName, artistName, albumName, service.getAbsolutePath());
                    int status = 2;
                    if (onlineId != null) {
                        status = download(context, new DirectlyDownload(onlineId), new LyricDownloadProxy(context, callback, searchInfo));
                    }
                    if (status == 2) {
                        status = download(context, new SearchAndDownload(searchInfo), callback);
                    }
                    this.mLyricStatus = status;
                }
            } else if (this.mLyricStatus == 4 && needLyric) {
                this.mLyricStatus = 2;
            }
            if (this.mLyricStatus == 3 && needLyric) {
                return true;
            }
            return false;
        }
    }

    public static int download(Context context, LyricSearchInfo searchInfo, LyricAsyncCallback cbk) {
        return download(context, new SearchAndDownload(searchInfo), cbk);
    }

    public static int download(Context context, LyricCommand command, LyricAsyncCallback cbk) {
        if (!NetworkUtil.isActive(context)) {
            return 5;
        }
        if (!NetworkUtil.isActiveNetworkMetered(context) || PreferenceCache.getPrefAsBoolean(context, PreferenceCache.PREF_DOWNLOAD_LYRIC_OTHER)) {
            return command.execute(context, cbk) ? 4 : 2;
        } else {
            return 6;
        }
    }

    public static boolean saveLyricFile(Context context, String title, String artist, LyricContent content) {
        boolean z = false;
        if (!(TextUtils.isEmpty(title) && TextUtils.isEmpty(artist))) {
            String path = MetaManager.getMainSdcardFilePath(title, artist, "lyric");
            try {
                if (MetaManager.makeDirIfNotExists(context, "lyric")) {
                    z = content.persist(path);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return z;
    }
}
