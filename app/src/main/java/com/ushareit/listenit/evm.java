package com.ushareit.listenit;

final class evm {
    public static String f11976a = "CREATE TABLE IF NOT EXISTS commands (_id TEXT PRIMARY KEY,type TEXT,name TEXT,start_date LONG,end_date LONG,need_report INTEGER,max_retry INTEGER,status TEXT,retry_count INTEGER,arrived_time LONG,data1 TEXT,data2 TEXT,data3 TEXT,data4 TEXT );";
    public static String f11977b = "CREATE TABLE IF NOT EXISTS properties (cmd_id TEXT,prop_key TEXT,prop_value TEXT );";
    public static String f11978c = "CREATE TABLE IF NOT EXISTS report (cmd_id TEXT,status TEXT,detail TEXT,duration LONG );";
}
