package com.ushareit.listenit;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Looper;

public class ans {
    private static final String f4989a = ("SELECT tokens." + anz.f5010a.f4976b + ", " + "tokens" + "." + anz.f5011b.f4976b + ", " + "events" + "." + anr.f4979a.f4976b + ", " + "events" + "." + anr.f4981c.f4976b + ", " + "events" + "." + anr.f4982d.f4976b + ", " + "events" + "." + anr.f4983e.f4976b + ", " + "events" + "." + anr.f4984f.f4976b + ", " + "events" + "." + anr.f4985g.f4976b + ", " + "events" + "." + anr.f4986h.f4976b + " FROM " + "events" + " JOIN " + "tokens" + " ON " + "events" + "." + anr.f4980b.f4976b + " = " + "tokens" + "." + anz.f5010a.f4976b + " ORDER BY " + "events" + "." + anr.f4983e.f4976b + " ASC");
    private final Context f4990b;
    private final anz f4991c = new anz(this);
    private final anr f4992d = new anr(this);
    private SQLiteOpenHelper f4993e;

    public ans(Context context) {
        this.f4990b = context;
    }

    private synchronized SQLiteDatabase m6416h() {
        if (this.f4993e == null) {
            this.f4993e = new anv(this.f4990b, this);
        }
        return this.f4993e.getWritableDatabase();
    }

    public Cursor m6417a(int i) {
        return m6418a().rawQuery(f4989a + " LIMIT " + String.valueOf(i), null);
    }

    public SQLiteDatabase m6418a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return m6416h();
        }
        throw new IllegalStateException("Cannot call getDatabase from the UI thread!");
    }

    public <T> AsyncTask m6419a(anw<T> com_ushareit_listenit_anw_T, anp<T> com_ushareit_listenit_anp_T) {
        return atz.m7154a(new ant(this, com_ushareit_listenit_anw_T, com_ushareit_listenit_anp_T), new Void[0]);
    }

    public AsyncTask m6420a(aov com_ushareit_listenit_aov, anp<String> com_ushareit_listenit_anp_java_lang_String) {
        return m6419a(new anu(this, com_ushareit_listenit_aov), (anp) com_ushareit_listenit_anp_java_lang_String);
    }

    public boolean m6421a(String str) {
        return this.f4992d.m6410a(str);
    }

    public void m6422b() {
        for (any e : m6423c()) {
            e.m6406e();
        }
        if (this.f4993e != null) {
            this.f4993e.close();
            this.f4993e = null;
        }
    }

    public any[] m6423c() {
        return new any[]{this.f4991c, this.f4992d};
    }

    public Cursor m6424d() {
        return this.f4992d.mo735c();
    }

    public Cursor m6425e() {
        return this.f4992d.m6413d();
    }

    public Cursor m6426f() {
        return this.f4991c.mo735c();
    }

    public void m6427g() {
        this.f4991c.m6440d();
    }
}
