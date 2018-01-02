package com.ushareit.listenit;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.share.model.ShareLinkContent;

class hio implements OnClickListener {
    final /* synthetic */ hin f15507a;

    hio(hin com_ushareit_listenit_hin) {
        this.f15507a = com_ushareit_listenit_hin;
    }

    public void onClick(View view) {
        if (this.f15507a.g.f15495h != null) {
            this.f15507a.g.f15495h.mo2787a(this.f15507a.b);
        }
        bdv com_ushareit_listenit_bdv = new bdv((Activity) this.f15507a.a);
        if (bdv.m7853a(ShareLinkContent.class)) {
            bct com_ushareit_listenit_bct = new bct();
            if (!TextUtils.isEmpty(this.f15507a.g.f15490c)) {
                com_ushareit_listenit_bct.m7773b(this.f15507a.g.f15490c);
            }
            if (!TextUtils.isEmpty(this.f15507a.g.f15491d) && TextUtils.isEmpty(this.f15507a.g.f15489b)) {
                com_ushareit_listenit_bct.m7771a(this.f15507a.g.f15491d);
            } else if (TextUtils.isEmpty(this.f15507a.g.f15491d) && !TextUtils.isEmpty(this.f15507a.g.f15489b)) {
                com_ushareit_listenit_bct.m7771a(this.f15507a.g.f15489b);
            } else if (!TextUtils.isEmpty(this.f15507a.g.f15491d) && !TextUtils.isEmpty(this.f15507a.g.f15489b)) {
                com_ushareit_listenit_bct.m7771a(this.f15507a.g.f15489b);
            } else {
                return;
            }
            if (TextUtils.isEmpty(this.f15507a.g.f15492e)) {
                com_ushareit_listenit_bct.m7764a(Uri.parse(hin.f15503h));
            } else {
                com_ushareit_listenit_bct.m7764a(Uri.parse(this.f15507a.g.f15492e));
            }
            if (TextUtils.isEmpty(this.f15507a.g.f15493f)) {
                com_ushareit_listenit_bct.m7772b(Uri.parse("https://lh3.googleusercontent.com/N8kXaixBF8X2zPvXkuhE0VM_ewtphxl_yKQunGYQj9Czb0SoFZ_8dUYzCPV9vDnxPw=w100-rw"));
            } else {
                com_ushareit_listenit_bct.m7772b(Uri.parse(this.f15507a.g.f15493f));
                if ("http://cdn.ushareit.com/img/listenit/facebook.jpg".equals(this.f15507a.g.f15493f)) {
                    com_ushareit_listenit_bct.m7764a(Uri.parse("https://play.google.com/store/apps/details?id=" + this.f15507a.a.getPackageName()));
                }
            }
            try {
                com_ushareit_listenit_bdv.m1738a(com_ushareit_listenit_bct.m7770a());
            } catch (Exception e) {
                heb.m23597a(this.f15507a.a.getResources().getString(C0349R.string.socialshare_openurl_failure), 1).show();
                exw.m18457e("FacebookEntry", "call facebook share exception:" + e.toString());
            }
        }
    }
}
