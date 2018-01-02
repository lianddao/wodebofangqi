package com.songbirdnest.soundboard.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class CollectionTrack implements Parcelable {
    public static final Creator<CollectionTrack> CREATOR = new C04651();
    protected String artist;
    protected long duration;
    protected String purchase_url;
    protected String release;
    protected String title;
    protected String url;

    static class C04651 implements Creator<CollectionTrack> {
        C04651() {
        }

        public CollectionTrack createFromParcel(Parcel in) {
            CollectionTrack collectionTrack = new CollectionTrack();
            collectionTrack.readFromParcel(in);
            return collectionTrack;
        }

        public CollectionTrack[] newArray(int size) {
            return new CollectionTrack[size];
        }
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getRelease() {
        return this.release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPurchase_url() {
        return this.purchase_url;
    }

    public void setPurchase_url(String purchase_url) {
        this.purchase_url = purchase_url;
    }

    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.title = parcel.readString();
        this.artist = parcel.readString();
        this.release = parcel.readString();
        this.url = parcel.readString();
        this.purchase_url = parcel.readString();
        this.duration = parcel.readLong();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.artist);
        dest.writeString(this.release);
        dest.writeString(this.url);
        dest.writeString(this.purchase_url);
        dest.writeLong(this.duration);
    }

    public void parseJSON(JSONObject jsonObject) {
        this.title = jsonObject.optString("title", null);
        this.artist = jsonObject.optString("artist", null);
        this.release = jsonObject.optString("release", null);
        this.url = jsonObject.optString("url", null);
        this.purchase_url = jsonObject.optString("purchase_url", null);
        this.duration = jsonObject.optLong("duration", 0);
    }
}
