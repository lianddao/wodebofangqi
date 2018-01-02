package com.ushareit.listenit;

import android.content.Intent;
import com.ushareit.cmd.CmdMsgBox;

public class exm extends hje {
    final /* synthetic */ CmdMsgBox aj;

    public exm(CmdMsgBox cmdMsgBox) {
        this.aj = cmdMsgBox;
    }

    public void mo2309U() {
        this.aj.f3967n.m1342a();
        Intent b = this.aj.m4907i();
        if (b != null) {
            m18416b(b);
        }
        this.aj.finish();
    }

    public void mo2310V() {
        this.aj.f3967n.m1342a();
        Intent c = this.aj.m4908j();
        if (c != null) {
            m18416b(c);
        }
        if (this.aj.m4914p()) {
            gxt.m23106a(this.aj);
        }
        this.aj.finish();
    }

    private void m18416b(Intent intent) {
        euu com_ushareit_listenit_euu = (euu) euu.f11907a.m18565a("CommandMsgBox.showMsgBox.mDialog.doCommand");
        eva a = com_ushareit_listenit_euu.m18044a(intent.getStringExtra("cmd_id"));
        if (a != null) {
            com_ushareit_listenit_euu.m18050a(a, intent);
        }
    }
}
