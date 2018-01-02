package com.ushareit.listenit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public final class evl extends SQLiteOpenHelper {
    private static evl f11971a;
    private SQLiteDatabase f11972b;
    private evn f11973c;
    private evo f11974d;
    private evq f11975e;

    public static synchronized evl m18165a(Context context) {
        evl com_ushareit_listenit_evl;
        synchronized (evl.class) {
            if (f11971a == null) {
                f11971a = new evl(context);
            }
            com_ushareit_listenit_evl = f11971a;
        }
        return com_ushareit_listenit_evl;
    }

    protected evl(Context context) {
        this(context, "cmd.db", null, 1);
    }

    protected evl(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.f11972b = null;
        this.f11973c = new evn();
        this.f11974d = new evo();
        this.f11975e = new evq();
    }

    public synchronized void close() {
        try {
            super.close();
            if (this.f11972b != null && this.f11972b.isOpen()) {
                this.f11972b.close();
                this.f11972b = null;
            }
        } catch (Throwable e) {
            exw.m18446a("CMD.Database", e);
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(evm.f11976a);
            sQLiteDatabase.execSQL(evm.f11977b);
            sQLiteDatabase.execSQL(evm.f11978c);
        } catch (Throwable e) {
            exw.m18446a("CMD.Database", e);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onCreate(sQLiteDatabase);
    }

    public synchronized boolean m18169a(eva com_ushareit_listenit_eva) {
        boolean a;
        try {
            this.f11972b = getWritableDatabase();
            this.f11972b.beginTransaction();
            try {
                a = this.f11974d.m18194a(com_ushareit_listenit_eva.m18099a(), com_ushareit_listenit_eva.m18122g(), this.f11972b);
                if (a) {
                    a = this.f11973c.m18184a(com_ushareit_listenit_eva, this.f11972b);
                }
                if (a) {
                    this.f11972b.setTransactionSuccessful();
                }
            } catch (Throwable e) {
                exw.m18444a("CMD.Database", "insertCommand error", e);
                a = false;
                return a;
            } finally {
                this.f11972b.endTransaction();
            }
        } catch (Throwable e2) {
            exw.m18444a("CMD.Database", "insertCommand error", e2);
            a = false;
        }
        return a;
    }

    public synchronized boolean m18172a(String str, evf com_ushareit_listenit_evf) {
        boolean a;
        try {
            this.f11972b = getWritableDatabase();
            a = this.f11973c.m18186a(str, com_ushareit_listenit_evf, this.f11972b);
        } catch (Throwable e) {
            exw.m18444a("CMD.Database", "updateStatus error", e);
            a = false;
        }
        return a;
    }

    public synchronized boolean m18173a(String str, String str2, String str3) {
        boolean a;
        try {
            this.f11972b = getWritableDatabase();
            a = this.f11974d.m18193a(str, str2, str3, this.f11972b);
        } catch (Throwable e) {
            exw.m18444a("CMD.Database", "updateProperty error", e);
            a = false;
        }
        return a;
    }

    public synchronized boolean m18171a(String str, int i) {
        boolean a;
        try {
            this.f11972b = getWritableDatabase();
            a = this.f11973c.m18185a(str, i, this.f11972b);
        } catch (Throwable e) {
            exw.m18444a("CMD.Database", "updateStatus error", e);
            a = false;
        }
        return a;
    }

    public synchronized void m18168a(String str) {
        try {
            this.f11972b = getWritableDatabase();
            this.f11972b.beginTransaction();
            this.f11973c.m18183a(str, this.f11972b);
            this.f11974d.m18192a(str, this.f11972b);
            this.f11972b.setTransactionSuccessful();
            this.f11972b.endTransaction();
        } catch (Exception e) {
            this.f11972b.endTransaction();
        } catch (Throwable e2) {
            exw.m18444a("CMD.Database", "removeCommand error", e2);
        } catch (Throwable th) {
            this.f11972b.endTransaction();
        }
    }

    public synchronized List<eva> m18166a() {
        List<eva> list;
        try {
            this.f11972b = getWritableDatabase();
            List<eva> a = this.f11973c.m18182a(this.f11972b);
            for (eva com_ushareit_listenit_eva : a) {
                com_ushareit_listenit_eva.m18105a(this.f11974d.m18195b(com_ushareit_listenit_eva.m18099a(), this.f11972b));
            }
            list = a;
        } catch (Throwable e) {
            exw.m18444a("CMD.Database", "listAllActiveCommands error", e);
            list = new ArrayList();
        }
        return list;
    }

    public synchronized List<eva> m18175b() {
        List<eva> list;
        try {
            this.f11972b = getWritableDatabase();
            List<eva> b = this.f11973c.m18188b(this.f11972b);
            for (eva com_ushareit_listenit_eva : b) {
                com_ushareit_listenit_eva.m18105a(this.f11974d.m18195b(com_ushareit_listenit_eva.m18099a(), this.f11972b));
            }
            list = b;
        } catch (Throwable e) {
            exw.m18444a("CMD.Database", "listAllActiveCommands error", e);
            list = new ArrayList();
        }
        return list;
    }

    public synchronized eva m18174b(String str) {
        eva b;
        try {
            this.f11972b = getWritableDatabase();
            b = this.f11973c.m18187b(str, this.f11972b);
            if (b != null) {
                b.m18105a(this.f11974d.m18195b(str, this.f11972b));
            }
        } catch (Throwable e) {
            exw.m18444a("CMD.Database", "getCommand error", e);
            b = null;
        }
        return b;
    }

    public synchronized List<eva> m18167a(String str, String str2) {
        List<eva> list;
        try {
            this.f11972b = getWritableDatabase();
            List<String> a = this.f11974d.m18191a(str, str2, this.f11972b);
            List<eva> arrayList = new ArrayList();
            if (a.size() > 0) {
                for (String b : a) {
                    eva b2 = m18174b(b);
                    if (b2 != null) {
                        arrayList.add(b2);
                    }
                }
            }
            list = arrayList;
        } catch (Throwable e) {
            exw.m18444a("CMD.Database", "getCommand error", e);
            list = new ArrayList();
        }
        return list;
    }

    public synchronized boolean m18170a(evp com_ushareit_listenit_evp) {
        boolean a;
        try {
            this.f11972b = getWritableDatabase();
            a = this.f11975e.m18200a(com_ushareit_listenit_evp, this.f11972b);
        } catch (Throwable e) {
            exw.m18444a("CMD.Database", "insertReport error", e);
            a = false;
        }
        return a;
    }

    public synchronized void m18176b(evp com_ushareit_listenit_evp) {
        try {
            this.f11972b = getWritableDatabase();
            this.f11975e.m18202b(com_ushareit_listenit_evp, this.f11972b);
        } catch (Throwable e) {
            exw.m18444a("CMD.Database", "removeReport error", e);
        }
    }

    public synchronized List<evp> m18177c() {
        List<evp> b;
        try {
            this.f11972b = getWritableDatabase();
            b = this.f11975e.m18201b(this.f11972b);
        } catch (Throwable e) {
            exw.m18444a("CMD.Database", "listReports error", e);
            b = new ArrayList();
        }
        return b;
    }

    public synchronized int m18178d() {
        int a;
        try {
            this.f11972b = getReadableDatabase();
            a = this.f11975e.m18199a(this.f11972b);
        } catch (Throwable e) {
            exw.m18444a("CMD.Database", "countReports error", e);
            a = 0;
        }
        return a;
    }
}
