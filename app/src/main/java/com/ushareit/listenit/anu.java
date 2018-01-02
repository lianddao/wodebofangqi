package com.ushareit.listenit;

import android.database.sqlite.SQLiteDatabase;

class anu extends aoa<String> {
    final /* synthetic */ aov f4999a;
    final /* synthetic */ ans f5000b;

    anu(ans com_ushareit_listenit_ans, aov com_ushareit_listenit_aov) {
        this.f5000b = com_ushareit_listenit_ans;
        this.f4999a = com_ushareit_listenit_aov;
    }

    public String m6432a() {
        try {
            SQLiteDatabase a = this.f5000b.m6418a();
            a.beginTransaction();
            String a2 = this.f4999a.m6494d() != null ? this.f5000b.f4992d.m6409a(this.f5000b.f4991c.m6437a(this.f4999a.m6494d()), this.f4999a.mo737a().f5137c, this.f4999a.mo738b(), this.f4999a.m6495e(), this.f4999a.m6496f(), this.f4999a.m6497g(), this.f4999a.m6498h()) : null;
            a.setTransactionSuccessful();
            a.endTransaction();
            return a2;
        } catch (Exception e) {
            m6429a(anx.DATABASE_INSERT);
            return null;
        }
    }

    public /* synthetic */ Object mo736b() {
        return m6432a();
    }
}
