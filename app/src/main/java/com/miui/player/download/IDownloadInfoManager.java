package com.miui.player.download;

import android.content.Context;
import com.miui.player.download.IDownloader.CandidateInfo;
import com.miui.player.meta.Audio.AudioLink;
import java.util.List;
import java.util.Map.Entry;

public interface IDownloadInfoManager {
    AudioLink getAudioLink(Context context, String str);

    List<AudioLink> getCandidates(Context context, String str);

    long getDownloadId(Context context, String str);

    Entry<String, CandidateInfo> getDownloadInfoByDownloadId(Context context, long j);

    void register(Context context, String str, long j, AudioLink audioLink, String str2, List<AudioLink> list);

    void unregister(Context context, String str);
}
