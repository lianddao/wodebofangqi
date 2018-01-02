package com.ushareit.listenit;

import android.database.sqlite.SQLiteDatabase;

public abstract class any {
    protected final ans f4978j;

    protected any(ans com_ushareit_listenit_ans) {
        this.f4978j = com_ushareit_listenit_ans;
    }

    public static String m6399a(String str, anq[] com_ushareit_listenit_anqArr) {
        StringBuilder stringBuilder = new StringBuilder("SELECT ");
        for (int i = 0; i < com_ushareit_listenit_anqArr.length - 1; i++) {
            stringBuilder.append(com_ushareit_listenit_anqArr[i].f4976b);
            stringBuilder.append(", ");
        }
        stringBuilder.append(com_ushareit_listenit_anqArr[com_ushareit_listenit_anqArr.length - 1].f4976b);
        stringBuilder.append(" FROM ");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static String m6400a(String str, anq[] com_ushareit_listenit_anqArr, anq com_ushareit_listenit_anq) {
        StringBuilder stringBuilder = new StringBuilder(m6399a(str, com_ushareit_listenit_anqArr));
        stringBuilder.append(" WHERE ");
        stringBuilder.append(com_ushareit_listenit_anq.f4976b);
        stringBuilder.append(" = ?");
        return stringBuilder.toString();
    }

    private String mo735c() {
        anq[] b = mo734b();
        if (b.length < 1) {
            return null;
        }
        String str = "";
        for (int i = 0; i < b.length - 1; i++) {
            str = str + b[i].m6398a() + ", ";
        }
        return str + b[b.length - 1].m6398a();
    }

    public abstract String mo733a();

    public void m6403a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE " + mo733a() + " (" + mo735c() + ")");
    }

    public void m6404b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + mo733a());
    }

    public abstract anq[] mo734b();

    public void m6406e() {
    }

    protected SQLiteDatabase m6407f() {
        return this.f4978j.m6418a();
    }
}
