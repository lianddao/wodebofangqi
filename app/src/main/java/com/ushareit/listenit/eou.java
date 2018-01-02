package com.ushareit.listenit;

import com.mopub.volley.ExecutorDelivery;
import com.mopub.volley.Request;
import com.mopub.volley.Response;

public class eou implements Runnable {
    final /* synthetic */ ExecutorDelivery f11405a;
    private final Request f11406b;
    private final Response f11407c;
    private final Runnable f11408d;

    public eou(ExecutorDelivery executorDelivery, Request request, Response response, Runnable runnable) {
        this.f11405a = executorDelivery;
        this.f11406b = request;
        this.f11407c = response;
        this.f11408d = runnable;
    }

    public void run() {
        if (this.f11406b.isCanceled()) {
            this.f11406b.m3271b("canceled-at-delivery");
            return;
        }
        if (this.f11407c.isSuccess()) {
            this.f11406b.deliverResponse(this.f11407c.result);
        } else {
            this.f11406b.deliverError(this.f11407c.error);
        }
        if (this.f11407c.intermediate) {
            this.f11406b.addMarker("intermediate-response");
        } else {
            this.f11406b.m3271b("done");
        }
        if (this.f11408d != null) {
            this.f11408d.run();
        }
    }
}
