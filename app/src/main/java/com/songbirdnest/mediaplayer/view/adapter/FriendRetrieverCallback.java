package com.songbirdnest.mediaplayer.view.adapter;

import android.graphics.Bitmap;
import com.songbirdnest.soundboard.data.Friend;
import java.util.List;

public interface FriendRetrieverCallback {
    void onError(String str, String str2);

    void setFriendImage(String str, Bitmap bitmap);

    void setFriends(List<Friend> list);
}
