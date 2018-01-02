package com.songbirdnest.mediaplayer.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.songbirdnest.mediaplayer.PlayableItem;
import java.util.ArrayList;
import java.util.List;

public class PlayQueueDatabase {
    public static final String PQ_DB_NAME = "playqueue@db.songbirdnest.com";
    public static final String PQ_PLAYABLE_ITEM_ID = "playableItemId";
    public static final String PQ_PLAYABLE_ITEM_STORAGE_URI = "playableItemStorageURI";
    public static final String PQ_PLAYABLE_ITEM_STORAGE_VOLUME = "playableItemStorageVolume";
    public static final String PQ_SHUFFLED_TABLE = "shuffledQueue";
    public static final String PQ_STATE_ITEM_ID = "playableItemId";
    public static final String PQ_STATE_ITEM_PLAYBACK_POSITION = "playableItemPlaybackPosition";
    public static final String PQ_STATE_ITEM_POSITION = "playableItemPositionInList";
    public static final String PQ_STATE_ITEM_STORAGE_URI = "playableItemStorageURI";
    public static final String PQ_STATE_ITEM_STORAGE_VOLUME = "playableItemStorageVolume";
    public static final String PQ_STATE_TABLE = "queueState";
    public static final String PQ_TABLE = "queue";
    private Context mContext = null;
    private PlayableItem mCurrentItem = new PlayableItem("<UNKNOWN>", null, -1, -1);
    private int mCurrentItemPlaybackPosition = -1;
    private int mCurrentItemPosition = -1;
    private SQLiteDatabase mDB = null;

    public PlayQueueDatabase(Context aContext) {
        this.mContext = aContext;
    }

    public void clear() {
        if (init()) {
            this.mDB.beginTransaction();
            try {
                this.mDB.execSQL("DELETE FROM queue");
                this.mDB.execSQL("DELETE FROM shuffledQueue");
                this.mDB.execSQL("DELETE FROM queueState");
                this.mDB.setTransactionSuccessful();
            } finally {
                this.mDB.endTransaction();
            }
        }
    }

    public void close() {
        if (this.mDB != null && this.mDB.isOpen()) {
            this.mDB.close();
        }
    }

    public int saveQueueFromPlayableList(List<PlayableItem> aPlayableList, List<PlayableItem> aShuffledPlayableList, PlayableItem aPlayableItem, int aPlayableItemPositionInList, int aPlayableItemPlaybackPosition) {
        int i = -1;
        if (init() && aPlayableList != null && aPlayableItem != null && aPlayableItemPositionInList >= 0) {
            clear();
            this.mDB.beginTransaction();
            i = 0;
            try {
                ContentValues values;
                for (PlayableItem item : aPlayableList) {
                    values = new ContentValues();
                    values.put("playableItemId", Integer.valueOf(item.mID));
                    values.put("playableItemStorageVolume", item.mStorageVolume);
                    if (item.mStorageUri != null) {
                        values.put("playableItemStorageURI", item.mStorageUri.toString());
                    }
                    if (this.mDB.insert(PQ_TABLE, null, values) != -1) {
                        i++;
                    }
                }
                this.mDB.setTransactionSuccessful();
                if (aShuffledPlayableList != null) {
                    this.mDB.beginTransaction();
                    try {
                        for (PlayableItem item2 : aShuffledPlayableList) {
                            values = new ContentValues();
                            values.put("playableItemId", Integer.valueOf(item2.mID));
                            values.put("playableItemStorageVolume", item2.mStorageVolume);
                            if (item2.mStorageUri != null) {
                                values.put("playableItemStorageURI", item2.mStorageUri.toString());
                            }
                            this.mDB.insert(PQ_SHUFFLED_TABLE, null, values);
                        }
                        this.mDB.setTransactionSuccessful();
                    } finally {
                        this.mDB.endTransaction();
                    }
                }
                updateQueuePosition(aPlayableItem, aPlayableItemPositionInList, aPlayableItemPlaybackPosition);
            } finally {
                this.mDB.endTransaction();
            }
        }
        return i;
    }

    public boolean updateQueuePosition(PlayableItem aPlayableItem, int aPlayableItemPositionInList, int aPlayableItemPlaybackPosition) {
        if (!init()) {
            return false;
        }
        this.mDB.execSQL("DELETE FROM queueState");
        if (aPlayableItem == null) {
            return false;
        }
        ContentValues values = new ContentValues();
        values.put("playableItemId", Integer.valueOf(aPlayableItem.mID));
        values.put("playableItemStorageVolume", aPlayableItem.mStorageVolume);
        values.put("playableItemStorageURI", aPlayableItem.mStorageUri != null ? aPlayableItem.mStorageUri.toString() : "");
        values.put(PQ_STATE_ITEM_POSITION, Integer.valueOf(aPlayableItemPositionInList));
        values.put(PQ_STATE_ITEM_PLAYBACK_POSITION, Integer.valueOf(aPlayableItemPlaybackPosition));
        this.mCurrentItem = aPlayableItem;
        this.mCurrentItemPosition = aPlayableItemPositionInList;
        this.mCurrentItemPlaybackPosition = aPlayableItemPlaybackPosition;
        this.mDB.insert(PQ_STATE_TABLE, null, values);
        return true;
    }

