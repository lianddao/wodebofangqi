package com.ushareit.listenit;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

class hiu implements OnClickListener {
    final /* synthetic */ hit f15511a;

    hiu(hit com_ushareit_listenit_hit) {
        this.f15511a = com_ushareit_listenit_hit;
    }

    public void onClick(View view) {
        if (this.f15511a.g.f15495h != null) {
            this.f15511a.g.f15495h.mo2787a(this.f15511a.b);
        }
        if (this.f15511a.g.f15489b.contains(this.f15511a.g.f15488a)) {
            StringBuilder stringBuilder = new StringBuilder();
            hik com_ushareit_listenit_hik = this.f15511a.g;
            com_ushareit_listenit_hik.f15489b = stringBuilder.append(com_ushareit_listenit_hik.f15489b).append("?ch=ZDX").toString();
        }
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:"));
        intent.putExtra("sms_body", this.f15511a.g.f15489b);
        intent.putExtra("exit_on_sent", true);
        try {
            ((Activity) this.f15511a.a).startActivityForResult(intent, 1);
        } catch (ActivityNotFoundException e) {
        }
    }
}
