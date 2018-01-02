package com.ushareit.listenit;

import android.database.Cursor;

public class fct {
    public static final String[] f12445a = new String[]{"_id", "title", "_size", "_data", "bucket_id", "bucket_display_name", "date_modified", "orientation", "datetaken"};

    public static fcb m18864a(Cursor cursor) {
        Object string = cursor.getString(3);
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
        com_ushareit_listenit_fcf.m18849a("file_size", Long.valueOf(fcq.m18860a(cursor.getLong(2), cursor.getString(3))));
        com_ushareit_listenit_fcf.m18849a("is_exist", Boolean.valueOf(true));
        com_ushareit_listenit_fcf.m18849a("media_id", Integer.valueOf(i));
        com_ushareit_listenit_fcf.m18849a("album_id", Integer.valueOf(cursor.getInt(4)));
        com_ushareit_listenit_fcf.m18849a("album_name", cursor.getString(5));
        com_ushareit_listenit_fcf.m18849a("date_modified", Long.valueOf(cursor.getLong(6) * 1000));
        com_ushareit_listenit_fcf.m18849a("date_taken", Long.valueOf(cursor.getLong(8)));
        try {
            com_ushareit_listenit_fcf.m18849a("orientation", Integer.valueOf(Integer.valueOf(cursor.getString(7)).intValue()));
        } catch (Exception e) {
        }
        return new fcm(com_ushareit_listenit_fcf);
    }
}
