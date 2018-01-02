package com.ushareit.listenit;

import com.ushareit.listenit.lockscreen.view.PowerDotLayout;
import java.util.Random;

public class gdi implements Runnable {
    final /* synthetic */ PowerDotLayout f13954a;

    public gdi(PowerDotLayout powerDotLayout) {
        this.f13954a = powerDotLayout;
    }

    public void run() {
        if (new Random(System.currentTimeMillis()).nextInt(200) <= 8 && this.f13954a.f15708b.size() < 7 && this.f13954a.f15707a) {
            this.f13954a.f15708b.add(gdh.m21751a(this.f13954a.getContext(), this.f13954a.getWidth(), this.f13954a.f15709c));
        }
        this.f13954a.postInvalidate();
    }
}
