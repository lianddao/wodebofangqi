package com.ushareit.listenit;

import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;

class ant extends AsyncTask<Void, Void, T> {
    final /* synthetic */ anw f4994a;
    final /* synthetic */ anp f4995b;
    final /* synthetic */ ans f4996c;
    private anx f4997d;

    ant(ans com_ushareit_listenit_ans, anw com_ushareit_listenit_anw, anp com_ushareit_listenit_anp) {
        this.f4996c = com_ushareit_listenit_ans;
        this.f4994a = com_ushareit_listenit_anw;
        this.f4995b = com_ushareit_listenit_anp;
    }

    protected T m6428a(Void... voidArr) {
        T t = null;
        try {
            t = this.f4994a.mo736b();
            this.f4997d = this.f4994a.m6431c();
            return t;
        } catch (SQLiteException e) {
            this.f4997d = anx.UNKNOWN;
            return t;
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m6428a((Void[]) objArr);
    }

    protected void onPostExecute(T t) {
        if (this.f4997d == null) {
            this.f4995b.mo751a(t);
        } else {
            this.f4995b.mo750a(this.f4997d.m6434a(), this.f4997d.m6435b());
        }
        this.f4995b.m6395a();
    }
}
