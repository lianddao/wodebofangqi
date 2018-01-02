package com.ushareit.listenit;

import android.content.Context;
import android.util.Log;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class czc implements Runnable {
    public final Context f9391a;
    public final czd f9392b;
    public final czd f9393c;
    public final czd f9394d;
    public final czf f9395e;

    public czc(Context context, czd com_ushareit_listenit_czd, czd com_ushareit_listenit_czd2, czd com_ushareit_listenit_czd3, czf com_ushareit_listenit_czf) {
        this.f9391a = context;
        this.f9392b = com_ushareit_listenit_czd;
        this.f9393c = com_ushareit_listenit_czd2;
        this.f9394d = com_ushareit_listenit_czd3;
        this.f9395e = com_ushareit_listenit_czf;
    }

    private czh m13449a(czd com_ushareit_listenit_czd) {
        czh com_ushareit_listenit_czh = new czh();
        if (com_ushareit_listenit_czd.m13450a() != null) {
            Map a = com_ushareit_listenit_czd.m13450a();
            List arrayList = new ArrayList();
            for (String str : a.keySet()) {
                List arrayList2 = new ArrayList();
                Map map = (Map) a.get(str);
                for (String str2 : map.keySet()) {
                    czi com_ushareit_listenit_czi = new czi();
                    com_ushareit_listenit_czi.f9410a = str2;
                    com_ushareit_listenit_czi.f9411b = (byte[]) map.get(str2);
                    arrayList2.add(com_ushareit_listenit_czi);
                }
                czk com_ushareit_listenit_czk = new czk();
                com_ushareit_listenit_czk.f9415a = str;
                com_ushareit_listenit_czk.f9416b = (czi[]) arrayList2.toArray(new czi[arrayList2.size()]);
                arrayList.add(com_ushareit_listenit_czk);
            }
            com_ushareit_listenit_czh.f9407a = (czk[]) arrayList.toArray(new czk[arrayList.size()]);
        }
        com_ushareit_listenit_czh.f9408b = com_ushareit_listenit_czd.m13457c();
        return com_ushareit_listenit_czh;
    }

    public void run() {
        dgi com_ushareit_listenit_czl = new czl();
        if (this.f9392b != null) {
            com_ushareit_listenit_czl.f9417a = m13449a(this.f9392b);
        }
        if (this.f9393c != null) {
            com_ushareit_listenit_czl.f9418b = m13449a(this.f9393c);
        }
        if (this.f9394d != null) {
            com_ushareit_listenit_czl.f9419c = m13449a(this.f9394d);
        }
        if (this.f9395e != null) {
            czj com_ushareit_listenit_czj = new czj();
            com_ushareit_listenit_czj.f9412a = this.f9395e.m13458a();
            com_ushareit_listenit_czj.f9413b = this.f9395e.m13465b();
            com_ushareit_listenit_czl.f9420d = com_ushareit_listenit_czj;
        }
        if (!(this.f9395e == null || this.f9395e.m13466c() == null)) {
            List arrayList = new ArrayList();
            Map c = this.f9395e.m13466c();
            for (String str : c.keySet()) {
                if (c.get(str) != null) {
                    czm com_ushareit_listenit_czm = new czm();
                    com_ushareit_listenit_czm.f9425c = str;
                    com_ushareit_listenit_czm.f9424b = ((czb) c.get(str)).m13448b();
                    com_ushareit_listenit_czm.f9423a = ((czb) c.get(str)).m13447a();
                    arrayList.add(com_ushareit_listenit_czm);
                }
            }
            com_ushareit_listenit_czl.f9421e = (czm[]) arrayList.toArray(new czm[arrayList.size()]);
        }
        byte[] a = dgi.m13469a(com_ushareit_listenit_czl);
        try {
            FileOutputStream openFileOutput = this.f9391a.openFileOutput("persisted_config", 0);
            openFileOutput.write(a);
            openFileOutput.close();
        } catch (Throwable e) {
            Log.e("AsyncPersisterTask", "Could not persist config.", e);
        }
    }
}
