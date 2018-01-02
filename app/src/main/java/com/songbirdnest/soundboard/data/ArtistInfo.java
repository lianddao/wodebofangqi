package com.songbirdnest.soundboard.data;

import android.util.Log;
import org.json.JSONObject;

public class ArtistInfo {
    CollectionImage aImage;
    ArtistBiography artistBiography;
    String artistId;
    String artistName;
    boolean isCollected;

    public ArtistInfo(JSONObject pObject) {
        parseJSON(pObject);
    }

    public boolean isCollected() {
        return this.isCollected;
    }

    public String getArtistId() {
        return this.artistId;
    }

    public String getArtistName() {
        return this.artistName;
    }

    public CollectionImage getImage() {
        return this.aImage;
    }

    public ArtistBiography getArtistBiography() {
        return this.artistBiography;
    }

    public void parseJSON(JSONObject pJson) {
        try {
            this.aImage = new CollectionImage();
            this.aImage.parseJSON(pJson);
            if (pJson.has("artist_name")) {
                this.artistName = pJson.getString("artist_name");
            }
            if (pJson.has("collected")) {
                this.isCollected = pJson.getBoolean("collected");
            }
            if (pJson.has("id")) {
                this.artistId = pJson.getString("id");
            }
            if (pJson.has("biography") && !pJson.isNull("biography")) {
                this.artistBiography = new ArtistBiography(pJson.getJSONObject("biography"));
            }
        } catch (Exception e) {
            Log.e(getClass().getSimpleName(), "Error parsing JSON \n" + pJson.toString(), e);
        }
    }
}
