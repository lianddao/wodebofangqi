package com.ushareit.listenit;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class gxv {
    public static void m23108a(SQLiteDatabase sQLiteDatabase, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" DROP TABLE ").append(str);
        sQLiteDatabase.execSQL(stringBuilder.toString());
    }

    public static void m23110a(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        if (strArr.length > 0 && strArr.length == strArr2.length) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("UPDATE ").append(str).append(" SET ");
            int length = strArr.length - 1;
            for (int i = 0; i < length; i++) {
                stringBuilder.append(strArr[i]).append("=").append(strArr2[i]).append(" , ");
            }
            stringBuilder.append(strArr[length]).append("=").append(strArr2[length]);
            exw.m18443a("DBUtils", "initColumn: sql=" + stringBuilder.toString());
            sQLiteDatabase.execSQL(stringBuilder.toString());
        }
    }

    public static void m23109a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        String str3 = str + "_temp";
        sQLiteDatabase.execSQL("ALTER TABLE " + str + " RENAME TO " + str3);
        sQLiteDatabase.execSQL(str2);
        String b = m23111b(sQLiteDatabase, str3);
        String str4 = "INSERT INTO " + str + " (" + b + ") " + " SELECT " + b + " FROM " + str3;
        exw.m18443a("DBUtils", "getColumnNames: columns=" + b);
        sQLiteDatabase.execSQL(str4);
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str3);
    }

    private static String m23111b(SQLiteDatabase sQLiteDatabase, String str) {
        Exception e;
        Throwable th;
        StringBuilder stringBuilder = new StringBuilder();
        Cursor rawQuery;
        try {
            rawQuery = sQLiteDatabase.rawQuery("PRAGMA table_info(" + str + ")", null);
            if (rawQuery != null) {
                try {
                    int columnIndex = rawQuery.getColumnIndex("name");
                    int count = rawQuery.getCount() - 1;
                    if (-1 != columnIndex && count >= 0) {
                        for (int i = 0; i < count; i++) {
                            rawQuery.moveToPosition(i);
                            stringBuilder.append(rawQuery.getString(columnIndex)).append(", ");
                        }
                        if (count > 0) {
                            rawQuery.moveToPosition(count);
                            stringBuilder.append(rawQuery.getString(columnIndex));
                        }
                    } else if (rawQuery == null) {
                        return null;
                    } else {
                        rawQuery.close();
                        return null;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e3) {
            Exception exception = e3;
            rawQuery = null;
            e = exception;
            try {
                e.printStackTrace();
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return stringBuilder.toString();
            } catch (Throwable th2) {
                th = th2;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            rawQuery = null;
            th = th4;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return stringBuilder.toString();
    }
}
