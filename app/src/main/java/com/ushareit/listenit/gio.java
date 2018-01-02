package com.ushareit.listenit;

import com.ushareit.listenit.main.MainActivity;
import java.util.ArrayList;
import java.util.List;

public class gio extends hhw {
    final /* synthetic */ String f14169a;
    final /* synthetic */ MainActivity f14170b;
    private List<glg> f14171c = new ArrayList();

    public gio(MainActivity mainActivity, String str) {
        this.f14170b = mainActivity;
        this.f14169a = str;
    }

    public void execute() {
        glg a = grr.m22621a().m22641a(this.f14169a);
        if (a != null) {
            this.f14171c.add(a);
        }
        int i = 0;
        while (true) {
            if (this.f14170b.m4860n() != null && this.f14170b.f15907n.m1338w() != null) {
                return;
            }
            if (i >= 50) {
                this.f14171c.clear();
                return;
            } else {
                Thread.sleep(100);
                i++;
            }
        }
    }

    public void callback() {
        if (this.f14171c.size() != 0 && this.f14170b.m4860n() != null && this.f14170b.f15907n.m1338w() != null) {
            this.f14170b.m4860n().mo2422a(this.f14171c, (glg) this.f14171c.get(0));
            this.f14170b.f15907n.m20550U();
        }
    }
}
