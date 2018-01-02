package com.ushareit.listenit;

import android.os.Bundle;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class bs implements ea<Object>, eb<Object> {
    final int f7573a;
    final Bundle f7574b;
    bq<Object> f7575c;
    dz<Object> f7576d;
    boolean f7577e;
    boolean f7578f;
    Object f7579g;
    boolean f7580h;
    boolean f7581i;
    boolean f7582j;
    boolean f7583k;
    boolean f7584l;
    boolean f7585m;
    bs f7586n;
    final /* synthetic */ br f7587o;

    public bs(br brVar, int i, Bundle bundle, bq<Object> bqVar) {
        this.f7587o = brVar;
        this.f7573a = i;
        this.f7574b = bundle;
        this.f7575c = bqVar;
    }

    void m9627a() {
        if (this.f7581i && this.f7582j) {
            this.f7580h = true;
        } else if (!this.f7580h) {
            this.f7580h = true;
            if (br.f7482a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            if (this.f7576d == null && this.f7575c != null) {
                this.f7576d = this.f7575c.mo1255a(this.f7573a, this.f7574b);
            }
            if (this.f7576d == null) {
                return;
            }
            if (!this.f7576d.getClass().isMemberClass() || Modifier.isStatic(this.f7576d.getClass().getModifiers())) {
                if (!this.f7585m) {
                    this.f7576d.m10742a(this.f7573a, this);
                    this.f7576d.m10743a((ea) this);
                    this.f7585m = true;
                }
                this.f7576d.m10752i();
                return;
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f7576d);
        }
    }

    void m9631b() {
        if (br.f7482a) {
            Log.v("LoaderManager", "  Retaining: " + this);
        }
        this.f7581i = true;
        this.f7582j = this.f7580h;
        this.f7580h = false;
        this.f7575c = null;
    }

    void m9633c() {
        if (this.f7581i) {
            if (br.f7482a) {
                Log.v("LoaderManager", "  Finished Retaining: " + this);
            }
            this.f7581i = false;
            if (!(this.f7580h == this.f7582j || this.f7580h)) {
                m9635e();
            }
        }
        if (this.f7580h && this.f7577e && !this.f7583k) {
            m9632b(this.f7576d, this.f7579g);
        }
    }

    void m9634d() {
        if (this.f7580h && this.f7583k) {
            this.f7583k = false;
            if (this.f7577e && !this.f7581i) {
                m9632b(this.f7576d, this.f7579g);
            }
        }
    }

    void m9635e() {
        if (br.f7482a) {
            Log.v("LoaderManager", "  Stopping: " + this);
        }
        this.f7580h = false;
        if (!this.f7581i && this.f7576d != null && this.f7585m) {
            this.f7585m = false;
            this.f7576d.m10744a((eb) this);
            this.f7576d.m10746b((ea) this);
            this.f7576d.m10756m();
        }
    }

    void m9636f() {
        String str;
        bq bqVar = null;
        if (br.f7482a) {
            Log.v("LoaderManager", "  Destroying: " + this);
        }
        this.f7584l = true;
        boolean z = this.f7578f;
        this.f7578f = false;
        if (this.f7575c != null && this.f7576d != null && this.f7577e && z) {
            if (br.f7482a) {
                Log.v("LoaderManager", "  Reseting: " + this);
            }
            if (this.f7587o.f7489h != null) {
                String str2 = this.f7587o.f7489h.f4755d.f5393v;
                this.f7587o.f7489h.f4755d.f5393v = "onLoaderReset";
                str = str2;
            } else {
                str = null;
            }
            try {
                this.f7575c.mo1256a(this.f7576d);
            } finally {
                bqVar = this.f7587o.f7489h;
                if (bqVar != null) {
                    bqVar = this.f7587o.f7489h.f4755d;
                    bqVar.f5393v = str;
                }
            }
        }
        this.f7575c = bqVar;
        this.f7579g = bqVar;
        this.f7577e = false;
        if (this.f7576d != null) {
            if (this.f7585m) {
                this.f7585m = false;
                this.f7576d.m10744a((eb) this);
                this.f7576d.m10746b((ea) this);
            }
            this.f7576d.m10758o();
        }
        if (this.f7586n != null) {
            this.f7586n.m9636f();
        }
    }

    public void mo1101a(dz<Object> dzVar) {
        if (br.f7482a) {
            Log.v("LoaderManager", "onLoadCanceled: " + this);
        }
        if (this.f7584l) {
            if (br.f7482a) {
                Log.v("LoaderManager", "  Ignoring load canceled -- destroyed");
            }
        } else if (this.f7587o.f7483b.m21987a(this.f7573a) == this) {
            bs bsVar = this.f7586n;
            if (bsVar != null) {
                if (br.f7482a) {
                    Log.v("LoaderManager", "  Switching to pending loader: " + bsVar);
                }
                this.f7586n = null;
                this.f7587o.f7483b.m21991b(this.f7573a, null);
                m9636f();
                this.f7587o.m9556a(bsVar);
            }
        } else if (br.f7482a) {
            Log.v("LoaderManager", "  Ignoring load canceled -- not active");
        }
    }

    public void mo1102a(dz<Object> dzVar, Object obj) {
        if (br.f7482a) {
            Log.v("LoaderManager", "onLoadComplete: " + this);
        }
        if (this.f7584l) {
            if (br.f7482a) {
                Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
            }
        } else if (this.f7587o.f7483b.m21987a(this.f7573a) == this) {
            bs bsVar = this.f7586n;
            if (bsVar != null) {
                if (br.f7482a) {
                    Log.v("LoaderManager", "  Switching to pending loader: " + bsVar);
                }
                this.f7586n = null;
                this.f7587o.f7483b.m21991b(this.f7573a, null);
                m9636f();
                this.f7587o.m9556a(bsVar);
                return;
            }
            if (!(this.f7579g == obj && this.f7577e)) {
                this.f7579g = obj;
                this.f7577e = true;
                if (this.f7580h) {
                    m9632b(dzVar, obj);
                }
            }
            bsVar = (bs) this.f7587o.f7484c.m21987a(this.f7573a);
            if (!(bsVar == null || bsVar == this)) {
                bsVar.f7578f = false;
                bsVar.m9636f();
                this.f7587o.f7484c.m21993c(this.f7573a);
            }
            if (this.f7587o.f7489h != null && !this.f7587o.mo1086a()) {
                this.f7587o.f7489h.f4755d.m7087d();
            }
        } else if (br.f7482a) {
            Log.v("LoaderManager", "  Ignoring load complete -- not active");
        }
    }

    void m9632b(dz<Object> dzVar, Object obj) {
        String str;
        if (this.f7575c != null) {
            if (this.f7587o.f7489h != null) {
                String str2 = this.f7587o.f7489h.f4755d.f5393v;
                this.f7587o.f7489h.f4755d.f5393v = "onLoadFinished";
                str = str2;
            } else {
                str = null;
            }
            try {
                if (br.f7482a) {
                    Log.v("LoaderManager", "  onLoadFinished in " + dzVar + ": " + dzVar.m10749c(obj));
                }
                this.f7575c.mo1257a((dz) dzVar, obj);
                this.f7578f = true;
            } finally {
                if (this.f7587o.f7489h != null) {
                    this.f7587o.f7489h.f4755d.f5393v = str;
                }
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("LoaderInfo{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" #");
        stringBuilder.append(this.f7573a);
        stringBuilder.append(" : ");
        ft.m20887a(this.f7576d, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void m9630a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f7573a);
        printWriter.print(" mArgs=");
        printWriter.println(this.f7574b);
        printWriter.print(str);
        printWriter.print("mCallbacks=");
        printWriter.println(this.f7575c);
        printWriter.print(str);
        printWriter.print("mLoader=");
        printWriter.println(this.f7576d);
        if (this.f7576d != null) {
            this.f7576d.mo1262a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f7577e || this.f7578f) {
            printWriter.print(str);
            printWriter.print("mHaveData=");
            printWriter.print(this.f7577e);
            printWriter.print("  mDeliveredData=");
            printWriter.println(this.f7578f);
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(this.f7579g);
        }
        printWriter.print(str);
        printWriter.print("mStarted=");
        printWriter.print(this.f7580h);
        printWriter.print(" mReportNextStart=");
        printWriter.print(this.f7583k);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f7584l);
        printWriter.print(str);
        printWriter.print("mRetaining=");
        printWriter.print(this.f7581i);
        printWriter.print(" mRetainingStarted=");
        printWriter.print(this.f7582j);
        printWriter.print(" mListenerRegistered=");
        printWriter.println(this.f7585m);
        if (this.f7586n != null) {
            printWriter.print(str);
            printWriter.println("Pending Loader ");
            printWriter.print(this.f7586n);
            printWriter.println(":");
            this.f7586n.m9630a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }
}
