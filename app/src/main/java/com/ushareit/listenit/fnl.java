package com.ushareit.listenit;

import android.database.Cursor;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class fnl implements Serializable {
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "na";
    public static final String KEY_PLAY_COUNT = "pc";
    public static final String KEY_SONG_NUMBER = "sgN";
    public static final String PLAY_COUNT = "play_count";
    public static final String QUERY_SQL = " select playlist_id, playlist_name, (select count() from audio_library where song_backup>0 and _id in  (select song_id from playlist_song where playlist_song.playlist_id=playlist.playlist_id)) as song_count, (select sum(play_count) from audio_library where song_backup>0 and _id in  (select song_id from playlist_song where playlist_song.playlist_id=playlist.playlist_id)) as play_count from playlist";
    public static final String SONG_NUMBER = "song_count";
    private static final String SUB_QUERY_SQL = " (select song_id from playlist_song where playlist_song.playlist_id=playlist.playlist_id)";
    private static final String TAG = "ShareList";
    public static final String[] WHERE_ARGS = new String[]{String.valueOf(0), String.valueOf(0)};
    public static final String WHERE_CLAUSE = " where state=? and visibility=?";
    private String id;
    private String na;
    private int pc;
    private int sgN;

    public fnl(String str, String str2, int i, int i2) {
        this.id = str;
        this.na = str2;
        this.sgN = i;
        this.pc = i2;
    }

    public fnl(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("playlist_name");
        int columnIndex2 = cursor.getColumnIndex("playlist_id");
        int columnIndex3 = cursor.getColumnIndex(SONG_NUMBER);
        int columnIndex4 = cursor.getColumnIndex(PLAY_COUNT);
        this.id = cursor.getString(columnIndex2);
        this.na = cursor.getString(columnIndex);
        this.sgN = cursor.getInt(columnIndex3);
        this.pc = cursor.getInt(columnIndex4);
        exw.m18443a(TAG, "playlistShared=" + toString());
    }

    public fnl(ecb com_ushareit_listenit_ecb) {
        this.id = com_ushareit_listenit_ecb.m16706d();
        this.na = (String) com_ushareit_listenit_ecb.m16699a("na").m16701a(String.class);
        this.sgN = ((Integer) com_ushareit_listenit_ecb.m16699a("sgN").m16701a(Integer.class)).intValue();
        this.pc = ((Integer) com_ushareit_listenit_ecb.m16699a(KEY_PLAY_COUNT).m16701a(Integer.class)).intValue();
    }

    public Map<String, Object> toMap() {
        Map<String, Object> linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("na", this.na);
        linkedHashMap.put("sgN", Integer.valueOf(this.sgN));
        linkedHashMap.put(KEY_PLAY_COUNT, Integer.valueOf(this.pc));
        return linkedHashMap;
    }

    public String toString() {
        return "id=" + this.id + ", name=" + this.na + ", songNumber=" + this.sgN + ", playCount=" + this.pc;
    }

    public int getPc() {
        return this.pc;
    }

    public void setPc(int i) {
        this.pc = i;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getNa() {
        return this.na;
    }

    public void setNa(String str) {
        this.na = str;
    }

    public int getSgN() {
        return this.sgN;
    }

    public void setSgN(int i) {
        this.sgN = i;
    }
}
