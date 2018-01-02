package com.ushareit.listenit.cloudsync;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Pair;
import com.umeng.analytics.C0154a;
import com.ushareit.listenit.exw;
import com.ushareit.listenit.eys;
import com.ushareit.listenit.eyw;
import com.ushareit.listenit.fbb;
import com.ushareit.listenit.fjf;
import com.ushareit.listenit.fkb;
import com.ushareit.listenit.fko;
import com.ushareit.listenit.fkr;
import com.ushareit.listenit.fks;
import com.ushareit.listenit.fkt;
import com.ushareit.listenit.fku;
import com.ushareit.listenit.fle;
import com.ushareit.listenit.fqk;
import com.ushareit.listenit.frf;
import com.ushareit.listenit.gef;
import com.ushareit.listenit.gvj;
import com.ushareit.listenit.gyv;

public class CloudSyncService extends Service {
    private fkt f8431a = new fkt(this);
    private String f8432b = null;
    private fko f8433c = new fkr(this);

    public void onCreate() {
        super.onCreate();
        fkb.m19610a().m19639a(this.f8433c);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null || fbb.m18763c(intent.getAction())) {
            return super.onStartCommand(intent, i, i2);
        }
        exw.m18443a("CloudSyncService", "onStartCommand(): action=" + intent.getAction());
        String action = intent.getAction();
        if (this.f8432b == null) {
            this.f8432b = gyv.m23317a(CloudSyncService.class.getName());
        }
        if (action.equals("com.ushareit.listenit.action.startsync")) {
            int intExtra = intent.getIntExtra("extra_sync_mode", 1);
            switch (fks.f12862a[fku.m19673a(intent.getIntExtra("extra_start_from", fku.AUTO.m19674a())).ordinal()]) {
                case 1:
                    fkb.m19610a().m19638a(intExtra, false, "auto");
                    break;
                case 2:
                    fkb.m19610a().m19638a(intExtra, true, "manual");
                    break;
                case 3:
                    fkb.m19610a().m19638a(intExtra, true, "login");
                    break;
                case 4:
                    if (fkb.m19610a().m19649g()) {
                        m11599e();
                        break;
                    }
                    break;
                case 5:
                    m11597c(intent.getIntExtra("extra_network_state", 0));
                    break;
            }
        } else if (action.equals("com.ushareit.listenit.action.stopsync")) {
            fkb.m19610a().m19642b();
            if (!gef.m21805a().m21835e()) {
                m11599e();
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    public IBinder onBind(Intent intent) {
        return this.f8431a;
    }

    public void onDestroy() {
        fkb.m19610a().m19643b(this.f8433c);
        super.onDestroy();
    }

    private void m11597c(int i) {
        switch (i) {
            case 1:
            case 3:
            case 5:
            case 6:
                if (!fkb.m19610a().m19649g()) {
                    fkb.m19610a().m19642b();
                    return;
                }
                return;
            case 2:
            case 4:
                long currentTimeMillis = (System.currentTimeMillis() - gvj.m22885X(eys.m18562a())) / C0154a.f2954j;
                int d = fqk.m20378d();
                if (gvj.m22879R(eys.m18562a()) && currentTimeMillis >= ((long) d) && fkb.m19610a().m19649g()) {
                    fkb.m19610a().m19641a("network");
                    gvj.m22981j(eys.m18562a(), System.currentTimeMillis());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void m11599e() {
        exw.m18443a("CloudSyncService", "stopService");
        stopSelf();
        if (this.f8432b != null) {
            gyv.m23318b(this.f8432b);
        }
    }

    public static void m11589a() {
        exw.m18443a("CloudSyncService", "loginStartCloudSyncService");
        m11591a(eys.m18562a(), fku.LOGIN, 1, true, 0);
    }

    public static void m11593b() {
        boolean a = fle.m19717b().m19727a();
        int k = frf.m20685k() + frf.m20684j();
        boolean R = gvj.m22879R(eys.m18562a());
        exw.m18443a("CloudSyncService", "autoStartCloudSyncService: isLocalModified=" + a + ", syncSongCount=" + k);
        Pair a2 = eyw.m18568a(eys.m18562a());
        boolean booleanValue = ((Boolean) a2.first).booleanValue();
        boolean booleanValue2 = ((Boolean) a2.second).booleanValue();
        if ((booleanValue2 && R && (a || k > 0)) || (!booleanValue2 && booleanValue && a)) {
            m11591a(eys.m18562a(), fku.AUTO, 1, false, 0);
        }
    }

    public static void m11590a(int i) {
        exw.m18443a("CloudSyncService", "manualStartCloudSyncService");
        m11591a(eys.m18562a(), fku.MANUAL, i, true, 0);
    }

    public static void m11596c() {
        exw.m18443a("CloudSyncService", "startCloudSyncServiceFromDestory");
        m11591a(eys.m18562a(), fku.DESTORY, 1, false, 0);
    }

    public static void m11594b(int i) {
        exw.m18443a("CloudSyncService", "startCloudSyncServiceFromNetworkChanged: networkstate=" + i);
        m11591a(eys.m18562a(), fku.NETWORK_CHANGED, 1, false, i);
    }

    private static void m11591a(Context context, fku com_ushareit_listenit_fku, int i, boolean z, int i2) {
        Intent intent = new Intent(context, CloudSyncService.class);
        intent.setAction("com.ushareit.listenit.action.startsync");
        intent.putExtra("extra_start_from", com_ushareit_listenit_fku.m19674a());
        intent.putExtra("extra_sync_mode", i);
        intent.putExtra("extra_network_state", i2);
        context.startService(intent);
    }

    public static void m11598d() {
        Intent intent = new Intent(eys.m18562a(), CloudSyncService.class);
        intent.setAction("com.ushareit.listenit.action.stopsync");
        eys.m18562a().startService(intent);
    }

    private boolean m11600f() {
        return fjf.f3909u != 0;
    }
}
