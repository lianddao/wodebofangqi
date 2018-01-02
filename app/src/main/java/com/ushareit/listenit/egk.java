package com.ushareit.listenit;

import com.mopub.common.DiskLruCache;
import java.util.concurrent.Callable;

public class egk implements Callable<Void> {
    final /* synthetic */ DiskLruCache f11036a;

    public egk(DiskLruCache diskLruCache) {
        this.f11036a = diskLruCache;
    }

    public Void call() {
        synchronized (this.f11036a) {
            if (this.f11036a.f2106k == null) {
            } else {
                this.f11036a.m2666g();
                if (this.f11036a.m2663e()) {
                    this.f11036a.m2660d();
                    this.f11036a.f2108m = 0;
                }
            }
        }
        return null;
    }
}
