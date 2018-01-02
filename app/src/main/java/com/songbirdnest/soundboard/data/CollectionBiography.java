package com.songbirdnest.soundboard.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class CollectionBiography implements Parcelable {
    public static final Creator<CollectionBiography> CREATOR = new C04631();
    protected CollectionLicense license = new CollectionLicense();
    protected String site;
    protected String text;
    protected String url;

    static class C04631 implements Creator<CollectionBiography> {
        C04631() {
        }

        public CollectionBiography createFromParcel(Parcel in) {
            CollectionBiography collectionBiography = new CollectionBiography();
            collectionBiography.readFromParcel(in);
            return collectionBiography;
        }

        public CollectionBiography[] newArray(int size) {
            return new CollectionBiography[size];
        }
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSite() {
        return this.site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public CollectionLicense getLicense() {
        return this.license;
    }

    public void setLicense(CollectionLicense license) {
        this.license = license;
    }

    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.text = parcel.readString();
        this.site = parcel.readString();
        this.license.readFromParcel(parcel);
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.text);
        dest.writeString(this.site);
        dest.writeString(this.url);
        this.license.writeToParcel(dest, flags);
    }

    public void parseJSON(JSONObject jsonObject) {
        if (jsonObject.has("biography") && !jsonObject.isNull("biography")) {
            try {
                JSONObject biography = jsonObject.getJSONObject("biography");
                this.text = biography.optString("text", null);
                this.site = biography.optString("site", null);
                if (!biography.isNull("url")) {
                    this.url = biography.optString("url", null);
                }
            } catch (JSONException e) {
                Log.e("CollectionBiography", "Problems parsing CollectionBiography", e);
            }
        }
    }
}
