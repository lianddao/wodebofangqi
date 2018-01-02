package com.miui.player.network;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import com.miui.player.C0329R;
import com.miui.player.meta.MediaFileManager;
import com.miui.player.meta.MetaManager;
import com.miui.player.plugin.onlinemusic2.AudioID3Info;
import com.miui.player.provider.StatisticsHelper;
import com.miui.player.util.PreferenceCache;
import com.miui.player.util.Utils;
import com.xiaomi.music.util.NetworkUtil;
import java.io.File;

public class ID3Correcter {
    private static final String TAG = ID3Correcter.class.getName();

    public static class AsyncCorrectID3Task extends AsyncTask<Void, Void, Boolean> {
        private final long[] mAudioIdList;
        private final Context mContext;
        private final boolean mForceCorrect;
        private final boolean mNeedToast;
        private final String[] mPathList;

        public AsyncCorrectID3Task(Context context, String[] pathList, long[] audioIdList, boolean forceCorrect, boolean needToast) {
            this.mContext = context;
            this.mPathList = pathList;
            this.mAudioIdList = audioIdList;
            this.mForceCorrect = forceCorrect;
            this.mNeedToast = needToast;
        }

        public boolean isFirstTrackPathEquals(String path) {
            if (this.mPathList == null || this.mPathList.length == 0 || this.mPathList[0] == null) {
                return false;
            }
            return this.mPathList[0].equals(path);
        }

        protected void onPreExecute() {
            if (this.mNeedToast) {
                Toast.makeText(this.mContext, C0329R.string.correct_id3_start, 0).show();
            }
        }

        protected Boolean doInBackground(Void... params) {
            boolean isCorrected = false;
            try {
                int len = this.mAudioIdList.length;
                for (int i = 0; i < len; i++) {
                    long audioId = this.mAudioIdList[i];
                    String trackPath = this.mPathList[i];
                    if (Utils.isSupportID3(trackPath) && (this.mForceCorrect || !StatisticsHelper.queryIsCorrectedID3(this.mContext, audioId))) {
                        isCorrected |= ID3Correcter.correctID3(this.mContext, trackPath, audioId);
                    }
                }
            } catch (Exception e) {
                Log.e(ID3Correcter.TAG, MetaManager.UNKNOWN_STRING, e);
            }
            return Boolean.valueOf(isCorrected);
        }

        protected void onPostExecute(Boolean isCorrected) {
            super.onPostExecute(isCorrected);
            if (!this.mNeedToast) {
                return;
            }
            if (this.mAudioIdList.length > 1) {
                Toast.makeText(this.mContext, C0329R.string.batch_correct_id3_completed, 0).show();
            } else if (isCorrected.booleanValue()) {
                Toast.makeText(this.mContext, C0329R.string.correct_id3_success, 0).show();
            } else {
                Toast.makeText(this.mContext, C0329R.string.correct_id3_failed, 0).show();
            }
        }
    }

    private static boolean correctID3(Context context, String trackPath, long audioId) {
        AudioID3Info audioID3Info = OnlineMusicProxy.queryAudioID3(context, trackPath);
        if (audioID3Info == null) {
            return false;
        }
        return MediaFileManager.correctID3(context, new File(trackPath), audioID3Info.mTitle, audioID3Info.mArtistName, audioID3Info.mAlbumName, true);
    }

    public static boolean isNetworkActive(Context context, boolean needToast) {
        if (NetworkUtil.isActive(context)) {
            if (!NetworkUtil.isActiveNetworkMetered(context) || PreferenceCache.getPrefAsBoolean(context, PreferenceCache.PREF_CORRECT_ID3_SETTINGS)) {
                return true;
            }
            if (!needToast) {
                return false;
            }
            Toast.makeText(context, C0329R.string.correct_id3_open_other_connect, 0).show();
            return false;
        } else if (!needToast) {
            return false;
        } else {
            Toast.makeText(context, C0329R.string.network_error, 0).show();
            return false;
        }
    }

    public static AsyncCorrectID3Task startTaskForID3Correct(Context context, String[] trackPaths, long[] localIds, boolean forceCorrect, boolean needToast) {
        if (trackPaths.length == 1 && !Utils.isSupportID3(trackPaths[0])) {
            Toast.makeText(context, C0329R.string.correct_id3_not_support, 0).show();
            return null;
        } else if (!isNetworkActive(context, true)) {
            return null;
        } else {
            AsyncCorrectID3Task task = new AsyncCorrectID3Task(context, trackPaths, localIds, forceCorrect, needToast);
            task.execute(new Void[0]);
            return task;
        }
    }
}
