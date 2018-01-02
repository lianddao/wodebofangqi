package com.ushareit.listenit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class am extends aq<ak> {
    final /* synthetic */ ak f4762a;

    public am(ak akVar) {
        this.f4762a = akVar;
        super(akVar);
    }

    public void mo720a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f4762a.dump(str, fileDescriptor, printWriter, strArr);
    }

    public boolean mo721a(ah ahVar) {
        return !this.f4762a.isFinishing();
    }

    public LayoutInflater mo723b() {
        return this.f4762a.getLayoutInflater().cloneInContext(this.f4762a);
    }

    public void mo725c() {
        this.f4762a.m707d();
    }

    public void mo718a(ah ahVar, Intent intent, int i, Bundle bundle) {
        this.f4762a.m702a(ahVar, intent, i, bundle);
    }

    public void mo719a(ah ahVar, String[] strArr, int i) {
        this.f4762a.m694a(ahVar, strArr, i);
    }

    public boolean mo722a(String str) {
        return C0364n.m25144a(this.f4762a, str);
    }

    public boolean mo726d() {
        return this.f4762a.getWindow() != null;
    }

    public int mo727e() {
        Window window = this.f4762a.getWindow();
        return window == null ? 0 : window.getAttributes().windowAnimations;
    }

    public void mo724b(ah ahVar) {
        this.f4762a.m701a(ahVar);
    }

    public View mo635a(int i) {
        return this.f4762a.findViewById(i);
    }

    public boolean mo636a() {
        Window window = this.f4762a.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }
}
