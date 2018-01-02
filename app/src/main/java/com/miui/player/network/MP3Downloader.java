package com.miui.player.network;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask.Status;
import android.widget.Toast;
import com.miui.player.C0329R;
import com.miui.player.download.DownloadProviderProxy;
import com.miui.player.meta.Audio;
import com.miui.player.meta.Audio.AudioLink;
import com.miui.player.meta.MediaFileManager;
import com.miui.player.meta.MetaManager;
import com.miui.player.plugin.onlinemusic2.AudioList;
import com.miui.player.ui.controller.QualityAlert;
import com.miui.player.ui.controller.QualityAlert.OnQualitySelectedListener;
import com.miui.player.util.CollectionHelper;
import com.miui.player.util.StorageConfig;
import com.miui.player.util.Utils;
import com.xiaomi.music.util.NetworkUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class MP3Downloader {
    public static final String ALBUM_JSON = "album";
    public static final String ARTIST_JSON = "artist";
    public static final String TRACK_JSON = "track";

    public static boolean startOnUIThread(Activity activity, Audio audio, Runnable runOnStartDownload) {
        if (audio == null) {
            return false;
        }
        ArrayList<Audio> list = new ArrayList();
        list.add(audio);
        startOnUIThread(activity, new AudioList(list), runOnStartDownload);
        return true;
    }

    public static void startOnUIThread(final Activity activity, final AudioList audioList, final Runnable runOnStartDownload) {
        Audio audio = (audioList == null || audioList.size() != 1) ? null : (Audio) audioList.get(0);
        QualityAlert.show(activity, true, -1, audio, new OnQualitySelectedListener() {
            public void onSelected(int quality, boolean allow) {
                if (allow && quality >= 0) {
                    MP3Downloader.startOnUIThread(activity, audioList, quality, runOnStartDownload);
                }
            }
        }, "下载");
    }

    private static void startOnUIThread(Context context, AudioList audioList, int quality, Runnable runOnStartDownload) {
        if (!NetworkUtil.isActive(context)) {
            Toast.makeText(context, C0329R.string.network_error, 0).show();
        } else if (audioList == null || !audioList.isValid()) {
            Toast.makeText(context, C0329R.string.no_song_downloaded, 0).show();
        } else if (Utils.isExternalStorageMounted()) {
            List<Audio> list = getUnDownloadList(context, audioList.getContent());
            int size = list.size();
            if (size == 0) {
                Toast.makeText(context, C0329R.string.no_song_downloaded, 0).show();
                return;
            }
            final MP3DownloadTask task = new MP3DownloadTask(context, list, quality, runOnStartDownload);
            if (size == 1) {
                task.execute(new Void[0]);
                return;
            }
            new Builder(context).setCancelable(true).setTitle(C0329R.string.download).setNegativeButton(C0329R.string.cancel, null).setPositiveButton(C0329R.string.confirm, new OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    if (task.getStatus() == Status.PENDING) {
                        task.execute(new Void[0]);
                    }
                }
            }).setMessage(context.getResources().getQuantityString(C0329R.plurals.NTrackstoDownload, size, new Object[]{Integer.valueOf(size)})).create().show();
        }
    }

    private static List<Audio> getUnDownloadList(Context context, List<Audio> audioList) {
        String[] downloadedFileSet = MetaManager.getAllSortedDownloadedMP3Names();
        ArrayList<Audio> arraryList = new ArrayList();
        for (int i = 0; i < audioList.size(); i++) {
            Audio audio = (Audio) audioList.get(i);
            if (DownloadInfoManager.getDownloadStatus(context, audio.mOutline.mId, audio.mOutline.mTitle, audio.getArtistName(), downloadedFileSet) == 0) {
                arraryList.add(audio);
            }
        }
        return arraryList;
    }

    public static boolean startOnUIThread(Context context, Audio item, int quality) {
        ArrayList<AudioLink> linkList = getCandidateInfo(item.mAudioLinks);
        if (linkList == null) {
            return false;
        }
        if (!DownloadInfoManager.isAudioLinkRequested(item.getId())) {
            if (!DownloadInfoManager.isDownloading(context, item.getId())) {
                String tr = item.getTitle();
                String ar = item.getArtistName();
                if (ar == null) {
                    ar = MetaManager.UNKNOWN_STRING;
                }
                String al = item.getAlbumName();
                if (al == null) {
                    al = MetaManager.UNKNOWN_STRING;
                }
                String musicType = StorageConfig.getMusicType(((AudioLink) MetaManager.getAudioLink(linkList, quality).get(0)).mBitrate);
                String appointName = MetaManager.getMetaFileName(tr, ar, musicType);
                if (appointName == null) {
                    return false;
                }
                File dir = MetaManager.getMetaDir(musicType);
                if (dir == null) {
                    return false;
                }
                if (new File(dir, appointName).exists()) {
                    return false;
                }
                return DownloadProviderProxy.start(context, (AudioLink) linkList.get(0), item.getId(), getDetails(tr, ar, al).toString(), appointName, dir.getAbsolutePath(), linkList.subList(1, linkList.size())) != null;
            }
        }
        return false;
    }

    private static ArrayList<AudioLink> getCandidateInfo(List<AudioLink> links) {
        if (CollectionHelper.isEmpty(links)) {
            return null;
        }
        ArrayList<AudioLink> candidates = new ArrayList(links.size());
        for (AudioLink link : links) {
            if (!(link == null || link.mURL == null)) {
                candidates.add(link);
            }
        }
        return candidates.size() > 0 ? candidates : null;
    }

    public static void correctId3(Context context, String appointName, String details, boolean forceScan) {
        if (details != null && appointName != null) {
            try {
                JSONObject json = new JSONObject(details);
                String album = json.getString("album");
                String artist = json.getString("artist");
                String track = json.getString("track");
                File file = MetaManager.getSavedMetaFile(appointName, StorageConfig.META_TYPE_MP3);
                if (file != null && file.exists()) {
                    MediaFileManager.correctID3(context, file, track, artist, album, forceScan);
                }
            } catch (JSONException e) {
            }
        }
    }

    private static String getDetails(String tr, String ar, String al) {
        JSONObject details = new JSONObject();
        try {
            details.put("album", al);
            details.put("artist", ar);
            details.put("track", tr);
        } catch (JSONException e) {
        }
        return details.toString();
    }
}
