package com.ushareit.listenit;

import android.database.Cursor;

public class gkw extends gla {
    public static final String[] f14248a = new String[]{String.valueOf(0)};
    public String f14249b;
    public String f14250c;
    public String f14251d;
    public int f14252e;
    public long f14253f;

    public gkw(Cursor cursor) {
        super(cursor);
    }

    public gkw(String str, String str2, String str3, int i, long j) {
        this.f14249b = str;
        this.f14250c = str2;
        this.f14251d = str3;
        this.f14252e = i;
        this.f14253f = j;
    }

    public void mo2560a(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("artist");
        int columnIndex2 = cursor.getColumnIndex("album");
        int columnIndex3 = cursor.getColumnIndex("album_art_path");
        int columnIndex4 = cursor.getColumnIndex(fnl.SONG_NUMBER);
        int columnIndex5 = cursor.getColumnIndex("albumart_modified_timestamp");
        this.f14249b = cursor.getString(columnIndex);
        this.f14250c = cursor.getString(columnIndex2);
        this.f14251d = cursor.getString(columnIndex3);
        this.f14252e = cursor.getInt(columnIndex4);
        this.f14253f = cursor.getLong(columnIndex5);
    }

    public String mo2557a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("artistitem").append("_").append(this.f14249b);
        return stringBuilder.toString();
    }

    public int mo2561b() {
        return this.f14252e;
    }

    public void mo2559a(int i) {
        this.f14252e = i;
    }

    public long mo2702d() {
        return this.f14253f;
    }

    public String mo2562c() {
        return this.f14249b;
    }

    public int mo2703e() {
        return 5;
    }
}
