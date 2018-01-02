package com.ushareit.listenit;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.view.View.OnClickListener;

public class hir extends hip {
    private OnClickListener f15508h = new his(this);

    public hir(Context context) {
        super(context, "email", C0349R.string.common_email, C0349R.drawable.invite_icon_email);
        this.f15501f = m23912b(context);
    }

    private boolean m23912b(Context context) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("message/rfc822");
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
            if (resolveInfo.activityInfo.packageName.contains("mail")) {
                return true;
            }
        }
        return false;
    }
}
