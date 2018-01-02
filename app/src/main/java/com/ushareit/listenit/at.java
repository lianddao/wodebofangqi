package com.ushareit.listenit;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.BackStackState;
import android.support.v4.app.FragmentManagerState;
import android.support.v4.app.FragmentState;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import com.mopub.volley.DefaultRetryPolicy;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class at extends ar implements ht {
    static final Interpolator f5368A = new DecelerateInterpolator(2.5f);
    static final Interpolator f5369B = new DecelerateInterpolator(1.5f);
    static final Interpolator f5370C = new AccelerateInterpolator(2.5f);
    static final Interpolator f5371D = new AccelerateInterpolator(1.5f);
    public static boolean f5372a = false;
    static final boolean f5373b;
    static Field f5374r = null;
    ArrayList<Runnable> f5375c;
    Runnable[] f5376d;
    boolean f5377e;
    public ArrayList<ah> f5378f;
    ArrayList<ah> f5379g;
    ArrayList<Integer> f5380h;
    ArrayList<C0369v> f5381i;
    ArrayList<ah> f5382j;
    ArrayList<C0369v> f5383k;
    ArrayList<Integer> f5384l;
    ArrayList<as> f5385m;
    int f5386n = 0;
    aq f5387o;
    ao f5388p;
    ah f5389q;
    boolean f5390s;
    boolean f5391t;
    boolean f5392u;
    String f5393v;
    boolean f5394w;
    Bundle f5395x = null;
    SparseArray<Parcelable> f5396y = null;
    Runnable f5397z = new au(this);

    at() {
    }

    static {
        boolean z = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        f5373b = z;
    }

    static boolean m7044a(Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (!(animation instanceof AnimationSet)) {
            return false;
        }
        List animations = ((AnimationSet) animation).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    static boolean m7043a(View view, Animation animation) {
        return VERSION.SDK_INT >= 19 && ja.m24161g(view) == 0 && ja.m24174t(view) && m7044a(animation);
    }

    private void m7042a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new fu("FragmentManager"));
        if (this.f5387o != null) {
            try {
                this.f5387o.mo720a("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                mo799a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public bh mo797a() {
        return new C0369v(this);
    }

    public boolean mo800b() {
        return m7092e();
    }

    public boolean mo801c() {
        m7048v();
        mo800b();
        return m7070a(this.f5387o.m6166h(), null, -1, 0);
    }

    public void mo798a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        m7068a(new av(this, i, i2), false);
    }

    public void m7061a(Bundle bundle, String str, ah ahVar) {
        if (ahVar.f1014p < 0) {
            m7042a(new IllegalStateException("Fragment " + ahVar + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, ahVar.f1014p);
    }

    public ah m7053a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f5378f.size()) {
            m7042a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        ah ahVar = (ah) this.f5378f.get(i);
        if (ahVar != null) {
            return ahVar;
        }
        m7042a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return ahVar;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.f5389q != null) {
            ft.m20887a(this.f5389q, stringBuilder);
        } else {
            ft.m20887a(this.f5387o, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void mo799a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        ah ahVar;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f5378f != null) {
            size = this.f5378f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    ahVar = (ah) this.f5378f.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(ahVar);
                    if (ahVar != null) {
                        ahVar.mo2015a(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.f5379g != null) {
            size = this.f5379g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    ahVar = (ah) this.f5379g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(ahVar.toString());
                }
            }
        }
        if (this.f5382j != null) {
            size = this.f5382j.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    ahVar = (ah) this.f5382j.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(ahVar.toString());
                }
            }
        }
        if (this.f5381i != null) {
            size = this.f5381i.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    C0369v c0369v = (C0369v) this.f5381i.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0369v.toString());
                    c0369v.m26657a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.f5383k != null) {
                int size2 = this.f5383k.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        c0369v = (C0369v) this.f5383k.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(c0369v);
                    }
                }
            }
            if (this.f5384l != null && this.f5384l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f5384l.toArray()));
            }
        }
        if (this.f5375c != null) {
            i = this.f5375c.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.f5375c.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f5387o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f5388p);
        if (this.f5389q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f5389q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f5386n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f5391t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f5392u);
        if (this.f5390s) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f5390s);
        }
        if (this.f5393v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f5393v);
        }
        if (this.f5380h != null && this.f5380h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.f5380h.toArray()));
        }
    }

    static Animation m7041a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f5368A);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(f5369B);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    static Animation m7040a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f5369B);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    Animation m7051a(ah ahVar, int i, boolean z, int i2) {
        Animation a = ahVar.m1274a(i, z, ahVar.f999Q);
        if (a != null) {
            return a;
        }
        if (ahVar.f999Q != 0) {
            a = AnimationUtils.loadAnimation(this.f5387o.m6165g(), ahVar.f999Q);
            if (a != null) {
                return a;
            }
        }
        if (i == 0) {
            return null;
        }
        int b = m7045b(i, z);
        if (b < 0) {
            return null;
        }
        switch (b) {
            case 1:
                return m7041a(this.f5387o.m6165g(), 1.125f, (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.0f, (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            case 2:
                return m7041a(this.f5387o.m6165g(), (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.975f, (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.0f);
            case 3:
                return m7041a(this.f5387o.m6165g(), 0.975f, (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.0f, (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            case 4:
                return m7041a(this.f5387o.m6165g(), (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 1.075f, (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.0f);
            case 5:
                return m7040a(this.f5387o.m6165g(), 0.0f, (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            case 6:
                return m7040a(this.f5387o.m6165g(), (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.0f);
            default:
                if (i2 == 0 && this.f5387o.mo726d()) {
                    i2 = this.f5387o.mo727e();
                }
                if (i2 == 0) {
                    return null;
                }
                return null;
        }
    }

    public void m7063a(ah ahVar) {
        if (!ahVar.f1003U) {
            return;
        }
        if (this.f5377e) {
            this.f5394w = true;
            return;
        }
        ahVar.f1003U = false;
        m7065a(ahVar, this.f5386n, 0, 0, false);
    }

    private void m7046b(View view, Animation animation) {
        if (view != null && animation != null && m7043a(view, animation)) {
            AnimationListener animationListener;
            try {
                if (f5374r == null) {
                    f5374r = Animation.class.getDeclaredField("mListener");
                    f5374r.setAccessible(true);
                }
                animationListener = (AnimationListener) f5374r.get(animation);
            } catch (Throwable e) {
                Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e);
                animationListener = null;
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
                animationListener = null;
            }
            ja.m24137a(view, 2, null);
            animation.setAnimationListener(new ax(view, animation, animationListener));
        }
    }

    boolean m7081b(int i) {
        return this.f5386n >= i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m7065a(com.ushareit.listenit.ah r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r9 = 4;
        r6 = 3;
        r3 = 0;
        r5 = 1;
        r7 = 0;
        r0 = r11.f1020v;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r11.f993K;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r12 <= r5) goto L_0x0010;
    L_0x000f:
        r12 = r5;
    L_0x0010:
        r0 = r11.f1021w;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r11.f1009k;
        if (r12 <= r0) goto L_0x001a;
    L_0x0018:
        r12 = r11.f1009k;
    L_0x001a:
        r0 = r11.f1003U;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r11.f1009k;
        if (r0 >= r9) goto L_0x0025;
    L_0x0022:
        if (r12 <= r6) goto L_0x0025;
    L_0x0024:
        r12 = r6;
    L_0x0025:
        r0 = r11.f1009k;
        if (r0 >= r12) goto L_0x02eb;
    L_0x0029:
        r0 = r11.f1022x;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r11.f1023y;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r11.f1010l;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r11.f1010l = r7;
        r2 = r11.f1011m;
        r0 = r10;
        r1 = r11;
        r4 = r3;
        r0.m7065a(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r11.f1009k;
        switch(r0) {
            case 0: goto L_0x0080;
            case 1: goto L_0x0176;
            case 2: goto L_0x026d;
            case 3: goto L_0x0272;
            case 4: goto L_0x0293;
            default: goto L_0x0045;
        };
    L_0x0045:
        r0 = r11.f1009k;
        if (r0 == r12) goto L_0x0031;
    L_0x0049:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveToState: Fragment state for ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " not updated inline; ";
        r1 = r1.append(r2);
        r2 = "expected state ";
        r1 = r1.append(r2);
        r1 = r1.append(r12);
        r2 = " found ";
        r1 = r1.append(r2);
        r2 = r11.f1009k;
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        r11.f1009k = r12;
        goto L_0x0031;
    L_0x0080:
        r0 = f5372a;
        if (r0 == 0) goto L_0x009c;
    L_0x0084:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x009c:
        r0 = r11.f1012n;
        if (r0 == 0) goto L_0x00e4;
    L_0x00a0:
        r0 = r11.f1012n;
        r1 = r10.f5387o;
        r1 = r1.m6165g();
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r11.f1012n;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.f1013o = r0;
        r0 = r11.f1012n;
        r1 = "android:target_state";
        r0 = r10.m7053a(r0, r1);
        r11.f1017s = r0;
        r0 = r11.f1017s;
        if (r0 == 0) goto L_0x00d1;
    L_0x00c7:
        r0 = r11.f1012n;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r11.f1019u = r0;
    L_0x00d1:
        r0 = r11.f1012n;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r11.f1004V = r0;
        r0 = r11.f1004V;
        if (r0 != 0) goto L_0x00e4;
    L_0x00df:
        r11.f1003U = r5;
        if (r12 <= r6) goto L_0x00e4;
    L_0x00e3:
        r12 = r6;
    L_0x00e4:
        r0 = r10.f5387o;
        r11.f985C = r0;
        r0 = r10.f5389q;
        r11.f988F = r0;
        r0 = r10.f5389q;
        if (r0 == 0) goto L_0x0124;
    L_0x00f0:
        r0 = r10.f5389q;
        r0 = r0.f986D;
    L_0x00f4:
        r11.f984B = r0;
        r11.f998P = r3;
        r0 = r10.f5387o;
        r0 = r0.m6165g();
        r11.mo167a(r0);
        r0 = r11.f998P;
        if (r0 != 0) goto L_0x012b;
    L_0x0105:
        r0 = new com.ushareit.listenit.dt;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0124:
        r0 = r10.f5387o;
        r0 = r0.m6167i();
        goto L_0x00f4;
    L_0x012b:
        r0 = r11.f988F;
        if (r0 != 0) goto L_0x02ba;
    L_0x012f:
        r0 = r10.f5387o;
        r0.mo724b(r11);
    L_0x0134:
        r0 = r11.f995M;
        if (r0 != 0) goto L_0x02c1;
    L_0x0138:
        r0 = r11.f1012n;
        r11.m1323j(r0);
    L_0x013d:
        r11.f995M = r3;
        r0 = r11.f1022x;
        if (r0 == 0) goto L_0x0176;
    L_0x0143:
        r0 = r11.f1012n;
        r0 = r11.mo169b(r0);
        r1 = r11.f1012n;
        r0 = r11.m1298b(r0, r7, r1);
        r11.f1001S = r0;
        r0 = r11.f1001S;
        if (r0 == 0) goto L_0x02d4;
    L_0x0155:
        r0 = r11.f1001S;
        r11.f1002T = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x02ca;
    L_0x015f:
        r0 = r11.f1001S;
        com.ushareit.listenit.ja.m24143a(r0, r3);
    L_0x0164:
        r0 = r11.f992J;
        if (r0 == 0) goto L_0x016f;
    L_0x0168:
        r0 = r11.f1001S;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x016f:
        r0 = r11.f1001S;
        r1 = r11.f1012n;
        r11.mo2387a(r0, r1);
    L_0x0176:
        if (r12 <= r5) goto L_0x026d;
    L_0x0178:
        r0 = f5372a;
        if (r0 == 0) goto L_0x0194;
    L_0x017c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0194:
        r0 = r11.f1022x;
        if (r0 != 0) goto L_0x025d;
    L_0x0198:
        r0 = r11.f990H;
        if (r0 == 0) goto L_0x0421;
    L_0x019c:
        r0 = r11.f990H;
        r1 = -1;
        if (r0 != r1) goto L_0x01c2;
    L_0x01a1:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Cannot create fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " for a container view with no id";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        r10.m7042a(r0);
    L_0x01c2:
        r0 = r10.f5388p;
        r1 = r11.f990H;
        r0 = r0.mo635a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x0211;
    L_0x01ce:
        r1 = r11.f1024z;
        if (r1 != 0) goto L_0x0211;
    L_0x01d2:
        r1 = r11.m1329n();	 Catch:{ NotFoundException -> 0x02d8 }
        r2 = r11.f990H;	 Catch:{ NotFoundException -> 0x02d8 }
        r1 = r1.getResourceName(r2);	 Catch:{ NotFoundException -> 0x02d8 }
    L_0x01dc:
        r2 = new java.lang.IllegalArgumentException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r8 = "No view found for id 0x";
        r4 = r4.append(r8);
        r8 = r11.f990H;
        r8 = java.lang.Integer.toHexString(r8);
        r4 = r4.append(r8);
        r8 = " (";
        r4 = r4.append(r8);
        r1 = r4.append(r1);
        r4 = ") for fragment ";
        r1 = r1.append(r4);
        r1 = r1.append(r11);
        r1 = r1.toString();
        r2.<init>(r1);
        r10.m7042a(r2);
    L_0x0211:
        r11.f1000R = r0;
        r1 = r11.f1012n;
        r1 = r11.mo169b(r1);
        r2 = r11.f1012n;
        r1 = r11.m1298b(r1, r0, r2);
        r11.f1001S = r1;
        r1 = r11.f1001S;
        if (r1 == 0) goto L_0x02e7;
    L_0x0225:
        r1 = r11.f1001S;
        r11.f1002T = r1;
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 11;
        if (r1 < r2) goto L_0x02dd;
    L_0x022f:
        r1 = r11.f1001S;
        com.ushareit.listenit.ja.m24143a(r1, r3);
    L_0x0234:
        if (r0 == 0) goto L_0x024b;
    L_0x0236:
        r1 = r10.m7051a(r11, r13, r5, r14);
        if (r1 == 0) goto L_0x0246;
    L_0x023c:
        r2 = r11.f1001S;
        r10.m7046b(r2, r1);
        r2 = r11.f1001S;
        r2.startAnimation(r1);
    L_0x0246:
        r1 = r11.f1001S;
        r0.addView(r1);
    L_0x024b:
        r0 = r11.f992J;
        if (r0 == 0) goto L_0x0256;
    L_0x024f:
        r0 = r11.f1001S;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0256:
        r0 = r11.f1001S;
        r1 = r11.f1012n;
        r11.mo2387a(r0, r1);
    L_0x025d:
        r0 = r11.f1012n;
        r11.m1325k(r0);
        r0 = r11.f1001S;
        if (r0 == 0) goto L_0x026b;
    L_0x0266:
        r0 = r11.f1012n;
        r11.m1314f(r0);
    L_0x026b:
        r11.f1012n = r7;
    L_0x026d:
        r0 = 2;
        if (r12 <= r0) goto L_0x0272;
    L_0x0270:
        r11.f1009k = r6;
    L_0x0272:
        if (r12 <= r6) goto L_0x0293;
    L_0x0274:
        r0 = f5372a;
        if (r0 == 0) goto L_0x0290;
    L_0x0278:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0290:
        r11.m1264L();
    L_0x0293:
        if (r12 <= r9) goto L_0x0045;
    L_0x0295:
        r0 = f5372a;
        if (r0 == 0) goto L_0x02b1;
    L_0x0299:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02b1:
        r11.m1265M();
        r11.f1012n = r7;
        r11.f1013o = r7;
        goto L_0x0045;
    L_0x02ba:
        r0 = r11.f988F;
        r0.m1292a(r11);
        goto L_0x0134;
    L_0x02c1:
        r0 = r11.f1012n;
        r11.m1319h(r0);
        r11.f1009k = r5;
        goto L_0x013d;
    L_0x02ca:
        r0 = r11.f1001S;
        r0 = android.support.v4.app.NoSaveStateFrameLayout.m6a(r0);
        r11.f1001S = r0;
        goto L_0x0164;
    L_0x02d4:
        r11.f1002T = r7;
        goto L_0x0176;
    L_0x02d8:
        r1 = move-exception;
        r1 = "unknown";
        goto L_0x01dc;
    L_0x02dd:
        r1 = r11.f1001S;
        r1 = android.support.v4.app.NoSaveStateFrameLayout.m6a(r1);
        r11.f1001S = r1;
        goto L_0x0234;
    L_0x02e7:
        r11.f1002T = r7;
        goto L_0x025d;
    L_0x02eb:
        r0 = r11.f1009k;
        if (r0 <= r12) goto L_0x0045;
    L_0x02ef:
        r0 = r11.f1009k;
        switch(r0) {
            case 1: goto L_0x02f6;
            case 2: goto L_0x0374;
            case 3: goto L_0x0353;
            case 4: goto L_0x0332;
            case 5: goto L_0x0310;
            default: goto L_0x02f4;
        };
    L_0x02f4:
        goto L_0x0045;
    L_0x02f6:
        if (r12 >= r5) goto L_0x0045;
    L_0x02f8:
        r0 = r10.f5392u;
        if (r0 == 0) goto L_0x0307;
    L_0x02fc:
        r0 = r11.f1010l;
        if (r0 == 0) goto L_0x0307;
    L_0x0300:
        r0 = r11.f1010l;
        r11.f1010l = r7;
        r0.clearAnimation();
    L_0x0307:
        r0 = r11.f1010l;
        if (r0 == 0) goto L_0x03e3;
    L_0x030b:
        r11.f1011m = r12;
        r12 = r5;
        goto L_0x0045;
    L_0x0310:
        r0 = 5;
        if (r12 >= r0) goto L_0x0332;
    L_0x0313:
        r0 = f5372a;
        if (r0 == 0) goto L_0x032f;
    L_0x0317:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x032f:
        r11.m1267O();
    L_0x0332:
        if (r12 >= r9) goto L_0x0353;
    L_0x0334:
        r0 = f5372a;
        if (r0 == 0) goto L_0x0350;
    L_0x0338:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0350:
        r11.m1268P();
    L_0x0353:
        if (r12 >= r6) goto L_0x0374;
    L_0x0355:
        r0 = f5372a;
        if (r0 == 0) goto L_0x0371;
    L_0x0359:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0371:
        r11.m1269Q();
    L_0x0374:
        r0 = 2;
        if (r12 >= r0) goto L_0x02f6;
    L_0x0377:
        r0 = f5372a;
        if (r0 == 0) goto L_0x0393;
    L_0x037b:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0393:
        r0 = r11.f1001S;
        if (r0 == 0) goto L_0x03a6;
    L_0x0397:
        r0 = r10.f5387o;
        r0 = r0.mo721a(r11);
        if (r0 == 0) goto L_0x03a6;
    L_0x039f:
        r0 = r11.f1013o;
        if (r0 != 0) goto L_0x03a6;
    L_0x03a3:
        r10.m7090e(r11);
    L_0x03a6:
        r11.m1270R();
        r0 = r11.f1001S;
        if (r0 == 0) goto L_0x03db;
    L_0x03ad:
        r0 = r11.f1000R;
        if (r0 == 0) goto L_0x03db;
    L_0x03b1:
        r0 = r10.f5386n;
        if (r0 <= 0) goto L_0x041f;
    L_0x03b5:
        r0 = r10.f5392u;
        if (r0 != 0) goto L_0x041f;
    L_0x03b9:
        r0 = r10.m7051a(r11, r13, r3, r14);
    L_0x03bd:
        if (r0 == 0) goto L_0x03d4;
    L_0x03bf:
        r1 = r11.f1001S;
        r11.f1010l = r1;
        r11.f1011m = r12;
        r1 = r11.f1001S;
        r2 = new com.ushareit.listenit.aw;
        r2.<init>(r10, r1, r0, r11);
        r0.setAnimationListener(r2);
        r1 = r11.f1001S;
        r1.startAnimation(r0);
    L_0x03d4:
        r0 = r11.f1000R;
        r1 = r11.f1001S;
        r0.removeView(r1);
    L_0x03db:
        r11.f1000R = r7;
        r11.f1001S = r7;
        r11.f1002T = r7;
        goto L_0x02f6;
    L_0x03e3:
        r0 = f5372a;
        if (r0 == 0) goto L_0x03ff;
    L_0x03e7:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03ff:
        r0 = r11.f995M;
        if (r0 != 0) goto L_0x0414;
    L_0x0403:
        r11.m1271S();
    L_0x0406:
        r11.m1272T();
        if (r15 != 0) goto L_0x0045;
    L_0x040b:
        r0 = r11.f995M;
        if (r0 != 0) goto L_0x0417;
    L_0x040f:
        r10.m7088d(r11);
        goto L_0x0045;
    L_0x0414:
        r11.f1009k = r3;
        goto L_0x0406;
    L_0x0417:
        r11.f985C = r7;
        r11.f988F = r7;
        r11.f984B = r7;
        goto L_0x0045;
    L_0x041f:
        r0 = r7;
        goto L_0x03bd;
    L_0x0421:
        r0 = r7;
        goto L_0x0211;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.at.a(com.ushareit.listenit.ah, int, int, int, boolean):void");
    }

    void m7076b(ah ahVar) {
        m7065a(ahVar, this.f5386n, 0, 0, false);
    }

    void m7059a(int i, boolean z) {
        m7057a(i, 0, 0, z);
    }

    void m7057a(int i, int i2, int i3, boolean z) {
        if (this.f5387o == null && i != 0) {
            throw new IllegalStateException("No host");
        } else if (z || this.f5386n != i) {
            this.f5386n = i;
            if (this.f5378f != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.f5378f.size()) {
                    int a;
                    ah ahVar = (ah) this.f5378f.get(i4);
                    if (ahVar != null) {
                        m7065a(ahVar, i, i2, i3, false);
                        if (ahVar.f1005W != null) {
                            a = i5 | ahVar.f1005W.mo1086a();
                            i4++;
                            i5 = a;
                        }
                    }
                    a = i5;
                    i4++;
                    i5 = a;
                }
                if (i5 == 0) {
                    m7087d();
                }
                if (this.f5390s && this.f5387o != null && this.f5386n == 5) {
                    this.f5387o.mo725c();
                    this.f5390s = false;
                }
            }
        }
    }

    void m7087d() {
        if (this.f5378f != null) {
            for (int i = 0; i < this.f5378f.size(); i++) {
                ah ahVar = (ah) this.f5378f.get(i);
                if (ahVar != null) {
                    m7063a(ahVar);
                }
            }
        }
    }

    void m7084c(ah ahVar) {
        if (ahVar.f1014p < 0) {
            if (this.f5380h == null || this.f5380h.size() <= 0) {
                if (this.f5378f == null) {
                    this.f5378f = new ArrayList();
                }
                ahVar.m1278a(this.f5378f.size(), this.f5389q);
                this.f5378f.add(ahVar);
            } else {
                ahVar.m1278a(((Integer) this.f5380h.remove(this.f5380h.size() - 1)).intValue(), this.f5389q);
                this.f5378f.set(ahVar.f1014p, ahVar);
            }
            if (f5372a) {
                Log.v("FragmentManager", "Allocated fragment index " + ahVar);
            }
        }
    }

    void m7088d(ah ahVar) {
        if (ahVar.f1014p >= 0) {
            if (f5372a) {
                Log.v("FragmentManager", "Freeing fragment index " + ahVar);
            }
            this.f5378f.set(ahVar.f1014p, null);
            if (this.f5380h == null) {
                this.f5380h = new ArrayList();
            }
            this.f5380h.add(Integer.valueOf(ahVar.f1014p));
            this.f5387o.m6159b(ahVar.f1015q);
            ahVar.m1253A();
        }
    }

    public void m7066a(ah ahVar, boolean z) {
        if (this.f5379g == null) {
            this.f5379g = new ArrayList();
        }
        if (f5372a) {
            Log.v("FragmentManager", "add: " + ahVar);
        }
        m7084c(ahVar);
        if (!ahVar.f993K) {
            if (this.f5379g.contains(ahVar)) {
                throw new IllegalStateException("Fragment already added: " + ahVar);
            }
            this.f5379g.add(ahVar);
            ahVar.f1020v = true;
            ahVar.f1021w = false;
            if (ahVar.f996N && ahVar.f997O) {
                this.f5390s = true;
            }
            if (z) {
                m7076b(ahVar);
            }
        }
    }

    public void m7064a(ah ahVar, int i, int i2) {
        if (f5372a) {
            Log.v("FragmentManager", "remove: " + ahVar + " nesting=" + ahVar.f983A);
        }
        boolean z = !ahVar.m1321i();
        if (!ahVar.f993K || z) {
            int i3;
            if (this.f5379g != null) {
                this.f5379g.remove(ahVar);
            }
            if (ahVar.f996N && ahVar.f997O) {
                this.f5390s = true;
            }
            ahVar.f1020v = false;
            ahVar.f1021w = true;
            if (z) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            m7065a(ahVar, i3, i, i2, false);
        }
    }

    public void m7077b(ah ahVar, int i, int i2) {
        if (f5372a) {
            Log.v("FragmentManager", "hide: " + ahVar);
        }
        if (!ahVar.f992J) {
            ahVar.f992J = true;
            if (ahVar.f1001S != null) {
                Animation a = m7051a(ahVar, i, false, i2);
                if (a != null) {
                    m7046b(ahVar.f1001S, a);
                    ahVar.f1001S.startAnimation(a);
                }
                ahVar.f1001S.setVisibility(8);
            }
            if (ahVar.f1020v && ahVar.f996N && ahVar.f997O) {
                this.f5390s = true;
            }
            ahVar.mo2580c(true);
        }
    }

    public void m7085c(ah ahVar, int i, int i2) {
        if (f5372a) {
            Log.v("FragmentManager", "show: " + ahVar);
        }
        if (ahVar.f992J) {
            ahVar.f992J = false;
            if (ahVar.f1001S != null) {
                Animation a = m7051a(ahVar, i, true, i2);
                if (a != null) {
                    m7046b(ahVar.f1001S, a);
                    ahVar.f1001S.startAnimation(a);
                }
                ahVar.f1001S.setVisibility(0);
            }
            if (ahVar.f1020v && ahVar.f996N && ahVar.f997O) {
                this.f5390s = true;
            }
            ahVar.mo2580c(false);
        }
    }

    public void m7089d(ah ahVar, int i, int i2) {
        if (f5372a) {
            Log.v("FragmentManager", "detach: " + ahVar);
        }
        if (!ahVar.f993K) {
            ahVar.f993K = true;
            if (ahVar.f1020v) {
                if (this.f5379g != null) {
                    if (f5372a) {
                        Log.v("FragmentManager", "remove from detach: " + ahVar);
                    }
                    this.f5379g.remove(ahVar);
                }
                if (ahVar.f996N && ahVar.f997O) {
                    this.f5390s = true;
                }
                ahVar.f1020v = false;
                m7065a(ahVar, 1, i, i2, false);
            }
        }
    }

    public void m7091e(ah ahVar, int i, int i2) {
        if (f5372a) {
            Log.v("FragmentManager", "attach: " + ahVar);
        }
        if (ahVar.f993K) {
            ahVar.f993K = false;
            if (!ahVar.f1020v) {
                if (this.f5379g == null) {
                    this.f5379g = new ArrayList();
                }
                if (this.f5379g.contains(ahVar)) {
                    throw new IllegalStateException("Fragment already added: " + ahVar);
                }
                if (f5372a) {
                    Log.v("FragmentManager", "add from attach: " + ahVar);
                }
                this.f5379g.add(ahVar);
                ahVar.f1020v = true;
                if (ahVar.f996N && ahVar.f997O) {
                    this.f5390s = true;
                }
                m7065a(ahVar, this.f5386n, i, i2, false);
            }
        }
    }

    public ah mo795a(int i) {
        int size;
        ah ahVar;
        if (this.f5379g != null) {
            for (size = this.f5379g.size() - 1; size >= 0; size--) {
                ahVar = (ah) this.f5379g.get(size);
                if (ahVar != null && ahVar.f989G == i) {
                    return ahVar;
                }
            }
        }
        if (this.f5378f != null) {
            for (size = this.f5378f.size() - 1; size >= 0; size--) {
                ahVar = (ah) this.f5378f.get(size);
                if (ahVar != null && ahVar.f989G == i) {
                    return ahVar;
                }
            }
        }
        return null;
    }

    public ah mo796a(String str) {
        int size;
        ah ahVar;
        if (!(this.f5379g == null || str == null)) {
            for (size = this.f5379g.size() - 1; size >= 0; size--) {
                ahVar = (ah) this.f5379g.get(size);
                if (ahVar != null && str.equals(ahVar.f991I)) {
                    return ahVar;
                }
            }
        }
        if (!(this.f5378f == null || str == null)) {
            for (size = this.f5378f.size() - 1; size >= 0; size--) {
                ahVar = (ah) this.f5378f.get(size);
                if (ahVar != null && str.equals(ahVar.f991I)) {
                    return ahVar;
                }
            }
        }
        return null;
    }

    public ah m7074b(String str) {
        if (!(this.f5378f == null || str == null)) {
            for (int size = this.f5378f.size() - 1; size >= 0; size--) {
                ah ahVar = (ah) this.f5378f.get(size);
                if (ahVar != null) {
                    ahVar = ahVar.m1299b(str);
                    if (ahVar != null) {
                        return ahVar;
                    }
                }
            }
        }
        return null;
    }

    private void m7048v() {
        if (this.f5391t) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f5393v != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f5393v);
        }
    }

    public void m7068a(Runnable runnable, boolean z) {
        if (!z) {
            m7048v();
        }
        synchronized (this) {
            if (this.f5392u || this.f5387o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.f5375c == null) {
                this.f5375c = new ArrayList();
            }
            this.f5375c.add(runnable);
            if (this.f5375c.size() == 1) {
                this.f5387o.m6166h().removeCallbacks(this.f5397z);
                this.f5387o.m6166h().post(this.f5397z);
            }
        }
    }

    public int m7049a(C0369v c0369v) {
        int size;
        synchronized (this) {
            if (this.f5384l == null || this.f5384l.size() <= 0) {
                if (this.f5383k == null) {
                    this.f5383k = new ArrayList();
                }
                size = this.f5383k.size();
                if (f5372a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + c0369v);
                }
                this.f5383k.add(c0369v);
            } else {
                size = ((Integer) this.f5384l.remove(this.f5384l.size() - 1)).intValue();
                if (f5372a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + c0369v);
                }
                this.f5383k.set(size, c0369v);
            }
        }
        return size;
    }

    public void m7058a(int i, C0369v c0369v) {
        synchronized (this) {
            if (this.f5383k == null) {
                this.f5383k = new ArrayList();
            }
            int size = this.f5383k.size();
            if (i < size) {
                if (f5372a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + c0369v);
                }
                this.f5383k.set(i, c0369v);
            } else {
                while (size < i) {
                    this.f5383k.add(null);
                    if (this.f5384l == null) {
                        this.f5384l = new ArrayList();
                    }
                    if (f5372a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f5384l.add(Integer.valueOf(size));
                    size++;
                }
                if (f5372a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + c0369v);
                }
                this.f5383k.add(c0369v);
            }
        }
    }

    public void m7083c(int i) {
        synchronized (this) {
            this.f5383k.set(i, null);
            if (this.f5384l == null) {
                this.f5384l = new ArrayList();
            }
            if (f5372a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f5384l.add(Integer.valueOf(i));
        }
    }

    public void m7079b(Runnable runnable, boolean z) {
        if (this.f5377e) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (Looper.myLooper() != this.f5387o.m6166h().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else {
            if (!z) {
                m7048v();
            }
            this.f5377e = true;
            runnable.run();
            this.f5377e = false;
            m7094f();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m7092e() {
        /*
        r6 = this;
        r2 = 1;
        r1 = 0;
        r0 = r6.f5377e;
        if (r0 == 0) goto L_0x000e;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "FragmentManager is already executing transactions";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r0 = android.os.Looper.myLooper();
        r3 = r6.f5387o;
        r3 = r3.m6166h();
        r3 = r3.getLooper();
        if (r0 == r3) goto L_0x0026;
    L_0x001e:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of fragment host";
        r0.<init>(r1);
        throw r0;
    L_0x0026:
        r0 = r1;
    L_0x0027:
        monitor-enter(r6);
        r3 = r6.f5375c;	 Catch:{ all -> 0x0078 }
        if (r3 == 0) goto L_0x0034;
    L_0x002c:
        r3 = r6.f5375c;	 Catch:{ all -> 0x0078 }
        r3 = r3.size();	 Catch:{ all -> 0x0078 }
        if (r3 != 0) goto L_0x0039;
    L_0x0034:
        monitor-exit(r6);	 Catch:{ all -> 0x0078 }
        r6.m7094f();
        return r0;
    L_0x0039:
        r0 = r6.f5375c;	 Catch:{ all -> 0x0078 }
        r3 = r0.size();	 Catch:{ all -> 0x0078 }
        r0 = r6.f5376d;	 Catch:{ all -> 0x0078 }
        if (r0 == 0) goto L_0x0048;
    L_0x0043:
        r0 = r6.f5376d;	 Catch:{ all -> 0x0078 }
        r0 = r0.length;	 Catch:{ all -> 0x0078 }
        if (r0 >= r3) goto L_0x004c;
    L_0x0048:
        r0 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x0078 }
        r6.f5376d = r0;	 Catch:{ all -> 0x0078 }
    L_0x004c:
        r0 = r6.f5375c;	 Catch:{ all -> 0x0078 }
        r4 = r6.f5376d;	 Catch:{ all -> 0x0078 }
        r0.toArray(r4);	 Catch:{ all -> 0x0078 }
        r0 = r6.f5375c;	 Catch:{ all -> 0x0078 }
        r0.clear();	 Catch:{ all -> 0x0078 }
        r0 = r6.f5387o;	 Catch:{ all -> 0x0078 }
        r0 = r0.m6166h();	 Catch:{ all -> 0x0078 }
        r4 = r6.f5397z;	 Catch:{ all -> 0x0078 }
        r0.removeCallbacks(r4);	 Catch:{ all -> 0x0078 }
        monitor-exit(r6);	 Catch:{ all -> 0x0078 }
        r6.f5377e = r2;
        r0 = r1;
    L_0x0067:
        if (r0 >= r3) goto L_0x007b;
    L_0x0069:
        r4 = r6.f5376d;
        r4 = r4[r0];
        r4.run();
        r4 = r6.f5376d;
        r5 = 0;
        r4[r0] = r5;
        r0 = r0 + 1;
        goto L_0x0067;
    L_0x0078:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0078 }
        throw r0;
    L_0x007b:
        r6.f5377e = r1;
        r0 = r2;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ushareit.listenit.at.e():boolean");
    }

    void m7094f() {
        if (this.f5394w) {
            int i = 0;
            for (int i2 = 0; i2 < this.f5378f.size(); i2++) {
                ah ahVar = (ah) this.f5378f.get(i2);
                if (!(ahVar == null || ahVar.f1005W == null)) {
                    i |= ahVar.f1005W.mo1086a();
                }
            }
            if (i == 0) {
                this.f5394w = false;
                m7087d();
            }
        }
    }

    void m7095g() {
        if (this.f5385m != null) {
            for (int i = 0; i < this.f5385m.size(); i++) {
                ((as) this.f5385m.get(i)).m6944a();
            }
        }
    }

    void m7078b(C0369v c0369v) {
        if (this.f5381i == null) {
            this.f5381i = new ArrayList();
        }
        this.f5381i.add(c0369v);
        m7095g();
    }

    boolean m7070a(Handler handler, String str, int i, int i2) {
        if (this.f5381i == null) {
            return false;
        }
        int size;
        C0369v c0369v;
        if (str == null && i < 0 && (i2 & 1) == 0) {
            size = this.f5381i.size() - 1;
            if (size < 0) {
                return false;
            }
            c0369v = (C0369v) this.f5381i.remove(size);
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            if (this.f5386n >= 1) {
                c0369v.m26655a(sparseArray, sparseArray2);
            }
            c0369v.m26647a(true, null, sparseArray, sparseArray2);
            m7095g();
        } else {
            int size2;
            size = -1;
            if (str != null || i >= 0) {
                size2 = this.f5381i.size() - 1;
                while (size2 >= 0) {
                    c0369v = (C0369v) this.f5381i.get(size2);
                    if ((str != null && str.equals(c0369v.m26668e())) || (i >= 0 && i == c0369v.f17018p)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        c0369v = (C0369v) this.f5381i.get(size2);
                        if ((str == null || !str.equals(c0369v.m26668e())) && (i < 0 || i != c0369v.f17018p)) {
                            break;
                        }
                        size2--;
                    }
                }
                size = size2;
            }
            if (size == this.f5381i.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (size2 = this.f5381i.size() - 1; size2 > size; size2--) {
                arrayList.add(this.f5381i.remove(size2));
            }
            int size3 = arrayList.size() - 1;
            SparseArray sparseArray3 = new SparseArray();
            SparseArray sparseArray4 = new SparseArray();
            if (this.f5386n >= 1) {
                for (size2 = 0; size2 <= size3; size2++) {
                    ((C0369v) arrayList.get(size2)).m26655a(sparseArray3, sparseArray4);
                }
            }
            aa aaVar = null;
            int i3 = 0;
            while (i3 <= size3) {
                boolean z;
                if (f5372a) {
                    Log.v("FragmentManager", "Popping back stack state: " + arrayList.get(i3));
                }
                c0369v = (C0369v) arrayList.get(i3);
                if (i3 == size3) {
                    z = true;
                } else {
                    z = false;
                }
                i3++;
                aaVar = c0369v.m26647a(z, aaVar, sparseArray3, sparseArray4);
            }
            m7095g();
        }
        return true;
    }

    ba m7096h() {
        List list;
        List list2;
        if (this.f5378f != null) {
            int i = 0;
            list = null;
            list2 = null;
            while (i < this.f5378f.size()) {
                ArrayList arrayList;
                ah ahVar = (ah) this.f5378f.get(i);
                if (ahVar != null) {
                    boolean z;
                    if (ahVar.f994L) {
                        if (list2 == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(ahVar);
                        ahVar.f995M = true;
                        ahVar.f1018t = ahVar.f1017s != null ? ahVar.f1017s.f1014p : -1;
                        if (f5372a) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + ahVar);
                        }
                    }
                    if (ahVar.f986D != null) {
                        ba h = ahVar.f986D.m7096h();
                        if (h != null) {
                            ArrayList arrayList2;
                            if (list == null) {
                                arrayList2 = new ArrayList();
                                for (int i2 = 0; i2 < i; i2++) {
                                    arrayList2.add(null);
                                }
                            } else {
                                arrayList2 = list;
                            }
                            arrayList2.add(h);
                            list = arrayList2;
                            z = true;
                            if (!(list == null || r0)) {
                                list.add(null);
                            }
                        }
                    }
                    z = false;
                    list.add(null);
                }
                i++;
                Object obj = arrayList;
            }
        } else {
            list = null;
            list2 = null;
        }
        if (list2 == null && list == null) {
            return null;
        }
        return new ba(list2, list);
    }

    void m7090e(ah ahVar) {
        if (ahVar.f1002T != null) {
            if (this.f5396y == null) {
                this.f5396y = new SparseArray();
            } else {
                this.f5396y.clear();
            }
            ahVar.f1002T.saveHierarchyState(this.f5396y);
            if (this.f5396y.size() > 0) {
                ahVar.f1013o = this.f5396y;
                this.f5396y = null;
            }
        }
    }

    Bundle m7093f(ah ahVar) {
        Bundle bundle;
        if (this.f5395x == null) {
            this.f5395x = new Bundle();
        }
        ahVar.m1327l(this.f5395x);
        if (this.f5395x.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f5395x;
            this.f5395x = null;
        }
        if (ahVar.f1001S != null) {
            m7090e(ahVar);
        }
        if (ahVar.f1013o != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", ahVar.f1013o);
        }
        if (!ahVar.f1004V) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", ahVar.f1004V);
        }
        return bundle;
    }

    Parcelable m7097i() {
        BackStackState[] backStackStateArr = null;
        m7092e();
        if (f5373b) {
            this.f5391t = true;
        }
        if (this.f5378f == null || this.f5378f.size() <= 0) {
            return null;
        }
        int size = this.f5378f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            ah ahVar = (ah) this.f5378f.get(i);
            if (ahVar != null) {
                if (ahVar.f1014p < 0) {
                    m7042a(new IllegalStateException("Failure saving state: active " + ahVar + " has cleared index: " + ahVar.f1014p));
                }
                FragmentState fragmentState = new FragmentState(ahVar);
                fragmentStateArr[i] = fragmentState;
                if (ahVar.f1009k <= 0 || fragmentState.f24k != null) {
                    fragmentState.f24k = ahVar.f1012n;
                } else {
                    fragmentState.f24k = m7093f(ahVar);
                    if (ahVar.f1017s != null) {
                        if (ahVar.f1017s.f1014p < 0) {
                            m7042a(new IllegalStateException("Failure saving state: " + ahVar + " has target not in fragment manager: " + ahVar.f1017s));
                        }
                        if (fragmentState.f24k == null) {
                            fragmentState.f24k = new Bundle();
                        }
                        m7061a(fragmentState.f24k, "android:target_state", ahVar.f1017s);
                        if (ahVar.f1019u != 0) {
                            fragmentState.f24k.putInt("android:target_req_state", ahVar.f1019u);
                        }
                    }
                }
                if (f5372a) {
                    Log.v("FragmentManager", "Saved state of " + ahVar + ": " + fragmentState.f24k);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            FragmentManagerState fragmentManagerState;
            if (this.f5379g != null) {
                i = this.f5379g.size();
                if (i > 0) {
                    iArr = new int[i];
                    for (i2 = 0; i2 < i; i2++) {
                        iArr[i2] = ((ah) this.f5379g.get(i2)).f1014p;
                        if (iArr[i2] < 0) {
                            m7042a(new IllegalStateException("Failure saving state: active " + this.f5379g.get(i2) + " has cleared index: " + iArr[i2]));
                        }
                        if (f5372a) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f5379g.get(i2));
                        }
                    }
                    if (this.f5381i != null) {
                        i = this.f5381i.size();
                        if (i > 0) {
                            backStackStateArr = new BackStackState[i];
                            for (i2 = 0; i2 < i; i2++) {
                                backStackStateArr[i2] = new BackStackState((C0369v) this.f5381i.get(i2));
                                if (f5372a) {
                                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f5381i.get(i2));
                                }
                            }
                        }
                    }
                    fragmentManagerState = new FragmentManagerState();
                    fragmentManagerState.f11a = fragmentStateArr;
                    fragmentManagerState.f12b = iArr;
                    fragmentManagerState.f13c = backStackStateArr;
                    return fragmentManagerState;
                }
            }
            iArr = null;
            if (this.f5381i != null) {
                i = this.f5381i.size();
                if (i > 0) {
                    backStackStateArr = new BackStackState[i];
                    for (i2 = 0; i2 < i; i2++) {
                        backStackStateArr[i2] = new BackStackState((C0369v) this.f5381i.get(i2));
                        if (f5372a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f5381i.get(i2));
                        }
                    }
                }
            }
            fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f11a = fragmentStateArr;
            fragmentManagerState.f12b = iArr;
            fragmentManagerState.f13c = backStackStateArr;
            return fragmentManagerState;
        } else if (!f5372a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    void m7062a(Parcelable parcelable, ba baVar) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f11a != null) {
                List a;
                int size;
                int i;
                ah ahVar;
                List list;
                if (baVar != null) {
                    a = baVar.m7482a();
                    List b = baVar.m7483b();
                    if (a != null) {
                        size = a.size();
                    } else {
                        boolean z = false;
                    }
                    for (i = 0; i < size; i++) {
                        ahVar = (ah) a.get(i);
                        if (f5372a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + ahVar);
                        }
                        FragmentState fragmentState = fragmentManagerState.f11a[ahVar.f1014p];
                        fragmentState.f25l = ahVar;
                        ahVar.f1013o = null;
                        ahVar.f983A = 0;
                        ahVar.f1023y = false;
                        ahVar.f1020v = false;
                        ahVar.f1017s = null;
                        if (fragmentState.f24k != null) {
                            fragmentState.f24k.setClassLoader(this.f5387o.m6165g().getClassLoader());
                            ahVar.f1013o = fragmentState.f24k.getSparseParcelableArray("android:view_state");
                            ahVar.f1012n = fragmentState.f24k;
                        }
                    }
                    list = b;
                } else {
                    list = null;
                }
                this.f5378f = new ArrayList(fragmentManagerState.f11a.length);
                if (this.f5380h != null) {
                    this.f5380h.clear();
                }
                int i2 = 0;
                while (i2 < fragmentManagerState.f11a.length) {
                    FragmentState fragmentState2 = fragmentManagerState.f11a[i2];
                    if (fragmentState2 != null) {
                        ba baVar2;
                        if (list == null || i2 >= list.size()) {
                            baVar2 = null;
                        } else {
                            baVar2 = (ba) list.get(i2);
                        }
                        ahVar = fragmentState2.m1a(this.f5387o, this.f5389q, baVar2);
                        if (f5372a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + ahVar);
                        }
                        this.f5378f.add(ahVar);
                        fragmentState2.f25l = null;
                    } else {
                        this.f5378f.add(null);
                        if (this.f5380h == null) {
                            this.f5380h = new ArrayList();
                        }
                        if (f5372a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.f5380h.add(Integer.valueOf(i2));
                    }
                    i2++;
                }
                if (baVar != null) {
                    a = baVar.m7482a();
                    if (a != null) {
                        i2 = a.size();
                    } else {
                        boolean z2 = false;
                    }
                    for (i = 0; i < i2; i++) {
                        ahVar = (ah) a.get(i);
                        if (ahVar.f1018t >= 0) {
                            if (ahVar.f1018t < this.f5378f.size()) {
                                ahVar.f1017s = (ah) this.f5378f.get(ahVar.f1018t);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + ahVar + " target no longer exists: " + ahVar.f1018t);
                                ahVar.f1017s = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.f12b != null) {
                    this.f5379g = new ArrayList(fragmentManagerState.f12b.length);
                    for (size = 0; size < fragmentManagerState.f12b.length; size++) {
                        ahVar = (ah) this.f5378f.get(fragmentManagerState.f12b[size]);
                        if (ahVar == null) {
                            m7042a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.f12b[size]));
                        }
                        ahVar.f1020v = true;
                        if (f5372a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + size + ": " + ahVar);
                        }
                        if (this.f5379g.contains(ahVar)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.f5379g.add(ahVar);
                    }
                } else {
                    this.f5379g = null;
                }
                if (fragmentManagerState.f13c != null) {
                    this.f5381i = new ArrayList(fragmentManagerState.f13c.length);
                    for (int i3 = 0; i3 < fragmentManagerState.f13c.length; i3++) {
                        C0369v a2 = fragmentManagerState.f13c[i3].m0a(this);
                        if (f5372a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i3 + " (index " + a2.f17018p + "): " + a2);
                            a2.m26658a("  ", new PrintWriter(new fu("FragmentManager")), false);
                        }
                        this.f5381i.add(a2);
                        if (a2.f17018p >= 0) {
                            m7058a(a2.f17018p, a2);
                        }
                    }
                    return;
                }
                this.f5381i = null;
            }
        }
    }

    public void m7067a(aq aqVar, ao aoVar, ah ahVar) {
        if (this.f5387o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f5387o = aqVar;
        this.f5388p = aoVar;
        this.f5389q = ahVar;
    }

    public void m7098j() {
        this.f5391t = false;
    }

    public void m7099k() {
        this.f5391t = false;
        m7059a(1, false);
    }

    public void m7100l() {
        this.f5391t = false;
        m7059a(2, false);
    }

    public void m7101m() {
        this.f5391t = false;
        m7059a(4, false);
    }

    public void m7102n() {
        this.f5391t = false;
        m7059a(5, false);
    }

    public void m7103o() {
        m7059a(4, false);
    }

    public void m7104p() {
        this.f5391t = true;
        m7059a(3, false);
    }

    public void m7105q() {
        m7059a(2, false);
    }

    public void m7106r() {
        m7059a(1, false);
    }

    public void m7107s() {
        this.f5392u = true;
        m7092e();
        m7059a(0, false);
        this.f5387o = null;
        this.f5388p = null;
        this.f5389q = null;
    }

    public void m7060a(Configuration configuration) {
        if (this.f5379g != null) {
            for (int i = 0; i < this.f5379g.size(); i++) {
                ah ahVar = (ah) this.f5379g.get(i);
                if (ahVar != null) {
                    ahVar.m1287a(configuration);
                }
            }
        }
    }

    public void m7108t() {
        if (this.f5379g != null) {
            for (int i = 0; i < this.f5379g.size(); i++) {
                ah ahVar = (ah) this.f5379g.get(i);
                if (ahVar != null) {
                    ahVar.m1266N();
                }
            }
        }
    }

    public boolean m7072a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        ah ahVar;
        int i = 0;
        ArrayList arrayList = null;
        if (this.f5379g != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.f5379g.size()) {
                ahVar = (ah) this.f5379g.get(i2);
                if (ahVar != null && ahVar.m1301b(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(ahVar);
                }
                i2++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.f5382j != null) {
            while (i < this.f5382j.size()) {
                ahVar = (ah) this.f5382j.get(i);
                if (arrayList == null || !arrayList.contains(ahVar)) {
                    ahVar.m1254B();
                }
                i++;
            }
        }
        this.f5382j = arrayList;
        return z;
    }

    public boolean m7071a(Menu menu) {
        if (this.f5379g == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f5379g.size(); i++) {
            ah ahVar = (ah) this.f5379g.get(i);
            if (ahVar != null && ahVar.m1304c(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean m7073a(MenuItem menuItem) {
        if (this.f5379g == null) {
            return false;
        }
        for (int i = 0; i < this.f5379g.size(); i++) {
            ah ahVar = (ah) this.f5379g.get(i);
            if (ahVar != null && ahVar.m1305c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean m7082b(MenuItem menuItem) {
        if (this.f5379g == null) {
            return false;
        }
        for (int i = 0; i < this.f5379g.size(); i++) {
            ah ahVar = (ah) this.f5379g.get(i);
            if (ahVar != null && ahVar.m1309d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void m7075b(Menu menu) {
        if (this.f5379g != null) {
            for (int i = 0; i < this.f5379g.size(); i++) {
                ah ahVar = (ah) this.f5379g.get(i);
                if (ahVar != null) {
                    ahVar.m1307d(menu);
                }
            }
        }
    }

    public static int m7047d(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    public static int m7045b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    public View mo794a(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String string;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, az.f5707a);
        if (attributeValue == null) {
            string = obtainStyledAttributes.getString(0);
        } else {
            string = attributeValue;
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!ah.m1252b(this.f5387o.m6165g(), string)) {
            return null;
        }
        int id;
        if (view != null) {
            id = view.getId();
        } else {
            id = 0;
        }
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        ah ahVar;
        ah a = resourceId != -1 ? mo795a(resourceId) : null;
        if (a == null && string2 != null) {
            a = mo796a(string2);
        }
        if (a == null && id != -1) {
            a = mo795a(id);
        }
        if (f5372a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + a);
        }
        if (a == null) {
            ah a2 = ah.m1250a(context, string);
            a2.f1022x = true;
            a2.f989G = resourceId != 0 ? resourceId : id;
            a2.f990H = id;
            a2.f991I = string2;
            a2.f1023y = true;
            a2.f984B = this;
            a2.f985C = this.f5387o;
            a2.m1283a(this.f5387o.m6165g(), attributeSet, a2.f1012n);
            m7066a(a2, true);
            ahVar = a2;
        } else if (a.f1023y) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            a.f1023y = true;
            a.f985C = this.f5387o;
            if (!a.f995M) {
                a.m1283a(this.f5387o.m6165g(), attributeSet, a.f1012n);
            }
            ahVar = a;
        }
        if (this.f5386n >= 1 || !ahVar.f1022x) {
            m7076b(ahVar);
        } else {
            m7065a(ahVar, 1, 0, 0, false);
        }
        if (ahVar.f1001S == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            ahVar.f1001S.setId(resourceId);
        }
        if (ahVar.f1001S.getTag() == null) {
            ahVar.f1001S.setTag(string2);
        }
        return ahVar.f1001S;
    }

    ht m7109u() {
        return this;
    }
}
