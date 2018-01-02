package com.miui.player.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.MediaStore.Audio.Media;
import android.util.Log;
import com.miui.player.provider.PlayerStore.MemberColomns;
import com.miui.player.provider.PlayerStore.MiuiPlaylistsAudioMap;
import com.miui.player.util.SqlUtils;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import miui.os.Build;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HMSwitcher {
    private static final String BACK_UP_FILE = "music_back_up_convert_sdcard";
    private static final boolean DEBUG = false;
    private static final long RECOVER_DATA_TIME_LIMIT = 432000000;
    private static final String TAG = "HMSwitcher";
    private static String[] sColumns = new String[]{"_id", "audio_id", MemberColomns.PLAYLIST_ID, "play_order", "date_added", "_data", "title", "online_id", "provider_id", "album", "artist", "duration", "sync_state"};

    private static class TrackLogo {
        public int mAudioId;
        public int mPlaylistId;

        public TrackLogo(int audioId, int playlistId) {
            this.mAudioId = audioId;
            this.mPlaylistId = playlistId;
        }

        public int hashCode() {
            return this.mAudioId;
        }

        public boolean equals(Object o) {
            if (o == null || !(o instanceof TrackLogo)) {
                return false;
            }
            TrackLogo tl = (TrackLogo) o;
            if (this.mAudioId == tl.mAudioId && this.mPlaylistId == tl.mPlaylistId) {
                return true;
            }
            return false;
        }
    }

    public static void saveAllTracks(Context context, SQLiteDatabase db) {
        if (Build.IS_HONGMI) {
            SQLiteDatabase sQLiteDatabase = db;
            Cursor cursor = sQLiteDatabase.query(MiuiPlaylistsAudioMap.TABLE_NAME, sColumns, "_data is not null AND audio_id<536870911", null, null, null, null);
            JSONArray array = new JSONArray();
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        JSONObject obj = new JSONObject();
                        obj.put(sColumns[0], cursor.getInt(0));
                        obj.put(sColumns[1], cursor.getInt(1));
                        obj.put(sColumns[2], cursor.getInt(2));
                        obj.put(sColumns[3], cursor.getInt(3));
                        obj.put(sColumns[4], cursor.getInt(4));
                        obj.put(sColumns[5], switchPath(cursor.getString(5)));
                        obj.put(sColumns[6], cursor.getString(6));
                        obj.put(sColumns[7], cursor.getString(7));
                        obj.put(sColumns[8], cursor.getString(8));
                        obj.put(sColumns[9], cursor.getString(9));
                        obj.put(sColumns[10], cursor.getString(10));
                        obj.put(sColumns[11], cursor.getInt(11));
                        obj.put(sColumns[12], cursor.getString(12));
                        array.put(obj);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        cursor.close();
                    }
                }
                cursor.close();
            }
            if (array.length() > 0) {
                Log.d(TAG, context.getCacheDir().getPath());
                File file = new File(context.getCacheDir().getPath(), BACK_UP_FILE);
                if (!file.exists()) {
                    try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
                        bw.write(array.toString());
                        bw.close();
                    } catch (FileNotFoundException e2) {
                        e2.printStackTrace();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    private static String switchPath(String path) {
        if (path == null) {
            return null;
        }
        if (path.startsWith("/storage/sdcard0")) {
            return path.replaceFirst("sdcard0", "sdcard1");
        }
        if (path.startsWith("/storage/sdcard1")) {
            return path.replaceFirst("sdcard1", "sdcard0");
        }
        return path;
    }

    public static void matchTracks(Context context) {
        if (Build.IS_HONGMI) {
            HashMap<String, Integer> newMap = getTracksFromMediaProvider(context);
            if (newMap != null && newMap.size() != 0) {
                JSONArray array = getTracksFromBackUpFile(context);
                if (array != null && array.length() != 0) {
                    ArrayList<JSONObject> list1 = new ArrayList();
                    int i = 0;
                    while (i < array.length()) {
                        try {
                            JSONObject obj = array.getJSONObject(i);
                            Integer newId = (Integer) newMap.get(obj.getString("_data"));
                            if (newId != null) {
                                obj.put("audio_id", newId);
                                list1.add(obj);
                            }
                            i++;
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    recoverTracks(context, removeDuplicatedTracks(context, list1));
                }
            }
        }
    }

    private static HashMap<String, Integer> getTracksFromMediaProvider(Context context) {
        Uri uri = Media.EXTERNAL_CONTENT_URI;
        String[] colums = new String[]{"_data", "_id"};
        HashMap<String, Integer> map = new HashMap();
        Cursor cursor = SqlUtils.query(context, uri, colums, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    map.put(cursor.getString(0), Integer.valueOf(cursor.getInt(1)));
                } finally {
                    cursor.close();
                }
            }
        }
        return map;
    }

    private static JSONArray getTracksFromBackUpFile(Context context) {
        File file = new File(context.getCacheDir(), BACK_UP_FILE);
        if (!file.exists()) {
            return null;
        }
        if (Math.abs(file.lastModified() - System.currentTimeMillis()) > RECOVER_DATA_TIME_LIMIT) {
            file.delete();
            return null;
        }
        JSONArray jSONArray = null;
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[bis.available()];
            bis.read(buffer);
            bis.close();
            String string = new String(buffer);
            Log.d(TAG, "back up file input:\n" + string);
            jSONArray = new JSONArray(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        file.delete();
        return jSONArray;
    }

    private static void recoverTracks(Context context, ArrayList<JSONObject> array) {
        if (array != null && !array.isEmpty()) {
            ContentValues[] cvs = new ContentValues[array.size()];
            int i = 0;
            while (i < cvs.length) {
                try {
                    int j;
                    cvs[i] = new ContentValues();
                    JSONObject obj = (JSONObject) array.get(i);
                    for (j = 1; j < 5; j++) {
                        cvs[i].put(sColumns[j], Integer.valueOf(obj.getInt(sColumns[j])));
                    }
                    for (j = 5; j < 7; j++) {
                        cvs[i].put(sColumns[j], obj.getString(sColumns[j]));
                    }
                    for (j = 9; j < 11; j++) {
                        cvs[i].put(sColumns[j], obj.getString(sColumns[j]));
                    }
                    cvs[i].put(sColumns[11], Integer.valueOf(obj.getInt(sColumns[11])));
                    cvs[i].put(sColumns[12], obj.getString(sColumns[12]));
                    i++;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            context.getContentResolver().bulkInsert(MiuiPlaylistsAudioMap.EXTERNAL_URI, cvs);
        }
    }

    private static ArrayList<JSONObject> removeDuplicatedTracks(Context context, ArrayList<JSONObject> list) {
        Uri uri = MiuiPlaylistsAudioMap.EXTERNAL_URI;
        String[] colums = new String[]{"audio_id", MemberColomns.PLAYLIST_ID};
        HashSet<TrackLogo> existSet = new HashSet();
        Cursor cursor = SqlUtils.query(context, uri, colums, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    existSet.add(new TrackLogo(cursor.getInt(0), cursor.getInt(1)));
                } finally {
                    cursor.close();
                }
            }
        }
        ArrayList<JSONObject> result = new ArrayList();
        Iterator i$ = list.iterator();
        while (i$.hasNext()) {
            JSONObject obj = (JSONObject) i$.next();
            if (!existSet.contains(new TrackLogo(obj.optInt(sColumns[1]), obj.optInt(sColumns[2])))) {
                result.add(obj);
            }
        }
        return result;
    }
}
