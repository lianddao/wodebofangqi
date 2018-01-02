package com.ushareit.listenit;

import android.database.Cursor;
import java.util.Locale;

public class glf extends gla {
    public int f14299A;
    public long f14300B;
    public int f14301C;
    public long f14302D;
    public boolean f14303E;
    public int f14304F;
    public long f14305G;
    public long f14306a;
    public int f14307b;
    public int f14308c;
    public String f14309d;
    public int f14310e;
    public int f14311f;
    public int f14312g;
    public long f14313h;
    public long f14314i;
    public String f14315j;
    public String f14316k;
    public int f14317l;
    public String f14318m;
    public int f14319n;
    public String f14320o;
    public String f14321p;
    public int f14322q;
    public int f14323r;
    public String f14324s;
    public String f14325t;
    public long f14326u;
    public long f14327v;
    public String f14328w;
    public int f14329x;
    public String f14330y;
    public String f14331z;

    public glf(Cursor cursor) {
        super(cursor);
    }

    public glf(long j, int i, String str, int i2, int i3, int i4, int i5, long j2, long j3, String str2, String str3, int i6, String str4, int i7, String str5, String str6, int i8, int i9, String str7, String str8, long j4, long j5, String str9, int i10, String str10, String str11, int i11, long j6, int i12, long j7, boolean z, int i13, long j8) {
        this.f14306a = j;
        this.f14307b = i;
        this.f14309d = str;
        this.f14310e = i2;
        this.f14311f = i3;
        this.f14308c = i4;
        this.f14312g = i5;
        this.f14313h = j2;
        this.f14314i = j3;
        this.f14315j = m22348a(str2, str);
        this.f14316k = m22347a(str3);
        this.f14317l = i6;
        this.f14318m = m22347a(str4);
        this.f14319n = i7;
        this.f14320o = m22347a(str5);
        this.f14321p = str6;
        this.f14322q = i8;
        this.f14323r = i9;
        this.f14324s = str7;
        this.f14325t = str8;
        this.f14326u = j4;
        this.f14327v = j5;
        this.f14328w = str9;
        this.f14329x = i10;
        this.f14330y = str10;
        this.f14331z = str11;
        this.f14299A = i11;
        this.f14300B = j6;
        this.f14301C = i12;
        this.f14302D = j7;
        this.f14303E = z;
        this.f14304F = i13;
        this.f14305G = j8;
    }

    public void mo2560a(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("song_key");
        int columnIndex3 = cursor.getColumnIndex("_data");
        int columnIndex4 = cursor.getColumnIndex("_size");
        int columnIndex5 = cursor.getColumnIndex("duration");
        int columnIndex6 = cursor.getColumnIndex("song_state");
        int columnIndex7 = cursor.getColumnIndex("year");
        int columnIndex8 = cursor.getColumnIndex("date_modified");
        int columnIndex9 = cursor.getColumnIndex("last_add_timestamp");
        int columnIndex10 = cursor.getColumnIndex("title");
        int columnIndex11 = cursor.getColumnIndex("artist");
        int columnIndex12 = cursor.getColumnIndex("artist_id");
        int columnIndex13 = cursor.getColumnIndex("album");
        int columnIndex14 = cursor.getColumnIndex("album_id");
        int columnIndex15 = cursor.getColumnIndex("album_artist");
        int columnIndex16 = cursor.getColumnIndex("album_art_path");
        int columnIndex17 = cursor.getColumnIndex(fnl.PLAY_COUNT);
        int columnIndex18 = cursor.getColumnIndex("temp_play_count");
        int columnIndex19 = cursor.getColumnIndex("folder_path");
        int columnIndex20 = cursor.getColumnIndex("folder_name");
        int columnIndex21 = cursor.getColumnIndex("last_play_timestamp");
        int columnIndex22 = cursor.getColumnIndex("like_it");
        int columnIndex23 = cursor.getColumnIndex("song_md5");
        int columnIndex24 = cursor.getColumnIndex("song_bitrate");
        int columnIndex25 = cursor.getColumnIndex("song_genre");
        int columnIndex26 = cursor.getColumnIndex("song_mimetype");
        int columnIndex27 = cursor.getColumnIndex("song_source");
        int columnIndex28 = cursor.getColumnIndex("sync_time");
        int columnIndex29 = cursor.getColumnIndex("changed_flag");
        int columnIndex30 = cursor.getColumnIndex("song_backup");
        int columnIndex31 = cursor.getColumnIndex("is_support");
        int columnIndex32 = cursor.getColumnIndex("track");
        int columnIndex33 = cursor.getColumnIndex("albumart_modified_timestamp");
        this.f14306a = cursor.getLong(columnIndex);
        this.f14307b = columnIndex2 != -1 ? cursor.getInt(columnIndex2) : 0;
        this.f14309d = cursor.getString(columnIndex3);
        this.f14310e = cursor.getInt(columnIndex4);
        this.f14311f = cursor.getInt(columnIndex5);
        this.f14308c = columnIndex6 != -1 ? cursor.getInt(columnIndex6) : 0;
        this.f14312g = cursor.getInt(columnIndex7);
        this.f14313h = cursor.getLong(columnIndex8);
        this.f14314i = columnIndex9 != -1 ? cursor.getLong(columnIndex9) : this.f14313h;
        this.f14315j = m22346a(cursor, columnIndex10, this.f14309d);
        this.f14316k = m22345a(cursor, columnIndex11);
        this.f14317l = cursor.getInt(columnIndex12);
        this.f14318m = m22345a(cursor, columnIndex13);
        this.f14319n = cursor.getInt(columnIndex14);
        if (columnIndex15 != -1) {
            columnIndex = columnIndex15;
        } else {
            columnIndex = columnIndex11;
        }
        this.f14320o = cursor.getString(columnIndex);
        if (fbb.m18763c(this.f14320o)) {
            this.f14320o = this.f14316k;
        }
        this.f14321p = columnIndex16 != -1 ? cursor.getString(columnIndex16) : "albumid:" + this.f14319n;
        this.f14322q = columnIndex17 != -1 ? cursor.getInt(columnIndex17) : 0;
        this.f14323r = columnIndex18 != -1 ? cursor.getInt(columnIndex18) : 0;
        this.f14324s = columnIndex19 != -1 ? cursor.getString(columnIndex19) : gyn.m23209b(this.f14309d);
        this.f14325t = columnIndex20 != -1 ? cursor.getString(columnIndex20) : gyn.m23220c(this.f14309d);
        this.f14326u = columnIndex21 != -1 ? cursor.getLong(columnIndex21) : 0;
        this.f14327v = columnIndex22 != -1 ? cursor.getLong(columnIndex22) : 0;
        this.f14328w = columnIndex23 != -1 ? cursor.getString(columnIndex23) : "0";
        this.f14329x = columnIndex24 != -1 ? cursor.getInt(columnIndex24) : 0;
        this.f14330y = columnIndex25 != -1 ? cursor.getString(columnIndex25) : "";
        this.f14331z = columnIndex26 != -1 ? cursor.getString(columnIndex26) : gyn.m23235e(this.f14309d);
        this.f14299A = columnIndex27 != -1 ? cursor.getInt(columnIndex27) : 0;
        this.f14300B = columnIndex28 != -1 ? cursor.getLong(columnIndex28) : 0;
        this.f14301C = columnIndex29 != -1 ? cursor.getInt(columnIndex29) : 0;
        this.f14302D = columnIndex30 != -1 ? cursor.getLong(columnIndex30) : 0;
        boolean z = columnIndex31 != -1 ? cursor.getInt(columnIndex31) == 0 : true;
        this.f14303E = z;
        this.f14304F = columnIndex32 != -1 ? cursor.getInt(columnIndex32) : -1;
        this.f14305G = columnIndex33 != -1 ? cursor.getLong(columnIndex33) : 0;
    }

