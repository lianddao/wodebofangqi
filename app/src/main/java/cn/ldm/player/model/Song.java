/*
 * Copyright (C) 2012 Andrew Neal
 * Copyright (C) 2014 The CyanogenMod Project
 * Licensed under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package cn.ldm.player.model;

import android.media.MediaMetadata;
import android.net.Uri;
import android.text.TextUtils;

import cn.ldm.player.tool.MusicTool;

/**
 * A class that represents a song.
 *
 * @author Andrew Neal (andrewdneal@gmail.com)
 */
public class Song {

    /**
     * The unique Id of the song
     */
    public long mSongId;

    /**
     * The song name
     */
    public String mSongName;

    /**
     * The song artist
     */
    public String mArtistName;

    /**
     * The song album
     */
    public String mAlbumName;

    /**
     * The album id
     */
    public long mAlbumId;

    public long mDuration;

    /**
     * The year the song was recorded
     */
    public int mYear;

    /**
     * Bucket label for the name - may not necessarily be the name - for example songs sorted by
     * artists would be the artist bucket label and not the song name bucket label
     */
    public String mBucketLabel;

    public Uri mData;

    /**
     * Constructor of <code>Song</code>
     *
     * @param songId     The Id of the song
     * @param songName   The name of the song
     * @param artistName The song artist
     * @param albumName  The song album
     * @param duration   The duration of a song in seconds
     * @param year       The year the song was recorded
     */
    public Song(final long songId, final String songName, final String artistName,
                final String albumName, final long albumId, final long duration, final int year, final String data) {
        mSongId = songId;
        mSongName = songName;
        mArtistName = artistName;
        mAlbumName = albumName;
        mAlbumId = albumId;
        mDuration = duration;
        mYear = year;
        mData = Uri.parse(data);
    }

    //    public Song(MediaMetadata metadata) {
    //        mSongId = Long.valueOf(metadata.getString(MediaMetadata.METADATA_KEY_MEDIA_ID));
    //        mSongName = metadata.getString(MediaMetadata.METADATA_KEY_DISPLAY_TITLE);
    //        mArtistName = metadata.getString(MediaMetadata.METADATA_KEY_ARTIST);
    //        mAlbumName = metadata.getString(MediaMetadata.METADATA_KEY_ALBUM);
    //        mDuration = MusicTool.getSecond(metadata.getLong(MediaMetadata.METADATA_KEY_DURATION));
    //        mYear = (int) metadata.getLong(MediaMetadata.METADATA_KEY_YEAR);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (mAlbumName == null ? 0 : mAlbumName.hashCode());
        result = prime * result + (int) mAlbumId;
        result = prime * result + (mArtistName == null ? 0 : mArtistName.hashCode());
        result = prime * result + (int) mDuration;
        result = prime * result + (int) mSongId;
        result = prime * result + (mSongName == null ? 0 : mSongName.hashCode());
        result = prime * result + mYear;
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Song other = (Song) obj;
        if (mSongId != other.mSongId) {
            return false;
        }
        if (!TextUtils.equals(mAlbumName, other.mAlbumName)) {
            return false;
        }
        if (mAlbumId != other.mAlbumId) {
            return false;
        }
        if (!TextUtils.equals(mArtistName, other.mArtistName)) {
            return false;
        }
        if (mDuration != other.mDuration) {
            return false;
        }
        if (!TextUtils.equals(mSongName, other.mSongName)) {
            return false;
        }

        if (mYear != other.mYear) {
            return false;
        }

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return mSongName;
    }
}
