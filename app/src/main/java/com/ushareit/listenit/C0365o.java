package com.ushareit.listenit;

import android.app.Activity;
import android.content.pm.PackageManager;

final class C0365o implements Runnable {
    final /* synthetic */ String[] f16051a;
    final /* synthetic */ Activity f16052b;
    final /* synthetic */ int f16053c;

    C0365o(String[] strArr, Activity activity, int i) {
        this.f16051a = strArr;
        this.f16052b = activity;
        this.f16053c = i;
    }

    public void run() {
        int[] iArr = new int[this.f16051a.length];
        PackageManager packageManager = this.f16052b.getPackageManager();
        String packageName = this.f16052b.getPackageName();
        int length = this.f16051a.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = packageManager.checkPermission(this.f16051a[i], packageName);
        }
        ((C0004p) this.f16052b).mo66a(this.f16053c, this.f16051a, iArr);
    }
}
