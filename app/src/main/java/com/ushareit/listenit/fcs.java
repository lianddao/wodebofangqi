package com.ushareit.listenit;

import android.database.Cursor;

public class fcs {
    public static final String[] f12444a = new String[]{"_id", "title", "album_id", "album", "artist_id", "artist", "duration", "_size", "_data", "date_modified"};

    public static fcb m18863a(Cursor cursor) {
        Object string = cursor.getString(8);
        if (!eyh.m18491a((String) string).mo2328c()) {
            return null;
        }
        fcf com_ushareit_listenit_fcf = new fcf();
        int i = cursor.getInt(0);
        com_ushareit_listenit_fcf.m18849a("id", Integer.valueOf(i));
        com_ushareit_listenit_fcf.m18849a("ver", (Object) "");
        com_ushareit_listenit_fcf.m18849a("name", cursor.getString(1));
        com_ushareit_listenit_fcf.m18849a("has_thumbnail", Boolean.valueOf(true));
        com_ushareit_listenit_fcf.m18849a("file_path", string);
        com_ushareit_listenit_fcf.m18849a("file_size", Long.valueOf(fcq.m18860a(cursor.getLong(7), cursor.getString(8))));
        com_ushareit_listenit_fcf.m18849a("is_exist", Boolean.valueOf(true));
        com_ushareit_listenit_fcf.m18849a("media_id", Integer.valueOf(i));
        com_ushareit_listenit_fcf.m18849a("album_id", Integer.valueOf(cursor.getInt(2)));
        com_ushareit_listenit_fcf.m18849a("album_name", cursor.getString(3));
        com_ushareit_listenit_fcf.m18849a("artist_id", Integer.valueOf(cursor.getInt(4)));
        com_ushareit_listenit_fcf.m18849a("artist_name", cursor.getString(5));
        com_ushareit_listenit_fcf.m18849a("duration", Long.valueOf(cursor.getLong(6)));
        com_ushareit_listenit_fcf.m18849a("date_modified", Long.valueOf(cursor.getLong(9) * 1000));
        return new fcl(com_ushareit_listenit_fcf);
    }
}
