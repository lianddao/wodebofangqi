package com.ushareit.listenit;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class fqs {
    private static HashMap<Long, glg> f13244a = new HashMap();

    static {
        try {
            m20476i();
        } catch (Exception e) {
        }
    }

    public static List<glg> m20453a(gla com_ushareit_listenit_gla) {
        List<glg> arrayList = new ArrayList();
        if (com_ushareit_listenit_gla instanceof gkw) {
            arrayList.addAll(m20468e(((gkw) com_ushareit_listenit_gla).f14249b));
        } else if (com_ushareit_listenit_gla instanceof gkv) {
            arrayList.addAll(m20470f(((gkv) com_ushareit_listenit_gla).f14244c));
        } else if (com_ushareit_listenit_gla instanceof gkz) {
            arrayList.addAll(m20472g(((gkz) com_ushareit_listenit_gla).f14279c));
        } else if (com_ushareit_listenit_gla instanceof glc) {
            arrayList.addAll(m20475i(((glc) com_ushareit_listenit_gla).f14283c));
        }
        return arrayList;
    }

    public static int m20458b(gla com_ushareit_listenit_gla) {
        if (com_ushareit_listenit_gla instanceof gkw) {
            return ((gkw) com_ushareit_listenit_gla).f14252e;
        }
        if (com_ushareit_listenit_gla instanceof gkv) {
            return ((gkv) com_ushareit_listenit_gla).f14246e;
        }
        if (com_ushareit_listenit_gla instanceof gkz) {
            return ((gkz) com_ushareit_listenit_gla).f14280d;
        }
        if (com_ushareit_listenit_gla instanceof glc) {
            return ((glc) com_ushareit_listenit_gla).f14289i;
        }
        return 0;
    }

    public static glg m20448a(String str) {
        long d = frf.m20671d(str);
        return d > 0 ? m20447a(d) : null;
    }

    public static glg m20447a(long j) {
        glg com_ushareit_listenit_glg;
        synchronized (f13244a) {
            com_ushareit_listenit_glg = (glg) f13244a.get(Long.valueOf(j));
            if (com_ushareit_listenit_glg != null) {
            } else {
                com_ushareit_listenit_glg = frf.m20634a(j);
                if (com_ushareit_listenit_glg == null) {
                    fse a = frg.m20686a(j);
                    if (a != null) {
                        com_ushareit_listenit_glg = new glg(a);
                    }
                }
                synchronized (f13244a) {
                    if (com_ushareit_listenit_glg != null) {
                        f13244a.put(Long.valueOf(j), com_ushareit_listenit_glg);
                    }
                }
            }
        }
        return com_ushareit_listenit_glg;
    }

    public static List<glg> m20454a(List<Long> list) {
        List<glg> arrayList = new ArrayList(list.size());
        for (Long longValue : list) {
            glg a = m20447a(longValue.longValue());
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    public static void m20455a() {
        for (glg a : m20454a(frf.m20636a(m20449a(" select ", "_id", " from ", "audio_library", " where ", "song_state", "!=? and ", "song_source", "=?"), new String[]{String.valueOf(2), String.valueOf(0)}, "_id"))) {
            m20457a(a);
        }
    }

    public static void m20457a(glg com_ushareit_listenit_glg) {
        if (com_ushareit_listenit_glg != null && com_ushareit_listenit_glg.f14336d != 2 && com_ushareit_listenit_glg.f14348p != 1 && !gyn.m23240f(com_ushareit_listenit_glg.f14342j)) {
            frf.m20661b(com_ushareit_listenit_glg, 1);
            if (frf.m20656b(com_ushareit_listenit_glg.f14344l, com_ushareit_listenit_glg.f14338f, com_ushareit_listenit_glg.f14339g) > 1) {
                frf.m20667c(com_ushareit_listenit_glg);
            } else if (!gef.m21805a().m21835e()) {
                frf.m20667c(com_ushareit_listenit_glg);
            }
            if (gyo.m23264a().m23267a(Long.valueOf(com_ushareit_listenit_glg.f14334b))) {
                gyo.m23264a().m23269b(Long.valueOf(com_ushareit_listenit_glg.f14334b));
            }
        }
    }

    public static void m20456a(int i) {
        synchronized (f13244a) {
            HashMap hashMap = (HashMap) f13244a.clone();
        }
        if (hashMap.size() > 0) {
            for (glg com_ushareit_listenit_glg : hashMap.values()) {
                if (com_ushareit_listenit_glg.f14337e <= 60000) {
                    com_ushareit_listenit_glg.f14336d = i;
                    com_ushareit_listenit_glg.f14350r = 1;
                }
            }
        }
    }

    public static List<glg> m20459b() {
        List<glg> a = m20454a(frf.m20636a(m20449a(" select ", "_id", " from ", "audio_library", " where ", "song_state", "!=?"), new String[]{String.valueOf(2)}, "_id"));
        Collections.sort(a, new fqv());
        return a;
    }

    public static List<glg> m20462b(String str) {
        if (fbb.m18763c(str)) {
            return new ArrayList();
        }
        return m20454a(frf.m20636a(m20449a(" select ", "_id", " from ", "audio_library", " where ", "song_md5", "=? ", " order by sync_time desc"), new String[]{str}, "_id"));
    }

    public static List<glg> m20464c() {
        return m20454a(frf.m20636a(m20449a(" select ", "_id", " from ", "audio_library", " where ", "song_md5", "=?"), new String[]{"0"}, "_id"));
    }

    public static List<glg> m20451a(Context context) {
        return m20460b(gvj.m23034t(context) ? 1 : 0);
    }

    public static List<glg> m20450a(int i, String str, String str2) {
        return m20454a(frf.m20636a(m20449a(" select ", "_id", " from ", "audio_library", " where ", "_size", "=? and ", "title", "=? and ", "artist", "=?"), new String[]{String.valueOf(i), str, str2}, "_id"));
    }

    public static List<glg> m20460b(int i) {
        switch (i) {
            case 0:
                return m20467e();
            case 1:
                return m20469f();
            case 2:
                return m20466d();
            default:
                return new ArrayList();
        }
    }

    public static List<glg> m20466d() {
        return m20454a(frf.m20636a(m20449a(" select ", "_id", " from ", "audio_library", " where ", "song_state", "=? ", " group by _size, title, artist"), new String[]{String.valueOf(0)}, "_id"));
    }

    public static List<glg> m20467e() {
        List<glg> a = m20454a(frf.m20636a(m20449a(" select ", "_id", " from ", "audio_library", " where ", "song_state", "=? ", " group by _size, title, artist"), new String[]{String.valueOf(0)}, "_id"));
        Collections.sort(a, new fqv());
        return a;
    }

    public static List<glg> m20469f() {
        return m20454a(frf.m20636a(m20449a(" select ", "_id", " from ", "audio_library", " where ", "song_state", "=?", " and ", "last_add_timestamp", ">? ", " group by _size, title, artist", " order by last_add_timestamp desc"), new String[]{String.valueOf(0), String.valueOf(0)}, "_id"));
    }

    public static List<gkw> m20471g() {
        Cursor rawQuery = fra.m20531a().m20533b().rawQuery(" select distinct ( artist ), album_art_path, album,  count() as song_count, max(albumart_modified_timestamp) as albumart_modified_timestamp from(select artist, album_art_path, album, albumart_modified_timestamp, song_state from audio_library group by artist, _size, title) where song_state=?  group by artist", gkw.f14248a);
        List<gkw> arrayList = new ArrayList();
        if (!gyn.m23200a(rawQuery)) {
            return arrayList;
        }
        for (int i = 0; i < rawQuery.getCount(); i++) {
            rawQuery.moveToPosition(i);
            arrayList.add(new gkw(rawQuery));
        }
        Collections.sort(arrayList, new fqv());
        rawQuery.close();
        return arrayList;
    }

    public static void m20474h() {
    }

    public static void m20476i() {
        Cursor rawQuery = fra.m20531a().m20533b().rawQuery(" select _id , song_key , song_state , duration , title , artist , album , _data , folder_path , album_art_path , _size , song_genre , song_bitrate , song_mimetype , song_source , song_md5 , sync_time , changed_flag , like_it , song_backup , is_support , play_count , temp_play_count , track , last_play_timestamp , albumart_modified_timestamp from audio_library where song_state=?", glg.f14332a);
        if (gyn.m23200a(rawQuery)) {
            synchronized (f13244a) {
                for (int i = 0; i < rawQuery.getCount(); i++) {
                    rawQuery.moveToPosition(i);
                    glg com_ushareit_listenit_glg = new glg(rawQuery);
                    f13244a.put(Long.valueOf(com_ushareit_listenit_glg.f14334b), com_ushareit_listenit_glg);
                }
            }
            rawQuery.close();
        }
    }

    public static List<gkv> m20477j() {
        Cursor rawQuery = fra.m20531a().m20533b().rawQuery(" select distinct ( album ), artist, album_art_path,  count() as song_count, max(albumart_modified_timestamp) as albumart_modified_timestamp from(select album, artist, album_art_path, song_state, albumart_modified_timestamp from audio_library group by album, _size, title, artist) where song_state=? group by album", gkv.f14242a);
        List<gkv> arrayList = new ArrayList();
        if (!gyn.m23200a(rawQuery)) {
            return arrayList;
        }
        for (int i = 0; i < rawQuery.getCount(); i++) {
            rawQuery.moveToPosition(i);
            arrayList.add(new gkv(rawQuery));
        }
        Collections.sort(arrayList, new fqv());
        rawQuery.close();
        return arrayList;
    }

    public static gkv m20463c(String str) {
        String[] strArr = new String[]{String.valueOf(0), str};
        Cursor rawQuery = fra.m20531a().m20533b().rawQuery(" select distinct ( album ), artist, album_art_path,  count() as song_count, max(albumart_modified_timestamp) as albumart_modified_timestamp from(select album, artist, album_art_path, song_state, albumart_modified_timestamp from audio_library group by album, _size, title, artist)" + " where song_state=? and album=?", strArr);
        if (!gyn.m23200a(rawQuery)) {
            return null;
        }
        gkv com_ushareit_listenit_gkv = new gkv(rawQuery);
        rawQuery.close();
        return com_ushareit_listenit_gkv;
    }

    public static gkw m20465d(String str) {
        String[] strArr = new String[]{String.valueOf(0), str};
        Cursor rawQuery = fra.m20531a().m20533b().rawQuery(" select distinct ( artist ), album_art_path, album,  count() as song_count, max(albumart_modified_timestamp) as albumart_modified_timestamp from(select artist, album_art_path, album, albumart_modified_timestamp, song_state from audio_library group by artist, _size, title)" + " where song_state=? and artist=?", strArr);
        if (!gyn.m23200a(rawQuery)) {
            return null;
        }
        gkw com_ushareit_listenit_gkw = new gkw(rawQuery);
        rawQuery.close();
        return com_ushareit_listenit_gkw;
    }

    public static List<gkz> m20478k() {
        int i = 0;
        String[] strArr = new String[]{String.valueOf(2)};
        Cursor rawQuery = fra.m20531a().m20533b().rawQuery(" select distinct ( folder_path ), folder_name,  count() as song_count from(select folder_path, folder_name, song_state from audio_library group by folder_path, _size, title,artist)" + " where song_state!=? group by folder_path", strArr);
        List<gkz> arrayList = new ArrayList();
        if (!gyn.m23200a(rawQuery)) {
            return arrayList;
        }
        while (i < rawQuery.getCount()) {
            rawQuery.moveToPosition(i);
            arrayList.add(new gkz(rawQuery));
            i++;
        }
        Collections.sort(arrayList, new fqv());
        rawQuery.close();
        return arrayList;
    }

    public static List<gkz> m20479l() {
        Cursor rawQuery = fra.m20531a().m20533b().rawQuery(" select distinct ( folder_path ), folder_name,  count() as song_count from(select folder_path, folder_name, song_state from audio_library group by folder_path, _size, title,artist) where song_state=? group by folder_path", gkz.f14277a);
        List<gkz> arrayList = new ArrayList();
        if (!gyn.m23200a(rawQuery)) {
            return arrayList;
        }
        for (int i = 0; i < rawQuery.getCount(); i++) {
            rawQuery.moveToPosition(i);
            arrayList.add(new gkz(rawQuery));
        }
        Collections.sort(arrayList, new fqv());
        rawQuery.close();
        return arrayList;
    }

    public static List<glc> m20480m() {
        return m20461b(fra.m20531a().m20533b());
    }

    public static List<fnl> m20481n() {
        List<fnl> arrayList = new ArrayList();
        if (fra.m20531a().m20533b() == null) {
            return arrayList;
        }
        Cursor rawQuery = fra.m20531a().m20533b().rawQuery(" select playlist_id, playlist_name, (select count() from audio_library where song_backup>0 and _id in  (select song_id from playlist_song where playlist_song.playlist_id=playlist.playlist_id)) as song_count, (select sum(play_count) from audio_library where song_backup>0 and _id in  (select song_id from playlist_song where playlist_song.playlist_id=playlist.playlist_id)) as play_count from playlist where state=? and visibility=?", fnl.WHERE_ARGS);
        if (!gyn.m23200a(rawQuery)) {
            return arrayList;
        }
        for (int i = 0; i < rawQuery.getCount(); i++) {
            rawQuery.moveToPosition(i);
            arrayList.add(new fnl(rawQuery));
        }
        rawQuery.close();
        return arrayList;
    }

    public static List<glc> m20482o() {
        return m20452a(fra.m20531a().m20533b());
    }

    public static List<glc> m20452a(SQLiteDatabase sQLiteDatabase) {
        List<glc> arrayList = new ArrayList();
        if (sQLiteDatabase == null) {
            return arrayList;
        }
        Cursor rawQuery = sQLiteDatabase.rawQuery(" select playlist_id, playlist_key, playlist_name, sync_time, changed_flag, state, visibility,  (select count() from playlist_song where playlist_song.playlist_id=playlist.playlist_id ) as song_count from playlist order by playlist_key desc ", glc.f14282b);
        if (!gyn.m23200a(rawQuery)) {
            return arrayList;
        }
        for (int i = 0; i < rawQuery.getCount(); i++) {
            rawQuery.moveToPosition(i);
            arrayList.add(new glc(rawQuery));
        }
        rawQuery.close();
        return arrayList;
    }

    public static List<glc> m20461b(SQLiteDatabase sQLiteDatabase) {
        List<glc> arrayList = new ArrayList();
        if (sQLiteDatabase == null) {
            return arrayList;
        }
        Cursor rawQuery = sQLiteDatabase.rawQuery(" select playlist_id, playlist_key, playlist_name, sync_time, changed_flag, state, visibility,  (select count() from playlist_song where playlist_song.playlist_id=playlist.playlist_id ) as song_count from playlist where state=? order by playlist_key desc ", glc.f14281a);
        if (!gyn.m23200a(rawQuery)) {
            return arrayList;
        }
        for (int i = 0; i < rawQuery.getCount(); i++) {
            rawQuery.moveToPosition(i);
            arrayList.add(new glc(rawQuery));
        }
        rawQuery.close();
        return arrayList;
    }

    public static List<gkx> m20483p() {
        Cursor rawQuery = fra.m20531a().m20533b().rawQuery(" select _id , title , _data , _size , duration , last_add_timestamp , artist , album , album_art_path , folder_path , song_genre , song_bitrate from audio_clips_library", null);
        List<gkx> arrayList = new ArrayList();
        if (!gyn.m23200a(rawQuery)) {
            return arrayList;
        }
        for (int i = 0; i < rawQuery.getCount(); i++) {
            rawQuery.moveToPosition(i);
            arrayList.add(new gkx(rawQuery));
        }
        Collections.sort(arrayList, new fqv());
        rawQuery.close();
        return arrayList;
    }

    public static List<glg> m20468e(String str) {
        List<glg> a = m20454a(frf.m20636a(m20449a(" select ", "_id", " from ", "audio_library", " where ", "artist", "=?", " and ", "song_state", "=?", " group by _size, title, artist"), new String[]{str, String.valueOf(0)}, "_id"));
        Collections.sort(a, new fqv());
        return a;
    }

    public static List<glg> m20470f(String str) {
        return m20454a(frf.m20636a(m20449a(" select ", "_id", " ,track from ", "audio_library", " where ", "album", "=? and ", "song_state", "=?", " group by _size, title, artist", " order by track"), new String[]{str, String.valueOf(0)}, "_id"));
    }

    public static List<glg> m20472g(String str) {
        List<glg> a = m20454a(frf.m20636a(m20449a(" select ", "_id", " from ", "audio_library", " where ", "folder_path", "=?", " and ", "song_state", "=?", " group by _size, title, artist"), new String[]{str, String.valueOf(0)}, "_id"));
        Collections.sort(a, new fqv());
        return a;
    }

    public static List<gld> m20473h(String str) {
        int i = 0;
        Cursor rawQuery = fra.m20531a().m20533b().rawQuery(m20449a(" select row_id, row_key, playlist_id, song_id from playlist_song", " where ", "playlist_id", "=?", " and ", "song_id", ">?", " order by row_key asc"), new String[]{str, String.valueOf(0)});
        List<gld> arrayList = new ArrayList();
        if (!gyn.m23200a(rawQuery)) {
            return arrayList;
        }
        while (i < rawQuery.getCount()) {
            rawQuery.moveToPosition(i);
            arrayList.add(new gld(rawQuery));
            i++;
        }
        rawQuery.close();
        return arrayList;
    }

    public static List<glg> m20475i(String str) {
        return m20454a(frf.m20636a(m20449a(" select ", "song_id", " from ", "playlist_song", " where ", "playlist_id", "=?", " and ", "song_id", ">?", " order by row_key asc"), new String[]{str, String.valueOf(0)}, "song_id"));
    }

    public static List<glg> m20484q() {
        String a = m20449a(" select ", "_id", " from ", "audio_library", " where ", "like_it", ">?", " and ", "song_state", "=?", " order by like_it desc");
        String[] strArr = new String[]{String.valueOf(0), String.valueOf(0)};
        List arrayList = new ArrayList();
        Collection a2 = frf.m20636a(a, strArr, "_id");
        if (a2 != null && a2.size() > 0) {
            arrayList.addAll(a2);
        }
        a2 = frg.m20694b();
        if (a2 != null && a2.size() > 0) {
            arrayList.addAll(a2);
        }
        List<glg> a3 = m20454a(arrayList);
        Collections.sort(a3, new fqu());
        return a3;
    }

    public static List<glg> m20485r() {
        return m20454a(frf.m20636a(m20449a(" select ", "_id", " from ", "audio_library", " where ", "song_state", "=?", " and ", "last_add_timestamp", ">?", " group by _size, title, artist", " order by last_add_timestamp desc"), new String[]{String.valueOf(0), String.valueOf(0)}, "_id"));
    }

    public static List<glg> m20486s() {
        String a = m20449a(" select ", "_id", " from ", "audio_library", " where ", "song_state", "=?", " and ", "last_play_timestamp", ">?", " order by last_play_timestamp desc");
        String[] strArr = new String[]{String.valueOf(0), String.valueOf(0)};
        List arrayList = new ArrayList();
        Collection a2 = frf.m20636a(a, strArr, "_id");
        if (a2 != null && a2.size() > 0) {
            arrayList.addAll(a2);
        }
        a2 = frg.m20696c();
        if (a2 != null && a2.size() > 0) {
            arrayList.addAll(a2);
        }
        List<glg> a3 = m20454a(arrayList);
        Collections.sort(a3, new fqw());
        return a3;
    }

    public static List<glg> m20487t() {
        return m20454a(frf.m20636a(m20449a(" select ", "_id", " from ", "audio_library", " where ", "song_state", "=?", " and ", "temp_play_count", ">?"), new String[]{String.valueOf(0), "0"}, "_id"));
    }

    private static String m20449a(String... strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : strArr) {
            stringBuilder.append(append);
        }
        return stringBuilder.toString();
    }
}
