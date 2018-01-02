package com.xiaomi.music.cloud.model;

import com.google.android.collect.Lists;
import java.util.Collections;
import java.util.List;

public abstract class MetaList<T> {
    protected List<T> mItems = Lists.newArrayList();
    protected boolean mLastPage;
    protected String mTag;

    public MetaList(List<? extends T> items, String tag, boolean lastPage) {
        this.mLastPage = lastPage;
        this.mTag = tag;
        if (items != null) {
            this.mItems.addAll(items);
        }
    }

    public List<T> getItems() {
        return Collections.unmodifiableList(this.mItems);
    }

    public boolean isLastPage() {
        return this.mLastPage;
    }

    public String getSyncTag() {
        return this.mTag;
    }

    public void append(MetaList<T> list) {
        this.mItems.addAll(list.mItems);
        this.mTag = list.mTag;
        this.mLastPage = list.mLastPage;
    }
}
