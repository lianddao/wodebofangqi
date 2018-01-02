package com.ushareit.listenit;

import android.telephony.PhoneStateListener;
import java.lang.ref.WeakReference;

public class hgh extends PhoneStateListener {
    private WeakReference<hgk> f15400a;
    private boolean f15401b = false;
    private boolean f15402c = false;
    private boolean f15403d = false;

    public void m23707a(hgk com_ushareit_listenit_hgk) {
        this.f15400a = new WeakReference(com_ushareit_listenit_hgk);
    }

    public void onCallStateChanged(int i, String str) {
        boolean z = true;
        if (this.f15400a != null && this.f15400a.get() != null) {
            hgk com_ushareit_listenit_hgk = (hgk) this.f15400a.get();
            switch (i) {
                case 0:
                    if ((this.f15401b || this.f15402c) && this.f15403d) {
                        com_ushareit_listenit_hgk.m23799d();
                    }
                    this.f15401b = false;
                    this.f15402c = false;
                    this.f15403d = false;
                    break;
                case 1:
                    this.f15401b = true;
                    this.f15403d = com_ushareit_listenit_hgk.m23804i();
                    com_ushareit_listenit_hgk.m23801f();
                    break;
                case 2:
                    if (this.f15401b) {
                        z = false;
                    }
                    this.f15402c = z;
                    this.f15403d = this.f15402c ? com_ushareit_listenit_hgk.m23804i() : this.f15403d;
                    com_ushareit_listenit_hgk.m23801f();
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    }
}
