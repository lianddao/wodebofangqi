package com.ushareit.listenit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.bp;
import com.facebook.internal.cb;
import com.facebook.share.widget.LikeView;

public class bdl extends BroadcastReceiver {
    final /* synthetic */ LikeView f5938a;

    private bdl(LikeView likeView) {
        this.f5938a = likeView;
    }

    public void onReceive(Context context, Intent intent) {
        Object obj = 1;
        String action = intent.getAction();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            Object string = extras.getString("com.facebook.sdk.LikeActionController.OBJECT_ID");
            if (!(cb.m1591a((String) string) || cb.m1590a(this.f5938a.f1397a, string))) {
                obj = null;
            }
        }
        if (obj != null) {
            if ("com.facebook.sdk.LikeActionController.UPDATED".equals(action)) {
                this.f5938a.m1998c();
            } else if ("com.facebook.sdk.LikeActionController.DID_ERROR".equals(action)) {
                if (this.f5938a.f1404h != null) {
                    this.f5938a.f1404h.m7833a(bp.m1506a(extras));
                }
            } else if ("com.facebook.sdk.LikeActionController.DID_RESET".equals(action)) {
                this.f5938a.setObjectIdAndTypeForced(this.f5938a.f1397a, this.f5938a.f1398b);
                this.f5938a.m1998c();
            }
        }
    }
}
