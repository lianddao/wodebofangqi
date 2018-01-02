package com.miui.player.download;

import android.content.Context;
import android.net.Uri;
import com.miui.player.meta.Audio.AudioDetail;
import com.miui.player.meta.Audio.AudioLink;
import com.miui.player.meta.ImageSearchInfo;
import com.miui.player.meta.LyricSearchInfo;
import java.util.List;

public interface IDownloader {
    public static final String ALBUM_JSON = "album";
    public static final String ARTIST_JSON = "artist";
    public static final String TRACK_JSON = "track";

    public static class CandidateInfo {
        public final AudioLink mAudioLink;
        public final List<AudioLink> mCandidates;
        public final String mDescription;
        public final long mDownloadId;

        public CandidateInfo(long id, AudioLink link, String description, List<AudioLink> candidates) {
            this.mDownloadId = id;
            this.mAudioLink = link;
            this.mDescription = description;
            this.mCandidates = candidates;
        }
    }

    void correctId3(Context context, String str, String str2, boolean z);

    void downloadImageAsync(Context context, String str, ImageSearchInfo imageSearchInfo);

    void downloadLyricAsync(Context context, String str, LyricSearchInfo lyricSearchInfo);

    int markRowDeleted(Context context, long... jArr);

    long[] queryByAppointName(Context context, String str);

    Uri start(Context context, AudioLink audioLink, String str, String str2, String str3, String str4, List<AudioLink> list, boolean z, long j);

    int updateDB(Context context, String str, AudioDetail audioDetail);
}
