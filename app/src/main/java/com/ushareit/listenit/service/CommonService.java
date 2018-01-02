package com.ushareit.listenit.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Pair;
import com.ushareit.listenit.esr;
import com.ushareit.listenit.ete;
import com.ushareit.listenit.euq;
import com.ushareit.listenit.eut;
import com.ushareit.listenit.exo;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.eys;
import com.ushareit.listenit.eyw;
import com.ushareit.listenit.fjf;
import com.ushareit.listenit.guh;
import com.ushareit.listenit.guj;
import com.ushareit.listenit.guk;
import com.ushareit.listenit.gul;
import com.ushareit.listenit.gyv;
import com.ushareit.listenit.hhx;

public class CommonService extends Service {
    private gul f16441a = gul.ConnChange;
    private guj f16442b = new guj(this);
    private String f16443c = null;
    private boolean f16444d = false;
    private boolean f16445e = false;
    private boolean f16446f = false;

    public void onCreate() {
        exw.m18443a("CommonService", "onCreate()");
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        exw.m18443a("CommonService", "onStartCommand()");
        if (this.f16443c == null) {
            this.f16443c = gyv.m23317a(CommonService.class.getName());
        }
        hhx.m23867a(new guh(this, "UI.CleanService", intent));
        return super.onStartCommand(intent, i, i2);
    }

    public IBinder onBind(Intent intent) {
        exw.m18443a("CommonService", "onBind()");
        return this.f16442b;
    }

    private void m26042a(Intent intent) {
        exw.m18443a("CommonService", "handleIntent()");
        Pair a = eyw.m18568a(this);
        if (a == null || !(((Boolean) a.first).booleanValue() || ((Boolean) a.second).booleanValue())) {
            m26043a(guk.ALL);
        } else if (m26048b()) {
            exw.m18443a("CommonService", "Just return if app is running.");
            m26043a(guk.ALL);
        } else {
            m26041a((Context) this, a);
            m26040a((Context) this);
            m26047b(this);
        }
    }

    private void m26043a(guk com_ushareit_listenit_guk) {
        exw.m18449b("CommonService", "quit() is called: " + com_ushareit_listenit_guk);
        switch (com_ushareit_listenit_guk) {
            case ANALYTICS:
                this.f16444d = true;
                break;
            case COLLECTEVN:
                this.f16445e = true;
                break;
            case CLOUD:
                this.f16446f = true;
                break;
            case ALL:
                this.f16444d = true;
                this.f16445e = true;
                this.f16446f = true;
                break;
        }
        if (m26046a()) {
            stopSelf();
            gyv.m23318b(this.f16443c);
        }
    }

    private boolean m26046a() {
        return this.f16444d && this.f16445e && this.f16446f;
    }

    private boolean m26048b() {
        return fjf.f3909u != 0;
    }

    private void m26041a(Context context, Pair<Boolean, Boolean> pair) {
        if (this.f16441a != gul.ConnChange) {
            m26043a(guk.CLOUD);
            return;
        }
        euq.m18024a(eys.m18562a(), ((Boolean) pair.first).booleanValue(), ((Boolean) pair.second).booleanValue());
        int i = ((Boolean) pair.second).booleanValue() ? 2 : 4;
        eut.m18032a(context);
        exo.m18425a(context, i, false, false);
        m26043a(guk.CLOUD);
    }

    private void m26040a(Context context) {
        if (esr.m17816a(context, ete.class)) {
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
            }
            m26043a(guk.ANALYTICS);
            return;
        }
        exw.m18449b("CommonService", "do not need dispatch!");
        m26043a(guk.ANALYTICS);
    }

    private void m26047b(Context context) {
        if (this.f16441a != gul.ConnChange) {
            m26043a(guk.COLLECTEVN);
        } else {
            m26043a(guk.COLLECTEVN);
        }
    }
}
