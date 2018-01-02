package com.songbirdnest.database.friends;

import android.content.Context;
import android.database.Cursor;
import com.songbirdnest.database.BaseDatabaseHelper;
import com.songbirdnest.database.DBBuilder;
import com.songbirdnest.database.DBException;
import com.songbirdnest.database.TableEntry;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArtistPhotoCache {
    private static ArtistPhotoCache mSingleton;
    String[] aCols = new String[]{"artist_id", "local_photo"};
    BaseDatabaseHelper mHelper;
    TableEntry mMainTable;

    public static synchronized ArtistPhotoCache get(Context pContext) {
        ArtistPhotoCache artistPhotoCache;
        synchronized (ArtistPhotoCache.class) {
            if (mSingleton == null) {
                mSingleton = new ArtistPhotoCache(pContext);
            }
            artistPhotoCache = mSingleton;
        }
        return artistPhotoCache;
    }

    ArtistPhotoCache(Context pContext) {
        DBBuilder builder = new DBBuilder(pContext);
        builder.setDatabaseName("artistPhoto.db");
        builder.setMainTableName("artistPhoto");
        ArrayList<String> aColList = new ArrayList();
        aColList.add(this.aCols[0]);
        aColList.add(this.aCols[1]);
        builder.addTable("artistPhoto", aColList);
        try {
            this.mHelper = builder.build();
            this.mMainTable = builder.getTableEntry("artistPhoto");
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public synchronized void addPhoto(String pArtistID, String pPhotoPath) {
        List aData = new ArrayList();
        aData.add(pArtistID);
        aData.add(pPhotoPath);
        Cursor aCursor = this.mHelper.getEntry(this.mMainTable, this.aCols[0], pArtistID);
        if (aCursor == null || aCursor.getCount() == 0) {
            this.mHelper.insertEntry(this.mMainTable, aData);
        } else {
            this.mHelper.updateEntry(this.mMainTable, aData, (Object) pArtistID);
        }
        if (aCursor != null) {
            aCursor.close();
        }
        this.mHelper.close();
    }

    public synchronized String getPhoto(String pArtistID) {
        String str;
        Cursor aCursor = this.mHelper.getEntry(this.mMainTable, this.aCols[0], pArtistID);
        if (aCursor == null || aCursor.getCount() == 0 || !aCursor.moveToFirst()) {
            if (aCursor != null) {
                aCursor.close();
            }
            this.mHelper.close();
            str = null;
        } else {
            str = aCursor.getString(aCursor.getColumnIndex(this.aCols[1]));
            aCursor.close();
            this.mHelper.close();
        }
        return str;
    }

    public synchronized void cleanupPhotos() {
        Cursor aCursor = this.mHelper.getAllEntries(this.mMainTable);
        if (aCursor != null) {
            if (aCursor.getCount() == 0 || !aCursor.moveToFirst()) {
                aCursor.close();
            } else {
                if (aCursor.getCount() > 50) {
                    ArrayList<String[]> aArtistList = new ArrayList();
                    do {
                        aArtistList.add(new String[]{aCursor.getString(aCursor.getColumnIndex(this.aCols[0])), aCursor.getString(aCursor.getColumnIndex(this.aCols[1]))});
                    } while (aCursor.moveToNext());
                    aCursor.close();
                    Collections.shuffle(aArtistList);
                    ArrayList<String> aDeleteItems = new ArrayList();
                    while (aArtistList.size() > 25) {
                        aDeleteItems.add(((String[]) aArtistList.get(aArtistList.size() - 1))[0]);
                        aArtistList.remove(aArtistList.size() - 1);
                    }
                    this.mHelper.deleteEntryWhere(this.mMainTable, this.aCols[0] + " in " + buildString(aArtistList), null);
                    Iterator i$ = aArtistList.iterator();
                    while (i$.hasNext()) {
                        new File(((String[]) i$.next())[1]).delete();
                    }
                } else {
                    aCursor.close();
                }
                this.mHelper.close();
            }
        }
    }

    public static String buildString(List<String[]> aList) {
        StringBuilder aBuilder = new StringBuilder();
        aBuilder.append("(");
        for (String[] aItem : aList) {
            aBuilder.append("\"").append(aItem[0]).append("\"");
            if (!aItem[0].equals(((String[]) aList.get(aList.size() - 1))[0])) {
                aBuilder.append(",");
            }
        }
        aBuilder.append(")");
        return aBuilder.toString();
    }
}
