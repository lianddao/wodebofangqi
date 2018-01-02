package com.songbirdnest.soundboard.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CollectionLicense implements Parcelable {
    public static final Creator<CollectionLicense> CREATOR = new C04641();
    protected String attribution;
    protected String attribution_url;
    protected String type;
    protected String url;
    protected String version;

    static class C04641 implements Creator<CollectionLicense> {
        C04641() {
        }

        public CollectionLicense createFromParcel(Parcel in) {
            CollectionLicense collectionLicense = new CollectionLicense();
            collectionLicense.readFromParcel(in);
            return collectionLicense;
        }

        public CollectionLicense[] newArray(int size) {
            return new CollectionLicense[size];
        }
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAttribution() {
        return this.attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    public String getAttribution_url() {
        return this.attribution_url;
    }

    public void setAttribution_url(String attribution_url) {
        this.attribution_url = attribution_url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.type = parcel.readString();
        this.attribution = parcel.readString();
        this.attribution_url = parcel.readString();
        this.url = parcel.readString();
        this.version = parcel.readString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeString(this.attribution);
        dest.writeString(this.attribution_url);
        dest.writeString(this.url);
        dest.writeString(this.version);
    }
}
