package com.ushareit.cmd;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import com.ushareit.listenit.euu;
import com.ushareit.listenit.eva;
import com.ushareit.listenit.evk;
import com.ushareit.listenit.ewt;
import com.ushareit.listenit.exp;
import com.ushareit.listenit.exq;
import com.ushareit.listenit.exr;
import com.ushareit.listenit.exs;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.fad;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fbj;
import com.ushareit.listenit.gyv;
import com.ushareit.listenit.hhx;
import org.json.JSONObject;

public class CmdService extends Service {
    private exp f3969a = new exp();
    private exr f3970b = new exr(this);

    public void onCreate() {
        exw.m18443a("CMD.Service", "onCreate()");
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (!gyv.m23319c(CmdService.class.getName())) {
            m4917a();
        }
        hhx.m23867a(new exq(this, "Service.Command", intent));
        return super.onStartCommand(intent, i, i2);
    }

    public IBinder onBind(Intent intent) {
        exw.m18443a("CMD.Service", "onBind()");
        return this.f3970b;
    }

    private void m4922b(Intent intent) {
        try {
            euu com_ushareit_listenit_euu = (euu) euu.f11907a.m18565a("CommandService.handleWrapperEvent");
            eva a = com_ushareit_listenit_euu.m18044a(intent.getStringExtra("cmd_id"));
            if (a != null) {
                com_ushareit_listenit_euu.m18050a(a, intent);
            }
        } catch (Exception e) {
            exw.m18457e("CMD.Service", "handleWrapperEvent exception: " + e.toString());
        }
    }

    private void m4924c(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("system_uri");
            if (!fbb.m18763c(stringExtra)) {
                Intent parseUri = Intent.parseUri(stringExtra, 0);
                if (parseUri != null) {
                    ((euu) euu.f11907a.m18565a("CommandService.handleSystemEvent")).m18049a(parseUri);
                }
            }
        } catch (Exception e) {
            exw.m18457e("CMD.Service", "handleSystemEvent exception: " + e.toString());
        }
    }

    private void m4926d(Intent intent) {
        try {
            evk com_ushareit_listenit_evk = new evk(new JSONObject(intent.getStringExtra("opt_info")));
            if (fbj.m18784a((Context) this, com_ushareit_listenit_evk.f11967a, com_ushareit_listenit_evk.f11968b) == 1) {
                ewt.m18319a((Context) this, com_ushareit_listenit_evk.f11969c, com_ushareit_listenit_evk.f11970d);
            } else {
                fad.m18688a(this, com_ushareit_listenit_evk.f11967a, "LISTENit", "cmd_install_app", true);
            }
        } catch (Exception e) {
            exw.m18457e("CMD.Service", "handleOperateApp exception: " + e.toString());
        }
    }

    private static exs m4927e(Intent intent) {
        String action = intent.getAction();
        if ("com.ushareit.cmd.action.COMMAND_ALARM".equals(action)) {
            return exs.PRESET_ALARM;
        }
        if ("com.ushareit.cmd.action.COMMAND_WRAPPER_EVENT".equals(action)) {
            return exs.WRAPPER_EVENT;
        }
        if ("com.ushareit.cmd.action.COMMAND_SYSTEM_EVENT".equals(action)) {
            return exs.SYSTEM_EVENT;
        }
        if ("com.ushareit.cmd.action.COMMAND_OPERATE_APP".equals(action)) {
            return exs.OPERATE_APP;
        }
        return null;
    }

    private void m4917a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        getApplicationContext().registerReceiver(this.f3969a, intentFilter);
    }

    private void m4921b() {
        try {
            getApplicationContext().unregisterReceiver(this.f3969a);
        } catch (Exception e) {
        }
    }

    private void m4920a(String str, boolean z) {
        if (z) {
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
            }
        }
        gyv.m23318b(str);
        if (!gyv.m23319c(CmdService.class.getName())) {
            m4921b();
            stopSelf();
        }
    }
}
