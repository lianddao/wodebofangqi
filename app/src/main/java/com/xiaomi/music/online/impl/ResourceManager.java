package com.xiaomi.music.online.impl;

import android.content.Context;
import com.xiaomi.music.Result;
import com.xiaomi.music.online.model.ResourceSearchInfo;
import com.xiaomi.music.online.model.ResourceSearchResult;
import java.util.List;

public interface ResourceManager extends CpIds {
    int getId();

    Result<List<ResourceSearchResult>> search(Context context, ResourceSearchInfo resourceSearchInfo);
}
