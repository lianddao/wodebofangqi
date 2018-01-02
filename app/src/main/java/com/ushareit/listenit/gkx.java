package com.ushareit.listenit;

import android.database.Cursor;

public class gkx extends gla {
    public long f14254a;
    public String f14255b;
    public String f14256c;
    public int f14257d;
    public int f14258e;
    public long f14259f;
    public String f14260g;
    public String f14261h;
    public String f14262i;
    public String f14263j;
    public String f14264k;
    public int f14265l;

    public gkx(Cursor cursor) {
        super(cursor);
    }

    public gkx(glg com_ushareit_listenit_glg) {
        this.f14254a = com_ushareit_listenit_glg.f14334b;
        this.f14255b = com_ushareit_listenit_glg.f14338f;
        this.f14256c = com_ushareit_listenit_glg.f14342j;
        this.f14257d = com_ushareit_listenit_glg.f14344l;
        this.f14258e = com_ushareit_listenit_glg.f14337e;
        this.f14259f = com_ushareit_listenit_glg.f14352t;
        this.f14260g = com_ushareit_listenit_glg.f14339g;
        this.f14261h = com_ushareit_listenit_glg.f14340h;
        this.f14262i = com_ushareit_listenit_glg.f14343k;
        this.f14263j = com_ushareit_listenit_glg.f14341i;
        this.f14264k = com_ushareit_listenit_glg.f14345m;
        this.f14265l = com_ushareit_listenit_glg.f14346n;
    }

    public void mo2560a(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("title");
        int columnIndex3 = cursor.getColumnIndex("_data");
        int columnIndex4 = cursor.getColumnIndex("_size");
        int columnIndex5 = cursor.getColumnIndex("duration");
        int columnIndex6 = cursor.getColumnIndex("last_add_timestamp");
        int columnIndex7 = cursor.getColumnIndex("artist");
        int columnIndex8 = cursor.getColumnIndex("album");
        int columnIndex9 = cursor.getColumnIndex("album_art_path");
        int columnIndex10 = cursor.getColumnIndex("folder_path");
        int columnIndex11 = cursor.getColumnIndex("song_genre");
        int columnIndex12 = cursor.getColumnIndex("song_bitrate");
        this.f14254a = cursor.getLong(columnIndex);
        this.f14255b = cursor.getString(columnIndex2);
        this.f14256c = cursor.getString(columnIndex3);
        this.f14257d = cursor.getInt(columnIndex4);
        this.f14258e = cursor.getInt(columnIndex5);
        this.f14259f = cursor.getLong(columnIndex6);
        this.f14260g = cursor.getString(columnIndex7);
        this.f14261h = cursor.getString(columnIndex8);
        this.f14262i = cursor.getString(columnIndex9);
        this.f14263j = cursor.getString(columnIndex10);
        this.f14264k = cursor.getString(columnIndex11);
        this.f14265l = cursor.getInt(columnIndex12);
    }

    public String mo2557a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("clip").append("_").append(this.f14254a);
        return stringBuilder.toString();
    }

    public int mo2561b() {
        return 1;
    }

    public void mo2559a(int i) {
    }

    public String mo2562c() {
        return this.f14255b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id=").append(this.f14254a);
        stringBuilder.append("songName=").append(this.f14255b);
        stringBuilder.append("songPath=").append(this.f14256c);
        stringBuilder.append("songSize=").append(this.f14257d);
        stringBuilder.append("songDuration=").append(this.f14258e);
        stringBuilder.append("lastAdd=").append(this.f14259f);
        stringBuilder.append("artistName=").append(this.f14260g);
        stringBuilder.append("albumName=").append(this.f14261h);
        stringBuilder.append("albumartPath=").append(this.f14262i);
        stringBuilder.append("folderPath=").append(this.f14263j);
        stringBuilder.append("genre=").append(this.f14264k);
        stringBuilder.append("bitrate=").append(this.f14265l);
        return stringBuilder.toString();
    }
}
