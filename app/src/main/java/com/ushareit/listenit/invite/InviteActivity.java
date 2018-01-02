package com.ushareit.listenit.invite;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.erj;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fjt;
import com.ushareit.listenit.gac;
import com.ushareit.listenit.gad;
import com.ushareit.listenit.gae;
import com.ushareit.listenit.gaf;
import com.ushareit.listenit.gag;
import com.ushareit.listenit.gyn;
import com.ushareit.listenit.gzc;
import com.ushareit.listenit.hik;
import com.ushareit.listenit.him;
import com.ushareit.listenit.hin;
import java.util.HashMap;
import java.util.Map;

public class InviteActivity extends fjt {
    private Button f15587n;
    private Button f15588o;
    private LinearLayout f15589p;
    private hik f15590q = null;
    private hin f15591r;
    private OnClickListener f15592s = new gad(this);
    private OnClickListener f15593t = new gae(this);
    private OnClickListener f15594y = new gaf(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        gzc.m23341a((Activity) this, (int) C0349R.color.common_actionbar_color);
        setContentView(C0349R.layout.activity_invite);
        m24110j();
        m24109h();
    }

    private void m24109h() {
        View findViewById = findViewById(C0349R.id.actionbar_view);
        TextView textView = (TextView) findViewById(C0349R.id.title);
        View findViewById2 = findViewById(C0349R.id.actionbar_bg);
        textView.setText(getString(C0349R.string.invite_frd));
        findViewById(C0349R.id.back).setOnClickListener(new gac(this));
        if (gyn.m23217b()) {
            gyn.m23237e(findViewById, fbb.m18766e(this));
            gyn.m23224c(findViewById2, fbb.m18766e(this) + getResources().getDimensionPixelSize(C0349R.dimen.common_dimens_50dp));
        }
    }

    private static final void m24107b(Context context, String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str2);
        intent.setType("text/plain");
        intent.setClassName(str, (String) m24104a(context).get(str));
        try {
            ((Activity) context).startActivityForResult(intent, 1);
        } catch (ActivityNotFoundException e) {
        }
    }

    private static final Map<String, String> m24104a(Context context) {
        Map<String, String> hashMap = new HashMap();
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 0)) {
            String str = resolveInfo.activityInfo.packageName;
            String str2 = resolveInfo.activityInfo.name;
            if (!(str2 == null || hashMap.containsKey(str))) {
                hashMap.put(str, str2);
            }
        }
        return hashMap;
    }

    public boolean mo540i() {
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        exw.m18456d("InviteActivity", "onActivityResult: resultCode=" + i2 + ", requestCode=" + i);
        switch (i) {
            case 4097:
                if (i2 == -1) {
                    try {
                        gag.m21469a(this);
                        break;
                    } catch (Throwable e) {
                        exw.m18446a("InviteActivity", e);
                        break;
                    }
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    private void m24110j() {
        this.f15589p = (LinearLayout) findViewById(C0349R.id.social_share);
        TextView textView = (TextView) findViewById(C0349R.id.facebook);
        TextView textView2 = (TextView) findViewById(C0349R.id.qq);
        TextView textView3 = (TextView) findViewById(C0349R.id.message);
        TextView textView4 = (TextView) findViewById(C0349R.id.email);
        TextView textView5 = (TextView) findViewById(C0349R.id.blankTextView1);
        TextView textView6 = (TextView) findViewById(C0349R.id.blankTextView2);
        textView.setOnClickListener(this.f15592s);
        textView2.setOnClickListener(this.f15592s);
        textView3.setOnClickListener(this.f15592s);
        textView4.setOnClickListener(this.f15592s);
        this.f15588o = (Button) findViewById(C0349R.id.bluetooth);
        if (gyn.m23199a((Context) this)) {
            this.f15588o.setOnClickListener(this.f15593t);
        } else {
            ((TextView) findViewById(C0349R.id.bluetooth_hint)).setTextColor(getResources().getColor(C0349R.color.common_text_color_gray));
            erj.m17570a(this.f15588o, 0.2f);
            this.f15588o.setOnClickListener(this.f15593t);
        }
        this.f15587n = (Button) findViewById(C0349R.id.invite_by_share_it);
        this.f15587n.setOnClickListener(this.f15594y);
        ((ScrollView) findViewById(C0349R.id.scroll_view)).smoothScrollTo(0, 0);
        if (him.m23904a(this)) {
            this.f15589p.setVisibility(0);
            this.f15591r = new hin(this);
            this.f15590q = new hik(this.f15591r.m23911b());
            if (!m24104a((Context) this).containsKey("com.tencent.mobileqq")) {
                textView2.setVisibility(8);
            }
            if (!(m24104a((Context) this).containsKey("com.facebook.katana") && gyn.m23226c())) {
                textView.setVisibility(8);
            }
            if (!m24108b((Context) this)) {
                textView4.setVisibility(8);
            }
            if (him.m23905b(this)) {
                textView5.setVisibility(0);
                textView6.setVisibility(0);
                return;
            }
            return;
        }
        this.f15589p.setVisibility(8);
    }

    private boolean m24108b(Context context) {
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
