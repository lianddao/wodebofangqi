package com.songbirdnest.mediaplayer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class Playlist implements Parcelable {
    public static final Creator<Playlist> CREATOR = new C01151();
    public Long mPlaylistId;
    public String mPlaylistVolume;

    static class C01151 implements Creator<Playlist> {
        C01151() {
        }

        public Playlist createFromParcel(Parcel in) {
            return new Playlist(in);
        }

        public Playlist[] newArray(int aSize) {
            return new Playlist[aSize];
        }
    }

    public Playlist() {
        this.mPlaylistId = new Long(-1);
        this.mPlaylistVolume = null;
    }

    public Playlist(Playlist aPlaylist) {
        this.mPlaylistId = new Long(-1);
        this.mPlaylistVolume = null;
        this.mPlaylistId = aPlaylist.mPlaylistId;
        this.mPlaylistVolume = aPlaylist.mPlaylistVolume;
    }

    public Playlist(String aPlaylistVolume, Long aPlaylistId) {
        this.mPlaylistId = new Long(-1);
        this.mPlaylistVolume = null;
        this.mPlaylistId = aPlaylistId;
        this.mPlaylistVolume = aPlaylistVolume;
    }

    private Playlist(Parcel aParcel) {
        this.mPlaylistId = new Long(-1);
        this.mPlaylistVolume = null;
        this.mPlaylistId = Long.valueOf(aParcel.readLong());
        this.mPlaylistVolume = aParcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel aDest, int aFlags) {
        aDest.writeLong(this.mPlaylistId.longValue());
        aDest.writeString(this.mPlaylistVolume);
    }
}
