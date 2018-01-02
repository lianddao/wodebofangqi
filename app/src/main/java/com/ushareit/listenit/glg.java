package com.ushareit.listenit;

import android.database.Cursor;

public class glg extends gla {
    public static final String[] f14332a = new String[]{String.valueOf(0)};
    private String f14333A;
    public long f14334b;
    public int f14335c;
    public int f14336d;
    public int f14337e;
    public String f14338f;
    public String f14339g;
    public String f14340h;
    public String f14341i;
    public String f14342j;
    public String f14343k;
    public int f14344l;
    public String f14345m;
    public int f14346n;
    public String f14347o;
    public int f14348p;
    public long f14349q;
    public int f14350r;
    public long f14351s;
    public long f14352t;
    public boolean f14353u;
    public int f14354v;
    public int f14355w;
    public int f14356x;
    public long f14357y;
    public long f14358z;

    public glg(Cursor cursor) {
        super(cursor);
    }

    public glg(fse com_ushareit_listenit_fse) {
        this.f14334b = com_ushareit_listenit_fse.f13343a;
        this.f14338f = com_ushareit_listenit_fse.f13344b;
        this.f14339g = com_ushareit_listenit_fse.f13345c;
        this.f14340h = com_ushareit_listenit_fse.f13346d;
        this.f14343k = com_ushareit_listenit_fse.f13347e;
        this.f14344l = (int) com_ushareit_listenit_fse.f13349g;
        this.f14337e = (int) com_ushareit_listenit_fse.f13348f;
        this.f14342j = gyn.m23261q(com_ushareit_listenit_fse.f13351i);
        this.f14354v = (int) com_ushareit_listenit_fse.f13350h;
        this.f14351s = com_ushareit_listenit_fse.f13352j;
        this.f14358z = com_ushareit_listenit_fse.f13353k;
    }

    public glg(gkx com_ushareit_listenit_gkx) {
        this.f14334b = com_ushareit_listenit_gkx.f14254a;
        this.f14335c = 0;
        this.f14336d = 0;
        this.f14337e = com_ushareit_listenit_gkx.f14258e;
        this.f14344l = com_ushareit_listenit_gkx.f14257d;
        this.f14338f = com_ushareit_listenit_gkx.f14255b;
        this.f14339g = com_ushareit_listenit_gkx.f14260g;
        this.f14340h = com_ushareit_listenit_gkx.f14261h;
        this.f14342j = com_ushareit_listenit_gkx.f14256c;
        this.f14341i = com_ushareit_listenit_gkx.f14263j;
        this.f14343k = com_ushareit_listenit_gkx.f14262i;
        this.f14345m = com_ushareit_listenit_gkx.f14264k;
        this.f14346n = com_ushareit_listenit_gkx.f14265l;
        this.f14347o = "";
        this.f14348p = 0;
        this.f14333A = "";
        this.f14349q = 0;
        this.f14350r = 0;
        this.f14351s = 0;
        this.f14352t = 0;
        this.f14353u = true;
        this.f14354v = 0;
        this.f14355w = 0;
        this.f14356x = 0;
        this.f14357y = 0;
        this.f14358z = 0;
    }

