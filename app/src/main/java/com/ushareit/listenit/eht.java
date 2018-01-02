package com.ushareit.listenit;

import com.mopub.common.event.ScribeEventRecorder;
import com.mopub.network.ScribeRequest;
import com.mopub.network.ScribeRequest.Listener;
import com.mopub.network.ScribeRequest.ScribeRequestFactory;
import java.util.List;

public class eht implements ScribeRequestFactory {
    final /* synthetic */ List f11067a;
    final /* synthetic */ ScribeEventRecorder f11068b;

    public eht(ScribeEventRecorder scribeEventRecorder, List list) {
        this.f11068b = scribeEventRecorder;
        this.f11067a = list;
    }

    public ScribeRequest createRequest(Listener listener) {
        return new ScribeRequest("https://analytics.mopub.com/i/jot/exchange_client_event", this.f11067a, this.f11068b.f2247c, listener);
    }
}
