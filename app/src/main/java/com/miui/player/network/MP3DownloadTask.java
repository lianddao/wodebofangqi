package com.miui.player.network;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;
import android.widget.Toast;
import com.miui.player.C0329R;
import com.miui.player.meta.Audio;
import com.miui.player.meta.Audio.AudioDetail;
import com.miui.player.meta.Audio.AudioLink;
import com.miui.player.provider.OnlineAudioDetailHelper;
import com.miui.player.ui.UIHelper;
import com.miui.player.util.CollectionHelper;
import com.miui.player.util.StorageConfig;
import java.util.List;

public class MP3DownloadTask extends AsyncTask<Void, Void, Void> {
    private Context mContext;
    private List<Audio> mList;
    private int mQuality;
    private Runnable mRunOnStartDownload;

    public MP3DownloadTask(Context context, List<Audio> list, int quality, Runnable runOnStartDownload) {
        this.mContext = context.getApplicationContext();
        this.mList = list;
        this.mQuality = quality;
        this.mRunOnStartDownload = runOnStartDownload;
    }

    protected void onPreExecute() {
        if (this.mList.size() > 1) {
            Toast.makeText(this.mContext, C0329R.string.download_batch_start, 0).show();
        }
    }

    protected Void doInBackground(Void... params) {
        for (int i = 0; i < this.mList.size(); i++) {
            Audio audio = (Audio) this.mList.get(i);
            String cpSongId = audio.getCpSongId();
            if (cpSongId == null) {
                cpSongId = OnlineAudioDetailHelper.queryCpSongId(this.mContext, audio.getId());
            }
            if (DownloadInfoManager.startRequestAudioLink(audio.getId())) {
                Pair<AudioDetail, List<AudioLink>> pair;
                List<AudioLink> links = audio.mAudioLinks;
                int bitRate = StorageConfig.getMusicBitRate(this.mQuality);
                if (links == null || CollectionHelper.isEmpty(links) || ((AudioLink) links.get(0)).mBitrate != bitRate) {
                    pair = OnlineMusicProxy.requestAudioDetail(this.mContext, cpSongId, bitRate, null, 2);
                } else {
                    pair = Pair.create(audio.mDetail, audio.mAudioLinks);
                }
                DownloadInfoManager.finishRequestAudioLink(audio.getId());
                if (pair != null) {
                    boolean toast;
                    if (pair.first != null) {
                        audio.mDetail = (AudioDetail) pair.first;
                    }
                    if (this.mList.size() == 1) {
                        toast = true;
                    } else {
                        toast = false;
                    }
                    if (pair.second != null && !((List) pair.second).isEmpty() && ((AudioLink) ((List) pair.second).get(0)).mBitrate == bitRate) {
                        audio.mAudioLinks = (List) pair.second;
                        if (toast) {
                            UIHelper.toastSafe(C0329R.string.download_processing, new Object[0]);
                        }
                        MP3Downloader.startOnUIThread(this.mContext, audio, this.mQuality);
                    } else if (toast) {
                        UIHelper.toastSafe(C0329R.string.no_song_downloaded, new Object[0]);
                    }
                }
                publishProgress(new Void[0]);
            }
        }
        return null;
    }

    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        if (this.mRunOnStartDownload != null) {
            this.mRunOnStartDownload.run();
        }
    }
}
