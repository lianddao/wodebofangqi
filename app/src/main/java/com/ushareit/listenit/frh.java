package com.ushareit.listenit;

import android.database.Cursor;

public class frh {
    public String f13268a;
    public long f13269b = -1;
    public String f13270c;
    public String f13271d;
    public String f13272e;
    public String f13273f;
    public String f13274g;
    public int f13275h;
    public int f13276i;
    public int f13277j;
    public long f13278k;
    public long f13279l;

    public frh(Cursor cursor) {
        this.f13268a = cursor.getString(cursor.getColumnIndex("song_md5"));
        this.f13269b = cursor.getLong(cursor.getColumnIndex("song_id"));
        this.f13270c = cursor.getString(cursor.getColumnIndex("song_name"));
        this.f13271d = cursor.getString(cursor.getColumnIndex("song_author"));
        this.f13272e = cursor.getString(cursor.getColumnIndex("album"));
        this.f13273f = cursor.getString(cursor.getColumnIndex("genre"));
        this.f13274g = cursor.getString(cursor.getColumnIndex("mimetype"));
        this.f13275h = cursor.getInt(cursor.getColumnIndex("bitrate"));
        this.f13276i = cursor.getInt(cursor.getColumnIndex("duration"));
        this.f13277j = cursor.getInt(cursor.getColumnIndex("size"));
        this.f13278k = cursor.getLong(cursor.getColumnIndex("size"));
        this.f13279l = cursor.getLong(cursor.getColumnIndex("is_downloaded"));
    }

    public String toString() {
        return "CollectSong{MD5='" + this.f13268a + '\'' + ", name='" + this.f13270c + '\'' + ", artist='" + this.f13271d + '\'' + ", album='" + this.f13272e + '\'' + ", genre='" + this.f13273f + '\'' + ", mimetype='" + this.f13274g + '\'' + ", bitrate='" + this.f13275h + '\'' + ", duration='" + this.f13276i + '\'' + ", size=" + this.f13277j + '}';
    }
}
