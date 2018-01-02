package com.ushareit.listenit;

import android.database.Cursor;

public class fcu {
    public static final String[] f12446a = new String[]{"_id", "title", "duration", "_size", "_data", "bucket_id", "bucket_display_name", "date_modified"};

    public static fcb m18865a(Cursor cursor) {
        Object string = cursor.getString(4);
        if (!eyh.m18491a((String) string).mo2328c()) {
            return null;
        }
        fcf com_ushareit_listenit_fcf = new fcf();
        int i = cursor.getInt(0);
        com_ushareit_listenit_fcf.m18849a("id", Integer.valueOf(i));
        com_ushareit_listenit_fcf.m18849a("ver", (Object) "");
        com_ushareit_listenit_fcf.m18849a("name", eye.m18480b(string));
        com_ushareit_listenit_fcf.m18849a("has_thumbnail", Boolean.valueOf(true));
        com_ushareit_listenit_fcf.m18849a("file_path", string);
        com_ushareit_listenit_fcf.m18849a("file_size", Long.valueOf(fcq.m18860a(cursor.getLong(3), cursor.getString(4))));
        com_ushareit_listenit_fcf.m18849a("is_exist", Boolean.valueOf(true));
        com_ushareit_listenit_fcf.m18849a("media_id", Integer.valueOf(i));
        com_ushareit_listenit_fcf.m18849a("duration", Long.valueOf(cursor.getLong(2)));
        com_ushareit_listenit_fcf.m18849a("album_id", Integer.valueOf(cursor.getInt(5)));
        com_ushareit_listenit_fcf.m18849a("album_name", cursor.getString(6));
        com_ushareit_listenit_fcf.m18849a("date_modified", Long.valueOf(cursor.getLong(7) * 1000));
        return new fcn(com_ushareit_listenit_fcf);
    }
}
