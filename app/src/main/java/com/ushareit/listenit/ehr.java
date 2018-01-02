package com.ushareit.listenit;

import android.os.Handler.Callback;
import android.os.Message;
import com.mopub.common.event.BaseEvent;
import com.mopub.common.event.EventDispatcher;
import com.mopub.common.event.EventRecorder;
import com.mopub.common.logging.MoPubLog;

public class ehr implements Callback {
    final /* synthetic */ EventDispatcher f11065a;

    public ehr(EventDispatcher eventDispatcher) {
        this.f11065a = eventDispatcher;
    }

    public boolean handleMessage(Message message) {
        if (message.obj instanceof BaseEvent) {
            for (EventRecorder record : this.f11065a.f2238a) {
                record.record((BaseEvent) message.obj);
            }
        } else {
            MoPubLog.m2753d("EventDispatcher received non-BaseEvent message type.");
        }
        return true;
    }
}
