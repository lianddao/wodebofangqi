package com.ushareit.listenit;

import android.os.Bundle;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class br extends bp {
    static boolean f7482a = false;
    final gh<bs> f7483b = new gh();
    final gh<bs> f7484c = new gh();
    final String f7485d;
    boolean f7486e;
    boolean f7487f;
    boolean f7488g;
    private aq f7489h;

    br(String str, aq aqVar, boolean z) {
        this.f7485d = str;
        this.f7489h = aqVar;
        this.f7486e = z;
    }

    void m9555a(aq aqVar) {
        this.f7489h = aqVar;
    }

    private bs m9552b(int i, Bundle bundle, bq<Object> bqVar) {
        bs bsVar = new bs(this, i, bundle, bqVar);
        bsVar.f7576d = bqVar.mo1255a(i, bundle);
        return bsVar;
    }

    private bs m9553c(int i, Bundle bundle, bq<Object> bqVar) {
        try {
            this.f7488g = true;
            bs b = m9552b(i, bundle, bqVar);
            m9556a(b);
            return b;
        } finally {
            this.f7488g = false;
        }
    }

    void m9556a(bs bsVar) {
        this.f7483b.m21991b(bsVar.f7573a, bsVar);
        if (this.f7486e) {
            bsVar.m9627a();
        }
    }

    public <D> dz<D> mo1085a(int i, Bundle bundle, bq<D> bqVar) {
        if (this.f7488g) {
            throw new IllegalStateException("Called while creating a loader");
        }
        bs bsVar = (bs) this.f7483b.m21987a(i);
        if (f7482a) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
        }
        if (bsVar == null) {
            bsVar = m9553c(i, bundle, bqVar);
            if (f7482a) {
                Log.v("LoaderManager", "  Created new loader " + bsVar);
            }
        } else {
            if (f7482a) {
                Log.v("LoaderManager", "  Re-using existing loader " + bsVar);
            }
            bsVar.f7575c = bqVar;
        }
        if (bsVar.f7577e && this.f7486e) {
            bsVar.m9632b(bsVar.f7576d, bsVar.f7579g);
        }
        return bsVar.f7576d;
    }

    void m9559b() {
        if (f7482a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f7486e) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f7486e = true;
        for (int b = this.f7483b.m21989b() - 1; b >= 0; b--) {
            ((bs) this.f7483b.m21995e(b)).m9627a();
        }
    }

    void m9560c() {
        if (f7482a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.f7486e) {
            for (int b = this.f7483b.m21989b() - 1; b >= 0; b--) {
                ((bs) this.f7483b.m21995e(b)).m9635e();
            }
            this.f7486e = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    void m9561d() {
        if (f7482a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.f7486e) {
            this.f7487f = true;
            this.f7486e = false;
            for (int b = this.f7483b.m21989b() - 1; b >= 0; b--) {
                ((bs) this.f7483b.m21995e(b)).m9631b();
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    void m9562e() {
        if (this.f7487f) {
            if (f7482a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f7487f = false;
            for (int b = this.f7483b.m21989b() - 1; b >= 0; b--) {
                ((bs) this.f7483b.m21995e(b)).m9633c();
            }
        }
    }

    void m9563f() {
        for (int b = this.f7483b.m21989b() - 1; b >= 0; b--) {
            ((bs) this.f7483b.m21995e(b)).f7583k = true;
        }
    }

    void m9564g() {
        for (int b = this.f7483b.m21989b() - 1; b >= 0; b--) {
            ((bs) this.f7483b.m21995e(b)).m9634d();
        }
    }

    void m9565h() {
        int b;
        if (!this.f7487f) {
            if (f7482a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (b = this.f7483b.m21989b() - 1; b >= 0; b--) {
                ((bs) this.f7483b.m21995e(b)).m9636f();
            }
            this.f7483b.m21992c();
        }
        if (f7482a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (b = this.f7484c.m21989b() - 1; b >= 0; b--) {
            ((bs) this.f7484c.m21995e(b)).m9636f();
        }
        this.f7484c.m21992c();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        ft.m20887a(this.f7489h, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void m9557a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.f7483b.m21989b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f7483b.m21989b(); i2++) {
                bs bsVar = (bs) this.f7483b.m21995e(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f7483b.m21994d(i2));
                printWriter.print(": ");
                printWriter.println(bsVar.toString());
                bsVar.m9630a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f7484c.m21989b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.f7484c.m21989b()) {
                bsVar = (bs) this.f7484c.m21995e(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f7484c.m21994d(i));
                printWriter.print(": ");
                printWriter.println(bsVar.toString());
                bsVar.m9630a(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public boolean mo1086a() {
        int b = this.f7483b.m21989b();
        boolean z = false;
        for (int i = 0; i < b; i++) {
            int i2;
            bs bsVar = (bs) this.f7483b.m21995e(i);
            if (!bsVar.f7580h || bsVar.f7578f) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            z |= i2;
        }
        return z;
    }
}
