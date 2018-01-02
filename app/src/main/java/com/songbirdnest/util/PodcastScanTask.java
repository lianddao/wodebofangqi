package com.songbirdnest.util;

import android.content.Context;
import android.os.AsyncTask;
import com.songbirdnest.database.Model.Podcast;
import com.songbirdnest.database.Model.Song;
import com.songbirdnest.mediaplayer.Utils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;

public class PodcastScanTask extends AsyncTask<Context, Integer, Void> {
    WeakReference<Runnable> mOnComplete;

    public PodcastScanTask(Runnable pOnComplete) {
        this.mOnComplete = new WeakReference(pOnComplete);
    }

    protected Void doInBackground(Context... aContexts) {
        try {
            List list = Song.getMisplacedPodcasts(aContexts[0]);
            if (list != null && list.size() > 0) {
                Utils.move(list, Podcast.getSdFolder());
                Utils.scanSd(aContexts[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        Runnable aRet = (Runnable) this.mOnComplete.get();
        if (aRet != null) {
            aRet.run();
        }
    }
}
