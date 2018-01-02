package com.ushareit.listenit;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.ushareit.listenit.receiver.RemotePlaybackReceiver;
import com.ushareit.listenit.service.PlayService;

public final class grn extends Handler {
    public void handleMessage(Message message) {
        int i = message.what;
        String str = (String) message.obj;
        if (i > 0) {
            Intent intent = new Intent(RemotePlaybackReceiver.f16401d, PlayService.class);
            intent.setAction("com.ushareit.listenit.action.remoteplayback");
            intent.putExtra("extra_action", i);
            intent.putExtra("extra_from", str);
            RemotePlaybackReceiver.f16401d.startService(intent);
        }
    }
}
