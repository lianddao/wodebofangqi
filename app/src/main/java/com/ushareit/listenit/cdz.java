package com.ushareit.listenit;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class cdz {
    private static final Set<cdz> f8158a = Collections.newSetFromMap(new WeakHashMap());

    public static Set<cdz> m10921a() {
        Set<cdz> set;
        synchronized (f8158a) {
            set = f8158a;
        }
        return set;
    }

    public <C extends cdt> C mo1996a(cdr<C> com_ushareit_listenit_cdr_C) {
        throw new UnsupportedOperationException();
    }

    public <A extends cdq, R extends ceg, T extends dlu<R, A>> T mo1997a(T t) {
        throw new UnsupportedOperationException();
    }

    public void mo1998a(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void mo1971a(ceb com_ushareit_listenit_ceb);

    public abstract void mo1972a(cec com_ushareit_listenit_cec);

    public void mo1999a(dot com_ushareit_listenit_dot) {
        throw new UnsupportedOperationException();
    }

    public abstract void mo1973a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public boolean mo2000a(doo com_ushareit_listenit_doo) {
        throw new UnsupportedOperationException();
    }

    public Context mo2001b() {
        throw new UnsupportedOperationException();
    }

    public <A extends cdq, T extends dlu<? extends ceg, A>> T mo2002b(T t) {
        throw new UnsupportedOperationException();
    }

    public abstract void mo1974b(ceb com_ushareit_listenit_ceb);

    public abstract void mo1975b(cec com_ushareit_listenit_cec);

    public void mo2003b(dot com_ushareit_listenit_dot) {
        throw new UnsupportedOperationException();
    }

    public Looper mo2004c() {
        throw new UnsupportedOperationException();
    }

    public void mo2005d() {
        throw new UnsupportedOperationException();
    }

    public abstract void mo1976e();

    public abstract ConnectionResult mo1977f();

    public abstract void mo1978g();

    public abstract ced<Status> mo1979h();

    public abstract boolean mo1980i();
}
