package com.ushareit.listenit;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;

public class ffh extends Handler {
    protected Context f12591a;
    public FrameLayout f12592b;
    public FrameLayout f12593c;
    public FrameLayout f12594d;
    public FrameLayout f12595e;
    protected int f12596f = 5000;
    protected int f12597g = 5000;
    public boolean f12598h = false;
    protected boolean f12599i = true;
    protected boolean f12600j = false;
    protected boolean f12601k = false;

    public ffh(Context context, View view) {
        this.f12591a = context;
        this.f12592b = (FrameLayout) view.findViewById(C0349R.id.current_center_card);
        this.f12593c = (FrameLayout) view.findViewById(C0349R.id.curr_ad_container);
        this.f12594d = (FrameLayout) view.findViewById(C0349R.id.next_center_card);
        this.f12595e = (FrameLayout) view.findViewById(C0349R.id.next_ad_container);
        this.f12596f = fqo.m20436r() * 1000;
        this.f12597g = fqo.m20437s() * 1000;
    }

    public void m19096a(boolean z) {
        if (fem.m18972c()) {
            fem.f12544b++;
            if (fem.m18979j()) {
                this.f12599i = !z;
                if (this.f12599i) {
                    exw.m18454c("1020", "show ad on current view after 5 second");
                    sendEmptyMessageDelayed(2, (long) this.f12596f);
                    return;
                }
                exw.m18454c("1020", "show ad on next view after 5 second");
                sendEmptyMessageDelayed(3, (long) this.f12596f);
                return;
            }
            fet.m19024b(this.f12591a);
        }
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 2:
            case 3:
                m19095a();
                return;
            case 4:
            case 5:
                m19094b();
                return;
            default:
                return;
        }
    }

    protected void m19095a() {
        exw.m18454c("1020", "start load ad");
        fet.m19028c(this.f12591a, new ffi(this, 30000));
    }

    private void m19094b() {
        if (this.f12599i && this.f12593c.getChildCount() > 0) {
            gzi.m23383b(this.f12593c, this.f12592b);
        }
        if (!this.f12599i && this.f12595e.getChildCount() > 0) {
            gzi.m23383b(this.f12595e, this.f12594d);
        }
    }

    public void m19097b(boolean z) {
        if (z) {
            exw.m18454c("1020", "clear all ad on next View");
            removeMessages(3);
            removeMessages(5);
            this.f12601k = true;
            this.f12600j = false;
            this.f12595e.setVisibility(4);
            return;
        }
        exw.m18454c("1020", "clear all ad on current View");
        removeMessages(2);
        removeMessages(4);
        this.f12600j = true;
        this.f12601k = false;
        this.f12593c.setVisibility(4);
    }
}
