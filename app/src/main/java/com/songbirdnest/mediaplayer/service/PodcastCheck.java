package com.songbirdnest.mediaplayer.service;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import com.songbirdnest.mediaplayer.C0116R;
import com.songbirdnest.mediaplayer.Constants;
import com.songbirdnest.util.MediaUtils;
import java.io.File;
import java.util.Vector;
import org.cmc.music.metadata.ImageData;
import org.cmc.music.myid3.MyID3;

public class PodcastCheck extends AsyncTask<Void, Void, Boolean> {
    public static final String TAG = "PodcastCheck";
    Context mContext;

    public PodcastCheck(Context pContext) {
        this.mContext = pContext;
    }

    protected Boolean doInBackground(Void... params) {
        Boolean valueOf;
        Throwable e;
        Throwable th;
        PodcastAlbumArtHelper podcastAlbumArtHelper = null;
        try {
            Cursor aCursor;
            PodcastAlbumArtHelper podcastAlbumArtHelper2 = new PodcastAlbumArtHelper(this.mContext);
            podcastAlbumArtHelper2.open();
            Cursor aSyncCursor = podcastAlbumArtHelper2.getCursor();
            aSyncCursor.moveToFirst();
            String[] aProjection = new String[]{"title", "_data", "album_key", "album"};
            if (aSyncCursor.moveToFirst()) {
                do {
                    String[] strArr = aProjection;
                    aCursor = MediaUtils.getMediaStoreMergeCursor(this.mContext, strArr, "is_podcast = 1 AND album_key = ?", new String[]{aSyncCursor.getString(aSyncCursor.getColumnIndex(PodcastAlbumArtHelper.KEY_ALBUM_KEY))}, "album_key ASC");
                    if (aCursor.getCount() == 0) {
                        podcastAlbumArtHelper2.removeEntry(aAlbumKey);
                    }
                    aCursor.close();
                } while (aSyncCursor.moveToNext());
            }
            aSyncCursor.close();
            podcastAlbumArtHelper2.close();
            aCursor = MediaUtils.getMediaStoreMergeCursor(this.mContext, aProjection, "is_podcast = 1", null, "album_key ASC");
            if (aCursor == null) {
                valueOf = Boolean.valueOf(false);
                podcastAlbumArtHelper2.close();
                podcastAlbumArtHelper = podcastAlbumArtHelper2;
            } else if (aCursor.getCount() == 0) {
                aCursor.close();
                valueOf = Boolean.valueOf(true);
                podcastAlbumArtHelper2.close();
                podcastAlbumArtHelper = podcastAlbumArtHelper2;
            } else {
                aCursor.moveToFirst();
                int aDataCol = aCursor.getColumnIndex("_data");
                int aAlbumKeyCol = aCursor.getColumnIndex("album_key");
                int aAlbumCol = aCursor.getColumnIndex("album");
                podcastAlbumArtHelper2.open();
                do {
                    String aData = aCursor.getString(aDataCol);
                    String aAlbum = aCursor.getString(aAlbumCol);
                    String albumKey = aCursor.getString(aAlbumKeyCol);
                    if (podcastAlbumArtHelper2.getArtwork(albumKey) == null) {
                        Vector<ImageData> aVector = null;
                        try {
                            aVector = new MyID3().read(new File(aData)).getSimplified().getPictures();
                        } catch (StackOverflowError e2) {
                            Log.e(TAG, "Problems Reading Bitmap from MP3. StackOverflowError");
                        }
                        if (aVector != null) {
                            try {
                                if (aVector.size() > 0) {
                                    byte[] aByte = ((ImageData) aVector.get(0)).imageData;
                                    Bitmap aMap = BitmapFactory.decodeByteArray(aByte, 0, aByte.length);
                                    podcastAlbumArtHelper2.createEntry(new PodcastEntry(Bitmap.createScaledBitmap(aMap, aMap.getWidth() / 4, aMap.getHeight() / 4, true), aMap, albumKey, aAlbum, aData));
                                    aMap.recycle();
                                    this.mContext.sendBroadcast(new Intent(Constants.PODCAST_UPDATE));
                                }
                            } catch (Throwable ex) {
                                try {
                                    Log.e(TAG, "Problems Reading Bitmap from MP3", ex);
                                } catch (Exception e3) {
                                    e = e3;
                                    podcastAlbumArtHelper = podcastAlbumArtHelper2;
                                } catch (Throwable th2) {
                                    th = th2;
                                    podcastAlbumArtHelper = podcastAlbumArtHelper2;
                                }
                            } catch (Throwable th22) {
                                th = th22;
                                podcastAlbumArtHelper = podcastAlbumArtHelper2;
                            }
                        }
                        Bitmap mArtDefault = BitmapFactory.decodeResource(this.mContext.getResources(), C0116R.drawable.generic_podcast_big);
                        podcastAlbumArtHelper2.createEntry(new PodcastEntry(Bitmap.createScaledBitmap(mArtDefault, mArtDefault.getWidth() / 4, mArtDefault.getHeight() / 4, true), mArtDefault, albumKey, aAlbum, aData));
                        mArtDefault.recycle();
                        this.mContext.sendBroadcast(new Intent(Constants.PODCAST_UPDATE));
                    }
                } while (aCursor.moveToNext());
                aCursor.close();
                valueOf = Boolean.valueOf(true);
                podcastAlbumArtHelper2.close();
                podcastAlbumArtHelper = podcastAlbumArtHelper2;
            }
        } catch (Exception e4) {
            e = e4;
            try {
                Log.e(TAG, "Problems processing Podcast art", e);
                valueOf = Boolean.valueOf(false);
                podcastAlbumArtHelper.close();
                return valueOf;
            } catch (Throwable th3) {
                th = th3;
                podcastAlbumArtHelper.close();
                throw th;
            }
        }
        return valueOf;
    }
}
