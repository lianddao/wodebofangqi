package com.xiaomi.music.cloud.model;

public class DeleteInfo {
    public final boolean mExist;
    public final long mSyncTag;

    private DeleteInfo(long syncTag, boolean exist) {
        this.mSyncTag = syncTag;
        this.mExist = exist;
    }

    public static DeleteInfo create(long syncTag, boolean exist) {
        return new DeleteInfo(syncTag, exist);
    }

    public String toString() {
        return "sync tag=" + this.mSyncTag + "  exist=" + this.mExist;
    }
}
