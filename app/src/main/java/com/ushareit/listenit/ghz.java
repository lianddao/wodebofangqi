package com.ushareit.listenit;

import android.os.Handler;
import android.os.Message;
import com.ushareit.listenit.lyrics.LyricView;

public class ghz extends Handler {
    final /* synthetic */ LyricView f14147a;

    public ghz(LyricView lyricView) {
        this.f14147a = lyricView;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (gyp.m23302p()) {
            this.f14147a.m24779a(gyp.m23299m(), true);
        } else {
            this.f14147a.m24762b(true);
        }
    }
}
