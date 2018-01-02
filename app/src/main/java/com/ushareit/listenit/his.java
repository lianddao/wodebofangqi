package com.ushareit.listenit;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.view.View;
import android.view.View.OnClickListener;

class his implements OnClickListener {
    final /* synthetic */ hir f15509a;

    his(hir com_ushareit_listenit_hir) {
        this.f15509a = com_ushareit_listenit_hir;
    }

    public void onClick(View view) {
        if (this.f15509a.g.f15495h != null) {
            this.f15509a.g.f15495h.mo2787a(this.f15509a.b);
        }
        if (this.f15509a.g.f15489b.contains(this.f15509a.g.f15488a)) {
            StringBuilder stringBuilder = new StringBuilder();
            hik com_ushareit_listenit_hik = this.f15509a.g;
            com_ushareit_listenit_hik.f15489b = stringBuilder.append(com_ushareit_listenit_hik.f15489b).append("?ch=ZYJ").toString();
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("message/rfc822");
        for (ResolveInfo resolveInfo : this.f15509a.a.getPackageManager().queryIntentActivities(intent, 0)) {
            String str = resolveInfo.activityInfo.packageName;
            if (str.contains("mail")) {
                intent.setClassName(str, resolveInfo.activityInfo.name);
                break;
            }
        }
        intent.putExtra("android.intent.extra.SUBJECT", this.f15509a.a.getString(C0349R.string.app_name));
        intent.putExtra("android.intent.extra.TEXT", this.f15509a.g.f15489b);
        try {
            this.f15509a.a.startActivity(intent);
        } catch (ActivityNotFoundException e) {
        }
    }
}
