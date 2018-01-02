package com.ushareit.listenit;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.ushareit.listenit.invite.InviteActivity;

public class gad implements OnClickListener {
    final /* synthetic */ InviteActivity f13808a;

    public gad(InviteActivity inviteActivity) {
        this.f13808a = inviteActivity;
    }

    public void onClick(View view) {
        StringBuilder stringBuilder;
        hik b;
        switch (view.getId()) {
            case C0349R.id.facebook:
                try {
                    this.f13808a.f15591r.e.onClick(view);
                    fil.m19345a(this.f13808a.getApplicationContext(), "facebook");
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case C0349R.id.qq:
                try {
                    if (this.f13808a.f15590q.f15489b.contains(this.f13808a.f15590q.f15488a)) {
                        stringBuilder = new StringBuilder();
                        b = this.f13808a.f15590q;
                        b.f15489b = stringBuilder.append(b.f15489b).append("?ch=ZQQ").toString();
                    }
                    InviteActivity.m24107b(this.f13808a, "com.tencent.mobileqq", this.f13808a.f15590q.f15489b);
                    fil.m19345a(this.f13808a.getApplicationContext(), "qq");
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case C0349R.id.message:
                if (this.f13808a.f15590q.f15495h != null && this.f13808a.f15590q.f15489b.contains(this.f13808a.f15590q.f15488a)) {
                    stringBuilder = new StringBuilder();
                    b = this.f13808a.f15590q;
                    b.f15489b = stringBuilder.append(b.f15489b).append("?ch=ZDX").toString();
                }
                Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:"));
                intent.putExtra("sms_body", this.f13808a.f15590q.f15489b);
                intent.putExtra("exit_on_sent", true);
                try {
                    this.f13808a.startActivityForResult(intent, 1);
                    fil.m19345a(this.f13808a.getApplicationContext(), "message");
                    return;
                } catch (ActivityNotFoundException e3) {
                    return;
                }
            case C0349R.id.email:
                if (this.f13808a.f15590q.f15489b.contains(this.f13808a.f15590q.f15488a)) {
                    stringBuilder = new StringBuilder();
                    b = this.f13808a.f15590q;
                    b.f15489b = stringBuilder.append(b.f15489b).append("?ch=ZYJ").toString();
                }
                Intent intent2 = new Intent("android.intent.action.SEND");
                intent2.setType("message/rfc822");
                for (ResolveInfo resolveInfo : this.f13808a.getPackageManager().queryIntentActivities(intent2, 0)) {
                    String str = resolveInfo.activityInfo.packageName;
                    if (str.contains("mail")) {
                        intent2.setClassName(str, resolveInfo.activityInfo.name);
                        intent2.putExtra("android.intent.extra.SUBJECT", this.f13808a.getString(C0349R.string.app_name));
                        intent2.putExtra("android.intent.extra.TEXT", this.f13808a.f15590q.f15489b);
                        this.f13808a.startActivity(intent2);
                        fil.m19345a(this.f13808a.getApplicationContext(), "email");
                        return;
                    }
                }
                intent2.putExtra("android.intent.extra.SUBJECT", this.f13808a.getString(C0349R.string.app_name));
                intent2.putExtra("android.intent.extra.TEXT", this.f13808a.f15590q.f15489b);
                try {
                    this.f13808a.startActivity(intent2);
                    fil.m19345a(this.f13808a.getApplicationContext(), "email");
                    return;
                } catch (ActivityNotFoundException e4) {
                    e4.printStackTrace();
                    return;
                }
            default:
                return;
        }
    }
}
