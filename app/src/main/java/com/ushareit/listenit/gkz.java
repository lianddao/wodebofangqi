package com.ushareit.listenit;

import android.database.Cursor;

public class gkz extends gla {
    public static final String[] f14277a = new String[]{String.valueOf(0)};
    public String f14278b;
    public String f14279c;
    public int f14280d;

    public gkz(Cursor cursor) {
        super(cursor);
    }

    public void mo2560a(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("folder_name");
        int columnIndex2 = cursor.getColumnIndex("folder_path");
        int columnIndex3 = cursor.getColumnIndex(fnl.SONG_NUMBER);
        this.f14278b = cursor.getString(columnIndex);
        this.f14279c = cursor.getString(columnIndex2);
        this.f14280d = cursor.getInt(columnIndex3);
    }

    public String mo2557a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("folderitem").append("_").append(this.f14279c);
        return stringBuilder.toString();
    }

    public int mo2561b() {
        return this.f14280d;
    }

    public void mo2559a(int i) {
        this.f14280d = i;
    }

    public String mo2562c() {
        return this.f14278b;
    }

    public int mo2703e() {
        return 11;
    }
}
