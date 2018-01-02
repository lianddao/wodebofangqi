package com.ushareit.listenit;

import android.database.Cursor;

public class gkv extends gla {
    public static final String[] f14242a = new String[]{String.valueOf(0)};
    public String f14243b;
    public String f14244c;
    public String f14245d;
    public int f14246e;
    public long f14247f;

    public gkv(Cursor cursor) {
        super(cursor);
    }

    public gkv(String str, String str2, String str3, int i, long j) {
        this.f14244c = str;
        this.f14243b = str2;
        this.f14245d = str3;
        this.f14246e = i;
        this.f14247f = j;
    }

    public void mo2560a(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("artist");
        int columnIndex2 = cursor.getColumnIndex("album");
        int columnIndex3 = cursor.getColumnIndex("album_art_path");
        int columnIndex4 = cursor.getColumnIndex(fnl.SONG_NUMBER);
        int columnIndex5 = cursor.getColumnIndex("albumart_modified_timestamp");
        this.f14244c = cursor.getString(columnIndex2);
        this.f14243b = cursor.getString(columnIndex);
        this.f14245d = cursor.getString(columnIndex3);
        this.f14246e = cursor.getInt(columnIndex4);
        this.f14247f = cursor.getLong(columnIndex5);
    }

    public String mo2557a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("albumitem").append("_").append(this.f14244c);
        return stringBuilder.toString();
    }

    public int mo2561b() {
        return this.f14246e;
    }

    public void mo2559a(int i) {
        this.f14246e = i;
    }

    public long mo2702d() {
        return this.f14247f;
    }

    public void mo2701a(long j) {
        this.f14247f = j;
    }

    public String mo2562c() {
        return this.f14244c;
    }

    public int mo2703e() {
        return 6;
    }
}