    public String mo2557a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("songdetails").append("_").append(this.f14309d);
        return stringBuilder.toString();
    }

    public int mo2561b() {
        return 1;
    }

    public void mo2559a(int i) {
    }

    public String mo2562c() {
        return this.f14315j;
    }

    private String m22346a(Cursor cursor, int i, String str) {
        String trim = cursor.getString(i).trim();
        if (fbb.m18763c(trim) || "<unknown>".equals(trim.toLowerCase(Locale.US)) || gyn.m23202a(trim)) {
            return gyn.m23229d(str);
        }
        return trim;
    }

    private String m22348a(String str, String str2) {
        String trim = str.trim();
        if (fbb.m18763c(trim) || "<unknown>".equals(trim.toLowerCase(Locale.US)) || gyn.m23202a(trim)) {
            return gyn.m23229d(str2);
        }
        return trim;
    }

    private String m22345a(Cursor cursor, int i) {
        String trim = cursor.getString(i).trim();
        if (fbb.m18763c(trim) || "<unknown>".equals(trim.toLowerCase(Locale.US))) {
            return eys.m18562a().getString(C0349R.string.unknown);
        }
        return trim;
    }

    private String m22347a(String str) {
        String trim = str.trim();
        if (fbb.m18763c(trim) || "<unknown>".equals(trim.toLowerCase(Locale.US))) {
            return eys.m18562a().getString(C0349R.string.unknown);
        }
        return trim;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ id=").append(this.f14306a);
        stringBuilder.append(", key=").append(this.f14307b);
        stringBuilder.append(", path=").append(this.f14309d);
        stringBuilder.append(", size=").append(this.f14310e);
        stringBuilder.append(", duration=").append(this.f14311f);
        stringBuilder.append(", songState=").append(this.f14308c);
        stringBuilder.append(", year=").append(this.f14312g);
        stringBuilder.append(", lastModified=").append(this.f14313h);
        stringBuilder.append(", lastAddTimestamp=").append(this.f14314i);
        stringBuilder.append(", name=").append(this.f14315j);
        stringBuilder.append(", artist=").append(this.f14316k);
        stringBuilder.append(", artistId=").append(this.f14317l);
        stringBuilder.append(", album=").append(this.f14318m);
        stringBuilder.append(", albumId=").append(this.f14319n);
        stringBuilder.append(", albumArtist=").append(this.f14320o);
        stringBuilder.append(", albumArtPath=").append(this.f14321p);
        stringBuilder.append(", playCount=").append(this.f14322q);
        stringBuilder.append(", tempPlayCount=").append(this.f14323r);
        stringBuilder.append(", folderName=").append(this.f14325t);
        stringBuilder.append(", folderPath=").append(this.f14324s);
        stringBuilder.append(", likeIt=").append(this.f14327v);
        stringBuilder.append(", genre=").append(this.f14330y);
        stringBuilder.append(", mimetype=").append(this.f14331z);
        stringBuilder.append(", source=").append(this.f14299A);
        stringBuilder.append(", syncTime=").append(this.f14300B);
        stringBuilder.append(", changedFlag=").append(this.f14301C);
        stringBuilder.append(", backup=").append(this.f14302D);
        stringBuilder.append(", isSupport=").append(this.f14303E);
        stringBuilder.append(", songTrack=").append(this.f14304F);
        stringBuilder.append(", mAlbumArtModifiedTimestamp=").append(this.f14305G);
        stringBuilder.append(", lastPlayTimestamp=").append(this.f14326u).append(" ]");
        return stringBuilder.toString();
    }
}
