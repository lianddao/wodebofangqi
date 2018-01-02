package com.songbirdnest.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FacebookUser implements Parcelable {
    public static final Creator<FacebookUser> CREATOR = new C01031();
    protected String accessToken;
    protected String email;
    protected long expiration;
    protected String id;
    protected String name;
    protected String soundBoardId;

    static class C01031 implements Creator<FacebookUser> {
        C01031() {
        }

        public FacebookUser createFromParcel(Parcel in) {
            FacebookUser FacebookUser = new FacebookUser();
            FacebookUser.readFromParcel(in);
            return FacebookUser;
        }

        public FacebookUser[] newArray(int size) {
            return new FacebookUser[size];
        }
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getExpiration() {
        return this.expiration;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }

    public String getSoundBoardId() {
        return this.soundBoardId;
    }

    public void setSoundBoardId(String soundBoardId) {
        this.soundBoardId = soundBoardId;
    }

    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.accessToken = parcel.readString();
        this.id = parcel.readString();
        this.name = parcel.readString();
        this.email = parcel.readString();
        this.expiration = parcel.readLong();
        this.soundBoardId = parcel.readString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.accessToken);
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.email);
        dest.writeLong(this.expiration);
        dest.writeString(this.soundBoardId);
    }
}
