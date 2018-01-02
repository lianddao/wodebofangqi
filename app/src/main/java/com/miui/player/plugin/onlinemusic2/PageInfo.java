package com.miui.player.plugin.onlinemusic2;

public class PageInfo {
    public final int mNumPerPage;
    public final int mTotal;

    public PageInfo(int total, int numPerPage) {
        this.mTotal = total;
        this.mNumPerPage = numPerPage;
    }
}
