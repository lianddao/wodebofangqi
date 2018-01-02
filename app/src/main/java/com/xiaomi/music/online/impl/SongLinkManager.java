package com.xiaomi.music.online.impl;

import android.content.Context;
import com.xiaomi.music.Result;
import com.xiaomi.music.online.model.SongLink;
import java.util.List;

public interface SongLinkManager {
    public static final int ID_BAIDU = 1;

    Result<List<SongLink>> getMusicLinks(Context context, String str, int i);
}
