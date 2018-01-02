package com.ushareit.listenit;

import com.ushareit.listenit.service.PlayService;

public class guv implements hgq {
    final /* synthetic */ PlayService f14766a;
    private long f14767b = -1;
    private long f14768c = -1;
    private int f14769d = 0;

    public guv(PlayService playService) {
        this.f14766a = playService;
    }

    public void mo2623a(String str, int i, int i2) {
        try {
            long parseLong = Long.parseLong(str);
            fiz.m19505b();
            m22828a(parseLong);
        } catch (Exception e) {
        }
    }

    private void m22828a(long j) {
        if (this.f14767b != j) {
            this.f14767b = j;
            this.f14769d = 0;
        } else {
            this.f14769d += 500;
            if (this.f14768c != j && this.f14769d > 30000) {
                this.f14768c = j;
                gla a = fqs.m20447a(j);
                if (a != null) {
                    fre.m20625a((glg) a, System.currentTimeMillis());
                    fii.m19293a(this.f14766a.getApplicationContext(), a);
                }
            }
        }
        this.f14766a.f16451e = this.f14766a.f16451e + 500;
        if (this.f14766a.f16448b != null) {
            this.f14766a.f16448b.mo2439c(this.f14766a.f16451e);
        }
    }
}
