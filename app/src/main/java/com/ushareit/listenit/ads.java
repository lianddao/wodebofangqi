package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public class ads implements Callback {
    private static final ads f4170c = new ads();
    final Map<FragmentManager, adp> f4171a = new HashMap();
    final Map<ar, adv> f4172b = new HashMap();
    private volatile tw f4173d;
    private final Handler f4174e = new Handler(Looper.getMainLooper(), this);

    public static ads m5294a() {
        return f4170c;
    }

    ads() {
    }

    private tw m5295b(Context context) {
        if (this.f4173d == null) {
            synchronized (this) {
                if (this.f4173d == null) {
                    this.f4173d = new tw(context.getApplicationContext(), new adf(), new adl());
                }
            }
        }
        return this.f4173d;
    }

    public tw m5300a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (afu.m5499b() && !(context instanceof Application)) {
            if (context instanceof ak) {
                return m5303a((ak) context);
            }
            if (context instanceof Activity) {
                return m5299a((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                return m5300a(((ContextWrapper) context).getBaseContext());
            }
        }
        return m5295b(context);
    }

    public tw m5303a(ak akVar) {
        if (afu.m5501c()) {
            return m5300a(akVar.getApplicationContext());
        }
        m5296b((Activity) akVar);
        return m5302a((Context) akVar, akVar.m709f());
    }

    @TargetApi(11)
    public tw m5299a(Activity activity) {
        if (afu.m5501c() || VERSION.SDK_INT < 11) {
            return m5300a(activity.getApplicationContext());
        }
        m5296b(activity);
        return m5301a((Context) activity, activity.getFragmentManager());
    }

    @TargetApi(17)
    private static void m5296b(Activity activity) {
        if (VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @TargetApi(17)
    adp m5297a(FragmentManager fragmentManager) {
        adp com_ushareit_listenit_adp = (adp) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (com_ushareit_listenit_adp != null) {
            return com_ushareit_listenit_adp;
        }
        com_ushareit_listenit_adp = (adp) this.f4171a.get(fragmentManager);
        if (com_ushareit_listenit_adp != null) {
            return com_ushareit_listenit_adp;
        }
        Fragment com_ushareit_listenit_adp2 = new adp();
        this.f4171a.put(fragmentManager, com_ushareit_listenit_adp2);
        fragmentManager.beginTransaction().add(com_ushareit_listenit_adp2, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.f4174e.obtainMessage(1, fragmentManager).sendToTarget();
        return com_ushareit_listenit_adp2;
    }

    @TargetApi(11)
    tw m5301a(Context context, FragmentManager fragmentManager) {
        adp a = m5297a(fragmentManager);
        tw b = a.m5292b();
        if (b != null) {
            return b;
        }
        b = new tw(context, a.m5290a(), a.m5293c());
        a.m5291a(b);
        return b;
    }

    adv m5298a(ar arVar) {
        adv com_ushareit_listenit_adv = (adv) arVar.mo796a("com.bumptech.glide.manager");
        if (com_ushareit_listenit_adv != null) {
            return com_ushareit_listenit_adv;
        }
        com_ushareit_listenit_adv = (adv) this.f4172b.get(arVar);
        if (com_ushareit_listenit_adv != null) {
            return com_ushareit_listenit_adv;
        }
        ah com_ushareit_listenit_adv2 = new adv();
        this.f4172b.put(arVar, com_ushareit_listenit_adv2);
        arVar.mo797a().mo3093a(com_ushareit_listenit_adv2, "com.bumptech.glide.manager").mo3098c();
        this.f4174e.obtainMessage(2, arVar).sendToTarget();
        return com_ushareit_listenit_adv2;
    }

    tw m5302a(Context context, ar arVar) {
        adv a = m5298a(arVar);
        tw b = a.m5315b();
        if (b != null) {
            return b;
        }
        b = new tw(context, a.m5312a(), a.m5316c());
        a.m5314a(b);
        return b;
    }

    public boolean handleMessage(Message message) {
        Object obj = null;
        boolean z = true;
        Object remove;
        switch (message.what) {
            case 1:
                FragmentManager fragmentManager = (FragmentManager) message.obj;
                remove = this.f4171a.remove(fragmentManager);
                break;
            case 2:
                ar arVar = (ar) message.obj;
                remove = this.f4172b.remove(arVar);
                break;
            default:
                z = false;
                remove = null;
                break;
        }
        if (z && r1 == null && Log.isLoggable("RMRetriever", 5)) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
        }
        return z;
    }
}
