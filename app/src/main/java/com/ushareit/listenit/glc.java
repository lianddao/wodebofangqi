package com.ushareit.listenit;

import android.database.Cursor;

public class glc extends gla {
    public static final String[] f14281a = new String[]{String.valueOf(0)};
    public static final String[] f14282b = null;
    public String f14283c;
    public int f14284d;
    public String f14285e;
    public long f14286f;
    public int f14287g;
    public int f14288h;
    public int f14289i;
    public int f14290j;
    public long f14291k = -1;

    public glc(Cursor cursor) {
        super(cursor);
    }

    public void mo2560a(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("playlist_name");
        int columnIndex2 = cursor.getColumnIndex("playlist_id");
        int columnIndex3 = cursor.getColumnIndex("playlist_key");
        int columnIndex4 = cursor.getColumnIndex(fnl.SONG_NUMBER);
        int columnIndex5 = cursor.getColumnIndex("sync_time");
        int columnIndex6 = cursor.getColumnIndex("changed_flag");
        int columnIndex7 = cursor.getColumnIndex("state");
        int columnIndex8 = cursor.getColumnIndex("visibility");
        this.f14283c = cursor.getString(columnIndex2);
        this.f14284d = cursor.getInt(columnIndex3);
        this.f14285e = cursor.getString(columnIndex);
        this.f14289i = cursor.getInt(columnIndex4);
        this.f14286f = cursor.getLong(columnIndex5);
        this.f14287g = cursor.getInt(columnIndex6);
        this.f14288h = cursor.getInt(columnIndex7);
        this.f14290j = cursor.getInt(columnIndex8);
    }

    private long m22331h() {
        long j = 0;
        for (glg com_ushareit_listenit_glg : fqs.m20475i(this.f14283c)) {
            long j2;
            if (j < com_ushareit_listenit_glg.f14357y) {
                j2 = com_ushareit_listenit_glg.f14357y;
            } else {
                j2 = j;
            }
            j = j2;
        }
        return j;
    }

    public String mo2557a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("playlistitem").append("_").append(this.f14285e);
        return stringBuilder.toString();
    }

    public int mo2561b() {
        return this.f14289i;
    }

    public void mo2559a(int i) {
        this.f14289i = i;
    }

    public long mo2702d() {
        if (this.f14291k == -1) {
            this.f14291k = m22331h();
        }
        return this.f14291k;
    }

    public void mo2701a(long j) {
        this.f14291k = j;
    }

    public String mo2562c() {
        return this.f14285e;
    }

    public int mo2703e() {
        return 8;
    }
}
