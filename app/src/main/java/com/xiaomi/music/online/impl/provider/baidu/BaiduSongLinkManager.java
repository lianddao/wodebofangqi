package com.xiaomi.music.online.impl.provider.baidu;

import android.content.Context;
import com.baidu.music.model.Music;
import com.baidu.music.model.MusicFile;
import com.google.android.collect.Lists;
import com.xiaomi.music.Result;
import com.xiaomi.music.online.impl.SongLinkManager;
import com.xiaomi.music.online.model.SongLink;
import com.xiaomi.music.util.Numbers;
import java.util.List;

public class BaiduSongLinkManager implements SongLinkManager {
    private static final int DEFAULT_URL_TYPE = 1;

    private static class BaiduSongLink implements SongLink {
        private final String mAudioId;
        private final int mBitRate;
        private final String mUrl;

        public BaiduSongLink(String url, String audioId, int bitRate) {
            this.mUrl = url;
            this.mAudioId = audioId;
            this.mBitRate = bitRate;
        }

        public String getUrl() {
            return this.mUrl;
        }

        public String getAudioId() {
            return this.mAudioId;
        }

        public int getBitrate() {
            return this.mBitRate;
        }
    }

    public Result<List<SongLink>> getMusicLinks(Context context, String cpSongId, int bitRate) {
        int errorCode = -1;
        List<SongLink> list = Lists.newArrayList();
        Music music = BaiduEngine.get(context).getMusicManager(context).getMusicSync(Long.parseLong(cpSongId), 1, Integer.toString(bitRate));
        if (music != null) {
            errorCode = 1;
            for (MusicFile file : music.getItems()) {
                list.add(new BaiduSongLink(file.mFileLink, music.mId, Numbers.toInt(file.mFileBitrate, 128)));
            }
        }
        return Result.create(errorCode, list);
    }
}
