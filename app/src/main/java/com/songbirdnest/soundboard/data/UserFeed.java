package com.songbirdnest.soundboard.data;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class UserFeed {
    List<UserFeedItem> mFeedItems;

    public UserFeed(JSONArray pJSONArray) {
        parseJSON(pJSONArray);
    }

    public void addFeedItems(JSONArray pJSONArray) {
        parseJSON(pJSONArray);
    }

    public int getItemCount() {
        if (this.mFeedItems == null) {
            return 0;
        }
        return this.mFeedItems.size();
    }

    public UserFeedItem getItem(int pItem) {
        if (pItem > this.mFeedItems.size()) {
            return null;
        }
        return (UserFeedItem) this.mFeedItems.get(pItem);
    }

    protected void parseJSON(JSONArray pJSONArray) {
        if (this.mFeedItems == null) {
            this.mFeedItems = new ArrayList();
        }
        for (int i = 0; i < pJSONArray.length(); i++) {
            try {
                this.mFeedItems.add(new UserFeedItem(pJSONArray.getJSONObject(i)));
            } catch (JSONException ex) {
                Log.e(getClass().getSimpleName(), "Failed parsing JSON", ex);
            }
        }
    }
}
