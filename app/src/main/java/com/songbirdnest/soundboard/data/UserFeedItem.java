package com.songbirdnest.soundboard.data;

import android.util.Log;
import com.mixpanel.android.mpmetrics.MPDbAdapter;
import com.songbirdnest.stream.StreamUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class UserFeedItem {
    private final String TAG = getClass().getSimpleName();
    protected String mArtistID;
    protected String mArtistName;
    protected FeedImage mCoverImage;
    protected Long mCreatedAt;
    protected String mDescription;
    protected String mID;
    protected boolean mLiked;
    protected String mTitle;
    protected String mType;
    protected String mUrl;

    public UserFeedItem(JSONObject pInput) {
        parseJSON(pInput);
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getArtistID() {
        return this.mArtistID;
    }

    public String getArtistName() {
        return this.mArtistName;
    }

    public String getType() {
        return this.mType;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public FeedImage getCoverImage() {
        return this.mCoverImage;
    }

    public Long getCreatedAt() {
        return this.mCreatedAt;
    }

    public boolean getLiked() {
        return this.mLiked;
    }

    public String getID() {
        return this.mID;
    }

    protected void parseJSON(JSONObject pInput) {
        try {
            if (pInput.has("artist")) {
                JSONObject aArtistObject = pInput.getJSONObject("artist");
                this.mArtistID = StreamUtils.jsonGetString(aArtistObject, "id");
                this.mArtistName = StreamUtils.jsonGetString(aArtistObject, "artist_name");
            }
            this.mType = StreamUtils.jsonGetString(pInput, "type");
            this.mUrl = StreamUtils.jsonGetString(pInput, "url");
            this.mTitle = StreamUtils.jsonGetString(pInput, "title");
            this.mDescription = StreamUtils.jsonGetString(pInput, "description");
            this.mCreatedAt = StreamUtils.jsonGetLong(pInput, MPDbAdapter.KEY_CREATED_AT);
            if (pInput.has("cover_image")) {
                this.mCoverImage = new FeedImage(pInput.getJSONObject("cover_image"));
            }
            if (pInput.has("liked")) {
                this.mLiked = pInput.getBoolean("liked");
            }
            if (pInput.has("id")) {
                this.mID = pInput.getString("id");
            }
        } catch (JSONException e) {
            Log.i(this.TAG, "Issue parsing JSON");
        }
    }

    public boolean equals(Object o) {
        if (o.getClass().equals(UserFeedItem.class)) {
            UserFeedItem aItem = (UserFeedItem) o;
            if (aItem.getArtistID().equals(this.mArtistID) && aItem.mArtistName.equals(this.mArtistName) && aItem.mCoverImage.equals(this.mCoverImage) && aItem.mCreatedAt.equals(this.mCreatedAt) && aItem.getDescription().equals(this.mDescription) && aItem.mTitle.equals(this.mTitle) && aItem.mType.equals(this.mType) && aItem.mUrl.equals(this.mUrl)) {
                return true;
            }
        }
        return false;
    }
}
