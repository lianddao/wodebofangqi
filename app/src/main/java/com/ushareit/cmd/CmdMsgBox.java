package com.ushareit.cmd;

import android.content.Intent;
import android.os.Bundle;
import com.ushareit.listenit.C0349R;
import com.ushareit.listenit.ak;
import com.ushareit.listenit.esr;
import com.ushareit.listenit.evh;
import com.ushareit.listenit.exm;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.hje;
import com.ushareit.listenit.hjk;

public class CmdMsgBox extends ak {
    private hje f3967n = null;
    private evh f3968o = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.f3968o = new evh(getIntent().getStringExtra("msgbox"));
            m4906h();
        } catch (Exception e) {
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
    }

    protected void mo544b() {
        super.mo544b();
    }

    protected void onResume() {
        super.onResume();
        exw.m18443a("UI.CommandMsgBox", getClass().getSimpleName() + ".onResume()");
        esr.m17823c(this);
    }

    protected void onPause() {
        super.onPause();
        exw.m18443a("UI.CommandMsgBox", getClass().getSimpleName() + ".onPause()");
        esr.m17825d(this);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void onBackPressed() {
    }

    private void m4906h() {
        if (this.f3967n == null || !this.f3967n.m1335t()) {
            Bundle bundle = new Bundle();
            if (fbb.m18765d(m4909k())) {
                bundle.putString("title", m4909k());
            }
            bundle.putString("msg", m4910l());
            bundle.putString("btn1", m4911m());
            if (m4912n()) {
                bundle.putString("btn2", m4913o());
            }
            this.f3967n = new exm(this);
            if (m4912n()) {
                this.f3967n.m18411a(hjk.TWOBUTTON);
            } else {
                this.f3967n.m18411a(hjk.ONEBUTTON);
            }
            this.f3967n.m1317g(bundle);
            this.f3967n.mo1295a(m709f(), "confirm");
        }
    }

    private Intent m4907i() {
        Intent intent = null;
        if (!(this.f3968o == null || fbb.m18763c(this.f3968o.f11949h))) {
            try {
                intent = Intent.parseUri(this.f3968o.f11949h, 0);
            } catch (Exception e) {
            }
        }
        return intent;
    }

    private Intent m4908j() {
        Intent intent = null;
        if (!(this.f3968o == null || fbb.m18763c(this.f3968o.f11951j))) {
            try {
                intent = Intent.parseUri(this.f3968o.f11951j, 0);
            } catch (Exception e) {
            }
        }
        return intent;
    }

    private String m4909k() {
        if (this.f3968o == null) {
            return "";
        }
        return this.f3968o.f11942a;
    }

    private String m4910l() {
        if (this.f3968o == null) {
            return "";
        }
        return this.f3968o.f11943b.replace("\\n", "\n");
    }

    private String m4911m() {
        if (this.f3968o == null || !fbb.m18765d(this.f3968o.f11945d)) {
            return getString(C0349R.string.common_operate_ok);
        }
        return this.f3968o.f11945d;
    }

    private boolean m4912n() {
        if (this.f3968o == null || this.f3968o.f11944c == 0 || this.f3968o.f11944c == 2) {
            return true;
        }
        return false;
    }

    private String m4913o() {
        if (this.f3968o == null || !fbb.m18765d(this.f3968o.f11946e)) {
            return getString(C0349R.string.common_operate_cancel);
        }
        return this.f3968o.f11946e;
    }

    private boolean m4914p() {
        if (this.f3968o == null) {
            return false;
        }
        if (this.f3968o.f11944c == 3 || this.f3968o.f11944c == 2) {
            return true;
        }
        return false;
    }
}
