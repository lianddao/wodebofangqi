package com.ushareit.listenit;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class ag extends ah implements OnCancelListener, OnDismissListener {
    int f1025a = 0;
    int f1026b = 0;
    boolean f1027c = true;
    boolean f1028d = true;
    int f1029e = -1;
    Dialog f1030f;
    boolean f1031g;
    boolean f1032h;
    boolean f1033i;

    public void m1343a(int i, int i2) {
        this.f1025a = i;
        if (this.f1025a == 2 || this.f1025a == 3) {
            this.f1026b = 16973913;
        }
        if (i2 != 0) {
            this.f1026b = i2;
        }
    }

    public void mo1295a(ar arVar, String str) {
        this.f1032h = false;
        this.f1033i = true;
        bh a = arVar.mo797a();
        a.mo3093a((ah) this, str);
        a.mo3095b();
    }

    public void m1342a() {
        m1348a(false);
    }

    public void m1350b() {
        m1348a(true);
    }

    void m1348a(boolean z) {
        if (!this.f1032h) {
            this.f1032h = true;
            this.f1033i = false;
            if (this.f1030f != null) {
                this.f1030f.dismiss();
                this.f1030f = null;
            }
            this.f1031g = true;
            if (this.f1029e >= 0) {
                m1330o().mo798a(this.f1029e, 1);
                this.f1029e = -1;
                return;
            }
            bh a = m1330o().mo797a();
            a.mo3092a((ah) this);
            if (z) {
                a.mo3098c();
            } else {
                a.mo3095b();
            }
        }
    }

    public Dialog m1352c() {
        return this.f1030f;
    }

    public int m1354d() {
        return this.f1026b;
    }

    public void m1351b(boolean z) {
        this.f1028d = z;
    }

    public void mo167a(Context context) {
        super.mo167a(context);
        if (!this.f1033i) {
            this.f1032h = false;
        }
    }

    public void mo171e() {
        super.mo171e();
        if (!this.f1033i && !this.f1032h) {
            this.f1032h = true;
        }
    }

    public void mo168a(Bundle bundle) {
        super.mo168a(bundle);
        this.f1028d = this.H == 0;
        if (bundle != null) {
            this.f1025a = bundle.getInt("android:style", 0);
            this.f1026b = bundle.getInt("android:theme", 0);
            this.f1027c = bundle.getBoolean("android:cancelable", true);
            this.f1028d = bundle.getBoolean("android:showsDialog", this.f1028d);
            this.f1029e = bundle.getInt("android:backStackId", -1);
        }
    }

    public LayoutInflater mo169b(Bundle bundle) {
        if (!this.f1028d) {
            return super.mo169b(bundle);
        }
        this.f1030f = mo176c(bundle);
        if (this.f1030f == null) {
            return (LayoutInflater) this.C.m6165g().getSystemService("layout_inflater");
        }
        m1344a(this.f1030f, this.f1025a);
        return (LayoutInflater) this.f1030f.getContext().getSystemService("layout_inflater");
    }

    public void m1344a(Dialog dialog, int i) {
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
                dialog.getWindow().addFlags(24);
                break;
            default:
                return;
        }
        dialog.requestWindowFeature(1);
    }

    public Dialog mo176c(Bundle bundle) {
        return new Dialog(m1328m(), m1354d());
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.f1031g) {
            m1348a(true);
        }
    }

    public void mo170d(Bundle bundle) {
        super.mo170d(bundle);
        if (this.f1028d) {
            View w = m1338w();
            if (w != null) {
                if (w.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f1030f.setContentView(w);
            }
            Activity m = m1328m();
            if (m != null) {
                this.f1030f.setOwnerActivity(m);
            }
            this.f1030f.setCancelable(this.f1027c);
            this.f1030f.setOnCancelListener(this);
            this.f1030f.setOnDismissListener(this);
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle("android:savedDialogState");
                if (bundle2 != null) {
                    this.f1030f.onRestoreInstanceState(bundle2);
                }
            }
        }
    }

    public void mo173f() {
        super.mo173f();
        if (this.f1030f != null) {
            this.f1031g = false;
            this.f1030f.show();
        }
    }

    public void mo172e(Bundle bundle) {
        super.mo172e(bundle);
        if (this.f1030f != null) {
            Bundle onSaveInstanceState = this.f1030f.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
        }
        if (this.f1025a != 0) {
            bundle.putInt("android:style", this.f1025a);
        }
        if (this.f1026b != 0) {
            bundle.putInt("android:theme", this.f1026b);
        }
        if (!this.f1027c) {
            bundle.putBoolean("android:cancelable", this.f1027c);
        }
        if (!this.f1028d) {
            bundle.putBoolean("android:showsDialog", this.f1028d);
        }
        if (this.f1029e != -1) {
            bundle.putInt("android:backStackId", this.f1029e);
        }
    }

    public void mo174g() {
        super.mo174g();
        if (this.f1030f != null) {
            this.f1030f.hide();
        }
    }

    public void mo175h() {
        super.mo175h();
        if (this.f1030f != null) {
            this.f1031g = true;
            this.f1030f.dismiss();
            this.f1030f = null;
        }
    }
}