    public void mo2560a(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("song_key");
        int columnIndex3 = cursor.getColumnIndex("song_state");
        int columnIndex4 = cursor.getColumnIndex("duration");
        int columnIndex5 = cursor.getColumnIndex("_size");
        int columnIndex6 = cursor.getColumnIndex("title");
        int columnIndex7 = cursor.getColumnIndex("artist");
        int columnIndex8 = cursor.getColumnIndex("album");
        int columnIndex9 = cursor.getColumnIndex("_data");
        int columnIndex10 = cursor.getColumnIndex("folder_path");
        int columnIndex11 = cursor.getColumnIndex("album_art_path");
        int columnIndex12 = cursor.getColumnIndex("song_genre");
        int columnIndex13 = cursor.getColumnIndex("song_bitrate");
        int columnIndex14 = cursor.getColumnIndex("song_mimetype");
        int columnIndex15 = cursor.getColumnIndex("song_source");
        int columnIndex16 = cursor.getColumnIndex("song_md5");
        int columnIndex17 = cursor.getColumnIndex("sync_time");
        int columnIndex18 = cursor.getColumnIndex("changed_flag");
        int columnIndex19 = cursor.getColumnIndex("song_backup");
        int columnIndex20 = cursor.getColumnIndex("like_it");
        int columnIndex21 = cursor.getColumnIndex("is_support");
        int columnIndex22 = cursor.getColumnIndex(fnl.PLAY_COUNT);
        int columnIndex23 = cursor.getColumnIndex("temp_play_count");
        int columnIndex24 = cursor.getColumnIndex("track");
        int columnIndex25 = cursor.getColumnIndex("albumart_modified_timestamp");
        int columnIndex26 = cursor.getColumnIndex("last_play_timestamp");
        this.f14334b = cursor.getLong(columnIndex);
        this.f14335c = cursor.getInt(columnIndex2);
        this.f14336d = cursor.getInt(columnIndex3);
        this.f14337e = cursor.getInt(columnIndex4);
        this.f14344l = cursor.getInt(columnIndex5);
        this.f14338f = cursor.getString(columnIndex6);
        this.f14339g = cursor.getString(columnIndex7);
        this.f14340h = cursor.getString(columnIndex8);
        this.f14342j = cursor.getString(columnIndex9);
        this.f14341i = cursor.getString(columnIndex10);
        this.f14343k = cursor.getString(columnIndex11);
        this.f14345m = cursor.getString(columnIndex12);
        this.f14346n = cursor.getInt(columnIndex13);
        this.f14347o = cursor.getString(columnIndex14);
        this.f14347o = fbb.m18763c(this.f14347o) ? gyn.m23235e(this.f14342j) : this.f14347o;
        this.f14348p = cursor.getInt(columnIndex15);
        this.f14333A = cursor.getString(columnIndex16);
        this.f14349q = cursor.getLong(columnIndex17);
        this.f14350r = cursor.getInt(columnIndex18);
        this.f14352t = cursor.getLong(columnIndex19);
        this.f14351s = cursor.getLong(columnIndex20);
        this.f14353u = cursor.getInt(columnIndex21) == 0;
        this.f14354v = cursor.getInt(columnIndex22);
        this.f14355w = cursor.getInt(columnIndex23);
        this.f14356x = cursor.getInt(columnIndex24);
        this.f14357y = cursor.getLong(columnIndex25);
        this.f14358z = cursor.getLong(columnIndex26);
    }

    public String mo2557a() {
        return "" + this.f14334b;
    }

    public int mo2561b() {
        return 1;
    }

    public void mo2559a(int i) {
    }

    public long mo2702d() {
        return this.f14357y;
    }

    public String mo2562c() {
        return this.f14338f;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id=").append(this.f14334b);
        stringBuilder.append("key=").append(this.f14335c);
        stringBuilder.append("songState=").append(this.f14336d);
        stringBuilder.append("songDuration=").append(this.f14337e);
        stringBuilder.append("songSize=").append(this.f14344l);
        stringBuilder.append("songName=").append(this.f14338f);
        stringBuilder.append("artistName=").append(this.f14339g);
        stringBuilder.append("albumName=").append(this.f14340h);
        stringBuilder.append("songPath=").append(this.f14342j);
        stringBuilder.append("folderPath=").append(this.f14341i);
        stringBuilder.append("albumartPath=").append(this.f14343k);
        stringBuilder.append("genre=").append(this.f14345m);
        stringBuilder.append("bitrate=").append(this.f14346n);
        stringBuilder.append("mimeType=").append(this.f14347o);
        stringBuilder.append("source=").append(this.f14348p);
        stringBuilder.append("songMD5=").append(this.f14333A);
        stringBuilder.append("syncTime=").append(this.f14349q);
        stringBuilder.append("changedFlag=").append(this.f14350r);
        stringBuilder.append("backup=").append(this.f14352t);
        stringBuilder.append("favorite=").append(this.f14351s);
        stringBuilder.append("isSupport=").append(this.f14353u);
        stringBuilder.append("playCount=").append(this.f14354v);
        stringBuilder.append("tempPlayCount=").append(this.f14355w);
        stringBuilder.append("songTrack=").append(this.f14356x);
        stringBuilder.append("mAlbumArtModifiedTimestamp=").append(this.f14357y);
        stringBuilder.append("lastPlayTimestamp=").append(this.f14358z);
        return stringBuilder.toString();
    }

    public String m22362h() {
        if (fbb.m18763c(this.f14333A) || this.f14333A.equals("0")) {
            frf.m20643a(this);
        }
        return this.f14333A;
    }

    public void m22357a(String str) {
        this.f14333A = str;
    }

    public boolean m22363i() {
        return (fbb.m18763c(this.f14333A) || this.f14333A.equals("0")) ? false : true;
    }

    public String mo2558g() {
        return this.f14342j;
    }
}
