package com.ushareit.listenit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class aq<E> extends ao {
    private final Activity f4752a;
    final Context f4753b;
    final int f4754c;
    public final at f4755d;
    private final Handler f4756e;
    private gg<String, bp> f4757f;
    private boolean f4758g;
    private br f4759h;
    private boolean f4760i;
    private boolean f4761j;

    aq(ak akVar) {
        this(akVar, akVar, akVar.f433c, 0);
    }

    aq(Activity activity, Context context, Handler handler, int i) {
        this.f4755d = new at();
        this.f4752a = activity;
        this.f4753b = context;
        this.f4756e = handler;
        this.f4754c = i;
    }

    public void mo720a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean mo721a(ah ahVar) {
        return true;
    }

    public LayoutInflater mo723b() {
        return (LayoutInflater) this.f4753b.getSystemService("layout_inflater");
    }

    public void mo725c() {
    }

    public void mo718a(ah ahVar, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.f4753b.startActivity(intent);
    }

    public void mo719a(ah ahVar, String[] strArr, int i) {
    }

    public boolean mo722a(String str) {
        return false;
    }

    public boolean mo726d() {
        return true;
    }

    public int mo727e() {
        return this.f4754c;
    }

    public View mo635a(int i) {
        return null;
    }

    public boolean mo636a() {
        return true;
    }

    Activity m6164f() {
        return this.f4752a;
    }

    public Context m6165g() {
        return this.f4753b;
    }

    Handler m6166h() {
        return this.f4756e;
    }

    at m6167i() {
        return this.f4755d;
    }

    br m6168j() {
        if (this.f4759h != null) {
            return this.f4759h;
        }
        this.f4760i = true;
        this.f4759h = m6148a("(root)", this.f4761j, true);
        return this.f4759h;
    }

    void m6159b(String str) {
        if (this.f4757f != null) {
            br brVar = (br) this.f4757f.get(str);
            if (brVar != null && !brVar.f7487f) {
                brVar.m9565h();
                this.f4757f.remove(str);
            }
        }
    }

    void mo724b(ah ahVar) {
    }

    boolean m6169k() {
        return this.f4758g;
    }

    void m6170l() {
        if (!this.f4761j) {
            this.f4761j = true;
            if (this.f4759h != null) {
                this.f4759h.m9559b();
            } else if (!this.f4760i) {
                this.f4759h = m6148a("(root)", this.f4761j, false);
                if (!(this.f4759h == null || this.f4759h.f7486e)) {
                    this.f4759h.m9559b();
                }
            }
            this.f4760i = true;
        }
    }

    void m6153a(boolean z) {
        this.f4758g = z;
        if (this.f4759h != null && this.f4761j) {
            this.f4761j = false;
            if (z) {
                this.f4759h.m9561d();
            } else {
                this.f4759h.m9560c();
            }
        }
    }

    void m6171m() {
        if (this.f4759h != null) {
            this.f4759h.m9565h();
        }
    }

    void m6172n() {
        if (this.f4757f != null) {
            int size = this.f4757f.size();
            br[] brVarArr = new br[size];
            for (int i = size - 1; i >= 0; i--) {
                brVarArr[i] = (br) this.f4757f.m20345c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                br brVar = brVarArr[i2];
                brVar.m9562e();
                brVar.m9564g();
            }
        }
    }

    br m6148a(String str, boolean z, boolean z2) {
        if (this.f4757f == null) {
            this.f4757f = new gg();
        }
        br brVar = (br) this.f4757f.get(str);
        if (brVar != null) {
            brVar.m9555a(this);
            return brVar;
        } else if (!z2) {
            return brVar;
        } else {
            brVar = new br(str, this, z);
            this.f4757f.put(str, brVar);
            return brVar;
        }
    }

    gg<String, bp> m6173o() {
        int i;
        int i2 = 0;
        if (this.f4757f != null) {
            int size = this.f4757f.size();
            br[] brVarArr = new br[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                brVarArr[i3] = (br) this.f4757f.m20345c(i3);
            }
            boolean k = m6169k();
            i = 0;
            while (i2 < size) {
                br brVar = brVarArr[i2];
                if (!brVar.f7487f && k) {
                    if (!brVar.f7486e) {
                        brVar.m9559b();
                    }
                    brVar.m9561d();
                }
                if (brVar.f7487f) {
                    i = 1;
                } else {
                    brVar.m9565h();
                    this.f4757f.remove(brVar.f7485d);
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i != 0) {
            return this.f4757f;
        }
        return null;
    }

    void m6151a(gg<String, bp> ggVar) {
        this.f4757f = ggVar;
    }

    void m6160b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.f4761j);
        if (this.f4759h != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f4759h)));
            printWriter.println(":");
            this.f4759h.m9557a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }
}
