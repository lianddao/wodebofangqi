package com.ushareit.listenit;

import android.util.Log;
import java.util.Random;

public class czq {
    static czs f9434a = new czt();
    static cio f9435b = new ciq();
    private static Random f9436c = new Random();
    private eah f9437d;
    private long f9438e;
    private volatile boolean f9439f;

    public czq(eah com_ushareit_listenit_eah, long j) {
        this.f9437d = com_ushareit_listenit_eah;
        this.f9438e = j;
    }

    public void m13533a() {
        this.f9439f = true;
    }

    public void m13534a(dad com_ushareit_listenit_dad) {
        m13535a(com_ushareit_listenit_dad, true);
    }

    public void m13535a(dad com_ushareit_listenit_dad, boolean z) {
        cfi.m11080a((Object) com_ushareit_listenit_dad);
        long b = f9435b.mo1371b() + this.f9438e;
        if (z) {
            com_ushareit_listenit_dad.m13615a(czv.m13545a(this.f9437d), this.f9437d.m16618a());
        } else {
            com_ushareit_listenit_dad.m13617b(czv.m13545a(this.f9437d));
        }
        int i = 1000;
        while (f9435b.mo1371b() + ((long) i) <= b && !com_ushareit_listenit_dad.m13623h() && m13536a(com_ushareit_listenit_dad.m13622g())) {
            try {
                f9434a.mo1672a(f9436c.nextInt(250) + i);
                if (i < 30000) {
                    if (com_ushareit_listenit_dad.m13622g() != -2) {
                        i *= 2;
                        Log.w("ExponenentialBackoff", "network error occurred, backing off/sleeping.");
                    } else {
                        Log.w("ExponenentialBackoff", "network unavailable, sleeping.");
                        i = 1000;
                    }
                }
                if (!this.f9439f) {
                    com_ushareit_listenit_dad.m13614a();
                    if (z) {
                        com_ushareit_listenit_dad.m13615a(czv.m13545a(this.f9437d), this.f9437d.m16618a());
                    } else {
                        com_ushareit_listenit_dad.m13617b(czv.m13545a(this.f9437d));
                    }
                } else {
                    return;
                }
            } catch (InterruptedException e) {
                Log.w("ExponenentialBackoff", "thread interrupted during exponential backoff.");
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public boolean m13536a(int i) {
        return (i >= 500 && i < 600) || i == -2 || i == 429;
    }

    public void m13537b() {
        this.f9439f = false;
    }
}
