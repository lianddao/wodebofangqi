package com.xiaomi.music.online.impl;

import android.content.Context;
import com.xiaomi.music.Result;
import com.xiaomi.music.online.impl.provider.baidu.BaiduSongLinkManager;
import com.xiaomi.music.online.model.SongLink;
import com.xiaomi.music.util.NetworkUtil;
import com.xiaomi.music.util.Numbers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongLinkEngine {
    private static final Object CACHE_LOCK = new Object();
    private static final Object LOCK = new Object();
    private static SongLinkEngine sEngine;
    private final Map<String, SongLinkManager> managers = new HashMap();

    public static SongLinkEngine getInstance() {
        synchronized (LOCK) {
            if (sEngine == null) {
                sEngine = new SongLinkEngine();
            }
        }
        return sEngine;
    }

    private SongLinkManager getMusicLinkManager(String cpId) {
        SongLinkManager manager;
        synchronized (CACHE_LOCK) {
            manager = (SongLinkManager) this.managers.get(cpId);
        }
        if (manager == null) {
            manager = newMusicLinkManager(cpId);
            if (manager != null) {
                synchronized (CACHE_LOCK) {
                    this.managers.put(cpId, manager);
                }
            }
        }
        return manager;
    }

    private SongLinkManager newMusicLinkManager(String cpId) {
        switch (Numbers.toInt(cpId, 0)) {
            case 1:
                return new BaiduSongLinkManager();
            default:
                return null;
        }
    }

    private SongLinkEngine() {
    }

    public Result<List<SongLink>> getMusicLinks(Context context, String cpId, String cpSongId, int bitRate) {
        if (!NetworkUtil.isNetworkAllow()) {
            return Result.create(-5);
        }
        List<SongLink> list = null;
        int errorCode = -1;
        SongLinkManager manager = getMusicLinkManager(cpId);
        if (manager != null) {
            Result<List<SongLink>> links = manager.getMusicLinks(context, cpSongId, bitRate);
            if (links.mErrorCode == 1) {
                errorCode = 1;
                list = links.mData;
            }
        }
        return Result.create(errorCode, list);
    }
}
