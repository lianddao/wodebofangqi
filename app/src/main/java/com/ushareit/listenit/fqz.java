package com.ushareit.listenit;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class fqz {
    public static synchronized SQLiteDatabase m20501a() {
        SQLiteDatabase b;
        synchronized (fqz.class) {
            b = fra.m20531a().m20533b();
        }
        return b;
    }

    public static synchronized void m20502a(gkx com_ushareit_listenit_gkx) {
        synchronized (fqz.class) {
            try {
                long c = gvj.m22916c();
                String e = fqm.m20393a().m20400f().mo2330e();
                m20501a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", Long.valueOf(c));
                contentValues.put("title", com_ushareit_listenit_gkx.f14255b);
                contentValues.put("_data", com_ushareit_listenit_gkx.f14256c);
                contentValues.put("_size", Integer.valueOf(gyn.m23241g(com_ushareit_listenit_gkx.f14256c)));
                contentValues.put("duration", Integer.valueOf(com_ushareit_listenit_gkx.f14258e));
                contentValues.put("last_add_timestamp", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("artist", com_ushareit_listenit_gkx.f14260g);
                contentValues.put("album", com_ushareit_listenit_gkx.f14261h);
                contentValues.put("album_art_path", com_ushareit_listenit_gkx.f14262i);
                contentValues.put("folder_path", e);
                contentValues.put("song_genre", com_ushareit_listenit_gkx.f14264k);
                contentValues.put("song_bitrate", Integer.valueOf(com_ushareit_listenit_gkx.f14265l));
                m20501a().insert("audio_clips_library", null, contentValues);
                m20501a().setTransactionSuccessful();
                m20501a().endTransaction();
            } catch (Throwable e2) {
                exw.m18450b("AudioClipsDatabase", "insert audio clip to database error", e2);
                m20501a().setTransactionSuccessful();
                m20501a().endTransaction();
            } catch (Throwable th) {
                m20501a().setTransactionSuccessful();
                m20501a().endTransaction();
            }
        }
    }

    public static synchronized void m20503b(gkx com_ushareit_listenit_gkx) {
        synchronized (fqz.class) {
            try {
                m20501a().delete("audio_clips_library", "_id=?", new String[]{String.valueOf(com_ushareit_listenit_gkx.f14254a)});
                exw.m18443a("AudioClipsDatabase", "removeAudioClip: songName=" + com_ushareit_listenit_gkx.f14255b);
            } catch (Exception e) {
            }
        }
    }
}
