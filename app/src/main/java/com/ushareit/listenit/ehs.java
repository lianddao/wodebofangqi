package com.ushareit.listenit;

import com.mopub.common.event.EventSampler;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class ehs extends LinkedHashMap<String, Boolean> {
    final /* synthetic */ EventSampler f11066a;

    public ehs(EventSampler eventSampler, int i, float f, boolean z) {
        this.f11066a = eventSampler;
        super(i, f, z);
    }

    protected boolean removeEldestEntry(Entry<String, Boolean> entry) {
        return size() > 100;
    }
}
