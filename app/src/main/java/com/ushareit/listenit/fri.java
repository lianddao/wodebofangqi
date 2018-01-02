package com.ushareit.listenit;

import android.database.Cursor;

public class fri {
    public String f13280a;
    public String f13281b;
    public String f13282c;
    public String f13283d;
    public String f13284e;
    public int f13285f;
    public int f13286g;
    public int f13287h;
    public String f13288i;
    public int f13289j = 0;
    public int f13290k = 0;

    public fri(Cursor cursor) {
        this.f13280a = cursor.getString(cursor.getColumnIndex("id"));
        this.f13281b = cursor.getString(cursor.getColumnIndex("name"));
        this.f13282c = cursor.getString(cursor.getColumnIndex("artist"));
        this.f13283d = cursor.getString(cursor.getColumnIndex("album"));
        this.f13284e = cursor.getString(cursor.getColumnIndex("genre"));
        this.f13285f = cursor.getInt(cursor.getColumnIndex("bitrate"));
        this.f13286g = cursor.getInt(cursor.getColumnIndex("duration"));
        this.f13287h = cursor.getInt(cursor.getColumnIndex("size"));
        this.f13288i = cursor.getString(cursor.getColumnIndex("mimetype"));
    }

    public fri(ecb com_ushareit_listenit_ecb) {
        this.f13280a = com_ushareit_listenit_ecb.m16706d();
        this.f13281b = (String) com_ushareit_listenit_ecb.m16699a("na").m16701a(String.class);
        this.f13282c = (String) com_ushareit_listenit_ecb.m16699a(fnn.KEY_ARTIST).m16701a(String.class);
        this.f13283d = (String) com_ushareit_listenit_ecb.m16699a(fnn.KEY_ALBUM).m16701a(String.class);
        this.f13284e = (String) com_ushareit_listenit_ecb.m16699a(fnn.KEY_GENRE).m16701a(String.class);
        this.f13285f = ((Integer) com_ushareit_listenit_ecb.m16699a(fnn.KEY_BITRATE).m16701a(Integer.class)).intValue();
        this.f13286g = ((Integer) com_ushareit_listenit_ecb.m16699a("du").m16701a(Integer.class)).intValue();
        this.f13287h = ((Integer) com_ushareit_listenit_ecb.m16699a(fnn.KEY_SIZE).m16701a(Integer.class)).intValue();
        this.f13288i = (String) com_ushareit_listenit_ecb.m16699a(fnn.KEY_MIMETYPE).m16701a(String.class);
    }

    public String m20702a() {
        return this.f13281b;
    }

    public String m20704b() {
        return this.f13282c;
    }

    public boolean m20705c() {
        return this.f13289j > 0;
    }

    public void m20703a(boolean z) {
        this.f13289j = z ? 1 : 0;
    }

    public String toString() {
        return "NearbySong{mSongId='" + this.f13280a + '\'' + ", mSongName='" + this.f13281b + '\'' + ", mArtist='" + this.f13282c + '\'' + ", mSize=" + this.f13287h + ", mIsCollected=" + this.f13289j + '}';
    }
}
