package com.ushareit.listenit;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import java.util.UUID;

public class anz extends any {
    public static final anq f5010a = new anq(0, "token_id", "TEXT PRIMARY KEY");
    public static final anq f5011b = new anq(1, "token", "TEXT");
    public static final anq[] f5012c = new anq[]{f5010a, f5011b};
    private static final String f5013d = anz.class.getSimpleName();
    private static final String f5014e = any.m6399a("tokens", f5012c);
    private static final String f5015f = any.m6400a("tokens", f5012c, f5011b);
    private static final String f5016g = ("DELETE FROM tokens WHERE NOT EXISTS (SELECT 1 FROM events WHERE tokens." + f5010a.f4976b + " = " + "events" + "." + anr.f4980b.f4976b + ")");

    public anz(ans com_ushareit_listenit_ans) {
        super(com_ushareit_listenit_ans);
    }

    public String mo733a() {
        return "tokens";
    }

    String m6437a(String str) {
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Invalid token.");
        }
        Cursor rawQuery;
        try {
            rawQuery = m6407f().rawQuery(f5015f, new String[]{str});
            try {
                String string = rawQuery.moveToNext() ? rawQuery.getString(f5010a.f4975a) : null;
                if (TextUtils.isEmpty(string)) {
                    string = UUID.randomUUID().toString();
                    ContentValues contentValues = new ContentValues(2);
                    contentValues.put(f5010a.f4976b, string);
                    contentValues.put(f5011b.f4976b, str);
                    m6407f().insertOrThrow("tokens", null, contentValues);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else if (rawQuery != null) {
                    rawQuery.close();
                }
                return string;
            } catch (Throwable th2) {
                th = th2;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    public anq[] mo734b() {
        return f5012c;
    }

    Cursor mo735c() {
        return m6407f().rawQuery(f5014e, null);
    }

    public void m6440d() {
        try {
            m6407f().execSQL(f5016g);
        } catch (SQLException e) {
        }
    }
}
