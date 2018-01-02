package com.ushareit.listenit;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class frd {
    public static synchronized SQLiteDatabase m20596a() {
        SQLiteDatabase b;
        synchronized (frd.class) {
            b = fra.m20531a().m20533b();
        }
        return b;
    }

    public static synchronized boolean m20610a(String str) {
        boolean z = false;
        synchronized (frd.class) {
            String str2 = "select * from playlist where playlist_name=?";
            String[] strArr = new String[]{str};
            exw.m18443a("PlaylistDatabase", "isPlayListExistsWidthName: sql=" + str2);
            Cursor rawQuery = m20596a().rawQuery(str2, strArr);
            if (gyn.m23200a(rawQuery)) {
                if (rawQuery.getCount() > 0) {
                    z = true;
                }
                rawQuery.close();
            }
        }
        return z;
    }

    public static synchronized boolean m20617b(String str) {
        boolean z = false;
        synchronized (frd.class) {
            String str2 = "select * from playlist where playlist_id=?";
            String[] strArr = new String[]{str};
            exw.m18443a("PlaylistDatabase", "isPlayListExistsWidthId: sql=" + str2);
            Cursor rawQuery = m20596a().rawQuery(str2, strArr);
            if (gyn.m23200a(rawQuery)) {
                if (rawQuery.getCount() > 0) {
                    z = true;
                }
                rawQuery.close();
            }
        }
        return z;
    }

    public static synchronized boolean m20611a(String str, String str2) {
        boolean z = false;
        synchronized (frd.class) {
            String str3 = "select * from playlist where playlist_name=? and playlist_id!=?";
            String[] strArr = new String[]{str, str2};
            exw.m18443a("PlaylistDatabase", "isPlayListExistsWidthName: sql=" + str3);
            Cursor rawQuery = m20596a().rawQuery(str3, strArr);
            if (gyn.m23200a(rawQuery)) {
                if (rawQuery.getCount() > 0) {
                    z = true;
                }
                rawQuery.close();
            }
        }
        return z;
    }

    public static synchronized boolean m20619c(String str) {
        boolean z = false;
        synchronized (frd.class) {
            String str2 = "select * from playlist where playlist_id=? and state=?";
            String[] strArr = new String[]{str, String.valueOf(0)};
            exw.m18443a("PlaylistDatabase", "isPlaylistCollected: sql=" + str2);
            Cursor rawQuery = m20596a().rawQuery(str2, strArr);
            if (gyn.m23200a(rawQuery)) {
                if (rawQuery.getCount() > 0) {
                    z = true;
                }
                rawQuery.close();
            }
        }
        return z;
    }

    public static synchronized void m20614b(String str, String str2) {
        synchronized (frd.class) {
            int f = gvj.m22945f(eys.m18562a()) + 1;
            try {
                m20596a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("playlist_id", str);
                contentValues.put("playlist_name", str2);
                contentValues.put("state", Integer.valueOf(0));
                contentValues.put("visibility", Integer.valueOf(0));
                contentValues.put("playlist_key", Integer.valueOf(f));
                contentValues.put("changed_flag", Integer.valueOf(1));
                String str3 = "playlist_id=?";
                m20596a().update("playlist", contentValues, str3, new String[]{str});
                gvj.m22894a(eys.m18562a(), f);
                exw.m18443a("PlaylistDatabase", "relivePlaylist: whereclause=" + str3);
            } catch (Exception e) {
            } finally {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            }
        }
    }

    public static synchronized String m20597a(String str, int i) {
        String a;
        SQLiteDatabase sQLiteDatabase = null;
        synchronized (frd.class) {
            int f = gvj.m22945f(eys.m18562a()) + 1;
            a = fbb.m18749a();
            try {
                m20596a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("playlist_id", a);
                contentValues.put("playlist_key", Integer.valueOf(f));
                contentValues.put("playlist_name", str);
                contentValues.put("sync_time", Long.valueOf(0));
                contentValues.put("changed_flag", Integer.valueOf(1));
                contentValues.put("state", Integer.valueOf(0));
                contentValues.put("visibility", Integer.valueOf(i));
                m20596a().insert("playlist", null, contentValues);
                fle.m19717b().m19730b(true);
                gvj.m22894a(eys.m18562a(), f);
                exw.m18443a("PlaylistDatabase", "insertPlaylist: value=" + contentValues.toString());
            } catch (Exception e) {
                Object obj = sQLiteDatabase;
                return a;
            } finally {
                m20596a().setTransactionSuccessful();
                sQLiteDatabase = m20596a();
                sQLiteDatabase.endTransaction();
            }
        }
        return a;
    }

    public static synchronized String m20598a(String str, String str2, int i) {
        synchronized (frd.class) {
            int f = gvj.m22945f(eys.m18562a()) + 1;
            try {
                m20596a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("playlist_id", str);
                contentValues.put("playlist_key", Integer.valueOf(f));
                contentValues.put("playlist_name", str2);
                contentValues.put("sync_time", Long.valueOf(0));
                contentValues.put("changed_flag", Integer.valueOf(1));
                contentValues.put("state", Integer.valueOf(0));
                contentValues.put("visibility", Integer.valueOf(i));
                m20596a().insert("playlist", null, contentValues);
                fle.m19717b().m19730b(true);
                gvj.m22894a(eys.m18562a(), f);
                exw.m18443a("PlaylistDatabase", "insertPlaylist: value=" + contentValues.toString());
            } catch (Exception e) {
                str = null;
                gvj.m23010n();
                return str;
            } finally {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            }
            gvj.m23010n();
        }
        return str;
    }

    public static synchronized void m20602a(fnk com_ushareit_listenit_fnk) {
        synchronized (frd.class) {
            int f = gvj.m22945f(eys.m18562a()) + 1;
            try {
                m20596a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("playlist_id", com_ushareit_listenit_fnk.getId());
                contentValues.put("playlist_key", Integer.valueOf(f));
                contentValues.put("playlist_name", com_ushareit_listenit_fnk.getNa());
                contentValues.put("sync_time", Long.valueOf(com_ushareit_listenit_fnk.getSt()));
                contentValues.put("changed_flag", Integer.valueOf(0));
                contentValues.put("state", Integer.valueOf(com_ushareit_listenit_fnk.getSta()));
                contentValues.put("visibility", Integer.valueOf(com_ushareit_listenit_fnk.getVi()));
                m20596a().insert("playlist", null, contentValues);
                exw.m18443a("PlaylistDatabase", "insertPlaylist: value=" + contentValues.toString());
                gvj.m22894a(eys.m18562a(), f);
            } catch (Exception e) {
            } finally {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            }
        }
    }

    public static synchronized void m20612b(fnk com_ushareit_listenit_fnk) {
        synchronized (frd.class) {
            try {
                m20596a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("playlist_id", com_ushareit_listenit_fnk.getId());
                contentValues.put("playlist_name", com_ushareit_listenit_fnk.getNa());
                contentValues.put("sync_time", Long.valueOf(com_ushareit_listenit_fnk.getSt()));
                contentValues.put("state", Integer.valueOf(com_ushareit_listenit_fnk.getSta()));
                contentValues.put("visibility", Integer.valueOf(com_ushareit_listenit_fnk.getVi()));
                String str = "playlist_id=?";
                m20596a().update("playlist", contentValues, str, new String[]{com_ushareit_listenit_fnk.getId()});
                exw.m18443a("PlaylistDatabase", "updatePlaylist: whereclause=" + str);
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            } catch (Exception e) {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            } catch (Throwable th) {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            }
        }
    }

    public static synchronized void m20613b(String str, int i) {
        synchronized (frd.class) {
            try {
                m20596a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("changed_flag", Integer.valueOf(i));
                String str2 = "playlist_id=?";
                m20596a().update("playlist", contentValues, str2, new String[]{str});
                exw.m18443a("PlaylistDatabase", "updatePlaylistChangedFlag: whereclause=" + str2);
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            } catch (Exception e) {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            } catch (Throwable th) {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            }
        }
    }

    public static synchronized void m20606a(List<String> list, int i) {
        synchronized (frd.class) {
            exw.m18443a("PlaylistDatabase", "updatePlaylistChangedFlag: flag=" + i);
            try {
                m20596a().beginTransaction();
                for (String str : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("changed_flag", Integer.valueOf(i));
                    String[] strArr = new String[]{str};
                    m20596a().update("playlist", contentValues, "playlist_id=?", strArr);
                }
            } catch (Exception e) {
            } finally {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            }
        }
    }

    public static synchronized void m20607a(List<String> list, long j) {
        synchronized (frd.class) {
            exw.m18443a("PlaylistDatabase", "updatePlaylistsSyncTime: syncTime=" + j);
            try {
                m20596a().beginTransaction();
                for (String str : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("sync_time", Long.valueOf(j));
                    String[] strArr = new String[]{str};
                    m20596a().update("playlist", contentValues, "playlist_id=?", strArr);
                }
            } catch (Exception e) {
            } finally {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            }
        }
    }

    public static synchronized void m20618c(String str, String str2) {
        synchronized (frd.class) {
            try {
                m20596a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("playlist_name", str);
                contentValues.put("changed_flag", Integer.valueOf(1));
                String str3 = "playlist_id=?";
                if (m20596a().update("playlist", contentValues, str3, new String[]{str2}) > 0) {
                    fle.m19717b().m19730b(true);
                }
                exw.m18443a("PlaylistDatabase", "updatePlaylistName: whereclause=" + str3);
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            } catch (Exception e) {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            } catch (Throwable th) {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            }
        }
    }

    public static synchronized void m20600a(int i, String str) {
        synchronized (frd.class) {
            try {
                m20596a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("playlist_key", Integer.valueOf(i));
                contentValues.put("changed_flag", Integer.valueOf(1));
                String str2 = "playlist_id=?";
                if (m20596a().update("playlist", contentValues, str2, new String[]{str}) > 0) {
                    fle.m19717b().m19730b(true);
                }
                exw.m18443a("PlaylistDatabase", "updatePlaylistKey: whereclause=" + str2);
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            } catch (Exception e) {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            } catch (Throwable th) {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            }
        }
    }

    public static synchronized void m20615b(List<String> list, int i) {
        synchronized (frd.class) {
            exw.m18443a("PlaylistDatabase", "updatePlaylistKeys");
            try {
                m20596a().beginTransaction();
                for (String str : list) {
                    ContentValues contentValues = new ContentValues();
                    int i2 = i + 1;
                    contentValues.put("playlist_key", Integer.valueOf(i));
                    contentValues.put("changed_flag", Integer.valueOf(1));
                    String[] strArr = new String[]{str};
                    m20596a().update("playlist", contentValues, "playlist_id=?", strArr);
                    i = i2;
                }
                fle.m19717b().m19730b(true);
            } catch (Exception e) {
            } finally {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            }
        }
    }

    public static synchronized void m20601a(SQLiteDatabase sQLiteDatabase, String str) {
        synchronized (frd.class) {
            String a = fbb.m18749a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("playlist_id", a);
            String[] strArr = new String[]{str};
            sQLiteDatabase.update("playlist", contentValues, "playlist_id=?", strArr);
            contentValues = new ContentValues();
            contentValues.put("playlist_id", a);
            a = "playlist_id=?";
            sQLiteDatabase.update("playlist_song", contentValues, a, strArr);
            exw.m18443a("PlaylistDatabase", "updatePlaylistIdToUUID: whereclause=" + a);
        }
    }

    public static synchronized void m20604a(String str, long j, int i) {
        synchronized (frd.class) {
            try {
                m20596a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("row_key", Integer.valueOf(i));
                String str2 = "playlist_id=? AND song_id=?";
                if (m20596a().update("playlist_song", contentValues, str2, new String[]{str, String.valueOf(j)}) > 0) {
                    m20620d(str);
                }
                exw.m18443a("PlaylistDatabase", "updatePlaylistRecordKey: whereclause=" + str2);
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            } catch (Exception e) {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            } catch (Throwable th) {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            }
        }
    }

    public static synchronized void m20620d(String str) {
        synchronized (frd.class) {
            m20613b(str, 1);
            fle.m19717b().m19730b(true);
        }
    }

    public static synchronized String m20621e(String str) {
        String str2;
        synchronized (frd.class) {
            str2 = "select playlist_id from playlist where playlist_name=?";
            String[] strArr = new String[]{str};
            exw.m18443a("PlaylistDatabase", "getPlayListId: sql=" + str2);
            Cursor rawQuery = m20596a().rawQuery(str2, strArr);
            if (gyn.m23200a(rawQuery)) {
                str2 = rawQuery.getString(rawQuery.getColumnIndex("playlist_id"));
                rawQuery.close();
            } else {
                str2 = null;
            }
        }
        return str2;
    }

    public static synchronized List<String> m20599a(long j) {
        List arrayList;
        synchronized (frd.class) {
            String str = "select playlist_id from playlist_song where song_id=?";
            String[] strArr = new String[]{String.valueOf(j)};
            exw.m18443a("PlaylistDatabase", "getPlayListIds: sql=" + str);
            Cursor rawQuery = m20596a().rawQuery(str, strArr);
            arrayList = new ArrayList();
            if (gyn.m23200a(rawQuery)) {
                for (int i = 0; i < rawQuery.getCount(); i++) {
                    rawQuery.moveToPosition(i);
                    int columnIndex = rawQuery.getColumnIndex("playlist_id");
                    if (columnIndex != -1) {
                        arrayList.add(rawQuery.getString(columnIndex));
                    }
                }
                rawQuery.close();
            }
        }
        return arrayList;
    }

    public static synchronized void m20622f(String str) {
        synchronized (frd.class) {
            try {
                boolean e = gef.m21805a().m21835e();
                m20596a().beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", Integer.valueOf(1));
                if (e) {
                    contentValues.put("changed_flag", Integer.valueOf(1));
                } else {
                    contentValues.put("sync_time", Integer.valueOf(0));
                }
                String str2 = "playlist_id=?";
                if (m20596a().update("playlist", contentValues, str2, new String[]{str}) > 0) {
                    if (e) {
                        fle.m19717b().m19730b(true);
                    } else {
                        fle.m19717b().m19728b(0);
                        fle.m19717b().m19730b(false);
                    }
                }
                exw.m18443a("PlaylistDatabase", "removePlayListWidthName: whereclause=" + str2);
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            } catch (Exception e2) {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            } catch (Throwable th) {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            }
        }
    }

    public static synchronized boolean m20609a(long j, String str) {
        boolean z = false;
        synchronized (frd.class) {
            String str2 = "select row_id from playlist_song where playlist_id=? and   song_id=?";
            Cursor rawQuery = m20596a().rawQuery(str2, new String[]{str, String.valueOf(j)});
            exw.m18443a("PlaylistDatabase", "isPlayListSongExists: sql=" + str2);
            if (gyn.m23200a(rawQuery)) {
                if (rawQuery.getCount() > 0) {
                    z = true;
                }
                rawQuery.close();
            }
        }
        return z;
    }

    public static synchronized void m20608a(List<glg> list, String str) {
        synchronized (frd.class) {
            exw.m18443a("PlaylistDatabase", "insertPlaylistSongs");
            try {
                m20596a().beginTransaction();
                int g = gvj.m22954g(eys.m18562a());
                int i = g;
                for (glg com_ushareit_listenit_glg : list) {
                    if (!m20609a(com_ushareit_listenit_glg.f14334b, str)) {
                        i++;
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("row_id", Integer.valueOf(i));
                        contentValues.put("row_key", Integer.valueOf(i));
                        contentValues.put("playlist_id", str);
                        contentValues.put("song_id", Long.valueOf(com_ushareit_listenit_glg.f14334b));
                        m20596a().insert("playlist_song", null, contentValues);
                    }
                }
                gvj.m22907b(eys.m18562a(), i);
                m20620d(str);
            } catch (Exception e) {
            } finally {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            }
        }
    }

    public static synchronized void m20616b(List<Long> list, String str) {
        synchronized (frd.class) {
            exw.m18443a("0426", "insertCollectSongToPlaylist:" + list.size());
            try {
                m20596a().beginTransaction();
                int g = gvj.m22954g(eys.m18562a());
                int i = g;
                for (Long l : list) {
                    i++;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("row_id", Integer.valueOf(i));
                    contentValues.put("row_key", Integer.valueOf(i));
                    contentValues.put("playlist_id", str);
                    contentValues.put("song_id", l);
                    m20596a().insert("playlist_song", null, contentValues);
                }
                gvj.m22907b(eys.m18562a(), i);
                m20620d(str);
            } catch (Exception e) {
            } finally {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            }
        }
    }

    public static synchronized void m20605a(String str, List<glg> list) {
        synchronized (frd.class) {
            try {
                m20596a().beginTransaction();
                for (glg com_ushareit_listenit_glg : list) {
                    String str2 = "playlist_id=? and song_id=?";
                    m20596a().delete("playlist_song", str2, new String[]{str, String.valueOf(com_ushareit_listenit_glg.f14334b)});
                    exw.m18443a("PlaylistDatabase", "removePlayListSong: songId=" + com_ushareit_listenit_glg.f14334b + ", playlistId=" + str + ", wc=" + str2);
                }
                m20620d(str);
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            } catch (Exception e) {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            } catch (Throwable th) {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            }
        }
        return;
    }

    public static synchronized void m20603a(String str, long j) {
        synchronized (frd.class) {
            try {
                m20596a().beginTransaction();
                String str2 = "playlist_id=? and song_id=?";
                if (m20596a().delete("playlist_song", str2, new String[]{str, String.valueOf(j)}) > 0) {
                    m20620d(str);
                }
                exw.m18443a("PlaylistDatabase", "removePlayListSong: songId=" + j + ", playlistId=" + str + ", wc=" + str2);
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            } catch (Exception e) {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            } catch (Throwable th) {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            }
        }
    }

    public static synchronized void m20623g(String str) {
        synchronized (frd.class) {
            try {
                m20596a().beginTransaction();
                String str2 = "playlist_id=?";
                m20596a().delete("playlist_song", str2, new String[]{str});
                exw.m18443a("PlaylistDatabase", "removePlayListSong: playlistId=" + str + ", wc=" + str2);
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            } catch (Exception e) {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            } catch (Throwable th) {
                m20596a().setTransactionSuccessful();
                m20596a().endTransaction();
            }
        }
    }
}