    public List<PlayableItem> getSavedQueue() {
        return getSavedQueueFromTable(PQ_TABLE);
    }

    public List<PlayableItem> getSavedShuffledQueue() {
        return getSavedQueueFromTable(PQ_SHUFFLED_TABLE);
    }

    private List<PlayableItem> getSavedQueueFromTable(String aTable) {
        if (!init()) {
            return null;
        }
        Cursor c = this.mDB.query(aTable, new String[]{"playableItemId", "playableItemStorageVolume", "playableItemStorageURI"}, null, null, null, null, null);
        int idColumn = c.getColumnIndex("playableItemId");
        int storageVolumeColumn = c.getColumnIndex("playableItemStorageVolume");
        int storageUriColumn = c.getColumnIndex("playableItemStorageURI");
        List<PlayableItem> playableList = new ArrayList(c.getCount());
        while (c.moveToNext()) {
            int itemId = c.getInt(idColumn);
            playableList.add(new PlayableItem(c.getString(storageVolumeColumn), Uri.parse(c.getString(storageUriColumn)), itemId, -1));
        }
        c.close();
        this.mCurrentItem = getCurrentItem();
        return playableList;
    }

    public PlayableItem getCurrentItem() {
        if (!init()) {
            return null;
        }
        if (this.mCurrentItem.mStorageUri != null) {
            return this.mCurrentItem;
        }
        Cursor c = this.mDB.query(PQ_STATE_TABLE, new String[]{"playableItemId", "playableItemStorageVolume", "playableItemStorageURI", PQ_STATE_ITEM_POSITION, PQ_STATE_ITEM_PLAYBACK_POSITION}, null, null, null, null, null);
        if (c.moveToNext()) {
            PlayableItem item = new PlayableItem(c.getString(c.getColumnIndex("playableItemStorageVolume")), Uri.parse(c.getString(c.getColumnIndex("playableItemStorageURI"))), c.getInt(c.getColumnIndex("playableItemId")), -1);
            this.mCurrentItemPosition = c.getInt(c.getColumnIndex(PQ_STATE_ITEM_POSITION));
            this.mCurrentItemPlaybackPosition = c.getInt(c.getColumnIndex(PQ_STATE_ITEM_PLAYBACK_POSITION));
            c.close();
            return item;
        }
        c.close();
        return null;
    }

    public int getCurrentItemPosition() {
        if (!init()) {
            return -1;
        }
        if (this.mCurrentItemPosition != -1) {
            return this.mCurrentItemPosition;
        }
        cacheCurrentItemPositions();
        return this.mCurrentItemPosition;
    }

    public int getCurrentItemPlaybackPosition() {
        if (!init()) {
            return -1;
        }
        if (this.mCurrentItemPlaybackPosition != -1) {
            return this.mCurrentItemPlaybackPosition;
        }
        cacheCurrentItemPositions();
        return this.mCurrentItemPlaybackPosition;
    }

    private boolean init() {
        if (this.mDB == null || !this.mDB.isOpen()) {
            this.mDB = this.mContext.openOrCreateDatabase(PQ_DB_NAME, 0, null);
            this.mDB.execSQL("CREATE TABLE IF NOT EXISTS queue (playableItemId INTEGER NOT NULL,playableItemStorageVolume TEXT NOT NULL,playableItemStorageURI TEXT NOT NULL)");
            this.mDB.execSQL("CREATE TABLE IF NOT EXISTS shuffledQueue (playableItemId INTEGER NOT NULL,playableItemStorageVolume TEXT NOT NULL,playableItemStorageURI TEXT NOT NULL)");
            this.mDB.execSQL("CREATE TABLE IF NOT EXISTS queueState (playableItemId INTEGER NOT NULL,playableItemStorageVolume TEXT NOT NULL,playableItemStorageURI TEXT NOT NULL,playableItemPositionInList INTEGER NOT NULL,playableItemPlaybackPosition INTEGER NOT NULL)");
        }
        return true;
    }

    private void cacheCurrentItemPositions() {
        Cursor c = this.mDB.query(PQ_STATE_TABLE, new String[]{PQ_STATE_ITEM_POSITION, PQ_STATE_ITEM_PLAYBACK_POSITION}, null, null, null, null, null);
        if (c.moveToNext()) {
            this.mCurrentItemPosition = c.getInt(c.getColumnIndex(PQ_STATE_ITEM_POSITION));
            this.mCurrentItemPlaybackPosition = c.getInt(c.getColumnIndex(PQ_STATE_ITEM_PLAYBACK_POSITION));
            c.close();
            return;
        }
        this.mCurrentItemPosition = -1;
        this.mCurrentItemPlaybackPosition = -1;
        c.close();
    }
}
