package com.songbirdnest.mediaplayer.viewInterface;

import com.songbirdnest.mediaplayer.listObjects.ListData;

public interface ListAction {
    ListData getItem(int i);

    void getItem(int i, ListData listData);

    void itemClicked(int i);

    Integer listCount();
}
