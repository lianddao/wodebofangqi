package com.songbirdnest.soundboard.data;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Collection implements Comparable<Collection> {
    protected String artistId;
    protected String artistName;
    protected long collected_at;
    protected CollectionBiography collectionBiography = new CollectionBiography();
    protected List<CollectionTrack> collectionTracks = new ArrayList();
    protected String facebook_id;
    protected CollectionImage image = new CollectionImage();
    protected boolean isCollected;
    protected String type_desc;
    protected String user_id;

    public boolean isCollected() {
        return this.isCollected;
    }

    public String getArtistId() {
        return this.artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getFacebookId() {
        return this.facebook_id;
    }

    public void setFacebookId(String facebook_id) {
        this.facebook_id = facebook_id;
    }

    public CollectionImage getImage() {
        return this.image;
    }

    public void setImage(CollectionImage image) {
        this.image = image;
    }

    public CollectionBiography getCollectionBiography() {
        return this.collectionBiography;
    }

    public void setCollectionBiography(CollectionBiography collectionBiography) {
        this.collectionBiography = collectionBiography;
    }

    public List<CollectionTrack> getCollectionTracks() {
        return this.collectionTracks;
    }

    public void setCollectionTracks(List<CollectionTrack> collectionTracks) {
        this.collectionTracks = collectionTracks;
    }

    public String getArtistName() {
        return this.artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getTypeDesc() {
        return this.type_desc;
    }

    public void setTypeDesc(String type_desc) {
        this.type_desc = type_desc;
    }

    public String getUserId() {
        return this.user_id;
    }

    public void setUserId(String user_id) {
        this.user_id = user_id;
    }

    public long getCollectedAt() {
        return this.collected_at;
    }

    public void setCollectedAt(long collected_at) {
        this.collected_at = collected_at;
    }

    public void parseJSON(JSONObject jsonObject) {
        this.artistId = jsonObject.optString("id", null);
        this.facebook_id = jsonObject.optString("facebook_id", null);
        this.image.parseJSON(jsonObject);
        this.collectionBiography.parseJSON(jsonObject);
        this.collectionTracks.clear();
        try {
            if (jsonObject.has("collected")) {
                this.isCollected = jsonObject.getBoolean("collected");
            }
            if (jsonObject.has("collected_at")) {
                this.collected_at = jsonObject.getLong("collected_at");
            }
        } catch (JSONException e1) {
            Log.e("Collection", "Problems parsing Collection", e1);
        }
        if (jsonObject.has("tracks")) {
            try {
                JSONArray tracks = jsonObject.getJSONArray("tracks");
                int size = tracks.length();
                for (int i = 0; i < size; i++) {
                    JSONObject track = tracks.getJSONObject(i);
                    CollectionTrack collectionTrack = new CollectionTrack();
                    collectionTrack.parseJSON(track);
                    this.collectionTracks.add(collectionTrack);
                }
            } catch (JSONException e) {
                Log.e("Collection", "Problems parsing CollectionTrack", e);
            }
        }
        this.artistName = jsonObject.optString("artist_name", null);
        this.type_desc = jsonObject.optString("type_desc", null);
    }

    public int compareTo(Collection another) {
        int aRet = this.collected_at > another.collected_at ? -1 : this.collected_at == another.collected_at ? 0 : 1;
        if (this.collected_at != 0 && another.collected_at == 0) {
            return -1;
        }
        if (this.collected_at != 0 || another.collected_at == 0) {
            return (this.artistName == null || another.artistName == null || aRet != 0) ? aRet : this.artistName.compareTo(another.artistName);
        } else {
            return 1;
        }
    }
}
