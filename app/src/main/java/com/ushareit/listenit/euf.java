package com.ushareit.listenit;

import android.database.sqlite.SQLiteDatabase;

public class euf {
    static void m17986a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("alter table events add sn LONG");
    }

    static void m17987b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE headers RENAME TO headers_tmp;");
        sQLiteDatabase.execSQL("CREATE TABLE headers (_id INTEGER PRIMARY KEY,sdk_ver INTEGER ,time_zone INTEGER,commit_id TEXT,pid TEXT,app_token TEXT,app_id TEXT,device_id TEXT,release_channel TEXT,app_ver_name TEXT,app_ver_code INTEGER,os_name TEXT,os_ver TEXT,language TEXT,country TEXT,manufacturer TEXT,device_model TEXT,resolution TEXT,net_type INTEGER,account TEXT,app_device_id TEXT,mac_address TEXT,android_id TEXT,imei TEXT,cid_sn TEXT,build_num TEXT,mobile_data_type INTEGER,promotion_channel TEXT,carrier TEXT );");
        sQLiteDatabase.execSQL("INSERT INTO headers SELECT * FROM headers_tmp;");
        sQLiteDatabase.execSQL("DROP TABLE headers_tmp");
    }
}
