package com.ushareit.listenit;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.mopub.volley.DefaultRetryPolicy;

class foa extends Handler {
    final /* synthetic */ fnr f13078a;

    foa(fnr com_ushareit_listenit_fnr, Looper looper) {
        this.f13078a = com_ushareit_listenit_fnr;
        super(looper);
    }

    public void handleMessage(Message message) {
        float k;
        switch (message.what) {
            case 1:
                k = this.f13078a.f13051j.m23806k() + 0.1f;
                if (k < DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
                    sendMessageDelayed(obtainMessage(1), 100);
                    this.f13078a.f13051j.m23782a(k);
                    return;
                }
                this.f13078a.f13051j.m23782a((float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                return;
            case 2:
                k = this.f13078a.f13051j.m23806k() - 0.1f;
                if (k > 0.0f) {
                    sendMessageDelayed(obtainMessage(2), 100);
                    this.f13078a.f13051j.m23782a(k);
                    return;
                }
                this.f13078a.f13051j.m23782a(0.0f);
                this.f13078a.f13051j.m23801f();
                return;
            case 3:
                k = this.f13078a.f13051j.m23806k() - 0.1f;
                if (k > 0.1f) {
                    sendMessageDelayed(obtainMessage(3), 50);
                    this.f13078a.f13051j.m23782a(k);
                    return;
                }
                this.f13078a.f13051j.m23782a(0.1f);
                return;
            default:
                return;
        }
    }
}
