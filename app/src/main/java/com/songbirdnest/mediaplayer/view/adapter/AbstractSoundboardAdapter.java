package com.songbirdnest.mediaplayer.view.adapter;

import android.widget.BaseAdapter;

public abstract class AbstractSoundboardAdapter extends BaseAdapter {
    public abstract void refreshDownload();

    public abstract void setServerError(boolean z);
}
