package com.ushareit.listenit;

import android.database.Cursor;

public class gld extends gla {
    public int f14292a;
    public int f14293b;
    public int f14294c;
    public long f14295d;

    public gld(Cursor cursor) {
        super(cursor);
    }

    public void mo2560a(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("row_id");
        int columnIndex2 = cursor.getColumnIndex("row_key");
        int columnIndex3 = cursor.getColumnIndex("playlist_id");
        int columnIndex4 = cursor.getColumnIndex("song_id");
        this.f14292a = cursor.getInt(columnIndex);
        this.f14293b = cursor.getInt(columnIndex2);
        this.f14294c = cursor.getInt(columnIndex3);
        this.f14295d = cursor.getLong(columnIndex4);
    }

    public String mo2557a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("playListItem").append("_").append(this.f14292a);
        return stringBuilder.toString();
    }

    public int mo2561b() {
        return 1;
    }

    public void mo2559a(int i) {
    }

    public String mo2562c() {
        return "";
    }
}
