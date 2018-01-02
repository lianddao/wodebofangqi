package com.ushareit.listenit;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.widget.ImageView;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class tt {
    private static volatile tt f16811a;
    private final yo f16812b;
    private final vr f16813c;
    private final ws f16814d;
    private final xw f16815e;
    private final ut f16816f;
    private final afd f16817g = new afd();
    private final adc f16818h = new adc();
    private final aec f16819i;
    private final aar f16820j;
    private final acx f16821k;
    private final aay f16822l;
    private final acx f16823m;
    private final Handler f16824n;
    private final yl f16825o;

    public static tt m26449a(Context context) {
        if (f16811a == null) {
            synchronized (tt.class) {
                if (f16811a == null) {
                    Context applicationContext = context.getApplicationContext();
                    List<ady> a = new adz(applicationContext).m5324a();
                    tu tuVar = new tu(applicationContext);
                    for (ady a2 : a) {
                        a2.mo2807a(applicationContext, tuVar);
                    }
                    f16811a = tuVar.m26469a();
                    for (ady a22 : a) {
                        a22.mo2806a(applicationContext, f16811a);
                    }
                }
            }
        }
        return f16811a;
    }

    tt(vr vrVar, xw xwVar, ws wsVar, Context context, ut utVar) {
        this.f16813c = vrVar;
        this.f16814d = wsVar;
        this.f16815e = xwVar;
        this.f16816f = utVar;
        this.f16812b = new yo(context);
        this.f16824n = new Handler(Looper.getMainLooper());
        this.f16825o = new yl(xwVar, wsVar, utVar);
        this.f16819i = new aec();
        aeb com_ushareit_listenit_abi = new abi(wsVar, utVar);
        this.f16819i.m5337a(InputStream.class, Bitmap.class, com_ushareit_listenit_abi);
        aeb com_ushareit_listenit_aaw = new aaw(wsVar, utVar);
        this.f16819i.m5337a(ParcelFileDescriptor.class, Bitmap.class, com_ushareit_listenit_aaw);
        aeb com_ushareit_listenit_abf = new abf(com_ushareit_listenit_abi, com_ushareit_listenit_aaw);
        this.f16819i.m5337a(yv.class, Bitmap.class, com_ushareit_listenit_abf);
        com_ushareit_listenit_abi = new abz(context, wsVar);
        this.f16819i.m5337a(InputStream.class, abx.class, com_ushareit_listenit_abi);
        this.f16819i.m5337a(yv.class, acq.class, new acy(com_ushareit_listenit_abf, com_ushareit_listenit_abi, wsVar));
        this.f16819i.m5337a(InputStream.class, File.class, new abt());
        m26460a(File.class, ParcelFileDescriptor.class, new zm());
        m26460a(File.class, InputStream.class, new zz());
        m26460a(Integer.TYPE, ParcelFileDescriptor.class, new zp());
        m26460a(Integer.TYPE, InputStream.class, new aac());
        m26460a(Integer.class, ParcelFileDescriptor.class, new zp());
        m26460a(Integer.class, InputStream.class, new aac());
        m26460a(String.class, ParcelFileDescriptor.class, new zr());
        m26460a(String.class, InputStream.class, new aae());
        m26460a(Uri.class, ParcelFileDescriptor.class, new zt());
        m26460a(Uri.class, InputStream.class, new aag());
        m26460a(URL.class, InputStream.class, new aai());
        m26460a(yq.class, InputStream.class, new zv());
        m26460a(byte[].class, InputStream.class, new zx());
        this.f16818h.m5263a(Bitmap.class, aaz.class, new ada(context.getResources(), wsVar));
        this.f16818h.m5263a(acq.class, abo.class, new acz(new ada(context.getResources(), wsVar)));
        this.f16820j = new aar(wsVar);
        this.f16821k = new acx(wsVar, this.f16820j);
        this.f16822l = new aay(wsVar);
        this.f16823m = new acx(wsVar, this.f16822l);
    }

    public ws m26458a() {
        return this.f16814d;
    }

    <Z, R> adb<Z, R> m26456a(Class<Z> cls, Class<R> cls2) {
        return this.f16818h.m5262a(cls, cls2);
    }

    <T, Z> aeb<T, Z> m26461b(Class<T> cls, Class<Z> cls2) {
        return this.f16819i.m5336a(cls, cls2);
    }

    <R> afi<R> m26457a(ImageView imageView, Class<R> cls) {
        return this.f16817g.m5451a(imageView, cls);
    }

    vr m26462b() {
        return this.f16813c;
    }

    aar m26463c() {
        return this.f16820j;
    }

    aay m26464d() {
        return this.f16822l;
    }

    acx m26465e() {
        return this.f16821k;
    }

    acx m26466f() {
        return this.f16823m;
    }

    ut m26467g() {
        return this.f16816f;
    }

    private yo m26455i() {
        return this.f16812b;
    }

    public void m26468h() {
        afu.m5497a();
        this.f16815e.m27215a();
        this.f16814d.mo3129a();
    }

    public void m26459a(int i) {
        afu.m5497a();
        this.f16815e.mo3142a(i);
        this.f16814d.mo3130a(i);
    }

    public static void m26452a(afi<?> com_ushareit_listenit_afi_) {
        afu.m5497a();
        aei c = com_ushareit_listenit_afi_.mo576c();
        if (c != null) {
            c.mo600d();
            com_ushareit_listenit_afi_.mo573a(null);
        }
    }

    public <T, Y> void m26460a(Class<T> cls, Class<Y> cls2, zf<T, Y> zfVar) {
        zf a = this.f16812b.m27250a((Class) cls, (Class) cls2, (zf) zfVar);
        if (a != null) {
            a.mo548a();
        }
    }

    public static <T, Y> ze<T, Y> m26451a(Class<T> cls, Class<Y> cls2, Context context) {
        if (cls != null) {
            return m26449a(context).m26455i().m27249a(cls, cls2);
        }
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Unable to load null model, setting placeholder only");
        }
        return null;
    }

    public static <T> ze<T, InputStream> m26450a(Class<T> cls, Context context) {
        return m26451a((Class) cls, InputStream.class, context);
    }

    public static <T> ze<T, ParcelFileDescriptor> m26454b(Class<T> cls, Context context) {
        return m26451a((Class) cls, ParcelFileDescriptor.class, context);
    }

    public static tw m26453b(Context context) {
        return ads.m5294a().m5300a(context);
    }
}
