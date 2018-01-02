package com.xiaomi.music.cloud.model;

import java.util.List;

public class OperationList extends MetaList<CloudObject<?>> {
    private final String mSyncExtraInfo;

    private OperationList(List<? extends CloudObject<?>> items, String tag, boolean lastPage, String syncExtraInfo) {
        super(items, tag, lastPage);
        this.mSyncExtraInfo = syncExtraInfo;
    }

    public static OperationList create(List<? extends CloudObject<?>> items, String tag, boolean lastPage, String syncExtraInfo) {
        return new OperationList(items, tag, lastPage, syncExtraInfo);
    }

    public String getSyncExtraInfo() {
        return this.mSyncExtraInfo;
    }
}
