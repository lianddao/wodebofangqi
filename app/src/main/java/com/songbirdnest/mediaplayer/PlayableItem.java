package com.songbirdnest.mediaplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PlayableItem implements Parcelable {
    public static final Creator<PlayableItem> CREATOR = new C01141();
    public int mID;
    public int mPlaylistItemID;
    public Uri mStorageUri;
    public String mStorageVolume;

    static class C01141 implements Creator<PlayableItem> {
        C01141() {
        }

        public PlayableItem createFromParcel(Parcel in) {
            return new PlayableItem(in);
        }

        public PlayableItem[] newArray(int aSize) {
            return new PlayableItem[aSize];
        }
    }

    public PlayableItem() {
        this.mID = -1;
        this.mPlaylistItemID = -1;
        this.mStorageUri = Uri.EMPTY;
        this.mStorageVolume = "";
    }

    public PlayableItem(String aStorageVolume, Uri aStorageUri, int aID, int aPlaylistItemID) {
        this.mID = -1;
        this.mPlaylistItemID = -1;
        this.mStorageUri = Uri.EMPTY;
        this.mStorageVolume = "";
        this.mStorageVolume = aStorageVolume;
        this.mStorageUri = aStorageUri;
        this.mID = aID;
        this.mPlaylistItemID = aPlaylistItemID;
    }

    private PlayableItem(Parcel aParcel) {
        this.mID = -1;
        this.mPlaylistItemID = -1;
        this.mStorageUri = Uri.EMPTY;
        this.mStorageVolume = "";
        this.mStorageVolume = aParcel.readString();
        this.mStorageUri = (Uri) aParcel.readParcelable(null);
        this.mID = aParcel.readInt();
        this.mPlaylistItemID = aParcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel aDest, int aFlags) {
        aDest.writeString(this.mStorageVolume);
        aDest.writeParcelable(this.mStorageUri, 0);
        aDest.writeInt(this.mID);
        aDest.writeInt(this.mPlaylistItemID);
    }
}
