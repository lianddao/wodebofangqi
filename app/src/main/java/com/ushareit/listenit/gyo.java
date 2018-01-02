package com.ushareit.listenit;

import android.content.Context;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class gyo {
    private static gyo f14930a = new gyo();
    private List<Long> f14931b = new CopyOnWriteArrayList();

    public static gyo m23264a() {
        if (f14930a == null) {
            f14930a = new gyo();
        }
        return f14930a;
    }

    private gyo() {
        String w = gvj.m23040w(eys.m18562a());
        if (!fbb.m18763c(w)) {
            String[] split = w.split(",");
            if (split != null && split.length != 0) {
                for (String parseLong : split) {
                    this.f14931b.add(Long.valueOf(Long.parseLong(parseLong)));
                }
                exw.m18443a("NewSongManager", "mNewSongIds=" + this.f14931b);
            }
        }
    }

    public void m23265a(Context context) {
        StringBuilder stringBuilder = new StringBuilder("");
        int size = this.f14931b.size() - 1;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(this.f14931b.get(i)).append(",");
        }
        if (this.f14931b.size() > 0) {
            stringBuilder.append(this.f14931b.get(size));
        }
        exw.m18443a("NewSongManager", "saveUserNewSong: newSongIds=" + stringBuilder.toString() + ", mNewSongIds=" + this.f14931b.toString());
        gvj.m22942e(context, stringBuilder.toString());
    }

    public boolean m23270b(Context context) {
        exw.m18443a("NewSongManager", "hasNewSongs: sognIds=" + this.f14931b.toString());
        return this.f14931b.size() > 0;
    }

    public int m23268b() {
        return this.f14931b.size();
    }

    public void m23271c(Context context) {
        exw.m18443a("NewSongManager", "clearUserNewSong:");
        this.f14931b.clear();
        gvj.m22942e(context, "");
    }

    public boolean m23267a(Long l) {
        return this.f14931b.contains(l);
    }

    public void m23266a(Context context, Long l) {
        exw.m18443a("NewSongManager", "addNewSong: songId=" + l + ", sognIds=" + this.f14931b.toString());
        if (!this.f14931b.contains(l)) {
            this.f14931b.add(l);
        }
    }

    public void m23269b(Long l) {
        exw.m18443a("NewSongManager", "removeNewSong: songId=" + l + ", sognIds=" + this.f14931b.toString());
        if (this.f14931b.contains(l)) {
            this.f14931b.remove(l);
        }
    }
}
