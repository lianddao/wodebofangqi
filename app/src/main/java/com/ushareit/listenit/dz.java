package com.ushareit.listenit;

import android.content.Context;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class dz<D> {
    int f8087f;
    eb<D> f8088g;
    ea<D> f8089h;
    Context f8090i;
    boolean f8091j = false;
    boolean f8092k = false;
    boolean f8093l = true;
    boolean f8094m = false;
    boolean f8095n = false;

    public dz(Context context) {
        this.f8090i = context.getApplicationContext();
    }

    public void m10747b(D d) {
        if (this.f8088g != null) {
            this.f8088g.mo1102a(this, d);
        }
    }

    public void m10750g() {
        if (this.f8089h != null) {
            this.f8089h.mo1101a(this);
        }
    }

    public void m10742a(int i, eb<D> ebVar) {
        if (this.f8088g != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f8088g = ebVar;
        this.f8087f = i;
    }

    public void m10744a(eb<D> ebVar) {
        if (this.f8088g == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f8088g != ebVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f8088g = null;
        }
    }

    public void m10743a(ea<D> eaVar) {
        if (this.f8089h != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f8089h = eaVar;
    }

    public void m10746b(ea<D> eaVar) {
        if (this.f8089h == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f8089h != eaVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f8089h = null;
        }
    }

    public boolean m10751h() {
        return this.f8092k;
    }

    public final void m10752i() {
        this.f8091j = true;
        this.f8093l = false;
        this.f8092k = false;
        mo1265j();
    }

    protected void mo1265j() {
    }

    public boolean m10754k() {
        return mo1263b();
    }

    protected boolean mo1263b() {
        return false;
    }

    public void m10755l() {
        mo1261a();
    }

    protected void mo1261a() {
    }

    public void m10756m() {
        this.f8091j = false;
        m10757n();
    }

    protected void m10757n() {
    }

    public void m10758o() {
        m10759p();
        this.f8093l = true;
        this.f8091j = false;
        this.f8092k = false;
        this.f8094m = false;
        this.f8095n = false;
    }

    protected void m10759p() {
    }

    public void m10760q() {
        this.f8095n = false;
    }

    public void m10761r() {
        if (this.f8095n) {
            m10762s();
        }
    }

    public void m10762s() {
        if (this.f8091j) {
            m10755l();
        } else {
            this.f8094m = true;
        }
    }

    public String m10749c(D d) {
        StringBuilder stringBuilder = new StringBuilder(64);
        ft.m20887a(d, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        ft.m20887a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.f8087f);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void mo1262a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f8087f);
        printWriter.print(" mListener=");
        printWriter.println(this.f8088g);
        if (this.f8091j || this.f8094m || this.f8095n) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f8091j);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f8094m);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f8095n);
        }
        if (this.f8092k || this.f8093l) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f8092k);
            printWriter.print(" mReset=");
            printWriter.println(this.f8093l);
        }
    }
}
