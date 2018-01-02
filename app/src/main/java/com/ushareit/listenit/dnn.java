package com.ushareit.listenit;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import java.lang.ref.ReferenceQueue;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class dnn implements Callback {
    private static final Object f10028d = new Object();
    private static dnn f10029e;
    private long f10030a;
    private long f10031b;
    private long f10032c;
    private final Context f10033f;
    private final cdd f10034g;
    private int f10035h;
    private final AtomicInteger f10036i;
    private final SparseArray<dnq<?>> f10037j;
    private final Map<dlp<?>, dnq<?>> f10038k;
    private dmk f10039l;
    private final Set<dlp<?>> f10040m;
    private final Handler f10041n;
    private final ReferenceQueue<ceo<?>> f10042o;
    private final SparseArray<dno> f10043p;
    private dnp f10044q;

    private dnn(Context context) {
        this(context, cdd.m10887a());
    }

    private dnn(Context context, cdd com_ushareit_listenit_cdd) {
        this.f10030a = 5000;
        this.f10031b = 120000;
        this.f10032c = 10000;
        this.f10035h = -1;
        this.f10036i = new AtomicInteger(1);
        this.f10037j = new SparseArray();
        this.f10038k = new ConcurrentHashMap(5, 0.75f, 1);
        this.f10039l = null;
        this.f10040m = new cil();
        this.f10042o = new ReferenceQueue();
        this.f10043p = new SparseArray();
        this.f10033f = context;
        HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
        handlerThread.start();
        this.f10041n = new Handler(handlerThread.getLooper(), this);
        this.f10034g = com_ushareit_listenit_cdd;
    }

    private int m15065a(ceo<?> com_ushareit_listenit_ceo_) {
        int andIncrement = this.f10036i.getAndIncrement();
        this.f10041n.sendMessage(this.f10041n.obtainMessage(6, andIncrement, 0, com_ushareit_listenit_ceo_));
        return andIncrement;
    }

    public static Pair<dnn, Integer> m15068a(Context context, ceo<?> com_ushareit_listenit_ceo_) {
        Pair<dnn, Integer> create;
        synchronized (f10028d) {
            if (f10029e == null) {
                f10029e = new dnn(context.getApplicationContext());
            }
            create = Pair.create(f10029e, Integer.valueOf(f10029e.m15065a((ceo) com_ushareit_listenit_ceo_)));
        }
        return create;
    }

    public static dnn m15069a() {
        dnn com_ushareit_listenit_dnn;
        synchronized (f10028d) {
            com_ushareit_listenit_dnn = f10029e;
        }
        return com_ushareit_listenit_dnn;
    }

    private void m15070a(int i) {
        dnq com_ushareit_listenit_dnq = (dnq) this.f10037j.get(i);
        if (com_ushareit_listenit_dnq != null) {
            this.f10037j.delete(i);
            com_ushareit_listenit_dnq.m15127c(i);
            return;
        }
        Log.wtf("GoogleApiManager", "onCleanupLeakInternal received for unknown instance: " + i, new Exception());
    }

    private void m15071a(int i, doi<?> com_ushareit_listenit_doi_, dzp<Void> com_ushareit_listenit_dzp_java_lang_Void) {
        ((dnq) this.f10037j.get(i)).m15116a(i, (doi) com_ushareit_listenit_doi_, (dzp) com_ushareit_listenit_dzp_java_lang_Void);
    }

    private void m15072a(int i, dol com_ushareit_listenit_dol, dzp<Void> com_ushareit_listenit_dzp_java_lang_Void) {
        ((dnq) this.f10037j.get(i)).m15117a(i, com_ushareit_listenit_dol, (dzp) com_ushareit_listenit_dzp_java_lang_Void);
    }

    private void m15073a(ceo<?> com_ushareit_listenit_ceo_, int i) {
        dlp e = com_ushareit_listenit_ceo_.m10983e();
        if (!this.f10038k.containsKey(e)) {
            this.f10038k.put(e, new dnq(this, com_ushareit_listenit_ceo_));
        }
        dnq com_ushareit_listenit_dnq = (dnq) this.f10038k.get(e);
        com_ushareit_listenit_dnq.m15125b(i);
        this.f10037j.put(i, com_ushareit_listenit_dnq);
        com_ushareit_listenit_dnq.m15113j();
        this.f10043p.put(i, new dno(this, com_ushareit_listenit_ceo_, i, this.f10042o));
        if (this.f10044q == null || !this.f10044q.f10049c.get()) {
            this.f10044q = new dnp(this.f10042o, this.f10043p);
            this.f10044q.start();
        }
    }

    private void m15074a(dlj com_ushareit_listenit_dlj) {
        ((dnq) this.f10037j.get(com_ushareit_listenit_dlj.f9877a)).m15122a(com_ushareit_listenit_dlj);
    }

    private void m15076b(int i, boolean z) {
        dnq com_ushareit_listenit_dnq = (dnq) this.f10037j.get(i);
        if (com_ushareit_listenit_dnq != null) {
            if (!z) {
                this.f10037j.delete(i);
            }
            com_ushareit_listenit_dnq.m15118a(i, z);
            return;
        }
        Log.wtf("GoogleApiManager", "onRelease received for unknown instance: " + i, new Exception());
    }

    private void m15080d() {
        for (dnq com_ushareit_listenit_dnq : this.f10038k.values()) {
            com_ushareit_listenit_dnq.m15124b();
            com_ushareit_listenit_dnq.m15113j();
        }
    }

    public void m15088a(int i, boolean z) {
        this.f10041n.sendMessage(this.f10041n.obtainMessage(8, i, z ? 1 : 2));
    }

    public <O extends cdk> void m15089a(ceo<O> com_ushareit_listenit_ceo_O, int i, dlu<? extends ceg, cdq> com_ushareit_listenit_dlu__extends_com_ushareit_listenit_ceg__com_ushareit_listenit_cdq) {
        this.f10041n.sendMessage(this.f10041n.obtainMessage(4, new dll(com_ushareit_listenit_ceo_O.m10984f(), i, com_ushareit_listenit_dlu__extends_com_ushareit_listenit_ceg__com_ushareit_listenit_cdq)));
    }

    public <O extends cdk, TResult> void m15090a(ceo<O> com_ushareit_listenit_ceo_O, int i, dos<cdq, TResult> com_ushareit_listenit_dos_com_ushareit_listenit_cdq__TResult, dzp<TResult> com_ushareit_listenit_dzp_TResult) {
        this.f10041n.sendMessage(this.f10041n.obtainMessage(4, new dln(com_ushareit_listenit_ceo_O.m10984f(), i, com_ushareit_listenit_dos_com_ushareit_listenit_cdq__TResult, com_ushareit_listenit_dzp_TResult)));
    }

    public void m15091a(dls com_ushareit_listenit_dls) {
        for (dlp com_ushareit_listenit_dlp : com_ushareit_listenit_dls.mo1275b()) {
            dnq com_ushareit_listenit_dnq = (dnq) this.f10038k.get(com_ushareit_listenit_dlp);
            if (com_ushareit_listenit_dnq == null) {
                com_ushareit_listenit_dls.m10796e();
                return;
            } else if (com_ushareit_listenit_dnq.m15128d()) {
                com_ushareit_listenit_dls.m14815a(com_ushareit_listenit_dlp, ConnectionResult.f1674a);
            } else if (com_ushareit_listenit_dnq.m15126c() != null) {
                com_ushareit_listenit_dls.m14815a(com_ushareit_listenit_dlp, com_ushareit_listenit_dnq.m15126c());
            } else {
                com_ushareit_listenit_dnq.m15123a(com_ushareit_listenit_dls);
            }
        }
    }

    public void m15092a(dmk com_ushareit_listenit_dmk) {
        synchronized (f10028d) {
            if (com_ushareit_listenit_dmk == null) {
                this.f10039l = null;
                this.f10040m.clear();
            }
        }
    }

    boolean m15093a(ConnectionResult connectionResult, int i) {
        if (!connectionResult.m2234a() && !this.f10034g.mo1291a(connectionResult.m2236c())) {
            return false;
        }
        this.f10034g.m10898a(this.f10033f, connectionResult, i);
        return true;
    }

    public void m15094b() {
        this.f10041n.sendMessage(this.f10041n.obtainMessage(3));
    }

    public void m15095b(ConnectionResult connectionResult, int i) {
        if (!m15093a(connectionResult, i)) {
            this.f10041n.sendMessage(this.f10041n.obtainMessage(5, i, 0));
        }
    }

    public boolean handleMessage(Message message) {
        boolean z = false;
        Pair pair;
        switch (message.what) {
            case 1:
                m15091a((dls) message.obj);
                break;
            case 2:
                m15070a(message.arg1);
                break;
            case 3:
                m15080d();
                break;
            case 4:
                m15074a((dlj) message.obj);
                break;
            case 5:
                if (this.f10037j.get(message.arg1) != null) {
                    ((dnq) this.f10037j.get(message.arg1)).m15099a(new Status(17, "Error resolution was canceled by the user."));
                    break;
                }
                break;
            case 6:
                m15073a((ceo) message.obj, message.arg1);
                break;
            case 7:
                pair = (Pair) message.obj;
                m15072a(message.arg1, (dol) pair.first, (dzp) pair.second);
                break;
            case 8:
                int i = message.arg1;
                if (message.arg2 == 1) {
                    z = true;
                }
                m15076b(i, z);
                break;
            case 9:
                if (this.f10038k.containsKey(message.obj)) {
                    ((dnq) this.f10038k.get(message.obj)).m15108e();
                    break;
                }
                break;
            case 10:
                if (this.f10038k.containsKey(message.obj)) {
                    ((dnq) this.f10038k.get(message.obj)).m15110g();
                    break;
                }
                break;
            case 11:
                if (this.f10038k.containsKey(message.obj)) {
                    ((dnq) this.f10038k.get(message.obj)).m15112i();
                    break;
                }
                break;
            case 12:
                pair = (Pair) message.obj;
                m15071a(message.arg1, (doi) pair.first, (dzp) pair.second);
                break;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + message.what);
                return false;
        }
        return true;
    }
}
