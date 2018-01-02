package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

public final class C0369v extends bh implements Runnable {
    static final boolean f17003a = (VERSION.SDK_INT >= 21);
    final at f17004b;
    public C0373z f17005c;
    C0373z f17006d;
    public int f17007e;
    public int f17008f;
    public int f17009g;
    public int f17010h;
    public int f17011i;
    public int f17012j;
    public int f17013k;
    public boolean f17014l;
    boolean f17015m = true;
    public String f17016n;
    boolean f17017o;
    public int f17018p = -1;
    public int f17019q;
    public CharSequence f17020r;
    public int f17021s;
    public CharSequence f17022t;
    public ArrayList<String> f17023u;
    public ArrayList<String> f17024v;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f17018p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f17018p);
        }
        if (this.f17016n != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f17016n);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void m26657a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        m26658a(str, printWriter, true);
    }

    public void m26658a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f17016n);
            printWriter.print(" mIndex=");
            printWriter.print(this.f17018p);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f17017o);
            if (this.f17012j != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f17012j));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f17013k));
            }
            if (!(this.f17008f == 0 && this.f17009g == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f17008f));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f17009g));
            }
            if (!(this.f17010h == 0 && this.f17011i == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f17010h));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f17011i));
            }
            if (!(this.f17019q == 0 && this.f17020r == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f17019q));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f17020r);
            }
            if (!(this.f17021s == 0 && this.f17022t == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f17021s));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f17022t);
            }
        }
        if (this.f17005c != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            C0373z c0373z = this.f17005c;
            while (c0373z != null) {
                String str3;
                switch (c0373z.f17603c) {
                    case 0:
                        str3 = "NULL";
                        break;
                    case 1:
                        str3 = "ADD";
                        break;
                    case 2:
                        str3 = "REPLACE";
                        break;
                    case 3:
                        str3 = "REMOVE";
                        break;
                    case 4:
                        str3 = "HIDE";
                        break;
                    case 5:
                        str3 = "SHOW";
                        break;
                    case 6:
                        str3 = "DETACH";
                        break;
                    case 7:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + c0373z.f17603c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(c0373z.f17604d);
                if (z) {
                    if (!(c0373z.f17605e == 0 && c0373z.f17606f == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(c0373z.f17605e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(c0373z.f17606f));
                    }
                    if (!(c0373z.f17607g == 0 && c0373z.f17608h == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(c0373z.f17607g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(c0373z.f17608h));
                    }
                }
                if (c0373z.f17609i != null && c0373z.f17609i.size() > 0) {
                    for (int i2 = 0; i2 < c0373z.f17609i.size(); i2++) {
                        printWriter.print(str2);
                        if (c0373z.f17609i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(c0373z.f17609i.get(i2));
                    }
                }
                c0373z = c0373z.f17601a;
                i++;
            }
        }
    }

    public C0369v(at atVar) {
        this.f17004b = atVar;
    }

    public void m26656a(C0373z c0373z) {
        if (this.f17005c == null) {
            this.f17006d = c0373z;
            this.f17005c = c0373z;
        } else {
            c0373z.f17602b = this.f17006d;
            this.f17006d.f17601a = c0373z;
            this.f17006d = c0373z;
        }
        c0373z.f17605e = this.f17008f;
        c0373z.f17606f = this.f17009g;
        c0373z.f17607g = this.f17010h;
        c0373z.f17608h = this.f17011i;
        this.f17007e++;
    }

    public bh mo3093a(ah ahVar, String str) {
        m26627a(0, ahVar, str, 1);
        return this;
    }

    public bh mo3090a(int i, ah ahVar) {
        m26627a(i, ahVar, null, 1);
        return this;
    }

    public bh mo3091a(int i, ah ahVar, String str) {
        m26627a(i, ahVar, str, 1);
        return this;
    }

    private void m26627a(int i, ah ahVar, String str, int i2) {
        ahVar.f984B = this.f17004b;
        if (str != null) {
            if (ahVar.f991I == null || str.equals(ahVar.f991I)) {
                ahVar.f991I = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + ahVar + ": was " + ahVar.f991I + " now " + str);
            }
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + ahVar + " with tag " + str + " to container view with no id");
            } else if (ahVar.f989G == 0 || ahVar.f989G == i) {
                ahVar.f989G = i;
                ahVar.f990H = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + ahVar + ": was " + ahVar.f989G + " now " + i);
            }
        }
        C0373z c0373z = new C0373z();
        c0373z.f17603c = i2;
        c0373z.f17604d = ahVar;
        m26656a(c0373z);
    }

    public bh mo3096b(int i, ah ahVar) {
        return m26661b(i, ahVar, null);
    }

    public bh m26661b(int i, ah ahVar, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        m26627a(i, ahVar, str, 2);
        return this;
    }

    public bh mo3092a(ah ahVar) {
        C0373z c0373z = new C0373z();
        c0373z.f17603c = 3;
        c0373z.f17604d = ahVar;
        m26656a(c0373z);
        return this;
    }

    public bh mo3097b(ah ahVar) {
        C0373z c0373z = new C0373z();
        c0373z.f17603c = 4;
        c0373z.f17604d = ahVar;
        m26656a(c0373z);
        return this;
    }

    public bh mo3099c(ah ahVar) {
        C0373z c0373z = new C0373z();
        c0373z.f17603c = 5;
        c0373z.f17604d = ahVar;
        m26656a(c0373z);
        return this;
    }

    public bh mo3100d(ah ahVar) {
        C0373z c0373z = new C0373z();
        c0373z.f17603c = 6;
        c0373z.f17604d = ahVar;
        m26656a(c0373z);
        return this;
    }

    public bh mo3102e(ah ahVar) {
        C0373z c0373z = new C0373z();
        c0373z.f17603c = 7;
        c0373z.f17604d = ahVar;
        m26656a(c0373z);
        return this;
    }

    public bh mo3094a(String str) {
        if (this.f17015m) {
            this.f17014l = true;
            this.f17016n = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public bh m26648a() {
        if (this.f17014l) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f17015m = false;
        return this;
    }

    public void m26654a(int i) {
        if (this.f17014l) {
            if (at.f5372a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (C0373z c0373z = this.f17005c; c0373z != null; c0373z = c0373z.f17601a) {
                ah ahVar;
                if (c0373z.f17604d != null) {
                    ahVar = c0373z.f17604d;
                    ahVar.f983A += i;
                    if (at.f5372a) {
                        Log.v("FragmentManager", "Bump nesting of " + c0373z.f17604d + " to " + c0373z.f17604d.f983A);
                    }
                }
                if (c0373z.f17609i != null) {
                    for (int size = c0373z.f17609i.size() - 1; size >= 0; size--) {
                        ahVar = (ah) c0373z.f17609i.get(size);
                        ahVar.f983A += i;
                        if (at.f5372a) {
                            Log.v("FragmentManager", "Bump nesting of " + ahVar + " to " + ahVar.f983A);
                        }
                    }
                }
            }
        }
    }

    public int mo3095b() {
        return m26646a(false);
    }

    public int mo3098c() {
        return m26646a(true);
    }

    public void mo3101d() {
        m26648a();
        this.f17004b.m7079b((Runnable) this, true);
    }

    int m26646a(boolean z) {
        if (this.f17017o) {
            throw new IllegalStateException("commit already called");
        }
        if (at.f5372a) {
            Log.v("FragmentManager", "Commit: " + this);
            m26657a("  ", null, new PrintWriter(new fu("FragmentManager")), null);
        }
        this.f17017o = true;
        if (this.f17014l) {
            this.f17018p = this.f17004b.m7049a(this);
        } else {
            this.f17018p = -1;
        }
        this.f17004b.m7068a((Runnable) this, z);
        return this.f17018p;
    }

    public void run() {
        if (at.f5372a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (!this.f17014l || this.f17018p >= 0) {
            aa aaVar;
            m26654a(1);
            if (!f17003a || this.f17004b.f5386n < 1) {
                aaVar = null;
            } else {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                m26643b(sparseArray, sparseArray2);
                aaVar = m26619a(sparseArray, sparseArray2, false);
            }
            int i = aaVar != null ? 0 : this.f17013k;
            int i2 = aaVar != null ? 0 : this.f17012j;
            C0373z c0373z = this.f17005c;
            while (c0373z != null) {
                int i3 = aaVar != null ? 0 : c0373z.f17605e;
                int i4 = aaVar != null ? 0 : c0373z.f17606f;
                ah ahVar;
                switch (c0373z.f17603c) {
                    case 1:
                        ahVar = c0373z.f17604d;
                        ahVar.f999Q = i3;
                        this.f17004b.m7066a(ahVar, false);
                        break;
                    case 2:
                        ah ahVar2 = c0373z.f17604d;
                        int i5 = ahVar2.f990H;
                        if (this.f17004b.f5379g != null) {
                            int size = this.f17004b.f5379g.size() - 1;
                            while (size >= 0) {
                                ahVar = (ah) this.f17004b.f5379g.get(size);
                                if (at.f5372a) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + ahVar2 + " old=" + ahVar);
                                }
                                if (ahVar.f990H == i5) {
                                    if (ahVar == ahVar2) {
                                        ahVar = null;
                                        c0373z.f17604d = null;
                                        size--;
                                        ahVar2 = ahVar;
                                    } else {
                                        if (c0373z.f17609i == null) {
                                            c0373z.f17609i = new ArrayList();
                                        }
                                        c0373z.f17609i.add(ahVar);
                                        ahVar.f999Q = i4;
                                        if (this.f17014l) {
                                            ahVar.f983A++;
                                            if (at.f5372a) {
                                                Log.v("FragmentManager", "Bump nesting of " + ahVar + " to " + ahVar.f983A);
                                            }
                                        }
                                        this.f17004b.m7064a(ahVar, i2, i);
                                    }
                                }
                                ahVar = ahVar2;
                                size--;
                                ahVar2 = ahVar;
                            }
                        }
                        if (ahVar2 == null) {
                            break;
                        }
                        ahVar2.f999Q = i3;
                        this.f17004b.m7066a(ahVar2, false);
                        break;
                    case 3:
                        ahVar = c0373z.f17604d;
                        ahVar.f999Q = i4;
                        this.f17004b.m7064a(ahVar, i2, i);
                        break;
                    case 4:
                        ahVar = c0373z.f17604d;
                        ahVar.f999Q = i4;
                        this.f17004b.m7077b(ahVar, i2, i);
                        break;
                    case 5:
                        ahVar = c0373z.f17604d;
                        ahVar.f999Q = i3;
                        this.f17004b.m7085c(ahVar, i2, i);
                        break;
                    case 6:
                        ahVar = c0373z.f17604d;
                        ahVar.f999Q = i4;
                        this.f17004b.m7089d(ahVar, i2, i);
                        break;
                    case 7:
                        ahVar = c0373z.f17604d;
                        ahVar.f999Q = i3;
                        this.f17004b.m7091e(ahVar, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + c0373z.f17603c);
                }
                c0373z = c0373z.f17601a;
            }
            this.f17004b.m7057a(this.f17004b.f5386n, i2, i, true);
            if (this.f17014l) {
                this.f17004b.m7078b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    private static void m26628a(SparseArray<ah> sparseArray, SparseArray<ah> sparseArray2, ah ahVar) {
        if (ahVar != null) {
            int i = ahVar.f990H;
            if (i != 0 && !ahVar.m1336u()) {
                if (ahVar.m1332q() && ahVar.m1338w() != null && sparseArray.get(i) == null) {
                    sparseArray.put(i, ahVar);
                }
                if (sparseArray2.get(i) == ahVar) {
                    sparseArray2.remove(i);
                }
            }
        }
    }

    private void m26644b(SparseArray<ah> sparseArray, SparseArray<ah> sparseArray2, ah ahVar) {
        if (ahVar != null) {
            int i = ahVar.f990H;
            if (i != 0) {
                if (!ahVar.m1332q()) {
                    sparseArray2.put(i, ahVar);
                }
                if (sparseArray.get(i) == ahVar) {
                    sparseArray.remove(i);
                }
            }
            if (ahVar.f1009k < 1 && this.f17004b.f5386n >= 1) {
                this.f17004b.m7084c(ahVar);
                this.f17004b.m7065a(ahVar, 1, 0, 0, false);
            }
        }
    }

    private void m26643b(SparseArray<ah> sparseArray, SparseArray<ah> sparseArray2) {
        if (this.f17004b.f5388p.mo636a()) {
            for (C0373z c0373z = this.f17005c; c0373z != null; c0373z = c0373z.f17601a) {
                switch (c0373z.f17603c) {
                    case 1:
                        m26644b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0373z.f17604d);
                        break;
                    case 2:
                        ah ahVar = c0373z.f17604d;
                        if (this.f17004b.f5379g != null) {
                            ah ahVar2 = ahVar;
                            for (int i = 0; i < this.f17004b.f5379g.size(); i++) {
                                ah ahVar3 = (ah) this.f17004b.f5379g.get(i);
                                if (ahVar2 == null || ahVar3.f990H == ahVar2.f990H) {
                                    if (ahVar3 == ahVar2) {
                                        ahVar2 = null;
                                        sparseArray2.remove(ahVar3.f990H);
                                    } else {
                                        C0369v.m26628a((SparseArray) sparseArray, (SparseArray) sparseArray2, ahVar3);
                                    }
                                }
                            }
                        }
                        m26644b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0373z.f17604d);
                        break;
                    case 3:
                        C0369v.m26628a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0373z.f17604d);
                        break;
                    case 4:
                        C0369v.m26628a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0373z.f17604d);
                        break;
                    case 5:
                        m26644b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0373z.f17604d);
                        break;
                    case 6:
                        C0369v.m26628a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0373z.f17604d);
                        break;
                    case 7:
                        m26644b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0373z.f17604d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void m26655a(SparseArray<ah> sparseArray, SparseArray<ah> sparseArray2) {
        if (this.f17004b.f5388p.mo636a()) {
            for (C0373z c0373z = this.f17006d; c0373z != null; c0373z = c0373z.f17602b) {
                switch (c0373z.f17603c) {
                    case 1:
                        C0369v.m26628a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0373z.f17604d);
                        break;
                    case 2:
                        if (c0373z.f17609i != null) {
                            for (int size = c0373z.f17609i.size() - 1; size >= 0; size--) {
                                m26644b((SparseArray) sparseArray, (SparseArray) sparseArray2, (ah) c0373z.f17609i.get(size));
                            }
                        }
                        C0369v.m26628a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0373z.f17604d);
                        break;
                    case 3:
                        m26644b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0373z.f17604d);
                        break;
                    case 4:
                        m26644b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0373z.f17604d);
                        break;
                    case 5:
                        C0369v.m26628a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0373z.f17604d);
                        break;
                    case 6:
                        m26644b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0373z.f17604d);
                        break;
                    case 7:
                        C0369v.m26628a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0373z.f17604d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public aa m26647a(boolean z, aa aaVar, SparseArray<ah> sparseArray, SparseArray<ah> sparseArray2) {
        if (at.f5372a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            m26657a("  ", null, new PrintWriter(new fu("FragmentManager")), null);
        }
        if (f17003a && this.f17004b.f5386n >= 1) {
            if (aaVar == null) {
                if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                    aaVar = m26619a((SparseArray) sparseArray, (SparseArray) sparseArray2, true);
                }
            } else if (!z) {
                C0369v.m26634a(aaVar, this.f17024v, this.f17023u);
            }
        }
        m26654a(-1);
        int i = aaVar != null ? 0 : this.f17013k;
        int i2 = aaVar != null ? 0 : this.f17012j;
        C0373z c0373z = this.f17006d;
        while (c0373z != null) {
            int i3 = aaVar != null ? 0 : c0373z.f17607g;
            int i4 = aaVar != null ? 0 : c0373z.f17608h;
            ah ahVar;
            ah ahVar2;
            switch (c0373z.f17603c) {
                case 1:
                    ahVar = c0373z.f17604d;
                    ahVar.f999Q = i4;
                    this.f17004b.m7064a(ahVar, at.m7047d(i2), i);
                    break;
                case 2:
                    ahVar = c0373z.f17604d;
                    if (ahVar != null) {
                        ahVar.f999Q = i4;
                        this.f17004b.m7064a(ahVar, at.m7047d(i2), i);
                    }
                    if (c0373z.f17609i == null) {
                        break;
                    }
                    for (int i5 = 0; i5 < c0373z.f17609i.size(); i5++) {
                        ahVar2 = (ah) c0373z.f17609i.get(i5);
                        ahVar2.f999Q = i3;
                        this.f17004b.m7066a(ahVar2, false);
                    }
                    break;
                case 3:
                    ahVar2 = c0373z.f17604d;
                    ahVar2.f999Q = i3;
                    this.f17004b.m7066a(ahVar2, false);
                    break;
                case 4:
                    ahVar2 = c0373z.f17604d;
                    ahVar2.f999Q = i3;
                    this.f17004b.m7085c(ahVar2, at.m7047d(i2), i);
                    break;
                case 5:
                    ahVar = c0373z.f17604d;
                    ahVar.f999Q = i4;
                    this.f17004b.m7077b(ahVar, at.m7047d(i2), i);
                    break;
                case 6:
                    ahVar2 = c0373z.f17604d;
                    ahVar2.f999Q = i3;
                    this.f17004b.m7091e(ahVar2, at.m7047d(i2), i);
                    break;
                case 7:
                    ahVar2 = c0373z.f17604d;
                    ahVar2.f999Q = i3;
                    this.f17004b.m7089d(ahVar2, at.m7047d(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0373z.f17603c);
            }
            c0373z = c0373z.f17602b;
        }
        if (z) {
            this.f17004b.m7057a(this.f17004b.f5386n, at.m7047d(i2), i, true);
            aaVar = null;
        }
        if (this.f17018p >= 0) {
            this.f17004b.m7083c(this.f17018p);
            this.f17018p = -1;
        }
        return aaVar;
    }

    public String m26668e() {
        return this.f17016n;
    }

    private aa m26619a(SparseArray<ah> sparseArray, SparseArray<ah> sparseArray2, boolean z) {
        int i = 0;
        aa aaVar = new aa(this);
        aaVar.f3984d = new View(this.f17004b.f5387o.m6165g());
        int i2 = 0;
        int i3 = 0;
        while (i2 < sparseArray.size()) {
            int i4;
            if (m26640a(sparseArray.keyAt(i2), aaVar, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i4 = 1;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        while (i < sparseArray2.size()) {
            i4 = sparseArray2.keyAt(i);
            if (sparseArray.get(i4) == null && m26640a(i4, aaVar, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i3 = 1;
            }
            i++;
        }
        if (i3 == 0) {
            return null;
        }
        return aaVar;
    }

    private static Object m26625a(ah ahVar, boolean z) {
        if (ahVar == null) {
            return null;
        }
        return bi.m8523a(z ? ahVar.m1258F() : ahVar.m1255C());
    }

    private static Object m26642b(ah ahVar, boolean z) {
        if (ahVar == null) {
            return null;
        }
        return bi.m8523a(z ? ahVar.m1256D() : ahVar.m1257E());
    }

    private static Object m26624a(ah ahVar, ah ahVar2, boolean z) {
        if (ahVar == null || ahVar2 == null) {
            return null;
        }
        Object H;
        if (z) {
            H = ahVar2.m1260H();
        } else {
            H = ahVar.m1259G();
        }
        return bi.m8544b(H);
    }

    private static Object m26626a(Object obj, ah ahVar, ArrayList<View> arrayList, fq<String, View> fqVar, View view) {
        if (obj != null) {
            return bi.m8524a(obj, ahVar.m1338w(), (ArrayList) arrayList, (Map) fqVar, view);
        }
        return obj;
    }

    private fq<String, View> m26620a(aa aaVar, ah ahVar, boolean z) {
        fq fqVar = new fq();
        if (this.f17023u != null) {
            bi.m8539a((Map) fqVar, ahVar.m1338w());
            if (z) {
                fqVar.m20348a(this.f17024v);
            } else {
                fqVar = C0369v.m26623a(this.f17023u, this.f17024v, fqVar);
            }
        }
        if (z) {
            if (ahVar.ah != null) {
                ahVar.ah.m15407a(this.f17024v, fqVar);
            }
            m26633a(aaVar, fqVar, false);
        } else {
            if (ahVar.ai != null) {
                ahVar.ai.m15407a(this.f17024v, fqVar);
            }
            m26645b(aaVar, fqVar, false);
        }
        return fqVar;
    }

    private boolean m26640a(int i, aa aaVar, boolean z, SparseArray<ah> sparseArray, SparseArray<ah> sparseArray2) {
        View view = (ViewGroup) this.f17004b.f5388p.mo635a(i);
        if (view == null) {
            return false;
        }
        Object obj;
        ArrayList arrayList;
        Object a;
        View view2;
        bo c0370w;
        ArrayList arrayList2;
        Map fqVar;
        boolean z2;
        Object a2;
        ah ahVar = (ah) sparseArray2.get(i);
        ah ahVar2 = (ah) sparseArray.get(i);
        Object a3 = C0369v.m26625a(ahVar, z);
        Object a4 = C0369v.m26624a(ahVar, ahVar2, z);
        Object b = C0369v.m26642b(ahVar2, z);
        Map map = null;
        ArrayList arrayList3 = new ArrayList();
        if (a4 != null) {
            map = m26620a(aaVar, ahVar2, z);
            if (map.isEmpty()) {
                map = null;
                obj = null;
                if (a3 != null && obj == null && b == null) {
                    return false;
                }
                arrayList = new ArrayList();
                a = C0369v.m26626a(b, ahVar2, arrayList, (fq) map, aaVar.f3984d);
                if (!(this.f17024v == null || map == null)) {
                    view2 = (View) map.get(this.f17024v.get(0));
                    if (view2 != null) {
                        if (a != null) {
                            bi.m8531a(a, view2);
                        }
                        if (obj != null) {
                            bi.m8531a(obj, view2);
                        }
                    }
                }
                c0370w = new C0370w(this, ahVar);
                arrayList2 = new ArrayList();
                fqVar = new fq();
                z2 = true;
                if (ahVar != null) {
                    if (z) {
                        z2 = ahVar.m1261I();
                    } else {
                        z2 = ahVar.m1262J();
                    }
                }
                a2 = bi.m8525a(a3, a, obj, z2);
                if (a2 != null) {
                    bi.m8534a(a3, obj, a, view, c0370w, aaVar.f3984d, aaVar.f3983c, aaVar.f3981a, arrayList2, arrayList, map, fqVar, arrayList3);
                    m26629a(view, aaVar, i, a2);
                    bi.m8533a(a2, aaVar.f3984d, true);
                    m26630a(aaVar, i, a2);
                    bi.m8530a((ViewGroup) view, a2);
                    bi.m8529a(view, aaVar.f3984d, a3, arrayList2, a, arrayList, obj, arrayList3, a2, aaVar.f3982b, fqVar);
                }
                if (a2 == null) {
                    return true;
                }
                return false;
            }
            ds dsVar = z ? ahVar2.ah : ahVar.ah;
            if (dsVar != null) {
                dsVar.m15406a(new ArrayList(map.keySet()), new ArrayList(map.values()), null);
            }
            m26631a(aaVar, view, a4, ahVar, ahVar2, z, arrayList3, a3, b);
        }
        obj = a4;
        if (a3 != null) {
        }
        arrayList = new ArrayList();
        a = C0369v.m26626a(b, ahVar2, arrayList, (fq) map, aaVar.f3984d);
        view2 = (View) map.get(this.f17024v.get(0));
        if (view2 != null) {
            if (a != null) {
                bi.m8531a(a, view2);
            }
            if (obj != null) {
                bi.m8531a(obj, view2);
            }
        }
        c0370w = new C0370w(this, ahVar);
        arrayList2 = new ArrayList();
        fqVar = new fq();
        z2 = true;
        if (ahVar != null) {
            if (z) {
                z2 = ahVar.m1261I();
            } else {
                z2 = ahVar.m1262J();
            }
        }
        a2 = bi.m8525a(a3, a, obj, z2);
        if (a2 != null) {
            bi.m8534a(a3, obj, a, view, c0370w, aaVar.f3984d, aaVar.f3983c, aaVar.f3981a, arrayList2, arrayList, map, fqVar, arrayList3);
            m26629a(view, aaVar, i, a2);
            bi.m8533a(a2, aaVar.f3984d, true);
            m26630a(aaVar, i, a2);
            bi.m8530a((ViewGroup) view, a2);
            bi.m8529a(view, aaVar.f3984d, a3, arrayList2, a, arrayList, obj, arrayList3, a2, aaVar.f3982b, fqVar);
        }
        if (a2 == null) {
            return false;
        }
        return true;
    }

    private void m26631a(aa aaVar, View view, Object obj, ah ahVar, ah ahVar2, boolean z, ArrayList<View> arrayList, Object obj2, Object obj3) {
        if (obj != null) {
            view.getViewTreeObserver().addOnPreDrawListener(new C0371x(this, view, obj, arrayList, aaVar, obj2, obj3, z, ahVar, ahVar2));
        }
    }

    private void m26632a(aa aaVar, ah ahVar, ah ahVar2, boolean z, fq<String, View> fqVar) {
        ds dsVar = z ? ahVar2.ah : ahVar.ah;
        if (dsVar != null) {
            dsVar.m15408b(new ArrayList(fqVar.keySet()), new ArrayList(fqVar.values()), null);
        }
    }

    private void m26635a(fq<String, View> fqVar, aa aaVar) {
        if (this.f17024v != null && !fqVar.isEmpty()) {
            View view = (View) fqVar.get(this.f17024v.get(0));
            if (view != null) {
                aaVar.f3983c.f7127a = view;
            }
        }
    }

    private fq<String, View> m26621a(aa aaVar, boolean z, ah ahVar) {
        fq b = m26641b(aaVar, ahVar, z);
        if (z) {
            if (ahVar.ai != null) {
                ahVar.ai.m15407a(this.f17024v, b);
            }
            m26633a(aaVar, b, true);
        } else {
            if (ahVar.ah != null) {
                ahVar.ah.m15407a(this.f17024v, b);
            }
            m26645b(aaVar, b, true);
        }
        return b;
    }

    private static fq<String, View> m26623a(ArrayList<String> arrayList, ArrayList<String> arrayList2, fq<String, View> fqVar) {
        if (fqVar.isEmpty()) {
            return fqVar;
        }
        fq<String, View> fqVar2 = new fq();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) fqVar.get(arrayList.get(i));
            if (view != null) {
                fqVar2.put(arrayList2.get(i), view);
            }
        }
        return fqVar2;
    }

    private fq<String, View> m26641b(aa aaVar, ah ahVar, boolean z) {
        fq fqVar = new fq();
        View w = ahVar.m1338w();
        if (w == null || this.f17023u == null) {
            return fqVar;
        }
        bi.m8539a((Map) fqVar, w);
        if (z) {
            return C0369v.m26623a(this.f17023u, this.f17024v, fqVar);
        }
        fqVar.m20348a(this.f17024v);
        return fqVar;
    }

    private void m26629a(View view, aa aaVar, int i, Object obj) {
        view.getViewTreeObserver().addOnPreDrawListener(new C0372y(this, view, aaVar, i, obj));
    }

    private void m26630a(aa aaVar, int i, Object obj) {
        if (this.f17004b.f5379g != null) {
            for (int i2 = 0; i2 < this.f17004b.f5379g.size(); i2++) {
                ah ahVar = (ah) this.f17004b.f5379g.get(i2);
                if (!(ahVar.f1001S == null || ahVar.f1000R == null || ahVar.f990H != i)) {
                    if (!ahVar.f992J) {
                        bi.m8533a(obj, ahVar.f1001S, false);
                        aaVar.f3982b.remove(ahVar.f1001S);
                    } else if (!aaVar.f3982b.contains(ahVar.f1001S)) {
                        bi.m8533a(obj, ahVar.f1001S, true);
                        aaVar.f3982b.add(ahVar.f1001S);
                    }
                }
            }
        }
    }

    private static void m26636a(fq<String, String> fqVar, String str, String str2) {
        if (str != null && str2 != null) {
            for (int i = 0; i < fqVar.size(); i++) {
                if (str.equals(fqVar.m20345c(i))) {
                    fqVar.m20340a(i, (Object) str2);
                    return;
                }
            }
            fqVar.put(str, str2);
        }
    }

    private static void m26634a(aa aaVar, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                C0369v.m26636a(aaVar.f3981a, (String) arrayList.get(i), (String) arrayList2.get(i));
            }
        }
    }

    private void m26633a(aa aaVar, fq<String, View> fqVar, boolean z) {
        int size = this.f17024v == null ? 0 : this.f17024v.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.f17023u.get(i);
            View view = (View) fqVar.get((String) this.f17024v.get(i));
            if (view != null) {
                String a = bi.m8526a(view);
                if (z) {
                    C0369v.m26636a(aaVar.f3981a, str, a);
                } else {
                    C0369v.m26636a(aaVar.f3981a, a, str);
                }
            }
        }
    }

    private void m26645b(aa aaVar, fq<String, View> fqVar, boolean z) {
        int size = fqVar.size();
        for (int i = 0; i < size; i++) {
            String str = (String) fqVar.m20344b(i);
            String a = bi.m8526a((View) fqVar.m20345c(i));
            if (z) {
                C0369v.m26636a(aaVar.f3981a, str, a);
            } else {
                C0369v.m26636a(aaVar.f3981a, a, str);
            }
        }
    }
}
