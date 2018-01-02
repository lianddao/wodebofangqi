package com.songbirdnest.soundboard.data;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class ArtistFeed {
    protected static final String TAG = ArtistFeed.class.getSimpleName();
    protected String description;
    protected int imageHeight;
    protected String imageSource;
    protected int imageWidth;
    protected String title;
    protected String type;
    protected String url;

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImageSource() {
        return this.imageSource;
    }

    public void parseJSON(JSONObject aObject) {
        try {
            if (aObject.has("description")) {
                this.description = aObject.getString("description");
            }
            if (aObject.has("type")) {
                this.type = aObject.getString("type");
            }
            if (aObject.has("url")) {
                this.url = aObject.getString("url");
            }
            if (aObject.has("title")) {
                this.title = aObject.getString("title");
            }
            if (aObject.has("cover_image")) {
                JSONObject aCover = aObject.getJSONObject("cover_image");
                this.imageSource = aCover.getString("src");
                this.imageHeight = aCover.getInt("height");
                this.imageWidth = aCover.getInt("width");
            }
        } catch (JSONException e) {
            Log.e(TAG, "Error in parse", e);
        }
    }
}
