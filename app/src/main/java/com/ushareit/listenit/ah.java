package com.ushareit.listenit;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class ah implements ComponentCallbacks, OnCreateContextMenuListener {
    private static final gg<String, Class<?>> f981a = new gg();
    static final Object f982j = new Object();
    int f983A;
    public at f984B;
    aq f985C;
    at f986D;
    public ba f987E;
    ah f988F;
    public int f989G;
    public int f990H;
    public String f991I;
    public boolean f992J;
    public boolean f993K;
    public boolean f994L;
    boolean f995M;
    boolean f996N;
    boolean f997O = true;
    boolean f998P;
    int f999Q;
    ViewGroup f1000R;
    View f1001S;
    View f1002T;
    boolean f1003U;
    boolean f1004V = true;
    br f1005W;
    boolean f1006X;
    boolean f1007Y;
    Object f1008Z = null;
    Object aa = f982j;
    Object ab = null;
    Object ac = f982j;
    Object ad = null;
    Object ae = f982j;
    Boolean af;
    Boolean ag;
    ds ah = null;
    ds ai = null;
    int f1009k = 0;
    View f1010l;
    int f1011m;
    public Bundle f1012n;
    SparseArray<Parcelable> f1013o;
    public int f1014p = -1;
    String f1015q;
    public Bundle f1016r;
    ah f1017s;
    int f1018t = -1;
    int f1019u;
    boolean f1020v;
    boolean f1021w;
    public boolean f1022x;
    boolean f1023y;
    public boolean f1024z;

    public static ah m1250a(Context context, String str) {
        return m1251a(context, str, null);
    }

    public static ah m1251a(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) f981a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f981a.put(str, cls);
            }
            ah ahVar = (ah) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(ahVar.getClass().getClassLoader());
                ahVar.f1016r = bundle;
            }
            return ahVar;
        } catch (Exception e) {
            throw new aj("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e);
        } catch (Exception e2) {
            throw new aj("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new aj("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e22);
        }
    }

    static boolean m1252b(Context context, String str) {
        try {
            Class cls = (Class) f981a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f981a.put(str, cls);
            }
            return ah.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    final void m1314f(Bundle bundle) {
        if (this.f1013o != null) {
            this.f1002T.restoreHierarchyState(this.f1013o);
            this.f1013o = null;
        }
        this.f998P = false;
        m1320i(bundle);
        if (!this.f998P) {
            throw new dt("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public final void m1278a(int i, ah ahVar) {
        this.f1014p = i;
        if (ahVar != null) {
            this.f1015q = ahVar.f1015q + ":" + this.f1014p;
        } else {
            this.f1015q = "android:fragment:" + this.f1014p;
        }
    }

    final boolean m1321i() {
        return this.f983A > 0;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        ft.m20887a(this, stringBuilder);
        if (this.f1014p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f1014p);
        }
        if (this.f989G != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.f989G));
        }
        if (this.f991I != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f991I);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final String m1322j() {
        return this.f991I;
    }

    public void m1317g(Bundle bundle) {
        if (this.f1014p >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        this.f1016r = bundle;
    }

    public final Bundle m1324k() {
        return this.f1016r;
    }

    public Context m1326l() {
        return this.f985C == null ? null : this.f985C.m6165g();
    }

    public final ak m1328m() {
        return this.f985C == null ? null : (ak) this.f985C.m6164f();
    }

    public final Resources m1329n() {
        if (this.f985C != null) {
            return this.f985C.m6165g().getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final String m1275a(int i) {
        return m1329n().getString(i);
    }

    public final String m1276a(int i, Object... objArr) {
        return m1329n().getString(i, objArr);
    }

    public final ar m1330o() {
        return this.f984B;
    }

    public final ar m1331p() {
        if (this.f986D == null) {
            m1263K();
            if (this.f1009k >= 5) {
                this.f986D.m7102n();
            } else if (this.f1009k >= 4) {
                this.f986D.m7101m();
            } else if (this.f1009k >= 2) {
                this.f986D.m7100l();
            } else if (this.f1009k >= 1) {
                this.f986D.m7099k();
            }
        }
        return this.f986D;
    }

    public final boolean m1332q() {
        return this.f985C != null && this.f1020v;
    }

    public final boolean m1333r() {
        return this.f993K;
    }

    public final boolean m1334s() {
        return this.f1021w;
    }

    public final boolean m1335t() {
        return (!m1332q() || m1336u() || this.f1001S == null || this.f1001S.getWindowToken() == null || this.f1001S.getVisibility() != 0) ? false : true;
    }

    public final boolean m1336u() {
        return this.f992J;
    }

    public void mo2580c(boolean z) {
    }

    public void m1308d(boolean z) {
        this.f994L = z;
    }

    public final boolean m1337v() {
        return this.f994L;
    }

    public void m1312e(boolean z) {
        if (this.f997O != z) {
            this.f997O = z;
            if (this.f996N && m1332q() && !m1336u()) {
                this.f985C.mo725c();
            }
        }
    }

    public void m1315f(boolean z) {
        if (!this.f1004V && z && this.f1009k < 4 && this.f984B != null && m1332q()) {
            this.f984B.m7063a(this);
        }
        this.f1004V = z;
        boolean z2 = this.f1009k < 4 && !z;
        this.f1003U = z2;
    }

    public void m1284a(Intent intent) {
        m1286a(intent, null);
    }

    public void m1286a(Intent intent, Bundle bundle) {
        if (this.f985C == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.f985C.mo718a(this, intent, -1, bundle);
    }

    public void startActivityForResult(Intent intent, int i) {
        m1285a(intent, i, null);
    }

    public void m1285a(Intent intent, int i, Bundle bundle) {
        if (this.f985C == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.f985C.mo718a(this, intent, i, bundle);
    }

    public void mo200a(int i, int i2, Intent intent) {
    }

    public final void m1294a(String[] strArr, int i) {
        if (this.f985C == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.f985C.mo719a(this, strArr, i);
    }

    public void m1279a(int i, String[] strArr, int[] iArr) {
    }

    public boolean m1296a(String str) {
        if (this.f985C != null) {
            return this.f985C.mo722a(str);
        }
        return false;
    }

    public LayoutInflater mo169b(Bundle bundle) {
        LayoutInflater b = this.f985C.mo723b();
        m1331p();
        hj.m23919a(b, this.f986D.m7109u());
        return b;
    }

    public void m1283a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.f998P = true;
        Activity f = this.f985C == null ? null : this.f985C.m6164f();
        if (f != null) {
            this.f998P = false;
            m1281a(f, attributeSet, bundle);
        }
    }

    @Deprecated
    public void m1281a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.f998P = true;
    }

    public void m1292a(ah ahVar) {
    }

    public void mo167a(Context context) {
        this.f998P = true;
        Activity f = this.f985C == null ? null : this.f985C.m6164f();
        if (f != null) {
            this.f998P = false;
            mo591a(f);
        }
    }

    @Deprecated
    public void mo591a(Activity activity) {
        this.f998P = true;
    }

    public Animation m1274a(int i, boolean z, int i2) {
        return null;
    }

    public void mo168a(Bundle bundle) {
        this.f998P = true;
        m1319h(bundle);
        if (this.f986D != null && !this.f986D.m7081b(1)) {
            this.f986D.m7099k();
        }
    }

    void m1319h(Bundle bundle) {
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.f986D == null) {
                    m1263K();
                }
                this.f986D.m7062a(parcelable, this.f987E);
                this.f987E = null;
                this.f986D.m7099k();
            }
        }
    }

    public View mo199a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void mo2387a(View view, Bundle bundle) {
    }

    public View m1338w() {
        return this.f1001S;
    }

    public void mo170d(Bundle bundle) {
        this.f998P = true;
    }

    public void m1320i(Bundle bundle) {
        this.f998P = true;
    }

    public void mo173f() {
        this.f998P = true;
        if (!this.f1006X) {
            this.f1006X = true;
            if (!this.f1007Y) {
                this.f1007Y = true;
                this.f1005W = this.f985C.m6148a(this.f1015q, this.f1006X, false);
            }
            if (this.f1005W != null) {
                this.f1005W.m9559b();
            }
        }
    }

    public void mo201x() {
        this.f998P = true;
    }

    public void mo172e(Bundle bundle) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.f998P = true;
    }

    public void mo202y() {
        this.f998P = true;
    }

    public void mo174g() {
        this.f998P = true;
    }

    public void onLowMemory() {
        this.f998P = true;
    }

    public void mo175h() {
        this.f998P = true;
    }

    public void mo203z() {
        this.f998P = true;
        if (!this.f1007Y) {
            this.f1007Y = true;
            this.f1005W = this.f985C.m6148a(this.f1015q, this.f1006X, false);
        }
        if (this.f1005W != null) {
            this.f1005W.m9565h();
        }
    }

    void m1253A() {
        this.f1014p = -1;
        this.f1015q = null;
        this.f1020v = false;
        this.f1021w = false;
        this.f1022x = false;
        this.f1023y = false;
        this.f1024z = false;
        this.f983A = 0;
        this.f984B = null;
        this.f986D = null;
        this.f985C = null;
        this.f989G = 0;
        this.f990H = 0;
        this.f991I = null;
        this.f992J = false;
        this.f993K = false;
        this.f995M = false;
        this.f1005W = null;
        this.f1006X = false;
        this.f1007Y = false;
    }

    public void mo171e() {
        this.f998P = true;
    }

    public void m1290a(Menu menu, MenuInflater menuInflater) {
    }

    public void m1289a(Menu menu) {
    }

    public void m1254B() {
    }

    public boolean m1295a(MenuItem menuItem) {
        return false;
    }

    public void m1300b(Menu menu) {
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        m1328m().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public boolean m1302b(MenuItem menuItem) {
        return false;
    }

    public Object m1255C() {
        return this.f1008Z;
    }

    public Object m1256D() {
        return this.aa == f982j ? m1255C() : this.aa;
    }

    public Object m1257E() {
        return this.ab;
    }

    public Object m1258F() {
        return this.ac == f982j ? m1257E() : this.ac;
    }

    public Object m1259G() {
        return this.ad;
    }

    public Object m1260H() {
        return this.ae == f982j ? m1259G() : this.ae;
    }

    public boolean m1261I() {
        return this.ag == null ? true : this.ag.booleanValue();
    }

    public boolean m1262J() {
        return this.af == null ? true : this.af.booleanValue();
    }

    public void mo2015a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f989G));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f990H));
        printWriter.print(" mTag=");
        printWriter.println(this.f991I);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f1009k);
        printWriter.print(" mIndex=");
        printWriter.print(this.f1014p);
        printWriter.print(" mWho=");
        printWriter.print(this.f1015q);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f983A);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f1020v);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f1021w);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f1022x);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f1023y);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f992J);
        printWriter.print(" mDetached=");
        printWriter.print(this.f993K);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f997O);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f996N);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f994L);
        printWriter.print(" mRetaining=");
        printWriter.print(this.f995M);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f1004V);
        if (this.f984B != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f984B);
        }
        if (this.f985C != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f985C);
        }
        if (this.f988F != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f988F);
        }
        if (this.f1016r != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f1016r);
        }
        if (this.f1012n != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f1012n);
        }
        if (this.f1013o != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f1013o);
        }
        if (this.f1017s != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.f1017s);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f1019u);
        }
        if (this.f999Q != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.f999Q);
        }
        if (this.f1000R != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f1000R);
        }
        if (this.f1001S != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f1001S);
        }
        if (this.f1002T != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.f1001S);
        }
        if (this.f1010l != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.f1010l);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.f1011m);
        }
        if (this.f1005W != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.f1005W.m9557a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f986D != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.f986D + ":");
            this.f986D.mo799a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    ah m1299b(String str) {
        if (str.equals(this.f1015q)) {
            return this;
        }
        if (this.f986D != null) {
            return this.f986D.m7074b(str);
        }
        return null;
    }

    void m1263K() {
        this.f986D = new at();
        this.f986D.m7067a(this.f985C, new ai(this), this);
    }

    void m1323j(Bundle bundle) {
        if (this.f986D != null) {
            this.f986D.m7098j();
        }
        this.f1009k = 1;
        this.f998P = false;
        mo168a(bundle);
        if (!this.f998P) {
            throw new dt("Fragment " + this + " did not call through to super.onCreate()");
        }
    }

    View m1298b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f986D != null) {
            this.f986D.m7098j();
        }
        return mo199a(layoutInflater, viewGroup, bundle);
    }

    void m1325k(Bundle bundle) {
        if (this.f986D != null) {
            this.f986D.m7098j();
        }
        this.f1009k = 2;
        this.f998P = false;
        mo170d(bundle);
        if (!this.f998P) {
            throw new dt("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.f986D != null) {
            this.f986D.m7100l();
        }
    }

    void m1264L() {
        if (this.f986D != null) {
            this.f986D.m7098j();
            this.f986D.m7092e();
        }
        this.f1009k = 4;
        this.f998P = false;
        mo173f();
        if (this.f998P) {
            if (this.f986D != null) {
                this.f986D.m7101m();
            }
            if (this.f1005W != null) {
                this.f1005W.m9564g();
                return;
            }
            return;
        }
        throw new dt("Fragment " + this + " did not call through to super.onStart()");
    }

    void m1265M() {
        if (this.f986D != null) {
            this.f986D.m7098j();
            this.f986D.m7092e();
        }
        this.f1009k = 5;
        this.f998P = false;
        mo201x();
        if (!this.f998P) {
            throw new dt("Fragment " + this + " did not call through to super.onResume()");
        } else if (this.f986D != null) {
            this.f986D.m7102n();
            this.f986D.m7092e();
        }
    }

    void m1287a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.f986D != null) {
            this.f986D.m7060a(configuration);
        }
    }

    void m1266N() {
        onLowMemory();
        if (this.f986D != null) {
            this.f986D.m7108t();
        }
    }

    boolean m1301b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.f992J) {
            return false;
        }
        if (this.f996N && this.f997O) {
            z = true;
            m1290a(menu, menuInflater);
        }
        if (this.f986D != null) {
            return z | this.f986D.m7072a(menu, menuInflater);
        }
        return z;
    }

    boolean m1304c(Menu menu) {
        boolean z = false;
        if (this.f992J) {
            return false;
        }
        if (this.f996N && this.f997O) {
            z = true;
            m1289a(menu);
        }
        if (this.f986D != null) {
            return z | this.f986D.m7071a(menu);
        }
        return z;
    }

    boolean m1305c(MenuItem menuItem) {
        if (!this.f992J) {
            if (this.f996N && this.f997O && m1295a(menuItem)) {
                return true;
            }
            if (this.f986D != null && this.f986D.m7073a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean m1309d(MenuItem menuItem) {
        if (!this.f992J) {
            if (m1302b(menuItem)) {
                return true;
            }
            if (this.f986D != null && this.f986D.m7082b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void m1307d(Menu menu) {
        if (!this.f992J) {
            if (this.f996N && this.f997O) {
                m1300b(menu);
            }
            if (this.f986D != null) {
                this.f986D.m7075b(menu);
            }
        }
    }

    void m1327l(Bundle bundle) {
        mo172e(bundle);
        if (this.f986D != null) {
            Parcelable i = this.f986D.m7097i();
            if (i != null) {
                bundle.putParcelable("android:support:fragments", i);
            }
        }
    }

    void m1267O() {
        if (this.f986D != null) {
            this.f986D.m7103o();
        }
        this.f1009k = 4;
        this.f998P = false;
        mo202y();
        if (!this.f998P) {
            throw new dt("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    void m1268P() {
        if (this.f986D != null) {
            this.f986D.m7104p();
        }
        this.f1009k = 3;
        this.f998P = false;
        mo174g();
        if (!this.f998P) {
            throw new dt("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    void m1269Q() {
        if (this.f986D != null) {
            this.f986D.m7105q();
        }
        this.f1009k = 2;
        if (this.f1006X) {
            this.f1006X = false;
            if (!this.f1007Y) {
                this.f1007Y = true;
                this.f1005W = this.f985C.m6148a(this.f1015q, this.f1006X, false);
            }
            if (this.f1005W == null) {
                return;
            }
            if (this.f985C.m6169k()) {
                this.f1005W.m9561d();
            } else {
                this.f1005W.m9560c();
            }
        }
    }

    void m1270R() {
        if (this.f986D != null) {
            this.f986D.m7106r();
        }
        this.f1009k = 1;
        this.f998P = false;
        mo175h();
        if (!this.f998P) {
            throw new dt("Fragment " + this + " did not call through to super.onDestroyView()");
        } else if (this.f1005W != null) {
            this.f1005W.m9563f();
        }
    }

    void m1271S() {
        if (this.f986D != null) {
            this.f986D.m7107s();
        }
        this.f1009k = 0;
        this.f998P = false;
        mo203z();
        if (this.f998P) {
            this.f986D = null;
            return;
        }
        throw new dt("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void m1272T() {
        this.f998P = false;
        mo171e();
        if (!this.f998P) {
            throw new dt("Fragment " + this + " did not call through to super.onDetach()");
        } else if (this.f986D == null) {
        } else {
            if (this.f995M) {
                this.f986D.m7107s();
                this.f986D = null;
                return;
            }
            throw new IllegalStateException("Child FragmentManager of " + this + " was not " + " destroyed and this fragment is not retaining instance");
        }
    }
}
