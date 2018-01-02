package com.ushareit.listenit;

import android.content.Intent;
import com.ushareit.cmd.CmdService;
import java.util.Date;

public class exq extends gwv {
    final /* synthetic */ Intent f12132a;
    final /* synthetic */ CmdService f12133b;

    public exq(CmdService cmdService, String str, Intent intent) {
        this.f12133b = cmdService;
        this.f12132a = intent;
        super(str);
    }

    public void execute() {
        boolean z = false;
        String a = gyv.m23317a(CmdService.class.getName());
        try {
            if (this.f12132a == null) {
                exw.m18449b(hhw.TAG, "onStartCommand(): Intent is null!");
            } else {
                exs a2 = CmdService.m4927e(this.f12132a);
                if (a2 == null) {
                    exw.m18449b(hhw.TAG, "onStartCommand(): Intent start type is null!");
                } else if (a2 == exs.PRESET_ALARM) {
                    eve a3 = eve.m18153a();
                    boolean e = a3.m18000e("last_succ_alarm_t");
                    long currentTimeMillis = System.currentTimeMillis();
                    a3.m18159c(currentTimeMillis);
                    a3.m18161d(0);
                    eut.m18032a(this.f12133b);
                    if (!e) {
                        exw.m18449b(hhw.TAG, "The alarm is first startup, do not use it");
                    } else if (eut.m18033a(currentTimeMillis)) {
                        exo.m18425a(this.f12133b, 8, true, true);
                    } else {
                        exw.m18449b(hhw.TAG, "The alarm is not in preset alarm region: " + new Date(currentTimeMillis).toString());
                    }
                } else if (a2 == exs.WRAPPER_EVENT) {
                    if (this.f12132a.getIntExtra("next_event", 0) == 96) {
                        z = true;
                    }
                    this.f12133b.m4922b(this.f12132a);
                } else if (a2 == exs.SYSTEM_EVENT) {
                    this.f12133b.m4924c(this.f12132a);
                } else if (a2 == exs.OPERATE_APP) {
                    this.f12133b.m4926d(this.f12132a);
                }
            }
        } catch (Exception e2) {
        }
        this.f12133b.m4920a(a, z);
    }
}
