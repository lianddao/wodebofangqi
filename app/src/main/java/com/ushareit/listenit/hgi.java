package com.ushareit.listenit;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;

public class hgi extends hgs {
    private hgs f15408a;
    private Context f15409b;
    private OnAudioFocusChangeListener f15410c;
    private AudioManager f15411d;
    private OnAudioFocusChangeListener f15412e = new hgj(this);

    public hgi(Context context, hgs com_ushareit_listenit_hgs) {
        this.f15409b = context;
        this.f15408a = com_ushareit_listenit_hgs;
        this.f15411d = (AudioManager) context.getSystemService("audio");
    }

    public void m23743a(boolean z, OnAudioFocusChangeListener onAudioFocusChangeListener) {
        if (!z) {
            onAudioFocusChangeListener = null;
        }
        this.f15410c = onAudioFocusChangeListener;
    }

    public boolean mo2770a() {
        return this.f15408a.mo2770a();
    }

    public boolean mo2771b() {
        return this.f15408a.mo2771b();
    }

    public boolean mo2772c() {
        return this.f15408a.mo2772c();
    }

    public void mo2768a(String str) {
        this.f15408a.mo2768a(str);
    }

    public int mo2773d() {
        return this.f15408a.mo2773d();
    }

    public synchronized void mo2774e() {
        this.f15411d.requestAudioFocus(this.f15412e, 3, 1);
        this.f15408a.mo2774e();
    }

    public void mo2775f() {
        this.f15408a.mo2775f();
    }

    public void mo2776g() {
        this.f15411d.abandonAudioFocus(this.f15412e);
        this.f15408a.mo2776g();
    }

    public void mo2763a(float f) {
        this.f15408a.mo2763a(f);
    }

    public float mo2777h() {
        return this.f15408a.mo2777h();
    }

    public void mo2764a(int i) {
        this.f15408a.mo2764a(i);
    }

    public int mo2778i() {
        return this.f15408a.mo2778i();
    }

    public int mo2779j() {
        return this.f15408a.mo2779j();
    }

    public String mo2780k() {
        return this.f15408a.mo2780k();
    }

    public boolean mo2781l() {
        return this.f15408a.mo2781l();
    }

    public void mo2767a(hgv com_ushareit_listenit_hgv) {
        this.f15408a.mo2767a(com_ushareit_listenit_hgv);
    }

    public void mo2766a(hgu com_ushareit_listenit_hgu) {
        this.f15408a.mo2766a(com_ushareit_listenit_hgu);
    }

    public void mo2765a(hgt com_ushareit_listenit_hgt) {
        this.f15408a.mo2765a(com_ushareit_listenit_hgt);
    }

    public void mo2769a(boolean z) {
        this.f15408a.mo2769a(z);
    }

    public boolean mo2782m() {
        return this.f15408a.mo2782m();
    }
}
