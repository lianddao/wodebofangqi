package com.songbirdnest.facebook.util;

import android.os.Handler;
import java.util.ArrayList;

public class ImageBackend {
    Handler mHandler;
    ArrayList<Long> mIdList = new ArrayList();
    ArrayList<String> mNameList = new ArrayList();

    public ImageBackend(Handler pHandler) {
        this.mHandler = pHandler;
    }

    public void addId(Long pId) {
        this.mIdList.add(pId);
    }

    public int getListCount() {
        return this.mIdList.size();
    }

    public void addName(String pName) {
        this.mNameList.add(pName);
    }

    public String[] getArray(int pPosition) {
        return new String[]{Long.toString(((Long) this.mIdList.get(pPosition)).longValue()), (String) this.mNameList.get(pPosition)};
    }

    public void updateDone() {
        this.mHandler.sendEmptyMessage(3);
    }
}
