package com.songbirdnest.soundboard.data;

import android.util.Log;
import org.json.JSONObject;

public class ArtistBiography {
    private String license;
    private String site;
    private String text;
    private String url;

    public ArtistBiography(JSONObject pObject) {
        parseJSON(pObject);
    }

    public String getLicense() {
        return this.license;
    }

    public String getSite() {
        return this.site;
    }

    public String getText() {
        return this.text;
    }

    public String getUrl() {
        return this.url;
    }

    public void parseJSON(JSONObject pJson) {
        try {
            if (pJson.has("license")) {
                this.license = pJson.getJSONObject("license").toString();
            }
            if (pJson.has("site")) {
                this.site = pJson.getString("site");
            }
            if (pJson.has("text")) {
                this.text = pJson.getString("text");
            }
            if (pJson.has("url")) {
                this.url = pJson.getString("url");
            }
        } catch (Exception e) {
            Log.e(getClass().getSimpleName(), "Error parsing JSON \n" + pJson.toString(), e);
        }
    }
}
