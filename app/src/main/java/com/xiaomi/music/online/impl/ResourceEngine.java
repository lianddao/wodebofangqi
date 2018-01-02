package com.xiaomi.music.online.impl;

import android.content.Context;
import com.google.android.collect.Lists;
import com.xiaomi.music.Result;
import com.xiaomi.music.online.impl.provider.baidu.BaiduResource;
import com.xiaomi.music.online.impl.provider.xiaomi.MiResourceManager;
import com.xiaomi.music.online.model.ResourceSearchInfo;
import com.xiaomi.music.online.model.ResourceSearchResult;
import com.xiaomi.music.util.NetworkUtil;
import java.util.Collection;
import java.util.List;

public class ResourceEngine {
    private static final Object LOCK = new Object();
    private static ResourceEngine sEngine;
    private final List<ResourceManager> managers = Lists.newArrayList();

    public static ResourceEngine getInstance() {
        synchronized (LOCK) {
            if (sEngine == null) {
                sEngine = new ResourceEngine();
            }
        }
        return sEngine;
    }

    private List<ResourceManager> getAllResourceManager() {
        return this.managers;
    }

    private ResourceEngine() {
        this.managers.add(MiResourceManager.instance());
        this.managers.add(BaiduResource.instance());
    }

    public Result<List<ResourceSearchResult>> search(Context context, ResourceSearchInfo searchinfo) {
        if (!NetworkUtil.isNetworkAllow()) {
            return Result.create(-5);
        }
        List<ResourceSearchResult> list = Lists.newArrayList();
        int errorCode = -1;
        for (ResourceManager manager : getAllResourceManager()) {
            Result<List<ResourceSearchResult>> searchResult = manager.search(context, searchinfo);
            if (searchResult.mErrorCode == 1) {
                errorCode = 1;
                if (searchResult.mData != null) {
                    list.addAll((Collection) searchResult.mData);
                }
            }
        }
        return Result.create(errorCode, list);
    }
}
